<%-- 
        Document   : insertSanPham
        Created on : Aug 10, 2022, 5:34:42 PM
        Author     : PC
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <jsp:include page="../linkcss.jsp"></jsp:include>
            <style>
                .span-color{width:25px;
                            height:25px;
                            margin-right: 20px;
                            display:inline-block;
                            color:black;
                            cursor:pointer;
                            position:relative;}
                .product-img{
                    width: 100px !important;
                    height: auto  !important;
                    border-radius: 20% !important;
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
                                <div class="col-md-7 grid-margin stretch-card">
                                    <div class="card">
                                        <div class="card-body">
                                            <h4 class="card-title">Detail Product</h4>
                                            <form class="forms-sample">
                                                <div class="form-group row">
                                                    <h3 class="col font-weight-500 text-primary">${ctsp.tenSanPham}</h3>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <div class="form-group row">
                                                        <label class="col-sm-4 col-form-label">Màu</label>
                                                        <div class="col-sm-8">
                                                            <input type="text" class="form-control" value="${ctsp.tenMau}" readonly=""/>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group row">
                                                        <label class="col-sm-4 col-form-label">Nhãn Hiệu</label>
                                                        <div class="col-sm-8">
                                                            <input type="text" class="form-control" value="${ctsp.tenNhanHang}" readonly/>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <div class="form-group row">
                                                        <label class="col-sm-4 col-form-label">Danh Mục</label>
                                                        <div class="col-sm-8">
                                                            <input type="text" class="form-control" value="${ctsp.tenDanhMuc}" readonly/>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group row">
                                                        <label class="col-sm-4 col-form-label">Giới Tính</label>
                                                        <div class="col-sm-8">
                                                            <input type="text" class="form-control" value="${ctsp.tenGioiTinh}" readonly/>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label for="exampleInputMobile" class="col-sm-2 col-form-label">Giá Tiền</label>
                                                <div class="col-sm-10">
                                                    <div class="input-group">
                                                        <div class="input-group-prepend">
                                                            <span class="input-group-text bg-primary text-white">VND</span>
                                                        </div>
                                                        <input type="text" class="form-control"  style="text-align:right;" value="${ctsp.giaTien}" aria-label="Amount (to the nearest dollar)" readonly/>
                                                        <div class="input-group-append">
                                                            <span class="input-group-text">.00</span>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-check form-check-flat form-check-primary">
                                                <label class="form-check-label">
                                                    <c:if test="${ctsp.status == true}">
                                                        <input onclick="return false;" type="checkbox" checked="true" class="form-check-input">
                                                        Đang bán
                                                    </c:if>
                                                    <c:if test="${ctsp.status == false}">
                                                        <input onclick="return false;" type="checkbox" class="form-check-input">
                                                        Ngừng bán
                                                    </c:if>
                                                </label>
                                            </div>
                                            <a data-toggle="modal" data-target="#myModal"><button class="btn btn-primary mr-2">Sửa</button></a>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-5 grid-margin stretch-card">
                                <div class="card">
                                    <div class="card-body">
                                        <img src="/Web_Shoes/images/${ctsp.anhChinh}" width="100%"/>
                                    </div>
                                    <div class="form-group">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-7 grid-margin stretch-card">
                                <div class="card">
                                    <div class="card-body">
                                        <p class="card-title mb-0">Sizes</p>
                                        <a href="#sizeChiTiet"  data-toggle="modal" data-target="#insertSizeModal">
                                            <button class="btn btn-success float-right" type="submit" style="padding: 10px 18px;">
                                                Thêm size
                                            </button>
                                        </a>
                                        <div class="table-responsive">
                                            <table class="table table-striped table-borderless">
                                                <thead>
                                                    <tr>
                                                        <th>STT</th>
                                                        <th>Sizes</th>
                                                        <th>Số lượng</th>
                                                        <th>Status</th>
                                                        <th>Thêm SL</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <% int i = 1;  %>
                                                    <c:forEach var="sl" items="${slsp}">
                                                        <tr>
                                                                <td><% out.println(i);
                                                                    i++;%></td>
                                                            <td class="font-weight-bold">${sl.size}</td>
                                                            <td>${sl.soLuong}</td>
                                                            <td class="font-weight-medium">
                                                                <c:if test="${sl.status}">
                                                                    <div class="badge badge-success">Open</div>
                                                                </c:if>
                                                                <c:if test="${sl.status == false}">
                                                                    <div class="badge badge-danger">Close</div>
                                                                </c:if>
                                                            </td>
                                                            <td> 
                                                                <a   data-toggle="modal" data-target="#insertSLModal" >
                                                                    <button type="button" class="btn btn-success  btn-icon getsize" data-masize="${sl.soLuongSanPhamPK.maSize}" data-tensize="${sl.size}" data-soluong="${sl.soLuong}" data-status="${sl.status}">
                                                                        <i class="ti-package"></i>
                                                                    </button>
                                                                </a>
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-5 grid-margin stretch-card">
                                <div class="card">
                                    <div class="card-body">
                                        <h4 class="card-title" style="display: inline-block;">Ảnh sản phẩm</h4>
                                        <a data-toggle="modal" data-target="#insertAnhModal"><button class="btn btn-success float-right" type="submit" style="padding: 10px 18px;">
                                                Thêm ảnh
                                            </button></a>
                                        <table class="table  table-striped table-borderless">
                                            <thead>
                                                <tr>
                                                    <th>
                                                        #
                                                    </th>
                                                    <th>
                                                        Ảnh
                                                    </th>
                                                    <th>
                                                        Action
                                                    </th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <% int j = 1;  %>
                                                <c:forEach var="anh" items="${listAnh}">
                                                    <tr>
                                                        <td><% out.println(j);
                                                            j++;%></td>
                                                        <td class="font-weight-bold"><img class="product-img" src="/Web_Shoes/images/${anh.linkAnh}" width="100"/></td>
                                                        <td>
                                                            <a data-toggle="modal" data-target="#updateAnhModal">
                                                                <button type="button" class="btn btn-success  btn-icon updateanh" data-maanh="${anh.maAnhSP}" data-tenanh="${anh.linkAnh}">
                                                                    <i class="ti-image"></i>
                                                                </button>
                                                            </a>
                                                            <a data-toggle="modal" data-target="#deleteAnhModal">
                                                                <button type="button" class="btn btn-danger  btn-icon getanh" data-tenanh="${anh.linkAnh}" data-maanh="${anh.maAnhSP}" data-masanpham="${anh.maSanPham}" data-mamau="${anh.maMau}">
                                                                    <i class="ti-trash"></i>
                                                                </button>
                                                            </a>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12 grid-margin stretch-card">
                                <div class="card position-relative">
                                    <div class="card-body">
                                        <h4>Mô tả</h4>
                                        <div></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--Modal-->
                        <div>
                            <div class="modal fade" tabindex="-1" role="dialog" id="myModal">
                                <div class="modal-dialog mt-5">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h4 class="modal-title">Sửa chi tiết</h4>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                        </div>
                                        <div class="modal-body pb-0" >
                                            <form class="forms-sample" action="/Web_Shoes/admin/chitietsanpham/updateChiTietSanPham" method="post">
                                                <div class="form-group row">
                                                    <h3 class="col font-weight-500 text-primary">${ctsp.tenSanPham}</h3>
                                                    <input type="text" name="maSanPham" class="form-control" value="${ctsp.chiTietSanPhamPK.maSanPham}" hidden="true"/>
                                                </div>
                                                <div class="row">
                                                    <div class="col-md-12">
                                                        <div class="form-group row">
                                                            <label class="col-sm-3 col-form-label">Màu</label>
                                                            <div class="col-sm-9">
                                                                <h4>${ctsp.tenMau}</h4>
                                                                <input type="text" name="maMau" class="form-control" value="${ctsp.chiTietSanPhamPK.maMau}" hidden="true"/>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label for="exampleInputMobile" class="col-sm-3 col-form-label">Giá Tiền</label>
                                                    <div class="col-sm-9">
                                                        <div class="input-group">
                                                            <div class="input-group-prepend">
                                                                <span class="input-group-text bg-primary text-white">VND</span>
                                                            </div>
                                                            <input type="number" step="any" name="giaTien" class="form-control"  style="text-align:right;" value="${ctsp.giaTien}"/>
                                                            <div class="input-group-append">
                                                                <span class="input-group-text">.00</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-check form-check-flat form-check-primary">
                                                    <label class="form-check-label">
                                                        <c:if test="${ctsp.status == true}">
                                                            <input name="status" type="checkbox" checked="true" class="form-check-input">
                                                            Đang bán
                                                        </c:if>
                                                        <c:if test="${ctsp.status == false}">
                                                            <input name="status" type="checkbox" class="form-check-input">
                                                            Đang bán
                                                        </c:if>
                                                    </label>
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-default" data-dismiss="modal">Thoát</button>
                                                    <button type="submit" class="btn btn-primary">Lưu</button>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                    <!-- /.modal-content -->
                                </div>
                                <!-- /.modal-dialog -->
                            </div>
                            <!-- /.modal -->
                            <!-- Modal -->
                            <div class="modal fade" id="insertAnhModal" tabindex="-1" role="dialog" aria-hidden="true">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel">Thêm ảnh</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <form action="/Web_Shoes/admin/chitietsanpham/saveImages" method="post"  enctype="multipart/form-data">
                                            <div class="modal-body">
                                                <h4>Chọn tệp</h4>
                                                <input type="number" hidden name="maSanPham" value="${ctsp.chiTietSanPhamPK.maSanPham}"/>
                                                <input type="number" hidden name="maMau" value="${ctsp.chiTietSanPhamPK.maMau}"/>
                                                <div class="form-group">
                                                    <label>File upload</label>
                                                    <input id="fileupload" hidden type="file" name="files" multiple class="file-upload-input">
                                                    <div class="input-group col-xs-12">
                                                        <input type="text" id="filetext" class="form-control file-upload-info" disabled placeholder="Upload Image">
                                                        <span class="input-group-append">
                                                            <button class="file-upload-button btn btn-primary" onclick="document.getElementById('fileupload').click()" type="button">Upload</button>
                                                        </span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Hủy</button>
                                                <button type="submit" class="btn btn-primary">Lưu</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <div class="modal fade" id="updateAnhModal" tabindex="-1" role="dialog" aria-hidden="true">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel">Sửa ảnh</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <form action="/Web_Shoes/admin/chitietsanpham/updateAnh" method="post" enctype="multipart/form-data">
                                            <div class="modal-body">
                                                <h4>Chọn tệp</h4>
                                                <input id="upmaanh" type="number" hidden name="maAnh"/>
                                                <input type="number" hidden name="maSanPham" value="${ctsp.chiTietSanPhamPK.maSanPham}"/>
                                                <input type="number" hidden name="maMau" value="${ctsp.chiTietSanPhamPK.maMau}"/>
                                                <input id="uptenanh" type="text" hidden  name="tenAnhCu"/>
                                                <input type="file" id="fileupload2" hidden name="files"/>
                                                <div class="form-group">
                                                    <label>File upload</label>
                                                    <div class="input-group col-xs-12">
                                                        <input type="text" id="filetext2" class="form-control file-upload-info" disabled placeholder="Upload Image">
                                                        <span class="input-group-append">
                                                            <button class="file-upload-button btn btn-primary" onclick="document.getElementById('fileupload2').click()" type="button">Upload</button>
                                                        </span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Hủy</button>
                                                <button type="submit" class="btn btn-primary">Lưu</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <div class="modal fade" id="insertSizeModal" tabindex="-1" role="dialog" aria-hidden="true">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel">Thêm size</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <form action="/Web_Shoes/admin/chitietsanpham/saveSizes" method="post">
                                            <div class="modal-body">
                                                <h4>Chọn Size</h4>
                                                <input type="number" hidden name="maSanPham" value="${ctsp.chiTietSanPhamPK.maSanPham}"/>
                                                <input type="number" hidden name="maMau" value="${ctsp.chiTietSanPhamPK.maMau}"/>
                                                <select name="maSize" class="form-control">
                                                    <c:forEach items="${sizes}" var="sizes">
                                                        <option value="
                                                                <fmt:formatNumber value="${sizes.maSize}"></fmt:formatNumber>
                                                                ">${sizes.size}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                <button type="submit" class="btn btn-primary">Thêm</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <div class="modal fade" id="insertSLModal" tabindex="-1" role="dialog" aria-hidden="true">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel">Thêm Số lượng</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <form action="/Web_Shoes/admin/chitietsanpham/updateSoLuong" method="post">
                                            <div class="modal-body">
                                                <h4>Thêm Số Lượng</h4>
                                                <input type="number" hidden name="maSanPham" value="${ctsp.chiTietSanPhamPK.maSanPham}"/>
                                                <input type="number" hidden name="maMau" value="${ctsp.chiTietSanPhamPK.maMau}"/>
                                                <div class="row">
                                                    <div class="col-md-12">
                                                        <div class="form-group row">
                                                            <label class="col-sm-4 col-form-label">Size</label>
                                                            <div class="col-sm-8">
                                                                <input id="masizet" hidden value="" name="maSize"/>
                                                                <input id="tensizet" type="text" value="" name="maSize" class="form-control" readonly/>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label for="exampleInputMobile" class="col-sm-4 col-form-label">Số Lượng hiện có</label>
                                                    <div class="col-sm-8">
                                                        <div class="input-group">
                                                            <div class="input-group-prepend">
                                                                <span class="input-group-text bg-primary text-white">Đôi</span>
                                                            </div>
                                                            <input id="soluongcu" type="number" name="soLuongCu" class="form-control"  style="text-align:right;" readonly/>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label for="exampleInputMobile" class="col-sm-4 col-form-label">Nhập Số Lượng</label>
                                                    <div class="col-sm-8">
                                                        <div class="input-group">
                                                            <div class="input-group-prepend">
                                                                <span class="input-group-text bg-primary text-white">Đôi</span>
                                                            </div>
                                                            <input type="number" min="0" max="20000" oninput="validity.valid||(value='');" name="soLuongThem" class="form-control"  style="text-align:right;"/>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-check form-check-flat form-check-primary">
                                                    <label class="form-check-label">
                                                        <input id="statust" name="status" type="checkbox" class="form-check-input">
                                                        Đang bán
                                                    </label>
                                                </div>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                <button type="submit" class="btn btn-primary">Save changes</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--delete modal-->
                        <div>
                            <div id="deleteAnhModal" class="modal fade" >
                                <div class="modal-dialog" role="document">
                                    <form action="/Web_Shoes/admin/chitietsanpham/deleteAnh" method="post">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h4 class="modal-title">Xóa Ảnh</h4>
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>

                                            </div>
                                            <div class="modal-body">
                                                <p>Bạn có muốn xóa ảnh này</p>
                                                <input type="number" id="maanhdt" hidden name="maAnh"/>
                                                <input id="detenanh" type="text" hidden  name="tenAnhCu"/>
                                                <input type="number" id="maspdt" hidden name="maSanPham"/>
                                                <input type="number" id="mamaudt" hidden name="maMau"/>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Hủy</button>
                                                <button type="submit" class="btn btn-danger">Xóa ảnh</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- content-wrapper ends -->
                    <!-- partial:../../partials/_footer.html -->
                    <footer class="footer">
                        <div class="d-sm-flex justify-content-center justify-content-sm-between">
                            <span class="float-none float-sm-right d-block mt-1 mt-sm-0 text-center">Hand-crafted &amp; made with <i class="ti-heart text-danger ml-1"></i></span>
                        </div>
                    </footer>
                    <!-- partial -->
                </div>
                <!-- main-panel ends -->
            </div>
            <!-- page-body-wrapper ends -->
        </div>
        <jsp:include page="../footer.jsp"></jsp:include>
        <script>
            $("#fileupload").change(function () {
                var filenames ="";
                for (var i = 0; i < this.files.length; i++) {
                    if (i > 0) {
                        filenames = filenames + ", ";
                    }
                    filenames = filenames + "'"+this.files[i].name +"' ";
                }
                $("#filetext").val(filenames);
            });
        </script>
        <script>
            $("#fileupload2").change(function () {
                $("#filetext2").val(this.files[0].name);
            });
        </script>
        <script>
            $(".getsize").on("click", function () {
                console.log("hi")
                var masize = $(this).data("masize");
                var tensize = $(this).data("tensize");
                var status = $(this).data("status");
                var soluong = $(this).data("soluong");
                console.log(masize)
                console.log(tensize)
                console.log(status)
                $("#masizet").val(masize);
                $("#tensizet").val(tensize);
                $("#soluongcu").val(soluong);
                if (status) {
                    $("#statust").prop('checked', true);
                }
            });

            $(".getanh").on("click", function () {
                var maanh = $(this).data("maanh");
                var masanpham = $(this).data("masanpham");
                var mamau = $(this).data("mamau");
                var tenanh = $(this).data("tenanh");
                $("#maanhdt").val(maanh);
                $("#detenanh").val(tenanh);
                $("#maspdt").val(masanpham);
                $("#mamaudt").val(mamau);
            });
            $(".updateanh").on("click", function () {
                console.log("hi")
                var maanh = $(this).data("maanh");
                var tenanh = $(this).data("tenanh");
                console.log(maanh)
                $("#uptenanh").val(tenanh);
                $("#upmaanh").val(maanh);
            });

        </script>
    </body>
</html>