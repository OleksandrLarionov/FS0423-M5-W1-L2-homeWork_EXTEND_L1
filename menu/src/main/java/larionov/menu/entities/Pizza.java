package larionov.menu.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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

    public void calcoloTotaleCalorie() {
        double totaleCalorie = getCalorie() + condimenti.stream().mapToDouble(Condimenti::getCalorie).sum();
        System.out.println("Il totale delle calorie di questo piatto è: " + totaleCalorie + " Kcal");
    }

    public void calcoloPrezzoFinaleDelProdotto() {
        double prezzoTotaleDelPiatto = getPrezzo() + condimenti.stream().mapToDouble(Condimenti::getPrezzo).sum();
        System.out.println("In totale questo piatto ha un valore di: " + prezzoTotaleDelPiatto + " Euro");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb
                .append("Pizza: ")
                .append(getNome()).append(" ")
                .append("base: '").append(base).append("'");
        if (!condimenti.isEmpty()) {
            sb.append(", condimenti: ");

            for (Condimenti condimento : condimenti) {
                sb.append(condimento.getNomeCondimento()).append(", ");
            }
//            .append(condimenti.getNomeCondimento().toString().replaceAll("[\\[\\]]", ""));
        }
        sb.append(" Prezzo: ")
                .append(getPrezzo())
                .append(" Euro")
                .append("\n");
        return sb.toString();
    }
}
