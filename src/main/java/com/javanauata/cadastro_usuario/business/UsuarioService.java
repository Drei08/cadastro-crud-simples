package com.javanauata.cadastro_usuario.business;

import com.javanauata.cadastro_usuario.infrastructure.entitys.Usuario;
import com.javanauata.cadastro_usuario.infrastructure.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;


    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public void salvaUsuario(Usuario usuario){
         repository.saveAndFlush(usuario);
    }

    public Usuario buscarPorEmail(String  email){
        return repository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Email não encontrado"));
    }
    
    public void deleteUsuarioEmail(String email){
        repository.deleteByEmail(email);
    }

    public void atualizaUsuarioEmail(String email, Usuario usuario){
        Usuario usuarioEntity = buscarPorEmail(email);
        Usuario usuarioAtualizado = Usuario.builder()
                .email(usuario.getEmail() != null ? usuario.getEmail() : usuarioEntity.getEmail())
                .nome(usuario.getNome() != null ? usuario.getNome() : usuarioEntity.getNome())
                .endereco(usuario.getEndereco() != null ? usuario.getEndereco() : usuarioEntity.getEndereco())
                .numero(usuario.getNumero() != null ? usuario.getNumero() : usuarioEntity.getNumero())
                .telefone(usuario.getTelefone() != null ? usuario.getTelefone() : usuarioEntity.getEmail())
                .cidade(usuario.getCidade() != null ? usuario.getCidade() : usuarioEntity.getCidade())
                .cep(usuario.getCep() != null ? usuario.getCep() : usuarioEntity.getCep())
                .build();

        repository.saveAndFlush(usuarioAtualizado);
    }
}
