# splitter_java
Ejercicio de División en Segmentos de Archivos Varios

Configuraciones:

1. Configuración del Backend (Spring Boot)

Requisitos previos

1.1.-Instalar Java 8 o superior:

En Linux:
sudo apt update
sudo apt install openjdk-11-jdk
java -version

En Windows bajar

1.2.-Instalar Maven para gestionar dependencias:

En Linux:
sudo apt install maven
mvn -version

1.3.-Crear el proyecto con Spring Boot utilizando Spring Initializr:

mvn archetype:generate -DgroupId=com.filesplitter -DartifactId=file-splitter -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

1.4.- Acceder al directorio del proyecto

cd file-splitter

1.5.- Configurar Dependencias

Edita el archivo pom.xml y agrega las dependencias iniciales necesarias:

<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter</artifactId>
    </dependency>
</dependencies>

1.6.- Ejecutar el Backend

mvn spring-boot:run

El servicio estará disponible en http://localhost:8080/api/files/split.

2.- Configuración del Frontend (React)

Requisitos previos

2.1 Instalar Node.js y npm:

En linux(Debian)

sudo apt install nodejs npm
node -v
npm -v

2.2 Crear un proyecto React con Vite:

En Linux y Windows:

npm create vite@latest file-split-frontend --template react

2.3 Acceder al proyecto:

En Linux:

cd file-split-frontend

2,4 Instalar Dependencias

Dentro del directorio del frontend, instala las dependencias necesarias:

npm install
npm install @shadcn/ui tailwindcss postcss autoprefixer

2.5 Ejecutar el Frontend

npm run dev

2.6 Se debe Acceder en el navegador(Cualquiera firefox,Edge,Chrome,Brave,etc) a la rura:

   http://localhost:5173/

Recomendaciones de IDES:

IDE Recomendado para Linux

Se recomienda usar Visual Studio Code(Frontend Nodejs) e IntelliJ IDEA Community(Backend Java).

Resumen de Pasos
1.-Configurar el backend con Spring Boot y Maven.
2.-Ejecutar el backend con mvn spring-boot:run.
3.-Configurar el frontend con React y Vite.
4.-Ejecutar el frontend con npm run dev.
5.-Abrir el proyecto en un IDE como VS Code o IntelliJ IDEA.

-----------------------------------------------------------------------------------------------

Ejercicio de Desarrollo Java

Este Ejercicio se desarrolló con la idea de responder a un requerimiento funcional
para solucionar un problema práctico de la vida diaria.

Se presenta un Manual de Desarrollo que se realizó para la solución del problema planteado:

1.- Se dividió el desarrollo en dos partes:

A) Backend en Java

1.-Un servicio REST que reciba un archivo, lo divida en segmentos configurables y devuelva la lista de archivos generados.
2.-Una implementación con Spring Boot para manejar la lógica de fragmentación.

En el backend con Spring Boot. Se definó un servicio REST que:

-Recibe un archivo y el tamaño del segmento en bytes.
-Divide el archivo en partes según el tamaño indicado.
-Devuelve los archivos generados con sus nombres y tamaños.

B) Frontend Web Responsivo

1.- Se desarrolló una interfaz que permite arrastrar y soltar archivos o seleccionarlos desde el disco.
2.- Visualizar de los archivos generados con sus nombres y tamaños.
3.- Una pantalla rápida Modal de "Procesando Archivo" mientras se ejecuta la operación.

En el Frontend(Desarrollado con React y TailwindCSS):

Para el frontend, se desarrolló una interfaz web responsiva que permite:

-Subir archivos arrastrando o seleccionando desde el disco.
-Ingresar el tamaño del segmento en bytes.
-Mostrar un modal "Procesando Archivo" mientras se divide el archivo.
-Listar los archivos generados con sus nombres y tamaños.

Cosas a Tener en Cuenta

1.- Reemplaze  /ruta/donde/se/guardan/los/archivos/ con la ruta donde se guardan los archivos generados por el backend.
 Por ejemplo:
  private static final String STORAGE_PATH = "C:/Users/tuUsuario/splitFiles/";
Asegure que los archivos sean accesibles desde el backend.
2.- Si esta en Linux/Mac, revise los permisos con el comando:
  chmod -R 755 /ruta/donde/se/guardan/los/archivos/
3.- Pruebe accediendo a un archivo en el navegador:
 Supongamos que generó Foto.0.img, intenta descargarlo con:
    http://localhost:8080/api/files/Foto.0.img
Si descarga correctamente, el controlador está funcionando.

/---------------------------------fastdid Enjoy-----------------------------------------------/
