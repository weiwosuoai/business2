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
    <link href="<%=context%>/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
    <link href="<%=context%>/css/animate.min.css" rel="stylesheet">
    <link href="<%=context%>/js/plugins/layer/skin/layer.css" rel="stylesheet">
    <link href="<%=context%>/css/style.min.css?v=4.1.0" rel="stylesheet">
    <link href="<%=context%>/css/common.css" rel="stylesheet">

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content">
    <div class="ibox float-e-margins">
        <div class="ibox-title">
            <h5>查询条件</h5>
        </div>
        <div class="ibox-content">

            <div role="form" class="form-inline">
                <div class="form-group">
                    <label class="margin-right-5px">产品名称：</label>
                    <input type="text" id="productName" name="productName" class="form-control">
                </div>
                <div class="form-group margin-left-10px">
                    <label class="margin-right-5px">企业类型：</label>
                    <select class="form-control" name="comType" id="comType">
                        <option value="" selected>--请选择--</option>
                        <c:forEach var="companyType" items="${companyTypeList}">
                             <option value="${companyType.code}">${companyType.value}</option>
                        </c:forEach>
                        <%--<option value="2">外资</option>--%>
                    </select>
                </div>

                <button class="btn btn-primary margin-left-10px" id="query" style="margin-bottom: 0;">查询</button>
            </div>
        </div>

    </div>
    <!-- Panel Other -->
    <div class="ibox float-e-margins">
        <div class="ibox-title">
            <h5>产品列表</h5>
        </div>
        <div class="ibox-content">
            <div class="row row-lg">
                <div class="col-sm-12">
                    <!-- Example Events -->
                    <div class="example-wrap">

                        <%--此隐藏域用来接收 layer 组件返回的状态码--%>
                        <input type="hidden" id="layer_status" value="-1"/>
                        <%--此隐藏域用来接收 layer 组件返回的从服务器获取的消息--%>
                        <input type="hidden" id="layer_msg" value=""/>

                        <div class="example">
                            <div class="btn-group hidden-xs" id="toolbar" role="group">

                                <%--<button type="button" class="btn btn-outline btn-default">--%>
                                    <%--<i class="glyphicon glyphicon-eye-open" aria-hidden="true"></i>查看--%>
                                <%--</button>--%>
                                <button type="button" class="btn btn-outline btn-default" id="add">
                                    <i class="glyphicon glyphicon-plus" aria-hidden="true"></i>新增
                                </button>
                                <button type="button" class="btn btn-outline btn-default" id="edit">
                                    <i class="glyphicon glyphicon-pencil" aria-hidden="true"></i>编辑
                                </button>
                                <button type="button" class="btn btn-outline btn-default" id="del">
                                    <i class="glyphicon glyphicon-trash" aria-hidden="true"></i>删除
                                </button>

                            </div>
                            <table id="table" data-mobile-responsive="true">

                            </table>
                        </div>
                    </div>
                    <!-- End Example Events -->
                </div>
            </div>
        </div>
    </div>
    <!-- End Panel Other -->
</div>

<script src="<%=context%>/js/jquery.min.js?v=2.1.4"></script>
<script src="<%=context%>/js/bootstrap.min.js?v=3.3.6"></script>
<script src="<%=context%>/js/content.min.js?v=1.0.0"></script>
<script src="<%=context%>/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
<script src="<%=context%>/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
<script src="<%=context%>/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
<script src="<%=context%>/js/demo/bootstrap-table-demo.min.js"></script>
<%--弹出框组件--%>
<script src="<%=context%>/js/plugins/layer/layer.js"></script>

<script type="text/javascript">
    // 表格初始化
    $('#table').bootstrapTable({
        pagination: true,
        showColumns: true,
        pageSize: 10,
        pageNumber: 1,
        pageList: [10, 25, 50],
        showRefresh: true,
        smartDisplay: false,
        singleSelect : true, // 单选checkbox
        clickToSelect: true,
        uniqueId: 'productId',
        method: 'get',
        url: '/sys/product/list/data',
        dataType: 'json',
        sidePagination: 'server',
        toolbar: '#toolbar',
        queryParams: 	function(params) {
            var params = {
                offset: params.offset,   //数据起始
                limit: params.limit,  //偏移量
                productName: $("#productName").val(),
                comType: $("#comType").val()
            };
            return params;
        },
        columns: [{
            checkbox: true
        }, {
            field: 'productName',
            title: '产品名称'
        }, {
            field: 'comType',
            title: '企业类型',
            formatter: function(value, row, index) {
                if (value == 1) {
                    return "内资";
                } else if (value == 2) {
                    return "外资";
                } else if (value == 3) {
                    return "特殊类企业";
                } else {
                    return "未设置";
                }
            }
        }, {
            field: 'subComType',
            title: '企业规模',
            formatter: function(value, row, index) {
                if (value == 0) {
                    return "不限";
                } else if (value == 1) {
                    return "小规模";
                } else if (value == 2) {
                    return "一般纳税人";
                } else {
                    return "未设置";
                }
            }
        }, {
            field: 'monthSize',
            title: '月份数',
            formatter: function(value, row, index) {
                if (value == 0) {
                    return "不限";
                } else if (value == 1) {
                    return "6个月";
                } else if (value == 2) {
                    return "12个月";
                } else {
                    return "未设置";
                }
            }
        }, {
            field: 'price',
            title: '价格(元)',
            formatter: function(value, row, index) {
                return "￥" + value;
            }
        }, {
            field: 'createTimeStr',
            title: '创建时间'
        }]
    });

    // 按钮事件
    // 查询
    $('#query').click(function(){
        // 刷新列表
        $("#table").bootstrapTable('refresh');
    });

    // 添加
    $('#add').click(function(){
        layer.open({
            type: 2,
            title: '新增',
            shadeClose: true,
            shade: false,
            maxmin: true, //开启最大化最小化按钮
            area: ['800px', '600px'],
            content: '<%=context%>/sys/product/add/view',
            end: function() {
                // iframe 层提交表单返回的状态码
                var status = $("#layer_status").val();
                // iframe 层提交表单返回的服务器响应的消息
                var msg = $("#layer_msg").val();
                if (status == 0) {
                    layer.msg(msg, {icon: 1});
                    // 刷新列表
                    $("#table").bootstrapTable('refresh');
                } else if (status == 1) {
                    layer.msg(msg, {icon: 2});
                }
                // 状态码恢复默认值
                $("#layer_status").val(-1);
            }
        });
    });

    // 编辑
    $('#edit').click(function(){
        var a= $('#table').bootstrapTable('getSelections');
        if (a.length == 1) {
            var id = a[0].productId;
            layer.open({
                type: 2,
                title: '编辑',
                shadeClose: true,
                shade: false,
                maxmin: true, //开启最大化最小化按钮
                area: ['800px', '500px'],
                content: "<%=context%>/sys/product/" + id + "/edit/view",
                end: function() {
                    // iframe 层提交表单返回的状态码
                    var status = $("#layer_status").val();
                    // iframe 层提交表单返回的服务器响应的消息
                    var msg = $("#layer_msg").val();
                    if (status == 0) {
                        layer.msg(msg, {icon: 1});
                        // 刷新列表
                        $("#table").bootstrapTable('refresh');
                    } else if (status == 1) {
                        layer.msg(msg, {icon: 2});
                    }
                    // 状态码恢复默认值
                    $("#layer_status").val(-1);
                }
            });
        } else {
            //提示层
            layer.msg("请选择一条记录！");
        }
    });

    // 删除
    $('#del').click(function(){
        var a= $('#table').bootstrapTable('getSelections');
        if (a.length == 1) {
            // 提示是否确定删除
            layer.confirm('是否确定要删除这条记录？', {
                icon: 7, title:'提示', btn: ['确定','取消'] //按钮
            }, function(){
                var id = a[0].productId;
                // ajax 异步删除角色
                $.ajax({
                    type: "POST",
                    async: true,
                    url: "<%=context%>/sys/product/" + id + "/delete",
                    success: function (data) {
                        var jsonData = $.parseJSON(JSON.stringify(data));
                        layer.msg(jsonData.msg);

                        // 刷新列表
                        $("#table").bootstrapTable('refresh');
                    }
                });
            }, function(){
                layer.closeAll();
            });
        } else {
            //提示层
            layer.msg("请选择一条记录！");
        }
    });


</script>

</body>


<!--  /table_bootstrap.html -->
</html>
