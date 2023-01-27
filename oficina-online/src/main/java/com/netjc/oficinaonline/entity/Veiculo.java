package com.netjc.oficinaonline.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "veiculo")
@Setter
@Getter
@ToString
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false, length = 100, unique = true)
    private String veiculo;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fabricate_id", referencedColumnName = "id")
    private FabricanteVeiculo fabricante;
    @Column(name = "jdoc")
    private String jdocConfiguration;
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    private boolean enabled = true;
}
