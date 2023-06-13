package view;

import controller.CarteiraController;
import model.Carteira;

public class Main {
    public static void main(String[] args) {
        Carteira carteira = new Carteira("");
        CarteiraView view = new CarteiraView();
        CarteiraController controller = new CarteiraController(carteira, view);
        controller.iniciar();
    }
}
