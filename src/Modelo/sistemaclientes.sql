-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-05-2020 a las 21:46:00
-- Versión del servidor: 10.4.6-MariaDB
-- Versión de PHP: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sistemaclientes`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `auditoria`
--

CREATE TABLE `auditoria` (
  `idAuditoria` int(11) NOT NULL,
  `descripcionAuditoria` varchar(77) NOT NULL,
  `fechaAuditoria` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `auditoria`
--

INSERT INTO `auditoria` (`idAuditoria`, `descripcionAuditoria`, `fechaAuditoria`) VALUES
(1, 'Se Insertó Cliente', '2020-04-17 21:24:49'),
(2, 'Se Modificó Cliente', '2020-04-17 21:24:56'),
(3, 'Se Eliminó Cliente', '2020-04-17 21:25:01'),
(4, 'Se Insertó Cliente', '2020-04-17 21:25:08'),
(5, 'Se Eliminó Cliente', '2020-04-17 21:25:10'),
(6, 'Se Insertó Compra', '2020-04-17 21:25:35'),
(7, 'Se Eliminó Compra', '2020-04-17 21:25:45'),
(8, 'Se Insertó Cliente', '2020-04-22 21:37:02'),
(9, 'Se Insertó Compra', '2020-04-22 23:29:40'),
(10, 'Se Modificó Compra', '2020-04-22 23:29:50'),
(11, 'Se Insertó Compra', '2020-04-22 23:30:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bodega`
--

CREATE TABLE `bodega` (
  `idBodega` int(11) NOT NULL,
  `codigoBodega` varchar(45) DEFAULT NULL,
  `idProductoBodega` int(11) DEFAULT NULL,
  `cantidadBodega` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `bodega`
--

INSERT INTO `bodega` (`idBodega`, `codigoBodega`, `idProductoBodega`, `cantidadBodega`) VALUES
(1, '1', 2, 233),
(3, '1', 1, 4560),
(6, '1', 1, 20),
(7, '1', 5, 22),
(9, '1', 1, 22),
(10, '1', 1, 5678),
(11, '1', 1, 450);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `idCliente` smallint(6) NOT NULL,
  `nombreCliente` varchar(255) NOT NULL,
  `documentoCliente` varchar(255) NOT NULL,
  `direccionCliente` varchar(255) NOT NULL,
  `celularCliente` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`idCliente`, `nombreCliente`, `documentoCliente`, `direccionCliente`, `celularCliente`) VALUES
(9, 'Arnoldo G.', '12356234', 'Los guayabos', '123456'),
(12, 'Duvan Felipe Barbosa Barbosa ', '107678977', 'Velez', '3232474563'),
(16, 'Dayana', '1007678978', 'Moniquira', '123445566'),
(17, 'Flor ESperanza Rodriguez', '63987567', 'Vélez', '3202698846'),
(22, 'Maria Fransica', '2345663', 'Bogotá', '789-4567-78'),
(26, 'Alberto Ramirez', '4567', 'Bogotá', '34');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compra`
--

CREATE TABLE `compra` (
  `idCompra` int(11) NOT NULL,
  `idClienteCompra` smallint(6) NOT NULL,
  `idProductoCompra` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `compra`
--

INSERT INTO `compra` (`idCompra`, `idClienteCompra`, `idProductoCompra`) VALUES
(1, 16, 4),
(2, 22, 9),
(3, 17, 5),
(6, 17, 1),
(7, 26, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `idEmpleado` int(11) NOT NULL,
  `nombreEmpleado` varchar(45) NOT NULL,
  `apellidoEmpleado` varchar(45) NOT NULL,
  `edadEmpleado` varchar(100) NOT NULL,
  `salarioEmpleado` varchar(100) NOT NULL,
  `correoEmpleado` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`idEmpleado`, `nombreEmpleado`, `apellidoEmpleado`, `edadEmpleado`, `salarioEmpleado`, `correoEmpleado`) VALUES
(5, 'Duvan Felipe', 'Barbosa Barbosa', '19', '55', 'felipe@gmail.com'),
(20, 'Flor Esperanza', 'Barbosa Rodriguez', '58', '0', '--'),
(27, 'Siervo De Jesus ', 'Barbosa Velasco', '62', '45000', '---');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE `pedido` (
  `idPedido` int(11) NOT NULL,
  `idProveedorPedido` int(11) DEFAULT NULL,
  `idProductoPedido` int(11) DEFAULT NULL,
  `fechaPedido` timestamp NULL DEFAULT current_timestamp(),
  `observacionPedido` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `pedido`
--

INSERT INTO `pedido` (`idPedido`, `idProveedorPedido`, `idProductoPedido`, `fechaPedido`, `observacionPedido`) VALUES
(3, 2, 1, '2020-04-22 10:30:18', 'incompleto'),
(4, 2, 2, '2020-04-22 22:17:07', 'Completo'),
(7, 6, 1, '2020-04-22 22:35:14', 'Completo'),
(8, 6, 2, '2020-04-23 00:37:12', 'Completo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `idProducto` int(11) NOT NULL,
  `nombreProducto` varchar(45) DEFAULT NULL,
  `pesoProducto` int(11) DEFAULT NULL,
  `idProveedor_Producto` int(11) DEFAULT NULL,
  `idTipo_Producto` int(11) DEFAULT NULL,
  `precioProducto` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`idProducto`, `nombreProducto`, `pesoProducto`, `idProveedor_Producto`, `idTipo_Producto`, `precioProducto`) VALUES
(1, 'Lenteja', 500, 6, 2, 8000),
(2, 'Frijol', 250, 5, 2, 5000),
(3, 'Fresa', 870, 5, 2, 6000),
(4, 'Garbanzo', 3400, 6, 2, 3000),
(5, 'Arroz', 5000, 3, 3, 21000),
(6, 'Arveja', 500, 3, 2, 3000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE `proveedor` (
  `idProveedor` int(11) NOT NULL,
  `nombreProveedor` varchar(77) NOT NULL,
  `RUTProveedor` varchar(77) NOT NULL,
  `telefonoProveedor` varchar(77) NOT NULL,
  `direccionProveedor` varchar(77) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`idProveedor`, `nombreProveedor`, `RUTProveedor`, `telefonoProveedor`, `direccionProveedor`) VALUES
(2, 'Duvan Barbosa', '234567', '32324777', 'Bolivar-santander'),
(3, 'Felipe', '23456', '23445676', 'Velez'),
(5, 'Alberto Camacho', '3253263', '322-234-2321', 'Bogotá'),
(6, 'Dayana Barbosa', '23576', '4567890', 'Moniquira');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo`
--

CREATE TABLE `tipo` (
  `idTipo` int(11) NOT NULL,
  `descripcionTipo` varchar(55) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipo`
--

INSERT INTO `tipo` (`idTipo`, `descripcionTipo`) VALUES
(1, 'Pasas'),
(2, 'Seco'),
(3, 'Del Valle'),
(4, 'Pasas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL,
  `nombreUsuario` varchar(45) NOT NULL,
  `cedulaUsuario` varchar(45) NOT NULL,
  `correoUsuario` varchar(45) NOT NULL,
  `telefonoUsuario` varchar(45) NOT NULL,
  `contrasenaUsuario` varchar(45) NOT NULL,
  `rolUsuario` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idUsuario`, `nombreUsuario`, `cedulaUsuario`, `correoUsuario`, `telefonoUsuario`, `contrasenaUsuario`, `rolUsuario`) VALUES
(1, 'Felipe', '123456789', 'Dubl@gmail.com', '3232474563', '12345678', 'Administrador'),
(3, 'Duvan ', '123545', 'felipe@gmail.com', '234356', 'hila', 'Empleado'),
(4, 'Arnoldo Ramirez', '1234', 'arlo@gmail.com', '23551246', '531ae4a0b287e230303c470af278617f6cd3eb13', 'Empleado'),
(5, 'Felipe', '123456789', 'Dublas@gmail.com', '3232474563', 'da39a3ee5e6b4b0d3255bfef95601890afd80709', 'Administrador'),
(6, 'Julio Suarez', '130042854', 'Julion@gmail.com', '----', '20eabe5d64b0e216796e834f52d61fd0b70332fc', 'Cliente'),
(7, 'Laura Pinzón', '234554', '-----', '3123454578', '99800b85d3383e3a2fb45eb7d0066a4879a9dad0', 'Cliente Premium'),
(8, 'Oscar Gonzalez', '1234567', 'os.hon@gmail.com', '00000000000', '8cb2237d0679ca88db6464eac60da96345513964', 'Administrador'),
(9, 'Alberto Cisneros ', '2346572', 'Alberto@gmail.com', '765432', 'cc4723995ce819915e734147a77850427a9e95f9', 'Cliente'),
(10, 'Laura Pinzón', '234554', 'NULO', '3123454578', 'da39a3ee5e6b4b0d3255bfef95601890afd80709', 'Cliente Premium');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `auditoria`
--
ALTER TABLE `auditoria`
  ADD PRIMARY KEY (`idAuditoria`);

--
-- Indices de la tabla `bodega`
--
ALTER TABLE `bodega`
  ADD PRIMARY KEY (`idBodega`),
  ADD KEY `idProductoBodega` (`idProductoBodega`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idCliente`);

--
-- Indices de la tabla `compra`
--
ALTER TABLE `compra`
  ADD PRIMARY KEY (`idCompra`),
  ADD KEY `idClienteCompra` (`idClienteCompra`),
  ADD KEY `idProductoCompra` (`idProductoCompra`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`idEmpleado`);

--
-- Indices de la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`idPedido`),
  ADD KEY `idProveedorPedido` (`idProveedorPedido`),
  ADD KEY `idProductoPedido` (`idProductoPedido`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`idProducto`),
  ADD KEY `idProveedor_Producto` (`idProveedor_Producto`),
  ADD KEY `idTipo_Producto` (`idTipo_Producto`);

--
-- Indices de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`idProveedor`);

--
-- Indices de la tabla `tipo`
--
ALTER TABLE `tipo`
  ADD PRIMARY KEY (`idTipo`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idUsuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `auditoria`
--
ALTER TABLE `auditoria`
  MODIFY `idAuditoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `bodega`
--
ALTER TABLE `bodega`
  MODIFY `idBodega` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `idCliente` smallint(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT de la tabla `compra`
--
ALTER TABLE `compra`
  MODIFY `idCompra` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `empleado`
--
ALTER TABLE `empleado`
  MODIFY `idEmpleado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT de la tabla `pedido`
--
ALTER TABLE `pedido`
  MODIFY `idPedido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `idProducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  MODIFY `idProveedor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `tipo`
--
ALTER TABLE `tipo`
  MODIFY `idTipo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `bodega`
--
ALTER TABLE `bodega`
  ADD CONSTRAINT `bodega_ibfk_1` FOREIGN KEY (`idProductoBodega`) REFERENCES `producto` (`idProducto`);

--
-- Filtros para la tabla `compra`
--
ALTER TABLE `compra`
  ADD CONSTRAINT `compra_ibfk_1` FOREIGN KEY (`idClienteCompra`) REFERENCES `cliente` (`idCliente`),
  ADD CONSTRAINT `compra_ibfk_2` FOREIGN KEY (`idProductoCompra`) REFERENCES `producto` (`idProducto`);

--
-- Filtros para la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`idProveedorPedido`) REFERENCES `proveedor` (`idProveedor`),
  ADD CONSTRAINT `pedido_ibfk_2` FOREIGN KEY (`idProductoPedido`) REFERENCES `producto` (`idProducto`);

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`idProveedor_Producto`) REFERENCES `proveedor` (`idProveedor`),
  ADD CONSTRAINT `producto_ibfk_2` FOREIGN KEY (`idTipo_Producto`) REFERENCES `tipo` (`idTipo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
