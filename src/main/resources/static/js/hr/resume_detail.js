var vue=new Vue({
	data:{
		//预约接口
		Url:"/recruit-online/resume",
		entity:{
			
		},
		 resume:{
			
		},
		category:[],
		company:{},
		department:{},
		reviews:[],     
        hr: {
        },
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
			if(this.hr == null || this.hr.id==null){
				alert("请前往登录")
				location.href="/recruit-online/dist/hr/hr_login.html";
			}
			this.mark.hrId=this.hr.id;
			this.mark.resumeId = this.resume.id;
			var self =this;
			axios.post("/recruit-online/hrmake",
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
			if(this.hr == null || this.hr.id==null){
				alert("请前往登录")
				location.href="/recruit-online/dist/hr/hr_login.html";
			}
			var self = this;
			this.mark.id=this.hr.id;
			this.mark.resumeId = this.resume.id;
			axios.delete("/recruit-online/hrmake/unmake?hrId="+this.hr.id
					+"&resumeId="+this.resume.id
					).then(function(res){						
						alert(res.data.msg);
						if(res.data.code ==0 ){
							self.isMark=0;
						}
						console.log(res);
			}).catch(function(err){
				alert(err);
			})
		},
		seartchMarks:function(){
			var self = this;
			axios.get("/recruit-online/hrmake/is_mark/"+this.resume.id
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
			if(this.hr == null || this.hr.id==null){
				alert("请前往登录")
				location.href="/recruit-online/dist/hr/hr_login.html";
			}
			this.drop.id=this.hr.id;
			this.drop.resumeId = this.resume.id;
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
			self.addComment.id=this.hr.id;
			self.addComment.resumeId = this.resume.id;
			self.addComment.content = $("#review_editor").val(); 
			self.addComment.type = $("#comment_star").val();
			console.log(this.addComment);
			axios.post("/recruit-online/comment",this.addComment).then(function(res){					
				console.log(res);
				axios.get("/recruit-online/resume/"+self.resume.id
				).then(function(res){
					console.log(res);
					self.resume = res.data.data;
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
			axios.get("/recruit-online/hr/present"
			).then(function(res){
				console.log(res);
				self.hr = res.data.data;
				if(self.hr!=null){
				self.type = "hr";
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
					axios.get("/recruit-online/resume/"+param
					).then(function(res){
						console.log(res);
						self.resume = res.data.data;
						self.category =  res.data.data.sorts;
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