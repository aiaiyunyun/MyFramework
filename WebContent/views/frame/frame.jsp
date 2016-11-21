<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>XXX系统</title>
    <link rel="stylesheet" type="text/css" href="../../styles/frame.css" />
    <link rel="stylesheet" type="text/css" href="../../plugins/easyui/themes/gray/easyui.css" />
    <link rel="stylesheet" type="text/css" href="../../plugins/easyui/themes/icon.css" />
    <script type="text/javascript" src="../../scripts/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="../../plugins/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../../scripts/jeasyui.js"></script>
    
    <script type="text/javascript">
        //首页
        var indexContent = $('<iframe style="width:100%;height:100%;border:0" />');
        indexContent.attr('src', 'index.jsp');

        var jtab = new jeasyui.Tabs('tabs', 10);

        function AddTab(obj) {
            if (obj.attributes === null || obj.attributes.url =="" || obj.attributes.title=="") {
                return false;
            }
            var mainurl='${pageContext.request.contextPath}/views'+obj.attributes.url;
            jtab.addTab(obj.attributes.title, mainurl);
        }

        function CloseCurrTab() {
            var title = $('#hidCurrTab').val();
            jtab.CloseTab(title);
        }

        function ReloadTab() {
            var selectedTab = jtab.getSelected();
            jtab.refresh(selectedTab);
        }

        function CloseAllTabExceptThis() {
            var title = $('#hidCurrTab').val();
            jtab.CloseAllTabExceptThis(title);
        }

        $(document).ready(function () {
            //构建手风琴
            var aaOptions = {
                fit: true,
                border: false
            };
            $('#aa').accordion(aaOptions);

            //构建选项卡
            var tabsOptions = {
                fit: true,
                tools: '#tab-tools',
                onContextMenu: function (e, title) {
                    e.preventDefault();
                    if (title == "首页") {
                        $('#mm-closeone').attr('style', 'display:none');
                    } else {
                        $('#mm-closeone').attr('style', '');
                    }
                    $('#mm').menu('show', { left: e.pageX, top: e.pageY })
                    $('#hidCurrTab').val(title);
                },
                onAdd: function (title) {
                    jtab.currTabCount++;
                    if (jtab.currTabCount > jtab.maxlength) {
                        jtab.autoCloseTab();
                    }
                },
                onClose: function (title) {
                    jtab.currTabCount--;
                }
            };
            $('#tabs').tabs(tabsOptions);
        });

        function ShowModal(title, windowurl, width, height) {
            var windowoptions = {
                closed: true,
                modal: true,
                collapsible: false,
                minimizable: false,
                maximizable: false,
                title: title,
                content: '<iframe name="' + title + '" src="' + windowurl + '" width="100%" height="100%" frameborder="0" scrolling="auto" ></iframe>',
                top: ($(window).height() - height) * 0.5,
                left: ($(window).width() - width) * 0.5,
                width: width,
                height: height,
                loadingMessage: '正在加载，请稍后...'
            }
            $('#handlewindow').window(windowoptions);
            $('#handlewindow').window('open');
        }

        function CloseModal() {
            $('#handlewindow').window('close');
            ReloadTab();
        }

        var json='[{"id":1,"text":"Folder1","iconCls":"icon-save","children":[{"text":"File1","checked":true},{"text":"Books","state":"open","attributes":{"url":"/demo/book/abc","price":100},"children":[{"text":"PhotoShop","checked":true},{"id":8,"text":"SubBookds","state":"closed"}]}]},{"text":"Languages","state":"closed","children":[{"text":"Java"},{"text":"C#"}]}]';
        
    </script>
</head>
<body class="easyui-layout">
    <form id="form1">
    <div data-options="region:'north',border:false" style="height: 100px; padding: 10px">
        XXX系统
        </div>
    <div data-options="region:'west',split:true,title:'导航'" style="width: 200px; padding: 10px;
        padding: 0; margin: 0">
        <div id="aa" class="easyui-accordion" style="padding: 0; margin: 0">
            <div title="系统目录" style="padding: 8px 0px 8px 0px">
                <ul id="tt2" class="easyui-tree" 
                            data-options="
                            url:'${pageContext.request.contextPath}/views/test/menutree.do',
			                onClick: function(node){
				                $(this).tree('toggle', node.target);
                                AddTab(node);
			                }"></ul>
            </div>
            <div title="内部邮件">
                <div style="line-height: 22px; margin-left: 12px;">
                    <a href="#" url="/views/test/UploadTest.jsp" title="系统配置" onclick="AddTab(this)">系统配置</a></div>
                <div style="line-height: 22px; margin-left: 12px;">
                    <a href="#" url="/views/frame/WebForm1.jsp" title="工作流程" onclick="AddTab(this)">工作流程</a></div>
                <div style="line-height: 22px; margin-left: 12px;">
                    <a href="#" url="/views/frame/WebForm1.jsp" title="报表查询" onclick="AddTab(this)">报表查询</a></div>
            </div>
            <div title="即时通信">
            </div>
        </div>
    </div>
    <div data-options="region:'south',border:false" style="height: 50px; padding: 10px;">
        by:燕十三</div>
    <div data-options="region:'center'">
        <div id="tabs" class="easyui-tabs">
            <div data-options="title:'首页',closable:false,content:indexContent,fit:true">
            </div>
        </div>
    </div>
    <div id="mm" class="easyui-menu" style="width: 160px;">
        <div id="mm-closeone" onclick="CloseCurrTab()">
            关闭当前选项</div>
        <div id="mm-closeall" onclick="CloseAllTabExceptThis()">
            除此之外全部关闭</div>
    </div>
    <div id="tab-tools">
        <a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-reload'"
            onclick="ReloadTab()"></a>
    </div>
    <input type="hidden" id="hidCurrTab" />

    <div id="handlewindow" class="easyui-window" data-options="closed:true">
    </div>
    </form>
</body>
</html>
