package pt.c40task.l05wumpus;

import java.util.Random;

public class Heroi extends Componente{
	Heroi (int l, int c, Caverna caverna) {
		super('P', l, c, caverna);
	}

	public void equiparFlecha() {
		if (this.qtdFlechas == 1) {
			this.flechaEquipada = true;
			this.qtdFlechas = 0;
		}
	}
	public boolean isFlechaEquipada() {
		return this.flechaEquipada;
	}

	public void capturarOuro() {
		if (caverna.capturarOuro(l, c)) {
			this.ouroCapturado = true;
		}else {
			this.ouroCapturado = false;
		}
	}
	public boolean isOuroCapturado() {
		return this.ouroCapturado;
	}

	public int getQtdFlehas() { return this.qtdFlechas; };

	public void mover(char mov) {
		caverna.movimentar(mov, this.l, this.c); //ta dando erro falando que essa caverna pode ser null, não consegui arrumar
	}
	
	public boolean matouWumpus() {
		if (caverna.temWumpus(l, c))
			if(this.caverna.getWumpus(this.l, this.c).getVida() == false)
				return true;
		return false;
	}
	
	public boolean batalhar(){
		//devolve true se o heroi ganhar e false se ele perder
		Random rand = new Random();
		int venceu = rand.nextInt(2);
		if(venceu == 1) 
			return true;
		else 
			return false;
	}



}