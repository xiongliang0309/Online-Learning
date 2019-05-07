package com.ruanko.rent.service;

import com.ruanko.rent.dao.CourseDao;
import com.ruanko.rent.dao.KechenDao;
import com.ruanko.rent.entity.Course;
import com.ruanko.rent.entity.Kechen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class KechenService {
    @Autowired
    private KechenDao kechenDao;

    public List<Kechen> getKechenList(){
        return kechenDao.getAll();
    }

    public Kechen findKechenById(String kechenid){
        return  kechenDao.getOne(kechenid);
    }

    public void save(Kechen kechen) {
        kechenDao.insert(kechen);
    }

    public void edit(Kechen kechen){
        kechenDao.update(kechen);
    }

    public void delete(String kechenid) {
        kechenDao.delete(kechenid);
    }
}
