package larionov.menu.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
@Getter
@Setter
public class Menu {
    private List<Pizza> pizzeMenu;
    private List<Bevande> bevandeMenu;
    private List<Condimenti> condimenti;

    public Menu() {
        this.pizzeMenu = new ArrayList<>();
        this.bevandeMenu = new ArrayList<>();
        this.condimenti = new ArrayList<>();
    }

    public void aggiungiPizzaAlMenu(Pizza pizza) {
        this.pizzeMenu.add(pizza);
    }

    public void aggiungiBevandaAlMenu(Bevande bevanda) {
        this.bevandeMenu.add(bevanda);
    }

    public void aggiungiCondimentoAlMenu(Condimenti condimento){
        this.condimenti.add(condimento);
    }

    @Override
    public String toString() {
        return ":::::::::::::::::::::::................Menu................:::::::::::::::::::::::\n"
                + ".......:::::::Le Nostre Pizze:::::::.......\n" +
                pizzeMenu +
                "\n......:::::::Le Nostre Bevande:::::::......\n"
                + bevandeMenu +
                "\n.........:::::::Condimenti:::::::..........\n"
                + condimenti +
                '}';
    }
}
