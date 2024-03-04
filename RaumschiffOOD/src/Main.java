
public class Main {

	public static void main(String[] args) {
		Raumschiff klingonen = new Raumschiff(1, 100, 100, 100, 100, 2, "IKS Hegh'ta");
		Raumschiff romulaner = new Raumschiff(2, 100, 100, 100, 100, 2, "IRW Khazara");
		Raumschiff vulkanier = new Raumschiff(0, 80, 80, 50, 100, 5, "Ni'Var");
		
		klingonen.addLadung(new Gaeste("Borg", 200, "Delta-Quadrant", "irrelevant, alphanumirischer Code", Verpflegungsart.ALL_INCLUSIVE));
		vulkanier.addLadung(new Gaeste("Ferengi", 10, "Ferenginar", "Ferengi", Verpflegungsart.VOLLPENSION));
		klingonen.addLadung(new Transportgueter("Ferengi Schneckensaft", 200, 0.2f, 0.2f, 0.1f));
		klingonen.addLadung(new Transportgueter("Bat'leth Klingonen Schwert", 200, 0.8f, 0.2f, 0.1f));
		romulaner.addLadung(new Transportgueter("Borg-Schrott", 5, 0.2f, 0.5f, 0.5f));
		romulaner.addLadung(new Transportgueter("Rote Materie", 2, 1.0f, 1.0f, 1.0f));
		romulaner.addLadung(new Transportgueter("Plasma-Waffe", 50, 1.0f, 1.0f, 1.0f));
		vulkanier.addLadung(new Transportgueter("Forschungssonde", 35, 100.0f, 50.0f, 25.0f));
		vulkanier.addLadung(new Transportgueter("Photonentorpedo", 3, 2.0f, 2.0f, 1.0f));
				
		klingonen.photonentorpedoSchiessen(romulaner);
		romulaner.phaserkanoneSchiessen(klingonen);
		vulkanier.nachrichtAnAlle("Gewalt ist nicht logisch");
		klingonen.zustandRaumschiff();
		klingonen.ladungsverzeichnisAusgeben();
		vulkanier.reparaturDurchfuehren(true, true, true, 5);
		vulkanier.photonentorpedosLaden(5);
		klingonen.photonentorpedoSchiessen(romulaner);
		klingonen.photonentorpedoSchiessen(romulaner);
		klingonen.zustandRaumschiff();
		klingonen.ladungsverzeichnisAusgeben();
		vulkanier.zustandRaumschiff();
		vulkanier.ladungsverzeichnisAusgeben();
		romulaner.zustandRaumschiff();
		romulaner.ladungsverzeichnisAusgeben();
		Raumschiff.eintraegeLogbuchZurueckgeben();
		
		
		
		
		

	}

}
