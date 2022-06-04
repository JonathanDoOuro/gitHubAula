package pt.c40task.l05wumpus;

public class Wumpus extends Componente{
	Wumpus (int l, int c, Caverna caverna) {
		super('W', l, c, caverna);
	}
	
	public void instanciarSecundarios() {
		if(caverna.salaExiste(l - 1, c)) 
	    	this.caverna.addComponente(new Fedor(l - 1, c, caverna));
	    if(caverna.salaExiste(l + 1, c)) 
	    	caverna.addComponente(new Fedor(l+1, c, caverna));
	    if(caverna.salaExiste(l, c - 1)) 
	    	caverna.addComponente(new Fedor(l, c-1, caverna));
	    if(caverna.salaExiste(l, c + 1)) 
	    	caverna.addComponente(new Fedor(l, c+1, caverna));
	}
}
