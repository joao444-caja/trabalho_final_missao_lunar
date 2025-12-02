
package br.unochapeco.missoes.model;

import java.io.Serializable;
import java.util.Objects;

public class Astronauta implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nome;
    private int idade;
    private String especialidade;
    private int horasVoo;

    public Astronauta() {}

    public Astronauta(String nome, int idade, String especialidade, int horasVoo) {
        this.nome = nome;
        this.idade = idade;
        this.especialidade = especialidade;
        this.horasVoo = horasVoo;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }

    public String getEspecialidade() { return especialidade; }
    public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }

    public int getHorasVoo() { return horasVoo; }
    public void setHorasVoo(int horasVoo) { this.horasVoo = horasVoo; }

    @Override
    public String toString() {
        return String.format("%s (idade=%d, esp=%s, horasVoo=%d)", nome, idade, especialidade, horasVoo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Astronauta)) return false;
        Astronauta that = (Astronauta) o;
        return Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
