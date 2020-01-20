package com.renanleon.forca.controller;

import com.renanleon.forca.domain.dto.JogadaResponseDto;
import com.renanleon.forca.domain.dto.PartidaResponseDto;
import com.renanleon.forca.domain.model.Configuracao;
import com.renanleon.forca.domain.model.PalavraSecreta;
import com.renanleon.forca.domain.service.PartidaService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class PartidaControllerTest {

    @InjectMocks
    private PartidaController partidaController;

    @Mock
    private PartidaService partidaService;

    private int tentativas = 3;

    private String palavra = "coelho";

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldReturnNovaPartidaSemPalavraSecreta() {
        Configuracao configuracao = new Configuracao(5, null);

        Mockito.when(partidaService.iniciarNovaPartida(configuracao))
                .thenReturn(new PartidaResponseDto(tentativas, PalavraSecreta.random().name()));

        partidaController.iniciarNovaPartida(configuracao);
        Mockito.verify(partidaService, Mockito.only()).iniciarNovaPartida(configuracao);
    }

    @Test
    public void shouldReturnNovaPartidaComPalavraSecreta() {
        Configuracao configuracao = new Configuracao(tentativas, palavra);

        Mockito.when(partidaService.iniciarNovaPartida(configuracao))
                .thenReturn(new PartidaResponseDto(tentativas, palavra));

        partidaController.iniciarNovaPartida(configuracao);
        Mockito.verify(partidaService, Mockito.only()).iniciarNovaPartida(configuracao);
    }

    @Test
    public void shouldReturnNovaJogada() {
        Mockito.when(partidaService.novaJogada(Mockito.anyString())).thenReturn(new JogadaResponseDto(palavra, ""));

        partidaController.novaJogada("a");
        Mockito.verify(partidaService, Mockito.only()).novaJogada("a");
    }

    @Test
    public void shouldReturnTentativasRestantes() {
        Mockito.when(partidaService.getTentativasRestantes()).thenReturn(String.valueOf(tentativas));

        partidaController.getTentativasRestantes();
        Mockito.verify(partidaService, Mockito.only()).getTentativasRestantes();
    }
}
