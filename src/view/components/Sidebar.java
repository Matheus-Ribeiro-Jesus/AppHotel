package view.components;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class Sidebar extends VBox {
    public Button btnCliente = new Button("Cliente");
    public Button btnFuncionario = new Button("Funcionario");
    public Button btnQuartos = new Button("Quartos");
    public Button btnReservas = new Button("Reservas");
    public Button btnRelatorios = new Button("Relatórios");

    public Sidebar() {


        //Lista de Icons
        Image iconCliente = new Image(getClass().getResourceAsStream("/view/resources/img/icon-cliente.png"));
        Image iconFuncionario = new Image(getClass().getResourceAsStream("/view/resources/img/icon-funcionario.png"));
        Image iconQuarto = new Image(getClass().getResourceAsStream("/view/resources/img/icon-quarto.png"));
        Image iconRelatorio = new Image(getClass().getResourceAsStream("/view/resources/img/icon-relatorio.png"));
        Image iconReserva = new Image(getClass().getResourceAsStream("/view/resources/img/icon-reserva.png"));


        // Carregamento das fonts

        Font fonteNegrito = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/LeagueSpartan-Bold.ttf"), 15);
        Font fonteRegular = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/LeagueSpartan-Regular.ttf"), 14);


        ImageView viewIconCliente = new ImageView(iconCliente);
        viewIconCliente.setFitWidth(20);
        viewIconCliente.setFitHeight(20);

        ImageView viewIconFuncionario = new ImageView(iconFuncionario);
        viewIconFuncionario.setFitWidth(20);
        viewIconFuncionario.setFitHeight(20);

        ImageView viewIconQuarto = new ImageView(iconQuarto);
        viewIconQuarto.setFitWidth(20);
        viewIconQuarto.setFitHeight(20);

        ImageView viewIconRelatorio = new ImageView(iconRelatorio);
        viewIconRelatorio.setFitWidth(20);
        viewIconRelatorio.setFitHeight(20);

        ImageView viewIconReserva = new ImageView(iconReserva);
        viewIconReserva.setFitWidth(20);
        viewIconReserva.setFitHeight(20);

        btnCliente.setGraphic(viewIconCliente);
        btnFuncionario.setGraphic(viewIconFuncionario);
        btnQuartos.setGraphic(viewIconQuarto);
        btnReservas.setGraphic(viewIconRelatorio);
        btnRelatorios.setGraphic(viewIconReserva);

        Label lblMenu = new Label("Gran Hotel");
        lblMenu.setStyle("-fx-text-fill: #a87e08; ");
        setStyle("-fx-background-color: #ffffff; -fx-padding: 40px; -fx-spacing: 12px; -fx-font-family: " + fonteNegrito.getFamily() + ";"
        );

        //Estilização dos botoões (fundo e borda transparent)

        String styleButton = "-fx-background-color: transparent; " + "-fx-border-color: transparent; " + "-fx-graphic-text-gap: 10px; -fx-alignment: center;" + "-fx-cursor: hand;";

        btnCliente.setStyle(styleButton);
        btnFuncionario.setStyle(styleButton);
        btnQuartos.setStyle(styleButton);
        btnReservas.setStyle(styleButton);
        btnRelatorios.setStyle(styleButton);

        //Objetivo: ao passar o mouse, passar o fundo do botao para uma cor que desejar

        btnCliente.setOnMouseEntered(evento ->
                btnCliente.setStyle(styleButton.replace("transparent", "#D6C388FF")));
        btnCliente.setOnMouseExited(evento -> btnCliente.setStyle(styleButton));

        btnFuncionario.setOnMouseEntered(evento ->
                btnFuncionario.setStyle(styleButton.replace("transparent", "#D6C388FF")));
        btnFuncionario.setOnMouseExited(evento -> btnFuncionario.setStyle(styleButton));

        btnQuartos.setOnMouseEntered(evento ->
                btnQuartos.setStyle(styleButton.replace("transparent", "#D6C388FF")));
        btnQuartos.setOnMouseExited(evento -> btnQuartos.setStyle(styleButton));

        btnReservas.setOnMouseEntered(evento ->
                btnReservas.setStyle(styleButton.replace("transparent", "#D6C388FF")));
        btnReservas.setOnMouseExited(evento -> btnReservas.setStyle(styleButton));

        btnRelatorios.setOnMouseEntered(evento ->
                btnRelatorios.setStyle(styleButton.replace("transparent", "#D6C388FF")));
        btnRelatorios.setOnMouseExited(evento -> btnRelatorios.setStyle(styleButton));


        setMargin(lblMenu, new Insets(0, 0, 20, 0)); //superior, direita, inferior, esquerda

        lblMenu.setFont(Font.font(fonteNegrito.getFamily(), 25));

        getChildren().addAll(lblMenu, btnCliente, btnFuncionario, btnQuartos, btnReservas, btnRelatorios);
    }
}
