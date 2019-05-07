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
public class TeacherKechenController {
    @Autowired
    private AddkechenService addkechenService;

    @Autowired
    private KechenService kechenService;

    @Autowired
    private ClassesService classesService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private Addkechen addkechen;

    @Autowired
    private Course course;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @RequestMapping("/teacher_kechen")
    public String TeacherAddKechenList(Model model) {
        List<Addkechen> addkechenList = addkechenService.getAddkechenList();
        model.addAttribute("addkechenList", addkechenList);
        List<Kechen> kechenList = kechenService.getKechenList();
        model.addAttribute("kechenList", kechenList);
        return "teacher_kechen";
    }

    //开设课程
    @RequestMapping(value="/teacherAddKechen.action", method = POST)
    public String teacherAddKechen(HttpSession session, String kechenid){
        Admin admin = (Admin) session.getAttribute("admin");
        Kechen kechen = kechenService.findKechenById(kechenid);
        addkechen.setKechenid(kechenid);
        addkechen.setTeachername(admin.getName());
        addkechen.setXuefen(kechen.getXuefen());
        addkechen.setKechenname(kechen.getKechenname());
        addkechen.setKechenintro(kechen.getKechenintro());

        //保存到数据库
        try{
            addkechenService.save(addkechen);
            return "redirect:/teacher_kechen";
        }catch(Exception e) {
            System.out.print(e);
            return "error";
        }
    }

    //删除课程
    @RequestMapping("/teacherDeleteKechen")
    public String teacherDeleteNotice(String addkechenid){
        addkechenService.delete(addkechenid);
        return "redirect:/teacher_kechen";
    }


    //跳转到addkechen详情界面
    @RequestMapping("/teacherKechenDetail")
    public String teacherAddkechenDetail(Model model, String addkechenid) {
        Addkechen addkechen = addkechenService.findAddkechenById(addkechenid);
        model.addAttribute("addkechen", addkechen);
        List<Course> courseList = courseService.getCourseList();
        model.addAttribute("courseList", courseList);
        List<Classes> classesList = classesService.getClassesList();
        model.addAttribute("classesList", classesList);
        return "teacher_kechen_detail";
    }


    //加入班级
    @RequestMapping(value="/teacherAddClass.action", method = POST)
    public String teacherAddClass(HttpSession session, String classid,String addkechenid){
        Admin admin = (Admin) session.getAttribute("admin");
        Addkechen addkechen = addkechenService.findAddkechenById(addkechenid);
        course.setClassid(classid);
        course.setTeachername(admin.getName());
        course.setKechenid(addkechen.getKechenid());
        course.setIntro(addkechen.getKechenintro());
        course.setKechenname(addkechen.getKechenname());
        course.setCoursedate(sdf.format(new Date()));

        //保存到数据库
        try{
            courseService.save(course);
            return "redirect:/teacherKechenDetail?addkechenid="+addkechenid;
        }catch(Exception e) {
            System.out.print(e);
            return "error";
        }
    }

    //删除班级课程
    @RequestMapping("/teacherDeleteCourse")
    public String teacherDeleteCourse(String id,String addkechenid){
        courseService.delete(id);
        return "redirect:/teacherKechenDetail?addkechenid="+addkechenid;
    }
}
