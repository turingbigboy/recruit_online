Vue.component('paginate', VuejsPaginate);
var padDate = function (value) {
    return value < 10 ? '0' + value : value
}
var vue = new Vue({
	data:{
		
		Url:"/repast/Order",
		
		entity:{
			
		},
		order:{
			user:{},
			orderDetails:[]
			
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
		checkOrder:function(id){
			var self=this;
			this.order.orderDetails=[];
			this.order.user={};
			axios.get(this.Url+"/"+id).then(function(res){
				
				self.order=res.data.data;
				console.log(self.order);
			}).catch(function(err){
				alert(err);
			})
		},
		modify:function(){
			//修改
			var self=this;
			axios.put(this.Url,this.order).then(function(res){
				alert(res.data.msg);
				self.order={};
				self.order.orderDetails=[];
				self.order.user={};
				self.query();
			}).catch(function(err){
				alert(err);
			})
		},
		calculateTotal:function(order){
			
			var detail = this.order.orderDetails;
			var sum=0;
			for (var i = 0; i < detail.length; i++) {
				sum+=detail[i].number*detail[i].productVO.price
			}
			return sum;
		}
	},
	mixins:[entityMixin]
	,
	created:function(){	
		this.query();
	}	
})