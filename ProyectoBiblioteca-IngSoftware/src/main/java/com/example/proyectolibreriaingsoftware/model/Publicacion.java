package com.example.proyectolibreriaingsoftware.model;

import com.example.proyectolibreriaingsoftware.model.llavescompuestas.PubAutor;
import com.example.proyectolibreriaingsoftware.model.llavescompuestas.PubPC;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Publicacion {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPublicacion;

    @Column(nullable = false, length = 100)
    private String titulo;

    @Column(nullable = false)
    private Integer numPaginas;

    @Column(nullable = true)
    private LocalDateTime fechaPublicacion;

    @Column(nullable = false)
    private boolean disponibilidad;

    @Column(nullable = false)
    private Integer numEstante;

    @Column(nullable = false, length = 50)
    private String disciplina;

    @Column(nullable = true, length = 200)
    private String bibliografia;

    @ManyToOne
    @JoinColumn(name = "id_editorial", nullable = true, foreignKey = @ForeignKey(name = "FK_Publicacion_Editorial"))
    private Editorial editorial;

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = true, foreignKey = @ForeignKey(name = "FK_Publicacion_Categoria"))
    private CategoriaLC categoriaLC;

    //Las dos relaciones son para poder mostrar sus autores y palabras clave de las publicaciones
    //Esto se hace cuando hay tabla intermedia de Muchos a Muchos

    //Esta relación es importante porque nuestra intención al final es mostrar en el JSON todos los autores que tiene
    //cada publicación. VER PublicacionDTO
    @OneToMany(mappedBy = "publicacion", cascade = CascadeType.ALL)
    private List<PubAutor> pubAutor;

    //Esta relación es importante porque nuestra intención al final es mostrar en el JSON todos los autores que tiene
    //cada publicación. VER PublicacionDTO
    @OneToMany(mappedBy = "publicacion", cascade = CascadeType.ALL)
    private List<PubPC> pubPC;

    @Column(nullable = false)
    private boolean enabled;

}
