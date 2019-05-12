<<<<<<< HEAD
//当前页
var page = 5;
/*
 * tBody:存放内容
 */
//function load(urlPost, tBody){
//	$.ajax({
//		type:"post",
//		url:urlPost,
//		async:true,
//		data:{page:page,name:name},
//		dataType:"text",
//		success:function(data){
//			var str = "";
//		    var hang = data.split("|");
//		    //split拆分字符串
//		    for (var i = 0; i < hang.length; i++) {
//			     //通过循环取到每一行;拆分出列；
//			     var lie = hang[i].split("-");
//			     str = str +"<tr><td>"+ lie[0] +"</td><td>"+ lie[1] +"</td><td>" +
//			      "<button type='button' class='btn btn-info sc' ids='"+lie[0]+"'>删除</button>"+
//			      //ids里面存上主键值
//		      		"</td></tr>";
//			}
//		    $(tBody).html(str);
//		}
//	});
//}
function loadPage(url){
	var s="";
	var maxPage = 0;
	var minPage = 5;
	$.ajax({
		type:"get",
		url:url,
		async:false,
		dataType:"text",
		success:function(data){
			maxPage = data;
		}
	});
	//上一页
	s += "<li class='lastPage'><a><<</a></li>";
	//分页列表
	for(var i=page-4;i<page+5;i++){
		//i表示页数
		if(i>=minPage&&i<=maxPage){
			if(i==page){
				s += "<li class=\"active list\"><a>"+i+"</a></li>";
			}else{
				s += "<li class='list'><a>"+i+"</a></li>";
			}
		}
	}
	//下一页
	s += "<li class='nextPage'><a>>></a></li>";
	$('.pager').html(s);
	
	//点击页数
	$('.list').click(function(){
		//改变当前页数
		page = $(this).text();
		//重新加载
		load();
		loadPage(url);
	});
	
	//上一页
	$('.lastPage').click(function(){
		if(page>1){
			page = parseInt(page)-1;
		}
		load();
		loadPage(url);
	});
	
	//下一页
	$('.nextPage').click(function(){
		if(page<maxPage){
			page = parseInt(page)+1;
		}
		load();
		loadPage(url);
	});
	//查询
//	$(search).click(function(){
//		load();
//		loadPage();
//	});
}
/*
 * del:删除按钮
 */
// function del(del, url){
//	  //给删除按钮加上事件
//	  $(del).click(function () {
//		    var ids = $(this).attr("ids");
//		    $.ajax({
//			    url: url,
//			    data: {ids: ids},
//			    dataType: "TEXT",
//			    type: "POST",
//			    success: function (d) {
//			       if (d.trim() == "ok") {
//			       alert("删除成功");
//			       //调用加载数据的方法
//			       load();
//			    }else {
//			        alert("删除失败");
//			    }
//			}
//		});
//	})
=======
//当前页
var page = 5;
/*
 * tBody:存放内容
 */
//function load(urlPost, tBody){
//	$.ajax({
//		type:"post",
//		url:urlPost,
//		async:true,
//		data:{page:page,name:name},
//		dataType:"text",
//		success:function(data){
//			var str = "";
//		    var hang = data.split("|");
//		    //split拆分字符串
//		    for (var i = 0; i < hang.length; i++) {
//			     //通过循环取到每一行;拆分出列；
//			     var lie = hang[i].split("-");
//			     str = str +"<tr><td>"+ lie[0] +"</td><td>"+ lie[1] +"</td><td>" +
//			      "<button type='button' class='btn btn-info sc' ids='"+lie[0]+"'>删除</button>"+
//			      //ids里面存上主键值
//		      		"</td></tr>";
//			}
//		    $(tBody).html(str);
//		}
//	});
//}
function loadPage(url){
	var s="";
	var maxPage = 0;
	var minPage = 5;
	$.ajax({
		type:"get",
		url:url,
		async:false,
		dataType:"text",
		success:function(data){
			maxPage = data;
		}
	});
	//上一页
	s += "<li class='lastPage'><a><<</a></li>";
	//分页列表
	for(var i=page-4;i<page+5;i++){
		//i表示页数
		if(i>=minPage&&i<=maxPage){
			if(i==page){
				s += "<li class=\"active list\"><a>"+i+"</a></li>";
			}else{
				s += "<li class='list'><a>"+i+"</a></li>";
			}
		}
	}
	//下一页
	s += "<li class='nextPage'><a>>></a></li>";
	$('.pager').html(s);
	
	//点击页数
	$('.list').click(function(){
		//改变当前页数
		page = $(this).text();
		//重新加载
		load();
		loadPage(url);
	});
	
	//上一页
	$('.lastPage').click(function(){
		if(page>1){
			page = parseInt(page)-1;
		}
		load();
		loadPage(url);
	});
	
	//下一页
	$('.nextPage').click(function(){
		if(page<maxPage){
			page = parseInt(page)+1;
		}
		load();
		loadPage(url);
	});
	//查询
//	$(search).click(function(){
//		load();
//		loadPage();
//	});
}
/*
 * del:删除按钮
 */
// function del(del, url){
//	  //给删除按钮加上事件
//	  $(del).click(function () {
//		    var ids = $(this).attr("ids");
//		    $.ajax({
//			    url: url,
//			    data: {ids: ids},
//			    dataType: "TEXT",
//			    type: "POST",
//			    success: function (d) {
//			       if (d.trim() == "ok") {
//			       alert("删除成功");
//			       //调用加载数据的方法
//			       load();
//			    }else {
//			        alert("删除失败");
//			    }
//			}
//		});
//	})
>>>>>>> second commit
// }