
<%@tag description="User Page template" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>

<%@attribute name="headerName" required="true" %>
<%@attribute name="loginInfo" required="true" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
      integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
      integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>


<%--<link rel="stylesheet" href="css/main.css" crossorigin="anonymous">--%>


<c:url value="/logout" var="logoutUrl"/>
<c:url value="/login" var="loginUrl"/>
<c:set var="userName" value="${pageContext.request.userPrincipal.name}"/>

<t:genericpage>
    <jsp:attribute name="header">
<nav class="navbar navbar-default disable-user-select">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">${headerName}</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/index">Pulpit<span class="sr-only">(current)</span></a></li>
                <li class=""><a href="/devices">Urządzenia<span class="sr-only">(current)</span></a></li>
            </ul>
                <%--<form class="navbar-form navbar-left">--%>
                <%--<div class="form-group">--%>
                <%--<input type="text" class="form-control" placeholder="Search">--%>
                <%--</div>--%>
                <%--<button type="submit" class="btn btn-default">Submit</button>--%>
                <%--</form>--%>
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <br>

                    <c:if test="${userName != null}">${userName}, <span onclick="javascript:document.getElementById('logout').submit()">Wyloguj</span></c:if>
                    <c:if test="${userName == null}"><span onclick="javascript:document.getElementById('login').submit()">Zaloguj</span></c:if>
                </li>

            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

                            <form id="logout" action="${logoutUrl}" method="post">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            </form>
                    <form id="login" action="${loginUrl}" method="post">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    </form>

        <%--<div class="row">--%>
        <%--<div class="col-xs-12 col-sm-6 col-lg-6">--%>
        <%--<h1>${headerName}</h1>--%>
        <%--</div>--%>
        <%--<div class="col-xs-12 col-sm-6 col-lg-6 text-right">--%>
        <%--<h3>${loginInfo}</h3>--%>
        <%--<form id="logout" action="${logoutUrl}" method="post">--%>
        <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
        <%--</form>--%>
        <%--<form id="login" action="${loginUrl}" method="post">--%>
        <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
        <%--</form>--%>
        <%--<c:if test="${userName != null}">${userName}  <a--%>
        <%--href="javascript:document.getElementById('logout').submit()">Wyloguj</a></c:if>--%>
        <%--<c:if test="${userName == null}">             <a--%>
        <%--href="javascript:document.getElementById('login').submit()">Zaloguj</a></c:if>--%>
        <%--</div>--%>
        <%--</div>--%>
    </jsp:attribute>
    <jsp:attribute name="footer">
      <%--<p id="copyright">Copyright 1927</p>--%>
    </jsp:attribute>
    <jsp:body>
        <jsp:doBody/>
    </jsp:body>
</t:genericpage>
