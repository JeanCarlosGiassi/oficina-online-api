import axios from "axios";

export const api = axios().create({
    baseUrl: "http:localhost:3000"
})

export const createSession = async (username, password) =>{
    return api.post("/sessions", {username, password})
}

export const getUsers = async () => {
    return api.get("/users")
}