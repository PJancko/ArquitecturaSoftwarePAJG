const Reserva = require('../models/Reserva');

exports.getAll = async (req, res) => {
  const reservas = await Reserva.find();
  res.json(reservas);
};

exports.getById = async (req, res) => {
  const reserva = await Reserva.findById(req.params.id);
  if (!reserva) return res.status(404).json({ message: 'No encontrada' });
  res.json(reserva);
};

exports.create = async (req, res) => {
  const reserva = new Reserva(req.body);
  await reserva.save();
  res.status(201).json(reserva);
};

exports.update = async (req, res) => {
  const updated = await Reserva.findByIdAndUpdate(req.params.id, req.body, { new: true });
  if (!updated) return res.status(404).json({ message: 'No encontrada' });
  res.json(updated);
};

exports.remove = async (req, res) => {
  const deleted = await Reserva.findByIdAndDelete(req.params.id);
  if (!deleted) return res.status(404).json({ message: 'No encontrada' });
  res.json({ message: 'Reserva eliminada' });
};
