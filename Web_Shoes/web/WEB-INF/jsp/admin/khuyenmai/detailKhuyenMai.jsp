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
                                            <h4 class="card-title">Chi Tiết Khuyến mãi</h4>
                                            
                                            <div class="table-responsive">
                                                <table class="table table-striped">
                                                    <thead>
                                                        <tr>
                                                            <th>
                                                                Mã Khuyến Mãi
                                                            </th>
                                                            <th>
                                                                Mã Sản Phẩm
                                                            </th>
                                                            <th>
                                                               Tên Sản Phẩm
                                                            </th>
                                                            <th>
                                                                Giảm Giá
                                                            </th>
                                                            <th>
                                                                Giày Bắt Đầu
                                                            </th>
                                                            <th>
                                                                Ngày Kết Thúc
                                                            </th>
                                                            

                                                        </tr>
                                                    </thead>
                                                    <tbody>

                                                    <c:forEach var="a" items="${danhsach}">
                                                        <tr>
                                                            <td>${c.maKhuyenMai}</td>
                                                            <td>${a.maSanPham}</td>
                                                            <td>${a.tenSanPham}</td>
                                                            <td>${c.giaGiam}</td>
                                                            <td>${c.thoiGianBatDau}</td>
                                                            <td>${c.thoiGianBatDau}</td>
                                                            
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
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
