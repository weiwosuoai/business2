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
                    <label class="col-sm-3 control-label">产品名称：</label>
                    <div class="col-sm-8">
                        <p class="form-control-static">${busRequest.product.productName}</p>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">产品描述：</label>
                    <div class="col-sm-8">
                        <p class="form-control-static">${busRequest.description.descName}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">订单号：</label>
                    <div class="col-sm-8">
                        <p class="form-control-static">${busRequest.orderNo}</p>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">业务状态：</label>
                    <div class="col-sm-8">
                        <p class="form-control-static">
                            <c:if test="${busRequest.status == 0}">
                                未受理
                            </c:if>
                            <c:if test="${busRequest.status == 1}">
                                已受理
                            </c:if>
                            <c:if test="${busRequest.status == 2}">
                                已完结
                            </c:if>
                        </p>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">客户姓名：</label>
                    <div class="col-sm-8">
                        <p class="form-control-static">${busRequest.customerName}</p>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">联系电话：</label>
                    <div class="col-sm-8">
                        <p class="form-control-static">${busRequest.mobile}</p>
                        <%--<form:select path="user.roleId" cssClass="form-control">--%>
                            <%--<form:option value="" label="--请选择--"></form:option>--%>
                            <%--<form:options items="${roleList}" itemValue="roleId" itemLabel="roleName"/>--%>
                        <%--</form:select>--%>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">传真：</label>
                    <div class="col-sm-8">
                        <p class="form-control-static">${busRequest.fax}</p>
                    </div>
                </div>

                <%--<div class="form-group">--%>
                    <%--<label class="col-sm-3 control-label">经办人：</label>--%>
                    <%--<div class="col-sm-8">--%>
                        <%--<p class="form-control-static">${busRequest.customerName}</p>--%>
                    <%--</div>--%>
                <%--</div>--%>

                <div class="form-group">
                    <label class="col-sm-3 control-label">是否需要发票：</label>
                    <div class="col-sm-8">
                        <p class="form-control-static">
                            <c:if test="${busRequest.needInvoice == 0}">
                                不需要
                            </c:if>
                            <c:if test="${busRequest.needInvoice == 1}">
                                需要
                            </c:if>

                        </p>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">发票抬头：</label>
                    <div class="col-sm-8">
                        <p class="form-control-static">
                            ${busRequest.invoiceTitle}
                        </p>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">创建时间：</label>
                    <div class="col-sm-8">
                        <p class="form-control-static">${busRequest.createTimeStr}</p>
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
