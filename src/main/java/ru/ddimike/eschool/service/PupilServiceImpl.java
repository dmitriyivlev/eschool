package ru.ddimike.eschool.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ddimike.eschool.model.Pupil;

import java.util.List;

@Service
public class PupilServiceImpl implements PupilService{

    @Autowired
    private SqlSession sqlSession;

    @Override
    public List<Pupil> findAll() {
        return sqlSession.selectList("data-mapper.selectAllPupil");
    }

    @Override
    public void add(Pupil pupil) {
        sqlSession.insert("data-mapper.insertPupil", pupil);
    }

    @Override
    public void delete(int id) {
        sqlSession.delete("data-mapper.deletePupil", id);
    }
}
