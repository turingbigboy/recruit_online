
var vue=new Vue({
	data:{
		Url:"user",
		entity:{
		  user:{}
		}
	},
	methods:{
		register:function(){
			var self = this;
			console.log(this.SearchParam.param)
			axios.post(this.Url+"/register",this.SearchParam.param).then(function(res){					
				alert(res);
				console.log(res);
				this.user =  res.data.data;
				
			}).catch(function(err){
				alert(err);
			})
		},
		login:function(){
			var self = this;
			axios.post(this.Url+"/login",this.entity.user).then(function(res){						
				alert(res.data.msg);
				if(res.data.code == 0){
					location.href="admin/order/place_order.html";
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