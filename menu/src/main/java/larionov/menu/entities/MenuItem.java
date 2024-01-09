package larionov.menu.entities;

import lombok.*;

@Data
public abstract class MenuItem {
    private String nome;
    private double prezzo;
    private int calorie;

}
