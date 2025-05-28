const express = require('express');
require('dotenv').config();
require('./db'); // Conectar a MongoDB

const reservaRoutes = require('./routes/reservaRoutes');

const app = express();
app.use(express.json());

app.use('/reservas', reservaRoutes);

const PORT = process.env.PORT || 3003;
app.listen(PORT, () => {
  console.log(`Microservicio escuchando en http://localhost:${PORT}`);
});
