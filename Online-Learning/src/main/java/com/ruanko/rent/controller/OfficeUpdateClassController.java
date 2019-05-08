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
public class OfficeUpdateClassController {

    @Autowired
    private ClassesService classesService;

    @Autowired
    private LeaseholderService leaseholderService;


    @Autowired
    private Classes classes;

    private Date date = new Date();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    //显示班级
    @RequestMapping("/office_update_class")
    public String officeClassList(Model model) {
        List<Classes> classesList = classesService.getClassesList();
        model.addAttribute("classesList", classesList);
        return "office_update_class";
    }

    //添加班级
    @RequestMapping(value="/officeAddClass.action", method = POST)
    public String officeAddClass(String classid){

        classes.setClassid(classid);

        //保存到数据库
        try{
            classesService.save(classes);
            return "redirect:/office_update_class";
        }catch(Exception e) {
            System.out.print(e);
            return "error";
        }
    }

    // 删除班级
    @RequestMapping("/officeDeleteClass")
    public String officeDeleteClass(String classid){
        classesService.delete(classid);
        return "redirect:/office_update_class";
    }

    //班级花名册
    //显示班级所有的学生
    @RequestMapping("/officeClassStudent")
    public String showClassStudentList(Model model,String classid) {
        Classes classes = classesService.findClassesById(classid);
        model.addAttribute("classes", classes);
        List<Leaseholder> leaseholderList = leaseholderService.getLeaseholderList();
        model.addAttribute("leaseholderList", leaseholderList);
        return "office_update_student";
    }
}
