<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
 
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
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
<input type="radio" value="Katraj" name="choice" onclick="myFun2();">1</input>
<input type="radio" value="Ambegaon" name="choice" onclick="myFun2();">2</input>
<input type="radio" value="3" name="choice" onclick="myFun2();">3</input>
<br/>
You selected: 
<input type="text" id="choiceLabel" name="my"></input>
<p>Display some text when the checkbox is checked:</p>

<!-- Katraj: <input type="checkbox" id="myCheck" name="katraj" value="katraj"  onclick="myFunction();myFun();if (this.checked) { window.location = this.value; }"> -->
<!-- Katraj: <input type="checkbox" id="myCheck" name="katraj"  onclick="myFunction();myFun();"> -->
Katraj<input type="radio" id="myRadio" name="Katraj" onclick="myFunction();myFun();">
<!--  <p id="text" style="display:none">Checkbox is CHECKED!</p> -->
 <p id="text" style="display:none">Checkbox is CHECKED!</p>


<%
String name="Katraj";//=request.getParameter("choice");
String driverName = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String dbpsw = "oracle";

try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;



try{ 
connection = DriverManager.getConnection(url, user, dbpsw);
statement=connection.createStatement();

String sql ="SELECT * FROM ERP_AREA WHERE AREANAME='"+name+"'";

resultSet = statement.executeQuery(sql);
if(!resultSet.next())
{
%>
<!-- <center><font color="#FF0000" size="6">RECORD NOT FOUND...</font></center> -->
<%
}else
{
%>
<table id="customers" style="display:none">
   <tr>
	<th>AREA ID</th>
    <th>REGION Name</th>
    <th>AREA NAME</th>
    <th>DISCRIPTION</th>
</tr>
<% 
do{
%>
<tr bgcolor="#DEB887">

<td><%=resultSet.getString("AREAID") %></td>
<td><%=resultSet.getString("REGName") %></td>
<td><%=resultSet.getString("AREANAME") %></td>
<td><%=resultSet.getString("DESCRIPTION")%></td>

</tr>
</table>
<% 
}while(resultSet.next());
}
} catch (Exception e) {
e.printStackTrace();
}
%>
 
<script>
function myFunction() {
    var checkBox = document.getElementById("myRadio");
    var text = document.getElementById("text");
    if (checkBox.checked == true){
        text.style.display = "block";
    } else {
       text.style.display = "none";
    }
}
function myFun() {
    var checkBox = document.getElementById("myRadio");
    var text = document.getElementById("customers");
    if (checkBox.checked == true){
        text.style.display = "block";
    } else {
       text.style.display = "none";
    }
}
function myFun2() {
    var checkBox = document.getElementById("choiceLabel");
    var text = document.getElementById("customers");
    if (checkBox.checked == true){
        text.style.display = "block";
    } else {
       text.style.display = "none";
    }
}
(function (){
    var radios = document.getElementsByName('choice');
    console.log(radios);
    for(var i = 0; i < radios.length; i++){
        radios[i].onclick = function(){
            document.getElementById('choiceLabel').innerValue = this.value;
        }
    }
})();
</script>

</body>
</html>