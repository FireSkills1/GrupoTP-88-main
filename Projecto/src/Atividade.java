import java.io.Serializable;

public class Atividade implements Serializable {
    private int codigo;
    private String nome;
    private String dificuldade; //dificuldade do exercicio
    private float calorias;

    public Atividade(){
        this.codigo = 0;
        this.nome = "";
        this.dificuldade = "";
        this.calorias = 0;
    }

    public Atividade(Atividade a){
        this.codigo = a.getCodigo();
        this.nome = a.getNome();
        this.dificuldade = a.getDificuldade();
        this.calorias = a.getCalorias();
    }

    public Atividade(int codigo, String nome, String dificuldade) {
        this.codigo = codigo;
        this.nome = nome;
        this.dificuldade = dificuldade;
        this.calorias = 0;
    }

    /*GETS*/
    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public float getCalorias() {
        return calorias;
    }

    /*SETS*/

    public void setNome(String nome) {
        this.nome = nome;
    }


    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }

    public void setCalorias(float calorias) {
        this.calorias = calorias;
    }

    /*EQUALS*/
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Atividade atividade = (Atividade) o;
        return atividade.nome.equals(this.nome)  && atividade.dificuldade.equals(this.dificuldade) && atividade.codigo == this.codigo;
    }

    /*CLONE*/
    public Atividade clone(){
        return new Atividade(this);
    }

    /*TO STRING*/
    public String toString() {
        return "Atividade:: " +
                "codigo= " + codigo + '|' +
                "nome= " + nome + '|'  +
                "dificuldade=" + dificuldade + '|' + calorias + ';';
    }
}
