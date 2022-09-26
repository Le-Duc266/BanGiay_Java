<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header class="header" style="margin-top: 0px;">
    <div class="header__top">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-6 col-md-8 col-sm-6 col-xs-12 ">
                    <p>460 West 34th Street, 15th floor, New York  -  Hotline: 804-377-3580 - 804-399-3580</p>
                </div>
                <div class="col-lg-6 col-md-4 col-sm-6 col-xs-12 ">
                    <div class="header__actions">
                        <c:if test="${ten==null}">
                            <div class="btn-group ps-dropdown"><a class="dropdown-toggle" href="/Web_Shoes/login">Login &amp; Regiser<i class="fa fa-angle-down"></i></a>

                            </div>
                        </c:if>
                         <c:if test="${ten!=null}">
                        <div class="btn-group ps-dropdown"><a class="dropdown-toggle" href="/Web_Shoes/login" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">${ten}<i class="fa fa-angle-down"></i></a>
                            <ul class="dropdown-menu">
                                <li><a href="#"><img src="images/flag/usa.svg" alt=""> USD</a></li>
                                <li><a href="#"><img src="images/flag/singapore.svg" alt=""> SGD</a></li>
                                <li><a href="/Web_Shoes/logoutBackend"><img src="images/flag/japan.svg" alt=""> logout</a></li>
                            </ul>
                        </div>
                         </c:if>
                        <div class="btn-group ps-dropdown"><a class="dropdown-toggle" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">USD<i class="fa fa-angle-down"></i></a>
                            <ul class="dropdown-menu">
                                <li><a href="#"><img src="images/flag/usa.svg" alt=""> USD</a></li>
                                <li><a href="#"><img src="images/flag/singapore.svg" alt=""> SGD</a></li>
                                <li><a href="#"><img src="images/flag/japan.svg" alt=""> JPN</a></li>
                            </ul>
                        </div>
                        <div class="btn-group ps-dropdown"><a class="dropdown-toggle" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Language<i class="fa fa-angle-down"></i></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">English</a></li>
                                <li><a href="#">Japanese</a></li>
                                <li><a href="#">Chinese</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="menu.jsp"></jsp:include>
</header>