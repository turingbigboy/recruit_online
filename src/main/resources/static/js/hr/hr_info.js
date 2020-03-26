var vue=new Vue({
	data:{
		//预约接口
		Url:"/recruit-online/hr",
		entity:{
			
		},
		hr:{},
		hrDetail:{
			markPositions:[],
			dropBoxs:[]
		},
		type:null,
		types:null,
		navText:""
	},
	methods:{
		queryUser:function(){
			this.hrDetail = {};
			this.hrDetail.markPositions =[];
			this.hrDetail.dropBoxs =[];
				  var self=this;
				axios.get("/recruit-online/hr/present"
				).then(function(res){
					console.log(res);
					self.hr = res.data.data;
					if(self.hr!=null){
					self.types = "hr";
					self.type="person";
					}
					if(self.hr == null || self.hr.id==null){
						alert("请前往登录")
						location.href="/recruit-online/dist/hr/hr_login.html";
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
			axios.delete("/recruit-online/hrmake/unmake?hrId="+this.hrDetail.hrId
					+"&positionId="+positionId
					).then(function(res){						
						self.queryUser();
			}).catch(function(err){
				alert(err);
			})
		},
		getPositionById:function(id){
				location.href="/recruit-online/dist/hr/position_detail.html?id="+id;
		},
		changeType:function(typeName){
			this.type = typeName;
		},
		queryByUserId:function(){
			  var self=this;
				axios.get("/recruit-online/hr/"+self.hr.id
				).then(function(res){
					console.log(res);
					self.navText="个人资料";
					self.hrDetail = res.data.data;					
				}).catch(function(err){
					alert(err);
			}) 	
		},
		updateResume:function(){
			axios.put("/recruit-online/resume",
					this.hrDetail.resume).then(function(res){					
				alert(res.data.msg);
				console.log(res);
			}).catch(function(err){
				alert(err);
			})
		},
		updateUserInfo:function(){
			axios.put("/recruit-online/hr",
					this.hrDetail).then(function(res){					
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