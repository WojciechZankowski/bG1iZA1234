import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders, HttpParams, HttpRequest} from "@angular/common/http";
import {ErrorObservable} from "rxjs/observable/ErrorObservable";
import {Observable} from "rxjs/Observable";
import {environment} from "../../environments/environment";
import {catchError} from "rxjs/operators";
import {IMAGE_PATH} from "../services/image.service";

@Injectable()
export class ApiService {

  private readonly headers: HttpHeaders = new HttpHeaders().set('Content-Type', 'application/json');

  constructor(private http: HttpClient) {
  }

  private formatErrors(error: any) {
    return new ErrorObservable(error.error);
  }

  get(path: string, params: HttpParams = new HttpParams()): Observable<any> {
    return this.http.get(`${environment.restApiUrl}${path}`, {params})
      .pipe(catchError(this.formatErrors));
  }

  put(path: string, body: Object = {}): Observable<any> {
    return this.http.put(
      `${environment.restApiUrl}${path}`,
      JSON.stringify(body),
      {headers: this.headers}
    ).pipe(catchError(this.formatErrors));
  }

  post(path: string, body: Object = {}, headers?: HttpHeaders): Observable<any> {
    return this.http.post(
      `${environment.restApiUrl}${path}`,
      JSON.stringify(body),
      {headers: headers ? headers : this.headers, observe: 'response'}
    ).pipe(catchError(this.formatErrors));
  }

  delete(path): Observable<any> {
    return this.http.delete(
      `${environment.restApiUrl}${path}`
    ).pipe(catchError(this.formatErrors));
  }

  request(method: string, path: string, data: any, options: any): Observable<any> {
    const req = new HttpRequest(method, `${environment.restApiUrl}${path}`, data, options);
    return this.http.request(req);
  }

}
