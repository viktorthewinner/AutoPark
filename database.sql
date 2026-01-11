-- 1. Crearea bazei de date
IF NOT EXISTS (SELECT * FROM sys.databases WHERE name = 'AutoPark')
BEGIN
    CREATE DATABASE AutoPark;
END
GO

USE AutoPark;
GO

-- 2. Crearea tabelului Client
CREATE TABLE Client (
    id_client INT PRIMARY KEY IDENTITY(1,1),
    nume NVARCHAR(50) NOT NULL,
    prenume NVARCHAR(50) NOT NULL,
    cnp CHAR(13) UNIQUE NOT NULL
);

-- 3. Crearea tabelului Utilizator
CREATE TABLE Utilizator (
    id_utilizator INT PRIMARY KEY IDENTITY(1,1),
    username NVARCHAR(30) UNIQUE NOT NULL,
    parola NVARCHAR(255) NOT NULL,
    mail NVARCHAR(100) NULL,
    telefon NVARCHAR(15),
    nume NVARCHAR(50),
    prenume NVARCHAR(50)
);

-- 4. Crearea tabelului Masina
CREATE TABLE Masina (
    id_masina INT PRIMARY KEY IDENTITY(1,1),
    marca NVARCHAR(50) NOT NULL,
    model NVARCHAR(50) NOT NULL,
    an_fabricatie INT,
    km INT,
    pret DECIMAL(10, 2),
    id_cumparator INT NULL, -- Poate fi gol dacă nu e cumpărată
    CONSTRAINT FK_Masina_Client FOREIGN KEY (id_cumparator) 
        REFERENCES Client(id_client)
);
GO

-- 5. Populare Tabel Client (7 înregistrări)
INSERT INTO Client (nume, prenume, cnp) VALUES
('Popescu', 'Ion', '1800101123456'),
('Ionescu', 'Maria', '2900202123456'),
('Dumitru', 'Andrei', '1850303123456'),
('Stan', 'Elena', '2920404123456'),
('Radu', 'Cristian', '1880505123456'),
('Stoica', 'Anca', '2950606123456'),
('Mihai', 'George', '1900707123456');

-- 6. Populare Tabel Utilizator (3 înregistrări)
INSERT INTO Utilizator (username, parola, mail, telefon, nume, prenume) VALUES
('admin01', 'Pass123!', 'admin@autopark.ro', '0722111222', 'Ionescu', 'Vlad'),
('sales_manager', 'Sales2024', 'sales@autopark.ro', '0733444555', 'Vasile', 'Dan'),
('support_user', 'Supp9988', 'suport@autopark.ro', '0744777888', 'Georgescu', 'Ana');

-- 7. Populare Tabel Masina (20 înregistrări)
-- Primele 7 sunt vândute clienților de mai sus, restul au NULL la id_cumparator
INSERT INTO Masina (marca, model, an_fabricatie, km, pret, id_cumparator) VALUES
('Volkswagen', 'Golf 7', 2017, 125000, 12500.00, 1),
('BMW', '320d', 2019, 85000, 21000.00, 2),
('Audi', 'A4', 2018, 110000, 18500.00, 3),
('Dacia', 'Logan', 2022, 15000, 11500.00, 4),
('Toyota', 'Corolla', 2021, 45000, 19800.00, 5),
('Mercedes-Benz', 'C-Class', 2020, 60000, 32000.00, 6),
('Hyundai', 'Tucson', 2022, 30000, 27500.00, 7),
('Ford', 'Focus', 2016, 145000, 8900.00, NULL),
('Renault', 'Megane', 2015, 180000, 7200.00, NULL),
('Skoda', 'Octavia', 2019, 95000, 15500.00, NULL),
('Volvo', 'XC60', 2020, 72000, 34000.00, NULL),
('Mazda', 'CX-5', 2018, 88000, 17900.00, NULL),
('Peugeot', '3008', 2021, 40000, 23500.00, NULL),
('Kia', 'Sportage', 2023, 12000, 29000.00, NULL),
('Nissan', 'Qashqai', 2017, 105000, 13800.00, NULL),
('Honda', 'Civic', 2019, 70000, 18200.00, NULL),
('Tesla', 'Model 3', 2021, 25000, 38500.00, NULL),
('Opel', 'Astra', 2014, 195000, 5500.00, NULL),
('Seat', 'Leon', 2018, 115000, 12900.00, NULL),
('Lexus', 'RX450h', 2020, 55000, 45000.00, NULL);
GO