var promptSync = require('prompt-sync')();
function main() {
    var nome = promptSync("Qual o seu nome?\n");
    var pronome = promptSync("Qual sua preferência por pronome de tratamento? (caso não tenha, deixe em branco)\n");
    if (pronome !== "")
        saudacao(nome, pronome);
    else
        saudacao(nome);
}
function saudacao(nome, pronome) {
    if (pronome === void 0) { pronome = "Sr"; }
    console.log("".concat(pronome, ". ").concat(nome));
}
main();
