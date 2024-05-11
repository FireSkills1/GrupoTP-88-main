import java.util.Objects;

public class Amadores extends Utilizadores{
     private Boolean Acompanhado;

     public Amadores(Boolean Acompanhado, int codigo, String nome, String morada, String email, int frequenciaCardiacaMedia) {
          super(codigo, nome, morada, email, frequenciaCardiacaMedia);
          this.Acompanhado = Acompanhado;
     }
     public Amadores() {
          super();
          this.Acompanhado = false;
     }

     public Amadores(Amadores amadores) {
          super(amadores);
          this.Acompanhado = amadores.getAcompanhado();
     }

     public Boolean getAcompanhado() {
          return Acompanhado;
     }
     public void setAcompanhado(Boolean Acompanhado) {
          this.Acompanhado = Acompanhado;
     }

     public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;
          if (!super.equals(o)) return false;
          Amadores amadores = (Amadores) o;
          return Objects.equals(Acompanhado, amadores.Acompanhado);
     }

     public String toString() {
          return "Amadores{" + super.toString() + ", Acompanhado=" + Acompanhado + '}';
     }

     public Amadores clone() {
          return new Amadores(this);
     }
}
