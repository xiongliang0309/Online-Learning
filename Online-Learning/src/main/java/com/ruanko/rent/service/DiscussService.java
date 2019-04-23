package com.ruanko.rent.service;

import com.ruanko.rent.dao.DiscussDao;
import com.ruanko.rent.entity.Discuss;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DiscussService {
    @Autowired
    private DiscussDao discussDao;

    public List<Discuss> getDiscussList(){
        return discussDao.getAll();
    }

    public Discuss findDiscussById(String discussid){
        return  discussDao.getOne(discussid);
    }

    public void save(Discuss discuss) {
        discussDao.insert(discuss);
    }

    public void edit(Discuss discuss){
        discussDao.update(discuss);
    }

    public void delete(String discussid) {
        discussDao.delete(discussid);
    }
}
