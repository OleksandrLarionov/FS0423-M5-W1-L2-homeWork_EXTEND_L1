package larionov.menu.entities;

import larionov.menu.MenuApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MenuApplication.class);

        Sala tavoliDisponibiliAlLocale = (Sala) ctx.getBean("getTavoliDisponibiliNellaSala");

        Tavolo tavoloSociale = (Tavolo) ctx.getBean("tavoloSociale") ;
        tavoloSociale.setNumeroDiCopertiEffettivi(3);
        tavoloSociale.setStatoDelTavolo(STATO.OCCUPATO);

        Ordine nuovoOrdine = new Ordine(tavoloSociale);
        nuovoOrdine.setNumeroDiCoperti(3);
        System.out.println("****************" + nuovoOrdine.getNumeroDiCoperti());

        nuovoOrdine.aggiunguAllOrdine(ctx.getBean("napoli", Pizza.class));
        nuovoOrdine.aggiunguAllOrdine(ctx.getBean("fanta", Bevande.class));
        nuovoOrdine.aggiunguAllOrdine(ctx.getBean("prosciutto",Condimenti.class));
        nuovoOrdine.setCoperto(ctx.getBean("getCoperto", double.class));

        System.out.println(tavoliDisponibiliAlLocale);
        System.out.println(nuovoOrdine);
        nuovoOrdine.totaleDellOrdine();
    }
}
