REST API para gestion de una tienda de figuras de coleccion. Permite administrar productos, categorias, clientes, ventas, metodos de pago y envios.

## Sack
-Java 21
-Spring Boot 4.0.6
-Spring Data JPA** + **MySQL
-Lombok
-Bean Validation
-Maven


## entidades principales
| Entidad     | Descripción                              |
|-------------|------------------------------------------|
| Figuras   | Productos (nombre, precio, stock, categoria) |
| Categoria | Categoria de figuras                     |
| Personaje | Personaje asociado a una figura          |
| Cliente   | Cliente con nombre, email, teléfono      |
| Ventas    | venta de clientes, figura y pago         |
| TipoPago  | Metodos de pago disponibles              |
| TipoEnvio | Tipos de envío disponibles               |
| Region    | Regiones de despacho                     |

## endpoints

path: /api/v1

| Recurso      | Ruta                            |
|--------------|---------------------------------|
| Figuras      | /api/v1/figuras                 |
| Categorías   | /api/v1/categorias              |
| Personajes   | /api/v1/personajes              |
| Clientes     | /api/v1/clientes                |
| Ventas       | /api/v1/ventas                  |
| Tipos de pago| /api/v1/tipopago                |
| Tipos envío  | /api/v1/tipoenvio               |
| Regiones     | /api/v1/regiones                |

Cada recurso sporta operacuiones CRUD estandar.

## requisitos
-Java 21+
-MySQL 8+
-Maven 3.8

## Ejecutar

http://localhost:8080


