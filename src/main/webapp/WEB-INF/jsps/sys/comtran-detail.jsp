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
                    <label class="col-sm-3 control-label">交易类型：</label>
                    <div class="col-sm-8">
                        <p class="form-control-static">
                            <c:if test="${comTran.transType == 1}">
                                出售
                            </c:if>
                            <c:if test="${comTran.transType == 2}">
                                求购
                            </c:if>
                        </p>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">所在城市：</label>
                    <div class="col-sm-8">
                        <p class="form-control-static">${comTran.city}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">公司名称：</label>
                    <div class="col-sm-8">
                        <p class="form-control-static">${comTran.companyName}</p>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">营业执照：</label>
                    <div class="col-sm-8">
                        <p class="form-control-static">
                            ${comTran.licenseImage}
                        </p>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">是否有债务：</label>
                    <div class="col-sm-8">
                        <p class="form-control-static">
                            <c:if test="${comTran.debt == 0}">
                                无
                            </c:if>
                            <c:if test="${comTran.debt == 1}">
                                有债务
                            </c:if>
                            <c:if test="${comTran.debt == 2}">
                                有债权
                            </c:if>
                            <c:if test="${comTran.debt == 2}">
                                有不良记录
                            </c:if>
                        </p>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">财务情况：</label>
                    <div class="col-sm-8">
                        <p class="form-control-static">
                            <c:if test="${comTran.financeStatus == 0}">
                                零申报
                            </c:if>
                            <c:if test="${comTran.financeStatus == 1}">
                                亏损
                            </c:if>
                            <c:if test="${comTran.financeStatus == 2}">
                                赢利
                            </c:if>
                        </p>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">许可证：</label>
                    <div class="col-sm-8">
                        <p class="form-control-static">${comTran.permitImage}</p>
                    </div>
                </div>

                <%--<div class="form-group">--%>
                    <%--<label class="col-sm-3 control-label">经办人：</label>--%>
                    <%--<div class="col-sm-8">--%>
                        <%--<p class="form-control-static">${comTran.customerName}</p>--%>
                    <%--</div>--%>
                <%--</div>--%>

                <div class="form-group">
                    <label class="col-sm-3 control-label">所属行业：</label>
                    <div class="col-sm-8">
                        <p class="form-control-static">
                            ${comTran.industry}

                        </p>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">可否议价：</label>
                    <div class="col-sm-8">
                        <p class="form-control-static">
                            <c:if test="${comTran.bargain == 0}">
                                否
                            </c:if>
                            <c:if test="${comTran.bargain == 1}">
                                是
                            </c:if>
                        </p>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">注册时间：</label>
                    <div class="col-sm-8">
                        <p class="form-control-static">
                            <c:if test="${comTran.regDuration == 0}">
                                1年以内
                            </c:if>
                            <c:if test="${comTran.regDuration == 1}">
                                一年以上
                            </c:if>
                            <c:if test="${comTran.regDuration == 2}">
                                2年以上
                            </c:if>
                        </p>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">价格：</label>
                    <div class="col-sm-8">
                        <p class="form-control-static">${comTran.price}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">联系电话：</label>
                    <div class="col-sm-8">
                        <p class="form-control-static">${comTran.mobile}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">经办人：</label>
                    <div class="col-sm-8">
                        <p class="form-control-static">${comTran.acceptUserName}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">创建时间：</label>
                    <div class="col-sm-8">
                        <p class="form-control-static">${comTran.createTimeStr}</p>
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
