import java.util.Objects;

public class BicicletaDeEstrada extends AlimetriaDistancia{
    private float potencia;
    private float freqCardiaca;

    public BicicletaDeEstrada(){
        super();
        this.potencia = 0;
        this.freqCardiaca = 0;
    }

    public BicicletaDeEstrada(float potencia, float freqCardiaca, double distancia,
                              int tempo, double altitude, int codigo, String nome, String dificuldade){
        super(distancia, tempo, altitude, codigo, nome, dificuldade);
        this.potencia = potencia;
        this.freqCardiaca = freqCardiaca;
    }

    public BicicletaDeEstrada(BicicletaDeEstrada bicicletaDeEstrada){
        super(bicicletaDeEstrada);
        this.potencia = bicicletaDeEstrada.getPotencia();
        this.freqCardiaca = bicicletaDeEstrada.getFreqCardiaca();
    }

    public float getPotencia() {
        return potencia;
    }
    public void setPotencia(float potencia) {
        this.potencia = potencia;
    }
    public float getFreqCardiaca() {
        return freqCardiaca;
    }
    public void setFreqCardiaca(float freqCardiaca) {
        this.freqCardiaca = freqCardiaca;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BicicletaDeEstrada that = (BicicletaDeEstrada) o;
        return Float.compare(potencia, that.potencia) == 0 && Float.compare(freqCardiaca, that.freqCardiaca) == 0;
    }

    public String toString() {
        return  super.toString() +
                "potencia=" + potencia +
                ", freqCardiaca=" + freqCardiaca;
    }

    public BicicletaDeEstrada clone(){
        return new BicicletaDeEstrada(this);
    }

    public float calcularCaloriasBicicletaEstrada(int MET){
        float caloria=0;
        caloria = (float) getDistancia() * MET*super.getTempo()*freqCardiaca;
        super.setCalorias(caloria);
        return caloria;
    }

}
