package com.ruanko.rent.service;

import com.ruanko.rent.dao.TeacherDao;
import com.ruanko.rent.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * AdminService Class
 *
 * @author zhangjianyun
 * @date 2018-9-20
 */
@Service
public class TeacherService {
    @Autowired
    private TeacherDao teacherDao;

    public List<Teacher> getTeacherList(){
        return teacherDao.getAll();
    }

    public Teacher findTeacherById(String id){
        return  teacherDao.getOne(id);
    }

    public void save(Teacher teacher) {
        teacherDao.insert(teacher);
    }

    public void edit(Teacher teacher){
        teacherDao.update(teacher);
    }

    public void delete(String id) {
        teacherDao.delete(id);
    }
}
