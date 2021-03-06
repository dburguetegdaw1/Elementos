package juego.partida;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import juego.elementos.*;

public class Jugador {
	String nombreJugador, nombreFicheroGuardado;
	int medallas;
	ArrayList<Elemento> elementos;
	
	/**
	 * Constructor usado al cargar partida
	 * @param nomFichero (Ruta donde se encuentra el fichero de guardado a cargar)
	 */
	public Jugador(String nomFichero) {
		nombreFicheroGuardado = nomFichero;
		elementos = new ArrayList<>();
		BufferedReader fR = null;
		try {
			fR = new BufferedReader(new FileReader("Archivos_de_guardado\\" + nomFichero));
			cargar(fR);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Constructor que es usado al crear una nueva partida
	 * @param nomFich (Ruta donde se guardará el Fichero)
	 * @param nom (Nombre del jugador)
	 * @param e (Elemento inicial usado por el usuario)
	 */
	public Jugador(String nomFich, String nom, Elemento e) {
		nombreFicheroGuardado = nomFich;
		nombreJugador = nom;
		medallas = 0;
		elementos = new ArrayList<>();
		elementos.add(e);
		guardar();
	}
	
	/**
	 * Método que carga el fichero de partida
	 * @param fR (el fichero)
	 */
	private void cargar(BufferedReader fR) {
		try {
			//Carga del nombre y medallas logradas
			nombreJugador = fR.readLine().split(":")[1].trim();
			medallas = Integer.parseInt(fR.readLine().split(":")[1].trim());
			String bufferLectura = fR.readLine();
			//Carga cada uno de los elementos y los guarda en el ArrayList
			while( bufferLectura != null ) {
				fR.readLine();
				fR.readLine();
				String idInicial =fR.readLine();
				Nombres n = new Nombres();
				String nom = n.getNombre(idInicial.split(":")[1].trim());
				TiposDeElemento tE = n.element(Integer.parseInt(idInicial.split(":")[1].trim().split("-")[0].trim()));
				String id = idInicial.split(":")[1].trim();
				int nivel = Integer.parseInt(fR.readLine().split(":")[1].trim());
				int exp = Integer.parseInt(fR.readLine().split(":")[1].trim());
				String laVida = fR.readLine();
				int vida = Integer.parseInt(laVida.split(":")[1].trim().split("/")[0].trim());
				int vidaMax = Integer.parseInt(laVida.split(":")[1].trim().split("/")[1].trim());
				int ataque = Integer.parseInt(fR.readLine().split(":")[1].trim());
				int defensa = Integer.parseInt(fR.readLine().split(":")[1].trim());
				String movs = fR.readLine().split(":")[1].trim();
				Elemento e = new Elemento(nom, tE, id, nivel, exp, vida, vidaMax, ataque, defensa, movs);
				elementos.add(e);
				bufferLectura = fR.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Muestra en pantalla los datos del jugador
	 * También es usado para guardar la partida
	 * @return el String con la información
	 */
	public String toString() {
		String linea = "";
		linea += "Nombre: " + nombreJugador + "\n";
		linea += "Medallas: " + medallas + "\n";
		for (int i = 0; i < elementos.size(); i++) {
			linea += "Elemento " + (i + 1) + ":\n";
			linea += "\tNombre: " + elementos.get(i).getNombre() + "\n";
			linea += "\tTipo: " + elementos.get(i).gettE() + "\n";
			linea += "\tId: " + elementos.get(i).getId() + "\n";
			linea += "\tNivel: " + elementos.get(i).getNivel() + "\n";
			linea += "\tExperiencia: " + elementos.get(i).getExp() + "\n";
			linea += "\tVida: " + elementos.get(i).getVida() + "/" + elementos.get(i).getVidaMax() + "\n";
			linea += "\tAtaque: " + elementos.get(i).getAtaque() + "\n";
			linea += "\tDefensa: " + elementos.get(i).getDefensa() + "\n";
			String movs = "";
			movs += " " + elementos.get(i).getMov()[0];
			for(int j = 1; j < elementos.get(i).getMov().length; j++) {
				movs += ", " + elementos.get(i).getMov()[j];
			}
			linea += "\tMovimientos:" + movs + "\n";
		}
		return linea;
	}
	
	/**
	 * Guarda la partida escribiendo en un fichero
	 */
	public void guardar() {
		File f = new File("Archivos_de_guardado\\" + nombreFicheroGuardado);
		try {
			FileWriter fW = new FileWriter(f);
			fW.write(toString());
			fW.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Método que cura a los elementos
	 */
	public void sanar() {
		for (int i = 0; i < elementos.size(); i++) {
			elementos.get(i).setVida(elementos.get(i).getVidaMax());
		}
	}
	
	/*public static void main(String[] args) {
		Jugador j = new Jugador("C:\\Users\\david\\Desktop\\Combate_Rol\\Archivos_de_guardado\\Eledenthas.txt");
		j.guardar();
	}*/
}
