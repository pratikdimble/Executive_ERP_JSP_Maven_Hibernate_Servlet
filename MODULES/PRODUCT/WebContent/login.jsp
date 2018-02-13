<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<%! String userdbName;
String userdbPsw;
String userdbRole;
%>
<%
	Connection con= null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String driverName = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String dbpsw = "oracle";

		
		String sql = "select * from erptab where name=? and password=? and role=?";
	
		String name = request.getParameter("name");
		String password= request.getParameter("password");
		String role=request.getParameter("role");
	
	if(!(name.equals(null) || name.equals("")) && !(password.equals(null) || password.equals("")) && !role.equals("select"))
{
	try{
		Class.forName(driverName);
			con = DriverManager.getConnection(url, user, dbpsw);
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
			ps.setString(3, role);
			rs = ps.executeQuery();
		
		if(rs.next())
		{ 
			userdbName = rs.getString("name");
			userdbPsw = rs.getString("password");
			userdbRole= rs.getString("role");
				
		if(name.equals(userdbName) && password.equals(userdbPsw) && role.equalsIgnoreCase("ADMIN") )	
	{
		session.setAttribute("name",userdbName);
			session.setAttribute("role",userdbRole);
		response.sendRedirect("firstpage.jsp"); 
	} 
	else if(name.equals(userdbName) && password.equals(userdbPsw) && role.equalsIgnoreCase("Service Executive") )	
	{
		session.setAttribute("name",userdbName);
			session.setAttribute("role",userdbRole);
		response.sendRedirect("registration.html"); 
	} 
		else if(name.equals(userdbName) && password.equals(userdbPsw) && role.equalsIgnoreCase("Product Executive") )	
	{
		session.setAttribute("name",userdbName);
			session.setAttribute("role",userdbRole);
		response.sendRedirect("selectprodform.jsp"); 
	}
}
	else
		response.sendRedirect("loginerror.jsp");
	rs.close();
	ps.close(); 
	}
		catch(SQLException sqe)
		{
			out.println(sqe);
		} 
	}
else
	{

	%>
		<center><p style="color:red">Error In Login</p></center>
	<% 
		getServletContext().getRequestDispatcher("/loginform.jsp").include(request,response);
	}
%>

<form method="post" action="adminlogindetails.jsp">
<%
	String st=request.getParameter("role");
	String uname=request.getParameter("name");
	String pass=request.getParameter("password");
		session.setAttribute("myUser", uname);
		session.setAttribute("myPass", pass);
		session.setAttribute("myRole", role);
%>
</form>
</body>
</html>