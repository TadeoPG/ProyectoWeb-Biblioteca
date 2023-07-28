import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class EspecialidadService {
  private API_SERVER = 'http://localhost:8080/especialidades';

  constructor(private httpClient: HttpClient) {}

  public getAllEspecialidades(): Observable<any> {
    return this.httpClient.get(this.API_SERVER);
  }
}
