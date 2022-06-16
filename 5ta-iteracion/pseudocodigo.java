public class Usuario {

    List<Guardarropa> guardarropas;
    List<Sugerencia> sugerencias;

    public void usarSugerencia(Sugerencia sugerencia){
        Sugerencia.aplicarSugerencia();
        sugerencias.remove(sugerencia);

    }

    public void borrarSugerencia(Sugerencia sugerencia){
        sugerencias.remove(sugerencia)
    }

    public void verSugerencias(){
        return sugerencias;
    }

}


public class Prenda {

}


public class Guardarropa{

    List<Prenda> = prendas


    public void sumarPrenda(Prenda prenda){
        prendas.add(prenda);
    }

    public void quitarPrenda(prenda){
        prendas.remove(prenda);
    }
}


public class Sugerencia {
    Guardarropas guardarropas;
    Prenda prenda;
    Estado estado = Estado.ESPERA;

    public void aplicarSugerencia();
    public void rechazarSugerencia(){
        this.Estado = Estado.RECHAZADO;
    }

    public void deshacerSurencia(){
        this.Estado = Estado.ESPERA;
    }
}


abstract class AgregarPrenda implements Sugerencia {
    public AgregarPrenda(Guardarropas guardarropas, Prenda prenda){
        this.guardarropas = guardarropas;
        this.prenda = prenda;
    }
    public Sugerecia(Guardarropas guardarropas, Prenda prenda);
    public void aplicarSugerencia(){
        guardarropas.sumerPrenda(prenda);
        this.Estado = Estado.ACEPTADO;
    }
    public void deshacerSugerencia(){
        super();
        guardarropas.quitarPrenda(prenda);

    }
}

public class QuitarPrenda implements Sugerencia{
    public QuitarPrenda(Guardarropas guardarropas, Prenda prenda){
        this.guardarropas = guardarropas;
        this.prenda = prenda;
    }
    public void aplicarSugerencia(){
        guardarropas.quitarPrenda(prenda);
        this.Estado = Estado.ACEPTADO;
    }

    public void deshacerSugerencia(){
        super();
        guardarropas.sumerPrenda(prenda);
    }
}


public enum Estado {
    ACEPTADO,
    RECHAZADO,
    ESPERA
}