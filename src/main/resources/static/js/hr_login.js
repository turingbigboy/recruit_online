var form =new Vue({
    el:'#loginForm',
    data:{
        url:'/hr/login',
        form:{
        	mobile: '',
        	password: ''
        }
    },
    methods:{
        login : function () {
        	console.log(this.form);
        	axios.get(this.url,{
        		params:this.form
			}
			).then(function(res){			
	                alert("success");         
			}).catch(function(err){
				alert(err);
			})
        }
    }
});