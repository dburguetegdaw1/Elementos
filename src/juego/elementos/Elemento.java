package juego.elementos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Elemento {
	String nombre;
	TiposDeElemento tE;
	String id;
	int nivel;
	int exp;
	int vida;
	int vidaMax;
	int ataque;
	int defensa;
	List<String> mov;
	
	/**
	 * Constructor de la clase. Crea un único elemento
	 * Puede ser para añadir a la lista del jugador, de un coliseo
	 * o bien ser un elemento salvaje
	 * @param nombre
	 * @param tE
	 * @param id
	 * @param nivel
	 * @param exp
	 * @param vida
	 * @param vidaMax
	 * @param ataque
	 * @param defensa
	 * @param movs
	 */
	public Elemento(String nombre, TiposDeElemento tE, String id, 
			int nivel, int exp, int vida, int vidaMax, 
			int ataque,int defensa, String movs) {
		this.nombre = nombre;
		this.tE = tE;
		this.id = id;
		this.nivel = nivel;
		this.exp = exp;
		this.vida = vida;
		this.vidaMax = vidaMax;
		this.ataque = ataque;
		this.defensa = defensa;
		this.mov = new ArrayList<>();
		String[] mov = movs.split(",");
		for (int i = 0; i < mov.length; i++) {
			mov[i] = mov[i].trim();
		}
		this.mov = Arrays.asList(mov);
	}
	public String getNombre() {
		return nombre;
	}
	public TiposDeElemento gettE() {
		return tE;
	}
	public String getId() {
		return id;
	}
	public int getNivel() {
		return nivel;
	}
	public int getExp() {
		return exp;
	}
	public int getVida() {
		return vida;
	}
	public int getVidaMax() {
		return vidaMax;
	}
	public int getAtaque() {
		return ataque;
	}
	public int getDefensa() {
		return defensa;
	}
	public Object[] getMov() {
		Object[] movs = mov.toArray();
		return movs;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	
}
