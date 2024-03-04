
public class Transportgueter extends Ladung{
	private float laengeMeter;
	private float breiteMeter;
	private float hoeheMeter;
	
	/**
	 * Vollparametisierter-Konstruktor der Transportgüter
	 * 
	 * @param bezeichnung = Bezeichnung der Transportgüter
	 * @param menge = Menge der Transportgüter
	 * @param laengeMeter = Länge der Güter 
	 * @param breiteMeter = Breite der Güter
	 * @param hoeheMeter = Höhe der Güter
	 */
	public Transportgueter(String bezeichnung, int menge, float laengeMeter, float breiteMeter, float hoeheMeter) {
		super(bezeichnung, menge);
		this.laengeMeter = laengeMeter;
		this.breiteMeter = breiteMeter;
		this.hoeheMeter = hoeheMeter;
	}
	
	public Transportgueter() {} 
	
	public float getLaengeMeter() {
		return laengeMeter;
	}
	public void setLaengeMeter(float laengeMeter) {
		this.laengeMeter = laengeMeter;
	}
	public float getBreiteMeter() {
		return breiteMeter;
	}
	public void setBreiteMeter(float breiteMeter) {
		this.breiteMeter = breiteMeter;
	}
	public float getHoeheMeter() {
		return hoeheMeter;
	}
	public void setHoeheMeter(float hoeheMeter) {
		this.hoeheMeter = hoeheMeter;
	}
	
	
}
