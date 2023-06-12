import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {VideoService} from '../upload-video/video.service';

@Component({
  selector: 'app-video-detail',
  templateUrl: './video-detail.component.html',
  styleUrls: ['./video-detail.component.css']
})
export class VideoDetailComponent implements OnInit {

  videoId!: string;
  videoUrl!: string;
  videoAvailable = false;
  videoTitle!: string;
  videoDescription!: string;
  videoTags: Array<string> = [];

  constructor(private activatedRout: ActivatedRoute,
              private videoService: VideoService) {
    this.videoId = this.activatedRout.snapshot.params.videoId;
    this.videoService.getVideo(this.videoId).subscribe(data => {
      this.videoUrl = data.videoUrl;
      this.videoTitle = data.title;
      this.videoDescription = data.description;
      this.videoTags = data.tags;
      this.videoAvailable = true;
    });
  }

  ngOnInit(): void {
  }

}
