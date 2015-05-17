<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="navbar.jsp" />
<html>
<head>
	<script>
	function RedirectToTransactions() {
		if(document.getElementById('redirectToTransac').value == '')
			window.location = "${pageContext.request.contextPath}/transactions";
		else
			window.location = document.getElementById('redirectToTransac').value;
	}
	</script>
</head>

<body>
	<div class="container-fluid">
		<div class="table-responsive col-md-offset-3 col-md-6">
			<div class="panel panel-primary">
				<div class="panel-heading">Transaction Details</div>
				
				<table class="table">
            
		            <tr class="info">
		                <td><label>Transaction ID</label></td>
		                <td><label>${result.transactionId}</label></td>
		                <td><input type="hidden" id="redirectToTransac" value="${redirectToTransac}"></input></td>
		            </tr>
		            
		            <tr class="info">
		                <td><label>Book Title</label></td>
		                <td><label>${result.book.title}</label></td>
		                <td></td>
		            </tr>  
		            
		            <tr class="info">
		                <td><label>Seller Name</label></td>
		                <td><label>${result.book.userId.name}</label></td>
		                <td></td>
		            </tr> 
		              
		            <tr class="info">
		                <td><label>Price</label></td>
		                <td><label>${result.price}</label></td>
		                <td></td>
		            </tr>
		            
		            <tr class="info">
		                <td><label>Transaction Time</label></td>
		                <td><label>${result.transactionTime}</label></td>
		            </tr>
		            
		            <tr class="info">
		                <td colspan="2" align="right">
		                	<a class="btn btn-primary" href="${pageContext.request.contextPath}/feedback/buyer/${result.transactionId}" role="button">Feedback</a>
		                	<td><input type="submit" class="btn btn-md btn-primary" value="View All Transactions" onClick="javascript: RedirectToTransactions();"></td>
		                </td>
		            </tr>
		            
        		</table>
        	</div>
	    </div>
	</div>
</body>
</html>