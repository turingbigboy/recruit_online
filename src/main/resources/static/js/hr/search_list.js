
var box = new Vue({
    data: {
      positions:[],
      type:"user",
      user:{},
      orderBy:"salaryUp",
      title:""
    },
    methods:{
    	queryCheck:function(){
    		var b = new Base64();
    		var url = location.search; //获取url中"?"符后的字串 ('?modFlag=business&role=1')  
			var theRequest = new Object();  
			if ( url.indexOf( "?" ) != -1 ) {  
			  var str = url.substr( 1 ); //substr()方法返回从参数值开始到结束的字符串；  
			  var strs = str.split( "&" );  
			  var param = strs[ 0 ].split( "=" )[ 1 ];
			  var param2 = strs[ 1 ].split( "=" ) [1];
			  if(param=="sort"){
				  this.getPositionBySort(param2);
			  }else if(param == "title"){
				  this.title = decodeURIComponent(param2);
				  this.getPositionByTitle();
			  }
			
			}else{
				this.getPostionBySalary();
			}  
    	},
    	getPositionByTitle:function(){
    		var self = this;
			axios.get("/recruit-online/position/title?title="+self.title,{
        		params:self.SearchParam
			}
			).then(function(res){
				console.log(res);
				self.orderBy =	"salaryUp";
				self.positions = res.data.data;   
			}).catch(function(err){
				alert(err);
			})
    	}
    	,
    	searchlistByTitle:function(tit){
    		this.title = tit;
    		this.getPositionByTitle();
    	}
    	,
    	getPositionBySort:function(sortId){
    		var self = this;
			axios.get("/recruit-online/position/sort/"+sortId,{
        		params:self.SearchParam
			}
			).then(function(res){
				console.log(res);
				self.positions = res.data.data;   
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
		getPostionByHits:function(){
			var self = this;
			axios.get("/recruit-online/position?orders=hits&asc=false",{
        		params:self.SearchParam
			}
			).then(function(res){
				console.log(res);
				self.orderBy =	"hits";
				self.positions = res.data.data;   
			}).catch(function(err){
				alert(err);
			})
		},
		getPostionByCreateTime:function(){
			var self = this;
			axios.get("/recruit-online/position?orders=release_date&asc=false",{
        		params:self.SearchParam
			}
			).then(function(res){
				console.log(res);
				self.orderBy =	"releaseDate";
				self.positions = res.data.data;   
			}).catch(function(err){
				alert(err);
			})
		},
		getPostionBySalary:function(){
			var self = this;
			axios.get("/recruit-online/position?orders=salaryUp&asc=false",{
        		params:self.SearchParam
			}
			).then(function(res){
				console.log(res);
				self.orderBy =	"salaryUp";
				self.positions = res.data.data; 
				
			}).catch(function(err){
				alert(err);
			})
		}
    },
	mixins:[entityMixin]
    ,
    created:function(){	
		this.queryCheck();		
	}	
});


$("#bySalary").click(function () {
    window.location.href = "?keyword=" + box.keyword + "&orderBy=salaryUp";
});

$("#byRelease").click(function () {
    window.location.href = "?keyword=" + box.keyword + "&orderBy=releaseDate";
});

$("#byHits").click(function () {
    window.location.href = "?keyword=" + box.keyword + "&orderBy=hits";
});
function Base64() {
	 
    // private property
    _keyStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=";
 
    // public method for encoding
    this.encode = function (input) {
        var output = "";
        var chr1, chr2, chr3, enc1, enc2, enc3, enc4;
        var i = 0;
        input = _utf8_encode(input);
        while (i < input.length) {
            chr1 = input.charCodeAt(i++);
            chr2 = input.charCodeAt(i++);
            chr3 = input.charCodeAt(i++);
            enc1 = chr1 >> 2;
            enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);
            enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);
            enc4 = chr3 & 63;
            if (isNaN(chr2)) {
                enc3 = enc4 = 64;
            } else if (isNaN(chr3)) {
                enc4 = 64;
            }
            output = output +
            _keyStr.charAt(enc1) + _keyStr.charAt(enc2) +
            _keyStr.charAt(enc3) + _keyStr.charAt(enc4);
        }
        return output;
    }
 
    // public method for decoding
    this.decode = function (input) {
        var output = "";
        var chr1, chr2, chr3;
        var enc1, enc2, enc3, enc4;
        var i = 0;
        input = input.replace(/[^A-Za-z0-9\+\/\=]/g, "");
        while (i < input.length) {
            enc1 = _keyStr.indexOf(input.charAt(i++));
            enc2 = _keyStr.indexOf(input.charAt(i++));
            enc3 = _keyStr.indexOf(input.charAt(i++));
            enc4 = _keyStr.indexOf(input.charAt(i++));
            chr1 = (enc1 << 2) | (enc2 >> 4);
            chr2 = ((enc2 & 15) << 4) | (enc3 >> 2);
            chr3 = ((enc3 & 3) << 6) | enc4;
            output = output + String.fromCharCode(chr1);
            if (enc3 != 64) {
                output = output + String.fromCharCode(chr2);
            }
            if (enc4 != 64) {
                output = output + String.fromCharCode(chr3);
            }
        }
        output = _utf8_decode(output);
        return output;
    }
 
    // private method for UTF-8 encoding
    _utf8_encode = function (string) {
        string = string.replace(/\r\n/g,"\n");
        var utftext = "";
        for (var n = 0; n < string.length; n++) {
            var c = string.charCodeAt(n);
            if (c < 128) {
                utftext += String.fromCharCode(c);
            } else if((c > 127) && (c < 2048)) {
                utftext += String.fromCharCode((c >> 6) | 192);
                utftext += String.fromCharCode((c & 63) | 128);
            } else {
                utftext += String.fromCharCode((c >> 12) | 224);
                utftext += String.fromCharCode(((c >> 6) & 63) | 128);
                utftext += String.fromCharCode((c & 63) | 128);
            }
 
        }
        return utftext;
    }
 
    // private method for UTF-8 decoding
    _utf8_decode = function (utftext) {
        var string = "";
        var i = 0;
        var c = c1 = c2 = 0;
        while ( i < utftext.length ) {
            c = utftext.charCodeAt(i);
            if (c < 128) {
                string += String.fromCharCode(c);
                i++;
            } else if((c > 191) && (c < 224)) {
                c2 = utftext.charCodeAt(i+1);
                string += String.fromCharCode(((c & 31) << 6) | (c2 & 63));
                i += 2;
            } else {
                c2 = utftext.charCodeAt(i+1);
                c3 = utftext.charCodeAt(i+2);
                string += String.fromCharCode(((c & 15) << 12) | ((c2 & 63) << 6) | (c3 & 63));
                i += 3;
            }
        }
        return string;
    }
}

function nextPage() {
    page = page + 1;
    if (page <= pageTotal) {
        var searchItem = {
            keyword: box.keyword,
            orderBy: box.orderBy,
            page: page
        };
        $.ajax({
            url: "http://localhost:8080/search",
            type: "post",
            data: searchItem,
            dataType: "json",
            success: function (data) {

                $.each(data.posInfo.list, function (key, val) {
                    box.positions.push(val);
                });

            }, error: function () {
                $("#viewMoreButton").empty();
                $("#viewMoreButton").append("没有更多");
            }
        });
    } else {
        $("#viewMoreButton").empty();
        $("#viewMoreButton").append("没有更多");
        $("#viewMoreButton").addClass("disable");
    }
}

//查询url中orderBy方式
function GetQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null)
        return unescape(r[2]);
    return null;
}
