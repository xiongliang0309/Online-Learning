package com.ruanko.rent.service;

import com.ruanko.rent.dao.HelpDao;
import com.ruanko.rent.entity.Help;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HelpService {
    @Autowired
    private HelpDao helpDao;

    public List<Help> getHelpList(){
        return helpDao.getAll();
    }

    public Help findHelpById(String id){
        return  helpDao.getOne(id);
    }

    public void save(Help help) {
        helpDao.insert(help);
    }

    public void edit(Help help){
        helpDao.update(help);
    }

    public void delete(String id) {
        helpDao.delete(id);
    }
}
