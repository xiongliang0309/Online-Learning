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

    //显示学生
    @RequestMapping("/office_update_student")
    public String officeStudentList(Model model) {
        List<Leaseholder> leaseholderList = leaseholderService.getLeaseholderList();
        model.addAttribute("leaseholderList", leaseholderList);
        List<Classes> classesList = classesService.getClassesList();
        model.addAttribute("classesList", classesList);

        return "office_update_student";
    }

    //添加学生
    @RequestMapping(value="/officeAddStudent.action", method = POST)
    public String officeAddStudent(HttpSession session, String id,String password,String name,String phone,String email,String registerdate,String classid){
        leaseholder.setClassid(classid);
        leaseholder.setPhone(phone);
        leaseholder.setRegisterdate(sdf.format(date));
        leaseholder.setEmail(email);
        leaseholder.setId(id);
        leaseholder.setName(name);
        leaseholder.setPassword(password);
        //保存到数据库
        try{
            leaseholderService.save(leaseholder);
            return "redirect:/office_update_student";
        }catch(Exception e) {
            System.out.print(e);
            return "error";
        }
    }

    // 删除学生
    @RequestMapping("/officeDeleteStudent")
    public String officeDeleteStudent(String id){
        leaseholderService.delete(id);
        return "redirect:/office_update_student";
    }

}
