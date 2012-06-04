package org.kramaframework.demo;

public class Operation {

	private int resultat;
	
	public Operation() {
	}
	
	public Operation(int i) {
		this.resultat = i;
	}

	public Operation getValeur(Integer i, Integer j, String type){
		
		if(type.equals("somme"))
			return new Operation(i+j);
		else if (type.equals("soustraction"))
			return new Operation(i-j);
		else 
			return new Operation(0);
	}

	public int getResultat() {
		return resultat;
	}

	public void setResultat(int resultat) {
		this.resultat = resultat;
	}
}
