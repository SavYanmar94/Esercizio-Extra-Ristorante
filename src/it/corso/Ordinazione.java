package it.corso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

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
		System.out.println("\nCosto coperto - 2 euro/p\n");
	}

	public void registraOrdinazioni() throws IOException {
		
		double contoTemporaneoOrdinazione = 0.0;
		
		ArrayList<String> ordinazioneList= new ArrayList<>();
		
		int quantita = 0;
		    
	    mostraMenu();

	    String tavoloOrdinazione = null;
	    int indexuno;
	    int indexdue;

	    while (true) {
	        try {
	            System.out.println("Di quale tavolo vuoi prendere l'ordinazione ?");
	            tavoloOrdinazione = reader.readLine();
	            
	            indexuno = (Integer.parseInt(tavoloOrdinazione.substring(0,1)))-1;
	            indexdue = (Integer.parseInt(tavoloOrdinazione.substring(1,2)))-1;
	            
	            if (indexuno >= 0 && indexuno <= 2 && indexdue >= 0 && indexdue <= 4 && tavoloOrdinazione.length() == 2) {
	                if (tavolo.tavoli[indexuno][indexdue] == 0) {
	                    System.out.println("Non puoi prendere un ordinazione da un tavolo libero!");
	                    continue;
	                } else {
	                    break; // Esci dal ciclo se l'input è valido
	                }
	            } else {
	                System.out.println("Numero tavolo errato. Reinserisci correttamente il numero tavolo.");
	            }
	        } catch (Exception e) {
	            System.out.println("Input immesso errato. Reinserisci correttamente il numero tavolo.");
	        }
	    }
	    
		while (true) {
				
			
			System.out.println("Registra le ordinazioni \n");
			System.out.println("digita 1 per gli antipasti");
			System.out.println("digita 2 per la pizza margherita");
			System.out.println("digita 3 per la pizza farcita");
			System.out.println("digita 4 per la pizza gourmet");
			System.out.println("digita 5 per primo di mare");
			System.out.println("digita 6 per primo di terra");
			System.out.println("digita 7 per confermare ordinazione e tornare al menu principale");

				String sceltaordinazioni = reader.readLine();
	        
	        
				
	        
				switch (sceltaordinazioni) {
	            	case "1":
	            		

	    				try {
	    					System.out.println("Inserisci la quantità (per tavolo)");
	    		        
	    					quantita = Integer.parseInt(reader.readLine());
	    				
	    				
	    				} catch (Exception e) {
	    				System.out.println("Input immesso errato");
	    				}	
	    	        
	            		myCassa.setCassa(myCassa.getCassa() + (4.90*quantita));
	            		contoTemporaneoOrdinazione+=(4.90*quantita);
	            	
	                	if (quantita == 1 ) {
	            		String antipasto = "- "+ quantita + " antipasto";
	            		ordinazioneList.add(antipasto);
	            		} else {
	            		String antipasti = "- "+ quantita + " antipasti";
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
	    	        
	            		
	            		myCassa.setCassa(myCassa.getCassa() + (4.90*quantita));
	            		contoTemporaneoOrdinazione+=(4.90*quantita);
		            	
	                	if (quantita == 1 ) {
	            		String pizzaMargherita = "- "+ quantita + " pizza margherita";
	            		ordinazioneList.add(pizzaMargherita);
	            		} else {
	            		String pizzeMargherite = "- "+ quantita + " pizze margherite";
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
	    	        
	    				
	            		myCassa.setCassa(myCassa.getCassa() + (7.90*quantita));
	            		contoTemporaneoOrdinazione+=(7.90*quantita);
	            		
	            		if (quantita == 1 ) {
		            		String pizzaFarcita = "- "+ quantita + " pizza farcita";
		            		ordinazioneList.add(pizzaFarcita);
		            		} else {
		            		String pizzeFarcite = "- "+ quantita + " pizze farcite";
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
	    	        
	    				
	            		myCassa.setCassa(myCassa.getCassa() + (9.90*quantita));
	            		contoTemporaneoOrdinazione+=(9.90*quantita);
	            		
	            		if (quantita == 1 ) {
		            		String pizzaGourmet = "- "+ quantita + " pizza gourmet";
		            		ordinazioneList.add(pizzaGourmet);
		            		} else {
		            		String pizzeGourmet = "- "+ quantita + " pizze gourmet";
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
			        
						
						
		                myCassa.setCassa(myCassa.getCassa() + (10.90*quantita));
		                contoTemporaneoOrdinazione+=(10.90*quantita);
		                
		                if (quantita == 1 ) {
		            		String primodiMare = "- "+ quantita + " primo di mare";
		            		ordinazioneList.add(primodiMare);
		            		} else {
		            		String primidiMare = "- "+ quantita + " primi di mare";
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
			        
						
		                myCassa.setCassa(myCassa.getCassa() + (8.90*quantita));
		                contoTemporaneoOrdinazione+=(8.90*quantita);
		                
		                if (quantita == 1 ) {
		            		String primodiTerra = "- "+ quantita + " primo di terra";
		            		ordinazioneList.add(primodiTerra);
		            		} else {
		            		String primidiTerra = "- "+ quantita + " primi di terra";
		            		ordinazioneList.add(primidiTerra);
		            		}
	            		break;
	            		
		            case "7":
		            	System.out.println("Registrazione ordinazione tavolo " + tavoloOrdinazione + " confermata\n");
		            	
		            	for(String singolaVoce: ordinazioneList) {
		            		System.out.println(singolaVoce);
		            	}
		            	System.out.println("\nTotale conto tavolo num." + tavoloOrdinazione + " = " + Math.round(contoTemporaneoOrdinazione * 100.0) / 100.0 + " euro" + " (coperto escluso)\n");
		            	
		            	
		            	return;
		            	
		            	
		            default:
		                System.out.println("Input errato");
		                registraOrdinazioni();
		                break;
	            
	        
				}
				}
	    
	}
	
	
}
