package juego.elementos;

import java.util.HashMap;

public class Nombres {
	HashMap<Integer, String[]> nombres;

	/**
	 * Constructor de los posible elementos
	 * Clasificados en 6 grupos por elementos, están colocados
	 * las 3 evoluciones en orden de cada uno de los 3 elementos 
	 * de ese tipo en concreto
	 */
	public Nombres() {
		nombres = new HashMap<>();
		String[] tierra = {"Fango","Arcilla","Golem","Semilla","Brote","Ent","Lombriz","Serpiente","Hidra"};
		String[] agua = {"Pulpo","Calamar gigante","Kraken","Pez","Delfin","Tiburon","Pez abisal","Morena","Dragon marino"};
		String[] aire = {"Halcon","Aguila","Hipogrifo","Soplo","Nube","Tornado","Querubin","Angel","Arcangel"};
		String[] fuego = {"Espiritu de fuego","Draconiano","Demonio","Cobra","Basilisco","Apofis","Cenizas","Fenix menor","Ave Fenix"};
		String[] vida = {"Gato","Tigre","Quimera","Dragon komodo","T-Rex","Dragon","Rata","Murcielago","Vampiro"};
		String[] muerte = {"Momia","Zombi","Nigromante","Espiritu","Fantasma","Poltergeist","Esqueleto","Parca","Tanatos"};
		nombres.put(1, tierra);
		nombres.put(2, agua);
		nombres.put(3, aire);
		nombres.put(4, fuego);
		nombres.put(5, vida);
		nombres.put(6, muerte);
	}
	
	/**
	 * Método que devuelve el nombre de un elemento según su ID
	 * @param nom (String que representa el ID del elemento)
	 * @return el nombre del elemento según el @param
	 */
	public String getNombre(String nom) {
		String noms[] = nom.split("-");
		String nombre = "";
		switch(noms[0]) {
		case "1":
			nombre = nombres.get(1)[Integer.parseInt(noms[1]) - 1];
			break;
		case "2":
			nombre = nombres.get(2)[Integer.parseInt(noms[1]) - 1];
			break;
		case "3":
			nombre = nombres.get(3)[Integer.parseInt(noms[1]) - 1];
			break;
		case "4":
			nombre = nombres.get(4)[Integer.parseInt(noms[1]) - 1];
			break;
		case "5":
			nombre = nombres.get(5)[Integer.parseInt(noms[1]) - 1];
			break;
		case "6":
			nombre = nombres.get(6)[Integer.parseInt(noms[1]) - 1];
			break;
		}
		return nombre;
	}
	
	/**
	 * Método que devuelve el tipo de elemento según una ID
	 * @param id (Integer que representa el ID del tipo del elemento)
	 * @return el tipo del elemento según el @param
	 */
	public TiposDeElemento element(int id) {
		TiposDeElemento tE = TiposDeElemento.values()[id-1];
		return tE;
	}
}
