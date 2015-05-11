<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="navbar.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>
	  <div id="myCarousel" class="carousel slide" data-ride="carousel" data-interval="2000">
	      <!-- Indicators -->
	      <ol class="carousel-indicators">
	        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
	        <li data-target="#myCarousel" data-slide-to="1"></li>
	        <li data-target="#myCarousel" data-slide-to="2"></li>
	      </ol>
	      
	      <!-- Wrapper for slides -->
	      <div class="carousel-inner" role="listbox">
	        <div class="item active">
	          <img src="http://ecx.images-amazon.com/images/I/41wgksZup2L.jpg" alt="First slide" width="460" height="345">
	          <div class="container">
	            <div class="carousel-caption">
	              <p><a class="btn btn-sm btn-primary" href="#" role="button">Buy Now</a></p>
	            </div>
	          </div>
	        </div>
	        
	        <div class="item">
	          <img class="second-slide" src="http://i.imgur.com/7lnka2Z.jpg" alt="Second slide">
	          <div class="container">
	            <div class="carousel-caption">
	              <p><a class="btn btn-sm btn-primary" href="#" role="button">Buy Now</a></p>
	            </div>
	          </div>
	        </div>
	
	        <div class="item">
	          <img class="third-slide" src="http://ecx.images-amazon.com/images/I/41loDlWPAnL.jpg" alt="Third slide">
	          <div class="container">
	            <div class="carousel-caption">
					<p><a class="btn btn-sm btn-primary" href="#" role="button">Buy Now</a></p>
	            </div>
	          </div>
	        </div>
	      </div>
	
	      <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
	        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
	        <span class="sr-only">Previous</span>
	      </a>
	
	      <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
	        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
	        <span class="sr-only">Next</span>
	      </a>
	    </div><!-- /.carousel -->

	<div class="container-fluid" style="margin-top:15px">  
		<div class="row">
			<c:forEach items="${pagedetails.books}" var="result">
				<c:if test="${result.getStatus() != 'Sold'}">
					<div class="col-md-2">
						<a href="${pageContext.request.contextPath}/showbook/${result.bookId}">
							<img class="img-thumbnail" src="${result.pictureId}" width="300" height="200">
						</a>
						<h4>
					    	<a href="#">${result.title}</a>
						</h4>
						<p>Price: $${result.getPrice()}</p>
					</div>
				</c:if>
			</c:forEach>
		</div>
	</div>
</body>
</html>