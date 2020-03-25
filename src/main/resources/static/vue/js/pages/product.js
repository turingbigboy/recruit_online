Vue.component('paginate', VuejsPaginate);
var padDate = function (value) {
    return value < 10 ? '0' + value : value
}
var vue = new Vue({
	data:{
		
		Url:"/repast/product",
		
		entity:{
			
		},
		file:{},
		classify:[],
		oneClass:[],
		twoClass:[],
		classifyEntity:{},	
		proId:""
	},
	methods:{
		removeClassify:function(id){
			var self = this;
			axios.delete("/repast/product-lable/"+id).then(function(res){
				alert(res.data.msg);				
				self.classifyQuery(self.proId);
			}).catch(function(err){
				alert(err);
			})
		},
		addClass:function(){
			var self=this;
			var proId =this.classifyEntity.proId;
			axios.post("/repast/product-lable",this.classifyEntity).then(function(res){
				
				alert(res.data.msg);				
				self.classifyQuery(proId);
				self.classifyEntity={};
			}).catch(function(err){
				alert(err);
			})
		},
		classifyQuery:function(id){
			this.classifyEntity.proId=id;
			this.proId = id;
			var self=this;
			axios.get(this.Url+"/classify/"+id
			).then(function(res){									
				self.classify = res.data.data;
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
	    initAdd:function(){
	    	this.entity.id=null;
	    },
	    initClassAdd:function(){
	    	var self=this;
			axios.get("/repast/product-classify"
			).then(function(res){									
				self.oneClass = res.data.data.records;
			}).catch(function(err){
				alert(err);
			})
	    },
	    findTwoClass:function(){
	    	var self=this;
			axios.get("/repast/product-sort/classify/"+self.classifyEntity.lableClassId
			).then(function(res){									
				self.twoClass = res.data.data;
			}).catch(function(err){
				alert(err);
			})
	    },
	    saveAdv:function(){
	    	
	    },
	    getfile:function(){
	    	this.file = event.target.files;
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
		stateFormat:function(state){
			if(state == 1 ){
				return "上架";
			}else if (state == 2){
				return "下架";
			}
		},		
		disable:function(id){
			var self=this;
			axios.put(this.Url+"/disable/"+id).then(function(res){
				alert(res.data.msg);				
				self.query();
			}).catch(function(err){
				alert(err);
			})
		},
		modify:function(){
			var self = this;
			let formData = new FormData();
	    	
	    	if(this.file[0]!=null){
	    		formData.append("file",this.file[0]);
	    	}
	    	if(this.entity.id == null){
	    		formData.append("name",this.entity.name);
		    	formData.append("title",this.entity.title);
		    	formData.append("content",this.entity.content);
		    	formData.append("price",this.entity.price);
		    	axios.post(this.Url,formData,{
		    		headers:{
		    			'Content-Type':'multipart/form-data'
		    		}	    		
		    	}).then(function(res){
					alert(res.data.msg);
					self.query();
				}).catch(function(err){
					alert(err);
				})
	    	}else{
	    		formData.append("id",this.entity.id);
		    	formData.append("name",this.entity.name);
		    	formData.append("title",this.entity.title);
		    	formData.append("content",this.entity.content);
		    	formData.append("price",this.entity.price);
		    	axios.put(this.Url,formData,{
		    		headers:{
		    			'Content-Type':'multipart/form-data'
		    		}	    		
		    	}).then(function(res){
					alert(res.data.msg);
					self.query();
				}).catch(function(err){
					alert(err);
				})
	    	}
		},
		clear:function(){
			this.entity={};
			this.detail={};
			this.classify=[];
			this.classifyEntity={};
			this.proId=""
		}
	},
	mixins:[entityMixin]
	,
	created:function(){	
		this.query();
	}	
})