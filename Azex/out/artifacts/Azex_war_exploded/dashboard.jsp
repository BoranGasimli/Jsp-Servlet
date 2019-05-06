<%@ page import="az.azex.domain.FlexibleList" %>
<%@ page import="java.util.Map" %>
<%@ page import="az.azex.domain.FlexibleListItem" %><%--
  Created by IntelliJ IDEA.
  User: stundent
  Date: 2/6/19
  Time: 1:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User dashboard</title>
</head>
<body>
    Hormetli, ${sessionScope.user.email}, xos gelmisiniz! <br/>
    Giris vaxtiniz: ${sessionScope.loginTime} <br/>

    <a href="logout">Cixis</a>


    <%
        Map<String, FlexibleList> flexibleListMap = (Map<String, FlexibleList>) request.getServletContext().getAttribute("flexibleListMap");

        FlexibleList list = flexibleListMap.get("acquisition_channel");

        out.println("<h2>" + list.getName() + "</h2>");
        for(FlexibleListItem item : list.getItemList()) {
            out.println("<p>" + item.getValueId() + ", " + item.getValueName() + ", " + item.getInsertDate() + "</p>");
        }
    %>

</body>
</html>
