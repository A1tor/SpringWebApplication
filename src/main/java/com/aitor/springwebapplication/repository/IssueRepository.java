package com.aitor.springwebapplication.repository;

import com.aitor.springwebapplication.model.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue, Long> {
}
