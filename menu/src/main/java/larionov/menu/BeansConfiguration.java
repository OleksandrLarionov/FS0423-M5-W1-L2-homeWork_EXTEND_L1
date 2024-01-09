package larionov.menu;

import larionov.menu.entities.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfiguration {
    //    *********************************PIZZE*********************************
    @Bean
    Pizza napoli() {
        Pizza napoli = new Pizza("Napoli", 12.50, 1500);
        napoli.aggiungiCondimentiAllaPizza(basilico());
        napoli.aggiungiCondimentiAllaPizza(alici());
        return napoli;
    }

    @Bean
    Pizza margherita() {
        return new Pizza("Margherita", 8, 800);
    }

    @Bean
    Pizza pizzaAlSalame() {
        Pizza salame = new Pizza("Salame", 9.00, 1000);
        salame.aggiungiCondimentiAllaPizza(salame());
        return salame;
    }


    //    **********************************BEVANDE***************************
    @Bean
    Bevande cocacola() {
        return new Bevande("CocaCola", 5, 1000);
    }

    @Bean
    Bevande fanta() {
        return new Bevande("Fanta", 5, 800);
    }

    @Bean
    Bevande lemonade() {
        return new Bevande("Lemonade(0.33l)", 1.29, 128);
    }

    @Bean
    Bevande water() {
        return new Bevande("Water(0.5l)", 1.29, 0);
    }

    @Bean
    Bevande wine() {
        return new Bevande("Wine(0.75l)", 7.49, 607);
    }

    //******************************Condimenti**************************
    @Bean
    Condimenti prosciutto() {
        return new Condimenti("Prosciutto", 0.99, 35);
    }

    @Bean
    Condimenti basilico() {
        return new Condimenti("basilico", 0.25, 2);
    }

    @Bean
    Condimenti alici() {
        return new Condimenti("alici", 1.25, 70);
    }

    @Bean
    Condimenti funghi() {
        return new Condimenti("funghi", 1.25, 180);
    }

    @Bean
    Condimenti salsiccia() {
        return new Condimenti("salsiccia", 2.50, 300);
    }

    @Bean
    Condimenti formaggio() {
        return new Condimenti("alici", 0.69, 92);
    }

    @Bean
    Condimenti cipolle() {
        return new Condimenti("alici", 0.69, 24);
    }

    @Bean
    Condimenti salame (){
        return new Condimenti("salame",0.99,86);
    }

//    **************************************TAVOLI*************************************

    @Bean
    Tavolo tavoloSociale(){
        return new Tavolo(0,12);
    }
    @Bean
    Tavolo tavoloNumeroUno(){
        return new Tavolo(1,4);
    }
    @Bean
    Tavolo tavoloNumeroDue(){
        return new Tavolo(2,4);
    }
    @Bean
    Tavolo tavoloNumeroTre(){
        return new Tavolo(3,2);
    }
    @Bean
    Tavolo tavoloNumeroQuattro(){
        return new Tavolo(4,2);
    }

    @Bean
    Sala getTavoliDisponibiliNellaSala(){
        Sala sala = new Sala();
        sala.aggiungiIlTavoloAllaSala(tavoloSociale());
        sala.aggiungiIlTavoloAllaSala(tavoloNumeroUno());
        sala.aggiungiIlTavoloAllaSala(tavoloNumeroDue());
        sala.aggiungiIlTavoloAllaSala(tavoloNumeroTre());
        sala.aggiungiIlTavoloAllaSala(tavoloNumeroQuattro());

        return sala;
    }
    @Bean
    Menu getMenu() {
        Menu menu = new Menu();
        menu.aggiungiPizzaAlMenu(napoli());
        menu.aggiungiPizzaAlMenu(margherita());
        menu.aggiungiPizzaAlMenu(pizzaAlSalame());

        menu.aggiungiBevandaAlMenu(fanta());
        menu.aggiungiBevandaAlMenu(cocacola());
        menu.aggiungiBevandaAlMenu(lemonade());
        menu.aggiungiBevandaAlMenu(water());
        menu.aggiungiBevandaAlMenu(wine());

        menu.aggiungiCondimentoAlMenu(basilico());
        menu.aggiungiCondimentoAlMenu(alici());
        menu.aggiungiCondimentoAlMenu(salame());
        menu.aggiungiCondimentoAlMenu(prosciutto());
        menu.aggiungiCondimentoAlMenu(cipolle());


        return menu;
    }


}
