<%@    taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="navbar.jsp" />
<html>
<table>
<body>
	<div class="container">
	<div class="table-responsive col-md-3">
	<table>
		<tr>
			<td>
				<table class="table table-striped" align="center">
		        
		            <tr>
		                <td colspan="3"><h3>Your Purchase transaction: </h3><br/></td>
		                
		                
		                
		            </tr>
		            
		            <c:forEach items="${str}" var="result">
		            
		           
		            <tr  style="border-style: solid;">
		                <td><label>transaction request number</label></td>
		                <td><label>${result.transactionId}</label></td>
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
		            
		            <tr>
		                <td><label>transaction date</label></td>
		                <td><label>${result.transactionTime}</label></td>
		                <td></td>
		                
		            </tr>
		             </c:forEach>
		        </table>
		        </td>
		        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		        <td>
		        <table class="table table-striped" align="center">
		        
		            <tr>
		                <td colspan="3"><h3>Your Selling transaction: </h3><br/></td>
		                
		                
		                
		            </tr>
		            
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
		            
		            <tr >
		                <td><label>transaction date</label></td>
		                <td><label>${result.transactionTime}</label></td>
		                <td></td>		                
		            </tr>
		             </c:forEach>
		        </table>
		       </td>
		      </tr>
		    </table>
    </div>
   </div>
</body>
</html>