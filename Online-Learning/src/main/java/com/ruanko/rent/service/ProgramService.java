package com.ruanko.rent.service;

import com.ruanko.rent.dao.ProgramDao;
import com.ruanko.rent.entity.Program;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProgramService {
    @Autowired
    private ProgramDao programDao;

    public List<Program> getProgramList(){
        return programDao.getAll();
    }

    public Program findProgramById(String programid){
        return  programDao.getOne(programid);
    }

    public void save(Program program) {
        programDao.insert(program);
    }

    public void edit(Program program){
        programDao.update(program);
    }

    public void delete(String programid) {
        programDao.delete(programid);
    }
}
