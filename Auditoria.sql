USE udeceduca;
CREATE TABLE Auditoria_Diana(
    auth_key INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    number_identification VARCHAR(10),  FOREIGN KEY (number_identification) REFERENCES userue(number_identification),
    fecha DATETIME NOT NULL,
    accion VARCHAR(100) NOT NULL,
    contenido VARCHAR(100)
)