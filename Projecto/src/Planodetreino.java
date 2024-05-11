import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Planodetreino implements Serializable {
    private int idPlanodetreino;
    private LocalDate dataTreino;
    private Utilizadores utilizador;
    private List<Atividade> atividades;

    public Planodetreino() {
        this.idPlanodetreino = 0;
        this.dataTreino = LocalDate.now();
        this.utilizador = new Utilizadores();
        this.atividades = new ArrayList<>();
    }

    public Planodetreino(int idPlanodetreino, LocalDate dataTreino, Utilizadores utilizador, List<Atividade> atividades) {
        this.idPlanodetreino = idPlanodetreino;
        this.dataTreino = dataTreino;
        this.utilizador = utilizador;
        for(Atividade linha : atividades){
            this.atividades.add(linha.clone());
        }
    }

    public Planodetreino(Planodetreino planodetreino) {
        this.idPlanodetreino = planodetreino.getIdPlanodetreino();
        this.dataTreino = planodetreino.getDataTreino();
        this.utilizador = planodetreino.getUtilizador();
        this.atividades = planodetreino.getAtividades();
    }
    public int getIdPlanodetreino() {
        return idPlanodetreino;
    }
    public void setIdPlanodetreino(int idPlanodetreino) {
        this.idPlanodetreino = idPlanodetreino;
    }
    public LocalDate getDataTreino() {
        return dataTreino;
    }
    public void setDataTreino(LocalDate dataTreino) {
        this.dataTreino = dataTreino;
    }
    public Utilizadores getUtilizador() {
        return utilizador;
    }
    public void setUtilizador(Utilizadores utilizador) {
        this.utilizador = utilizador;
    }
    public List<Atividade> getAtividades() {
        List<Atividade> newLinha = new ArrayList<>();

        for (Atividade linha : this.atividades){
            newLinha.add(linha.clone());
        }
        return newLinha;
    }
    public void setAtividades(List<Atividade> atividades) {
        this.atividades = new ArrayList<>();
        for (Atividade l : atividades){
            this.atividades.add(l.clone());
        }
    }

    public String toString() {
        return "Planodetreino{" +
                "idPlanodetreino=" + idPlanodetreino +
                ", dataTreino=" + dataTreino +
                ", utilizador=" + utilizador +
                ", atividades=" + atividades +
                '}';
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planodetreino that = (Planodetreino) o;
        return idPlanodetreino == that.idPlanodetreino && Objects.equals(dataTreino, that.dataTreino) && Objects.equals(utilizador, that.utilizador) && Objects.equals(atividades, that.atividades);
    }

    public Planodetreino clone() {
        return new Planodetreino(this);
    }

    void addAtividade(Atividade atividade) {
        this.atividades.add(atividade);
    }
}
