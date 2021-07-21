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
		#idCheakArea{
			height: 60px;
			position: relative;
		}
		#idCheck{
			position: absolute;
			top: 70%;
			margin: 0;
			transform: translate(0, -70%);
			left: 5px;
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
                        <h1 class="mt-4">New Movie</h1>
                        <div class="container" style="font-family: 'GmarketSansMedium';">
                        
                        <div class="row justify-content-center">
                            <div class="col-lg-9">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="card-header bg-dark">
                                 	<h6 class="m-0 text-white" >영화 정보</h6>
                                	</div>
                                    
                                    <div class="card-body">
                                    
                                   
                                        <form action="${pageContext.request.contextPath}/movies/new" method="post" enctype="multipart/form-data" >
                                        	<div class="form-floating mb-3">
                                               	 <input class="form-control" id="addMvTitle" name="title" type="text" placeholder="영화제목" />
                                               	 <label for="addMvTitle">영화제목</label>
                                               	 </div>
                                               	 
                                            <div class="row mb-3">
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" id="addMvDirector" name="director" type="text" placeholder="감독" />
                                                        <label for="addMvDirector">감독</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" id="addMvGenre" name="genre" type="text" placeholder="장르" />
                                                        <label for="addMvGenre">장르</label>
                                                    </div>
                                                </div>
                                            </div>
                                            
                                               <div class="row mb-3">
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" id="addMvDate" name="date" type="date" placeholder="개봉일" />
                                                        <label for="addMvDate">개봉일</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                    <div class="form-control">
                                                        <input type="radio" id="addMvGrade" name="grade" value="0" checked="checked">
                                                        <label class="small" for="addMvGrade">전체관람가</label>
                                                        <input type="radio" id="addMvGrade" name="grade" value="12" checked="checked">
                                                        <label class="small" for="addMvGrade">12세 이상</label>
                                                        <input type="radio" id="addMvGrade" name="grade" value="15" checked="checked">
                                                        <label class="small" for="addMvGrade">15세 이상</label>
                                                        <input type="radio" id="addMvGrade" name="grade" value="18" checked="checked">
                                                        <label class="small" for="addMvGrade">청소년관람불가</label>
                                                    </div>
                                                    </div>
                                                </div>
                                               
                                            </div>
                                          
                                            <div class="form-floating mb-3">
                                                <input class="form-control" id="addMvPoster" name="mvfile" type="file" placeholder="영화 포스터" />
                                                <label for="inputEmail">영화 포스터</label>
                                            </div>
                                            <div class="mt-4 mb-0">
                                                <div class="d-grid"><button class="btn btn-primary btn-block" style="font-family: 'GmarketSansMedium';">영화등록</button></div>
                                            </div>
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
        <script src="${pageContext.request.contextPath}/js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="${pageContext.request.contextPath}/assets/demo/chart-area-demo.js"></script>
        <script src="${pageContext.request.contextPath}/assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="${pageContext.request.contextPath}/js/datatables-simple-demo.js"></script>
    </body>
    <script>
   
    </script>
</html>
