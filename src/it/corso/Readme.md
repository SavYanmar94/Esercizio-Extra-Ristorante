Traccia extra - Ristorante : esercizio svolto in solitaria

Progettare un'applicazione a uso di camerieri e cassiera di una pizzeria, immaginando che
l'accesso alle informazioni e alle sue funzionalità siano condivise dal personale.
La sala sarà rappresentata da una "mappa" dei tavoli attraverso un array bidimensionale da
3x5, ove ciascun elemento individua un tavolo da 4 posti. I tavoli saranno di conseguenza
numerati secondo le coppie di indici dell'array, preventivamente incrementati di 1 per evitare
il tavolo "zero-zero". 

All'arrivo di clienti in coppie o comitive, in base al loro numero, l'applicazione deve consentire
al cameriere di assegnare i tavoli necessari tra quelli disponibili se sufficienti; viceversa un
messaggio informerà che la sala è piena: ciascun elemento dell'array potrà quindi contenere
i valori 0 (tavolo libero) oppure da 1 a 4 (tavolo occupato).
Implementare quindi il menù da mostrare ai clienti di ciascun tavolo, visualizzando nome
della pietanza e relativo prezzo oltre a un numero da digitare per ordinarla. Le ordinazioni
sono da intendersi per tavolo e non per cliente (2 persone potranno ordinare 5 pizze!).
Implementare una cassa cui fare conferire i prezzi di ciascuna consumazione, aggiungendo
un coperto di 2€ a persona, in modo da memorizzare e aggiornare l'incasso della serata.
L'applicazione deve indicare lo stato di sala piena nonché consentire di liberare un tavolo,
quando i clienti, terminata la consumazione, si recano alla cassa.
Predisporre gli opportuni costrutti try/catch per evitare che immissioni errate nel programma
ne causino il blocco, quindi organizzare l'incapsulamento dei dati.
Ipotetica schermata principale delle funzioni mostrate all'utente:
1. Assegna tavolo/tavoli
2. Prendi ordinazioni
3. Libera tavolo/tavoli
4. Stampa incasso e chiudi applicazione
Situazione di esempio
 Si lancia l'applicazione e si avvia il ciclo…
 Entra una comitiva di 5 persone, e uno dei camerieri assegna loro i tavoli liberi 11 e
21 (previa visualizzazione della "mappa" della sala) suddividendoli equamente,
passando i tavoli allo stato di occupato (funzione 1)
11:[3] 12:[0] 13:[0] 14:[0] 15:[0]
21:[2] 22:[0] 23:[0] 24:[0] 25:[0]
31:[0] 32:[0] 33:[0] 34:[0] 35:[0]
 In corrispondenza di ciascun tavolo il cameriere acquisisce le ordinazioni mostrando
il menù e ne invia i relativi prezzi in cassa incrementati di un coperto a persona, quindi
+6 € di coperto dal tavolo 11, +4€ di coperto dal tavolo 21 (funzione 2)
 La cassiera, ricevendo il pagamento dai 5 clienti al termine della consumazione,
ripristina lo stato dei tavoli 11 e 21 allo stato di libero (funzione 3)
 A fine serata, chiudendo il ciclo, si verifica l'incasso chiudendo poi automaticamente
l'applicazione (funzione 4)

Traccia avanzata

Dopo aver svolto tutte le parti della traccia base:
 parametrizzare la sala ad avvio dell'applicazione, decidendo le dimensioni della
"mappa" inputando le dimensioni dell'array bidimensionale
 prevedere la vendita tramite asporto (ordinazione "al volo" senza un tavolo
assegnato).