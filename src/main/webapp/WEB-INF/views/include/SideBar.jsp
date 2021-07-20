<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sce" uri="http://www.springframework.org/security/tags" %>
<!-- SideBar.jsp -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>    
    
<div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu" style="font-family: 'GmarketSansMedium';">
                        <div class="nav">
                            <a class="nav-link" href="/">
                                <div class="sb-nav-link-icon"><i class="fas fa-home"></i></div>
                                <span>메인으로</span>
                            </a>
                        	<div class="sb-sidenav-menu-heading">menu</div>
                            <a class="nav-link" href="#">
                                <div class="sb-nav-link-icon"><i class="fas fa-video"></i></div>
                                <span>영화</span>
                            </a>
                            <a class="nav-link" href="${pageContext.request.contextPath}/Movies/MovieReservation">
                                <div class="sb-nav-link-icon"><i class="fas fa-calendar-check"></i></div>
                                <span>예매</span>
                            </a>
                            
                            <div class="sb-sidenav-menu-heading">SETTINGS</div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-user"></i></div>
                                <span>회원</span>
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">

                                	<sec:authorize access="isAuthenticated()">
                                		<a class="nav-link" href="${pageContext.request.contextPath}/profile">내정보</a>
                                		<a class="nav-link" href="${pageContext.request.contextPath}/Movies/MovieReList?loginId=${sessionScope.loginMember}">예매내역</a>
                                    </sec:authorize>
                                	
                                    <sce:authorize access="isAnonymous()">
                                	<a class="nav-link" href="${pageContext.request.contextPath}/login">로그인</a>
                                    <a class="nav-link" href="${pageContext.request.contextPath}/register">회원가입</a>
                                    </sce:authorize>
                                    

                                </nav>
                            </div>
                            <sec:authorize access="hasRole('ROLE_ADMIN')">
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
                                <div class="sb-nav-link-icon"><i class="fas fa-cogs"></i></div>
                                <span>관리</span>
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>

                            <div class="collapse" id="collapsePages" aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseAuth" aria-expanded="false" aria-controls="pagesCollapseAuth">
                                        <span>영화 관리</span>
                                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                    </a>
                                    <div class="collapse" id="pagesCollapseAuth" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordionPages">
                                        <nav class="sb-sidenav-menu-nested nav">
                                            <a class="nav-link" href="${pageContext.request.contextPath}/Movies/AddMovieForm">영화등록</a>
                                            <a class="nav-link" href="#">영화관등록</a>
                                            <a class="nav-link" href="/movies/MovieReList">영화목록</a>
                                            <a class="nav-link" href="${pageContext.request.contextPath}/Movies/addScheduleForm">스케쥴등록</a>
                                        </nav>
                                    </div>
                                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseError" aria-expanded="false" aria-controls="pagesCollapseError">
                                        <span>회원 관리</span>
                                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                    </a>
                                    <div class="collapse" id="pagesCollapseError" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordionPages">
                                        <nav class="sb-sidenav-menu-nested nav">
                                            <a class="nav-link" href="${pageContext.request.contextPath}/users">회원목록</a>

                                            
                                            <a class="nav-link" href="#">회원삭제</a>
                                        </nav>
                                    </div>
                                </nav>
                            </div>
                            </sec:authorize>
                        </div>
                    </div>
                    
                    <div class="sb-sidenav-footer">
                        <div class="small">MJ Movie</div>
                        
                    </div>
                </nav>
            </div>