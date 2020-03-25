Vue.component('paginate', VuejsPaginate);
var padDate = function (value) {
    return value < 10 ? '0' + value : value
}
var vue = new Vue({
	data:{
		
		Url:"/repast/shop",
		
		entity:{
			
		}
		
	},
	methods:{
		DateFormat: function (value) {
	     	// 根据给定的字符串，得到特定的日期
	        var date = new Date(value);
	        var year = date.getFullYear();
	        var month = padDate(date.getMonth() + 1);
	       	var day = padDate(date.getDate());
	       	var hour = padDate(date.getHours()+(date.getTimezoneOffset() / 60));
	        var min = padDate(date.getMinutes());
	        var sec = padDate(date.getSeconds());
	       	return  `${year}-${month}-${day} ${hour}:${min}:${sec}`;
	    },
	  
		modify:function(){
			//修改
			var self=this;
			axios.put(this.Url,this.entity).then(function(res){
				alert(res.data.msg);				
				self.findShop();
			}).catch(function(err){
				alert(err);
			})
		},
		findShop:function(){
			var self=this;
			axios.get(this.Url+"/user").then(function(res){
				self.entity=res.data.data;				
			}).catch(function(err){
				alert(err);
			})
		}
	},
	mixins:[entityMixin]
	,
	created:function(){	
		this.findShop();
	}	
})