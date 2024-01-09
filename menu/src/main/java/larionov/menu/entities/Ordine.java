package larionov.menu.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Ordine {
    private Tavolo tavolo;
    private STATO_ORDINE statoDellOrdinazione;
    private LocalDate dataAcquisizioneDellOrdine;
    private int numeroDiCoperti;
    private List<MenuItem> menuItems;

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
        Double totale = menuItems.stream().mapToDouble(MenuItem::getPrezzo).sum();
        System.out.println("Totale dell'ordine: " + totale);
    }
}
