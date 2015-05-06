<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="navbar.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>

<div class="container">
	<form class="form-horizontal" id="requestbook" action="requestbook" method="post" commandName="requestbookdetails">
		<fieldset>
		
		<!-- Form Name -->
		<legend align="top">Enter your request</legend>
		
		<!-- Text input-->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="textinput">Request</label>  
		  <div class="col-md-4">
		  <input id="message" name="message" type="text" placeholder="type your message" class="form-control input-md">
		  <font color="red"><form:errors path="message"></form:errors></font> 
		  </div>
		</div>
		
		<div class="form-group">
		  <label class="col-md-4 control-label" for="singlebutton"></label>
		  <div class="col-md-4">
		    <button id="singlebutton" name="singlebutton" class="btn btn-primary">Submit</button>
		  </div>
		</div>
		
		<div><font color="red"><form:errors /></font></div>
		
		</fieldset>
		
		</form>
   </div>
</body>
</html>