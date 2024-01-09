package larionov.menu.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class Pizza extends MenuItem {
    private String base;
    private List<Condimenti> condimenti;

    public Pizza(String nome, double prezzo, int calorie) {
        super(nome, prezzo, calorie);
        this.base = "Pomodoro e Mozzarella";
        this.condimenti = new ArrayList<>();
    }

    public void aggiungiCondimentiAllaPizza(Condimenti condimento) {
        this.condimenti.add(condimento);
    }
    
    public void calcoloTotaleCalorie(){
        double totaleCalorie = getCalorie() + condimenti.stream().mapToDouble(Condimenti::getCalorie).sum();
        System.out.println("Il totale delle calorie di questo piatto è: " + totaleCalorie + " Kcal");
    }

    public void calcoloPrezzoFinaleDelProdotto(){
        double prezzoTotaleDelPiatto = getPrezzo() + condimenti.stream().mapToDouble(Condimenti::getPrezzo).sum();
        System.out.println("In totale questo piatto ha un valore di: " + prezzoTotaleDelPiatto + " Euro");
    }

    @Override
    public String toString() {
        return "\n"  + getNome() + " " +
                "base='" + base + '\'' +
                (!condimenti.isEmpty() ? ", condimenti=" + condimenti : "") + "\n";

    }
}
