package com.renanleon.forca.validation;

import com.renanleon.forca.domain.model.Partida;
import com.renanleon.forca.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class NovaJogadaValidator {

    @Autowired
    PartidaExistenteValidator partidaExistenteValidator;

    public void validate(String letra, Partida partida){
        partidaExistenteValidator.validate(partida);

        if(Objects.isNull(letra) || letra.isEmpty())
            throw new RuntimeException("Letra não informada.");

        if(letra.length() > 1)
            throw new RuntimeException("Somente permitido informar uma letra por jogada.");

        if(!Character.isLetter(letra.charAt(0)))
            throw new RuntimeException("Caractere inválido. Insira uma letra.");

        if(partida.getLetrasInformadas().contains(StringUtil.removeAcento(letra).toUpperCase().charAt(0)))
            throw new RuntimeException("Essa letra já foi informada. Tente uma nova letra.");
    }
}
