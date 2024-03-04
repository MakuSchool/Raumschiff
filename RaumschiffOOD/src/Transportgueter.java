
public class Transportgueter extends Ladung{
	private float laenge;
	private float breite;
	private float hoehe;
	
	/**
	 * Vollparametisierter-Konstruktor der Transportgüter
	 * 
	 * @param bezeichnung = Bezeichnung der Transportgüter
	 * @param menge = Menge der Transportgüter
	 * @param laenge = Länge der Güter 
	 * @param breite = Breite der Güter
	 * @param hoehe = Höhe der Güter
	 */
	public Transportgueter(String bezeichnung, int menge, float laenge, float breite, float hoehe) {
		super(bezeichnung, menge);
		this.laenge = laenge;
		this.breite = breite;
		this.hoehe = hoehe;
	}
	
	public Transportgueter() {} 
	
	public float getLaenge() {
		return laenge;
	}
	public void setLaenge(float laenge) {
		this.laenge = laenge;
	}
	public float getBreite() {
		return breite;
	}
	public void setBreite(float breite) {
		this.breite = breite;
	}
	public float getHoehe() {
		return hoehe;
	}
	public void setHoehe(float hoehe) {
		this.hoehe = hoehe;
	}
	
	
}
