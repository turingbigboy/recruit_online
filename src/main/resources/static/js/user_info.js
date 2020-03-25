var vue=new Vue({
	data:{
		//预约接口
		Url:"/recruit-online/user",
		entity:{
			
		},
		user:{},
		userDetail:{
			markPositions:[],
			dropBoxs:[]
		},
		type:null,
		types:null,
		navText:""
	},
	methods:{
		queryUser:function(){
			this.userDetail = {};
			this.userDetail.markPositions =[];
			this.userDetail.dropBoxs =[];
				  var self=this;
				axios.get("/recruit-online/user/present"
				).then(function(res){
					console.log(res);
					self.user = res.data.data;
					if(self.user!=null){
					self.types = "user";
					self.type="person";
					}
					if(self.user == null || self.user.userId==null){
						alert("请前往登录")
						location.href="/recruit-online/dist/user/user_login.html";
					}else{
						self.queryByUserId();
						}
					
				}).catch(function(err){
					alert(err);
			}) 
		},
		stateFormat:function(state){
			if(state==0){
				return "hr未查看";
			}else if(state==1){
				return "hr已查看";
			}
		},
		unmarks:function(positionId){
			var self = this;
			axios.delete("/recruit-online/usermake/unmake?userId="+this.userDetail.userId
					+"&positionId="+positionId
					).then(function(res){						
						self.queryUser();
			}).catch(function(err){
				alert(err);
			})
		},
		getPositionById:function(id){
				location.href="/recruit-online/dist/user/position_detail.html?id="+id;
		},
		changeType:function(typeName){
			this.type = typeName;
		},
		queryByUserId:function(){
			  var self=this;
				axios.get("/recruit-online/user/"+self.user.userId
				).then(function(res){
					console.log(res);
					self.navText="个人资料";
					self.userDetail = res.data.data;					
				}).catch(function(err){
					alert(err);
			}) 	
		},
		updateResume:function(){
			axios.put("/recruit-online/resume",
					this.userDetail.resume).then(function(res){					
				alert(res.data.msg);
				console.log(res);
			}).catch(function(err){
				alert(err);
			})
		},
		updateUserInfo:function(){
			axios.put("/recruit-online/user",
					this.userDetail).then(function(res){					
				alert(res.data.msg);
				console.log(res);
			}).catch(function(err){
				alert(err);
			})
		}
	},
	mixins:[entityMixin]
	,
	created:function(){	
		this.queryUser();
	}	
})