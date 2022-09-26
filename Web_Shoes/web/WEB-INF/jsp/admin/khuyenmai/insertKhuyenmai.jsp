<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <jsp:include page="../linkcss.jsp"></jsp:include>
        <link rel="stylesheet" href="<c:url value="/resources/css/Select2.min.css"/>">
        
        <style>
                        .datachon2{display: none}
                        .datachon3{display: none}
                        .select2-selection--multiple{height: 45px;}
                        .select2-container--default .select2-selection--single .select2-selection__rendered {
    color: #444;
    line-height: 28px !important;
}
.btn-gradient-yellow {
    background-color: #ffae01;
}
.btn-fill-lg {
    display: inline-block;
    border: none;
    border-radius: 4px;
    font-weight: 500;
    color: #ffffff;
    letter-spacing: 1px;
    padding: 12px 45px;
    cursor: pointer;
    -webkit-transition: all 0.3s ease-out;
    -moz-transition: all 0.3s ease-out;
    -ms-transition: all 0.3s ease-out;
    -o-transition: all 0.3s ease-out;
    transition: all 0.3s ease-out;
}
.select2-container--default .select2-selection--multiple .select2-selection__choice {
    color: #ffffff;
    border: 0;
    border-radius: 3px;
    padding: 6px;
    font-size: 1rem !important;
    font-family: inherit;
    line-height: 1;
}
.select2-container .select2-selection--single {
    box-sizing: border-box;
    cursor: pointer;
    display: block;
    height: 54px !important;
    user-select: none;
    -webkit-user-select: none;
}
.select2-container--default .select2-selection--single .select2-selection__arrow b {
    border-color: #888 transparent transparent transparent;
    border-style: solid;
    border-width: 5px 4px 0 4px;
    height: 0;
    left: -23% !important;
    margin-left: -4px;
    margin-top: -2px;
    position: absolute;
    top: 100% !important;
    width: 0;
}
.select2-container--default.select2-container--focus .select2-selection--multiple {
    border: solid black 1px;
    outline: 0;
    height: 52px !important;
}
.select2-container--default .select2-selection--multiple {
    background-color: white;
    border: 1px solid #aaa;
    border-radius: 4px;
    cursor: text;
    height: 53px !important;
}
        </style>
    </head>
    <body>

        <div class="container-scroller">
            <!-- partial:partials/_navbar.html -->
            <jsp:include page="../header.jsp"></jsp:include>
                <!-- partial -->
                <div class="container-fluid page-body-wrapper">
                    <!-- partial:partials/_settings-panel.html -->
                <jsp:include page="../head.jsp"></jsp:include>
                    <!-- partial -->
                    <!-- partial:partials/_sidebar.html -->
                <jsp:include page="../menu.jsp"></jsp:include>
                    <!-- partial -->
                    <div class="main-panel">
                        <div class="content-wrapper">
                            <div class="row">
                                <div class="col-md-12 grid-margin ">
                                    <div class="card">
                                        <div class="card-body">
                                            <h4 class="card-title">Thêm Mới Khuyến mãi</h4>
                                            <form action="/Web_Shoes/admin/khuyenmai/insertKM" method="POST" class="forms-sample" onsubmit="return validate()">
                                                <div class="forms-sample">
                                                    <div class="error" style="color: red">
                                                    ${error}
                                                </div>
                                                <div class="row">


                                                    <label class="block clearfix">
                                                        <span class="block input-icon input-icon-right">
                                                            <input type="hidden" name="maKhuyenMai" class="input-control type_1" id="maKhuyenMai" value="0"/>
                                                        </span>
                                                    </label>

                                                    <div class="col-xl-3 col-lg-6 col-12 form-group">
                                                        <label>tên khuyến mãi *</label>
                                                        <div>
                                                            <input type="text" class="form-control" placeholder="Tên khuyến mãi ..." id="tenKhuyenMai" name="tenKhuyenMai">
                                                        </div>
                                                        <div class="invalid-feedback" style="display:block;font-size:15px;color: red"></div>
                                                    </div>

                                                    <div class="col-xl-3 col-lg-6 col-12 form-group">
                                                        <label>giảm giá *</label>
                                                        <div>


                                                            <input type="number" class="form-control" placeholder="giảm giá ..." id="giaGiam" name="giaGiam">

                                                        </div>
                                                        <div class="invalid-feedback" style="display:block;font-size:15px;color: red"></div>
                                                    </div>



                                                    <div class="col-xl-3 col-lg-6 col-12 form-group">
                                                        <label>thời gian bắt đầu</label>
                                                        <div>

                                                            <input type="text" id="batdau" name="thoiGianBatDau" placeholder="dd/mm/yyyy" class="form-control flatpickr-input" data-position="bottom right" readonly="readonly">
                                                            <i class="far fa-calendar-alt"></i>

                                                        </div>
                                                        <div class="invalid-feedback" style="display:block;font-size:15px;color: red"></div>
                                                    </div>

                                                    <div class="col-xl-3 col-lg-6 col-12 form-group">
                                                        <label for="TimeIn">thời gian bắt đầu</label>
                                                        <div>
                                                            <input type="text" id="ketthuc" name="thoiGianKetThuc" placeholder="dd/mm/yyyy" class="form-control flatpickr-input" data-position="bottom right" readonly="readonly">
                                                            <i class="far fa-calendar-alt"></i>

                                                        </div>
                                                        <div class="invalid-feedback" style="display:block;font-size:15px;color: red"></div>
                                                    </div>

                                                    <div class="col-xl-3 col-lg-6 col-12">

                                                        <label>khuyến mại theo</label>
                                                        <div>
                                                            <select class="form-control" id="Chon" name="kmtheo">
                                                                <option value="0">--chọn--</option>
                                                                <option value="true">Danh mục</option>
                                                                <option value="false">sản phẩm</option>
                                                            </select>

                                                        </div>
                                                        <div class="invalid-feedback" style="display:block;font-size:15px;color: red"></div>

                                                    </div>

                                                    <div class="col-xl-3 col-lg-6 col-12 datachon1">

                                                        <label class="sanpham">Sản Phẩm</label>
                                                        <div>

                                                            <select class="form-control" id="SanPham1" multiple="multiple">
                                                            </select>


                                                        </div>
                                                        <div class="invalid-feedback" style="display:block;font-size:15px;color: red"></div>

                                                    </div>
                                                    <div class="col-xl-3 col-lg-6 col-12 datachon2">

                                                        <label class="danhmuc">Sản Phẩm</label>
                                                        <div>



                                                            <select class="form-control" name="khuyenmaidanhmuc" id="DanhMuc" multiple="multiple">
                                                                <c:forEach var="a" items="${danhmuc}">
                                                                    <option value="${a.maDanhMuc}">${a.tenDanhMuc}</option>
                                                                </c:forEach>
                                                            </select>

                                                        </div>
                                                        <div class="invalid-feedback" style="display:block;font-size:15px;color: red"></div>

                                                    </div>
                                                    <div class="col-xl-3 col-lg-6 col-12 datachon3">

                                                        <label class="sanpham">Sản Phẩm</label>
                                                        <div>


                                                            <select class="form-control" name="khuyenMaisanpham"  id="SanPham"  multiple="multiple">
                                                                <c:forEach var="s" items="${sanpham}">
                                                                    <option value="${s.maSanPham}">${s.tenSanPham}</option>
                                                                </c:forEach>
                                                            </select>


                                                        </div>
                                                        <div class="invalid-feedback" style="display:block;font-size:15px;color: red"></div>

                                                    </div>

                                                    <div class="col-xl-3 col-lg-6 col-12 form-group">
                                                        <label for="Note">Note</label>
                                                        <div>
                                                            <textarea class="form-control" name="moTa" rows="3" placeholder="Note..."></textarea>



                                                        </div>
                                                    </div>
                                                    <div class="col-12 form-group mg-t-8">
                                                        <button type="submit" class="btn-fill-lg btn-gradient-yellow btn-hover-bluedark">Save</button>
                                                        <button type="reset" class="btn-fill-lg bg-blue-dark btn-hover-yellow" style="background: blue;">Reset</button>
                                                    </div>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- partial -->
                </div>
                <!-- main-panel ends -->
            </div>   
            <!-- page-body-wrapper ends -->
        </div>
        <jsp:include page="../footer.jsp"></jsp:include>

            <script src="<c:url value="/resources/js/Select2.min.js"/>"></script>
        <script>



                                                var minDate = new Date();
                                                minDate.setDate(minDate.getDate() + 2);
                                                $("#batdau").flatpickr({
                                                    minDate: minDate,
                                                    enableTime: true,
                                                    dateFormat: "d-m-Y H:i",
                                                });
                                                $('#ketthuc').flatpickr({
                                                    minDate: minDate,
                                                    enableTime: true,
                                                    dateFormat: "d-m-Y H:i",
                                                });



        </script>

        <script>
            $(document).ready(function () {
                $('#Chon').select2({
                    placeholder: "--chọn--",
                    allowClear: true
                });
                $('#SanPham1').select2({
                    placeholder: "--chọn--",
                    allowClear: true
                });
                $('#DanhMuc').select2({
                    placeholder: "--chọn--",
                    allowClear: true
                });
                $('#SanPham').select2({
                    placeholder: "--chọn--",
                    allowClear: true
                });

//                
                $('#Chon').change(function () {
                    var hallId = $('#Chon').val();
                    if (hallId == 'true') {
                        $('.danhmuc').html('Danh Mục');
                        $('#SanPham').val(null);
                        $('.datachon1').hide();
                        $('.datachon3').hide();
                        $('.datachon2').show();
                        $('#DanhMuc').select2({
                            placeholder: "--chọn--",
                            allowClear: true
                        });
                        $('#SanPham').select2({
                            placeholder: "--chọn--",
                            allowClear: true
                        });
                    } else if (hallId == 'false') {
                         $('#DanhMuc').val(null);
                        $('.sanpham').html('Sản Phẩm');
                        $('.datachon3').show();
                        $('.datachon1').hide();
                        $('.datachon2').hide();
                        $('#DanhMuc').select2({
                            placeholder: "--chọn--",
                            allowClear: true
                        });
                        $('#SanPham').select2({
                            placeholder: "--chọn--",
                            allowClear: true
                        });
                    } else {
                        $('.datachon3').hide();
                        $('.datachon1').show();
                        $('.datachon2').hide();

                    }
//                    FillSanPham();


                });

            });
            function validate() {
                var check = true;

                
                var tenkhuyenmai = $('#tenKhuyenMai').val();
                var giamgia = $('#giaGiam').val();
                var batdau = $('#batdau').val();
                var ketthuc = $('#ketthuc').val();
                var chon = $('#Chon').val();
                var SanPham1 = $('#SanPham1').val();
                var DanhMuc = $('#DanhMuc').val();
                var SanPham = $('#SanPham').val();

                if (tenkhuyenmai === '') {
                    $('#tenKhuyenMai').parent().next().html('tên khuyến mãi không được để trống!');
                    check = false;
                } else {
                    $('#tenKhuyenMai').parent().next().html('');

                    check = true;
                }
                if (giamgia <= 0) {
                    $('#giaGiam').parent().next().html('giảm giá phải lớn hơn 0!');
                    check = false;
                }
                else if (giamgia === '') {
                    $('#giaGiam').parent().next().html('giảm giá không được để trống!');
                    check = false;
                } else {
                    $('#giaGiam').parent().next().html('');
                    check = true;
                }
                if (batdau === '') {
                    $('#batdau').parent().next().html('thời gian không được để trống!');
                    check = false;
                } else {
                    $('#batdau').parent().next().html('');
                    check = true;
                }
                if (ketthuc === '') {
                    $('#ketthuc').parent().next().html('thời gian két thúc không được để trống!');
                    check = false;
                } else {
                    $('#ketthuc').parent().next().html('');
                    check = true;
                }
                if (chon == 0) {
                    $('#Chon').parent().next().html('bạn chưa chọn khuyến mãi theo!');
                    check = false;
                } else {
                    $('#Chon').parent().next().html('');
                    check = true;
                }
                if(chon==0){
                if (SanPham1 == 0 || SanPham1 == null) {
                    $('#SanPham1').parent().next().html('bạn khuyến mãi theo!');
                    check = false;
                } else {
                    $('#SanPham1').parent().next().html('');
                    check = true;

                }}else if(chon=='true'){
                if (DanhMuc == 0 || DanhMuc == null) {
                    $('#DanhMuc').parent().next().html('bạn khuyến mãi theo!');
                    check = false;
                    $('#SanPham1').parent().next().html('');
                    check = true;
                } else {
                    $('#DanhMuc').parent().next().html('');
                    check = true;
                    
                }}else{
                
            if (SanPham == 0 || SanPham == null) {
                    $('#SanPham').parent().next().html('bạn khuyến mãi theo!');
                    check = false;
                    $('#SanPham1').parent().next().html('');
                    check = true;
                } else {
                    $('#SanPham').parent().next().html('');
                    check = true;
                    
                }}
                if (batdau === '') {
                    $('#batdau').parent().next().html('thời gian không được để trống!');
                    check = false;
                }
                if (ketthuc === '') {
                    $('#ketthuc').parent().next().html('thời gian két thúc không được để trống!');
                    check = false;
                }
                if (giamgia <= 0) {
                    $('#giaGiam').parent().next().html('giảm giá phải lớn hơn 0!');
                    check = false;
                }
                else if (giamgia === '') {
                    $('#giaGiam').parent().next().html('giảm giá không được để trống!');
                    check = false;
                }

                if (tenkhuyenmai === '') {
                    $('#tenKhuyenMai').parent().next().html('tên khuyến mãi không được để trống!');
                    check = false;
                }
                if(chon==0){
                if (SanPham1 == 0 || SanPham1 == null) {
                    $('#SanPham1').parent().next().html('bạn khuyến mãi theo!');
                    check = false;
                }}else if(chon=='true'){
                if (DanhMuc == 0 || DanhMuc == null) {
                    $('#DanhMuc').parent().next().html('bạn khuyến mãi theo!');
                    check = false;
                }}else{
                if (SanPham == 0 || SanPham == null) {
                    $('#SanPham').parent().next().html('bạn khuyến mãi theo!');
                    check = false;
                }}
                return check;
            }
            ;

//            function FillSanPham() {
//                var hallId = $('#Chon option:selected').val();
//                if (hallId == "true") {
//                    $('.sanpham').html('Danh Mục')
//                    $.ajax({
//                        type: 'GET',
//                        headers: {
//                            Accept: "application/json; charset=utf8", "Content-Type": "application/json;charset=utf8"
//                        },
//                        url: '${pageContext.request.contextPath}/admin/khuyenmai/laydanhmuc',
//                        success: function (data) {
//                            var s = '';
//                            $('#SanPham').html('');
////                               
//                            for (i = 0; i < data.length; i++) {
//                                s += '<option value="' + data[i].maDanhMuc + '">' + data[i].tenDanhMuc + '</option>';
//                            }
//                            $('#SanPham').html(s);
//                        },
//                        error: function (xhr, status, error) {
//                            alert(xhr.responseText);
//                        }
//
//
//
//                    });
//
//
//                } else if (hallId == "false") {
//                    $('.sanpham').html('Sản Phẩm')
//                    $.ajax({
//                        type: 'GET',
//                        headers: {
//                            Accept: "application/json; charset=utf8", "Content-Type": "application/json;charset=utf8"
//                        },
//                        url: '${pageContext.request.contextPath}/admin/khuyenmai/laysanpham',
//                        success: function (data) {
//
//                            var s = '';
//                            $('#SanPham').html('');
//                            for (i = 0; i < data.length; i++) {
//                                s += '<option value="' + data[i].maSanPham + '">' + data[i].tenSanPham + '</option>';
//                            }
//                            $('#SanPham').html(s);
//
//
//                        },
//                        error: function (xhr, status, error) {
//                            alert(xhr.responseText);
//                        }
//
//
//
//                    });
//
//
//                } else {
//                    $("#SanPham").html('');
//                }
//            }
        </script>
    </body>
</html>
