<%--
  Created by IntelliJ IDEA.
  User: stundent
  Date: 2/8/19
  Time: 10:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Panel</title>
</head>
<body>
Hormetli, ${sessionScope.user.email}, admin panele xos gelmisiniz! <br/>
Giris vaxtiniz: ${sessionScope.loginTime} <br/>

<a href="logout">Cixis</a>
</body>
</html>
