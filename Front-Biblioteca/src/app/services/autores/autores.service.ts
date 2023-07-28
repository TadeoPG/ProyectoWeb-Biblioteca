import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AutoresService {
  private API_SERVER = 'http://localhost:8080/autores';

  constructor(private httpClient: HttpClient) {}

  public getAllAutores(): Observable<any> {
    return this.httpClient.get(this.API_SERVER);
  }
}
