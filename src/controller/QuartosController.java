package controller;

import dao.QuartosDAO;
import model.Quarto;

public class QuartosController {
    private final QuartosDAO quartosDAO;

    public QuartosController() {
        this.quartosDAO = new QuartosDAO();
    }
    public boolean verificarinfoQuartos(String nome, String numero, int qtdCamaCasal, int qtdCamaSolteiro, double preco, boolean disponiveis) {
        Quarto quarto = new Quarto(nome, numero, qtdCamaCasal, qtdCamaSolteiro, preco, disponiveis);
        return quartosDAO.inserirQuartos(quarto);
    }
}
