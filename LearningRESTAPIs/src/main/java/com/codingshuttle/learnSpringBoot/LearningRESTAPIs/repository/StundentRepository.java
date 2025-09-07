package com.codingshuttle.learnSpringBoot.LearningRESTAPIs.repository;

import com.codingshuttle.learnSpringBoot.LearningRESTAPIs.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StundentRepository extends JpaRepository<Student, Long> {





}
