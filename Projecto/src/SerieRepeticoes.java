public class SerieRepeticoes extends Atividade{
    private int tempo;
    private int repeticoes;
    private int nSets;

    public SerieRepeticoes(){
        super();
        this.tempo = 0;
        this.repeticoes = 0;
        this.nSets = 0;
    }
    public SerieRepeticoes(int tempo, int repeticoes, int nSets,   int codigo, String nome, String dificuldade) {
        super(codigo, nome, dificuldade);
        this.tempo = tempo;
        this.repeticoes = repeticoes;
        this.nSets = nSets;
    }

    public SerieRepeticoes(SerieRepeticoes serieRepeticoes) {
        super(serieRepeticoes);
        this.tempo = serieRepeticoes.getTempo();
        this.repeticoes = serieRepeticoes.getRepeticoes();
        this.nSets = serieRepeticoes.getnSets();
    }

    public int getTempo() {
        return tempo;
    }
    public void setTempo(int tempo) {
        this.tempo = tempo;
    }
    public int getRepeticoes() {
        return repeticoes;
    }
    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }

    public int getnSets() {
        return nSets;
    }

    public void setnSets(int nSets) {
        this.nSets = nSets;
    }

    public String toString() {
        return "Atividades.SerieRepeticoes{" + super.toString() + ", " +
                ", tempo=" + tempo +
                ", repeticoes=" + repeticoes +
                ", nSets=" + nSets +
                '}';
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SerieRepeticoes that = (SerieRepeticoes) o;
        return  tempo == that.tempo && repeticoes == that.repeticoes && nSets == that.nSets;
    }

    public SerieRepeticoes clone() {
        return new SerieRepeticoes(this);
    }
}
