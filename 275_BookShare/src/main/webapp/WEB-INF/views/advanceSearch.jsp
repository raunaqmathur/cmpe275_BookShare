<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="navbar.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>


  <body>
    <form:form id="advanceSearch" action="advanceSearch" method="post"
        commandName="advanceSearchDetails">
        
<input TYPE=checkbox name="byAuthChkBox" VALUE="BAuth"  > By Author's Name  
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
<label>mhere</label>

<br> <INPUT TYPE=submit name=submit Value="Submit">
       </form:form>
</body>
</html>