package com.renanleon.forca.domain.model;

import com.renanleon.forca.util.StringUtil;

import java.util.Objects;

public class Configuracao {

    private Integer totalTentativas;
    private String palavraSecreta;

    public Configuracao(Integer totalTentativas, String palavraSecreta) {
        this.totalTentativas = totalTentativas;

        if(Objects.isNull(palavraSecreta) || palavraSecreta.isEmpty())
            this.palavraSecreta = StringUtil.removeAcento(PalavraSecreta.random().name());
        else
            this.palavraSecreta = StringUtil.removeAcento(palavraSecreta.toUpperCase());
    }

    public Integer getTotalTentativas() {
        return totalTentativas;
    }

    public void setTotalTentativas(Integer totalTentativas) {
        this.totalTentativas = totalTentativas;
    }

    public String getPalavraSecreta() {
        return palavraSecreta;
    }

    public void setPalavraSecreta(String palavraSecreta) {
        this.palavraSecreta = palavraSecreta;
    }
}
