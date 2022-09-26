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
                                            <h4 class="card-title">Striped Table</h4>

                                            <div class="table-responsive">
                                                <table id="khuyenmai" class="table table-striped table-bordered" cellspacing="0" width="100%">
                                                    <thead>
                                                        <tr>
                                                            <th>
                                                                Mã Hóa Đơn
                                                            </th>
                                                            <th>
                                                                Tên Sản Phẩm
                                                            </th>
                                                            <th>
                                                                Tên Màu
                                                            </th>
                                                            <th>
                                                                Tên Size
                                                            </th>
                                                            <th>
                                                                Giá Bán
                                                            </th>

                                                            <th>
                                                                Số Lượng
                                                            </th>
                                                            <th>
                                                                Thành Tiền
                                                            </th>


                                                        </tr>
                                                    </thead>
                                                    <tbody>

                                                    <c:forEach var="c" items="${hoadon}">
                                                        <tr>
                                                            <td class="maHoaDon" data-maHoaDon="${ha.maHoaDon}">${ha.maHoaDon}</td>
                                                            <td>${c.soLuongSanPham.chiTietSanPham.sanPham.tenSanPham}</td>

                                                            <td>${c.soLuongSanPham.chiTietSanPham.mauSanPham.tenMau}</td>
                                                            <td>${c.soLuongSanPham.sizeSanPham.size}</td>
                                                            <td>${c.giaTien}</td>

                                                            <td>${c.soLuong}</td>
                                                            <td>${c.thanhTien}</td>
                                                            
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
