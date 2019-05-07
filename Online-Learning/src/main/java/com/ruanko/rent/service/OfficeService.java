package com.ruanko.rent.service;

import com.ruanko.rent.dao.AdminDao;
import com.ruanko.rent.dao.OfficeDao;
import com.ruanko.rent.entity.Admin;
import com.ruanko.rent.entity.Office;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OfficeService {
    @Autowired
    private OfficeDao officeDao;

    public List<Office> getOfficeList(){
        return officeDao.getAll();
    }

    public Office findOfficeById(String id){
        return  officeDao.getOne(id);
    }

    public void save(Office office) {
        officeDao.insert(office);
    }

    public void edit(Office office){
        officeDao.update(office);
    }

    public void delete(String id) {
        officeDao.delete(id);
    }
}
