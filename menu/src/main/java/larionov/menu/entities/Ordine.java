package larionov.menu.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
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
    private List<MenuItem> menuList;

    public Ordine(Tavolo tavolo) {
        this.tavolo = tavolo;
        this.statoDellOrdinazione = STATO_ORDINE.IN_CORSO;
        this.dataAcquisizioneDellOrdine = LocalDate.now();
        this.numeroDiCoperti = 0;
    }
}
