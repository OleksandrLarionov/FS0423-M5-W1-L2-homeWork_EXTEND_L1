package larionov.menu.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@Getter
@Setter
public class Condimenti extends MenuItem{
    private List<Condimenti> listaCondimentiDisponibili;
    public Condimenti(String nome, double prezzo, int calorie) {
        super(nome, prezzo, calorie);
        this.listaCondimentiDisponibili = new ArrayList<>();
    }

    public void aggiungiCondimento (Condimenti condimento){
        this.listaCondimentiDisponibili.add(condimento);
    }

    @Override
    public String toString() {
        return "\n" + getNome() + ": " + " Calorie: " + getCalorie() + " kal" + " Prezzo: " +  getPrezzo() + " Euro\n"
                ;
    }
}
