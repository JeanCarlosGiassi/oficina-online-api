import React, { useState, useContext } from 'react';
import {AuthContext} from "../../contexts/auth";

import "./styles.css"

const LoginPage = () =>{
    const {authenticated, login} = useContext(AuthContext);

const [username, setUsername] = useState("");
const [password, setPassword] = useState("");

const handleSubmit = (event) => {
 event.preventDefault();
 console.log("submit", {username, password});
 login(username, password)
}

    return (
        <div id="login">
            <h1 className="title">Login Oficina</h1>
            <p>{String(authenticated)}</p>
            <form className="form" onSubmit={handleSubmit}>
             <div className="field">
                <label htmlFor="user">Usuario</label>
                <input type="text" name="user" id="user"
                type={username}
                onChange={(e) => setUsername(e.target.value)}
                />
             </div>
             <div className="field">
                 <label htmlFor="password">Senha</label>
                 <input type="password" name="password" id="password"
                 type={password}
                 onChange={(e) => setPassword(e.target.value)}
                 />
             </div>
             <div className="actions">
                <button type="submit">Entrar</button>
             </div>
            </form>
        </div>
     );
};

export default LoginPage;