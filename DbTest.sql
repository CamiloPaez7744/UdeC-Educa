CREATE DATABASE udeceduca_test;
CREATE TABLE user_data(
    id_user BIGSERIAL NOT NULL,
    identification VARCHAR(10) NOT NULL,
    first_name VARCHAR(30) NOT NULL,
    second_name VARCHAR(30),
    first_lastname VARCHAR(30) NOT NULL,
    second_lastname VARCHAR(30),
    email VARCHAR(200) NOT NULL,
    username VARCHAR(80),
    hash_pass VARCHAR(128),
    enc_pass BYTEA
);

CREATE DATABASE udeceduca_test;
CREATE TABLE user_data(
    id_user BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    identification VARCHAR(10) NOT NULL,
    first_name VARCHAR(30) NOT NULL,
    second_name VARCHAR(30),
    first_lastname VARCHAR(30) NOT NULL,
    second_lastname VARCHAR(30),
    email VARCHAR(200) NOT NULL,
    username VARCHAR(80),
    hash_pass VARCHAR(128),
    enc_pass VARBINARY(200)
);

--Store Procedure for created username

CREATE FUNCTION fn_userGenerator(id varchar(10))
RETURNS VARCHAR(80) AS $$
DECLARE user_var VARCHAR(80);
BEGIN
SELECT lOWER(CONCAT(SUBSTRING(LTRIM(RTRIM(first_name)),1,1), LTRIM(RTRIM(first_lastname)),SUBSTRING(identification, CHAR_LENGTH(identification)-1,2))) INTO user_var  FROM user_data WHERE identification = id lIMIT 1;
RETURN user_var;
END;
$$ LANGUAGE plpgsql
--MYSQL
DELIMITER //
CREATE FUNCTION fn_userGenerator(id varchar(10))
RETURNS VARCHAR(80)
BEGIN
DECLARE user_var VARCHAR(80);
SELECT lOWER(CONCAT(SUBSTRING(LTRIM(RTRIM(first_name)),1,1), LTRIM(RTRIM(first_lastname)),SUBSTRING(identification, CHAR_LENGTH(identification)-1,2))) INTO user_var  FROM user_data WHERE identification = id lIMIT 1;
RETURN user_var;
END;
//

CREATE PROCEDURE sp_updateUser(IN id VARCHAR(10))
AS $$
BEGIN
UPDATE user_data SET username = fn_userGenerator(id) WHERE identification = id;
END;
$$ LANGUAGE plpgsql

DELIMITER //
CREATE PROCEDURE sp_updateUser(IN id VARCHAR(10))
BEGIN
UPDATE user_data SET username = fn_userGenerator(id) WHERE identification = id;
END;
//

--Store Procedure for encrypt password

--CALL sp_encryptPass('contraseña','2127503716')

CREATE PROCEDURE sp_encryptPassword(IN id VARCHAR(10), IN user_password VARCHAR(30))
AS $$
DECLARE AES_KEY VARCHAR(72) = gen_salt('bf');
BEGIN
UPDATE user_data SET 
    hash_pass = AES_KEY,
	enc_pass = pgp_sym_encrypt(user_password, AES_KEY)    
WHERE identification = id;
END;
$$ LANGUAGE plpgsql

--mysql encriptar contraseña
DELIMITER //
CREATE OR REPLACE PROCEDURE sp_encryptPassword(IN id VARCHAR(10), IN user_password VARCHAR(30))
BEGIN
UPDATE user_data SET 
    hash_pass = SUBSTRING(MD5(RAND()), -10),
	enc_pass = AES_ENCRYPT(user_password, hash_pass)    
WHERE identification = id;
END;
//
--Store Procedure for decrypt password


--select enc_pass, hash_pass, pgp_sym_decrypt(enc_pass, hash_pass) FROM user_data where identification = '2127503716';

CREATE FUNCTION fn_decryptPass(id varchar(10))
RETURNS VARCHAR(30) AS $$
DECLARE res VARCHAR(30);
BEGIN
select pgp_sym_decrypt(enc_pass, hash_pass) into res FROM user_data where identification = id;
RETURN res;
END;
$$ LANGUAGE plpgsql

DELIMITER //
CREATE FUNCTION fn_decryptPass(id varchar(10))
RETURNS VARCHAR(30)
BEGIN
DECLARE res VARCHAR(30);
select AES_DECRYPT(enc_pass, hash_pass) into res FROM user_data where identification = id;
RETURN res;
END;
//

CREATE PROCEDURE sp_decryptPassword(IN id VARCHAR(10), IN user_password VARCHAR(30), INOUT res boolean)
AS $$
BEGIN
SELECT (user_password = fn_decryptPass(id) into res);
END
$$ LANGUAGE plpgsql

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



--CALL sp_decryptPassword('8413840228', 'contraseña');