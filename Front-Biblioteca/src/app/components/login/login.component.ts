import { LoginService } from './../../services/login/login.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup = new FormGroup({});
  validacion: any;

  constructor(
    private router: Router,
    public fb: FormBuilder,
    public loginService: LoginService
  ) {}

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      usuario: ['', Validators.required],
      contrasenia: ['', Validators.required]
    });
  }

  redirigir() {
    this.router.navigate(['/home']);
  }

  validar(): void {
    this.loginService.validarCredenciales(this.loginForm.value).subscribe(
      (resp) => {
        if (resp == true) {
          this.validacion = resp;
          alert('Inicio de Sesión exitoso');
          this.redirigir();
        } 
        else if (resp == false) {
          this.validacion = resp;
          alert('Usuario o contraseña incorrecta');
        }
      },
      (error) => {
        console.error(error);
      }
    );
  }
}
