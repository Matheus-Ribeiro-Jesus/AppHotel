package view;

import controller.UsuariosController;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class Login extends Application {
    private boolean SenhaVisivel = false;

    @Override
    public void start(Stage stage) throws Exception {

        Image imageIcon = new Image(getClass().getResourceAsStream("/view/resources/img/logo_hotel.png"));
        Image imgSideBarLeft = new Image(getClass().getResourceAsStream("/view/resources/img/side-bar.jpg"));

        Image eyesOpen = new Image(getClass().getResourceAsStream("/view/resources/img/olho.png"));
        Image eyesClosed = new Image(getClass().getResourceAsStream("/view/resources/img/eye.png"));

        ImageView imgEyesOpen = new ImageView(eyesOpen);
        ImageView imgEyesClosed = new ImageView(eyesClosed);

        ImageView imgSideBar = new ImageView(imgSideBarLeft);
        ImageView ImageTopicon = new ImageView(imageIcon);

        BorderPane mainPane = new BorderPane();
        mainPane.setLeft(imgSideBar);

        Label lblTitulo = new Label("Bem-vindo ao Hotel Ibis");
        lblTitulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold");
        HBox tituloHbox = new HBox(10, ImageTopicon, lblTitulo);
        tituloHbox.setAlignment(Pos.CENTER);

        TextField campoEmail = new TextField();
        campoEmail.setPromptText("Digite seu e-mail");
        campoEmail.setStyle("-fx-background-color: #f4f4f4; " +
                "-fx-border-color: #d8d7d7; " +
                "-fx-border-radius: 15; " +
                "-fx-padding: 8 30 8 40; " +
                "-fx-background-image: url(/view/resources/img/o-email.png); " +
                "-fx-background-repeat: no-repeat; " +
                "-fx-background-position: left 14px center; " +
                "-fx-background-size: 19px 19px; " +
                "-fx-prompt-text-fill: #888888;");

        PasswordField campoSenha = new PasswordField();
        campoSenha.setPromptText("Digite sua senha");
        campoSenha.setStyle("-fx-background-color: #f4f4f4; " +
                "-fx-border-color: #d8d7d7; " +
                "-fx-border-radius: 15; " +
                "-fx-padding: 8 30 8 40; " +
                "-fx-prompt-text-fill: #888888;");

        Button btnSenha = new Button();
        btnSenha.setGraphic(imgEyesOpen);
        btnSenha.setStyle("-fx-background-color: transparent; -fx-cursor: hand;");
        imgEyesOpen.setFitWidth(22);
        imgEyesOpen.setFitHeight(22);

        imgEyesClosed.setFitWidth(22);
        imgEyesClosed.setFitHeight(22);

        //TextField permite a visibilidade da Senha

        TextField txtSenha = new TextField();
        txtSenha.setPromptText("Digite sua senha");
        txtSenha.setStyle("-fx-background-color: #f4f4f4; " +
                "-fx-border-color: #d8d7d7; " +
                "-fx-border-radius: 15; " +
                "-fx-padding: 8 30 8 40; " +
                "-fx-prompt-text-fill: #888888;");
        txtSenha.setVisible(false);
        txtSenha.setManaged(false);

        btnSenha.setOnAction(e -> {
            if (SenhaVisivel) {

                // Se a senha está visível, ocultar a senha
                campoSenha.setText(txtSenha.getText()); // Setar o texto no campo

                campoSenha.setVisible(true); // Exibe novamente senha (PasswordField) e o inclui no layout
                campoSenha.setManaged(true);

                txtSenha.setVisible(false); // Oculta txtSenha (TextField) e o retira do layout para não ocupar espaço
                txtSenha.setManaged(false);

                btnSenha.setGraphic(imgEyesOpen); // Troca o ícone do botão para o olho aberto

                SenhaVisivel = false; // Atualiza a variável de controle indicando que a senha não está visível
            } else {
                // Se a senha está oculta, mostrar a senha

                txtSenha.setText(campoSenha.getText()); // Seta o texto de senha (PasswordField - invisível) para txtSenha (TextField - visível)

                txtSenha.setVisible(true); // Exibe o componente txtSenha (TextoVisível) e o inclui no layout
                txtSenha.setManaged(true);

                campoSenha.setVisible(false); // Oculta o componente campoSenha (PasswordField - invisível) e o retira do layout
                campoSenha.setManaged(false);

                btnSenha.setGraphic(imgEyesClosed); // Troca o ícone do botão para o olho fechado

                SenhaVisivel = true; // Atualiza a variável de controle indicando que a senha está visível
            }
        });

        Button btnLogin = new Button("Login");
        btnLogin.setStyle("-fx-font-size: 14px; " +
                "-fx-background-radius: 30; " +
                "-fx-border-radius: 30; " +
                "-fx-font-weight: bold; " +
                "-fx-cursor: hand;" +
                "-fx-background-color: #86a7ea; " +
                "-fx-text-fill: white; " +
                "-fx-padding: 6 60 6; " +
                "-fx-border-color: transparent; " +
                "-fx-border-width: 1;");
        btnLogin.setTranslateX(-14);

        btnLogin.setOnAction(evento -> {
             String email = campoEmail.getText();
             String senha = campoSenha.isVisible() ? campoSenha.getText() : txtSenha.getText();
            UsuariosController usuariosController = new UsuariosController();
            boolean loginSucesso = usuariosController.verificarCredenciais(email, senha);
            if(loginSucesso){
                CadCliente cadCliente = new CadCliente();
                System.out.println("Login efetuado com sucesso");
                try{
                    cadCliente.start(stage);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }else{
                System.out.println("Login invalido!");
            }
        });

        // Criando o GridPane para o formulário
        GridPane formGrid = new GridPane();
        formGrid.add(campoEmail, 1, 0);
        formGrid.add(campoSenha, 1, 1);
        formGrid.add(txtSenha, 1, 1);
        formGrid.add(btnSenha, 2, 1);
        formGrid.setHgap(4);
        formGrid.setVgap(10);
        formGrid.setAlignment(Pos.CENTER);

        // Criando o layout principal

        VBox layout = new VBox(10, tituloHbox, formGrid, btnLogin);
        layout.setAlignment(Pos.CENTER);

        mainPane.setCenter(layout);

        Scene scene = new Scene(mainPane, 950, 596);
        stage.setTitle("Hotel Ibis");
        stage.getIcons().add(imageIcon);
        stage.setScene(scene);
        stage.setResizable(false); // Desabilitando a possibilidade de redimensionamento
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}