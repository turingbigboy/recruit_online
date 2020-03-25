Vue.component('paginate', VuejsPaginate);
var padDate = function (value) {
    return value < 10 ? '0' + value : value
}
var vue = new Vue({
	data:{
		
		Url:"/repast/product-lable",
		
		entity:{
			
		},
		classifys:[],
		sorts:[],
		lableSortId:"1",
		shoping:{
			products:[]
		}
	},
	methods:{
		addShopping:function(id){
			var self=this;
			axios.post("/repast/product/shoping/"+id).then(function(res){
				alert(res.data.msg);
			}).catch(function(err){
				alert(err);
			})
		},
		goShop:function(){
			var self=this;
			axios.get("/repast/user/check_identity"
			).then(function(res){					
				var result = res.data.data;	
				if(result == true){
					location.href="/repast/index.html";
				}else{
					alert("抱歉！您不是商家");
				}
			}).catch(function(err){
				alert(err);
			})
		},
		checkShoping:function(){
			var self=this;
			axios.get("/repast/product/myShoping"
			).then(function(res){					
				self.shoping = res.data.data;	
				console.log(self.shoping);
			}).catch(function(err){
				alert(err);
			})
		},
		removeShoping:function(id){
			var self=this;
			axios.post("/repast/product/shoping/"+id+"/remove").then(function(res){
				self.checkShoping();
				alert(res.data.msg);
			}).catch(function(err){
				alert(err);
			})
		},
		submitOrder:function(){
			var self=this;
			axios.post("/repast/Order").then(function(res){
				self.checkShoping();
				alert(res.data.msg);			
				location.href="/repast/index.html";
			}).catch(function(err){
				alert(err);
			})
		},
		findSort:function(id){
			var self=this;
			axios.get("/repast/product-sort/classify/"+id
			).then(function(res){					
				console.log(res)
				self.sorts=res.data.data;				
			}).catch(function(err){
				alert(err);
			})
		},
		queryClass:function(){
			var self=this;
			axios.get("/repast/product-classify/all"
			).then(function(res){					
				console.log(res)
				self.classifys=res.data.data;				
			}).catch(function(err){
				alert(err);
			})
		},
		findPro:function(id){
			this.lableSortId = id;
			this.queryPro();
		},
		queryPro:function(){
			var self=this;
			axios.get("/repast/product-lable?lableSortId="+this.lableSortId
			).then(function(res){					
				console.log(res)
				self.SearchResult.rows=res.data.data;				
			}).catch(function(err){
				alert(err);
			})
		},
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
			this.order.giftAddress={};
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
				self.order.giftAddress={};
				self.query();
			}).catch(function(err){
				alert(err);
			})
		},
		calculateTotal:function(order){
			
			var detail = this.order.orderDetails;
			var sum=0;
			for (var i = 0; i < detail.length; i++) {
				sum+=detail[i].number*detail[i].productCharacterVO.price
			}
			return sum;
		}
	},
	mixins:[entityMixin]
	,
	created:function(){	
		this.queryClass();
		this.queryPro();
	}	
})