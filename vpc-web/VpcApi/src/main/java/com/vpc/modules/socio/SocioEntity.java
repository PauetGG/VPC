package com.vpc.modules.socio;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "socios")
public class SocioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String apellidos;

    @Column(length = 150)
    private String email;

    @Column(length = 50)
    private String telefono;

    @Column(length = 255)
    private String direccion;

    private LocalDate fechaAlta;

    @Column(name = "tipo_socio", length = 50)
    private String tipoSocio;

    @Column(length = 50, nullable = false)
    private String estado = "Activo";

    @Column(length = 34)
    private String iban;

    @Column(name = "titular_cuenta", length = 150)
    private String titularCuenta;

    @Column(name = "aceptacion_rgpd")
    private LocalDate aceptacionRgpd;

    @Column(columnDefinition = "TEXT")
    private String observaciones;

    @Column(name = "creado_en", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime creadoEn;

    @Column(name = "actualizado_en", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime actualizadoEn;
}
