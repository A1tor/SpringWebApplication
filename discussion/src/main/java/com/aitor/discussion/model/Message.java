package com.aitor.discussion.model;

import lombok.*;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.*;

@Getter
@Setter
@NoArgsConstructor
@Table(value = "tbl_message", keyspace = "distcomp")
public class Message {

    static private long curIndex = 0;

    @PrimaryKey
    Long id;

    @Column
    Long issueId;

    @Column
    String content;

    public Message(Long issueId, String content){
        id = ++curIndex;
        this.issueId = issueId;
        this.content = content;
    }
}
