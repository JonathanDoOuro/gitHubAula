package pt.c40task.l05wumpus;

import java.util.Scanner;

public class AppWumpus {

   public static void main(String[] args) {
      AppWumpus.executaJogo(
            (args.length > 0) ? args[0] : null,
            (args.length > 1) ? args[1] : null,
            (args.length > 2) ? args[2] : null);
   }
   
   public static void executaJogo(String arquivoCaverna, String arquivoSaida,
                                  String arquivoMovimentos) {
      Toolkit tk = Toolkit.start(arquivoCaverna, arquivoSaida, arquivoMovimentos);
      
      String cave[][] = tk.retrieveCave();
      //System.out.println("=== Caverna");
      /*for (int l = 0; l < cave.length; l++) {
         for (int c = 0; c < cave[l].length; c++)
            System.out.print(cave[l][c] + ((c < cave[l].length-1) ? ", " : ""));
         System.out.println();
      }*/

      Montador montador = new Montador();
      Caverna caverna = new Caverna();
      montador.conecta(caverna);
      montador.setInstrucoes(cave);
      montador.monta();
      Controle controle = new Controle(caverna.getHeroi());

      String movements = tk.retrieveMovements();
      //movements = null;
      if (movements != null) {
    	  System.out.println("=== Movimentos");
    	  System.out.println(movements);
          caverna.imprime("Jonathan", controle.getScore());
    	  for(int i = 0; i < movements.length() && controle.getEstadoJogo(); i++){
             controle.agir(movements.charAt(i));
             tk.writeBoard(caverna.toMatriz(), controle.getScore(), controle.getcEstado());
             if (movements.charAt(i) != 'k') {
            	 caverna.imprime("Alcebiades", controle.getScore());
             }
             if(!controle.getEstadoJogo() && controle.getcEstado() == 'w') 
            	 System.out.println("Você ganhou =D !!!");
             else if(!controle.getEstadoJogo() && controle.getcEstado() == 'n')
            	 System.out.println("Você perdeu =( ...");
          }
      }
     else{
         Scanner keyboard = new Scanner(System.in);
         String player = keyboard.nextLine();
         caverna.imprime(player, controle.getScore());
         while(controle.getEstadoJogo()){
            String command = keyboard.nextLine();
            for(int i = 0; i < command.length(); i++){
               controle.agir(command.charAt(i));
               tk.writeBoard(caverna.toMatriz(), controle.getScore(), controle.getcEstado());
               if (command.charAt(i) != 'k') {
                  caverna.imprime(player, controle.getScore());
               }
               if(!controle.getEstadoJogo() && controle.getcEstado() == 'w') 
            	   System.out.println("Você ganhou =D !!!");
               else if(!controle.getEstadoJogo() && controle.getcEstado() == 'n') 
            	   System.out.println("Você perdeu =( ...");
            }
         }
      }
      
      /*System.out.println("=== Caverna Intermediaria");
      char partialCave[][] = {
         {'#', '#', 'b', '-'},
         {'#', 'b', '-', '-'},
         {'b', '-', '-', '-'},
         {'p', '-', '-', '-'}
      };
      int score = -120;
      char status = 'x'; // 'w' para venceu; 'n' para perdeu; 'x' intermediárias
      tk.writeBoard(partialCave, score, status);

      System.out.println("=== Última Caverna");
      char finalCave[][] = {
         {'#', '#', 'b', '-'},
         {'#', 'b', '#', 'f'},
         {'b', '-', '-', 'w'},
         {'#', '-', '-', '-'}
      };
      score = -1210;
      status = 'n'; // 'w' para venceu; 'n' para perdeu; 'x' intermediárias
      tk.writeBoard(finalCave, score, status);
      */
      tk.stop();
   }

}
