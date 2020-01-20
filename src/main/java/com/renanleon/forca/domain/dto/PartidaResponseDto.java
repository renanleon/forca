package com.renanleon.forca.domain.dto;

public class PartidaResponseDto {

    private Integer tentativas;
    private String palavraAtual;

    public PartidaResponseDto(Integer tentativas, String palavraAtual) {
        this.tentativas = tentativas;
        this.palavraAtual = palavraAtual;
    }

    public Integer getTentativas() {
        return tentativas;
    }

    public void setTentativas(Integer tentativas) {
        this.tentativas = tentativas;
    }

    public String getPalavraAtual() {
        return palavraAtual;
    }

    public void setPalavraAtual(String palavraAtual) {
        this.palavraAtual = palavraAtual;
    }
}
