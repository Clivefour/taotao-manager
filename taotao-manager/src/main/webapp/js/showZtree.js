var pageName;
$(function(){
	var setting = {
			async: {
				enable: true,
				url:"/itemCat/showZtree",
				autoParam: ["id"]	
			},
			callback: {
				onClick: zTreeOnClick
			}
		};
		$(document).ready(function(){
			$.fn.zTree.init($("#treeDemo"), setting);
		});
		
		
		
		function zTreeOnClick(event, treeId, treeNode) {
			if(pageName==1){
				parent.$("#selectCid").val(treeNode.name);
				parent.$("#cidContent").val(treeNode.id);
			}
		};

})
function child(obj){
	if(obj=='showItem.jsp'){
		pageName = "1";
	}
}