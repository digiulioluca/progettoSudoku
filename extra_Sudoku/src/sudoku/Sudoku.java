package sudoku;

import java.util.Scanner;

public class Sudoku {
	static int[][] griglia = new int[9][9];
	public static final String ANSI_RED = "\33[0;91m";
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String GREEN_BRIGHT = "\033[0;92m";

	public static void stampaGriglia() {
		/*
		 * Metodo per la stampa della griglia. Utilizzo due for per gestire al meglio la
		 * separazione tra numeri sulla stessa riga e su righe diverse
		 */
		for (int i = 0; i < griglia.length; i++) {
			for (int j = 0; j < griglia.length; j++) {
				if (griglia[i][j] != 0) {
					System.out.print(" " + griglia[i][j] + " ");
				} else {
					System.out.print("   ");
				}
				if (j == 2 || j == 5) {
					System.out.print(ANSI_RED + "|" + ANSI_RESET);
				}
				if (j == (griglia.length - 1) && i != (griglia.length - 1)) {
					if (i == 2 || i == 5) {
						System.out.println(ANSI_RED + "\n ---------------------------- " + ANSI_RESET);
					} else {
						System.out.println("\n ---------------------------- ");
					}
				}
			}
		}
		System.out.println("");
	}

	public static void startGriglia() {
		// metodo per inizializzare la griglia
		griglia[0][0] = 5;
		griglia[0][5] = 1;
		griglia[0][7] = 4;
		griglia[1][1] = 7;
		griglia[1][3] = 9;
		griglia[1][4] = 5;
		griglia[2][2] = 2;
		griglia[2][4] = 7;
		griglia[2][6] = 8;
		griglia[2][8] = 3;
		griglia[3][0] = 7;
		griglia[3][1] = 4;
		griglia[3][5] = 9;
		griglia[4][1] = 1;
		griglia[4][3] = 7;
		griglia[4][5] = 2;
		griglia[4][7] = 5;
		griglia[5][3] = 6;
		griglia[5][6] = 9;
		griglia[5][7] = 2;
		griglia[5][8] = 7;
		griglia[6][0] = 3;
		griglia[6][2] = 1;
		griglia[6][4] = 8;
		griglia[6][8] = 5;
		griglia[7][4] = 4;
		griglia[7][5] = 3;
		griglia[7][7] = 7;
		griglia[8][1] = 6;
		griglia[8][3] = 8;
		griglia[8][8] = 9;

	}

	public static void inserisciNumero(Scanner scanner) {
		/*
		 * Metodo per inserire un numero: raccolgo in input le coordinate per trovare la
		 * cella. Racchiudo tutto all'interno di un do-while per far sì che avvenga un
		 * inserimento corretto. Una volta usciti dal ciclo, vado a effettuare il
		 * controllo sulla cella: se al suo interno abbiamo un valore corrispondente a 0
		 * - ovvero "cella vuota" - procediamo a raccogliere via input il numero da
		 * inserire. Concluso questo inserimento, lanciamo il metodo isValid per
		 * controllare se quella cella può contenere o meno il numero inserito
		 * dall'utente.
		 */
		int uscita = 0;
		int riga = 0;
		int colonna = 0;
		int numero = 0;
		do {
			System.out.println("\nInserisci le coordinate della cella che vuoi andare"
					+ " a riempire (RICORDA: i numeri vanno da 0 a 8).\nRiga: ");
			riga = scanner.nextInt();
			System.out.println("Colonna: ");
			colonna = scanner.nextInt();
			if (riga < 9 && riga >= 0) {
				if (colonna < 9 && colonna >= 0) {
					uscita = 1;
				} else {
					System.out.println("Input non valido.");
				}
			} else {
				System.out.println("Input non valido.");
			}
		} while (uscita == 0);

		if (griglia[riga][colonna] == 0) {
			System.out.println("Inserisci il valore: ");
			numero = scanner.nextInt();
			if (numero < 9 && numero > 0) {
				if (isValid(numero, riga, colonna)) {
					System.out.println("Numero inserito!");
				} else {
					System.out.println("Numero non valido.");
				}
			} else {
				System.out.println("Input non valido.");
			}
		} else {
			System.out.println("Cella già riempita.");
		}
	}

	public static boolean isValid(int numero, int riga, int colonna) {
		boolean inserito = false;
		
		for (int i=0; i<griglia.length;i++) {
			for(int j=0; j<griglia.length;j++) {
				if(numero!=griglia[i][j]&&numero!=griglia[riga][j]&&numero!=griglia[i][colonna]&&numero!=griglia[riga][colonna]) {
					griglia[riga][colonna]=numero;
					inserito=true;
				}
			}
		}
		return inserito;
	}

	public static void stampaVuote() {
		// Metodo per stampare le celle "vuote"(celle con valore 0)
		for (int i = 0; i < griglia.length; i++) {
			for (int j = 0; j < griglia.length; j++) {
				if (griglia[i][j] == 0) {
					System.out.println("Riga: " + i + ", Colonna: " + j);
				}
			}
		}
	}

	public static boolean controllaRisoluzione() {
		boolean concluso = true;
		for (int i = 0; i < griglia.length; i++) {
			for (int j = 0; j < griglia.length; j++) {
				if (griglia[i][j] == 0) {
					concluso = false;
				}
			}
		}
		return concluso;
	}

}
