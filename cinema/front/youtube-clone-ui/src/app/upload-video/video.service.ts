import {Injectable} from '@angular/core';
import {UploadVideoResponse} from './UploadVideoResponse';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Route, Router} from '@angular/router';
import {VideoDto} from '../VideoDto';

@Injectable({
  providedIn: 'root'
})
export class VideoService {

  uploadVideoResponse: UploadVideoResponse | undefined;

  constructor(private httpClient: HttpClient, private router: Router) {
  }

  public uploadVideo(fileEntry: File): Observable<UploadVideoResponse> {
    const file = new FormData();
    file.append('file', fileEntry, fileEntry.name);

    return this.httpClient.post<UploadVideoResponse>('http://localhost:8090/api/videos', file);
  }

  public uploadThumbnail(fileEntry: File, videoId: string): Observable<string> {
    const fd = new FormData();
    console.log('videoId:', videoId);
    fd.append('file', fileEntry, fileEntry.name);
    fd.append('videoId', videoId);

    return this.httpClient.post('http://localhost:8090/api/videos/thumbnail', fd, {responseType: 'text'});
  }

  getVideo(videoId: string): Observable<VideoDto> {
    // when load video from Amazon have the error CORS error
    return this.httpClient.get<VideoDto>('http://localhost:8090/api/videos/' + videoId);
  }

  saveVideo(videoDto: VideoDto): Observable<VideoDto> {
    console.log('Video dto', videoDto);
    return this.httpClient.put<VideoDto>('http://localhost:8090/api/videos', videoDto);
  }
}
