-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 06 Jan 2025 pada 12.02
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `phpmyadmin`
--
CREATE DATABASE IF NOT EXISTS `phpmyadmin` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
USE `phpmyadmin`;

-- --------------------------------------------------------

--
-- Struktur dari tabel `pma__bookmark`
--

CREATE TABLE `pma__bookmark` (
  `id` int(10) UNSIGNED NOT NULL,
  `dbase` varchar(255) NOT NULL DEFAULT '',
  `user` varchar(255) NOT NULL DEFAULT '',
  `label` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `query` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Bookmarks';

-- --------------------------------------------------------

--
-- Struktur dari tabel `pma__central_columns`
--

CREATE TABLE `pma__central_columns` (
  `db_name` varchar(64) NOT NULL,
  `col_name` varchar(64) NOT NULL,
  `col_type` varchar(64) NOT NULL,
  `col_length` text DEFAULT NULL,
  `col_collation` varchar(64) NOT NULL,
  `col_isNull` tinyint(1) NOT NULL,
  `col_extra` varchar(255) DEFAULT '',
  `col_default` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Central list of columns';

-- --------------------------------------------------------

--
-- Struktur dari tabel `pma__column_info`
--

CREATE TABLE `pma__column_info` (
  `id` int(5) UNSIGNED NOT NULL,
  `db_name` varchar(64) NOT NULL DEFAULT '',
  `table_name` varchar(64) NOT NULL DEFAULT '',
  `column_name` varchar(64) NOT NULL DEFAULT '',
  `comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `mimetype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `transformation` varchar(255) NOT NULL DEFAULT '',
  `transformation_options` varchar(255) NOT NULL DEFAULT '',
  `input_transformation` varchar(255) NOT NULL DEFAULT '',
  `input_transformation_options` varchar(255) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Column information for phpMyAdmin';

-- --------------------------------------------------------

--
-- Struktur dari tabel `pma__designer_settings`
--

CREATE TABLE `pma__designer_settings` (
  `username` varchar(64) NOT NULL,
  `settings_data` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Settings related to Designer';

-- --------------------------------------------------------

--
-- Struktur dari tabel `pma__export_templates`
--

CREATE TABLE `pma__export_templates` (
  `id` int(5) UNSIGNED NOT NULL,
  `username` varchar(64) NOT NULL,
  `export_type` varchar(10) NOT NULL,
  `template_name` varchar(64) NOT NULL,
  `template_data` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Saved export templates';

-- --------------------------------------------------------

--
-- Struktur dari tabel `pma__favorite`
--

CREATE TABLE `pma__favorite` (
  `username` varchar(64) NOT NULL,
  `tables` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Favorite tables';

-- --------------------------------------------------------

--
-- Struktur dari tabel `pma__history`
--

CREATE TABLE `pma__history` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `username` varchar(64) NOT NULL DEFAULT '',
  `db` varchar(64) NOT NULL DEFAULT '',
  `table` varchar(64) NOT NULL DEFAULT '',
  `timevalue` timestamp NOT NULL DEFAULT current_timestamp(),
  `sqlquery` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='SQL history for phpMyAdmin';

-- --------------------------------------------------------

--
-- Struktur dari tabel `pma__navigationhiding`
--

CREATE TABLE `pma__navigationhiding` (
  `username` varchar(64) NOT NULL,
  `item_name` varchar(64) NOT NULL,
  `item_type` varchar(64) NOT NULL,
  `db_name` varchar(64) NOT NULL,
  `table_name` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Hidden items of navigation tree';

-- --------------------------------------------------------

--
-- Struktur dari tabel `pma__pdf_pages`
--

CREATE TABLE `pma__pdf_pages` (
  `db_name` varchar(64) NOT NULL DEFAULT '',
  `page_nr` int(10) UNSIGNED NOT NULL,
  `page_descr` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='PDF relation pages for phpMyAdmin';

-- --------------------------------------------------------

--
-- Struktur dari tabel `pma__recent`
--

CREATE TABLE `pma__recent` (
  `username` varchar(64) NOT NULL,
  `tables` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Recently accessed tables';

--
-- Dumping data untuk tabel `pma__recent`
--

INSERT INTO `pma__recent` (`username`, `tables`) VALUES
('root', '[{\"db\":\"tanipedia\",\"table\":\"kamus\"},{\"db\":\"tanipedia\",\"table\":\"tanaman\"},{\"db\":\"tanipedia\",\"table\":\"user\"},{\"db\":\"tanipedia\",\"table\":\"ensiklopedia\"}]');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pma__relation`
--

CREATE TABLE `pma__relation` (
  `master_db` varchar(64) NOT NULL DEFAULT '',
  `master_table` varchar(64) NOT NULL DEFAULT '',
  `master_field` varchar(64) NOT NULL DEFAULT '',
  `foreign_db` varchar(64) NOT NULL DEFAULT '',
  `foreign_table` varchar(64) NOT NULL DEFAULT '',
  `foreign_field` varchar(64) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Relation table';

-- --------------------------------------------------------

--
-- Struktur dari tabel `pma__savedsearches`
--

CREATE TABLE `pma__savedsearches` (
  `id` int(5) UNSIGNED NOT NULL,
  `username` varchar(64) NOT NULL DEFAULT '',
  `db_name` varchar(64) NOT NULL DEFAULT '',
  `search_name` varchar(64) NOT NULL DEFAULT '',
  `search_data` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Saved searches';

-- --------------------------------------------------------

--
-- Struktur dari tabel `pma__table_coords`
--

CREATE TABLE `pma__table_coords` (
  `db_name` varchar(64) NOT NULL DEFAULT '',
  `table_name` varchar(64) NOT NULL DEFAULT '',
  `pdf_page_number` int(11) NOT NULL DEFAULT 0,
  `x` float UNSIGNED NOT NULL DEFAULT 0,
  `y` float UNSIGNED NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Table coordinates for phpMyAdmin PDF output';

-- --------------------------------------------------------

--
-- Struktur dari tabel `pma__table_info`
--

CREATE TABLE `pma__table_info` (
  `db_name` varchar(64) NOT NULL DEFAULT '',
  `table_name` varchar(64) NOT NULL DEFAULT '',
  `display_field` varchar(64) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Table information for phpMyAdmin';

-- --------------------------------------------------------

--
-- Struktur dari tabel `pma__table_uiprefs`
--

CREATE TABLE `pma__table_uiprefs` (
  `username` varchar(64) NOT NULL,
  `db_name` varchar(64) NOT NULL,
  `table_name` varchar(64) NOT NULL,
  `prefs` text NOT NULL,
  `last_update` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Tables'' UI preferences';

--
-- Dumping data untuk tabel `pma__table_uiprefs`
--

INSERT INTO `pma__table_uiprefs` (`username`, `db_name`, `table_name`, `prefs`, `last_update`) VALUES
('root', 'tanipedia', 'user', '{\"sorted_col\":\"`user`.`password` DESC\"}', '2025-01-03 08:27:23');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pma__tracking`
--

CREATE TABLE `pma__tracking` (
  `db_name` varchar(64) NOT NULL,
  `table_name` varchar(64) NOT NULL,
  `version` int(10) UNSIGNED NOT NULL,
  `date_created` datetime NOT NULL,
  `date_updated` datetime NOT NULL,
  `schema_snapshot` text NOT NULL,
  `schema_sql` text DEFAULT NULL,
  `data_sql` longtext DEFAULT NULL,
  `tracking` set('UPDATE','REPLACE','INSERT','DELETE','TRUNCATE','CREATE DATABASE','ALTER DATABASE','DROP DATABASE','CREATE TABLE','ALTER TABLE','RENAME TABLE','DROP TABLE','CREATE INDEX','DROP INDEX','CREATE VIEW','ALTER VIEW','DROP VIEW') DEFAULT NULL,
  `tracking_active` int(1) UNSIGNED NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Database changes tracking for phpMyAdmin';

-- --------------------------------------------------------

--
-- Struktur dari tabel `pma__userconfig`
--

CREATE TABLE `pma__userconfig` (
  `username` varchar(64) NOT NULL,
  `timevalue` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `config_data` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='User preferences storage for phpMyAdmin';

--
-- Dumping data untuk tabel `pma__userconfig`
--

INSERT INTO `pma__userconfig` (`username`, `timevalue`, `config_data`) VALUES
('root', '2025-01-06 09:17:01', '{\"Console\\/Mode\":\"collapse\",\"lang\":\"id\",\"NavigationWidth\":0}');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pma__usergroups`
--

CREATE TABLE `pma__usergroups` (
  `usergroup` varchar(64) NOT NULL,
  `tab` varchar(64) NOT NULL,
  `allowed` enum('Y','N') NOT NULL DEFAULT 'N'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='User groups with configured menu items';

-- --------------------------------------------------------

--
-- Struktur dari tabel `pma__users`
--

CREATE TABLE `pma__users` (
  `username` varchar(64) NOT NULL,
  `usergroup` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Users and their assignments to user groups';

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `pma__bookmark`
--
ALTER TABLE `pma__bookmark`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `pma__central_columns`
--
ALTER TABLE `pma__central_columns`
  ADD PRIMARY KEY (`db_name`,`col_name`);

--
-- Indeks untuk tabel `pma__column_info`
--
ALTER TABLE `pma__column_info`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `db_name` (`db_name`,`table_name`,`column_name`);

--
-- Indeks untuk tabel `pma__designer_settings`
--
ALTER TABLE `pma__designer_settings`
  ADD PRIMARY KEY (`username`);

--
-- Indeks untuk tabel `pma__export_templates`
--
ALTER TABLE `pma__export_templates`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `u_user_type_template` (`username`,`export_type`,`template_name`);

--
-- Indeks untuk tabel `pma__favorite`
--
ALTER TABLE `pma__favorite`
  ADD PRIMARY KEY (`username`);

--
-- Indeks untuk tabel `pma__history`
--
ALTER TABLE `pma__history`
  ADD PRIMARY KEY (`id`),
  ADD KEY `username` (`username`,`db`,`table`,`timevalue`);

--
-- Indeks untuk tabel `pma__navigationhiding`
--
ALTER TABLE `pma__navigationhiding`
  ADD PRIMARY KEY (`username`,`item_name`,`item_type`,`db_name`,`table_name`);

--
-- Indeks untuk tabel `pma__pdf_pages`
--
ALTER TABLE `pma__pdf_pages`
  ADD PRIMARY KEY (`page_nr`),
  ADD KEY `db_name` (`db_name`);

--
-- Indeks untuk tabel `pma__recent`
--
ALTER TABLE `pma__recent`
  ADD PRIMARY KEY (`username`);

--
-- Indeks untuk tabel `pma__relation`
--
ALTER TABLE `pma__relation`
  ADD PRIMARY KEY (`master_db`,`master_table`,`master_field`),
  ADD KEY `foreign_field` (`foreign_db`,`foreign_table`);

--
-- Indeks untuk tabel `pma__savedsearches`
--
ALTER TABLE `pma__savedsearches`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `u_savedsearches_username_dbname` (`username`,`db_name`,`search_name`);

--
-- Indeks untuk tabel `pma__table_coords`
--
ALTER TABLE `pma__table_coords`
  ADD PRIMARY KEY (`db_name`,`table_name`,`pdf_page_number`);

--
-- Indeks untuk tabel `pma__table_info`
--
ALTER TABLE `pma__table_info`
  ADD PRIMARY KEY (`db_name`,`table_name`);

--
-- Indeks untuk tabel `pma__table_uiprefs`
--
ALTER TABLE `pma__table_uiprefs`
  ADD PRIMARY KEY (`username`,`db_name`,`table_name`);

--
-- Indeks untuk tabel `pma__tracking`
--
ALTER TABLE `pma__tracking`
  ADD PRIMARY KEY (`db_name`,`table_name`,`version`);

--
-- Indeks untuk tabel `pma__userconfig`
--
ALTER TABLE `pma__userconfig`
  ADD PRIMARY KEY (`username`);

--
-- Indeks untuk tabel `pma__usergroups`
--
ALTER TABLE `pma__usergroups`
  ADD PRIMARY KEY (`usergroup`,`tab`,`allowed`);

--
-- Indeks untuk tabel `pma__users`
--
ALTER TABLE `pma__users`
  ADD PRIMARY KEY (`username`,`usergroup`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `pma__bookmark`
--
ALTER TABLE `pma__bookmark`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `pma__column_info`
--
ALTER TABLE `pma__column_info`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `pma__export_templates`
--
ALTER TABLE `pma__export_templates`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `pma__history`
--
ALTER TABLE `pma__history`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `pma__pdf_pages`
--
ALTER TABLE `pma__pdf_pages`
  MODIFY `page_nr` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `pma__savedsearches`
--
ALTER TABLE `pma__savedsearches`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- Database: `tanipedia`
--
CREATE DATABASE IF NOT EXISTS `tanipedia` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `tanipedia`;

-- --------------------------------------------------------

--
-- Struktur dari tabel `detail_transaksi`
--

CREATE TABLE `detail_transaksi` (
  `id_detail_transaksi` int(11) NOT NULL,
  `id_order` int(11) NOT NULL,
  `kuantitas` int(11) NOT NULL,
  `produk` varchar(16) NOT NULL,
  `alamat` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `ensiklopedia`
--

CREATE TABLE `ensiklopedia` (
  `id_ensiklopedia` int(11) NOT NULL,
  `id_tanaman` int(11) NOT NULL,
  `panduan_budidaya` text NOT NULL,
  `penanganan_hama` text NOT NULL,
  `foto_ensiklopedia` longblob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `hama_penyakit`
--

CREATE TABLE `hama_penyakit` (
  `id_hama_penyakit` int(11) NOT NULL,
  `nama_hama_penyakit` varchar(16) DEFAULT NULL,
  `Deskripsi` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `kamus`
--

CREATE TABLE `kamus` (
  `id_kamus` int(11) NOT NULL,
  `nama_istilah` varchar(16) NOT NULL,
  `penjelasan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `kamus`
--

INSERT INTO `kamus` (`id_kamus`, `nama_istilah`, `penjelasan`) VALUES
(12, 'sdasdsadsds', 'sdasdsa'),
(13, 'abiabyu', 'abiabyu'),
(14, 'abiabyu', 'abiabyu'),
(15, 'padi', 'padipadipadipadipadi'),
(18, 'imam', 'imamimamimamimamimam'),
(19, 'imam', 'imamimamimam'),
(20, 'sdasdsadsds', 'imamimamimamimamimam'),
(21, 'sdasdsadsds', 'imam'),
(22, 'sdasdsadsds', 'bayyu');

-- --------------------------------------------------------

--
-- Struktur dari tabel `order`
--

CREATE TABLE `order` (
  `id_order` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `Total` int(11) NOT NULL,
  `Tanggal` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `penanganan_penyakit`
--

CREATE TABLE `penanganan_penyakit` (
  `id_penanganan_penyakit` int(11) NOT NULL,
  `id_tanaman` int(11) NOT NULL,
  `id_hama_penyakit` int(11) NOT NULL,
  `id_pestisida` int(11) NOT NULL,
  `cara_penanganan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `pestisida`
--

CREATE TABLE `pestisida` (
  `id_pestisida` int(11) NOT NULL,
  `nama_pestisida` varchar(16) DEFAULT NULL,
  `harga_pestisida` int(11) DEFAULT NULL,
  `jenis_pestisida` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `pupuk`
--

CREATE TABLE `pupuk` (
  `id_pupuk` int(11) NOT NULL,
  `nama_pupuk` varchar(32) DEFAULT NULL,
  `harga_pupuk` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `tanaman`
--

CREATE TABLE `tanaman` (
  `id_tanaman` int(11) NOT NULL,
  `nama_tanaman` varchar(32) DEFAULT NULL,
  `jenis_tanaman` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tanaman`
--

INSERT INTO `tanaman` (`id_tanaman`, `nama_tanaman`, `jenis_tanaman`) VALUES
(11, 'Strawberry', 'Tanaman Buah'),
(12, 'Kelapa', 'Tanaman Buah'),
(13, 'padi', 'Tanaman Pangan'),
(14, 'sasad', 'Tanaman Sayur');

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `password` varchar(16) DEFAULT NULL,
  `username` varchar(16) DEFAULT NULL,
  `nomor_hp` varchar(16) DEFAULT NULL,
  `email_pengguna` varchar(30) DEFAULT NULL,
  `alamat_pengguna` varchar(100) DEFAULT NULL,
  `nama_usaha` varchar(20) DEFAULT NULL,
  `Image` longblob DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`id`, `password`, `username`, `nomor_hp`, `email_pengguna`, `alamat_pengguna`, `nama_usaha`, `Image`) VALUES
(3, 'perkasa23', 'perkasa23', '081222965874', NULL, NULL, NULL, NULL),
(6, 'abibayu', 'abibayu', '081222965873', 'Graha Rancamanyar', 'abibayu83@gmail.com', 'Tani Bayu', 0x89504e470d0a1a0a0000000d4948445200000200000002000806000000f478d4fa000000097048597300000ec300000ec301c76fa8640000001974455874536f667477617265007777772e696e6b73636170652e6f72679bee3c1a0000200049444154789ceddd79bc1f557dfff1576e36b61092b0af615176904576010515aa588b226ed8ba616dab586deb4ffbab5a6dd55a6acbcf8a5bddd0aaa0a8155770434114d96447b6b06f09212cd993fbfbe3736fbd849b9bfbbd7366ce99efbc9e8fc7fb91487be77bcee4cecce73b73e61c902449922449922449922449922449922449922449922449922449922449922449922449922449922449922449922449922449922449922449922449922449922449922449922449922449922449922449922449922449922449922449922469dd26e56e8094d934604b600eb0d9d09f73804d47fc7d3800d3810d86fe3e0398020c003387fedb5260c9d0df1f05560de5d1a1ffb6185800cc071e1afafb8211ff6d01f000b028692f25690d1600ea8259c04e6bc90ec0e47c4d5baba5c0bdc06da3e4162c1024556401a07e3109980bec03ec3df4e73ec0cec4b7f47ef320703570cd883faf230a07495a270b00b5d164e2e27e30b0efd0dff70236ced9a802ac046e268a81df01570097e0dd0249a3b000501b6c08ec071c0e1c31f4e7acac2d6a97db808b818b86febc2e6f732495c00240259a053c17781671b1df87329fd3b7d5bd442170317001707ddee648cac10240a5d8137821702c701430356f733ae57ea210380f381f1f19489d6001a05c6603c71017fc1700dbe46d8e86ac047e4314033f26c6110c666d9124a9f56601af212e2ecb890b8b293b77006710632ffcc220491ab74df0a2df2fb99d3f1403925ace8a5e759801bc18389918cc372d6f735483eb817380af0137656e8b2429b303804f018f91ffdbaa692e9701a712af6b4a923a6263e2e43f3c58cc74378b8802703f24497d6bf8dbfee3e4bff098f2327c57600692a4d69b460ce8bb8afc1718d38e2c024e07b64392d43a3380d3803bc97f4131edcc2ae24d90839124156f07e0c3c042f25f404cffe422e0047c0b49928ab32ff0556005f92f16a67f732df067f4e772cd92d42abb036711d3c1e6be3898eee47662c0a00b3e4952c3e61223fabdf09b9cb99e18646a21204935db9eb8f07babdf94946b8193708c802425b7057026b08cfc277b63d6964b81e72049aa6c2af13adf23e43fb91b33de9c07ec8c2469428e05ae23ffc9dc98896439b112e14c2449e3b22bf03df29fc08d4991f9c45d2c070a4ad25acc06fe1307f899fecc65c01148929ee424e001f29fa48da933ab89792b6623a967be66d35fb6033e01bc2077433a6631f146c5b059b91ad251f7027f057c2b7743a436b100e80f03c05f001fc4e5572762397017300fb81f58403c6b5e30948786fe7c8c581701e2d1cae3ebd8ee5460a3a1bf6f006c0ccc19914d81cd46fcefb9c08ef86f3851e7026f01eecbdd10a90d2c00da6f0fe033c061b91b52b8c5c45b10d71117fadb87328ff806b92a57c34631b218983b945d817d80cd7335aa251e01fe16f82cf19840d25a5800b4d714e05dc0df03d333b7a52483c485fd6ae09aa13f7f07dc4a3c336ebb2d8842601f60efa13ff7c0df8135fd0c782d7047ee8648524a3b00bf20ff20ac12b29c18117e0631f871d30afbb5ada6000710afc79d455cf472ffbb949045c02915f6ab2415e514e2c496fbe49a2b8f02df06de0e1c423c67d7533d0df853e0bf88c71cb9ffdd72e6cb388190a416db18f812f94fa639722bf10dff58bcd53d513b114bee9e072c21ffbf69d3b90338b2f25e94a4861d49b7bec52d06be09bc01d8b6faeed31a36044e201684ba87fcffde4d6525f07ee2918924156d3271c25a49fe9367dd594adcda7f25be06d7a401a2c0fc4fe215c8dcbf074de41262296c492ad21ce087e43f59d69995c045c4ad699fd1e637404caf7b06fd5f0ccc079e9766b749523afb13afb2e53e49d695eb80b711458eca3405f863e0bbf4ef1da895c0ffc1d7a12515e2d5c013e43f39a6ce12e01c62209f27dc76d91a7827701bf97f8feac877804d92ed2d49ead134625056ee9361eafc8e98a6d85bfced3700fc1131e77ebfdd15b801d83dddae92a4f1d91af815f94f82a9b21af801f16d5ffd6967e063c47a08b97fdf52e551e025297792248d652ffa67e6b665c44c747b25dd432ad94c6206c2bbc9fffb9722ab81f7a5dc4192349ae713df3a729ff4aa6621f0cfc05669778f5a643a316fc30de4ff7d4c914fe17c01926af23a621efbdc27ba2a791cf830302bf1be699b0d887d309c2e1b20d664b889fcbf9f5573018e5d511f733476f32601ef1d4a5b2d26e698ff20f040e6b6a43295981c66eed09f9b130b0bcd59239b1213344d05365ac73657104512c49d9ef943593094e1bfdfc31f96265e94a63bd90d10cfd33f448c1768ab6b81170077e66e88949a0540b3a6039f2366bb6ba3e5c0178867a4f7656dc9c44c222ef0fb10e3149e3ef4bfe702db1017f6dc16f28762e036e07a6249e3eb88d912db662ab12cef7b887ddc46f7012f04aec8dd1049ed3413f825f96f6b4e24ab81af00db25df2bf5195e22f7cf814f0017d3ee55145710c5c0d9c0bb89d7f1daf4eefafa44bb1f23ffbe9c481e058e49be5724f5bd59c06fc87f129b482e23a6872ddd46443bdf49ac78b790fcfbae89dc4abc79712ab027e5dfd5db8a1860b78afcfbaed72c03fe24fd2e91d4afb6206ee1e63e79f59a7b898b4a09b7c547338558c4e683c4add97e9b98a6cabfdb59c02b287baae50368e71db115c02935ec0f497d6607e066f29fb47ac932e2a2baae016e396c4e8c303f8bee7cc3af9255c41d9c0f13933295f65adb24e055b46f49e295c4b806491ad58ec4edd9dc27ab5ef22be2367249b621269ab988188b907b1fb5390f11b7df8fa0ac470533891508dbf4586035b1a095243dc9eeb4eb5bcd13c4b3f3526ef7cf015e433ccbf7d67e3db98bb8e896540c1c410c74ccbd6f7ac97b6ad913925a696fe29b56ee13d378f33de2bdf7dca60227126b0878d16f363713cbe26eb9ce7fa5faad47cc2ad9a649b2fea1963d21a9557605ee27ff09693c59403c7fcd6d17625e813bc9bf4fba9e95c4ec7727917fbcc0bec0e5e4df27e3cddbebd90d92da607b62f296dc27a2f1e427c0b6b5ec85f1199e25ee27f85cbfd4cc03fe2f31f3612e5388e2b00d77845613734e48ea986d68c780bfe5c40975a096bdb06ed38967fbfdb2604c17b29478eb62f751fe3d9b7228312b62ee7db1aeac065e5fd33e9054a0cd88695a739f7cd6951b80fd6bda07ebb2395178cc1fa37da6ecac2206651e4b1e33812fafa38d256425f0b29af681a482cc02ae22ff49675df93831156bd3b601ce24be45e6de07265d2e22dfb4b8afa5fce9849701c7d5b50324e5b721f06bf29f6cc6cae3c0cbebda0163d88c987c66718fed35edca45c07368de1ec08d13686f93594c3ba6d096d4a301e05be43fc98c959b8957129b3487b8d5ff6885769bf6e522625ae626cd00be9ea0ed756601f16690a43e7206f94f2e63e5bb34bb52dc7ac0bbf0c2dff57c13d899e64c2266895c91b81f29731b310646521ff86bf29f54d696d5c4adf72647f99f403bde8030cd643951206f4c738e061e48d887d4b914d8a0aece4b6ac68b2977bef2478935e29bb23bf0c31afa61fa230f11dfce9b9a5e7a2e704d8dfda99aaf93eff55b49151d480caacb7d22192df7d2dc2b7e9b009fa41d93b398fcb98c38769ab011f0fd06fa34d17ca4beae4baacb5cca9de2f76a9a9bcbff4f886223779f4bcb12e259ef65c0b5c423915b896fc10fd3ae79edebc84ae0749ab90d3e05f844c3fdeb257f595fd725a5b63e7005f94f1ca3e57c628294ba6d059c9ba17fa5e77ce2b1cb7ae3d8871b033b010701c703af26064e7e0af811f07bfa7fbe845b696e22a1d328f371dd4ae0b935f65b52425f24ff4963b47c965841af4e938037000b33f7b5b43c019c5c61bfaecd007137e78f88d5f9be423cd7eea73b08ab81cf03b313edb3b19c44dc9dc9dde735f30079d7e290340e6f23ffc962b47ca0ce4e0fd982b29fa7e6ca7262d47993a611770ede460c26eb87c73077d3ccdd80632973ecce25c4bfaba4021d4699dfbcde5367a787bc90b25fabca997756d8af29ed442cacf4dfc45883dcfb65225905fc2bb148549d9e494cca93bbbf6be61375765ad2c46c4579dfb25613df00ebb43e3177bf4bf48e9e7b18dff3fea60d107708de474c4f5de2b3efb17225f5af36b83f65164aafabb3d3927a3315f825f94f0c23b392fa4f14fb00d717d0d79273c684f76eb3b6218ac55fd19e626e31f0a63a76c608bb138f1e72f7756496d0dc6b9292d6e14cf29f14466639f50c381be9d5c4c0b6dc7d2d3d2f9de80ece687be06f886fd9b9f7df787216f5ae5cf934e08e02fa3932b7d3cca04849633891fc2783915949bd179da9c0ff2ba09f6dc9e113dbcdc5389078edb0f4351bae0476ac691f30b4edbb0ae8e7c89c5b637f25adc3d6c07cf29f0886b31a787d8dfddd8a58c52d773fdb94a6de61afdb46c4eb9d97917f9fae2d0b80e3eada01c49d80fb0ae8e7c8d479bc4b5a8b01e002f29f0086b31a78738dfd3d8cf20639b621753fa3cee128e03b9439707015f0f7c47c1475d89bb2de0e781c970f961af7b7e43ff847e6ef6aecebc99439394a1bf23f13d8df6db11bf069cafcdd388bfade993f88b21e895c56635f25ad612fca3ae9fd438d7d2d757ad4b66425f5bfae96db66c492d2251d1383c4e3aa4d6beaf361943559d03fd7d44f49236c4059afbefd7b4dfd9c427cbbcbddbf7ec88f696e89db9cb623060c963419d6f5d43738f08f801505f4719028348faca99f928694f4cadf37a967bdf019c00f0be85f3fe5d374a308809871f0cb94339fc0fdc46dfb3abca980fe0de70e62e96d4935388a724e6abf0536aca18fb3814b0be85f3fe6c7746bc0d621c42c83b9f7fb20f018f0ec9afaf92f05f46f389faaa98f52a74d076e20ff013e48ac23bf450d7ddc02b8ba80fef573561023e8df442cf17a00b027f1ad79276073e20e4cbf98049c424c899c7bdf2f015e50531fbf5c40ff06892f28c7d4d047a9d33e4cfe837b107884188498dab6c08d05f4cf449611af5d5e03fc1cf82af041e054e079c43be9752fed9cd246c0e9c4b3eadcfbb58e89b2d6a39c39327e4fbd33234a9db21f650cf659463c86486d27626ad1dcfd33bdff3e5c097c9198baf7b994ff0cf840e02af2eeb795c4aa88a96d0adc92b96fc3f9600dfd933a670ae5cc7ef61735f46f17ca5becc44c3cab88bb069f246ebdcfa53c53817791f7b5c155c4cc86a9ed46197304ac2056339454c13bc97f300f12cf1853db1e985740df4cbdb909f80fe0f994b534f1aee41d70ba0a78650dfd7a79c63e8dcc95c417184913b00bb1e468ee03f90ad23fd3db8a785698bb6fa6d93c017c9bb8f06d447e5389dbd5b9c606ac00fea4867e7d34537fd6cc3b6ae89bd409df27ff01bc8078469fd2a6c0b505f4cde4cd62e01bc4a0b8e9e47514f996dc5d4adc1d49690a317833f7bff113c4044d927af002f21fbcab80e313f76b13e0f202fa66caca43c0bf11cfb073d904f81679faff04e907d86e41194b087f3171bfa4be369532def97f4fe27e4da78c6f25a6ecfc8258002ac7f3e349c400c11c8f041611abfda57418f9df205a4d7d33214a7de7afc97f12be88b453c74e225648cbdd2fd39edc4e0c82cdf16ae1d1c0033db43555ee26e6c448e9bd19fab1662ea1be2592a5be319bfceb7d3f42fad7b73e90b94fa6bd59480cd49b43b3e61203609beeefe5a41d2039401977de5e9db04f525ffa24f90fd45725eed36b0be893697f1e2366c46cf28ec086c0ff24eec778f27dd23e02d90e7838433f46e66eea593f44ea0b7b92ff79dd3989fb740c652dcf6ada9f05c473faa6a69b9d0c7cace63e8d968f27eec7ab33f461cdbc3f719fa4be7101790fcedb819909fbb30331ba3bf749c7f467ee22a6d46dead9f269c49b314df6f14d89fbf0df0db77fcd2cc6d702a5a7389abc07e66ad2be86b401311358ee8b84e9ff5c48ac97d18497106b2034d5b7a5c0c109db3f93fcaf067e32617fa4be7021fd75507e3e737f4cb7b28a588bbe89d9058fa3d9193aef2566ce4c25f71c23cb493fb998d45ac791f780bc97b403abde9ab93fa6bbb99d58aeb86ecf22dedb6faa5f3f25eda0c0731a6cfb68f95cc2be48adf66bf21e8c2f4ed8972370d09fc99fcf93763ccb680ea6d991f5a7276cfb16e47ddd7825b11893d4697f4cde1365ca51ffb3c9ff7cd198e1dc0e1c4ebd0e20e6cd68a23fab8117266cfbeb1a6af7da52c70aa3526b4c22ef40b94780ad13f6e76b19fb62cc685949cc1d3095fa1c42cc51d0447f1e04b64cd4ee49c0f90db57bb4ac02f649d417a9754e22efc9f18d09fb92fbdb843163e522d216bb6b3a0658d2505fbe4fba571f776eb0dda3e5eb89fa21b5ca24e06af21d7857105384a6b033f068c6be18339e3c083c87fa3c9f786daf89bebc2561bb3fd4509b47cb6a608f847d915a21f7c8ff2313f5632a7069e6be1833de2c2726f4a9cb6b888b5addfd5802ec95a8cd1b01f734d0e6b5e5bf12f5436a8d9cb3fe9d9db01fefcbd80f63269acf51dfb880f736d487ab12f6e1cf1a6af368594ada790ea4a2ed4333df1246cb12d2adf4b71bcdddf23426757e423d0b0b4d02bed0501fde9da8cd03c06f1a6af368f9a744fd908af725f21d68a916e318002eced80f6352e43a62cd8ad4a6d2cc5dbea5c0ee89da7c28f9be983c4c33b3384a596d43be8972ee21dd729ca765ea8331a9732fb112676ab3809b1b68ffcf49f756c0571a68efda927260a354a48f90ef007b73a23eec4073ef3d1bd3441e26eda23bc3f6061e6fa0fda7266aef2ee4fb82721b69a73b968a320358489e83eb0e607aa27efc20531f8ca9338f50cfcc81af6ca8eda906d2fd5703ed5d5b4e4ad407a9387f41be03ebf589fa907bea6263eacce3c4d2dca99dd140dbbf98a8ad3bd0ec92c7237361a23e48c5b9823c07d5cda4795d683acd3cd33426671e25a6f74d692af50f9a5d0d1c94a8bd1fafb9ad6325d5a046a9180791ef807a75a23ebc33631f8c69328f100bfda4b423f52f217c096906046e052caeb9ad6bcbbf2668bf5494cf90e760ba8934036bb6a0d9f5cf8dc99d0749ff6df4d50db43b55c1ffef0db475b43c44baf14a527633c8376afe5589faf0d94ced372667ee225edd4de9bf6b6ef3dda479dd774bf22d14f4b204ed978a702af94e5e299efdef4b2cdd99fb646c4c8efc9674f36700cc046eafb9cdef4dd4d65c772ecf4fd47e29bbdf92e7207a47a2f6ff4fa6f61b534abe0b4c269d6753efac7b8b80d909dab92b798affd5c42aa352abed439e13d622e29b4655cf24dff4a0c694948f92d6e76b6eef8712b5f3bc9adbb9b6b83e805aef3fc873f09c9ea8fd3fccd47e634acc9f92ce6ce0fe1adbfa383178b7aaa36b6ce358b99374531c4b8d1b2006e4347de02c07b64fd0fec333b4dd9892b318d88f745e5e737bff2d513b7f5d733bd7963a6666941a7124790e9a2f276aff4f33b5df98927333699711fe5e8d6d5d0c6c9da08d75172a6bcbff4bd076298b33c973d01c9aa0ed47646abb316dc8d749e769d43bf56e8ab10b538855139bdecff79176f0a5d488c9d4fb7c6f6db93e51fbbf9da1edc6b429af239d7fadb19d8f92e68ec5876b6ce358392a41dba5461d4b9e83e5b4046d7f3abef76fccbaf238f19a5c0a33886fbb75b5f5ef12b47127f2bc11746682b64b8dfa34cd1f284b814d13b4fd1319da6e4c1b73296926db0278638dedbc1b9896a08d39c6053d489ae9cca5464c217e699b3e50520cfedb8c7c8b8018d3c6bc9b340680ab6b6ce76b12b4f11535b66fac1c9ba0ed52239e4b9e83e4a8046d7f5fa6b61bd3d62c25dda24127d6d8ceaba9fe5efd74607e8d6d5c5b3e51b1dd526372aca27513d50feea9d4fb1cd2987ecd85a499b4661270798ded3c3a411b739cdfee48d06ef58181dc0d1887e3337ce6578903a58a138815c024f5e64862d1afaa0681f724d8cedabc21c136be92601bbdda1ed823c3e74a3dd9913cdf40521c1c4efb6bccc4f3306906e1025c52531b97906691a09b6b6adf58797b8276abe54abf0390e3dbff35547fff7f2e317641d2c4cc22c6d0a4f08144db59d37ac02909b6f38d04dbe8558e73ab0a6301f054e724d8c6eb297fdf4aa5fb7360ef04dbf901f0bb04db194d8ac7006727d846af8e0436caf0b9d2b84c071ea3f95b63bb556cf714f22c5a644c3fe67cd2786d8d6d4c315df8f535b66f6d392141bbd562257f4bcd51a15e09dc58711bcf05b649d01649713ca5789cf615e2ad9c3afc59826de4780c705c86cf54414a2e0072fc72a65894e4e509b621e90f3e48f5d70297011f4bd096d19c48f5190c533c7aec95e30054ac2b69fe9658d5e78dd3818519da6d4cbfe78554379b18b95f47fb9e9fa07db7d5d4b6b1b27d8276aba54abd03b011b057c39f7937706dc56d3c9fb46b9b4b0aefa7fa5d8087817313b465342727d846aaf10ebd3822c367aa10a5160087d2fc8215c3efed57f1b2140d91f414fb91e62ec067126c63342fa6fa02413f48d1901e1d9ee1335588520b801cbf94550fbef57054ad54a7bf49b08d0b811b126c674db380e755dcc68f89b10a4db200e8300b80b012f849c56d1c076c9ca02d92467724705082ed7c3ec13646f3d28a3fff0470718a86f4606f6066c39fa9429458004c060e6ef8332f061655dcc61fa56888a431a5b80b701651f4a7761cd5cfa93f4cd1901e0c008734fc992a448905c03ec08c863f33c541e73bb552fd4e24a6daaee201e067d59bf2145b00fb57dc86e300d498120b801ca3527f5ef1e7f702b64bd00e49639b4c4cb55d555defdd57fd22701df0608a86f4c002a0a34a2c009abe1db5949873a00a27d4909af37aaabf25742eb03c415bd654b5001824562f6cd2c14461a58e29b1007846c39f7729d547de5a0048cdd98aeac7dc42aa0ffc1dcd21545f22b8e981801b02bb34fc992a406905c074e0e90d7f66d5836d06de42939af6c604dba8e331c064e0d88adb68ba0080187ba58e29ad00d893e62700aa7ab01d46f5094024f5e67860f38adbf81eb03a415bd67474c59fbf9c7834d9a414cb2eab654a2b009aae42533c6ff3dbbfd4bc29c4ec7b553c045c91a02d6baa7a4e58065c96a2213db000e8a0d20a80a67f096f20e607afc20240ca23c5fcfb75bc77bf17d5d704b92845437ae023800eea7a01f0db8a3f3f8534339349eaddd1c0d615b751c77bf72926d7a97a6eead58e343fff8a322bad00d8b7e1cfbbbae2cfef4bac5c28a97903c01f57dcc66fa87e17703455ef0c563d37f56a123e06e89c920a802da93ea8a757550f326fff4b79559d827b15b140506a55cf0db7018fa768480f7c0cd031251500bb67f8cc6b2afebc73684b793d9b787db88a3a5ebb3b886a93ebac2666056c528e73b0322aa900d8b1e1cfbb9f9813bc8aa61f59487ab20d816755dc461d03ee360476aeb88da61f03347d0e5666251500731bfebcaa07578e498b243d55d55901af0016a768c81aaade52af7a87b257731bfe3c65565201d074f559b500d883e6272d92f454c754fcf915d433eabeeaa0baa6ef00cc6df8f394594905c0dc863feffa8a3fef8019a90c7b03332b6ea38e0578aa9e23ae4dd28af19b016cd6f0672aa3920a80a6ef00dc5af1e77dfe2f95610038b4e2367e97a2216ba87a076001b02845437ab043c39fa78c4a2900a6112b7c35695ec59ff79d59a91c25be77bf13d5e7099997a01dbd70206087945200ec40b36d5901dc53711bbba66888a424aa1600bf27fd023c9380a755dcc6ed291ad2030b800e29a50068fa97ee4e620290899a4af5294825a5b33f71c19da895541f17349ab9157fbee902606ec39fa78c4a2900b669f8f3e655fcf91da836c987a4b46602db55dc461d8f01aa7eb969ba00d8b6e1cf5346a514004d8f3cad7a50cd4dd1084949551d757f6392563c59d502605e8a46f460d3863f4f19955200cc69f8f3e655fc799f9349e5a93a30775e8a46ac616ec59f9f97a00dbdb000e890520a80a67fe9aa0e009c9ba2119292daabe2cfd771bbbdea9785aae7aa5e35fd654c1975b5005850f1e77d57562a4fd5b9f7eb2800e656fcf985c400c5a6ccc2194e3ba39402a0e9aa737ec59fdf32492b24a554f5dbf643a45f8277c3a14cd42051043465125104a8034a29009abe0350b500989da4159252da9c6a175ba8e7997bd5f35bd5f355af1c07d011a514004ddf01a8fa08c0f9b2a532cdadf8f35597081f4dd5f35bd30580e3003aa284026080666f39ad021ea9b80def0048659a5bf1e7ebb8d856fd465df50b4bafbc03d0112514001bd1eca43a0b81d5157e7e83a1482a4fd5bb73755c6cdb7607a0eaca8a6a89120a80e90d7f5ed503dcea582a578917dbb6dd0168fa9cac4cba58002caef8f39b246985a43a9478b1adfa8833f52245eb32ade1cf53262514004dffb22daff8f3eb256985a43a54bd03f07092563c59d573c6b224ad183fef007444090540d3bf6c550b000f0ea95c55bf6d2f49d28a27ab7acea87aceea9577003aa28402a0e95fb6aad5b4058054ae122fb655cf71de01502d4a2800da7607c0ea582a57890540d536355d00788eeb88120a80b68d01f0e090ca55e2b7edaa6df211806a514201d0f41d001f0148fdabc46fdb25b6692c9ee33aa28402a0c94980206602aca2e9f64a1abfaa93740d2669c5934dadf8f32b92b462fcaab6572d514201d0b65feea6db2b69fcaaaed4b95592563c59d56ff06d7b4caa9628a10068dbf32d0f0ea95c9b03db55f8f90352356484b6bd7adcf4230765524201d0b611ae1e1c52b926012f9de0cf0e002f49d8966116002a52090540d3dfa84b7c4d48523a7f472c32d6ab5701bb256e0bf80840852aa10068db1d000f0ea96c5b025f24ee068cd78ec047eb694eebde3cf21cd7112514006d1b03e0ed31a97c271245c078e6e1df0ff839f5adf4d9b6b9473cc77544170b80aad574d5d5042535e314e02ae064463feeb7014e077e056c5f633baa9e33bc03a05a4cc9dd009aaf3637acf8f375ac1626a91ebb025f031e037e03dc4b9c0376029e416f8f0926aaea12c355cf59bdb200e888120a80a6d7baae7a9b6f3e31594813270e4969cc008ecdf4d9f32bfe7cd5258e7bd5f439599994f008e0719aad3867526d32a015c4b709491a8faa05c066495a317e55ef58a8254a2800a0d95fb849c0ec8adba87a404bea8eaae7b7ba0627ae8d05404774b10080ea07940788a4f16adb2300bfe07444290540d3bf70550f280b0049e35575e0b07700548bae1600550fa8fb92b44252bf5b48b5379da610e3969ab21258d4e0e729a3520a80b63d02b823492b24f5bbdb2bfefc6c9a7de3e861ea591259052aa50068fa0ec0b6157fbeea412da91baa9e2bea9ca068340f35fc79caa89402a0e93b00732bfebc0580a4f1a87aae989ba2113df0f97f87945200347d0760c78a3f3f2f452324f5bd79157f7e6e8236f4c237003aa48677c55100001c15494441549402e0ce863f6f6ec59fbf0717cc90b46e55ef0054fdb2d2aba6cfc5caa89402a0e95bea5b536d818dd578a0485ab779157fbee902c0c79b1d524a01700f31c56e5306a83eb8e686140d91d4b75600b754dc46d305c0bc863f4f19955200ac02ee6af833e756fcf9ab53344252dfba916aeb9c4ca2f9b700bc03d021a51400d0fc2fded32afefc35495a21a95f55fd92b035b0418a86f4605ec39fa78c4a2a00e635fc797b55fc79ef00481a4bd52f09fb2669c5f82dc0954e3ba5cb05c03e157ffe6660718a8648ea4b55bf24543d47f5cadbff1d535201d0f42fdf3e549b627315707da2b648ea3f550b80bd93b462fc2c003aa6a402e0b6863f6f06d507025e95a01d92facf7ce2eda62aaa3ea6ec950540c79454005c4bf38b5054bdc57649925648ea37bfaaf8f3d380dd5234a4070e6cee98920a80c768df38808b92b44252bfb9b8e2cfef4e14014db200e898920a00687e647dd5676c37030fa66888a4be52b50068faf9ff0a62de027548d70b80c32afefc203e0690f464cb80cb2b6ee3d0140de9c18db8be49e7945600347d0b6a1baacfb455b5d297d45f2e039656dcc6e1291ad2036fff77506905408ec975aa1e688e03903452d573c2c634ff0680054007955600dc42f393eb542d002e0316a56888a4bef0d38a3f7f28303945437ae0cca61d545a01b00ab8aee1cfac5a00aca0fa012fa93f2c017e59711b4ddffe070b804e2aad0080e627d7d99b9814a88a1fa66888a4d6fb19510454d17401301fb8bbe1cf54014a2c009a1e54371938a4e236be9fa221925aef07157f7e0a70708a86f4a0eaa4456a290b80f09c8a3f7f37cd3fba90549eaa77030f01364cd1901e3890b9a34a2c006e01ee6ff8338f4fb08daa95bfa476bb8d387f55715c8a86f4c802a0a34a2c00a0f9c975f621e604a8e2bb291a22a9b5be93601b29be8cf462197045c39fa942945a0034fd186012f0fc8adbf825706f82b6486aa7b32bfefce6c0335234a40797e20c809d556a0190e39654d5ca7b35706e8a86486a9dbb80df54dcc6f1347f4e7626d30e2bb500b882e627047a1e30b5e236aa7e0390d44e5fa3fa72e6399eff5b007458a905c00a6286bd266d4cf5d7017f05dc91a02d92dae59c8a3f3f19786e8a86f4c0c5cc3aaed40200e027193ef345157f7e101f03485d731bd557ff3b1c9893a02dbdb80a58d0f067aa20251700395eab3b99181058858f01a46e4971fbffe5291ad2235f5deeb8aa17bb3a0d00f71123639b7418d56f8b5d05ec9ba02d92ca3608ec0adc5c611b93817b802d92b468fc8ea4faba056ab192ef00ac06cecff0b92727d8c6e7126c4352f97e4eb58b3fc0d1347ff17f14f875c39fa9c2945c00409e45765e46f5a538cfa2f9b7182435ef3309b691e24b47afce27065babc34a2f007e44dc0968d256545f8deb11e09b09da22a95c0f03dfaab88d29c08b13b4a557ae60aae20b80f934ff3a20c45d80aa527c339054ae2f014b2b6ee35860b3046de9558ec7ab2a4ce90500e4596af765c0b48adbf825706382b6482a538a22ffd509b6d1ab6b88990bd5716d2800be97e13337a3fa6db941e08c046d91549ef3a9be04f82ce02509dad2ab1ce75415a80d05c065545f627322de98601b5f001e48b01d4965f9b704db3805582fc1767ae55c2502da5100007c23c3671e03ec52711b4b814f26688ba4725c035c90603baf4bb08d5edd4acc5322b5a600c851b14e025e9b603b1f079624d88ea4329c4ef599ff0e21cf64615fcdf0992a545b0a80ab801b327ceeeba8be42e043c4bc0092daef1e62eadfaa523c629c086fffeb7fb5a500803c8bec6c09bc30c1763e0aac4ab01d49799d012cafb88d19a479d5b8573700d766f85c15aa4d0540aecaf5af126ce3f778eb4d6abbf9a419d3f37a60a304dbe9558a3b175236d712cfde9ace4109dabe0b31f5668ef61b63aae7ed543799188897a3fdbb2768bffa489bee0040bebb00a725d8c62d3816406aabfb48f3edffa5c04e09b6d3ababc9338e4a4a663b6025cd57ce2b801d12b47f07e2d5c0dcdf648c31bde52f49e3d799da9fe24b8cfa4cdbee00dc459e39aca7006f4db09d3b70a960a96dee04fe2bc1768e060e4eb09d5e2d03fe3bc3e7aa706d2b0020df223b6f043649b09d7fc6a582a536793f7111adea1d09b63111e7120318a527696301701ef13cae69338053136ce71ee02309b623a97e5711537a57b507f08204db998814772fa4627c903ccfd11e220a81aad607e665ea833166fc398a34ceced4fe5b88594da5a768e31d0088c700ab337ceea6c05b126c6709f07f126c47527dce012e4cb09dbd88d1ff397c9a2804a4bef263f254d40b89653c53b830531f8c31636731309734be9da90f2b80ad12f5417da8ad7700202adb1c3601de96685b6f23cf9d0c49633b9d784c57d581c08b126c6722be439ef15252eda690ef39fa63c06689fa7166a63e186346cf6dc086a4f1fd8cfd7856a23e48457a3bf90eae0f25eac3c6c4fc06b94f7ac698c8f348e3b08c7db834511fa4626d0c3c429e03ec7160db44fd7841a63e18639e9c2f92c624e09719fb7152a27e4845fb08f90eb22f27ecc73919fb618c89d77c533dda7b79c67edc463c2295fade36c42c5d390eb4d5c01189fab125b020533f8c31f04ad2c83dcf478a25cca5d6388b7c07dbe5a47b9be24f33f6c3982ee7bba4f39e8cfd58006c94b02f52f1f626be8de73ae8fe34615fbe96b11fc674310f1277e052d886181f94ab2f1f48d40fa9557e44be83ee5ed255dd9b10ab06e63e291ad385ac064e209d2f67eccb12d2153252abe47ce56610f897847d39125899b93fc67421ff493a4790f74ee47f24ec8bd43a3f20dfc1b702d83f615ffe25635f8ce942ae2306eca5306d687bb9fab218d83a515fa4563a80bc15f855c0d4447d99460c30cc7d9234a61fb314d89774fe31737f5c625c22dfc21bc3f99b847dd981783739f7c9d2987ecb1b486737a2a0c8d597c780cd13f6476aadbd8055e43b181703bb24eccf73713c8031297316e90c001765ee8f23ffa511ce26ef01f933622ad05472be576c4c3fe54ad23df707786be6fe3c02cc4ed81fa9f57627ffb7e694b7182701e766ee8f316dcf026047d2990b3c9ab94fef49d81fa96f7c9ebc07e663a47d14b009f0fbcc7d32a6ad59493c4e4b6532f96ffd3f402c8826690d5b008bc87b805e46bab7020076c64181c64c246f21adf716d0a73726ee93d457de45fe8334f5009d679177c4b1316dcb4749eb99c0f2cc7dba92b80b21692da691ffb6f92ae0e8c4fd3a99bcf31d18d3969c47da0be546e43fa70c024725ec93d4b74e24ffc17a17e947eafe4301fd32a6e45c066c485a5f2ca05fe724ee93d4d77e4afe83f6ec1afaf5b902fa654c89b98d180794d2ab0ae8d712e2ed0349e3b42731577fee83f7ed89fb3599fc731e18535a1e007625adbdc9bbccef709cf4479a804f92ffe05d41fa6777d380ef16d037634ac84344c19fd226c0cd05f4ed6ed22d3b2e75ca4ce01ef21fc40f00db26eedbfac4ec83b9fb664cce2c020e24ad49c0370be8db20319e49d204bd8cfc07f120f06b607ae2be6d08fcb280be1993234f004792de7b0be8db20f13683a48abe45fe837910f8440d7d9b854b089beee509e018d22b6521ae45a4bf6b2875d236c4021ab90fea41e0cd35f46f26f9a72835a6a93c063c87f476071e2ea07f83c09b6ae89fd4596f26ff413d487cbb78510dfddb0038bf80fe1953671e060e26bd4d2963d0df207021695716953a6f00f805f90fee41e21bcc7e35f4713ae53cee302675ee07f621bdf5814b0ae8df2031e5f7ee35f451eabca713936ae43ec807817b81ed6be8e3549c27c0f45fee009e467a0394b5ecf6dfd7d0474943de41fe837c385753cfd29e9380f715d03f6352e46aea299601febd80fe0de752d2ae242a690d03c005e43fd887733e31b14f1d4ea58cd9108d9968ce2706b9d6e1b402fa379cc7a8e70e87a4356c0dcc27ff413f9c6f01536aeaeb71c0a305f4d1985ef359eafb46fc1a62d5cedc7d1cceeb6beaa7a451bc98fc07fdc87c89b83b51877d89294573f7d198f16435f108ab2e2752d69db16fd6d857496bf169f21ffc23f339ea7bfd670762a9d4dc7d3466ac3c4abdd3df3e8f18699fbb9fc3b91b9853637f25adc586c08de43f098ccc1935f6773af09902fa68cc68b989f48bfa8cf41cca790b6890780451c76c8692c6e9406019f94f0623f3fe5a7b1ccf3f1717d04f6386f31dea1bec07701831d02e773f47e62335f657d23895341a78381facb5c7700030af807e9a6e6725f1bcbfaef12f004753de40d85f51dfdb3f927af405f29f14d6cc99d47b62dc1cf86e01fd34ddcc5dc4c5b94ec753deddaefb71a11fa928eb035790ffe4b066be447daf080e7b0df078017d35ddc9b9d43ff8ed04ca7ae63f48bc7d70549d9d96343173296b7e80e17c8dfa6708db9d320b20d35f594c3c72abdb2b29eb55bfe1fc759d9d9654cd0b296b8290e17c1b58afc67e43bc25f051e23decdcfd35fd974b6966b6bb3753e631fcb53a3b2d298d7f24ffc962b45c423cb7afdbe1c0f519fa67fa334b88817e750f7a2b790d8c1ba867dd0f49890d00df23ff4963b4fc1ed8a5beaeffaff588936969af489a76e517c06ed46f3af0950cfd1b4f1e21562295d4123380abc87ff2182d0b8023ebebfa93ec0dfca6813e99feca23c4b3fe3adf6219360bf879837deb25cb89d90725b5cc36c4ab4ab94f22a3652931d0a9099381b7010b6bee93697f5613dfc4b7a2193b12b7d773f77b6d79737d5d9754b7fd296f06b19127db7753dffa016b9a4d4c55bcb2c63e99f6e672e05934e708e0c11afa912aff5c5fd72535e578ca7ca56838df0136a9adf74fb53bf0c31afa61da998788dbfd9369cea9943d3ee56c9a2bcc25d5ec8de43fa98c959b80bd6aebfde85e02dc9ca0eda69d590c7c98182fd394f580cf26ee47eafc82189498d23b807d126f53520f4e27ffc965ac3c069c545bef473730f499b7546cbb694f96019f02b6a659db03bfadd8f6ba730bb059e27e9f40cc6bf030b18687a40c0628f755a3e1ac2656196bf2762cc44c85a712eb9be7de07a69e2c07ce0276a279c71317c0dcfb60acdc4bfa7df374e28d8ae1cfb00890329a0c9c43fe93cdbaf26b60e79af6c158d623de18b010e89f2c033e479e0bff54623e8a1267f61b9987803d13f77d0670dd289ff5203e0e90b299067c9ffc279d756511704a4dfb605da6128f062e5d471b4db9799478eb633bf2d88d78b320f77e585716010726eefb246220e1da3ed33b0152461b50eee4236be61c62b2941c2601cf072e58471b4d39b903783bcd0eee5b535b56a87c827a26e57ad7383efb4162a22e49196c4c7bbee1de4173b307aecd33804f13df2c73ef0ff3e4ac067e06bc82fa579e1ccba6c4c257b9f7c778b28c189b90da898cff9187458094d11ce06af29f8cc69395c0bf00ebd7b227c66f3de2f1807705f2e76162447fd3af908ee64f888174b9f7c978b21c78510dfb607f7abff361112065b425ed5a3def66e0d9b5ec89deed037c0c984ffefdd295ac047e00bc94fa57e81b8fad8073c9bf5fc69b15c0cb6bd80fdb31f102c82240ca6836ed791c3048dcf23d8bb8835182c9c4d4ae6750f6f4ae6dcd2ae02262c6be2dc7f96f52b749c4b3fe36157fcb8809b052db08b8b262db2c02a48c36017e45fe93542fb99f380997643a31f9c9978811d6b9f7515b337cd17f0bcd2dce335e3bd1be47404f10035a539b0c9c97a88d160152463388c154b94f56bde67bc0ae35ec8faa2613af3bbd0fb88cb873917b5f959cf9c45b1fa7d2fc4c7de3b121f001621ae1dcfbaa973c0a1c55c3fe98047c26715b2d02a48ca6d39e91cc23b39c1810b669fa5d92cc36c01b80af13772f72efb3dc594a7ccb7f2f7010315b65892611033fe7917f9ff59a85c021c9f748f8a79ada6c112065348db848e53e794d240b687e75b789da9ab8b09c41dc21287dc6b8aa5944dc3a7f1f702cf14645e90e208a94dcfb6e227900d837fd2e01e02f6a6ebb458094d114620ad5dc27b189e62ae039c9f74abde600c7017f077c19f81d716723f7be9c48ee241ecd7c88783f7f77dab5c4ecb6c01768ef639bdba9efb1d82b68a6587d90325ef1943aeb34da7b121c24bebd1d9d7aa734682af1bae12b885be55f206671bc8378252ee7be5d404c77fb0de05f813713cf9a73cddc98c2a6c432c16d7bce3f3297025ba4de31439e4fbc4dd0545f2c02f4bfdaf40da29f9c44bc76d7865bb66bf363e0ddc492acfd622ab1ccecf6c4097fce5a3240bcaa35957834b2f11adb590a2c19fafb22a2e07b9cb8c03f34f4e7fca13f1700f710df3017d5d3ad2ce6106f1cfc354fdd3f6df23fc02b890226b5a389bb3a1bd4b0edb13c081c035cdbf0e74a1a72187131c8fdeda66a2e20662c9320de7c79274f5eb6b6ad3983fac6be1c4ade69b01d132065b63b701bf94f7455b38a78d3e188b4bb472db20d31b5743f5cf857128feaeab23f31ed72ee7e5a044899cda1bda3a247cbe5c464425352ee24156b6fe275d125e4ffdd4b91c7813f4eba879eec19c4639fdcfd1c8e458094d9fac49880dc278394b915f82b62b217f59f63883504da3ca075cddc06ec977227ada1b48bff701ec0818152767f49b323829bc802e03f803d13ee27e5318b18d8d796152f7bc90f89353cea722065af73e09d00a9000712afa4e53e21d491cb886969374ab6b7d4840388dbfcbd2e4ddb86ac265e53ac73a2ab2369c73a1616015201b6047e41fe13425d79043893287654a62d81bf016e24ffef4b9dbf872f4ab5c3d6e278da3507824580548029c43793dc2784ba338f78ddca3708f29b450ce03c8f58e73ef7ef469db981780ba74e27d0cec191160152215e4e7fbc5a359e5c4fccce57f789597f300b782df10cbcdf2ffac3f922f50f4efd33dabd3f1fc0713b5211e602bf24ff49a1c95c43bc57fe6c62c63da5b32bf036e047f4dfa0d3b1b2103839c1fe5b97b64ff73d1ca70d960a31409c58ba74c21ece13c48c83a7013b54dd911db43eb15ae08789bb2cb9ff3d73e41260a7aa3b721d26031f2fa0af29e32b8252410e016e21ff892167ae033e099c02ec586d77f6a58d894566de0ffc94589b20f7bf59ae2c07fe9efa97b39e0e9c93b9af75c522402ac80ce0f3e43f3194927b8893ef69c49b05d326be6b5b697b6275c38f11cb36e75ed5b094dc0c1c5461bf8ed71ce0e20cfd6b32f7037ba4da612a83ab01b6db4b81ffa4bea54adb6a05f1fada35c4a435570ffdfdee9c8d4a60236260d6bec428edbd89a58ddbbc5c701d0689790bfe9698bba04e4f03be03ec56f3e794c05504fb8c0540fbcd064e27461dfbef39b6878967e0b711af1fde3e94794471b02a57c34698430cfadc718d3f771dfafb40a676b5c54dc01b8941b3757b1e7036b049039f550a8b803ee205a37f1c437cebd93977435a6a05701771ab7301316debf09f0f0dfd7d21312011e031e256fb2a6259d791a6f38735de671217eda9c437f53923b2e91ad981787eafdead003e02fc1331e6a16ea71203febab8e895458054a0f581f711039f723f3334a6a95c494c57dc8429c463b7dc7dce1d07064a85da17f82df94f12c6d49927807752ff08ff615bd1df5374f71a07064a851a20a6757d80fc270a6352e73c626c44539e05dc9bb80ffd10ef0448059b454c00d3c509844cffe5729a5f37e2547cac36562c02a4c23d1df82ef94f16c64c24f71217e2a66ef743ccb7d1af93fba48e4580d402c712a377739f308c194f9613ab45e6783be2cc09b4b7cbb91f17f2928a370d782b701ff94f1ac68c9655c097a87ffefeb14c23c61ae4de176d8a7702a496d880983ef77ef29f388c192456d13b8f7893a5041601bdc7a584a516d990789dea61f29f3c4c777301b03fe5b108e83d160152cbcc200a8147c87f0231ddc905c033299b4540efb108905a68536246c107c97f1231fd9955c0b78043690f8b80de631120b5d4746232a1ebc97f2231fd91a5c059b477b4b84540efb108905a6c003881b8559bfb6462da99078909a9b6a2fd2c027a8f4580d4070e05be41acbe96fba462cacf8dc09f130b55f5138b80de631120f589ad880183b792ffc462caca526206bd63e9ef25c72d027a8f4580d447068813fd39b8de40d7730351146e4a775804f41e8b00a90fcd22e66bbf86fc2719d34c96f0876ffb5d6511d07b2c02a43eb627f12aa18f08fa2f4b890bde6bc833477f892c027a8f4580d4e70688e55bcfc0f5d4db9c95c045c41d9e9968341601bde77e2c02a44e980c3c1bf82451fde73ef998b1b30cf811f07a60f628ff9e7a2a8b80de63112075d09ec4a0b10b88655f739f884c9c8ccf024ec26ffa13651130b1df3b8b00a9a36613179d4f017793ff84d495ac206eedbf133880fe7e6daf491601bdc722a0611eec2ad124603fe059c4f881c3e98f19e44ab014f82d71d1bf18b810783c6b8bfad734e05ce085b91bd2220f00cf21a61f57cd2c00d4165b1385c07041b01f31c050637b14b894b8d85f3494a5595bd42d1601bdb30868880580da6a13e020605f60efa1ec419c70bbea2e620e86ab8772057053d616092c0226c222a0011600ea2753815d896260b830d80dd86ee8ffd62f1e22e65718bed80fffb93067a334268b80de5904d4cc02405d3019d816980bec38e2cfe16c35f4ff538a85c01dc0edc0bc35febc1d782257c354894540ef2c026a6401208559c41cf67386b2e6df670dfdff6d44dc4d18e00fafc9ad0fac37f4f741e091a1bf2f25a6ca65e8bf0d0efdef05c0fc115930e2bf2d2046e6ab3f5904f4ce224092d4177c457062af08ee31919d2d4952492c022c0224491d651160112049ea288b008b004952475904580448923aca22c0224092d4511601160192a48eb208b008902475944580458024a9a32c022c0224491d651160112049ea288b008b004952475904580448923aca22606245c0ee13d9d9922495c422a0f7dc87458024a90f5804580448923aca22c0224092d4511601160192a48eb208b008902475944580458024a9a32c022c0224491d651160112049ea288b008b004952475904580448923aca22c0224092d4511601bde72e609789ec6c49924a621160112049ea288b008b004952475904580448923aca22c0224092d4511601160192a48eb208b008902475944580458024a9a32c022c0224491d651160112049ea288b008b004952475904580448923aca22606245c0ce13d9d9922495c422a0f7dc89458024a90f5804580448923aca22c0224092d4511601160192a48eb208b008902475944580458024a9a32c022c0224491d651160112049ea288b008b004952475904580448923aca22a04f8a80c9b91b20496a9555c0b78067e28238e335139804fc2077432449aaca3b01e3cfd781a913dbcd922495c722607c17ff2913ddc1922495ca22c08bbf24a9a32c02bcf84b923aca22c08bbf24a9a32c02e01cbcf84b923aa8cb4580177f4952a775b108f0e22f4912dd2a02bcf84b923442178a002ffe92248da29f8b80b3f1e22f49d25af56311e0c55f92a471e8a722c08bbf24493de88722c08bbf244913d0e622c08bbf244915b4b108f0e22f4952026d2a02bcf84b9294501b8a80afe1c55f92a4e44a2e02bcf84b9254a3128b002ffe922435a0a422c08bbf24490d2aa108f0e22f495206398b80afe2c55f92a46c7214015efc25492a40934580177f49920ad24411f0556072531d922449e3536711e0c55f92a482d5510478f19724a9055216015efc25496a911445c0e78181a61b2e4992aaa9520478f19724a9c52652047c0e2ffe9224b55e2f4580177f4992fac8788a002ffe9224f5a1b18a002ffe9224f5b1d18a002ffe922475c0c822e0b378f19724a933d603de8a177f4992244992244992244992244992244992244992244992244992244992244992244992244992244992244992244992244992244992244992244992244992244992244992244992244992244992244992244992244992244992244992244992244992244992244992c6f2ff01e4b93c3cdd61dd100000000049454e44ae426082),
(7, 'Perkasa23rcm', 'Perkasa23rcm', '081222965873', '', '', '', NULL);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `detail_transaksi`
--
ALTER TABLE `detail_transaksi`
  ADD PRIMARY KEY (`id_detail_transaksi`),
  ADD KEY `id_order` (`id_order`);

--
-- Indeks untuk tabel `ensiklopedia`
--
ALTER TABLE `ensiklopedia`
  ADD PRIMARY KEY (`id_ensiklopedia`),
  ADD KEY `id_tanaman` (`id_tanaman`);

--
-- Indeks untuk tabel `hama_penyakit`
--
ALTER TABLE `hama_penyakit`
  ADD PRIMARY KEY (`id_hama_penyakit`);

--
-- Indeks untuk tabel `kamus`
--
ALTER TABLE `kamus`
  ADD PRIMARY KEY (`id_kamus`);

--
-- Indeks untuk tabel `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`id_order`),
  ADD KEY `id_user` (`id_user`);

--
-- Indeks untuk tabel `penanganan_penyakit`
--
ALTER TABLE `penanganan_penyakit`
  ADD PRIMARY KEY (`id_penanganan_penyakit`),
  ADD KEY `id_penanganan_penyakit_2` (`id_penanganan_penyakit`,`id_hama_penyakit`),
  ADD KEY `id_penanganan_penyakit_3` (`id_penanganan_penyakit`,`id_pestisida`),
  ADD KEY `id_tanaman` (`id_tanaman`);

--
-- Indeks untuk tabel `pestisida`
--
ALTER TABLE `pestisida`
  ADD PRIMARY KEY (`id_pestisida`);

--
-- Indeks untuk tabel `pupuk`
--
ALTER TABLE `pupuk`
  ADD PRIMARY KEY (`id_pupuk`);

--
-- Indeks untuk tabel `tanaman`
--
ALTER TABLE `tanaman`
  ADD PRIMARY KEY (`id_tanaman`);

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `detail_transaksi`
--
ALTER TABLE `detail_transaksi`
  MODIFY `id_detail_transaksi` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `ensiklopedia`
--
ALTER TABLE `ensiklopedia`
  MODIFY `id_tanaman` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `hama_penyakit`
--
ALTER TABLE `hama_penyakit`
  MODIFY `id_hama_penyakit` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `kamus`
--
ALTER TABLE `kamus`
  MODIFY `id_kamus` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT untuk tabel `order`
--
ALTER TABLE `order`
  MODIFY `id_order` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `penanganan_penyakit`
--
ALTER TABLE `penanganan_penyakit`
  MODIFY `id_penanganan_penyakit` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `pestisida`
--
ALTER TABLE `pestisida`
  MODIFY `id_pestisida` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `pupuk`
--
ALTER TABLE `pupuk`
  MODIFY `id_pupuk` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `tanaman`
--
ALTER TABLE `tanaman`
  MODIFY `id_tanaman` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT untuk tabel `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- Database: `test`
--
CREATE DATABASE IF NOT EXISTS `test` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `test`;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
