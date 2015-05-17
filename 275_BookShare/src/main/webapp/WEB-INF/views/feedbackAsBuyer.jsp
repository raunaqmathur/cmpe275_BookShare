<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="navbar.jsp" />
<html>
<body>
	<div class="container-fluid">
		<div class="table-responsive col-md-offset-4 col-md-4">
			<div class="panel panel-primary">
				<div class="panel-heading">Feedback as a Buyer</div>
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
			                <td><label>Seller Name</label></td>
			                <td>${result.sellerId.name}</td>
			            </tr>
			            
			            <tr class="info">
			                <td><label>Rating</label></td>
			                <td>${result.sellerRating}</td>
			            </tr>
			            
			            <tr class="info">
			                <td><label>Comment</label></td>
			                <td>${result.sellerComments}</td>
			            </tr>
		             </c:forEach>
		        </table>
			</div>
		</div>
    </div>
</body>
</html>