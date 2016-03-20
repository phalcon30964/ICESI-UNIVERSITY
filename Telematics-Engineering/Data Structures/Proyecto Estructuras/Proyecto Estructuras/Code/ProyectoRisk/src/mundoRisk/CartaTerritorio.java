package mundoRisk;

import java.io.Serializable;

public class CartaTerritorio implements Serializable {

	private static final long serialVersionUID = 8137704202514416680L;

	private String tipoCarta;
	
	private String territorio;
	
	private String tipoTropa;
	
	
	
	/**
	 * Construtor de la clase carta territorio que administra la informacion de las cartas tipo territorio
	 * 
	 * @param tipoCarta tipo de carta CARTA_MISION ó CARTA_TERRITORIO
	 * @param territorio String nombre del territorio al que representa la carta
	 * @param tipoTropa  String tipo de que representa
	 */
    public CartaTerritorio(String tipoCarta, String territorio, String tipoTropa){

    	this.tipoCarta = tipoCarta;
    	
    	this.territorio = territorio;
    	
    	this.tipoTropa = tipoTropa;	
    }
    
    /**
	 * 
	 * Dice el tipo de carta que es, tipo de carta CARTA_MISION ó CARTA_TERRITORIO
	 * 
	 * @return tipo de carta 
	 */
	public String getTipoCarta() {
		return tipoCarta;
	}
	
	 /**
	  * Dice el territorio al cual la carta representa
	  * 
	  * @return tipo de carta 
	  */
	public String getTerritorio() {
		return territorio;
	}

	 /**
	  * Dice el tipo de tropa el cual la carta representa, como caballeria, infanteria o artilleria
	  * 
	  * @return tipo de carta 
	  */
	public String getTipoTropa() {
		return tipoTropa;
	}

	public void setTipoCarta(String tipoCarta) {
		this.tipoCarta = tipoCarta;
	}

	public void setTerritorio(String territorio) {
		this.territorio = territorio;
	}

	public void setTipoTropa(String tipoTropa) {
		this.tipoTropa = tipoTropa;
	}
    
    



}
