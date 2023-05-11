<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
String lat;

%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body onload="getLocation()">

<p id="demo"></p>


<script>
const x = document.getElementById("demo");

var latjs ;
var logjs ;

function getLocation() {
  if (navigator.geolocation) {
    navigator.geolocation.getCurrentPosition(showPosition);
  } else { 
    x.innerHTML = "Geolocation is not supported by this browser.";
  }
}

function showPosition(position) {
  x.innerHTML = "Latitude: " + position.coords.latitude + 
  "<br>Longitude: " + position.coords.longitude;
  latjs = position.coords.latitude;
  logjs = parseFloat(position.coords.longitude);
}
function call(){
	window.location.replace("NewFile.jsp?name="+logjs);
}
</script>

<input type="button" value="Get"  onclick='call()'>
<% 
  lat = "<script> document.writeln(latjs)</script>";
  String log = request.getParameter("name");
  out.println("  ---------   \n \n  ");
  out.println(log);
%>
<br>
<br>
Latitude : 
<h2> <%=lat %></h2>

Longitude : 
<h2> <%=log %></h2>






</body>
</html>