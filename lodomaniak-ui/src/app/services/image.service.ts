import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { HttpHeaders } from '@angular/common/http';
import { filter, map } from 'rxjs/operators';

import { ApiService } from '../core/api.service';
import { FileUploadResponse } from '../model/file-upload-response.model';

export const IMAGE_PATH = '/image';

@Injectable()
export class ImageService {

  private readonly headers: HttpHeaders;

  constructor(private apiService: ApiService) {
  }

  save(file: File): Observable<FileUploadResponse> {
    const formData: FormData = new FormData();
    formData.append('file', file);
    return this.apiService.request('POST', IMAGE_PATH, formData, {
      responseType: 'text',
    }).pipe(map((response) => {
      if (!response.body) {
        return response;
      }
      return JSON.parse(response.body);
    }));
  }

}
