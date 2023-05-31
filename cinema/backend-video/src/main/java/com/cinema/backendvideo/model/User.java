package com.cinema.backendvideo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Document(value = "User")
@Data
@NoArgsConstructor
public class User extends BaseEntity{

    public User(String id,
                Timestamp lastUpdate,
                String firstName,
                String lastName,
                String fullName,
                String emailAddress,
                Set<String> subscribedToUser,
                Set<String> subscribers,
                List<String> videoHistory,
                Set<String> likedVideos,
                Set<String> dislikedVideos) {
        super(id, lastUpdate);
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = fullName;
        this.emailAddress = emailAddress;
        this.subscribedToUser = subscribedToUser;
        this.subscribers = subscribers;
        this.videoHistory = videoHistory;
        this.likedVideos = likedVideos;
        this.dislikedVideos = dislikedVideos;
    }

    private String firstName;
    private String lastName;
    private String fullName;
    private String emailAddress;
    private Set<String> subscribedToUser;
    private Set<String> subscribers;
    private List<String> videoHistory;
    private Set<String> likedVideos;
    private Set<String> dislikedVideos;

}
