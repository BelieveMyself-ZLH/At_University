window.onload=Employee("Employee","GET")
function Employee(url,method,data){
	$.ajax({
		type:method,
		url:url,
		data:data,
		dataType:"json",
		success:function(date){
			alert("成功")
		},
		error:function(){
			alert("失败")
		},
		async:true,
	});
}
