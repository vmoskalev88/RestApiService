package com.example.AnotherTry.service;

import com.example.AnotherTry.model.Code;
import com.example.AnotherTry.repo.CodeRepo;
import org.springframework.stereotype.Service;

import java.util.List;

//todo сюда логирование добавить
@Service
public class CodeServiceImpl implements CodeService {
    private final CodeRepo codeRepo;

    public CodeServiceImpl(CodeRepo codeRepo) {
        this.codeRepo = codeRepo;
    }

    @Override
    public Code getById(Long id) {
        return codeRepo.getOne(id);
    }

    @Override
    public void save(Code code) {
        codeRepo.save(code);
    }

    @Override
    public void delete(Long id) {
        codeRepo.deleteById(id);
    }

    @Override
    public List<Code> getAll() {
        return codeRepo.findAll();
    }
}
