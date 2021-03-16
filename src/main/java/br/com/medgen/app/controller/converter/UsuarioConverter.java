package br.com.medgen.app.controller.converter;

import br.com.medgen.app.entity.Usuario;
import br.com.medgen.app.gateway.database.UsuarioData;
import org.springframework.stereotype.Component;

@Component
public class UsuarioConverter {

    public UsuarioData convert(Usuario usuario){
        UsuarioData usuarioData = new UsuarioData();
        usuarioData.setEmail(usuario.getEmail());
        usuarioData.setSenha(usuario.getSenha());
        return usuarioData;
    }

}
