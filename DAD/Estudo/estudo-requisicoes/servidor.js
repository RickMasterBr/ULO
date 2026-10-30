const express = require("express");
const path = require("node:path");

const app = express();
const PORT = 3000;

// Dados de exemplo: ainda não estamos usando um banco.
const usuarios = [
    { id: 1, nome: "Ana", email: "ana@exemplo.com" },
    { id: 2, nome: "Bruno", email: "bruno@exemplo.com" },
    { id: 3, nome: "Richard", email: "richard@exemplo.com" },
];

// Disponibiliza o HTML e o JavaScript da pasta public.
app.use(express.static(path.join(__dirname, "public")));

// Endpoint da nossa API.
app.get("/api/usuarios/:id", (req, res) => {
    const id = Number(req.params.id);

    if (!Number.isSafeInteger(id) || id < 1) {
        return res.status(400).json({
            mensagem: "Informe um ID inteiro maior que zero.",
        });
    }

    const usuario = usuarios.find((usuario) => usuario.id === id);

    if (!usuario) {
        return res.status(404).json({
            mensagem: "Usuário não encontrado.",
        });
    }

    return res.json(usuario);
});

app.listen(PORT, () => {
    console.log(`Abra http://localhost:${PORT}`);
});