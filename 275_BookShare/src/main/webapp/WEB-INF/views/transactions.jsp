<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="navbar.jsp" />
<html>

<body>
	<div class="container-fluid">
		<div class="table-responsive col-md-6">
			<div class="panel panel-primary">
				<div class="panel-heading">Sales</div>
				
				<table class="table">	
		            
		            <c:forEach items="${strSeller}" var="result">
		      

		           
		            <tr  style="border-style: solid;">
		                <td><label>transaction request number</label></td>
		                <td><label>${result.transactionId}</label></td>
		                <td></td>
		                
		            </tr>


			            <tr class="active">
			                <td><label>Transaction Number</label></td>
			                <td><label>${result.transactionId}</label></td>
			                <td></td>
			            </tr>
			            
			            <tr class="info">
			                <td><label>Book Title</label></td>
			                <td><label>${result.book.title}</label></td>
			                <td></td>
			            </tr>  
			            
			            <tr class="info">
			                <td><label>Buyer Name</label></td>
			                <td><label>${result.getUser().getName()}</label></td>
			                <td></td>
			            </tr>   
			            
			            <tr class="info">
			                <td><label>Price</label></td>
			                <td><label>${result.price}</label></td>
			                <td></td>
			            </tr>
			            
			            <tr class="info">
			                <td><label>Transaction Date</label></td>
			                <td><label>${result.transactionTime}</label></td>
			                <td></td>
			            </tr>


		            
		             <tr >
		                <td><label>Book Title</label></td>
		                <td><label>${result.book.title}</label></td>
		                <td></td>
		                
		            </tr>  
		            
		             <tr>
		                <td><label>Seller Id</label></td>
		                <td><label>${result.book.userId.userId}</label></td>
		                <td></td>
		                
		            </tr>   
		            
		            <tr>
		                <td><label>Price</label></td>
		                <td><label>${result.price}</label></td>
		                <td></td>
		                
		            </tr>

			            
			            <tr class="info">
			                <td colspan="2" align="right">
			                	<a class="btn btn-primary" href="${pageContext.request.contextPath}/feedback/seller/${result.transactionId}" role="button">Feedback</a>
			                </td>
			            </tr>

		            
					</c:forEach>
					
		        </table>
			</div>
		</div>
	
		<div class="table-responsive col-md-6">
			<div class="panel panel-primary">
				<div class="panel-heading">Purchases</div>
				
				<table class="table">		            
		            <c:forEach items="${strBuyer}" var="result">
		            


		           
		            <tr style="border-style: solid;">
		                <td><label>transaction request number</label></td>
		                <td><label>${result.transactionId}</label></td>
		                <td></td>
		                
		            </tr>
		            
		             <tr>
		                <td><label>Book Title</label></td>
		                <td><label>${result.book.title}</label></td>
		                <td></td>
		                
		            </tr>  
		            
		             <tr>
		                <td><label>Seller Id</label></td>
		                <td><label>${result.book.userId.userId}</label></td>
		                <td></td>
		                
		            </tr>   
		            
		            <tr>
		                <td><label>Price</label></td>
		                <td><label>${result.price}</label></td>
		                <td></td>
		                
		            </tr>


			            <tr class="active">
			                <td><label>Transaction Number</label></td>
			                <td><label>${result.transactionId}</label></td>
			                <td></td>
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
			                <td><label>Transaction Date</label></td>
			                <td><label>${result.transactionTime}</label></td>
			                <td></td>		                
			            </tr>

			            
		                <td colspan="2" align="right">
		                	<a class="btn btn-primary" href="${pageContext.request.contextPath}/feedback/buyer/${result.transactionId}" role="button">Feedback</a>
		                </td>

		            
					</c:forEach>
		        </table>
			</div>
		</div>
	</div>
</body>
</html>