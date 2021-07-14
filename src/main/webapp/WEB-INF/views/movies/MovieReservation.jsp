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
		#mvPoster{
		margin-right: auto;
		margin-left: auto;
		width: 200px; 
		height:auto; 
		
		padding-bottom:8px;"
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
                        <h1 class="mt-4">Movie Reservation</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active" style="font-family: 'GmarketSansMedium';"><i class="fas fa-bookmark"></i> 원하는 영화를 선택 하라우!</li>
                        </ol>
                        <div class="row" style="font-family: 'GmarketSansMedium';">
                     		<div class="col-lg-9">
								<div class="row">
								<!-- 영화 목록 출력 -->
									<div class="col-lg-4">
								
										<div class="card shadow mb-4">
                              			  <div class="card-header bg-primary">
                                 		 	  <h6 class="m-0 text-white" ><i class="fas fa-video"></i> 영화 선택 ${param.mvCode}</h6>
                                		  </div>
                               			    <div class="list-group list-group-flush small" id="movieListArea" style="height:200px;  overflow:auto;" >
                                      		  <c:forEach items="${mvList}" var="movie">
                                      		  <c:choose>
                                      		  <c:when test="${movie. mvcode == param.mvCode}">
                                      		  <a class="list-group-item list-group-item-action" id="movieSel"
                                      		  onclick="movieSelect(this,'${movie. mvcode}','${movie. mvtitle}','${movie. mvposter }')" href="#">
                                        	    <i class="fas fa-caret-right"></i> ${movie.mvtitle }
                                       		  </a>
                                       		  </c:when>
                                       		  <c:otherwise>
                                       		  <a class="list-group-item list-group-item-action"
                                      		  onclick="movieSelect(this,'${movie. mvcode}','${movie. mvtitle}','${movie. mvposter }')" href="#">
                                        	    <i class="fas fa-caret-right"></i> ${movie.mvtitle }
                                       		  </a>
                                       		  </c:otherwise>
                                       		  </c:choose>
                                        	  </c:forEach> 
                                  		    </div>
                          				  </div>
									</div>
								<!-- 영화관 목록 출력 -->	
									<div class="col-lg-4">
											<div class="card shadow mb-4">
                              			  <div class="card-header bg-success">
                                 		 	  <h6 class="m-0 text-white" ><i class="fas fa-couch"></i> 영화관 선택 </h6>
                                		  </div>
                               			    <div class="list-group list-group-flush small" style="height:200px; overflow:auto;" id="cinemaListArea">
                                      		
                                  		    </div>
                          				  </div>
									</div>
									<div class="col-lg-4">
										<div class="card shadow mb-4">
                              			  <div class="card-header bg-warning">
                                 		 	  <h6 class="m-0 text-white" ><i class="fas fa-calendar-check"></i> 날짜 선택</h6>
                                		  </div>
                               			    <div class="list-group list-group-flush small" style="height:200px; overflow:auto;" id="scDateListArea">
                                      		  
                                  		    </div>
                          				  </div>
									</div>
								</div>  
								<div class="row">
									<div class="col-lg-8">
										<div class="card shadow mb-4">
                              			  <div class="card-header bg-danger">
                                 		 	  <h6 class="m-0 text-white" ><i class="fas fa-clock"></i> 상영 시간표</h6>
                                		  </div>
                               			    <div class="list-group list-group-flush small" style="height:200px; overflow:auto;" id="scTimeListArea">
                                      		 
                                  		    </div>
                          				  </div>
									</div>
									<div class="col-lg-4">
										<div class="card shadow mb-4">
                              			  <div class="card-header bg-info">
                                 		 	  <h6 class="m-0 text-white" ><i class="fas fa-users"></i> 인원 선택</h6>
                                		  </div>
                               			    
                                      		 <div id="selectPeopleArea" style="padding : 10px;  text-align : center;">
                                      		 	<button class="btn btn-outline-dark" onclick="selectPeople(this,1)">1</button>
                                      		 	<button class="btn btn-outline-dark" onclick="selectPeople(this,2)">2</button>
                                      		 	<button class="btn btn-outline-dark" onclick="selectPeople(this,3)">3</button>
                                      		 	<button class="btn btn-outline-dark" onclick="selectPeople(this,4)">4</button>
                                      		 	<button class="btn btn-outline-dark" onclick="selectPeople(this,5)">5</button>
                                      		 </div>
                                  		   
                          				  </div>
									</div>
								</div>                   		
                     		</div>
                     		
                     		<div class="col-lg-3">
                     			<div class="card shadow mb-4">
                              			  <div class="card-header bg-dark">
                                 		 	  <h6 class="m-0 text-white" >예매 정보</h6>
                                		  </div>
                               			    <div class="list-group list-group-flush small" style="padding-top : 20px; height:500px; text-align : center; overflow:auto;" 
                               			     id="reservationArea">
                               			      <img  src="" id="mvPoster"  onclick="">
                                      		  <h6 id="selectMvTilte">영화를 선택 하라우~!</h6>
                                      		  <h6 id="selectCinema"></h6>
                                      		  <h6 id="selectDate"></h6>
                                      		  <h6 id="selectTheater"></h6>
                                      		  <h6 id="selectNum" ></h6> 
                                      		  <form action="reservationForm" method="post" onsubmit="return checkRev()">
                                      		  	<input type="hidden" name="re_cicode" id="re_cicode">
                                      		  	<input type="hidden" name="re_thname" id="re_thname">
                                      		  	<input type="hidden" name="re_start" id="re_start">
                                      		  	<input type="hidden" name="re_number" id="re_number">
                                      		  	<input type="hidden" name="re_id" id="re_id" value="${sessionScope.loginId }">
                                      		  <button class="btn btn-dark">예매하기</button>
                                      		  </form>
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
        <script src="${pageContext.request.contextPath}/js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="${pageContext.request.contextPath}/assets/demo/chart-area-demo.js"></script>
        <script src="${pageContext.request.contextPath}/assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="${pageContext.request.contextPath}/js/datatables-simple-demo.js"></script>
    </body>
    
    <script type="text/javascript">
    
    	$(document).ready(function(){
    		if("${sessionScope.loginMember}" == ""){
    			alert("로그인 후 이용해주세요");
    			location.href = "${pageContext.request.contextPath}/Members/Login";
    		}
    			
    		$("#movieSel").click();
    		
    	});
    
    	function movieSelect(obj, mv_code, mv_title, mv_poster){
    		console.log("선택한요소: "+ obj );
    		console.log("영화코드: "+mv_code);
    		console.log("포스터: "+mv_poster);
    		$("#movieListArea a").css("background-color", "white");
    		$(obj).css("background-color", "#e2e2e2");
    		
    		/* 목록 초기화 */
    		$("#cinemaListArea").html("");
    		$("#scDateListArea").html("");
    		$("#scTimeListArea").html("");
    		
    		/* 예매 내역 초기화 */
    		$("#selectCinema").text("");
    		$("#selectDate").text("");
    		$("#selectTheater").text("");
    		
    		/* form태그 초기화 */
    		$("#re_cicode").val("");
    		$("#re_thname").val("");
    		$("#re_start").val("");
    		
    		/* 영화포스터 */
    		$("#mvPoster").attr("src","../img/mvPoster/"+mv_poster)
    		$("#mvPoster").attr("style","cursor: pointer;")
    		$("#mvPoster").attr("onclick","location.href='movieInfo?mvCode="+mv_code+"'")
    		
    		$("#selectMvTilte").text(mv_title);
    		printCinemaList(mv_code);
    	}
    	
    	function printCinemaList(mv_code){
    		var output = "";
    	   $.ajax({
    		  type : "get",
    		  url : "cinemaList",
    		  data : { "mv_code" : mv_code },
    		  dataType : "json",
    		  success : function(cinemaList){
    			  console.log("영화관 목록");
    			  console.log(cinemaList);
    			 	 for(var i in cinemaList){
    			 		 output += "<a class='list-group-item list-group-item-action' onclick='cinemaSelect(this,\""+mv_code+"\",\""+cinemaList[i].cicode+"\",\""+cinemaList[i].ciname+"\" )' href='#!'>";
    			 		 output += "<i class='fas fa-caret-right'></i> ";
    			 		 output += cinemaList[i].ciname;
    			 		 output += "</a>";
    			 	 }
    			 	 $("#cinemaListArea").html(output);
    			 	 
    		  } 
    	   });
    	}
    	
    	
    	function cinemaSelect(obj,mv_code,ci_code,ci_name){
    		console.log(mv_code+":"+ci_code);
    		
    		
    		$("#cinemaListArea a").css("background-color", "white");
    		$(obj).css("background-color", "#e2e2e2");
    		
    		/* 목록 초기화 */
    		$("#scTimeListArea").html("");
    		
    		/* 예매 내역 초기화 */
    		$("#selectDate").text("");
    		$("#selectTheater").text("");
    		
    		$("#selectCinema").text(ci_name);
    		
    		/* form태그 초기화 */
    		$("#re_thname").val("");
    		$("#re_start").val("");
    		
    		
    		$("#re_cicode").val(ci_code);
    		printScdateList(mv_code,ci_code);
    		
    	}
    	
    	function printScdateList(mv_code,ci_code){
    		var output = "";
    		$.ajax({
    			type : "get",
    			url : "scDateList",
    			data : { "mv_code" : mv_code ,
    					 "ci_code" : ci_code
    					},
    			dataType : "json",
    			success : function(scDateList){
    				for(var i in scDateList){
    					output += "<a class='list-group-item list-group-item-action' onclick='scDateSelect(this,\""+mv_code+"\",\""+ci_code+"\",\""+scDateList[i].scstart+"\")' href='#!'>";
    					output += "<i class='fas fa-caret-right'></i> ";
    					output += scDateList[i].scstart;
    					output += "</a>";
    				}
    				$("#scDateListArea").html(output);
    			}
    		});
    	}
    	
    	function scDateSelect(obj,mv_code,ci_code,sc_start){
    		console.log(mv_code+":"+ci_code+":"+sc_start)
    		
    		$("#scDateListArea a").css("background-color", "white");
    		$(obj).css("background-color", "#e2e2e2");
    		
    		/* 예매 내역 초기화 */
    		$("#selectTheater").text("");
    		
    		/* form태그 초기화 */
    		$("#re_thname").val("");
    		$("#re_start").val("");
    		
    		$("#selectDate").text(sc_start);
    		
    		printscTimeList(mv_code,ci_code,sc_start);
    	}
    	
    	function printscTimeList(mv_code,ci_code,sc_start){
    		var output = "";
    		$.ajax({
    			type : "get",
    			url : "scTimeList",
    			data : { "mv_code" : mv_code ,
    					 "ci_code" : ci_code,
    					 "sc_start" : sc_start
    					},
    			dataType : "json",
    			success : function(scTimeList){
    				for(var i in scTimeList){
    					output += "<a class='list-group-item list-group-item-action' onclick='scTimeSelect(this,\""+scTimeList[i].sc_thname+"\",\""+scTimeList[i].scstart+"\",\""+sc_start+"\")' href='#!'>";
    					output += "<i class='fas fa-caret-right'></i> ";
    					output += scTimeList[i].sc_thname+" | "+scTimeList[i].scstart;
    					output += "</a>";
    				}
    				$("#scTimeListArea").html(output);
    			}
    		});
    	}
    	
    	function scTimeSelect(obj,sc_thname,sc_time,sc_date){
    		
    		$("#scTimeListArea a").css("background-color", "white");
    		$(obj).css("background-color", "#e2e2e2");
    		
    		$("#selectTheater").text(sc_thname+" | "+sc_time);
    		$("#re_thname").val(sc_thname);
    		$("#re_start").val(sc_date+" "+sc_time);
    	}
    	
    	function selectPeople(obj,num){
    		
    		$("#selectPeopleArea button").css("background-color", "white").css("color", "black");
    		$(obj).css("background-color", "black").css("color","white");
    		
    		$("#selectNum").text(num+"명");
    		$("#re_number").val(num);
    	}
    	
    	function checkRev(){
    		var cicode = $("#re_cicode").val();
    		var thname = $("#re_thname").val();
    		var start = $("#re_start").val();
    		var id = $("#re_id").val();
    		var number = $("#re_number").val();
    		
    		if(cicode == ""){
    			alert("영화를 선택해 주세요");
    			return false;
    		}else if(thname == ""){
    			alert("날짜 및 상영관을 선택해 주세요");
    			return false;
    		}else if(start == ""){
    			alert("날짜 및 상영관을 선택해 주세요");
    			return false;
    		}else if(id == ""){
    			alert("로그인을 해주세요");
    			return false;
    		}else if(number == ""){
    			alert("인원을 선택해 주세요");
    			return false;
    		}else{
    			return true;
    		}
    		
    	}
    </script>
</html>
