<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<html>
<head>
<style type="text/css">

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

<p>Display some text when the checkbox is checked:</p>
Katraj: <input type="checkbox" id="myCheck" name="katraj"  onclick="myFunction();myFun();">
Ambegaon: <input type="checkbox" id="myCheck" name="katraj"  onclick="myFunction();myFun();">
<p id="text" style="display:none">

<!-- <p id="text" style="display:none">Checkbox is CHECKED!</p> -->


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

		
		String sql = "select * from erp_area where areaname=?";
	
		String name = request.getParameter("name");
		try{	//try starts
			Class.forName(driverName);
				con = DriverManager.getConnection(url, user, dbpsw);
				ps = con.prepareStatement(sql);
				ps.setString(1, name);
				rs1 = ps.executeQuery();
					if(rs1.next())	//find the name
						{ 
						prname = rs1.getString("name");
				
					if(name.equalsIgnoreCase(prname) )	//if finds the print data
						{
							session.setAttribute("name",prname);
			%>


				<table id="customers">
  					 <tr>
  			<th>Area ID</th>
    <th>Region Name</th>
    <th>Area Name</th>
   	<th>Description</th>
					</tr>
		<% 
			do{	//do starts
			%>
				<tr bgcolor="#DEB887">
					<td><%=rs1.getString("AREAID") %></td>
					<td><%=rs1.getString("REGIONNAME")%></td>
					<td><%=rs1.getString("AREANAME") %></td>
					<td><%=rs1.getString("DESCRIPTION")%></td>
				</tr>
			<% //out.println(rs1.getString("AREAID"));
		}while(rs1.next());//do while close
	}//if close

%>
				
	</table>
	
	<%
		/* response.sendRedirect("registration.html");  
	} 
}*/
}
	else{
		response.sendRedirect("welcome.jsp");
	rs1.close();
	ps.close(); 
	}
		}catch(SQLException sqe)
		{
			out.println(sqe);
		} 
%>

 </p>
<script>
function myFunction() {
    var checkBox = document.getElementById("myCheck");
    var text = document.getElementById("t01");
    if (checkBox.checked == true){
        text.style.display = "block";
    } else {
       text.style.display = "none";
    }
}
function myFun() {
    var checkBox = document.getElementById("myCheck");
    var text = document.getElementById("customers");
    if (checkBox.checked == true){
        text.style.display = "block";
    } else {
       text.style.display = "none";
    }
}

</script>

</body>
</html>