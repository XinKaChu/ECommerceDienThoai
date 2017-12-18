/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controllers;

import ejb.business.CtPhieuMuaHangBusiness;
import ejb.business.DanhGiaBusiness;
import ejb.business.GoiTinBusiness;
import ejb.business.ThongKeBusiness;
import ejb.entities.Admin;
import ejb.entities.CauHinh;
import ejb.entities.CtPhieuMuaHang;
import ejb.entities.DanhGia;
import ejb.entities.GoiTin;
import ejb.entities.NguoiBan;
import ejb.entities.NguoiMua;
import ejb.entities.PhieuMuaHang;
import ejb.entities.PhieuMuaTinOffline;
import ejb.entities.PhieuNopPhat;
import ejb.sessions.CauHinhFacade;
import ejb.sessions.DanhGiaFacade;
import ejb.sessions.GoiTinFacade;
import ejb.sessions.NguoiBanFacade;
import ejb.sessions.PhieuMuaHangFacade;
import ejb.sessions.PhieuMuaTinOfflineFacade;
import ejb.sessions.PhieuNopPhatFacade;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import web.services.AdminService;
import web.services.LookupFactory;
import web.services.NguoiBanService;

/**
 *
 * @author DacTien
 */
@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    AdminService adminService;
    @Autowired 
    NguoiBanService nguoiBanService;
    
    PhieuMuaHangFacade phieuMuaHangFacade = (PhieuMuaHangFacade) LookupFactory.lookupFacadeBean("PhieuMuaHangFacade");
    CtPhieuMuaHangBusiness ctPhieuMuaHangBusiness = (CtPhieuMuaHangBusiness) LookupFactory.lookupBusinessBean("CtPhieuMuaHangBusiness");
    CauHinhFacade cauHinhFacade = (CauHinhFacade) LookupFactory.lookupFacadeBean("CauHinhFacade");
    NguoiBanFacade nguoiBanFacade = (NguoiBanFacade) LookupFactory.lookupFacadeBean("NguoiBanFacade");
    GoiTinFacade goiTinFacade = (GoiTinFacade) LookupFactory.lookupFacadeBean("GoiTinFacade");
    PhieuMuaTinOfflineFacade phieuMuaTinOfflineFacade = (PhieuMuaTinOfflineFacade) LookupFactory.lookupFacadeBean("PhieuMuaTinOfflineFacade");
    PhieuNopPhatFacade phieuNopPhatFacade = (PhieuNopPhatFacade) LookupFactory.lookupFacadeBean("PhieuNopPhatFacade");
    DanhGiaFacade danhGiaFacade = (DanhGiaFacade) LookupFactory.lookupFacadeBean("DanhGiaFacade");
    DanhGiaBusiness danhGiaBusiness = (DanhGiaBusiness) LookupFactory.lookupBusinessBean("DanhGiaBusiness");
    ThongKeBusiness thongKeBusiness = (ThongKeBusiness) LookupFactory.lookupBusinessBean("ThongKeBusiness");
    GoiTinBusiness goiTinBusiness = (GoiTinBusiness) LookupFactory.lookupBusinessBean("GoiTinBusiness");
    
    @RequestMapping("login")
    public String login() {
        return "admin/login/login";
    }
    
//    @ResponseBody
//    @RequestMapping(value = "login-check", produces = "application/x-www-form-urlencoded;charset=UTF-8")
//    public String login(@RequestParam("email") String email,
//            @RequestParam("password") String password,
//            HttpSession httpSession) {
//        String temp = adminService.dangNhap(email, password, httpSession);
//        return temp;
//    }
    
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(Model model,
            @RequestParam("Email") String email,
            @RequestParam("Password") String password,
            HttpSession httpSession) {
        String temp = adminService.dangNhap(email, password, httpSession);
        if (temp.equals("Đăng nhập thành công")) {
            return "redirect:/admin/index.php";
        }
        model.addAttribute("mess", temp);
        return "admin/login/login";
    }
    
    @RequestMapping("index")
    public String index() {
        return "admin/home/index";
    }
    
    /*
    * Quản lý MERCHANT
    */
    //Kích hoạt tài khoản Merchant
    @RequestMapping("active-account")
    public String kichHoatMerchant(Model model) {
        List<NguoiBan> list = adminService.layDanhSachNguoiBan();
        model.addAttribute("list", list);
        return "admin/account/active-account";
    }
    
    @RequestMapping("active-account/{id}")
    public String kichHoatMerchant(@PathVariable("id") Integer id,
            Model model) {
        adminService.kichHoatNguoiBan(id, model);
        return "redirect:/admin/active-account.php";
    }
    
    //SEARCH Merchant
    @RequestMapping(value="search-merchant", method = RequestMethod.POST)
    public String timKiemMerchant(Model model, 
            @RequestParam("cmnd") String cmnd) {
        List<NguoiBan> merchant = adminService.timKiemNguoiBan(cmnd);
        if (merchant.size() != 0) {
            model.addAttribute("list", merchant);
        }
        else model.addAttribute("mess", "Không tìm thấy kết quả");
        return "admin/account/active-account";
    }
    
    /*
    * Quản lý CUSTOMER
    */
    //QUản lý Customer
    @RequestMapping("manage-customer")
    public String quanLyCustomer(Model model) {
        List<NguoiMua> list = adminService.layDanhSachNguoiMua();
        model.addAttribute("list", list);
        return "admin/account/manage-customer";
    }
    
    //Cấu hình số lần block
    @RequestMapping("block")
    public String block(Model model) {
        CauHinh cauHinh = cauHinhFacade.find(1);
        model.addAttribute("cauHinh", cauHinh);
        return "admin/account/block";
    }
    
    @RequestMapping(value="block", method = RequestMethod.POST)
    public String block(Model model, @RequestParam("soLan") int soLan) {
        CauHinh cauHinh = cauHinhFacade.find(1);
        model.addAttribute("cauHinh", cauHinh);
        return "admin/account/block";
    }
    
    /*
    * Quản lý PHIẾU MUA HÀNG
    */
    @RequestMapping("order")
    public String order(Model model) {
        List<PhieuMuaHang> list = phieuMuaHangFacade.findAll();
        model.addAttribute("phieuMuaHangs", list);
        return "admin/order/danhSachPhieuMuaHang";
    }
    
    @RequestMapping("order/detail/{id}")
    public String orderDetail(@PathVariable("id") Integer id, Model model) {
        PhieuMuaHang phieuMuaHang = phieuMuaHangFacade.find(id);
        model.addAttribute("phieuMuaHang", phieuMuaHang);
        List<CtPhieuMuaHang> list_ct = ctPhieuMuaHangBusiness.layChiTietTheoMaPhieuMuaHang(id);
        model.addAttribute("ctPhieuMuaHang", list_ct);

        //Group Các chi tiết PMH theo người bán
        List<NguoiBan> listNguoiBan = new ArrayList<>();
        for (CtPhieuMuaHang ctPhieuMuaHang : list_ct) {
            listNguoiBan.add(ctPhieuMuaHang.getIdNguoiBan());
        }
        model.addAttribute("listNguoiBan", listNguoiBan);
        return "admin/order/detail";
    }
    
    @RequestMapping("locked-account")
    public String lockedAccount(Model model) {
        List<NguoiBan> temp = nguoiBanFacade.findAll();
        List<NguoiBan> list = new ArrayList<>();
        for (NguoiBan nguoiBan : temp) {
            if (nguoiBan.getBiKhoa() == true) {
                list.add(nguoiBan);
            }
        }
        model.addAttribute("list", list);
        return "admin/account/locked-account";
    }
    
    @RequestMapping("phieu-nop-phat/them-phieu-phat/{id}")
    public String themPhieuNopPhat(@PathVariable("id") Integer id, HttpSession httpSession) {
        nguoiBanService.themPhieuNopPhat(id, httpSession);
        return "redirect:/admin/locked-account.php";
    }
    
    @RequestMapping("phieu-mua-tin-offline/them-phieu-mua-tin-offline/{id}")
    public String themPhieuMuaTinOffline(Model model, @PathVariable("id") Integer id) {
        List<GoiTin> goiTins = goiTinFacade.findAll();
        model.addAttribute("listGoiTin", goiTins);
        NguoiBan nguoiBan = nguoiBanFacade.find(id);
        model.addAttribute("nguoiBan", nguoiBan);     
        return "admin/goi-tin/them-goi-tin-offline";
    }
    
    @ResponseBody
    @RequestMapping("getInfoGoiTin")
    public Object getGoiTin(@RequestParam("id") Integer id)
    {
        return goiTinBusiness.getGoiTinInfo(id);
    }
    
    @RequestMapping(value="phieu-mua-tin-offline/them-phieu-mua-tin-offline/{id}", method = RequestMethod.POST)
    public String themPhieuMuaTinOffline(@PathVariable("id") Integer id,
            @RequestParam("goiTin") Integer idGoiTin,
            HttpSession httpSession) {
        //Lưu thông tin phiếu mua tin tại trụ sở
        NguoiBan nguoiBan = nguoiBanFacade.find(id);   
        GoiTin goiTin = goiTinFacade.find(idGoiTin);
        PhieuMuaTinOffline phieuMuaTinOffline = new PhieuMuaTinOffline();
        phieuMuaTinOffline.setGiaBan(goiTin.getGiaBan());
        phieuMuaTinOffline.setIdAdmin((Admin) httpSession.getAttribute("admin"));
        phieuMuaTinOffline.setIdGoiTin(goiTin);
        phieuMuaTinOffline.setIdNguoiBan(nguoiBan);
        phieuMuaTinOffline.setNgayMua(new Date());
        try {
            phieuMuaTinOfflineFacade.create(phieuMuaTinOffline);
            //Cập nhật số lượng tin tồn của Merchant
            //nguoiBan.gS
        } catch (Exception e) {
            throw e;
        }
        return "redirect:/admin/active-account.php";
    }
    
    @RequestMapping("phieu-mua-tin-offline")
    public String quanLyPhieuMuaTinOffline(Model model) {
        List<PhieuMuaTinOffline> list = phieuMuaTinOfflineFacade.findAll();
        model.addAttribute("list", list);
        return "admin/goi-tin/quan-ly-phieu-mua-tin-offline";
    }
    
    @RequestMapping("phieu-nop-phat")
    public String quanLyPhieuNopPhat(Model model) {
        List<PhieuNopPhat> list = phieuNopPhatFacade.findAll();
        model.addAttribute("list", list);
        return "admin/phieu-nop-phat/quan-ly-phieu-nop-phat";
    }
    
    @RequestMapping("danh-gia")
    public String quanLyDanhGia(Model model) {
        List<DanhGia> list = danhGiaFacade.findAll();
        model.addAttribute("list", list);
        
        List<Object[]> items = danhGiaBusiness.thongKeDanhGia();
        model.addAttribute("items", items);
        return "admin/danh-gia/quan-ly-danh-gia";
    }
    
    @RequestMapping("thong-ke-danh-gia")
    public String thongKeDanhGia(Model model) {
        List<Object[]> list = danhGiaBusiness.thongKeDanhGia();
        model.addAttribute("items", list);
        return "";
    }
    
    @RequestMapping("thong-ke-doanh-thu")
    public String thongKeDoanhThu(Model model) {
        List<Long> list = thongKeBusiness.thongKeDoanhThu();
        model.addAttribute("items", list);
        return "admin/thong-ke/thong-ke-doanh-thu";
    }
    
    @RequestMapping("thong-ke-doanh-thu-theo-thang")
    public String thongKeDoanhThuTheoThang(Model model) {
        List<Long> list1 = thongKeBusiness.thongKeDoanhThuTheoThang(1);
        List<Long> list2 = thongKeBusiness.thongKeDoanhThuTheoThang(2);
        List<Long> list3 = thongKeBusiness.thongKeDoanhThuTheoThang(3);
        List<Long> list4 = thongKeBusiness.thongKeDoanhThuTheoThang(4);
        List<Long> list5 = thongKeBusiness.thongKeDoanhThuTheoThang(5);
        List<Long> list6 = thongKeBusiness.thongKeDoanhThuTheoThang(6);
        List<Long> list7 = thongKeBusiness.thongKeDoanhThuTheoThang(7);
        List<Long> list8 = thongKeBusiness.thongKeDoanhThuTheoThang(8);
        List<Long> list9 = thongKeBusiness.thongKeDoanhThuTheoThang(9);
        List<Long> list10 = thongKeBusiness.thongKeDoanhThuTheoThang(10);
        List<Long> list11 = thongKeBusiness.thongKeDoanhThuTheoThang(11);
        List<Long> list12 = thongKeBusiness.thongKeDoanhThuTheoThang(12);
        model.addAttribute("list1", list1);
        model.addAttribute("list2", list2);
        model.addAttribute("list3", list3);
        model.addAttribute("list4", list4);
        model.addAttribute("list5", list5);
        model.addAttribute("list6", list6);
        model.addAttribute("list7", list7);
        model.addAttribute("list8", list8);
        model.addAttribute("list9", list9);
        model.addAttribute("list10", list10);
        model.addAttribute("list11", list11);
        model.addAttribute("list12", list12);
        return "admin/thong-ke/thong-ke-doanh-thu-theo-thang";
    }
}
