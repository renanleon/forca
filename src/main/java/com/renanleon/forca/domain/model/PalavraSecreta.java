package com.renanleon.forca.domain.model;

public enum PalavraSecreta {

    CASA("CASA"),
    PREDIO("PRÉDIO"),
    EDIFICIO("EDIFÍCIO"),
    APARTAMENTO("APARTAMENTO"),
    VERMELHO("VERMELHO"),
    AZUL("AZUL"),
    AMARELO("AMARELO"),
    PRETO("PRETO"),
    ROSA("ROSA"),
    CAVALO("CAVALO"),
    CAMELO("CAMELO"),
    GIRAFA("GIRAFA"),
    ELEFANTE("ELEFANTE"),
    BRASIL("BRASIL"),
    ARGENTINA("ARGENTINA"),
    URUGUAI("URUGUAI"),
    CHILE("URUGUAI"),
    COLOMBIA("COLOMBIA"),
    INGLATERRA("INGLATERRA"),
    ESPANHA("ESPANHA"),
    JAPAO("JAPÃO"),
    ARROZ("ARROZ"),
    FEIJAO("FEIJÃO"),
    CAFE("CAFÉ"),
    LEITE("LEITE"),
    PAO("PÃO"),
    CARRO("CARRO"),
    AVIAO("AVIÃO"),
    BARCO("BARCO"),
    NAVIO("NAVIO"),
    LARANJA("LARANJA"),
    LIMAO("LIMÃO"),
    MARACUJA("MARACUJÁ"),
    ACEROLA("ACEROLA");

    PalavraSecreta(String palavraSecreta) {}

    public static PalavraSecreta random() {
        int pos = Double.valueOf(Math.random() * PalavraSecreta.values().length).intValue();

        return PalavraSecreta.values()[pos];
    }
}
