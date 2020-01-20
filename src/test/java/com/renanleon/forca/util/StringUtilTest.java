package com.renanleon.forca.util;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class StringUtilTest {

    @Test
    public void shouldReturnPalavraSemAcento(){
        String result = StringUtil.removeAcento("áàâãç");

        Assertions.assertEquals(result, "aaaac");
    }

    @Test
    public void shouldReturnEmptyString(){
        String result = StringUtil.removeAcento("");

        Assertions.assertEquals(result, "");
    }

    @Test
    public void shouldReturnSameWord(){
        String result = StringUtil.removeAcento("palavra");

        Assertions.assertEquals(result, "palavra");
    }
}
