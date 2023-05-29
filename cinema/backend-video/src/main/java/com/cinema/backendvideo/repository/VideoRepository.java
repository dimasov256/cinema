package com.cinema.backendvideo.repository;

import com.cinema.backendvideo.model.Video;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VideoRepository extends MongoRepository<Video, String> {
}
