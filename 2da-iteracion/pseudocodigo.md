## Prendas

```java
class Prenda {
  TipoDePrenda tipoDePrenda;
  Material material;
  Color color;
  Color colorSecundario;

  constructor(TipoDePrenda tipoDePrenda, Material material, Color color) {
      // Evitar recibir parámetros nulos
      this.tipoDePrenda = requireNonNull(tipoDePrenda, "El campo tipoDePrenda es obligatorio");
      this.material = requireNonNull(material, "El campo material es obligatorio");
      this.color = requireNonNull(color, "El campo color es obligatorio");
  }

  method setColorSecundario(Color unColor) {
    this.colorSecundario = color
  }
}
```
#

## Material de una prenda

```java
public enum Material {
    //...
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