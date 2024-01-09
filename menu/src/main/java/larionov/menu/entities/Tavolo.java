package larionov.menu.entities;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@ToString
public class Tavolo {
    private STATO statoDelTavolo;
    private int numeroDelTavolo;
    private int numeroMassimoDiCoperti;
    private int numeroDiCopertiEffettivi;

    public Tavolo(int numeroDelTavolo, int numeroMassimoDiCoperti) {
        this.statoDelTavolo = STATO.LIBERO;
        this.numeroDelTavolo = numeroDelTavolo;
        this.numeroMassimoDiCoperti = numeroMassimoDiCoperti;
        this.numeroDiCopertiEffettivi = 0;
    }

}
