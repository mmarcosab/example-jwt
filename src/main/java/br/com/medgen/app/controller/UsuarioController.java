package br.com.medgen.app.controller;

import br.com.medgen.app.controller.converter.UsuarioConverter;
import br.com.medgen.app.entity.Usuario;
import br.com.medgen.app.gateway.database.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioConverter usuarioConverter;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Usuario usuario){
        try {
            usuarioRepository.save(usuarioConverter.convert(usuario));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
