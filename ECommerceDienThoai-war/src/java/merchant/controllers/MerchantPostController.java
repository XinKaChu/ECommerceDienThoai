/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merchant.controllers;

import ejb.entities.NguoiBan;
import ejb.entities.SanPham;
import java.io.File;
import java.util.Date;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import web.models.SanPhamViewModel;
import web.services.GoiTinService;
import web.services.PostService;

/**
 *
 * @author XinKaChu
 */
@Controller
@RequestMapping("merchant/post")
public class MerchantPostController {

    //Nhúng GoiTinService để sử dụng
    @Autowired
    PostService postService;

    @Autowired
    ServletContext app;

    @RequestMapping("new")
    public String post(Model model) {
        model.addAttribute("hangSanXuat", postService.layDanhSachHangSanXuat());
        model.addAttribute("sanPham", new SanPhamViewModel());
        return "merchant/home/post";
    }

    @RequestMapping("list")
    public String list(Model model, HttpSession httpSession) {
        NguoiBan nguoiBan = (NguoiBan) httpSession.getAttribute("nguoiBan");
        model.addAttribute("sanPham", nguoiBan.getSanPhamList());
        return "merchant/home/post-list";
    }

//    @RequestMapping(value = "new", method=RequestMethod.POST)
//    public String dangTin(Model model,
//            @ModelAttribute("sanPham")  SanPhamViewModel sanPhamVM,
//            @RequestParam("hinhAnh") MultipartFile hinhAnh,
//            
//            HttpSession httpSession) {
//        String temp = postService.dangTin(model, sanPhamVM, hinhAnh, httpSession);
//        return "redirect:/merchant/home/post-list";
//    }
    
    @RequestMapping(value="new", method=RequestMethod.POST)
    public String dangTin(Model model, 
            @RequestParam(value = "tenMay", required = true) String tenMay,
            @RequestParam("hinhAnh") MultipartFile hinhAnh,
            @RequestParam("giaBan") Integer giaBan,
            @RequestParam("soLuong") Integer soLuong,
            @RequestParam("hangSanXuat") Integer hangSanXuat,
            @RequestParam("moTa") String moTa,
            @RequestParam("kichThuocManHinh") String kichThuocManHinh,
            @RequestParam("cpu") String cpu,
            @RequestParam("tocDoCPU") String tocDoCPU,
            @RequestParam("RAM") String RAM,
            @RequestParam("boNhoTrong") String boNhoTrong,
            @RequestParam("heDieuHanh") String heDieuHanh,
            @RequestParam("cameraTruoc") String cameraTruoc,
            @RequestParam("cameraSau") String cameraSau,
            @RequestParam("dungLuongPin") String dungLuongPin,
            @RequestParam("theNhoNgoai") Boolean theNhoNgoai,
            @RequestParam("chongNuoc") Boolean chongNuoc,
            @RequestParam("baoHanh") String baoHanh,
            @RequestParam("tonKho") Integer tonKho,
            HttpSession httpSession){
        String temp = postService.dangTin(model, tenMay, hinhAnh, giaBan,
                soLuong, hangSanXuat, moTa, kichThuocManHinh, cpu, tocDoCPU,
                RAM, boNhoTrong, heDieuHanh, cameraTruoc, cameraSau,
                dungLuongPin, theNhoNgoai, chongNuoc, baoHanh, tonKho, httpSession);
        return "redirect:/merchant/home/post-list";
    }
            
}
