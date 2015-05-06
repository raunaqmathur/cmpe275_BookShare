<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>BookShare</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
	<!-- Custom styles for this template -->
    <link rel="stylesheet" href="http://getbootstrap.com/examples/signin/signin.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<style>
		.carousel-inner > .item > img,
		.carousel-inner > .item > a > img {
			width: 15%;
			margin: auto;
		}
	</style>
</head>

<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
  <div class="navbar-header">
      <a class="navbar-brand" href="#">
        <img style="max-width:50px; margin-top: -15px;" alt="Brand" src="http://blindlibrary.utah.gov/images/logoBook.gif">
      </a>
    </div>
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">BookShare</a>
    </div>
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      
      <ul class="nav navbar-nav">
      </ul>
      
      <ul class="nav navbar-nav navbar-right">
      <li><a href="#">Advance Search</a></li>
        <li><a href="#">Buy</a></li>
        <li><a href="#">Sell</a></li>
        <li><a href="userhome">Login/Register</a></li>
      </ul>
      
      <form class="navbar-form navbar-right" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search by ISBN">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->

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
</nav>

<div class="container">
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
</div>
</c:forEach>
</body>
</html>