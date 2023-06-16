
const baseUrl = "http://localhost:8181/livro"

// DOM Elements
const form = document.getElementById("formCadastro");

// Get Student Data

form.addEventListener("submit", (event) => {
  event.preventDefault();

  let titulo = document.getElementById("titulo").value;
  let autor = document.getElementById("autor").value;
  let editora = document.getElementById("editora").value;
  let anoPublicacao = parseInt(document.getElementById("ano").value);
  let isbn = document.getElementById("isbn").value;

  let data = {
    titulo: titulo,
    autor: autor,
    editora: editora,
    anoPublicacao: anoPublicacao,
    isbn: isbn
  };

  console.log(data);
  enviarDados(data);
});


async function enviarDados(dados) {
  try {
    const response = await axios.post(baseUrl, dados);
    alert(response["data"]["message"]);
    window.location.reload();
  } catch (error) {
    console.log(error);
    alert("Erro ao cadastrar livro!");
  }
}
