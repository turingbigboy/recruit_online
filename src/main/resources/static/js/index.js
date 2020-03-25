var vue=new Vue({
	data:{
		//预约接口
		Url:"/recruit-online/user",
		entity:{
			
		},
		classify:[],
		hotPostionQuery:[],
		key:"",
		user: {},
        type:null
	},
	methods:{		
		present:function(){
			var self=this;
			axios.get("/recruit-online/user/present"
			).then(function(res){
				console.log(res);
				self.user = res.data.data;
				if(self.user!=null){
				self.type = "user";
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
		},
		getPositionById:function(id){
//			var self=this;
//			axios.get("/recruit-online/position/"+id
//			).then(function(res){
//				console.log(res);
				location.href="/recruit-online/dist/user/position_detail.html?id="+id;
//			}).catch(function(err){
//				alert(err);
//			})
		},
		//按类型搜索
		searchlistByKey:function(sortId){
				location.href="/recruit-online/dist/user/search_list.html?way=sort&sortId="+sortId
		},
		//按职位名称
		searchlistByTitles:function(key){
				location.href="/recruit-online/dist/user/search_list.html?way=title&title="+key;
		},
		searchlistByTitle:function(){			
				location.href="/recruit-online/dist/user/search_list.html?way=title&title="+this.key;			
		}
	
	},
	mixins:[entityMixin]
	,
	created:function(){	
		this.present();
		this.classQuery();
		this.hotPositionQuery();
		
	}	
})