<%@ page import="java.sql.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body background="img/back.jpg" >
		<font color="WHITE">
<%-- <%
	Connection con= null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String driverName = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String dbpsw = "oracle";

String sql = "select role from erptab";



	try {
		Class.forName(driverName);
			con = DriverManager.getConnection(url, user, dbpsw);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery(); 
	%> --%>

<form method="post" action="login.jsp">
	<center><h2 style="color:green">Login Form</h2>
	<table border="1" align="center">
			<tr>
				<td><font color="red">Enter UserName :</font></td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td><font color="red">Enter Password :</font></td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td><font color="red">Select Login Role</font></td>
				<td><select name="role">
				<option value="select">select</option>
				<option value="admin">Admin</option>
				<option value="hr">HR</option>
				<option value="Purchase Manager">Purchase Manager</option>
				<option value="Sales Manager">Sales Manager</option>
				<option value="Marketing Manager">Marketing Manager</option>
				<option value="Service Executive">Service Executive</option>
				<option value="Product Executive">Product Executive</option>
	<%-- <%
		while(rs.next())
			{
				String role = rs.getString("role");
	%>
			<option value=<%=role%>><%=role%></option>
		<% 
		}
	}
		catch(SQLException sqe)
		{
			out.println("home"+sqe);
		}
		%> --%>
			</select>
			</td>
		</tr>
			
	</table>
	</center>
		
	<pre>&nbsp&nbsp<input type="submit" value="LOGIN"></pre>
</form>
</body>
</html>