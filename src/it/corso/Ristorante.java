package it.corso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ristorante {

	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	Cassa cassa = new Cassa();
	Tavolo tavolo = new Tavolo(cassa);
	Ordinazione myOrdinazione = new Ordinazione(cassa, tavolo);
	Asporto asporto = new Asporto(cassa);

	public void dashboard() throws InterruptedException, IOException {

		tavolo.registraTavoliArray();
		tavolo.mostraTavoli();
		tavolo.assegnaTavolo();

		while (true) {

			System.out.println("Salve, quali operazioni desideri fare ?\n");
			System.out.println("Digita 1 : assegna tavolo/i");
			System.out.println("Digita 2 : prendi ordinazioni");
			System.out.println("Digita 3 : libera tavolo/tavoli");
			System.out.println("Digita 4 : mostra situazione tavolo/tavoli");
			System.out.println("Digita 5 : prendi ordini da asporto");
			System.out.println("Digita 6 : stampa incasso totale e chiudi applicazione");

			String sceltaDashboard = reader.readLine();

			switch (sceltaDashboard) {

			case "1":

				tavolo.assegnaTavolo();

				break;

			case "2":

				myOrdinazione.registraOrdinazioni();
				break;

			case "3":

				tavolo.liberaTavolo();
				break;

			case "4":

				tavolo.mostraTavoli();
				break;

			case "5":
				asporto.registraOrddaAsporto();
				break;

			case "6":
				
				int sommaPersoneinSala = 0;
				
				// calcolo di tutte le persone in sala, se nel caso sono zero , non dobbiamo liberare nulla 
				// quindi ritorniamo al menu principale
				for (int riga = 0; riga < tavolo.tavoli.length; riga++) {
					for (int colonna = 0; colonna < tavolo.tavoli[riga].length; colonna++) {
						sommaPersoneinSala += tavolo.tavoli[riga][colonna];
					}
				}
				
				if (sommaPersoneinSala == 0){
					System.out.println("Tutti i tavoli sono liberi.");
					System.out.println(
							"L'incasso totale di oggi è " + Math.round(cassa.getCassa() * 100.0) / 100.0 + " euro");
					System.out.println("Programma in chiusura...");
					Thread.sleep(2000);
					System.exit(0);
					
				} else 
					System.out.println("Per poter chiudere il programma, ");
					System.out.println("devi prima liberare tutti i tavoli!\n");
					continue;

			default:

				System.out.println("Input Errato");
				break;
			}
		}

	}

}
