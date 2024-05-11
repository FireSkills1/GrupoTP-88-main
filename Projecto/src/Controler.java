import java.io.Serializable;
import java.time.LocalDate;

public class Controler implements Serializable {
    private Model instance;

    Controler() {
        instance = new Model();
    }
    Controler(Model m) {
        instance = m;
    }

    public Model getModel() {
        return instance;
    }

    public void addAtividadeAbdominal(int codigoUtilizador, int codigo, String nome, String dificuldade,  String tipo, int repticoes, int tempo, int nSets) {
        Abdominais abdominais = new Abdominais(tipo,tempo, repticoes, nSets,codigo,nome,dificuldade);
        instance.addAtividade(codigoUtilizador, abdominais);

    }

    public void addAtividadePesos(int codigoUtilizador, int codigo, String nome, String dificuldade,  String tipo, int repticoes, int tempo, int nSets, int peso){
            LevantamentoDePesos levantamentoDePesos = new LevantamentoDePesos(tipo, codigo, nome, dificuldade,repticoes,peso,tempo);
            instance.addAtividade(codigoUtilizador,levantamentoDePesos);
    }

    public void addAtividadeBicicletaEstrada(int codigoUtilizador, float potencia,float freqCardiaca, float distancia, int tempo, int altitude,
                                            int codigo, String nome, String dificuldade){
        BicicletaDeEstrada bicicletaDeEstrada = new BicicletaDeEstrada(potencia,freqCardiaca,distancia, tempo, altitude,
                codigo, nome, dificuldade);
        instance.addAtividade(codigoUtilizador,bicicletaDeEstrada);

    }

    public void addAtividadeRemo(int codigoUtilizador, int codigo, String nome, String dificuldade, String condiCLimatericas,
                                 float distancia, int altitude, int tempo){
        Remo remo = new Remo(condiCLimatericas,distancia,tempo,codigo,nome,dificuldade);
        instance.addAtividade(codigoUtilizador, remo);

    }

   public void addUtilizador(Utilizadores utilizador){
        instance.addUtilizador(utilizador);
    }

    public void addUtilizadorProfissional(int codigo, String nome, String morada, String email,int freqCardiacao,
                                          String clube, int numeroClube){
        Profissional profissional = new Profissional(numeroClube,clube,codigo,nome,morada,email,freqCardiacao);
        instance.addUtilizador(profissional);

    }

    public void addUtilizadorAmador(int codigo, String nome, String morada, String email, int freqCardiaca,
                                    boolean acompanhado){
        Amadores amadores = new Amadores(acompanhado,codigo,nome,morada,email,freqCardiaca);
        instance.addUtilizador(amadores);
    }

    public void addPraticanteOcasional(int codigo, String nome, String morada, String email,int freqCardiaca,
                                       String motivacao){
        PraticantesOcasionais praticantesOcasionais = new PraticantesOcasionais(motivacao,codigo,nome,
                morada,email,freqCardiaca);
        instance.addUtilizador(praticantesOcasionais);

    }

    public Utilizadores procuraUtilizador(int codigo){
      return this.instance.retornaUtil(codigo);
    }

    public void addPlanoDeTreino(int idPlano, LocalDate date, int codUtilizador, int codAtividade){

        instance.addPlanodetreino(idPlano, date, codUtilizador, codAtividade);
    }

    public boolean existeUtilizador(int codigoUtilizador){
        return instance.existUtilizardor(codigoUtilizador);
    }

    public boolean existeAtividade(int codigoAtividade){
        return instance.existeAtividade(codigoAtividade);
    }

    public float Caloria(int MET, int codigoUtilizador, int codAtividade, int tipoAtividade){
       float resultado = 0;
       System.out.println(this.instance.calculaCalotiaAtividade(codigoUtilizador,codAtividade,MET, tipoAtividade));
       return  resultado;
    }

    public void printAtividadesUtilizador(int codigoUtilizador){
        this.instance.listarAtividadesUtilizadores(codigoUtilizador);
    }
    public void salvarEstado(){
        this.instance.salvarEstado();
    }
    public void carregarEstado() {
        this.instance.carregarEstado();
    }

}
