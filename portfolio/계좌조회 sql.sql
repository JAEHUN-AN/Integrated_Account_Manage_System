drop table user_table;
CREATE TABLE USER_Table(
    ID VARCHAR2 (20) PRIMARY KEY,
    PW VARCHAR2 (20),
    NAME VARCHAR2(15),
    join_date date default sysdate
);

CREATE TABLE admin_Table(
    ID VARCHAR2 (20) PRIMARY KEY,
    PW VARCHAR2 (20),
    NAME VARCHAR2(15),
    join_date date default sysdate
);


CREATE TABLE ACCOUNT_SYSTEM(
    ACCOUNT_NO VARCHAR(20) primary key,
    BANK VARCHAR(20),
    ACCOUNT_HOLDER VARCHAR2(10) ,
    BALANCE NUMBER,
    NICKNAME VARCHAR2(15),
    USER_ID varchar2(20) REFERENCES USER_TABLE(ID),
    create_date date default sysdate
);

CREATE TABLE ACCOUNT_하나(
    ACCOUNT_NO VARCHAR(20) primary key,
    BANK VARCHAR(20),
    ACCOUNT_HOLDER VARCHAR2(10) ,
    BALANCE NUMBER,
    NICKNAME VARCHAR2(15),
    USER_ID varchar2(20) REFERENCES USER_TABLE(ID),
    create_date date default sysdate
);

--신한 우리 기업 국민

CREATE TABLE ACCOUNT_신한(
    ACCOUNT_NO VARCHAR(20) primary key,
    BANK VARCHAR(20),
    ACCOUNT_HOLDER VARCHAR2(10) ,
    BALANCE NUMBER,
    NICKNAME VARCHAR2(15),
    USER_ID varchar2(20) REFERENCES USER_TABLE(ID),
    create_date date default sysdate
);

CREATE TABLE ACCOUNT_우리(
    ACCOUNT_NO VARCHAR(20) primary key,
    BANK VARCHAR(20),
    ACCOUNT_HOLDER VARCHAR2(10) ,
    BALANCE NUMBER,
    NICKNAME VARCHAR2(15),
    USER_ID varchar2(20) REFERENCES USER_TABLE(ID),
    create_date date default sysdate
);

CREATE TABLE ACCOUNT_기업(
    ACCOUNT_NO VARCHAR(20) primary key,
    BANK VARCHAR(20),
    ACCOUNT_HOLDER VARCHAR2(10) ,
    BALANCE NUMBER,
    NICKNAME VARCHAR2(15),
    USER_ID varchar2(20) REFERENCES USER_TABLE(ID),
    create_date date default sysdate
);

CREATE TABLE ACCOUNT_국민(
    ACCOUNT_NO VARCHAR(20) primary key,
    BANK VARCHAR(20),
    ACCOUNT_HOLDER VARCHAR2(10) ,
    BALANCE NUMBER,
    NICKNAME VARCHAR2(15),
    USER_ID varchar2(20) REFERENCES USER_TABLE(ID),
    create_date date default sysdate
);
--신한 INSERT
INSERT INTO ACCOUNT_신한  (ACCOUNT_NO, BANK, ACCOUNT_HOLDER, BALANCE, nickName, user_ID) 
VALUES('1', '신한', '1', '1', 1111, '123');
-- User 검색
SELECT ID, PW FROM USER_TABLE WHERE ID = 111 AND PW = 111;


INSERT INTO USER_Table(id, pw, name) VALUES('111', '111', 'jaan');
INSERT INTO admin_Table(id, pw, name) VALUES('111', '111', 'jaan');
INSERT INTO ACCOUNT_SYSTEM(ACCOUNT_NO, BANK, ACCOUNT_HOLDER, BALANCE, nickName, user_ID) 
VALUES('111-111','하나', '111', 1111, '닉네임', '111') ;

SELECT * FROM USER_TABLE;
SELECT * FROM ADMIN_TABLE;
SELECT ID, PW, NAME FROM ADMIN_TABLE WHERE ID = 111 AND PW = 111;
SELECT * FROM Account_system;
SELECT * FROM Account_신한;
SELECT * FROM ACCOUNT_SYSTEM WHERE user_ID = 123 and sysdate > add_months(create_date, 1) ORDER BY Create_date DESC ;
SELECT * FROM ACCOUNT_SYSTEM WHERE user_ID = 111 ORDER BY BANK;
delete account_system where nickname= '신한재훈';


delete "ACCOUNT_신한" where ACCOUNT_NO = '1' ;
commit;
rollback;



