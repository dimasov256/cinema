package com.cinema.backendvideo.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    public String uploadFIle(MultipartFile file);
}
