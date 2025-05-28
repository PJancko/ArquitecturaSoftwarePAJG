const db = require('../db');

// Listar todas las habitaciones
exports.getAll = async (req, res) => {
  const [rows] = await db.execute('SELECT * FROM habitacions');
  res.json(rows);
};

// Obtener una habitación por ID
exports.getById = async (req, res) => {
  const [rows] = await db.execute('SELECT * FROM habitacions WHERE id = ?', [req.params.id]);
  if (rows.length === 0) return res.status(404).json({ message: 'No encontrada' });
  res.json(rows[0]);
};

// Crear habitación
exports.create = async (req, res) => {
  const { numero_habitacion, tipo_habitacion_id, precio_por_noche, estado, descripcion } = req.body;
  await db.execute(
    'INSERT INTO habitacions (numero_habitacion, tipo_habitacion_id, precio_por_noche, estado, descripcion) VALUES (?, ?, ?, ?, ?)',
    [numero_habitacion, tipo_habitacion_id, precio_por_noche, estado, descripcion]
  );
  res.status(201).json({ message: 'Habitación creada' });
};

// Actualizar habitación
exports.update = async (req, res) => {
  const { numero_habitacion, tipo_habitacion_id, precio_por_noche, estado, descripcion } = req.body;
  await db.execute(
    'UPDATE habitacions SET numero_habitacion=?, tipo_habitacion_id=?, precio_por_noche=?, estado=?, descripcion=? WHERE id=?',
    [numero_habitacion, tipo_habitacion_id, precio_por_noche, estado, descripcion, req.params.id]
  );
  res.json({ message: 'Habitación actualizada' });
};

// Eliminar habitación
exports.remove = async (req, res) => {
  await db.execute('DELETE FROM habitacions WHERE id=?', [req.params.id]);
  res.json({ message: 'Habitación eliminada' });
};
