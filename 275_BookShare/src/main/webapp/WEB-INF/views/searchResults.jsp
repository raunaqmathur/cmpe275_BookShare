<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="navbar.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>
<div class="container" style="margin-top:15px">  
<c:forEach items="${pagedetails}" var="result" varStatus="status" step="3"> 
          
  <!-- Projects Row -->
        <div class="row">
            <div class="col-md-3 portfolio-item">
                <a href="${pageContext.request.contextPath}/showbook/${pagedetails[status.index].bookId}">
                    <img class="img-responsive" src="${pagedetails[status.index].pictureId}" width="300" height="200">
                </a>
                <h4>
                    <a href="#">${pagedetails[status.index].title}</a>
                </h4>
                <p>${pagedetails[status.index].description}</p>
            </div>

            <div class="col-md-3 portfolio-item">
                <a href="${pageContext.request.contextPath}/showbook/${pagedetails[status.index+1].bookId}">
                    <img class="img-responsive" src="${pagedetails[status.index+1].pictureId}" width="300" height="200">
                </a>
                <h4>
                    <a href="#">${pagedetails[status.index+1].title}</a>
                </h4>
                <p>${pagedetails[status.index+1].description}</p>
            </div>

            <div class="col-md-3 portfolio-item">
                <a href="${pageContext.request.contextPath}/showbook/${pagedetails[status.index+2].bookId}">
                    <img class="img-responsive" src="${pagedetails[status.index+2].pictureId}" width="300" height="200">
                </a>
                <h4>
                    <a href="#">${pagedetails[status.index+2].title}</a>
                </h4>
                <p>${pagedetails[status.index+2].description}</p>
            </div>
            
            <div class="col-md-3 portfolio-item">
                <a href="${pageContext.request.contextPath}/showbook/${pagedetails[status.index+3].bookId}">
                    <img class="img-responsive" src="${pagedetails[status.index+3].pictureId}" width="300" height="200">
                </a>
                <h4>
                    <a href="#">${pagedetails[status.index+3].title}</a>
                </h4>
                <p>${pagedetails[status.index+3].description}</p>
            </div>
            
        </div>
        <!-- /.row -->
</c:forEach>
</div>
</body>
</html>