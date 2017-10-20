<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <%--<link href="<%=context%>/css/animate.min.css" rel="stylesheet">--%>
    <link href="<%=context%>/css/style.min.css?v=4.1.0" rel="stylesheet">
    <link href="<%=context%>/css/common.css" rel="stylesheet">

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content">

    <div class="ibox float-e-margins">
        <%--<div class="ibox-title">--%>
            <%--<h5>完整验证表单</h5>--%>
        <%--</div>--%>
        <div class="ibox-content">
            <form class="form-horizontal m-t" id="roleAddForm">
                <div class="form-group">
                    <%--id--%>
                    <input type="hidden" value="${user.id}" id="id" name="id"/>
                    <label class="col-sm-3 control-label">用户名：</label>
                    <div class="col-sm-8">
                        <input id="roleName" name="username" value="${user.username}" class="form-control" type="text">
                        <%--<span class="help-block m-b-none"><i class="fa fa-info-circle"></i> 这里写点提示的内容</span>--%>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">密码：</label>
                    <div class="col-sm-8">
                        <input id="password" name="password" class="form-control" type="password">
                        <%--<span class="help-block m-b-none"><i class="fa fa-info-circle"></i> 这里写点提示的内容</span>--%>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">Email：</label>
                    <div class="col-sm-8">
                        <input id="email" name="email" value="${user.email}" class="form-control" type="email">
                        <%--<span class="help-block m-b-none"><i class="fa fa-info-circle"></i> 这里写点提示的内容</span>--%>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">手机号：</label>
                    <div class="col-sm-8">
                        <input id="phone" name="phone" value="${user.phone}" class="form-control" type="text">
                        <%--<span class="help-block m-b-none"><i class="fa fa-info-circle"></i> 这里写点提示的内容</span>--%>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">角色：</label>
                    <div class="col-sm-8">

                        <form:select path="user.roleId" cssClass="form-control">
                            <form:option value="" label="--请选择--"></form:option>
                            <form:options items="${roleList}" itemValue="roleId" itemLabel="roleName"/>
                        </form:select>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-8 col-sm-offset-3">
                        <button class="btn btn-primary" type="submit" id="submit">修改</button>
                        <%--<button class="btn btn-default margin-left-10px" id="cancle">取消</button>--%>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <!-- End Panel Other -->
</div>
<script src="<%=context%>/js/jquery.min.js?v=2.1.4"></script>
<script src="<%=context%>/js/bootstrap.min.js?v=3.3.6"></script>
<script src="<%=context%>/js/content.min.js?v=1.0.0"></script>
<script src="<%=context%>/js/plugins/validate/jquery.validate.min.js"></script>
<script src="<%=context%>/js/plugins/validate/messages_zh.min.js"></script>
<script src="<%=context%>/js/demo/form-validate-demo.min.js"></script>
<%--弹出框组件--%>
<script src="<%=context%>/js/plugins/layer/layer.js"></script>
<script type="text/javascript">

    $(document).ready(function(){
        // 表单验证
        $("#roleAddForm").validate({
            rules:{
                'username':{
                    required:true
                },
                'password':{
                    required:true
                },
                'email':{
                    required:true
                },
                'phone':{
                    required:true
                },
                'roleId':{
                    required:true
                }
            },
            messages:{
                'username':{
                    required:"请输入用户名"
                },
                'password':{
                    required:"请输入密码"
                },
                'email':{
                    required:"请输入Email"
                },
                'phone':{
                    required:"请输入手机号"
                },
                'roleId':{
                    required:"请选择角色"
                },
            },
            submitHandler : function(form) {
                // ajax 提交
                $.ajax({
                    type: "POST",
                    async: true,
                    data:$('#roleAddForm').serialize(),
                    url: "<%=context%>/sys/user/manage/edit",
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
            }
        });
    });

//    // 取消
//    $('#cancle').click(function(){
//        // 弹出层销毁
//       closeLayer();
//    });
//
//    function closeLayer() {
//        // 弹出层销毁
//        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
//        parent.layer.close(index); //再执行关闭
//    }

</script>

</body>


<!--  /table_bootstrap.html -->
</html>
