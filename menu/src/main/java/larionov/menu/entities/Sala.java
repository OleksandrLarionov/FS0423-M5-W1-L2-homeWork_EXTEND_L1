package larionov.menu.entities;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ToString
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
}
