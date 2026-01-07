package com.aitor.publisher;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;

@RequiredArgsConstructor
@SpringBootApplication
public class PublisherApplication {
    private static final String[] TOPIC_NAMES = new String[]{"InTopic", "OutTopic"};

    public static void main(String[] args) {
        SpringApplication.run(PublisherApplication.class, args);
    }

//    private final KafkaAdmin kafkaAdmin;
//    @PostConstruct
//    public void cleanupTopicsOnStartup() {
//        try (AdminClient adminClient = AdminClient.create(kafkaAdmin.getConfigurationProperties())) {
//            var topicsToActuallyDelete = Arrays.stream(TOPIC_NAMES)
//                    .filter(adminClient.listTopics().names().get(5, TimeUnit.SECONDS)::contains)
//                    .collect(Collectors.toList());
//            if (!topicsToActuallyDelete.isEmpty()) {
//                DeleteTopicsResult deleteResult = adminClient.deleteTopics(topicsToActuallyDelete);
//                deleteResult.all().get(10, TimeUnit.SECONDS);
//                Thread.sleep(2000);
//            }
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//        }
//    }

    @Bean
    public NewTopic inTopic() {
        return TopicBuilder.name(TOPIC_NAMES[0])
                .partitions(10)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic outTopic() {
        return TopicBuilder.name(TOPIC_NAMES[1])
                .partitions(10)
                .replicas(1)
                .build();
    }
}
