Vue.component('paginate', VuejsPaginate);
var padDate = function (value) {
    return value < 10 ? '0' + value : value
}
var vue = new Vue({
	data:{
		
		Url:"/repast/Advertisement",
		
		entity:{
			
		},
		file:{}
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
	    	this.entity.advId=null;
	    },
	    locationFormat:function(location){
	    	if(location ==1){
	    		return "首页跑马灯";
	    	}else if(location ==2){
	    		return "左侧广告";
	    	}else if(location ==3){
	    		return "右侧广告";
	    	}
	    },
	    saveAdv:function(){
	    	
	    },
	    getfile:function(){
	    	this.file = event.target.files;
	    },
		modify:function(){
			var self = this;
			let formData = new FormData();
	    	
	    	if(this.file[0]!=null){
	    		formData.append("file",this.file[0]);
	    	}
	    	if(this.entity.advId == null){
	    		formData.append("advLocation",this.entity.advLocation);
		    	formData.append("advHref",this.entity.advHref);
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
		    	formData.append("advId",this.entity.advId);
		    	formData.append("advLocation",this.entity.advLocation);
		    	formData.append("advHref",this.entity.advHref);
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
		}
	},
	mixins:[entityMixin]
	,
	created:function(){	
		this.query();
	}	
})