package com.example.proyectolibreriaingsoftware.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class CategoriaLC {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategoria;

    @Column(nullable = false, length = 1)
    private String codigo;

    @Column(nullable = false, length = 100)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_subcategoria", nullable = false, foreignKey = @ForeignKey(name = "FK_Categoria_Subcategoria"))
    private SubCategoriaLC subCategoriaLC;
}
