package it.corso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Asporto {
	
	Cassa myCassa;
	Ordinazione ordinazione = new Ordinazione();
	
	public Asporto(Cassa cassa) {
		this.myCassa = cassa;
	}
			

public void registraOrddaAsporto() throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
		double contoTemporaneoOrdinazione = 0.0;
		
		ArrayList<String> AsportoList= new ArrayList<>();

		
		int quantita = 0;
		    
		System.out.println("------Menu------\n");
		System.out.println("1.Antipasti - 4.90 euro");
		System.out.println("2.Pizza margherita - 4.90 euro");
		System.out.println("3.Pizza farcita - 7.90 euro");
		System.out.println("4.Pizza gourmet - 9.90 euro");
		System.out.println("5.Primo di mare - 10.90 euro");
		System.out.println("6.Primo di terra - 8.90 euro");
	    
	    System.out.println("Inserisci il nominativo cliente");
	    String nominativoCliente = reader.readLine();
	    
	    while(true) {
	    	
		    if(nominativoCliente.length()>2) {
		    	System.out.println("Nome inserito correttamente");
		    	break;
		    } else {
		    	System.out.println("Il nominativo deve essere almeno di 3 lettere");
		    }
	    }
	    
	    while (true) {
				
			
			System.out.println("Registra le ordinazioni per il cliente " + nominativoCliente + "\n");
			System.out.println("digita 1 per gli antipasti(4.90 euro)");
			System.out.println("digita 2 per la pizza margherita(4.90 euro)");
			System.out.println("digita 3 per la pizza farcita(7.90 euro)");
			System.out.println("digita 4 per la pizza gourmet(9.90 euro)");
			System.out.println("digita 5 per primo di mare(10.90 euro)");
			System.out.println("digita 6 per primo di terra(8.90 euro)");
			System.out.println("digita 7 per confermare ordinazione e tornare al menu principale");

				String sceltaAsporto = reader.readLine();
	        

				switch (sceltaAsporto) {
	            	case "1":
	            		

	    				try {
	    					System.out.println("Inserisci la quantità");
	    		        
	    					quantita = Integer.parseInt(reader.readLine());
	    				
	    				
	    				} catch (Exception e) {
	    				System.out.println("Input immesso errato");
	    				}	
	    	        
	            		myCassa.setCassa(myCassa.getCassa() + (4.90*quantita));
	            		contoTemporaneoOrdinazione+=(4.90*quantita);
	            	
	                	if (quantita == 1 ) {
	            		String antipasto = "- "+ quantita + " antipasto";
	            		AsportoList.add(antipasto);
	            		} else {
	            		String antipasti = "- "+ quantita + " antipasti";
	            		AsportoList.add(antipasti);
	            		}
	                	
	            		break;
	            		
	            	case "2":
	            		

	    				try {
	    					System.out.println("Inserisci la quantità");
	    		        
	    					quantita = Integer.parseInt(reader.readLine());
	    				
	    				
	    				} catch (Exception e) {
	    				System.out.println("Input immesso errato");
	    				}	
	    	        
	            		
	            		myCassa.setCassa(myCassa.getCassa() + (4.90*quantita));
	            		contoTemporaneoOrdinazione+=(4.90*quantita);
		            	
	                	if (quantita == 1 ) {
	            		String pizzaMargherita = "- "+ quantita + " pizza margherita";
	            		AsportoList.add(pizzaMargherita);
	            		} else {
	            		String pizzeMargherite = "- "+ quantita + " pizze margherite";
	            		AsportoList.add(pizzeMargherite);
	            		}
	                	
	            		break;
	            		
	            		
	            		
	            	case "3":
	            		

	    				try {
	    					System.out.println("Inserisci la quantità");
	    		        
	    					quantita = Integer.parseInt(reader.readLine());
	    				
	    				
	    				} catch (Exception e) {
	    				System.out.println("Input immesso errato");
	    				}	
	    	        
	    				
	            		myCassa.setCassa(myCassa.getCassa() + (7.90*quantita));
	            		contoTemporaneoOrdinazione+=(7.90*quantita);
	            		
	            		if (quantita == 1 ) {
		            		String pizzaFarcita = "- "+ quantita + " pizza farcita";
		            		AsportoList.add(pizzaFarcita);
		            		} else {
		            		String pizzeFarcite = "- "+ quantita + " pizze farcite";
		            		AsportoList.add(pizzeFarcite);
		            		}
	            		break;
	                
	            	case "4":
	            		

	    				try {
	    					System.out.println("Inserisci la quantità");
	    		        
	    					quantita = Integer.parseInt(reader.readLine());
	    				
	    				
	    				} catch (Exception e) {
	    				System.out.println("Input immesso errato");
	    				}	
	    	        
	    				
	            		myCassa.setCassa(myCassa.getCassa() + (9.90*quantita));
	            		contoTemporaneoOrdinazione+=(9.90*quantita);
	            		
	            		if (quantita == 1 ) {
		            		String pizzaGourmet = "- "+ quantita + " pizza gourmet";
		            		AsportoList.add(pizzaGourmet);
		            		} else {
		            		String pizzeGourmet = "- "+ quantita + " pizze gourmet";
		            		AsportoList.add(pizzeGourmet);
		            		}
	            		break;
	            		
		            case "5":
		            	

						try {
							System.out.println("Inserisci la quantità");
				        
							quantita = Integer.parseInt(reader.readLine());
						
						
						} catch (Exception e) {
						System.out.println("Input immesso errato");
						}	
			        
						
						
		                myCassa.setCassa(myCassa.getCassa() + (10.90*quantita));
		                contoTemporaneoOrdinazione+=(10.90*quantita);
		                
		                if (quantita == 1 ) {
		            		String primodiMare = "- "+ quantita + " primo di mare";
		            		AsportoList.add(primodiMare);
		            		} else {
		            		String primidiMare = "- "+ quantita + " primi di mare";
		            		AsportoList.add(primidiMare);
		            		}
	            		break;
		            
		            case "6":
		            	

						try {
							System.out.println("Inserisci la quantità");
				        
							quantita = Integer.parseInt(reader.readLine());
						
						
						} catch (Exception e) {
						System.out.println("Input immesso errato");
						}	
			        
						
		                myCassa.setCassa(myCassa.getCassa() + (8.90*quantita));
		                contoTemporaneoOrdinazione+=(8.90*quantita);
		                
		                if (quantita == 1 ) {
		            		String primodiTerra = "- "+ quantita + " primo di terra";
		            		AsportoList.add(primodiTerra);
		            		} else {
		            		String primidiTerra = "- "+ quantita + " primi di terra";
		            		AsportoList.add(primidiTerra);
		            		}
	            		break;
	            		
		            case "7":
		            	System.out.println("Registrazione ordinazione asporto " + nominativoCliente + " confermata\n");
		            	
		            	for(String singolaVoce: AsportoList) {
		            		System.out.println(singolaVoce);
		            	}
		            	System.out.println("\nTotale conto tavolo num." + nominativoCliente + " = " + Math.round(contoTemporaneoOrdinazione * 100.0) / 100.0 + " euro" + "\n");
		            	
		            	
		            	return;
		            	
		            	
		            default:
		                System.out.println("Input errato");
		                registraOrddaAsporto();
		                break;
	            
	        
				}
				}
	    
	}
}
