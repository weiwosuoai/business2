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
            <input type="hidden" id="comTranType" name="comTranType" value="1"/>
            <div role="form" class="form-inline">
                <div class="form-group">
                    <label class="margin-right-5px">所在城市：</label>
                    <input type="text" id="city" name="city" class="form-control">
                </div>
                <div class="form-group margin-left-10px">
                    <label class="margin-right-5px">所属行业：</label>
                    <input type="text" id="industry" name="industry" class="form-control">
                </div>
                <div class="form-group margin-left-10px">
                    <label class="margin-right-5px">价格区间（万）：</label>
                    <input type="number" id="priceStart" name="priceStart" size="10" class="form-control">~
                    <input type="number" id="priceEnd" name="priceEnd" size="10" class="form-control">
                </div>
                <button class="btn btn-primary margin-left-10px" id="query" style="margin-bottom: 0;">查询</button>
            </div>
        </div>

    </div>
    <!-- Panel Other -->
    <div class="ibox float-e-margins">
        <div class="ibox-title">
            <h5>出售列表</h5>
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
                                    <i class="glyphicon glyphicon-plus" aria-hidden="true"></i>详情
                                </button>
                                <%--<button type="button" class="btn btn-outline btn-default" id="edit">--%>
                                    <%--<i class="glyphicon glyphicon-pencil" aria-hidden="true"></i>受理--%>
                                <%--</button>--%>
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
        uniqueId: 'transId',
        method: 'get',
        url: '/sys/trans/list/data',
        dataType: 'json',
        sidePagination: 'server',
        toolbar: '#toolbar',
        queryParams: 	function(params) {
            var params = {
                offset: params.offset,   //数据起始
                limit: params.limit,  //偏移量
                city: $("#city").val(),
                comTranType: $("#comTranType").val(),
                industry: $("#industry").val(),
                priceStart: $("#priceStart").val(),
                priceEnd: $("#priceEnd").val()
            };
            return params;
        },
        columns: [{
            checkbox: true
        }, {
            field: 'city',
            title: '所在城市'
        }, {
            field: 'industry',
            title: '行业'
        }, {
            field: 'debt',
            title: '有否债务',
            formatter: function(value, row, index) {
                if (value == 0) {
                    return "无";
                } else if (value == 1) {
                    return "有债务";
                } else if (value == 2) {
                    return "有债权";
                } else if (value == 3) {
                    return "有不良记录";
                } else {
                    return "未设置";
                }
            }
        }, {
            field: 'regDuration',
            title: '注册时间',
            formatter: function(value, row, index) {
                if (value == 0) {
                    return "1年以内";
                } else if (value == 1) {
                    return "一年以上";
                } else if (value == 2) {
                    return "2年以上";
                } else if (value == 3) {
                    return "3年以上";
                } else {
                    return "未设置";
                }
            }
        }, {
            field: 'mobile',
            title: '联系电话'
        }, {
            field: 'price',
            title: '价格(万)',
            formatter: function(value, row, index) {
                return "￥" + value;
            }
        }, {
            field: 'validDateEnd',
            title: '有效期'
        }, {
            field: 'acceptUserName',
            title: '经办人'
        }
        ]
    });

    // 按钮事件
    // 查询
    $('#query').click(function(){
        // 刷新列表
        $("#table").bootstrapTable('refresh');
    });

    // 详情
    $('#add').click(function(){
        var a= $('#table').bootstrapTable('getSelections');
        if (a.length == 1) {
            var id = a[0].transId;
            layer.open({
                type: 2,
                title: '详情',
                shadeClose: true,
                shade: false,
                maxmin: true, //开启最大化最小化按钮
                area: ['800px', '800px'],
                content: '<%=context%>/sys/trans/' + id + '/detail'
            });
        } else {
            //提示层
            layer.msg("请选择一条记录！");
        }

    });

    // 受理
    $('#edit').click(function(){
        var a= $('#table').bootstrapTable('getSelections');
        if (a.length == 1) {
            // 提示是否确定删除
            layer.confirm('确定受理这条申请？', {
                icon: 7, title:'提示', btn: ['确定','取消'] //按钮
            }, function(){
                var id = a[0].transId;
                // ajax 异步删除角色
                $.ajax({
                    type: "POST",
                    async: true,
                    url: "<%=context%>/sys/trans/" + id + "/accept",
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

    // 完结
    $('#del').click(function(){
        var a= $('#table').bootstrapTable('getSelections');
        if (a.length == 1) {
            // 提示是否确定删除
            layer.confirm('确定要关闭这条申请？', {
                icon: 7, title:'提示', btn: ['确定','取消'] //按钮
            }, function(){
                var id = a[0].transId;
                // ajax 异步删除角色
                $.ajax({
                    type: "POST",
                    async: true,
                    url: "<%=context%>/sys/trans/" + id + "/finish",
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

    // 删除
    $('#del').click(function(){
        var a= $('#table').bootstrapTable('getSelections');
        if (a.length == 1) {
            // 提示是否确定删除
            layer.confirm('是否确定要删除这条记录？', {
                icon: 7, title:'提示', btn: ['确定','取消'] //按钮
            }, function(){
                var id = a[0].transId;
                // ajax 异步删除角色
                $.ajax({
                    type: "POST",
                    async: true,
                    url: "<%=context%>/sys/trans/" + id + "/delete",
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
