package juego.menu;

import java.util.Scanner;
import juego.partida.Jugador;

public class MenuJugador {
	private Jugador j;
	//Cargar el jugador para las opciones de este
	public MenuJugador(Jugador ju) {
		j = ju;
	}
	 /**
	  * Menú del jugador
	  * 1.Despliega el toString() de la clase Jugador
	  * 2.No hace nada, para así volver a la partida
	  * 3.Créidtos del juego
	  * 4.Guarda el juego
	  * 5.Sale del juego. Altera el String condicional para salir del juego
	  * @return el String condicional que dice si se termina el juego o no
	  */
	@SuppressWarnings("resource")
	public String menu() {
		String terminar = "";
		System.out.println("1.Información");
		System.out.println("2.Volver");
		System.out.println("3.Créditos");
		System.out.println("4.Guardar");
		System.out.println("5.Salir");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		Scanner sc = new Scanner(System.in);
		int op = sc.nextInt();
		if(op < 1 || op > 4) {
			System.out.println("\t EL VALOR INTRODUCIDO NO ES VÁLIDO");
			try {Thread.sleep(3*1000);} catch (Exception e) {System.out.println(e);}
			try {new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();} catch (Exception e) {}
			menu();
		}
		switch(op) {
			case 1:
				try {new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();} catch (Exception e) {}
				j.toString();
				sc.next();
				break;
			case 2:
				//Volver al juego
				break;
			case 3:
				creditos();
				sc.next();
				break;
			case 4:
				j.guardar();
				break;
			case 5:
				terminar = "Terminar";
				break;
		}
		return terminar;
	}
	
	/**
	 * Método que imprime por pantalla los créditos del juego
	 */
	private void creditos() {
		System.out.println("-CREADOR POR-");
		System.out.println("\tDavid Burguete");
		System.out.println("-PROGRAMACIÓN-");
		System.out.println("\tDavid Burguete");
		System.out.println("-DISEÑO-");
		System.out.println("\tDavid Burguete");
		System.out.println("-VERSIÓN-");
		System.out.println("\tvAlfa.3.0");
		System.out.println("\t(Para nada) basado een los juegos de Nintendo de Pokémon");
	}
}
