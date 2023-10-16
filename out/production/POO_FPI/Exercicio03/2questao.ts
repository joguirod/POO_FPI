var promptSync = require('prompt-sync')();

function main(){
    const entrada = Number(promptSync("Insira um número: "));
    if (ehPrimo(entrada)) console.log("O número digitado é primo!")
    else console.log("O número não é primo.")
}

function ehPrimo(numero: number): boolean{
    let divisores: number = 0;
    let atual: number = 1;

    while (atual <= numero){
        if (numero % atual == 0){
            divisores += 1;
        }
        atual += 1;
    }

    if (divisores == 2){
        return true;
    }

    return false;
}

main();