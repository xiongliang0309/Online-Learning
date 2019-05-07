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
public class OfficeUpdateTeacherController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private Admin admin;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    //显示学生
    @RequestMapping("/office_update_teacher")
    public String officeTeacherList(Model model) {
        List<Admin> adminList = adminService.getAdminList();
        model.addAttribute("adminList", adminList);
        return "office_update_teacher";
    }

    //添加学生
    @RequestMapping(value="/officeAddTeacher.action", method = POST)
    public String officeAddTeacher(String id,String password,String name,String phone,String email){
        admin.setPhone(phone);
        admin.setRegisterdate(sdf.format(new Date()));
        admin.setEmail(email);
        admin.setId(id);
        admin.setName(name);
        admin.setPassword(password);
        //保存到数据库
        try{
            adminService.save(admin);
            return "redirect:/office_update_teacher";
        }catch(Exception e) {
            System.out.print(e);
            return "error";
        }
    }

    // 删除学生
    @RequestMapping("/officeDeleteTeacher")
    public String officeDelete(String id){
        adminService.delete(id);
        return "redirect:/office_update_teacher";
    }



}
