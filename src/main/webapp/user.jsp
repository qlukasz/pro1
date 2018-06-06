<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>--%>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
      integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
        integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
        crossorigin="anonymous"></script>

<body style="width: 90%; margin-top: 50px; margin-left: auto; margin-right: auto;">

<%--<sec:authentication property="principal.username" />--%>

<c:url value="/logout" var="logoutUrl" />
<form id="logout" action="${logoutUrl}" method="post" >
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
<c:if test="${pageContext.request.userPrincipal.name != null}">
    ${pageContext.request.userPrincipal.name}
    <a href="javascript:document.getElementById('logout').submit()">Logout</a>
</c:if>

<sf:form method="POST" action="user_save" modelAttribute="user">
    <table class="table table-striped table-bordered">
        <tbody>
        <tr>
            <td>Imię:</td>
            <td><sf:input path="name" /><sf:errors path="name"/></td>
        </tr>
        <tr>
            <td>Nazwisko:</td>
            <td><sf:input path="lastName"/> <sf:errors path="lastName"/></td>
        </tr>
        <tr>
            <td>email:</td>
            <td><sf:input path="email" type="email"/> <sf:errors path="email"/></td>
        </tr>
        <tr>
            <td>wiek:</td>
            <td><sf:input path="age" type="number"/> <sf:errors path="age"/></td>
        </tr>
        <tr>
            <td>pensja:</td>
            <td><sf:input path="salary"/> <sf:errors path="salary"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Zapisz"/></td>
        </tr>
        </tbody>
    </table>
</sf:form>
</body>
