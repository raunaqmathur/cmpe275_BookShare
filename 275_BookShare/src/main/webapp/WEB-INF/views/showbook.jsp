<%@    taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>CMPE 275 BOOK SHARE</title>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.11.2.min.js"></script>

<script >


		$(document).ready(function(){
		    if(document.getElementById('active').value == 0)
				document.getElementById('activeX').checked = true;
		    else
		    	document.getElementById('activeX').checked = false;
			
			
		});



	function RedirectToEdit()
	{
		alert('' + document.getElementById('redirectTo').value);
		var x = document.getElementById('bookId').value;
		if(document.getElementById('redirectTo').value == '')
						window.location = "../bookhome/" + x;
		else
			window.location = document.getElementById('redirectTo').value + "/" + x;

	}

	
	/*function changePic()
	{
		//var myWindow = window.open("", "Upload Image", "toolbar=yes, scrollbars=no, resizable=no, top=300, left=500,width=500, height=500");
		//myWindow.document.write("<script>uploadImage <//script><p>Please upload an Image: <br/> <input type='file' /> <br/> <input type='submit' value='Upload' onClick='javascript: uploadImage();'> </p>")
		
		
		
			var imgDiv = document.getElementById('imgUpload');
			
			var x = document.createElement("INPUT");
		    
		    x.setAttribute("type", "file");
		    
		    var y = document.createElement("INPUT");
		    y.setAttribute("type", "submit");
		    y.setAttribute("value", "Upload");
		    
		    
		    
		    imgDiv.appendChild(x);
		    imgDiv.appendChild(y);
		    
		
		
		
		
	}*/
	
	
</script>

</head>
<body>
    
        <table>
            <tr>
                <td colspan="3"><h3>Book Details</h3></td>
            </tr>
            <tr>
                <td colspan="3"><img src="${bookdetails.pictureId}" alt="Smiley face" height="100" width="100" onClick="javascript: changePic();">
                <!--  <form id="bookhomeUpdate" action="../uploadImage" method="POST" >
                 <div id="imgUpload">
                  </div></form> --></td>
                
            </tr>
            
            <tr>
                <td><label>Title</label></td>
                <td><label>${bookdetails.title}</label>
                <input type="hidden" id="bookId" value="${bookdetails.bookId}"></input>
                <input type="hidden" id="redirectTo" value="${redirectTo}"></input></td>
                <td></td>
            </tr>
           
            <tr>
                <td><label>Author</label></td>
                <td><label >${bookdetails.author}</label></td>
                <td></td>
                
            </tr>
            
             <tr>
                <td><label>ISBN</label></td>
                <td><label>${bookdetails.isbn}</label></td>
                <td></td>
                
            </tr>
             <tr>
                <td><label>Description</label></td>
                <td><label>${bookdetails.description}</label></td>
                <td></td>
                
            </tr>
             
             <tr>
                <td><label>Price</label></td>
                <td><label>${bookdetails.price}</label></td>
                <td></td>
            </tr>
            <tr>
                <td><label>Condition</label></td>
                <td><label>${bookdetails.condition}</label></td>
                <td></td>
                
            </tr>
             <tr>
                <td><label>Keywords</label></td>
                <td><label>${bookdetails.keywords}</label></td>
                <td></td>
                
            </tr>
            <tr>
                <td><label>Category</label></td>
                <td><label id="cati">${catId}</label></td>
                <td></td>
                
            </tr>
            <tr>
                <td><label>Picture link</label></td>
                <td><label>${bookdetails.pictureId}</label>
                </td>
                <td></td>
            </tr>
           <tr>
                <td><label>Pickup Address</label></td>
                <td><label>${bookdetails.pickupAddress}</label></td>
                <td></td>
                
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit"
                    value="Edit" onClick="javascript: RedirectToEdit();" /></td>
                <td></td>
            </tr>
            <tr>
                <td colspan="3" align="center"><font color="red"><form:errors /></font></td>
            </tr>
        </table>
    
</body>
</html>