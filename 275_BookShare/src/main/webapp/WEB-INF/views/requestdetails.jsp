<%@    taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>CMPE 275 BOOK SHARE</title>
</head>
<table>

        
            <tr>
                <td colspan="3"><h3>Book Request</h3><br/><label>Request Id - ${RequestID},by UserId - ${UserId}</label></td>
                
                
                
            </tr>
            
            <c:forEach items="${str}" var="result">
            
  
            
             <tr>
                <td><label>Message</label></td>
                <td><label>${result.message}</label></td>
                <td></td>
                
            </tr>   
            
            <tr>
                <td><label>Time</label></td>
                <td><label>${result.requestBookTime}</label></td>
                <td></td>
                
            </tr>
            
            
             </c:forEach>
        </table>
    
   
</body>
</html>