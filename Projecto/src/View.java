import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;

public class View implements Serializable {
    private Scanner entrada = new Scanner(System.in);
    private int codigo;
    private String nome;

    public void run(Controler controler) {
        Scanner input = new Scanner(System.in);
        int option = -1;
        while (option != 0) {
            Menu();
            option = input.nextInt();
            switch (option) {
                case 0:
                    option = 0;
                    break;
                case 1:
                    option = 1;
                    InsiraAtividades(controler);
                    break;
                case 2:
                    option = 2;
                    InsiraUtilizador(controler);
                    break;
                case 3:
                    option = 3;
                    calculoCalorico(controler);
                    break;
                case 4:
                    option = 4;
                    InsiraPlanoDeTreiro(controler);
                    break;
                case 5:
                    option = 5;
                    listarAtividade(controler);
                    break;
                case 6:
                    option = 6;
                    salvarEstado(controler);
                    break;
                case 7:
                    option = 7;
                    carregarEstado(controler);
                    break;
                default:
                    System.out.println("Opção errada!!!");

            }
        }
        System.out.println("\n End of the line");
    }

    private void Menu(){
        System.out.println("                    MENU                                  ");
        System.out.println(" 1 - Insira Atividades");
        System.out.println(" 2 - Insira Utilizador");
        System.out.println(" 3 - Calculo de Parametros caloricos");
        System.out.println(" 4 - Insira Plano de Treiro");
        System.out.println(" 5 - Listar as atividades feitas por um Utilizadador");
        System.out.println(" 6 - Gravar");
        System.out.println(" 7 - Carregar");
        System.out.println(" 0 - Sair");

        System.out.println("\n Insira a Opção::");
    }

    private void menuUtilizadors() {
        System.out.println("\n Que tipo de Utilizador? ");
        System.out.println("1 - Profissional");
        System.out.println("2 - Amador");
        System.out.println("3 - Praticante Ocasional");

    }

    private void menuAtividades() {
            System.out.println("\n Que tipo de Atividade? ");
            System.out.println("1 - Levantamento de Pesos");
            System.out.println("2 - Abdominais");
            System.out.println("3 - Bicicleta de estrada");
            System.out.println("4 - Remo");
    }

    private void menuTreino() {

    }

    private void InsiraAtividades(Controler controler){
        int codigo, opcao = -1, altitude = -1, codigoUtilizador;
        String nome,  dificuldade, tipo, condicoesClimaticas;
        float distancia;
        float potencia, freqCardiaca;
        int repticoes, pesos,  tempo, nSets;
        menuAtividades();
        System.out.println("\n Tipo de Atividade: ");
        opcao = entrada.nextInt();
        System.out.println("\n Codigo do Utilizado: ");
        codigoUtilizador = entrada.nextInt();
        System.out.println("\n Informe o codigo do tipo de Atividade: ");
        codigo = entrada.nextInt();
        System.out.println("\n Informe o nome do tipo de Atividade: ");
        nome = entrada.next();
        System.out.println("\n Informe a dificuldade: ");
        dificuldade = entrada.next();

        switch (opcao) {
            case 1:
                System.out.println("\n O numero de reptições: ");
                repticoes = entrada.nextInt();
                System.out.println("\n O numero de pesos: ");
                pesos = entrada.nextInt();
                System.out.println("\n O tempo: ");
                tempo = entrada.nextInt();
                System.out.println("\n O número de Sets: ");
                nSets = entrada.nextInt();
                System.out.println("\n O Tipo de Peso: ");
                tipo = entrada.next();
                controler.addAtividadePesos(codigoUtilizador, codigo,nome,dificuldade, tipo,repticoes, tempo,nSets, pesos);
                break;
            case 2:
                System.out.println("\n O numero de reptições: ");
                repticoes = entrada.nextInt();
                System.out.println("\n O tempo: ");
                tempo = entrada.nextInt();
                System.out.println("\n O número de Sets: ");
                nSets = entrada.nextInt();
                System.out.println("\n O sitio do Abdominal: ");
                tipo = entrada.next();
                controler.addAtividadeAbdominal(codigoUtilizador, codigo,nome,dificuldade, tipo,repticoes, tempo,nSets);
                break;
                case 3:
                    System.out.println("Potencia da bicicleta: ");
                    potencia = entrada.nextFloat();
                    System.out.println("Freqencia cardiaca: ");
                    freqCardiaca = entrada.nextFloat();
                    System.out.println("\n A distancia da pecorrida: ");
                    distancia = entrada.nextFloat();
                    System.out.println("\n Altitude da pecorrida: ");
                    altitude = entrada.nextInt();
                    System.out.println("\n Tempo decorrido: ");
                    tempo = entrada.nextInt();
                    controler.addAtividadeBicicletaEstrada(codigoUtilizador,potencia,freqCardiaca,distancia, tempo, altitude,
                            codigo, nome, dificuldade);
                    break;
                    case 4:
                        System.out.println("\n Condições climatericas: ");
                        condicoesClimaticas = entrada.nextLine();
                        System.out.println("\n A distancia da pecorrida: ");
                        distancia = entrada.nextFloat();
                        System.out.println("\n Altitude da pecorrida: ");
                        altitude = entrada.nextInt();
                        System.out.println("\n Tempo decorrido: ");
                        tempo = entrada.nextInt();
                        controler.addAtividadeRemo(codigoUtilizador, codigo, nome, dificuldade,condicoesClimaticas,
                                distancia,altitude, tempo);
                        break;
            default:
                System.out.println("Opcao invalida!!!");
        }


    }

    private void InsiraUtilizador(Controler controler){
        int option = -1, codigo = 0, freqCardiacao = 0, numeroClube = 0;
        String nome, morada, email, clube, motivacao;
        Boolean acompanhado = false;

        menuUtilizadors();
        option = entrada.nextInt();
        System.out.println("Digite o codigo do utilizador: ");
        codigo = entrada.nextInt();
        System.out.println("Digite o nome do utilizador: ");
        nome = entrada.next();
        System.out.println("Digite o morada do utilizador: ");
        morada = entrada.next();
        System.out.println("Digite o email do utilizador: ");
        email = entrada.next();
        switch (option) {
            case 1:
                System.out.println("Digite o clube do utilizador: ");
                clube = entrada.next();
                System.out.println("Digite o numero do Atleta do utilizador: ");
                numeroClube = entrada.nextInt();
                controler.addUtilizadorProfissional(codigo,nome,morada,email,freqCardiacao,clube,numeroClube);
                break;
            case 2:
                System.out.println("Digite tem treinador?: ");
                acompanhado = entrada.nextBoolean();
                controler.addUtilizadorAmador(codigo,nome,morada,email,freqCardiacao,acompanhado);
                break;
            case 3:
                System.out.println("Digite o motivacao do utilizador: ");
                motivacao = entrada.next();
                controler.addPraticanteOcasional(codigo,nome,morada,email,freqCardiacao,motivacao);
                break;
            default:
                System.out.println("Opcao invalida!!!");
        }
    }

    private void InsiraTreino(Controler controler){


    }
    private void InsiraPlanoDeTreiro(Controler controler){
            int idPlanoDeTreino=0, codigoUtilizador, codAtividade;
            LocalDate date;
            System.out.println("Insira o codigo do Utilizador");
            codigoUtilizador = entrada.nextInt();
            System.out.println("Insira o codigo da atividade");
            codAtividade = entrada.nextInt();

            if (controler.existeUtilizador(codigoUtilizador) && controler.existeUtilizador(codAtividade)){
                System.out.println("Insira o numero do plano de treino");
                idPlanoDeTreino = entrada.nextInt();
                System.out.println("Insira a data para o treino");
                date = LocalDate.parse(entrada.next());
                controler.addPlanoDeTreino(idPlanoDeTreino, date, codigoUtilizador,codAtividade);
            }


    }

    private void calculoCalorico(Controler controler){
        int codAtividade, codUtilizador, op, tipo;
        float caloria =0;
        System.out.println("Insira a sua categoria");
        System.out.println("1 - Profissional");
        System.out.println("2 - Amador");
        System.out.println("3 - Praticante Ocasional");
        op = entrada.nextInt();
        System.out.println("Insira a sua categoria");
        System.out.println("1 - Remo");
        System.out.println("2 - Bicicleta de Estrada");
        System.out.println("3 - Abdominais");
        System.out.println("4 - Levantamento de Pesos");
        System.out.println("Insira o tipo de Atividade");
        tipo = entrada.nextInt();
        System.out.println("Insira codigo do Utilizador");
        codUtilizador = entrada.nextInt();
        if (controler.existeUtilizador(codUtilizador)){
            System.out.println("Insira o codigo da Ativadade feita");
            codAtividade = entrada.nextInt();
            if (controler.existeAtividade(codAtividade)){
                switch (op){
                    case 1:
                        controler.Caloria(100,codUtilizador,codAtividade, tipo);
                        System.out.println("Gastou " + caloria +" calorias.");
                        break;
                    case 2:
                        System.out.println("Gastou " + controler.Caloria(50,codUtilizador,codAtividade,tipo) +" calorias.");
                        break;
                    case 3:
                        System.out.println("Gastou " + controler.Caloria(25, codUtilizador,codAtividade, tipo) +" calorias.");
                        break;
                    default:
                        System.out.println("Opcção errada");
                }
            } else System.out.println("Não existe Atividade");
        }else System.out.println("Não existe utilizador");
    }

    private void listarAtividade(Controler controler){
        int codUtilizador;

        System.out.println("Insira codigo do Utilizador");
        codUtilizador = entrada.nextInt();
        if (controler.existeUtilizador(codUtilizador)){
            controler.printAtividadesUtilizador(codUtilizador);
        }else {
            System.out.println("Nao existe o Utilizador");
        }
    }
    private void salvarEstado(Controler controler){

        controler.salvarEstado(); //
    }
    private void carregarEstado(Controler controler){

        controler.carregarEstado();
    }

}
