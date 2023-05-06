package guesswho;

import java.io.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Menu 
{
    private int jugados;
    private int ganados;

    public Menu() 
    {
        jugados = 0;
        ganados = 0;
    }
    
    public void crearArchivo(String jugador)
    {
    	File registro = new File(jugador + ".csv");
    	FileWriter writer = null;
    	BufferedReader reader = null;
    	if(registro.exists())
    	{
    		System.out.println("");
    		System.out.println("Bienvenido nuevamente");
    		try
    		{
    			reader = new BufferedReader(new FileReader(registro));
                reader.readLine();
                jugador = reader.readLine();
                reader.readLine();
                String[] estadisticas = reader.readLine().split(",");
                jugados = Integer.parseInt(estadisticas[0]);
                ganados = Integer.parseInt(estadisticas[1]);
                reader.close();
    		}
    		catch(IOException e)
    		{
    			e.printStackTrace();
    		}
    	}
    	else
    	{
    		try 
    		{
    			jugados = 0;
    			ganados = 0;
    			registro.createNewFile();
    	        writer = new FileWriter(registro);
    	        writer.write("Jugador\n");
    	        writer.write(jugador + "\n");
    	        writer.write("Juegos jugados, Juegos ganados\n");
    	        writer.write(jugados + "," + ganados +"\n");
    	        writer.close();
    	        System.out.println("");
    	        System.out.println("Bienvenido");
    	    } 
    		catch (IOException e) 
    		{
    	        e.printStackTrace();
    	    }
    	}
    }
    
    public void actualizarEstadisticas(String jugador, int jugados, int ganados) 
    {
        String nombreArchivo = jugador + ".csv";
        List<String> lineas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) 
        {
            String linea;
            while ((linea = br.readLine()) != null) 
            {
                lineas.add(linea);
            }
        }
        catch (IOException e) 
		{
	        e.printStackTrace();
	    }

        String[] valores = lineas.get(3).split(",");
        valores[0] = String.valueOf(jugados);
        valores[1] = String.valueOf(ganados);
        lineas.set(3, String.join(",", valores));

        try (FileWriter writer = new FileWriter(nombreArchivo)) 
        {
            for (String linea : lineas) {
                writer.write(linea + "\n");
            }
        }
        catch (IOException e) 
		{
	        e.printStackTrace();
	    }
    }

    
    public void mostrarMenu() 
    {
    	Scanner lector = new Scanner(System.in);
    	GuessWho juego = new GuessWho();
        System.out.println("Bienvenido al juego Adivina Quién");
        System.out.print("Ingrese el nombre del jugador: ");
        String jugador = lector.nextLine();
        crearArchivo(jugador);
        System.out.println("");
        System.out.println("--- Menú ---");
        System.out.println("");
        System.out.println("A continuación elige lo que desees hacer:");
        System.out.println("1. Jugar");
        System.out.println("2. Ver estadísticas");
        System.out.println("3. Salir");
        System.out.println("");
        System.out.print("Tu elección: ");
        int elección = lector.nextInt();
        
        switch (elección) 
        {
            case 1:
            	jugados++;
            	juego.iniciarJuego();
            	if(juego.ganado())
            	{
            		ganados++;
            	}
            	actualizarEstadisticas(jugador, jugados, ganados);
                break;
            case 2:
            	System.out.println("");
            	System.out.println("Juegos jugados: " + jugados);
            	System.out.println("Juegos ganados: " + ganados);
                break;
            case 3:
                System.out.println("¡Gracias por jugar!");
                System.exit(0);
                break;
            default:
                System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                mostrarMenu();
                break;
        }
        lector.close();
    }
}