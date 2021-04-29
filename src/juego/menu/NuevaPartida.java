package juego.menu;

import juego.elementos.*;
import juego.partida.Jugador;

import java.util.Scanner;

public class NuevaPartida {
	private Elemento e1;
	
	@SuppressWarnings({ "resource", "unused" })
	public NuevaPartida(String nomFich) {
		try {Thread.sleep(0*1000);} catch (Exception e) {System.out.println(e);}
		e1 = null;
		int op = saludar();
		switch(op){
			case 1:
				e1 = new Elemento("Fango", TiposDeElemento.Tierra, "1-01", 1, 0, 10, 10, 12, 10, "Estrangular");
				break;
			case 2:
				e1 = new Elemento("Pez", TiposDeElemento.Agua, "2-04", 1, 0, 10, 10, 9, 13, "Corriente marina");
				break;
			case 3:
				e1 = new Elemento("Cobra", TiposDeElemento.Fuego, "4-04", 1, 0, 10, 10, 14, 8, "Estrangular");
				break;
		}
		System.out.println("¡Bien! Ahora que ya has elegido un Elemento, has de elegir tu nombre:");
		Scanner sc = new Scanner(System.in);
		String nom = sc.next();
		System.out.println("Bueno, ahora está todo listo...");
		try {Thread.sleep(3*1000);} catch (Exception e) {System.out.println(e);}
		System.out.println("¡Así que buena suerte! (Recuerda que es mi primera versión de juegos a gran nivel)");
		System.out.println("\tDavid Burguete - Creador del proyecto");
		try {Thread.sleep(3*1000);} catch (Exception e) {System.out.println(e);}
		Jugador j = new Jugador(nomFich, nom, e1);
	}
	
	@SuppressWarnings("resource")
	private int saludar() {
		try {new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();} catch (Exception e) {}
		System.out.println("¡Bienvenido! Esto, antes de que lo preguntes, no, no es un plagio de Pokémon");
		try {Thread.sleep(3*1000);} catch (Exception e) {System.out.println(e);}
		System.out.println("Para nada");
		try {Thread.sleep(3*1000);} catch (Exception e) {System.out.println(e);}
		System.out.println("Y como en todo buen inicio, debes escoger entre 3 tipos de Elementos (que no Pokémons):");
		try {Thread.sleep(3*1000);} catch (Exception e) {System.out.println(e);}
		System.out.println("1.-Fango: Tipo - Tierra");
		try {Thread.sleep(3*1000);} catch (Exception e) {System.out.println(e);}
		System.out.println("2.-Pez: Tipo - Agua");
		try {Thread.sleep(3*1000);} catch (Exception e) {System.out.println(e);}
		System.out.println("3.-Cobra: Tipo - Fuego");
		Scanner sc = new Scanner(System.in);
		System.out.println("¿Con cual te quedas?");
		int op = sc.nextInt();
		if(op < 1 || op > 3){
			op = reelige();
		}
		return op;
	}
	
	@SuppressWarnings("resource")
	private int reelige(){
		try {new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();} catch (Exception e) {}
		System.out.println("Bienvenido! Esto, antes de que lo preguntes, no, no es un plagio de Pokemon");
		System.out.println("Para nada");
		System.out.println("Y como en todo buen inicio, debes escoger entre 3 tipos de Elementos (que no Pokemons):");
		System.out.println("1.-Fango: Tipo - Tierra");
		System.out.println("2.-Pez: Tipo - Agua");
		System.out.println("3.-Cobra: Tipo - Fuego");
		System.out.println("Con cual te quedas?");
		System.out.println("Eso no es una opcion valida! Prueba otra vez!");
		Scanner sc = new Scanner(System.in);
		int op = sc.nextInt();
		if(op < 1 || op > 3){
			op = reelige();
		}
		return op;
	}
}
