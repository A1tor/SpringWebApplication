package com.aitor.springwebapplication.repository;

import com.aitor.springwebapplication.model.Issue;
import com.aitor.springwebapplication.model.IssueSticker;
import com.aitor.springwebapplication.model.Sticker;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IssueStickerRepository extends JpaRepository<IssueSticker, Long> {
    List<IssueSticker> findByIssueId(@NonNull Issue issueId);
}
