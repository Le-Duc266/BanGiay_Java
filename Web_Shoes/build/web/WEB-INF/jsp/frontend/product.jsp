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
       
        <body class="ps-loading">
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
                <div  class="ps-products-wrap pt-80 pb-80">
                    <div  id="phantrang" class="ps-products"  cellspacing="0" data-mh="product-listing">
                        <div class="ps-product-action">
                            <div class="ps-product__filter">
                                <select class="ps-select selectpicker">
                                    <option value="1">Shortby</option>
                                    <option value="2">Name</option>
                                    <option value="3">Price (Low to High)</option>
                                    <option value="3">Price (High to Low)</option>
                                </select>
                            </div>
                        </div>
                        <div class="ps-product__columns">
                        <c:forEach var="s" items="${sanpham}">
                            <div class="ps-product__column">
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
                                                                                                                     alt="" height="330px" ><a class="ps-shoe__overlay" href="/Web_Shoes/SanPhamDetail?maSanPham=${s.maSanPham}">
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
                                        <div class="ps-shoe__detail"><a class="ps-shoe__name" href="#">${s.tenSanPham}</a>
                                            <p class="ps-shoe__categories"><a href="#"> ${s.maNhanHang.tenNhanHang}</a></p>

                                            <p class="ps-shoe__categories">${s.getChiTietSanPhamCollection().size()} Colours</p>

                                            <c:if test="${!s.getKhuyenMaiCollection().isEmpty()}">
                                                <c:forEach var="b" items="${s.getKhuyenMaiCollection()}">

                                                    <c:if test="${b.getGiaGiam()!=null}">
                                                        <c:forEach var="p" items="${s.getChiTietSanPhamCollection()}" end="0">

                                                            <del id="giamkhuyenmai${s.getMaSanPham()}" style="position: absolute;top: 27px;right: 86px;">${p.getGiaString()}</del>
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
                        </c:forEach>
                            
                    </div>
                    
                </div>
                <div class="ps-sidebar" data-mh="product-listing">
                    <aside class="ps-widget--sidebar ps-widget--category">
                        <div class="ps-widget__header">
                            <h3>Category</h3>
                        </div>
                        <div class="ps-widget__content">
                            <ul class="ps-list--checked">
                                <li class="current"><a href="product-listing.html">Life(521)</a></li>
                                <li><a href="product-listing.html">Running(76)</a></li>
                                <li><a href="product-listing.html">Baseball(21)</a></li>
                                <li><a href="product-listing.html">Football(105)</a></li>
                                <li><a href="product-listing.html">Soccer(108)</a></li>
                                <li><a href="product-listing.html">Trainning & game(47)</a></li>
                                <li><a href="product-listing.html">More</a></li>
                            </ul>
                        </div>
                    </aside>
                    <aside class="ps-widget--sidebar ps-widget--filter">
                        <div class="ps-widget__header">
                            <h3>Category</h3>
                        </div>
                        <div class="ps-widget__content">
                            <div class="ac-slider" data-default-min="300" data-default-max="2000" data-max="3450" data-step="50" data-unit="$"></div>
                            <p class="ac-slider__meta">Price:<span class="ac-slider__value ac-slider__min"></span>-<span class="ac-slider__value ac-slider__max"></span></p><a class="ac-slider__filter ps-btn" href="#">Filter</a>
                        </div>
                    </aside>
                    <aside class="ps-widget--sidebar ps-widget--category">
                        <div class="ps-widget__header">
                            <h3>Sky Brand</h3>
                        </div>
                        <div class="ps-widget__content">
                            <ul class="ps-list--checked">
                                <li class="current"><a href="product-listing.html">Nike(521)</a></li>
                                <li><a href="product-listing.html">Adidas(76)</a></li>
                                <li><a href="product-listing.html">Baseball(69)</a></li>
                                <li><a href="product-listing.html">Gucci(36)</a></li>
                                <li><a href="product-listing.html">Dior(108)</a></li>
                                <li><a href="product-listing.html">B&G(108)</a></li>
                                <li><a href="product-listing.html">Louis Vuiton(47)</a></li>
                            </ul>
                        </div>
                    </aside>
                    <aside class="ps-widget--sidebar ps-widget--category">
                        <div class="ps-widget__header">
                            <h3>Width</h3>
                        </div>
                        <div class="ps-widget__content">
                            <ul class="ps-list--checked">
                                <li class="current"><a href="product-listing.html">Narrow</a></li>
                                <li><a href="product-listing.html">Regular</a></li>
                                <li><a href="product-listing.html">Wide</a></li>
                                <li><a href="product-listing.html">Extra Wide</a></li>
                            </ul>
                        </div>
                    </aside>
                    <div class="ps-sticky desktop">
                        <aside class="ps-widget--sidebar">
                            <div class="ps-widget__header">
                                <h3>Size</h3>
                            </div>
                            <div class="ps-widget__content">
                                <table class="table ps-table--size">
                                    <tbody>
                                        <tr>
                                            <td class="active">3</td>
                                            <td>5.5</td>
                                            <td>8</td>
                                            <td>10.5</td>
                                            <td>13</td>
                                        </tr>
                                        <tr>
                                            <td>3.5</td>
                                            <td>6</td>
                                            <td>8.5</td>
                                            <td>11</td>
                                            <td>13.5</td>
                                        </tr>
                                        <tr>
                                            <td>4</td>
                                            <td>6.5</td>
                                            <td>9</td>
                                            <td>11.5</td>
                                            <td>14</td>
                                        </tr>
                                        <tr>
                                            <td>4.5</td>
                                            <td>7</td>
                                            <td>9.5</td>
                                            <td>12</td>
                                            <td>14.5</td>
                                        </tr>
                                        <tr>
                                            <td>5</td>
                                            <td>7.5</td>
                                            <td>10</td>
                                            <td>12.5</td>
                                            <td>15</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </aside>
                        <aside class="ps-widget--sidebar">
                            <div class="ps-widget__header">
                                <h3>Color</h3>
                            </div>
                            <div class="ps-widget__content">
                                <ul class="ps-list--color">
                                    <li><a href="#"></a></li>
                                    <li><a href="#"></a></li>
                                    <li><a href="#"></a></li>
                                    <li><a href="#"></a></li>
                                    <li><a href="#"></a></li>
                                    <li><a href="#"></a></li>
                                    <li><a href="#"></a></li>
                                    <li><a href="#"></a></li>
                                    <li><a href="#"></a></li>
                                    <li><a href="#"></a></li>
                                    <li><a href="#"></a></li>
                                    <li><a href="#"></a></li>
                                    <li><a href="#"></a></li>
                                </ul>
                            </div>
                        </aside>
                    </div>

                </div>
            </div>
            <jsp:include page="footer.jsp"></jsp:include>
            </main>
            <!-- JS Library-->
        <jsp:include page="script.jsp"></jsp:include>
        <script>
            $(document).ready(function () {
                $('#phantrang').dataTable({
                    "n": "full_numbers",
                    "lengthMenu": [[5, 10, 20, -1], [5, 10, 20, "All"]],
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
                   
                    var giaKm = gia - ((gia / 100) * giamgia);
                    var giakhuyen = format2.format(giaKm)
                    $("#giakm" + sanphan).text(giakhuyen);
                    
                } else {
                    var giagoc = format2.format(gia)
                    $("#gia" + sanphan).text(giagoc);
                    
                   

                }


            }
        </script>
    </body>
</html>