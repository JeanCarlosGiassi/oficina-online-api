package com.netjc.oficinaonline.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "peca")
@Setter
@Getter
@ToString
public class Peca {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false, length = 100, unique = true)
    private String peca;
    @Column(name = "jdoc")
    private String jdocConfiguration;
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    private boolean enabled = true;
    @Column
    private BigDecimal valor;
    @Column
    private BigDecimal valorFabricante;
    @OneToOne
    private FornecedorPeca fornecedorPeca;
    @OneToOne
    private FabricantePeca fabricantePeca;
}
