import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LevantamentoDePesos extends RepeticoePesos{
    private String tipoPeso;
    public LevantamentoDePesos() {
        super();
        this.tipoPeso = "";
    }

    public LevantamentoDePesos(String tipoPeso, int codigo, String nome, String dificuldade, int repticoes, int pesos, int tempo){
        super(codigo, nome, dificuldade, repticoes, pesos, tempo);
        this.tipoPeso = tipoPeso;
    }

    public LevantamentoDePesos(LevantamentoDePesos levantamentoDePesos){
        super(levantamentoDePesos);
        this.tipoPeso = levantamentoDePesos.getTipoPeso();
    }

    public String getTipoPeso() {
        return tipoPeso;
    }
    public void setTipoPeso(String tipoPeso) {
        this.tipoPeso = tipoPeso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        LevantamentoDePesos that = (LevantamentoDePesos) o;
        return Objects.equals(tipoPeso, that.tipoPeso);
    }


    public String toString() {
        return "LevantamentoDePesos{" + super.toString() +
                "Tipo de Peso=" + this.tipoPeso +
                '}';
    }
    public LevantamentoDePesos clone() {
        return new LevantamentoDePesos(this);
    }

    public float calcularCaloriasLevatamentoPeso(int MET, int peso){
        float caloria=0;
        caloria = peso*MET*super.getTempo();
        super.setCalorias(caloria);
        return caloria;
    }
}
