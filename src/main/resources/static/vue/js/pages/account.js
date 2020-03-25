Vue.component('paginate', VuejsPaginate);
var padDate = function (value) {
    return value < 10 ? '0' + value : value
}
var vue = new Vue({
	data:{
		
		Url:"/repast/user",
		
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
	  //添加或者删除 由ID决定
		add:function(){
			var self=this;
			//alert(this.entity.id);
			//判断ID
			if(this.entity.id==null){
				this.save();//添加
				self.query();
				return;
			}
			//修改
			axios.put(this.Url,this.entity).then(function(res){
				alert(res.data.msg);
				self.entity={};
				self.query();
			}).catch(function(err){
				alert(err);
			})
		},
		stateFormat:function(state){
			if(state == 1 ){
				return "启用";
			}else if (state == 2){
				return "停用";
			}
		},
		enable:function(id){
			var self=this;
			axios.put(this.Url+"/enable/"+id).then(function(res){
				alert(res.data.msg);				
				self.query();
			}).catch(function(err){
				alert(err);
			})
		},
		disable:function(id){
			var self=this;
			axios.put(this.Url+"/disable/"+id).then(function(res){
				alert(res.data.msg);				
				self.query();
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