```java
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

public class Usuario {
    private interfazAPI api;

    api.obtenerTemperaturaActual()

}



public Interface AccuWeatherAPI {
    funcion temperatura(ciudad, dia, hora)
}





public class interfazAPI {
    private AccuWeatherAPI api;
    private Float temp = 0;
    private List<Map<String, Object>> condicionesClimaticas;
    private LocalDateTime ultimaSolicitud;
    
    Duration duration; 
    long diff;


    public static method obtenerTemperaturaActual(){
        if(LocalDateTime.now() - 12:00 > ultimaSolicitud)  { //checkeo si tengo la informacion de esta hora guardada
            condicionesClimaticas = api.getWeather(CABA);   // si no esta, actualizo la lista
            ultimaSolicitud = condicionesClimaticas.get(0).get("DateTime"); //tiempo en  el que realice la ultima consulta
            temp = condicionesClimaticas.get(0).get("Temperature").get("value");
        }
        else{
            duration = Duration.between(ultimaSolicitud, LocalDateTime.now()); //calculo a que hora pertenece (dentro de mi lista)
            diff = Math.trunc(duration.toHours()) - 1;
            temp = condicionesClimaticas.get(diff).get("Temperature").get("value"); // temperatura actual
        }
        this.FarenheitACelsius(temp);
        return temp;    
    }
    




    private FarenheitACelsius(Float temp){
        return (temp - 32)/1.8;
    }
}




public class Prenda {
    private Estado estado; 
    private temperaturaMaxima;

    private method setEstado(Estado estado) {
        this.estado = estado;
    }

    public method getEstado(){
        return estado;
    }

    public method getTempMax(){
        return temperaturaMaxima;
    }


    // A la clase prenda vamos a agregarle un estado
}


public class Sugerencia { 

    private interfazAPI api;

   
    public method hacerSugerencia(List<Prenda> prendas) {
        // sobre la lista de prendas, filtrar las prendas disponibles
        List<Prenda> prendasSeleccionables = this.prendasSeleccionalebles(prendas);
        
        // seleccionar prendas de cada categoria
        Prenda calzado = this.seleccionarPrendaDeCategoria(prendasDisponibles, CALZADO);
        Prenda parteInferior = this.seleccionarPrendaDeCategoria(prendasDisponibles, PARTE_INFERIOR);
        Prenda parteSuperior = this.seleccionarPrendaDeCategoria(prendasDisponibles, PARTE_SUPERIOR);
        Prenda accesorio = this.seleccionarPrendaDeCategoria(prendasDisponibles, ACCESORIO);

        // crear el atuendo y devolverlo
        return new Atuendo(calzado, parteInferior, parteSuperior, accesorio);
    }


    public method prendaSeleccionables (List<Prenda> prendas) {
        // debe estar disponible y estar en el rango valido de temperatura
    }


    public method prendaCorrespondienteALaTemperatura (List<Prenda> prendas) {
        List<Prenda> lista = prendas.stream().filter(p -> p.getTempMax() >  api.obtenerTemperaturaActual()).collect(Collectors.toList());
        // filtrar prendas que tengan una temperatura maxima menor a la actual
    }


    public method prendasDisponibles(List<Prenda> prendas) {
        // filtrar de una lista de prendas retornando únicamente las prendas disponibles según su estado
    }

    public method seleccionarPrendaDeCategoria(List<Prenda> prendas, Categoria categoria) {
        // retornar una prenda de la lista que coincida con la categoría
    } 
}

public class Atuendo {
    Prenda calzado;
    Prenda prendaInferior;
    Prenda prendaSuperior;
    Prenda accesorio;

    method constructor(Prenda calzado, Prenda parteInferior, Prenda parteSuperior, Prenda accesorio) {
        this.calzado = calzado;
        this.parteInferior = parteInferior;
        this.parteSuperior = parteSuperior;
        this.accesorio = accesorio;
    }
}



public final class AccuWeatherAPI {

    public final List<Map<String, Object>> getWeather(String ciudad) {
		return Arrays.asList(new HashMap<String, Object>(){{
			put("DateTime", "2019-05-03T01:00:00-03:00");
			put("EpochDateTime", 1556856000);
			put("WeatherIcon", 33);
			put("IconPhrase", "Clear");
			put("IsDaylight", false);
			put("PrecipitationProbability", 0);
			put("MobileLink", "http://m.accuweather.com/en/ar/villa-vil/7984/");
			put("Link", "http://www.accuweather.com/en/ar/villa-vil/7984");
			put("Temperature", new HashMap<String, Object>(){{
				put("Value", 57);
				put("Unit", "F");
				put("UnitType", 18);
			}});
		}});
	}
}
```