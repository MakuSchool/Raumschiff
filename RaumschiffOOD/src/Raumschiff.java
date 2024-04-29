/**
 * @author Max
 * 
 * @version 1.0
 * 
 * @since 14.02.2024
 */

import java.util.ArrayList;

/**
 * Raumschiffklasse
 */
public class Raumschiff {
	
	private int photonentorpedoAnzahl;
	private int energieversorgungInProzent;
	private int schildInProzent;
	private int huelleInProzent;
	private int lebenserhaltungssystemeInProzent;
	private int androidenAnzahl;
	private String schiffsname;
	private static ArrayList<String> broadcastKommunikator = new ArrayList<String>();
	private ArrayList<Ladung> ladungsverzeichnis = new ArrayList<Ladung>();
	private Verwaltung verwaltung;
	
	
	/**
	 * Vollparametisierter Konstruktor
	 * 
	 * @param photonentorpedoAnzahl Anzahl Photonentorpedos
	 * @param energieversorgungInProzent Energieversorgung
	 * @param schildInProzent	Schild
	 * @param huelleInProzent	Hülle
	 * @param lebenserhaltungssystemeInProzent	Lebenserhaltungssysteme
	 * @param androidenAnzahl	Anzahl der Androids
	 * @param schiffsname	Name des Schiffs
	 */
	public Raumschiff(int photonentorpedoAnzahl, int energieversorgungInProzent, int schildInProzent,
			int huelleInProzent, int lebenserhaltungssystemeInProzent, int androidenAnzahl, String schiffsname, Verwaltung verwaltung) {
		super();
		this.photonentorpedoAnzahl = photonentorpedoAnzahl;
		this.energieversorgungInProzent = energieversorgungInProzent;
		this.schildInProzent = schildInProzent;
		this.huelleInProzent = huelleInProzent;
		this.lebenserhaltungssystemeInProzent = lebenserhaltungssystemeInProzent;
		this.androidenAnzahl = androidenAnzahl;
		this.schiffsname = schiffsname;
		this.verwaltung = verwaltung;
	}
	
	public Raumschiff() {
		super();
	}
	
	public int getPhotonentorpedoAnzahl() {
		return photonentorpedoAnzahl;
	}
	
	public void setPhotonentorpedoAnzahl(int photonentorpedoAnzahl) {
		this.photonentorpedoAnzahl = photonentorpedoAnzahl;
	}
	
	public int getEnergieversorgungInProzent() {
		return energieversorgungInProzent;
	}
	
	public void setEnergieversorgungInProzent(int energieversorgungInProzent) {
		this.energieversorgungInProzent = energieversorgungInProzent;
	}
	
	public int getSchildInProzent() {
		return schildInProzent;
	}
	
	public void setSchildInProzent(int schildInProzent) {
		this.schildInProzent = schildInProzent;
	}
	
	public int getHuelleInProzent() {
		return huelleInProzent;
	}
	
	public void setHuelleInProzent(int huelleInProzent) {
		this.huelleInProzent = huelleInProzent;
	}
	
	public int getLebenserhaltungssystemeInProzent() {
		return lebenserhaltungssystemeInProzent;
	}
	
	public void setLebenserhaltungssystemeInProzent(int lebenserhaltungssystemeInProzent) {
		this.lebenserhaltungssystemeInProzent = lebenserhaltungssystemeInProzent;
	}
	
	public int getAndroidenAnzahl() {
		return androidenAnzahl;
	}
	
	public void setAndroidenAnzahl(int androidenAnzahl) {
		this.androidenAnzahl = androidenAnzahl;
	}
	
	public String getSchiffsname() {
		return schiffsname;
	}
	
	public void setSchiffsname(String schiffsname) {
		this.schiffsname = schiffsname;
	}
	
	public static ArrayList<String> getBroadcastKommunikator() {
		return Raumschiff.broadcastKommunikator;
	}
	
	public static void setBroadcastKommunikator(ArrayList<String> broadcastKommunikator) {
		Raumschiff.broadcastKommunikator = broadcastKommunikator;
	}
	
	public ArrayList<Ladung> getLadungsverzeichnis() {
		return ladungsverzeichnis;
	}
	
	public void setLadungsverzeichnis(ArrayList<Ladung> ladungsverzeichnis) {
		this.ladungsverzeichnis = ladungsverzeichnis;
	}
	
	/**
	 * Lade neue Ladung
	 * @param neueLadung = die zuladene Ladung
	 */
	public void addLadung(Ladung neueLadung) {
		this.ladungsverzeichnis.add(neueLadung);
	}
	
	/**
	 * Schiesse Photonentorpedos auf ein anderes Raumschiff
	 * @param r = das zu treffende Raumschiff
	 */
	public void photonentorpedoSchiessen(Raumschiff r) {
		int anzahl_torpedos = this.getPhotonentorpedoAnzahl();
		if(anzahl_torpedos == 0) {
			System.out.println("-=*Click*=-");
		} else {
			anzahl_torpedos--;
			this.setPhotonentorpedoAnzahl(anzahl_torpedos);
			this.nachrichtAnAlle("Photonentorpedo abgeschossen");
			this.treffer(r);
		}
	}
	
	/**
	 * Schiesse mit der Phaserkanone auf ein anderes Schiff
	 * @param r = das zu treffende Raumschiff
	 */
	public void phaserkanoneSchiessen(Raumschiff r) {
		int energie = this.getEnergieversorgungInProzent();
		if(energie < 50) {
			this.nachrichtAnAlle("-=*Click*=-");
		} else {
			energie -= 50;
			this.setEnergieversorgungInProzent(energie);
			this.nachrichtAnAlle("Phaserkanone abgeschossen");
			this.treffer(r);
		}
	}
	
	/**
	 * Berechne neue Prozente des Raumschiffs nach Treffer
	 * @param r = das getroffene Raumschiff
	 */
	private void treffer(Raumschiff r) {
		System.out.println(r.getSchiffsname() + " wurde getroffen!");
		int schild = r.getSchildInProzent();
		int huelle = r.getHuelleInProzent();
		int energie = r.getEnergieversorgungInProzent();
		schild -= 50;
		if(schild <= 0) {
			r.setSchildInProzent(0);
			huelle -= 50;
			energie -= 50;
			r.setHuelleInProzent(huelle);
			r.setEnergieversorgungInProzent(energie);
		} else {
			r.setSchildInProzent(schild);
		}
		if(huelle <= 0) {
			r.setLebenserhaltungssystemeInProzent(0);
			r.nachrichtAnAlle("Lebenserhaltungssysteme wurden zerstört!");
		}
	}
	
	/**
	 * Sende Nachricht durch den Broadcastkomminikator
	 * @param message = die zusendene Nachricht
	 */
	public void nachrichtAnAlle(String message) {
		Raumschiff.getBroadcastKommunikator().add(message);
	}
	
	/**
	 * Gebe alle Eintraege aus dem Logbuch wieder
	 */
	public static void eintraegeLogbuchZurueckgeben(){
		System.out.println("Kommunikator: " + getBroadcastKommunikator());
	}
	
	/**
	 * Lade neue Torpedos, wenn welche im Lager
	 * @param anzahlTorpedos = die Anzahl der zulandenen Torpedos
	 */
	public void photonentorpedosLaden(int anzahlTorpedos) {
		ArrayList<Ladung> verzeichnis = this.getLadungsverzeichnis();
		int anzahlTorpedosRest = anzahlTorpedos; 
		for(int i = 0; i < verzeichnis.size(); i++) {
			if(verzeichnis.get(i).getBezeichnung().equals("Photonentorpedos")) {
				if(verzeichnis.get(i).getMenge() <= anzahlTorpedosRest) {
					this.setPhotonentorpedoAnzahl(verzeichnis.get(i).getMenge());
					anzahlTorpedosRest -= verzeichnis.get(i).getMenge();
					this.getLadungsverzeichnis().get(i).setMenge(0);
				} else {
					this.setPhotonentorpedoAnzahl(anzahlTorpedosRest);
					this.getLadungsverzeichnis().get(i).setMenge(verzeichnis.get(i).getMenge()-anzahlTorpedosRest);
					System.out.println(anzahlTorpedos + " Photonentorpedo(s) eingesetzt");
				}
			} else if (verzeichnis.get(i).getBezeichnung() != "Photonentorpedos" && (i+1) == verzeichnis.size()) {
				System.out.println("Keine Photonentorpedos gefunden!");
				this.nachrichtAnAlle("-=*Click*=-");
			}
			if(anzahlTorpedosRest > 0 && (i+1) == verzeichnis.size()) {
				System.out.println(anzahlTorpedos - anzahlTorpedosRest + " Photonentorpedo(s) eingesetzt"); 
			}
		}
	}
	
	/**
	 * Repariere, Schutzschild, Energieversorgung und Schiffhuelle nach einer zufälligen Reperaturzahl
	 * @param schutzschilde = soll Schutzschild repariert werden
	 * @param energieversorgung = soll die Energieversorgung repariert werden
	 * @param schiffshuelle = soll die Schiffhuelle repariert werden
	 * @param anzahlDroids = wie viele Androids möchteste du einsetzen 
	 */
	public void reparaturDurchfuehren(boolean schutzschilde, boolean energieversorgung, boolean schiffshuelle, int anzahlDroids) {
		if(this.getAndroidenAnzahl() < anzahlDroids) {
			anzahlDroids = this.getAndroidenAnzahl();
		}
		int zufallszahl = (int) Math.floor(Math.random()*101);
		int strukturen = 0;
		if(schutzschilde) {strukturen++;}
		if(energieversorgung) {strukturen++;}
		if(schiffshuelle) {strukturen++;}
		int reparatur = (zufallszahl + Math.abs(anzahlDroids))/strukturen; 
		if(schutzschilde) {
			if(this.getSchildInProzent()+reparatur <= 100) {
				this.setSchildInProzent(this.getSchildInProzent()+reparatur);
			} else {
				this.setSchildInProzent(100);
			}
		}
		if(energieversorgung) {
			if(this.getEnergieversorgungInProzent()+reparatur <= 100) {
				this.setEnergieversorgungInProzent(this.getEnergieversorgungInProzent()+reparatur);
			} else {
				this.setEnergieversorgungInProzent(100);
			}
		}
		if(schiffshuelle) {
			if(this.getHuelleInProzent()+reparatur <= 100) {
				this.setHuelleInProzent(this.getHuelleInProzent()+reparatur);
			} else {
				this.setHuelleInProzent(100);
			}
		}
	}
	
	/**
	 * Gibt den Zustand des Raumschiffs aus
	 */
	public void zustandRaumschiff() {
		System.out.println("-------------Zustand-------------\n"
						 + "Photonentorpedo(s): " + this.getPhotonentorpedoAnzahl() + "\n"
						 + "Energieversorgung: " + this.getEnergieversorgungInProzent() + "%\n"
						 + "Schilde: " + this.getSchildInProzent() + "%\n"
						 + "Hülle: " + this.getHuelleInProzent() + "%\n"
						 + "Lebenserhaltungssysteme: " + this.getLebenserhaltungssystemeInProzent()+ "%\n"
						 + "Androiden: " + this.getAndroidenAnzahl() + "\n"
						 + "Schiffsname: " + this.getSchiffsname() + "\n");
	}
	
	/**
	 * Gibt das ganze Ladungsverzeichnis des Raumschiffs aus
	 */
	public void ladungsverzeichnisAusgeben() {
		this.ladungsverzeichnisAufraeumen();
		System.out.println("Ladungsverzeichnis von " + this.getSchiffsname() + ": \n");
		for(Ladung l : this.getLadungsverzeichnis()) {
			System.out.println(l.toString() + "\n");
		}
	}
	
	/**
	 * Löscht alle Ladungseintraege die Null als Menge haben
	 */
	public void ladungsverzeichnisAufraeumen() {
		ArrayList<Ladung> verzeichnis = this.getLadungsverzeichnis();
		for(int i = 0; i < verzeichnis.size(); i++) {
			if(verzeichnis.get(i).getMenge() <= 0) {
				this.getLadungsverzeichnis().remove(i);
			}
		}
	}
	
	public void ladungsverzeichnisToFile() {
		this.verwaltung.writeToFile("C:\\Users\\Max\\Desktop\\Dokumente\\Ladung.txt", this.ladungsverzeichnis);
	}
	
	
	
	

}
