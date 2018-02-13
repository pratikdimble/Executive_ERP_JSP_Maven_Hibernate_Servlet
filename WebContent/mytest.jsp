<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>

</style>
<body>


<%
	Connection con= null;
	PreparedStatement ps = null,ps1=null;
	ResultSet rs = null,rs1=null;
	String driverName = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String dbpsw = "oracle";

String sql = "select name from erp_product";
	 try {
		Class.forName(driverName);
			con = DriverManager.getConnection(url, user, dbpsw);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();  
	%>
<form method="post" action="#">
  
 <input type="radio" onclick="javascript:yesnoCheck();myFunction(this.value);" name="myradio" id="yesCheck" value="laptop"/>laptop 
kk <input type="radio" onclick="javascript:yesnoCheck();" name="myradio" id="noCheck"><br>
    <div id="ifYes" style="visibility:hidden">
     <%
        String b=request.getParameter("myradio");
        out.println("Your department is "+b);
        %>
        Your favorite browser is: <input type="text" id="result" name="result">
    <table border="1" align="center">
			<tr>
				<td><font color="red">Select Login Role</font></td>
				<td><select name="pname">
				<option value="select">select</option>
	<%
		while(rs.next())
			{
				String role = rs.getString("name");
	%>
			<option value=<%=role%>><%=role%></option>
		<% 
		}
		String pname=request.getParameter("pname");
		session.setAttribute("myProduct", pname);
		String prod = (String) session.getAttribute("myProduct");
		String sql1 = "select * from erp_product where name="+prod;
ps1 = con.prepareStatement(sql1);
//ps1.setString(1, thisProd);
rs1 = ps1.executeQuery();     
if(!rs1.next())
{

}else
{
%>
			</select>
			</td>
		</tr>
			
	</table>
	</center>
<table id="customers">
   <tr>
	<th>Product ID</th>
    <th>Product Name</th>
    <th>Product Type</th>
    <th>Product Company</th>
    <th>Product Cost</th>
    <th>Product Quantity</th>
    <th>Product Warranty</th>

</tr>
<% 
do{
%>
<tr bgcolor="#DEB887">

<td><%=rs1.getString("PID") %></td>
<td><%=rs1.getString("NAME") %></td>
<td><%=rs1.getString("TYPE") %></td>
<td><%=rs1.getString("COMPANY")%></td>
<td><%=rs1.getString("COST")%></td>
<td><%=rs1.getString("QUANTITY")%></td>
<td><%=rs1.getString("WARRANTY")%></td>
</tr>
<% 
}while(rs1.next());
	}
	}
		catch(SQLException sqe)
		{
			out.println("home"+sqe);
		}
		%>
				
	</table>
	<%-- <%
	try{ 
	Class.forName(driverName);
			con = DriverManager.getConnection(url, user, dbpsw);
	/* 		ps1 = con.prepareStatement(sql);
			rs1 = ps.executeQuery();  */
String pname=request.getParameter("yesno");
String sql1 = "select * from erp_product where name=?";
ps1 = con.prepareStatement(sql1);
ps1.setString(1, "");
rs1 = ps1.executeQuery();     
if(!rs1.next())
{

}else
{
%>
<%=pname%>
<table id="customers">
   <tr>
	<th>Product ID</th>
    <th>Product Name</th>
    <th>Product Type</th>
    <th>Product Company</th>
    <th>Product Cost</th>
    <th>Product Quantity</th>
    <th>Product Warranty</th>

</tr>
<% 
do{
%>
<tr bgcolor="#DEB887">

<td><%=rs1.getString("PID") %></td>
<td><%=rs1.getString("NAME") %></td>
<td><%=rs1.getString("TYPE") %></td>
<td><%=rs1.getString("COMPANY")%></td>
<td><%=rs1.getString("COST")%></td>
<td><%=rs1.getString("QUANTITY")%></td>
<td><%=rs1.getString("WARRANTY")%></td>
</tr>
</table>
<% 
}while(rs1.next());
}
} catch (Exception e) {
e.printStackTrace();
}
%> --%>
    </div>
        
        other 3<input type='text' id='other3' name='other3'><br>
        other 4<input type='text' id='other4' name='other4'><br>
      
</form>

<script type="text/javascript">
function yesnoCheck() {
    if (document.getElementById('yesCheck').checked) {
        document.getElementById('ifYes').style.visibility = 'visible';
    }
    else document.getElementById('ifYes').style.visibility = 'hidden';

}
</script>
<script>
function myFunction(myradio) {
    document.getElementById("result").value = myradio;
    
}
</script>
</body>

</html>