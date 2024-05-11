public class AlimetriaDistancia extends Atividade{
    private double distancia;//km
    private double altitude; //m
    private int tempo;


    public AlimetriaDistancia(){
        super();
        this.distancia = 0;
        this.altitude = 0;
        this.tempo = 0;
        ;
    }

    public AlimetriaDistancia(double distancia, int tempo, double altitude, int codigo, String nome, String dificuldade){
        super(codigo, nome, dificuldade);
        this.distancia = distancia;
        this.tempo = tempo;
        this.altitude = altitude;

    }

    public AlimetriaDistancia(AlimetriaDistancia alimetriaDistancia){
        super(alimetriaDistancia);
        this.distancia = alimetriaDistancia.getDistancia();
        this.tempo = alimetriaDistancia.getTempo();
        this.altitude = alimetriaDistancia.getAltitude();
    }

    public double getDistancia() {
        return distancia;
    }
    public double getAltitude() {
        return altitude;
    }
    public int getTempo() {
        return tempo;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }
    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }
    public void setTempo(int tempo) {
        this.tempo = tempo;
    }


    public String toString() {
        return "Atividades.AlimetriaDistancia{ Atividade" + super.toString() + "," +
                "distancia=" + distancia +
                ", altitude=" + altitude +
                ", tempo=" + tempo +
                '}';
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AlimetriaDistancia that = (AlimetriaDistancia) o;
        return Double.compare(distancia, that.distancia) == 0 && Double.compare(altitude, that.altitude) == 0
                && tempo == that.tempo;
    }

    public AlimetriaDistancia clone(){
        return new AlimetriaDistancia(this);
    }
}
