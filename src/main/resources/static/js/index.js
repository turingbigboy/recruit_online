var vue=new Vue({
	data:{
		//预约接口
		Url:"/recruit-online/user",
		entity:{
			
		},
		classify:[],
		hotPostionQuery:[]
	},
	methods:{				
		classQuery:function(){
			var self=this;
			axios.get("/recruit-online/classify/all"
			).then(function(res){			
	            console.log(res); 
	            self.classify = res.data.data;
			}).catch(function(err){
				alert(err);
			})
		},
		releaseDateFormat:function(date){
			date = new date(date);
			colsole.log(date);
			return "1";
		},
		//热门职位推荐
		hotPositionQuery:function(){
			var self=this;
			axios.get("/recruit-online/position?orders=hits&asc=false",{
        		params:self.SearchParam
			}
			).then(function(res){
				console.log(res);
				self.hotPostionQuery = res.data.data;   
			}).catch(function(err){
				alert(err);
			})
		}
	},
	mixins:[entityMixin]
	,
	created:function(){	
		this.classQuery();
		this.hotPositionQuery();
	}	
})