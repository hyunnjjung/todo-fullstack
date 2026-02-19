package com.example.demo.service;

import com.example.demo.model.TodoEntity;
import com.example.demo.persistence.TodoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    public List<TodoEntity> create(final TodoEntity entity){

        // ✅ 검증
        validate(entity);

        // ✅ 저장
        repository.save(entity);

        log.info("Entity Id : {} is saved", entity.getId());

        // ✅ 조회 후 반환
        return repository.findByUserId(entity.getUserId());
    }

    // 🔥 validate 메서드 따로 정의
    private void validate(final TodoEntity entity){
        if(entity == null){
            log.warn("entity cannot be null.");
            throw new RuntimeException("entity cannot be null.");
        }

        if(entity.getUserId() == null){
            log.warn("Unknown user.");
            throw new RuntimeException("Unknown user.");
        }
    }
}
