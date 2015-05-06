<%@    taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>CMPE 275 BOOK SHARE</title>
</head>
<body>
    <form:form id="userhome" action="userhome" method="post"
        commandName="userdetails">
        <table>
            <tr>
                <td colspan="3"><h3>Sign up Here</h3></td>
            </tr>
            
            <tr>
                <td><label>Name</label></td>
                <td><form:input path="name" type="text"></form:input></td>
                <td><font color="red"><form:errors path="name" required="true"></form:errors></font></td>
            </tr>
            <tr>
                <td><label>Age</label></td>
                <td><form:input path="age" type="number" required="true"></form:input></td>
               
            </tr>
           
            <tr>
                <td><label>Email</label></td>
                <td><form:input type="email" path="emailId" ></form:input></td>
                <td><font color="red"><form:errors path="emailId" required="true"></form:errors></font></td>
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
                
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit"
                    value="Create" /></td>
                <td></td>
            </tr>
            <tr>
                <td colspan="3" align="center"><font color="red"><form:errors /></font></td>
            </tr>
        </table>
    </form:form>
</body>
</html>