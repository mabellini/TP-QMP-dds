```java
public class Usuario {
    private List<Prenda> prendasGuardadas;

    public method adquirirPrenda(Prenda prendaAdquirida) {
        // agregar una nueva prenda a las prendas del usuario
    }

    public method lavarRopa(Prenda unaPrenda) {
        // lavar una prenda
        unaPrenda.lavar();
    }

}
```

# Decisión de diseño
### Decidimos utilizar el patrón **state** para modelar el estado de la prenda, que irá variando entre:

- Limpia
- Sucia
- Percudida
- No disponible

```java
public class Prenda {
    private Estado estado; 

    public method lavar() {
        this.setEstado(new NoDisponible());
    }

    public method sacarDelLavarropas() {
        this.setEstado(new Limpia());
    }

    private method setEstado(Estado estado) {
        this.estado = estado;
    }
    // A la clase prenda vamos a agregarle un estado
}

public interface Estado {
    public abstract method usar(Prenda unaPrenda);
    public abstract method estaDisponible();
}

public class Limpia implements Estado {
    int cantidadDeUsos

    // implementa el método usar
    method usar(Prenda unaPrenda) {
        // aumentar en 1 el uso
        // si la cantidad de usos es mayor a 2, la prenda pasa a estar sucia
    }

    method estaDisponible() {
        return true;
    }
}

public class Sucia implements Estado {
    int cantidadDeUsos

    // implementa el método usar
    method usar(Prenda unaPrenda) {
        // aumenta en 1 el uso
        // si la cantidad de usos es mayor a 3, la prenda pasa a percudida
    }

    method estaDisponible() {
        return true;
    }
}

public class Percudida implements Estado {
    method usar(Prenda unaPrenda) {
        throw new Exception(message = "No se puede usar una prenda percudida")
    }

    method estaDisponible() {
        return false;
    }
}

public class NoDisponible implements Estado {
    method usar(Prenda unaPrenda) {
        throw new Exception(message = "No se puede usar una prenda mientras se está lavando")
    }

    method estaDisponible() {
        return false;
    }
}
```

# Modelado de Sugerencias
### Decidimos utilizar el patrón **factory** para modelar la Sugerencia, que recibe una lista de prendas, y a partir de ella genera
### un atuendo para el usuario. Ordenando las prendas por su categoría (CALZADO, PARTE_INFERIOR, PARTE_SUPERIOR, ACCESORIOS)

```java
public class Sugerencia { 
    public method hacerSugerencia(List<Prenda> prendas) {
        // sobre la lista de prendas, filtrar las prendas disponibles
        List<Prenda> prendasDisponibles = this.prendasDisponibles(prendas);
        
        // seleccionar prendas de cada categoria
        Prenda calzado = this.seleccionarPrendaDeCategoria(prendasDisponibles, CALZADO);
        Prenda parteInferior = this.seleccionarPrendaDeCategoria(prendasDisponibles, PARTE_INFERIOR);
        Prenda parteSuperior = this.seleccionarPrendaDeCategoria(prendasDisponibles, PARTE_SUPERIOR);
        Prenda accesorio = this.seleccionarPrendaDeCategoria(prendasDisponibles, ACCESORIO);

        // crear el atuendo y devolverlo
        return new Atuendo(calzado, parteInferior, parteSuperior, accesorio);
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
```