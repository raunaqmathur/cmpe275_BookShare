<%@    taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="navbar.jsp" />
<html>
<head>
	<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>
  
	<style type="text/css">
	div#map_container{
		width:550px;
		height:350px;
	}
	</style> 
	<script>
		$(document).ready(function(){
	 		var geocoder = new google.maps.Geocoder();
			var address = document.getElementById('address').value;
    		geocoder.geocode( { 'address': address}, function(results, status) {
      		if (status == google.maps.GeocoderStatus.OK) {
    	  		var res = String(results[0].geometry.location).split(",");
	    	    res[0] = res[0].replace("(","").trim();
	    	    res[1] = res[1].replace(")","").trim();
	    	   
	    	    var latlng = new google.maps.LatLng(res[0], res[1]);
	    	    var myOptions = {
	    	      zoom: 15,
	    	      center: latlng,
	    	      mapTypeId: google.maps.MapTypeId.ROADMAP
	    	    };
	    	    var map = new google.maps.Map(document.getElementById("map_container"),myOptions);
    	 
	    	    var marker = new google.maps.Marker({
	    	      position: latlng, 
	    	      map: map, 
	    	      title:address
	    	    }); 
      		
      		} else {
    	  
		    	var latlng = new google.maps.LatLng(37.3357192, -121.8867076);
		  	    var myOptions = {
		  	      zoom: 15,
		  	      center: latlng,
		  	      mapTypeId: google.maps.MapTypeId.ROADMAP
		  	    };
		  	    var map = new google.maps.Map(document.getElementById("map_container"),myOptions);
		  	 
		  	    var marker = new google.maps.Marker({
		  	      position: latlng, 
		  	      map: map, 
		  	      title:address
		  	    }); 
    	  	}
      
        	});    
		});


		function RedirectToEdit() {
			var x = document.getElementById('bookId').value;
			if(document.getElementById('redirectTo').value == '')
				window.location = "../bookhome/" + x;
			else
				window.location = document.getElementById('redirectTo').value + "/" + x;
	
		}
	
		function RedirectToBuy() {
			var x = document.getElementById('bookId').value;
			if(document.getElementById('redirectToBuy').value == '')
				window.location = "../purchase/" + x;
			else
				window.location = document.getElementById('redirectToBuy').value + "/" + x;
		}	
	
	</script>
</head>

<body>
	<div class="container-fluid">
		<div class="table-responsive col-md-6">
			<div class="panel panel-primary">
				<div class="panel-heading">Book Details</div>
				<table class="table">					
					<tr class="active">
					    <td colspan="3">
					  		<img src="${bookdetails.pictureId}" alt="http://images.clipartpanda.com/books-20clipart-books-for-clip-art-9.jpg" height="100" width="100">
					    </td>
					</tr>
					
					<tr class="info">
					    <td><label>Title</label></td>
					    <td><label>${bookdetails.title}</label>
						<input type="hidden" id="bookId" value="${bookdetails.bookId}"></input>
						<input type="hidden" id="redirectTo" value="${redirectTo}"></input>
						<input type="hidden" id="redirectToBuy" value="${redirectToBuy}"></input>
						<input type="hidden" id="owner" value="${owner}"></input></td>
					    <td></td>
					</tr>
					
					<tr class="info">
					    <td><label>Author</label></td>
					    <td><label>${bookdetails.author}</label></td>
					    <td></td>
					</tr>
					
					<tr class="info">
					    <td><label>ISBN</label></td>
					    <td><label>${bookdetails.isbn}</label></td>
					    <td></td>
					</tr>
					
					<tr class="info">
					    <td><label>Description</label></td>
					    <td><label>${bookdetails.description}</label></td>
					    <td></td>
					</tr>
					 
					<tr class="info">
					    <td><label>Price</label></td>
					    <td><label>${bookdetails.price}</label></td>
					    <td></td>
					</tr>
					
					<tr class="info">
					    <td><label>Condition</label></td>
					    <td><label>${bookdetails.condition}</label></td>
					    <td></td>
					    
					</tr>
					
					<tr class="info">
					    <td><label>Keywords</label></td>
					    <td><label>${bookdetails.keywords}</label></td>
					    <td></td>
					</tr>
					
					<tr class="info">
					    <td><label>Category</label></td>
					    <td><label id="cati">${catId}</label></td>
					    <td></td>
					</tr>
					
					<tr class="info">
					    <td><label>Uploader</label></td>
					    <% if(null == session.getAttribute("USERID")){ %>
					    	<td><label>${bookdetails.getUserId().getName()}</label></td>
					    <% } else { %>
					    	<td><label><a href="${pageContext.request.contextPath}/showuser/${bookdetails.getUserId().getUserId()}" role="button">${bookdetails.getUserId().getName()}</a></label></td>
					    <% } %>
					    <td></td>
					</tr>
					
					<% if(null == session.getAttribute("USERID")){ %>
						    <td colspan="2" align="right"><a class="btn btn-primary" href="${pageContext.request.contextPath}/login" role="button">Log in to Buy</a>
						    
		            <% } else { %>
						<tr>
							<td colspan="2" align="right"><input type="submit" class="btn btn-md btn-primary" value="Buy" onClick="javascript: RedirectToBuy();" <c:if test="${owner == 'true'}"><c:out value="disabled='disabled'"/> </c:if> /></td>
							<td colspan="2" align="right"><input type="submit" class="btn btn-md btn-primary" id="edit" value="Edit" onClick="javascript: RedirectToEdit();" <c:if test="${owner == 'false'}"><c:out value="disabled='disabled'"/> </c:if> /></td>
						</tr>
					<% } %>
					
					<tr>
					    <td colspan="3" align="center"><font color="red"><form:errors /></font></td>
					</tr>
				</table>
			</div>
		</div>
	    	
		<div class="table-responsive col-md-6">
			<div class="panel panel-primary">
				<div class="panel-heading">Pickup Address</div>
				<table class="table table-striped">
					
		    		<tr>
					    <td><label>${bookdetails.pickupAddress}</label></td>
						<input type="hidden" id="address" value="${bookdetails.pickupAddress}"></input></td>
					</tr>
					
		    		<tr >
						<td><div id="map_container" align="center"></div></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>