DROP TABLE IF EXISTS USERS;
CREATE TABLE USERS (USER_ID UUID PRIMARY KEY,NAME VARCHAR(30) NOT NULL,USER_NAME VARCHAR(30)NOT NULL,PASSWORD VARCHAR(16),AGE INTEGER(3) NOT NULL,EMAIL VARCHAR(30),PHONE_NUMBER INTEGER(10),ADDRESS VARCHAR(30),STREET VARCHAR(30),CITY VARCHAR(30),STATE VARCHAR(30),COUNTRY VARCHAR(30),POSTAL_CODE VARCHAR(10),ACTIVE BOOLEAN , VERIFIER INTEGER(10));