package com.ruanko.rent.controller;

import com.ruanko.rent.entity.Admin;
import com.ruanko.rent.entity.Course;
import com.ruanko.rent.entity.Chapter;
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
    private CourseService courseService;

    @Autowired
    private ChapterService chapterService;

    @Autowired
    private Chapter chapter;

    //显示课程章节
    @RequestMapping("/teacherCourseChapter")
    public String teacherCourseChapter(Model model, String id) {
        Course course = courseService.findCourseById(id);
        model.addAttribute("course", course);
        List<Chapter> chapterList = chapterService.getChapterList();
        model.addAttribute("chapterList", chapterList);
        return "teacher_course_chapter";
    }

    //删除章节
    @RequestMapping("/teacherDeleteChapter")
    public String teacherDeleteChapter(String chapterid,String kechenid){
        chapterService.delete(chapterid,kechenid);
        return "redirect:/teacherCourseChapter?id="+kechenid;
    }

    //添加课程章节
    @RequestMapping("/teacherAddChapter")
    public String teacherAddChapter(Model model, String id) {
        Course course = courseService.findCourseById(id);
        model.addAttribute("course", course);
        List<Chapter> chapterList = chapterService.getChapterList();
        model.addAttribute("chapterList", chapterList);
        return "teacher_addchapter";
    }


    @RequestMapping(value="/addChapter.action", method = POST)
    public String AddChapter(String chapterid, String chaptername,String kechenid){
        chapter.setChapterid(chapterid);
        chapter.setChaptername(chaptername);
        chapter.setKechenid(kechenid);


        //保存到数据库
        try{
            chapterService.save(chapter);
            return "redirect:/teacherCourseChapter?id="+kechenid;
        }catch(Exception e) {
            System.out.print(e);
            return "error";
        }
    }

    //跳转到编辑章节
    @RequestMapping("/teacherEditChapter")
    public String teacherEditChapter(Model model, String  kechenid,String chapterid) {
       Chapter chapter=chapterService.findChapterById(chapterid,kechenid);
        model.addAttribute("chapter", chapter);
        return "teacher_edit_chapter";
    }

    @RequestMapping(value = "/changeChapterInfo.action", method = POST)
    public String changeChapterInfo(HttpSession session,String chaptername, String isupload,String kechenid){
        Chapter chapter = (Chapter) session.getAttribute("chapter");
        chapter.setChaptername(chaptername);

        //保存到数据库
        try{
            chapterService.save(chapter);
      //      session.setAttribute("chapter", chapter);
            return "redirect:/teacherCourseChapter?id="+kechenid;
        }catch(Exception e) {
            System.out.print(e);
            return "error";
        }
    }

}
