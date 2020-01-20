package com.renanleon.forca.validation;

import com.renanleon.forca.domain.model.Configuracao;
import org.springframework.stereotype.Component;

@Component
public class NovaPartidaValidator {

    private static Integer MIN_TENTATIVAS = 1;

    public void validate(Configuracao configuracao) {
        if(configuracao.getTotalTentativas() < MIN_TENTATIVAS)
            throw new RuntimeException("Número total de tentativas deve ser maior que " + (MIN_TENTATIVAS - 1) + ".");
    }
}
