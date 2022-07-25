package br.com.alura.rh.service.promocao;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Cargo;
import br.com.alura.rh.model.Funcionario;

public class PromocaoService {
    
    public void promoverFuncionario(Funcionario funcionario, Boolean metaAlcancada) {
        if(funcionario.getDadosPessoais().getCargo() == Cargo.GERENTE) {
            throw new ValidacaoException("Funcionários que são gerentes não podem ser promovidos!");
        }
        if(!metaAlcancada.booleanValue()) {
            throw new ValidacaoException("Funcionário não alcançou a meta estabelecida");
        }
        Cargo novoCargo = funcionario.getDadosPessoais().getCargo().getProximoCargo();
        funcionario.promover(novoCargo);
    }
 
}
