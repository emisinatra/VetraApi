# Vetra API - Documentación

Bienvenido a la documentación oficial de la API de Vetra, una tienda online. Esta API permite gestionar los recursos principales de la aplicación, como usuarios, productos, pedidos y más.

## Índice

1.  [📌 Descripción General del Proyecto](#-descripción-general-del-proyecto)
2.  [🛠️ Tecnologías Utilizadas](#️-tecnologías-utilizadas)
3.  [🗂️ Estructura del Proyecto](#️-estructura-del-proyecto)
4.  [🌐 Documentación de Endpoints](#-documentación-de-endpoints)
    *   [Usuarios (`/api/usuarios`)](#usuarios-apiusuarios)
    *   [Direcciones (`/api/direcciones`)](#direcciones-apidirecciones)
    *   [Categorías (`/api/categorias`)](#categorías-apicategorias)
    *   [Productos (`/api/productos`)](#productos-apiproductos)
    *   [Talles (`/api/talles`)](#talles-apitalles)
    *   [Descuentos (`/api/descuentos`)](#descuentos-apidescuentos)
    *   [Pedidos (`/api/pedidos`)](#pedidos-apipedidos)
    *   [Órdenes de Compra (`/api/ordenes-compra`)](#órdenes-de-compra-apiordenes-compra)
5.  [🔐 Autenticación y Autorización](#-autenticación-y-autorización)
6.  [✅ Cómo Testear un Endpoint](#-cómo-testear-un-endpoint)
7.  [🚀 Instrucciones para Levantar el Proyecto Localmente](#-instrucciones-para-levantar-el-proyecto-localmente)

---

## 📌 Descripción General del Proyecto

Vetra API es el backend para una aplicación de e-commerce. Proporciona endpoints RESTful para administrar entidades clave como usuarios, sus direcciones, catálogo de productos (incluyendo categorías, talles, descuentos), gestión de pedidos y órdenes de compra. El objetivo es ofrecer una API robusta, escalable y fácil de integrar para diversas plataformas cliente (web, móvil).

---

## 🛠️ Tecnologías Utilizadas

*   **Lenguaje**: Java 17
*   **Framework**: Spring Boot 3.4.4
    *   Spring Web (REST Controllers)
    *   Spring Data JPA (Persistencia)
*   **Base de Datos**: H2 Database (para desarrollo y pruebas, configurable para otras como PostgreSQL, MySQL)
*   **ORM**: Hibernate (a través de Spring Data JPA)
*   **Librerías**:
    *   Lombok (para reducir código boilerplate en entidades y otros DTOs)
*   **Build Tool**: Gradle
*   **Servidor Embebido**: Tomcat (default en Spring Boot)

---

## 🗂️ Estructura del Proyecto

La estructura del proyecto sigue las convenciones de Spring Boot y promueve una clara separación de responsabilidades:

*   `src/main/java/com/example/vetra`
    *   `VetraApplication.java`: Punto de entrada de la aplicación Spring Boot.
    *   `entities/`: Contiene las clases de entidad JPA que representan las tablas de la base de datos (Ej: `Usuario.java`, `Producto.java`).
    *   `repositories/`: Interfaces de Spring Data JPA para el acceso a datos (Ej: `UsuarioRepository.java`, `ProductoRepository.java`).
    *   `services/`:
        *   `Interface/`: Interfaces que definen los contratos para la lógica de negocio (Ej: `UsuarioService.java`).
        *   `Impl/`: Implementaciones concretas de los servicios (Ej: `UsuarioServiceImpl.java`).
    *   `controllers/`: Controladores REST que manejan las solicitudes HTTP y exponen los endpoints de la API (Ej: `UsuarioController.java`).
    *   `enums/`: (Si aplica) Enumeraciones utilizadas en la aplicación (Ej: `Rol.java`, `Estado.java`).
*   `src/main/resources/`
    *   `application.properties` o `application.yml`: Configuración de la aplicación (base de datos, servidor, etc.).
    *   `static/`: Recursos estáticos (CSS, JS, imágenes) si se sirve contenido web.
    *   `templates/`: Plantillas de vista (Thymeleaf, FreeMarker) si se usa renderizado del lado del servidor.
*   `build.gradle`: Archivo de configuración de Gradle para dependencias y build del proyecto.

---

## 🌐 Documentación de Endpoints

A continuación, se detallan los endpoints disponibles para cada entidad principal.

### Usuarios (`/api/usuarios`)

Gestiona los usuarios de la aplicación.

*   **`GET /api/usuarios`**
    *   Descripción: Obtiene una lista de todos los usuarios.
    *   Response: `200 OK`
        ```json
        [
            {
                "id": 1,
                "nombre": "Juan Perez",
                "email": "juan.perez@example.com",
                "rol": "USUARIO",
                "direcciones": [
                    {"id": 1, "calle": "Calle Falsa 123", "codpost": 12345}
                ]
            },
            {
                "id": 2,
                "nombre": "Ana Gomez",
                "email": "ana.gomez@example.com",
                "rol": "ADMIN",
                "direcciones": []
            }
        ]
        ```
*   **`GET /api/usuarios/{id}`**
    *   Descripción: Obtiene un usuario específico por su ID.
    *   Parámetros de Path: `id` (Long) - ID del usuario.
    *   Response: `200 OK`
        ```json
        {
            "id": 1,
            "nombre": "Juan Perez",
            "email": "juan.perez@example.com",
            "rol": "USUARIO",
            "direcciones": [
                 {"id": 1, "calle": "Calle Falsa 123", "codpost": 12345}
            ]
        }
        ```
    *   Response: `404 Not Found` si el usuario no existe.
*   **`POST /api/usuarios`**
    *   Descripción: Crea un nuevo usuario.
    *   Request Body:
        ```json
        {
            "nombre": "Carlos Ruiz",
            "email": "carlos.ruiz@example.com",
            "contraseña": "password123",
            "rol": "USUARIO"
        }
        ```
    *   Response: `201 Created`
        ```json
        {
            "id": 3,
            "nombre": "Carlos Ruiz",
            "email": "carlos.ruiz@example.com",
            "rol": "USUARIO",
            "direcciones": []
        }
        ```
    *   Response: `400 Bad Request` si los datos son inválidos.
*   **`PUT /api/usuarios/{id}`**
    *   Descripción: Actualiza un usuario existente.
    *   Parámetros de Path: `id` (Long) - ID del usuario.
    *   Request Body:
        ```json
        {
            "nombre": "Carlos Alberto Ruiz",
            "email": "carlos.ruiz.updated@example.com",
            "rol": "USUARIO"
        }
        ```
    *   Response: `200 OK`
        ```json
        {
            "id": 3,
            "nombre": "Carlos Alberto Ruiz",
            "email": "carlos.ruiz.updated@example.com",
            "rol": "USUARIO",
            "direcciones": []
        }
        ```
    *   Response: `404 Not Found` si el usuario no existe.
    *   Response: `400 Bad Request` si los datos son inválidos.
*   **`DELETE /api/usuarios/{id}`**
    *   Descripción: Elimina un usuario.
    *   Parámetros de Path: `id` (Long) - ID del usuario.
    *   Response: `204 No Content`.
    *   Response: `404 Not Found` si el usuario no existe.
*   **Notas sobre relaciones**:
    *   Un `Usuario` puede tener múltiples `Direcciones`. Al crear/actualizar un usuario, la lista de direcciones se gestiona por separado a través de los endpoints de `Direccion` o mediante operaciones específicas si se implementan (ej. `/api/usuarios/{usuarioId}/direcciones/{direccionId}`).

### Direcciones (`/api/direcciones`)

Gestiona las direcciones, que pueden estar asociadas a múltiples usuarios.

*   **`GET /api/direcciones`**
    *   Descripción: Obtiene una lista de todas las direcciones.
    *   Response: `200 OK`
        ```json
        [
            {"id": 1, "calle": "Calle Falsa 123", "codpost": 12345},
            {"id": 2, "calle": "Avenida Siempreviva 742", "codpost": 67890}
        ]
        ```
*   **`GET /api/direcciones/{id}`**
    *   Descripción: Obtiene una dirección específica por su ID.
    *   Response: `200 OK`
        ```json
        {"id": 1, "calle": "Calle Falsa 123", "codpost": 12345}
        ```
    *   Response: `404 Not Found`.
*   **`POST /api/direcciones`**
    *   Descripción: Crea una nueva dirección.
    *   Request Body:
        ```json
        {"calle": "Otra Calle 456", "codpost": 11223}
        ```
    *   Response: `201 Created`
        ```json
        {"id": 3, "calle": "Otra Calle 456", "codpost": 11223}
        ```
    *   Response: `400 Bad Request`.
*   **`PUT /api/direcciones/{id}`**
    *   Descripción: Actualiza una dirección existente.
    *   Request Body:
        ```json
        {"calle": "Otra Calle Principal 456", "codpost": 11224}
        ```
    *   Response: `200 OK`
        ```json
        {"id": 3, "calle": "Otra Calle Principal 456", "codpost": 11224}
        ```
    *   Response: `404 Not Found`.
    *   Response: `400 Bad Request`.
*   **`DELETE /api/direcciones/{id}`**
    *   Descripción: Elimina una dirección.
    *   Response: `204 No Content`.
    *   Response: `404 Not Found`.
*   **Notas sobre relaciones**:
    *   Una `Direccion` puede estar asociada a múltiples `Usuarios`. Esta relación se gestiona añadiendo una `Direccion` existente a la lista de `direcciones` de un `Usuario` o viceversa, dependiendo de cómo se diseñen los DTOs y la lógica de servicio para estas operaciones. La tabla de unión `usuarios_direcciones` es manejada por JPA.

### Categorías (`/api/categorias`)

Gestiona las categorías de productos.

*   **`GET /api/categorias`**
    *   Descripción: Obtiene todas las categorías.
    *   Response: `200 OK`
        ```json
        [
            {"id": 1, "nombre": "ZAPATILLAS"},
            {"id": 2, "nombre": "CAMPERAS"}
        ]
        ```
*   **`GET /api/categorias/{id}`**
    *   Descripción: Obtiene una categoría por ID.
    *   Response: `200 OK`
        ```json
        {"id": 1, "nombre": "ZAPATILLAS"}
        ```
    *   Response: `404 Not Found`.
*   **`POST /api/categorias`**
    *   Descripción: Crea una nueva categoría.
    *   Request Body:
        ```json
        {"nombre": "REMERAS"}
        ```
    *   Response: `201 Created`
        ```json
        {"id": 3, "nombre": "REMERAS"}
        ```
    *   Response: `400 Bad Request` (ej. si el nombre ya existe y es único).
*   **`PUT /api/categorias/{id}`**
    *   Descripción: Actualiza una categoría.
    *   Request Body:
        ```json
        {"nombre": "REMERAS OVERSIZE"}
        ```
    *   Response: `200 OK`
        ```json
        {"id": 3, "nombre": "REMERAS OVERSIZE"}
        ```
    *   Response: `404 Not Found`.
    *   Response: `400 Bad Request`.
*   **`DELETE /api/categorias/{id}`**
    *   Descripción: Elimina una categoría.
    *   Response: `204 No Content`.
    *   Response: `404 Not Found`.
*   **Notas sobre relaciones**:
    *   Los `Productos` tienen una relación `@ManyToMany` con `Categorias`.

### Productos (`/api/productos`)

Gestiona el catálogo de productos.

*   **`GET /api/productos`**
    *   Descripción: Obtiene una lista de todos los productos.
    *   Response: `200 OK`
        ```json
        [
            {
                "id": 1,
                "nombre": "Zapatilla Urbana Modelo X",
                "descripcion": "Zapatilla cómoda para el día a día.",
                "precio": 150.00,
                "stock": 100,
                "color": "Negro",
                "marca": "VetraSport",
                "imagen": "url_imagen_zapatilla.jpg",
                "categorias": [{"id": 1, "nombre": "ZAPATILLAS"}, {"id": 3, "nombre": "URBANAS"}],
                "talles": [{"id": 1, "talle": "40"}, {"id": 2, "talle": "41"}],
                "descuento": {"id": 1, "descuento": 10.0, "fechaInicio": "2024-01-01T00:00:00", "fechaCierre": "2024-12-31T23:59:59"}
            }
        ]
        ```
*   **`GET /api/productos/{id}`**
    *   Descripción: Obtiene un producto específico por su ID.
    *   Response: `200 OK` (similar al objeto en la lista anterior).
    *   Response: `404 Not Found`.
*   **`POST /api/productos`**
    *   Descripción: Crea un nuevo producto.
    *   Request Body:
        ```json
        {
            "nombre": "Campera Deportiva Viento",
            "descripcion": "Campera liviana rompevientos.",
            "precio": 89.99,
            "stock": 50,
            "color": "Azul",
            "marca": "VetraSport",
            "imagen": "url_imagen_campera.jpg",
            "categoriaIds": [2], // IDs de Categorias existentes
            "talleIds": [3, 4],   // IDs de Talles existentes
            "descuentoId": null // O ID de un Descuento existente
        }
        ```
    *   Response: `201 Created` (con el producto creado, incluyendo sus relaciones).
    *   Response: `400 Bad Request`.
*   **`PUT /api/productos/{id}`**
    *   Descripción: Actualiza un producto existente.
    *   Request Body: (similar al POST, campos a actualizar).
    *   Response: `200 OK`.
    *   Response: `404 Not Found`.
    *   Response: `400 Bad Request`.
*   **`DELETE /api/productos/{id}`**
    *   Descripción: Elimina un producto.
    *   Response: `204 No Content`.
    *   Response: `404 Not Found`.
*   **Notas sobre relaciones**:
    *   Un `Producto` tiene relación `@ManyToMany` con `Categoria` y `Talle`.
    *   Un `Producto` tiene relación `@ManyToOne` con `Descuento`.
    *   Al crear/actualizar un producto, se pueden enviar los IDs de las categorías, talles y descuento asociados. El servicio se encarga de gestionar estas relaciones.

### Talles (`/api/talles`)

Gestiona los talles disponibles para los productos.

*   **`GET /api/talles`**
    *   Descripción: Obtiene todos los talles.
    *   Response: `200 OK`
        ```json
        [
            {"id": 1, "talle": "S"},
            {"id": 2, "talle": "M"},
            {"id": 3, "talle": "L"}
        ]
        ```
*   **`GET /api/talles/{id}`**
    *   Descripción: Obtiene un talle por ID.
    *   Response: `200 OK`.
    *   Response: `404 Not Found`.
*   **`POST /api/talles`**
    *   Descripción: Crea un nuevo talle.
    *   Request Body:
        ```json
        {"talle": "XL"}
        ```
    *   Response: `201 Created`.
    *   Response: `400 Bad Request`.
*   **`PUT /api/talles/{id}`**
    *   Descripción: Actualiza un talle.
    *   Response: `200 OK`.
    *   Response: `404 Not Found`.
*   **`DELETE /api/talles/{id}`**
    *   Descripción: Elimina un talle.
    *   Response: `204 No Content`.
    *   Response: `404 Not Found`.
*   **Notas sobre relaciones**:
    *   Los `Productos` tienen una relación `@ManyToMany` con `Talles`.

### Descuentos (`/api/descuentos`)

Gestiona los descuentos aplicables a productos.

*   **`GET /api/descuentos`**
    *   Descripción: Obtiene todos los descuentos.
    *   Response: `200 OK`
        ```json
        [
            {"id": 1, "descuento": 10.0, "fechaInicio": "2024-01-01T00:00:00", "fechaCierre": "2024-12-31T23:59:59"},
            {"id": 2, "descuento": 25.5, "fechaInicio": "2024-06-01T00:00:00", "fechaCierre": "2024-07-01T23:59:59"}
        ]
        ```
*   **`GET /api/descuentos/{id}`**
    *   Descripción: Obtiene un descuento por ID.
    *   Response: `200 OK`.
    *   Response: `404 Not Found`.
*   **`POST /api/descuentos`**
    *   Descripción: Crea un nuevo descuento.
    *   Request Body:
        ```json
        {"descuento": 15.0, "fechaInicio": "2024-08-01T00:00:00", "fechaCierre": "2024-08-15T23:59:59"}
        ```
    *   Response: `201 Created`.
    *   Response: `400 Bad Request`.
*   **`PUT /api/descuentos/{id}`**
    *   Descripción: Actualiza un descuento.
    *   Response: `200 OK`.
    *   Response: `404 Not Found`.
*   **`DELETE /api/descuentos/{id}`**
    *   Descripción: Elimina un descuento.
    *   Response: `204 No Content`.
    *   Response: `404 Not Found`.
*   **Notas sobre relaciones**:
    *   Los `Productos` tienen una relación `@ManyToOne` con `Descuento`.

### Pedidos (`/api/pedidos`)

Gestiona los pedidos de los usuarios. Un pedido contiene items de productos.

*   **`GET /api/pedidos`**
    *   Descripción: Obtiene todos los pedidos (posiblemente con filtros para admin).
    *   Response: `200 OK`
        ```json
        [
            {
                "id": 1,
                "usuario": {"id": 1, "nombre": "Juan Perez"},
                "items": [
                    {"id": 1, "producto": {"id": 1, "nombre": "Zapatilla Urbana Modelo X"}, "cantidad": 1},
                    {"id": 2, "producto": {"id": 2, "nombre": "Campera Deportiva"}, "cantidad": 1}
                ],
                "estado": "PENDIENTE",
                "fechaCreacion": "2024-07-27T10:30:00"
            }
        ]
        ```
*   **`GET /api/pedidos/{id}`**
    *   Descripción: Obtiene un pedido por ID.
    *   Response: `200 OK` (similar al objeto en la lista).
    *   Response: `404 Not Found`.
*   **`POST /api/pedidos`**
    *   Descripción: Crea un nuevo pedido.
    *   Request Body:
        ```json
        {
            "usuarioId": 1,
            "items": [
                {"productoId": 1, "cantidad": 1},
                {"productoId": 3, "cantidad": 2}
            ],
            "estado": "PENDIENTE" // El estado inicial podría ser fijado por el backend
        }
        ```
    *   Response: `201 Created`.
    *   Response: `400 Bad Request`.
*   **`PUT /api/pedidos/{id}`**
    *   Descripción: Actualiza un pedido (ej. cambiar estado, modificar items si el pedido no está finalizado).
    *   Request Body: (campos a actualizar, ej. `estado` o `items`).
        ```json
        {
            "estado": "ENPROCESO",
            "items": [ // Puede ser para ajustar cantidades o agregar/quitar items antes de procesar
                {"id": 1, "productoId":1, "cantidad": 2}, // Actualizar cantidad del item existente
                {"productoId": 4, "cantidad": 1}      // Nuevo item
            ]
        }
        ```
    *   Response: `200 OK`.
    *   Response: `404 Not Found`.
*   **`DELETE /api/pedidos/{id}`**
    *   Descripción: Elimina un pedido (generalmente solo si está en un estado cancelable).
    *   Response: `204 No Content`.
    *   Response: `404 Not Found`.
*   **Notas sobre relaciones**:
    *   Un `Pedido` pertenece a un `Usuario`.
    *   Un `Pedido` tiene una lista de `PedidoItem`, cada uno con un `Producto` y `cantidad`.

### Órdenes de Compra (`/api/ordenes-compra`)

Gestiona las órdenes de compra, que se generan a partir de un pedido y contienen los detalles finales de la transacción.

*   **`GET /api/ordenes-compra`**
    *   Descripción: Obtiene todas las órdenes de compra (usualmente para administradores).
    *   Response: `200 OK`
        ```json
        [
            {
                "id": 1,
                "pedido": {"id": 1, "usuarioId": 1, "fechaCreacion": "2024-07-27T10:30:00"},
                "detalles": [
                    {"id": 1, "producto": {"id": 1, "nombre": "Zapatilla Urbana Modelo X"}, "cantidad": 1, "precioUnitario": 150.00},
                    {"id": 2, "producto": {"id": 2, "nombre": "Campera Deportiva"}, "cantidad": 1, "precioUnitario": 89.99}
                ],
                "fechaOrden": "2024-07-27T11:00:00",
                "montoTotal": 239.99,
                "medioPago": "TARJETA_CREDITO"
            }
        ]
        ```
*   **`GET /api/ordenes-compra/{id}`**
    *   Descripción: Obtiene una orden de compra por ID.
    *   Response: `200 OK` (similar al objeto en la lista).
    *   Response: `404 Not Found`.
*   **`POST /api/ordenes-compra`**
    *   Descripción: Crea una nueva orden de compra (generalmente a partir de un pedido).
    *   Request Body:
        ```json
        {
            "pedidoId": 1, // ID del Pedido a procesar
            "medioPago": "TARJETA_DEBITO"
            // El montoTotal y los detalles se calculan/copian desde el pedido en el backend
        }
        ```
    *   Response: `201 Created`.
    *   Response: `400 Bad Request` (ej. si el pedidoId no es válido o ya fue procesado).
*   **`PUT /api/ordenes-compra/{id}`**
    *   Descripción: Actualiza una orden de compra (ej. solo estado de pago, o información de envío si aplica). Generalmente las órdenes son inmutables en sus items y montos una vez creadas.
    *   Response: `200 OK`.
    *   Response: `404 Not Found`.
*   **`DELETE /api/ordenes-compra/{id}`**
    *   Descripción: Eliminar una orden de compra es poco común y usualmente se marca como cancelada.
    *   Response: `204 No Content` (si se permite) o `405 Method Not Allowed`.
*   **Notas sobre relaciones**:
    *   Una `OrdenCompra` tiene una relación `@OneToOne` con `Pedido`.
    *   Una `OrdenCompra` tiene una lista de `DetalleOrden`, cada uno con un `Producto`, `cantidad` y `precioUnitario` (capturado al momento de la compra).

---

## 🔐 Autenticación y Autorización

*(Sección Futura)*

Actualmente, la API no implementa un esquema de autenticación/autorización robusto. Para un entorno de producción, se recomienda implementar:

*   **Autenticación**: Spring Security con JWT (JSON Web Tokens) o OAuth2.
*   **Autorización**: Basada en roles (Ej: `USUARIO`, `ADMIN`) para restringir el acceso a ciertos endpoints o funcionalidades.

Los endpoints que requieran autenticación necesitarán un header `Authorization` con el token correspondiente (Ej: `Authorization: Bearer <token>`).

---

## ✅ Cómo Testear un Endpoint

Puedes testear los endpoints usando herramientas como `curl`, Postman, Insomnia, o cualquier cliente HTTP.

### Ejemplo con `curl`:

Obtener todas las categorías:
```bash
curl -X GET http://localhost:8080/api/categorias
```

Crear una nueva categoría:
```bash
curl -X POST http://localhost:8080/api/categorias \
-H "Content-Type: application/json" \
-d '{"nombre": "PANTALONES"}'
```

### Ejemplo con Postman:

1.  Importa la colección (si se proporciona una) o crea una nueva solicitud.
2.  Selecciona el método HTTP (GET, POST, PUT, DELETE).
3.  Ingresa la URL del endpoint (Ej: `http://localhost:8080/api/productos`).
4.  Para solicitudes POST o PUT:
    *   Ve a la pestaña "Body".
    *   Selecciona "raw" y "JSON" como formato.
    *   Pega el cuerpo JSON de la solicitud.
5.  Ve a la pestaña "Headers" si necesitas añadir alguno (Ej: `Content-Type: application/json`).
6.  Haz clic en "Send".
7.  Revisa la respuesta (cuerpo, código de estado, headers).

---

## 🚀 Instrucciones para Levantar el Proyecto Localmente

### Requisitos

*   JDK 17 (Java Development Kit)
*   Gradle (generalmente viene con el wrapper del proyecto `./gradlew`)
*   Un IDE como IntelliJ IDEA, Eclipse o VS Code (opcional, pero recomendado)

### Pasos para Ejecutar

1.  **Clonar el repositorio** (si aplica):
    ```bash
    git clone <url-del-repositorio>
    cd vetra-backend 
    ```

2.  **Construir y Ejecutar usando Gradle Wrapper**:
    Desde la raíz del proyecto:
    *   En Linux/macOS:
        ```bash
        ./gradlew bootRun
        ```
    *   En Windows:
        ```bash
        gradlew.bat bootRun
        ```
    Esto compilará el proyecto, descargará las dependencias y iniciará la aplicación Spring Boot.

3.  **Ejecutar desde un IDE**:
    *   Importa el proyecto como un proyecto Gradle.
    *   Busca la clase principal `VetraApplication.java` (en `src/main/java/com/example/vetra`).
    *   Ejecuta el método `main` de esta clase.

### URL Base

Una vez que la aplicación esté corriendo, la API estará disponible en:
`http://localhost:8080`

Los endpoints específicos se construirán a partir de esta URL base (Ej: `http://localhost:8080/api/usuarios`).
La base de datos H2 en memoria estará disponible (si la consola H2 está habilitada en `application.properties`) en `http://localhost:8080/h2-console`.
Configuración típica para `application.properties` para la consola H2:
```properties
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.datasource.url=jdbc:h2:mem:vetradb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
```

---
Este README.md debería proporcionar una guía completa para los desarrolladores que trabajen con tu API. 