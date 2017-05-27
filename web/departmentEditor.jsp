<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title><c:out value="${departmentClickedButton}"/> департамент</title>
</head>
<body>
<form method="get" action="DepartmentEditServlet">
    <p>Укажите название департамента: <input type="text" placeholder="Название департамента" name="name"
                                             value="${department.name}" required/>
        <input type="submit" name="button" value="${departmentClickedButton}">
        <input type="hidden" name="curDepartment_id" value="${department.id}">
        <span style="color: red; ">
            <c:set var="errorMessage" value="${errorMessage}"/>
            <c:if test="${not empty errorMessage}">
                <script type="text/javascript">
                    alert("${errorMessage}");
                </script>
            </c:if>
        </span>
    </p>
</form>
<a href="<c:url value="/DepartmentsServlet"/>">К списку департаментов</a>
</body>
</html>
