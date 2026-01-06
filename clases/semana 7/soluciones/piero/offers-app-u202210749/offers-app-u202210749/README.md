# Ejercicio2


This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 17.3.6.
<br>
Para mayor comprensión siga los siguientes pasos:

### Antes de empezar

1. Crea la carpeta donde residirá tu proyecto
2. Abre Webstorm, crea el proyecto en angular y selecciona la carpeta creada en el paso 1
3. Cuando webstorm termine de crear el proyecto
   dirigete a la siguiente sección **Durante el proceso**

### Durante el proceso
1. Abre el terminal de webstorm y ejecuta el siguiente comando:
```bash
npm install
```

2. Luego instala angular material con el siguiente comando:
```bash
ng add @angular/material
```
3. Para levantar el servidor coloca el siguiente comando:
```bash
ng serve -o
```

### Para crear componentes
1. Para crear un servicios abre otra terminal
   y coloca el comando: **ng g s** "nombre de tu servicio"
2. Para crear un componente **ng g c** "nombre de tu componente"

### Para levantar json
1. Abre otra terminal y coloca el siguiente comando:
   **cd** "nombre de tu carpeta"
2. Luego coloca el siguiente comando:
   **json-server --watch db.json --routes routes.json**

### Para instalar json-server
1. Abre otra terminal y coloca el siguiente comando:
   **npm install -g json-server@0.17.4**


---------------------------------------------------




# Installation
## Angular Basics
### Create Angular Project
```bash
npm install @angular/cli
```
### Add Angular Material
```bash
ng add @angular/material
```
## Fake API
### Install JSON Server
```bash
npm install -g json-server@0.17.4
```
### Init JSON Server
```
json-server --watch db.json --routes routes.json
```

# Commands
## Component Generation
```
ng g c dir/dir/dir
```

## Service Generation
```
ng g s dir/dir/dir
```

## Model Generation
```
ng g c dir/dir/dir --type=model
```
