package com.ruanko.rent.controller;

import com.ruanko.rent.entity.Leaseholder;
import com.ruanko.rent.service.LeaseholderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TeacherUpdateStudentController {

    @Autowired
    private LeaseholderService leaseholderService;

    //显示所有的学生
    @RequestMapping("/teacher_update_student")
    public String showStudentList(Model model) {
        List<Leaseholder> leaseholderList = leaseholderService.getLeaseholderList();
        model.addAttribute("leaseholderList", leaseholderList);
        return "teacher_update_student";
    }

//    @RequestMapping("/adminShowHouseInfo")
//    public String showAdminHouseDetailInfoPage(Model model, int id) {
//        House house = houseService.findHouseById(id);
//        model.addAttribute("house", house);
//        return "admin_house_detail_info";
//    }
//
//    @RequestMapping("/adminDeleteHouseInfo")
//    public String adminDeleteHouseInfo(int id) {
//        houseService.delete(id);
//        return "redirect:/admin_house_info";
//    }
}
