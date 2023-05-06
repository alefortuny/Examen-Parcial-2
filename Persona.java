package guesswho;

public class Persona extends PersonaBase
{
    private boolean tieneEstudios;
    
    public Persona(String nombre, boolean usaLentes, boolean usaGorra, boolean deporte, boolean tieneEstudios) 
    {
        super(nombre, usaLentes, usaGorra, deporte);
        this.tieneEstudios = tieneEstudios;
    }
    
    public String nombre()
    {
    	return super.getNombre();
    }
    
    public boolean lentes() 
    {
        return super.lentes();
    }
    
    public boolean gorra() 
    {
        return super.gorra();
    }
    
    public boolean deporte()
    {
        return super.deporte();
    }
    
    public boolean estudios()
    {
    	return tieneEstudios;
    }
    
    public void setNombre(String nombre) 
    {
        super.setNombre(nombre);
    }

    public void setUsaLentes(boolean usaLentes) 
    {
        super.setUsaLentes(usaLentes);
    }

    public void setUsaGorra(boolean usaGorra) 
    {
        super.setUsaGorra(usaGorra);
    }

    public void setJuegaDeporte(boolean juegaDeporte) 
    {
        super.setDeporte(juegaDeporte);
    }

    public void setTieneEstudios(boolean tieneEstudios) 
    {
        if(lentes() == gorra() && gorra() == deporte())
        {
        	this.tieneEstudios = !lentes();
        }
        else
        {
        	this.tieneEstudios = tieneEstudios;
        }
    }
}