import java.util.Objects;

public class PraticantesOcasionais extends Utilizadores{
        private String motivacao;

        public PraticantesOcasionais() {
            super();
            this.motivacao="";
        }

        public PraticantesOcasionais(String motivacao, int codigo, String nome, String morada, String email, int frequenciaCardiacaMedia) {
            super(codigo, nome, morada, email, frequenciaCardiacaMedia);
            this.motivacao=motivacao;
        }

        public PraticantesOcasionais(PraticantesOcasionais p) {
            super(p);
            this.motivacao=p.getMotivacao();
        }

        public String getMotivacao() {
            return motivacao;
        }

        public void setMotivacao(String motivacao) {
            this.motivacao = motivacao;
        }

    public String toString() {
        return "PraticantesOcasionais{" + super.toString() + ", motivacao=" + motivacao + '}';
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PraticantesOcasionais that = (PraticantesOcasionais) o;
        return Objects.equals(motivacao, that.motivacao);
    }

    public PraticantesOcasionais clone() {
            return new PraticantesOcasionais(this);
    }

}
