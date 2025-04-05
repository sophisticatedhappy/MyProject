package com.example.mybatisdemo.demos.web.service.impl;

import com.example.mybatisdemo.demos.web.entity.Subject;
import com.example.mybatisdemo.demos.web.mapper.SubjectMapper;
import com.example.mybatisdemo.demos.web.service.SubjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectMapper subjectMapper;

    @Override
    public List<Subject> selectAll() {
        log.info("调用了impl里面的方法...");
        return subjectMapper.selectAll();
    }
}
