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
public class OfficeUpdateStudentController {

    @Autowired
    private LeaseholderService leaseholderService;

    @Autowired
    private ClassesService classesService;

    @Autowired
    private Leaseholder leaseholder;

    private Date date = new Date();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


    //添加学生
    @RequestMapping(value="/officeAddStudent.action", method = POST)
    public String officeAddStudent(String id,String password,String name,String phone,String email,String classid){

        leaseholder.setPhone(phone);
        leaseholder.setRegisterdate(sdf.format(date));
        leaseholder.setEmail(email);
        leaseholder.setId(id);
        leaseholder.setName(name);
        leaseholder.setPassword(password);
        leaseholder.setClassid(classid);
        //保存到数据库
        try{
            leaseholderService.save(leaseholder);
            return "redirect:/officeClassStudent?classid="+classid;
        }catch(Exception e) {
            System.out.print(e);
            return "error";
        }
    }

    // 删除学生
    @RequestMapping("/officeDeleteStudent")
    public String officeDeleteStudent(String id,String classid){
        leaseholderService.delete(id);
        return "redirect:/officeClassStudent?classid="+classid;
    }

}
