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
                                            <h4 class="card-title">Thêm mới chi tiết sản phẩm</h4>
                                            <form class="form-sample" action="/Web_Shoes/admin/chitietsanpham/saveChiTietSanPham" method="post">
                                                <p class="card-description">
                                                    Personal info
                                                </p>
                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <div class="form-group row">
                                                            <label class="col-sm-3 col-form-label">Sản Phẩm</label>
                                                            <div class="col-sm-9">
                                                            <select name="maSanPham" class="form-control">
                                                                <c:forEach items="${sanPhams}" var="s">
                                                                    <option value="<fmt:formatNumber value="${s.maSanPham}"></fmt:formatNumber>">${s.tenSanPham}</option>
                                                                </c:forEach>
                                                            </select>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group row">
                                                        <label class="col-sm-3 col-form-label">Màu</label>
                                                        <div class="col-sm-9">
                                                            <select name="maMau" class="form-control">
                                                                <c:forEach items="${mauSanPhams}" var="m">
                                                                    <option value="<fmt:formatNumber value="${m.maMau}"></fmt:formatNumber>">${m.tenMau}</option>
                                                                </c:forEach>
                                                            </select>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <div class="form-group row">
                                                        <label class="col-sm-3 col-form-label">Giá Tiền</label>
                                                        <div class="col-sm-9">
                                                            <input type="number" name="giaTien" class="form-control" />
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <button type="submit" class="btn btn-primary mr-2">Submit</button>
                                            <input type="submit" class="btn btn-light" name="cancel" value="Cancel">
                                        </form>
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


