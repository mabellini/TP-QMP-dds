# TP - Que me pongo - 1ra Iteración

# Prendas

```java
class Prenda {
    String material;
    String colorPrincipal; 
    String colorSecundario;

    method Prenda(material, colorPrincipal) {
		this.material = material;
		this.colorPrincipal = colorPrincipal;
    } 

	// Usamos un setter, ya que el color secundario no es obligatorio
	method setColorSecundario(unColor) {
		this.colorSecundario = unColor
	}
}


class PrendaSuperior extends Prenda {
    TipoPrendaSuperior tipo;
	
	method PrendaSuperior(material, colorPrincipal, tipo) {
		super(material, colorPrincipal);
		this.tipo = tipo;
    }
}

class PrendaInferior extends Prenda {
    TipoPrendaInferior tipo;

	method PrendaInferior(material, colorPrincipal, tipo) {
		super(material, colorPrincipal);
		this.tipo = tipo;
    }
}

class Calzado extends Prenda {
	TipoCalzado tipo;

	method Calzado(material, colorPrincipal, tipo) {
		super(material, colorPrincipal);
		this.tipo = tipo;
    }    
}

class Accesorio extends Prenda {
    TipoAccesorio tipo;

	method Accesorio(material, colorPrincipal, tipo) {
		super(material, colorPrincipal);
		this.tipo = tipo;
    }
}
```

# Tipos de Prendas

```java
enum TipoPrendaSuperior {
	REMERA,
	CAMISA,
	CHOMBA,
	BUZO
}

enum TipoPrendaInferior {
	PANTALON,
	SHORT,
	JOGGING
}

enum TipoCalzado {
	ZAPATO,
	ZAPATILLA,
	BOTAS,
	OJOTAS
}

enum TipoAccesorio {
	COLLAR,
	GORRA,
	GUANTES,
	BARBIJO
}
```

## **Diagrama de Clases**
![imagen-diagrama](/img/tp-qmp.svg)

## **Decisión de Diseño: Prendas, categorías y tipos de prenda**
Tomamos la decisión como grupo de separar a las prendas según su categoría como subclases que heredan `Prenda`. Para así lograr que obligatoriamente, el tipo se condiga con la categoría, haciendo uso de `enum` para cada tipo

## **Alternativa descartada**
Otra alternativa planteada fue tener una única clase `Prenda`, que contenga una categoría de un enum `Categoria` y un tipo de un enum `Tipo`, pero fue descartada debido a que consideramos que podría llegar a complicarse en la implementación para cumplir la condición de que el tipo siempre se condiga con la categoría.
