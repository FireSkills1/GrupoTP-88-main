import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Abdominais extends SerieRepeticoes{
    private String nomeAbdominais;

     public Abdominais(){
         super();
        this.nomeAbdominais = "";
     }
     public Abdominais(String abdominais, int tempo, int repeticoes, int nSets,   int codigo, String nome, String dificuldade){
         super(tempo,repeticoes,nSets,codigo,nome,dificuldade);
         this.nomeAbdominais = abdominais;
     }

     public Abdominais(Abdominais abdominais){
         super(abdominais);
         this.nomeAbdominais = abdominais.getNomeAbdominais();
     }

     public String getNomeAbdominais(){
         return nomeAbdominais;
     }

     public void setNomeAbdominais(String abdominais){
         this.nomeAbdominais = abdominais;
     }

    public String toString() {
        return "Abdominais{" + super.toString() + ", abdominais=" + this.nomeAbdominais + '}';
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Abdominais that = (Abdominais) o;
        return Objects.equals(nomeAbdominais, that.nomeAbdominais);
    }

    public Abdominais clone() {
        return new Abdominais(this);
    }

    public float calcularCaloriasAbdominais(int MET, int peso){
        float caloria=0;
        caloria = peso*MET*super.getTempo();
        super.setCalorias(caloria);
        return caloria;
    }
}
