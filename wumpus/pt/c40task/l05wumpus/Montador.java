package pt.c40task.l05wumpus;

public class Montador {
    private Caverna caverna;
    private String[][] instrucoes;

    public Montador(){
        /*
        Inicialmente criar um montador nulo,
        para não ser preciso especificar a caverna
        e as instruções quando criá-lo.
         */
        this.caverna = null;
        this.instrucoes = null;
    }

    public void conecta(Caverna caverna){
        this.caverna = caverna;
    }

    public void setInstrucoes(String[][] instrucoes){
        int nBuracos = 0, nWumpus = 0, nOuro = 0, nHeroi = 0;

        for(int i = 0; i < instrucoes.length; i++){
            if(instrucoes[i][2].charAt(0) == 'P') nHeroi++;
            else if(instrucoes[i][2].charAt(0) == 'B') nBuracos++;
            else if(instrucoes[i][2].charAt(0) == 'W') nWumpus++;
            else if(instrucoes[i][2].charAt(0) == 'O') nOuro++;
        }
        if((nBuracos == 2 || nBuracos == 3) && nHeroi == 1 && nWumpus == 1 && nOuro == 1){
            this.instrucoes = new String[instrucoes.length][3];
            for(int i = 0; i < instrucoes.length; i++){
                for(int j = 0; j < instrucoes[i].length; j++){
                    this.instrucoes[i][j] = instrucoes[i][j];
                }
            }
        }
    }

    public Componente criar(char caracterCriacao, int l, int c) {
		if (caracterCriacao == 'P') {
			return new Heroi(l, c, caverna);
		}else if (caracterCriacao == 'W') {
			return new Wumpus(l, c, caverna);
		}else if (caracterCriacao == 'O') {
			return new Ouro(l, c, caverna);
		}else if (caracterCriacao == 'B') {
			return new Buraco(l, c, caverna);
		}else {
			return null;
		}
	}
    
    public void monta(){
        if(caverna != null && instrucoes != null){
            int l, c;
            char caracterCriacao;
            for(int i = 0; i < instrucoes.length; i++){
                caracterCriacao = instrucoes[i][2].charAt(0);
                if(caracterCriacao != '_') {
                    l = Integer.parseInt(instrucoes[i][0]) - 1; //no arquivo de entrada as linhas e colunas iniciam em 1
                    c = Integer.parseInt(instrucoes[i][1]) - 1;
                    caverna.addComponente(this.criar(caracterCriacao, l, c));
                }
            }
        }
    }
}