package main;

import java.util.Scanner;

import dao.DaoVideogioco;
import entities.Videogioco;
import interfaces.IDao;

public class Main_Videogioco {

	public static void main(String[] args) 
	{
		String nomeDb = "videogiochi";
		IDao d = new DaoVideogioco(nomeDb, "root", "root");
		Scanner tastiera = new Scanner(System.in);
		int scelta = 0;
		
		do
		{
			System.out.println("1) Stampa elenco videogiochi" 												+ 
							   "\n2) Create" 																+
							   "\n3) Update" 																+
							   "\n4) Delete" 																+
							   "\n5) Aggiungi tu un videogioco" 											+
							   "\n6) Aggiorna la caratteristica che preferisci di un videogioco" 			+
							   "\n7) Cancella in base all'ID a tua scelta"									+
							   "\n8) Aggiungi videogiochi da file txt" 										+
							   "\n9) Scopri quali giochi random puoi acquistare con un tot di budget"		+
							   "\n10) Visualizza videogiochi per una determinata piattaforma"				+
							   "\n11) Visualizza videogiochi per genere"									+
							   "\n12) Scopri se il gioco che cerchi e' scontato"							+
							   "\n13) Usa questo se non sei sicuro sul nome corretto del gioco"				+
							   "\n14) Usa questo se sei sicuro sul nome corretto"							+
							   "\n15) Compara i voti di 2 titoli"											+
							   "\n16) Trova un gioco in base all'anno che hai scelto"						+
							   "\n17) Visualizza il gioco piu' costoso"										+
							   "\n18) Visualizza il gioco piu' economico"									+
							   "\n19) Cancella tra un ID e l'altro a tua scelta"							+
							   "\n20) Trova giochi in base allo sviluppatore" 								+
							   "\n21) Carrello della spesa"													+
							   "\n0) Per uscire");
			scelta = Integer.parseInt(tastiera.nextLine());
			switch(scelta)
			{
			case 1:
				System.out.println("Elenco:\n" + d.stampaElenco());
				break;
			case 2:
				Videogioco videogioco = new Videogioco("Fortnite", "Nintendo Switch", "Platformer", 2020, "Nintendo", 9.0, 57.99);
				d.create(videogioco);
				break;
			case 3:
				Videogioco update = new Videogioco(6, "Fortnite", "Nintendo DS", "Platformer", 2020, "Valve", 9.0, 37.99);
				d.update(update);
				break;
			case 4:
				d.delete(23);
				break;
			case 5:
				d.createUtente();
				break;
			case 6:
				System.out.println("Inserisci l'id del gioco che vuoi modificare");
		        int sceltaId = Integer.parseInt(tastiera.nextLine());
		        System.out.println("Cosa vuoi modificare?");
		        String scelta2 = tastiera.nextLine();
		        d.update(sceltaId, scelta2);
				break;
			case 7:
				System.out.println("Inserisci l'id del gioco che desideri cancellare");
				int sceltaId2 = Integer.parseInt(tastiera.nextLine());
				d.deleteUtente(sceltaId2);
				break;
			case 8:
				d.insertGames();
				break;
			case 9:
				System.out.println(d.affordable());
				break;
			case 10:
				System.out.println("Inserisci la console");
				String console;
				int play = 0;
				console = tastiera.nextLine();
				if (console.equalsIgnoreCase("PlayStation"))
				{
					System.out.println("Quale PlayStation?");
					play = Integer.parseInt(tastiera.nextLine());
					System.out.println(d.playStation(play));	 
				}
				else 
				{
				System.out.println(d.consoleGame(console));
				}
				break;
			case 11:
				String genere = "";
				System.out.println("Inserisci il genere");
				genere = tastiera.nextLine();
				System.out.println(d.trovaPerGenere(genere));
				break;
			case 12:
				System.out.println("Inserisci il titolo");
				String titolo = tastiera.nextLine();
				System.out.println(d.scontoGiochi(titolo));
				break;
			case 13:
				String nome1 = "";
				System.out.println("Inserisci il gioco da cercare e troveremo l'affinita' migliore");
                nome1 = tastiera.nextLine();
                System.out.println(d.contacaratteri(nome1));
            break;
			case 14:
				String testo = "";
				System.out.println("Inserisci il nome del gioco che stai cercando");
                testo = tastiera.nextLine();
                System.out.println(d.trovaPerNome(testo));
				break;
			case 15:
				String nome2 = "";
				System.out.println("Inserisci il nome del gioco che dev'essere comparato");
                nome1 = tastiera.nextLine();
                System.out.println("Inserisci il nome del gioco con cui lo vuoi comparare");
                nome2 = tastiera.nextLine();
                System.out.println(d.compara(nome1, nome2));
				break;
			case 16:
				int anno;
				System.out.println("Inserisci l'anno");
				anno = Integer.parseInt(tastiera.nextLine());
				System.out.println(d.trovaPerAnno(anno));
				break;
			case 17:
				System.out.println(d.prezzoMax());
				break;
			case 18:
				System.out.println(d.prezzoMin2());
				break;
			case 19:
				int id1;
				int id2;
				System.out.println("Inserisci il primo ID");
				id1 = Integer.parseInt(tastiera.nextLine());
				System.out.println("Inserisci il secondo ID");
				id2 = Integer.parseInt(tastiera.nextLine());
				d.deleteBetween(id1, id2);
				break;
			case 20:
				String sviluppatore = "";
				System.out.println("Inserisci sviluppatore");
				sviluppatore = tastiera.nextLine();
				System.out.println(d.trovaPerSviluppatore(sviluppatore));
				break;
			case 21:
				System.out.println(d.carrellodellaspesa2());
				break;
			case 0:
				System.out.println("Grazie e buona giornata!");
				break;
			default:
				System.out.println("Errore, penso tu abbia inserito un numero errato");
				break;
			}
		}while(scelta != 0);
		tastiera.close();
	}
}