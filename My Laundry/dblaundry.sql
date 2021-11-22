-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 22 Nov 2021 pada 13.18
-- Versi server: 10.4.19-MariaDB
-- Versi PHP: 8.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dblaundry`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_laundry`
--

CREATE TABLE `tbl_laundry` (
  `id` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `alamat` text NOT NULL,
  `telepon` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tbl_laundry`
--

INSERT INTO `tbl_laundry` (`id`, `nama`, `alamat`, `telepon`) VALUES
(1, 'Kinantsa Laundry', 'Perumahan Grand Dringu Kahuripan nomor B-06 Perumahan Belakang Alfamidi, Jalan Raya Dringu Kabupaten Probolinggo', '082333848787'),
(2, 'Tutik Laundry', 'Gang Pakis Taji 2 nomor C-04 Wiroborang Kota Probolinggo', '082334678989'),
(3, 'Anin Laundry', 'Gang Kaliamas Blok C nomor A-10 Dringu Kabupaten Probolinggo', '083111766989');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tbl_laundry`
--
ALTER TABLE `tbl_laundry`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `tbl_laundry`
--
ALTER TABLE `tbl_laundry`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
