<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                                    <div class="card-header">
                                    <h3 class="text-center font-weight-bold my-4" style="height:20px;">?????????</h3>
                                    </div>
                                    
                                    <div class="card-body" style="text-align:center;">
                                    	<div class="form-floating mb-3">
                                        			 <img style="height: 150px; width: 150px; border-radius: 50% !important;"
                                    					src="/resources/img/memProfile/${user.imageName}">
                                        </div>
                                        <div class="form-floating mb-3">
                                          	    <button class="btn btn-primary btn-block" onclick="viewMprofileForm()">
                                          	    ????????? ?????? ??????</button>
                                        </div>
                        			
                        				<div class="form-floating mb-3 show-hide"  id="modifyPfArea">
                        				<form id="updateImage" action="modifyMemberProfile" method="post" enctype="multipart/form-data">
                                            <input type="file" name="mfile" class="form-control" id="inputProfile">
                                            <input type="hidden" name="memberProfile" value="${user.imageName}">
                                            <input type="hidden" name="mid" value="${user.username}">
											<br>
											<input type="submit" class="btn btn-primary btn-block"  value="???????????????">
                        				</form>
                        				</div>
                        			</div>
                        	</div>
                        	</div>
                        	
                        	
                            <div class="col-lg-7">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="card-header">
                                    <h3 class="text-center font-weight-bold my-4" style="height:20px;">?????????</h3>
                                    </div>
                                    
                                    <div class="card-body">

                                        <form method="post" action="/users/${user.username}/edit" id="editForm">
                                        	<div class="row mb-6" >
                                        		 <div class="col-md-6" >
                                            		<div class="form-floating mb-3">
                                               		 <input class="form-control" style="height:40px;" type="text" name="username" value="${user.username}" />
                                               	 	</div>
                                               	 </div>
                                               	 <div class="col-md-6">
                                               	 	<div class="form-floating mb-3">
                                               	 	<input class="form-control" style="height:40px;" type="text" name="password" value="${user.password}" />
                                               		 </div>
                                        		</div>
                                            </div>	
                                            	
                                            <div class="row mb-3">
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" style="height:40px;" type="text" name="name" value="${user.name}" />
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" style="height:40px;" type="text" name="birth" value="${user.birth}"  />
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row mb-3">
                                            <div class="form-floating mb-3">
                                            <input class="form-control" type="text" style="height:40px;" id="email" name="email" value="${user.email}"   />
                                            </div>

                                            </div>
                                            <div class="form-floating mb-3">
                                                <input class="form-control" type="text" style="height:40px;" name="address" value="${user.address}"  />
                                            </div>
                                            <div class="col-md-2">
                                                <button class="btn btn-primary btn-block" type="button" id="username" onclick="document.querySelector('#editForm').submit()">??????</button>
                                                <button class="btn btn-primary btn-block" type="button" id="ModifyMemail" style="display:none;">??????</button>
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
                            <div class="text-muted">Copyright &copy; MJ Movie </div>
                       
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
    $(document).ready(function() {
    console.log("?????? ?????????: "+"${sessionScope.loginMember}")
    console.log("?????? ?????????: "+"${sessionScope.loginPf}")	
    	
		$("#btnemail").click(function(){
			$("#email").removeAttr("disabled");
			$("#btnemail").css("display","none");
			$("#Modifyemail").css("display","");
		});
		
		
		$("#Modifyemail").click(function(){
			var memId = "${sessionScope.loginMember }";
			var newEmail = "${user.email}";
			
			$.ajax({
				type : "get",
				url : "modifyMemberEmail",
				data : { "memberId" : memId, 
						 "newEmail" : newEmail
						},
				async : false,
				success : function(checkResult){
					if(checkResult == "1"){
						$("#Memail").attr("disabled","disabled");
						$("#btnMemail").css("display",""); 
						$("#ModifyMemail").css("display","none"); 
					}else{
						alert("????????? ?????? ??????");
						$("#Memail").val("${user.email}");
					}
				}
				
			});
			$("#Memail").attr("disabled");
			$("#btnMemail").css("display",""); 
			$("#ModifyMemail").css("display","none");
		});
	});
    
    function viewMprofileForm(){
    	$("#modifyPfArea").toggleClass("show-hide");
    }

    </script>
</html>
