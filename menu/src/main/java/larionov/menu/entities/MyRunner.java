package larionov.menu.entities;

import larionov.menu.MenuApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Scanner;

import static larionov.menu.entities.Menu.*;

@Component
public class MyRunner implements CommandLineRunner {
    public static AnnotationConfigApplicationContext ctx;

    @Override
    public void run(String... args) throws Exception {
        ctx = new AnnotationConfigApplicationContext(MenuApplication.class);

        System.out.println("Benvenuto Alla Pizzeria Grande Piramide Di Egitto");
        int numeroCoperti = coperti();
        welcome();
        int choice = getUserChoise();
        sceltaDelTavolo(choice);
        mostraMenu();
        prontoPerOrdinare();
        Ordine ordine = ordineAlTavolo(sceltaDelTavolo(choice), numeroCoperti);
        System.out.println("Avete Ordinato: " + ordine.getMenuItems());

        ordine.totaleDellOrdine();


        System.out.println("Arrivederci");
        ctx.close();
    }

    //    ***************************Metodi**********************************
    private void welcome() {
        System.out.println("Dove Desidera Sedersi?");
        System.out.println("Seleziona un'opzione:");
        System.out.println("0. Tavolo sociale");
        System.out.println("1. Tavolo numero 1");
        System.out.println("2. Tavolo numero 2");
        System.out.println("3. Tavolo numero 3");
        System.out.println("4. Tavolo numero 4");
    }

    private int coperti() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("In Qianti siete?");
        return Integer.parseInt(scanner.nextLine());
    }


    private int getUserChoise() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci la tua scelta: ");
        return Integer.parseInt(scanner.nextLine());
    }

    private Tavolo sceltaDelTavolo(int choice) {
        Tavolo tavoloAssegnato = null;
        switch (choice) {
            case 0:
                tavoloAssegnato = assegnaIlTavolo("tavoloSociale");
                break;
            case 1:
                tavoloAssegnato = assegnaIlTavolo("tavoloNumeroUno");
                break;
            case 2:
                tavoloAssegnato = assegnaIlTavolo("tavoloNumeroDue");
                break;
            case 3:
                tavoloAssegnato = assegnaIlTavolo("tavoloNumeroTre");
                break;
            case 4:
                tavoloAssegnato = assegnaIlTavolo("tavoloNumeroQuattro");
                break;

            default:
                System.out.println("Il tavolo non è disponibile");
        }
        return tavoloAssegnato;
    }

    private Tavolo assegnaIlTavolo(String nomeDelTavolo) {
        Tavolo tavoloAssegnato = ctx.getBean(nomeDelTavolo, Tavolo.class);
        tavoloAssegnato.setStatoDelTavolo(STATO.OCCUPATO);
        return tavoloAssegnato;
    }

    private void mostraMenu() {
        tutteLePizzeDisponibili();
        tutteLeBevandeDisponibili();
        tuttiCondimentiDisponibili();
    }

    private Bevande scegliLaBevanda(String bevanda) {
        Bevande bevandaScelta = ctx.getBean(bevanda, Bevande.class);
        return bevandaScelta;
    }

    private Pizza scegliLaPizza(String pizza) {
        Pizza pizzaScelta = ctx.getBean(pizza, Pizza.class);
        return pizzaScelta;
    }

    private void scegliIlCondimento(String condimento) {
        Condimenti COndimentoScelto = ctx.getBean(condimento, Condimenti.class);
    }

    private void prontoPerOrdinare() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pronti?");
        if (scanner.nextLine().equalsIgnoreCase("si")) System.out.println("Cosa prendete?");
        else do {
            System.out.println("E ora!?");
        } while (!scanner.nextLine().equalsIgnoreCase("si"));
    }

    private Pizza ordinePizze(int choice) {
        Pizza pizza = null;
        switch (choice) {
            case 1:
                pizza = scegliLaPizza("napoli");
                break;
            case 2:
                pizza = scegliLaPizza("margherita");
                break;
            case 3:
                pizza = scegliLaPizza("pizzaAlSalame");
                break;
            default:
                System.out.println("Va a casa");
        }
        return pizza;
    }

    private Bevande ordineBevande(int choice) {
        Bevande bevanda = null;
        switch (choice) {
            case 1:
                bevanda = scegliLaBevanda("cocacola");
                break;
            case 2:
                bevanda = scegliLaBevanda("fanta");
                break;
            case 3:
                bevanda = scegliLaBevanda("lemonade");
                break;
            case 4:
                bevanda = scegliLaBevanda("water");
                break;
            case 5:
                bevanda = scegliLaBevanda("wine");
                break;
            default:
                System.out.println("Va a casa");
        }
        return bevanda;
    }

    private Ordine ordineAlTavolo(Tavolo tavolo, int coperti) {
        Ordine nuovoOrdine = new Ordine(tavolo);
        nuovoOrdine.setNumeroDiCoperti(coperti);
        nuovoOrdine.setCoperto(ctx.getBean("getCoperto", double.class));
        for (int i = 0; i < coperti; i++) {
            System.out.println("Che pizza vuole?");
            int sceltaPizze = getUserChoise();
            nuovoOrdine.aggiunguAllOrdine(ordinePizze(sceltaPizze));
            System.out.println("Cosa le porto da bere invece?");
            int sceltaBevande = getUserChoise();
            nuovoOrdine.aggiunguAllOrdine(ordineBevande(sceltaBevande));
        }
        return nuovoOrdine;
    }
}

