package com.ruanko.rent.service;

import com.ruanko.rent.dao.AddkechenDao;
import com.ruanko.rent.entity.Addkechen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AddkechenService {
    @Autowired
    private AddkechenDao addkechenDao;

    public List<Addkechen> getAddkechenList(){
        return addkechenDao.getAll();
    }

    public Addkechen findAddkechenById(String addkechenid){
        return  addkechenDao.getOne(addkechenid);
    }

    public void save(Addkechen addkechen) {
        addkechenDao.insert(addkechen);
    }

    public void edit(Addkechen addkechen){
        addkechenDao.update(addkechen);
    }

    public void delete(String addkechenid) {
        addkechenDao.delete(addkechenid);
    }
}
