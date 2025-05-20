package view;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import view.components.PainelBottons;
import view.components.Sidebar;

public class CadUsuario extends Application {

    @Override
    public void start(Stage janela) throws Exception {
        Sidebar menu = new Sidebar();
        PainelBottons painelBottons = new PainelBottons();

        Image imageIcon = new Image(getClass().getResourceAsStream("/view/resources/img/LogoHotel.png"));
        Image mainImg = new Image(getClass().getResourceAsStream("/view/resources/img/blackperson24px.png"));


        BorderPane mainPane = new BorderPane();
        mainPane.setLeft(menu);

        ImageView imgUserBlack = new ImageView(mainImg);

        Label lblTituloUser = new Label("Cadastro de Usuario");
        lblTituloUser.setStyle("-fx-font-size: 18px; -fx-font-weight: bold");
        HBox tituloHBox = new HBox(10, imgUserBlack, lblTituloUser);
        tituloHBox.setAlignment(Pos.CENTER);


        //Campos para preenchimento
        Label lblNome = new Label("Nome do funcionario");
        TextField campoNome = new TextField();

        Label lblSenha = new Label("Senha: ");
        TextField campoSenha = new TextField();

        Label lblEmail = new Label("E-mail");
        TextField campoEmail = new TextField();

        ComboBox<String>boxemail = new ComboBox<>();
        boxemail.getItems().addAll("@gmail.com", "@outlook.com", "@icloud.com");
        boxemail.setPromptText("Selecione: ");

        Label lblsetor = new Label("Cargo");
        TextField campoSetor = new TextField();

        ComboBox<String>cargoname = new ComboBox<>();
        cargoname.getItems().addAll("Administrador", "Funcionario", "Atendente");
        cargoname.setPromptText("Selecione: ");

        GridPane formgrid = new GridPane();
        formgrid.add(lblNome, 0,0);
        formgrid.add(campoNome, 1, 0);
        formgrid.add(boxemail, 2,1);
        formgrid.add(lblEmail, 0,1);
        formgrid.add(campoEmail, 1, 1);
        formgrid.add(cargoname, 2,2);
        formgrid.add(lblsetor, 0,2);
        formgrid.add(campoSetor, 1, 2);
        formgrid.add(lblSenha, 0,3);
        formgrid.add(campoSenha, 1, 3);

        formgrid.setHgap(10);
        formgrid.setVgap(10);
        formgrid.setAlignment(Pos.CENTER);

        VBox layout = new VBox(10, tituloHBox, formgrid, painelBottons);

        layout.setAlignment(Pos.CENTER);
        mainPane.setCenter(layout);


        Scene scene = new Scene(mainPane, 700, 500);
        janela.getIcons().add(imageIcon);
        janela.setTitle("Hotel Ibis");
        janela.setScene(scene);
        janela.setResizable(false);
        janela.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
