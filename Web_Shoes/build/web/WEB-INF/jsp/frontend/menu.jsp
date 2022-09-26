<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="i" uri="http://www.springframework.org/tags" %>

<nav class="navigation">
    <div class="container-fluid">
        <div class="navigation__column left">
            <div class="header__logo"><a class="ps-logo" href="index.html"><img src="<i:url value='/resources/images/logo.png'/>" alt=""></a></div>
        </div>
        <div class="navigation__column center"><ul class="main-menu menu">
                <li class="menu-item menu-item-has-children dropdown"><a href="/Web_Shoes/">Trang chủ</a>

                </li>
                <li class="menu-item menu-item-has-children dropdown"><a href="#">Sản Phẩm</a>
                    <ul class="sub-menu">
                        <c:forEach var="s" items="${danhmuc}">
                            <li><a href="/Web_Shoes/DanhMuc?maDanhMuc=${s.maDanhMuc}">${s.tenDanhMuc}</a></li>
                            </c:forEach>
                    </ul>
                </li>
                <li class="menu-item"><a href="#">Women</a></li>
                <li class="menu-item"><a href="#">Kids</a></li>
                <li class="menu-item menu-item-has-children dropdown"><a href="#">News</a>
                    <ul class="sub-menu">
                        <li class="menu-item menu-item-has-children dropdown"><a href="blog-grid.html">Blog-grid</a>
                            <ul class="sub-menu">
                                <li class="menu-item"><a href="blog-grid.html">Blog Grid 1</a></li>
                                <li class="menu-item"><a href="blog-grid-2.html">Blog Grid 2</a></li>
                            </ul>
                        </li>
                        <li class="menu-item"><a href="blog-list.html">Blog List</a></li>
                    </ul>
                </li>
                <li class="menu-item menu-item-has-children dropdown"><a href="#">Contact</a>
                    <ul class="sub-menu">
                        <li class="menu-item"><a href="contact-us.html">Contact Us #1</a></li>
                        <li class="menu-item"><a href="contact-us.html">Contact Us #2</a></li>
                    </ul>
                </li>
            </ul>

        </div>
        <div class="navigation__column right">

            <form class="ps-search--header" action="/Web_Shoes/search" method="GET">
                <input class="form-control" type="text" placeholder="Search Product…" name="name">
                <button><i class="ps-icon-search"></i></button>
            </form>
            <div class="ps-cart"><a class="ps-cart__toggle" href="/Web_Shoes/giohang" id="giohang">
                    <c:if test="${soluong>0}">
                    <span class="circle-giohang"><i>${soluong}</i></span>
                    </c:if>
                    <c:if test="${soluong<=0 || soluong==null}">
                         <span><i>${soluong}</i></span>
                    </c:if>
                    <i class="ps-icon-shopping-cart"></i></a>
               
            </div>
            <div class="menu-toggle"><span></span></div>
        </div>
    </div>
</nav>