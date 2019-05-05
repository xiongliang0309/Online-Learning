package com.ruanko.rent.service;

import com.ruanko.rent.dao.ChoiceDao;
import com.ruanko.rent.entity.Choice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ChoiceService {
    @Autowired
    private ChoiceDao choiceDao;

    public List<Choice> getChoiceList(){
        return choiceDao.getAll();
    }

    public Choice findChoiceById(String choiceid){
        return  choiceDao.getOne(choiceid);
    }

    public void save(Choice choice) {
        choiceDao.insert(choice);
    }

    public void edit(Choice choice){
        choiceDao.update(choice);
    }

    public void delete(String choiceid) {
        choiceDao.delete(choiceid);
    }
}
