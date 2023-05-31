package com.cinema.backendvideo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@Document(value = "Comment")
public class Comment extends BaseEntity{

    public Comment(String id,
                   Timestamp lastUpdate,
                   String text,
                   String authorId,
                   Integer likeCount,
                   Integer disLikeCount) {
        super(id, lastUpdate);
        this.text = text;
        this.authorId = authorId;
        this.likeCount = likeCount;
        this.disLikeCount = disLikeCount;
    }

    private String text;
    private String authorId;
    private Integer likeCount;
    private Integer disLikeCount;
}
