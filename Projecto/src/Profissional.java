import java.util.Map;
import java.util.Objects;

public class Profissional extends Utilizadores{
    private String clube;
    private int numero;

    public Profissional(){
        super();
        clube="";
        numero=0;
    }

    public Profissional(int numero, String clube, int codigo, String nome, String morada, String email, int frequenciaCardiacaMedia)  {

        super(codigo, nome, morada, email, frequenciaCardiacaMedia);
        this.numero = numero;
        this.clube = clube;
    }

    public Profissional(Profissional profissional){
        super(profissional);
        this.clube=profissional.getClube();
        this.numero=profissional.getNumero();
    }

    public String getClube() {
        return clube;
    }

    public void setClube(String clube) {
        this.clube = clube;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String toString() {
        return "Profissional{" + super.toString() + ", clube=" + clube + ", numero=" + numero + '}';
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Profissional that = (Profissional) o;
        return numero == that.numero && Objects.equals(clube, that.clube);
    }

    public Profissional clone(){
        return new Profissional(this);
    }


}
