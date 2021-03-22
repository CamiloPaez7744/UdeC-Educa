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
    compress_pass BYTEA,
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


---test

--Store Procedure for encrypt password

