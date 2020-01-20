package com.renanleon.forca.validation;

import com.renanleon.forca.domain.model.Partida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class TentativasRestantesValidator {

    @Autowired
    PartidaExistenteValidator partidaExistenteValidator;

    public void validate(Partida partida){
        partidaExistenteValidator.validate(partida);

        if(partida.getTentativasRestantes() == 0)
            throw new RuntimeException("Suas tentativas acabaram.");
    }

}
