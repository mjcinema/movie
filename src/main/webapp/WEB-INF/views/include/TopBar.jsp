<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<!-- TopBar.jsp -->

    <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark" style="font-family: 'GmarketSansMedium';">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" href="${pageContext.request.contextPath}/">MJ Movie</a>
            <!-- Sidebar Toggle-->
            <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>
            <!-- Navbar Search-->
            <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
                <div class="input-group">
                    <input class="form-control" type="text" placeholder="영화 제목 검색하라우" aria-label="Search for..." aria-describedby="btnNavbarSearch" />
                    <button class="btn btn-primary" id="btnNavbarSearch" type="button"><i class="fas fa-search"></i></button>
                </div>
            </form>
            <!-- Navbar-->
            <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    <c:choose>
                    <c:when test="${sessionScope.loginMember != null }">
                    <span class="mr-2 d-none d-lg-inline text-gray-600 small">${sessionScope.loginMember.username}</span>
                    
                    </c:when>
                    <c:otherwise>
                    	<span class="mr-2 d-none d-lg-inline text-gray-600 small">로그인 해주라우!</span>
                    </c:otherwise>                
                    </c:choose>
                    </a>
                    
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                    
                    <c:choose>     
                    	<c:when test="${sessionScope.loginMember != null }">
                    	<li><a class="dropdown-item" href="${pageContext.request.contextPath}/profile?username=${sessionScope.loginMember.username}"><i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i> 내정보</a></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/Movies/MovieReList?loginId=${sessionScope.loginMember}"> <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i> 예매 내역</a></li>
                        <li><hr class="dropdown-divider" /></li>
                        <a class="dropdown-item" onclick="document.querySelector('#logoutForm').submit();">
                        <form id="logoutForm" action="${pageContext.request.contextPath}/logout" method="post" style="visibility: hidden;"></form>
                        <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i> 로그아웃</a>
                       	</c:when>
                       	
                       	<c:otherwise>
                      	<li><a class="dropdown-item" href="${pageContext.request.contextPath}/login">로그인</a></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/register">회원가입</a></li>
                        </c:otherwise>
                    </c:choose>    
                    </ul>
                </li>
            </ul>
        </nav>
        
        
        
        

    	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Logout</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">로그아웃 하시겠습니까?</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/logout">Logout</a>
                </div>
            </div>
       	 </div>
   		 </div>
        
        
        
        