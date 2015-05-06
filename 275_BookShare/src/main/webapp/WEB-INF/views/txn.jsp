<%@    taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>CMPE 275 BOOK SHARE</title>
<script>

function RedirectToTransactions()
{
	//alert('' + document.getElementById('redirectToTransac').value);
	
	if(document.getElementById('redirectToTransac').value == '')
					window.location = "../transactions";
	else
		window.location = document.getElementById('redirectToTransac').value;

}

</script>

</head>

<table>

        
            <tr>
                <td colspan="3"><h3>Your Purchase transaction: </h3><br/></td>
                
                
                
            </tr>
            
            
            
           
            <tr>
                <td><label>transaction request number</label></td>
                <td><label>${result.transactionId}</label></td>
                <td><input type="hidden" id="redirectToTransac" value="${redirectToTransac}"></input></td>
                
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
            
            <tr>
                <td><label>transaction date</label></td>
                <td><label>${result.transactionTime}</label></td>
                <td><input type="submit"
                    value="View All Transactions" onClick="javascript: RedirectToTransactions();" /> </td>
                
            </tr>
             
        </table>
    
   
</body>
</html>