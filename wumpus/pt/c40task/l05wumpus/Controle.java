package pt.c40task.l05wumpus;

public class Controle {
	//private Caverna caverna;
	private Componente heroi;
	private int score = 0;
	private boolean estadoDoJogo = true;
	private char cEstado = 'x';

	public Controle(Componente heroi) {
		this.heroi = heroi;
	}

	public boolean getEstadoJogo() {
		return estadoDoJogo;
	}

	public char getcEstado(){return cEstado;}

	public boolean movimentoValido(char mov, int l, int c) {
		if (mov == 'w' && l-1 >= 0) {
			return true;
		}else if (mov == 's' && l+1 <= 3) {
			return true;
		}else if (mov == 'a' && c-1 >= 0) {
			return true;
		}else if (mov == 'd' && c+1 <= 3) {
			return true;
		}else {
			return false;
		}
	}

	public void agir(char mov) {
		if (mov == 'k') {
			heroi.equiparFlecha();
			score -= 100;
			cEstado = 'x';
		}else if (mov == 'c') {
			heroi.capturarOuro();
			cEstado = 'x';
		}else if (mov == 'q') {
			if(heroi.getLinha() == 0 && heroi.getColuna() == 0 && heroi.isOuroCapturado()) {
				score += 1000;
				cEstado = 'w';
			}
			this.estadoDoJogo = false;
			if(cEstado != 'w'){
				cEstado = 'n';
				System.out.println("Volte sempre !");
			}
		}
		else if (movimentoValido(mov, heroi.getLinha(), heroi.getColuna())) {
			heroi.mover(mov);
			if(!heroi.getVida()){
				score -= 1000;
				estadoDoJogo = false;
				cEstado = 'n';
			}else if(heroi.matouWumpus()) { 
				score += 500;
				cEstado = 'x';
			}
			score -= 15;
		}
	}
	
	public int getScore() {
		return score;
	}
}