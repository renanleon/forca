package com.renanleon.forca.validation;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class PartidaExistenteValidatorTest {

    @InjectMocks
    PartidaExistenteValidator partidaExistenteValidator;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowPartidaInexistente(){
        partidaExistenteValidator.validate(null);
    }
}
