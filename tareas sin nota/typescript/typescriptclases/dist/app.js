"use strict";
function imprimePino(altura) {
    for (var i = 0; i < altura; i++) {
        var espacios = "";
        for (var j = 0; j < altura - i - 1; j++) {
            espacios += " ";
        }
        var asteriscos = "";
        for (var k = 0; k < 2 * i + 1; k++) {
            asteriscos += "*";
        }
        console.log(espacios + asteriscos);
    }
}
imprimePino(5); // Llamada a la función
