import java.io.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class Model implements Serializable {
    private Map<Integer, Utilizadores> utilizadores;
    private Map<Integer, Atividade> atividades;
    private Map<Integer, Planodetreino> planodetreinos;

    public Model() {
        this.utilizadores = new HashMap<>();
        this.atividades = new HashMap<>();
        this.planodetreinos = new HashMap<>();
    }

    public Model(Map<Integer, Utilizadores> utilizadores, Map<Integer, Atividade> atividades, Map<Integer, Planodetreino> planodetreinos){
        this.utilizadores = utilizadores.values().stream().collect(Collectors.toMap(num->num.getCodigo(), num-> num));
        this.atividades = atividades.values().stream().collect(Collectors.toMap(num->num.getCodigo(), num-> num));
        this.planodetreinos =  planodetreinos.values().stream().collect(Collectors.toMap(num->num.getIdPlanodetreino(), num-> num));
    }

    public Model(Model m){
        this.utilizadores = m.getUtilizadores();
        this.atividades = m.getAtividades();
        this.planodetreinos = m.getPlanodetreinos();
    }

    public Map<Integer, Utilizadores> getUtilizadores() {

        return this.utilizadores.values().stream().collect(Collectors.toMap(a->a.getCodigo(), a->a.clone()));
    }
    public void setUtilizadores(Map<Integer, Utilizadores> utilizadores) {

        this.utilizadores = utilizadores.values().stream().map(Utilizadores::clone).collect(Collectors.toMap(a->a.getCodigo(), a-> a.clone()));
    }
    public Map<Integer, Atividade> getAtividades() {

        return this.atividades.values().stream().collect(Collectors.toMap(a->a.getCodigo(), a->a.clone()));
    }
    public void setAtividades(Map<Integer, Atividade> atividades) {
        this.atividades = atividades.values().stream().map(Atividade::clone).collect(Collectors.toMap(a->a.getCodigo(), a-> a.clone()));
    }
    public Map<Integer, Planodetreino> getPlanodetreinos() {

        return this.planodetreinos.values().stream().collect(Collectors.toMap(a->a.getIdPlanodetreino(), a->a.clone()));
    }
    public void setPlanodetreinos( Map<Integer, Planodetreino> planodetreinos ){
        this.planodetreinos = planodetreinos.values().stream().map(Planodetreino::clone).collect(Collectors.toMap(a->a.getIdPlanodetreino(),a-> a.clone()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Model model = (Model) o;
        return Objects.equals(utilizadores, model.utilizadores) && Objects.equals(atividades, model.atividades) && Objects.equals(planodetreinos, model.planodetreinos);
    }

    @Override
    public String toString() {
        return "Model{" +
                "utilizadores=" + utilizadores +
                ", atividades=" + atividades +
                ", planodetreinos=" + planodetreinos +
                '}';
    }
    public Model clone(){
        return new Model(this);
    }

    public void addUtilizador(Utilizadores utilizador){
        this.utilizadores.put(utilizador.getCodigo(), utilizador);
    }
    public void addAtividade(int codigoUtilizador,Atividade atividade){

        if(this.utilizadores.containsKey(codigoUtilizador)){
            this.utilizadores.get(codigoUtilizador).adicionaAtividade(atividade);
        }
        this.atividades.put(atividade.getCodigo(), atividade);
    }

    public Utilizadores retornaUtil(int codigo){
        Utilizadores utilizador = new Utilizadores();
        if (this.utilizadores.containsKey(codigo)){

        }
        return utilizador;
    }

    public boolean existUtilizardor(int codigo){
        return this.utilizadores.containsKey(codigo);
    }

    public boolean existeAtividade(int codigo){
        return this.atividades.containsKey(codigo);
    }

    public Atividade retornaAtividade(int cod){
        Atividade act = new Atividade(this.atividades.get(cod));
        return act;
    }

    public Utilizadores retornaUtilizador(int cod){
         Utilizadores util = new Utilizadores (this.utilizadores.get(cod));
         return util;
    }

    public void addPlanodetreino(int idPlano, LocalDate date, int codUtilizador, int codAtividade){
        Atividade atividade = new Atividade(retornaAtividade(codAtividade));
        Utilizadores utilizadores1 = new Utilizadores(retornaUtilizador(codUtilizador));
        Planodetreino p = new Planodetreino();
        p.setIdPlanodetreino(idPlano);
        p.setDataTreino(date);
        p.setUtilizador(utilizadores1);
        p.addAtividade(atividade);
        this.planodetreinos.put(p.getIdPlanodetreino(),p);
    }

    public float calculaCalotiaAtividade(int codUtilzador, int codAtividade, int MET, int tipoAtividade){
        float calotia = 0, peso, freqCariaca;
        Atividade atividadeCaloria = new Atividade(this.utilizadores.get(codUtilzador).retornaAtividade(codAtividade));

        if (tipoAtividade==1){
            Remo remo = new Remo((Remo) atividadeCaloria);
            calotia = remo.calcularCaloriasRemo(MET, utilizadores.get(codUtilzador).getFrequenciaCardiacaMedia());

        }else if(tipoAtividade == 2){
            BicicletaDeEstrada bicicletaDeEstrada = new BicicletaDeEstrada((BicicletaDeEstrada) atividadeCaloria);
            calotia = bicicletaDeEstrada.calcularCaloriasBicicletaEstrada(MET);

        } else if (tipoAtividade == 3) {
            Abdominais abdominais = new Abdominais((Abdominais) atividadeCaloria);
            calotia = abdominais.calcularCaloriasAbdominais(MET, abdominais.getRepeticoes());

        } else if (tipoAtividade == 4) {
            LevantamentoDePesos levantamentoDePesos = new LevantamentoDePesos((LevantamentoDePesos) atividadeCaloria);
            calotia = levantamentoDePesos.calcularCaloriasLevatamentoPeso(MET, ((LevantamentoDePesos) atividadeCaloria).getPesos());
        }

        return calotia;
    }

    public void listarAtividadesUtilizadores(int codigoUtilizador){
        Optional<Utilizadores> valor = utilizadores.entrySet().stream()
                .filter(entry -> entry.getKey().equals(codigoUtilizador))
                .map(Map.Entry::getValue)
                .findFirst();
        valor.toString();
    }
    public void salvarEstado() {
        Files nomedeficheiro = new Files();
        nomedeficheiro.salvarEstado(this);
    }

    public void carregarEstado() {
        Files nomedeficheiro = new Files();
        Model model = nomedeficheiro.carregarEstado();
        if (model != null) {
            this.utilizadores = model.getUtilizadores();
            this.atividades = model.getAtividades();
            this.planodetreinos = model.getPlanodetreinos();
        }
    }
}
