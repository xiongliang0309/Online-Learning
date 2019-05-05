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

    public Homework findHomeworkById(String homeworkid){
        return  homeworkDao.getOne(homeworkid);
    }

    public void save(Homework homework) {
        homeworkDao.insert(homework);
    }

    public void edit(Homework homework){
        homeworkDao.update(homework);
    }

    public void delete(String homeworkid) {
        homeworkDao.delete(homeworkid);
    }
}
