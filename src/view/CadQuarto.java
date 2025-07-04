package view;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.components.PainelBottons;
import view.components.Sidebar;

public class CadQuarto extends Application {

    @Override
    public void start(Stage janela) throws Exception {
        Sidebar menu = new Sidebar();
        PainelBottons painelBottons = new PainelBottons();

        Image imageIcon = new Image(getClass().getResourceAsStream("/view/resources/img/LogoHotel.png"));
        Image mainImg = new Image(getClass().getResourceAsStream("/view/resources/img/blackperson24px.png"));


        BorderPane mainPane = new BorderPane();
        mainPane.setLeft(menu);

        ImageView imgUserBlack = new ImageView(mainImg);

        Label lblTitulo = new Label("Cadastro de Quartos");
        lblTitulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold ");
        HBox tituloBox = new HBox(10, imgUserBlack, lblTitulo);
        tituloBox.setAlignment(Pos.CENTER);


        Label lblNome = new Label("Nome: ");
        TextField campoNome = new TextField();

        Label lblPreco = new Label("Preço: ");
        TextField campoPreco = criarMascara("R$ #######");

        Label lblCamaCasal = new Label("Cama de Casal: ");
        Spinner<Integer> qtdCamaCasal = new Spinner (0,10,1);

        Label lblCamaSolteiro = new Label("Cama de Solteiro: ");
        Spinner<Integer> qtdCamaSolteiro = new Spinner(0, 10, 1);

        Label lblNumero = new Label("Numero: ");
        TextField campoNumero = new TextField();

        Label lblDisponivel = new Label("Disponivel: ");
        ComboBox<String> campoDisponivel = new ComboBox<>();
        campoDisponivel.getItems().addAll("Disponivel", "Indisponivel");

        GridPane formgrid = new GridPane();

        formgrid.add(lblNome, 0, 0);
        formgrid.add(campoNome, 1, 0);
        formgrid.add(lblPreco, 0, 1);
        formgrid.add(campoPreco, 1, 1);
        formgrid.add(lblCamaCasal, 0, 2);
        formgrid.add(qtdCamaCasal, 1, 2);
        formgrid.add(lblCamaSolteiro, 0, 3);
        formgrid.add(qtdCamaSolteiro, 1, 3);
        formgrid.add(lblNumero, 0, 4);
        formgrid.add(campoNumero, 1, 4);
        formgrid.add(lblDisponivel, 0, 5);
        formgrid.add(campoDisponivel, 1, 5);

        formgrid.setHgap(10);
        formgrid.setVgap(10);
        formgrid.setAlignment(Pos.CENTER);


        painelBottons.btnCadastrar.setOnAction(e -> {
            String nome = campoNome.getText();
            String numero = campoNumero.getText();
            double preco = Double.parseDouble(campoPreco.getText());
            int camaCasal = qtdCamaCasal.getValue();
            int solteiro = qtdCamaSolteiro.getValue();
            String disponivel = (String) campoDisponivel.getSelectionModel().getSelectedItem();

            Boolean isDisponivel;

            if(disponivel.equals("Disponivel")){
                isDisponivel = true;
            }else{
                isDisponivel = false;
            }
        });


        VBox layout = new VBox(10, tituloBox, formgrid, painelBottons);
        layout.setAlignment(Pos.CENTER);
        mainPane.setCenter(layout);

        Scene scene = new Scene(mainPane, 700, 500);
        janela.setScene(scene);
        janela.setTitle("Hotel Ibis");
        janela.getIcons().add(imageIcon);
        janela.setResizable(false);
        janela.show();
    }

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
