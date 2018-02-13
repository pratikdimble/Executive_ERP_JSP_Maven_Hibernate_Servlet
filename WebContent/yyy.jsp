<%@ page import="java.sql.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
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
<body background="img/back.jpg" >
		<font color="WHITE">
<%
	Connection con= null;
	PreparedStatement ps = null;
	ResultSet rs = null;
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

<form method="post" action="welcome.jsp">
	<center><h2 style="color:green">Login Form</h2>	</center>
	<%
		while(rs.next())
			{
				String name = rs.getString("name");
	%>
	<font color="red" size="5">
		<input type="radio" id="myRadio" name="choice" onclick="myFun1();" 
			value="<%=name%>"><%=name%></input>
	</font>

		<% 
		}
	}
		catch(SQLException sqe)
		{
			out.println("home"+sqe);
		}
		
		%>
		<br>
You selected: 
<label id="choiceLabel"></label><br>
<input type="text" id="ch" name="name1"></input>

	 <p id="text" style="display:none">Checkbox is CHECKED!</p>	

	<pre>&nbsp&nbsp<input type="submit" value="LOGIN"></pre>
</form>
<script type="text/javascript">
function myFun() {
    var checkBox = document.getElementById("choice");
    var text = document.getElementById("customers");
    if (checkBox.checked == true){
        text.style.display = "block";
    } else {
       text.style.display = "none";
    }
}
function myFun1() {
    var checkBox = document.getElementById("choice");
    var text = document.getElementById("text");
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
            document.getElementById('choiceLabel').innerText = this.value;
               document.getElementById('text').value = this.value;
                session.setAttribute("name",this.value);
        }
    }
   
/*     var checkBox = document.getElementByName("choice");
     console.log(radios);
    for(var i = 0; i < radios.length; i++){
        radios[i].onclick = function(){
            document.getElementById('text').innerText = this.value;
        }
    }
     if (checkBox.checked == true){
        text.style.display = "block";
    } else {
       text.style.display = "none";
    } */
})();
</script>
</body>
</html>