package com.renanleon.forca.domain.model;

import java.util.ArrayList;

public class Partida {

    private Configuracao configuracao;
    private ArrayList<Character> letrasInformadas;
    private String palavraAtual;
    private Integer tentativasRestantes;

    public Partida(Configuracao configuracao) {
        this.configuracao = configuracao;

        this.letrasInformadas = new ArrayList<>();
        this.palavraAtual = geraPalavraInicial(configuracao.getPalavraSecreta().length());
        this.tentativasRestantes = configuracao.getTotalTentativas();
    }

    public Configuracao getConfiguracao() {
        return configuracao;
    }

    public void setConfiguracao(Configuracao configuracao) {
        this.configuracao = configuracao;
    }

    public ArrayList<Character> getLetrasInformadas() {
        return letrasInformadas;
    }

    public void setLetrasInformadas(ArrayList<Character> letrasInformadas) {
        this.letrasInformadas = letrasInformadas;
    }

    public String getPalavraAtual() {
        return palavraAtual;
    }

    public void setPalavraAtual(String palavraAtual) {
        this.palavraAtual = palavraAtual;
    }

    public Integer getTentativasRestantes() {
        return tentativasRestantes;
    }

    public void setTentativasRestantes(Integer tentativasRestantes) {
        this.tentativasRestantes = tentativasRestantes;
    }

    private String geraPalavraInicial(Integer tamanhoPalavra){
        String palavraInicial = "";

        for (int i = 0; i < tamanhoPalavra-1; i++)
            palavraInicial = palavraInicial.concat("_ ");

        palavraInicial = palavraInicial.concat("_");

        return palavraInicial;
    }
}
