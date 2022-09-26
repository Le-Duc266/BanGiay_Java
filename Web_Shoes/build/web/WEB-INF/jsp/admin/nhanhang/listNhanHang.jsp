<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="i" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>

        <!-- Required meta tags -->
        <jsp:include page="../linkcss.jsp"></jsp:include>
           <link rel="stylesheet" href="<c:url value="/resources/frontend/css/toastr.min.css"/>">
            <style>
                .file-upload{display:block;text-align:center;font-family: Helvetica, Arial, sans-serif;font-size: 12px;}
                .file-upload .file-select{display:block;border: 2px solid #dce4ec;color: #34495e;cursor:pointer;height:40px;line-height:40px;text-align:left;background:#FFFFFF;overflow:hidden;position:relative;}
                .file-upload .file-select .file-select-button{background:#dce4ec;padding:0 10px;display:inline-block;height:40px;line-height:40px;}
                .file-upload .file-select .file-select-name{line-height:40px;display:inline-block;padding:0 10px;}
                .file-upload .file-select:hover{border-color:#34495e;transition:all .2s ease-in-out;-moz-transition:all .2s ease-in-out;-webkit-transition:all .2s ease-in-out;-o-transition:all .2s ease-in-out;}
                .file-upload .file-select:hover .file-select-button{background:#34495e;color:#FFFFFF;transition:all .2s ease-in-out;-moz-transition:all .2s ease-in-out;-webkit-transition:all .2s ease-in-out;-o-transition:all .2s ease-in-out;}
                .file-upload.active .file-select{border-color:#3fa46a;transition:all .2s ease-in-out;-moz-transition:all .2s ease-in-out;-webkit-transition:all .2s ease-in-out;-o-transition:all .2s ease-in-out;}
                .file-upload.active .file-select .file-select-button{background:#3fa46a;color:#FFFFFF;transition:all .2s ease-in-out;-moz-transition:all .2s ease-in-out;-webkit-transition:all .2s ease-in-out;-o-transition:all .2s ease-in-out;}
                .file-upload .file-select input[type=file]{z-index:100;cursor:pointer;position:absolute;height:100%;width:100%;top:0;left:0;opacity:0;filter:alpha(opacity=0);}
                .file-upload .file-select.file-select-disabled{opacity:0.65;}
                .file-upload .file-select.file-select-disabled:hover{cursor:default;display:block;border: 2px solid #dce4ec;color: #34495e;cursor:pointer;height:40px;line-height:40px;margin-top:5px;text-align:left;background:#FFFFFF;overflow:hidden;position:relative;}
                .file-upload .file-select.file-select-disabled:hover .file-select-button{background:#dce4ec;color:#666666;padding:0 10px;display:inline-block;height:40px;line-height:40px;}
                .file-upload .file-select.file-select-disabled:hover .file-select-name{line-height:40px;display:inline-block;padding:0 10px;}
                .update{display: none;}
                #image{
                    display: none;
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
                                        <h2>Quản Lý Nhãn Hàng</h2>
                                    </div>
                                    <div class="card">
                                        <div class="card-body">
                                            <h4 class="card-title">Thêm Mới Danh Mục</h4>
                                            <form class="forms-sample" action="/Web_Shoes/admin/nhanhang/saveNhanHang" commandName="NhanHang" method="POST" enctype="multipart/form-data" onsubmit="return validate()">
                                                <input hidden name="maNhanHang" id="maNhanHang" value="0"/>
                                                <div class="form-group">
                                                    <label for="exampleInputUsername1">Tên Nhãn Hàng</label>
                                                    <div>
                                                        <input type="text" class="form-control" placeholder="Tên Nhãn Hàng ..." id="tenNhanHang" name="tenNhanHang"/>
                                                    </div>
                                                    <div class="invalid-feedback" style="display:block;font-size:15px;color: red"></div>
                                                </div>
                                                <div class="form-group" >
                                                    <label for="exampleInputUsername1">Chọn ảnh</label>
                                                    <div class="file-upload">
                                                        <div class="file-select"  id="ianh">
                                                            <div class="file-select-button" id="fileName">Choose File</div>
                                                            <div class="file-select-name" id="noFile">No file chosen...</div> 
                                                            <input type="file" name="anhBannerURL" id="chooseFile" accept="image/png, image/jpeg" onchange="file_changed()">
                                                            <input type="text" name="hinhNhanHang" id="hinhanh" hidden>
                                                        </div>
                                                    </div>
                                                    <div class="invalid-feedback" style="display:block;font-size:15px;color: red"></div>
                                                </div>

                                                <div class="form-group" id="image">
                                                    <img id="img" src="" width="50%">
                                                </div>
                                                <button type="submit" class="btn btn-success btn-rounded btn-fw" id="create" value="Insert">Thêm</button>
                                                <button type="submit" class="btn btn-success btn-rounded btn-fw update" id="update" value="save">Sửa</button>
                                                <button type="button" class="btn btn-light" id="huy">Hủy</button>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-6 grid-margin stretch-card">
                                    <div class="card">
                                        <div class="card-body">
                                            <h4 class="card-title">Danh Sách Danh Mục</h4>
                                            <div class="table-responsive">
                                                <table class="table table-hover">
                                                    <thead>
                                                        <tr>
                                                            <th>Mã Nhãn Hàng</th>
                                                            <th>Tên Nhãn Hàng</th>
                                                            <th>Hình Ảnh</th>
                                                            <th>Lựa Chọn</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                    <c:forEach var="s" items="${nhanhang}">
                                                        <tr>
                                                            <td class="nhan" data-nhan="${s.maNhanHang}">${s.maNhanHang}</td>
                                                            <td>${s.tenNhanHang}</td>
                                                            <td><img src="<i:url value='/resources/images/nhanhang/${s.hinhNhanHang}'/>"></td>
                                                            <td>
                                                                <button type="button" class="btn btn-info btn-rounded btn-fw edit" data-ma="${s.maNhanHang}" data-name="${s.tenNhanHang}" data-anh="${s.hinhNhanHang}">Sửa</button>
                                                                <button type="button" class="btn btn-info btn-rounded btn-fw delete" onclick="return confirm('Ban chac chan muon xoa?')">xóa</button>
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
            <script>
                $(".edit").on("click", function () {
                    var ma = $(this).data("ma");
                    var ten = $(this).data("name");
                    var anh = $(this).data("anh");
                    $("#maNhanHang").val(ma);
                    $("#tenNhanHang").val(ten);
                    $("#chooseFile").val(null);
                    $("#noFile").text(anh);
                    $("#hinhanh").val(anh);
                    $("#create").hide();
                    $("#update").show();
                    var img = document.getElementById('img')
                    if (anh == '') {
                        img.src = '';
                        $("#image").hide();
                    } else {
                        $("#image").show();
                        img.src = '/Web_Shoes/resources/images/nhanhang/' + anh;
                    }
                });
                $(".delete").on("click", function () {
                    var maNhanhang=$(this).closest("tr").find(".nhan").attr("data-nhan");
                    
                    $.ajax({
                        url: "${pageContext.request.contextPath}/admin/nhanhang/delete",
                        type: "GET",
                        data: {
                            maNhanhang:maNhanhang

                        },
                        success: function (value) {

                            if (value.result) {
                               
                                toastr.success('xóa thành công', 'Success!', {
                                    closeButton: true,
                                    tapToDismiss: false
                                });
                            } else {
                                toastr.error('xóa thất bại do sản phẩm đã được tham chiếu!', 'Error!', {
                                    closeButton: true,
                                    tapToDismiss: false
                                });
                            }

                        }

                    })
                });
                $("#huy").on("click", function () {

                    $("#maNhanHang").val('');
                    $("#tenNhanHang").val('');
                    $("#chooseFile").val(null);
                    $("#noFile").text("No file chosen...");
                    $("#hinhanh").html('');
                    $("#create").show();
                    $("#update").hide();
                    var img = document.getElementById('img')
                    img.src = '';
                    $("#image").hide();
                });
                function file_changed() {
                    var selectedFile = document.getElementById('chooseFile').files[0];
                    var img = document.getElementById('img')
                    $("#image").show();
                    var reader = new FileReader();
                    reader.onload = function () {
                        img.src = this.result

                    }
                    reader.readAsDataURL(selectedFile);
                }


                function validate() {
                    var check = true;


                    var tenNhanHang = $('#tenNhanHang').val();
                    var noFile = $('#noFile').text();

                    if (tenNhanHang == '') {
                        $('#tenNhanHang').parent().next().html('tên nhãn hàng được để trống!');
                        check = false;
                    } else {
                        $('#tenNhanHang').parent().next().html('');

                        check = true;
                    }
                    if (noFile == 'No file chosen...') {
                        $('#ianh').parent().next().html('ảnh không được để trống!');
                        check = false;
                    } else {
                        $('#ianh').parent().next().html('');

                        check = true;
                    }
                    if (tenNhanHang == '') {
                        $('#tenNhanHang').parent().next().html('tên nhãn hàng được để trống!');
                        check = false;
                    }
                    if (noFile == 'No file chosen...') {
                        $('#ianh').parent().next().html('ảnh không được để trống!');
                        check = false;
                    }

                    return check;
                }
                ;

        </script>
        <script>
            $('#chooseFile').bind('change', function () {
                var filename = $("#chooseFile").val();
                if (/^\s*$/.test(filename)) {
                    $(".file-upload").removeClass('active');
                    $("#noFile").text("No file chosen...");
                }
                else {
                    $(".file-upload").addClass('active');
                    $("#noFile").text(filename.replace("C:\\fakepath\\", ""));
                }
            });
        </script>
    </body>
</html>
