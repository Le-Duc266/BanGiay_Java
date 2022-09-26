<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <jsp:include page="../linkcss.jsp"></jsp:include>
            <style>
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
                                <div class="col-lg-12 grid-margin stretch-card">
                                    <div class="card">
                                        <div class="card-body">
                                            <h4 class="card-title">Sản Phẩm</h4>
                                            <p class="card-description">
                                            </p>
                                            <a style="display: inline" class="nav-link" href="${pageContext.request.contextPath}/admin/sanpham/insertSanPham">
                                            <button type="button" class="btn btn-success btn-icon-text">
                                                <i class="ti- btn-icon-prepend"></i> 

                                                Thêm sản phẩm
                                            </button></a>
                                        <div class="table-responsive pt-3">
                                            <table id="sanphamtables" class="table table-bordered table-striped" cellspacing="0">
                                                <thead>
                                                    <tr>
                                                        <th>
                                                            STT
                                                        </th>
                                                        <th>
                                                            Mã Sản Phẩm
                                                        </th>
                                                        <th>
                                                            Tên sản phẩm
                                                        </th>
                                                        <th>
                                                            Danh mục
                                                        </th>
                                                        <th>
                                                            Nhãn hàng
                                                        </th>
                                                        <th>
                                                            Giới tính
                                                        </th>
                                                        <th>
                                                            Actions
                                                        </th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <% int i = 1;  %>
                                                    <c:forEach var="s" items="${sanPhams}">
                                                        <tr>
                                                            <td>
                                                                <% out.println(i);
                                                                    i++;%>
                                                            </td>
                                                            <td>${s.maSanPham}</td>
                                                            <td>${s.tenSanPham}</td>
                                                            <td>${s.tenDanhMuc}</td>
                                                            <td>${s.tenNhanHang}</td>
                                                            <td>${s.tenGioiTinh}</td>
                                                            <td>
                                                                <a href="${pageContext.request.contextPath}/admin/sanpham/detailSanPham/${s.maSanPham}">
                                                                    <button type="button" class="btn btn-success  btn-icon">
                                                                        <i style="margin-left: -2px;" class="ti-arrow-circle-right"></i>
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
                $(document).ready(function () {
                    $('#sanphamtables').dataTable({
                        "pagingType": "full_numbers",
                        "lengthMenu": [[5, 10, 20, -1], [5, 10, 20, "All"]],
                    });
                });
            </script>
    </body>
</html>