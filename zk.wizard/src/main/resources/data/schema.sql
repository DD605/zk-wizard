create memory table T_PERSON(SID INTEGER GENERATED BY DEFAULT AS IDENTITY NOT NULL PRIMARY KEY, LASTNAME varchar(50), FIRSTNAME varchar(50))
create memory table T_USER(SID INTEGER GENERATED BY DEFAULT AS IDENTITY NOT NULL PRIMARY KEY,ACCOUNT VARCHAR(15) NOT NULL UNIQUE ,PERS_ID INTEGER NOT NULL, FOREIGN KEY (PERS_ID) REFERENCES T_PERSON(SID))
create memory table T_USER_ROLE (USER_ID INTEGER NOT NULL , ROLE VARCHAR(10) NOT NULL, FOREIGN KEY (USER_ID) REFERENCES T_USER(SID))