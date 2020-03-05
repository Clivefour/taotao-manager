$(function(){
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
	console.log(event);
	console.log(treeId);
	console.log(treeNode);
};