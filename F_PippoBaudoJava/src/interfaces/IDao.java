package interfaces;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import entities.Videogioco;

public interface IDao 
{
	public List<Videogioco> read();

	public void create(Videogioco v);

	public void createUtente();

	public void update(Videogioco v);

	public void update(int id, String campoDaModificare);

	public void delete(int id);
	
	public void deleteUtente(int id);
	
	public void deleteBetween(int id1, int id2);

	public void insertGames();

	default String stampaElenco() 
	{
		String ris = "";
		for(Videogioco v : read())
		{
			ris += v.toString();
		}
		return ris;
	}	

	default String affordable() 
	{
		String stampa = "";
		String ris = "";

		ArrayList<Integer> ids = new ArrayList<Integer>();
		Scanner tastiera = new Scanner(System.in);
		System.out.println("Inserisci il tuo budget");
		int i = 0;

		double budget = Double.parseDouble(tastiera.nextLine());
		double iniz = budget;
		do {
			int index = (int) (Math.random() * read().size());
			Videogioco v = read().get(index);

			if (v.getPrezzo() <= budget && !ids.contains(v.getId())) 
			{ 
				stampa += "★" +v.getTitolo() + " -" + v.getPrezzo() + "€\n";
				i++;

				ids.add(v.getId());
				budget -= v.getPrezzo();
			}

		}while (budget >= prezzoMin() && i < read().size()); 

		ris = "---------------\nSei rimasto con " + String.format("%.2f", budget) + " euro di budget" + "\n";

		return "Con un budget di " + iniz + "€\nhai potuto acquistare questi " + i + " giochi! \n---------------\n" + stampa + ris;
	}

	default Double prezzoMin() 
	{
		double min = Double.MAX_VALUE;
		for (Videogioco v : read()) 
		{
			if (v.getPrezzo() <= min) 
			{
				min = v.getPrezzo();	
			}
		}
		return min;
	}
	
	default String prezzoMin2() 
	{
		String ris = "";
		double min = Double.MAX_VALUE;
		for (Videogioco v : read()) 
		{
			if (v.getPrezzo() <= min) 
			{
				min = v.getPrezzo();
				ris = "Il gioco meno costoso e' " + v.toString();
				
			}
		}
		return ris;
	}

	default String prezzoMax() 
	{
		String ris = "";
		double max = Double.MIN_VALUE;
		for (Videogioco v : read()) 
		{
			if (v.getPrezzo() >= max) 
			{
				max = v.getPrezzo();
				ris = "Il gioco più costoso e' " + v.toString();
			}
		}
		return ris;
	}
	
	default String consoleGame(String console)
	{
		String ris = "";
		boolean check = false;
		for (Videogioco v : read()) 
		{
			if (v.getPiattaforma().toLowerCase().contains(console.toLowerCase())) 
			{
				ris += v.toString();
				check = true;
			}
		}
		if (!check)
		{
			ris = "Non esistono giochi nel nostro DB con questa piattaforma, ci dispiace!";
		}
		return ris;
	}

	default String playStation(int play)
	{
		String ris = "";
		boolean check = false;
		
		for (Videogioco v : read())
		{
			switch(play)
			{
			case 1:
				if (v.getPiattaforma().equalsIgnoreCase("PlayStation 1"))
				{
					ris += v.toString();
					check = true;
				}
				if (!check)
				{
					ris = "Non esistono giochi nel nostro DB per questa console, ci dispiace!";
				}
				break;
			case 2:
				if (v.getPiattaforma().equalsIgnoreCase("PlayStation 2"))
				{
					ris += v.toString();
					check = true;
				}
				if (!check)
				{
					ris = "Non esistono giochi nel nostro DB per questa console, ci dispiace!";
				}
				break;
			case 3:
				if (v.getPiattaforma().equalsIgnoreCase("PlayStation 3"))
				{
					ris += v.toString();
					check = true;
				}
				if (!check)
				{
					ris = "Non esistono giochi nel nostro DB per questa console, ci dispiace!";
				}
				break;
			case 4:
				if (v.getPiattaforma().equalsIgnoreCase("PlayStation 4"))
				{
					ris += v.toString();
					check = true;
				}
				if (!check)
				{
					ris = "Non esistono giochi nel nostro DB per questa console, ci dispiace!";
				}
				break;
			case 5:
				if (v.getPiattaforma().equalsIgnoreCase("PlayStation 5"))
				{
					ris += v.toString();
					check = true;
				}
				if (!check)
				{
					ris = "Non esistono giochi nel nostro DB per questa console, ci dispiace!";
				}
				break;
				default:
					System.out.println("Errore");
				break;
			}
		}
		return ris;
	}
	
	default String trovaPerGenere(String genere) 
	{
        String ris = "";
        boolean check = false;
        for (Videogioco v : read()) 
        {
            if (v.getGenere().toLowerCase().contains(genere)) 
            {
                ris += v.toString();
                check = true;
            }
        }
        if (!check)
		{
			ris = "Non esistono giochi nel nostro DB con questo genere, ci dispiace!";
		}
        return ris;
    }
	
	default String trovaPerAnno(int anno)
	{
		String ris = "";
		boolean check = false;
		
		for(Videogioco v : read())
		{
			int annoGioco = v.getAnnoDiPubblicazione();
			if(annoGioco == anno)
			{
				ris += v.toString();
				check = true;
			}	
		}
		if (!check)
		{
			ris = "Non esistono giochi nel nostro DB per l'anno specificato, ci dispiace!";
		}
		return ris;
	}
	
	default String trovaPerNome(String nome)
    {
        String ris = "";
        boolean check = false;
        for (Videogioco v : read()) 
        {
            if (v.getTitolo().toLowerCase().contains(nome.toLowerCase())) 
            {
                ris += v.toString();
                check = true;
            }
        }
        if(!check)
        {
        	ris = "Non esistono giochi nel nostro DB con questo nome, ci dispiace!";
        }
        return ris;
    }
	
	default String trovaPerSviluppatore(String sviluppatore)
    {
        String ris = "";
        for (Videogioco v : read()) 
        {
            if (v.getSviluppatore().toLowerCase().contains(sviluppatore.toLowerCase())) 
            {
                ris += v.toString();
            }
        }
        return ris;
    }
	
	default String compara(String nome1, String nome2)
    {
        String ris = "";
        double voto1 = 0;
        double voto2 = 0;
        String temp1 = "";
        String temp2 = "";
        for (Videogioco v : read()) 
        {
             if (v.getTitolo().toLowerCase().contains(nome1.toLowerCase())) 
                {
                    ris += v.toString();
                    voto1 = v.getValutazione();
                    temp1 = v.toString();
                }

             if (v.getTitolo().toLowerCase().contains(nome2.toLowerCase())) 
                {
                    ris += v.toString();
                    voto2 = v.getValutazione();
                    temp2 = v.toString();
                }

             if(voto1 > voto2)
             {
                 ris = "Il migliore tra i due è: " + temp1;
             }
             else
             {
                 ris = "Il migliore tra i due è: " + temp2;
             }
        }
        return ris;
    }
	
	default String scontoGiochi(String titolo) 
	{
	    String ris = "";
	    int annoCorrente = 2023, sconto = 10;
	    double prezzoScontato;
	    
	    for (Videogioco v : read()) 
	    {
	        if (v.getTitolo().equalsIgnoreCase(titolo)) 
	        {
	            int annoGioco = v.getAnnoDiPubblicazione();
	            if (annoCorrente - annoGioco >= 8) 
	            {
	                prezzoScontato = v.getPrezzo() - sconto;
	                ris = titolo + " e' scontato e costa " + String.format("%.2f", prezzoScontato);
	            } 
	            else 
	            {
	                ris = titolo + " non e' scontato";
	            }
	            break; // Esci dal ciclo una volta trovato il videogioco corrispondente al titolo
	        }
	    }
	    return ris;
	}
	
	default String contacaratteri(String parola1) 
    {
        String ris = "";
        String lettere = "";
        int maxCount = 0;
        int conta = 0;
        String imigliori = "";
        Videogioco maxVideogioco = null;

        for (Videogioco v : read()) 
        {
            String titolo = v.getTitolo().toLowerCase();
            int count = 0;
            int length = Math.min(parola1.length(), titolo.length());
            for (int i = 0; i < length; i++) 
            {
                if (parola1.charAt(i) == titolo.charAt(i)) 
                {
                    lettere += parola1.charAt(i);
                    count++;
                }
            }
            if (count > maxCount) 
            {
                maxCount = count;
                maxVideogioco = v;
            }
        }
        ris += "Il videogioco con il maggior numero di lettere in comune con \n" + parola1 + " e': \n" + maxVideogioco.toString() + "\nCon " + maxCount + " lettere in comune.\n";

        return ris + "\n" + imigliori;
    }
	
	default String carrellodellaspesa2()
	{
		Scanner tastiera = new Scanner(System.in);
		System.out.println("Inserisci il tuo budget");
		Double budget = Double.parseDouble(tastiera.nextLine());
		String continua = "";

		int id;
		int i = 1;
		String ris = "";
		List<Videogioco> giochi = new ArrayList<>(read());
		List<Videogioco> acquistati = new ArrayList<>();
		List<Videogioco> temp = new ArrayList<>();
		temp = giochi;
		
		do
		{
			if (budget > prezzoMin()) 
			{
				System.out.println("Lista dei giochi disponibili:");
				System.out.println("Il tuo budget rimanente è: " + String.format("%.2f", budget));
				for (Videogioco v : temp) 
				{
					System.out.println(v.getId() + " | " + v.getTitolo() + " | " + v.getPrezzo());
				}
				
				System.out.println("Inserisci l'ID del gioco che vuoi comprare");
				id = Integer.parseInt(tastiera.nextLine());

				Iterator<Videogioco> iterator = temp.iterator();
				while (iterator.hasNext()) 
				{
					Videogioco v = iterator.next();

					if (v.getId() == id) 
					{
						if (v.getPrezzo() < budget) 
						{
							acquistati.add(v);
							System.out.println("Hai acquistato: " + v.getTitolo());
							budget -= v.getPrezzo();
							System.out.println("Budget rimanente: " + String.format("%.2f", budget));
							iterator.remove();
							break;
						}
						else 
						{
							System.out.println("Il tuo budget non ti permette di comprare questo gioco");
							continua = "No";
						}
					}
				}
				System.out.println("Vuoi comprare un'altro gioco?");
				continua = tastiera.nextLine();
				if(continua.equalsIgnoreCase("no"))
				{
					System.out.println("BREAK");
					break;
				}
			} 
			else 
			{
				System.out.println("\nHai finito il budget");
				continua = "No";
			}
		}while(continua != "No");

		System.out.println("Hai acquistato: \n" + ris);
		for(Videogioco v : acquistati)
		{
			ris += v.getTitolo() + " | " + v.getPrezzo() + "\n";
		}
		return ris;
	}
}