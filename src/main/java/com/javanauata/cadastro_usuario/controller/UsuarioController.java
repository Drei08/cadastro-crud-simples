package com.javanauata.cadastro_usuario.controller;

import com.javanauata.cadastro_usuario.business.UsuarioService;
import com.javanauata.cadastro_usuario.infrastructure.entitys.Usuario;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    @PostMapping
    public ResponseEntity<Usuario> salvaUsuario(@RequestBody Usuario usuario) {
        service.salvaUsuario(usuario);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Usuario> buscarUsuarioPorEmail(@RequestParam String email) {
        return ResponseEntity.ok(service.buscarPorEmail(email));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarUsuarioPorEmail(@RequestParam String email){
        service.deleteUsuarioEmail(email);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizaUsuarioPorId(@RequestParam Long id,
                                                     @RequestBody Usuario usuario){
        service.atualizaUsuarioPorId(id, usuario);
        return ResponseEntity.ok().build();
    }
}
