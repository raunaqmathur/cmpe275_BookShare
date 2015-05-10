<%@    taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="navbar.jsp" />
<html>

<body>
	<div class="container-fluid">
		<div class="table-responsive col-md-6">
			<div class="panel panel-primary">
				<div class="panel-heading">Purchase transactions</div>
				
				<table class="table">	
		            
		            <c:forEach items="${str}" var="result">
		            
			            <tr class="active">
			                <td><label>transaction request number</label></td>
			                <td><label>${result.transactionId}</label></td>
			                <td></td>
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
			                <td><label>transaction date</label></td>
			                <td><label>${result.transactionTime}</label></td>
			                <td></td>
			            </tr>
		            
					</c:forEach>
					
		        </table>
			</div>
		</div>
	
		<div class="table-responsive col-md-6">
			<div class="panel panel-primary">
				<div class="panel-heading">Sale transactions</div>
				
				<table class="table">		            
		            <c:forEach items="${strBuyer}" var="result">
		            
			            <tr class="active">
			                <td><label>transaction request number</label></td>
			                <td><label>${result.transactionId}</label></td>
			                <td></td>
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
			                <td><label>transaction date</label></td>
			                <td><label>${result.transactionTime}</label></td>
			                <td></td>		                
			            </tr>
		            
					</c:forEach>
		        </table>
			</div>
		</div>
	</div>
</body>
</html>