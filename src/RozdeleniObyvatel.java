import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;



public class RozdeleniObyvatel {

	int pocetObyvatel;
	private static int pocetPlanetCelkem = 10;
	private static int dolniMez = 100000;
	private static int horniMez = 1000000;
	private static Planeta []planety = new Planeta[pocetPlanetCelkem];
	private static PrintWriter pw;
	
	public static int gausovoRozdeleni(int prumer, int x, double odchylka ) {

		double mocnina = ((x-prumer)*(x-prumer))/(2*odchylka*odchylka);
		
		return (int)((1/(odchylka*Math.sqrt(2*Math.PI)))*Math.exp(-mocnina)); 
	}

	public static void main(String[] args) {
		
		int pocetPlanet = 0;
		int pocetObyvatel;
		String nazev;

		while(pocetPlanet != pocetPlanetCelkem){
			 
			pocetObyvatel = gausovoRozdeleni(0, 4, Math.sqrt(0.5));
			if (pocetObyvatel > dolniMez && pocetObyvatel < horniMez) {
				
				if (pocetObyvatel < 2000000) {
					nazev = "X" + pocetPlanet;
				}else if (pocetObyvatel < 4000000) {
					nazev = "Y" + pocetPlanet;
				}else if (pocetObyvatel < 7000000) {
					nazev = "Z" + pocetPlanet; 
				}else {
					nazev = "W" + pocetPlanet;
				}

				planety[pocetPlanet] = new Planeta(nazev,pocetObyvatel);
				pocetPlanet++;
			}
			
		}
		
	}
}
