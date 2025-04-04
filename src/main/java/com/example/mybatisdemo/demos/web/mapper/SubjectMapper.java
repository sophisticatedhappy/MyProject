package com.example.mybatisdemo.demos.web.mapper;

import com.example.mybatisdemo.demos.web.entity.Subject;
import org.apache.ibatis.annotations.Param;

import java.sql.Wrapper;
import java.util.List;


public interface SubjectMapper {

    List<Subject> selectAll();

    Subject selectById(@Param("id") Long id);

    void updateById(@Param("id") Long id,@Param("subject") Subject subject);

    void batchSave(@Param("list") List<Subject> list);
}
