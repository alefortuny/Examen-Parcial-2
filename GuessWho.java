package guesswho;

import java.util.Random;
import java.util.Scanner;

public class GuessWho 
{
	private boolean ganado = false;
	Random random = new Random();
	Persona[] personajes = new Persona[10];
	Scanner selección = new Scanner(System.in);
	String[] nombres = {"Max", "Christian", "Luis", "Felipe", "Alejandro", "Luna", "Javier", "Andrea", "Ximena", "Perla"};
	String[] nombresFinales = asignarNombre();
	
	public GuessWho() {
	}
	
    public void iniciarJuego()
    {
    	crearPersonajes();
    	mostrarPersonajes();
    	
    	System.out.println("----------------------------------------------------------------------------------------");
    	System.out.println("El sistema está eligiendo un personaje...");
    	System.out.println("Podrás hacer 3 preguntas sobre sus características y tendrás un intento para adivinar...");
    	System.out.println("----------------------------------------------------------------------------------------");
    	System.out.println("");
    	int indicePersonajeElegido = random.nextInt(10);
    	
    	for(int i = 3; i > 0; i--)
    	{
    		System.out.println("Elige una pregunta");
    		System.out.println("");
    		System.out.println("1. ¿El personaje tiene lentes?");
    		System.out.println("2. ¿El personaje usa gorra?");
    		System.out.println("3. ¿El personaje juega un deporte?");
    		System.out.println("4. ¿El personaje tiene estudios?");
    		System.out.println("");
    		System.out.print("Tu elección: ");
    		int preguntaDelUsuario = selección.nextInt();
    		
    		switch(preguntaDelUsuario)
    		{
    		case 1:
    		if(personajes[indicePersonajeElegido].lentes())
    		{
    			System.out.println("");
    			System.out.println("Sí");
    			for(int j = 0; j < personajes.length; j++)
        		{
        			if(personajes[j].lentes() == false)
        			{
        				personajes[j].setNombre(null);
        			}
        		}
        	break;
    		}
    		else
    		{
    			System.out.println("");
    			System.out.println("No");
    			for(int j = 0; j < personajes.length; j++)
        		{
        			if(personajes[j].lentes())
        			{
        				personajes[j].setNombre(null);
        			}
        		}
    			break;
    		}
    		case 2:
    		if(personajes[indicePersonajeElegido].gorra())
    		{
    			System.out.println("");
    			System.out.println("Sí");
    			for(int j = 0; j < personajes.length; j++)
        		{
        			if(personajes[j].gorra() == false)
        			{
        				personajes[j].setNombre(null);
        			}
        		}
        		break;
    		}
    		else
    		{
    			System.out.println("");
    			System.out.println("No");
    			for(int j = 0; j < personajes.length; j++)
        		{
        			if(personajes[j].gorra())
        			{
        				personajes[j].setNombre(null);
        			}
        		}
    			break;
    		}
    		case 3:
    		if(personajes[indicePersonajeElegido].deporte())
    		{
    			System.out.println("");
    			System.out.println("Sí");
    			System.out.println("");
    			for (int j = 0; j < personajes.length; j++) 
        		{
        			if (personajes[j].deporte() == false) 
        			{
        				personajes[j].setNombre(null);
        			}
        		}
    		}
    		else
    		{
    			System.out.println("");
    			System.out.println("No");
    			for (int j = 0; j < personajes.length; j++) 
        		{
        			if (personajes[j].deporte()) 
        			{
        				personajes[j].setNombre(null);
        			}
        		}
        		break;
    		}
    		case 4:
        	if(personajes[indicePersonajeElegido].estudios())
        	{
        		System.out.println("");
        		System.out.println("Sí");
        		for(int j = 0; j < personajes.length; j++)
            	{
            		if(personajes[j].estudios() == false)
            		{
            			personajes[j].setNombre(null);
            		}
            	}
        		break;
        	}
        	else
        	{
        		System.out.println("");
        		System.out.println("No");
        		for(int j = 0; j < personajes.length; j++)
            	{
            		if(personajes[j].estudios())
            		{
            			personajes[j].setNombre(null);
            		}
            	}
        		break;
        	}
    		default:
                System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                i++;
                break;
    		}
    		System.out.println("");
    		System.out.println("Los personajes restantes son:");
    		System.out.println("");
    		for(int k = 0; k < personajes.length; k++)
    		{
    			if(personajes[k].getNombre() != null)
    			{
    				System.out.println(k + ") " + personajes[k].getNombre());
    			}
    		}
    		System.out.println("");
    	}
    	System.out.print("Introduce el número correspondiente a la persona que consideres que ha elegido el sistema: ");
    	int adivinanza = selección.nextInt();
    	System.out.println("");
    	if(adivinanza == indicePersonajeElegido)
    	{
    		System.out.println("El personaje era: " + personajes[indicePersonajeElegido].getNombre());
    		System.out.println("¡Felicidades! Acertaste");
    		ganado = true;
    	}
    	else
    	{
    		System.out.println("El personaje era: " + personajes[indicePersonajeElegido].getNombre());
    		System.out.println("Lo lamento, suerte a la próxima");
    	}
    	selección.close();    
    	}
    
    public String[] asignarNombre()
    {
    	for (int i = nombres.length - 1; i > 0; i--) 
    	{
            int j = random.nextInt(i + 1);
            String reemplazo = nombres[i];
            nombres[i] = nombres[j];
            nombres[j] = reemplazo;
        }
    	return nombres;
    }
    
    public void crearPersonajes()
    {
    	
    	for(int i = 0; i < personajes.length; i++)
    	{
    		boolean usaLentes = random.nextBoolean();
    		boolean usaGorra = random.nextBoolean();
    		boolean juegaDeporte = random.nextBoolean();
    		boolean tieneEstudios = random.nextBoolean();
    		personajes[i]= new Persona(nombres[i], usaLentes, usaGorra, juegaDeporte, tieneEstudios);
    	}
    }
    
    public void mostrarPersonajes()
    {
    	System.out.println("-----------------------------------------------------");
    	System.out.println("");
    	System.out.println("Los personajes a adivinar y sus características son: ");
    	System.out.println("");
    	
    	for(int i = 0; i < personajes.length; i++)
    	{
    	    System.out.print("* " + i + ") " + personajes[i].getNombre() + ": ");
    	    if(personajes[i].lentes())
    	    {
    	    	System.out.print("Tiene lentes, ");
    	    }
    	    else
    	    {
    	    	System.out.print("No tiene lentes, ");
    	    }
    	    if(personajes[i].gorra())
    	    {
    	    	System.out.print("usa gorra, ");
    	    }
    	    else
    	    {
    	    	System.out.print("no usa gorra, ");
    	    }
    	    if(personajes[i].deporte())
    	    {
    	    	System.out.print("juega algún deporte, ");
    	    }
    	    else
    	    {
    	    	System.out.print("no juega ningún deporte, ");
    	    }
    	    if(personajes[i].estudios())
    	    {
    	    	System.out.print("tiene estudios.");
    	    }
    	    else
    	    {
    	    	System.out.print("no tiene estudios.");
    	    }
    	    System.out.println("");
    	    System.out.println(""); 
    	}
    }
    
    public boolean ganado()
    {
    	return ganado;
    }
}