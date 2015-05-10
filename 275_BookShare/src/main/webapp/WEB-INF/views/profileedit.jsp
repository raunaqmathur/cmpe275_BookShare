<%@    taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="navbar.jsp" />
<html>
  
<body>
    <form:form id="userhome" action="${path}" method="post" commandName="userdetails">
        <table align="center">
            <tr>
                <td colspan="3"><h3>Please enter your details</h3></td>
            </tr>
            
            <tr>
                <td><label>Name</label></td>
                <td><form:input path="name" type="text"></form:input>
                <form:input path="userId" type="hidden" name="userId"></form:input></td>
                <td><font color="red"><form:errors path="name" required="true"></form:errors></font></td>
            </tr>
            
            <tr>
                <td><label>Age</label></td>
                <td><form:input path="age" type="number" required="true"></form:input></td>
               
            </tr>
           
            <tr>
                <td><label>Email</label></td>
                <td><form:input type="email" path="emailId" ></form:input></td>
                <td><font color="red"><form:errors path="emailId" required="true" disabled="disabled"></form:errors></font></td>
                <td><label>${msg}</label></td>
                
            </tr>
             <tr>
                <td><label>Phone Number</label></td>
                <td><form:input type="number" path="phone" required="true"></form:input></td>
                
            </tr>
            <tr>
                <td><label>Address</label></td>
                <td><form:input path="address" required="true"></form:input></td>
                
            </tr>
            
           <tr>
                <td><label>Password</label></td>

                <td><form:input type="password" path="password" required="true" ></form:input></td>

            <tr>
                <td colspan="2" align="center"><button class="btn btn-sm btn-primary btn-block" type="submit">Update</button></td>
                <td></td>
            </tr>
            <tr>
                <td colspan="3" align="center"><font color="red"><form:errors /></font></td>
            </tr>
        </table>
    </form:form>
</body>
</html>
