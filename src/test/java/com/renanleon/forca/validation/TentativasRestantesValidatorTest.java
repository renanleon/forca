package com.renanleon.forca.validation;

import com.renanleon.forca.domain.model.Configuracao;
import com.renanleon.forca.domain.model.Partida;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TentativasRestantesValidatorTest {

    @InjectMocks
    TentativasRestantesValidator tentativasRestantesValidator;

    @Mock
    PartidaExistenteValidator partidaExistenteValidator;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowTentativasAcabaram(){
        Partida partida = new Partida(new Configuracao(1, ""));
        partida.setTentativasRestantes(0);

        tentativasRestantesValidator.validate(partida);
    }
}
