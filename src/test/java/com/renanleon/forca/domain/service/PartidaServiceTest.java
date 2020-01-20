package com.renanleon.forca.domain.service;

import com.renanleon.forca.domain.dto.JogadaResponseDto;
import com.renanleon.forca.domain.dto.PartidaResponseDto;
import com.renanleon.forca.domain.model.Configuracao;
import com.renanleon.forca.validation.NovaJogadaValidator;
import com.renanleon.forca.validation.NovaPartidaValidator;
import com.renanleon.forca.validation.TentativasRestantesValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class PartidaServiceTest {

    @InjectMocks
    PartidaService partidaService;

    @Mock
    NovaPartidaValidator novaPartidaValidator;

    @Mock
    NovaJogadaValidator novaJogadaValidator;

    @Mock
    TentativasRestantesValidator tentativasRestantesValidator;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldReturnNovaPartidaSemPalavra() {
        PartidaResponseDto partida = partidaService.iniciarNovaPartida(new Configuracao(5, ""));

        Assertions.assertNotNull(partida.getPalavraAtual());
        Assertions.assertEquals(partida.getTentativas(), 5);
    }

    @Test
    public void shouldReturnNovaPartidaComPalavra() {
        PartidaResponseDto partida = partidaService.iniciarNovaPartida(new Configuracao(5, "coelho"));

        Assertions.assertEquals(partida.getPalavraAtual(), "_ _ _ _ _ _");
        Assertions.assertEquals(partida.getTentativas(), 5);
    }

    @Test
    public void shouldReturnForca() {
        partidaService.iniciarNovaPartida(new Configuracao(1, "coelho"));

        JogadaResponseDto jogada = partidaService.novaJogada("a");

        Assertions.assertEquals(jogada.getPalavraAtual(), "_ _ _ _ _ _");
        Assertions.assertEquals(jogada.getMessage(), "Forca! Suas tentativas acabaram.");
    }

    @Test
    public void shouldReturnLetraInexistente() {
        partidaService.iniciarNovaPartida(new Configuracao(2, "coelho"));

        JogadaResponseDto jogada = partidaService.novaJogada("a");

        Assertions.assertEquals(jogada.getPalavraAtual(), "_ _ _ _ _ _");
        Assertions.assertEquals(jogada.getMessage(), "Letra A inexistente. Você ainda possui 1 tentativas");
    }

    @Test
    public void shouldReturnVencedor() {
        partidaService.iniciarNovaPartida(new Configuracao(2, "c"));

        JogadaResponseDto jogada = partidaService.novaJogada("c");

        Assertions.assertEquals(jogada.getPalavraAtual(), "C");
        Assertions.assertEquals(jogada.getMessage(), "Parabéns! Você encontrou a palavra secreta.");
    }

    @Test
    public void shouldReturnLetraInserida() {
        partidaService.iniciarNovaPartida(new Configuracao(2, "coelho"));

        JogadaResponseDto jogada = partidaService.novaJogada("o");

        Assertions.assertEquals(jogada.getPalavraAtual(), "_ O _ _ _ O");
        Assertions.assertEquals(jogada.getMessage(), "Letra O inserida com sucesso.");
    }

}
