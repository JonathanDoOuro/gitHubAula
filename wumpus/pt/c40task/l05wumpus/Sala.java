package pt.c40task.l05wumpus;

public class Sala {
	private Componente conteudoSala[];
	/* vetor de 4 posições, componentes inseridos em ordem de visibilidade.
	   		posição zero: Wumpus, Buraco ou Ouro.
	   		posicão um: Herói.
	   		posição dois: Fedor.
	   		posição três: Brisa.
	   Quando não tem nada na posição é declarado um null.
	 */	
	private boolean vazia, visitada = false;
	
	Sala(boolean vazia) {
		this.vazia = vazia;
		this.conteudoSala = new Componente[4];
 		for (int i = 0; i < 4; i++)
			conteudoSala[i] = null;
	}

	public void add(Componente componente) {
		if (componente.getCaracter() == 'W' || componente.getCaracter() == 'B' || componente.getCaracter() == 'O')
			conteudoSala[0] = componente;
		else if (componente.getCaracter() == 'P')
			conteudoSala[1] = componente;
		else if (componente.getCaracter() == 'f')
			conteudoSala[2] = componente;
		else if (componente.getCaracter() == 'b')
			conteudoSala[3] = componente;
	}
	
	public Componente getHeroi() { 
		return conteudoSala[1]; 
	}
	
	public void addHeroi(Componente heroi) {
		this.visitada = true;
		if (heroi != null && this.conteudoSala[0] != null && this.conteudoSala[0].getCaracter() != 'O') {
			if(this.conteudoSala[0].getCaracter() == 'B')
				heroi.setVida(false);
			else {
				if(heroi.isFlechaEquipada()){
					if(heroi.batalhar()){
						conteudoSala[0].setVida(false); //Wumpus morreu
					}
					else 
						heroi.setVida(false);
				}
				else 
					heroi.setVida(false);
			}
		}
		this.conteudoSala[1] = heroi; 
		
	}
	
	public void removerHeroi() { 
		this.addHeroi(null); 
	}
	
	public boolean temHeroi() {
		if (this.conteudoSala[1] != null) { //&& this.conteudoSala[1].getVida()) {
			return true;
		}
		return false;
	}

	public Componente getBuraco() {
		if (conteudoSala[0].getCaracter() == 'B')
			return this.conteudoSala[0];
		else
			return null;
	}
	
	public Componente getWumpus() {
		if (conteudoSala[0] != null && conteudoSala[0].getCaracter() == 'W') {
			return conteudoSala[0];
		}else
			return null;
	}
	
	public boolean temFedor() {
		if (this.conteudoSala[2] != null) {
			return true;
		}
		return false;
	}
	
	public boolean temBrisa() {
		if (this.conteudoSala[3] != null) {
			return true;
		}
		return false;
	}
	
	public boolean capturarOuro() {
		if(this.conteudoSala[0].getCaracter() == 'O') {
			this.conteudoSala[0] = null;
			return true;
		}else {
			return false;
		}
	}
	
	public boolean isVazia() {
		return vazia;
	}
	
	public void visitar() {
		this.visitada = true;
	}
	
	public boolean getVisitada() {
		return this.visitada;
	}
	
	public char componenteDoTopo() {
		for (int i = 0; i < 4; i++) {
			if (conteudoSala[i] != null && (this.visitada || conteudoSala[i].getCaracter() == 'P') && conteudoSala[i].getVida()) {
				return conteudoSala[i].getCaracter();
			}
		}
		if (this.visitada)
				return '#';
		else
			return '_';
	}
	
	public int getTamanho() {
		return conteudoSala.length;
	}
}