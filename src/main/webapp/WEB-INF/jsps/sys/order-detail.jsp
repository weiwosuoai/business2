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
                    <label class="col-sm-3 control-label">订单号：</label>
                    <div class="col-sm-8">
                        <p class="form-control-static">
                            ${order.orderNo}
                        </p>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">产品名称：</label>
                    <div class="col-sm-8">
                        <p class="form-control-static">${order.product.productName}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">金额：</label>
                    <div class="col-sm-8">
                        <p class="form-control-static">${order.price}</p>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">订单状态：</label>
                    <div class="col-sm-8">
                        <p class="form-control-static">
                            <c:if test="${order.status == 0}">
                                获取二维码，等待支付
                            </c:if>
                            <c:if test="${order.status == 1}">
                                已支付
                            </c:if>
                        </p>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">创建时间：</label>
                    <div class="col-sm-8">
                        <p class="form-control-static">
                           ${order.createTimeStr}
                        </p>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">支付时间：</label>
                    <div class="col-sm-8">
                        <p class="form-control-static">
                            ${order.payTimeStr}
                        </p>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">退款时间：</label>
                    <div class="col-sm-8">
                        <p class="form-control-static">
                            ${order.refundTime}

                        </p>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">平台流水号：</label>
                    <div class="col-sm-8">
                        <p class="form-control-static">
                            ${order.platformTradeNo}
                        </p>
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
</body>


<!--  /table_bootstrap.html -->
</html>
