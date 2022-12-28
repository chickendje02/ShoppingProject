package com.excercise.loggingservice.repository;

import com.excercise.loggingservice.model.orm.LogModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoggingRepository extends JpaRepository<LogModel, String> {
}
