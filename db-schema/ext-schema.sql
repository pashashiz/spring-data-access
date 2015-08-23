# A simple function
DELIMITER $$
DROP FUNCTION IF EXISTS multiply_10;
CREATE FUNCTION multiply_10(n INT) RETURNS INT
  BEGIN
    RETURN n * 10;
  END $$
DELIMITER ;
# Test
SELECT multiply_10(4) as mltp;


# A simple procedure with variables (and IN, OUT parameters)
DELIMITER $$
DROP PROCEDURE IF EXISTS sum_customer_payment_tax;
CREATE PROCEDURE sum_customer_payment_tax(IN id INT, OUT payment FLOAT)
  BEGIN
    DECLARE tax_rate FLOAT DEFAULT 0.2;
    DECLARE sum_payment FLOAT;
    SELECT SUM(amount) FROM payment WHERE customer_id = id INTO sum_payment;
    SET payment = sum_payment * tax_rate;
  END $$
DELIMITER ;
# Test (@out_value - session variable)
CALL sum_customer_payment_tax(1, @out_value);
SELECT @out_value;


# A simple procedure with INOUT parameter
DELIMITER $$
DROP PROCEDURE IF EXISTS increment;
CREATE PROCEDURE increment(INOUT value INT)
  BEGIN
    SET value = value + 1;
  END $$
DELIMITER ;
# Test (@i - session variable)
SET @i = 0;
CALL increment(@i);
CALL increment(@i);
CALL increment(@i);
SELECT @i;


# A simple procedure with IF statement
DELIMITER $$
DROP PROCEDURE IF EXISTS film_by_rating;
CREATE PROCEDURE film_by_rating(IN rating_val VARCHAR(8))
  BEGIN
    IF rating_val = '' THEN
      SELECT * FROM film;
    ELSE
      SELECT * FROM film WHERE rating = rating_val;
    END IF;
  END $$
DELIMITER ;
# Test
CALL film_by_rating('R');


# A simple procedure with CASE statement
DELIMITER $$
DROP PROCEDURE IF EXISTS msum_customer_payment_tax;
CREATE PROCEDURE msum_customer_payment_tax(IN id INT, IN mode VARCHAR(8), OUT payment FLOAT)
  BEGIN
    DECLARE tax_rate FLOAT;
    DECLARE sum_payment FLOAT;
    CASE mode
      WHEN 'low' THEN SET tax_rate = 0.03;
      WHEN 'normal' THEN SET tax_rate = 0.2;
      WHEN 'high' THEN SET tax_rate = 0.25;
    ELSE SET tax_rate = 0;
    END CASE;
    SELECT SUM(amount) FROM payment WHERE customer_id = id INTO sum_payment;
    SET payment = sum_payment * tax_rate;
  END $$
DELIMITER ;
# Test (@out_value - session variable)
CALL msum_customer_payment_tax(1, 'low', @out_value);
SELECT @out_value;


# A simple procedure with WHILE statement
DELIMITER $$
DROP PROCEDURE IF EXISTS generate_sequence;
CREATE PROCEDURE generate_sequence(IN count INT, OUT sequence TEXT)
  BEGIN
    DECLARE i INT;
    SET i = 0;
    SET sequence = '';
    WHILE i <= count DO
      IF i != count THEN
        SET sequence = CONCAT(sequence, i, ', ');
      ELSE
        SET sequence = CONCAT(sequence, i);
      END IF ;
      SET i = i + 1;
    END WHILE;
  END$$
DELIMITER ;
# Test
CALL generate_sequence(10, @sequence);
SELECT @sequence;


# A simple function with CURSOR
DELIMITER $$
DROP FUNCTION IF EXISTS get_film_actors;
CREATE FUNCTION get_film_actors(id INT) RETURNS TEXT
  BEGIN
    DECLARE actors TEXT;
    DECLARE actor_tmp VARCHAR(45);
    DECLARE finished INT DEFAULT 0;
    # Declare cursor for select
    DECLARE actors_cursor CURSOR FOR
      SELECT CONCAT(a.first_name, ' ', a.last_name) FROM film_actor AS fa
        JOIN actor as a ON fa.actor_id = a.actor_id
      WHERE fa.film_id = id;
    # Declare not found handler
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET finished = 1;
    # Open cursor and do operations
    OPEN actors_cursor;
    WHILE finished = 0 DO
      FETCH actors_cursor INTO actor_tmp;
      IF actors IS NULL THEN
        SET actors = actor_tmp;
      ELSE
        SET actors = CONCAT(actors, ', ', actor_tmp);
      END IF;
    END WHILE ;
    # Close cursor
    CLOSE actors_cursor;
    RETURN actors;
  END$$
DELIMITER ;
# Some comment 0
# Hey
# Test
SELECT title, description, get_film_actors(film_id) as film_actors, release_year FROM film;

# Some comment 1
# Some comment 2
