package com.example.mybatisdemo.demos.web.controller;

import com.example.mybatisdemo.demos.web.Validate.ValidateCollectionData;
import com.example.mybatisdemo.demos.web.entity.Subject;
import com.example.mybatisdemo.demos.web.mapper.SubjectMapper;
import com.example.mybatisdemo.demos.web.service.SubjectService;
import com.example.mybatisdemo.demos.web.service.SubjectServiceImpl;
import com.sun.istack.internal.NotNull;
import org.apache.ibatis.annotations.Update;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    private static final Logger log = LoggerFactory.getLogger(SubjectServiceImpl.class);

    @Resource
    private SubjectService subjectService;

    @Resource
    private SubjectMapper subjectMapper;

    @GetMapping("/fetchData")
    public List<Subject> fetchData() {
        return subjectService.selectAll();
    }

    @GetMapping("/fetchData/{id}")
    public Subject fetchDataById(@PathVariable Long id){
        Subject subject = subjectMapper.selectById(id);
        return subject;
    }


    /**
     * 更新指定 ID 的 Subject 记录
     *
     * @param id      要更新的 Subject 的 ID
     * @param subject 包含更新信息的 Subject 对象（可选）
     * @return ResponseEntity 包含操作结果
     */
    @PostMapping("/{id}/update")
    public ResponseEntity<?> updateById(
            @PathVariable("id") @NotNull Long id,
            @RequestBody(required = false) Subject subject) {

        try {
            if (subject == null) {
                // 如果请求体为空，可以选择创建一个空的 Subject 对象，只更新 ID，或者返回错误
                // 这里选择返回错误响应
                return ResponseEntity.badRequest().body("Subject body is required for update.");
            }

            // 可选：进一步验证 subject 对象中的字段
            // 例如，确保 id 在 subject 对象中与路径中的 id 一致
            if (!id.equals(subject.getId())) {
                return ResponseEntity.badRequest().body("Path ID and Body ID must match.");
            }

            subjectMapper.updateById(id, subject);
            return ResponseEntity.ok().build();

        } catch (IllegalArgumentException e) {
            // 处理业务逻辑异常
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            // 处理其他未预见的异常
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while updating the subject.");
        }
    }

    @PostMapping("/batchSave")
    public ResponseEntity<?> batchSave(@RequestBody(required = true) List<Subject> list){
        try {
            if (CollectionUtils.isEmpty(list)) {
                // 如果请求体为空，可以选择创建一个空的 Subject 对象，只更新 ID，或者返回错误
                // 这里选择返回错误响应
                return ResponseEntity.badRequest().body("List<Subject> list body is required for update.");
            }

            if(!ValidateCollectionData.validateListData(list)) {
                return ResponseEntity.badRequest().body("批量插入操作中，subject对象有空字段");
            }

            subjectMapper.batchSave(list);
            return ResponseEntity.ok().build();

        } catch (IllegalArgumentException e) {
            // 处理业务逻辑异常
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            // 处理其他未预见的异常
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while updating the subject.");
        }
    }
}
