<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Logout</title>
 
</head>

<body>

<% session.invalidate(); %>

<p>You have been successfully logout</p>
<% response.addHeader("refresh","2;http://localhost:1010/ERP_Project/index.jsp"); %>
</body>

</html>