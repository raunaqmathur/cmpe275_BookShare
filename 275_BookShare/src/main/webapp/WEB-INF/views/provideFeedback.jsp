<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="navbar.jsp" />
<%@ page import="edu.sjsu.cmpe275.prj.models.transaction" %>
<html>
<body>
	<form class="form-horizontal col-md-offset-3 col-md-6" id="provideFeedback" action="insertfeedback" method="post" commandName="feedbackModelDetails">
  		<div class="panel panel-primary">
			<div class="panel-heading">Enter Your Feedback</div>
			
			<!-- Text input-->
			<div class="form-group" style="margin-top:15px">
				<label class="col-md-3 control-label" for="comment">Comment:</label>
				<textarea class="col-md-8" rows="5" id="comment"></textarea>
			</div>
			
			<div class="form-group" style="margin-top:15px">
				<label class="col-md-3 control-label" for="textinput">Rating</label>  
				<label class="radio-inline"> <input type="radio" name="rating" id="rating1" value=1> Worst </label>
				<label class="radio-inline"> <input type="radio" name="rating" id="rating2" value=2> Bad </label>
				<label class="radio-inline"> <input type="radio" name="rating" id="rating3" value=3> Okay </label>
				<label class="radio-inline"> <input type="radio" name="rating" id="rating4" value=4> Good </label>
				<label class="radio-inline"> <input type="radio" name="rating" id="rating5" value=5> Best </label>
			</div>
			
			<div class="form-group">
				<label class="col-md-3 control-label" for="singlebutton"></label>
				<button id="singlebutton" name="singlebutton" class="btn btn-primary" type="submit">Submit</button>
				<div><font color="red"><form:errors /></font></div>
			</div>
			
		</div>
  	</form>
</body>
</html>