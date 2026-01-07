package com.aitor.publisher;

import com.aitor.publisher.model.Issue;
import com.aitor.publisher.model.IssueSticker;
import com.aitor.publisher.model.Sticker;
import com.aitor.publisher.model.User;
import com.aitor.publisher.repository.IssueRepository;
import com.aitor.publisher.repository.IssueStickerRepository;
import com.aitor.publisher.repository.StickerRepository;
import com.aitor.publisher.repository.UserRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RepositoryTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private IssueRepository issueRepository;
    @Autowired
    private StickerRepository stickerRepository;
    @Autowired
    private IssueStickerRepository issueStickerRepository;

    @Test
    @Order(1)
    void testUserRepository() {
        Assertions.assertNotNull(userRepository);
        var entity = new User();
        entity.setFirstname("James");
        entity.setLastname("Bondulance");
        entity.setLogin("jbtrojan");
        entity.setPassword("boomshake23");
        userRepository.save(entity);
        var list = userRepository.findAll();
        Assertions.assertNotNull(list);
        Assertions.assertNotEquals(0, list.size());
        var persisted = list.getFirst();
        Assertions.assertNotNull(persisted.getId());
        Assertions.assertNotNull(persisted.getLogin());
    }

    @Test
    @Order(2)
    void testIssueRepository() {
        Assertions.assertNotNull(issueRepository);
        var issue = new Issue();
        issue.setUserId(userRepository.findAll().getFirst());
        issue.setContent("testContent");
        issue.setTitle("testTitle");
        issueRepository.save(issue);
        var list = issueRepository.findAll();
        Assertions.assertNotNull(list);
        Assertions.assertNotEquals(0, list.size());
        var persisted = list.getFirst();
        Assertions.assertNotNull(persisted.getId());
    }

    @Test
    @Order(3)
    void testStickerRepository() {
        Assertions.assertNotNull(stickerRepository);
        var entity = new Sticker();
        entity.setName("abusiveContent");
        stickerRepository.save(entity);
        var list = stickerRepository.findAll();
        Assertions.assertNotNull(list);
        Assertions.assertNotEquals(0, list.size());
        var persisted = list.getFirst();
        Assertions.assertNotNull(persisted.getId());
    }

    @Test
    @Order(4)
    void testIssueStickerRepository() {
        Assertions.assertNotNull(issueStickerRepository);
        var entity = new IssueSticker();
        entity.setIssueId(issueRepository.findAll().getFirst());
        entity.setStickerId(stickerRepository.findAll().getFirst());
        issueStickerRepository.save(entity);
        var list = userRepository.findAll();
        Assertions.assertNotNull(list);
        Assertions.assertNotEquals(0, list.size());
        var persisted = list.getFirst();
        Assertions.assertNotNull(persisted.getId());
    }
}
