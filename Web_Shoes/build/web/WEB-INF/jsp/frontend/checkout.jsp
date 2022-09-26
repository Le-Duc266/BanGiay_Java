<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="i" uri="http://www.springframework.org/tags" %>
<html lang="en">
    <head>
        <jsp:include page="linkcss.jsp"></jsp:include>
        <link rel="stylesheet" href="<c:url value="/resources/frontend/css/toastr.min.css"/>">

    </head>
    <body>
        <div class="header--sidebar"></div>
        <jsp:include page="header.jsp"></jsp:include>
            <div class="header-services">
                <div class="ps-services owl-slider" data-owl-auto="true" data-owl-loop="true" data-owl-speed="7000" data-owl-gap="0" data-owl-nav="true" data-owl-dots="false" data-owl-item="1" data-owl-item-xs="1" data-owl-item-sm="1" data-owl-item-md="1" data-owl-item-lg="1" data-owl-duration="1000" data-owl-mousedrag="on">
                    <p class="ps-service"><i class="ps-icon-delivery"></i><strong>Free delivery</strong>: Get free standard delivery on every order with Sky Store</p>
                    <p class="ps-service"><i class="ps-icon-delivery"></i><strong>Free delivery</strong>: Get free standard delivery on every order with Sky Store</p>
                    <p class="ps-service"><i class="ps-icon-delivery"></i><strong>Free delivery</strong>: Get free standard delivery on every order with Sky Store</p>
                </div>
            </div>
            <main class="ps-main">
                <div class="ps-checkout pt-80 pb-80">
                    <div class="ps-container">
                        <form class="ps-checkout__form" action="/Web_Shoes/ThemHoaDon" onsubmit="return myFunction()"  method="POST">
                            <div class="row">
                                <div class="col-lg-8 col-md-8 col-sm-12 col-xs-12 ">
                                    <div class="ps-checkout__billing">
                                        <h3>Thanh Toán Đơn Hàng</h3>

                                        <div class="form-group form-group--inline" hidden>

                                            <input class="form-control" type="text" name="maHoaDon" value="0">
                                        </div>
                                        <div class="form-group form-group--inline">
                                            <label>Họ Và Tên<span>*</span>
                                            </label>
                                            <input class="form-control" type="text" name="tenKhachHang" id="tenKhachHang" value="${nhanvien.hoTen}">
                                            
                                        <div class="invalid-feedback" style="display:block;font-size:15px;color: red"></div>
                                    </div>

                                    <div class="form-group form-group--inline">
                                        <label>Email<span>*</span>
                                        </label>
                                        <input class="form-control" type="email" id="email" name="email" value="${nhanvien.email}">
                                        
                                        <div class="invalid-feedback" style="display:block;font-size:15px;color: red"></div>
                                    </div>

                                    <div class="form-group form-group--inline">
                                        <label>Số Điện Thoại<span>*</span>
                                       </label>
                                        <input class="form-control" type="text" id="soDT" name="soDT" value="${nhanvien.soDT}">
                                         
                                        <div class="invalid-feedback" style="display:block;font-size:15px;color: red"></div>
                                    </div>

                                    <div class="form-group form-group--inline">
                                        <label>Địa chỉ Nhận hàng<span>*</span>
                                        </label>
                                        <input class="form-control" type="text" id="diaChiGiaoHang"  name="diaChiGiaoHang" value="${nhanvien.diaChi}">
                                        
                                        <div class="invalid-feedback" style="display:block;font-size:15px;color: red"></div>
                                    </div>

                                </div>
                            </div>
                            <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 ">
                                <div class="ps-checkout__order">
                                    <header>
                                        <h3>Đơn Hàng Của Bạn</h3>
                                    </header>
                                    <div class="content">
                                        <table class="table ps-checkout__products">
                                            <thead>
                                                <tr>
                                                    <th class="text-uppercase">Sản Phảm</th>
                                                    <th class="text-uppercase">Màu-Size</th>
                                                    <th class="text-uppercase">Tổng iền</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach var="giohang" items="${gioHangs}">
                                                    <tr>
                                                        <td><a class="ps-product__preview" href="#"><img class="mr-15" src="<i:url value='/images/${giohang.anh}'/>"  width="50px;" height="50px;" alt=""><span>${giohang.tenSanPham}*${giohang.soluong}</span>
                                                            </a></td>
                                                        <td style="padding-top: 20px;"><span>${giohang.tenMau}</span>-<span>${giohang.size}</span></td>
                                                        <td style="padding-top: 20px;">${giohang.getTinhTongtien()}</td>
                                                    </tr>
                                                </c:forEach>
                                                <tr>
                                                    <td>Tổng Tiền</td>
                                                    <td></td>
                                                    <td>${tongtien}</td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                    <footer>


                                        <div class="form-group paypal">

                                            <button type="submit" class="ps-btn ps-btn--fullwidth">Thanh toán<i class="ps-icon-next"></i></button>
                                        </div>
                                    </footer>
                                </div>

                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <jsp:include page="footer.jsp"></jsp:include>
            </main>
            <!-- JS Library-->
        <jsp:include page="script.jsp"></jsp:include>
        <script>
            function myFunction() {
                var check = true;

                var email = $('#email').val();

                var hoTen = $('#tenKhachHang').val();
                var soDT = $('#soDT').val();
                var diaChi = $('#diaChiGiaoHang').val();

                var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;

                if (email === '') {
                    $('#email').parent().next().html('email không được để trống!');
                    check = false;
                } else if (filter.test(email.value)) {
                    $('#email').parent().next().html('email không hợp lệ!');
                    check = false;
                } else {
                    $('#email').parent().next().html('');
                    check = true;
                }

                if (hoTen === '') {
                    $('#tenKhachHang').parent().next().html('họ tên không được để trống!');
                    check = false;
                } else {
                    $('#tenKhachHang').parent().next().html('');

                    check = true;
                }
                if (soDT === '') {
                    $('#soDT').parent().next().html('số điện thoại không được để trống!');
                    check = false;
                } else {
                    $('#soDT').parent().next().html('');

                    check = true;
                }
                if (diaChi === '') {
                    $('#diaChi').parent().next().html('Đại Chi không được để trống!');
                    check = false;
                } else {
                    $('#tenDn').parent().next().html('');

                    check = true;
                }

                if (hoTen === '') {
                    $('#tenKhachHang').parent().next().html('họ tên không được để trống!');
                    check = false;
                }
                if (soDT === '') {
                    $('#soDT').parent().next().html('số điện thoại không được để trống!');
                    check = false;
                } else if (checksoDT(soDT)) {
                    $('#soDT').parent().next().html('số Điện Thoại đã tồn tại!');
                    check = false;
                }
                if (diaChi === '') {
                    $('#diaChiGiaoHang').parent().next().html('Đại Chi không được để trống!');
                    check = false;
                }
                if (email === '') {
                    $('#email').parent().next().html('email không được để trống!');
                    check = false;
                } else if (filter.test(email.value)) {
                    $('#email').parent().next().html('email không hợp lệ!');
                    check = false;
                }
                if (hoTen === '') {
                    $('#tenKhachHang').parent().next().html('họ tên không được để trống!');
                    check = false;
                }

                return check;

            }
        </script>
    </body>
</html>