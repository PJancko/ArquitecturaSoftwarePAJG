const express = require('express');
const router = express.Router();
const habitacionController = require('../controllers/habitacionController');
const auth = require('../middlewares/authMiddleware');

router.use(auth); // Proteger todas las rutas

router.get('/', habitacionController.getAll);
router.get('/:id', habitacionController.getById);
router.post('/', habitacionController.create);
router.put('/:id', habitacionController.update);
router.delete('/:id', habitacionController.remove);

module.exports = router;
