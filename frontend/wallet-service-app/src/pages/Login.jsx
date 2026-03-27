import React, { useState } from 'react';

function Login() {
    const [credentials, setCredentials] = useState({ username: '', password: '' });
    const [message, setMessage] = useState('');

    const handleChange = (e) => {
        const { name, value } = e.target;
        setCredentials({ ...credentials, [name]: value });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await fetch('http://localhost:8080/api/login', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(credentials),
            });

            if (response.ok) {
                const data = await response.json();
                localStorage.setItem('token', data.token);
                setMessage('Login efetuado com sucesso!');
            } else {
                setMessage('Credenciais inválidas.');
            }
        } catch (error) {
            setMessage('Erro ao ligar ao servidor.');
        }
    };

    return (
        <div style={{ maxWidth: '300px', margin: '50px auto' }}>
        <h2>Login Bank System</h2>
        <form onSubmit={handleSubmit}>
            <div>
            <label>Username/NIF:</label>
            <input type="text" name="username" onChange={handleChange} required style={{ width: '100%' }} />
            </div>
            <div style={{ marginTop: '10px' }}>
            <label>Password:</label>
            <input type="password" name="password" onChange={handleChange} required style={{ width: '100%' }} />
            </div>
            <button type="submit" style={{ marginTop: '20px', width: '100%' }}>Entrar</button>
        </form>
        {message && <p>{message}</p>}
        </div>
    );
}

export default Login;