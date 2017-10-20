<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/common/taglib.jsp" %>

<!DOCTYPE html>
<html>


<!--  /index.html -->
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <title>后台管理系统</title>
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->

    <link rel="shortcut icon" href="<%=context%>/img/favicon.ico">
    <link href="<%=context%>/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="<%=context%>/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="<%=context%>/css/animate.min.css" rel="stylesheet">
    <link href="<%=context%>/css/style.min.css?v=4.1.0" rel="stylesheet">
</head>

<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
    <div id="wrapper">
        <!--左侧导航开始-->
        <nav class="navbar-default navbar-static-side" role="navigation">
            <div class="nav-close"><i class="fa fa-times-circle"></i>
            </div>
            <div class="sidebar-collapse">
                <ul class="nav" id="side-menu">
                    <li class="nav-header">
                        <div class="dropdown profile-element">
                            <span><img alt="image" class="img-circle" src="img/profile_small.jpg" /></span>
                            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <span class="clear">
                               <span class="block m-t-xs"><strong class="font-bold">Allen Jiang</strong></span>
                                <span class="text-muted text-xs block">超级管理员
                                    <%--<b class="caret"></b>--%>
                                </span>
                                </span>
                            </a>
                            <%--<ul class="dropdown-menu animated fadeInRight m-t-xs">--%>
                            	<%--<li><a href="login.html">安全退出</a></li>--%>
                            <%--</ul>--%>
                        </div>
                        <div class="logo-element">系统
                        </div>
                    </li>
                    <%--<li>--%>
                        <%--<a href="#">--%>
                            <%--<i class="fa fa-home"></i>--%>
                            <%--<span class="nav-label">主页</span>--%>
                            <%--<span class="fa arrow"></span>--%>
                        <%--</a>--%>
                        <%--<ul class="nav nav-second-level">--%>
                            <%--<li>--%>
                                <%--<a class="J_menuItem" href="index_v1.html" data-index="0">主页示例一</a>--%>
                            <%--</li>--%>

                        <%--</ul>--%>
                    <%--</li>--%>

                    <%--<li>--%>
                        <%--<a href="#"><i class="fa fa-group"></i> <span class="nav-label">企业登记</span><span class="fa arrow"></span></a>--%>
                        <%--<ul class="nav nav-second-level">--%>
                            <%--<li><a class="J_menuItem" href="#">企业设立</a></li>--%>
                            <%--<li><a class="J_menuItem" href="#">企业变更</a></li>--%>
                            <%--<li><a class="J_menuItem" href="#">企业注销</a></li>--%>
                            <%--<li><a class="J_menuItem" href="#">特殊类服务</a></li>--%>
                        <%--</ul>--%>
                    <%--</li>--%>

                    <%--<li>--%>
                        <%--<a href="#"><i class="fa fa-credit-card"></i> <span class="nav-label">订单查询</span><span class="fa arrow"></span></a>--%>
                    <%--</li>--%>

                    <%--<li>--%>
                        <%--<a href="#"><i class="fa fa-gavel"></i> <span class="nav-label">证照交易</span><span class="fa arrow"></span></a>--%>
                        <%--<ul class="nav nav-second-level">--%>
                            <%--<li><a class="J_menuItem" href="#">公司出售</a></li>--%>
                            <%--<li><a class="J_menuItem" href="#">公司求购</a></li>--%>

                            <%--<li><a class="J_menuItem" href="<%=context%>/sys/user/manage/list">用户管理</a>--%>
                            <%--</li>--%>
                            <%--<!-- <li><a class="J_menuItem" href="table_data_tables.html">菜单管理</a> -->--%>
                            <%--</li>--%>
                            <%--<li><a class="J_menuItem" href="<%=context%>/sys/role/manage/list">角色管理</a>--%>
                            <%--</li>--%>
                        <%--</ul>--%>
                    <%--</li>--%>

                    <%--<li>--%>
                        <%--<a href="#"><i class="fa fa-commenting"></i> <span class="nav-label">在线留言</span><span class="fa arrow"></span></a>--%>
                    <%--</li>--%>

                    <c:forEach var="level1Menu" items="${leftMenus}" varStatus="status">
                        <li>
                            <a href="#"><i class="${level1Menu.icon}"></i> <span class="nav-label">${level1Menu.name}</span><span class="fa arrow"></span></a>

                            <c:if test="${level1Menu.children != null}">
                                <ul class="nav nav-second-level">
                                    <c:forEach var="level2Menu" items="${level1Menu.children}">
                                        <li><a class="J_menuItem" href="<%=context%>${level2Menu.url}">${level2Menu.name}</a></li>
                                    </c:forEach>
                                    <%--<li><a class="J_menuItem" href="<%=context%>/sys/user/manage/list">用户管理</a>--%>
                                    <%--</li>--%>
                                    <%--<!-- <li><a class="J_menuItem" href="table_data_tables.html">菜单管理</a> -->--%>
                                    <%--</li>--%>
                                    <%--<li><a class="J_menuItem" href="<%=context%>/sys/role/manage/list">角色管理</a>--%>
                                    <%--</li>--%>

                                    <%--<li><a class="J_menuItem" href="<%=context%>/sys/role/manage/list">短信收发</a>--%>
                                    <%--</li>--%>

                                </ul>
                            </c:if>
                        </li>
                    </c:forEach>

                </ul>
            </div>
        </nav>
        <!--左侧导航结束-->
        <!--右侧部分开始-->
        <div id="page-wrapper" class="gray-bg dashbard-1">
            <div class="row border-bottom">
                <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                    <div class="navbar-header"><a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i> </a>
                        
                    </div>
                    <ul class="nav navbar-top-links navbar-right">
                        <li class="dropdown hidden-xs">
                            <a class="right-sidebar-toggle" aria-expanded="false">
                                <i class="fa fa-tasks"></i> 皮肤
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>
            <div class="row content-tabs">
                <button class="roll-nav roll-left J_tabLeft"><i class="fa fa-backward"></i>
                </button>
                <nav class="page-tabs J_menuTabs">
                    <div class="page-tabs-content">
                        <a href="javascript:;" class="active J_menuTab" data-id="index_v1.html">首页</a>
                    </div>
                </nav>
                <button class="roll-nav roll-right J_tabRight"><i class="fa fa-forward"></i>
                </button>
                <div class="btn-group roll-nav roll-right">
                    <button class="dropdown J_tabClose" data-toggle="dropdown">关闭操作<span class="caret"></span>

                    </button>
                    <ul role="menu" class="dropdown-menu dropdown-menu-right">
                        <li class="J_tabCloseAll"><a>关闭全部选项卡</a>
                        </li>
                        <li class="J_tabCloseOther"><a>关闭其他选项卡</a>
                        </li>
                    </ul>
                </div>
                <a href="login.html" class="roll-nav roll-right J_tabExit"><i class="fa fa fa-sign-out"></i> 退出</a>
            </div>
            <div class="row J_mainContent" id="content-main">
                <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="<%=context%>/sys/user/manage/list" frameborder="0" data-id="index_v1.html" seamless></iframe>
            </div>
            <div class="footer">
                <div class="pull-right">&copy; 2014-2015 <a href="" target="_blank"></a>
                </div>
            </div>
        </div>
        <!--右侧部分结束-->
        <!--右侧边栏开始-->
        <div id="right-sidebar">
            <div class="sidebar-container">

                <ul class="nav nav-tabs navs-3">

                    <li class="active">
                        <a data-toggle="tab" href="#tab-1">
                            <i class="fa fa-gear"></i> 主题
                        </a>
                    </li>
                </ul>

                <div class="tab-content">
                    <div id="tab-1" class="tab-pane active">
                        <div class="sidebar-title">
                            <h3> <i class="fa fa-comments-o"></i> 主题设置</h3>
                            <small><i class="fa fa-tim"></i> 你可以从这里选择和预览主题的布局和样式，这些设置会被保存在本地，下次打开的时候会直接应用这些设置。</small>
                        </div>
                        <div class="skin-setttings">
                            <div class="title">主题设置</div>
                            <div class="setings-item">
                                <span>收起左侧菜单</span>
                                <div class="switch">
                                    <div class="onoffswitch">
                                        <input type="checkbox" name="collapsemenu" class="onoffswitch-checkbox" id="collapsemenu">
                                        <label class="onoffswitch-label" for="collapsemenu">
                                            <span class="onoffswitch-inner"></span>
                                            <span class="onoffswitch-switch"></span>
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <div class="setings-item">
                                <span>固定顶部</span>

                                <div class="switch">
                                    <div class="onoffswitch">
                                        <input type="checkbox" name="fixednavbar" class="onoffswitch-checkbox" id="fixednavbar">
                                        <label class="onoffswitch-label" for="fixednavbar">
                                            <span class="onoffswitch-inner"></span>
                                            <span class="onoffswitch-switch"></span>
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <div class="setings-item">
                                <span>
                        固定宽度
                    </span>

                                <div class="switch">
                                    <div class="onoffswitch">
                                        <input type="checkbox" name="boxedlayout" class="onoffswitch-checkbox" id="boxedlayout">
                                        <label class="onoffswitch-label" for="boxedlayout">
                                            <span class="onoffswitch-inner"></span>
                                            <span class="onoffswitch-switch"></span>
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <div class="title">皮肤选择</div>
                            <div class="setings-item default-skin nb">
                                <span class="skin-name ">
                         <a href="#" class="s-skin-0">
                             默认皮肤
                         </a>
                    </span>
                            </div>
                            <div class="setings-item blue-skin nb">
                                <span class="skin-name ">
                        <a href="#" class="s-skin-1">
                            蓝色主题
                        </a>
                    </span>
                            </div>
                            <div class="setings-item yellow-skin nb">
                                <span class="skin-name ">
                        <a href="#" class="s-skin-3">
                            黄色/紫色主题
                        </a>
                    </span>
                            </div>
                        </div>
                    </div>
                   
                </div>

            </div>
        </div>
        <!--右侧边栏结束-->
        
    </div>
    <script src="<%=context%>/js/jquery.min.js?v=2.1.4"></script>
    <script src="<%=context%>/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="<%=context%>/js/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script src="<%=context%>/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
    <script src="<%=context%>/js/plugins/layer/layer.min.js"></script>
    <script src="<%=context%>/js/hplus.min.js?v=4.1.0"></script>
    <script type="text/javascript" src="<%=context%>/js/contabs.min.js"></script>
    <script src="<%=context%>/js/plugins/pace/pace.min.js"></script>
</body>


<!--  / -->
</html>
