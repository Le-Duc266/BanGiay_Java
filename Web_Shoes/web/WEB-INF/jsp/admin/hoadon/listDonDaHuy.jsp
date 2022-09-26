<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>

        <!-- Required meta tags -->
        <jsp:include page="../linkcss.jsp"></jsp:include>
        <link rel="stylesheet" href="<c:url value="/resources/frontend/css/toastr.min.css"/>">
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
                                            <h4 class="card-title">Hóa Đơn Đã Hủy</h4>

                                            <div class="table-responsive">
                                                <table id="khuyenmai" class="table table-striped table-bordered" cellspacing="0" width="100%">
                                                    <thead>
                                                        <tr>
                                                            <th>
                                                                Mã Hóa Đơn
                                                            </th>
                                                            <th>
                                                                Tên Khách hàng
                                                            </th>
                                                            <th>
                                                                Số Điện Thoại
                                                            </th>
                                                            <th>
                                                                Địa Chỉ Giao Hàng
                                                            </th>
                                                            <th>
                                                                Ngày lập
                                                            </th>

                                                            <th>
                                                                Tổng Tiền
                                                            </th>

                                                            <th>
                                                                Lựa Chọn
                                                            </th>

                                                        </tr>
                                                    </thead>
                                                    <tbody>

                                                    <c:forEach var="c" items="${hoadon}">
                                                        <tr>
                                                            <td class="maHoaDon" data-maHoaDon="${c.maHoaDon}">${c.maHoaDon}</td>
                                                            <td>${c.tenKhachHang}</td>

                                                            <td>${c.soDT}</td>
                                                            <td>${c.diaChiGiaoHang}</td>
                                                            <td>${c.ngayLap}</td>

                                                            <td>${c.tongTien}</td>
                                                            <td>
                                                                <a  href="${pageContext.request.contextPath}/admin/hoadon/HoaDonDetail?maHoaDon=${c.maHoaDon}">
                                                                    <button type="button" class="btn btn-success  btn-icon">
                                                                        <i class="ti-arrow-circle-right"></i>
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
         <script type="text/javascript" src="<c:url value="/resources/frontend/js/toastr.min.js"/>"></script>
            <script type="text/javascript">
                $(document).ready(function () {
                    $('#khuyenmai').dataTable({
                        "n": "full_numbers",
                        "lengthMenu": [[5, 10, 20, -1], [5, 10, 20, "All"]],
                    });
                    
                });

        </script>
    </body>
</html>
