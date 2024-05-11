import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Utilizadores implements Serializable {
    private int codigo;
    private String nome;
    private String morada;
    private String email;
    private int frequenciaCardiacaMedia;
    private Map<Integer, Atividade> atividades;

    public  Utilizadores(){
        this.codigo = 0;
        this.nome = "";
        this.morada = "";
        this.email = "";
        this.frequenciaCardiacaMedia = 0;
        this.atividades = new HashMap<Integer, Atividade>();
    }
    public Utilizadores(Utilizadores u){
        this.codigo = u.getCodigo();
        this.nome = u.getNome();
        this.morada = u.getMorada();
        this.email = u.getEmail();
        this.frequenciaCardiacaMedia = u.getFrequenciaCardiacaMedia();
        this.atividades = u.getAtividades();
    }

    public Utilizadores(int codigo, String nome, String morada, String email, int frequenciaCardiacaMedia) {
        this.codigo = codigo;
        this.nome = nome;
        this.morada = morada;
        this.email = email;
        this.frequenciaCardiacaMedia = frequenciaCardiacaMedia;
        this.atividades = new HashMap<>();
    }

    /*GETS*/
    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getMorada() {
        return morada;
    }
    public String getEmail() {
        return email;
    }
    public int getFrequenciaCardiacaMedia() {
        return frequenciaCardiacaMedia;
    }

    public Map<Integer, Atividade> getAtividades() {
        return this.atividades.values().stream().collect(Collectors.toMap(a->a.getCodigo(), a->a.clone()));
    }

    /*SETS*/

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFrequenciaCardiacaMedia(int frequenciaCardiacaMedia) {
        this.frequenciaCardiacaMedia = frequenciaCardiacaMedia;
    }

    public void setAtividades(Map<Integer, Atividade> atividades) {
       this.atividades = this.atividades.values().stream().map(Atividade::clone).collect(Collectors.toMap(a->a.getCodigo(),a-> a.clone()));
    }

    /*TOSTRING*/

    @Override
    public String toString() {
        return "Utilizador{" +
                "Codigo:: " + codigo +
                ", Nome:: '" + nome + '\'' +
                ", Morada= ::'" + morada + '\'' +
                ", Email ::'" + email + '\'' +
                ", Media de Frequencia Cardiaca ::" + frequenciaCardiacaMedia
                + " Lista de atividades::" +this.atividades.toString() +
                '}';
    }

    /*EQUALS*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utilizadores that = (Utilizadores) o;
        return this.codigo == that.getCodigo() && this.frequenciaCardiacaMedia == that.getFrequenciaCardiacaMedia() && that.nome.equals(this.nome) &&
                that.morada.equals(this.morada) && that.email.equals(this.email);
    }

    /*CLONE*/
    public Utilizadores clone(){ return new Utilizadores(this);}

    public void adicionaAtividade(Atividade atividade){
        this.atividades.put(atividade.getCodigo(), atividade);
    }

    public Atividade retornaAtividade(int codigo){
        return this.atividades.get(codigo);
    }

    public void printAtividade(){
        System.out.println(this.atividades.values().toString());
    }
}
