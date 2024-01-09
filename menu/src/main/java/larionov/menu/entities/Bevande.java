package larionov.menu.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Bevande extends MenuItem{
    public Bevande(String nome, double prezzo, int calorie) {
        super(nome, prezzo, calorie);
    }

    @Override
    public String toString() {
        return "\n" + getNome() + " " + getPrezzo() + " Euro\n";
    }
}
