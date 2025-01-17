package com.ruanko.rent.controller;

import com.ruanko.rent.entity.Landlord;
import com.ruanko.rent.service.LandlordService;
import com.ruanko.rent.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpSession;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class HelpSelfInfoController {
    @Autowired
    private LandlordService landlordService;

    //跳转到助教个人信息页面
    @RequestMapping("/help_self_info")
    public String showLandlordSelfInfoPage()
    {
        return "help_self_info";
    }

    //修改个人信息操作
    @RequestMapping(value = "/changeLandlordSelfInfo.action", method = POST)
    public String changeLandlordSelfInfo(HttpSession session, String phone, String email, @RequestParam("icon") MultipartFile file) {
        Landlord landlord = (Landlord) session.getAttribute("landlord");
        landlord.setPhone(phone);
        landlord.setEmail(email);
        String newIcon = FileUtil.uploadFile(file);
        if(newIcon != null){
            landlord.setIcon(newIcon);
        }

        //保存到数据库
        try{
            landlordService.edit(landlord);
            session.setAttribute("landlord", landlord);
            return "redirect:/help";
        }catch(Exception e) {
            System.out.print(e);
            return "error";
        }
    }

    //跳转到修改密码界面
    @RequestMapping("/help_self_change_password")
    public String showLandlordSelfChangePasswordPage()
    {
        return "help_self_change_password";
    }

    //修改密码操作
    @RequestMapping(value = "/changeLandlordSelfPassword.action", method = POST)
    public String changeLandlordSelfPassword(HttpSession session, String oldpassword, String newpassword1, String newpassword2){
        Landlord landlord = (Landlord) session.getAttribute("landlord");

        if(oldpassword.equals(landlord.getPassword()) && newpassword1.equals(newpassword2)){
            landlord.setPassword(newpassword1);

            landlordService.edit(landlord);
            session.setAttribute("landlord", landlord);
            return "redirect:/help";
        }
        else{
            return "error";
        }
    }
}
