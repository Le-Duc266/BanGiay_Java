
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="i" uri="http://www.springframework.org/tags" %>
<html lang="en">
    <head>
        <jsp:include page="linkcss.jsp"></jsp:include>
        <link rel="stylesheet" href="<c:url value="/resources/frontend/css/toastr.min.css"/>">
        <style>
            .css-12whm6j {
                display: grid;
                grid-template-columns: repeat(3, 1fr);
                gap: 7px;
            }
            .mt2-sm {
                margin-top: 8px;
            }
            .visually-hidden {
                position: absolute!important;
                height: 1px;
                width: 1px;
                overflow: hidden;
                clip: rect(1px 1px 1px 1px);
                clip: rect(1px,1px,1px,1px);
                white-space: nowrap;
            }
            .css-1pj6y87 input[type="radio"]:disabled + label {
                cursor: default;
                color: rgb(221, 221, 221);
                background: rgb(247, 247, 247);
                border: none;
            }.css-1pj6y87 input[type="radio"].visually-hidden + label {
                outline: none;
            }.css-12whm6j > :not(input):not(label) > label {
                -webkit-box-flex: 1;
                flex-grow: 1;
                display: flex;
                -webkit-box-align: center;
                align-items: center;
                -webkit-box-pack: center;
                justify-content: center;
            }
            .css-1pj6y87 label {
                background: rgb(255, 255, 255);
                color: rgb(17, 17, 17);
                box-shadow: rgb(229 229 229) 0px 0px 0px 1px;
            }.css-xf3ahq {
                height: 48px;
                border-radius: 4px;
            }.swatch input {
                display: none;
            }
            .swatch input:checked + label {
                border: 1px solid rgb(17, 17, 17);
            }
            .css-1pj6y87 input[type="radio"]:not(:disabled) + label {
                cursor: pointer;
            }
            .css-1pj6y87 input[type="radio"]:checked + label {
                box-shadow: rgb(17 17 17) 0px 0px 0px 1px inset;
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
                <div class="test">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4 ">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="ps-product--detail pt-60">
                    <div class="ps-container">
                        <div class="row">
                            <div class="col-lg-10 col-md-12 col-lg-offset-1">
                                <div class="ps-product__thumbnail"  id="anhSp" >
                                    <div class="ps-product__preview">
                                        <div class="ps-product__variants">
                                        <c:forEach var="p" items="${sanpham.getChiTietSanPhamCollection()}" end="1">
                                            <c:forEach var="d" items="${p.getAnhSanPhamCollection()}">
                                                <c:if test="${p.mauSanPham.maMau==d.anhSanPhamPK.maMau}">
                                                    <div class="item"><img src="<i:url value='/images/${d.linkAnh}'/>" height="55px" alt=""></div>
                                                    </c:if>
                                                </c:forEach>
                                            </c:forEach> 

                                    </div>
                                </div>
                                <div class="ps-product__image">
                                    <c:forEach var="p" items="${sanpham.getChiTietSanPhamCollection()}" end="0">
                                        <c:forEach var="d" items="${p.getAnhSanPhamCollection()}">
                                            <c:if test="${p.mauSanPham.maMau==d.anhSanPhamPK.maMau}">
                                                <div class="item"><img class="zoom" src="<i:url value='/images/${d.linkAnh}'/>" alt=""></div>

                                            </c:if>
                                        </c:forEach>
                                    </c:forEach> 
                                </div>
                            </div>
                            <div class="ps-product__thumbnail--mobile">
                                <div class="ps-product__main-img"><img src="images/shoe-detail/1.jpg" alt=""></div>
                                <div class="ps-product__preview owl-slider" data-owl-auto="true" data-owl-loop="true" data-owl-speed="5000" data-owl-gap="20" data-owl-nav="true" data-owl-dots="false" data-owl-item="3" data-owl-item-xs="3" data-owl-item-sm="3" data-owl-item-md="3" data-owl-item-lg="3" data-owl-duration="1000" data-owl-mousedrag="on"><img src="images/shoe-detail/1.jpg" alt=""><img src="images/shoe-detail/2.jpg" alt=""><img src="images/shoe-detail/3.jpg" alt=""></div>
                            </div>
                            <div class="ps-product__info">

                                <h1>${sanpham.tenSanPham}</h1>
                                <p class="ps-product__category"><a href="#">${sanpham.maDanhMuc.tenDanhMuc}</a></p>
                                    <c:if test="${!sanpham.getKhuyenMaiCollection().isEmpty()}">
                                        <c:forEach var="b" items="${sanpham.getKhuyenMaiCollection()}">

                                        <c:if test="${b.getGiaGiam()!=null}">
                                            <c:forEach var="p" items="${sanpham.getChiTietSanPhamCollection()}" end="0">
                                                <span id="giakhuyenmai" class="ps-product__price">${p.getGiaKmString()}</span>
                                                <del id="gia">${p.getGiaString()}</del>
                                            </c:forEach>
                                        </c:if>




                                    </c:forEach>
                                </c:if>
                                <c:if test="${sanpham.getKhuyenMaiCollection().isEmpty()}">
                                    <c:forEach var="p" items="${sanpham.getChiTietSanPhamCollection()}" end="0">

                                        <span id="giakhuyenmai" class="ps-product__price">${p.getGiaString()}</span>

                                    </c:forEach>
                                </c:if>

                                <div class="ps-product__block ps-product__quickview">
                                    <h4>${sanpham.maNhanHang.tenNhanHang}</h4>
                                    <p>${sanpham.moTa}</p>
                                </div>
                                <div class="ps-product__block ps-product__style " id="chonmau">
                                    <h4>CHOOSE YOUR STYLE</h4>
                                    <ul class="swatch" >
                                        <c:if test="${!sanpham.getKhuyenMaiCollection().isEmpty()}">
                                            <c:forEach var="b" items="${sanpham.getKhuyenMaiCollection()}">
                                                <c:forEach var="p" items="${sanpham.getChiTietSanPhamCollection()}">

                                                    <li>
                                                        <input id="${p.mauSanPham.maMau}" id="chonmau${p.mauSanPham.maMau}" type="radio" name="option-0" value="${p.mauSanPham.maMau}">

                                                        <label for="${p.mauSanPham.maMau}"><img id="pic" onclick="chaneImages(${sanpham.getMaSanPham()},${p.mauSanPham.maMau},${p.getGiaTien()},${b.getGiaGiam()})" src="<i:url value='/images/${p.anhChinh}'/>" height="55px" alt=""></label></li>


                                                </c:forEach>

                                            </c:forEach>
                                        </c:if>
                                        <c:if test="${sanpham.getKhuyenMaiCollection().isEmpty()}">
                                            <c:forEach var="p" items="${sanpham.getChiTietSanPhamCollection()}">

                                                <li>
                                                    <input id="${p.mauSanPham.maMau}" class="chonmau" type="radio" name="option-0" value="${p.mauSanPham.maMau}">

                                                    <label for="${p.mauSanPham.maMau}"><img id="pic" onclick="chaneImages(${sanpham.getMaSanPham()},${p.mauSanPham.maMau},${p.getGiaTien()})" src="<i:url value='/images/${p.anhChinh}'/>" height="55px" alt=""></label>


                                                </li>

                                            </c:forEach>  

                                        </c:if>
                                        


                                    </ul>
                                    <div class="invalid-feedback" style="display:block;color: red;"></div>

                                </div>
                                <div class="ps-product__block ps-product__size css-1pj6y87" id="size">
                                    <h4>CHOOSE SIZE<a href="#">Size chart</a></h4>
                                    <div class="mt2-sm css-12whm6j" id="masize">
                                        <c:forEach var="p" items="${sanpham.getChiTietSanPhamCollection()}" end="0">
                                            <c:forEach var="c" items="${p.getSoLuongSanPhamCollection()}">
                                                <c:if test="${c.getStatus()=='true'}">
                                                    <div class="masiz">

                                                        <input id="${c.sizeSanPham.size}" type="radio" class="visually-hidden">
                                                        <label for="${c.sizeSanPham.size}" tabindex="-1" class="css-xf3ahq">${c.sizeSanPham.size}</label>

                                                    </div>
                                                </c:if>
                                                <c:if test="${c.getStatus()=='false'}">
                                                    <div class="masiz">

                                                        <input id="${c.sizeSanPham.size}" type="radio" disabled class="visually-hidden">
                                                        <label for="${c.sizeSanPham.size}" tabindex="-1" class="css-xf3ahq">${c.sizeSanPham.size}</label>
                                                       
                                                    </div>
                                                </c:if>
                                            </c:forEach>
                                        </c:forEach> 
                                        
                                    </div>
                                    <div class="invalid-feedback" style="display:block;color: red;"></div>
                                    <div class="form-group" style="padding-top: 20px;">
                                        <input id="sanPham" type="radio" value="${sanpham.maSanPham}" hidden>
                                        <input class="form-control quantity" type="number" min="1" value="1" style="width: 135px;">
                                    </div>
                                    <div class="ps-product__shopping"><a class="ps-btn mb-10 btn-add-to-cart">Add to cart<i class="ps-icon-next"></i></a>
                                        <div class="ps-product__actions"><a class="mr-10" href="whishlist.html"><i class="ps-icon-heart"></i></a><a href="compare.html"><i class="ps-icon-share"></i></a></div>
                                    </div>
                                </div>


                            </div>
                            <div class="clearfix"></div>
                            <div class="ps-product__content mt-50">
                                <ul class="tab-list" role="tablist">
                                    <li class="active"><a href="#tab_01" aria-controls="tab_01" role="tab" data-toggle="tab">Overview</a></li>
                                    <li><a href="#tab_02" aria-controls="tab_02" role="tab" data-toggle="tab">Review</a></li>
                                    <li><a href="#tab_03" aria-controls="tab_03" role="tab" data-toggle="tab">PRODUCT TAG</a></li>
                                    <li><a href="#tab_04" aria-controls="tab_04" role="tab" data-toggle="tab">ADDITIONAL</a></li>
                                </ul>
                            </div>
                            <div class="tab-content mb-60">
                                <div class="tab-pane active" role="tabpanel" id="tab_01">
                                    <p>Caramels tootsie roll carrot cake sugar plum. Sweet roll jelly bear claw liquorice. Gingerbread lollipop dragée cake. Pie topping jelly-o. Fruitcake dragée candy canes tootsie roll. Pastry jelly-o cupcake. Bonbon brownie soufflé muffin.</p>
                                    <p>Sweet roll soufflé oat cake apple pie croissant. Pie gummi bears jujubes cake lemon drops gummi bears croissant macaroon pie. Fruitcake tootsie roll chocolate cake Carrot cake cake bear claw jujubes topping cake apple pie. Jujubes gummi bears soufflé candy canes topping gummi bears cake soufflé cake. Cotton candy soufflé sugar plum pastry sweet roll..</p>
                                </div>
                                <div class="tab-pane" role="tabpanel" id="tab_02">
                                    <p class="mb-20">1 review for <strong>Shoes Air Jordan</strong></p>
                                    <div class="ps-review">
                                        <div class="ps-review__thumbnail"><img src="images/user/1.jpg" alt=""></div>
                                        <div class="ps-review__content">
                                            <header>
                                                <select class="ps-rating">
                                                    <option value="1">1</option>
                                                    <option value="1">2</option>
                                                    <option value="1">3</option>
                                                    <option value="1">4</option>
                                                    <option value="5">5</option>
                                                </select>
                                                <p>By<a href=""> Alena Studio</a> - November 25, 2017</p>
                                            </header>
                                            <p>Soufflé danish gummi bears tart. Pie wafer icing. Gummies jelly beans powder. Chocolate bar pudding macaroon candy canes chocolate apple pie chocolate cake. Sweet caramels sesame snaps halvah bear claw wafer. Sweet roll soufflé muffin topping muffin brownie. Tart bear claw cake tiramisu chocolate bar gummies dragée lemon drops brownie.</p>
                                        </div>
                                    </div>
                                    <form class="ps-product__review" action="_action" method="post">
                                        <h4>ADD YOUR REVIEW</h4>
                                        <div class="row">
                                            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 ">
                                                <div class="form-group">
                                                    <label>Name:<span>*</span></label>
                                                    <input class="form-control" type="text" placeholder="">
                                                </div>
                                                <div class="form-group">
                                                    <label>Email:<span>*</span></label>
                                                    <input class="form-control" type="email" placeholder="">
                                                </div>
                                                <div class="form-group">
                                                    <label>Your rating<span></span></label>
                                                    <select class="ps-rating">
                                                        <option value="1">1</option>
                                                        <option value="1">2</option>
                                                        <option value="1">3</option>
                                                        <option value="1">4</option>
                                                        <option value="5">5</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="col-lg-8 col-md-8 col-sm-6 col-xs-12 ">
                                                <div class="form-group">
                                                    <label>Your Review:</label>
                                                    <textarea class="form-control" rows="6"></textarea>
                                                </div>
                                                <div class="form-group">
                                                    <button class="ps-btn ps-btn--sm">Submit<i class="ps-icon-next"></i></button>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <div class="tab-pane" role="tabpanel" id="tab_03">
                                    <p>Add your tag <span> *</span></p>
                                    <form class="ps-product__tags" action="_action" method="post">
                                        <div class="form-group">
                                            <input class="form-control" type="text" placeholder="">
                                            <button class="ps-btn ps-btn--sm">Add Tags</button>
                                        </div>
                                    </form>
                                </div>
                                <div class="tab-pane" role="tabpanel" id="tab_04">
                                    <div class="form-group">
                                        <textarea class="form-control" rows="6" placeholder="Enter your addition here..."></textarea>
                                    </div>
                                    <div class="form-group">
                                        <button class="ps-btn" type="button">Submit</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="ps-section ps-section--top-sales ps-owl-root pt-40 pb-80">
                    <div class="ps-container">
                        <div class="ps-section__header mb-50">
                            <div class="row">
                                <div class="col-lg-9 col-md-9 col-sm-12 col-xs-12 ">
                                    <h3 class="ps-section__title" data-mask="Related item">- YOU MIGHT ALSO LIKE</h3>
                                </div>
                                <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12 ">
                                    <div class="ps-owl-actions"><a class="ps-prev" href="#"><i class="ps-icon-arrow-right"></i>Prev</a><a class="ps-next" href="#">Next<i class="ps-icon-arrow-left"></i></a></div>
                                </div>
                            </div>
                        </div>
                        <div class="ps-section__content">
                            <div class="ps-owl--colection owl-slider" data-owl-auto="true" data-owl-loop="true" data-owl-speed="5000" data-owl-gap="30" data-owl-nav="false" data-owl-dots="false" data-owl-item="4" data-owl-item-xs="1" data-owl-item-sm="2" data-owl-item-md="3" data-owl-item-lg="4" data-owl-duration="1000" data-owl-mousedrag="on">
                                <c:forEach var="s" items="${sp}">
                                    <div class="ps-shoes--carousel">
                                        <div class="ps-shoe">
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

                                                                    <del id="giamkhuyenmai${s.getMaSanPham()}" style="position: absolute;top: 10px;right: 86px;">${p.getGiaString()}</del>
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
                                                            </span>đ
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
                <jsp:include page="footer.jsp"></jsp:include>
            </main>
            <!-- JS Library-->
        <jsp:include page="script.jsp"></jsp:include>
        <script type="text/javascript" src="<c:url value="/resources/frontend/js/toastr.min.js"/>"></script>
        <script>
                                                                    $(document).ready(function () {
                                                                        $(".btn-add-to-cart").click(function () {
                                                                            if (ValidateScreening()) {
                                                                                var maSanPham = $("#sanPham").val();
                                                                                var str = $("#giakhuyenmai").text();
                                                                                var quantity = $(".quantity").val();
                                                                                var checkbox = document.getElementsByName("option-0");
                                                                                for (var i = 0; i < checkbox.length; i++) {
                                                                                    if (checkbox[i].checked === true) {
                                                                                        var maMau = checkbox[i].value;
                                                                                    }
                                                                                }
                                                                                var gia1 = str.replaceAll(".", "");
                                                                                var gia2 = gia1.replaceAll("đ", "");
                                                                                var gia = gia2.replaceAll(" ", "");
                                                                                var checkbox1 = document.getElementsByName("skuAndSize");
                                                                                for (var i = 0; i < checkbox1.length; i++) {
                                                                                    if (checkbox1[i].checked === true) {
                                                                                        var maSize = checkbox1[i].value;
                                                                                    }
                                                                                }
                                                                                $.ajax({
                                                                                    url: "${pageContext.request.contextPath}/ThemGioHang",
                                                                                    type: "GET",
                                                                                    data: {
                                                                                        maSanPham: maSanPham,
                                                                                        maMau: maMau,
                                                                                        maSize: maSize,
                                                                                        quantity: quantity,
                                                                                        gia: gia

                                                                                    },
                                                                                    success: function (value) {

                                                                                        if (!value.result) {
                                                                                            $("#giohang").find("span").addClass(".circle-giohang");
                                                                                            $("#giohang").find("span").html("<i>" + value + "</i>");
                                                                                            var quantity = $(".quantity").val(1);
                                                                                            toastr.success('thêm giỏ hàng thành công', 'Success!', {
                                                                                                closeButton: true,
                                                                                                tapToDismiss: false
                                                                                            });
                                                                                        } else {
                                                                                            toastr.error('thêm thất bại!', 'Error!', {
                                                                                                closeButton: true,
                                                                                                tapToDismiss: false
                                                                                            });
                                                                                        }

                                                                                    }

                                                                                })
                                                                            }





                                                                        })
                                                                        function ValidateScreening() {
                                                                            var check = true;
                                                                            var checkbox = document.getElementsByName("option-0");
                                                                            for (var i = 0; i < checkbox.length; i++) {
                                                                                if (checkbox[i].checked === true) {
                                                                                    var maMau = checkbox[i].value;
                                                                                }
                                                                            }

                                                                            var checkbox1 = document.getElementsByName("skuAndSize");
                                                                            for (var i = 0; i < checkbox1.length; i++) {
                                                                                if (checkbox1[i].checked === true) {
                                                                                    var maSize = checkbox1[i].value;
                                                                                }
                                                                            }

                                                                            if (maMau == null) {
                                                                                $('#chonmau ul li').parent().next().html('bạn chưa chọn mau!');
                                                                                check = false;
                                                                            } else { 
                                                                                $('#chonmau ul li').parent().next().html('');
                                                                            }
                                                                            if (maSize == null) {
                                                                                $('#size div div').parent().next().html('bạn chưa chọn size!');
                                                                                check = false;
                                                                            } else {
                                                                                $('#size div div').parent().next().html('');
                                                                            }




                                                                            return check;

                                                                        }
                                                                    })
        </script>
        <script>




            function chaneImages(sanphan, mamau, gia, giamgia) {
                var format2 = new Intl.NumberFormat('vi-VN', {
                    style: 'currency',
                    currency: 'VND'
                })



                Number.prototype.format = function (n, x) {
                    var re = '\\d(?=(\\d{' + (x || 3) + '})+' + (n > 0 ? '\\.' : '$') + ')';
                    return this.toFixed(Math.max(0, ~~n)).replace(new RegExp(re, 'g'), '$&.');
                };
                if (giamgia != null) {

                    var giagoc = format2.format(gia);
                    $("#gia").text(giagoc);
                    var giaKm = gia - ((gia / 100) * giamgia);
                    var giakhuyen = giaKm.format();
                    $("#giakhuyenmai").text(giakhuyen + " đ");
                } else {
                    var giagoc = gia.format();
                    $("#giakhuyenmai").text(giagoc + " đ");
                }

                $.ajax({
                    url: "${pageContext.request.contextPath}/Size",
                    type: "GET",
                    data: {
                        sanphan: sanphan,
                        mamau: mamau

                    },
                    success: function (value) {
                        var size = $("#masize").empty();
                        size.append(value);
                    }
                });
                $.ajax({
                    url: "${pageContext.request.contextPath}/anhSp",
                    type: "GET",
                    data: {
                        sanphan: sanphan,
                        mamau: mamau

                    },
                    success: function (value) {
                        var data = $("#anhSp").empty();
                        data.append(value);
                    }

                });
            }

        </script>
        
    </body>
</html>