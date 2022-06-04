package pt.c40task.l05wumpus;

public class Caverna {
    private Sala[][] vSalas;

    public Caverna(){
        this.vSalas = new Sala[4][4];
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                this.vSalas[i][j] = new Sala(true);
            }
        }
    }
    //novo método
    public Componente getHeroi() {
    	for(int i = 0; i < vSalas.length; i++) {
    		for(int j = 0; j < vSalas[i].length; j++) {
    			if(vSalas[i][j].temHeroi()) 
    				return vSalas[i][j].getHeroi();
    		}
    	}
    	return null;
    }
    
    public boolean temWumpus(int l, int c) {
    	if (vSalas[l][c].getWumpus() != null)
    		return true;
    	else
    		return false;
    }
    
    public Componente getWumpus(int l, int c) {
    	return vSalas[l][c].getWumpus();
    } 
    
    public boolean capturarOuro(int l, int c) {	
    	return vSalas[l][c].capturarOuro();
    }
    
    public Sala getSala(int l, int c){ return vSalas[l][c];}
    
    public void movimentar(char mov, int l, int c) {
    	Componente heroi = vSalas[l][c].getHeroi();
    	if (mov == 'w' && salaExiste(l-1,c)) {
    		heroi.setPosicao(l-1, c);
    		vSalas[l-1][c].addHeroi(heroi);
    		vSalas[l][c].removerHeroi();;
    	}else if (mov == 's' && salaExiste(l+1,c)) {
    		heroi.setPosicao(l+1, c);
    		vSalas[l+1][c].addHeroi(heroi);
    		vSalas[l][c].removerHeroi();;
    	}else if (mov == 'a' && salaExiste(l,c-1)) {
    		heroi.setPosicao(l, c-1);
    		vSalas[l][c-1].addHeroi(heroi);
    		vSalas[l][c].removerHeroi();;
    	}else if (mov == 'd' && salaExiste(l,c+1)) {
    		heroi.setPosicao(l, c+1);
    		vSalas[l][c+1].addHeroi(heroi);
    		vSalas[l][c].removerHeroi();;
    	}
    }
    
    public void addComponente(Componente componente){
        this.vSalas[componente.getLinha()][componente.getColuna()].add(componente);
        if(componente.getCaracter() == 'B') {
        	this.vSalas[componente.getLinha()][componente.getColuna()].getBuraco().instanciarSecundarios(); 
        }else if (componente.getCaracter() == 'W') {
        	this.vSalas[componente.getLinha()][componente.getColuna()].getWumpus().instanciarSecundarios(); 
        }
    }
    
    public boolean salaExiste(int l, int c){
        // Considerando que as salas vao de 0 a 3, e não de 1 a 4.
    	// Adicionando condição de > -1
        if(l < 4 && c < 4 && l > -1 && c > -1)
            return true;
        return false;
    }

    public char[][] toMatriz(){
        char[][] mChar = new char[4][4];
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                mChar[i][j] = vSalas[i][j].componenteDoTopo();
            }
        }
        return mChar;
    }

    public void imprime(String player, int score){
        for (int l = 0; l < vSalas.length; l++) {
            for (int c = 0; c < vSalas[l].length; c++)
                System.out.print(vSalas[l][c].componenteDoTopo() + ((c < vSalas[l].length-1) ? " " : ""));
            System.out.println();
        }
        System.out.println("Player: " + player);
        System.out.println("Score: " + score);
    }
}