<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
 "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Uploadify</title>
    <script type="text/javascript" src="../../scripts/jquery-1.7.2.min.js"></script>
    <script src="../../plugins/uploadify/jquery.uploadify.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="../../plugins/uploadify/uploadify.css" />
    <script type="text/javascript" src="../../scripts/jsontool.js"></script>
    <style type="text/css">
        body
        {
            font: 12px 宋体, Helvetica, Sans-serif;
        }
    </style>
</head>
<body>
    <h1>
        Uploadify Demo</h1>
    <form id="form1">
    <div class="uploadify-div">
        <div id="queue">
        </div>
        <a href="javascript:$('#file_upload').uploadify('upload','*')">上传</a> <a href="javascript:LoadDataBase()">
            模拟页面加载</a>
        <input id="file_upload" name="file_upload" type="file" multiple="true" />
    </div>
    <div class="uploadify-mistake">
    </div>
    </form>
    <script type="text/javascript">

        //已上传文件进队列
        function InQueue(myfile) {
            $('#file_upload').uploadify('inqueue', myfile);
        }

        //已上传文件删除
        function CancelFile(fileid) {
            //异步删除数据库记录

            $('#file_upload').uploadify('cancel', fileid);
        }

        function LoadDataBase() {
            //页面加载
            $.ajax({
                type: "POST",
                url: '../../Ashx/frame/UploadPageLoad.ashx',
                data: "code=flow1",
                dataType: "text",
                success: function (myfiles) {
                    var files = $.evalJSON(myfiles);
                    if (files == null) return;
                    for (var i = 0; i < files.length; i++) {
                        InQueue(files[i]);
                    }
                }
            });
        }

        function clearMistake(){
            $('.uploadify-mistake').html("");
        }

        $(document).ready(function () {
            $('#file_upload').uploadify({
                'formData': {
                    'targetFolder': '../../UploadFile'
                }, //文件保存路径
                'swf': '../../Plug-ins/uploadify/uploadify.swf',
                'uploader': '../../Ashx/frame/UploadHandler.ashx',
                'buttonText': "添加附件",
                'auto': false,
                'fileObjName': 'Filedata',
                'width': 80,
                'removeCompleted': false,
                'onUploadSuccess': function (file, data, response) {
                    var uploadResponse = eval('(' + data + ')');
                    if (uploadResponse.success) {
                        var cancel = $("#" + file.id + " .cancel a");
                        if (cancel) {
                            cancel.bind('click',
                                function () {
                                    return CancelFile(uploadResponse.databaseid);
                                }
                            );
                        }
                    } else {
                        $('#file_upload').uploadify('cancel', file.id);
                        if ($('.uploadify-mistake').html() == "") {
                            $('.uploadify-mistake').append('<div><a href="javascript:clearMistake()">清空错误信息</a></div>');
                        }
                        $('.uploadify-mistake').append("<div>" + uploadResponse.msg + "</div>");
                    }
                }
            });

        });
    </script>
</body>
</html>
