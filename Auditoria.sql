USE udeceduca;
CREATE TABLE Auditoria(
    auth_key INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    number_identification VARCHAR(10),  FOREIGN KEY (number_identification) REFERENCES userue(number_identification),
    fecha DATETIME NOT NULL,
    accion VARCHAR(100) NOT NULL,
    contenido VARCHAR(100)
)

 insert into userue value('1076670528', '001', 'Diana', '', 'Paez', 'Espitia','3105433467', 'dgarzong@mail.com', '1999-10-13', '00001', '002', 1, 'dpaez28', '','');
