function converter() {
    const valorEmReais = parseFloat(document.getElementById("valor").value);
    const moedaSelecionada = document.getElementById("moeda").value;

    let taxaDeConversao = 0;

    // Defina as taxas de conversão para as moedas desejadas
    if (moedaSelecionada === "dolar") {
        taxaDeConversao = 4.8710; // Exemplo: 1 BRL = 5.20 USD
    } else if (moedaSelecionada === "euro") {
        taxaDeConversao = 5.20; // Exemplo: 1 BRL = 6.10 EUR
    }

    const valorConvertido = (valorEmReais / taxaDeConversao).toFixed(2);

    document.getElementById("resultado").textContent = valorConvertido + ` ${moedaSelecionada.toUpperCase()}`;
}




