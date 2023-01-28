package com.netjc.oficinaonline.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "cliente")
@Setter
@Getter
@ToString
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false, length = 100, unique = true)
    private String cliente;
    @Column(length = 100)
    private String apelido;
    @Column(length = 20)
    private String documento;
    @Column(length = 13)
    private String telefone;
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
