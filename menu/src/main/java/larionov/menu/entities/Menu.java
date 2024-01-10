package larionov.menu.entities;

import larionov.menu.MenuApplication;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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

    public Menu(@Qualifier("pizze") List<Pizza> pizzeMenu, @Qualifier("bevande") List<Bevande> bevandeMenu, @Qualifier("condimenti") List<Condimenti> condimenti) {
        this.pizzeMenu = pizzeMenu;
        this.bevandeMenu = bevandeMenu;
        this.condimenti = condimenti;
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


    public static void tutteLePizzeDisponibili() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MenuApplication.class);
        System.out.println("....................:::::::::::::LE NOSTRE PIZZE:::::::::::::....................");
        List<Pizza> pizzeList = ctx.getBean("pizze", List.class);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pizzeList.size(); i++) {
            Pizza pizza = pizzeList.get(i);
            sb.append(i + 1).append(". ").append(pizza.toString());
        }

        System.out.println(sb);
    }
    public static void tutteLeBevandeDisponibili() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MenuApplication.class);
        System.out.println("....................:::::::::::::LE NOSTRE BEVANDE:::::::::::::....................");
        List<Bevande> bevandeList = ctx.getBean("bevande", List.class);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bevandeList.size(); i++) {
            Bevande bevanda = bevandeList.get(i);
            sb.append(i + 1).append(". ").append(bevanda.toString().replaceAll(", ", " "));
        }

        System.out.println(sb);
    }
    public static void tuttiCondimentiDisponibili() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MenuApplication.class);
        System.out.println("....................:::::::::::::CONDIMENTI EXTRA:::::::::::::....................");
        List<Condimenti> condimentiList = ctx.getBean("condimenti", List.class);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < condimentiList.size(); i++) {
            Condimenti condimento = condimentiList.get(i);
            sb.append(i + 1).append(". ").append(condimento.toString().replaceAll(", ", " "));
        }

        System.out.println(sb);
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
