package com.repuestos.app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "\"años_producto\"", schema = "repuestos")
public class AñosProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "años_producto_id_gen")
    @SequenceGenerator(name = "años_producto_id_gen", sequenceName = "años_producto_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

    @Column(name = "\"año\"", nullable = false)
    private Integer año;

}