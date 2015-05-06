<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="navbar.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>
	  <div id="myCarousel" class="carousel slide" data-ride="carousel">
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

<div class="container" style="margin-top:15px">  
<c:forEach items="${pagedetails.books}" var="result" varStatus="status" step="6"> 
          
  <!-- Projects Row -->
        <div class="row">
            <div class="col-md-2 portfolio-item">
                <a href="#">
                    <img class="img-responsive" src="${pagedetails.books[status.index].pictureId}" width="300" height="200">
                </a>
                <h4>
                    <a href="#">${pagedetails.books[status.index].title}</a>
                </h4>
                <p>${pagedetails.books[status.index].description}</p>
            </div>

            <div class="col-md-2 portfolio-item">
                <a href="#">
                    <img class="img-responsive" src="${pagedetails.books[status.index+1].pictureId}" width="300" height="200">
                </a>
                <h4>
                    <a href="#">${pagedetails.books[status.index+1].title}</a>
                </h4>
                <p>${pagedetails.books[status.index+1].description}</p>
            </div>

            <div class="col-md-2 portfolio-item">
                <a href="#">
                    <img class="img-responsive" src="${pagedetails.books[status.index+2].pictureId}" width="300" height="200">
                </a>
                <h4>
                    <a href="#">${pagedetails.books[status.index+2].title}</a>
                </h4>
                <p>${pagedetails.books[status.index+2].description}</p>
            </div>

            <div class="col-md-2 portfolio-item">
                <a href="#">
                    <img class="img-responsive" src="${pagedetails.books[status.index+3].pictureId}" width="300" height="200">
                </a>
                <h4>
                    <a href="#">${pagedetails.books[status.index+3].title}</a>
                </h4>
                <p>${pagedetails.books[status.index+3].description}</p>
            </div>

            <div class="col-md-2 portfolio-item">
                <a href="#">
                    <img class="img-responsive" src="${pagedetails.books[status.index+4].pictureId}" width="300" height="200">
                </a>
                <h4>
                    <a href="#">${pagedetails.books[status.index+4].title}</a>
                </h4>
                <p>${pagedetails.books[status.index+4].description}</p>
            </div>

            <div class="col-md-2 portfolio-item">
                <a href="#">
                    <img class="img-responsive" src="${pagedetails.books[status.index+5].pictureId}" width="200" height="200">
                </a>
                <h4>
                    <a href="#">${pagedetails.books[status.index+5].title}</a>
                </h4>
                <p>${pagedetails.books[status.index+5].description}</p>
            </div>
            
        </div>
        <!-- /.row -->
</c:forEach>
</div>
</body>
</html>