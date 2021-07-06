<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
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
        
         <%@ include file = "../Include/TopBar.jsp" %>
        
        <div id="layoutSidenav">
             
             <%@ include file = "../Include/SideBar.jsp" %>
             
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Join</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active" style="font-family: 'GmarketSansMedium';">MJ Movie의 멤버가 되세유 :> </li>
                        </ol>
                        
                        <div class="container" style="font-family: 'GmarketSansMedium';">
                        <div class="row justify-content-center">
                            <div class="col-lg-7">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="card-header">
                                    <h3 class="text-center font-weight-bold my-4" style="height:20px;">회원 가입</h3>
                                    </div>
                                    
                                    <div class="card-body">
                                    
                                    <!--  회원가입 -->
                                        <form action="memberJoin" method="post" enctype="multipart/form-data" >
                                        	
                                        	<div class="row mb-3">
                                        		<div class="col-md-9">
                                            	<div class="form-floating mb-3">
												 
                                               	 <input class="form-control" id="mId" name="mid" type="text" value="${joinMemberForm.mid}" placeholder="아이디" />
                                               	 <label for="inputEmail">아이디</label>
                                               	 </div>
                                               	 </div>
                                               	 <div class="col-md-3" id="idCheakArea">
                                               	 <span class="small" id="idCheck"> *영문/숫자 4~15자 </span>
                                               	 </div>
                                              </div>
												<spring:hasBindErrors name="registrationForm">
													<c:if test="${errors.hasFieldErrors('mid')}">                                     
														<strong>${errors.getFieldError('mid').defaultMessage }</strong>
													 </c:if>
												 </spring:hasBindErrors>	 
                                            	<div class="form-floating mb-3">
                                               	 <input class="form-control" id="mPw" name="mpw" type="password" placeholder="비밀번호" />
                                               	 <label for="inputEmail">비밀번호</label>
                                               	 </div>
                                            	
                                            <div class="row mb-3">
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" id="mName" name="mname" type="text" placeholder="이름" />
                                                        <label for="inputPassword">이름</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" id="mBirth" name="mbirth" type="date" placeholder="생년월일" />
                                                        <label for="inputPasswordConfirm">생년월일</label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-floating mb-3">
                                                <input class="form-control" id="mEmail" name="memail" type="email" placeholder="이메일" />
                                                <label for="inputEmail">이메일</label>
                                            </div>
                                            <div class="form-floating mb-3">
                                                <input class="form-control" id="mAddr" name="maddr" type="text" placeholder="주소" />
                                                <label for="inputEmail">주소</label>
                                            </div>
                                            <div class="form-floating mb-3">
                                                <input class="form-control" id="mProfile" name="mfile" type="file" placeholder="프로필이미지" />
                                                <label for="inputEmail">프로필이미지</label>
                                            </div>
                                            <div class="mt-4 mb-0">
                                                <div class="d-grid"><button class="btn btn-primary btn-block" style="font-family: 'GmarketSansMedium';">회원가입</button></div>
                                            </div>
                                        </form>
                                    </div>
                                    <div class="card-footer text-center py-3">
                                        <div class="small"><a href="Login">이미 가입이 되어있쥬?</a></div>
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
    	console.log("실행");
    	
    	$("#mId").keyup(function(){
    		var mid = $("#mId").val();
    		console.log(mid);
   		 	if(mid.length < 1){
   			 	$("#idCheck").css("color", "red").text("아이디를 입력해 주세요.");
   		 	}
   			 if(mid.length < 4 && mid.length > 15){
   				 $("#idCheck").text("영문/숫자 4~15자입니다.");
   			 }
   		 $.ajax({
   			type : "get",
   			url : "idCheck",
   			data : { "mid" : mid },
   			success : function(result){
   				console.log(result);
   				if(mid.length < 1){
   	   			 	$("#idCheck").css("color", "red").text("아이디를 입력해 주세요.");
   			    }else if(mid.length < 4 || mid.length > 12){
   	   				 $("#idCheck").css("color", "red").text("영문/숫자 4~12자입니다.");
   	   			}else{
   					if(result == "x"){
   						$("#idCheck").css("color", "green").text("사용가능한 아이디 입니다.");
   					}else{
   						$("#idCheck").css("color", "red").text("이미 사용중인 아이디 입니다.");
   					}
   	   			}
   			}
   		 });
    	});
    });
    	 
    </script>
</html>
