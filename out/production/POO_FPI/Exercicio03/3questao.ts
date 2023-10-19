const promptSync = require('prompt-sync')();

function main(){
    const nome: string = promptSync("Qual o seu nome?\n");
    const pronome: string = promptSync("Qual sua preferência por pronome de tratamento? (caso não tenha, deixe em branco)\n");

    if (pronome !== "") saudacao(nome, pronome);
    else saudacao(nome);
}

function saudacao(nome: string, pronome: string = "Sr"){
    console.log(`${pronome}. ${nome}`);
}

main();