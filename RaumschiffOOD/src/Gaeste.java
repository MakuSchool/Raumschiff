
public class Gaeste extends Ladung{
	private String sprache;
	private String heimatplanet;
	private Verpflegungsart verpflegungsart;
	
	/**
	 * Vollparametisierter-Konstruktor für Gäste
	 *  
	 * @param bezeichnung = Name der Ladung
	 * @param menge = Menge der Ladung
	 * @param sprache = Sprache der Gäste
	 * @param heimatplanet = Heimatplanet der Gäste
	 * @param verpflegungsart = Verpflegungsart der Gäste
	 */
	public Gaeste(String bezeichnung, int menge, String sprache, String heimatplanet, Verpflegungsart verpflegungsart) {
		super(bezeichnung, menge);
		this.sprache = sprache;
		this.heimatplanet = heimatplanet;
		this.verpflegungsart = verpflegungsart;
	}
	
	public Gaeste() {}

	public String getSprache() {
		return sprache;
	}

	public void setSprache(String sprache) {
		this.sprache = sprache;
	}

	public String getHeimatplanet() {
		return heimatplanet;
	}

	public void setHeimatplanet(String heimatplanet) {
		this.heimatplanet = heimatplanet;
	}

	public Verpflegungsart getVerpflegungsart() {
		return verpflegungsart;
	}

	public void setVerpflegungsart(Verpflegungsart verpflegungsart) {
		this.verpflegungsart = verpflegungsart;
	}
	
	
	
	
	
}
