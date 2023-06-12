import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {COMMA, ENTER} from '@angular/cdk/keycodes';
import {MatChipInputEvent} from '@angular/material/chips';
import {ActivatedRoute} from '@angular/router';
import {VideoService} from '../upload-video/video.service';
import {MatSnackBar} from '@angular/material/snack-bar';
import {VideoDto} from '../VideoDto';

@Component({
  selector: 'app-save-video-details',
  templateUrl: './save-video-details.component.html',
  styleUrls: ['./save-video-details.component.css']
})
export class SaveVideoDetailsComponent implements OnInit {
  saveVideoDetails: FormGroup;
  title: FormControl = new FormControl('');
  description: FormControl = new FormControl('');
  videoStatus: FormControl = new FormControl('');
  selectable = true;
  removable = true;
  addOnBlur = true;
  selectedFile!: File;
  videoUrl!: string;
  thumbnailUrl!: string;

  readonly separatorKeyCodes = [ENTER, COMMA] as const;

  tags: string[] = [];
  selectedFileName = '';
  fileUploaded = false;
  videoId = '';

  constructor(private activatedRout: ActivatedRoute,
              private videoService: VideoService,
              private matSnackBar: MatSnackBar) {
    this.videoId = this.activatedRout.snapshot.params.videoId;
    this.videoService.getVideo(this.videoId).subscribe(data => {
      this.videoUrl = data.videoUrl;
      this.thumbnailUrl = data.thumbnailUrl;
    });
    this.saveVideoDetails = new FormGroup({
      title: this.title,
      description: this.description,
      videoStatus: this.videoStatus
    });
  }

  ngOnInit(): void {
  }

  add(event: MatChipInputEvent): void {
    const value = (event.value || '').trim();

    if (value) {
      this.tags.push(value);
    }
    console.log('', event);
    // event!.clear();
  }

  remove(value: string): void {
    const index = this.tags.indexOf(value);
    if (index >= 0) {
      this.tags.splice(index, 1);
    }
  }


  onFileSelected($event: Event): void {
    // @ts-ignore
    this.selectedFile = $event.target.files[0];
    this.selectedFileName = this.selectedFile.name;
    this.fileUploaded = true;
  }

  saveVideo(): void {
    // Make http call to backend
    const videoMetaData: VideoDto = {
      videoStatus: this.saveVideoDetails.get('videoStatus')?.value,
      videoUrl: this.videoUrl,
      thumbnailUrl: this.videoUrl,
      videoId: this.videoId,
      userId: this.saveVideoDetails.get('userId')?.value,
      title: this.saveVideoDetails.get('title')?.value,
      videoName: this.saveVideoDetails.get('videoName')?.value,
      description: this.saveVideoDetails.get('description')?.value,
      tags: this.tags,
      likeCount: 1,
      dislikeCount: 1,
    };

    console.log('Video metadata: ', videoMetaData);
    this.videoService.saveVideo(videoMetaData).subscribe(data => {
      this.matSnackBar.open('Video metadata updated successfully', 'OK');
    });
  }

  onUpload(): void {
    this.videoService.uploadThumbnail(this.selectedFile, this.videoId).subscribe(
      data => {
        console.log('Response from thumbnail', data);
        this.matSnackBar.open('Thumbnail upload successful!', 'OK');
      }
    );
  }
}
