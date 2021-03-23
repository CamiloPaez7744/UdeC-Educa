--SELECT LENGTH( REPEAT('abc~ABC', 100) ) AS full_bytes,
--LENGTH ( COMPRESS(REPEAT('abc~ABC', 100))) AS comp_bytes;
--SET @comped = COMPRESS(REPEAT('abc~ABC', 100) );

SET @mykeystr = 'cifrado extremo';
SET @shahex = SHA2(mykeystr, 512);
SET @keys = UNHEX(shahex);
UPDATE usuario SET 
compress_pass = COMPRESS(REPEAT('abc~ABC', 100) ),
hash_pass = SHA2('contrasena', 512),
enc_pass = AES_ENCRYPT('contrasena', keys)
WHERE identificacion = id;


--------------------

DO $$
DECLARE mykeystr VARCHAR(128) := 'cifrado extremo';
DECLARE shahex VARCHAR(128) := SHA2(mykeystr, 512);
DECLARE keys VARCHAR(128) := UNHEX(shahex);

BEGIN
UPDATE user_data SET 
compress_pass = COMPRESS(REPEAT('abc~ABC', 100) ),
hash_pass = SHA2('contrasena', 512),
enc_pass = AES_ENCRYPT('contrasena', keys)
WHERE identificacion = id;
END $$;

-----------------
CREATE FUNCTION fn_cryptpass(id varchar(10))
RETURNS void AS $$
DECLARE @mykeystr VARCHAR(128);
DECLARE @shahex VARCHAR(128);
DECLARE @keys VARCHAR(128);

SET @mykeystr = 'cifrado extremo';
SET @shahex = SHA2(mykeystr, 512);
SET @keys = UNHEX(shahex);
BEGIN
UPDATE user_data SET 
compress_pass = COMPRESS(REPEAT('abc~ABC', 100) ),
hash_pass = SHA2('contrasena', 512),
enc_pass = AES_ENCRYPT('contrasena', keys)
WHERE identificacion = id;
END;
$$ LANGUAGE SQL



DECLARE comped VARCHAR(128) := COMPRESS(REPEAT('abc~ABC', 100) );
DECLARE mykeystr VARCHAR(40) := 'cifrado extremo';
DECLARE shahex VARCHAR(128) := SHA2(mykeystr, 512);
DECLARE keys VARCHAR(128) := UNHEX(shahex);
BEGIN
UPDATE usuario SET 
compress_pass = COMPRESS(REPEAT('abc~ABC', 100) ),
hash_pass = SHA2('contrasena', 512),
enc_pass = AES_ENCRYPT('contrasena', keys)
WHERE identificacion = id;
RETURN comped;
END;

CREATE FUNCTION fn_cryptpass(id varchar(10))
RETURNS void AS $$

BEGIN
UPDATE user_data SET 
compress_pass = COMPRESS(REPEAT('abc~ABC', 100) ),
hash_pass = SHA2('contrasena', 512),
enc_pass = AES_ENCRYPT('contrasena', keys)
WHERE identificacion = id;
END;
$$ LANGUAGE SQL



-------------------------------------------------------
CREATE OR REPLACE FUNCTION fn_encryptPassword(bytea) returns text AS $$
    SELECT encode(digest($1, 'sha1'), 'md5')
$$ LANGUAGE SQL STRICT IMMUTABLE;

INSERT INTO user_data(hash_pass)
VALUES (crypt('password', md('md5')));

intenté hacer todo lo anterior pero no se cómo hacerlo 

CREATE OR REPLACE FUNCTION fn_encryptPassword(bytea) returns text AS $$
    SELECT encode(digest($1, 'sha1'), 'md5');
$$ LANGUAGE SQL;

CREATE PROCEDURE sp_updatePassword(IN pass VARCHAR(20), IN id VARCHAR(10))
AS $$
BEGIN
UPDATE user_data SET hass_pass = fn_encryptPassword(pass) WHERE identification = id;
END;
$$ LANGUAGE plpgsql


CREATE FUNCTION fn_encryptPass(password varchar(30),id varchar(10))
RETURNS VOID AS $$
DECLARE AES_KEY VARCHAR(72);
BEGIN
UPDATE user_data SET 
    AES_KEY = gen_salt('bf'),
	enc_pass = pgp_sym_encrypt(password, AES_KEY)    
WHERE identification = id;

END;
$$ LANGUAGE plpgsql

CREATE FUNCTION fn_encryptPassTwo(pass varchar(30),id varchar(10))
RETURNS VOID AS $$
DECLARE AES_KEY VARCHAR(72) = gen_salt('bf');
BEGIN
UPDATE user_data SET 
    hash_pass = AES_KEY,
	enc_pass = pgp_sym_encrypt(pass, AES_KEY)    
WHERE identification = id;
END;
$$ LANGUAGE plpgsql

select pgp_pub_decrypt(enc_pass, hash_pass)
sequelize.fn('PGP_SYM_DECRYPT',sequelize.cast(sequelize.col('enc_pass'), 'bytea'), hash_pass)
--pgp_sym_encrypt(data text, psw text [, options text ])
-- pgp_pub_decrypt(msg bytea, key bytea [, psw text [, options text ]]) returns text