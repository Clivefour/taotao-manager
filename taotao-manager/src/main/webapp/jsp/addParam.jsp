<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-2.1.0.min.js"></script>

</head>
<body>
	<div id="div1">
		<input type="button" id="button1" value="创建规格组"/><br/>
		<input type="text" name="group"/><input type="button" onclick="paramKey()" value="添加规格项"/><br/>
		|-----<input type="text" /><br/>
		|-----<input type="text" /><br/>
		<input type="text" name="group"/><input type="button" onclick="paramKey()" value="添加规格项"/><br/>
		|-----<input type="text" /><br/>
		|-----<input type="text" /><br/>
		|-----<input type="text" /><br/>
	</div>
	<input type="button" id="button2" value="点击我上传"/>
	<script type="text/javascript">
		$("#button1").click(function(){
			$("#div1").append("<input type='text' name='group'/><input type='button' onclick='paramKey()' value='添加规格项'/><br/>");
		});
		$("#button2").click(function(){
			$("input[name='group']").each(function(i,n){
				console.log($(n).val());
			})
		})
		function paramKey(){
			$("#div1").append("|-----<input  type='text' /><br/>");
		}
	</script>
</body>
</html>