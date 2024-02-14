import java.util.ArrayList;

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
	
	
	
	public Raumschiff(int photonentorpedoAnzahl, int energieversorgungInProzent, int schildInProzent,
			int huelleInProzent, int lebenserhaltungssystemeInProzent, int androidenAnzahl, String schiffsname) {
		super();
		this.photonentorpedoAnzahl = photonentorpedoAnzahl;
		this.energieversorgungInProzent = energieversorgungInProzent;
		this.schildInProzent = schildInProzent;
		this.huelleInProzent = huelleInProzent;
		this.lebenserhaltungssystemeInProzent = lebenserhaltungssystemeInProzent;
		this.androidenAnzahl = androidenAnzahl;
		this.schiffsname = schiffsname;
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
	
	public void addLadung(Ladung neueLadung) {
		this.ladungsverzeichnis.add(neueLadung);
	}
	
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
	
	public void nachrichtAnAlle(String message) {
		Raumschiff.getBroadcastKommunikator().add(message);
	}
	
	public static void eintraegeLogbuchZurueckgeben(){
		System.out.println("Kommunikator: " + getBroadcastKommunikator());
	}
	
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
	
	public void ladungsverzeichnisAusgeben() {
		this.ladungsverzeichnisAufraeumen();
		System.out.println("Ladungsverzeichnis von " + this.getSchiffsname() + ": \n");
		for(Ladung l : this.getLadungsverzeichnis()) {
			System.out.println(l.toString() + "\n");
		}
	}
	
	public void ladungsverzeichnisAufraeumen() {
		ArrayList<Ladung> verzeichnis = this.getLadungsverzeichnis();
		for(int i = 0; i < verzeichnis.size(); i++) {
			if(verzeichnis.get(i).getMenge() <= 0) {
				this.getLadungsverzeichnis().remove(i);
			}
		}
	}
	
	
	
	

}
