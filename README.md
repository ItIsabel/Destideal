# Destideal
Tras 13 años en el sector turístico

He detectado las principales preguntas con las que se suele llegar a una agencia de viajes. Este proyecto pretende dar solución a esos interrogantes y canalizar la venta en función de los requisitos establecidos por el usuario.

En el front se trabaja por componentes con Angular. En el back usamos el entorno de Spring con las facilidades que ello aporta para la persistencia de datos y el MVC. Para la BBDD usamos MySql.

## Notas de Implementación Técnica 

### Backend
- Framework Spring Boot
- Java 17 o superior
- Base de datos Mysql
- Arquitectura API RESTful

### Frontend
- Framework Angular
- Estilos compartidos para contenedores de listas y diálogos de edición

## Configuración del Entorno de Desarrollo

### Requisitos Backend
- IDE IntelliJ
- Java 17 o superior
- Postman para pruebas de API

### Configuración de Spring
- Tipo de proyecto: Maven
- Lenguaje: Java
- Versión de Spring Boot: 3.2.4 (o similar versión 3.x no-SNAPSHOT)
- Group: com.ccsw
- ArtifactId: tutorial
- Versión de Java: 17 o superior

### Dependencias Backend
- Spring Web
- Spring Data JPA
- Base de datos Mysql
- Dependencias adicionales:
  ```xml
  <dependency>
      <groupId>org.springdoc</groupId>
      <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
      <version>2.0.3</version>
  </dependency>
  <dependency>
      <groupId>org.hibernate</groupId>
      <artifactId>hibernate-validator</artifactId>
      <version>8.0.0.Final</version>
  </dependency>
  <dependency>
      <groupId>org.modelmapper</groupId>
      <artifactId>modelmapper</artifactId>
      <version>3.1.1</version>
  </dependency>
  ```

### Requisitos Frontend
- Visual Studio Code
- Node.js (instalado vía Scoop)

### Configuración del Gestor de Paquetes Scoop
```powershell
Set-ExecutionPolicy -ExecutionPolicy RemoteSigned -Scope CurrentUser
Invoke-RestMethod -Uri https://get.scoop.sh | Invoke-Expression
scoop config use_lessmsi true
scoop install main/nodejs
```

### Configuración de Angular
1. Instalar Angular CLI: `npm install -g @angular/cli`
2. Crear nuevo proyecto: `ng new tutorial --strict=false`
   - ¿Desea añadir enrutamiento Angular? Preferiblemente: y
   - ¿Qué formato de hoja de estilos le gustaría usar? Preferiblemente: SCSS
   - ¿Desea habilitar la renderización del lado del servidor (SSR)? Preferiblemente: N
3. Añadir Angular Material: `ng add @angular/material`
4. Iniciar el proyecto: `ng serve`
