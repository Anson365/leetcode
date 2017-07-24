update salary set sex = IF(sex='m','f','m');

update salary set sex = CHAR(ASCII('f') ^ ASCII('m') ^ ASCII(sex));

update salary set sex = char(ascii(sex) ^ 11);

UPDATE salary SET sex  = (CASE WHEN sex = 'm' THEN  'f' ELSE 'm' END)