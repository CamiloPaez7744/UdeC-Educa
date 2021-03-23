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

--Store Procedure for created username

CREATE FUNCTION fn_userGenerator(id varchar(10))
RETURNS VARCHAR(80) AS $$
DECLARE user_var VARCHAR(80);
BEGIN
SELECT lOWER(CONCAT(SUBSTRING(LTRIM(RTRIM(first_name)),1,1), LTRIM(RTRIM(first_lastname)),SUBSTRING(identification, CHAR_LENGTH(identification)-1,2))) INTO user_var  FROM user_data WHERE identification = id lIMIT 1;
RETURN user_var;
END;
$$ LANGUAGE plpgsql


CREATE PROCEDURE sp_updateUser(IN id VARCHAR(10))
AS $$
BEGIN
UPDATE user_data SET username = fn_userGenerator(id) WHERE identification = id;
END;
$$ LANGUAGE plpgsql



--Store Procedure for encrypt password


CREATE FUNCTION fn_encryptPassword(pass VARCHAR(30), )
RETURNS VARCHAR(72) AS $$
DECLARE AES_KEY VARCHAR(72) = gen_salt('bf');
BEGIN
RETURN AES_KEY;
END;
$$ LANGUAGE plpgsql

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

--Store Procedure for decrypt password


select enc_pass, hash_pass, pgp_sym_decrypt(enc_pass, hash_pass) FROM user_data where identification = '2127503716';

CREATE FUNCTION fn_dencryptPass(id varchar(10))
RETURNS VARCHAR(30) AS $$
DECLARE res VARCHAR (30);
DECLARE enc_passField BYTEA;
DECLARE hash_passField VARCHAR(72);
BEGIN
select enc_pass INTO enc_passField FROM user_data where identification = id;
select hash_pass INTO hash_passField FROM user_data where identification = id;
RETURN res = pgp_sym_decrypt(enc_passField, hash_passField); 
END;
$$ LANGUAGE plpgsql


CREATE PROCEDURE sp_decryptPassword(IN id VARCHAR(10), IN user_password VARCHAR(30))
AS $$
DECLARE twins BOOLEAN;
BEGIN
IF (user_password = fn_decryptPass(id))
SELECT twins := 'TRUE';
ELSE 
SELEC twins := 'FALSE';
END IF;
END;
RETURN twins;
$$ LANGUAGE plpgsql