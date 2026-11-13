import { addUser, removeUser, getUserCount } from "../state/connection.js"

export const handleConnectionEvents = (io, socket) => {
    socket.on("join", (user) => {
        if (!user?.id) return
        addUser(socket, user)
        console.log(`[Connection] User ${user.name} has joined the server`)
        console.log(`[Connection] ${getUserCount()} users online`)
    })

    socket.on("leave", () => {
        const user = removeUser(socket.id)
        if (user?.name) {
            console.log(`[Connection] User ${user.name} has left the server`)
        }
        console.log(`[Connection] ${getUserCount()} users online`)
    })

    socket.on("disconnect", () => {
        console.log("Connection Lost:", socket.id)
        const user = removeUser(socket.id)
        if (user?.name) {
            console.log(`[Connection] User ${user.name} has left the server`)
        }
        console.log(`[Connection] ${getUserCount()} users online`)
    })
}