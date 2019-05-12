window.onload=updateTime() 
function updateTime(){
	var date=new Date();
	var h=date.getHours();
	var m=date.getMinutes();
	var s=date.getSeconds();
	if(h<10){
		h="0"+h;
	}
	if(m<10){
		m="0"+m;
	}
	if(s<10){
		s="0"+s;
	}
	$(".date").text(h+":"+m+":"+s);
}
setInterval(updateTime,1000);
function calc(){
	$.ajax({
		type:"get",
		url:"daka.action?userName="+8888,
		async:true,
		success:function(){
			alert("打卡成功")
		},
		error:function(){
			alert("打卡失敗")
		}
	});
}

$(".book_title").click(function(){
	$(".book").slideToggle(1000);
})
$(".user_title").click(function(){
	//slideToggle()执行隐藏效果，
	//点击一下，如果是展开的就会收缩
	//如果是收缩的就会展开显示
	$(".user").slideToggle(1000);
})
$(".gongneng_title").click(function(){
	$(".gongneng").slideToggle(1000);
})

$("#bookKind").click(function(){
	var iframe=document.getElementById("iframes");
	iframe.src="get_bookkind.action"
})

$("#updatePasw").click(function(){
	var iframe=document.getElementById("iframes");
	iframe.src="updatePassword.html";
})
$("#employee_inf_tab").click(function(){
	var iframe=document.getElementById("iframes");
	iframe.src="employee.action";
})
$("#attendance_record_tab").click(function(){
	var iframe=document.getElementById("iframes");
	iframe.src="attendance.action";
})

$("#daka").click(function(){
	var iframe=document.getElementById("iframes");
	iframe.src="Clockin.html";
})
$("#qingjia").click(function(){
	var iframe=document.getElementById("iframes");
	iframe.src="vacate.html";
})
$("#out_record_tab").click(function(){
	var iframe=document.getElementById("iframes");
	iframe.src="out.action";
})
$("#overtime_record_tab").click(function(){
	var iframe=document.getElementById("iframes");
	iframe.src="overtime.action";
})
$("#off_record_tab").click(function(){
	var iframe=document.getElementById("iframes");
	iframe.src="off.action";
})
$("#month_record_tab").click(function(){
	var iframe=document.getElementById("iframes");
	iframe.src="month.action";
})


