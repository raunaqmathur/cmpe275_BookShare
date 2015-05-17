<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="navbar.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<div class="container-fluid">
		<form class="form-horizontal col-md-offset-4 col-md-4" id="advanceSearch" action="advanceSearch" method="post" commandName="advanceSearchDetails">
			<div class="panel panel-primary">
				<div class="panel-heading">Advance Search</div>
				
				<div class="checkbox" style="margin-left:15px">
					<label><b><input type="checkbox" name="byAuthChkBox" VALUE="BAuth"> By Author Name</b></label>
				</div>
				<div>
					<input id="byAuthTxt" name="byAuthTxt" type="text" placeholder="Enter author name" style="margin-left:35px">
				</div>
				
				<div class="checkbox" style="margin-left:15px" style="margin-top:15px">
					<label><b><input type="checkbox" name="byPricChkBox" VALUE="BPrice"> By Price Range</b></label>
				</div>
				<div>
					<input id="byPriceLowerTxt" name="byPriceLowerTxt" type="text" placeholder="Enter starting price" style="margin-left:35px">
					<input id="byPriceUpperTxt" name="byPriceUpperTxt" type="text" placeholder="Enter ending price">
				</div>
				
				<div class="checkbox" style="margin-left:15px" style="margin-top:15px">
					<label><b><input type="checkbox" name="byCondChkBox" VALUE="BCond"> By Condition</b></label>
				</div>
				<div>
					<input id="newCondCheckbox" name="newCondCheckbox" type="checkbox" value="N" style="margin-left:35px"> New
					<input id="byPriceUpperTxt" name="byPriceUpperTxt" type="checkbox" value="O"> Old
				</div>
				
				<div class="checkbox" style="margin-left:15px" style="margin-top:15px">
					<label><b><input type="checkbox" name="byCategChkBoxP" VALUE="BCateg"> By Categories</b></label>
				</div>
				
				<c:forEach items="${advanceSearchDetails.getCm()}" var="result">
					<div>
						<input path="slist" id="tt" name="tt" type="checkbox" value="${result.getCategoryId()}" style="margin-left:35px"> ${result.getName()}
					</div>
				</c:forEach>
				<label style="margin-left:15px" style="margin-top:35px">Make sure to check the filter you want</label>
				
				<div>
					<button style="margin-left:150px" id="submit" name="submit" class="btn btn-primary" type="submit" value="Submit">Submit</button>
				</div>

			</div>
		</form>
	</div>
</body>
</html>