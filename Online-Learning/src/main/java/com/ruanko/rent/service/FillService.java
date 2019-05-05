package com.ruanko.rent.service;

import com.ruanko.rent.dao.FillDao;
import com.ruanko.rent.entity.Fill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FillService {
    @Autowired
    private FillDao fillDao;

    public List<Fill> getFillList(){
        return fillDao.getAll();
    }

    public Fill findFillById(String fillid){
        return  fillDao.getOne(fillid);
    }

    public void save(Fill fill) {
        fillDao.insert(fill);
    }

    public void edit(Fill fill){
        fillDao.update(fill);
    }

    public void delete(String fillid) {
        fillDao.delete(fillid);
    }
}
