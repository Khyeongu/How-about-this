-- 생성자 Oracle SQL Developer Data Modeler 20.4.0.374.0801
--   위치:        2021-04-02 10:30:33 KST
--   사이트:      Oracle Database 11g
--   유형:      Oracle Database 11g



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

DROP TABLE board CASCADE CONSTRAINT PURGE;
DROP TABLE member CASCADE CONSTRAINT PURGE;
DROP TABLE review CASCADE CONSTRAINT PURGE;
DROP TABLE traderecord CASCADE CONSTRAINT PURGE;
DROP TABLE reply CASCADE CONSTRAINT PURGE;
DROP TABLE zzim CASCADE CONSTRAINT PURGE;
DROP TABLE category CASCADE CONSTRAINT PURGE;

DROP CLUSTER c_review;

DROP SEQUENCE board_id_seq;
DROP SEQUENCE member_id_seq;
DROP SEQUENCE reply_id_seq;
DROP SEQUENCE review_id_seq;

DROP SYNONYM love;

CREATE TABLE board (
    id           NUMBER(10) NOT NULL,
    title        VARCHAR2(50) NOT NULL,
    content      VARCHAR2(300) NOT NULL,
    price        NUMBER(10) NOT NULL,
    status       CHAR(1) NOT NULL,
    time         DATE NOT NULL,
    start_date   DATE NOT NULL,
    end_date     DATE NOT NULL,
    image_url    VARCHAR2(100),
    category_id  NUMBER(3) NOT NULL,
    member_id    NUMBER(10) NOT NULL
)
PARTITION BY RANGE(time) (   -- Partitoned Table 사용
	PARTITION y_2018 VALUES LESS THAN(TO_DATE('2018-12-31 23:59:59','YYYY/MM/DD HH24:MI:SS')),
	PARTITION y_2019 VALUES LESS THAN(TO_DATE('2019-12-31 23:59:59','YYYY/MM/DD HH24:MI:SS')),
	PARTITION y_2020 VALUES LESS THAN(TO_DATE('2020-12-31 23:59:59','YYYY/MM/DD HH24:MI:SS')),
	PARTITION y_2021 VALUES LESS THAN(TO_DATE('2021-12-31 23:59:59','YYYY/MM/DD HH24:MI:SS'))
);


CREATE SEQUENCE board_id_seq INCREMENT BY 1 START WITH 1;

-- INSERT INTO board(id) VALUES(board_id_seq.NEXTVAL);

CREATE INDEX board_id_idx ON board(id);

ALTER TABLE board ADD CONSTRAINT board_pk PRIMARY KEY ( id );

CREATE TABLE category (
    id    NUMBER(3) NOT NULL,
    name  VARCHAR2(30) NOT NULL
);

ALTER TABLE category ADD CONSTRAINT category_pk PRIMARY KEY ( id );

CREATE CLUSTER c_review (id number(10)) INDEX;

CREATE INDEX i_review ON CLUSTER c_review;

CREATE TABLE member (
    id              NUMBER(10) NOT NULL,
    login_id        VARCHAR2(15) NOT NULL,
    login_password  VARCHAR2(15) NOT NULL,
    name            VARCHAR2(10) NOT NULL,
    phone_number    VARCHAR2(13) NOT NULL,
    birthdate       DATE NOT NULL,
    nickname        VARCHAR2(15) NOT NULL
)
CLUSTER c_review (id);

CREATE SEQUENCE member_id_seq INCREMENT BY 1 START WITH 1;

CREATE INDEX member_id_idx ON member(id);

ALTER TABLE member ADD CONSTRAINT member_pk PRIMARY KEY ( id );

CREATE TABLE reply (
    id        NUMBER(10) NOT NULL,
    content   VARCHAR2(100) NOT NULL,
    time      DATE NOT NULL,
    board_id  NUMBER(10) NOT NULL
);

CREATE SEQUENCE reply_id_seq INCREMENT BY 1 START WITH 1;

CREATE INDEX reply_id_idx ON reply(id);

ALTER TABLE reply ADD CONSTRAINT reply_pk PRIMARY KEY ( id );

CREATE TABLE review (
    id         NUMBER(10) NOT NULL,
    grade      NUMBER(2, 1) NOT NULL,
    content    VARCHAR2(30) NOT NULL,
    time       DATE NOT NULL,
    member_id  NUMBER(10) NOT NULL
)
CLUSTER c_review (id)
;

CREATE SEQUENCE review_id_seq INCREMENT BY 1 START WITH 1;

CREATE INDEX review_id_idx ON review(id);

ALTER TABLE review ADD CONSTRAINT review_pk PRIMARY KEY ( id );

CREATE TABLE traderecord (
    board_id   NUMBER(10) NOT NULL,
    time       DATE NOT NULL,
    member_id  NUMBER(10) NOT NULL,
	category_id NUMBER(3) NOT NULL,
	PRIMARY KEY (member_id,board_id)
	)
ORGANIZATION INDEX;

CREATE UNIQUE INDEX traderecord__idx ON
    traderecord (
        board_id
    ASC );

CREATE TABLE zzim (
    board_id   NUMBER(10) NOT NULL,
    member_id  NUMBER(10) NOT NULL,
	PRIMARY KEY (member_id, board_id)
)
ORGANIZATION INDEX;

CREATE SYNONYM love FOR zzim;

ALTER TABLE board
    ADD CONSTRAINT board_category_fk FOREIGN KEY ( category_id )
        REFERENCES category ( id );

ALTER TABLE board
    ADD CONSTRAINT board_member_fk FOREIGN KEY ( member_id )
        REFERENCES member ( id );

ALTER TABLE reply
    ADD CONSTRAINT reply_board_fk FOREIGN KEY ( board_id )
        REFERENCES board ( id );

ALTER TABLE review
    ADD CONSTRAINT review_member_fk FOREIGN KEY ( member_id )
        REFERENCES member ( id );

ALTER TABLE traderecord
    ADD CONSTRAINT traderecord_board_fk FOREIGN KEY ( board_id )
        REFERENCES board ( id );

ALTER TABLE traderecord
    ADD CONSTRAINT traderecord_member_fk FOREIGN KEY ( member_id )
        REFERENCES member ( id );

ALTER TABLE zzim
    ADD CONSTRAINT zzim_board_fk FOREIGN KEY ( board_id )
        REFERENCES board ( id );

ALTER TABLE zzim
    ADD CONSTRAINT zzim_member_fk FOREIGN KEY ( member_id )
        REFERENCES member ( id );






-- Oracle SQL Developer Data Modeler 요약 보고서: 
-- 
-- CREATE TABLE                             7
-- CREATE INDEX                             1
-- ALTER TABLE                             15
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
