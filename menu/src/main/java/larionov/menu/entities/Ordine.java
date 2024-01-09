package larionov.menu.entities;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@PropertySource("application.properties")
public class Ordine {
    private Tavolo tavolo;
    private STATO_ORDINE statoDellOrdinazione;
    private LocalDate dataAcquisizioneDellOrdine;
    private int numeroDiCoperti;
    private List<MenuItem> menuItems;
//    @Value("${prezzo.coperto}")
    private double coperto;

    public Ordine(Tavolo tavolo) {
        this.tavolo = tavolo;
        this.statoDellOrdinazione = STATO_ORDINE.IN_CORSO;
        this.dataAcquisizioneDellOrdine = LocalDate.now();
        this.numeroDiCoperti = 0;
        this.menuItems = new ArrayList<>();
    }

    public void aggiunguAllOrdine(MenuItem menuItem){
        this.menuItems.add(menuItem);
    }

    public void totaleDellOrdine(){
        Double totale = menuItems.stream().mapToDouble(MenuItem::getPrezzo).sum() + coperto * numeroDiCoperti;
        System.out.println("Totale dell'ordine: " + totale);
    }
}
