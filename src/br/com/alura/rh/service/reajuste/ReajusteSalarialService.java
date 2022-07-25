package br.com.alura.rh.service.reajuste;

import java.math.BigDecimal;
import java.util.List;

import br.com.alura.rh.model.Funcionario;

public class ReajusteSalarialService {
    
    private final Funcionario funcionario;
    private final List<ValidacaoReajusteSalarial> validacoes;

    public ReajusteSalarialService(Funcionario funcionario, List<ValidacaoReajusteSalarial> validacoes) {
        this.funcionario = funcionario;
        this.validacoes = validacoes;
    }

    public void reajustarSalario(BigDecimal aumento) {
        this.validacoes.forEach(validacao -> validacao.validar(this.funcionario, aumento));
        BigDecimal salarioAtual = this.funcionario.getDadosPessoais().getSalario();
        this.funcionario.atualizaSalario(salarioAtual.add(aumento));
    }

}
