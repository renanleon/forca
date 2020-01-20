package com.renanleon.forca.controller;

import com.renanleon.forca.domain.dto.JogadaResponseDto;
import com.renanleon.forca.domain.dto.PartidaResponseDto;
import com.renanleon.forca.domain.model.Configuracao;
import com.renanleon.forca.domain.service.PartidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/partida")
public class PartidaController {

    @Autowired
    PartidaService partidaService;

    @PostMapping(path = "/nova", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PartidaResponseDto iniciarNovaPartida(@RequestBody @Valid Configuracao configuracao){
        return partidaService.iniciarNovaPartida(configuracao);
    }

    @PostMapping(path = "/jogada", consumes = MediaType.TEXT_PLAIN_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public JogadaResponseDto novaJogada(@RequestBody @Nullable String letra){
        return partidaService.novaJogada(letra);
    }

    @GetMapping(path = "/tentativas", produces = MediaType.TEXT_PLAIN_VALUE)
    public String getTentativasRestantes(){
        return partidaService.getTentativasRestantes();
    }

}
