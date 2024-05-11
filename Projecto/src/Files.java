import java.io.*;
import java.io.ObjectOutputStream;

public class Files {

    public void salvarEstado(Model model) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("estado.bin"))) {
            outputStream.writeObject(model);
            System.out.println("Estado da aplicação salvo com sucesso em estado.bin");
        } catch (IOException e) {
            System.err.println("Erro ao salvar o estado da aplicação: " + e.getMessage());
        }
    }

    public Model carregarEstado() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("estado.bin"))) {
            Model model = (Model) inputStream.readObject();
            System.out.println("Estado da aplicação carregado com sucesso de estado.bin");
            return model;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao carregar o estado da aplicação: " + e.getMessage());
            return null;
        }
    }
}
