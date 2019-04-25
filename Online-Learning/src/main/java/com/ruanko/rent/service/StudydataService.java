package com.ruanko.rent.service;

import com.ruanko.rent.dao.StudydataDao;
import com.ruanko.rent.entity.Studydata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudydataService {
    @Autowired
    private StudydataDao studydataDao;

    public List<Studydata> getStudydataList(){
        return studydataDao.getAll();
    }

    public Studydata findStudydataById(String fileid){
        return  studydataDao.getOne(fileid);
    }

    public void save(Studydata studydata) {
        studydataDao.insert(studydata);
    }

    public void edit(Studydata studydata){
        studydataDao.update(studydata);
    }

    public void delete(String fileid) {
        studydataDao.delete(fileid);
    }
}
