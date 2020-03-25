Vue.component('paginate', VuejsPaginate);
var padDate = function (value) {
    return value < 10 ? '0' + value : value
}
var vue = new Vue({
	data:{
		
		Url:"/recruit-online/classify",
		
		entity:{
			
		},
		sorts:[],
		sort:{
			
		},
		classId:{}
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
	    initAdd:function(){
	    	
	    	this.entity.id = null;
	    	this.entity.name="";
	    },
	    initSort:function(){
	    	this.sort.id=null;
	    	this.sort.name = ""	,
	    	this.sort.classId=""
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
		findSubLabel:function(id){
			this.classId = id;
			var self = this;
			axios.get("/recruit-online/sort/classify/"+id).then(function(res){
				console.log(res);
				self.sorts=res.data.data;				
			}).catch(function(err){
				alert(err);
			})
		},
		findSortById:function(id){
			var self = this;
			axios.get("/recruit-online/sort/"+id).then(function(res){				
				self.sort=res.data.data;				
			}).catch(function(err){
				alert(err);
			})
		},
		clearSort:function(){
			this.sort={};
		},
		addSort:function(){
			var self=this;
			//alert(this.entity.id);
			//判断ID
			if(this.sort.id==null){
				this.saveSort();//添加
				self.query();
				return;
			}
			//修改
			axios.put("/recruit-online/sort",this.sort).then(function(res){
				alert(res.data.msg);
				self.sort={};
				self.findSubLabel(self.classId);
			}).catch(function(err){
				alert(err);
			})
		},
		saveSort:function(){
			this.sort.classId=this.classId;
			//console.log(this.sort);
			var self=this;
			axios.post("/recruit-online/sort/",this.sort).then(function(res){
				alert(res.data.msg);
				self.sort={};
				self.findSubLabel(self.classId);
			}).catch(function(err){
				alert(err);
			})
		},
		removeSortById:function(id){
			var self=this;
			axios.delete("/recruit-online/sort/"+id).then(function(res){
				alert(res.data.msg);			
				self.findSubLabel(self.classId);
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