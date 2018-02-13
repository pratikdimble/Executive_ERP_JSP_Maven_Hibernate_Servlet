<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<style>
* {box-sizing: border-box;}

body { 
  margin: 0;
  font-family: Arial;
}

.header {
  overflow: hidden;
  background-color: #f1f1f1;
  padding: 20px 10px;
}

.header a {
  float: left;
  color: black;
  text-align: center;
  padding: 12px;
  text-decoration: none;
  font-size: 18px; 
  line-height: 25px;
  border-radius: 4px;
}

.header a.logo {
  font-size: 25px;
  font-weight: bold;
}

.header a:hover {
  background-color: #ddd;
  color: black;
}

.header a.active {
  background-color: dodgerblue;
  color: white;
}

.header-right {
  float: right;
}

@media screen and (max-width: 500px) {
  .header a {
    float: none;
    display: block;
    text-align: left;
  }
  .header-right {
    float: none;
  }
}


#customers {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

#customers td, #customers th {
    border: 1px solid #ddd;
    padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
    padding-top: 12px;
    padding-bottom: 12px;
    text-align: left;
    background-color: #4CAF50;
    color: white;
}
</style>
</head>
<body>
<div class="header">
 <img src="img/newlogo.png" class="logo" style="width: 149px; height: 75px; "/>
  <div class="header-right">
    <a class="active" href="prod_exec_firstpage.jsp">Home</a>
    <a href="selectprodform.jsp">Back</a>
    <a href="#contact">Contact</a>
    <a href="#about">About</a>
    <a href="logout.jsp">Logout</a>
  </div>
</div>
<%! String userdbName;
String userdbPsw;
String prname;
%>
	<%
	Connection con= null;
	PreparedStatement ps = null;
	ResultSet rs1 = null;
	String driverName = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String dbpsw = "oracle";

		
		String sql = "select * from erp_product where name=?";
	
		String name = request.getParameter("name");
	
	if(!(name.equals("select")))	//check that name is not the name of select box
	{
		try{	//try starts
			Class.forName(driverName);
				con = DriverManager.getConnection(url, user, dbpsw);
				ps = con.prepareStatement(sql);
				ps.setString(1, name);
				rs1 = ps.executeQuery();
					if(rs1.next())	//find the name
						{ 
						prname = rs1.getString("name");
				
					if(name.equals(prname) )	//if finds the print data
						{
							session.setAttribute("name",prname);
			%>
<form method="post" action="welcome.jsp">
				<table id="customers">
  					 <tr>
  					 	<th>Select</th>
						<th>Product ID</th>
    					<th>Product Name</th>
   						<th>Product Type</th>
  						<th>Product Company</th>
  						<th>Product Cost</th>
   						<th>Product Quantity</th>
   						<th>Product Warranty</th>
					</tr>
		<% 
			do{	//do starts
			%>
				<tr bgcolor="#DEB887">
				    	  	
    	  			<td><input type="checkbox" name="itemId" value="<%=rs1.getString("PID") %>"></td>
					<td><%=rs1.getString("PID") %></td>
					<td><%=rs1.getString("NAME") %></td>
					<td><%=rs1.getString("TYPE") %></td>
					<td><%=rs1.getString("COMPANY")%></td>
					<td><%=rs1.getString("COST")%></td>
					<td><%=rs1.getString("QUANTITY")%></td>
					<td><%=rs1.getString("WARRANTY")%></td>
				</tr>
			<% 
		}while(rs1.next());//do while close
	}//if close

%>
				
	</table>
	<%
		/* response.sendRedirect("registration.html");  
	} 
}*/
}
	else
		response.sendRedirect("loginerror.jsp");
	rs1.close();
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
	<pre>&nbsp&nbsp<input type="submit" value="Select"></pre>
</form>
</body>
</html>