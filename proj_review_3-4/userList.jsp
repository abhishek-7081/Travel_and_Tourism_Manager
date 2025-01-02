<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
    <h1>User List</h1>
    <ul>
        <c:forEach items="${userList}" var="user">
            <li>${user}</li>
        </c:forEach>
    </ul>
</body>
</html>