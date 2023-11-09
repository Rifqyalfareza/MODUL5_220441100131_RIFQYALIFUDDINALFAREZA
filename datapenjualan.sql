-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 09, 2023 at 04:53 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `datapenjualan`
--

-- --------------------------------------------------------

--
-- Table structure for table `databarang`
--

CREATE TABLE `databarang` (
  `kode_barang` varchar(20) NOT NULL,
  `nama_barang` varchar(20) NOT NULL,
  `harga_barang` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `databarang`
--

INSERT INTO `databarang` (`kode_barang`, `nama_barang`, `harga_barang`) VALUES
('AD001', 'Sepatu', '120000'),
('AD002', 'Tas', '200000');

-- --------------------------------------------------------

--
-- Table structure for table `datapembeli`
--

CREATE TABLE `datapembeli` (
  `nama_pembeli` varchar(20) NOT NULL,
  `nama_barang` varchar(20) NOT NULL,
  `kode_barang` varchar(20) NOT NULL,
  `harga_barang` varchar(20) NOT NULL,
  `jumlah_beli` varchar(20) NOT NULL,
  `harga_total` varchar(20) NOT NULL,
  `uang_pembeli` varchar(20) NOT NULL,
  `kembalian` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `datapembeli`
--

INSERT INTO `datapembeli` (`nama_pembeli`, `nama_barang`, `kode_barang`, `harga_barang`, `jumlah_beli`, `harga_total`, `uang_pembeli`, `kembalian`) VALUES
('Alpa', 'Tas', 'AD002', '200000', '2', '400000', '400000', '0');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `databarang`
--
ALTER TABLE `databarang`
  ADD UNIQUE KEY `kode_barang` (`kode_barang`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
