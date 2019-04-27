package com.ruanko.rent.service;

import com.ruanko.rent.dao.NoticeDao;
import com.ruanko.rent.entity.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NoticeService {
    @Autowired
    private NoticeDao noticeDao;

    public List<Notice> getNoticeList(){
        return noticeDao.getAll();
    }

    public Notice findNoticeById(String id){
        return  noticeDao.getOne(id);
    }

    public void save(Notice notice) {
        noticeDao.insert(notice);
    }

    public void edit(Notice notice){
        noticeDao.update(notice);
    }

    public void delete(String id) {
        noticeDao.delete(id);
    }
}
