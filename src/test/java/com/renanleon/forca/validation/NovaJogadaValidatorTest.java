package com.renanleon.forca.validation;

import com.renanleon.forca.domain.model.Configuracao;
import com.renanleon.forca.domain.model.Partida;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class NovaJogadaValidatorTest {

    @InjectMocks
    NovaJogadaValidator novaJogadaValidator;

    @Mock
    PartidaExistenteValidator partidaExistenteValidator;

    Configuracao configuracao = new Configuracao(5, "coelho");

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowLetraNulla(){
        novaJogadaValidator.validate(null, new Partida(configuracao));
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowLetraNaoInformada(){
        novaJogadaValidator.validate("", new Partida(configuracao));
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowLetraMaiorQueUm(){
        novaJogadaValidator.validate("ab", new Partida(configuracao));
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowLetraInvalida(){
        novaJogadaValidator.validate("2", new Partida(configuracao));
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowLetraJaInserida(){
        Partida partida = new Partida(configuracao);
        ArrayList<Character> inseridos = new ArrayList<>();
        inseridos.add('A');
        partida.setLetrasInformadas(inseridos);

        novaJogadaValidator.validate("a", partida);
    }
}
