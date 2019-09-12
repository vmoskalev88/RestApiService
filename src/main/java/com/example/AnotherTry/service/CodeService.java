package com.example.AnotherTry.service;

import com.example.AnotherTry.model.Code;

import java.util.List;

public interface CodeService {
    Code getById(Long id);

    void save(Code code);

    void delete(Long id);

    List<Code> getAll();
}
