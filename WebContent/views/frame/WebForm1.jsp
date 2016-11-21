<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

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
                    jeasyui.Window.ShowModal('Add', '', 800, 600);
                }
            });


            var opt =new Array();
            opt["add"]={
                id: 'id1',
                type:'add',
                icon: 'icon-add',
                onClick: function () {
                    //jeasyui.Window.ShowModal('Add', '', 800, 600);
                }
            };
            opt["edit"]={
                id: 'id2',
                type:'edit',
                icon: 'icon-edit',
                onClick: function () {
                    //jeasyui.Window.ShowModal('Edit', '', 800, 600);
                }
            };
            $('#toolsbar').toolsbar('setControl', opt);
        });
        function a() {
            jeasyui.Window.ShowModal('标题', '../frame/WebForm1.jsp', 800, 600);
        }
        function b() {
            jeasyui.Window.CloseModal();
        }
    </script>
</head>
<body>
    <form id="form1">
    <div id="toolsbar"></div>
    
    <div>
    <input id="te" value="123" type="button" onclick="a()" />

    <input id="d" value="c" type="button" onclick="b()" />
    </div>
    </form>
</body>
</html>
