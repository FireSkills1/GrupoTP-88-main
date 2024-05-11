public class RepeticoePesos extends Atividade{
    private int repticoes;
    private int pesos;
    private int tempo;
    private int nSets;

    public RepeticoePesos(){
        super();
        this.repticoes = 0;
        this.pesos = 0;
        this.tempo = 0;
        this.nSets = 0;
    }

    public RepeticoePesos(RepeticoePesos repeticoePesos){
        super(repeticoePesos);
        this.repticoes = repeticoePesos.getRepticoes();
        this.pesos = repeticoePesos.getPesos();
        this.tempo = repeticoePesos.getTempo();
        this.nSets = repeticoePesos.getNSets();

    }

    public RepeticoePesos( int codigo, String nome, String dificuldade, int repticoes, int pesos, int tempo){
        super(codigo, nome, dificuldade);
        this.repticoes = repticoes;
        this.pesos = pesos;
        this.tempo = tempo;
        this.nSets = 0;
    }
    /*GETS*/
    public int getRepticoes(){
        return this.repticoes;
    }
    public int getPesos(){
        return this.pesos;
    }
    public int getTempo(){
        return this.tempo;
    }
    public int getNSets(){
        return this.nSets;
    }
    /*SETS*/
    public void setRepticoes(int repticoes){
        this.repticoes = repticoes;
    }
    public void setPesos(int pesos){
        this.pesos = pesos;
    }
    public void setTempo(int tempo){
        this.tempo = tempo;
    }

    public void setNSets(int nSets){
        this.nSets = nSets;
    }

    /*EQUALS*/
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        if(!super.equals(obj)) return false;
        RepeticoePesos s = (RepeticoePesos) obj;
        return  this.pesos == s.pesos && this.tempo == s.tempo;
    }

    /*CLONE*/

    public RepeticoePesos clone(){
        return new RepeticoePesos(this);
    }

    /*TOSTRING*/

    @Override
    public String toString() {
        return "Atividades.RepeticoePesos{ Atividades.Atividade:: " + super.toString() +
                "repticoes=" + repticoes +
                ", pesos=" + pesos +
                ", tempo=" + tempo +
                ", nSets=" + nSets +
                '}';
    }
}
