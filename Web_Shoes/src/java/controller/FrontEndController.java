/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author DELL
 */
import dao.BannerDAO;
import dao.SoLuongSanPhamDAO;
import dao1.DanhMucDAO;
import dao1.HoaDonDao;
import dao1.KichThuocDAO;
import dao1.MauSacDAO;
import dao1.NhanvienDao;
import dao1.SanPhamDao;
import entities.AnhSanPham;
import entities.AnhSanPhamPK;
import entities.Banner;
import entities.ChiTietHoaDon;
import entities.ChiTietHoaDonPK;
import entities.ChiTietSanPham;
import entities.DanhMucSanPham;
import entities.GioHang;
import entities.HoaDon;
import entities.MauSanPham;
import entities.NhanVien;
import entities.SanPham;
import entities.SizeSanPham;
import entities.SoLuongSanPham;
import entities.SoLuongSanPhamPK;
import entities.joins.SoLuongSanPhamJoin;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import unit.XuLyTien;

@Controller
public class FrontEndController {

    DanhMucDAO dmuc = null;
    SanPhamDao spdao = null;
    MauSacDAO mdao = null;
    KichThuocDAO kdao = null;
    HoaDonDao hdao = null;
    BannerDAO bndao;
    private NhanvienDao nhanviendao;
    SoLuongSanPhamDAO slo = null;

    public FrontEndController() {
        dmuc = new DanhMucDAO();
        spdao = new SanPhamDao();
        mdao = new MauSacDAO();
        kdao = new KichThuocDAO();
        hdao = new HoaDonDao();
        bndao = new BannerDAO();
        nhanviendao = new NhanvienDao();
        slo = new SoLuongSanPhamDAO();
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model, HttpSession session) {
        session.setAttribute("danhmuc", dmuc.getAlls());
        List<SanPham> list = spdao.limit(8);
        List<SanPham> spall = spdao.getSanPham();
        List<SanPham> oderby = spdao.oderById(20);
        for (SanPham spall1 : spall) {
            if (spall1.getKhuyenMaiCollection().size() > 0) {
                model.addAttribute("sa", spall1);
                break;
            }
        }
        List<Banner> banners = bndao.getAlls();

        model.addAttribute("banners", banners);
        session.setAttribute("spoderby", oderby);
        model.addAttribute("sanpham", list);
        model.addAttribute("spall", spall);
        int soluong = 0;
        if (null != session.getAttribute("giohang")) {
            List<GioHang> gioHangs = (List<GioHang>) session.getAttribute("giohang");
            for (GioHang gioHang : gioHangs) {
                soluong += gioHang.getSoluong();
            }
        }
        model.addAttribute("soluong", soluong);
        return "frontend/index";
    }

    @RequestMapping(value = "DanhMuc", method = RequestMethod.GET)
    public String DanhMuc(Model model, DanhMucSanPham maDanhMuc,HttpSession session) {
        List<SanPham> danhmuc = spdao.getDanhMuc(maDanhMuc);
 int soluong = 0;
        if (null != session.getAttribute("giohang")) {
            List<GioHang> gioHangs = (List<GioHang>) session.getAttribute("giohang");
            for (GioHang gioHang : gioHangs) {
                soluong += gioHang.getSoluong();
            }
        }
        model.addAttribute("soluong", soluong);
        model.addAttribute("sanpham", danhmuc);
        return "frontend/product";
    }

    @RequestMapping(value = "search", method = RequestMethod.GET)
    public String search(Model model, String name) {
        List<SanPham> search = spdao.search(name);
        model.addAttribute("sanpham", search);
        return "frontend/product";
    }

    @RequestMapping(value = "SanPhamDetail", method = RequestMethod.GET)
    public String SanPhamDetail(Model model, int maSanPham, DanhMucSanPham maDanhMuc, HttpSession session) {
        SanPham sanpham = spdao.getByIdSp(maSanPham);
        List<SanPham> sanphamlq = spdao.SanPhamLienQuan(maSanPham, maDanhMuc);
        model.addAttribute("sp", sanphamlq);
        model.addAttribute("sanpham", sanpham);
        int soluong = 0;
        if (null != session.getAttribute("giohang")) {
            List<GioHang> gioHangs = (List<GioHang>) session.getAttribute("giohang");
            for (GioHang gioHang : gioHangs) {
                soluong += gioHang.getSoluong();
            }
        }
        for (ChiTietSanPham sp : sanpham.getChiTietSanPhamCollection()) {
            for (SoLuongSanPham solo : sp.getSoLuongSanPhamCollection()) {
                SoLuongSanPhamJoin soLuongSanPhamJoin = slo.getSoluong(sp.getSanPham().getMaSanPham(), sp.getMauSanPham().getMaMau(), solo.getSizeSanPham().getMaSize());
                

                SoLuongSanPham so = new SoLuongSanPham();

                SoLuongSanPhamPK spk = new SoLuongSanPhamPK();
                spk.setMaSanPham(sp.getSanPham().getMaSanPham());
                spk.setMaMau(sp.getMauSanPham().getMaMau());
                spk.setMaSize(solo.getSizeSanPham().getMaSize());
                if (soLuongSanPhamJoin.getSoLuong() <= 0 || soLuongSanPhamJoin.getSoLuong() == null) {
                    so.setStatus(false);

                } else {
                    so.setStatus(true);

                }
                so.setSoLuong(soLuongSanPhamJoin.getSoLuong());
                so.setSoLuongSanPhamPK(spk);
                hdao.UpdateSoLuong(so);

            }

        }

        model.addAttribute("soluong", soluong);
        return "frontend/productDetail";
    }

    @RequestMapping(value = "anhSp")
    @ResponseBody
    public String SanPhamDetail(Model model, @RequestParam Integer sanphan, @RequestParam Integer mamau) {
        SanPham anhsp = spdao.getByIdSp(sanphan);
        String html = "";
        html += "<div class='ps-product__preview'>";
        html += " <div class='ps-product__variants slick-initialized slick-slider slick-vertical'>";
        html += "<div aria-live='polite' class='slick-list draggable' style='height: 243px;'>";
        html += "<div class='slick-track' style='opacity: 1; height: 162px; transform: translate3d(0px, 0px, 0px);' role='listbox'>";
        for (ChiTietSanPham anh : anhsp.getChiTietSanPhamCollection()) {
            for (AnhSanPham col : anh.getAnhSanPhamCollection()) {
                if (col.getAnhSanPhamPK().getMaSanPham() == sanphan && col.getAnhSanPhamPK().getMaMau() == mamau) {
                    html += "<div class='item slick-slide slick-active' data-slick-index='' aria-hidden='false' style='width: 66px;' tabindex='-1' role='option' aria-describedby='slick-slide10'><img src='/Web_Shoes/images/" + col.getLinkAnh() + "' height='55px' alt=''></div>";
                }
            }

        }
        html += " </div>";
        html += " </div>";
        html += " </div>";
        html += " </div>";

        html += "<div class='ps-product__image slick-initialized slick-slider'>";
        html += "<div aria-live='polite' class='slick-list draggable'>";
        html += "<div class='slick-track' style='opacity: 1; width: 2480px; transform: translate3d(-620px, 0px, 0px);' role='listbox'>";
        for (ChiTietSanPham anh : anhsp.getChiTietSanPhamCollection()) {
            for (AnhSanPham col : anh.getAnhSanPhamCollection()) {
                if (col.getAnhSanPhamPK().getMaSanPham() == sanphan && col.getAnhSanPhamPK().getMaMau() == mamau) {
                    html += "<div class='item slick-slide slick-cloned' data-slick-index='-1' aria-hidden='true' style='width: 620px;height:620px;' tabindex='-1'><img class='zoom' src='/Web_Shoes/images/" + col.getLinkAnh() + "' alt=''>            </div>";
                }
            }

        }
        html += " </div>";
        html += " </div>";
        html += " </div>";

        return html;
    }

    @RequestMapping(value = "Size")
    @ResponseBody
    public String anh(@RequestParam Integer sanphan, @RequestParam Integer mamau) {
        SanPham anhsp = spdao.getByIdSp(sanphan);
        String html = "";

        for (ChiTietSanPham anh : anhsp.getChiTietSanPhamCollection()) {
            for (SoLuongSanPham col : anh.getSoLuongSanPhamCollection()) {
                if (col.getSoLuongSanPhamPK().getMaSanPham() == sanphan && col.getSoLuongSanPhamPK().getMaMau() == mamau) {
                    
                    if (col.getSoLuongSanPhamPK().getMaMau() == mamau) {
                        if (col.getStatus() == true) {
                            html += "<div>";
                            html += " <input id='" + col.getSizeSanPham().getSize() + "' name='skuAndSize' type='radio' class='visually-hidden' value='" + col.getSizeSanPham().getMaSize() + "'>\n"
                                    + "                                                        <label for='" + col.getSizeSanPham().getSize() + "' tabindex='-1' class='css-xf3ahq'>" + col.getSizeSanPham().getSize() + "</label>";
                            html += "</div>";
                        } else {
                            html += "<div>";
                            html += " <input id='" + col.getSizeSanPham().getSize() + "' name='skuAndSize' disabled type='radio' class='visually-hidden maSize' value='" + col.getSizeSanPham().getMaSize() + "'>\n"
                                    + "                                                        <label for='" + col.getSizeSanPham().getSize() + "'  tabindex='-1' class='css-xf3ahq'>" + col.getSizeSanPham().getSize() + "</label>";
                            html += "</div>";
                        }
                    } else if(col.getSoLuongSanPhamPK().getMaMau() != mamau){
                        html+="";
                    }
                }
            }

        }

        return html;
    }

    @RequestMapping(value = "ThemGioHang")
    @ResponseBody
    public String ThemGioHang(@RequestParam int maSanPham, @RequestParam int maMau, @RequestParam int maSize, @RequestParam int quantity, @RequestParam int gia, HttpSession session) {
        SanPham anhsp = spdao.getByIdSp(maSanPham);
        MauSanPham mau = mdao.getByIdMau(maMau);
        SizeSanPham size = kdao.getByIdSize(maSize);
        if (null == session.getAttribute("giohang")) {
            List<GioHang> list = new ArrayList<>();
            GioHang gio = new GioHang();
            gio.setMaSanPham(maSanPham);
            gio.setTenSanPham(anhsp.getTenSanPham());
            gio.setMaMau(maMau);
            gio.setTenMau(mau.getTenMau());
            gio.setSize(size.getSize());
            gio.setMaSize(maSize);
            for (ChiTietSanPham chi : anhsp.getChiTietSanPhamCollection()) {
                if (chi.getChiTietSanPhamPK().getMaSanPham() == maSanPham && chi.getChiTietSanPhamPK().getMaMau() == maMau) {
                    gio.setAnh(chi.getAnhChinh());
                }
            }
            gio.setGiaTien(gia);
            gio.setSoluong(quantity);
            list.add(gio);
            session.setAttribute("giohang", list);
            int soluong = 0;

            for (GioHang gioHang : list) {
                soluong += gioHang.getSoluong();
            }
            return soluong + "";
        } else {
            List<GioHang> lsGioHangs = (List<GioHang>) session.getAttribute("giohang");
            int vitri = kiemtraSanPhamdatontai(lsGioHangs, session, maSanPham, maMau, maSize);
            if (vitri == -1) {
                GioHang gio = new GioHang();
                gio.setMaSanPham(maSanPham);
                gio.setTenSanPham(anhsp.getTenSanPham());
                gio.setMaMau(maMau);
                gio.setTenMau(mau.getTenMau());
                gio.setSize(size.getSize());
                gio.setMaSize(maSize);
                for (ChiTietSanPham chi : anhsp.getChiTietSanPhamCollection()) {
                    if (chi.getChiTietSanPhamPK().getMaSanPham() == maSanPham && chi.getChiTietSanPhamPK().getMaMau() == maMau) {
                        gio.setAnh(chi.getAnhChinh());
                    }
                }
                gio.setGiaTien(gia);
                gio.setSoluong(quantity);
                lsGioHangs.add(gio);
            } else {
                int soluongmoi = lsGioHangs.get(vitri).getSoluong() + quantity;
                lsGioHangs.get(vitri).setSoluong(soluongmoi);
            }
            int soluong = 0;

            for (GioHang gioHang : lsGioHangs) {
                soluong += gioHang.getSoluong();
            }
            return soluong + "";
        }

    }

    @RequestMapping(value = "Capnhapsoluonggiam")
    @ResponseBody
    private String Capnhapsoluonggiam(HttpSession session, @RequestParam int maSanPham, @RequestParam int maMau, @RequestParam int maSize) {
        if (null != session.getAttribute("giohang")) {
            List<GioHang> gioHangs = (List<GioHang>) session.getAttribute("giohang");

            int vitri = kiemtraSanPhamdatontai(gioHangs, session, maSanPham, maMau, maSize);
            int soluongmoi = gioHangs.get(vitri).getSoluong() - 1;
            gioHangs.get(vitri).setSoluong(soluongmoi);
        }
        int soluong = 0;
        List<GioHang> gioHangs = (List<GioHang>) session.getAttribute("giohang");
        for (GioHang gioHang : gioHangs) {
            soluong += gioHang.getSoluong();
        }
        return soluong + "";

    }

    @RequestMapping(value = "Capnhapsoluongtang")
    @ResponseBody
    private String Capnhapsoluongtang(HttpSession session, @RequestParam int maSanPham, @RequestParam int maMau, @RequestParam int maSize) {
        if (null != session.getAttribute("giohang")) {
            List<GioHang> gioHangs = (List<GioHang>) session.getAttribute("giohang");

            int vitri = kiemtraSanPhamdatontai(gioHangs, session, maSanPham, maMau, maSize);
            int soluongmoi = gioHangs.get(vitri).getSoluong() + 1;
            gioHangs.get(vitri).setSoluong(soluongmoi);
        }
        int soluong = 0;
        List<GioHang> gioHangs = (List<GioHang>) session.getAttribute("giohang");
        for (GioHang gioHang : gioHangs) {
            soluong += gioHang.getSoluong();
        }
        return soluong + "";
    }

    @RequestMapping(value = "Capnhapsoluong")
    @ResponseBody
    private String Capnhapsoluong(HttpSession session, @RequestParam int maSanPham, @RequestParam int maMau, @RequestParam int maSize, @RequestParam int quantity) {
        if (null != session.getAttribute("giohang")) {
            List<GioHang> gioHangs = (List<GioHang>) session.getAttribute("giohang");

            int vitri = kiemtraSanPhamdatontai(gioHangs, session, maSanPham, maMau, maSize);

            gioHangs.get(vitri).setSoluong(quantity);
        }
        int soluong = 0;
        List<GioHang> gioHangs = (List<GioHang>) session.getAttribute("giohang");
        for (GioHang gioHang : gioHangs) {
            soluong += gioHang.getSoluong();
        }
        return soluong + "";

    }

    @RequestMapping(value = "xoagiohang")
    @ResponseBody
    private String xoagiohang(HttpSession session, @RequestParam int maSanPham, @RequestParam int maMau, @RequestParam int maSize) {
        if (null != session.getAttribute("giohang")) {
            List<GioHang> gioHangs = (List<GioHang>) session.getAttribute("giohang");

            int vitri = kiemtraSanPhamdatontai(gioHangs, session, maSanPham, maMau, maSize);

            gioHangs.remove(vitri);
        }
        int soluong = 0;
        List<GioHang> gioHangs = (List<GioHang>) session.getAttribute("giohang");
        for (GioHang gioHang : gioHangs) {
            soluong += gioHang.getSoluong();
        }
        return soluong + "";
    }

    private int kiemtraSanPhamdatontai(List<GioHang> lsGioHangs, HttpSession session, int maSanPham, int maMau, int maSize) {

        for (int i = 0; i < lsGioHangs.size(); i++) {
            if (lsGioHangs.get(i).getMaSanPham() == maSanPham && lsGioHangs.get(i).getMaMau() == maMau && lsGioHangs.get(i).getMaSize() == maSize) {
                return i;
            }
        }
        return -1;
    }

    @RequestMapping(value = "giohang", method = RequestMethod.GET)
    public String giohang(Model model, HttpSession session) {

        int soluong = 0;
        int tongtien = 0;
        if (null != session.getAttribute("giohang")) {
            List<GioHang> gioHangs = (List<GioHang>) session.getAttribute("giohang");

            for (GioHang gioHang : gioHangs) {
                soluong += gioHang.getSoluong();
                tongtien += gioHang.tinhTongtien();
            }
           session.setAttribute("gioHangs", gioHangs);
        }
        session.setAttribute("soluong", soluong);

        session.setAttribute("tongtien", XuLyTien.dinhDangTien(tongtien));
        return "frontend/cart";
    }

    @RequestMapping(value = "checkout", method = RequestMethod.GET)
    public String checkout(Model model, HttpSession session, ModelMap mm) {
        if (session.getAttribute("accout") != null) {
            int soluong = 0;
            int tongtien = 0;
            if (null != session.getAttribute("giohang")) {
                List<GioHang> gioHangs = (List<GioHang>) session.getAttribute("giohang");
                for (GioHang gioHang : gioHangs) {
                    soluong += gioHang.getSoluong();
                    tongtien += gioHang.tinhTongtien();
                }
                model.addAttribute("gioHangs", gioHangs);

            }
            model.addAttribute("soluong", soluong);

            model.addAttribute("tongtien", XuLyTien.dinhDangTien(tongtien));
            String name = (String) session.getAttribute("accout");

            NhanVien nvien = nhanviendao.checkName(name);
            model.addAttribute("nhanvien", nvien);
            return "frontend/checkout";
        } else {
            mm.put("message", "vui lòng đăng nhập để tiếp tục mua hàng");
            return "frontend/login";
        }

    }

    @RequestMapping(value = "/ThemHoaDon", method = RequestMethod.POST)
    public String ThemHoaDon(Integer maHoaDon, String tenKhachHang, String soDT, String diaChiGiaoHang, ModelMap mm, Model model, HttpSession session) throws ParseException {

        HoaDon hoaDon = new HoaDon();

        hoaDon.setMaHoaDon(maHoaDon);
        hoaDon.setTenKhachHang(tenKhachHang);
        hoaDon.setSoDT(soDT);
        hoaDon.setDiaChiGiaoHang(diaChiGiaoHang);
        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date ngayLap = format.parse(date);
        hoaDon.setNgayLap(ngayLap);
        hoaDon.setTinhTrang(1);
        String name = (String) session.getAttribute("accout");

        NhanVien nvien = nhanviendao.checkName(name);
        int tongtien = 0;
        hoaDon.setMaNhanVien(nvien);

        if (null != session.getAttribute("giohang")) {
            List<GioHang> gioHangs = (List<GioHang>) session.getAttribute("giohang");
            for (GioHang gioHang : gioHangs) {
                tongtien += gioHang.tinhTongtien();
                SoLuongSanPhamJoin soLuongSanPhamJoin = slo.getSoluong(gioHang.getMaSanPham(), gioHang.getMaMau(), gioHang.getMaSize());
                    if (soLuongSanPhamJoin.getSoLuong() < gioHang.getSoluong()) {
                       mm.put("error", "đặt hàng thất bại do sản phẩm " +gioHang.getTenSanPham()+" chỉ còn lại số lượng là " +soLuongSanPhamJoin.getSoLuong());
                        return "frontend/cart";
                    }
            }
        }
        hoaDon.setTongTien(tongtien);
        hdao.Insert(hoaDon);
        if (hdao.getIdAnhMoiNhat() > 0) {
            if (null != session.getAttribute("giohang")) {
                List<GioHang> gioHangs = (List<GioHang>) session.getAttribute("giohang");
                for (GioHang gioHang : gioHangs) {

                    ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
                    ChiTietHoaDonPK chiTietHoaDonpk = new ChiTietHoaDonPK();
                    chiTietHoaDonpk.setMaHoaDon(hdao.getIdAnhMoiNhat());
                    chiTietHoaDonpk.setMaSanPham(gioHang.getMaSanPham());
                    chiTietHoaDonpk.setMaMau(gioHang.getMaMau());
                    chiTietHoaDonpk.setMaSize(gioHang.getMaSize());
                    chiTietHoaDon.setChiTietHoaDonPK(chiTietHoaDonpk);
                    chiTietHoaDon.setSoLuong(gioHang.getSoluong());
                    chiTietHoaDon.setGiaTien(gioHang.getGiaTien());
                    chiTietHoaDon.setThanhTien(gioHang.tinhTongtien());
                    SoLuongSanPhamJoin soLuongSanPhamJoin = slo.getSoluong(gioHang.getMaSanPham(), gioHang.getMaMau(), gioHang.getMaSize());
                     
                    SoLuongSanPham so = new SoLuongSanPham();
                    so.setSoLuong(soLuongSanPhamJoin.getSoLuong() - gioHang.getSoluong());
                    SoLuongSanPhamPK spk = new SoLuongSanPhamPK();
                    spk.setMaSanPham(gioHang.getMaSanPham());
                    spk.setMaMau(gioHang.getMaMau());
                    spk.setMaSize(gioHang.getMaSize());
                    so.setSoLuongSanPhamPK(spk);
                    int soluong = soLuongSanPhamJoin.getSoLuong() - gioHang.getSoluong();
                    if (soluong <= 0) {
                        so.setStatus(false);
                    } else {
                        so.setStatus(true);
                    }
                    hdao.UpdateSoLuong(so);
                    hdao.Insertchitiet(chiTietHoaDon);

                }

            }
            session.removeAttribute("gioHangs");
        
        session.removeAttribute("soluong");

        session.removeAttribute("tongtien");
            session.removeAttribute("giohang");
            return "redirect:";
        } else {
            if (session.getAttribute("accout") != null) {
                int soluong = 0;
                int tongtien1 = 0;
                if (null != session.getAttribute("giohang")) {
                    List<GioHang> gioHangs = (List<GioHang>) session.getAttribute("giohang");
                    for (GioHang gioHang : gioHangs) {
                        soluong += gioHang.getSoluong();
                        tongtien1 += gioHang.tinhTongtien();
                    }
                    model.addAttribute("gioHangs", gioHangs);

                }
                model.addAttribute("soluong", soluong);

                model.addAttribute("tongtien", XuLyTien.dinhDangTien(tongtien1));

                model.addAttribute("nhanvien", nvien);
                return "frontend/checkout";
            }
            return null;
        }

    }

    @RequestMapping(value = "login")
    public String initBackendLogin() {
        return "frontend/login";
    }

    @RequestMapping(value = "/backendLogin")
    public String loginBackend(NhanVien nhanvien, ModelMap mm, HttpSession session
    ) {
        boolean result = false;

        result = nhanviendao.loginStudent(nhanvien);

        if (result) {

            session.setAttribute("accout", nhanvien.getTenDangNhap());
            String name = (String) session.getAttribute("accout");

            NhanVien nvien = nhanviendao.checkName(name);
            session.setAttribute("ten", nvien.getHoTen());

            return "redirect:";

        } else {
            mm.put("message", "Sai thông tin đăng nhập.");
            return "frontend/login";
        }
    }

    @RequestMapping(value = "/checkname")
    @ResponseBody
    public Boolean checkname(@RequestParam String name, ModelMap mm, HttpSession session
    ) {

        Boolean result = nhanviendao.checkNametontai(name);

        
        return result;

    }
    @RequestMapping(value = "/checksoDT")
    @ResponseBody
    public Boolean checksoDT(@RequestParam String soDT, ModelMap mm, HttpSession session
    ) {

        Boolean result = nhanviendao.checkSoDTtontai(soDT);

        
        return result;

    }
    @RequestMapping(value = "/checkemail")
    @ResponseBody
    public Boolean checkemail(@RequestParam String email, ModelMap mm, HttpSession session
    ) {

        Boolean result = nhanviendao.checkEmailtontai(email);

        
        return result;

    }

    @RequestMapping(value = "/backendSigup", method = RequestMethod.POST)
    public String backendSigup(ModelMap mm, NhanVien nhanvien
    ) {

        boolean result = nhanviendao.Insert(nhanvien);

        if (result) {
            mm.put("success", "tạo tài khoản thành công");

        } else {
            mm.put("error", "tạo tài khoản thất bại");

        }

        return "frontend/login";
    }

    @RequestMapping(value = "/logoutBackend")
    public String logoutBackend(HttpSession session, ModelMap mm, HttpServletRequest request
    ) {

        if (session.getAttribute("accout") != null || session.getAttribute("ten") != null) {
            session.removeAttribute("accout");
            session.removeAttribute("ten");
        }
        return "redirect:";
    }
}
