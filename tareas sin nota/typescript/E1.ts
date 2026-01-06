function calcularSumaCuadrados(N: number): number {
    let suma = 0;
    for (let i = 1; i <= N; i++) {
      suma += i ** 2;
    }
    return suma;
}

const N = 5;
const sumaCuadrados = calcularSumaCuadrados(N);
console.log(`La suma de los cuadrados de los primeros ${N} números enteros es: ${sumaCuadrados}`);