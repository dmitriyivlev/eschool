package ru.ddimike.eschool.service;

import ru.ddimike.eschool.model.Pupil;

import java.util.List;

public interface PupilService {

    List<Pupil> findAll();

    void add(Pupil pupil);

    void delete(int id);

}
