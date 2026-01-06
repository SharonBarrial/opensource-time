//ejercicio 1

let n = 5;
//let n = 2;

function calcularSuma(n: number): number {
    let suma = 0;

    for (let i = 1; i <= n; i++) {
        suma += i * i;
    }
    return suma;
}

const sumaTotal = calcularSuma(n);
console.log("Ejercicio 1 - La suma total es: " + sumaTotal);

//ejercicio 2

//fibonacci: suma de los dos anteriores
//producto de los numeros de la serie fibonacci
//pero no se puede contar el 0

let num = 5; //0*,1,1,2,3,5
//let num = 2; //0*,1,1
//let num = 3; //0*,1,1,2
//let num = 4; //0*,1,1,2,3

function fibonacci(num: number) {
    let t1 = 0;
    let t2 = 1;
    let producto = 1;

    for (let i = 0; i < num; i++) {
        let temp = t1;
        //let temp2 += t2;
        t1= t2;
        t2= temp+t2;
        producto *= t1;
    }
    return producto;
}
const resultado=fibonacci(num);
console.log("Ejercicio 2 - El resultado es: " + resultado);

//ejercicio 3

let numeros: number[] = [6, 2, 8, 10];
//let numeros: number[] = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];

function encontrarSegundoMayor(numeros: number[]): [number, number] {
    let mayor = numeros[0];
    let segundoMayor = numeros[1];
    let posicion = 0;

    for (let i = 0; i < numeros.length; i++) {
        if (numeros[i] > mayor) {
            segundoMayor = mayor;
            mayor = numeros[i];
            posicion = i;
        } else if (numeros[i] > segundoMayor && numeros[i] !== mayor) {
            segundoMayor = numeros[i];
            posicion = i;
        }
    }

    return [segundoMayor, posicion];
}

const [segundoMayor, posicion] = encontrarSegundoMayor(numeros);
console.log("Ejercicio 3 - El segundo número más grande es: " + segundoMayor, 
            "y su posición en el vector es: " + posicion);

//ejercicio 7

let edades: number[] = [6, 2, 8, 10];
//let numeros: number[] = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];

function ascendente(edades: number[]): [number, number] {
    let mayor = edades[0];
    let segundoMayor = edades[1];

    for (let i = 0; i < edades.length; i++) {
        for (let j = 0; j < edades.length; j++) {
            if (edades[j] > edades[j+1]) {
                let temp = edades[j];
                edades[j] = edades[j+1];
                edades[j+1] = temp;
            }
        }
    }

    return [mayor, segundoMayor];
}

//const [] = ascendente(numeros);
//console.log("Ejercicio 3 - El segundo número más grande es: " + segundoMayor, 
            //"y su posición en el vector es: " + posicion); //.join
