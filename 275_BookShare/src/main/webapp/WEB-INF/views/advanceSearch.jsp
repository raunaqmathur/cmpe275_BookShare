<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="navbar.jsp" />

<html>
<body>
	<div class="container-fluid">
		<form:form id="advanceSearch" action="advanceSearch" method="post" commandName="advanceSearchDetails">
        	<div class="panel panel-primary">
        		<div class="panel-heading">Advance Search</div>
        		
        		<div class="form-group" style="margin-top:15px">
        			<label><input type="checkbox"> Check me out</label>
					<label class="col-md-3 control-label" for="textinput">User ID</label>  
					<div class="col-md-8">
						<input id="userId" name="userId" type="text" placeholder="Enter your User ID" class="form-control input-md">
						<font color="red"><form:errors path="userId" required="true"></form:errors></font> 
						<font color="red"><form:errors path="userId"></form:errors></font>
					</div>
				</div>
			<input TYPE=checkbox name="byAuthChkBox" VALUE="BAuth"> By Author's Name  
			<label>Enter author name </label><input type="text" name="byAuthTxt"><BR><br>
			<input TYPE=checkbox name="byPricChkBox" VALUE="BPrice">By Price Range
			<label>Starting Price </label><input type="text" name="byPriceLowerTxt"> <label>Ending Price </label><input type="text" name="byPriceUpperTxt"><BR><BR>
			<input TYPE=checkbox name="byCondChkBox" VALUE="BCond">By Condition <label> Select Condition </label><input type="checkbox" name="newCondCheckbox" value="N"> NEW <input type="checkbox" name="oldCondCheckbox" value="O"> OLD <BR> <BR>


	<input TYPE=checkbox name=byCategChkBoxP VALUE="BCateg">By Categories <BR><BR>
	<c:forEach items="${advanceSearchDetails.getCm()}" var="result">
	<label> Select Category ${result.getName()}</label>
	<form:checkbox path="slist" value="${result.getCategoryId()}" name="tt"></form:checkbox><br>


</c:forEach>
<br>
<label>Corresponding filters won't work unless the checkboxes are checked</label>

<br> <INPUT TYPE=submit name=submit Value="Submit">
       </form:form>
</body>
</html>