package it.corso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tavolo {
	
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	int numRighe = 3;
	int numColonne = 5;

	public void NumerototTavoli() throws NumberFormatException, IOException {
		
	  while(true) {
		try {
			System.out.println("Determina la disposizione della sala in righe e colonne");
			System.out.println("Scrivi il numero di righe");
			numRighe = Integer.parseInt(reader.readLine());
			System.out.println("Scrivi il numero di colonne");
			numColonne = Integer.parseInt(reader.readLine());
			break;
			
		} catch (Exception e) {
			System.out.println("Input errato");
		
		
		}
	  }
	  mostraTavoli();
	}
	
	public int[][] tavoli = new int[numRighe][numColonne];
	
	Cassa cassa;
	int comitiva;
	int limiteTavoli = 4;
	int capacitaRistorante = limiteTavoli * tavoli.length * tavoli[0].length;
	

	public Tavolo(Cassa cassa){
		this.cassa = cassa;
		try {
			NumerototTavoli();
			assegnaTavolo();
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		} // Chiamiamo il metodo per ottenere i valori delle righe e colonne
        tavoli = new int[numRighe][numColonne]; // Inizializziamo l'array tavoli
    }
	
	
	public Tavolo() {
		
	}
	
	
	

	public void mostraTavoli() {
		
		int nuovariga;
		int nuovacolonna;
		
		System.out.println("Ecco la situazione attuale dei tavoli:\n");
		
		
		for (int riga =0; riga < tavoli.length;riga++) {
			for(int colonna=0; colonna < tavoli[riga].length;colonna++) {
				nuovariga = riga + 1;
				nuovacolonna = colonna + 1;
				
				//inseriamo un altro ciclo for interno
				
				for (int i = 1; i <= numRighe;i++) {
					
				if(nuovariga == i && nuovacolonna > 0 && nuovacolonna <= numColonne)
					System.out.print(" "+ nuovariga + nuovacolonna + ":[" + tavoli[riga][colonna] + "] ");
				}
				
				
			    
			}
			System.out.println("\n");
		}
	
		
	}
	
	
	public void assegnaTavoloAutomatico() throws NumberFormatException, IOException {
			
	   int sommaPersoneinSala = 0;
		
	while(true) {
		

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
			break;
			
		} catch (Exception e) {
			System.out.println("Input immesso errato");
		  }
	    }
	
	//calcolo di tutte le persone in sala , se nel caso sforiamo la capacità massima
	for (int riga = 0; riga < tavoli.length; riga++) {
	    for (int colonna = 0; colonna < tavoli[riga].length; colonna++) {
	    	sommaPersoneinSala += tavoli[riga][colonna];
	    } 
	}
    
	if ((comitiva + sommaPersoneinSala) > capacitaRistorante) {
		System.out.println("Attenzione siamo sopra la capienza massima!");
		System.out.println("Devi prima liberare qualche tavolo!");
		return;
	}
	
	
		cassa.setCassa(cassa.getCassa()+(comitiva*2));
		
		for (int riga = 0; riga < tavoli.length; riga++) {
		    for (int colonna = 0; colonna < tavoli[riga].length; colonna++) {
		        // Ora vediamo se il tavolo è libero (il valore dell'array è uguale a 0)
		        if (tavoli[riga][colonna] == 0) {
		            if (comitiva <= limiteTavoli) {
		                // Se la comitiva è al massimo 4 persone, assegnala a questo tavolo
		                tavoli[riga][colonna] = comitiva;
		                comitiva = 0; // Tavolo completamente occupato
		            } else if ( comitiva % 2 == 1){
		            	tavoli[riga][colonna] = 3;
		            	comitiva -= 3;
		            	
		            } else {
		                // Se la comitiva è più grande di 4 persone, riempi il tavolo con 4 persone
		                tavoli[riga][colonna] = limiteTavoli;
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
		
		mostraTavoli();
		
		int sommaPersoneinSala = 0;
		
		while(true) {
			
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
			break;
			
		} catch (Exception e) {
			System.out.println("Input immesso errato");
		}
		
		
	   }
		//calcolo di tutte le persone in sala , se nel caso sforiamo la capacità massima
		for (int riga = 0; riga < tavoli.length; riga++) {
		    for (int colonna = 0; colonna < tavoli[riga].length; colonna++) {
		    	sommaPersoneinSala += tavoli[riga][colonna];
		    } 
		}
	    
		if ((comitiva + sommaPersoneinSala) > capacitaRistorante) {
			System.out.println("Attenzione siamo sopra la capienza massima!");
			System.out.println("Devi prima liberare qualche tavolo!");
			return;
		}
		
	
		while (true) {
			
			
	        try {
	        	System.out.println("A quale tavolo vuoi aggiungere le persone ?  ");
				String tavoloDaAggiungere = reader.readLine();
				int indexuno = (Integer.parseInt(tavoloDaAggiungere.substring(0,1)))-1;
				int indexdue = (Integer.parseInt(tavoloDaAggiungere.substring(1,2)))-1;
				int personeTavolo;
				
				
				
				
				if (indexuno >=0 && indexuno <=numRighe && indexdue >=0 && indexdue <=numColonne && tavoloDaAggiungere.length() == 2) {
					
					if(tavoli[indexuno][indexdue]!=0) {
						System.out.println("Tavolo già occupato ! Inserisci un altro tavolo:");
						continue; // Torna all'inizio del ciclo
					}
					
					System.out.println("Puoi aggiungere massimo " + limiteTavoli + " persone per tavolo");
					System.out.println("Quante persone vuoi aggiungere a questo tavolo?");
					personeTavolo = Integer.parseInt(reader.readLine());
	            
					if (personeTavolo > limiteTavoli) {
						System.out.println("Puoi aggiungere massimo " + limiteTavoli + " persone per tavolo");
					} else if (personeTavolo > comitiva) {
						System.out.println("Non puoi aggiungere più persone di quelle disponibili");
					} else {
						tavoli[indexuno][indexdue] = personeTavolo;
						System.out.println("Tavolo registrato con successo!");
						comitiva -= personeTavolo;
						System.out.println("Ti rimangono ancora da accomodare " + comitiva + " persone");
						
						if (comitiva == 0) {
							break; // Tutte le persone sono state accomodate
						}
					}
				} else {
						System.out.println("numero tavolo errato");
						System.out.println("reinserisci correttamente il numero tavolo");
					}
	            
	        	} catch (Exception e) {
	            System.out.println("Input immesso errato");
	        	}
	        
	        mostraTavoli();
	    }
		
	   }
		
		
		

	
	public void assegnaTavolo() throws IOException {
		
		
	    while(true) {
	    	
	    	System.out.println("Digita 1 per assegnare il tavolo manualmente, 2 per assegnazione automatica");
			String assegnazione = reader.readLine();
			
	    	if (assegnazione.equals("1")){
				assegnaTavoloManualmente();
				break;
			} else if (assegnazione.equals("2")){
				assegnaTavoloAutomatico();
				break;
			} else {
				System.out.println("Input errato");
				
			}
	    }
		
		
		
		
	}
	
	
	public void liberaTavolo() throws IOException {
		System.out.println("Quale tavolo vuoi liberare? ");
		
		while(true) {	
			
			try {
				
				String tavolodaliberare = reader.readLine();
				int indexuno = (Integer.parseInt(tavolodaliberare.substring(0,1)))-1;
				int indexdue = (Integer.parseInt(tavolodaliberare.substring(1,2)))-1;
				
				
				if ( indexuno >=0 && indexuno <=numRighe && indexdue >=0 && indexdue <=numColonne && tavolodaliberare.length() == 2) {
					tavoli[indexuno][indexdue] = 0;
					System.out.println("Tavolo liberato con successo");
					break;
				
				
					
				} else {
					System.out.println("numero tavolo errato");
					System.out.println("reinserisci correttamente il numero tavolo");
				}
				
			} catch (Exception e) {
				System.out.println("Input immesso errato");
				System.out.println("Reinserisci correttamente il numero tavolo");
				
			}
			
		}
			
		
		mostraTavoli();
	}
	

	

}
