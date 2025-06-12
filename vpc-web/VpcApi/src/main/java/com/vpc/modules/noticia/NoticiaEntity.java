package com.vpc.modules.noticia;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "noticias")
public class NoticiaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String contenido;

    @Column(name = "imagen_principal", length = 255)
    private String imagenPrincipal;

    @Column(name = "fecha_publicacion")
    private LocalDateTime fechaPublicacion;

    @Column(length = 100)
    private String autor;

    @Column(length = 100, nullable = false)
    private String fuente = "club";

    @Column(name = "link_fuente", length = 255)
    private String linkFuente;

    @Column(nullable = false)
    private boolean visible = true;

    @Column(name = "creado_en", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime creadoEn;

    @Column(name = "actualizado_en", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime actualizadoEn;
}
