<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<style type="text/css" rel="stylesheet">
		.wrap{margin:0 auto;width:500px;}
		[type="text"]{border-radius:5px 5px 5px 5px}
		.xla_k{border-radius:3px 3px 3px 3px}
	</style>
	<title>会员注册</title>
</head>
<body background="./images/2.jpg">
	<div class="wrap">
		<h1>会员信息注册</h1>
		<form action="/example/html/form_action.asp" method="get">
			<p>用户名：&nbsp;&nbsp;&nbsp;
			<input type="text" name="name" />
			</p>
			<p>密码：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="text" name="name" />
			</p>
			<p>确认密码：<input type="text" name="name" />
			</p>
			<p>电子邮件：<input type="text" name="name" />
			</p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;性别：<label>
			<input name="Fruit" type="radio" value=" " checked />保密</label>
			<label><input name="Fruit" type="radio" value=" " checked />男</label>
			<label><input name="Fruit" type="radio" value=" " checked />女</label>			
			</p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;生日：
			<select name="select" id="select_k1" class="xla_k">
			<option value="请选择">请选择</option>
			<option value="1989">1989</option>
			<option value="1990">1990</option>
			<option value="1991">1991</option>
			</select>年
			<select name="select" id="select_k1" class="xla_k">
			<option value="请选择">请选择</option>
			<option value="5">5</option>
			<option value="4">4</option>
			<option value="3">3</option>
			</select>月
			<select name="select" id="select_k1" class="xla_k">
			<option value="请选择">请选择</option>
			<option value="17">17</option>
			<option value="16">16</option>
			<option value="15">15</option>
			<option value="14">14</option>
			<option value="13">13</option>
			<option value="12">12</option>
			<option value="11">11</option>
			<option value="10">10</option>
			<option value="9">9</option>
			<option value="8">8</option>
			<option value="7">7</option>
			<option value="6">6</option>
			<option value="5">5</option>
			<option value="4">4</option>
			<option value="3">3</option>
			<option value="2">2</option>
			<option value="1">1</option>
			</select>日
			</p>
			<p>会员类型：
			<label><input name="Fruit" type="radio" value=" " checked />我要出租</label>
			<label><input name="Fruit" type="radio" value=" " checked />我是租客</label>
			</p>
			<p>昵称：<textarea rows="1" cols="15"></textarea></p>
			<p>所在地区：<select name="select" id="select_k1" class="xla_k">
			<option value="请选择">请选择</option>
			<option value="四川">四川</option>
			<option value="广东">广东</option>
			<option value="浙江">浙江</option>
			</select>
			</p>
			<p>所在城市：<select name="select" id="select_k1" class="xla_k">
			<option value="请选择">请选择</option>
			<option value="成都">成都</option>
			<option value="广州">广州</option>
			<option value="杭州">杭州</option>
			</select>
			</p>
			<p>身高：<select name="select" id="select_k1" class="xla_k">
			<option value="请选择">请选择</option>
			<option value="150cm">150cm</option>
			<option value="160cm">160cm</option>
			<option value="170cm">170cm</option>
			</select>
			</p>
			<p>体重：<select name="select" id="select_k1" class="xla_k">
			<option value="请选择">请选择</option>
			<option value="50kg">50kg</option>
			<option value="60kg">60kg</option>
			<option value="70kg">70kg</option>
			</select>
			</p>
			<p>体型：<select name="select" id="select_k1" class="xla_k">
			<option value="请选择">请选择</option>
			<option value="苗条">苗条</option>
			<option value="丰满">丰满</option>
			<option value="性感">性感</option>
			</select>
			</p>
			<p>学历：<select name="select" id="select_k1" class="xla_k">
			<option value="请选择">请选择</option>
			<option value="高中">高中</option>
			<option value="大专">大专</option>
			<option value="本科">本科</option>
			</select>
			</p>
			<p>婚姻：<select name="select" id="select_k1" class="xla_k">
			<option value="请选择">请选择</option>
			<option value="未婚">未婚</option>
			<option value="已婚">已婚</option>
			<option value="离婚">离婚</option>
			</select>
			</p>
			<p>职业：<textarea rows="1" cols="15"></textarea></p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;爱好：<input type=checkbox 
			checked>读书
			<input type=checkbox>旅游
			<input type=checkbox value=1>足球
			<input type=checkbox value=1>篮球
			<input type=checkbox value=1>乒乓球
			</p>
			<p>个人说明：<textarea cols="30" rows="6"></textarea></p>
			<p>电子邮箱：<textarea rows="1" cols="15"></textarea></p>
			<p>手机号码：<textarea rows="1" cols="15"></textarea></p>
			<p>微信：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<textarea rows="1" cols="15"></textarea></p>
			<p><input type="submit" value="提交基本信息"/></p>
		</form>	
		</div>
</body>
</html>