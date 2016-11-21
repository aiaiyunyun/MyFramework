<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="../../styles/main.css"/>
    <link rel="stylesheet" type="text/css" href="../../plugins/easyui/themes/gray/easyui.css" />
    <link rel="stylesheet" type="text/css" href="../../plugins/easyui/themes/icon.css" />
    <script type="text/javascript" src="../../scripts/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="../../plugins/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../../scripts/jeasyui.js"></script>
    
    <script type="text/javascript" src="../../scripts/toolsbar.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            //jeasyui.Messager.Alert('页面加载');

            $('#toolsbar').toolsbar({
                'controls': 'add,edit,delete',
                'onAdd': function () {
                    jeasyui.Messager.Alert('onAdd!');
                    jeasyui.Window.ShowModal('Add', '../frame/WebForm1.jsp', 800, 600);
                }
            });
            
            
            BindDataGrid();
        });
        
        function BindDataGrid() {
            $('#datagrid').datagrid({
                url: '${pageContext.request.contextPath}/ajax/LoadGrid',
                //queryParams: { id: id },
                title: '菜单',
                width: 800,
                fitColumns: false,
                columns: [[
					{ field: 'name', title: '菜单名称' },
                    { field: 'code', title: '菜单编码' },
                    { field: 'pageurl', title: '地址' }
				]],
                pagination: true, //分页控件  
                rownumbers: true//行号  
            });
        }
        
        function Search(){
        	$('#datagrid').datagrid('load',{parentid:$('#txt_parentid').val()});
        }
        
    </script>
</head>
<body>
    <form id="form1">
    <div id="toolsbar"></div>
    <div id="searchbar">
    	<input id="txt_parentid" type="text" value="">
    	<a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-search'"
    	 onclick="Search()">查询</a>
    </div>
    <div>
		<table id="datagrid">
        </table>
    </div>
    </form>
</body>
</html>