var padDate = function (value) {
    return value < 10 ? '0' + value : value
}
var vue=new Vue({
	data:{
		Url:"/repast/Order/statistics",
		entity:{
		  
		}
	},
	methods:{
		query:function(){
			var self=this;
			axios.get(this.Url).then(function(res){
				self.entity=res.data.data;				
			}).catch(function(err){
				alert(err);
			})
		}
	},
	mixins:[entityMixin]
	,
	created:function(){	
		this.query();
	}	
})