<%@    taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="navbar.jsp" />
<html>
<head>
	<script>
	function RedirectToTransactions() {
		if(document.getElementById('redirectToTransac').value == '')
			window.location = "../transactions";
		else
			window.location = document.getElementById('redirectToTransac').value;
	}
	</script>
</head>

<body>
	<div class="container-fluid">
		<div class="table-responsive col-md-offset-3 col-md-6">
			<div class="panel panel-primary">
				<div class="panel-heading">Transaction details</div>
				
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
		                <td><label>Seller Id</label></td>
		                <td><label>${result.book.userId.userId}</label></td>
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
		                <td><input type="submit" class="btn btn-md btn-primary" value="View All Transactions" onClick="javascript: RedirectToTransactions();" /> </td>
		            </tr>
             
        		</table>
        	</div>
	    </div>
	</div>
</body>
</html>