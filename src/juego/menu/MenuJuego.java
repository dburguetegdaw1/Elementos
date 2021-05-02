package juego.menu;

import java.util.Scanner;

import juego.partida.CentroClinico;
import juego.partida.Jugador;

public class MenuJuego {
	private Jugador j;
	
	/**
	 * Carga los datos de un jugador según que fichero se haya seleccionado
	 * @param nomFich (Ruta del fichero)
	 */
	public MenuJuego(String nomFich) {
		j = new Jugador(nomFich);
	}
	
	/**
	 * "Interfaz" gráfica del juego
	 * Llama a 4 métodos
	 * 1.Para cazar elementos
	 * 2.Curar los propios
	 * 3.Combatir contra señores de los elementos
	 * 4.Desplegar el menú de opciones del jugador
	 */
	@SuppressWarnings("resource")
	public void desplegarAreas() {
		String terminar = "";
		do {
			try {new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();} catch (Exception e) {}
			System.out.println("                      _______________________________________");
			System.out.println(" _              _    |                                       |                     ");
			System.out.println("| |____________| |   |   CENTRO         ___        CLÍNICO   |                    ");
			System.out.println("| |            | |   |                 |   |                 |                   ______");
			System.out.println("| |  CAMPO DE  | |   |             ____|   |____             |                  /_|___|\\");
			System.out.println("| |            | |   |            |             |            |                 /|___|___\\");
			System.out.println("| |    CAZA    | |   |            |____     ____|            |                /___|___|__\\");
			System.out.println("| |____________| |   |                 |   |                 |               /__|COLISEO|_\\");
			System.out.println("| |            | |   |                 |___|                 |              /_|___|___|___|\\");
			System.out.println("| |            | |   |              ___________              |             /|___|___|___|___\\");
			System.out.println("| |            | |   |             |  /  |     |             |            /___|___|___|___|__\\");
			System.out.println("| |     O      | |   |             | /   |     |             |           /__|___|___|___|___|_\\");
			System.out.println("| |   _ |/     | |   |             |    .|.   /|             |          /_|___|___|___|___|___|\\");
			System.out.println("| |    \\|      | |   |             |   / |   / |             |         /|___|___|__/\\___|___|___\\");
			System.out.println("| |            | |   |             |  /  |     |             |                    /  \\");
			System.out.println("|_|____________|_|   |_____________|_____|_____|_____________|                   /    \\");
			System.out.println("  |            |                   |           |                                /      \\");
			System.out.println("  |            |                   |           |                               /        \\");
			System.out.println("  |            |___________________|           |______________________________/          \\");
			System.out.println("  |                                                                                      |");
			System.out.println("  |                                                                                      |");
			System.out.println("  |                                                                                      |");
			System.out.println("  |________________________________             _________________________________________|");
			System.out.println("--------------------               |           |");
			System.out.println("+MENÚ DE JUGADOR (4)|              |           |");
			System.out.println("                    |              |           |");
			System.out.println("¿A donde piensas dirigirte? (1)CAMPO DE CAZA - (2) CENTRO CLÍNICO - (3) COLISEO");
			Scanner sc = new Scanner(System.in);
			int op = sc.nextInt();
			//Comprobar que la opción sea válida
			if(op < 1 || op > 4) {
				System.out.println("\t EL VALOR INTRODUCIDO NO ES VÁLIDO");
				try {
		            Thread.sleep(3*1000);
		         } catch (Exception e) {
		            System.out.println(e);
		         }
				try {new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();} catch (Exception e) {}
				desplegarAreas();
			}
			switch(op) {
				case 1:
					
					break;
				case 2:
					CentroClinico cc = new CentroClinico(j);
					cc.menu();
					break;
				case 3:
					
					break;
				case 4:
					MenuJugador mJ = new MenuJugador(j);
					terminar = mJ.menu();
					break;
			}
		}while(terminar.equals(""));
	}
}
