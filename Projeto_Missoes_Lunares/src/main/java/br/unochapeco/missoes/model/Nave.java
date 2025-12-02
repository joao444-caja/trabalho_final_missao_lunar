
package br.unochapeco.missoes.model;

import java.io.Serializable;

public abstract class Nave implements Serializable {
    private static final long serialVersionUID = 1L;
    protected String nome;
    protected int capacidade; // número máximo de tripulantes

    public Nave() {}

    public Nave(String nome, int capacidade) {
        this.nome = nome;
        this.capacidade = capacidade;
    }

    public String getNome() { return nome; }
    public int getCapacidade() { return capacidade; }

    @Override
    public String toString() {
        return String.format("%s (capacidade=%d)", nome, capacidade);
    }
}
