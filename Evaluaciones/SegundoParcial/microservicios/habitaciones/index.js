const express = require('express');
const habitacionRoutes = require('./routes/habitacionRoutes');
require('dotenv').config();

const app = express();
app.use(express.json());

app.use('/habitaciones', habitacionRoutes);

const PORT = process.env.PORT || 3002;
app.listen(PORT, () => {
  console.log(`Microservicio de habitaciones en http://localhost:${PORT}`);
});
