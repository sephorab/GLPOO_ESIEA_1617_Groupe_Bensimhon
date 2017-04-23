package com.eggame.enfant;

public class Enfant {

	private int posX;
	private int posY;
	private String orientation; // inclinaison de l'enfant (nord/N,sud/S,est/E,ouest/O)
	private int oeufsRamasses;
	private String nom;
	
	public Enfant() {
	}
	
	public Enfant(String nom,int x,int y,String or) {
		this.nom=nom;
		this.posX=x;
		this.posY=y;
		this.orientation=or;
		this.oeufsRamasses=0;
	}
	
	public void setNom(String nom) {
		this.nom=nom;
	}
	public void setPosX(int x) {
	posX=x;
	}
	
	public void setPosY(int y) {
		posY=y;
	}
	
	public void setOrientation(String or) {
		orientation=or;
	}
	public int getPosX() {
		return posX;
	}
	public int getPosY(){
		return posY;
	}
	public String getNom() {
		return nom;
	}
	
	public String getOrientation() {
		return orientation;
	}
	
	public void avancer() {		
		
		switch(orientation){
		case "N":
			posY-=1;
			break;
		case "S" :
			posY+=1;
			break;
		case "O" :
			posX-=1;
			break;
		case "E" :
			posX+=1;
			break;
		}
		
	}
	
	public void changerOrientation(String rotation) {
		switch(orientation) {
		case "N":
			if(rotation=="G")
				orientation="O";
			else //orientation=="D"
				orientation="E";
		break;
		case "S":
			if(rotation=="G")
				orientation="E";
			else //orientation=="D"
				orientation="O";
		break;
		case "O":
			if(rotation=="G")
				orientation="S";
			else //orientation=="D"
				orientation="N";
		break;
		case "E":
			if(rotation=="G")
				orientation="N";
			else //orientation=="D"
				orientation="S";
		break;
		}
	}
	
	
}