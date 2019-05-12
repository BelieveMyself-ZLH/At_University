function calc(){
	$.ajax({
		type:"post",
		url:"http://loaclhost:8080/Attendance/login.action",
		async:true,
		data:$("#form").serialize(),
		success:function(){
			
		},
		error:function(){
			
		}
	});
}
