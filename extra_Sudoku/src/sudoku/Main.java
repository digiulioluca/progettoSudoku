/*
 Ecco la traccia aggiornata senza la sezione "Dettagli di implementazione":

---

### **Traccia: Realizzazione di un gioco di Sudoku in Java**

#### **Obiettivo:**
Realizzare un'applicazione che consenta di giocare a Sudoku in Java. 
Il programma deve permettere all'utente di inserire numeri in una griglia 9x9,
 rispettando le regole del Sudoku (ogni numero da 1 a 9 deve apparire una sola volta
  per ogni riga, colonna e sottogriglia 3x3).

#### **Descrizione del progetto:**

1. **Creazione della classe `Sudoku`:**
   - La classe `Sudoku` sarà la classe principale del programma e conterrà la logica del gioco,
    i metodi per stampare la griglia e per verificare la validità del gioco.
   - All'interno della classe, utilizza una matrice bidimensionale (array di array) per 
   rappresentare la griglia 9x9.

2. **Costruzione della griglia iniziale:**
   - La griglia iniziale del Sudoku può essere definita come una matrice 9x9. Per semplicità,
   potresti iniziare con una griglia incompleta, dove alcune celle sono già riempite con numeri 
   (per esempio, una griglia con numeri preimpostati).
   - Ogni cella può contenere un valore numerico da 1 a 9, oppure 0 (che indica che la cella è vuota).

3. **Metodi da implementare:**
   - **`printBoard()`**: Un metodo che stampa la griglia del Sudoku in modo leggibile
(in formato 9x9, con separazioni tra righe e colonne).
   - **`isValid(int row, int col, int num)`**: Un metodo che verifica se è valido
    inserire un numero (`num`) in una cella specifica (`row`, `col`). La validità è determinata 
    dal fatto che il numero non deve apparire nella stessa riga, nella stessa colonna, 
    o nella stessa sottogriglia 3x3.
   - **`isSolved()`**: Un metodo che controlla se il gioco è stato risolto, cioè se tutte le 
   celle sono riempite con numeri validi.
   - **`fillCell(int row, int col, int num)`**: Un metodo che permette all'utente di inserire 
   un numero in una cella specificata.
   - **`getEmptyCells()`**: Un metodo che restituisce una lista delle celle vuote
   (quelle con valore 0),
   da usare se desideri implementare una funzionalità che permette di sapere quali celle sono
   ancora
   da riempire.

4. **Interazione con l'utente:**
   - All'inizio del gioco, il programma dovrebbe stampare la griglia iniziale con alcuni
   numeri già inseriti e chiedere all'utente di inserire un numero in una cella specifica.
   - Dopo ogni inserimento, il programma deve verificare se l'input è valido e, in caso contrario,
   chiedere nuovamente l'input.
   - Il gioco continua finché l'utente non risolve il Sudoku o decide di terminare.

5. **Classe `Main`:**
   - La classe `Main` contiene il metodo `main()`, che avvia il gioco, interagisce con l'utente e
   gestisce il flusso del gioco.
   - Utilizza un ciclo per chiedere all'utente di inserire numeri fino a quando il Sudoku è risolto.

 */
package sudoku;

import java.util.Scanner;

public class Main {
	
	public static void menu(Scanner scanner) {
		int scelta = 0;
		Sudoku.startGriglia();
		do {
			System.out.println("MENU' SUDOKU\nScegli un'opzione"
					+"\n1) controlla griglia\n2) inserisci numero\n3) stampa celle vuote"
					+ "\n4) controlla status gioco");
			try {
				scelta=scanner.nextInt();
			} catch (Exception e) {
				System.out.println("Hai inserito un carattere. Errore.");
				scanner.next();
			}
			switch(scelta) {
			case 1:
				Sudoku.stampaGriglia();
				break;
			case 2:
				Sudoku.inserisciNumero(scanner);
				break;
			case 3:
				Sudoku.stampaVuote();
				break;
			case 4:
				/*if (Sudoku.controllaRisoluzione()) {
					System.out.println("Gioco completo. Stai uscendo dal programma.");
				} else {
					System.out.println("Gioco incompleto.");
					scelta=0;
				}*/
				System.out.println("Gioco incompleto.");
				scelta=0;
				break;
			default:
			}
		} while (scelta!=4);
		
	}

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner (System.in);
		menu(scanner);
		scanner.close();
		System.exit(0);
		
	}

}
