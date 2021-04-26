package juego.menu;

import juego.elementos.Elemento;
import juego.elementos.TiposDeElemento;

public class NuevaPartida {
	private Elemento e1;
	private Elemento e2;
	private Elemento e3;
	
	public NuevaPartida() {
		e1 = new Elemento("Fango", TiposDeElemento.Tierra, "1-01", 1, 0, 10, 10, 12, 10, "");
	}
}
