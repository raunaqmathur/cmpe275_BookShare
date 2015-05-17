<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="navbar.jsp" />
<html>
<body>
	<div class="container-fluid">
		<div class="table-responsive col-md-offset-4 col-md-4">
			<div class="panel panel-primary">
				<div class="panel-heading">Feedback as a Seller</div>
				<table class="table">
					<c:forEach items="${str}" var="result">
						<tr class="active">
			                <td><label>Transaction #</label></td>
			                <td>${result.transactionId.transactionId}</td>
			            </tr>
			            
			            <tr class="info">
			                <td><label>Book Name</label></td>
			                <td>${result.transactionId.book.title}</td>
			            </tr>
			            
						<tr class="info">
			                <td><label>Buyer Name</label></td>
			                <td>${result.buyerId.name}</td>
			            </tr>
			            
			            <tr class="info">
			                <td><label>Rating</label></td>
			                <td>${result.buyerRating}</td>
			            </tr>
			            
			            <tr class="info">
			                <td><label>Comment</label></td>
			                <td>${result.buyerComments}</td>
			            </tr>
		             </c:forEach>
		        </table>
			</div>
		</div>
    </div>
</body>
</html>