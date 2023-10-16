package it.corso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Tavolo {

	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	int numRighe = 3;
	int numColonne = 5;

	public void NumerototTavoli() throws NumberFormatException, IOException {

		System.out.println("Determina la disposizione della sala in righe e colonne");
		while (true) {
			try {

				System.out.println("Scrivi il numero di righe");
				numRighe = Integer.parseInt(reader.readLine());
				if (numRighe < 1 || numRighe > 98) {
					System.out.println("Il numero di righe deve essere maggiore di 0 e minore di 99");
					continue;
				}
				System.out.println("Scrivi il numero di colonne");
				numColonne = Integer.parseInt(reader.readLine());
				if (numColonne < 1 || numColonne > 98) {
					System.out.println("Il numero di colonne deve essere maggiore di 0 e minore di 99");
					continue;
				}
				break;

			} catch (Exception e) {
				System.out.println("Input errato");

			}
		}
	}

	public int[][] tavoli = new int[numRighe][numColonne];

	Cassa cassa;
	int comitiva;
	int limiteTavoli = 4;
	int capacitaRistorante = limiteTavoli * tavoli.length * tavoli[0].length;
	HashMap<String, Integer> listaNumerazioneTavoli = new HashMap<>();

	public Tavolo(Cassa cassa) {
		this.cassa = cassa;
		try {
			NumerototTavoli();
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		} // Chiamiamo il metodo per ottenere i valori delle righe e colonne
		tavoli = new int[numRighe][numColonne]; // Inizializziamo l'array tavoli
	}

	public Tavolo() {

	}

	public int calcoloIndexUno(String string) {

		int indexUno = 0;

		if (numRighe < 9)
			indexUno = Integer.parseInt(string.substring(0, 1)) - 1;
		else if (numRighe >= 9 && numRighe < 99)
			indexUno = Integer.parseInt(string.substring(0, 2)) - 1;

		return indexUno;

	}

	public int calcoloIndexDue(String string) {

		int indexDue = 0;

		if (numColonne < 9)
			indexDue = Integer.parseInt(string.substring(string.length() - 1)) - 1;
		else if (numColonne >= 9 && numColonne < 99)
			indexDue = Integer.parseInt(string.substring(string.length() - 2)) - 1;

		return indexDue;

	}

	public void registraTavoliArray() {

		int nuovariga;
		int nuovacolonna;
		String tavoloDaAggiungere = null;

		for (int riga = 0; riga < tavoli.length; riga++) {
			for (int colonna = 0; colonna < tavoli[riga].length; colonna++) {
				nuovariga = riga + 1;
				nuovacolonna = colonna + 1;

				// inseriamo un altro ciclo for interno

				for (int i = 1; i <= numRighe; i++) {

					if (nuovariga == i && nuovacolonna > 0 && nuovacolonna <= numColonne)
						tavoloDaAggiungere = Integer.toString(nuovariga) + Integer.toString(nuovacolonna);
					listaNumerazioneTavoli.put(tavoloDaAggiungere, tavoli[riga][colonna]);

				}

			}
		}
	}

	public void mostraTavoli() {

		int nuovariga;
		int nuovacolonna;

		System.out.println("Ecco la situazione attuale dei tavoli:\n");

		for (int riga = 0; riga < tavoli.length; riga++) {
			for (int colonna = 0; colonna < tavoli[riga].length; colonna++) {
				nuovariga = riga + 1;
				nuovacolonna = colonna + 1;

				// inseriamo un altro ciclo for interno

				for (int i = 1; i <= numRighe; i++) {

					if (nuovariga == i && nuovacolonna > 0 && nuovacolonna <= numColonne)
						System.out.print(" " + nuovariga + nuovacolonna + ":[" + tavoli[riga][colonna] + "] ");
				}

			}
			System.out.println("\n");
		}

	}

	public void assegnaTavoloAutomatico() throws NumberFormatException, IOException {
		int sommaPersoneinSala = 0;

		while (true) {
			mostraTavoli();

			boolean tuttiTavoliOccupati = true;

			for (int riga = 0; riga < tavoli.length; riga++) {
				for (int colonna = 0; colonna < tavoli[riga].length; colonna++) {
					if (tavoli[riga][colonna] == 0) {
						tuttiTavoliOccupati = false;
						break; // Esci dal ciclo interno, hai trovato un tavolo libero
					}
				}
				if (!tuttiTavoliOccupati) {
					break; // Esci dal ciclo esterno, hai trovato almeno un tavolo libero
				}
			}

			try {
				System.out.println("Quante persone sono da accomodare?");
				comitiva = Integer.parseInt(reader.readLine());

				// calcolo di tutte le persone in sala, se nel caso sforiamo la capacità massima
				for (int riga = 0; riga < tavoli.length; riga++) {
					for (int colonna = 0; colonna < tavoli[riga].length; colonna++) {
						sommaPersoneinSala += tavoli[riga][colonna];
					}
				}

				if ((comitiva + sommaPersoneinSala) > capacitaRistorante) {
					System.out.println("Attenzione siamo sopra la capienza massima!");
					System.out.println("Inserisci nuovamente il numero di persone:");
					continue; // Ripeti il ciclo per chiedere nuovamente il numero di persone
				}

				// Se la capacità non è superata, esci dal ciclo
				break;

			} catch (Exception e) {
				System.out.println("Input immesso errato");
			}
		}

		cassa.setCassa(cassa.getCassa() + (comitiva * 2));

		for (int riga = 0; riga < tavoli.length; riga++) {
			for (int colonna = 0; colonna < tavoli[riga].length; colonna++) {
				// Ora vediamo se il tavolo è libero (il valore dell'array è uguale a 0)
				if (tavoli[riga][colonna] == 0) {
					if (comitiva <= limiteTavoli) {
						// Se la comitiva è al massimo 4 persone, assegnala a questo tavolo
						tavoli[riga][colonna] = comitiva;
						String tavoloDaAggiungere = Integer.toString(riga + 1) + Integer.toString(colonna + 1);
						listaNumerazioneTavoli.put(tavoloDaAggiungere, comitiva);
						comitiva = 0; // Tavolo completamente occupato
					} else if (comitiva % 2 == 1) {
						tavoli[riga][colonna] = 3;
						String tavoloDaAggiungere = Integer.toString(riga + 1) + Integer.toString(colonna + 1);
						listaNumerazioneTavoli.put(tavoloDaAggiungere, 3);
						comitiva -= 3;
					} else {
						// Se la comitiva è più grande di 4 persone, riempi il tavolo con 4 persone
						tavoli[riga][colonna] = limiteTavoli;
						String tavoloDaAggiungere = Integer.toString(riga + 1) + Integer.toString(colonna + 1);
						listaNumerazioneTavoli.put(tavoloDaAggiungere, limiteTavoli);
						comitiva -= 4; // Rimuovi le persone assegnate
					}
				}
			}
			if (comitiva == 0) {
				// Tutte le persone sono state accomodate, esci dal ciclo
				break;
			}
		}

		System.out.println("Tavolo registrato con successo!\n");
		mostraTavoli();
	}

	public void assegnaTavoloManualmente() throws IOException {

		int sommaPersoneinSala = 0;
		while (true) {
			mostraTavoli();

			boolean tuttiTavoliOccupati = true;

			for (int riga = 0; riga < tavoli.length; riga++) {
				for (int colonna = 0; colonna < tavoli[riga].length; colonna++) {
					if (tavoli[riga][colonna] == 0) {
						tuttiTavoliOccupati = false;
						break; // Esci dal ciclo interno, hai trovato un tavolo libero
					}
				}
				if (!tuttiTavoliOccupati) {
					break; // Esci dal ciclo esterno, hai trovato almeno un tavolo libero
				}
			}

			try {
				System.out.println("Quante persone sono da accomodare?");
				comitiva = Integer.parseInt(reader.readLine());

				// calcolo di tutte le persone in sala, se nel caso sforiamo la capacità massima
				for (int riga = 0; riga < tavoli.length; riga++) {
					for (int colonna = 0; colonna < tavoli[riga].length; colonna++) {
						sommaPersoneinSala += tavoli[riga][colonna];
					}
				}

				if ((comitiva + sommaPersoneinSala) > capacitaRistorante) {
					System.out.println("Attenzione siamo sopra la capienza massima!");
					System.out.println("Inserisci nuovamente il numero di persone:");
					continue; // Ripeti il ciclo per chiedere nuovamente il numero di persone
				}

				// Se la capacità non è superata, esci dal ciclo
				break;

			} catch (Exception e) {
				System.out.println("Input immesso errato");
			}
		}

		cassa.setCassa(cassa.getCassa() + (comitiva * 2));

		while (true) {

			try {
				System.out.println("A quale tavolo vuoi aggiungere le persone ?  ");
				System.out.println("(Puoi aggiungere massimo " + limiteTavoli + " persone per tavolo)");
				String tavoloDaAggiungere = reader.readLine();
				int indexuno = calcoloIndexUno(tavoloDaAggiungere);
				int indexdue = calcoloIndexDue(tavoloDaAggiungere);
				int personeTavolo;

				if (listaNumerazioneTavoli.containsKey(tavoloDaAggiungere)) {
					if (listaNumerazioneTavoli.get(tavoloDaAggiungere) != 0) {
						System.out.println("Tavolo già occupato ! Inserisci un altro tavolo:");
						continue;
					} else {
						System.out.println("Quante persone vuoi aggiungere a questo tavolo?");
						personeTavolo = Integer.parseInt(reader.readLine());

						if (personeTavolo > limiteTavoli) {
							System.out.println("Puoi aggiungere massimo " + limiteTavoli + " persone per tavolo");
						} else if (personeTavolo > comitiva) {
							System.out.println("Non puoi aggiungere più persone di quelle disponibili");
						} else {
							tavoli[indexuno][indexdue] = personeTavolo;
							listaNumerazioneTavoli.put(tavoloDaAggiungere, personeTavolo);
							System.out.println("Tavolo registrato con successo!");
							comitiva -= personeTavolo;
							System.out.println("Ti rimangono ancora da accomodare " + comitiva + " persone");

							if (comitiva == 0) {
								break; // Tutte le persone sono state accomodate
							}
						}
					}
				} else {
					System.out.println("Input immesso errato. Reinserisci correttamente il numero tavolo.");
					continue;
				}

			} catch (Exception e) {
				System.out.println("Input immesso errato");
			}

			mostraTavoli();
		}

	}

	public void assegnaTavolo() throws IOException {

		while (true) {

			System.out.println("Digita 1 per assegnare il tavolo manualmente, 2 per assegnazione automatica");
			String assegnazione = reader.readLine();

			if (assegnazione.equals("1")) {
				assegnaTavoloManualmente();
				break;
			} else if (assegnazione.equals("2")) {
				assegnaTavoloAutomatico();
				break;
			} else {
				System.out.println("Input errato");

			}
		}

	}

	public void liberaTavolo() throws IOException {
		
		int sommaPersoneinSala = 0;
		
		// calcolo di tutte le persone in sala, se nel caso sono zero , non dobbiamo liberare nulla 
		// quindi ritorniamo al menu principale
		for (int riga = 0; riga < tavoli.length; riga++) {
			for (int colonna = 0; colonna < tavoli[riga].length; colonna++) {
				sommaPersoneinSala += tavoli[riga][colonna];
			}
		}
		
		if (sommaPersoneinSala == 0){
			System.out.println("Tutti i tavoli sono già liberi! Non c'è nulla da liberare.");
			System.out.println("Ritorno al menu principale...\n");
			return;
			
		}
		
		mostraTavoli();

		while (true) {

			try {
				System.out.println("Quale tavolo vuoi liberare? ");
				String tavolodaliberare = reader.readLine();
				int indexuno = calcoloIndexUno(tavolodaliberare);
				int indexdue = calcoloIndexDue(tavolodaliberare);
				
				//se tutti i tavoli sono liberi fai il return, al metodo principale
				

				if (listaNumerazioneTavoli.containsKey(tavolodaliberare)) {
					if (listaNumerazioneTavoli.get(tavolodaliberare) == 0) {
						System.out.println("Tavolo già libero!");
						continue;
					} else {
						tavoli[indexuno][indexdue] = 0;
						listaNumerazioneTavoli.put(tavolodaliberare, 0);
						System.out.println("Tavolo liberato con successo \n");
						break;
					}
				} else {
					System.out.println("Input immesso errato. Reinserisci correttamente il numero tavolo.");
					continue;
				}

			} catch (Exception e) {
				System.out.println("Input immesso errato. Reinserisci correttamente il numero tavolo.");
			}

		}

		mostraTavoli();
	}

}
