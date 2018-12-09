import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import { CleanData } from './cleanData';
import {Observable, Subscription} from 'rxjs';

// TODO create a config for external addresses
const SERVICE_URL = 'http://localhost:8080';

@Injectable({
  providedIn: 'root'
})
export class CleanService {

  constructor(
    private _httpClient: HttpClient
  ) {
  }

  getCleanFileData (filename): Observable<Object> {
    let params = new HttpParams().set('filename', filename);
    return this._httpClient.get(SERVICE_URL + '/clean', {params: params});
  }

}
