package ru.ddimike.eschool.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ddimike.eschool.model.Pupil;

import java.util.List;

@Service("pupilService")
public class PupilServiceImpl implements PupilService{

    @Autowired
    private SqlSession m_SqlSession;

    @Override
    public List<Pupil> findAll() {
        return m_SqlSession.selectList("data-mapper.selectAllPupil");
    }

    @Override
    public void add(Pupil pupil) {
        m_SqlSession.insert("data-mapper.insertPupil", pupil);
    }

    @Override
    public void delete(int id) {
        m_SqlSession.delete("data-mapper.deletePupil", id);
    }
}
