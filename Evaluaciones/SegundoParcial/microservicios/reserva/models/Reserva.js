const mongoose = require('mongoose');

const reservaSchema = new mongoose.Schema({
  habitacion_id: { type: Number, required: true }, 
  usuario_id: { type: Number, required: true }, 
  fecha_reserva: { type: Date, default: Date.now },
  fecha_entrada: { type: Date, required: true },
  fecha_salida: { type: Date, required: true },
  estado_reserva: {
    type: String,
    enum: ['confirmada', 'pendiente', 'cancelada'],
    default: 'pendiente',
  },
  total_a_pagar: { type: Number, required: true }
});

module.exports = mongoose.model('Reserva', reservaSchema);
