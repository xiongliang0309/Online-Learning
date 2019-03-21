package com.ruanko.rent.service;

import com.ruanko.rent.dao.StudentDao;
import com.ruanko.rent.entity.Student;
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
public class StudentService {
    @Autowired
    private StudentDao studentDao;

    public List<Student> getStudentList(){
        return studentDao.getAll();
    }

    public Student findStudentById(String id){
        return  studentDao.getOne(id);
    }

    public void save(Student student) {
        studentDao.insert(student);
    }

    public void edit(Student student){
        studentDao.update(student);
    }

    public void delete(String id) {
        studentDao.delete(id);
    }
}
