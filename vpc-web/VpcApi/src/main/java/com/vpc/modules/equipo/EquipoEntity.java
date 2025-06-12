package com.vpc.modules.equipo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.vpc.modules.jugador.JugadorEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "equipos")
public class EquipoEntity {
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	
	    @Column(nullable = false, length = 100)
	    private String nombre;
	
	    @Column(columnDefinition = "TEXT")
	    private String descripcion;
	    
	 // Relación con JugadorEntity
	    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL, orphanRemoval = true)
	    @JsonManagedReference
	    private List<JugadorEntity> jugadores;
}
