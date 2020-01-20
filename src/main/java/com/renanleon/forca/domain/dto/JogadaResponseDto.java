package com.renanleon.forca.domain.dto;

public class JogadaResponseDto {

    private String palavraAtual;
    private String message;

    public JogadaResponseDto(String palavraAtual, String message) {
        this.palavraAtual = palavraAtual;
        this.message = message;
    }

    public String getPalavraAtual() {
        return palavraAtual;
    }

    public void setPalavraAtual(String palavraAtual) {
        this.palavraAtual = palavraAtual;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
