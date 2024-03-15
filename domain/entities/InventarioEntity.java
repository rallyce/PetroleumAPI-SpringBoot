package com.rallyce.Petroleum_Inventario.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "inventario")
public class InventarioEntity {

    @Id
    @Column(name = "id")
    private String id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "informante_id")
    private UserSecurityEntity informanteId;

    @Column(name = "maquina")
    private String maquina;

    @Column(name = "producto")
    private String producto;

    @Column(name = "fecha")
    private String fecha;

    @Column(name = "descripcion")
    private String descripcion;



}
