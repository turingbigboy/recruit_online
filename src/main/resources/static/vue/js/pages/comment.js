Vue.component('paginate', VuejsPaginate);
var padDate = function (value) {
    return value < 10 ? '0' + value : value
}
var vue = new Vue({
	data:{
		
		Url:"/repast/Comment",
		
		entity:{
			
		},
		
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
				self.query();
			}).catch(function(err){
				alert(err);
			})
		},
		statusFormat:function(status){
			if(status == 1 ){
				return "好评";
			}else if(status ==2 ){
				return "差评";
			}
		},
		modify:function(){
			var self=this;
			axios.put(this.Url,this.entity).then(function(res){
				alert(res.data.msg);
				self.entity={};
				self.query();
			}).catch(function(err){
				alert(err);
			})
		},
		replyFormat:function(status){
			if(status ==1 ){
				return "已回复";
			}else if(status ==0 ){
				return "未回复";
			}
			
		}
	},
	mixins:[entityMixin]
	,
	created:function(){	
		this.query();
	}	
})