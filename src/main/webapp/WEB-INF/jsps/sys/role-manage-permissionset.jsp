<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/common/taglib.jsp" %>

<!DOCTYPE html>
<html>
<!--  /table_bootstrap.html -->
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>后台管理系统</title>
    <link href="<%=context%>/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="<%=context%>/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <%--<link href="<%=context%>/css/plugins/jsTree/style.min.css" rel="stylesheet">--%>
    <link href="<%=context%>/css/plugins/jsTree/assets/dist/themes/proton/style.css" rel="stylesheet">
    <link href="<%=context%>/css/plugins/jsTree/assets/docs.css" rel="stylesheet">
    <link href="<%=context%>/css/style.min.css?v=4.1.0" rel="stylesheet">
    <link href="<%=context%>/css/common.css" rel="stylesheet">

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content" style="padding-left: 30px;">
    <%--jstree container--%>
        <div class="form-horizontal m-t" id="form">

            <div id="container" class="margin-bottom-20px"></div>
            <input type="hidden" value="${roleId}" id="roleId" name="roleId"/>
            <button class="btn btn-primary pull-left" type="submit" id="submit">确定</button>
        </div>

    <!-- End Panel Other -->
</div>
<script src="<%=context%>/js/jquery.min.js?v=2.1.4"></script>
<script src="<%=context%>/js/bootstrap.min.js?v=3.3.6"></script>
<script src="<%=context%>/js/content.min.js?v=1.0.0"></script>
<script src="<%=context%>/js/plugins/jsTree/jstree.min.js"></script>

<script type="text/javascript">

    $(function() {
        // 清空实例，jstree不会重新生成
//        $('#container').data('jstree', false).empty();
        var roleId = $('#roleId').val();
        $('#container').jstree({
            'plugins': ["checkbox"],
            'core' : {
                'data' : {
                    'url' : '/sys/role/manage/permissionset/tree?roleId=' + roleId,
                    'data': function (node) {
                        return { 'id': node.id };
                    }
                },
                'themes': {
                    'name': 'proton',
                    'responsive': true
                }
            }
        });

    });

    $('#submit').click(function(){
        var menuIds = $('#container').jstree().get_checked(); //获取所有选中的节点ID
        var roleId = $('#roleId').val();
        // ajax 提交
        $.ajax({
            type: "POST",
            async: true,
            url: "<%=context%>/sys/role/manage/permissionset/update?roleId=" + roleId + "&menuIds=" + menuIds,
            success: function (data) {
                var jsonData = $.parseJSON(JSON.stringify(data));
                var index = parent.layer.getFrameIndex(window.name);
                if (jsonData.status == 0) {
                    parent.$("#layer_status").val(0);
                } else {
                    parent.$("#layer_status").val(1);
                }
                parent.$("#layer_msg").val(jsonData.msg);
                parent.layer.close(index);
            }
        });
    });

</script>

</body>


<!--  /table_bootstrap.html -->
</html>
