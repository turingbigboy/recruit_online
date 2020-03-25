var vue=new Vue({
	data:{
		//预约接口
		Url:"/recruit-online/hr",
		entity:{
			
		},
		classify:[],
		hotResumeQuery:[],
		key:"",
		hr: {},
        type:null
	},
	methods:{		
		present:function(){
			var self=this;
			axios.get("/recruit-online/hr/present"
			).then(function(res){
				console.log(res);
				self.hr = res.data.data;
				if(self.hr!=null){
				self.type = "hr";
				}
			}).catch(function(err){
				alert(err);
		}) 
		},		
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
		hotResumeQuerys:function(){
			//热门简历推荐			
			var self=this;
			axios.get("/recruit-online/resume?orders=hits&asc=false",{
        		params:self.SearchParam
			}
			).then(function(res){
				console.log(res);
				self.hotResumeQuery = res.data.data;   
			}).catch(function(err){
				alert(err);
			})
		},
		getResumeById:function(id){
//			var self=this;
//			axios.get("/recruit-online/position/"+id
//			).then(function(res){
//				console.log(res);
				location.href="/recruit-online/dist/hr/resume_detail.html?id="+id;
//			}).catch(function(err){
//				alert(err);
//			})
		},
		//按类型搜索
		searchlistByKey:function(sortId){
				location.href="/recruit-online/dist/hr/search_list.html?way=sort&sortId="+sortId
		},
		//按职位名称
		searchlistByTitles:function(key){
				location.href="/recruit-online/dist/hr/search_list.html?way=title&title="+key;
		},
		searchlistByTitle:function(){			
				location.href="/recruit-online/dist/hr/search_list.html?way=title&title="+this.key;			
		}
	
	},
	mixins:[entityMixin]
	,
	created:function(){	
		this.hotResumeQuerys();		
		this.present();
		this.classQuery();
		
	}	
})