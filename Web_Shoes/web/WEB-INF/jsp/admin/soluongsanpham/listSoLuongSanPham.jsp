<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <jsp:include page="../linkcss.jsp"></jsp:include>
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
                                            <a class="nav-link" href="${pageContext.request.contextPath}/admin/soluongsanpham/insertSoLuongSanPham">
                                            <button type="button" class="btn btn-success btn-icon-text">
                                                <i class="ti- btn-icon-prepend"></i> 

                                                Thêm chi tiết sản phẩm
                                            </button></a>
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
                                                            Size
                                                        </th>
                                                        <th>
                                                            Số Lượng
                                                        </th>
                                                        <th>
                                                            Trạng thái
                                                        </th>
                                                        <th>
                                                            Actions
                                                        </th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <% int i = 1;  %>
                                                    <c:forEach var="sl" items="${slsanPhams}">
                                                        <tr>
                                                            <td>
                                                                <% out.println(i);
                                                                    i++;%>
                                                            </td>
                                                            <td>${sl.tenSanPham}</td>
                                                            <td>${sl.tenMau}</td>
                                                            <td>${sl.tenSize}</td>
                                                            <td>${sl.soLuongSanPham.soLuong}</td>
                                                            <td>${sl.soLuongSanPham.status}</td>
                                                            <td>
                                                                <a href="${pageContext.request.contextPath}/admin/sanpham/insertSanPham">
                                                                    <button type="button" class="btn btn-warning btn-icon editsp">
                                                                        <i class="ti-eraser"></i>
                                                                    </button>
                                                                </a>
                                                                <a>
                                                                    <button type="button" class="btn btn-danger btn-rounded btn-icon">
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
    </body>
</html>