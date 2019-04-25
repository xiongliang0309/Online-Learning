package com.ruanko.rent.controller;

import com.ruanko.rent.entity.Leaseholder;
import com.ruanko.rent.service.LeaseholderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

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

    //跳转到加入班级详情界面
    @RequestMapping("/teacherAddToClass")
    public String showTeacherAddToClassPage(HttpSession session, String id) {
        Leaseholder leaseholder = leaseholderService.findLeaseholderById(id);
        session.setAttribute("leaseholder", leaseholder);
        return "teacher_add_toclass";
    }

    //加入班级
    @RequestMapping(value = "/addToClass.action", method = POST)
    public String addToClass(HttpSession session, String classid) {

        Leaseholder leaseholder = (Leaseholder) session.getAttribute("leaseholder");
        leaseholder.setClassid(classid);
        leaseholderService.edit(leaseholder);
        session.setAttribute("leaseholder", leaseholder);
        return "redirect:/teacher_update_student";
    }


}
