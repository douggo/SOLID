package br.com.alura.rh.service.reajuste;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Funcionario;

public class ValidacaoIntervaloTempoReajusteSalarial implements ValidacaoReajusteSalarial {

    public void validar(Funcionario funcionario, BigDecimal aumento) {
        LocalDate dataUltimoReajuste = funcionario.getDataUltimoReajuste();
        LocalDate dataAtual = LocalDate.now();
        Long qtdMesesAposReajuste = ChronoUnit.MONTHS.between(dataUltimoReajuste, dataAtual);
        if(qtdMesesAposReajuste < 6) {
            throw new ValidacaoException("Intervalo de reajustes deve ser a partir de seis meses");
        }
    }

}
