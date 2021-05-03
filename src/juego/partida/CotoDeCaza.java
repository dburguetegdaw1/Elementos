package juego.partida;

import java.util.Random;
import java.util.Scanner;

public class CotoDeCaza {

	
	public void interfazCampo() {
		try {new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();} catch (Exception e) {}
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("      wWWWw               wWWWw");
		System.out.println("vVVVv (___) wWWWw         (___)  vVVVv");
		System.out.println("(___)  ~Y~  (___)  vVVVv   ~Y~   (___)");
		System.out.println(" ~Y~   \\|    ~Y~   (___)    |/    ~Y~\"");
		System.out.println(" \\|   \\ |/   \\| /  \\~Y~/   \\|    \\ |/");
		System.out.println("\\\\|// \\\\|// \\\\|/// \\\\|//  \\\\|// \\\\\\|///");
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println("");
		System.out.println("                                 wWWWw               wWWWw");
		System.out.println("                           vVVVv (___) wWWWw         (___)  vVVVv");
		System.out.println("                           (___)  ~Y~  (___)  vVVVv   ~Y~   (___)");
		System.out.println("                            ~Y~   \\|    ~Y~   (___)    |/    ~Y~");
		System.out.println("                            \\|   \\ |/   \\| /  \\~Y~/   \\|    \\ |/");
		System.out.println("         wWWWw             \\\\wWWWw\\|// \\\\|/// \\\\|//  \\\\|// \\\\\\|///");
		System.out.println("   vVVVv (___) wWWWw       ^^(___)^^vVVVv^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println("   (___)  ~Y~  (___)  vVVVv   ~Y~   (___)");
		System.out.println("    ~Y~   \\|    ~Y~   (___)    |/    ~Y~");
		System.out.println("    \\|   \\ |/   \\| /  \\~Y~/   \\|    \\ |/");
		System.out.println("   \\\\|// \\\\|// \\\\|/// \\\\|//  \\\\|// \\\\\\|///");
		System.out.println("   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println("Estas a la espera de ver si aparece algún elemento en estado salvaje...");
		boolean pac = esperar();
		do {
			pac = esperar();
		}while (pac);
	}
	
	@SuppressWarnings("resource")
	private boolean esperar() {
		boolean paciencia = false;
		boolean aparecido = false;
		for (int i = 0; i < 30; i++) {
			try {Thread.sleep(1*1000);} catch (Exception e) {System.out.println(e);}
			Random rand = new Random();
			int num = (int) (rand.nextDouble() * 100 + 1);
			if(num <= 5) {
				System.out.println("Combate!");
				aparecido = true;
				try {Thread.sleep(1*1000);} catch (Exception e) {System.out.println(e);}
				combate();
				break;
			}
		}
		if(!aparecido) {
			System.out.println("No se ha encontrado ninguno...");
		}
		System.out.println("¿Quieres seguir buscando elementos?(S/N)");
		Scanner sc = new Scanner(System.in);
		String op = sc.next().toUpperCase();
		while(!(op.equals("S")) || !(op.equals("N"))) {
			if (op.equals("S")) {
				paciencia = true;
				break;
			}
			else if (op.equals("N")) {
				break;
			}
			else {
				System.out.println("¡OPCIÓN INCORRECTA!");
				op = sc.next().toUpperCase();
			}
		}
		return paciencia;
	}
	
	private void combate() {
		
	}
}
