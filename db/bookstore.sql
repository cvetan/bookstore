-- MySQL dump 10.13  Distrib 5.7.23, for Linux (x86_64)
--
-- Host: localhost    Database: bookstore
-- ------------------------------------------------------
-- Server version	5.7.23-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `addresses`
--

DROP TABLE IF EXISTS `addresses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `addresses` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned NOT NULL,
  `city_id` int(10) unsigned NOT NULL,
  `street` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `street_number` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `details` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `contact_phone` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `city_id` (`city_id`),
  KEY `street` (`street`),
  CONSTRAINT `addresses_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `addresses_ibfk_2` FOREIGN KEY (`city_id`) REFERENCES `cities` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addresses`
--

LOCK TABLES `addresses` WRITE;
/*!40000 ALTER TABLE `addresses` DISABLE KEYS */;
INSERT INTO `addresses` VALUES (1,3,1,'Bulevar kralja Aleksandra','352',NULL,NULL,'2018-08-31 03:07:04',NULL),(2,3,1,'Žarka Samardžića ','43a','Stan 2','065/688-11-80','2018-08-31 03:09:25',NULL);
/*!40000 ALTER TABLE `addresses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `administrators`
--

DROP TABLE IF EXISTS `administrators`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `administrators` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `active` tinyint(1) unsigned NOT NULL,
  `first_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `last_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `email` (`email`),
  KEY `active` (`active`),
  KEY `first_name` (`first_name`),
  KEY `last_name` (`last_name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrators`
--

LOCK TABLES `administrators` WRITE;
/*!40000 ALTER TABLE `administrators` DISABLE KEYS */;
INSERT INTO `administrators` VALUES (2,1,'Default','Admin','admin','admin@admin.com','$2a$10$8dORIcSCFXxlYgtMovMPWuIUhrXtf93/D0svSo132ZllJY5q0WL3q','2018-08-23 02:09:49',NULL),(3,1,'Cvetan','Šimšić','cvetan','cvetan.simsic@gmail.com','$2a$10$RycDd85P53CthNdnr0nXreCU0YBr3OXdK2hPqsXTmH3fNPoXNyOam','2018-08-23 02:10:12','2018-08-26 02:20:06');
/*!40000 ALTER TABLE `administrators` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authors`
--

DROP TABLE IF EXISTS `authors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authors` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `slug` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `description` text COLLATE utf8_unicode_ci NOT NULL,
  `image` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `image_public_id` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `title_tag` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `description_tag` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `slug` (`slug`),
  KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authors`
--

LOCK TABLES `authors` WRITE;
/*!40000 ALTER TABLE `authors` DISABLE KEYS */;
INSERT INTO `authors` VALUES (1,'Džordž R. R. Martin','dzordz-r-r-martin','<p><strong>Džordž Martin rođen je 1948. u Nju Džersiju kao Džordž Rejmond Ričard Martin.</strong> Sklonost ka pisanju razvio je još kao dete, pišući priče o čudovištima i prodajući ih komšijskoj deci. Kasnije, u srednjoj školi, postao je ljubitelj stripa i predani kolekcionar, usmerivši svoje literarno delovanje na pisanje strip scenarija za različite opskurne fanzine. Prvi profesionalni ugovor sklopio je 1970, prodavši priču za strip <em>Heroj</em>. </p><p><br></p><p> Godine 1971. diplomirao je žurnalistiku na univerzitetu Northwestern. Nekoliko sledećih godina radio je pri administraciji okruga Kuk, organizovao šahovske turnire i bio predavač na katedri za novinarstvo univerziteta Klark u Ajovi. Tokom sedamdesetih samo je povremeno pisao.</p><p><br></p><p> Pošto se 1979. razveo, svu energiju usmerio je ka pisanju. Sve ostalo je legenda: za svoj literarni rad, Džordž R. R. Martin dobio je sve važnije nagrade u žanru epske fantastike, nekoliko Nebula i Hugo nagrada. </p><p><br></p><p> Godine 1986. seli se u Holivud, gde radi kao urednik serijala <em>Zona sumraka</em>, konsultant na scenariju za <em>Lepoticu i zver</em>, producent istog projekta, a na kraju i supervizor. </p><p><br></p><p> Martin danas živi u Santa Feu u Novom Meksiku. Potpredsednik je američkog udruženja SF pisaca.</p>','http://res.cloudinary.com/cvetan/image/upload/v1535245391/Bookstore/Authors/Images/dzordz-r-r-martin-20180826030309.jpg','Bookstore/Authors/Images/dzordz-r-r-martin-20180826030309','Džordž R. R. Martin :: Bookstore',NULL,'2018-08-26 03:03:11',NULL),(2,'Vanja Bulić','vanja-bulic','<p class=\"ql-align-justify\">Vanja Bulić (1947) čitav radni vek je proveo kao novinar u pisanim i elektronskim medijima. Za televiziju je uradio više od dve i po hiljade jednočasovnih emisija, a pisao je za gotovo sve prestižne listove nekadašnje Jugoslavije. Radio je dokumentarne filmove (<em>Državni radnik</em>, <em>Crveni barjak Filipa Filipovića</em>), scenarista je tri TV serije (<em>Jugovići</em> – RTS, <em>Javlja mi se iz dubine duše</em>&nbsp;– TV Košava i <em>Drugo stanje</em> – BK TV). Koscenarista je dugometražnog filma <em>Lepa sela lepo gore</em> i scenarista filma <em>Drugo stanje</em>. Napisao je zbirke priča: <em>Kako sam gajio blizance</em> (1995), <em>Sto bisera</em> (2009), <em>Istorija u krevetu</em> (2012) i <em>Muškarac u izvesnim godinama</em> (2014); romane: <em>Tunel – lepa sela lepo gore</em> (1996), <em>Ratna sreća</em> (1999), <em>Zadah belog</em> (2000), <em>Vrele usne</em> (2001), <em>Parada strasti</em> (2003), <em>Drugo stanje</em> (2006), <em>Oko otoka</em> (2009), <em>Šole</em> (2010), <em>Simeonov pečat</em> (2012), <em>Jovanovo zaveštanje</em> (2013), <em>Dosije Bogorodica</em> (2014), <em>Devedesete</em> (2015 – knjiga u kojoj se nalaze četiri romana objavljena devedesetih godina prošlog veka) i <em>Teslina pošiljka</em>. Priredio je dnevnik iz Haga Veselina Šljivančanina <em>Branio sam istinu</em> (2012), a napisao je i romansirane biografije glumaca Petra Božovića i Marka Nikolića. Otac je trojice sinova. Imao je rok sastav, strastveni je&nbsp;igrač preferansa i još uvek igra odbojku. Član je Udruženja novinara Srbije i Udruženja književnika Srbije.</p>','http://res.cloudinary.com/cvetan/image/upload/v1535323467/Bookstore/Authors/Images/vanja-bulic-20180827004426.jpg','Bookstore/Authors/Images/vanja-bulic-20180827004426',NULL,NULL,'2018-08-27 00:44:28',NULL),(3,'Džo Aberkrombi','dzo-aberkrombi','<p class=\"ql-align-justify\">Džo Aberkrombi je rođen 1974. godine u Lankasteru (Engleska). Studirao je psihologiju na Univerzitetu u Mančesteru. Bavio se televizijskom produkcijom i montažom.</p><p class=\"ql-align-justify\"> </p><p class=\"ql-align-justify\"> U pauzama između honorarnih poslova tokom 2002. godine počeo je da piše <em>Oštricu</em>. Rukopis je završio 2004, a izdavača za svoj prvi roman pronašao je 2006. godine. Tako je počela njegova književna karijera. Ovim naslovom je započeta trilogija <em>Prvi zakon</em>, koja je prevedena na trideset jezika. Sledi trilogija <em>Skrhano more</em> i još tri romana iz sveta <em>Prvog zakona</em>: <em>Osveta, Junaci </em>i<em> Krvava zemlja</em>.</p><p class=\"ql-align-justify\"> </p><p class=\"ql-align-justify\"> Džo živi u Batu u Engleskoj sa ženom i troje dece. Vreme provodi u pisanju epskofantastičnih romana, punih nasilja, ali i humora.</p>','http://res.cloudinary.com/cvetan/image/upload/v1535691773/Bookstore/Authors/Images/dzo-aberkrombi-20180831070252.jpg','Bookstore/Authors/Images/dzo-aberkrombi-20180831070252',NULL,NULL,'2018-08-31 07:02:54',NULL),(4,'Rodžer Zelazni','rodzer-zelazni','<p class=\"ql-align-justify\">Rodžer Zelazni (1937–1995) bio je američki prozni pisac i pesnik, jedan od najznačajnijih autora epske i naučne fantastike. Na polju žanra njegova dela smatraju se revolucionarnim, naročito u pogledu psihologije likova, stila i motiva; objavio je više od sto pedeset kratkih priča i više od pedeset knjiga. Triput je osvojio nagradu Nebula, šest puta nagradu Hugo i brojne druge. Prevođen je na više od dvadeset jezika.</p><p><br></p>','http://res.cloudinary.com/cvetan/image/upload/v1535691907/Bookstore/Authors/Images/rodzer-zelazni-20180831070506.jpg','Bookstore/Authors/Images/rodzer-zelazni-20180831070506',NULL,NULL,'2018-08-31 07:04:51','2018-08-31 07:05:08'),(5,'Dejan Stojiljković','dejan-stojiljkovic','<p class=\"ql-align-justify\">Dejan Stojiljković, prozni i dramski pisac, filmski i strip-scenarista, rođen je u Nišu 1976. godine. Do sada je objavio romane <em>Konstantinovo raskršće</em>, <em>Duge noći i crne zastave</em>, <em>Znamenje anđela</em>, <em>Kainov ožiljak</em> (u četiri ruke, sa Vladimirom Kecmanovićem) i <em>Olujni bedem</em>, kao i prozne zbirke <em>Leva strana druma</em>, <em>Low Life </em>i <em>Kišni psi</em>. Zajedno sa Vladimirom Kecmanovićem i Draganom Paunovićem autor je ilustrovane trilogije o Nemanjićima, koju čine knjige <em>U ime oca</em>, <em>Dva orla</em> i <em>U ime sina</em>. Autor je više dramskih tekstova i strip-scenarija. Jedan je od scenarista serije <em>Senke nad Balkanom</em>, u režiji Dragana Bjelogrlića. Laureat je prestižne književne nagrade „Miloš Crnjanski“ (za roman <em>Konstantinovo raskršće</em>). Proza mu je prevođena na ruski, engleski, grčki, slovački, makedonski, slovenački i francuski. Jedan je od najčitanijih savremenih srpskih pisaca. Član je književne grupe P-70, Srpskog književnog društva i Udruženja stripskih umetnika Srbije. Živi i radi u Nišu.</p>','http://res.cloudinary.com/cvetan/image/upload/v1535691950/Bookstore/Authors/Images/dejan-stojiljkovic-20180831070549.jpg','Bookstore/Authors/Images/dejan-stojiljkovic-20180831070549',NULL,NULL,'2018-08-31 07:05:51',NULL);
/*!40000 ALTER TABLE `authors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `books` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `active` tinyint(1) unsigned NOT NULL,
  `main_price` decimal(10,2) unsigned NOT NULL,
  `promotion_price` decimal(10,2) unsigned DEFAULT NULL,
  `sale` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `author_id` int(10) unsigned NOT NULL,
  `isbn` varchar(17) COLLATE utf8_unicode_ci NOT NULL,
  `title` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `slug` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `description` text COLLATE utf8_unicode_ci NOT NULL,
  `format` enum('13x20cm','22x31cm') COLLATE utf8_unicode_ci NOT NULL,
  `page_number` int(10) unsigned NOT NULL,
  `alphabet` enum('cyrillic','latin') COLLATE utf8_unicode_ci NOT NULL,
  `cover` enum('hardcover','paperback') COLLATE utf8_unicode_ci NOT NULL,
  `publish_date` date NOT NULL,
  `sample` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sample_public_id` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `image` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `image_public_id` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `thumbnail` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `thumbnail_public_id` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `title_tag` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `description_tag` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `isbn` (`isbn`),
  UNIQUE KEY `slug` (`slug`),
  KEY `author_id` (`author_id`),
  KEY `title` (`title`),
  CONSTRAINT `books_ibfk_1` FOREIGN KEY (`author_id`) REFERENCES `authors` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (3,1,899.00,NULL,0,2,'978-86-521-2811-2','Dušanova kletva','dusanova-kletva','<p class=\"ql-align-justify\">Autor bestselera <em>Simeonov pečat</em> i <em>Teslina pošiljka</em></p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\"> Zlo ima hiljadu lica, ali samo jedan cilj.</p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\"> „Sve sudije da sude, pravo, po zakonu, a ne da sude po strahu od cara.“ <em>Dušanov zakonik</em></p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\"> Ispred Palate pravde, naslonjena na spomenik caru Dušanu, pronađena je kesa za đubre i u njoj odsečena ruka. Kakvu poruku šalje odsečena ruka čoveka koji je tri puta bio u zatvoru zbog silovanja? Odgovor traži novinar Novak Ivanović, dok policija po nečijem naređenju usporava istragu. </p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\"> Sumnja pada na društvo <em>Dušanovi sledbenici</em>, koje se zalaže za striktnu primenu zakona kao u vreme vladavine cara Dušana („ako vlastelin uzme drugu bez njenog pristanka, da mu se obe ruke odseku“). Članovi društva su roditelji, braće, sestre i prijatelji silovanih žena, ili dece koja su pretrpela torturu pedofila, ili devojaka koje su završile kao belo roblje... Da li su <em>Dušanovi sledbenici</em> društvo osvetnika ili neformalno udruženje koje pokušava da probudi uspavanu savest zemlje u tranziciji?</p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\"> Kad sazna da iz Beograda ka Kosovu kreće već utabanom stazom minibus sa devojkama koje će završiti kao prostitutke u noćnim klubovima i bordelima na Kosovu, u Italiji ili na Bliskom istoku, Novak kreće u Mitrovicu, Prizren, Prištinu... U Manastiru Sveti Arhangeli, kraj groba cara Dušana, sreće monaha Onufrija, koji mu govori o Dušanovoj kletvi na potomstvo. </p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\"> Posle povratka u Beograd, monah postaje Novakova noćna mora. Dok istražuje ko stoji iza trgovine belim robljem i prikriva glavne aktere zbog kojih je uzdrmana vlada, Novak više nije siguran da li je kosovski monah san ili java…</p>','13x20cm',308,'latin','paperback','2018-05-29',NULL,NULL,'http://res.cloudinary.com/cvetan/image/upload/v1535326492/Bookstore/Books/Images/Du%C5%A1anova%20kletva.jpg','Bookstore/Books/Images/Dušanova kletva',NULL,NULL,NULL,NULL,'2018-08-27 01:37:34',NULL),(4,1,1199.00,NULL,0,2,'978-86-521-2101-4','Teslina pošiljka - Posebno izdanje','teslina-posiljka-posebno-izdanje','<p class=\"ql-align-justify\">Posebno izdanje sa autorovim dodatkom.</p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\">Neke tajne treba zauvek da ostanu daleko od očiju.</p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\">Kad knjiga izgori, pepeo progovori.</p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\">Na ruševinama Narodne biblioteke, uništene tokom bombardovanja Beograda 6. aprila 1941. godine, jednog jutra pronađeno je telo nemačkog novinara Riharda Genca. Taj događaj označiće početak potere za ubicom koja će novinara Novaka Ivanovića uvesti u lavirint laži, obmana, obaveštajnih intriga, istorijskih nepravdi, međunarodnih zavera... A na samom kraju tog lavirinta čeka šokantna istina.</p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\">Posle serije ubistava i otmica, na prvi pogled međusobno nepovezanih, Novaku postaje jasno da je postao pion u igri moćnika čiji je jedini cilj pronalaženje Teslinih „zraka smrti“. Tesla je tvrdio da je taj pronalazak namenio svojoj otadžbini. Da li je pronalazak uoči rata stigao u Srbiju i da li se nalazio baš u Narodnoj biblioteci, čija je celokupna arhiva trebalo da bude izmeštena u manastir Blagoveštenje? U toj arhivi se nalazilo i <em>Miroslavljevo jevanđelje</em>, ali ga je neko uoči bombardovanja sakrio u manastir Raču. Da li su tada sklonjeni i Teslini pronalasci?</p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\">Novak shvata da svi putevi vode u manastir Blagoveštenje, gde živi sveti čovek koji može biti ključ za rešenje zagonetke.</p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\">Gore, u vrletima koje vekovima šibaju vetrovi i gde je vreme stalo, sačekaće ga jedan monah, jedan orao i jedan vuk.</p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\">U dodatku ovog, posebnog izdanja romana<em> Teslina pošiljka</em> Vanja Bulić nudi malo poznate podatke koji se nisu uklapali u literarnu priču, a govore o novijoj istoriji Narodne biblioteke i intrigantnim pojedinostima iz života Nikole Tesle. Čitalac će biti u prilici da sazna i priču o manastirima u Srpskoj Svetoj gori, u Ovčarsko-kablarskoj klisuri, gde je smešten u Manastir Blagoveštenje, jedna od ključnih lokacija u romanu.</p>','13x20cm',400,'cyrillic','hardcover','2016-02-24',NULL,NULL,'http://res.cloudinary.com/cvetan/image/upload/v1535327081/Bookstore/Books/Images/Teslina%20po%C5%A1iljka%20-%20Posebno%20izdanje.jpg','Bookstore/Books/Images/Teslina pošiljka - Posebno izdanje',NULL,NULL,NULL,NULL,'2018-08-27 01:44:42',NULL),(5,0,1199.00,NULL,0,2,'978-86-521-2558-6','Viza za nebo - Posebno izdanje','viza-za-nebo-posebno-izdanje','<p class=\"ql-align-justify\">Gde se krije rukopis koji će promeniti istoriju?</p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\"> Posebno izdanje sa autorovim dodatkom.</p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\"><em>Viza za nebo</em> je onespokojavajući roman o tabloidnoj Srbiji koja se otrgla iz naručja Belog anđela i zagazila u nemoral, krv i bezakonje.</p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\"> U svom novom romanu Vanja Bulić nastavlja da prati uzbudljiva istraživanja novinara „crne hronike“ Novaka Ivanovića, ovoga puta povodom ubistva vlasnika noćnog kluba Laleta Svica, nekadašnjeg žestokog momka sa beogradskog asfalta. Kada iz noćnog kluba dobije anonimni poziv, sa obaveštenjem da je njegov vlasnik ubijen, i kada shvati da policija zanemaruje i zataškava zločin, ovaj beskompromisni novinar upustiće se u traganje za pozadinom krvavog događaja. </p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\"> Polako postaje jasno da je ubijeni bio upleten u mrežu korupcije, spregu vlasti i kriminala i seks-afere. Osim toga, poslao je zagonetnu poruku tako što je u smrtnom času razdrljio košulju i otkrio grudi na kojima je imao istetoviranog Belog anđela, repliku čuvene mileševske freske. Novak počinje da piše seriju članaka i da povezuje skrivene i moćne protagoniste jedne dalekosežne zavere. </p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\"> U posebnom, dopunjenom izdanju <em>Vize za nebo</em> Vanja Bulić u dodatku otkriva šta ga je inspirisalo da napiše ovaj roman i daje putokaz za čitanje ove uzbudljive priče: o tome kako je nastala freska Belog anđela kada su „Sveti ratnici“, čuvari koplja Svetog Đorđa, na mestu budućeg manastira Mileševe potkraj XII veka odbranili Hristovu plaštanicu od templara; o krađama relikvija i crkvenog blaga iz srpskih manastira; o sprezi države i kriminala 90-ih godina XX veka i ubistvima Giške, Belog, Arkana, Badže; o nemačkom publicisti Hansu Peteru Rulmanu i njegovoj brošuri<em> Ubistva naručena u Beogradu</em>…</p>','13x20cm',384,'cyrillic','hardcover','2017-06-02',NULL,NULL,'http://res.cloudinary.com/cvetan/image/upload/v1535327195/Bookstore/Books/Images/Viza%20za%20nebo%20-%20Posebno%20izdanje.jpg','Bookstore/Books/Images/Viza za nebo - Posebno izdanje',NULL,NULL,NULL,NULL,'2018-08-27 01:46:36',NULL),(6,0,1199.00,NULL,0,1,'978-86-7436-099-6','Igra prestola','igra-prestola','<p><strong>ROMAN DO SADA NEVIÐENE SNAGE MAŠTE IZ PERA NAJVEĆEG MAJSTORA ŽANRA</strong></p><p><br></p><p> U „IGRI PRESTOLA“, Džordž R.R. Martin je stvorio istinsko remek-delo, objedinivši sve ono najbolje što žanr epske fantastike može da pruži. Magija, spletke, romanse i pustolovine ispunjavaju stranice prvog toma ovog epskog serijala, koji će zasigurno oduševiti ne samo ljubitelje žanra, već i mnogo širi krug čitalaca.</p><p><br></p><p> Nad zemljom u kojoj leta mogu trajati decenijama, a zime pokolenjima, nadvili su se crni oblaci. Ledeni vetrovi ponovo duvaju i u snežnim bespućima severno od Zimovrela, mračne i natprirodne sile okupljaju se iza velikog zida koji štiti kraljevstvo. U središtu sukoba nalazi se porodica Stark od Zimovrela, ljudi nepopustljivih i tvrdih kao što je i zemlja kojom vladaju. Prostirući se od predela okovanih surovom hladnoćom do dalekog letnjeg kraljevstva obilja i raskoši, ovo je priča o vitezovima i damama, vojnicima i čarobnjacima, plaćenim ubicama i kopiladima, ljudima koji žive u vremenu zlih predskazanja. Kroz mnoge zavere i spletke, tragedije i izdajstva, bitke i opsade, rešava se sudbina porodice Stark, njihovih saveznika i neprijatelja, dok svi oni pokušavaju da pobede u toj najsmrtonosnijoj od svih igara: igri prestola.</p>','13x20cm',655,'latin','paperback','2003-06-26',NULL,NULL,'http://res.cloudinary.com/cvetan/image/upload/v1535327798/Bookstore/Books/Images/Igra%20prestola.jpg','Bookstore/Books/Images/Igra prestola',NULL,NULL,NULL,NULL,'2018-08-27 01:56:39',NULL),(7,1,1399.00,NULL,0,1,'987-86-7436-140-5','Sudar kraljeva','sudar-kraljeva','<p class=\"ql-align-justify\">U drugom delu <strong>Pesme leda i vatre</strong>, Džordž R. R. Martin stvorio je delo neprevaziđenog zamaha, snage i mašte.<strong> Sudar kraljeva</strong> vodi nas u svet spletki i sjaja, čudesa i bitaka,potpuno drugačiji od svega što ste do sada iskusili. </p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\"> Kometa boje krvi i plamena plovi preko neba. A od drevnog zamka na Zmajkamenu do ledenih pustoši Zimovrela, kraljevstvo vri. Šest pretendenata želi vlast nad podeljenom zemljom i gvozdeni presto Sedam kraljevstava, ne prežući ni od čega – od bitaka do bratoubistva, od intriga do izdaja. Ovo je priča u kojoj brat kuje zavere protiv brata, a mrtvi se dižu i hodaju po noći. Princeza je prerušena u dečaka beskućnika; vitez uma sprema se da otruje strašnu čarobnicu; a divlji ljudi spuštaju se sa Mesečevih planina i pale sve pred sobom. Dok se tajne otkrivaju i čarolije tkaju a epske bitke smenjuju sa dvorskim spletkama, pobeda može pripasti onima koji imaju najhladniji čelik... i najhladnija srca. Jer kada se kraljevi sudare, čitavo kraljevstvo drhti.</p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\"> „Martin ispunjava sva obećanja data u prvom delu, i nastavlja da stvara jedan od najboljih fantastičnih epova ikada napisanih.“ <em>Denver post</em></p>','13x20cm',750,'latin','paperback','2011-08-08',NULL,NULL,'http://res.cloudinary.com/cvetan/image/upload/v1535328125/Bookstore/Books/Images/sudar-kraljeva-20180827020204.jpg','Bookstore/Books/Images/sudar-kraljeva-20180827020204',NULL,NULL,NULL,NULL,'2018-08-27 02:02:06',NULL),(8,1,1499.00,1299.00,1,3,'978-86-521-2895-2','Krvava zemlja','krvava-zemlja','<p class=\"ql-align-justify\">Roman iz sveta <em>Prvog zakona.</em></p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\"> Spalili su joj dom.</p><p class=\"ql-align-justify\"> Ukrali su joj brata i sestru.</p><p class=\"ql-align-justify\"> Sledi osveta.</p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\"> Šaj Saut se nadala da će moći da zaboravi na svoju krvavu prošlost i da će živeti mirnim životom. Ali neko se usudio da joj dira porodicu i sada će brzo morati da se priseti svih loših navika da bi spasila brata i sestru. Pre svega, ona nije žena koja će ustuknuti pred onim što se mora.</p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\"> U poteru kreće u društvu dva vola i jedne kukavice – svog očuha, čoveka zvanog Jagnje. Ispostaviće se, međutim, da i Jagnje krije svoju prošlost, i to još krvaviju. A tamo, u bezakonju i divljini Daleke zemlje, prošlost nikada ne ostaje dugo sakrivena...</p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\"> Putovanje će ih odvesti preko surovih i beskrajnih ravnica do rudarskog grada gde vlada zlatna groznica, kroz krvne osvete, dvoboje i masakre, visoko u neistražene planine, u susret Utvarama. Još i gore, nateraće ih na savez sa Nikomom Koskom, zloglasnim najamničkim vođom i njegovim prevrtljivim pravnikom Templom, ljudima kojima niko ne bi smeo da veruje...</p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\"> „Izvanredne scene borbi, uverljivi i zanimljivi likovi (kako oni koje smo već sretali tako i svi novi) i ironična, eksplozivna priča pokazuju da je Aberkrombi u <em>Krvavoj zemlji</em> na vrhuncu svog pisanja.“ <em>Publishers Weekly</em></p>','13x20cm',584,'latin','paperback','2018-03-03',NULL,NULL,'http://res.cloudinary.com/cvetan/image/upload/v1535691846/Bookstore/Books/Images/krvava-zemlja-20180831070405.jpg','Bookstore/Books/Images/krvava-zemlja-20180831070405',NULL,NULL,NULL,NULL,'2018-08-31 07:04:07',NULL),(9,1,799.00,649.00,1,5,'978-86-521-2710-8','Olujni Bedem','olujni-bedem','<p class=\"ql-align-justify\">Nastavak romana <em>Duge noći i crne zastave</em>.</p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\">Bitka se nastavlja.</p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\">Oluja je stigla... I pred kapijom moćne tvrđave, čiji bedemi sežu do neba, ordija velikog osmanskog emira pali vatre i oštri svoje handžare. Među zidovima grada jedan vitez, jedna gospa i jedan uglednik postaće neimari sopstvene sudbine.</p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\">U jesen 1386, nakon pada Pirota, moćna turska ordija predvođena lično sultanom Muratom stiže u dolinu Nišave. Knez Lazar, svestan opasnosti po svoju državu, nije siguran gde će Turci udariti: na Kruševac ili na Niš. Zato u moćnu tvrđavu grada na Nišavi šalje svog kuma, krajiškog vojvodu Milana Toplicu, sa zadatkom da, u slučaju osmanlijske opsade, zapoveda odbranom grada. Ta kneževa odluka nije po volji kefaliji Nenadi, gospodaru Niša, koji će se zato sukobiti sa topličkim vojvodom, a sve se dodatno zaplete kada Nenada otkrije da njegova rođaka Dostana gaji naklonost prema mladome vitezu, iako je obećana drugom proscu. I dok se Niš sprema za veliku bitku, vitezovi Reda Zmaja, vojvoda Ivan Kosančić i Pavle Orlović, u potrazi su za Milošem Obilićem, koga nalaze na krajnje neočekivanom mestu. Dodatni njihov zadatak biće da iz Niša pod opsadom iznesu mošti Svetog Prokopija. Istovremeno, u pustinjskom gradu na obodima carstva derviš Edhem i mladi princ Bajazit bore se sa silama i iskušenjima koji nisu od ovoga sveta...</p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\"><em>Olujni bedem</em> je nastavak priče o vitezovima Reda Zmaja, o usponu i padu srpske srednjovekovne države, o opsadi Niša i bici na Pločniku.</p><p><br></p>','13x20cm',304,'latin','paperback','2017-09-15',NULL,NULL,'http://res.cloudinary.com/cvetan/image/upload/v1535692115/Bookstore/Books/Images/olujni-bedem-20180831070834.jpg','Bookstore/Books/Images/olujni-bedem-20180831070834',NULL,NULL,NULL,NULL,'2018-08-31 07:08:36',NULL),(10,1,949.00,NULL,0,5,'978-86-521-2793-1','Duge noći i crne zastave - Ćirilica','duge-noci-i-crne-zastave-cirilica','<p class=\"ql-align-justify\">Tri viteza. Dva carstva. Jedna bitka koja će promeniti sve.</p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\"> Autor bestselera <em>Konstantinovo raskršće</em>.</p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\"> Oluja se približava... I tri viteza joj kreću u susret. Prvi da bi sačuvao tajnu svog gospodara, drugi da bi dobio ruku žene koju voli, a treći da bi zario bodež u samo srce te oluje...</p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\"> Proleće 1386. godine. Granice Srbije potresaju upadi osmanlijskih pljačkaških hordi. U jednom takvom prepadu, brzi osmanlijski konjanici uspevaju da iz pograničnog manastira ukradu kivot čija je sadržina poznata samo srpskom knezu Lazaru Hrebeljanoviću. Lazar odlučuje da pošalje poteru i za taj zadatak bira dvojicu pripadnika viteškog Reda Zmaja – svog kuma, topličkog vojvodu Milana, i njegovog pobratima, čuvenog mačevaoca Ivana Kosančića. Njima se pridružuje i mladi, svojeglavi vitez Miloš Obilić, koji je zaprosio ruku najmlađe Lazareve kćeri.</p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\"> Trojka kreće u potragu prateći krvavi trag pljačkaša – od Lazareve prestonice Kruševca do Prilepa gde ih čeka stari prijatelj, kraljević Marko Mrnjavčević. U Prilepu nalaze trgovca starinama za koga se priča da je u dosluhu sa demonima. U isto vreme, silna osmanlijska vojska čeka utaborena kod Serdike, a kada glasovi predaka šapnu na uvo emiru Muratu da je kucnuo čas, on se odlučuje na pokret. Prvo na udaru je pogranično utvrđenje Pirot, čiji je kapetan Lazar Musić, knežev rođak, rešen pre da umre nego da Osmanlijama preda tvrđavu.</p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\"> Na samoj granici hrišćanstva, na bedemima ispred kojih se vijore crne zastave i ratni bubnjevi odjekuju u dugim noćima, bitka za kapije Evrope može da počne.</p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\"> „Stojiljković ume da ispriča sjajnu priču. Živopisan i visoko narativan stil, koji u umu slika i te kako dugotrajne slike.“ Markus Ejgar, <em>Wild Rooster</em></p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\"><a href=\"http://www.dugenociicrnezastave.rs/\" target=\"_blank\">www.dugenociicrnezastave.rs</a></p>','13x20cm',336,'cyrillic','paperback','2017-11-19',NULL,NULL,'http://res.cloudinary.com/cvetan/image/upload/v1535692244/Bookstore/Books/Images/duge-noci-i-crne-zastave-cirilica-20180831071043.jpg','Bookstore/Books/Images/duge-noci-i-crne-zastave-cirilica-20180831071043',NULL,NULL,NULL,NULL,'2018-08-31 07:10:45',NULL),(11,1,599.00,449.00,1,5,'978-86-521-1619-5','Kainov ožiljak','kainov-oziljak','<p class=\"ql-align-justify\">Od autora romana <em>Top je bio vreo</em> i <em>Konstantinovo raskršće</em>.</p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\"> Roman o misiji Ive Andrića u nacističkoj Nemačkoj.&nbsp;</p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\"> Proleće je 1939. godine i Evropa je na ivici novog rata. U Berlin, prestonicu nacističke Nemačke, Kraljevina Jugoslavija šalje novog ambasadora. Reč je o vrsnom diplomati, uglednom intelektualcu i književniku Ivi Andriću. Dan nakon prijema kod vođe „hiljadugodišnjeg“ Rajha Adolfa Hitlera, poslanik Andrić će na zgarištu ispred Berlinske opere pronaći knjigu pesama koja nosi naslov <em>Kainov ožiljak</em>. Napisao ju je austrijski nacista rođen u Bosni, misteriozno nestao u Noći dugih noževa. Istovremeno, prateći političke potrese u Evropi, kreću diplomatske i špijunske igre između Nemačke i Kraljevine Jugoslavije koje će imati tragičan ishod u potpisivanju Trojnog pakta, puču 27. marta i neminovnom ratu u kome će goreti cela Evropa. U srcu velikog zla, progonjen nemirima, nesanicom i žudnjom, rastrzan između dužnosti, ljubavi i moralnih dilema, ambasador Andrić će krenuti u potragu za zagonetnim zemljakom i tajnom njegove uklete knjige.</p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\"> Roman <em>Kainov ožiljak</em> je istovremeno uzbudljiv politički triler, priča o nemogućoj ljubavi, potresna istorijska drama, parabola o ljudskosti u dehumanizovanom svetu, partija karata sa đavolom, faustovska dilema jednog velikog pisca i hipoteza o tome kako je nastao Andrićev roman <em>Prokleta avlija</em>.</p>','13x20cm',306,'latin','paperback','2014-10-13',NULL,NULL,'http://res.cloudinary.com/cvetan/image/upload/v1535692329/Bookstore/Books/Images/kainov-oziljak-20180831071208.jpg','Bookstore/Books/Images/kainov-oziljak-20180831071208',NULL,NULL,NULL,NULL,'2018-08-31 07:12:10',NULL),(12,1,699.00,499.00,0,5,'978-86-521-1927-1','Kišni psi','kisni-psi','<p class=\"ql-align-justify\">Autor bestselera <em>Konstantinovo raskršće</em> i <em>Kainov ožiljak.</em></p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\"> Iz pera jednog od najčitanijih savremenih srpskih pripovedača dolazi knjiga tematski različitih pripovesti, u vremenskoj elipsi od skoro jednog veka, kroz koje promiču poznati i nepoznati likovi, pletu se sudbine, otkrivaju tajne, rađa se i umire...</p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\"> Susret Ive Andrića i Nemanje Lukića (glavnog junaka romana <em>Konstantinovo raskršće</em>) u priči na osnovu koje je nastao roman <em>Kainov ožiljak</em>. Ukleti pružni prelaz gde duh mrtve devojčice čeka svog ubicu. Četa vojnika na granici sa Kosovom koja nehotice budi usnulo zlo. Tajni život Danila Kiša, pisca, bonvivana i ubice vampira. Beogradski dani Gavrila Principa, bolest, košmari i tajanstveni crnorukac koji je odlučio da baš Gavrilo ubije Franca Ferdinanda. Vremenski skok u neku drugu Srbiju čiji je glavni grad Niš i kojom vlada vojna hunta, gde su čuda ponekad moguća a kišni psi zavijaju u noći.</p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\"> Od Beograda koji opsedaju Austrougari, preko berlinskih bulevara i planina na kojima žive demoni, do apokaliptične vizije Srbije u bliskoj budućnosti, ova knjiga-mozaik odvešće vas na putovanje kroz fantazmagorične svetove u kojima se susreću istorija i mašta.</p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\"> „Ono što treba reći jeste da se za Dejana Stojiljkovića više ne može govoriti da je mlad i talentovan pisac. Svoje majstorstvo pripovedanja on je dokazao postajući predvodnik nove generacije srpskih autora.“ -&nbsp;Dejan Milutinović,&nbsp;<em>Letopis Matice srpske</em></p>','13x20cm',224,'latin','paperback','2015-07-01',NULL,NULL,'http://res.cloudinary.com/cvetan/image/upload/v1535692477/Bookstore/Books/Images/kisni-psi-20180831071436.jpg','Bookstore/Books/Images/kisni-psi-20180831071436',NULL,NULL,NULL,NULL,'2018-08-31 07:14:38',NULL),(13,1,1099.00,NULL,0,1,'978-86-521-1498-6','Znamenje anđela - posebno izdanje ','znamenje-anela-posebno-izdanje','<p class=\"ql-align-justify\">Od autora bestselera <em>Konstantinovo raskršće</em> i <em>Duge noći i crne zastave</em>.</p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\"> Posebno izdanje sa ilustrovanim dodatkom.&nbsp;</p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\"> Godine 297. rimski cezar Galerije kreće u osvetnički pohod na Istok da se obračuna sa Persijom i njenim vladarom. U njegovoj armiji, naći će se tri čoveka koje povezuje nevidljiva nit sudbine: Georgije, stameni i harizmatični general iz Kapadokije, Dimitrije, potomak ugledne senatorske porodice iz Soluna, i Konstantin, mladi naslednik prestola na Zapadu. Galerije, veliki progonitelj hrišćana, ni ne sluti da pod njegovom zastavom jašu tri čoveka koji će snagom volje i prijateljstva promeniti tok istorije i postati hrišćanski sveci – jer...</p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\"> Nebo se ne osvaja ognjem i čelikom.&nbsp;Nebo se osvaja vrlinom.</p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\"> Ovo posebno izdanje romana <em>Znamenje anđela</em>, u kome se pripoveda o tri rimska vojnika čija će dela označiti osvit jednog novog doba i uzdizanje hrišćanske vere, sadrži ilustrovani dodatak (Appendix) sa deset eseja nastalih na osnovu autorovog dugogodišnjeg istraživanja i prikupljanja građe za roman. U njima je data istorijska pozadina opisanih događaja, naročito perioda vladavine tetrarha i dolaska Konstantina Velikog na vlast, predstavljeno turbulentno vreme pozne antike kao i mesta glavnih protaginista romana u istorijskom kontekstu, te svojverstan portret Rimske imperije na samom početku njenog neumitnog opadanja. Dodatak je posebno obogaćen ilustracijama i fotografijama od kojih se neke po prvi put stavljaju na uvid čitaocima.</p>','13x20cm',392,'latin','hardcover','2015-06-01',NULL,NULL,'http://res.cloudinary.com/cvetan/image/upload/v1535692586/Bookstore/Books/Images/znamenje-anela-posebno-izdanje-20180831071625.jpg','Bookstore/Books/Images/znamenje-anela-posebno-izdanje-20180831071625',NULL,NULL,NULL,NULL,'2018-08-31 07:16:27',NULL);
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `books_categories`
--

DROP TABLE IF EXISTS `books_categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `books_categories` (
  `book_id` int(10) unsigned NOT NULL,
  `category_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`book_id`,`category_id`),
  KEY `category_id` (`category_id`),
  KEY `book_id` (`book_id`),
  CONSTRAINT `books_categories_ibfk_1` FOREIGN KEY (`book_id`) REFERENCES `books` (`id`),
  CONSTRAINT `books_categories_ibfk_2` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books_categories`
--

LOCK TABLES `books_categories` WRITE;
/*!40000 ALTER TABLE `books_categories` DISABLE KEYS */;
INSERT INTO `books_categories` VALUES (3,9),(4,9),(5,9),(9,9),(10,9),(11,9),(12,9),(13,9),(6,12),(7,12),(8,12),(4,17),(9,17),(10,17),(11,17),(13,17),(4,18),(9,18),(11,18),(3,30),(4,30),(5,30);
/*!40000 ALTER TABLE `books_categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categories` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `parent` int(10) unsigned DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `slug` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `title_tag` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `description_tag` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `slug` (`slug`),
  KEY `parent` (`parent`),
  KEY `name` (`name`),
  CONSTRAINT `categories_ibfk_1` FOREIGN KEY (`parent`) REFERENCES `categories` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (3,NULL,'Akcioni','akcioni','<p class=\"ql-align-justify\">Liter homines, aliter philosophos loqui putas oportere? Tu quidem reddes; Duo Reges: constructio interrete. Ut aliquid scire se gaudeant? Si mala non sunt, iacet omnis ratio Peripateticorum. </p>','Akcioni :: Bookstore prodavnica knjiga',NULL,'2018-08-26 02:54:14',NULL),(9,NULL,'Domaći autori','domaci-autori',NULL,NULL,NULL,'2018-08-27 00:29:36',NULL),(12,NULL,'Epska fantastika','epska-fantastika',NULL,NULL,NULL,'2018-08-27 00:30:07',NULL),(14,NULL,'Fantastika','fantastika',NULL,NULL,NULL,'2018-08-27 00:30:25',NULL),(16,NULL,'Horor','horor',NULL,NULL,NULL,'2018-08-27 00:30:40',NULL),(17,NULL,'Istorija','istorija',NULL,NULL,NULL,'2018-08-27 00:30:51',NULL),(18,NULL,'Istorijski triler','istorijski-triler',NULL,NULL,NULL,'2018-08-27 00:31:02',NULL),(19,NULL,'Klasici','klasici',NULL,NULL,NULL,'2018-08-27 00:31:50',NULL),(20,NULL,'Kriminalistički','kriminalisticki',NULL,NULL,NULL,'2018-08-27 00:31:58',NULL),(24,NULL,'Naučna fantastika','naucna-fantastika',NULL,NULL,NULL,'2018-08-27 00:32:32',NULL),(29,NULL,'Putopisi','putopisi',NULL,NULL,NULL,'2018-08-27 00:33:14',NULL),(30,NULL,'Trileri','trileri',NULL,NULL,NULL,'2018-08-27 00:33:25',NULL);
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cities`
--

DROP TABLE IF EXISTS `cities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cities` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `postal_code` char(5) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `postal_code` (`postal_code`),
  KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=1172 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cities`
--

LOCK TABLES `cities` WRITE;
/*!40000 ALTER TABLE `cities` DISABLE KEYS */;
INSERT INTO `cities` VALUES (1,'11000','Beograd'),(2,'11010','Beograd Voždovac'),(3,'11030','Beograd Čukarica'),(4,'11050','Beograd Zvezdara'),(5,'11060','Beograd Palilula'),(6,'11070','Novi Beograd'),(7,'11080','Beograd Zemun'),(8,'11090','Beograd Rakovica'),(9,'11130','Kaluđerica'),(10,'11194','Rušanj'),(11,'11211','Borča'),(12,'11212','Ovča'),(13,'11213','Padinska Skela'),(14,'11223','Beli Potok'),(15,'11224','Vrčin'),(16,'11225','Zuce'),(17,'11226','Pinosava'),(18,'11232','Ripanj'),(19,'11233','Ralja'),(20,'11235','Mali Požarevac'),(21,'11251','Ostružnica'),(22,'11253','Sremčica'),(23,'11260','Umka'),(24,'11261','Mala Moštanica'),(25,'11262','Velika Moštanica'),(26,'11271','Surčin'),(27,'11272','Dobanovci'),(28,'11275','Boljevci'),(29,'11276','Jakovo'),(30,'11277','Ugrinovci'),(31,'11279','Bečmen'),(32,'11280','Progar'),(33,'11282','Petrovčić'),(34,'11300','Smederevo'),(35,'11306','Grocka'),(36,'11307','Boleč'),(37,'11308','Begaljica'),(38,'11309','Leštane'),(39,'11310','Lipe'),(40,'11311','Radinac'),(41,'11312','Mihajlovac'),(42,'11313','Mala Krsna'),(43,'11314','Osipaonica'),(44,'11315','Saraorci'),(45,'11316','Golobok'),(46,'11317','Lozovik'),(47,'11318','Miloševac'),(48,'11319','Krnjevo'),(49,'11320','Velika Plana'),(50,'11321','Lugavcina'),(51,'11322','Skobalj'),(52,'11323','Veliko Orašje'),(53,'11324','Staro Selo'),(54,'11325','Markovac'),(55,'11326','Donja Livadica'),(56,'11327','Rakinac'),(57,'11328','Vodanj'),(58,'11329','Vranovo'),(59,'11351','Vinča'),(60,'11400','Mladenovac'),(61,'11406','Vlaška'),(62,'11407','Selevac'),(63,'11408','Velika Krsna'),(64,'11409','Kovačevac'),(65,'11411','Ratari'),(66,'11412','Jagnjilo'),(67,'11413','Pružatovac'),(68,'11414','Velika Ivanča'),(69,'11415','Koraćica'),(70,'11420','Smederevska Palanka'),(71,'11423','Azanja'),(72,'11424','Banicina'),(73,'11425','Kusadak'),(74,'11426','Meljak'),(75,'11427','Vranić'),(76,'11430','Umčari'),(77,'11431','Kolari'),(78,'11432','Drugovac'),(79,'11433','Šepšin'),(80,'11450','Sopot'),(81,'11453','Rogača'),(82,'11454','Sibnica'),(83,'11460','Barajevo'),(84,'11461','Beljina'),(85,'11462','Veliki Borak'),(86,'11500','Obrenovac'),(87,'11504','Barič'),(88,'11505','Zabrežje'),(89,'11506','Draževac'),(90,'11507','Stubline'),(91,'11508','Grabovac'),(92,'11509','Skela'),(93,'11550','Lazarevac'),(94,'11560','Vreoci'),(95,'11561','Dudovica'),(96,'11562','Junkovac'),(97,'11563','Veliki Crljeni'),(98,'11564','Stepojevac'),(99,'11565','Barosevac'),(100,'11566','Rudovci'),(101,'11567','Mirosaljci'),(102,'12000','Požarevac'),(103,'12205','Brezane'),(104,'12206','Bradarac'),(105,'12207','Dubravica'),(106,'12208','Kostolac'),(107,'12209','Kličevac'),(108,'12220','Veliko Gradište'),(109,'12221','Majilovac'),(110,'12222','Braničevo'),(111,'12223','Golubac'),(112,'12224','Dobra'),(113,'12225','Bratinac'),(114,'12226','Topolovnik'),(115,'12229','Vinci'),(116,'12230','Brnjica'),(117,'12240','Kučevo'),(118,'12242','Neresnica'),(119,'12253','Srednjevo'),(120,'12254','Rabrovo'),(121,'12255','Duboka'),(122,'12256','Voluja'),(123,'12258','Klenje'),(124,'12300','Petrovac Na Mlavi'),(125,'12304','Ranovac'),(126,'12305','Melnica'),(127,'12306','Veliko Laole'),(128,'12307','Burovac'),(129,'12309','Šetonje'),(130,'12311','Malo Crniće'),(131,'12312','Smoljinac'),(132,'12313','Bozevac'),(133,'12314','Veliko Selo'),(134,'12315','Rašanac'),(135,'12316','Krepoljin'),(136,'12317','Osanica'),(137,'12318','Vukovac'),(138,'12320','Žagubica'),(139,'12321','Laznica'),(140,'12322','Suvi Do'),(141,'12370','Aleksandrovac'),(142,'12371','Vlaški Do'),(143,'12372','Poljana'),(144,'12373','Simićevo'),(145,'12374','Žabari'),(146,'12375','Porodin'),(147,'14000','Valjevo'),(148,'14201','Brankovina'),(149,'14202','Rajković'),(150,'14203','Dračić'),(151,'14204','Divčibare'),(152,'14205','Lelić'),(153,'14206','Poćuta'),(154,'14207','Pećka'),(155,'14210','Ub'),(156,'14211','Radljevo'),(157,'14212','Brgule'),(158,'14213','Pambukovica'),(159,'14214','Banjani'),(160,'14221','Popučke'),(161,'14222','Divci'),(162,'14223','Slovac'),(163,'14224','Lajkovac'),(164,'14225','Bogovadja'),(165,'14226','Jabučje'),(166,'14240','Ljig'),(167,'14242','Mionica'),(168,'14243','Gornja Toplica'),(169,'14244','Brezde'),(170,'14245','Slavkovica'),(171,'14246','Belanovica'),(172,'14251','Pricevic'),(173,'14252','Kamenica'),(174,'14253','Osečina'),(175,'14254','Komirić'),(176,'14255','Stave'),(177,'15000','Šabac'),(178,'15211','Mačvanski Pričinović'),(179,'15212','Drenovac'),(180,'15213','Orid'),(181,'15214','Debeljača'),(182,'15215','Provo'),(183,'15220','Koceljeva'),(184,'15221','Svileuva'),(185,'15222','Kamenica'),(186,'15224','Cerovac'),(187,'15225','Vladimirci'),(188,'15226','Draginje'),(189,'15227','Donje Crniljevo'),(190,'15232','Varna'),(191,'15233','Metlić'),(192,'15234','Tekeriš'),(193,'15235','Dobrić'),(194,'15300','Loznica'),(195,'15302','Korenita'),(196,'15303','Tršić'),(197,'15304','Petlovača'),(198,'15305','Lipolist'),(199,'15306','Prnjavor Mačvanski'),(200,'15307','Lešnica'),(201,'15308','Jadranska Lešnica'),(202,'15309','Brezjak'),(203,'15310','Ribari'),(204,'15311','Draginac'),(205,'15312','Zavlaka'),(206,'15313','Bela Crkva'),(207,'15314','Krupanj'),(208,'15315','Zajaca'),(209,'15316','Banja Koviljača'),(210,'15317','Donja Borina'),(211,'15318','Mali Zvornik'),(212,'15319','Uzovnica'),(213,'15320','Ljubovija'),(214,'15321','Radalj'),(215,'15322','Velika Reka'),(216,'15323','Donja Orovica'),(217,'15324','Drlace'),(218,'15350','Bogatić'),(219,'15352','Zminjak'),(220,'15353','Majur'),(221,'15354','Štitar'),(222,'15355','Crna Bara'),(223,'15356','Glušci'),(224,'15357','Klenje'),(225,'15358','Badovinci'),(226,'15359','Dublje'),(227,'15362','Banovo Polje'),(228,'16000','Leskovac'),(229,'16201','Manojlovce'),(230,'16203','Vučje'),(231,'16204','Miroševce'),(232,'16205','Bojnik'),(233,'16206','Kosančić'),(234,'16210','Vlasotince'),(235,'16212','Svođe'),(236,'16213','Sastav Reka'),(237,'16215','Crna Trava'),(238,'16220','Grdelica'),(239,'16221','Velika Grabovnica'),(240,'16222','Predejane'),(241,'16223','Ruplje'),(242,'16230','Lebane'),(243,'16231','Turekovac'),(244,'16232','Bosnjace'),(245,'16233','Orane'),(246,'16240','Medvedja'),(247,'16244','Gornji Brestovac'),(248,'16246','Sijarinska Banja'),(249,'16247','Tulare'),(250,'16248','Lece'),(251,'16251','Pecanjevce'),(252,'16252','Razgojna'),(253,'16253','Brestovac'),(254,'17500','Vranje'),(255,'17507','Vlase'),(256,'17508','Sveti Ilija'),(257,'17510','Vladičin Han'),(258,'17511','Priboj Vranjski'),(259,'17512','Stubal'),(260,'17513','Lepenica'),(261,'17514','Džep'),(262,'17520','Bujanovac'),(263,'17521','Ristovac'),(264,'17522','Biljaca'),(265,'17523','Preševo'),(266,'17524','Klenike'),(267,'17525','Trgovište'),(268,'17526','Donji Stajevac'),(269,'17529','Muhovac'),(270,'17530','Surdulica'),(271,'17531','Jelašnica'),(272,'17532','Vlasina Okruglica'),(273,'17533','Vlasina Rid'),(274,'17534','Vlasina Stojkovićevo'),(275,'17535','Klisura'),(276,'17537','Bozica'),(277,'17538','Gornja Lisina'),(278,'17540','Bosilegrad'),(279,'17542','Vranjska Banja'),(280,'17543','Kriva Feja'),(281,'17544','Donja Ljubata'),(282,'17545','Korbevac'),(283,'17546','Bistar'),(284,'17547','Donje Tlamino'),(285,'17556','Reljan'),(286,'17557','Oraovica'),(287,'17567','Bujanovac'),(288,'18000','Niš'),(289,'18201','Lalinac'),(290,'18202','Gornja Toponica'),(291,'18204','Gornji Matejevac'),(292,'18205','Niška Banja'),(293,'18206','Jelašnica'),(294,'18207','Malča'),(295,'18208','Guševac'),(296,'18209','Medoševac'),(297,'18210','Žitkovac'),(298,'18211','Trupale'),(299,'18212','Tešica'),(300,'18213','Gredetin'),(301,'18214','Kulina'),(302,'18215','Veliko Bonjince'),(303,'18216','Korman'),(304,'18217','Ljuberadja'),(305,'18219','Grejac'),(306,'18220','Aleksinac'),(307,'18223','Draževac(kod Aleksinca)'),(308,'18224','Rutevac'),(309,'18225','Katun'),(310,'18226','Aleksinacki Rudnik'),(311,'18227','Subotinac'),(312,'18228','Luzane'),(313,'18229','Mozgovo'),(314,'18230','Soko Banja'),(315,'18232','Čitluk'),(316,'18234','Jošanica'),(317,'18235','Šarbanovac'),(318,'18237','Dugo Polje'),(319,'18240','Gadžin Han'),(320,'18241','Gornji Barbes'),(321,'18242','Donji Dušnik'),(322,'18244','Zaplanjska Toponica'),(323,'18245','Lički Hanovi'),(324,'18246','Ravna Dubrava'),(325,'18250','Novo Selo'),(326,'18251','Mramor'),(327,'18252','Merošina'),(328,'18253','Jugbogdanovac'),(329,'18254','Donje Medurovo'),(330,'18255','Pukovac'),(331,'18257','Balajinac'),(332,'18258','Jovanovac'),(333,'18260','Popovac'),(334,'18300','Pirot'),(335,'18304','Crnokliste'),(336,'18306','Visoka Rzana'),(337,'18307','Krupač'),(338,'18310','Bela Palanka'),(339,'18311','Sićevo'),(340,'18312','Ostrovica'),(341,'18313','Crvena Reka'),(342,'18314','Dolac'),(343,'18315','Babin Kal'),(344,'18320','Dimitrovgrad'),(345,'18321','Gradina'),(346,'18322','Sukovo'),(347,'18323','Smilovci'),(348,'18324','Kamenica'),(349,'18326','Poganovo'),(350,'18330','Babusnica'),(351,'18332','Strelac'),(352,'18333','Zvonce'),(353,'18355','Temska'),(354,'18360','Svrljig'),(355,'18363','Palilula'),(356,'18365','Prekonoga'),(357,'18366','Niševac'),(358,'18368','Burdimo'),(359,'18400','Prokuplje'),(360,'18403','Velika Plana'),(361,'18404','Donja Rečica'),(362,'18405','Džigolj'),(363,'18406','Dubovo'),(364,'18407','Žitni Potok'),(365,'18408','Dobri Do'),(366,'18409','Kruševica'),(367,'18410','Doljevac'),(368,'18411','Belotinac'),(369,'18412','Žitoradja'),(370,'18413','Pejkovac'),(371,'18414','Donje Crnatovo'),(372,'18415','Malošište'),(373,'18417','Cecina'),(374,'18420','Blace'),(375,'18421','Donja Trnava'),(376,'18423','Mala Plana'),(377,'18424','Beloljin'),(378,'18425','Gornja Draguša'),(379,'18426','Barbatovac'),(380,'18430','Kuršumlija'),(381,'18432','Barlovo'),(382,'18433','Prolom'),(383,'18435','Kuršumlijska Banja'),(384,'18436','Merćez'),(385,'18437','Lukovo'),(386,'18438','Zuc'),(387,'18440','Rača'),(388,'18445','Merdare'),(389,'19000','Zaječar'),(390,'19204','Metovnica'),(391,'19205','Gradskovo'),(392,'19206','Veliki Izvor'),(393,'19207','Planinica'),(394,'19208','Lubnica'),(395,'19209','Mali Jasenovac'),(396,'19210','Bor'),(397,'19213','Donja Bela Reka'),(398,'19214','Rgotina'),(399,'19215','Zlot'),(400,'19216','Brestovačka Banja'),(401,'19219','Krivelj'),(402,'19220','Donji Milanovac'),(403,'19222','Klokočevac'),(404,'19223','Koprivnica'),(405,'19224','Salaš'),(406,'19225','Sikole'),(407,'19227','Zvezdan'),(408,'19228','Gamzigradska Banja'),(409,'19229','Borski Brestovac'),(410,'19231','Borsko Bucje'),(411,'19234','Luka'),(412,'19235','Velika Jasikova'),(413,'19236','Halovo'),(414,'19250','Majdanpek'),(415,'19257','Rudna Glava'),(416,'19300','Negotin'),(417,'19303','Štubik'),(418,'19304','Jabukovac'),(419,'19305','Urovica'),(420,'19306','Trnjane'),(421,'19311','Nikolićevo'),(422,'19312','Vražogrnac'),(423,'19313','Brusnik'),(424,'19314','Rajac'),(425,'19315','Bracevac'),(426,'19316','Kobišnica'),(427,'19317','Mokranja'),(428,'19318','Rogljevo'),(429,'19320','Kladovo'),(430,'19321','Podvrška'),(431,'19322','Mihajlovac'),(432,'19323','Brza Palanka'),(433,'19324','Slatina'),(434,'19325','Tekija'),(435,'19326','Sip'),(436,'19328','Velesnica'),(437,'19329','Korbovo'),(438,'19330','Prahovo'),(439,'19334','Radujevac'),(440,'19335','Dušanovac'),(441,'19340','Minićevo'),(442,'19341','Grljan'),(443,'19342','Grlište'),(444,'19343','Lenovac'),(445,'19344','Vratarnica'),(446,'19345','Donje Zuniće'),(447,'19347','Mali Izvor'),(448,'19350','Knjaževac'),(449,'19352','Donja Kamenica'),(450,'19353','Kalna'),(451,'19362','Podvis'),(452,'19366','Beli Potok'),(453,'19367','Vasilj'),(454,'19369','Bucje'),(455,'19370','Boljevac'),(456,'19371','Lukovo'),(457,'19372','Bogovina'),(458,'19373','Šarbanovac'),(459,'19375','Krivi Vir'),(460,'19376','Sumrakovac'),(461,'19377','Savinac'),(462,'19378','Osnić'),(463,'19379','Šarbanovac Timok'),(464,'21000','Novi Sad'),(465,'21131','Petrovaradin'),(466,'21201','Rumenka'),(467,'21203','Veternik'),(468,'21205','Sremski Karlovci'),(469,'21206','Stari Ledinci'),(470,'21207','Ledinci'),(471,'21208','Sremska Kamenica'),(472,'21209','Bukovac'),(473,'21211','Kisač'),(474,'21212','Stepanovićevo'),(475,'21213','Zmajevo'),(476,'21214','Sirig'),(477,'21215','Turija'),(478,'21216','Nadalj'),(479,'21217','Bačko Gradište'),(480,'21220','Bečej'),(481,'21225','Radičević'),(482,'21226','Bačko Petrovo Selo'),(483,'21227','Mileševo'),(484,'21230','Žabalj'),(485,'21233','Čenej'),(486,'21234','Bački Jarak'),(487,'21235','Temerin'),(488,'21237','Gospođinci'),(489,'21238','Čurug'),(490,'21239','Đurdjevo'),(491,'21240','Titel'),(492,'21241','Kać'),(493,'21242','Budisava'),(494,'21243','Kovilj'),(495,'21244','Šajkaš'),(496,'21245','Mošorin'),(497,'21246','Vilovo'),(498,'21247','Gardinovci'),(499,'21248','Lok'),(500,'21299','Rakovac'),(501,'21300','Beočin'),(502,'21311','Čerević'),(503,'21312','Banoštor'),(504,'21313','Susek'),(505,'21314','Neštin'),(506,'21315','Lug'),(507,'21400','Bačka Palanka'),(508,'21410','Futog'),(509,'21411','Begeč'),(510,'21412','Gložan'),(511,'21413','Čelarevo'),(512,'21420','Bač'),(513,'21421','Karađorđevo'),(514,'21422','Mladenovo'),(515,'21423','Obrovac'),(516,'21424','Tovariševo'),(517,'21425','Selenča'),(518,'21426','Vajska'),(519,'21427','Bodjani'),(520,'21428','Plavna'),(521,'21429','Bačko Novo Selo'),(522,'21431','Nova Gajdobra'),(523,'21432','Gajdobra'),(524,'21433','Silbaš'),(525,'21434','Parage'),(526,'21460','Vrbas'),(527,'21465','Bačko Dobro Polje'),(528,'21466','Kucura'),(529,'21467','Savino Selo'),(530,'21468','Despotovo'),(531,'21469','Pivnice'),(532,'21470','Bački Petrovac'),(533,'21471','Ravno Selo'),(534,'21472','Kulpin'),(535,'21473','Maglić'),(536,'21480','Srbobran'),(537,'22000','Sremska Mitrovica'),(538,'22201','Zasavica'),(539,'22202','Mačvanska Mitrovica'),(540,'22203','Noćaj'),(541,'22204','Salaš Noćajski'),(542,'22205','Ravnje'),(543,'22206','Radenković'),(544,'22207','Ležimir'),(545,'22208','Mandjelos'),(546,'22211','Veliki Radinci'),(547,'22212','Bešenovo'),(548,'22213','Grgurevci'),(549,'22217','Bosut'),(550,'22221','Laćarak'),(551,'22222','Martinci'),(552,'22223','Kuzmin'),(553,'22224','Kukujevci'),(554,'22225','Bacinci'),(555,'22230','Erdevik'),(556,'22231','Čalma'),(557,'22232','Divoš'),(558,'22240','Šid'),(559,'22241','Vasica'),(560,'22242','Berkasovo'),(561,'22243','Sot'),(562,'22244','Adasevci'),(563,'22245','Morović'),(564,'22246','Višnjićevo'),(565,'22247','Sremska Rača'),(566,'22248','Jamena'),(567,'22250','Ilinci'),(568,'22251','Batrovci'),(569,'22253','Bingula'),(570,'22254','Bikić Do'),(571,'22255','Ljuba'),(572,'22256','Molovin'),(573,'22257','Privina Glava'),(574,'22258','Gibarac'),(575,'22300','Stara Pazova'),(576,'22303','Banovci Dunav'),(577,'22304','Novi Banovci'),(578,'22305','Stari Banovci'),(579,'22306','Belegiš'),(580,'22307','Surduk'),(581,'22308','Golubinci'),(582,'22310','Šimanovci'),(583,'22313','Vojka'),(584,'22314','Krnješevci'),(585,'22320','Inđija'),(586,'22321','Ljukovo'),(587,'22322','Novi Karlovci'),(588,'22323','Novi Slankamen'),(589,'22324','Beška'),(590,'22325','Krčedin'),(591,'22326','Čortanovci'),(592,'22327','Maradik'),(593,'22328','Krušedol'),(594,'22329','Stari Slankamen'),(595,'22330','Nova Pazova'),(596,'22400','Ruma'),(597,'22404','Putinci'),(598,'22405','Stejanovci'),(599,'22406','Irig'),(600,'22408','Vrdnik'),(601,'22409','Jazak'),(602,'22410','Pećinci'),(603,'22411','Kraljevci'),(604,'22412','Dobrinci'),(605,'22413','Sremski Mihaljevci'),(606,'22414','Subotište'),(607,'22416','Ogar'),(608,'22417','Obrez'),(609,'22418','Asanja'),(610,'22419','Kupinovo'),(611,'22420','Platičevo'),(612,'22421','Budjanovci'),(613,'22422','Nikinci'),(614,'22423','Grabovci'),(615,'22424','Klenak'),(616,'22425','Šašinci'),(617,'22427','Hrtkovci'),(618,'22428','Popinci'),(619,'22429','Voganj'),(620,'22431','Vitojevci'),(621,'22440','Sibač'),(622,'22441','Dec'),(623,'22442','Prhovo'),(624,'22443','Karlovčić'),(625,'23000','Zrenjanin'),(626,'23202','Mihajlovo'),(627,'23203','Ečka'),(628,'23204','Stajićevo'),(629,'23205','Belo Blato'),(630,'23206','Muzlja'),(631,'23207','Aradac'),(632,'23208','Elemir'),(633,'23209','Taraš'),(634,'23210','Žitište'),(635,'23211','Klek'),(636,'23212','Ravni Topolovac'),(637,'23213','Banatski Dvor'),(638,'23214','Torda'),(639,'23215','Cestereg'),(640,'23216','Banatsko Karađorđevo'),(641,'23217','Aleksandrovo'),(642,'23218','Nova Crnja'),(643,'23219','Vojvoda Stepa'),(644,'23220','Srpska Crnja'),(645,'23221','Radojevo'),(646,'23222','Toba'),(647,'23224','Lukino Selo'),(648,'23230','Jaša Tomić'),(649,'23231','Krajišnik'),(650,'23232','Begejci'),(651,'23233','Srpski Itebej'),(652,'23234','Medja'),(653,'23235','Hetin'),(654,'23236','Novi Itebej'),(655,'23237','Banatsko Višnjićevo'),(656,'23240','Sečanj'),(657,'23241','Lazarevo'),(658,'23242','Banatski Despotovac'),(659,'23243','Botos'),(660,'23244','Sutjeska'),(661,'23245','Neuzina'),(662,'23250','Jarkovac'),(663,'23251','Banatska Dubica'),(664,'23252','Boka'),(665,'23253','Konak'),(666,'23254','Surjan'),(667,'23255','Zlatica'),(668,'23260','Perlez'),(669,'23261','Lukićevo'),(670,'23262','Tomaševac'),(671,'23263','Orlovat'),(672,'23264','Farkaždin'),(673,'23265','Knićanin'),(674,'23266','Ćenta'),(675,'23270','Melenci'),(676,'23271','Kumane'),(677,'23272','Novi Bečej'),(678,'23273','Novo Miloševo'),(679,'23274','Bocar'),(680,'23300','Kikinda'),(681,'23305','Mokrin'),(682,'23311','Nakovo'),(683,'23312','Banatsko Veliko Selo'),(684,'23313','Novi Kozarci'),(685,'23314','Rusko Selo'),(686,'23315','Banatska Topola'),(687,'23316','Basaid'),(688,'23320','Čoka'),(689,'23323','Iđos'),(690,'23324','Sajan'),(691,'23325','Padej'),(692,'23326','Ostojićevo'),(693,'23327','Jazovo'),(694,'23328','Crna Bara'),(695,'23329','Vrbica'),(696,'23330','Novi Kneževac'),(697,'23331','Sanad'),(698,'23332','Banatsko Arandjelovo'),(699,'23333','Majdan'),(700,'23334','Srpski Krstur'),(701,'23335','Đala'),(702,'24000','Subotica'),(703,'24104','Kelebija'),(704,'24205','Kelebija-granični prelaz'),(705,'24206','Bikovo'),(706,'24207','Orom'),(707,'24210','Bajmok'),(708,'24211','Mišićevo'),(709,'24213','Đurđin'),(710,'24214','Tavankut'),(711,'24215','Ljutovo'),(712,'24217','Mala Bosna'),(713,'24220','Čantavir'),(714,'24222','Višnjevac'),(715,'24223','Novi Zednik'),(716,'24224','Stari Žednik'),(717,'24300','Bačka Topola'),(718,'24308','Karadjordjevo'),(719,'24309','Mali Beograd'),(720,'24311','Njegoševo'),(721,'24312','Gunaroš'),(722,'24313','Pobeda'),(723,'24321','Mali Idjoš'),(724,'24322','Lovćenac'),(725,'24323','Feketić'),(726,'24330','Panonija'),(727,'24331','Bajša'),(728,'24340','Stara Moravica'),(729,'24341','Krivaja'),(730,'24342','Pačir'),(731,'24343','Bački Sokolac'),(732,'24344','Oresković'),(733,'24351','Novo Orahovo'),(734,'24352','Tornjoš'),(735,'24400','Senta'),(736,'24406','Gornji Breg'),(737,'24407','Kevi'),(738,'24408','Bogaras'),(739,'24410','Horgoš'),(740,'24411','Horgoš Granični Prelaz'),(741,'24413','Palić'),(742,'24414','Hajdukovo'),(743,'24415','Bački Vinogradi'),(744,'24416','Male Pijace'),(745,'24417','Martonoš'),(746,'24420','Kanjiža'),(747,'24425','Adorjan'),(748,'24426','Tresnjevac'),(749,'24427','Totovo Selo'),(750,'24430','Ada'),(751,'24435','Mol'),(752,'24437','Utrine'),(753,'25000','Sombor'),(754,'25210','Conoplja'),(755,'25211','Svetozar Miletić'),(756,'25212','Aleksa Santic'),(757,'25220','Crvenka'),(758,'25221','Kljajićevo'),(759,'25222','Telečka'),(760,'25223','Sivac'),(761,'25224','Nova Crvenka'),(762,'25225','Krusčić'),(763,'25230','Kula'),(764,'25232','Lipar'),(765,'25233','Ruski Krstur'),(766,'25234','Lalić'),(767,'25240','Stapar'),(768,'25242','Bački Brestovac'),(769,'25243','Doroslovo'),(770,'25244','Srpski Miletić'),(771,'25245','Bogojevo'),(772,'25250','Odzaci'),(773,'25252','Bački Gracac'),(774,'25253','Ratkovo'),(775,'25254','Deronje'),(776,'25255','Karavukovo'),(777,'25260','Apatin'),(778,'25262','Kupušina'),(779,'25263','Prigrevica'),(780,'25264','Sonta'),(781,'25265','Svilojevo'),(782,'25270','Bezdan'),(783,'25272','Bački Monostor'),(784,'25274','Kolut'),(785,'25275','Bački Breg'),(786,'25280','Ridjica'),(787,'25282','Gakovo'),(788,'25283','Rastina'),(789,'25284','Stanišić'),(790,'26000','Pančevo'),(791,'26201','Jabuka'),(792,'26202','Glogonj'),(793,'26203','Sefkerin'),(794,'26204','Opovo'),(795,'26205','Baranda'),(796,'26206','Sakule'),(797,'26207','Idvor'),(798,'26210','Kovačica'),(799,'26212','Kačarevo'),(800,'26213','Crepaja'),(801,'26215','Padina'),(802,'26216','Uzdin'),(803,'26220','Kovin'),(804,'26222','Bavanište'),(805,'26223','Gaj'),(806,'26224','Dubovac'),(807,'26225','Deliblato'),(808,'26226','Mramorak'),(809,'26227','Dolovo'),(810,'26228','Skorenovac'),(811,'26229','Pločica'),(812,'26230','Omoljica'),(813,'26232','Starčevo'),(814,'26233','Ivanovo'),(815,'26234','Banatski Brestovac'),(816,'26300','Vršac'),(817,'26310','Alibunar'),(818,'26314','Banatsko Novo Selo'),(819,'26315','Vladimirovac'),(820,'26316','Devojački Bunar'),(821,'26320','Banatski Karlovac'),(822,'26322','Nikolinci'),(823,'26323','Crvena Crkva'),(824,'26324','Banatska Palanka'),(825,'26327','Banatska Subotica'),(826,'26328','Dupljaja'),(827,'26329','Kajtasovo'),(828,'26330','Uljma'),(829,'26331','Ritisevo'),(830,'26332','Vlajkovac'),(831,'26333','Pavliš'),(832,'26334','Veliko Središte'),(833,'26335','Gudurica'),(834,'26336','Kuštilj'),(835,'26337','Vatin'),(836,'26338','Vojvodinci'),(837,'26340','Bela Crkva'),(838,'26343','Izbište'),(839,'26345','Straža'),(840,'26346','Jasenovo'),(841,'26347','Grebenac'),(842,'26348','Vračev Gaj'),(843,'26349','Kusić'),(844,'26350','Samoš'),(845,'26351','Seleuš'),(846,'26352','Ilandža'),(847,'26353','Novi Kozjak'),(848,'26354','Dobrica'),(849,'26360','Plandište'),(850,'26361','Lokve'),(851,'26362','Janošik'),(852,'26363','Jermenovci'),(853,'26364','Margita'),(854,'26365','Veliki Gaj'),(855,'26366','Velika Greda'),(856,'26367','Barice'),(857,'26368','Kupinik'),(858,'26370','Hajdučica'),(859,'26371','Stari Lec'),(860,'26373','Miletićevo'),(861,'26380','Kruščica'),(862,'31000','Užice'),(863,'31203','Lunovo Selo'),(864,'31204','Karan'),(865,'31205','Sevojno'),(866,'31206','Ravni'),(867,'31207','Sirogojno'),(868,'31208','Rožanstvo'),(869,'31209','Ljubiš'),(870,'31210','Požega'),(871,'31213','Ježevica'),(872,'31214','Gornja Dobrinja'),(873,'31215','Jelen Do'),(874,'31230','Arilje'),(875,'31233','Kruščica'),(876,'31234','Brekovo'),(877,'31236','Divljaka'),(878,'31237','Roge'),(879,'31241','Bioska'),(880,'31242','Kremna'),(881,'31243','Mokra Gora'),(882,'31244','Šljivovica'),(883,'31250','Bajina Bašta'),(884,'31251','Mitrovac'),(885,'31253','Zlodol'),(886,'31254','Kostojevići'),(887,'31255','Rogačica'),(888,'31256','Perućac'),(889,'31257','Kaluđerske Bare'),(890,'31258','Bačevci'),(891,'31260','Kosjerić'),(892,'31262','Seča Reka'),(893,'31263','Varda'),(894,'31265','Ražana'),(895,'31300','Prijepolje'),(896,'31305','Brodarevo'),(897,'31306','Jabuka'),(898,'31307','Aljinovici'),(899,'31310','Čajetina'),(900,'31311','Bela Zemlja'),(901,'31312','Mačkat'),(902,'31313','Gostilje'),(903,'31314','Jablanica'),(904,'31315','Zlatibor'),(905,'31317','Draglica'),(906,'31318','Kokin Brod'),(907,'31319','Jasenovo'),(908,'31320','Nova Varoš'),(909,'31322','Bozetici'),(910,'31325','Bistrica'),(911,'31330','Priboj'),(912,'31335','Sastavci'),(913,'31337','Banja Kod Priboja'),(914,'32000','Čačak'),(915,'32205','Trbušani'),(916,'32206','Kamenica'),(917,'32210','Mrčajevci'),(918,'32211','Mojsinje'),(919,'32212','Preljina'),(920,'32213','Bresnica'),(921,'32215','Gornja Trepca'),(922,'32221','Trnava'),(923,'32222','Ježevica'),(924,'32223','Zablaće'),(925,'32224','Slatina'),(926,'32225','Goričani'),(927,'32230','Guča'),(928,'32232','Goračići'),(929,'32234','Kaona'),(930,'32235','Kotraža'),(931,'32240','Lučani'),(932,'32242','Ovčar Banja'),(933,'32243','Markovica'),(934,'32250','Ivanjica'),(935,'32251','Bukovica'),(936,'32252','Prilicki Kiseljak'),(937,'32253','Brezova'),(938,'32254','Vionica'),(939,'32255','Medjurečje'),(940,'32256','Bratljevo'),(941,'32257','Kovilje'),(942,'32258','Kušići'),(943,'32259','Bele Vode'),(944,'32300','Gornji Milanovac'),(945,'32303','Brđani'),(946,'32304','Takovo'),(947,'32305','Bersici'),(948,'32306','Gornji Banjani'),(949,'32307','Brezna'),(950,'32308','Pranjani'),(951,'32311','Šilopaj'),(952,'32312','Boljkovci'),(953,'32313','Rudnik'),(954,'32314','Ugrinovci'),(955,'32315','Vračevšnica'),(956,'34000','Kragujevac'),(957,'34202','Grosnica'),(958,'34203','Ilićevo'),(959,'34204','Divostin'),(960,'34205','Bare'),(961,'34206','Gornja Sabanta'),(962,'34207','Erdec'),(963,'34209','Marsic'),(964,'34210','Rača Kragujevačka'),(965,'34211','Jovanovac'),(966,'34212','Malo Krcmare'),(967,'34214','Veliko Krčmare'),(968,'34215','Đurdjevo'),(969,'34216','Male Pčelice'),(970,'34217','Bukurovac'),(971,'34220','Lapovo'),(972,'34223','Lapovo Selo'),(973,'34224','Korman'),(974,'34225','Resnik'),(975,'34226','Badnjevac'),(976,'34227','Batočina'),(977,'34228','Brzan'),(978,'34229','Zirovnica'),(979,'34230','Gruza'),(980,'34231','Dragobraca'),(981,'34232','Guberevac'),(982,'34240','Knić'),(983,'34242','Bumbarevo Brdo'),(984,'34243','Toponica'),(985,'34244','Zabojnica'),(986,'34300','Arandjelovac'),(987,'34301','Bukovik'),(988,'34302','Ranilovic'),(989,'34303','Arandjelovac'),(990,'34304','Banja'),(991,'34305','Darosava'),(992,'34306','Vencane'),(993,'34307','Stojnik'),(994,'34308','Orašac'),(995,'34309','Jelovik'),(996,'34310','Topola'),(997,'34312','Belosavci'),(998,'34313','Natalinci'),(999,'34314','Donja Satornja'),(1000,'34318','Jarmenovci'),(1001,'34321','Desimirovac'),(1002,'34322','Čumić'),(1003,'34323','Stragari'),(1004,'34325','Lužnice'),(1005,'35000','Jagodina'),(1006,'35203','Siokovac'),(1007,'35204','Bagrdan'),(1008,'35205','Jovac'),(1009,'35206','Raševica'),(1010,'35207','Potočac'),(1011,'35208','Vojska'),(1012,'35209','Subotica Kod Svilajnca'),(1013,'35210','Svilajnac'),(1014,'35211','Sedlare'),(1015,'35212','Plažane'),(1016,'35213','Despotovac'),(1017,'35215','Stenjevac'),(1018,'35217','Bobovo'),(1019,'35219','Končarevo'),(1020,'35220','Ribare'),(1021,'35222','Glogovac'),(1022,'35223','Veliki Popović'),(1023,'35224','Medvedja'),(1024,'35226','Kušiljevo'),(1025,'35227','Krušar'),(1026,'35228','Supska'),(1027,'35230','Ćuprija'),(1028,'35233','Senje'),(1029,'35234','Senjski Rudnik'),(1030,'35235','Ravna Reka'),(1031,'35236','Mijatovac'),(1032,'35237','Resavica'),(1033,'35238','Bigrenica'),(1034,'35241','Jasenovo'),(1035,'35242','Kolare'),(1036,'35247','Plana'),(1037,'35248','Trešnjevica'),(1038,'35249','Busilovac'),(1039,'35250','Paraćin'),(1040,'35254','Popovac'),(1041,'35255','Donja Mutnica'),(1042,'35256','Sikirica'),(1043,'35257','Drenovac'),(1044,'35258','Donje Vidovo'),(1045,'35259','Svojnovo'),(1046,'35260','Rekovac'),(1047,'35261','Glavinci'),(1048,'35262','Dragoševac'),(1049,'35263','Belusic'),(1050,'35264','Prevešt'),(1051,'35265','Dragovo'),(1052,'35267','Oparić'),(1053,'35268','Miloševo'),(1054,'35269','Strižilo'),(1055,'35270','Majur'),(1056,'35271','Novo Lanište'),(1057,'35272','Dragocvet'),(1058,'35273','Bunar'),(1059,'36000','Kraljevo'),(1060,'36201','Mataruška Banja'),(1061,'36202','Samaila'),(1062,'36203','Adrani'),(1063,'36204','Lađevci'),(1064,'36205','Roćevci'),(1065,'36206','Vitanovac'),(1066,'36207','Vitkovac'),(1067,'36208','Sirča'),(1068,'36210','Vrnjačka Banja'),(1069,'36212','Ratina'),(1070,'36214','Vrba'),(1071,'36215','Podunavci'),(1072,'36216','Novo Selo'),(1073,'36217','Vrnjci'),(1074,'36220','Čukojevac'),(1075,'36221','Zica'),(1076,'36222','Rudno'),(1077,'36300','Novi Pazar'),(1078,'36305','Dezeva'),(1079,'36306','Lukare'),(1080,'36307','Delimede'),(1081,'36308','Sopoćani'),(1082,'36309','Ribarice'),(1083,'36310','Sjenica'),(1084,'36311','Štavalj'),(1085,'36312','Duga Poljana'),(1086,'36313','Ugao'),(1087,'36320','Tutin'),(1088,'36321','Crkvine'),(1089,'36340','Konarevo'),(1090,'36341','Bogutovac'),(1091,'36342','Ušće'),(1092,'36343','Studenica'),(1093,'36344','Baljevac Na Ibru'),(1094,'36345','Jošanicka Banja'),(1095,'36346','Brvenik'),(1096,'36350','Raška'),(1097,'36353','Rudnica'),(1098,'36354','Kopaonik'),(1099,'37000','Kruševac'),(1100,'37201','Parunovac'),(1101,'37202','Djunis'),(1102,'37203','Zdravinje'),(1103,'37204','Veliki Siljegovac'),(1104,'37205','Ribarska Banja'),(1105,'37206','Dvorane'),(1106,'37207','Veliko Golovode'),(1107,'37208','Čitluk'),(1108,'37209','Velika Lomnica'),(1109,'37210','Ćićevac'),(1110,'37212','Stalać'),(1111,'37213','Vitosevac'),(1112,'37214','Pojate'),(1113,'37215','Ražanj'),(1114,'37220','Brus'),(1115,'37221','Gornji Stepos'),(1116,'37222','Kupci'),(1117,'37223','Razbojna'),(1118,'37224','Lepenac'),(1119,'37225','Brzeće'),(1120,'37226','Blazevo'),(1121,'37227','Milentija'),(1122,'37228','Zlatari'),(1123,'37229','Grasevci'),(1124,'37230','Aleksandrovac'),(1125,'37231','Pepeljevac'),(1126,'37232','Laćisled'),(1127,'37233','Velika Vrbnica'),(1128,'37234','Gornji Stupanj'),(1129,'37235','Trnavci'),(1130,'37236','Rataje'),(1131,'37237','Ploča'),(1132,'37238','Ples'),(1133,'37239','Šljivovo'),(1134,'37240','Trstenik'),(1135,'37242','Stopanja'),(1136,'37243','Počekovina'),(1137,'37244','Medvedja'),(1138,'37245','Velika Drenova'),(1139,'37246','Milutovac'),(1140,'37251','Globoder'),(1141,'37252','Jasika'),(1142,'37253','Bela Voda'),(1143,'37254','Konjuh'),(1144,'37255','Kukljin'),(1145,'37256','Kaonik'),(1146,'37257','Padež'),(1147,'37258','Donji Krcin'),(1148,'37259','Ribare'),(1149,'37260','Varvarin'),(1150,'37262','Bosnjane'),(1151,'37265','Bačina'),(1152,'37266','Obrez'),(1153,'37271','Dasnica'),(1154,'37281','Osreci'),(1155,'37282','Kriva Reka'),(1156,'38157','Brezovica'),(1157,'38205','Gracanica'),(1158,'38210','Kosovo Polje'),(1159,'38213','Prilužje'),(1160,'38216','Banjska'),(1161,'38217','Sočanica'),(1162,'38218','Leposavić'),(1163,'38219','Lešak'),(1164,'38220','Kosovska Mitrovica'),(1165,'38227','Zvecan'),(1166,'38228','Zubin Potok'),(1167,'38236','Štrpce'),(1168,'38239','Drajkovce'),(1169,'38266','Pasjane'),(1170,'38267','Ranilug'),(1171,'22415','Brestac');
/*!40000 ALTER TABLE `cities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `configuration`
--

DROP TABLE IF EXISTS `configuration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `configuration` (
  `item` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `item_value` text COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`item`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `configuration`
--

LOCK TABLES `configuration` WRITE;
/*!40000 ALTER TABLE `configuration` DISABLE KEYS */;
INSERT INTO `configuration` VALUES ('backendPaginationLimit','10');
/*!40000 ALTER TABLE `configuration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_items`
--

DROP TABLE IF EXISTS `order_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_items` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `order_id` int(10) unsigned NOT NULL,
  `book_id` int(10) unsigned NOT NULL,
  `item_number` int(10) unsigned NOT NULL,
  `amount` int(10) unsigned NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `total_item` decimal(10,2) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `order_id` (`order_id`),
  KEY `book_id` (`book_id`),
  CONSTRAINT `order_items_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
  CONSTRAINT `order_items_ibfk_2` FOREIGN KEY (`book_id`) REFERENCES `books` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_items`
--

LOCK TABLES `order_items` WRITE;
/*!40000 ALTER TABLE `order_items` DISABLE KEYS */;
INSERT INTO `order_items` VALUES (1,3,4,1,1,1199.00,1199.00,'2018-08-31 05:43:23',NULL),(2,3,3,1,1,899.00,899.00,'2018-08-31 05:43:23',NULL),(3,4,3,1,1,899.00,899.00,'2018-08-31 05:53:23',NULL),(4,4,4,1,1,1199.00,1199.00,'2018-08-31 05:53:23',NULL);
/*!40000 ALTER TABLE `order_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned NOT NULL,
  `address_id` int(10) unsigned NOT NULL,
  `administrator_id` int(10) unsigned DEFAULT NULL,
  `status` enum('created','sent','delivered','cancelled') COLLATE utf8_unicode_ci NOT NULL,
  `processed` tinyint(1) NOT NULL,
  `order_total` decimal(10,2) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `address_id` (`address_id`),
  KEY `administrator_id` (`administrator_id`),
  KEY `status` (`status`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`address_id`) REFERENCES `addresses` (`id`),
  CONSTRAINT `orders_ibfk_3` FOREIGN KEY (`administrator_id`) REFERENCES `administrators` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (3,3,1,NULL,'created',0,2098.00,'2018-08-31 05:43:23',NULL),(4,3,1,NULL,'created',0,2098.00,'2018-08-31 05:53:23',NULL);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `active` tinyint(1) unsigned NOT NULL,
  `first_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `last_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `avatar` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `avatar_public_id` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `thumbnail` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `thumbnail_public_id` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `gender` enum('male','female') COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `email` (`email`),
  KEY `first_name` (`first_name`),
  KEY `last_name` (`last_name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (3,0,'Cvetan','Šimšić','cvetan','cvetan.simsic@gmail.com','$2a$10$XmLiGtp6MVI1MVO8ZQuf0uynYnqG.D85/EBNVmNwFjcLenb4Op9vy',NULL,NULL,NULL,NULL,'1988-01-08','male','065/688-11-80','2018-08-30 06:17:07',NULL),(4,0,'Default','User','user','user@user.com','$2a$10$H06wfsP6NQlKUuUquMmmjen5Jtlck9ZcRMO3nES1o8kUe6TNwm8be',NULL,NULL,NULL,NULL,'2018-08-30','male','060/123-456','2018-08-30 06:21:31',NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wishlist`
--

DROP TABLE IF EXISTS `wishlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wishlist` (
  `user_id` int(10) unsigned NOT NULL,
  `book_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`user_id`,`book_id`),
  KEY `book_id` (`book_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `wishlist_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `wishlist_ibfk_2` FOREIGN KEY (`book_id`) REFERENCES `books` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wishlist`
--

LOCK TABLES `wishlist` WRITE;
/*!40000 ALTER TABLE `wishlist` DISABLE KEYS */;
/*!40000 ALTER TABLE `wishlist` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-08-31  7:19:06
