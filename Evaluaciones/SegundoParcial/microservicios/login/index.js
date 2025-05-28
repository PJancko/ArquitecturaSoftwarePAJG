const express = require('express');
const jwt = require('jsonwebtoken');
const bcrypt = require('bcrypt');
const pool = require('./db');
require('dotenv').config();

const app = express();
app.use(express.json());

app.use((req, res, next) => {
  console.log('Petición recibida:', req.method, req.url);
  next();
});

app.post('/login', async (req, res) => {
  console.log('Ruta backend')
  const { email, password } = req.body;

  try {
    const [rows] = await pool.execute(
      'SELECT * FROM users WHERE email = ? LIMIT 1',
      [email]
    );

    if (rows.length === 0) {
      return res.status(401).json({ message: 'Credenciales inválidas' });
    }

    const user = rows[0];
    const hash = user.password.replace('$2y$', '$2b$'); // 🔧 Fix clave

    const isPasswordValid = await bcrypt.compare(password, hash);
    if (!isPasswordValid) {
    return res.status(401).json({ message: 'Credenciales inválidas' });
    }

    const token = jwt.sign(
      {
        id: user.id,
        email: user.email,
        tipo_usuario: user.tipo_usuario,
      },
      process.env.JWT_SECRET,
      { expiresIn: process.env.JWT_EXPIRES_IN }
    );

    res.json({ token });
  } catch (error) {
    console.error('Error en login:', error);
    res.status(500).json({ message: 'Error interno del servidor' });
  }
});

const PORT = 3000;
app.listen(PORT, () => {
  console.log(`Login microservice running on http://localhost:${PORT}`);
});
