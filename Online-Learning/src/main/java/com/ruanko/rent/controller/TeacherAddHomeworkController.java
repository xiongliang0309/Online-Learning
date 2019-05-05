package com.ruanko.rent.controller;

import com.ruanko.rent.entity.Chapter;
import com.ruanko.rent.entity.Choice;
import com.ruanko.rent.entity.Fill;
import com.ruanko.rent.entity.Program;
import com.ruanko.rent.service.ChapterService;
import com.ruanko.rent.service.ChoiceService;
import com.ruanko.rent.service.FillService;
import com.ruanko.rent.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class TeacherAddHomeworkController {
    @Autowired
    private ChoiceService choiceService;
    @Autowired
    private FillService fillService;
    @Autowired
    private ProgramService programService;
    @Autowired
    private ChapterService chapterService;
    @Autowired
    private Choice choice;
    @Autowired
    private Fill fill;
    @Autowired
    private Program program;

    //显示章节作业
    @RequestMapping("/teacherAddHomework")
    public String teacherAddHomework(Model model,String chapterid,String kechenid) {
        Chapter chapter = chapterService.findChapterById(chapterid,kechenid);
        model.addAttribute("chapter", chapter);
        List<Choice> choiceList = choiceService.getChoiceList();
        model.addAttribute("choiceList", choiceList);
        List<Fill> fillList = fillService.getFillList();
        model.addAttribute("fillList", fillList);
        List<Program> programList = programService.getProgramList();
        model.addAttribute("programList", programList);
        return "teacher_add_homework";
    }

    //添加选择题
    @RequestMapping(value="/teacherAddChoice.action", method = POST)
    public String teacherAddChoice(HttpSession session, String choicetitle, String choicea,String choiceb,String choicec,String choiced,String chapterid,String kechenid){
        choice.setChoicetitle(choicetitle);
        choice.setChoicea(choicea);
        choice.setChoiceb(choiceb);
        choice.setChoicec(choicec);
        choice.setChoiced(choiced);
        choice.setKechenid(kechenid);
        choice.setChapterid(chapterid);

        //保存到数据库
        try{
            choiceService.save(choice);
            return "redirect:/teacherAddHomework?chapterid="+chapterid+"&kechenid="+kechenid;
        }catch(Exception e) {
            System.out.print(e);
            return "error";
        }

    }


    //添加填空题
    @RequestMapping(value="/teacherAddFill.action", method = POST)
    public String teacherAddFill(HttpSession session, String fillcontent, String chapterid1,String kechenid1){
        fill.setFillcontent(fillcontent);
        fill.setChapterid(chapterid1);
        fill.setKechenid(kechenid1);

        //保存到数据库
        try{
            fillService.save(fill);
            return "redirect:/teacherAddHomework?chapterid="+chapterid1+"&kechenid="+kechenid1;
        }catch(Exception e) {
            System.out.print(e);
            return "error";
        }

    }


    //添加设计题
    @RequestMapping(value="/teacherAddProgram.action", method = POST)
    public String teacherAddProgram(HttpSession session, String programcontent, String chapterid2,String kechenid2){
        program.setProgramcontent(programcontent);
        program.setChapterid(chapterid2);
        program.setKechenid(kechenid2);

        //保存到数据库
        try{
            programService.save(program);
            return "redirect:/teacherAddHomework?chapterid="+chapterid2+"&kechenid="+kechenid2;
        }catch(Exception e) {
            System.out.print(e);
            return "error";
        }

    }


    //删除choice
    @RequestMapping("/teacherDeleteChoice")
    public String teacherDeleteChoice(String choiceid,String kechenid,String chapterid){
        choiceService.delete(choiceid);
        return "redirect:/teacherAddHomework?chapterid="+chapterid+"&kechenid="+kechenid;
    }


    //删除fill
    @RequestMapping("/teacherDeleteFill")
    public String teacherDeleteFill(String fillid,String kechenid,String chapterid){
        fillService.delete(fillid);
        return "redirect:/teacherAddHomework?chapterid="+chapterid+"&kechenid="+kechenid;
    }

    //删除program
    @RequestMapping("/teacherDeleteProgram")
    public String teacherDeleteProgram(String programid,String kechenid,String chapterid){
        programService.delete(programid);
        return "redirect:/teacherAddHomework?chapterid="+chapterid+"&kechenid="+kechenid;
    }

}
