<%@ page import="java.sql.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body background="back.jpg" >
		<font color="WHITE">


<form method="post" action="login.jsp">
	<center><h2 style="color:green">Login Form</h2><table border="1" align="center">
		
			<tr>
				<td><font color="red">Enter UserName :</font></td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td><font color="red">Enter Password :</font></td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td><font color="red">Select Login Role<form></form></font></td>
				<td><select name="role">
				<option value="select">select</option>
				<option value="Admin">Admin</option>
				<option value="HR">HR</option>
				<option value="Purchase Manager">Purchase Manager</option>
				<option value="Sales Manager">Sales Manager</option>
				<option value="Marketing Manager">Marketing Manager</option>
			</select>
			</td>
		</tr>	
	</table></center>
		
	<pre>&nbsp&nbsp<input type="submit" value="LOGIN"></pre>
	
	</font>
</form>
</body>
</html>