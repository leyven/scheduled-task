package com.mx.leyven.scheduledtask.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mx.leyven.scheduledtask.entity.Tasks;

@Repository
public interface TasksRepository extends CrudRepository<Tasks, Integer> {

	

	List<Tasks> findByActive(Boolean activo);

}
