package com.ruanko.rent.controller;

import com.ruanko.rent.entity.House;
import com.ruanko.rent.entity.Landlord;
import com.ruanko.rent.entity.Order;
import com.ruanko.rent.entity.Studydata;
import com.ruanko.rent.service.HouseService;
import com.ruanko.rent.service.LandlordService;
import com.ruanko.rent.service.OrderService;
import com.ruanko.rent.service.StudydataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StudentDataController {
    @Autowired
    private StudydataService studydataService;

    //显示学习资料
    @RequestMapping("/student_data")
    public String showStudentData(Model model){
        List<Studydata> studydataList = studydataService.getStudydataList();
        model.addAttribute("studydataList", studydataList);
        return "student_data";
    }



    //删除订单操作

}
