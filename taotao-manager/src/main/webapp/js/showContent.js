$(function(){
	layui.use('table',function() {
		table = layui.table;
		table.render({
			elem : '#showContentTable',//绑定哪个table表 可以以id选择器绑定 可以以class选择器 还可以以 name选择器
			url : '/content/table',//请求服务器的url路径
			toolbar : '#toolbarContent',//开启头部工具栏，并为其绑定左侧模板
			defaultToolbar : [ 'filter', { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
				layEvent : 'LAYTABLE_TIPS',
				icon : 'layui-icon-tips'
			} ],
			title : '内容表',
			cols : [
			        [
			         {
					  type : 'checkbox',
					  fixed : 'left'
					 },
					 {
					  field : 'id',
					  title : 'ID',
					  width : 80,
					  fixed : 'left'
					 },
					 {
					  field : 'title',
					  title : '内容标题',
					  width : 150
					 },
					 {
					  field : 'subTitle',
					  title : '内容子标题',
					  width : 150
					 },
					 {
					  field : 'titleDesc',
					  title : '内容描述',
					  width : 100
					 },
					 {
					  field : 'url',
					  title : '内容链接',
					  width : 100
					 },
					 {
					  field : 'pic',
					  title : '图片',
					  width : 100
					 },
					 {
					  field : 'pic2',
					  title : '图片2',
					  width : 100
					 },
					 {
					  field : 'created',
					  title : '创建时间',
					  templet : '<div>{{ layui.util.toDateString(d.created, "yyyy-MM-dd HH:mm:ss") }}</div>',
					  width : 200
					 },
					 {
					  field : 'updated',
					  title : '更新时间',
					  templet : '<div>{{ layui.util.toDateString(d.updated, "yyyy-MM-dd HH:mm:ss") }}</div>',
					  width : 200
					 }
					 ] 
			        ],
					page : true
				});
		table.on('toolbar(itemToolBar)',function(obj) {
			var checkStatus = table.checkStatus(obj.config.id);
				switch (obj.event) {
			
					};
				});
		});	
	
	
	var setting = {
			async: {
				enable: true,
				url:"/content/showContentZtree",
				autoParam: ["id"]	
			},
			callback: {
				onClick: zTreeOnClick
			}
		};
		$.fn.zTree.init($("#showContentTree"), setting);
})
function zTreeOnClick(event, treeId, treeNode) {
	if(treeNode.isParent==false){
		console.log(treeNode.id);
	}
};