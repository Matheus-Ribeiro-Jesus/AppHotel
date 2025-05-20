package view.components;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class PainelBottons extends HBox {

    public PainelBottons() {

        Image iconBtnCad = new Image(getClass().getResourceAsStream("/view/resources/img/plus48px.png"));
        Image iconBtnUp = new Image(getClass().getResourceAsStream("/view/resources/img/update48px.png"));
        Image iconBtnDel = new Image(getClass().getResourceAsStream("/view/resources/img/delete48px.png"));

        //Inserir img em container para manipular tamanho/redimensionamento.

        ImageView icon = new ImageView(iconBtnCad);
        icon.setFitWidth(20); // Definição de largura
        icon.setFitHeight(20); // Definição de altura

        ImageView iconUp = new ImageView(iconBtnUp);
        iconUp.setFitWidth(20);
        iconUp.setFitHeight(20);

        ImageView iconDel = new ImageView(iconBtnDel);
        iconDel.setFitWidth(20);
        iconDel.setFitHeight(20);

        //Area dos Botões
        Button btnCadastrar = new Button("Cadastrar", icon);
        btnCadastrar.setStyle("-fx-background-color: transparent; -fx-font-weight: bold");

        Button btnAtualizar = new Button("Atualizar", iconUp);
        btnAtualizar.setStyle("-fx-background-color: transparent; -fx-font-weight: bold");

        Button btnExcluir = new Button("Excluir", iconDel);
        btnExcluir.setStyle("-fx-background-color: transparent; -fx-font-weight: bold");

        String styleButton = "-fx-background-color: transparent; " + "-fx-border-color: transparent; " + "-fx-graphic-text-gap: 10px; -fx-alignment: center;" + "-fx-cursor: hand;";

        btnCadastrar.setStyle(styleButton);
        btnAtualizar.setStyle(styleButton);
        btnExcluir.setStyle(styleButton);


        btnCadastrar.setOnMouseEntered(evento ->
                btnCadastrar.setStyle(styleButton.replace("transparent", "#87CEFA")));
        btnCadastrar.setOnMouseExited(evento -> btnCadastrar.setStyle(styleButton));

        btnAtualizar.setOnMouseEntered(evento ->
                btnAtualizar.setStyle(styleButton.replace("transparent", "#40E0D0")));
        btnAtualizar.setOnMouseExited(evento -> btnAtualizar.setStyle(styleButton));

        btnExcluir.setOnMouseEntered(evento ->
                btnExcluir.setStyle(styleButton.replace("transparent", "#FF6347")));
        btnExcluir.setOnMouseExited(evento -> btnExcluir.setStyle(styleButton));




        btnCadastrar.setGraphic(icon);
        btnAtualizar.setGraphic(iconUp);
        btnExcluir.setGraphic(iconDel);

        setAlignment(Pos.CENTER);
        getChildren().addAll(btnCadastrar, btnAtualizar, btnExcluir);

    }
}
