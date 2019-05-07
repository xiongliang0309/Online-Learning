package com.ruanko.rent.service;

import com.ruanko.rent.dao.ChapterDao;
import com.ruanko.rent.dao.ClassesDao;
import com.ruanko.rent.entity.Chapter;
import com.ruanko.rent.entity.Classes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClassesService {
    @Autowired
    private ClassesDao classesDao;

    public List<Classes> getClassesList(){
        return classesDao.getAll();
    }

    public Classes findClassesById(String classid){
        return  classesDao.getOne(classid);
    }

    public void save(Classes classes) {
        classesDao.insert(classes);
    }

    public void edit(Classes classes){
        classesDao.update(classes);
    }

    public void delete(String classid) {
        classesDao.delete(classid);
    }
}
