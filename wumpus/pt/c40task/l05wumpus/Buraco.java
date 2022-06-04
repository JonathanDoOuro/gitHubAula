package pt.c40task.l05wumpus;

public class Buraco extends Componente{
	Buraco(int l, int c, Caverna caverna) {
		super('B', l, c, caverna);
	}
	
	public void instanciarSecundarios() {
		if(caverna.salaExiste(l - 1, c)) 
	    	this.caverna.addComponente(new Brisa(l - 1, c, caverna));
	    if(caverna.salaExiste(l + 1, c)) 
	    	caverna.addComponente(new Brisa(l+1, c, caverna));
	    if(caverna.salaExiste(l, c - 1)) 
	    	caverna.addComponente(new Brisa(l, c-1, caverna));
	    if(caverna.salaExiste(l, c + 1)) 
	    	caverna.addComponente(new Brisa(l, c+1, caverna));
	}
}
