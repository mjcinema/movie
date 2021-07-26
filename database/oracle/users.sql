CREATE SEQUENCE  USERS_SEQUENCE
START WITH 1
INCREMENT BY 1
NOCACHE;

CREATE TABLE USERS (
    ID NUMBER PRIMARY KEY,
    USERNAME NVARCHAR2(255) UNIQUE NOT NULL,
    PASSWORD NVARCHAR2(255) NOT NULL,
    NAME NVARCHAR2(255),
    BIRTH NVARCHAR2(255),
    EMAIL NVARCHAR2(255),
    ADDRESS NVARCHAR2(255)

);

CREATE TABLE AUTHORITIES (
     USERNAME NVARCHAR2(255) NOT NULL,
     AUTHORITY NVARCHAR2(255) NOT NULL
);

ALTER TABLE AUTHORITIES ADD CONSTRAINT AUTHORITIES_UNIQUE UNIQUE (USERNAME, AUTHORITY);
ALTER TABLE AUTHORITIES ADD CONSTRAINT AUTHORITIES_FK1 FOREIGN KEY (USERNAME) REFERENCES USERS (USERNAME) ENABLE;