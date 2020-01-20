package com.renanleon.forca.domain.service;

import com.renanleon.forca.domain.dto.JogadaResponseDto;
import com.renanleon.forca.domain.dto.PartidaResponseDto;
import com.renanleon.forca.domain.model.Configuracao;
import com.renanleon.forca.domain.model.Partida;
import com.renanleon.forca.util.StringUtil;
import com.renanleon.forca.validation.NovaJogadaValidator;
import com.renanleon.forca.validation.NovaPartidaValidator;
import com.renanleon.forca.validation.TentativasRestantesValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Service
public class PartidaService {

    private Partida partida;

    @Autowired
    private NovaPartidaValidator novaPartidaValidator;

    @Autowired
    private NovaJogadaValidator novaJogadaValidator;

    @Autowired
    private TentativasRestantesValidator tentativasRestantesValidator;

    public PartidaResponseDto iniciarNovaPartida(Configuracao configuracao) {
        novaPartidaValidator.validate(configuracao);
        partida = new Partida(configuracao);

        return new PartidaResponseDto(partida.getTentativasRestantes(), partida.getPalavraAtual());
    }

    public JogadaResponseDto novaJogada(String letra) {
        try {
            novaJogadaValidator.validate(letra, partida);
        } catch (Exception e) {
            if(Objects.isNull(partida))
                return new JogadaResponseDto("", e.getMessage());
            return new JogadaResponseDto(partida.getPalavraAtual(), e.getMessage() + " " + getTentativasRestantes());
        }

        if(venceu())
            return new JogadaResponseDto(partida.getPalavraAtual(), "Essa partida finalizou. Inicie uma nova partida.");

        char letraFormatada = StringUtil.removeAcento(letra).toUpperCase().charAt(0);

        ArrayList<Character> letrasInformadas = partida.getLetrasInformadas();
        letrasInformadas.add(letraFormatada);
        partida.setLetrasInformadas(letrasInformadas);

        if (!existeLetraInformada(letraFormatada)) {
            partida.setTentativasRestantes(partida.getTentativasRestantes() - 1);

            if (partida.getTentativasRestantes() == 0)
                return new JogadaResponseDto(partida.getPalavraAtual(), "Forca! Suas tentativas acabaram.");

            return new JogadaResponseDto(partida.getPalavraAtual(),
                    "Letra " + letraFormatada + " inexistente. " + getTentativasRestantes());
        }
        atualizaPalavraAtual(letraFormatada);

        if(venceu()) {
            partida.setTentativasRestantes(0);
            return new JogadaResponseDto(partida.getPalavraAtual(), "Parabéns! Você encontrou a palavra secreta.");
        }

        return new JogadaResponseDto(partida.getPalavraAtual(), "Letra " + letraFormatada + " inserida com sucesso.");
    }

    private Boolean existeLetraInformada(Character letraInformada){
        return partida.getConfiguracao().getPalavraSecreta().contains(letraInformada.toString());
    }

    private void atualizaPalavraAtual(Character letraInformada){
        String palavraSecreta = partida.getConfiguracao().getPalavraSecreta();
        StringBuilder newPalavra = new StringBuilder(partida.getPalavraAtual());

        for (int i = 0; i < palavraSecreta.length(); i++){
            if(letraInformada.equals(palavraSecreta.charAt(i))) {
                newPalavra.setCharAt(i*2, letraInformada);
            }
        }

        partida.setPalavraAtual(newPalavra.toString());
    }

    private Boolean venceu(){
        return partida.getPalavraAtual().replaceAll(" ", "").equals(partida.getConfiguracao().getPalavraSecreta());
    }

    public String getTentativasRestantes() {
        try{
            tentativasRestantesValidator.validate(partida);
        } catch (Exception e) {
            return e.getMessage();
        }

        return "Você ainda possui " + partida.getTentativasRestantes() + " tentativas";
    }


}
