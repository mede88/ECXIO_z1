# ECXIO
zadatak

Na data web stranici postoji forma za upis imena, emaila i zabiljeske, a ispod te forme je prikaz svih 
prethodnih unosa koji su approvani preko admin stranice. 

Na admin web stranicu se treba ulogirati sa username i pasword. Ako login prode dolazi se na admin stranicu 
na kojoj su prikazani svi unosi koje treba oznaciti/approvati da bi se prikazali na data web stranici.


DB:

-- Database: `Ecxio`
--

-- --------------------------------------------------------

--
-- Table structure for table `data`
--

CREATE TABLE IF NOT EXISTS `data` (
  `id` int(10) unsigned NOT NULL,
  `name` varchar(20) NOT NULL,
  `email` varchar(30) NOT NULL,
  `note` tinytext,
  `approved` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `data`
--

INSERT INTO `data` (`id`, `name`, `email`, `note`, `approved`) VALUES
(1, ‘A’, ‘asdasd’, 'test ghajskdasdadsadsdadad', 1),
(2, 'X', 'X@X.com', 'kef', 1),
(3, 'asdadad', 'asda@asd.com', 'asdfghjgfsdirngenerinfsdfsdfsdfsdfs', 1),
(4, 'asdasdadasd', 'asdasdadad', 'asdasdads', 1),
(5, 'as dad', 'dhdsff', 'sdfhgjkljhgfdv', 1),
(6, 'as dad', 'dhdsff', 'sdfhgjkljhgfdv', 1),
(7, 'dfghjgmnfdbff', 'dfghnfgvgbf', 'fghbfgbttb', 1),
(8, '2222222', '222222', '22222', 1),
(9, '111', '111', '111', 1),
(10, '222', '222', '222', 1),
(11, '333', '333', '333', 1),
(12, '444', '444', '444', 1);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` tinyint(3) unsigned NOT NULL,
  `username` varchar(15) NOT NULL,
  `password` varchar(15) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`) VALUES
(1, 'ecxio', '1234');