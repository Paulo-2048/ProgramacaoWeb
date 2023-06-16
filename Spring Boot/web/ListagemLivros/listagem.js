const baseUrl = "http://localhost:8181/livro"

async function getLivros() {
  try {
    const response = await axios.get(baseUrl);
    return response["data"]["data"];
  } catch (error) {
    console.log(error);
    alert("Erro ao carregar livros!");
  }
}

const livros = await getLivros();

console.log(livros)

const table = document.getElementById("tableListagem");

async function renderListaLivros(data){
  for (let i = 0; i < data.length; i++) {
    const row = table.insertRow(i+1);
    const cellTitulo = row.insertCell(0);
    const cellAutor = row.insertCell(1);
    const cellEditora = row.insertCell(2);
    const cellAno = row.insertCell(3);
    const cellIsbn = row.insertCell(4);
    const cellAcoes = row.insertCell(5);
    
    const btnRemover = document.createElement("button");
    btnRemover.innerHTML = "Remover";
    btnRemover.classList.add("btn", "btn-danger");
    btnRemover.addEventListener("click", () => {
      removerLivro(data[i]["id"]);
    }
    );

    cellTitulo.innerHTML = data[i]["title"];
    cellAutor.innerHTML = data[i]["author"];
    cellEditora.innerHTML = data[i]["publisher"];
    cellAno.innerHTML = data[i]["year"];
    cellIsbn.innerHTML = data[i]["isbn"];
    cellAcoes.appendChild(btnRemover);
  }
}

renderListaLivros(livros);

async function removerLivro(id) {
  try {
    const response = await axios.delete(`${baseUrl}/${id}`);
    alert(response["data"]["message"]);
    window.location.reload();
  } catch (error) {
    console.log(error);
    alert("Erro ao remover livro!");
  }
}
