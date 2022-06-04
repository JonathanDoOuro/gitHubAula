package pt.c40task.l05wumpus;

//import java.util.Random;

public class Componente {
	protected char caracter; 
	protected boolean vida;
	protected boolean artefato, flechaEquipada, ouroCapturado;
	protected int l, c, qtdFlechas;
	Caverna caverna;
	
	public Componente(char caracter, int l, int c, Caverna caverna) {
		this.caracter = caracter;
		this.l = l;
		this.c = c;
		this.vida = true;
		if (caracter == 'P'){
			this.artefato = true;
			this.qtdFlechas = 1;
		}
		else {
			this.artefato = false;
		}
		this.flechaEquipada = false;
		this.ouroCapturado = false;
		this.caverna = caverna;
	}
	
	public void instanciarSecundarios() {
		
	}
	
	public boolean matouWumpus() {
		return false;
	}
	
	public void conectarCaverna(Caverna caverna) {
		this.caverna = caverna;
	}

	public void setPosicao(int l, int c) {
		this.l = l;
		this.c = c;
	}
	
	public Caverna getCaverna(){return this.caverna;}
	
	public int getLinha() { return this.l; };
	
	public int getColuna() { return this.c; };
	
	public boolean temArtefato() {
		return artefato;
	}
	
	public void setArtefato(boolean artefato) {
		this.artefato = artefato;
	}
	
	public boolean getVida() {
		return vida;
	}
	
	public void setVida(boolean vida) {
		this.vida = vida;
	}
	
	public char getCaracter() {
		return caracter;
	}

	public void equiparFlecha() {return;}
	public boolean isFlechaEquipada() {return false;}


	public void capturarOuro() {return;}
	public boolean isOuroCapturado() {return false;}

	public int getQtdFlehas() { return 0;}

	public void mover(char mov) {return;}

	public boolean batalhar(){return false;}
 
}
