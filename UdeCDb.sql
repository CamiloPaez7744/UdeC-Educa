CREATE DATABASE udeceduca;
USE udeceduca;

CREATE TABLE institution(
    id_institution VARCHAR(4),
    name_intitution VARCHAR(200) NOT NULL
);

CREATE TABLE identification_type(
    id_type VARCHAR(3),
    type_name VARCHAR(40)
)

CREATE TABLE competitor(
    id_competitor VARCHAR(5) PRIMARY KEY,
    name_competitor_type VARCHAR(15)
)

CREATE TABLE userue(
    number_identification VARCHAR(10) PRIMARY KEY NOT NULL,
    identification_type VARCHAR(3) NOT NULL FOREIGN KEY REFERENCES identification_type(id_type),
    first_name VARCHAR(30) NOT NULL,
    second_name VARCHAR(30),
    first_lastname VARCHAR(30) NOT NULL,
    second_lastname VARCHAR(30),
    phone VARCHAR(10) NOT NULL,
    email VARCHAR(200) NOT NULL,
    birth_date DATE NOT NULL,
    competitor_type VARCHAR(20) NOT NULL FOREIGN KEY REFERENCES competitor(id_competitor),
    id_intitution VARCHAR(4) FOREIGN KEY REFERENCES institution(id_institution),
    username VARCHAR(100) NOT NULL,
    access_key VARCHAR(128) NOT NULL,
    enc_pass VARBINARY(200) NOT NULL
);

CREATE TABLE category(
    id_category int AUTO_INCREMENT PRIMARY KEY NOT NULL,
);

CREATE TABLE eventue(
    event_id int AUTO_INCREMENT PRIMARY KEY NOT NULL,
    event_category VARCHAR(4),
    event_name VARCHAR(200),
    event_start_date TIMESTAMP,
    event_end_date TIMESTAMP, 
    event_date 
);

CREATE TABLE suscripcion(
    id_suscription int AUTO_INCREMENT PRIMARY KEY NOT NULL,
    number_identification VARCHAR(10) FOREIGN KEY REFERENCES userue(number_identification),
    event_id int FOREIGN KEY REFERENCES eventue(event_id)
)

CREATE TABLE realimentacion(
    id_feedback VARCHAR(300),
    descriptionfeed VARCHAR(300),
    calification int,
    id_suscription int FOREIGN KEY REFERENCES suscripcion(id_suscription)
)




--MYSQL
DELIMITER //
CREATE OR REPLACE FUNCTION fn_userGenerator(id varchar(10))
RETURNS VARCHAR(80)
BEGIN
DECLARE user_var VARCHAR(80);
SELECT REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(lOWER(CONCAT(SUBSTRING(LTRIM(RTRIM(first_name)),1,1), LTRIM(RTRIM(first_lastname)),SUBSTRING(number_identification, CHAR_LENGTH(number_identification)-1,2))),'á','a'),'é','e'),'í','i'),'ó','o'),'ú','u') INTO user_var  FROM userue WHERE number_identification = id lIMIT 1;
RETURN user_var;
END;
//

DELIMITER //
CREATE PROCEDURE sp_updateUser(IN id VARCHAR(10))
BEGIN
UPDATE userue SET username = fn_userGenerator(id) WHERE number_identification = id;
END;
//

--mysql encriptar contraseña
DELIMITER //
CREATE OR REPLACE PROCEDURE sp_encryptPassword(IN id VARCHAR(10), IN user_password VARCHAR(30))
BEGIN
UPDATE user_data SET 
    access_key = SHA2(user_password, 512),
	enc_pass = AES_ENCRYPT(user_password, access_key)    
WHERE number_identification = id;
END;
//
--Store Procedure for decrypt password

DELIMITER //
CREATE FUNCTION fn_decryptPass(id varchar(10))
RETURNS VARCHAR(30)
BEGIN
DECLARE res VARCHAR(30);
select AES_DECRYPT(enc_pass, access_key) into res FROM userue where number_identification = id;
RETURN res;
END;
//

DELIMITER //
CREATE PROCEDURE sp_decryptPassword(IN id VARCHAR(10), IN user_password VARCHAR(30), INOUT res boolean)
BEGIN
IF user_password = fn_decryptPass(id)
THEN
    SET res = true;
ELSE
    SET res = false;
END IF;
END
//