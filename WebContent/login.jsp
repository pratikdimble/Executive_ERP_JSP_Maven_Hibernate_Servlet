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
%>
<%
	Connection con= null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String driverName = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String dbpsw = "oracle";

		
		String sql = "select * from erptab where name=? and password=?";
	
		String name = request.getParameter("name");
		String password= request.getParameter("password");
	
	if(!(name.equals(null) || name.equals("")) && !(password.equals(null) || password.equals("")))
{
	try{
		Class.forName(driverName);
			con = DriverManager.getConnection(url, user, dbpsw);
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
		
		if(rs.next())
		{ 
			userdbName = rs.getString("name");
			userdbPsw = rs.getString("password");
				
		if(name.equals(userdbName) && password.equals(userdbPsw))	
	{
		session.setAttribute("name",userdbName);
			
		response.sendRedirect("welcome.jsp"); 
	} 
}
	else
		response.sendRedirect("error.jsp");
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
		getServletContext().getRequestDispatcher("/home.jsp").include(request,response);
	}
%>
</body>
</html>