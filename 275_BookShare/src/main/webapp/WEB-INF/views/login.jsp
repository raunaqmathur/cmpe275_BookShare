<%@    taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>CMPE 275 BOOK SHARE</title>
</head>
<body>
    <form:form id="login" action="login" method="post"
        commandName="logindetails">
        <table>
            <tr>
                <td colspan="3"><h3>Enter UserID and password</h3></td>
            </tr>
            
            <tr>
                <td><label>User Id</label></td>
                <td><form:input path="userId" ></form:input></td>
                <td><font color="red"><form:errors path="userId"></form:errors></font></td>
            </tr>
             <tr>
                <td><label>Password</label></td>
                <td><form:input path="password" ></form:input></td>
                <td><font color="red"><form:errors path="password"></form:errors></font></td>
            </tr>
             <tr>
                <td colspan="3"><font color="red"><label>${msg}</label></font></td>
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