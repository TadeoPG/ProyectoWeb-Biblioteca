import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AutoresService } from 'src/app/services/autores/autores.service';
import { EspecialidadService } from 'src/app/services/especialidades/especialidad.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  autorForm: FormGroup = new FormGroup({});
  autores: any;
  especialidades: any;

  title = 'Front-Biblioteca';
  constructor(
    public fb: FormBuilder,
    public autoresService: AutoresService,
    public especialidadService: EspecialidadService
  ) {}

  ngOnInit(): void {
    this.autorForm = this.fb.group({
      nombre: ['', Validators.required],
      apellidos: ['', Validators.required],
      telefono: ['', Validators.required],
      dni: ['', Validators.required],
      nacionalidad: ['', Validators.required],
      especialidad: ['', Validators.required],
    });

    this.autoresService.getAllAutores().subscribe(
      (resp) => {
        this.autores = resp;
        console.log(resp);
      },
      (error) => {
        console.error(error);
      }
    );

    this.especialidadService.getAllEspecialidades().subscribe(
      (resp) => {
        this.especialidades = resp;
        console.log(resp);
      },
      (error) => {
        console.error(error);
      }
    );
  }

  guardar(): void {}
}
