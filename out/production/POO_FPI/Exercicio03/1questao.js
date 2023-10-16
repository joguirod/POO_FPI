var promptSync = require('prompt-sync')();
function main() {
    var entrada = Number(promptSync("Insira um número: "));
    if (ehPar(entrada))
        console.log("O número digitado é par!");
    else
        console.log("O número digitado é ímpar!");
}
function ehPar(numero) {
    if (numero % 2 == 0) {
        return true;
    }
    return false;
}
main();
