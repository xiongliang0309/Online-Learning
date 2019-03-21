package com.ruanko.rent.service;

import com.ruanko.rent.dao.ScoreDao;
import com.ruanko.rent.entity.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ScoreService {
    @Autowired
    private ScoreDao scoreDao;

    public List<Score> getScoreList(){
        return scoreDao.getAll();
    }

    public Score findScoreById(String id){
        return  scoreDao.getOne(id);
    }

    public void save(Score score) {
        scoreDao.insert(score);
    }

    public void edit(Score score){
        scoreDao.update(score);
    }

    public void delete(String id) {
        scoreDao.delete(id);
    }
}
