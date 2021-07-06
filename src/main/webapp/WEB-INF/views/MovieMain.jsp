<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>MJ Movie</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/resources/css/styles.css" rel="stylesheet" />
        <link href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@700&display=swap" rel="stylesheet">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
   		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"
		integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ=="
		crossorigin="anonymous"></script>
   		<style>
   		@font-face {
   			font-family: 'GmarketSansMedium';
    		src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/GmarketSansMedium.woff') format('woff');
    		font-weight: normal;
    		font-style: normal;
		}
   		</style>
    </head>
    <body class="sb-nav-fixed">
        
         <%@ include file = "Include/TopBar.jsp" %>
        
        <div id="layoutSidenav">
             
             <%@ include file = "Include/SideBar.jsp" %>
             
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">MOVIE :)</h1>
                       
                        <ol class="breadcrumb mb-4">
                        	<c:choose>
                        		<c:when test="${sessionScope.loginMember != null }">
                        			<li class="breadcrumb-item active" style="font-family: 'GmarketSansMedium';">MJ Movie에 오신걸 환영합니다! <span>${sessionScope.loginMember }</span>님 :)</li>
                        		</c:when>
                        		<c:otherwise>
                            		<li class="breadcrumb-item active" style="font-family: 'GmarketSansMedium';">Welcome to MJ Movie :)</li>
                        		</c:otherwise>
                        	</c:choose>
                        </ol>
                        <div class="row" style="font-family: 'GmarketSansMedium';" id="mainMovieArea">
                 		
                 		
                         
                     
                        </div>
                       
                        
                    </div>
                </main>
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted" href="./">Copyright &copy; MJ Movie </div>
                       
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="${pageContext.request.contextPath}/js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="${pageContext.request.contextPath}/assets/demo/chart-area-demo.js"></script>
        <script src="${pageContext.request.contextPath}/assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="${pageContext.request.contextPath}/js/datatables-simple-demo.js"></script>
    </body>
    <script>
    $(document).ready(function(){
    	console.log("main");
    	var output = "";
    	
    	$.ajax({
    		type : "get",
    		url : "${pageContext.request.contextPath}/Movies/movieMain",
    		dataType : 'json',
    		async : false,
    		success : function(movie){
    			console.log(movie);
    			
    			for(var i=0; i<4; i++){
    				output += "<div class='col-xl-3 col-md-6 mb-4'>";
    				output += "<div class='card shadow h-100 py-2' style='border-left: 0.3em solid black;'>";
    				output += "<div class='card-body'>";
    				output += "<div class='row no-gutters align-items-center'>";
    				
    				output += "<a href='${pageContext.request.contextPath}/Movies/movieInfo?mvCode="+movie[i].mvcode+"'>";
    				output += "<img src='${pageContext.request.contextPath}/img/mvPoster/"+movie[i].mvposter+"' style='width:100%;'></a>";
    				output += "<div class='col mr-2'>";
    				output += "<div class='small text-primary text-uppercase mb-1' style='padding-top:5px;'>";
    				output += "<span>"+movie[i].mvredate+"</span></div>";
    				output += "<div class='h5 mb-0 font-weight-bold text-gray-800'>";
    				output += "<span>"+movie[i].mvtitle+"</span></div>";
    				output += "</div>";
    				output += "<div>";
    				output += "<button class='btn btn-primary btn-block' onclick='moveReservation(\""+movie[i].mvcode+"\")'>예매하기</button>";
    				output += "</div></div></div></div></div>";
    			}$("#mainMovieArea").html(output);
    		}
    		
    	});
    });
    
    function moveReservation(mv_code){
    	location.href="${pageContext.request.contextPath}/Movies/MovieReservation?mvCode="+mv_code+"";
    }
     
    </script>
</html>
