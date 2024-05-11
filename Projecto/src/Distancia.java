public class Distancia extends Atividade{
    private double distancia; //km
    private int tempo;

    public Distancia(){
        super();
        this.distancia = 0;
        this.tempo = 0;
    }

    public Distancia(double distancia, int tempo,  int codigo, String nome, String dificuldade){
        super(codigo, nome, dificuldade);
        this.distancia = distancia;
        this.tempo = tempo;
    }

    public Distancia(Distancia distancia){
        super(distancia);
        this.distancia = distancia.getDistancia();
        this.tempo = distancia.getTempo();
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }
    public int getTempo() {
        return tempo;
    }
    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Distancia distancia1 = (Distancia) o;
        return Double.compare(distancia, distancia1.distancia) == 0 && tempo == distancia1.tempo;
    }

    public String toString() {
        return "Atividades.Distancia{ Atividades.Atividade" + super.toString() + ", "+
                ", distancia=" + distancia +
                ", tempo=" + tempo +
                '}';
    }
    public Distancia clone(){
        return new Distancia(this);
    }
}
