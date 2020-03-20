
var vue=new Vue({
	data:{
		Url:"/recruit-online/user",
		entity:{
		  
		}
	},
	methods:{
		register:function(){
			var reg = /^\d{11}$/;     //工作密码必须是8位数字						
			
			if(!reg.test(this.entity.account)) {
			    alert("手机号必须为11位数字！");
			    return ;
			}
			
			if(this.entity.password == null){
				alert("密码不能为空");
				return ;
			}
			if(this.entity.name == null){
				alert("名称不能为空");
				return ;
			}	
			var self = this;
			
			axios.post(this.Url+"/register",this.entity).then(function(res){					
				alert(res.data.msg);
				console.log(res);
				this.user =  res.data.data;
				location.href="/recruit-online/dist/user/user_login.html";
			}).catch(function(err){
				alert(err);
			})
		},
		login:function(){
			var self = this;
			axios.post(this.Url+"/login",this.entity).then(function(res){		
				
				alert(res.data.msg);
				if(res.data.code == 0){
					location.href="index.html";
				}
				this.user = res.data.data;
				
			}).catch(function(err){
				alert(err);
			})
		}
	},
	mixins:[entityMixin]
	,
	created:function(){	
		
	}	
})