package com.renanleon.forca.validation;

import com.renanleon.forca.domain.model.Configuracao;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class NovaPartidaValidatorTest {

    @InjectMocks
    private NovaPartidaValidator novaPartidaValidator;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowMinTentativas(){
        novaPartidaValidator.validate(new Configuracao(0, ""));
    }
}
