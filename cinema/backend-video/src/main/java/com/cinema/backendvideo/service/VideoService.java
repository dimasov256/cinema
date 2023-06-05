package com.cinema.backendvideo.service;

import com.cinema.backendvideo.dto.UploadVideoResponse;
import com.cinema.backendvideo.dto.VideoDto;
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

    public UploadVideoResponse uploadVideo(MultipartFile file) {
        //upload file to database S3
        //save Video to data to database
//        String videoUrl = s3Service.uploadFile(file);
        String videoUrl = file.getResource().toString();
        var video = new Video();
        video.setVideoUrl(videoUrl);
        var savedVideo = videoRepository.save(video);
        return new UploadVideoResponse(savedVideo.getId(), savedVideo.getVideoUrl());
    }

    public VideoDto editVideo(VideoDto videoDto) {
        //find video by video id
        var savedVideo = getVideoById(videoDto.getId());
        // map videoDto fields
        savedVideo.setTitle(videoDto.getTitle());
        savedVideo.setDescription(videoDto.getDescription());
        savedVideo.setTags(videoDto.getTags());
        savedVideo.setThumbnailUrl(videoDto.getThumbnailUrl());
        savedVideo.setStatus(videoDto.getStatus());
        //save dto to database
        videoRepository.save(savedVideo);

        return videoDto;
    }

    public String uploadThumbnailUrl(MultipartFile multipartFile, String videoId) {
        var savedVideo = getVideoById(videoId);

//        String thumbnailUrl = s3Service.uploadFile(multipartFile);
        String thumbnailUrl = multipartFile.getResource().toString();
        savedVideo.setThumbnailUrl(thumbnailUrl);

        videoRepository.save(savedVideo);
        return thumbnailUrl;
    }

    Video getVideoById(String videoId) {
        return videoRepository.findById(videoId)
                .orElseThrow(() -> new IllegalArgumentException("Cannot find video by id: " + videoId));
    }


    public VideoDto getVideoDetails(String videoId) {
        Video saveVideo = getVideoById(videoId);
        VideoDto videoDto = new VideoDto();
        videoDto.setId(saveVideo.getId());
        videoDto.setVideoUrl(saveVideo.getVideoUrl());
        videoDto.setThumbnailUrl(saveVideo.getThumbnailUrl());
        videoDto.setDescription(saveVideo.getDescription());
        videoDto.setStatus(saveVideo.getStatus());
        videoDto.setTitle(saveVideo.getTitle());

        return videoDto;
    }
}
