package com.ruanko.rent.controller;

import com.ruanko.rent.entity.Addkechen;
import com.ruanko.rent.entity.Admin;
import com.ruanko.rent.entity.Chapter;
import com.ruanko.rent.service.AddkechenService;
import com.ruanko.rent.service.CourseService;
import com.ruanko.rent.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;


@Controller
public class TeacherChapterController {

    @Autowired
    private ChapterService chapterService;

    @Autowired
    private AddkechenService addkechenService;

    @Autowired
    private Chapter chapter;

    //显示课程章节
    @RequestMapping("/teacherKechenHomework")
    public String teacherCourseChapter(Model model, String addkechenid) {
        Addkechen addkechen = addkechenService.findAddkechenById(addkechenid);
        model.addAttribute("addkechen", addkechen);
        List<Chapter> chapterList = chapterService.getChapterList();
        model.addAttribute("chapterList", chapterList);
        return "teacher_course_chapter";
    }

    //删除作业
    @RequestMapping("/teacherDeleteChapter")
    public String teacherDeleteChapter(String chapterid,String addkechenid){
        chapterService.delete(chapterid);
        return "redirect:/teacherKechenHomework?addkechenid="+addkechenid;
    }

    //添加课程作业

    @RequestMapping(value="/teacherAddChapter.action", method = POST)
    public String AddChapter(HttpSession session, String chaptername,String kechenid,String addkechenid){
        Admin admin = (Admin) session.getAttribute("admin");
        chapter.setChaptername(chaptername);
        chapter.setKechenid(kechenid);
        chapter.setTeachername(admin.getName());
        chapter.setIsupload(false);


        //保存到数据库
        try{
            chapterService.save(chapter);
            return "redirect:/teacherKechenHomework?addkechenid="+addkechenid;
        }catch(Exception e) {
            System.out.print(e);
            return "error";
        }
    }

    //设为不可提交
   @RequestMapping("/teacherEditChapterFalse")
    public String teacherEditChapterFalse(HttpSession session, Model model, String  kechenid,String chapterid,String addkechenid) {
       Chapter chapter=chapterService.findChapterById(chapterid);
       Admin admin = (Admin) session.getAttribute("admin");
        model.addAttribute("chapter", chapter);
        chapter.setKechenid(kechenid);
        chapter.setChapterid(chapterid);
        chapter.setIsupload(false);
        chapter.setTeachername(admin.getName());
        //保存到数据库
        try{
             chapterService.edit(chapter);
            //      session.setAttribute("chapter", chapter);
            return "redirect:/teacherKechenHomework?addkechenid="+addkechenid;
        }catch(Exception e) {
            System.out.print(e);
            return "error";
        }

    }

    //设为可以提交
    @RequestMapping("/teacherEditChapterTrue")
    public String teacherEditChapterTrue(HttpSession session,Model model, String  kechenid,String chapterid,String addkechenid) {
        Chapter chapter=chapterService.findChapterById(chapterid);
        Admin admin = (Admin) session.getAttribute("admin");
        model.addAttribute("chapter", chapter);
        chapter.setKechenid(kechenid);
        chapter.setChapterid(chapterid);
        chapter.setIsupload(true);
        chapter.setTeachername(admin.getName());
        //保存到数据库
        try{
            chapterService.edit(chapter);
            //      session.setAttribute("chapter", chapter);
            return "redirect:/teacherKechenHomework?addkechenid="+addkechenid;
        }catch(Exception e) {
            System.out.print(e);
            return "error";
        }

    }

}
