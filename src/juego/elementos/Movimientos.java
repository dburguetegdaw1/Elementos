package juego.elementos;

import java.util.HashMap;

public class Movimientos {
	HashMap<String, TiposDeElemento> movs;

	public Movimientos() {
		this.movs = new HashMap<>();
		movs.put("Placaje", TiposDeElemento.Tierra);
		movs.put("Corte", TiposDeElemento.Tierra);
		movs.put("Estrangular", TiposDeElemento.Tierra);
		movs.put("Terremoto", TiposDeElemento.Tierra);
		movs.put("Chorro de Agua", TiposDeElemento.Agua);
		movs.put("Geiser", TiposDeElemento.Agua);
		movs.put("Tsunami", TiposDeElemento.Agua);
		movs.put("Corriente marina", TiposDeElemento.Agua);
		movs.put("Ventisca", TiposDeElemento.Aire);
		movs.put("Ciclon", TiposDeElemento.Aire);
		movs.put("Tormenta", TiposDeElemento.Aire);
		movs.put("Vendaval", TiposDeElemento.Aire);
		movs.put("Brasas", TiposDeElemento.Fuego);
		movs.put("Quemadura", TiposDeElemento.Fuego);
		movs.put("Llamarada", TiposDeElemento.Fuego);
		movs.put("Infierno", TiposDeElemento.Fuego);
		movs.put("Mordisco", TiposDeElemento.Vida);
		movs.put("Pisoton", TiposDeElemento.Vida);
		movs.put("Acido", TiposDeElemento.Vida);
		movs.put("Furia", TiposDeElemento.Vida);
		movs.put("Veneno", TiposDeElemento.Muerte);
		movs.put("Castigo", TiposDeElemento.Muerte);
		movs.put("Purgatorio", TiposDeElemento.Muerte);
		movs.put("Necromancia", TiposDeElemento.Muerte);
	}
	
	public String aprender(Elemento e) {
		String aAprender = "";
		switch(e.gettE()) {
		case Tierra:
			switch(Integer.parseInt(e.getId().split("-")[1])) {
			case 1:
				String[] movs = {"Estrangular", "Chorro de agua", "Placaje", "Vendaval", "Quemadura", "Geiser", "Corte", "Furia", "Terremoto"};
				aAprender = movs[e.getNivel()/5];
				break;
			case 2:
				aAprender = movs[e.getNivel()/5];
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			case 6:
				
				break;
			case 7:
				
				break;
			case 8:
				
				break;
			case 9:
				
				break;
			}
			break;
		case Agua:
			switch(Integer.parseInt(e.getId().split("-")[1])) {
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			case 6:
				
				break;
			case 7:
				
				break;
			case 8:
				
				break;
			case 9:
				
				break;
			}
			break;
		case Aire:
			switch(Integer.parseInt(e.getId().split("-")[1])) {
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			case 6:
				
				break;
			case 7:
				
				break;
			case 8:
				
				break;
			case 9:
				
				break;
			}
			break;
		case Fuego:
			switch(Integer.parseInt(e.getId().split("-")[1])) {
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			case 6:
				
				break;
			case 7:
				
				break;
			case 8:
				
				break;
			case 9:
				
				break;
			}
			break;
		case Vida:
			switch(Integer.parseInt(e.getId().split("-")[1])) {
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			case 6:
				
				break;
			case 7:
				
				break;
			case 8:
				
				break;
			case 9:
				
				break;
			}
			break;
		case Muerte:
			switch(Integer.parseInt(e.getId().split("-")[1])) {
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			case 6:
				
				break;
			case 7:
				
				break;
			case 8:
				
				break;
			case 9:
				
				break;
			}
			break;
		}
		return aAprender;
	}
}
