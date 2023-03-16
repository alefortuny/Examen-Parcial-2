package guesswho;

public abstract class PersonaBase 
{
    private String nombre;
    private boolean usaLentes;
    private boolean usaGorra;
    private boolean atributo3;

    public PersonaBase(String nombre, boolean usaLentes, boolean usaGorra, boolean atributo3) 
    {
        this.nombre = nombre;
        this.usaLentes = usaLentes;
        this.usaGorra = usaGorra;
        this.atributo3 = atributo3;
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
    
    public boolean tieneAtributo3() 
    {
        return atributo3;
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

    public void setTieneAtributo3(boolean tieneAtributo3) 
    {
    	this.atributo3 = tieneAtributo3;
    }
}