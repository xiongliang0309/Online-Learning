package com.ruanko.rent.controller;

import com.ruanko.rent.entity.*;
import com.ruanko.rent.service.*;
import com.ruanko.rent.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class StudentChapterHomeworkController {

    @Autowired
    private ChapterService chapterService;
    @Autowired
    private ChoiceService choiceService;
    @Autowired
    private FillService fillService;
    @Autowired
    private ProgramService programService;
    @Autowired
    private HomeworkService homeworkService;
    @Autowired
    private Homework homework;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    //跳转到homework详情界面
    @RequestMapping("/studentChapterHomework")
    public String showStudentChapterHomework(Model model, String chapterid,String kechenid) {
        Chapter chapter = chapterService.findChapterById(chapterid,kechenid);
        model.addAttribute("chapter", chapter);
        List<Choice> choiceList = choiceService.getChoiceList();
        model.addAttribute("choiceList", choiceList);
        List<Fill> fillList = fillService.getFillList();
        model.addAttribute("fillList", fillList);
        List<Program> programList = programService.getProgramList();
        model.addAttribute("programList", programList);
        return "student_homework_detail";
    }


    //提交作业
    @RequestMapping(value="/studentAddHomework.action", method = POST)
    public String studentAddHomework(HttpSession session, String answercontent,String chapterid,String kechenid, @RequestParam("answerfile") MultipartFile file){
        Leaseholder leaseholder = (Leaseholder) session.getAttribute("leaseholder");
        homework.setAnswercontent(answercontent);
        homework.setStudentid(leaseholder.getId());
        homework.setStudentname(leaseholder.getName());
        homework.setClassid(leaseholder.getClassid());
        homework.setChapterid(chapterid);
        homework.setKechenid(kechenid);
        homework.setCommitdate(sdf.format(new Date()));
        String newPath = FileUtil.uploadFile(file);
        homework.setAnswerfile(newPath);

        //保存到数据库
        try{
            homeworkService.save(homework);
            return "redirect:/studentCourseDetail?id="+kechenid;
        }catch(Exception e) {
            System.out.print(e);
            return "error";
        }
    }
}
