package larionov.menu.entities;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
@Setter
public class Sala {
    private List<Tavolo> tavoliDisponibili;
    public Sala() {
        this.tavoliDisponibili = new ArrayList<>();
    }
    public void aggiungiIlTavoloAllaSala(Tavolo tavolo) {
        this.tavoliDisponibili.add(tavolo);
    }

    @Override
    public String toString() {
        return "Sala{" +
                 (tavoliDisponibili.stream().map(Tavolo::getStatoDelTavolo)).forEach(Tavolo tavolo == STATO.LIBERO);  +
                '}';
    }
}

