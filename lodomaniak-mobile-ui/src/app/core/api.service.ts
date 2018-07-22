import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams, HttpRequest } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { environment } from '../../environments/environment';

@Injectable()
export class ApiService {

  private readonly headers: HttpHeaders = new HttpHeaders().set('Content-Type', 'application/json');

  constructor(private http: HttpClient) {
  }

  get(path: string, params: HttpParams = new HttpParams()): Observable<any> {
    return this.http.get(`${environment.restApiUrl}${path}`, { params });
  }

  put(path: string, body: Object = {}): Observable<any> {
    return this.http.put(
      `${environment.restApiUrl}${path}`,
      JSON.stringify(body),
      { headers: this.headers },
    );
  }

  post(path: string, body: Object = {}, headers?: HttpHeaders): Observable<any> {
    return this.http.post(
      `${environment.restApiUrl}${path}`,
      JSON.stringify(body),
      { headers: headers ? headers : this.headers, observe: 'response' },
    );
  }

  delete(path): Observable<any> {
    return this.http.delete(
      `${environment.restApiUrl}${path}`,
    );
  }

  request(method: string, path: string, data: any, options: any): Observable<any> {
    const req = new HttpRequest(method, `${environment.restApiUrl}${path}`, data, options);
    return this.http.request(req);
  }

}
