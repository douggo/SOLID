package br.com.alura.rh.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Funcionario;

public class ReajusteSalarialService {
    
    private final Funcionario funcionario;

    public ReajusteSalarialService(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public void reajustarSalario(BigDecimal aumento) {
        BigDecimal salarioAtual = this.funcionario.getSalario();
        BigDecimal percentualReajuste = aumento.divide(salarioAtual, RoundingMode.HALF_UP);
		if (percentualReajuste.compareTo(new BigDecimal("0.4")) > 0) {
			throw new ValidacaoException("Reajuste nao pode ser superior a 40% do salario!");
		}
        this.funcionario.atualizaSalario(salarioAtual.add(aumento));
    }

}
