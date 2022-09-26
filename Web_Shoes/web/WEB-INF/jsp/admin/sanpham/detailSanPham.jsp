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
            <style>.span-color{width:25px;
                        height:25px;
                        margin-right: 20px;
                        display:inline-block;
                        color:black;
                        cursor:pointer;
                        position:relative;}
                a:hover{text-decoration: none}

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
                                <div class="col-12 grid-margin">
                                    <div class="card">
                                        <div class="card-body">
                                            <h4 class="card-title">Detail sản phẩm</h4>

                                            <p class="card-description">
                                                Personal info
                                            </p>
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <div class="form-group">
                                                        <label class="form-group">Tên sản phẩm</label>
                                                        <input type="text" readonly class="form-control" value="${sp.tenSanPham}" />
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-6 ">
                                                <div class="row ">
                                                    <div class="col-md-12">
                                                        <div class="form-group row">
                                                            <label class="col-sm-3 col-form-label">Danh mục</label>
                                                            <div class="col-sm-9">
                                                                <input type="text" readonly class="form-control" value="${sp.tenDanhMuc}" />
                                                                </select>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row ">
                                                    <div class="col-md-12">
                                                        <div class="form-group row">
                                                            <label class="col-sm-3 col-form-label">Nhãn hàng</label>
                                                            <div class="col-sm-9">
                                                                <input type="text" readonly class="form-control" value="${sp.tenNhanHang}" />
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="col-md-12">
                                                        <div class="form-group row">
                                                            <label class="col-sm-3 col-form-label">Giới tính</label>
                                                            <div class="col-sm-9">
                                                                <input type="text" readonly class="form-control" value="${sp.tenGioiTinh}" />
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-6 ">
                                                <div class="form-group">
                                                    <label>Mô tả</label>
                                                    <textarea readonly class="form-control" name="moTa" rows="11" >${sp.moTa}</textarea>
                                                </div>
                                            </div>
                                        </div>
                                        <a data-toggle="modal" data-target="#myModal"><button class="btn btn-primary mr-2">Sửa</button></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-12 grid-margin stretch-card">
                                <div class="card">
                                    <div class="card-body">
                                        <h4 class="card-title">Sản Phẩm</h4>
                                        <p class="card-description">
                                        </p>
                                        <a class="nav-link" data-toggle="modal" data-target="#themchitietspModal">
                                            <button type="button" class="btn btn-success btn-icon-text">
                                                <i class="ti- btn-icon-prepend"></i> 

                                                Thêm chi tiết sản phẩm
                                            </button>
                                        </a>
                                        <div class="table-responsive pt-3">
                                            <table class="table table-bordered">
                                                <thead>
                                                    <tr>
                                                        <th>
                                                            STT
                                                        </th>

                                                        <th>
                                                            Tên sản phẩm
                                                        </th>
                                                        <th>
                                                            Màu
                                                        </th>
                                                        <th>
                                                            Giá
                                                        </th>
                                                        <th>
                                                            Ngày Tạo
                                                        </th>
                                                        <th>
                                                            Trạng thái
                                                        </th>
                                                        <th style="width: 0%">
                                                            Actions
                                                        </th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <% int i = 1;  %>
                                                    <c:forEach var="c" items="${lct}">
                                                        <tr>
                                                            <td>
                                                                <% out.println(i);
                                                                    i++;%>
                                                            </td>
                                                            <td>${c.tenSanPham}</td>
                                                            <td>${c.tenMau}</td>
                                                            <td>${c.giaTien}</td>
                                                            <td>${c.ngayTao}</td>
                                                            <td class="font-weight-medium">
                                                                <c:if test="${c.status}">
                                                                    <div class="badge badge-success">Open</div>
                                                                </c:if>
                                                                <c:if test="${c.status == false}">
                                                                    <div class="badge badge-danger">Close</div>
                                                                </c:if>
                                                            </td>
                                                            <td>
                                                                <a  href="${pageContext.request.contextPath}/admin/chitietsanpham/detailChiTietSanPham/${c.chiTietSanPhamPK.maSanPham}/${c.chiTietSanPhamPK.maMau}">
                                                                    <button type="button" class="btn btn-success  btn-icon">
                                                                        <i class="ti-arrow-circle-right"></i>
                                                                    </button>
                                                                </a>
                                                                <a>
                                                                    <button type="button" class="btn btn-danger  btn-icon">
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
                        </div>
                        <div>
                            <div class="modal fade" tabindex="-1" role="dialog" id="themchitietspModal">
                                <div class="modal-dialog mt-5">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h4 class="modal-title">Thêm chi tiết</h4>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                        </div>
                                        <div class="modal-body pb-0" >
                                            <form class="forms-sample" action="/Web_Shoes/admin/sanpham/insert2ChiTietSanPham" method="post" enctype="multipart/form-data">
                                                <div class="form-group row">
                                                    <h3 class="col font-weight-500 text-primary">${sp.tenSanPham}</h3>
                                                    <input type="text" name="maSanPham" class="form-control" value="${sp.maSanPham}" hidden="true"/>
                                                </div>
                                                <div class="row">
                                                    <div class="col-md-12">
                                                        <div class="form-group row">
                                                            <label class="col-sm-3 col-form-label">Màu</label>
                                                            <div class="col-sm-9">
                                                                <select name="maMau" class="form-control">
                                                                    <c:forEach items="${msp}" var="m">
                                                                        <option value="<fmt:formatNumber value="${m.maMau}"></fmt:formatNumber>">${m.tenMau}</option>
                                                                    </c:forEach>
                                                                </select>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-3 col-form-label">Giá Tiền</label>
                                                    <div class="col-sm-9">
                                                        <div class="input-group">
                                                            <div class="input-group-prepend">
                                                                <span class="input-group-text bg-primary text-white">VND</span>
                                                            </div>
                                                            <input type="number" step="any" name="giaTien" class="form-control"  style="text-align:right;"/>
                                                            <div class="input-group-append">
                                                                <span class="input-group-text">.00</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-3 col-form-label">File upload</label>
                                                    <div class="col-sm-9">
                                                        <div class="input-group">
                                                            <input id="fileupload" hidden type="file" name="files" multiple class="file-upload-input">
                                                            <input type="text" id="filetext" class="form-control file-upload-info" disabled placeholder="Upload Image">
                                                            <span class="input-group-append">
                                                                <button class="file-upload-button btn btn-primary" onclick="document.getElementById('fileupload').click()" type="button">Upload</button>
                                                            </span>
                                                        </div>
                                                    </div>
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
                            <div class="modal fade" tabindex="-1" role="dialog" id="myModal">
                                <div class="modal-dialog modal-xl mt-5">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h4 class="modal-title">Sửa sản phẩm</h4>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                        </div>
                                        <div class="modal-body pb-0" >
                                            <div class="row">
                                                <div class="col-12 grid-margin">
                                                    <div class="card">
                                                        <div class="card-body">
                                                            <form class="form-sample" action="/Web_Shoes/admin/sanpham/updateProduct" method="post">
                                                                <p class="card-description">
                                                                    Personal info
                                                                </p>
                                                                <div class="row">
                                                                    <div class="col-md-12">
                                                                        <div class="form-group">
                                                                            <label class="form-group">Tên sản phẩm</label>
                                                                            <input type="text" hidden="" name="maSanPham" class="form-control" value="${sp.maSanPham}" />
                                                                            <input type="text" name="tenSanPham" class="form-control" value="${sp.tenSanPham}"  placeholder="Tên sản phẩm"  />
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="row">
                                                                    <div class="col-6 ">
                                                                        <div class="row ">
                                                                            <div class="col-md-12">
                                                                                <div class="form-group row">
                                                                                    <label class="col-sm-3 col-form-label">Danh mục</label>
                                                                                    <div class="col-sm-9">
                                                                                        <select name="maDanhMuc" class="form-control">
                                                                                            <c:forEach items="${danhMucs}" var="d">
                                                                                                <c:if test="${d.maDanhMuc == sp.maDanhMuc}">
                                                                                                    <option selected value="<fmt:formatNumber value="${d.maDanhMuc}"></fmt:formatNumber>">${d.tenDanhMuc}</option>
                                                                                                </c:if>
                                                                                                <c:if test="${d.maDanhMuc != sp.maDanhMuc}">
                                                                                                    <option value="<fmt:formatNumber value="${d.maDanhMuc}"></fmt:formatNumber>">${d.tenDanhMuc}</option>
                                                                                                </c:if>
                                                                                            </c:forEach>
                                                                                        </select>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                        <div class="row ">
                                                                            <div class="col-md-12">
                                                                                <div class="form-group row">
                                                                                    <label class="col-sm-3 col-form-label">Nhãn hàng</label>
                                                                                    <div class="col-sm-9">
                                                                                        <select name="maNhanHang" class="form-control">
                                                                                            <c:forEach items="${nhanHangs}" var="n">
                                                                                                <c:if test="${n.maNhanHang == sp.maNhanHang}">
                                                                                                    <option selected value="<fmt:formatNumber value="${n.maNhanHang}"></fmt:formatNumber>">${n.tenNhanHang}</option>
                                                                                                </c:if>
                                                                                                <c:if test="${n.maNhanHang != sp.maNhanHang}">
                                                                                                    <option value="<fmt:formatNumber value="${n.maNhanHang}"></fmt:formatNumber>">${n.tenNhanHang}</option>
                                                                                                </c:if>
                                                                                            </c:forEach>
                                                                                        </select>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                        <div class="row">
                                                                            <div class="col-md-12">
                                                                                <div class="form-group row">
                                                                                    <label class="col-sm-3 col-form-label">Giới tính</label>
                                                                                    <div class="col-sm-9">
                                                                                        <select name="maGioiTinh" class="form-control">
                                                                                            <c:forEach items="${gioiTinhs}" var="g">
                                                                                                <c:if test="${g.maGioiTinh == sp.maGioiTinh}">
                                                                                                    <option selected value="<fmt:formatNumber value="${g.maGioiTinh}"></fmt:formatNumber>">${g.tenGioiTinh}</option>
                                                                                                </c:if>
                                                                                                <c:if test="${g.maGioiTinh != sp.maGioiTinh}">
                                                                                                    <option value="<fmt:formatNumber value="${g.maGioiTinh}"></fmt:formatNumber>">${g.tenGioiTinh}</option>
                                                                                                </c:if>
                                                                                            </c:forEach>
                                                                                        </select>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                    <div class="col-6 ">
                                                                        <div class="form-group">
                                                                            <label>Mô tả</label>
                                                                            <textarea class="form-control" name="moTa" rows="11">${sp.moTa}</textarea>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <button type="submit" class="btn btn-primary mr-2">Submit</button>
                                                                <button type="button" class="btn btn-light" data-dismiss="modal">Cancel</button>
                                                            </form>
                                                        </div>
                                                    </div>
                                                </div>


                                            </div>
                                        </div>
                                    </div>
                                    <!-- /.modal-content -->
                                </div>
                                <!-- /.modal-dialog -->
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
                var filenames = "";
                for (var i = 0; i < this.files.length; i++) {
                    if (i > 0) {
                        filenames = filenames + ", ";
                    }
                    filenames = filenames + "'" + this.files[i].name + "' ";
                }
                $("#filetext").val(filenames);
            });
        </script>
    </body>
</html>


