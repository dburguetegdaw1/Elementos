package juego.menu;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MenuInicio {
	/**
	 * Inicializador del juego
	 * @param args
	 */
	public static void main(String[] args) {
		MenuInicio mi = new MenuInicio();
		mi.desplegarMenu();
	}
	
	/**
	 * Menú inicial
	 * Llama a 3 posibles métodos para 
	 * 1.Crear una nueva partida
	 * 2.Cargar una partida ya existente
	 * 3.Eliminar una partida
	 * Existe una cuarta opción para salir del método
	 */
	public void desplegarMenu() {
		try {new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();} catch (Exception e) {}
		Scanner sc = new Scanner(System.in);
		System.out.println("_________  ____      _________  _____  _____  _________  ____  ____  _____________   ");
		System.out.println("\\   ____/  \\  /      \\   ____/  \\   /  \\   /  \\   ____/  \\   \\|   /  \\           /   ______");
		System.out.println("|  |__     |  |      |  |__     |   \\__/   |  |  |__     |        |   \\__     __/   /      \\");
		System.out.println("|   __|    |  |      |   __|    |          |  |   __|    |        |      |   |      |  /\\  |");
		System.out.println("|  |____   |  |___   |  |____   |   |__|   |  |  |____   |   |\\   |      |   |      |  \\/  |");
		System.out.println("/_______\\  /______|  /_______\\  /___\\  /___\\  /_______\\  /___\\/___\\      /___\\      \\______/");
		System.out.println();
		System.out.println();
		System.out.println("\t\t\t1.-NUEVO JUEGO");
		System.out.println("\t\t\t2.-CARGAR PARTIDA");
		System.out.println("\t\t\t3.-BORRAR PARTIDA");
		System.out.println("\t\t\t4.-SALIR");
		System.out.println();
		System.out.println();
		System.out.println("Version Alfa.3.1");
		System.out.println();
		System.out.println();
		int op = sc.nextInt();
		//Comprobar que la opción es válida
		if(op < 1 || op > 4) {
			System.out.println("\t EL VALOR INTRODUCIDO NO ES VÁLIDO");
			try {Thread.sleep(3*1000);} catch (Exception e) {System.out.println(e);}
			try {new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();} catch (Exception e) {}
			desplegarMenu();
		}
		//Según la opción, llama a un método, y al terminar, vuelve a llamar al menú
		switch(op) {
			case 1:
				nueva();
				desplegarMenu();
				break;
			case 2:
				cargar();
				desplegarMenu();
				break;
			case 3:
				borrar();
				desplegarMenu();
				break;
		}
		sc.close();
	}
	
	
	/**
	 * Crea una partida nueva
	 * Si ya hay 3 ficheros guardados, redirecciona a cargar()
	 * En cualquier otro caso, pide al usuario un nombre para el archivo de guardado
	 * y le manda instananeamente a crearPartidaNueva()
	 */
	@SuppressWarnings({ "unused", "resource" })
	private void nueva() {
		Scanner sc = null;
		FileWriter fW = null;
		String nomFich = "";
		File fich = new File("Archivos_de_guardado");
		String[] archivos = fich.list();
		if(archivos.length >= 3) {
			System.out.println("Los espacios de guardado de juego están completos\nDebes cargar un nuevo archivo:");
			cargar();
			return;
		}
		else {
			sc = new Scanner(System.in);
			System.out.println("Introduce un nombre (una palabra) para esta nueva partida:");
			nomFich = sc.next();
			try {
				fW = new FileWriter("Archivos_de_guardado\\" + nomFich + ".txt");
			} catch (IOException e) {
				e.printStackTrace();
			}
			NuevaPartida n = new NuevaPartida(nomFich + ".txt");
		}
		try {
			fW.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		MenuJuego mJ = new MenuJuego(nomFich);
		mJ.desplegarAreas();
	}
	
	/**
	 * Este metodo carga un archivo de juego, recogiendo la lista de todos y cada uno de ellos
	 * para despues listarlos y escoger
	 * Si ya hay un archivo, lo carga, sino, crea uno nuevo
	 */
	@SuppressWarnings("resource")
	private void cargar() {
		File fich = new File("Archivos_de_guardado");
		String[] archivos = fich.list();
		System.out.println("Archivos de guardado");
		for (int i = 1; i < 4; i++) {
			if(i-1 < archivos.length) {
				System.out.println(i + ".- " + archivos[i-1]);
			}
			else {
				System.out.println(i + ".- _______________");
			}
		}
		Scanner sc = new Scanner(System.in);
		int op = sc.nextInt();
		if(op-1 < archivos.length && op > 0) {
			MenuJuego mJ = new MenuJuego(archivos[op-1]);
			mJ.desplegarAreas();
		}
		else if(op-1 >= archivos.length && op < 4) {
			System.out.println("Este espacio está vacío");
			try {
	            Thread.sleep(3*1000);
	         } catch (Exception e) {
	            System.out.println(e);
	         }
			try {new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();} catch (Exception e) {}
			nueva();
		}
		else {
			System.out.println("Opcion no válida");
			try {
	            Thread.sleep(3*1000);
	         } catch (Exception e) {
	            System.out.println(e);
	         }
			try {new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();} catch (Exception e) {}
			cargar();
		}
	}
	
	/**
	 * Elimina un archivo de partida
	 * Solamente elimina antes de cargar una partida, sino se debe cerrar
	 * y volver a abrir
	 */
	@SuppressWarnings("resource")
	private void borrar() {
		File fich = new File("Archivos_de_guardado");
		String[] archivos = fich.list();
		if(archivos.length == 0){
			System.out.println("No hay ningún archivo a borrar");
			try {
	            Thread.sleep(3*1000);
	         } catch (Exception e) {
	            System.out.println(e);
	         }
		}
		else {
			System.out.println("Borrar archivo");
			for (int i = 1; i < 4; i++) {
				if(i-1 < archivos.length) {
					System.out.println(i + ".- " + archivos[i-1]);
				}
				else {
					System.out.println(i + ".- _______________");
				}
			}
			Scanner sc = new Scanner(System.in);
			int op = sc.nextInt();
			if(op-1 < archivos.length && op > 0) {
				File f = new File("Archivos_de_guardado\\" + archivos[op-1]);
				f.delete();
				System.out.println("Archivo borrado");
			}
			else {
				System.out.println("Este espacio está vacio");
				try {
		            Thread.sleep(3*1000);
		         } catch (Exception e) {
		            System.out.println(e);
		         }
				try {new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();} catch (Exception e) {}
				borrar();
			}
		}
		try {new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();} catch (Exception e) {}
	}
}
