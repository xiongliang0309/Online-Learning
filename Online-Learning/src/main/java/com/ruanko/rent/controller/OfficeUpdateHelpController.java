package com.ruanko.rent.controller;

import com.ruanko.rent.entity.*;
import com.ruanko.rent.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class OfficeUpdateHelpController {

    @Autowired
    private LandlordService landlordService;

    @Autowired
    private KechenService kechenService;

    @Autowired
    private AdminService adminService;


    @Autowired
    private Landlord landlord;

    private Date date = new Date();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    //显示助教
    @RequestMapping("/office_update_help")
    public String officeHelpList(Model model) {
        List<Landlord> landlordList = landlordService.getLandlordList();
        model.addAttribute("landlordList", landlordList);
        List<Kechen> kechenList = kechenService.getKechenList();
        model.addAttribute("kechenList", kechenList);
        List<Admin> adminList = adminService.getAdminList();
        model.addAttribute("adminList", adminList);
        return "office_update_help";
    }

    //添加助教
    @RequestMapping(value="/officeAddHelp.action", method = POST)
    public String officeAddHelp(String id,String password,String name,String phone,String email,String teachername,String kechenid){

        landlord.setPhone(phone);
        landlord.setRegisterdate(sdf.format(date));
        landlord.setEmail(email);
        landlord.setId(id);
        landlord.setName(name);
        landlord.setPassword(password);
        landlord.setTeachername(teachername);
        landlord.setKechenid(kechenid);
        //保存到数据库
        try{
            landlordService.save(landlord);
            return "redirect:/office_update_help";
        }catch(Exception e) {
            System.out.print(e);
            return "error";
        }
    }

    // 删除助教
    @RequestMapping("/officeDeleteHelp")
    public String officeDeleteHelp(String id){
        landlordService.delete(id);
        return "redirect:/office_update_help";
    }
}
