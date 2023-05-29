package com.cinema.backendvideo.service;

import com.cinema.backendvideo.model.Video;
import com.cinema.backendvideo.repository.VideoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@AllArgsConstructor
public class VideoService {

    private final S3Service s3Service;
    private final VideoRepository videoRepository;

    public void uploadVideo(MultipartFile file) {
        //upload file to database S3
        //save Video to data to database
        String videoUrl = s3Service.uploadFIle(file);
        var video = new Video();
        video.setVideoUrl(videoUrl);
        videoRepository.save(video);
    }
}
