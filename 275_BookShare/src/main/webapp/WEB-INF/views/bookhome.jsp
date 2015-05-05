<%@    taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>CMPE 275 BOOK SHARE</title>
<script>

function checkCat()
{
	if(document.getElementById("categoryX").value == '')
		document.getElementById("errorCat").value = "Category can't be left blank";
	
	
}

</script>


</head>
<body>
    <form:form id="bookhome" action="${path}" method="post" 
        commandName="bookdetails">
        <table>
            <tr>
                <td colspan="3"><h3>Enter Book Details</h3></td>
            </tr>
            
            
            <tr>
                <td><label>Title</label></td>
                <td><form:input path="title"></form:input><form:input type="hidden" path="bookId"></form:input><form:input type="hidden" path="status"></form:input></td>
                <td><font color="red"><form:errors path="title"></form:errors></font></td>
            </tr>
           
            <tr>
                <td><label>Author</label></td>
                <td><form:input path="author" ></form:input></td>
                <td><font color="red"><form:errors path="author"></form:errors></font></td>
                
            </tr>
            
             <tr>
                <td><label>ISBN</label></td>
                <td><form:input path="isbn" ></form:input></td>
                <td><font color="red"><form:errors path="isbn"></form:errors></font></td>
                
            </tr>
             <tr>
                <td><label>Description</label></td>
                <td><form:input path="description" ></form:input></td>
                 <td><font color="red"><form:errors path="description"></form:errors></font></td>
                
            </tr>
             <tr>
                <td><label>Picture</label></td>
                <td><form:input path="pictureId" ></form:input></td>
                <td></td>
                
            </tr>
             <tr>
                <td><label>Price</label></td>
                <td><form:input path="price"></form:input></td>
                <td><font color="red"><form:errors path="price"></form:errors></font></td>
            </tr>
            <tr>
                <td><label>Condition</label></td>
                <td><form:input path="condition" ></form:input></td>
                <td><font color="red"><form:errors path="condition"></form:errors></font></td>
                
            </tr>
             <tr>
                <td><label>Keywords</label></td>
                <td><form:input path="keywords" ></form:input></td>
                 <td><font color="red"><form:errors path="keywords"></form:errors></font></td>
                
            </tr>
            <tr>
                <td><label>Category</label></td>
                <td><input type="text" name="categoryX" id="categoryX" value="${categ}"></input></td>
                <td><font color="red"><label id="errorCat"></label></font></td>
                
            </tr>
           <tr>
                <td><label>Pickup Address</label></td>
                <td><form:input path="pickupAddress" ></form:input></td>
                <td><font color="red"><form:errors path="pickupAddress"></form:errors></font></td>
                
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit"
                    value="${buttonX}" onClick="javascript: checkCat();" /></td>
                <td></td>
            </tr>
            <tr>
                <td colspan="3" align="center"><font color="red"><form:errors /></font></td>
            </tr>
        </table>
    </form:form>
</body>
</html>