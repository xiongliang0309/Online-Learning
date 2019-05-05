package com.ruanko.rent.service;

import com.ruanko.rent.dao.ChapterDao;
import com.ruanko.rent.entity.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ChapterService {
    @Autowired
    private ChapterDao chapterDao;

    public List<Chapter> getChapterList(){
        return chapterDao.getAll();
    }

    public Chapter findChapterById(String chapterid,String kechenid){
        return  chapterDao.getOne(chapterid,kechenid);
    }

    public void save(Chapter chapter) {
        chapterDao.insert(chapter);
    }

    public void edit(Chapter chapter){
        chapterDao.update(chapter);
    }

    public void delete(String chapterid,String kechenid) {
        chapterDao.delete(chapterid,kechenid);
    }
}
