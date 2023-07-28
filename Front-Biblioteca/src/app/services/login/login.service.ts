import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  private API_SERVER = 'http://localhost:8080/cuentas/validar';

  constructor(private httpClient: HttpClient) {}

  public validarCredenciales(cuenta: any): Observable<any> {
    return this.httpClient.post(this.API_SERVER, cuenta);
  }
}
