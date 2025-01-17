package com.ruanko.rent.controller;

import com.ruanko.rent.entity.Admin;
import com.ruanko.rent.entity.Landlord;
import com.ruanko.rent.entity.Leaseholder;
import com.ruanko.rent.entity.Office;
import com.ruanko.rent.service.AdminService;
import com.ruanko.rent.service.LandlordService;
import com.ruanko.rent.service.LeaseholderService;
import com.ruanko.rent.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class LoginController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private LeaseholderService leaseholderService;
    @Autowired
    private LandlordService landlordService;
    @Autowired
    private OfficeService officeService;

    //跳转到登录
    @RequestMapping(value={"/", "/login"})
    public String showLogin() {
        return "login";
    }


    //登录校验判断
    @RequestMapping(value="/loginCheck.action", method = POST)
    public String loginCheck(HttpSession session, String id, String password, String option) {
        if(option.equals("teacher")) {
            Admin admin = adminService.findAdminById(id);
            if (admin == null || !admin.getPassword().equals(password)) {
                return "login_failed";
            } else {
                session.setAttribute("admin", admin);
                return "redirect:/teacher";   //重定向到teacher主界面
            }
        }
        else if(option.equals("student")){
            Leaseholder leaseholder = leaseholderService.findLeaseholderById(id);
            if (leaseholder == null || !leaseholder.getPassword().equals(password)) {
                return "login_failed";
            } else {
                session.setAttribute("leaseholder", leaseholder);
                return "redirect:/student";   //重定向到leaseholder主界面
            }
        }
        else if(option.equals("office")){
            Office office = officeService.findOfficeById(id);
            if (office == null || !office.getPassword().equals(password)) {
                return "login_failed";
            } else {
                session.setAttribute("office", office);
                return "redirect:/office";   //重定向到office主界面
            }
        }
        else {
            Landlord landlord = landlordService.findLandlordById(id);
            if (landlord == null || !landlord.getPassword().equals(password)) {
                return "login_failed";
            } else {
                session.setAttribute("landlord", landlord);
                return "redirect:/help";   //重定向到help主界面
            }
        }
    }
}