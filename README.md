## Nombres
Matias Contreras Gajardo
Bastian Zuñiga Montecino
Sebastian Herrera Correa


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

### Figuras `/api/v1/figuras`
| Metodo | Ruta | Descripción |
|--------|------|-------------|
| GET | `/` | Listar todas |
| GET | `/{id}` | Buscar por ID |
| GET | `/categoria/{id}` | Buscar por categoría |
| POST | `/` | Crear — `{ nombre, precio, stock, descripcion, categoria: {idCategoria} }` |
| PUT | `/actualizar/{id}` | Actualizar |
| DELETE | `/{id}` | Eliminar |

### Categorias `/api/v1/categorias`
| Metodo | Ruta | Body |
|--------|------|------|
| GET | `/` | — |
| POST | `/` | `{ nombreCategoria }` |
| PUT | `/{id}` | `{ nombreCategoria }` |
| DELETE | `/{id}` | — |

### Clientes `/api/clientes`
| Metodo | Ruta | Body |
|--------|------|------|
| GET | `/` | — |
| POST | `/` | `{ nombre, email, telefono, direccion }` |
| PUT | `/{id}` | `{ nombre, email, telefono, direccion }` |
| DELETE | `/{id}` | — |

### Ventas `/api/ventas`
| Metodo | Ruta | Body |
|--------|------|------|
| GET | `/` | — |
| GET | `/{id}` | — |
| POST | `/` | `{ cliente: {id}, figuras: [{idFigura}], tipoPago: {idTipoPago}, tipoEnvio, total }` |
| PUT | `/{id}` | igual al POST |
| DELETE | `/{id}` | — |

### Personajes `/api/personajes`
| Metodo | Ruta | Body |
|--------|------|------|
| GET | `/` | — |
| GET | `/buscar/{nombre}` | — |
| POST | `/` | `{ nombre, franquicia }` |
| PUT | `/{id}` | `{ nombre, franquicia }` |
| DELETE | `/{id}` | — |

### Tipos de Pago `/api/v1/tipopago`
| Metodo | Ruta | Body |
|--------|------|------|
| GET | `/` · `/{id}` | — |
| POST | `/` | `{ nombreTipoPago }` |
| PUT | `/{id}` | `{ nombreTipoPago }` |
| DELETE | `/{id}` | — |

### Tipos de Envio `/api/v1/tipoenvio`
| Metodo | Ruta | Body |
|--------|------|------|
| GET | `/` · `/{id}` | — |
| POST | `/` | `{ nombreEnvio, costoEnvio, activoEnvio }` |
| PUT | `/{id}` | `{ nombreEnvio, costoEnvio, activoEnvio }` |
| DELETE | `/{id}` | — |

### Regiones `/api/v1/region`
| Metodo | Ruta | Body |
|--------|------|------|
| GET | `/` · `/{id}` | — |
| POST | `/` | `{ nombreRegion, activo }` |
| PUT | `/{id}` | `{ nombreRegion, activo }` |
| DELETE | `/{id}` | — |

### Regiones `/api/v1/comuna`
| Metodo | Ruta | Body |
|--------|------|------|
| GET | `/` · `/{id}` | — |
| POST | `/` | `{ nombreRegion, activo }` |
| PUT | `/{id}` | `{ nombreRegion, activo }` |
| DELETE | `/{id}` | — |

## requisitos
-Java 21+
-MySQL 8+
-Maven 3.8

## Ejecutar

http://localhost:8080



