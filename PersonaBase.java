package guesswho;

public abstract class PersonaBase 
{
    private String nombre;
    private boolean usaLentes;
    private boolean usaGorra;
    private boolean juegaDeporte;

    public PersonaBase(String nombre, boolean usaLentes, boolean usaGorra, boolean juegaDeporte) 
    {
        this.nombre = nombre;
        this.usaLentes = usaLentes;
        this.usaGorra = usaGorra;
        this.juegaDeporte = juegaDeporte;
    }

    public String getNombre() 
    {
        return nombre;
    }
    
    public boolean lentes() 
    {
        return usaLentes;
    }
    
    public boolean gorra() 
    {
        return usaGorra;
    }
    
    public boolean deporte() 
    {
        return juegaDeporte;
    }
    
    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    public void setUsaLentes(boolean usaLentes) 
    {
    	this.usaLentes = usaLentes;
    }

    public void setUsaGorra(boolean usaGorra) 
    {
    	this.usaGorra = usaGorra;
    }

    public void setDeporte(boolean juegaDeporte) 
    {
    	this.juegaDeporte = juegaDeporte;
    }
}