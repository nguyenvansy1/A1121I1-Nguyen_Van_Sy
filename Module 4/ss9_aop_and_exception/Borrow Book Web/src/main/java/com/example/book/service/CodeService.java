package com.example.book.service;


import com.example.book.entity.Code;
import com.example.book.repository.ICodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodeService implements ICodeService {
    @Autowired
    private ICodeRepository codeRepository;

    @Override
    public void save(Code code) {
        codeRepository.save(code);
    }

    @Override
    public List<Code> findAllCodeByBookId(Integer id) {
        return codeRepository.findCodeByBookId(id);
    }

    @Override
    public List<Code> findAvailableCodeByBookId(Integer id ) {
        return codeRepository.findCodeByBookAndStatus(id, 1);
    }

    @Override
    public List<Code> findUsedCodeByBookId(Integer id ) {
        return codeRepository.findCodeByBookAndStatus(id, 2);
    }

}
