package com.ruanko.rent.controller;

import com.ruanko.rent.entity.Admin;
import com.ruanko.rent.entity.Studydata;
import com.ruanko.rent.service.StudydataService;
import com.ruanko.rent.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

import javax.servlet.http.HttpSession;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class TeacherAddDataController {
    @Autowired
    private StudydataService studydataService;
    @Autowired
    private Studydata studydata;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    //上传资料
    @RequestMapping("/teacher_adddata")
    public String showTeacherAddDiscuss() {
        return "teacher_adddata";
    }

    @RequestMapping(value="/teacherAddData.action", method = POST)
    public String teacherAddData(HttpSession session, String filename,@RequestParam("filepath") MultipartFile file){
        Admin admin = (Admin) session.getAttribute("admin");
        studydata.setFilename(filename);
        studydata.setFiledate(sdf.format(new Date()));
        studydata.setFiler(admin.getName());
        String newPath = FileUtil.uploadFile(file);
        if(newPath != null){
            studydata.setFilepath(newPath);
        }

        //保存到数据库
        try{
            studydataService.save(studydata);
            return "redirect:/teacher_studydata";
        }catch(Exception e) {
            System.out.print(e);
            return "error";
        }
    }

    //删除资料
    @RequestMapping("/teacherDeleteFile")
    public String teacherDeleteFile(String fileid){
        studydataService.delete(fileid);
        return "redirect:/teacher_studydata";
    }

    //下载资料
    @RequestMapping("/teacherDownloadFile")
    public String downloadFile(Model model, org.apache.catalina.servlet4preview.http.HttpServletRequest request, HttpServletResponse response, String filepath) {
        if (filepath != null) {
            String realPath = "C:\\file\\";
            File file = new File(realPath , filepath);
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition",
                        "attachment;fileName=" +  filepath);// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    System.out.println("success");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;

        }

    }


