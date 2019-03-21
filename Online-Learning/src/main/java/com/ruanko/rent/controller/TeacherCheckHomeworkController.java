package com.ruanko.rent.controller;

import com.ruanko.rent.entity.Landlord;
import com.ruanko.rent.service.LandlordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class TeacherCheckHomeworkController {
    @Autowired
    private LandlordService landlordService;

    //老师批改学生作业
    @RequestMapping("/teacher_check_homework")
    public String showAdminLandlordInfoPage(Model model) {
        List<Landlord> landlordList = landlordService.getLandlordList();
        model.addAttribute("landlordList", landlordList);
        return "teacher_check_homework";
    }

    //跳转到房东账号修改界面
    @RequestMapping("/adminChangeLandlordInfo")
    public String adminChangeLandlordInfo(HttpSession session, String id) {
        Landlord landlord = landlordService.findLandlordById(id);
        session.setAttribute("landlord", landlord);
        return "admin_landlord_change_info";
    }

    //修改房东账号操作
    @RequestMapping(value = "/changeLandlordInfo.action", method = POST)
    public String changeLandlordInfo(HttpSession session, String name, String phone, String email) {
        Landlord landlord = (Landlord) session.getAttribute("landlord");
        landlord.setName(name);
        landlord.setPhone(phone);
        landlord.setEmail(email);

        //保存到数据库
        try{
            landlordService.edit(landlord);
            session.setAttribute("landlord", landlord);
            return "redirect:/teacher_check_homework"; //操作成功，重定向到房东账号列表
        }catch(Exception e) {
            System.out.print(e);
            return "error";
        }
    }

    //删除房东账号操作
    @RequestMapping("/adminDeleteLandlordInfo")
    public String adminDeleteLandlordInfo(String id){
        landlordService.delete(id);
        return "redirect:/teacher_check_homework";
    }
}
