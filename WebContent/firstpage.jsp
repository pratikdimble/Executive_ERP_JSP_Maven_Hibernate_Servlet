<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

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

.navbar {
    overflow: hidden;
    /* background-color: #333; */
    font-family: Arial;
}

.navbar a {
    float: left;
    font-size: 16px;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

.dropdown {
    float: left;
    overflow: hidden;
}

.dropdown .dropbtn{
    font-size: 16px;    
    border: none;
    outline: none;
    color: red;
    padding: 14px 16px;
    background-color: inherit;
    font: inherit;
    margin: 0;
}

.navbar a:hover, .dropdown:hover .dropbtn  {
    background-color: pink;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}

.dropdown-content a {
    float: none;
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
    text-align: left;
}

.dropdown-content a:hover {
    background-color: #ddd;
}

.dropdown:hover .dropdown-content {
    display: block;
}
/* Create three equal columns that floats next to each other */
.column {
  float: left;
 /*  width: 50%; */
  padding: 10px;
  background-color: #ccc;
  /* height: 250px; */
}

/* Style links inside the columns */
.column a {
  float: none;
  color: black;
  padding: 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}

/* Add a background color on hover */
.column a:hover {
  background-color: #ddd;
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}
.show {display:block;}
</style> 
</head>
<body background="img/back.jpg">

<div class="header">
 <img src="img/newlogo.png" class="logo" style="width: 149px; height: 75px; "/>
  <div class="header-right">
    <a class="active" href="firstpage.jsp">Home</a>
    <a href="#contact">Contact</a>
    <a href="#about">About</a>
    <a href="logout.jsp">Logout</a>
  </div>
</div>


<div class="navbar">

  <div class="dropdown">
    <button class="dropbtn">Masters 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="addproductform.html">Product Master</a>
      <a href="addserviceform.html">Service Master</a>
      <a href="#">Designation Master</a>
      <a href="addcompanyform.html">Company Master</a>
      <a href="bankandbranch.jsp">Bank and Branch Master</a>
      <a href="addregionform.jsp">Region Master</a>
      <a href="addareaform.jsp">Area Master</a>
      <a href="#">Incentive Master</a>
      <a href="#">Telecaller</a>
    </div>
      </div>
      
    <div class="dropdown">
    <button class="dropbtn">Employee 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="#">Assign To</a>
      <a href="adminlogindetails.jsp">Login Details</a>
      <a href="#">Change Department</a>
       <a href="employee?operation=link2">Employee Details</a>
     </div>
  </div> 
  
      <div class="dropdown">
    <button class="dropbtn">Customer 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="#">Profile Entry</a>
      <a href="#">Appointment</a>
     </div>
  </div> 
  
  <div class="dropdown">
    <button class="dropbtn">Transaction 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <div class="row">
        <div class="column">
          <h3>Purchase</h3>
         <a href="#">Purchase Enquiry</a>
     	<a href="#">Purchase Quotation</a>
     	<a href="#">Purchase Order</a>
     	 <a href="#">GRN</a>
        </div>
        <div class="column">
          <h3>Sale</h3>
           <a href="#">Sale Enquiry</a>
     		<a href="#">Sale Quotation</a>
     		<a href="#">Sale Order</a>
     		<a href="#">GRN</a>
        </div>
        </div>
      </div>
      </div>
      						
  	<div class="dropdown">
    <button class="dropbtn">Invoice 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="#">Purchase Bill</a>
      <a href="#">Sale Bill</a>
      <a href="#">Amount Pay/Receive</a>
     </div>
  </div>  
  
   <div class="dropdown">
    <button class="dropbtn">Payroll 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="#">Attendace</a>
      <a href="#">Leave Application</a>
      <a href="#">Payment</a>
     </div>
  </div> 
  
   <div class="dropdown">
    <button class="dropbtn">Events and Holidays 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="#">Create Event </a>
      <a href="#">Display All</a>
     </div>
  </div> 
  
   <div class="dropdown">
    <button class="dropbtn">Search 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="searchproductform.html">Product</a>
      <a href="searchserviceform.html">Service</a>
      <a href="controller?operation=link1">View All Products</a>
      <a href="service?operation=link1">View All Services</a>
      <a href="company?operation=link1">View All Companies</a>
      <a href="employee?operation=link1">View All Employees</a>
      <a href="bank?operation=link1">View All Banks</a>
      <a href="branch?operation=link1">View All Branches</a>
       <a href="region?operation=link1">View All Regions</a>
      <a href="area?operation=link1">View All Areas</a>
     </div>
  </div> 
  
</div>

</body>
</html>