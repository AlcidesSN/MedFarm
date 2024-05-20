function removerParametrosDaURL(url) {
    // Criando um objeto URL a partir da URL fornecida
    const urlObj = new URL(url);

    // Removendo os parâmetros de pesquisa da URL
    urlObj.search = '';

    // Atualizando a URL atual no histórico do navegador
    window.history.replaceState({}, '', urlObj.toString());
}

// Exemplo de uso:
removerParametrosDaURL(window.location.href);