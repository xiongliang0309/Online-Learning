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
public class OfficeKechenController {

    @Autowired
    private KechenService kechenService;

    @Autowired
    private Kechen kechen;


    //显示系统课程
    @RequestMapping("/office_kechen")
    public String OfficeKechenList(Model model) {
        List<Kechen> kechenList = kechenService.getKechenList();
        model.addAttribute("kechenList", kechenList);

        return "office_kechen";
    }

    //开设系统课程
    @RequestMapping(value="/officeAddKechen.action", method = POST)
    public String teacherAddKechen(HttpSession session, String kechenname,String kechenintro,String xuefen){
        Admin admin = (Admin) session.getAttribute("admin");
      //  Kechen kechen = kechenService.findKechenById(kechenid);
        kechen.setKechenname(kechenname);
       kechen.setKechenintro(kechenintro);
       kechen.setXuefen(xuefen);

        //保存到数据库
        try{
            kechenService.save(kechen);
            return "redirect:/office_kechen";
        }catch(Exception e) {
            System.out.print(e);
            return "error";
        }
    }

    //删除课程
    @RequestMapping("/officeDeleteKechen")
    public String officeDeleteKechen(String kechenid){
        kechenService.delete(kechenid);
        return "redirect:/office_kechen";
    }


    //编辑课程
    @RequestMapping("/officeEditKechen")
    public String officeEditKechen(Model model,String kechenid){
        Kechen kechen=kechenService.findKechenById(kechenid);
        model.addAttribute("kechen",kechen);
        return "office_edit_kechen";
    }

    @RequestMapping(value="/officeEditKechen.action", method = POST)
    public String teacherEditKechen(String kechenid, String kechenname,String kechenintro,String xuefen){
        kechen.setKechenid(kechenid);
        kechen.setKechenname(kechenname);
        kechen.setKechenintro(kechenintro);
        kechen.setXuefen(xuefen);

        //保存到数据库
        try{
            kechenService.save(kechen);

            return "redirect:/office_kechen";
        }catch(Exception e) {
            System.out.print(e);
            return "error";
        }
    }
}
