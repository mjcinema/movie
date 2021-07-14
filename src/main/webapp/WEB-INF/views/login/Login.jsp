<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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

         <%@ include file = "../include/TopBar.jsp" %>
         
        
        <div id="layoutSidenav">
             
             <%@ include file = "../include/SideBar.jsp" %>
             
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Login</h1>
                        
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active">Nice to meet you. Please login :)</li>
                        </ol>
                        <div class="row justify-content-center">
                            <div class="col-lg-5">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="card-header"><h3 class="text-center font-weight-light my-4 mt-4">로그인하라우!</h3></div>
                                    
                                    <div class="card-body" style="font-family: 'GmarketSansMedium';">
                                        <form action="${pageContext.request.contextPath}/login" method="post" onsubmit="return loginCheck()">
                                            <div class="form-floating mb-3">
                                                <input class="form-control" id="username" name="username" type="text"/>
                                                <label for="username" id="idLabel">아이디 입력</label>
                                            </div>
                                            <div class="form-floating mb-3">
                                                <input class="form-control" id="password" name="password" type="password" />
                                                <label for="password" id="pwLabel">비밀번호 입력</label>
                                                
                                            </div>
                                            <spring:hasBindErrors name="loginForm">
												<c:if test="${errors.hasFieldErrors('invalidIdOrPassword')}">                                     
													<strong>${errors.getFieldError('invalidIdOrPassword').defaultMessage }</strong>
												 </c:if>
											</spring:hasBindErrors>
                                            <div class="d-flex align-items-center justify-content-between mt-4 mb-0">
                                                <a class="small" href="#">Forgot Password?</a>
                                                <button class="btn btn-primary" style="font-family: 'GmarketSansMedium';" >로그인</button>
                                            </div>
                                        </form>
                                    </div>
                                    <div class="card-footer text-center py-3">
                                        <div class="small"><a href="/register">아직 회원이 아니쥬?</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                    </div>
                </main>
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                         <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted" href="/">Copyright &copy; MJ Movie </div>
                       
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
    	function loginCheck(){
    		var id = $("#username").val();
    		var pw = $("#password").val();
    		if(id == ""){
    			$("#idLabel").css("color","red").text("아이디를 입력해 주세요");
    			return false;
    		}else if(pw == ""){
    			$("#pwLabel").css("color","red").text("비밀번호를 입력해 주세요");
    			return false;
    		}else{
    			return true;
    		}
    	}
    </script>
</html>
