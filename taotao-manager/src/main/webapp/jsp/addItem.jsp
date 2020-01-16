<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品添加页面</title>
<script charset="utf-8"
	src="${pageContext.request.contextPath}/kindeditor/kindeditor-all-min.js"></script>
<script charset="utf-8"
	src="${pageContext.request.contextPath}/kindeditor/lang/zh-CN.js"></script>
</head>
<body>
	<div style="padding: 15px; background-color: #FFFFFF">
		<form class="layui-form" action="">
			<div class="layui-form-item">
				<label class="layui-form-label">商品类目</label>
				<div class="layui-input-block">
					<button id="addItemSelectItemCat" type="button"
						class="layui-btn layui-btn-radius">选择类目</button>
					<span style="display: none;" id="addItemSpan"></span> <input
						id="addItemId" type="hidden" name="cId" />
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">商品标题</label>
				<div class="layui-input-inline">
					<input style="width: 270px" type="text" name="title"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">商品卖点</label>
				<div class="layui-input-inline">
					<input style="height: 76px; width: 270px" type="text"
						name="sellPoint" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">商品价格</label>
				<div class="layui-input-inline">
					<input type="text" name="price" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">商品库存</label>
				<div class="layui-input-inline">
					<input type="text" name="num" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">条形码</label>
				<div class="layui-input-inline">
					<input type="text" name="barcode" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">商品图片</label>
				<div class="layui-input-block">
					<div class="layui-upload">
						<button type="button" class="layui-btn" id="test2">上传图片</button>
						<blockquote class="layui-elem-quote layui-quote-nm"
							style="margin-top: 10px;">
							预览图：
							<div class="layui-upload-list" id="demo2"></div>
						</blockquote>
						<input type="hidden" name="image" id="imageUpload" />
					</div>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">商品描述</label>
				<div class="layui-input-inline">
					<textarea id="editor_id" name="itemDesc"
						style="width: 700px; height: 300px;">
					</textarea>
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button type="submit" class="layui-btn" lay-submit=""
						lay-filter="formDemo">立即提交</button>
					<button type="reset" class="layui-btn layui-btn-primary">重置</button>
				</div>
			</div>
		</form>
	</div>
	<script>
		//富文本编辑框对象
		var editor = window.editor = KindEditor.create("#editor_id");

		layui
				.use(
						[ 'form', 'layedit', 'laydate', 'upload' ],
						function() {
							var form = layui.form, layer = layui.layer, layedit = layui.layedit, laydate = layui.laydate, upload = layui.upload;

							//监听提交
							form.on('submit(formDemo)', function(data) {
								//通过富文本编辑器对象.html()方法可以获取到富文本编辑器里面的值
								editorVal = editor.html();
								data.field.itemDesc = editorVal;
							    $.ajax({
							           type: "POST",
							           url: "/item/addItem",
							           data:data.field,
							           dataType: "json",
							           success:function (message) {
							        	   layer.alert(message.msg);
							           },
							           error:function (message) {
							        	   layer.alert(message.msg);
							           }
							       });
								return false;
							});

							//多图片上传  这里一定是 layui的ajax请求 发送图片 controller回传json格式的数据给我们 提示上传成功或者失败
							upload
									.render({
										elem : '#test2',
										url : '/item/fileUpload' //改成您自己的上传接口
										,
										multiple : true,
										before : function(obj) {
											//预读本地文件示例，不支持ie8
											obj
													.preview(function(index,
															file, result) {
														$('#demo2')
																.append(
																		'<img style="height: 100px;width: 100px" src="'+ result +'" alt="'+ file.name +'" class="layui-upload-img">')
													});
										},
										done : function(res) {
											/*
												两种可能行 
												1.返回的结果集 必须按照某一种规格的json格式返回
											 */
											$("#imageUpload").val(
													$("#imageUpload").val()
															+ res.data.src
															+ ",");

										}
									});

						});
		$("#addItemSelectItemCat").click(function() {
			/**
				success:function是当用户点击了按钮以后 成功打开了模态框以后 会执行的function函数
				我们在这个函数里面 执行了一个代码 就是 传递一个参数 到showZtree.jsp页面中去
				是一个唯一标识符 用于区分是谁点击的 这个按钮
				yes:function是当用户点击了模态框上面的确定按钮以后 才会执行的方法
				但是这里有个坑， 主要在业务逻辑上面
				在官网查询得到的资料里面 我可以知道 layer.close(index);
			是关闭这个模态框的，我关闭不聊 关不了的原因是因为
			success:function里面的index == yes:function里面的layero
			 */
			layer.open({
				type : 2,
				title : '商品分类选择',
				shadeClose : true,
				shade : 0.8,
				area : [ '380px', '90%' ],
				content : '/jsp/showZtree.jsp',
				btn : [ '确定', '取消' ],
				yes : function(layero, index) {
					$("#addItemSpan").show();
					layer.close(layero);
				},
				success : function(layero, index) {
					var iframe = window['layui-layer-iframe' + index];
					iframe.child('addItem.jsp');
				}
			});
		})
	</script>



</body>
</html>