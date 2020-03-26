var vue=new Vue({
	data:{
		//预约接口
		Url:"/recruit-online/position",
		entity:{
			
		},
		 position:{
			
		},
		category:[],
		company:{},
		department:{},
		reviews:[],     
        user: {},
        type:null,
        addComment:{
        	content:"",
        	type:""
        },
        drop:{},
        mark:{},
        isMark:""
	},
	methods:{
		marks:function(){
			if(this.user == null || this.user.userId==null){
				alert("请前往登录")
				location.href="/recruit-online/dist/user/user_login.html";
			}
			this.mark.userId=this.user.userId;
			this.mark.positionId = this.position.id;
			var self = this;
			axios.post("/recruit-online/usermake",
					this.mark).then(function(res){					
				alert(res.data.msg);
				if(res.data.code ==0 ){
					self.isMark=1;
				}
				console.log(res);
			}).catch(function(err){
				alert(err);
			})
		},
		unmarks:function(){
			if(this.user == null || this.user.userId==null){
				alert("请前往登录")
				location.href="/recruit-online/dist/user/user_login.html";
			}
			var self = this;
			this.mark.userId=this.user.userId;
			this.mark.positionId = this.position.id;
			axios.delete("/recruit-online/usermake/unmake?userId="+this.user.userId
					+"&positionId="+this.position.id
					).then(function(res){						
						axios.get("/recruit-online/position/"+self.position.id
						).then(function(res){
							console.log(res);
							self.position = res.data.data;
							self.category =  res.data.data.sorts;
							self.company = res.data.data.company;
							self.department = res.data.data.hr;										
							self.reviews = res.data.data.reviews;
							self.seartchMarks();
						}).catch(function(err){
							alert(err);
					});
			}).catch(function(err){
				alert(err);
			})
		},
		seartchMarks:function(){
			var self = this;
			axios.get("/recruit-online/usermake/is_mark/"+this.position.id
			).then(function(res){
				console.log(res);
				//alert(res.data.data);
				 if(res.data.data){
					 self.isMark=1
				}else{
					 self.isMark=0
				}
			}).catch(function(err){
				alert(err);
			}) 
		},
		dropBox:function(){
			if(this.user == null || this.user.userId==null){
				alert("请前往登录")
				location.href="/recruit-online/dist/user/user_login.html";
			}
			this.drop.userId=this.user.userId;
			this.drop.positionId = this.position.id;
			axios.post("/recruit-online/dropbox",
					this.drop).then(function(res){					
				alert(res.data.msg);
				console.log(res);
			}).catch(function(err){
				alert(err);
			})
		},
		addComments:function(){
			var self=this;
			self.addComment.userId=this.user.userId;
			self.addComment.positionId = this.position.id;
			self.addComment.content = $("#review_editor").val(); 
			self.addComment.type = $("#comment_star").val();
			console.log(this.addComment);
			axios.post("/recruit-online/comment",this.addComment).then(function(res){					
				console.log(res);
				axios.get("/recruit-online/position/"+self.position.id
				).then(function(res){
					console.log(res);
					self.position = res.data.data;
					self.category =  res.data.data.sorts;
					self.company = res.data.data.company;
					self.department = res.data.data.hr;										
					self.reviews = res.data.data.reviews;
					self.seartchMarks();
				}).catch(function(err){
					alert(err);
			}) 
			}).catch(function(err){
				alert(err);
			})
		},
		present:function(){
			  var self=this;
			axios.get("/recruit-online/user/present"
			).then(function(res){
				console.log(res);
				self.user = res.data.data;
				if(self.user!=null){
				self.type = "user";
				}
			}).catch(function(err){
				alert(err);
		}) 
		},
		queryById:function(){  
				var url = location.search; //获取url中"?"符后的字串 ('?modFlag=business&role=1')  
				var theRequest = new Object();  
				if ( url.indexOf( "?" ) != -1 ) {  
				  var str = url.substr( 1 ); //substr()方法返回从参数值开始到结束的字符串；  
				  var strs = str.split( "&" );  
				  var param = strs[ 0 ].split( "=" )[ 1 ]
				  var self=this;
					axios.get("/recruit-online/position/"+param
					).then(function(res){
						console.log(res);
						self.position = res.data.data;
						self.category =  res.data.data.sorts;
						self.company = res.data.data.company;
						self.department = res.data.data.hr;						
						self.reviews = res.data.data.reviews;
						self.seartchMarks();
					}).catch(function(err){
						alert(err);
				}) 
			}
		}
	
	},
	mixins:[entityMixin]
	,
	created:function(){	
		this.queryById();
		this.present();
		
	}	
})