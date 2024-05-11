import java.util.Objects;

public class Remo extends Distancia{
        private String condicoeClimaticas;


        public Remo(){
            super();
            this.condicoeClimaticas = "N";
        }

        public Remo(String condicoeClimaticas,double distancia, int tempo,  int codigo, String nome, String dificuldade ){
            super(distancia,tempo,codigo,nome,dificuldade);
            this.condicoeClimaticas = condicoeClimaticas;
        }

        public Remo(Remo remo){
            super(remo);
            this.condicoeClimaticas = remo.getCondicoeClimaticas();
        }

        public String getCondicoeClimaticas(){
            return condicoeClimaticas;
        }

        public void setCondicoeClimaticas(String condicoeClimaticas){
            this.condicoeClimaticas = condicoeClimaticas;
        }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Remo remo = (Remo) o;
        return Objects.equals(condicoeClimaticas, remo.condicoeClimaticas);
    }

    @Override
    public String toString() {
        return  super.toString() +
                "condicoeClimaticas='" + condicoeClimaticas;
    }

    public Remo clone(){
            return new Remo(this);
    }

    public float calcularCaloriasRemo(int MET, int freqCardiaca){
        float caloria=0;
        caloria = (float) super.getDistancia() * MET * super.getTempo()*freqCardiaca;
        super.setCalorias(caloria);
        return caloria;
    }
}
