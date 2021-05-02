package juego.partida;

import java.util.Scanner;

public class CentroClinico {
	private Jugador j;
	
	/**
	 * Constructor que crea el Jugador para curar a los elementos
	 * @param j (el jugador)
	 */
	public CentroClinico(Jugador j) {
		this.j = j;
	}
	
	/**
	 * "Interfaz" que pregunta al usuario si quiere sanar a los elementos
	 */
	@SuppressWarnings("resource")
	public void menu() {
		try {new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();} catch (Exception e) {}
		Scanner sc = new Scanner(System.in);
		System.out.println("");
		System.out.println("                           _________________");
		System.out.println("                          /   ___________   \\");
		System.out.println("                         |   /   |   |   \\   |");
		System.out.println("                         |  |    |-^-|    |  |");
		System.out.println("                         |  |             |  |");
		System.out.println("    _,-._                |  |═══<     >═══|  |                  ");
		System.out.println("   / \\_/ \\               |  |             |  |                  ");
		System.out.println("   >-(_)-<               |  |    |-v-|    |  |                  ");
		System.out.println("   \\_/ \\_/               |   \\___|___|___/   |                  ");
		System.out.println("     `-'                 |                   |                  ");
		System.out.println("      ||                 |      COLOCAR      |                  ");
		System.out.println("    __||__               |                   |                  ");
		System.out.println("   |______|              |     ALMA AQUÍ     |                  ");
		System.out.println("    |    |               |                   |                  ");
		System.out.println(" ___|____|________________\\_________________/__________________");
		System.out.println("|                                                              |");
		System.out.println("|______________________________________________________________|");
		System.out.println("   |                                                        |");
		System.out.println("   |                                                        |");
		System.out.println("   |                                                        |");
		System.out.println("   |                                                        |");
		System.out.println("   |                                                        |");
		System.out.println("   |                                                        |");
		System.out.println("   |                                                        |");
		System.out.println("   |________________________________________________________|");
		System.out.println("¿Quieres curar a tus Elementos?(S/N)");
		char op = sc.next().toUpperCase().charAt(0);
		if(op == 'S') j.sanar();
		else if(op == 'N') {/*Salir del método*/}
		else menu();
	}
}
