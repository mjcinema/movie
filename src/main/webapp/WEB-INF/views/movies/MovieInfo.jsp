<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		.show-hide{
		  display:none;
		}
   		</style>
    </head>
    <body class="sb-nav-fixed">
        
         <%@ include file = "../include/TopBar.jsp" %>
        
        <div id="layoutSidenav">
             
             <%@ include file = "../include/SideBar.jsp" %>
             
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                       
                     <div class="container" style="font-family: 'GmarketSansMedium';">
                        <div class="row justify-content-center">
                        	
                        	<div class="col-lg-3">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                     <div class="card-header bg-primary">
                                 		 	  <h6 class="m-0 text-white" > 영화포스터</h6>
                                		  </div>
                                    
                                    <div class="card-body" style="text-align:center;">
                                    	<div class="form-floating mb-3">
                                        			 <img style="height: 220px; width: 160px; "
                                    					src="${pageContext.request.contextPath}/resources/img/mvPoster/${movie.filename}">
                                        </div>
                        			</div>
                        	</div>
                        	</div>
                        	
                        	
                            <div class="col-lg-7">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="card-header bg-primary">
                                 		 	  <h6 class="m-0 text-white" > 영화정보</h6>
                                		  </div>
                                    
                                    <div class="card-body">
                                    
                                    
                                        <form method="post" action="/movies/${movie.title}/edit" id="editForm">
                                        	<div class="form-floating mb-3">
                                        		<span class="small">영화제목</span>
                                               <input class="form-control" type="text" style="height:40px; line-height: 55px;"  value="${movie.title}" name="title"  />
                                            </div>
                                        	<div class="row mb-6" >
                                        		 <div class="col-md-6" >
                                            		<div class="form-floating mb-3">
                                            		<span class="small">영화장르</span>
                                               		 <input class="form-control" style="height:40px;" type="text"  value="${movie.genre}" name="genre" />
                                               	 	</div>
                                               	 </div>
                                               	 <div class="col-md-6">
                                               	 	<div class="form-floating mb-3">
                                               	 	<span class="small">영화감독</span>
                                               	 	<input class="form-control" style="height:40px;" type="text" value="${movie.director}" name="director"  />
                                               		 </div>
                                        		</div>
                                            </div>	
                                            	
                                            <div class="row mb-3">
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                    <span class="small">관람등급</span>
                                                        <input class="form-control" style="height:40px;" type="text" value="${movie.grade}" name="grade" />
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                    <span class="small">개봉일</span>
                                                        <input class="form-control" style="height:40px;" type="text" value="${movie.date}"  name="date" />
                                                    </div>
                                                </div>

                                            </div>
                                            <div class="col-md-2">
                                                <button class="btn btn-primary btn-block" type="button" id="title" onclick="document.querySelector('#deleteForm').submit()">삭제</button>

                                            </div><br>
                                            <div class="col-md-2">
                                                <button class="btn btn-primary btn-block" type="button" id="movieTitle" onclick="document.querySelector('#editForm').submit()">수정</button>

                                            </div>

                                          
                                        </form>
                                        <form method="post" action="/movies/${movie.title}/delete" id="deleteForm" style="visibility: hidden;">
                                            <input type="submit" value="submit">
                                        </form>




                                    </div>
                                    
                                </div>
                            </div>
                    </div>
                    </div>
                        
                    </div>
                </main>
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; 0joo's Movie </div>
                       
                        </div>
                    </div>
                </footer>
            </div>
        </div>
         <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
         <script src="${pageContext.request.contextPath}/resources/js/scripts.js"></script>
         <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
         <script src="${pageContext.request.contextPath}/resources/assets/demo/chart-area-demo.js"></script>
         <script src="${pageContext.request.contextPath}/resources/assets/demo/chart-bar-demo.js"></script>
         <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
         <script src="${pageContext.request.contextPath}/resources/js/datatables-simple-demo.js"></script>
    </body>
    <script>
   
    </script>
</html>
