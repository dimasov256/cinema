import {Component, OnInit} from '@angular/core';
import {FileSystemDirectoryEntry, FileSystemFileEntry, NgxFileDropEntry} from 'ngx-file-drop';
import {Router} from '@angular/router';
import {VideoService} from './video.service';

@Component({
  selector: 'app-upload-video',
  templateUrl: './upload-video.component.html',
  styleUrls: ['./upload-video.component.css']
})
export class UploadVideoComponent implements OnInit {

  public files: NgxFileDropEntry[] = [];
  fileUploaded = false;
  fileEntry: FileSystemFileEntry | undefined;

  constructor(private videoService: VideoService, private router: Router) {
  }

  ngOnInit(): void {
  }


  dropped(files: NgxFileDropEntry[]): void {
    this.files = files;
    for (const dropFile of files) {
      if (dropFile.fileEntry.isFile) {
        this.fileEntry = dropFile.fileEntry as FileSystemFileEntry;
        this.fileEntry.file((file: File) => {
          console.log(dropFile.relativePath, file);
          this.fileUploaded = true;
        });
      } else {
        const fileEntry = dropFile.fileEntry as FileSystemDirectoryEntry;
        console.log(dropFile.relativePath, fileEntry);
      }
    }
  }

  fileOver($event: any): void {
  }

  fileLeave(): void {
  }

  uploadVideo(): void {
    if (this.fileEntry !== undefined) {
      this.fileEntry.file(file => {

        this.videoService.uploadVideo(file).subscribe(data => {
          this.router.navigateByUrl('save-video-details/' + data.videoId);
          console.log('Video uploaded successfully', data.videoId);
        });
      });
    }
  }

}
