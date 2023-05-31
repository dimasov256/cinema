package com.cinema.backendvideo.service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.UUID;

@Service
@AllArgsConstructor
public class S3Service implements FileService {

    public static final String BUCKET_NAME = "youtube-demo-ptechie";
    private final AmazonS3Client amazonS3Client;

    @Override
    public String uploadFile(MultipartFile file) {
        //upload to AWS S3

        //prepare the key
        var filenameExtension = StringUtils.getFilenameExtension(file.getOriginalFilename());
        var key = UUID.randomUUID().toString() + "." + filenameExtension;
        var metadata = new ObjectMetadata();
        metadata.setContentLength(file.getSize());
        metadata.setContentType(file.getContentType());
        try {
            amazonS3Client.putObject(BUCKET_NAME, key, file.getInputStream(), metadata);
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "An exception occurred while uploading file");
        }

        amazonS3Client.setObjectAcl(BUCKET_NAME, key, CannedAccessControlList.PublicRead);

        return amazonS3Client.getResourceUrl(BUCKET_NAME, key);

    }
}
