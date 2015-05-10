<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="navbar.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.11.2.min.js"></script>

<style>

.rating {
  unicode-bidi: bidi-override;
  direction: rtl;
}
.rating > span {
  display: inline-block;
  position: relative;
  width: 1.1em;
}
.rating > span:hover:before:checked,
.rating > span:hover ~ span:before,
.rating > span:checked ~ span:before,
.rating > span:checked {
  content: "\2605";
   position: absolute;
}
</style>
<script>

function changeForm()
{
	
	if(document.getElementById("type").value == 1)	
		{
			document.getElementById("requestNewDiv").style.display = 'none';
			document.getElementById("feedbackDiv").style.display = 'block';
		}
	else
		{
			document.getElementById("requestNewDiv").style.display = 'block';
			document.getElementById("feedbackDiv").style.display = 'none';
		}
}


function searchTx()
{
	
	

	$.ajax({
	    url: document.getElementById("pageContext").value + '/searchTransaction/' + document.getElementById("transactionId").value,
	    type: 'GET',
	    success: function(data) {
	       
	        if(data.length > 0)
	            document.getElementById("searchedData").innerHTML = data;
	        else
	        	document.getElementById("searchedData").innerHTML = '';
	        
	        //alert('transaction searched ' + document.getElementById("searchedData").innerHTML);
	        
	        var s = data;
	        if(s.indexOf("Buyer") > -1)
	           document.getElementById("userType").value = "Buyer";
	        else
	        	 document.getElementById("userType").value = "Seller";
	    }
	    
	});

}


function starClicked(x)
{
		  
	document.getElementById("rating").value = 6- x;
	//alert('rating: ' + document.getElementById("rating").value);
}

</script>

<body>

<div class="container">
	<form class="form-horizontal" id="getMessage" action="getMessage" method="post" >
		<fieldset>
		
		<!-- Form Name -->
		<legend align="top">Send Message:</legend>
		
		
		<div class="form-group">
		  <label class="col-md-4 control-label" for="textinput">Type of message</label>  
		  <div class="col-md-4">
		  <select id="type" name="type" class="form-control input-md" onClick="javascript: changeForm();">
		  <option value="1">Feedback</option>
		  <option value="2">Request New Book</option>
		  </select> 
		  </div>
		</div>
		
		<!-- Text input-->
		<div id="requestNewDiv" class="form-group" style="display:none;">
		  <label class="col-md-4 control-label" for="textinput">Request</label>  
		  <div class="col-md-4">
		  <input id="message" name="message" type="text"  class="form-control input-md">
		  <font color="red"><label id="errorMessage"></label></font> 
		  </div>
		</div>
		
		<div id="feedbackDiv" class="form-group" style="display:none;">
		  <label class="col-md-1 control-label" for="textinput">Provide Feedback</label>  
		 
		  <label class="col-md-1 control-label" for="textinput">Transaction Id</label> 
		  <div class="col-md-4">
		   
		  <input id="transactionId" name="transactionId" type="text"  class="form-control input-md">
		  <div id="searchedData" style="display:block;"></div>
		  </div>
		  <div class="col-md-4">
		  <button type="button" id="searchTX" name="searchTX" class="btn btn-primary" onClick="javascript: searchTx();">Search</button>
		  
		  <font color="red"><label id="errorTransaction"></label></font> 
		 </div><br/>
		  <div class="col-md-4">
		  <div class="rating">
			<span id="1" onClick="javascript: starClicked(1);">☆</span><span id="2" onClick="javascript: starClicked(2);">☆</span>
			<span id="3" onClick="javascript: starClicked(3);">☆</span><span id="4" onClick="javascript: starClicked(4);">☆</span>
			<span id="5" onClick="javascript: starClicked(5);">☆</span>
			<input id="rating" name="rating" type="hidden" >
			<input id="userType" name="userType" type="hidden" >
			<input id="pageContext" name="pageContext" type="hidden" value="${pageContext.request.contextPath}">
			</div> <br/>
			<label class="col-md-4 control-label" for="textinput">Message</label> 
		  <textarea id="feedbackMessage" name="feedbackMessage"  rows="4" cols="100"  class="form-control input-md" > </textarea>
		  <font color="red"><label id="errorFeedbackMessage"></label></font> 
		  </div>
		</div>
		
		<div class="form-group">
		  <label class="col-md-4 control-label" for="singlebutton"></label>
		  <div class="col-md-4">
		    <button id="singlebutton" name="singlebutton" class="btn btn-primary">Submit</button>
		  </div>
		</div>
		
		
		<font color="green"><label>${msg}</label></font>	
		</fieldset>
		
		</form>
   </div>
</body>
</html>