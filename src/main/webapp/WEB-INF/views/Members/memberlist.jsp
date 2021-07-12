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
        <title>MJ MOVIE</title>
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
		.Grade_12{
		 background-color:#f5ae1e;
		width: 20px;
		height: 20px;
		float: left;
		margin-right:1em;
		border-radius: 50%;
		-webkit-shape-outside:circle(40%);
		shape-outside:circle(40%);
		line-height:  22px;
		text-align:center;
		font-size:13px;
		 background-color:#1badd6;
		
		}
		.Grade_15{
		background-color:#f5ae1e;
		width: 20px;
		height: 20px;
		float: left;
		margin-right:1em;
		border-radius: 50%;
		-webkit-shape-outside:circle(40%);
		shape-outside:circle(40%);
		line-height:  22px;
		text-align:center;
		font-size:13px;
		}
		.Grade_18{
		background-color:#bf1a20;
		width: 20px;
		height: 20px;
		float: left;
		margin-right:1em;
		border-radius: 50%;
		-webkit-shape-outside:circle(40%);
		shape-outside:circle(40%);
		line-height:  22px;
		text-align:center;
		font-size:13px;
		}
		.Grade_all{
		background-color:#59b53d;
		width: 20px;
		height: 20px;
		float: left;
		margin-right:1em;
		border-radius: 50%;
		-webkit-shape-outside:circle(40%);
		shape-outside:circle(40%);
		line-height:  22px;
		text-align:center;
		font-size:13px;
		}
		
		tbody tr:hover{
		color : black;
		cursor: pointer;
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
                        <h1 class="mt-4">회원목록 :)</h1>
                    </div>
                      <div class="card mb-4" style="font-family: 'GmarketSansMedium';">
                            <div class="card-header">
                                <i class="fas fa-ticket-alt"></i>
                                Member List
                            </div>
                            <div class="card-body">
                                <table id="datatablesSimple">
                                    <thead>
                                        <tr>
                                            <th>아이디</th>
                                            <th>이름</th>
                                            <th>생년월일</th>
                                            <th>이메일</th>
                                            <th>주소</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>아이디</th>
                                            <th>이름</th>
                                            <th>생년월일</th>
                                            <th>이메일</th>
                                            <th>주소</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                    	<c:forEach items="${memberlist}" var="member">
                                        <tr onclick="movieInfo('${reInfo[7]}')">
                                        	<td>                              
                                        	<span>${member.username}</span>
                                        	</td>
                                            <td>${member.mname}</td>
                                            <td>${member.mbirth}</td>
                                            <td>${member.memail}</td>
                                            <td>${member.maddr}</td>
                                        </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                </main>
                
                
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; MJ MOVIE </div>
                       
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
	function movieInfo(movCode){
		console.log("movCode: "+movCode);
		location.href="movieInfo?mvCode="+movCode;
	}
	</script>    
</html>
