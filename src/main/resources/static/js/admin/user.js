Vue.component('paginate', VuejsPaginate);
var padDate = function (value) {
    return value < 10 ? '0' + value : value
}
var vue = new Vue({
	data:{
		
		Url:"/recruit-online/user",
		
		entity:{
			
		}
	},
	methods:{
	    initAdd:function(){	    	
	    	this.entity.id = null;
	    	this.entity.name="";
	    },
	    stateFormat:function(state){
	    	if(state == 0){
	    		return "封停";
	    	}else if(state ==1){
	    		return  "正常";
	    	}
	    },
	    disable:function(id){
	    	var self=this;
	    	axios.put(this.Url+"/"+id+"/disable").then(function(res){
				alert(res.data.msg);
				self.query();
			}).catch(function(err){
				alert(err);
			})
	    },
	    enable:function(id){
	    	var self=this;
	    	axios.put(this.Url+"/"+id+"/enable").then(function(res){
				alert(res.data.msg);
				self.query();
			}).catch(function(err){
				alert(err);
			})
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
		}
	},
	mixins:[entityMixin]
	,
	created:function(){	
		this.query();
	}	
})