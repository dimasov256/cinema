package com.cinema.backendvideo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Document(value = "Video")
@Data
@NoArgsConstructor
public class Video extends BaseEntity{

    public Video(Long id,
                 Timestamp lastUpdate,
                 String title,
                 String description,
                 String userId,
                 Integer like,
                 Integer disLike,
                 Set<String> tags,
                 String videoUrl,
                 VideoStatus status,
                 Integer viewCount,
                 String thumbnailUrl,
                 List<Comment> comments) {
        super(id, lastUpdate);
        this.title = title;
        this.description = description;
        this.userId = userId;
        this.like = like;
        this.disLike = disLike;
        this.tags = tags;
        this.videoUrl = videoUrl;
        this.status = status;
        this.viewCount = viewCount;
        this.thumbnailUrl = thumbnailUrl;
        this.comments = comments;
    }

    private String title;
    private String description;
    private String userId;
    private Integer like;
    private Integer disLike;
    private Set<String> tags;
    private String videoUrl;
    private VideoStatus status;
    private Integer viewCount;
    private String thumbnailUrl;
    private List<Comment> comments;
}
