import React, { useState } from 'react';
import "./styles.css"

const LoginPage = () =>{
const [username, setUsername] = useState("");
const [password, setPassword] = useState("");

const handleSubmit = (event) => {
 event.preventDefault();
 console.log("submit", {username, password});
}

    return (
        <div id="login">
            <h1 className="title">Login Oficina</h1>
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