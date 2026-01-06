//Tipo de referencia

//personaje de tv
let nombre ="Tanjiro";
let anime ="Demon Slayer";
let edad = 16;

let personaje = { 
    //propiedades, llave: valor
    //javascript no asegura el orden de las propiedades
    nombre: "Tanjiro",
    anime: "Demon Slayer",
    edad: 16,
};
//para acceder a propiedades de un objeto
console.log(personaje); //totalidad del objeto
console.log(personaje.nombre); //Tanjiro
console.log(personaje['anime']); //[]: acceder a una propiedad de un objeto

personaje.edad = 13;

//---------------------------
personaje['edad'] = 16; //es mejor urilizar esta forma

//porque se puede concatenar con variables
let propiedad = 'edad';
console.log(personaje[propiedad]);

//eliminar propiedades de un objeto
delete personaje.anime;
console.log(personaje);