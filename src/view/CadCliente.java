package view;
import javafx.application.Application; // Ciclo de vida da aplicação (init() start () stop() => Launch())
import javafx.geometry.Pos;
import javafx.scene.Scene; // Classe Scene: container que contem os layouts da aplicação
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox; // Um dos tipos do layout
import javafx.stage.Stage; // Classe Stage é a propria janela (incluso a barra de opções: minimizar , maximizar, fechar)
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import view.components.PainelBottons;
import view.components.Sidebar;

public class CadCliente extends Application {

    @Override
    public void start(Stage janela) throws Exception {
        Sidebar menu = new Sidebar();
        PainelBottons painel = new PainelBottons();

        //Carregar Imagens

        Image imageIcon = new Image(getClass().getResourceAsStream("/view/resources/img/logo_hotel.png"));
        Image imgUser = new Image(getClass().getResourceAsStream("/view/resources/img/blackperson24px.png"));

        // Criação de um container principal

        BorderPane mainPane = new BorderPane();
        mainPane.setLeft(menu);


        //Inserir img em container para manipular tamanho/redimensionamento.

        ImageView imgUserBlack = new ImageView(imgUser);

        //Titulo
        Label lblTitulo = new Label("Cadastro de Clientes");
        lblTitulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold");
        HBox tituloHBox = new HBox(10, imgUserBlack, lblTitulo);
        tituloHBox.setAlignment(Pos.CENTER);

        //Campos para preenchimento
        Label pergunteNome = new Label("Nome");
        TextField campoNome = new TextField();


        Label pergunteEmail = new Label("E-mail");
        TextField campoEmail = new TextField();

        ComboBox<String>boxemail = new ComboBox<>();
        boxemail.getItems().addAll("@gmail.com", "@outlook.com", "@icloud.com");
        boxemail.setPromptText("Selecione: ");

        Label perguntecpf = new Label("CPF");
        TextField campocpf = criarMascara("###.###.###-##");

        Label pergunteTelefone = new Label("Telefone");
        TextField campoTelefone = criarMascara("(##) ####-####");

        GridPane formGrid = new GridPane();
        formGrid.add(pergunteNome, 0, 0);
        formGrid.add(campoNome, 1, 0);
        formGrid.add(perguntecpf, 0, 1);
        formGrid.add(campocpf, 1, 1);
        formGrid.add(pergunteEmail, 0, 2);
        formGrid.add(boxemail, 2, 2);
        formGrid.add(campoEmail, 1, 2);
        formGrid.add(pergunteTelefone, 0, 3);
        formGrid.add(campoTelefone, 1, 3);

        formGrid.setHgap(10);
        formGrid.setVgap(10);
        formGrid.setAlignment(Pos.CENTER);


        VBox layout = new VBox(10, tituloHBox, formGrid, painel);

        layout.setAlignment(Pos.CENTER);

        mainPane.setCenter(layout); //Adicionada nova linha

        Scene scene = new Scene(mainPane, 700, 500);
        janela.setTitle("Hotel Ibis");

        janela.getIcons().add(imageIcon);
        janela.setScene(scene);
        janela.setResizable(false);
        janela.show();
    }

    //Metodo para criar um campo de texto com mascara

    private TextField criarMascara(String mascara){
        TextField txtMascara = new TextField();
        txtMascara.textProperty().addListener((observable, oldValue, newValue) ->
                
        {
            String value = newValue.replaceAll("[^0-9,]", "");
            StringBuilder formatacaoCampo = new StringBuilder();

            int index = 0;


            for (char caracter : mascara.toCharArray()) {
                if (caracter == '#'){

                    if(index < value.length()){
                        formatacaoCampo.append(value.charAt(index));
                        index++;
                    }
                    else{
                        break;
                    }
                }
                else{
                    formatacaoCampo.append(caracter);
                }
            }
                txtMascara.setText(formatacaoCampo.toString());
        });
        return txtMascara;
    }
    public static void main(String[] args) {
        launch(args);
    }
}
