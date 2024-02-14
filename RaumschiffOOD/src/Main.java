
public class Main {

	public static void main(String[] args) {
		Raumschiff klingonen = new Raumschiff(1, 100, 100, 100, 100, 2, "IKS Hegh'ta");
		Raumschiff romulaner = new Raumschiff(2, 100, 100, 100, 100, 2, "IRW Khazara");
		Raumschiff vulkanier = new Raumschiff(0, 80, 80, 50, 100, 5, "Ni'Var");
		
		klingonen.addLadung(new Ladung("Ferengi Schneckensaft", 200));
		klingonen.addLadung(new Ladung("Bat'leth Klingonen Schwert", 200));
		romulaner.addLadung(new Ladung("Borg-Schrott", 5));
		romulaner.addLadung(new Ladung("Rote Materie", 2));
		romulaner.addLadung(new Ladung("Plasma-Waffe", 50));
		vulkanier.addLadung(new Ladung("Forschungssonde", 35));
		vulkanier.addLadung(new Ladung("Photonentorpedos", 3));
		
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
