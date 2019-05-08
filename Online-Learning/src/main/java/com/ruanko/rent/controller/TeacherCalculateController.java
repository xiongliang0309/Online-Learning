package com.ruanko.rent.controller;

import com.ruanko.rent.entity.Course;
import com.ruanko.rent.entity.Homework;
import com.ruanko.rent.service.CourseService;
import com.ruanko.rent.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.*;
import java.io.IOException;
import java.util.List;


@Controller
public class TeacherCalculateController {

    @Autowired
    private HomeworkService homeworkService;
    @Autowired
    private CourseService courseService;

    //统计成绩
    @RequestMapping("/teacher_calculate")
    public String showStudentScoreList(Model model) {
        List<Course> courseList = courseService.getCourseList();
        model.addAttribute("courseList", courseList);
        return "teacher_calculate";
    }

    //统计成绩
    @RequestMapping("/teacherClassScore")
    public String teacherClassScore(Model model,String id) {
        Course course=courseService.findCourseById(id);
        model.addAttribute("course",course);
        List<Homework> homeworkList = homeworkService.getHomeworkList();
        model.addAttribute("homeworkList", homeworkList);
        return "teacher_class_score";
    }

//导出excel
    @RequestMapping("/export_excel")
    public void downloadAllClassmate(HttpServletResponse response,String classid,String kechenid) throws IOException {
       System.out.println(classid);
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("信息表");

       // Homework homework=homeworkService.findClassScore(classid,kechenid,chapterid);
        List<Homework> homeworkList = homeworkService.getHomeworkList();
       // Homework score = homeworkService.getScoreList(classid,kechenid,chapterid);
        List<Homework> scoreList = homeworkService.getScoreList(classid,kechenid);
        System.out.println(scoreList);
        // System.out.println(score);
        System.out.println(homeworkList);
        String fileName = "scoreinf"  + ".xls";//设置要导出的文件的名字
        //新增数据行，并且设置单元格数据

        int rowNum = 1;

        String[] headers = {"学号", "姓名", "班级", "课程号", "章节号", "成绩"};
        //headers表示excel表中第一行的表头

        HSSFRow row = sheet.createRow(0);
        //在excel表中添加表头

        for(int i=0;i<headers.length;i++){
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }

        //在表中存放查询到的数据放入对应的列
        for (Homework homework :scoreList) {
            HSSFRow row1 = sheet.createRow(rowNum);
            row1.createCell(0).setCellValue(homework.getStudentid());
            row1.createCell(1).setCellValue(homework.getStudentname());
            row1.createCell(2).setCellValue(homework.getClassid());
            row1.createCell(3).setCellValue(homework.getKechenid());
            row1.createCell(4).setCellValue(homework.getChapterid());
            row1.createCell(5).setCellValue(homework.getScore());
            rowNum++;
        }

        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        response.flushBuffer();
        workbook.write(response.getOutputStream());
    }

}
