-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 30-Jun-2018 às 02:55
-- Versão do servidor: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `locadoragames`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cadastroclientes`
--

CREATE TABLE `cadastroclientes` (
  `nomeCliente` varchar(50) NOT NULL,
  `cpfCliente` varchar(50) NOT NULL,
  `enderecoCliente` varchar(50) NOT NULL,
  `numeroEndereco` varchar(50) NOT NULL,
  `telResidencial` varchar(50) NOT NULL,
  `telCelular` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `cadastroclientes`
--

INSERT INTO `cadastroclientes` (`nomeCliente`, `cpfCliente`, `enderecoCliente`, `numeroEndereco`, `telResidencial`, `telCelular`) VALUES
('Sergio Augusto Dognini', '07685047918', 'rio negrinho kkk', '9998', '33265605', '997720228'),
('sergio', '12225', 'fffa', '3', '55', '55');

-- --------------------------------------------------------

--
-- Estrutura da tabela `consoles`
--

CREATE TABLE `consoles` (
  `idConsole` int(11) NOT NULL,
  `nomeConsole` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `dadosclientes`
--

CREATE TABLE `dadosclientes` (
  `idDadosClientes` int(11) NOT NULL,
  `nomeDadosCliente` varchar(50) NOT NULL,
  `senhaUsuario` varchar(50) DEFAULT NULL,
  `emailDadosCliente` varchar(50) NOT NULL,
  `telefoneDadosClientes` varchar(14) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `dadosclientes`
--

INSERT INTO `dadosclientes` (`idDadosClientes`, `nomeDadosCliente`, `senhaUsuario`, `emailDadosCliente`, `telefoneDadosClientes`) VALUES
(1, 'sergio', '123', 'asfasfasf@asfasf', '123123123'),
(2, 'Sergio', '123456', 'asfasfas', '12312312321'),
(3, 'iphone', '1234', '', '');

-- --------------------------------------------------------

--
-- Estrutura da tabela `estoque`
--

CREATE TABLE `estoque` (
  `idEstoque` int(11) NOT NULL,
  `idJogo` int(11) NOT NULL,
  `quantidadeEstoque` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `generos`
--

CREATE TABLE `generos` (
  `idGenero` int(11) NOT NULL,
  `nomeGenero` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `jogos`
--

CREATE TABLE `jogos` (
  `idJogo` int(11) NOT NULL,
  `nomeJogo` varchar(30) NOT NULL,
  `valorJogo` decimal(10,2) NOT NULL,
  `idGenero` int(11) NOT NULL,
  `idConsole` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `locacao`
--

CREATE TABLE `locacao` (
  `idLocacao` int(11) NOT NULL,
  `idJogo` int(11) NOT NULL,
  `idCadastroClientes` int(11) NOT NULL,
  `dataLocacao` date NOT NULL,
  `dataEntrega` date NOT NULL,
  `situacao` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `login`
--

CREATE TABLE `login` (
  `idLogin` int(11) NOT NULL,
  `usuarioLogin` varchar(50) NOT NULL,
  `senhaLogin` varchar(50) NOT NULL,
  `idDadosClientes` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cadastroclientes`
--
ALTER TABLE `cadastroclientes`
  ADD PRIMARY KEY (`cpfCliente`);

--
-- Indexes for table `consoles`
--
ALTER TABLE `consoles`
  ADD PRIMARY KEY (`idConsole`);

--
-- Indexes for table `dadosclientes`
--
ALTER TABLE `dadosclientes`
  ADD PRIMARY KEY (`idDadosClientes`);

--
-- Indexes for table `estoque`
--
ALTER TABLE `estoque`
  ADD PRIMARY KEY (`idEstoque`),
  ADD KEY `estoque_fk0` (`idJogo`);

--
-- Indexes for table `generos`
--
ALTER TABLE `generos`
  ADD PRIMARY KEY (`idGenero`);

--
-- Indexes for table `jogos`
--
ALTER TABLE `jogos`
  ADD PRIMARY KEY (`idJogo`),
  ADD KEY `jogos_fk0` (`idGenero`),
  ADD KEY `jogos_fk1` (`idConsole`);

--
-- Indexes for table `locacao`
--
ALTER TABLE `locacao`
  ADD PRIMARY KEY (`idLocacao`),
  ADD KEY `Locacao_fk0` (`idJogo`),
  ADD KEY `Locacao_fk1` (`idCadastroClientes`) USING BTREE;

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`idLogin`),
  ADD KEY `login_fk0` (`idDadosClientes`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `consoles`
--
ALTER TABLE `consoles`
  MODIFY `idConsole` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `dadosclientes`
--
ALTER TABLE `dadosclientes`
  MODIFY `idDadosClientes` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `estoque`
--
ALTER TABLE `estoque`
  MODIFY `idEstoque` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `generos`
--
ALTER TABLE `generos`
  MODIFY `idGenero` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `jogos`
--
ALTER TABLE `jogos`
  MODIFY `idJogo` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `locacao`
--
ALTER TABLE `locacao`
  MODIFY `idLocacao` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `idLogin` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `estoque`
--
ALTER TABLE `estoque`
  ADD CONSTRAINT `estoque_fk0` FOREIGN KEY (`idJogo`) REFERENCES `jogos` (`idJogo`);

--
-- Limitadores para a tabela `jogos`
--
ALTER TABLE `jogos`
  ADD CONSTRAINT `jogos_fk0` FOREIGN KEY (`idGenero`) REFERENCES `generos` (`idGenero`),
  ADD CONSTRAINT `jogos_fk1` FOREIGN KEY (`idConsole`) REFERENCES `consoles` (`idConsole`);

--
-- Limitadores para a tabela `locacao`
--
ALTER TABLE `locacao`
  ADD CONSTRAINT `Locacao_fk0` FOREIGN KEY (`idJogo`) REFERENCES `jogos` (`idJogo`),
  ADD CONSTRAINT `Locacao_fk1` FOREIGN KEY (`idcadastroClientes`) REFERENCES `dadosclientes` (`idDadosClientes`);

--
-- Limitadores para a tabela `login`
--
ALTER TABLE `login`
  ADD CONSTRAINT `login_fk0` FOREIGN KEY (`idDadosClientes`) REFERENCES `dadosclientes` (`idDadosClientes`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
