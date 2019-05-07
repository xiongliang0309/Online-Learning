package com.ruanko.rent.controller;

import com.ruanko.rent.entity.Office;
import com.ruanko.rent.service.OfficeService;
import com.ruanko.rent.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class OfficeSelfInfoController {
    @Autowired
    private OfficeService officeService;

    //跳转到教务个人信息页面
    @RequestMapping("/office_self_info")
    public String showOfficeSelfInfoPage()
    {
        return "office_self_info";
    }

    //修改个人信息操作
    @RequestMapping(value = "/changeOfficeSelfInfo.action", method = POST)
    public String changeOfficeSelfInfo(HttpSession session, String phone, String email, @RequestParam("icon") MultipartFile file) {
        Office office = (Office) session.getAttribute("office");
        office.setPhone(phone);
        office.setEmail(email);
        String newIcon = FileUtil.uploadFile(file);
        if(newIcon != null){
            office.setIcon(newIcon);
        }

        //保存到数据库
        try{
            officeService.edit(office);
            session.setAttribute("office", office);
            return "redirect:/office_self_info";
        }catch(Exception e) {
            System.out.print(e);
            return "error";
        }
    }

    //跳转到修改密码界面
    @RequestMapping("/office_self_change_password")
    public String showOfficeSelfChangePasswordPage()
    {
        return "office_self_change_password";
    }

    //修改密码操作
    @RequestMapping(value = "/changeOfficeSelfPassword.action", method = POST)
    public String changeOfficeSelfPassword(HttpSession session, String oldpassword, String newpassword1, String newpassword2){
        Office office = (Office) session.getAttribute("office");

        if(oldpassword.equals(office.getPassword()) && newpassword1.equals(newpassword2)){
            office.setPassword(newpassword1);

            officeService.edit(office);
            session.setAttribute("office", office);
            return "redirect:/office_self_info";
        }
        else{
            return "error";
        }
    }
}
