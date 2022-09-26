<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="i" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <jsp:include page="../linkcss.jsp"></jsp:include>
            <style>
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
                                <div class="col-md-6 grid-margin ">
                                    <div class="card grid-margin" style="height: 70px;text-align: center;padding:  20px">
                                        <h2>Quản Lý Banner</h2>
                                    </div>
                                    <div class="card">
                                        <div class="card-body">
                                            <h4 class="card-title">Thêm Mới Banner</h4>
                                            <form class="forms-sample" action="/Web_Shoes/admin/banner/saveBan" commandName="banner" method="POST" enctype="multipart/form-data" >
                                                <input hidden name="maBanner" id="maBanner" value="0"/>
                                                <div class="form-group">
                                                    <label>File upload</label>

                                                    <div class="input-group col-xs-12">
                                                        <input type="file" name="anhBannerURL" id="anhBanner" class="form-control filestyle" accept="image/png, image/jpeg">
                                                        <span class="input-group-append">
                                                        </span>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="exampleInputUsername1">Vị Trí Banner</label>
                                                    <input type="number" class="form-control" placeholder="Vị trí ..." id="viTri" name="viTri"/>
                                                </div>
                                                <button type="submit" class="btn btn-success btn-rounded btn-fw" id="save" value="Insert">Lưu</button>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-6 grid-margin stretch-card">
                                    <div class="card">
                                        <div class="card-body">
                                            <h4 class="card-title">Danh Sách Banner</h4>
                                            <div class="table-responsive">
                                                <table class="table table-hover">
                                                    <thead>
                                                        <tr>
                                                            <th>Mã Banner</th>
                                                            <th>Ảnh Banner</th>
                                                            <th>Vị Trí</th>
                                                            <th>Lựa Chọn</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                    <c:forEach var="bn" items="${bn}">
                                                        <tr>
                                                            <td>${bn.maBanner}</td>
                                                            <td class="font-weight-bold"><img class="product-img" src="<i:url value='/resources/images/banner/${bn.anhBanner}'/>" width="100"/></td>
                                                            <td>${bn.viTri}</td>
                                                            <td>
<!--                                                                <a href="deleteBanner.htm?maBanner=${bn.maBanner}" style="color: white" onclick="return confirm('Bạn Có Chắc Muốn Xóa?')">
                                                                    <button type="submit" class="btn btn-danger btn-rounded btn-fw">Xóa</button></a>-->

                                                                <!--day là phần Kiên-->
                                                                <a data-toggle="modal" data-target="#deleteAnhModal">
                                                                    <button type="button" class="btn btn-danger  btn-icon getanh" data-tenanh="${bn.anhBanner}" data-mabanner="${bn.maBanner}">
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
                                <div id="deleteAnhModal" class="modal fade" >
                                <div class="modal-dialog" role="document">
                                    <form action="/Web_Shoes/admin/banner/deleteAnh" method="post">
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
            $(".edit").on("click", function () {
                var ma = $(this).data("ma");
                var anh = $(this).data("anh");
                var vitri = $(this).data("vitri");
                $("#maBanner").val(ma);
                $("#anhBanner").val(anh);
                $("#viTri").val(viTri);
            });
              $(".getanh").on("click", function () {
                var mabanner = $(this).data("mabanner");
                var tenanh = $(this).data("tenanh");
                $("#maanhdt").val(mabanner);
                $("#detenanh").val(tenanh);
            });
        </script>
    </body>
</html>
