package com.example.proyectolibreriaingsoftware.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class DetallePrestamo {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalle;

    @Column(nullable = false, length = 50)
    private String estado;

    @Column(nullable = true)
    private Integer diasPrestamo;

    @OneToOne
    @JoinColumn(name = "id_multa", nullable = true, foreignKey = @ForeignKey(name = "FK_Detalle_Multa"))
    private Multa multa;

    @ManyToOne
    @JoinColumn(name = "id_tesis", nullable = true, foreignKey = @ForeignKey(name = "FK_Detalle_Tesis"))
    private Tesis tesis;

    @ManyToOne
    @JoinColumn(name = "id_revista", nullable = true, foreignKey = @ForeignKey(name = "FK_Detalle_Revista"))
    private Revista revista;

    @ManyToOne
    @JoinColumn(name = "id_libro", nullable = true, foreignKey = @ForeignKey(name = "FK_Detalle_Libro"))
    private Libro libro;

    @ManyToOne
    @JoinColumn(name = "id_prestamo", nullable = false, foreignKey = @ForeignKey(name = "FK_Detalle_Prestamo"))
    private Prestamo prestamo;
}