package br.com.alura.rh.model;

import java.math.BigDecimal;

public class DadosPessoais {

    private final String nome;
	private final String cpf;
	private Cargo cargo;
	private BigDecimal salario;
    
    public static class Builder {
        private final String nome;
        private final String cpf;
        private Cargo cargo;
        private BigDecimal salario;

        public Builder(String nome, String cpf) {
            this.nome = nome;
            this.cpf = cpf;
        }
        public Builder cargo(Cargo cargo) { this.cargo = cargo; return this; }
        public Builder salario(BigDecimal salario) { this.salario = salario; return this; }

        public DadosPessoais build() {
            return new DadosPessoais(this);
        }
    }

    public DadosPessoais(Builder builder) {
        this.nome = builder.nome;
        this.cpf = builder.cpf;
        this.cargo = builder.cargo;
        this.salario = builder.salario;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public static DadosPessoais of(String nome, String cpf, Cargo cargo, BigDecimal salario) {
        return new Builder(nome, cpf).cargo(cargo).salario(salario).build();
    }

}
