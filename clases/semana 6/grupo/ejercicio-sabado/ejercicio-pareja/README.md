# Ejercicio Peliculas 

## Enunciado
Caso Películas

A muchas personas les encanta ir al cine y ver las películas que están en cartelera. Se le pide realizar
un CRUD de las películas que están en cartelera manejando la siguiente implementación:
Para el desarrollo web de lado web frontend, se ha seleccionado TypeScript como lenguaje de
programación y Angular como Frontend Framework.

Se le encarga el desarrollo de una aplicación web que implemente las siguientes características:
1. Toolbar
   o Un toolbar, donde a la izquierda se muestra e nombre del cine y a la derecha se
   muestra las opciones “Home” y “películas”.
2. Vista Home
   o Un landing principal del cine.
   • Es accesible desde la ruta /home.
   • La vista raíz (accesible desde la ruta de navegación tanto /) debe redirigir al usuario
   a la vista /home.
3. Vista List Peliculas
   o Presenta una vista tabular con soporte de operaciones CRUD, para mostrar todas las
   películas disponibles.
   o Accesible en la ruta /business/peliculas, cada elemento de la tabla muestra la
   información de una pelicula, incluyendo el id, name, photo, duración, genero.
   o Debe permitir, además Actualizar o Eliminar Peliculas. Para cada fila se muestran
   controles con íconos para edit y delete. En la parte superior se muestra un botón
   new. Para el caso del delete al momento de eliminar una película se debe mostrar
   un mensaje de “película eliminado con éxito”.

## Miembros
- Piero Delgado
- Sharon Barrial
- Joseph Llacchua

## Instalaciones

```bash
npm install
```

```bash
ng add @angular/material
```

## Fake Api
Instalar los módulos requeridos:
```bash
npm install axios
npm install json-server
```

Y activar la ruta de la api falsa con el comando:
```bash
json-server --watch data.json
```

## Clone Deep
```bash
npm i --save lodash
npm i --save-dev @types/lodash
```
