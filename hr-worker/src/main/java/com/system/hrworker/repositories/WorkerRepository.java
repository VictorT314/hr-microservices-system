package com.system.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.system.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
