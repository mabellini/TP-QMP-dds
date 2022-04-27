## Prendas

```java
class Prenda {
  TipoDePrenda tipoDePrenda;
  Material material;
  Color color;
  Color colorSecundario;

  constructor(TipoDePrenda tipoDePrenda) {
      // Evitar recibir parámetros nulos
      this.tipoDePrenda = requireNonNull(tipoDePrenda, "El campo tipoDePrenda es obligatorio");
  }

  method categoria() {
    return tipoDePrenda.categoria()
  }

  method setMaterial(Material material, Color color) {
    this.material = requireNonNull(material, "El campo material es obligatorio")
    this.color = requireNonNull(color, "El campo color es obligatorio")
  }

  method esPrendaValida() {
    // Devuelve True solo sí los tres elementos principales (tipoDePrenda,
    // material, color) tienen un valor seteado.
  }

  method setColorSecundario(Color unColor) {
    this.colorSecundario = color
  }
}
```
#

## Material de una prenda

```java
class Material {
    TramaDeLaPrenda trama;

    constructor (TramaDeLaPrenda trama) {
        this.trama = trama
    }

    // Si no se envía ningún parámetro, la trama de la tela es LISA
    constructor () {
      this.trama = TramaDeLaPrenda.LISA
    }
}

enum TramaDeLaPrenda {
  LISA, 
  RAYADA, 
  CON_LUNARES, 
  A_CUADROS, 
  ESTAMPADO
}
```

#

## Tipo de Prenda y categoría

```java
class TipoDePrenda {
  Categoria categoria;

  constructor(Categoria categoria) {
    this.categoria = requireNonNull(categoria, "La categoría es obligatoria")
  }

  method categoria() {
    return this.categoria;
  }
}


enum Categoria {
  PARTE_SUPERIOR, 
  CALZADO, 
  PARTE_INFERIOR, 
  ACCESORIOS
}
```

### Para empezar a establecer relaciones entre Tipos y Categorías, podemos instanciar los diferentes tipos dados en el enunciado de la siguiente forma (ejemplos)

```java
constant REMERA = new TipoDePrenda(PARTE_SUPERIOR)
constant PANTALON = new TipoDePrenda(PARTE_INFERIOR)
constant POLLERA = new TipoDePrenda(PARTE_INFERIOR)
constant CAMISA_MANGA_CORTA = new TipoDePrenda(PARTE_SUPERIOR)
constant BLUSA = new TipoDePrenda(PARTE_SUPERIOR)
constant ZAPATO = new TipoDePrenda(CALZADO)
```

#

## Colores

```java
class Color {
  int rojo;
  int verde;
  int azul;

  constructor(int rojo, int verde, int azul) {
      this.rojo = rojo;
      this.verde = verde;
      this.azul = azul;
  }
}
```

## Borrador
Cada usuario tiene la posibilidad de guardar sus prendas, y tener una única prenda en un borrador, para seguir creándola luego.

```java
class Usuario {
  List<Prenda> prendasGuardadas;
  Prenda borrador;

  method guardarUnaPrenda(Prenda unaPrenda) {
    // agregar unaPrenda a la lista de prendas guardadas
    if unaPrenda.esValida() {
      // Guardar prenda (agregar a la lista)
    }
    else {
      // Arrojar excepción indicando que la prenda no pudo guardarse
      
    }
  }

  method guardarEnBorrador(Prenda unaPrenda) {
    this.borrador = unaPrenda
  }

  method terminarBorrador() {
    this.guardarUnaPrenda(this.borrador)
    this.borrador = null
  }

}
```

# Uniformes: Tienen una prenda superior, una prenda inferior y un calzado

```java
class Uniforme {
  Prenda parteSuperior
  Prenda parteInferior
  Prenda calzado

  constructor (Prenda parteSuperior, Prenda parteInferior, Prenda calzado) {
    if verificarQueTodasLasPrendasCoincidan(parteSuperior, parteInferior, calzado){
      this.parteSuperior = parteSuperior
      this.parteInferior = parteInferior
      this.calzado = calzado
    }
    else {
      // Arrojar una excepción indicando que las prendas no corresponden con las categorias
    }
  }

  method verificarQueCondice(Prenda unaPrenda, Categoria unaCategoria) {
    return unaPrenda.categoria().equals(unaCategoria)
  }

  method verificarQueTodasLasPrendasCoincidan(Prenda parteSuperior, Prenda parteInferior, Prenda calzado) {
    return verificarQueCondice(parteSuperior, PARTE_SUPERIOR) && verificarQueCondice(parteInferior, PARTE_INFERIOR) && verificarQueCondice(calzado, CALZADO)
  }
```

## Configurar uniformes para distintas instituciones

```java
class Institucion {
  Uniforme uniforme;

  method setUniforme(Uniforme uniforme) {
    this.uniforme = uniforme
  }
}
```

```java
constant sanJuan = new Institucion()
sanJuan.setUniforme(new Uniforme(chombaVerde ...))

constant johnson = new Institucion()
sanJuan.setUniforme(new Uniforme(camisaBlanca...))
```

## Duda: Sugerencia de Uniformes
Cómo podemos retornar una sugerencia de uniforme? Quién es el encargado de realizar la sugerencia y cómo conoce a todos los uniformes a partir de los cuales tiene que generar dicha sugerencia.