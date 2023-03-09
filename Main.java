package guesswho;

import java.util.Random;
import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) 
    {
    	Persona[] personajes = new Persona[10];
    	String[] nombres = {"Max", "Christian", "Luis", "Felipe", "Alejandro", "Luna", "Javier", "Andrea", "Ximena", "Perla"};
    	String[] atributoVariable = {"juega volleyball", "juega basketball", "juega fútbol", "juega tenis", "juega baseball", "juega pádel", "juega ajedrez", "juega fútbol americano", "juega golf", "juega hockey"};
    	Random random = new Random();
    	
    	for (int i = nombres.length - 1; i > 0; i--) 
    	{
            int j = random.nextInt(i + 1);
            String reemplazo = nombres[i];
            nombres[i] = nombres[j];
            nombres[j] = reemplazo;
        }
    	
    	for (int i = atributoVariable.length - 1; i > 0; i--) 
    	{
            int j = random.nextInt(i + 1);
            String reemplaza = atributoVariable[i];
            atributoVariable[i] = atributoVariable[j];
            atributoVariable[j] = reemplaza;
        }
    	
    	for(int i = 0; i < personajes.length; i++)
    	{
    		boolean usaLentes = random.nextBoolean();
    		boolean usaGorra = random.nextBoolean();
    		boolean atributo3 = random.nextBoolean();
    		boolean atributo4 = random.nextBoolean();
    		personajes[i]= new Persona(nombres[i], usaLentes, usaGorra, atributo3, atributo4);
    	}
    		
    	System.out.println("---------- Adivina quién ---------");
    	System.out.println("");
    	System.out.println("Los personajes a adivinar y sus características son: ");
    	System.out.println("");
    	
    	for(int i = 0; i < personajes.length; i++)
    	{
    	    System.out.print("* " + personajes[i].getNombre() + ": ");
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
    	    if(personajes[i].tieneAtributo3())
    	    {
    	    	System.out.print(atributoVariable[i]);
    	    }
    	    System.out.println("");
    	    System.out.println("");
    	    
    	}
    	System.out.println("----------------------------------------------------------------------------------------");
    	System.out.println("El sistema está eligiendo un personaje...");
    	System.out.println("Podrás hacer 3 preguntas sobre sus características y tendrás un intento para adivinar...");
    	System.out.println("----------------------------------------------------------------------------------------");
    	System.out.println("");
    	
    	Scanner selección = new Scanner(System.in);
    	int indicePersonajeElegido = random.nextInt(10);
    	
    	for(int i = 3; i > 0; i--)
    	{
    		System.out.println("Elige una pregunta");
    		System.out.println("");
    		System.out.println("1. ¿El personaje tiene lentes?");
    		System.out.println("2. ¿El personaje usa gorra?");
    		System.out.println("3. ¿El personaje juega un deporte?");
    		System.out.println("");
    		
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
    		if(personajes[indicePersonajeElegido].tieneAtributo3())
    		{
    			System.out.println("");
    			System.out.println("Sí");
    			System.out.println("");
    			System.out.println("Selecciona un deporte:");
    			System.out.println("");
        		for (int j = 0; j < atributoVariable.length; j++) 
        		{
        			System.out.println((j + 1) + ". " + atributoVariable[j]);
        		}
        		int deporteSeleccionado = selección.nextInt() - 1;
        		String deporte = atributoVariable[deporteSeleccionado];
        		for (int j = 0; j < personajes.length; j++) 
        		{
        			if (!personajes[j].tieneAtributo3() || !deporte.equals(atributoVariable[j])) 
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
    		}
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
    	
    	System.out.println("");
    	System.out.println("Introduce el número correspondiente a la persona que consideres que ha elegido el sistema: ");
    	System.out.println("");
    	int adivinanza = selección.nextInt();
    	System.out.println("");
    	if(adivinanza == indicePersonajeElegido)
    	{
    		System.out.println("El personaje era: " + personajes[indicePersonajeElegido].getNombre());
    		System.out.println("¡Felicidades! Acertaste");
    	}
    	else
    	{
    		System.out.println("El personaje era: " + personajes[indicePersonajeElegido].getNombre());
    		System.out.println("Lo lamento, suerte a la próxima");
    	}
    	selección.close();
    }
}