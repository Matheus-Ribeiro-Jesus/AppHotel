package controller;

import dao.QuartosDAO;
import model.Quarto;

public class QuartosController {
    private final QuartosDAO quartosDAO;

    public QuartosController() {
        this.quartosDAO = new QuartosDAO();
    }
    public void verificarinfoQuartos(String nome, String numero, int qtdCamaCasal, int qtdCamaSolteiro, double preco, boolean disponiveis) {
        Quarto quartos = new Quarto(nome, numero, qtdCamaCasal, qtdCamaSolteiro, preco, disponiveis);
        quartosDAO.inserirQuartos(quartos);
    }
}
