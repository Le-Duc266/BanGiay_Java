<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="i" uri="http://www.springframework.org/tags" %>
<html lang="en">

    <head>
        <jsp:include page="linkcss.jsp"></jsp:include>
            <style>
                .ps-shoe__thumbnail img {
                    height: fit-content;
                    height: 270px;
                    object-fit: cover;
                }
                .ps-shoe__variant img{
                    height:34px
                }
                .pagination>li>a, .pagination>li>span{
                    float: none;
                }
                .dropdown-menu {
                    position: absolute;
                    z-index: 2000;
                }
                .ps-shoe__detail span{
                    top: 25px !important;
                }

                .ps-shoe__detail del{
                    font-size: 16px;
                    position: absolute;
                    top: 30px;
                    right: 95px;
                    color: #cf5050;
                }
                .owl-carousel {
                    width: 100%;
                    height: 90vh;
                }

                .slide {
                    width: 100%;
                    height: 90vh;
                    position: relative;
                    background-size: cover;
                    background-repeat: no-repeat;
                    background-position: center center;
                }

                .slide::before {
                    content: "";
                    position: absolute;
                    top: 0;
                    left: 0;
                    width: 100%;
                    height: 90vh;
                }

                .slide-content {
                    position: absolute;
                    top: 50%;
                    transform: translateY(-50%);
                    color: #fff;
                    padding-right: 50%;
                    padding-left: 10%;
                }

                .slide-content h1 {
                    font-family: "Anton", serif;
                    font-size: 45px;
                    text-transform: uppercase;
                }

                .slide-content p {
                    font-family: "Lato", serif;
                    font-size: 18px;
                    color: #333;
                    margin-bottom: 20px;
                }

                .slide-content button {
                    font-family: "Roboto", serif;
                    font-size: 25px;
                    text-transform: uppercase;
                    font-weight: bolder;
                    padding: 10px 25px;
                    border: none;
                }


                .owl-dots button {
                    border: none !important;
                    outline: none !important;
                }

                .owl-nav button {
                    border: none !important;
                    outline: none !important;
                }
                .ps18{
                    font-size: 18px !important;
                }
            </style>
        </head>


        <body>
            <div class="header--sidebar"></div>
        <jsp:include page="header.jsp"></jsp:include>
            <div class="header-services">
                <div class="ps-services owl-slider" data-owl-auto="true" data-owl-loop="true" data-owl-speed="7000" data-owl-gap="0"
                     data-owl-nav="true" data-owl-dots="false" data-owl-item="1" data-owl-item-xs="1" data-owl-item-sm="1"
                     data-owl-item-md="1" data-owl-item-lg="1" data-owl-duration="1000" data-owl-mousedrag="on">
                    <p class="ps-service"><i class="ps-icon-delivery"></i><strong>Free delivery</strong>: Get free standard delivery
                        on every order with Sky Store</p>
                    <p class="ps-service"><i class="ps-icon-delivery"></i><strong>Free delivery</strong>: Get free standard delivery
                        on every order with Sky Store</p>
                    <p class="ps-service"><i class="ps-icon-delivery"></i><strong>Free delivery</strong>: Get free standard delivery
                        on every order with Sky Store</p>
                </div>
            </div>
            <main class="ps-main">
                <div class="ps-banner">
                    <div class="rev_slider fullscreenbanner" id="home-banner">
                        <div class="owl-carousel owl-theme">
                        <c:forEach var="bn" items="${banners}">
                            <c:if test="${bn.viTri == 1}">
                                <div class="slide" style="background-image: url(/Web_Shoes/resources/images/banner/${bn.anhBanner});">

                                </div>
                            </c:if>
                        </c:forEach>
                    </div>



                </div>
            </div>
            <div class="ps-section--features-product ps-section masonry-root pt-100 pb-100">
                <div class="ps-container">
                    <div class="ps-section__header mb-50">
                        <h3 class="ps-section__title" data-mask="features">- Features Products</h3>
                        <ul class="ps-masonry__filter">
                            <li class="current"><a href="#" data-filter="*">All <sup>8</sup></a></li>
                            <li><a href="#" data-filter=".nike">Nike <sup>1</sup></a></li>
                            <li><a href="#" data-filter=".adidas">Adidas <sup>1</sup></a></li>
                            <li><a href="#" data-filter=".men">Men <sup>1</sup></a></li>
                            <li><a href="#" data-filter=".women">Women <sup>1</sup></a></li>
                            <li><a href="#" data-filter=".kids">Kids <sup>4</sup></a></li>
                        </ul>
                    </div>
                    <div class="ps-section__content pb-50">
                        <div class="masonry-wrapper" data-col-md="4" data-col-sm="2" data-col-xs="1" data-gap="30" data-radio="100%">
                            <div class="ps-masonry">

                                <c:forEach var="s" items="${sanpham}">
                                    <div class="grid-item kids">
                                        <div class="grid-item__content-wrapper">
                                            <div class="ps-shoe mb-30">

                                                <div class="ps-shoe__thumbnail">
                                                    <c:forEach var="o" items="${spoderby}">
                                                        <c:if test="${s.getMaSanPham()==o.getMaSanPham()}">
                                                            <div class="ps-badge"><span>New</span></div>
                                                        </c:if>
                                                    </c:forEach>
                                                    <c:forEach var="b" items="${s.getKhuyenMaiCollection()}">

                                                        <c:if test="${b.getGiaGiam()!=null}">
                                                            <div class="ps-badge ps-badge--sale ps-badge--2nd"><span>-${b.getGiaGiam()}%</span></div>

                                                        </c:if>
                                                    </c:forEach>
                                                    <c:forEach var="p" items="${s.getChiTietSanPhamCollection()}" end="0">
                                                        <a
                                                            class="ps-shoe__favorite" href="#"><i class="ps-icon-heart"></i></a><img id="pic" src="<i:url value='/images/${p.anhChinh}'/>"
                                                                                                                                 alt="" height="330px" ><a class="ps-shoe__overlay" href="/Web_Shoes/SanPhamDetail?maSanPham=${s.maSanPham}&maDanhMuc=${s.maDanhMuc.maDanhMuc}">
                                                        </a>

                                                    </c:forEach>  
                                                </div>
                                                <div class="ps-shoe__content">
                                                    <div class="ps-shoe__variants">
                                                        <div class="ps-shoe__variant normal">
                                                            <c:if test="${!s.getKhuyenMaiCollection().isEmpty()}">
                                                                <c:forEach var="b" items="${s.getKhuyenMaiCollection()}">
                                                                    <c:forEach var="p" items="${s.getChiTietSanPhamCollection()}">

                                                                        <img id="pic1" onmouseover="chaneImage('<i:url value='/images/${p.anhChinh}'/>',${p.getGiaTien()},${s.getMaSanPham()},${b.getGiaGiam()})" src="<i:url value='/images/${p.anhChinh}'/>" height="55px" alt="">

                                                                    </c:forEach>

                                                                </c:forEach>
                                                            </c:if>
                                                            <c:if test="${s.getKhuyenMaiCollection().isEmpty()}">
                                                                <c:forEach var="p" items="${s.getChiTietSanPhamCollection()}">

                                                                    <img id="pic1" onmouseover="chaneImage('<i:url value='/images/${p.anhChinh}'/>',${p.getGiaTien()},${s.getMaSanPham()})" src="<i:url value='/images/${p.anhChinh}'/>" height="55px" alt="">

                                                                </c:forEach>  

                                                            </c:if>
                                                        </div>

                                                    </div>
                                                    <div class="ps-shoe__detail"><a class="ps-shoe__name">${s.tenSanPham}</a>
                                                        <p class="ps-shoe__categories"><a href="#"> ${s.maNhanHang.tenNhanHang}</a></p>

                                                        <p class="ps-shoe__categories">${s.getChiTietSanPhamCollection().size()} Colours</p>

                                                        <c:if test="${!s.getKhuyenMaiCollection().isEmpty()}">
                                                            <c:forEach var="b" items="${s.getKhuyenMaiCollection()}">

                                                                <c:if test="${b.getGiaGiam()!=null}">
                                                                    <c:forEach var="p" items="${s.getChiTietSanPhamCollection()}" end="0">

                                                                        <del id="giamkhuyenmai${s.getMaSanPham()}">${p.getGiaString()}</del>
                                                                        <span class="ps-shoe__price" id="giakm${s.getMaSanPham()}">
                                                                            ${p.getGiaKmString()}</span>
                                                                        </c:forEach>
                                                                    </c:if>




                                                            </c:forEach>
                                                        </c:if>
                                                        <c:if test="${s.getKhuyenMaiCollection().isEmpty()}">
                                                            <c:forEach var="p" items="${s.getChiTietSanPhamCollection()}" end="0">

                                                                <span class="ps-shoe__price" id="gia${s.getMaSanPham()}">
                                                                    ${p.getGiaString()}
                                                                </span>
                                                            </c:forEach>
                                                        </c:if>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="ps-section--offer">
                <div class="ps-column"><a class="ps-offer" href="product-listing.html"><img src="images/banner/home-banner-1.png"
                                                                                            alt=""></a></div>
                <div class="ps-column"><a class="ps-offer" href="product-listing.html"><img src="images/banner/home-banner-2.png"
                                                                                            alt=""></a></div>
            </div>
            <div class="ps-section--sale-off ps-section pt-80 pb-40">
                <div class="ps-container">
                    <div class="ps-section__header mb-50">
                        <h3 class="ps-section__title" data-mask="Sale off">- Hot Deal Today</h3>
                    </div>
                    <div class="ps-section__content">
                        <div class="row">
                            <div class="col-lg-6 col-md-12 col-sm-12 col-xs-12 ">
                                <div class="ps-hot-deal">
                                    <h3>Nike DUNK Max 95 OG</h3>
                                    <p class="ps-hot-deal__price">Only: <span>£155</span></p>
                                    <ul class="ps-countdown" data-time="December 13, 2017 15:37:25">
                                        <li><span class="hours"></span>
                                            <p>Hours</p>
                                        </li>
                                        <li class="divider">:</li>
                                        <li><span class="minutes"></span>
                                            <p>minutes</p>
                                        </li>
                                        <li class="divider">:</li>
                                        <li><span class="seconds"></span>
                                            <p>Seconds</p>
                                        </li>
                                    </ul><a class="ps-btn" href="#">Order Today<i class="ps-icon-next"></i></a>
                                </div>
                            </div>
                            <div class="col-lg-6 col-md-12 col-sm-12 col-xs-12 ">
                                <div class="ps-hotspot"><a class="point first active" href="javascript:;"><i class="fa fa-plus"></i>
                                        <div class="ps-hotspot__content">
                                            <p class="heading">JUMP TO HEADER</p>
                                            <p>Dynamic Fit Collar en la zona del tobillo que une la parte inferior de la pierna y el pie sin
                                                reducir la libertad de movimiento.</p>
                                        </div>
                                    </a><a class="point second" href="javascript:;"><i class="fa fa-plus"></i>
                                        <div class="ps-hotspot__content">
                                            <p class="heading">JUMP TO HEADER</p>
                                            <p>Dynamic Fit Collar en la zona del tobillo que une la parte inferior de la pierna y el pie sin
                                                reducir la libertad de movimiento.</p>
                                        </div>
                                    </a><a class="point third" href="javascript:;"><i class="fa fa-plus"></i>
                                        <div class="ps-hotspot__content">
                                            <p class="heading">JUMP TO HEADER</p>
                                            <p>Dynamic Fit Collar en la zona del tobillo que une la parte inferior de la pierna y el pie sin
                                                reducir la libertad de movimiento.</p>
                                        </div>
                                    </a><img src="images/hot-deal.png" alt=""></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <c:if test="${sa!=null}">
                <div class="ps-section ps-section--top-sales ps-owl-root pt-80 pb-80">
                    <div class="ps-container">
                        <div class="ps-section__header mb-50">
                            <div class="row">
                                <div class="col-lg-9 col-md-9 col-sm-12 col-xs-12 ">
                                    <h3 class="ps-section__title" data-mask="BEST SALE">- Top Sales</h3>
                                </div>
                                <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12 ">
                                    <div class="ps-owl-actions"><a class="ps-prev" href="#"><i class="ps-icon-arrow-right"></i>Prev</a><a
                                            class="ps-next" href="#">Next<i class="ps-icon-arrow-left"></i></a></div>
                                </div>
                            </div>
                        </div>
                        <div class="ps-section__content">
                            <div class="ps-owl--colection owl-slider" data-owl-auto="true" data-owl-loop="true" data-owl-speed="5000"
                                 data-owl-gap="30" data-owl-nav="false" data-owl-dots="false" data-owl-item="4" data-owl-item-xs="1"
                                 data-owl-item-sm="2" data-owl-item-md="3" data-owl-item-lg="4" data-owl-duration="1000"
                                 data-owl-mousedrag="on">
                                <c:forEach var="c" items="${spall}">
                                    <c:if test="${!c.getKhuyenMaiCollection().isEmpty()}">
                                        <div class="ps-shoes--carousel">
                                            <div class="ps-shoe">
                                                <div class="ps-shoe__thumbnail">
                                                    <c:forEach var="o" items="${spoderby}">
                                                        <c:if test="${c.getMaSanPham()==o.getMaSanPham()}">
                                                            <div class="ps-badge"><span>New</span></div>
                                                        </c:if>
                                                    </c:forEach>
                                                    <c:forEach var="b" items="${c.getKhuyenMaiCollection()}">

                                                        <c:if test="${b.getGiaGiam()!=null}">
                                                            <div class="ps-badge ps-badge--sale ps-badge--2nd"><span>-${b.getGiaGiam()}%</span></div>

                                                        </c:if>
                                                    </c:forEach>
                                                    <c:forEach var="p" items="${c.getChiTietSanPhamCollection()}" end="0">
                                                        <a
                                                            class="ps-shoe__favorite" href="#"><i class="ps-icon-heart"></i></a><img id="pic" src="<i:url value='/images/${p.anhChinh}'/>"
                                                                                                                                 alt="" height="330px" ><a class="ps-shoe__overlay" href="/Web_Shoes/SanPhamDetail?maSanPham=${c.maSanPham}">
                                                        </a>

                                                    </c:forEach> 
                                                </div>
                                                <div class="ps-shoe__content">
                                                    <div class="ps-shoe__variants">
                                                        <div class="ps-shoe__variant normal">
                                                            <c:forEach var="b" items="${c.getKhuyenMaiCollection()}">
                                                                <c:forEach var="p" items="${c.getChiTietSanPhamCollection()}">

                                                                    <img id="pic1" onmouseover="chaneImage('<i:url value='/images/${p.anhChinh}'/>',${p.getGiaTien()},${c.getMaSanPham()},${b.getGiaGiam()})" src="<i:url value='/images/${p.anhChinh}'/>" height="55px" alt="">

                                                                </c:forEach>

                                                            </c:forEach>
                                                        </div>

                                                    </div>
                                                    <div class="ps-shoe__detail"><a class="ps-shoe__name" href="#">${c.tenSanPham}</a>
                                                        <p class="ps-shoe__categories"><a href="#"> ${c.maNhanHang.tenNhanHang}</a></p>

                                                        <p class="ps-shoe__categories">${c.getChiTietSanPhamCollection().size()} Colours</p>


                                                        <c:forEach var="b" items="${c.getKhuyenMaiCollection()}">

                                                            <c:if test="${b.getGiaGiam()!=null}">
                                                                <c:forEach var="p" items="${c.getChiTietSanPhamCollection()}" end="0">

                                                                    <del id="giamkhuyenmais${c.getMaSanPham()}" style="position: absolute;top: 10px;right: 86px;">${p.getGiaString()}</del>
                                                                    <span class="ps-shoe__price" id="giakms${c.getMaSanPham()}">
                                                                        ${p.getGiaKmString()}</span>
                                                                    </c:forEach>
                                                                </c:if>
                                                            </c:forEach>


                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </c:if>
                                </c:forEach>  
                            </div>
                        </div>
                    </div>
                </div>
            </c:if>

            <div class="ps-section--offer">
                <c:forEach var="bn" items="${banners}">
                    <c:if test="${bn.viTri == 2}">
                        <div class="ps-column">
                            <a class="ps-offer">
                                <img src="/Web_Shoes/resources/images/banner/${bn.anhBanner}" alt="" width="100%;">
                            </a>
                        </div>
                    </c:if>
                </c:forEach>
            </div>
            <c:if test="${spoderby!=null}">
                <div class="ps-section ps-section--top-sales ps-owl-root pt-80 pb-80">
                    <div class="ps-container">
                        <div class="ps-section__header mb-50">
                            <div class="row">
                                <div class="col-lg-9 col-md-9 col-sm-12 col-xs-12 ">
                                    <h3 class="ps-section__title" data-mask="BEST SALE">- Sản Phẩm Mới</h3>
                                </div>
                                <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12 ">
                                    <div class="ps-owl-actions"><a class="ps-prev" href="#"><i class="ps-icon-arrow-right"></i>Prev</a><a
                                            class="ps-next" href="#">Next<i class="ps-icon-arrow-left"></i></a></div>
                                </div>
                            </div>
                        </div>
                        <div class="ps-section__content">
                            <div class="ps-owl--colection owl-slider" data-owl-auto="true" data-owl-loop="true" data-owl-speed="5000"
                                 data-owl-gap="30" data-owl-nav="false" data-owl-dots="false" data-owl-item="4" data-owl-item-xs="1"
                                 data-owl-item-sm="2" data-owl-item-md="3" data-owl-item-lg="4" data-owl-duration="1000"
                                 data-owl-mousedrag="on">
                                <c:forEach var="c" items="${spoderby}">

                                    <div class="ps-shoes--carousel">
                                        <div class="ps-shoe">
                                            <div class="ps-shoe__thumbnail">
                                                <div class="ps-badge"><span>New</span></div>
                                                <c:forEach var="b" items="${c.getKhuyenMaiCollection()}">

                                                    <c:if test="${b.getGiaGiam()!=null}">
                                                        <div class="ps-badge ps-badge--sale ps-badge--2nd"><span>-${b.getGiaGiam()}%</span></div>

                                                    </c:if>
                                                </c:forEach>
                                                <c:forEach var="p" items="${c.getChiTietSanPhamCollection()}" end="0">
                                                    <a
                                                        class="ps-shoe__favorite" href="#"><i class="ps-icon-heart"></i></a><img id="pic" src="<i:url value='/images/${p.anhChinh}'/>"
                                                                                                                             alt="" height="330px" ><a class="ps-shoe__overlay" href="/Web_Shoes/SanPhamDetail?maSanPham=${c.maSanPham}">
                                                    </a>

                                                </c:forEach> 
                                            </div>
                                            <div class="ps-shoe__content">
                                                <div class="ps-shoe__variants">
                                                    <div class="ps-shoe__variant normal">
                                                        <c:if test="${!c.getKhuyenMaiCollection().isEmpty()}">
                                                            <c:forEach var="b" items="${c.getKhuyenMaiCollection()}">
                                                                <c:forEach var="p" items="${c.getChiTietSanPhamCollection()}">

                                                                    <img id="pic1" onmouseover="chaneImage('<i:url value='/images/${p.anhChinh}'/>',${p.getGiaTien()},${c.getMaSanPham()},${b.getGiaGiam()})" src="<i:url value='/images/${p.anhChinh}'/>" height="55px" alt="">

                                                                </c:forEach>

                                                            </c:forEach>
                                                        </c:if>
                                                        <c:if test="${c.getKhuyenMaiCollection().isEmpty()}">
                                                            <c:forEach var="p" items="${c.getChiTietSanPhamCollection()}">

                                                                <img id="pic1" onmouseover="chaneImage('<i:url value='/images/${p.anhChinh}'/>',${p.getGiaTien()},${c.getMaSanPham()})" src="<i:url value='/images/${p.anhChinh}'/>" height="55px" alt="">

                                                            </c:forEach>  

                                                        </c:if>
                                                    </div>

                                                </div>
                                                <div class="ps-shoe__detail"><a class="ps-shoe__name" href="#">${c.tenSanPham}</a>
                                                    <p class="ps-shoe__categories"><a href="#"> ${c.maNhanHang.tenNhanHang}</a></p>

                                                    <p class="ps-shoe__categories">${c.getChiTietSanPhamCollection().size()} Colours</p>

                                                    <c:if test="${!c.getKhuyenMaiCollection().isEmpty()}">
                                                        <c:forEach var="b" items="${c.getKhuyenMaiCollection()}">

                                                            <c:if test="${b.getGiaGiam()!=null}">
                                                                <c:forEach var="p" items="${c.getChiTietSanPhamCollection()}" end="0">

                                                                    <del id="giamkhuyenmaiss${c.getMaSanPham()}" style="position: absolute;top: 10px;right: 86px;">${p.getGiaString()}</del>
                                                                    <span class="ps-shoe__price" id="giakmss${c.getMaSanPham()}">
                                                                        ${p.getGiaKmString()}</span>
                                                                    </c:forEach>
                                                                </c:if>




                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${s.getKhuyenMaiCollection().isEmpty()}">
                                                        <c:forEach var="p" items="${s.getChiTietSanPhamCollection()}" end="0">

                                                            <span class="ps-shoe__price" id="gias${s.getMaSanPham()}">
                                                                ${p.getGiaString()}
                                                            </span>
                                                        </c:forEach>
                                                    </c:if>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                </c:forEach>  
                            </div>
                        </div>
                    </div>
                </div>
            </c:if>
            <div class="ps-home-testimonial bg--parallax pb-80"  data-background="/Web_Shoes/resources/images/background/parallax.jpg">
                <div class="container">
                    <div class="owl-slider" style="max-height: 60%;" data-owl-auto="true" data-owl-loop="true" data-owl-speed="5000" data-owl-gap="0"
                         data-owl-nav="false" data-owl-dots="true" data-owl-item="1" data-owl-item-xs="1" data-owl-item-sm="1"
                         data-owl-item-md="1" data-owl-item-lg="1" data-owl-duration="1000" data-owl-mousedrag="on"
                         data-owl-animate-in="fadeIn" data-owl-animate-out="fadeOut">
                        <div class="ps-testimonial">
                            <div class="ps-testimonial__thumbnail"><img src="/Web_Shoes/resources/images/testimonial/1.jpg" alt=""><i
                                    class="fa fa-quote-left"></i></div>
                            <header>
                                <select class="ps-rating">
                                    <option value="1">1</option>
                                    <option value="1">2</option>
                                    <option value="1">3</option>
                                    <option value="1">4</option>
                                    <option value="5">5</option>
                                </select>
                                <p>Logan May - CEO & Founder Invision</p>
                            </header>
                            <footer>
                                <p>“Dessert pudding dessert jelly beans cupcake sweet caramels gingerbread. Fruitcake biscuit cheesecake.
                                    Cookie topping sweet muffin pudding tart bear claw sugar plum croissant. “</p>
                            </footer>
                        </div>
                        <div class="ps-testimonial">
                            <div class="ps-testimonial__thumbnail"><img src="/Web_Shoes/resources/images/testimonial/2.jpg" alt=""><i
                                    class="fa fa-quote-left"></i></div>
                            <header>
                                <select class="ps-rating">
                                    <option value="1">1</option>
                                    <option value="1">2</option>
                                    <option value="1">3</option>
                                    <option value="1">4</option>
                                    <option value="5">5</option>
                                </select>
                                <p>Logan May - CEO & Founder Invision</p>
                            </header>
                            <footer>
                                <p>“Dessert pudding dessert jelly beans cupcake sweet caramels gingerbread. Fruitcake biscuit cheesecake.
                                    Cookie topping sweet muffin pudding tart bear claw sugar plum croissant. “</p>
                            </footer>
                        </div>
                        <div class="ps-testimonial">
                            <div class="ps-testimonial__thumbnail"><img src="/Web_Shoes/resources/images/testimonial/3.jpg" alt=""><i
                                    class="fa fa-quote-left"></i></div>
                            <header>
                                <select class="ps-rating">
                                    <option value="1">1</option>
                                    <option value="1">2</option>
                                    <option value="1">3</option>
                                    <option value="1">4</option>
                                    <option value="5">5</option>
                                </select>
                                <p>Logan May - CEO & Founder Invision</p>
                            </header>
                            <footer>
                                <p>“Dessert pudding dessert jelly beans cupcake sweet caramels gingerbread. Fruitcake biscuit cheesecake.
                                    Cookie topping sweet muffin pudding tart bear claw sugar plum croissant. “</p>
                            </footer>
                        </div>
                    </div>
                </div>
            </div>

            <div class="ps-home-contact">
                <div id="contact-map" data-address="New York, NY" data-title="BAKERY LOCATION!" data-zoom="17"></div>
                <div class="ps-home-contact__form">
                    <header>
                        <h3>Contact Us</h3>
                        <p>Learn about our company profile, communityimpact, sustainable motivation, and more.</p>
                    </header>
                    <footer>
                        <form action="product-listing.html" method="post">
                            <div class="form-group">
                                <label>Name<span>*</span></label>
                                <input class="form-control" type="text">
                            </div>
                            <div class="form-group">
                                <label>Email<span>*</span></label>
                                <input class="form-control" type="email">
                            </div>
                            <div class="form-group">
                                <label>Your message<span>*</span></label>
                                <textarea class="form-control" rows="4"></textarea>
                            </div>
                            <div class="form-group text-center">
                                <button class="ps-btn">Send Message<i class="fa fa-angle-right"></i></button>
                            </div>
                        </form>
                    </footer>
                </div>
            </div>
            <jsp:include page="footer.jsp"></jsp:include>
            </main>
            <!-- JS Library-->
        <jsp:include page="script.jsp"></jsp:include>
        <script>

            $(document).ready(function () {
                $(".owl-carousel").owlCarousel({
                    items: 1,
                    lazyLoad: true,
                    loop: true,
                    nav: true,
                    dots: true,
                    autoplay: true,
                    autoplaySpeed: 1000,
                    smartSpeed: 1500,
                    autoplayHoverPause: true
                });
            });
            var pic = document.querySelector('#pic');


            function chaneImage(imgSrc, gia, sanphan, giamgia) {
                var format2 = new Intl.NumberFormat('vi-VN', {
                    style: 'currency',
                    currency: 'VND'
                })

                pic.img = imgSrc;
                if (giamgia != null) {

                    var giagoc = format2.format(gia)
                    $("#giamkhuyenmai" + sanphan).text(giagoc);
                    $("#giamkhuyenmais" + sanphan).text(giagoc);
                    $("#giamkhuyenmaiss" + sanphan).text(giagoc);
                    var giaKm = gia - ((gia / 100) * giamgia);
                    var giakhuyen = format2.format(giaKm)
                    $("#giakm" + sanphan).text(giakhuyen);
                    $("#giakms" + sanphan).text(giakhuyen);
                    $("#giakmss" + sanphan).text(giakhuyen);
                } else {
                    var giagoc = format2.format(gia)
                    $("#gia" + sanphan).text(giagoc);
                    $("#gias" + sanphan).text(giagoc);


                }


            }
        </script>
    </body>

</html>