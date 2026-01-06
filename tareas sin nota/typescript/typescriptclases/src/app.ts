function imprimePino(altura:number) : void {
    for(let i = 0; i < altura; i++){
        let espacios: string ="";
        for(let j = 0; j < altura - i-1; j++){
            espacios += " ";
        }

        let asteriscos: string ="";
        for(let k=0; k<2*i+1; k++){
            asteriscos += "*";
        }
        console.log(espacios + asteriscos);
    }
}
imprimePino(5); // Llamada a la función