package com.renanleon.forca.validation;

import com.renanleon.forca.domain.model.Partida;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class PartidaExistenteValidator {

    public void validate(Partida partida){
        if(Objects.isNull(partida))
            throw new RuntimeException("Não existe partida iniciada.");
    }
}
