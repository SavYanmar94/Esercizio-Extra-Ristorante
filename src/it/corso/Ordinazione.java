package it.corso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;

public class Ordinazione {

	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	// nella classe ristorante facciamo comunicare
	Cassa myCassa; // Aggiungi un riferimento alla classe Cassa
	Tavolo tavolo;

// vorrei copiare l'array 

	// Costruttore che accetta una istanza di Cassa
	public Ordinazione(Cassa cassa) {
		this.myCassa = cassa;
	}

	public Ordinazione(Cassa cassa, Tavolo tavolo) {
		this.myCassa = cassa;
		this.tavolo = tavolo;
	}

	public Ordinazione() {

	}

	public void mostraMenu() {
		System.out.println("------Menu------\n");
		System.out.println("1.Antipasti - 4.90 euro");
		System.out.println("2.Pizza margherita - 4.90 euro");
		System.out.println("3.Pizza farcita - 7.90 euro");
		System.out.println("4.Pizza gourmet - 9.90 euro");
		System.out.println("5.Primo di mare - 10.90 euro");
		System.out.println("6.Primo di terra - 8.90 euro");
		System.out.println("\n------Bevande------\n");
		System.out.println("7.Acqua - 1.00 euro");
		System.out.println("8.Bibite - 1.50 euro");
		System.out.println("9.Birra - 3.00 euro");
		System.out.println("10.Vino della casa - 3.50 euro");
		System.out.println("\nCosto coperto - 2 euro/p\n");
	}

	public void registraOrdinazioni() throws IOException {
		
		int sommaPersoneinSala = 0;
		
		// calcolo di tutte le persone in sala, se nel caso sono zero , non dobbiamo liberare nulla 
		// quindi ritorniamo al menu principale
		for (int riga = 0; riga < tavolo.tavoli.length; riga++) {
			for (int colonna = 0; colonna < tavolo.tavoli[riga].length; colonna++) {
				sommaPersoneinSala += tavolo.tavoli[riga][colonna];
			}
		}
		
		if (sommaPersoneinSala == 0){
			System.out.println("Tutti i tavoli sono liberi ! Non puoi prendere ordinazioni !");
			System.out.println("Ritorno al menu principale... \n");
			return;
			
		}

		double contoTemporaneoOrdinazione = 0.0;

		ArrayList<String> ordinazioneList = new ArrayList<>();

		int quantita = 0;

		mostraMenu();
		tavolo.mostraTavoli();

		String tavoloOrdinazione = null;

		while (true) {
			try {
				System.out.println("Di quale tavolo vuoi prendere l'ordinazione ?");
				tavoloOrdinazione = reader.readLine();

				if (tavolo.listaNumerazioneTavoli.containsKey(tavoloOrdinazione)) {
					if (tavolo.listaNumerazioneTavoli.get(tavoloOrdinazione) == 0) {
						System.out.println("Non puoi prendere un'ordinazione da un tavolo libero!");
						continue;
					} else {
						// Il tavolo esiste ed è occupato, procedi con l'ordinazione
					}
				} else {
					System.out.println("Input immesso errato. Reinserisci correttamente il numero tavolo.");
					continue;
				}

			} catch (Exception e) {
				System.out.println("Input immesso errato. Reinserisci correttamente il numero tavolo.");
			}

			while (true) {

				System.out.println("Registra le ordinazioni \n");
				System.out.println("digita 1 per gli antipasti");
				System.out.println("digita 2 per la pizza margherita");
				System.out.println("digita 3 per la pizza farcita");
				System.out.println("digita 4 per la pizza gourmet");
				System.out.println("digita 5 per primo di mare");
				System.out.println("digita 6 per primo di terra");
				System.out.println("digita 7 per acqua");
				System.out.println("digita 8 per bibite");
				System.out.println("digita 9 per birra");
				System.out.println("digita 10 per vino della casa");
				System.out.println("digita 0 per confermare ordinazione e tornare al menu principale");

				String sceltaordinazioni = reader.readLine();

				switch (sceltaordinazioni) {
				case "1":

					try {
						System.out.println("Inserisci la quantità (per tavolo)");

						quantita = Integer.parseInt(reader.readLine());

					} catch (Exception e) {
						System.out.println("Input immesso errato");
					}

					myCassa.setCassa(myCassa.getCassa() + (4.90 * quantita));
					contoTemporaneoOrdinazione += (4.90 * quantita);

					if (quantita == 1) {
						String antipasto = "- " + quantita + " antipasto";
						ordinazioneList.add(antipasto);
					} else {
						String antipasti = "- " + quantita + " antipasti";
						ordinazioneList.add(antipasti);
					}

					break;

				case "2":

					try {
						System.out.println("Inserisci la quantità (per tavolo)");

						quantita = Integer.parseInt(reader.readLine());

					} catch (Exception e) {
						System.out.println("Input immesso errato");
					}

					myCassa.setCassa(myCassa.getCassa() + (4.90 * quantita));
					contoTemporaneoOrdinazione += (4.90 * quantita);

					if (quantita == 1) {
						String pizzaMargherita = "- " + quantita + " pizza margherita";
						ordinazioneList.add(pizzaMargherita);
					} else {
						String pizzeMargherite = "- " + quantita + " pizze margherite";
						ordinazioneList.add(pizzeMargherite);
					}

					break;

				case "3":

					try {
						System.out.println("Inserisci la quantità (per tavolo)");

						quantita = Integer.parseInt(reader.readLine());

					} catch (Exception e) {
						System.out.println("Input immesso errato");
					}

					myCassa.setCassa(myCassa.getCassa() + (7.90 * quantita));
					contoTemporaneoOrdinazione += (7.90 * quantita);

					if (quantita == 1) {
						String pizzaFarcita = "- " + quantita + " pizza farcita";
						ordinazioneList.add(pizzaFarcita);
					} else {
						String pizzeFarcite = "- " + quantita + " pizze farcite";
						ordinazioneList.add(pizzeFarcite);
					}
					break;

				case "4":

					try {
						System.out.println("Inserisci la quantità (per tavolo)");

						quantita = Integer.parseInt(reader.readLine());

					} catch (Exception e) {
						System.out.println("Input immesso errato");
					}

					myCassa.setCassa(myCassa.getCassa() + (9.90 * quantita));
					contoTemporaneoOrdinazione += (9.90 * quantita);

					if (quantita == 1) {
						String pizzaGourmet = "- " + quantita + " pizza gourmet";
						ordinazioneList.add(pizzaGourmet);
					} else {
						String pizzeGourmet = "- " + quantita + " pizze gourmet";
						ordinazioneList.add(pizzeGourmet);
					}
					break;

				case "5":

					try {
						System.out.println("Inserisci la quantità (per tavolo)");

						quantita = Integer.parseInt(reader.readLine());

					} catch (Exception e) {
						System.out.println("Input immesso errato");
					}

					myCassa.setCassa(myCassa.getCassa() + (10.90 * quantita));
					contoTemporaneoOrdinazione += (10.90 * quantita);

					if (quantita == 1) {
						String primodiMare = "- " + quantita + " primo di mare";
						ordinazioneList.add(primodiMare);
					} else {
						String primidiMare = "- " + quantita + " primi di mare";
						ordinazioneList.add(primidiMare);
					}
					break;

				case "6":

					try {
						System.out.println("Inserisci la quantità (per tavolo)");

						quantita = Integer.parseInt(reader.readLine());

					} catch (Exception e) {
						System.out.println("Input immesso errato");
					}

					myCassa.setCassa(myCassa.getCassa() + (8.90 * quantita));
					contoTemporaneoOrdinazione += (8.90 * quantita);

					if (quantita == 1) {
						String primodiTerra = "- " + quantita + " primo di terra";
						ordinazioneList.add(primodiTerra);
					} else {
						String primidiTerra = "- " + quantita + " primi di terra";
						ordinazioneList.add(primidiTerra);
					}
					break;
					
				case "7":

					try {
						System.out.println("Inserisci la quantità (per tavolo)");

						quantita = Integer.parseInt(reader.readLine());

					} catch (Exception e) {
						System.out.println("Input immesso errato");
					}

					myCassa.setCassa(myCassa.getCassa() + (1.00 * quantita));
					contoTemporaneoOrdinazione += (1.00 * quantita);

					if (quantita == 1) {
						String acqua = "- " + quantita + " acqua";
						ordinazioneList.add(acqua);
					} else {
						String acque = "- " + quantita + " acque";
						ordinazioneList.add(acque);
					}
					break;
					
				case "8":

					try {
						System.out.println("Inserisci la quantità (per tavolo)");

						quantita = Integer.parseInt(reader.readLine());

					} catch (Exception e) {
						System.out.println("Input immesso errato");
					}

					myCassa.setCassa(myCassa.getCassa() + (1.50 * quantita));
					contoTemporaneoOrdinazione += (1.50 * quantita);

					if (quantita == 1) {
						String bibita = "- " + quantita + " bibita";
						ordinazioneList.add(bibita);
					} else {
						String bibite = "- " + quantita + " bibite";
						ordinazioneList.add(bibite);
					}
					break;
					
				case "9":

					try {
						System.out.println("Inserisci la quantità (per tavolo)");

						quantita = Integer.parseInt(reader.readLine());

					} catch (Exception e) {
						System.out.println("Input immesso errato");
					}

					myCassa.setCassa(myCassa.getCassa() + (3.00 * quantita));
					contoTemporaneoOrdinazione += (3.00 * quantita);

					if (quantita == 1) {
						String birra = "- " + quantita + " birra";
						ordinazioneList.add(birra);
					} else {
						String birre = "- " + quantita + " birre";
						ordinazioneList.add(birre);
					}
					break;
					
				case "10":

					try {
						System.out.println("Inserisci la quantità (per tavolo)");

						quantita = Integer.parseInt(reader.readLine());

					} catch (Exception e) {
						System.out.println("Input immesso errato");
					}

					myCassa.setCassa(myCassa.getCassa() + (3.50 * quantita));
					contoTemporaneoOrdinazione += (3.50 * quantita);

					if (quantita == 1) {
						String vinodellaCasa = "- " + quantita + " vino della casa";
						ordinazioneList.add(vinodellaCasa);
					} else {
						String vinidellaCasa = "- " + quantita + " vini della casa";
						ordinazioneList.add(vinidellaCasa);
					}
					break;

				case "0":
					System.out.println("Registrazione ordinazione tavolo " + tavoloOrdinazione + " confermata\n");

					for (String singolaVoce : ordinazioneList) {
						System.out.println(singolaVoce);
					}
					System.out.println("\nTotale conto tavolo num." + tavoloOrdinazione + " = "
							+ Math.round(contoTemporaneoOrdinazione * 100.0) / 100.0 + " euro"
							+ " (coperto escluso)\n");

					return;

				default:
					System.out.println("Input errato");
					continue;

				}
			}

		}

	}
}
