<%@page contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:userpage headerName="Janusz" loginInfo="">
    <div style="border:1px solid lightgray; padding: 15px; width: 100%; margin-right: auto; margin-left: auto">

        <table id="workforceSkillsTable" class='table table-bordered table-hover table-striped table-dark'>
            <thead class='table-columns'>
            <tr>
                <th>lp</th>
                <th></th>
                <th></th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <tbody class='table-data'>
            <c:forEach var="item" items="${devices}" varStatus="status">
                <%-- dda --%>
                <tr id="${item.getId()}">
                    <td>
                            ${status.index + 1} (${item.getId()})
                    </td>
                    <td>
                        <input type="text" class="a" value="${item.getName()}"/>
                    </td>
                    <td>
                        <input type="text" class="a" value="${item.getType()}"/>
                    </td>
                    <td>
                        <input type="text" class="a" value="${item.isInUse()}"/>
                    </td>
                    <td>
                        <input type="text" class="a" value="${item.getDepartment()}"/>
                    </td>

                </tr>
            </c:forEach>
            </tbody>
        </table>


    </div>
</t:userpage>