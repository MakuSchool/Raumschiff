/**
 * @author Max
 * 
 * @version 1.0
 * 
 */

public class Ladung {
	private String bezeichnung;
	private int menge;
	
	/**
	 * Parameterloser Konstruktor für Ladung  
	 */
	public Ladung() {
		super();
	}
	
	/**
	 * Teilparametisierter Konstruktor
	 * 
	 * @param bezeichnung 
	 * Name der Ladung als String
	 * @param menge
	 * Menge der Ladung als Integer
	 */
	public Ladung(String bezeichnung, int menge) {
		super();
		this.bezeichnung = bezeichnung;
		this.menge = menge;
	}
	
	/**
	 * Getter Methode für den Namen der Ladung
	 * @return Name der Ladung als String
	 */
	public String getBezeichnung() {
		return bezeichnung;
	}
	
	/**
	 * Setter Methode für den Namen der Ladung
	 * @param bezeichnung Neuer Name der Ladung
	 */
	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}
	
	/**
	 * Getter Methode für die Menge der Ladung
	 * @return Menge der Ladung als Integer
	 */
	public int getMenge() {
		return menge;
	}
	
	/**
	 * Setter Methode für die Menge der Ladung
	 * @param menge Neue Menge der ladung als Integer
	 */
	public void setMenge(int menge) {
		this.menge = menge;
	}
	
	/**
	 * toString Methode der Ladungsklasse
	 * 
	 * {NameDerLadung : MengeDerLadung}
	 */
	public String toString() {
		return this.getBezeichnung() + ": " + this.getMenge();
	}
	
}
