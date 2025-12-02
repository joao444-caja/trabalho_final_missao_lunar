
package br.unochapeco.missoes.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Missao implements Serializable {
    private static final long serialVersionUID = 1L;
    private String codigo; // único
    private String nome;
    private LocalDate dataLancamento;
    private LocalDate dataRetorno;
    private String destino;
    private String objetivo;
    private String resultado;
    private Nave nave;
    private List<Astronauta> tripulantes = new ArrayList<>();

    public Missao() {}

    public Missao(String codigo, String nome, LocalDate dataLancamento, LocalDate dataRetorno,
                  String destino, String objetivo, Nave nave) {
        this.codigo = codigo;
        this.nome = nome;
        this.dataLancamento = dataLancamento;
        this.dataRetorno = dataRetorno;
        this.destino = destino;
        this.objetivo = objetivo;
        this.nave = nave;
    }

    public String getCodigo() { return codigo; }
    public String getNome() { return nome; }
    public LocalDate getDataLancamento() { return dataLancamento; }
    public LocalDate getDataRetorno() { return dataRetorno; }
    public String getDestino() { return destino; }
    public String getObjetivo() { return objetivo; }
    public String getResultado() { return resultado; }
    public void setResultado(String resultado) { this.resultado = resultado; }
    public Nave getNave() { return nave; }
    public List<Astronauta> getTripulantes() { return tripulantes; }

    public void adicionarAstronauta(Astronauta a) {
        this.tripulantes.add(a);
    }

    public long duracaoDias() {
        if (dataLancamento == null || dataRetorno == null) return -1;
        return ChronoUnit.DAYS.between(dataLancamento, dataRetorno);
    }

    @Override
    public String toString() {
        return String.format("Missao[codigo=%s, nome=%s, lanc=%s, retorno=%s, destino=%s, nave=%s, tripulantes=%d, resultado=%s]",
                codigo, nome, dataLancamento, dataRetorno, destino, nave, tripulantes.size(), resultado);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Missao)) return false;
        Missao missao = (Missao) o;
        return Objects.equals(codigo, missao.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
