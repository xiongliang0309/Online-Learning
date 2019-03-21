package com.ruanko.rent.controller;

import com.ruanko.rent.entity.House;
import com.ruanko.rent.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TeacherUpdateStudentController {
    @Autowired
    private HouseService houseService;

    //显示所有的学生
    @RequestMapping("/teacher_update_student")
    public String showAdminHouseInfoPage(Model model) {
        List<House> houseList = houseService.getHouseList();
        model.addAttribute("houseList", houseList);
        return "teacher_update_student";
    }

    @RequestMapping("/adminShowHouseInfo")
    public String showAdminHouseDetailInfoPage(Model model, int id) {
        House house = houseService.findHouseById(id);
        model.addAttribute("house", house);
        return "admin_house_detail_info";
    }

    @RequestMapping("/adminDeleteHouseInfo")
    public String adminDeleteHouseInfo(int id) {
        houseService.delete(id);
        return "redirect:/admin_house_info";
    }
}
