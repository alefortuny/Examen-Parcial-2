package guesswho;

public class Persona extends PersonaBase
{
    private boolean tieneEstudios;
    
    public Persona(String nombre, boolean usaLentes, boolean usaGorra, boolean atributo3, boolean tieneEstudios) 
    {
        super(nombre, usaLentes, usaGorra, atributo3);
        this.tieneEstudios = tieneEstudios;
    }
    
    public boolean lentes() 
    {
        return super.lentes();
    }
    
    public boolean gorra() 
    {
        return super.gorra();
    }
    
    public boolean tieneAtributo3() 
    {
        return super.tieneAtributo3();
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

    public void setTieneAtributo3(boolean atributo3) 
    {
        super.setTieneAtributo3(atributo3);
    }

    public void setTieneEstudios(boolean tieneEstudios) 
    {
        if(lentes() == gorra() && gorra() == tieneAtributo3())
        {
        	this.tieneEstudios = !lentes();
        }
        else
        {
        	this.tieneEstudios = tieneEstudios;
        }
    }
}