
public class Ladung {
	private String bezeichnung;
	private int menge;
	
	public Ladung() {
		super();
	}
	
	public Ladung(String bezeichnung, int menge) {
		super();
		this.bezeichnung = bezeichnung;
		this.menge = menge;
	}
	
	public String getBezeichnung() {
		return bezeichnung;
	}
	
	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}
	
	public int getMenge() {
		return menge;
	}
	
	public void setMenge(int menge) {
		this.menge = menge;
	}
	
	public String toString() {
		return this.getBezeichnung() + ": " + this.getMenge();
	}
	
}
