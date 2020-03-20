//统一增删改查方法
var entityMixin={
		el:'#Box',//绑定DIV 
		data:{
			pageCount:0,//总页数
			//分页参数
			SearchParam:{
				pageSize:5,
				page:1,
				
				param:{
					
				}
			},
			//结果集
			SearchResult:{
				total:0,
				rows:[]
			},
			//复选数组
			vals:[],
			//Url:"/manager/brand"
		},
		//方法
		methods:{
			jsonformat:function(jsonStr,key){
				var jsonArr = JSON.parse(jsonStr);
				var newArr=[];
				jsonArr.forEach(function(item,index,arr){
					newArr.push(item[key]);
				});
				return newArr.join(",");
			},
			ArraySplit:function(Array,key,str){
				var newArr=[];
				Array.forEach(function(item,index,arr){
					newArr.push(item[key]);
				});
				return newArr.join(str);
			},
			houresFormat:function(date){
				//console.log("转换前"+date);
				var d =date.getTimezoneOffset() / 60;
				//console.log("时差"+d);
				var h = date.getHours();
				//console.log(h);
				date.setHours(h-d);
				//console.log("转换后"+date);
				return date;
			}
			,
			seartchquery:function(){
				var self=this;
				 axios.post(this.Url+"s",this.SearchParam).then(function(res){
					
					self.SearchResult.rows = res.data.data;
					self.SearchParam.page = res.data.data.page;
					/*self.SearchResult.rows[0].brandIds=JSON.parse(res.data.rows[0].brandIds);*/
					/*console.log(res.data.rows);*/
					self.pageCount=Math.ceil(res.data.data.total/self.SearchParam.pageSize);
					//return res.data.rows;
				}).catch(function(err){
					alert(err);
				})
			},
			remove:function(id){			
				//alert(this.vals);
				var self = this;
				axios.delete(this.Url+"/"+id).then(function(res){
					alert(res.data.msg);				
					self.query();
				}).catch(function(err){
					alert(err);
				})
			},
			//查询所有支持分页
			query:function(){
				var self=this;
				axios.get(this.Url,{
					params:self.SearchParam
				}
				).then(function(res){
					console.log(res)
					self.SearchResult.rows=res.data.data;
					self.SearchParam.page = res.data.data.page;				
					self.pageCount=Math.ceil(res.data.data.total/self.SearchParam.pageSize)
					console.log(self.SearchParam.page);
				}).catch(function(err){
					alert(err);
				})
			},
						
			//批量删除
			drop:function(){
				var self=this;		
				if(this.vals.length==0){
					alert("请至少选择一项");
					return ;
				}
				//alert(this.vals);
				axios.delete(this.Url+"/"+this.vals).then(function(res){
					alert(res.data.msg);
					self.vals=[];
					self.seartchquery();
				}).catch(function(err){
					alert(err);
				})
			},
			//根据ID查询实体
			findById:function(id){
				var self=this;
				axios.get(this.Url+"/"+id).then(function(res){
					console.log(res);
					self.detail=res.data.data;				
				}).catch(function(err){
					alert(err);
				})
			},
			//添加
			save:function(){
				var self=this;
				axios.post(this.Url,this.addEntity).then(function(res){
					alert(res.data.msg);
					self.addEntity={};
					self.query();
				}).catch(function(err){
					alert(err);
				})
			},
			identityFormat:function(identity){
				if(identity==1){
					return "学生";
				}else if(identity==2){
					return "老师";
				}else if(identity==3){
					return "管理员";
				}
			},
			//清除实体
			clear:function(){
				this.entity={};
				this.addEntity={};
				this.detail={};				
			}
		}
		
}
