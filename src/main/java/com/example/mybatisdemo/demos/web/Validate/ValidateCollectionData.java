package com.example.mybatisdemo.demos.web.Validate;

import com.example.mybatisdemo.demos.web.entity.Subject;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;

public class ValidateCollectionData {

    public static boolean validateListData(List<Subject> list){
        for(Subject subject:list){
            if(!validateData(subject)) return false;
        }
        return true;
    }

    public static boolean validateData(Subject subject){
        if(subject.getId() == null) return false;
        if(subject.getTitle() == null) return false;
        if(subject.getParentId() == null) return false;
        if(subject.getSort() == null) return false;
        if(subject.getCreateTime() == null) return false;
        if(subject.getUpdateTime() == null) return false;
        if(subject.getIsDeleted() == null) return false;
        return true;
    }

}
