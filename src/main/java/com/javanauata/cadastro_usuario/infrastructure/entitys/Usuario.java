package com.javanauata.cadastro_usuario.infrastructure.entitys;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table (name = "usuario")
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "email", unique = true )
    private String email;
    @Column(name = "nome")
    private String nome;
    @Column(name = "enderco")
    private String endereco;
    @Column(name = "numero", length = 3)
    private String numero;
    @Column(name = "telefone", length = 11)
    private String telefone;
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "cep", length = 8)
    private String cep;
}
