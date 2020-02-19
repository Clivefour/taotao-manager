<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加规格参数</title>
</head>
<body>
<div style="padding: 15px; background-color: #FFFFFF;height: 100%">
	<form class="layui-form">
		<div class="layui-form-item">
			<label class="layui-form-label">商品类目</label>
			<div class="layui-input-block">
				<button id="findGroup" type="button"
					class="layui-btn layui-btn-radius">选择类目</button>
				<span style="display: none;" id="addParamSpan"></span> <input
					id="cIdParam" type="hidden" name="cId" />
			</div>
		</div>
		
		<div id="paramTemplate" style="display: none;"  class="layui-form-item">
			<label class="layui-form-label">规格模板</label>
			<div class="layui-input-block">
				<button id="addParamGroup" type="button"
					class="layui-btn layui-btn-radius">添加规格参数组</button>
			</div>
		</div>
		<div id="groupAndKey">
			
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
					<button type="submit" class="layui-btn" lay-submit=""
						lay-filter="saveParam">保存规格参数</button>
					<button type="reset" class="layui-btn layui-btn-primary">取消</button>
			</div>
		</div>
	</form>

<script type="text/javascript">
layui.use([ 'form', 'layedit', 'laydate' ],function() {
		var form = layui.form, layer = layui.layer, layedit = layui.layedit, laydate = layui.laydate;
		form.on('submit(saveParam)', function(data) {
				
			
		return false;
	});
});
$("#findGroup").click(function() {
	
	layer.open({
		type : 2,
		title : '商品分类选择',
		shadeClose : true,
		shade : 0.8,
		area : [ '380px', '90%' ],
		content : '/jsp/showZtree.jsp',
		btn : [ '确定', '取消' ],
		yes : function(layero, index) {
			$("#addParamSpan").show();
			layer.close(layero);
			var cId = $("#cIdParam").val();
			$.ajax({
				type : "POST",
				url : "/itemGroup/showItemGroup",
				data : "cId="+cId,
				dataType : "json",
				success : function(message) {
				if (message.status == 200) {
					layer.alert("该分类已经有规格参数模板了，如果需要修改，请去规格参数模板修改页面完成");
				
				} else {
					$("#paramTemplate").show();
				}
			}
		});
		},
		success : function(layero, index) {
			var iframe = window['layui-layer-iframe' + index];
			iframe.child('addParam.jsp');
		}
	});
})	
$("#addParamGroup").click(function(){
	$("#groupAndKey").append("<div class='layui-form-item'><label class='layui-form-label'>规格参数组</label><div class='layui-input-inline layui-row layui-col-space10 paramGroups'><div class='layui-col-md9'><input type='text' class='layui-input'></div><div class='layui-col-md3'><input type='button' value='&#xe624;' name='addParamKeys' class='layui-btn layui-icon layui-icon-addition'></div></div></div>");
	$(".paramGroups").each(function(i,n){
		$(n).find("input[name=addParamKeys]").click(function(){
			$(n).append("<div class='layui-col-md3'>|____</div><div class='layui-col-md9'><input type='text' class='layui-input'></div>");
		})
	})
})


</script>
</div>
</body>
</html>