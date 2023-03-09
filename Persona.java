package guesswho;

public class Persona extends PersonaBase
{
    private boolean atributo4;
    
    public Persona(String nombre, boolean usaLentes, boolean usaGorra, boolean atributo3, boolean atributo4) 
    {
        super(nombre, usaLentes, usaGorra, atributo3);
        this.atributo4 = atributo4;
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
    
    public boolean tieneAtributo4()
    {
    	return atributo4;
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

    public void setAtributo3(boolean atributo3) 
    {
        super.setAtributo3(atributo3);
    }

    public void setAtributo4(boolean atributo4) 
    {
        this.atributo4 = atributo4;
    }
}