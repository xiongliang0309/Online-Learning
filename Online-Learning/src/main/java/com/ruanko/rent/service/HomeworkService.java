package com.ruanko.rent.service;

import com.ruanko.rent.dao.ChoiceDao;
import com.ruanko.rent.dao.HomeworkDao;
import com.ruanko.rent.entity.Choice;
import com.ruanko.rent.entity.Homework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HomeworkService {
    @Autowired
    private HomeworkDao homeworkDao;

    public List<Homework> getHomeworkList(){
        return homeworkDao.getAll();
    }

    public Homework findHomeworkById(String chapterid,String kechenid,String studentid){
        return  homeworkDao.getOne(chapterid,kechenid,studentid);
    }

    public List<Homework> getScoreList(String classid, String kechenid){
        return  homeworkDao.getScore(classid,kechenid);
    }

    public void save(Homework homework) {
        homeworkDao.insert(homework);
    }


    public void edit(Homework homework){
        homeworkDao.update(homework);
    }

    public void delete(String chapterid,String kechenid,String studentid) {
        homeworkDao.delete(chapterid,kechenid,studentid);
    }
}
