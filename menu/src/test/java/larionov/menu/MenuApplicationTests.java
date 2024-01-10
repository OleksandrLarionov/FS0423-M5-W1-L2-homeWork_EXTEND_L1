package larionov.menu;

import larionov.menu.entities.Condimenti;
import larionov.menu.entities.Pizza;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MenuApplicationTests {

	@Test
	public void testCreazionePizza() {
		Pizza pizza = new Pizza("Margherita", 8.5, 800);
		assertNotNull(pizza);
		assertEquals("Margherita", pizza.getNome());
		assertEquals(8.5, pizza.getPrezzo(), 0.001);
		assertEquals(800, pizza.getCalorie());
		assertEquals("Pomodoro e Mozzarella", pizza.getBase());
		assertTrue(pizza.getCondimenti().isEmpty());
	}

	@Test
	public void testAggiungiCondimentiAllaPizza() {
		Pizza pizza = new Pizza("Cinque Formaggini", 10.0, 1000);
		Condimenti condimento1 = new Condimenti("Parmigiano", 2.0, 150);
		pizza.aggiungiCondimentiAllaPizza(condimento1);
		assertEquals(1, pizza.getCondimenti().size());
		assertEquals("Parmigiano", pizza.getCondimenti().get(0).getNomeCondimento());
	}
	@Test
	public void testCalcoloTotaleCalorie() {
		Pizza pizza = new Pizza("Begganti", 9.0, 900);
		Condimenti condimento1 = new Condimenti("Salame", 3.0, 200);
		Condimenti condimento2 = new Condimenti("Salame Begganti", 1.0, 50);
		pizza.aggiungiCondimentiAllaPizza(condimento1);
		pizza.aggiungiCondimentiAllaPizza(condimento2);

		pizza.calcoloTotaleCalorie();
		assertEquals(1150, pizza.calcoloCalorieBackDouble());
	}

	@Test
	public void testCalcoloPrezzoFinaleDellaPizza() {
		Pizza pizza = new Pizza("Margherita", 8.5, 800);
		Condimenti condimento1 = new Condimenti("Basilico", 1.0, 10);
		Condimenti condimento2 = new Condimenti("Peperoncino", 0.5, 5);
		pizza.aggiungiCondimentiAllaPizza(condimento1);
		pizza.aggiungiCondimentiAllaPizza(condimento2);
		pizza.calcoloPrezzoFinaleDelProdotto();
	}

	@ParameterizedTest
	@CsvSource({"Margherita, 8.5, 800", "Begganti, 11.0, 1950"})
	public void testCreazionePizzaConParametri(String nome, double prezzo, int calorie) {
		Pizza pizza = new Pizza(nome, prezzo, calorie);
		assertNotNull(pizza);
		assertEquals(nome, pizza.getNome());
		assertEquals(prezzo, pizza.getPrezzo(), 0.001);
		assertEquals(calorie, pizza.getCalorie());
		assertEquals("Pomodoro e Mozzarella", pizza.getBase());
		assertTrue(pizza.getCondimenti().isEmpty());
	}

}
