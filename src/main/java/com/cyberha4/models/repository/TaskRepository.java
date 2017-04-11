package com.cyberha4.models.repository;

import com.cyberha4.models.entity.TaskEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;


public interface TaskRepository extends CrudRepository<TaskEntity, Integer>
{
    public List<TaskEntity> findById(Integer id);
}
