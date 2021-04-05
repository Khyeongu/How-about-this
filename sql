--------------------------------------------------------
--  파일이 생성됨 - 월요일-4월-05-2021   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence BOARD_ID_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "BOARD_ID_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 41 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence MEMBER_ID_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "MEMBER_ID_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence REPLY_ID_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "REPLY_ID_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence REVIEW_ID_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "REVIEW_ID_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Table BOARD
--------------------------------------------------------

  CREATE TABLE "BOARD" 
   (	"ID" NUMBER(10,0), 
	"TITLE" VARCHAR2(50 BYTE), 
	"CONTENT" VARCHAR2(300 BYTE), 
	"PRICE" NUMBER(10,0), 
	"STATUS" CHAR(1 BYTE), 
	"TIME" DATE, 
	"START_DATE" DATE, 
	"END_DATE" DATE, 
	"IMAGE_URL" VARCHAR2(100 BYTE), 
	"CATEGORY_ID" NUMBER(3,0), 
	"MEMBER_ID" NUMBER(10,0)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
  STORAGE(
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" 
  PARTITION BY RANGE ("TIME") 
 (PARTITION "Y_2018"  VALUES LESS THAN (TO_DATE(' 2018-12-31 23:59:59', 'SYYYY-MM-DD HH24:MI:SS', 'NLS_CALENDAR=GREGORIAN')) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING 
  STORAGE(INITIAL 8388608 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" , 
 PARTITION "Y_2019"  VALUES LESS THAN (TO_DATE(' 2019-12-31 23:59:59', 'SYYYY-MM-DD HH24:MI:SS', 'NLS_CALENDAR=GREGORIAN')) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING 
  STORAGE(INITIAL 8388608 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" , 
 PARTITION "Y_2020"  VALUES LESS THAN (TO_DATE(' 2020-12-31 23:59:59', 'SYYYY-MM-DD HH24:MI:SS', 'NLS_CALENDAR=GREGORIAN')) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING 
  STORAGE(INITIAL 8388608 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" , 
 PARTITION "Y_2021"  VALUES LESS THAN (TO_DATE(' 2021-12-31 23:59:59', 'SYYYY-MM-DD HH24:MI:SS', 'NLS_CALENDAR=GREGORIAN')) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING 
  STORAGE(INITIAL 8388608 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ) ;
--------------------------------------------------------
--  DDL for Table CATEGORY
--------------------------------------------------------

  CREATE TABLE "CATEGORY" 
   (	"ID" NUMBER(3,0), 
	"NAME" VARCHAR2(30 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table MEMBER
--------------------------------------------------------

  CREATE TABLE "MEMBER" 
   (	"ID" NUMBER(10,0), 
	"LOGIN_ID" VARCHAR2(15 BYTE), 
	"LOGIN_PASSWORD" VARCHAR2(15 BYTE), 
	"NAME" VARCHAR2(10 BYTE), 
	"PHONE_NUMBER" VARCHAR2(13 BYTE), 
	"BIRTHDATE" DATE, 
	"NICKNAME" VARCHAR2(15 BYTE)
   ) CLUSTER "C_REVIEW" ("ID");
--------------------------------------------------------
--  DDL for Table REPLY
--------------------------------------------------------

  CREATE TABLE "REPLY" 
   (	"ID" NUMBER(10,0), 
	"CONTENT" VARCHAR2(100 BYTE), 
	"TIME" DATE, 
	"BOARD_ID" NUMBER(10,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table REVIEW
--------------------------------------------------------

  CREATE TABLE "REVIEW" 
   (	"ID" NUMBER(10,0), 
	"GRADE" NUMBER(2,1), 
	"CONTENT" VARCHAR2(30 BYTE), 
	"TIME" DATE, 
	"MEMBER_ID" NUMBER(10,0)
   ) CLUSTER "C_REVIEW" ("ID");
--------------------------------------------------------
--  DDL for Table TRADERECORD
--------------------------------------------------------

  CREATE TABLE "TRADERECORD" 
   (	"BOARD_ID" NUMBER(10,0), 
	"TIME" DATE, 
	"MEMBER_ID" NUMBER(10,0), 
	"CATEGORY_ID" NUMBER(3,0), 
	 PRIMARY KEY ("MEMBER_ID", "BOARD_ID") ENABLE
   ) SEGMENT CREATION IMMEDIATE 
  ORGANIZATION INDEX NOCOMPRESS PCTFREE 10 INITRANS 2 MAXTRANS 255 LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" 
 PCTTHRESHOLD 50;
--------------------------------------------------------
--  DDL for Table ZZIM
--------------------------------------------------------

  CREATE TABLE "ZZIM" 
   (	"BOARD_ID" NUMBER(10,0), 
	"MEMBER_ID" NUMBER(10,0), 
	 PRIMARY KEY ("MEMBER_ID", "BOARD_ID") ENABLE
   ) SEGMENT CREATION IMMEDIATE 
  ORGANIZATION INDEX NOCOMPRESS PCTFREE 10 INITRANS 2 MAXTRANS 255 LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" 
 PCTTHRESHOLD 50;
--------------------------------------------------------
--  DDL for View MEMBER_VIEW
--------------------------------------------------------

  CREATE OR REPLACE FORCE EDITIONABLE VIEW "MEMBER_VIEW" ("ID", "LOGIN_ID", "NAME", "PHONE_NUMBER", "BIRTHDATE", "NICKNAME") AS 
  select id, login_id, name, phone_number, birthdate, nickname
from member
;
REM INSERTING into BOARD
SET DEFINE OFF;
Insert into BOARD (ID,TITLE,CONTENT,PRICE,STATUS,TIME,START_DATE,END_DATE,IMAGE_URL,CATEGORY_ID,MEMBER_ID) values (15,'투명 신발정리 함','수납 공간 장난 아님',2000,'1',to_date('18/01/24','RR/MM/DD'),to_date('18/01/24','RR/MM/DD'),to_date('18/03/31','RR/MM/DD'),'C:\Users\user\Desktop\현대IT&E\project\How-about-this\bin\boardImgshoe.jpg',2,3);
Insert into BOARD (ID,TITLE,CONTENT,PRICE,STATUS,TIME,START_DATE,END_DATE,IMAGE_URL,CATEGORY_ID,MEMBER_ID) values (19,'노래하는 코끼리','노래하는 코끼리 애기들이 정말 좋아해욧',1500,'1',to_date('18/04/12','RR/MM/DD'),to_date('18/04/12','RR/MM/DD'),to_date('20/12/12','RR/MM/DD'),'C:\Users\user\Desktop\현대IT&E\project\How-about-this\bin\boardImgsingcokiri.jpg',3,2);
Insert into BOARD (ID,TITLE,CONTENT,PRICE,STATUS,TIME,START_DATE,END_DATE,IMAGE_URL,CATEGORY_ID,MEMBER_ID) values (27,'beats studio3 wireless','음질 장난 아닙니다.',2000,'1',to_date('18/07/25','RR/MM/DD'),to_date('18/07/25','RR/MM/DD'),to_date('18/07/28','RR/MM/DD'),'C:\Users\user\Desktop\현대IT&E\project\How-about-this\bin\boardImgheadphone.jpg',1,3);
Insert into BOARD (ID,TITLE,CONTENT,PRICE,STATUS,TIME,START_DATE,END_DATE,IMAGE_URL,CATEGORY_ID,MEMBER_ID) values (12,'갤럭시탭 북커버 포함 ','써보니 좋았어요',7000,'1',to_date('19/10/23','RR/MM/DD'),to_date('19/10/30','RR/MM/DD'),to_date('19/11/20','RR/MM/DD'),'C:\Users\user\Desktop\현대IT&E\project\How-about-this\bin\boardImggaltab.jpg',1,2);
Insert into BOARD (ID,TITLE,CONTENT,PRICE,STATUS,TIME,START_DATE,END_DATE,IMAGE_URL,CATEGORY_ID,MEMBER_ID) values (13,'공간 덜 차지하는 책상 ','은근 많이 올려둘 수 있어요',13000,'1',to_date('19/12/17','RR/MM/DD'),to_date('19/12/17','RR/MM/DD'),to_date('20/04/02','RR/MM/DD'),'C:\Users\user\Desktop\현대IT&E\project\How-about-this\bin\boardImgtable1.jpg',2,2);
Insert into BOARD (ID,TITLE,CONTENT,PRICE,STATUS,TIME,START_DATE,END_DATE,IMAGE_URL,CATEGORY_ID,MEMBER_ID) values (14,'많은 옷 걸기 가능 행거','옷 정리에 탁월합니다',2000,'1',to_date('19/07/24','RR/MM/DD'),to_date('19/07/24','RR/MM/DD'),to_date('20/04/03','RR/MM/DD'),'C:\Users\user\Desktop\현대IT&E\project\How-about-this\bin\boardImghangers.jpg',2,1);
Insert into BOARD (ID,TITLE,CONTENT,PRICE,STATUS,TIME,START_DATE,END_DATE,IMAGE_URL,CATEGORY_ID,MEMBER_ID) values (26,'갤럭시탭 북커버 포함 ','써보니 좋았어요',7000,'1',to_date('19/10/23','RR/MM/DD'),to_date('19/10/30','RR/MM/DD'),to_date('19/11/20','RR/MM/DD'),'C:\Users\user\Desktop\현대IT&E\project\How-about-this\bin\boardImggaltab.jpg',1,2);
Insert into BOARD (ID,TITLE,CONTENT,PRICE,STATUS,TIME,START_DATE,END_DATE,IMAGE_URL,CATEGORY_ID,MEMBER_ID) values (2,'맥북 pro빌려드립니다.','맥북 탐나지 않으세요?',80000,'0',to_date('20/04/03','RR/MM/DD'),to_date('21/04/03','RR/MM/DD'),to_date('21/04/10','RR/MM/DD'),'C:\Users\user\Desktop\현대IT&E\project\How-about-this\bin\boardImgmacbook.jpg',1,3);
Insert into BOARD (ID,TITLE,CONTENT,PRICE,STATUS,TIME,START_DATE,END_DATE,IMAGE_URL,CATEGORY_ID,MEMBER_ID) values (4,'미니 소파','편하게 쉴 수 있어요',20000,'0',to_date('20/09/26','RR/MM/DD'),to_date('20/04/03','RR/MM/DD'),to_date('20/04/10','RR/MM/DD'),'C:\Users\user\Desktop\현대IT&E\project\How-about-this\bin\boardImgminisofa1.jpg',2,3);
Insert into BOARD (ID,TITLE,CONTENT,PRICE,STATUS,TIME,START_DATE,END_DATE,IMAGE_URL,CATEGORY_ID,MEMBER_ID) values (5,'갤럭시s20','저는 핸드폰 많아요~',10000,'0',to_date('20/07/25','RR/MM/DD'),to_date('20/04/03','RR/MM/DD'),to_date('20/04/10','RR/MM/DD'),'C:\Users\user\Desktop\현대IT&E\project\How-about-this\bin\boardImgs20.jpg',1,3);
Insert into BOARD (ID,TITLE,CONTENT,PRICE,STATUS,TIME,START_DATE,END_DATE,IMAGE_URL,CATEGORY_ID,MEMBER_ID) values (6,'에어팟 프로','이어폰 싸게 팝니다',20000,'0',to_date('20/10/13','RR/MM/DD'),to_date('20/04/03','RR/MM/DD'),to_date('21/04/10','RR/MM/DD'),'C:\Users\user\Desktop\현대IT&E\project\How-about-this\bin\boardImgairpod.jpg',1,3);
Insert into BOARD (ID,TITLE,CONTENT,PRICE,STATUS,TIME,START_DATE,END_DATE,IMAGE_URL,CATEGORY_ID,MEMBER_ID) values (7,'고글','이번 겨울 저는 안 써요',12000,'0',to_date('20/06/14','RR/MM/DD'),to_date('20/04/03','RR/MM/DD'),to_date('21/04/10','RR/MM/DD'),'C:\Users\user\Desktop\현대IT&E\project\How-about-this\bin\boardImggogle.jpg',1,3);
Insert into BOARD (ID,TITLE,CONTENT,PRICE,STATUS,TIME,START_DATE,END_DATE,IMAGE_URL,CATEGORY_ID,MEMBER_ID) values (9,'빔 프로젝터','넷플릭스 한 편 보세요',900,'0',to_date('20/12/23','RR/MM/DD'),to_date('20/12/23','RR/MM/DD'),to_date('20/12/27','RR/MM/DD'),'C:\Users\user\Desktop\현대IT&E\project\How-about-this\bin\boardImgvim.jpg',1,2);
Insert into BOARD (ID,TITLE,CONTENT,PRICE,STATUS,TIME,START_DATE,END_DATE,IMAGE_URL,CATEGORY_ID,MEMBER_ID) values (11,'클로바 인공지능 스피커','2가지 종류 선택 가능',5000,'1',to_date('20/09/23','RR/MM/DD'),to_date('20/09/23','RR/MM/DD'),to_date('20/10/05','RR/MM/DD'),'C:\Users\user\Desktop\현대IT&E\project\How-about-this\bin\boardImgclova.jpg',1,2);
Insert into BOARD (ID,TITLE,CONTENT,PRICE,STATUS,TIME,START_DATE,END_DATE,IMAGE_URL,CATEGORY_ID,MEMBER_ID) values (16,'아기 포브','무게감 저하',5000,'1',to_date('20/11/28','RR/MM/DD'),to_date('20/11/28','RR/MM/DD'),to_date('21/02/25','RR/MM/DD'),'C:\Users\user\Desktop\현대IT&E\project\How-about-this\bin\boardImgbabypove.jpg',3,3);
Insert into BOARD (ID,TITLE,CONTENT,PRICE,STATUS,TIME,START_DATE,END_DATE,IMAGE_URL,CATEGORY_ID,MEMBER_ID) values (21,'강아지 우비','강아지도 비를 피해야지요',1000,'1',to_date('20/01/31','RR/MM/DD'),to_date('20/01/31','RR/MM/DD'),to_date('20/03/31','RR/MM/DD'),'C:\Users\user\Desktop\현대IT&E\project\How-about-this\bin\boardImgrain.jpg',10,3);
Insert into BOARD (ID,TITLE,CONTENT,PRICE,STATUS,TIME,START_DATE,END_DATE,IMAGE_URL,CATEGORY_ID,MEMBER_ID) values (23,'빔 프로젝터','넷플릭스 한 편 보세요',900,'0',to_date('20/12/23','RR/MM/DD'),to_date('20/12/23','RR/MM/DD'),to_date('20/12/27','RR/MM/DD'),'C:\Users\user\Desktop\현대IT&E\project\How-about-this\bin\boardImgvim.jpg',1,2);
Insert into BOARD (ID,TITLE,CONTENT,PRICE,STATUS,TIME,START_DATE,END_DATE,IMAGE_URL,CATEGORY_ID,MEMBER_ID) values (25,'클로바 인공지능 스피커','2가지 종류 선택 가능',5000,'1',to_date('20/09/23','RR/MM/DD'),to_date('20/09/23','RR/MM/DD'),to_date('20/10/05','RR/MM/DD'),'C:\Users\user\Desktop\현대IT&E\project\How-about-this\bin\boardImgclova.jpg',1,2);
Insert into BOARD (ID,TITLE,CONTENT,PRICE,STATUS,TIME,START_DATE,END_DATE,IMAGE_URL,CATEGORY_ID,MEMBER_ID) values (1,'아이패드 빌려드립니다.','아이패드 프로3 써보고 싶으신분~?',500000,'0',to_date('21/04/02','RR/MM/DD'),to_date('21/04/02','RR/MM/DD'),to_date('21/05/27','RR/MM/DD'),'C:\Users\user\Desktop\현대IT&E\project\How-about-this\bin\boardImgipad.jpg',1,3);
Insert into BOARD (ID,TITLE,CONTENT,PRICE,STATUS,TIME,START_DATE,END_DATE,IMAGE_URL,CATEGORY_ID,MEMBER_ID) values (3,'책장','인테리어 책장',3000,'0',to_date('21/03/15','RR/MM/DD'),to_date('21/04/03','RR/MM/DD'),to_date('21/04/10','RR/MM/DD'),'C:\Users\user\Desktop\현대IT&E\project\How-about-this\bin\boardImgshelf.jpg',2,3);
Insert into BOARD (ID,TITLE,CONTENT,PRICE,STATUS,TIME,START_DATE,END_DATE,IMAGE_URL,CATEGORY_ID,MEMBER_ID) values (17,'유아용 크록스','애기에게 맞는건지 테스트해 보아요',500,'1',to_date('21/08/03','RR/MM/DD'),to_date('21/08/03','RR/MM/DD'),to_date('21/10/10','RR/MM/DD'),'C:\Users\user\Desktop\현대IT&E\project\How-about-this\bin\boardImgchicorcs.jpg',3,1);
Insert into BOARD (ID,TITLE,CONTENT,PRICE,STATUS,TIME,START_DATE,END_DATE,IMAGE_URL,CATEGORY_ID,MEMBER_ID) values (18,'인기있는 촉감 교육','애기들의 촉감 능력을 향상시켜요',100,'1',to_date('21/06/16','RR/MM/DD'),to_date('21/06/29','RR/MM/DD'),to_date('21/09/09','RR/MM/DD'),'C:\Users\user\Desktop\현대IT&E\project\How-about-this\bin\boardImgpushpop.jpg',3,2);
Insert into BOARD (ID,TITLE,CONTENT,PRICE,STATUS,TIME,START_DATE,END_DATE,IMAGE_URL,CATEGORY_ID,MEMBER_ID) values (28,'아이폰12','저는 새 폰 씁니다',3000,'0',to_date('21/04/01','RR/MM/DD'),to_date('21/04/01','RR/MM/DD'),to_date('21/04/02','RR/MM/DD'),'C:\Users\user\Desktop\현대IT&E\project\How-about-this\bin\boardImgiphone12.jpg',1,3);
REM INSERTING into CATEGORY
SET DEFINE OFF;
Insert into CATEGORY (ID,NAME) values (1,'디지털/가전');
Insert into CATEGORY (ID,NAME) values (2,'가구/인테리어');
Insert into CATEGORY (ID,NAME) values (3,'유아동/유아도서');
Insert into CATEGORY (ID,NAME) values (4,'스포츠/레저');
Insert into CATEGORY (ID,NAME) values (5,'여성잡화');
Insert into CATEGORY (ID,NAME) values (6,'여성의류');
Insert into CATEGORY (ID,NAME) values (7,'남성패션/잡화');
Insert into CATEGORY (ID,NAME) values (8,'게임/취미');
Insert into CATEGORY (ID,NAME) values (9,'뷰티/미용');
Insert into CATEGORY (ID,NAME) values (10,'반려동물용품');
Insert into CATEGORY (ID,NAME) values (11,'도서/티켓/음반');
Insert into CATEGORY (ID,NAME) values (12,'식물');
Insert into CATEGORY (ID,NAME) values (13,'기타');
REM INSERTING into MEMBER
SET DEFINE OFF;
Insert into MEMBER (ID,LOGIN_ID,LOGIN_PASSWORD,NAME,PHONE_NUMBER,BIRTHDATE,NICKNAME) values (1,'ck','12ck','이채경','010-4520-0793',to_date('96/08/03','RR/MM/DD'),'chaeky');
Insert into MEMBER (ID,LOGIN_ID,LOGIN_PASSWORD,NAME,PHONE_NUMBER,BIRTHDATE,NICKNAME) values (6,'seojun12','dfik','이서준','010-4542-6332',to_date('56/07/08','RR/MM/DD'),'Mr.Seo');
Insert into MEMBER (ID,LOGIN_ID,LOGIN_PASSWORD,NAME,PHONE_NUMBER,BIRTHDATE,NICKNAME) values (2,'tom','toms12','토미','010-4344-0567',to_date('92/07/29','RR/MM/DD'),'tommy');
Insert into MEMBER (ID,LOGIN_ID,LOGIN_PASSWORD,NAME,PHONE_NUMBER,BIRTHDATE,NICKNAME) values (3,'jenny','jennies1234','제니','010-2342-0922',to_date('01/05/12','RR/MM/DD'),'jennyhart');
Insert into MEMBER (ID,LOGIN_ID,LOGIN_PASSWORD,NAME,PHONE_NUMBER,BIRTHDATE,NICKNAME) values (5,'leemin','minzoon2','이민준','010-4346-1646',to_date('09/03/27','RR/MM/DD'),'min12');
Insert into MEMBER (ID,LOGIN_ID,LOGIN_PASSWORD,NAME,PHONE_NUMBER,BIRTHDATE,NICKNAME) values (10,'ahyoung','wooah','유아영','010-2142-4215',to_date('76/11/07','RR/MM/DD'),'ahyoung');
Insert into MEMBER (ID,LOGIN_ID,LOGIN_PASSWORD,NAME,PHONE_NUMBER,BIRTHDATE,NICKNAME) values (12,'yuseok13','ohwoo','오유석','010-5642-6221',to_date('01/01/20','RR/MM/DD'),'유석oh');
Insert into MEMBER (ID,LOGIN_ID,LOGIN_PASSWORD,NAME,PHONE_NUMBER,BIRTHDATE,NICKNAME) values (13,'chacah12','jiwoo','차지우','010-1542-3935',to_date('15/05/06','RR/MM/DD'),'chacha');
Insert into MEMBER (ID,LOGIN_ID,LOGIN_PASSWORD,NAME,PHONE_NUMBER,BIRTHDATE,NICKNAME) values (14,'halim','chicken','임지수','010-4142-3522',to_date('13/05/12','RR/MM/DD'),'lim98');
Insert into MEMBER (ID,LOGIN_ID,LOGIN_PASSWORD,NAME,PHONE_NUMBER,BIRTHDATE,NICKNAME) values (11,'jiwonlee','2jiwon','이지원','010-4214-5622',to_date('97/03/02','RR/MM/DD'),'ziwon2');
Insert into MEMBER (ID,LOGIN_ID,LOGIN_PASSWORD,NAME,PHONE_NUMBER,BIRTHDATE,NICKNAME) values (7,'yes24','jkued','김예준','010-2156-7335',to_date('85/02/26','RR/MM/DD'),'Kim0450');
Insert into MEMBER (ID,LOGIN_ID,LOGIN_PASSWORD,NAME,PHONE_NUMBER,BIRTHDATE,NICKNAME) values (8,'jang9867','jang12','장도윤','010-4612-0363',to_date('10/08/20','RR/MM/DD'),'짱도');
Insert into MEMBER (ID,LOGIN_ID,LOGIN_PASSWORD,NAME,PHONE_NUMBER,BIRTHDATE,NICKNAME) values (9,'soyoungtwo','two2','임소영','010-7142-3522',to_date('62/09/04','RR/MM/DD'),'쏘');
REM INSERTING into REPLY
SET DEFINE OFF;
Insert into REPLY (ID,CONTENT,TIME,BOARD_ID) values (1,'진짜 갖고 싶다...',to_date('21/04/03','RR/MM/DD'),2);
Insert into REPLY (ID,CONTENT,TIME,BOARD_ID) values (2,'연락 드릴께요.',to_date('21/04/04','RR/MM/DD'),2);
Insert into REPLY (ID,CONTENT,TIME,BOARD_ID) values (3,'이번에 새로운 제품 나오지 않아요?',to_date('21/05/03','RR/MM/DD'),2);
Insert into REPLY (ID,CONTENT,TIME,BOARD_ID) values (4,'몇년도꺼 인가요?',to_date('21/05/07','RR/MM/DD'),2);
Insert into REPLY (ID,CONTENT,TIME,BOARD_ID) values (5,'I love it',to_date('21/07/15','RR/MM/DD'),2);
Insert into REPLY (ID,CONTENT,TIME,BOARD_ID) values (6,'연락드릴꼐요~',to_date('21/04/05','RR/MM/DD'),2);
REM INSERTING into REVIEW
SET DEFINE OFF;
Insert into REVIEW (ID,GRADE,CONTENT,TIME,MEMBER_ID) values (1,4.5,'쿨거래했어요~',to_date('20/02/05','RR/MM/DD'),3);
Insert into REVIEW (ID,GRADE,CONTENT,TIME,MEMBER_ID) values (2,5,'정말 친절하세요^^',to_date('20/04/05','RR/MM/DD'),3);
Insert into REVIEW (ID,GRADE,CONTENT,TIME,MEMBER_ID) values (3,2.5,'강아지옷에서 결함이..',to_date('20/12/12','RR/MM/DD'),3);
Insert into REVIEW (ID,GRADE,CONTENT,TIME,MEMBER_ID) values (4,3,'좋아요!',to_date('21/08/05','RR/MM/DD'),3);
Insert into REVIEW (ID,GRADE,CONTENT,TIME,MEMBER_ID) values (5,4,'전자기기의 대명사',to_date('21/04/05','RR/MM/DD'),3);
REM INSERTING into TRADERECORD
SET DEFINE OFF;
Insert into TRADERECORD (BOARD_ID,TIME,MEMBER_ID,CATEGORY_ID) values (1,to_date('20/01/25','RR/MM/DD'),3,1);
Insert into TRADERECORD (BOARD_ID,TIME,MEMBER_ID,CATEGORY_ID) values (2,to_date('21/02/10','RR/MM/DD'),3,1);
Insert into TRADERECORD (BOARD_ID,TIME,MEMBER_ID,CATEGORY_ID) values (3,to_date('20/03/27','RR/MM/DD'),3,2);
Insert into TRADERECORD (BOARD_ID,TIME,MEMBER_ID,CATEGORY_ID) values (4,to_date('20/04/16','RR/MM/DD'),3,2);
Insert into TRADERECORD (BOARD_ID,TIME,MEMBER_ID,CATEGORY_ID) values (5,to_date('21/03/18','RR/MM/DD'),3,1);
Insert into TRADERECORD (BOARD_ID,TIME,MEMBER_ID,CATEGORY_ID) values (6,to_date('20/06/19','RR/MM/DD'),3,1);
Insert into TRADERECORD (BOARD_ID,TIME,MEMBER_ID,CATEGORY_ID) values (7,to_date('20/11/20','RR/MM/DD'),3,1);
Insert into TRADERECORD (BOARD_ID,TIME,MEMBER_ID,CATEGORY_ID) values (15,to_date('21/03/09','RR/MM/DD'),3,2);
Insert into TRADERECORD (BOARD_ID,TIME,MEMBER_ID,CATEGORY_ID) values (21,to_date('21/03/19','RR/MM/DD'),3,10);
REM INSERTING into ZZIM
SET DEFINE OFF;
Insert into ZZIM (BOARD_ID,MEMBER_ID) values (17,3);
REM INSERTING into MEMBER_VIEW
SET DEFINE OFF;
Insert into MEMBER_VIEW (ID,LOGIN_ID,NAME,PHONE_NUMBER,BIRTHDATE,NICKNAME) values (1,'ck','이채경','010-4520-0793',to_date('96/08/03','RR/MM/DD'),'chaeky');
Insert into MEMBER_VIEW (ID,LOGIN_ID,NAME,PHONE_NUMBER,BIRTHDATE,NICKNAME) values (6,'seojun12','이서준','010-4542-6332',to_date('56/07/08','RR/MM/DD'),'Mr.Seo');
Insert into MEMBER_VIEW (ID,LOGIN_ID,NAME,PHONE_NUMBER,BIRTHDATE,NICKNAME) values (2,'tom','토미','010-4344-0567',to_date('92/07/29','RR/MM/DD'),'tommy');
Insert into MEMBER_VIEW (ID,LOGIN_ID,NAME,PHONE_NUMBER,BIRTHDATE,NICKNAME) values (3,'jenny','제니','010-2342-0922',to_date('01/05/12','RR/MM/DD'),'jennyhart');
Insert into MEMBER_VIEW (ID,LOGIN_ID,NAME,PHONE_NUMBER,BIRTHDATE,NICKNAME) values (5,'leemin','이민준','010-4346-1646',to_date('09/03/27','RR/MM/DD'),'min12');
Insert into MEMBER_VIEW (ID,LOGIN_ID,NAME,PHONE_NUMBER,BIRTHDATE,NICKNAME) values (10,'ahyoung','유아영','010-2142-4215',to_date('76/11/07','RR/MM/DD'),'ahyoung');
Insert into MEMBER_VIEW (ID,LOGIN_ID,NAME,PHONE_NUMBER,BIRTHDATE,NICKNAME) values (12,'yuseok13','오유석','010-5642-6221',to_date('01/01/20','RR/MM/DD'),'유석oh');
Insert into MEMBER_VIEW (ID,LOGIN_ID,NAME,PHONE_NUMBER,BIRTHDATE,NICKNAME) values (13,'chacah12','차지우','010-1542-3935',to_date('15/05/06','RR/MM/DD'),'chacha');
Insert into MEMBER_VIEW (ID,LOGIN_ID,NAME,PHONE_NUMBER,BIRTHDATE,NICKNAME) values (14,'halim','임지수','010-4142-3522',to_date('13/05/12','RR/MM/DD'),'lim98');
Insert into MEMBER_VIEW (ID,LOGIN_ID,NAME,PHONE_NUMBER,BIRTHDATE,NICKNAME) values (11,'jiwonlee','이지원','010-4214-5622',to_date('97/03/02','RR/MM/DD'),'ziwon2');
Insert into MEMBER_VIEW (ID,LOGIN_ID,NAME,PHONE_NUMBER,BIRTHDATE,NICKNAME) values (7,'yes24','김예준','010-2156-7335',to_date('85/02/26','RR/MM/DD'),'Kim0450');
Insert into MEMBER_VIEW (ID,LOGIN_ID,NAME,PHONE_NUMBER,BIRTHDATE,NICKNAME) values (8,'jang9867','장도윤','010-4612-0363',to_date('10/08/20','RR/MM/DD'),'짱도');
Insert into MEMBER_VIEW (ID,LOGIN_ID,NAME,PHONE_NUMBER,BIRTHDATE,NICKNAME) values (9,'soyoungtwo','임소영','010-7142-3522',to_date('62/09/04','RR/MM/DD'),'쏘');
--------------------------------------------------------
--  DDL for Index BOARD_ID_IDX
--------------------------------------------------------

  CREATE INDEX "BOARD_ID_IDX" ON "BOARD" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index CATEGORY_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "CATEGORY_PK" ON "CATEGORY" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index I_REVIEW
--------------------------------------------------------

  CREATE INDEX "I_REVIEW" ON CLUSTER "C_REVIEW" 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index MEMBER_ID_IDX
--------------------------------------------------------

  CREATE INDEX "MEMBER_ID_IDX" ON "MEMBER" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index REPLY_ID_IDX
--------------------------------------------------------

  CREATE INDEX "REPLY_ID_IDX" ON "REPLY" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index REVIEW_ID_IDX
--------------------------------------------------------

  CREATE INDEX "REVIEW_ID_IDX" ON "REVIEW" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_IOT_TOP_76237
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_IOT_TOP_76237" ON "TRADERECORD" ("MEMBER_ID", "BOARD_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_IOT_TOP_76240
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_IOT_TOP_76240" ON "ZZIM" ("MEMBER_ID", "BOARD_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index TRADERECORD__IDX
--------------------------------------------------------

  CREATE UNIQUE INDEX "TRADERECORD__IDX" ON "TRADERECORD" ("BOARD_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index BOARD_ID_IDX
--------------------------------------------------------

  CREATE INDEX "BOARD_ID_IDX" ON "BOARD" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index CATEGORY_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "CATEGORY_PK" ON "CATEGORY" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index MEMBER_ID_IDX
--------------------------------------------------------

  CREATE INDEX "MEMBER_ID_IDX" ON "MEMBER" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index REPLY_ID_IDX
--------------------------------------------------------

  CREATE INDEX "REPLY_ID_IDX" ON "REPLY" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index REVIEW_ID_IDX
--------------------------------------------------------

  CREATE INDEX "REVIEW_ID_IDX" ON "REVIEW" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_IOT_TOP_76237
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_IOT_TOP_76237" ON "TRADERECORD" ("MEMBER_ID", "BOARD_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index TRADERECORD__IDX
--------------------------------------------------------

  CREATE UNIQUE INDEX "TRADERECORD__IDX" ON "TRADERECORD" ("BOARD_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_IOT_TOP_76240
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_IOT_TOP_76240" ON "ZZIM" ("MEMBER_ID", "BOARD_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Procedure DELETE_ZZIM_LIST
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "DELETE_ZZIM_LIST" 
(p_board_id in board.id%type,
 P_member_id in zzim.member_id%type)
IS
BEGIN
DELETE FROM zzim
WHERE board_id = p_board_id
and member_id = P_member_id;
  EXCEPTION
  WHEN OTHERS THEN
  DBMS_OUTPUT.PUT_LINE('SQL ERROR MESSAGE: ' || SQLERRM);
END;

/
--------------------------------------------------------
--  DDL for Procedure INSERT_BOARD_POST
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "INSERT_BOARD_POST" 
(
  p_title       in board.title%type,
  p_content     in board.content%type,
  p_price       in board.price%type,
  p_status      in board.status%type,
  p_start_date  in board.start_date%type,
  p_end_date    in board.end_date%type,
  p_image_url   in board.image_url%type,
  p_category_id in board.category_id%type,
  p_member_id   in board.member_id%type
)
is
begin
  insert into board (id, title, content, price, status, time, start_date, end_date, image_url, category_id, member_id)
  values (board_id_seq.NEXTVAL, p_title, p_content, p_price, p_status, sysdate, p_start_date, p_end_date, p_image_url, p_category_id, p_member_id);
  commit;
end;

/
--------------------------------------------------------
--  DDL for Procedure INSERT_MEMBER_SIGNUP
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "INSERT_MEMBER_SIGNUP" 
(
  p_login_id member.login_id%type,
  p_login_password member.login_password%type,
  p_name member.name%type,
  p_phone_number member.phone_number%type,
  p_birthdate member.birthdate%type,
  p_nickname member.nickname%type
)
is
begin
  insert into member values(member_id_seq.NEXTVAL, p_login_id, p_login_password, p_name, p_phone_number,
  p_birthdate,
  p_nickname);

end;

/
--------------------------------------------------------
--  DDL for Procedure INSERT_REPLY_BOARD
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "INSERT_REPLY_BOARD" 
(
  p_content reply.content%type,
  p_board_id reply.board_id%type
)
is
begin
  insert into reply values(reply_id_seq.NEXTVAL, p_content, to_char(sysdate, 'YYYY-MM-DD'), p_board_id);
end;

/
--------------------------------------------------------
--  DDL for Procedure INSERT_REVIEW_POST
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "INSERT_REVIEW_POST" 
(
  p_grade     in review.grade%type,
  p_content   in review.content%type,
  p_time      in review.time%type,
  p_member_id in review.member_id%type
)
is
begin
  insert into review (id, grade, content, time, member_id)
  values (review_id_seq.NEXTVAL, p_grade, p_content, p_time, p_member_id);
  commit;
end;

/
--------------------------------------------------------
--  DDL for Procedure INSERT_ZZIM_BOARD
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "INSERT_ZZIM_BOARD" 
(
  p_board_id zzim.board_id%type,
  p_member_id zzim.member_id%type
)
is
begin
  insert into zzim values (p_board_id, p_member_id);
end;

/
--------------------------------------------------------
--  DDL for Procedure SELECT_BOARD_ALL
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "SELECT_BOARD_ALL" 
(select_board_all_cursor out sys_refcursor)
IS
BEGIN
  open select_board_all_cursor for
    SELECT id, title, price, image_url, time
    FROM board
ORDER BY time desc;
  EXCEPTION
  WHEN OTHERS THEN
  DBMS_OUTPUT.PUT_LINE('SQL ERROR MESSAGE: ' || SQLERRM);
END;

/
--------------------------------------------------------
--  DDL for Procedure SELECT_BOARD_BY_SEARCH
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "SELECT_BOARD_BY_SEARCH" 
(p_category_title   in board.title%type,
 p_category_content in board.content%type,
 select_board_by_search_cursor out sys_refcursor)
IS
BEGIN
  open select_board_by_search_cursor for
    select id, title, price, image_url, time
    from board
    where title like '%'||p_category_title||'%'
    or content like '%'||p_category_content||'%';
  EXCEPTION
  WHEN OTHERS THEN
  DBMS_OUTPUT.PUT_LINE('SQL ERROR MESSAGE: ' || SQLERRM);
end;

/
--------------------------------------------------------
--  DDL for Procedure SELECT_BOARD_DETAIL
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "SELECT_BOARD_DETAIL" 
(
  board_id board.id%type,
  detail_cursor out sys_refcursor
)
is
begin
  open detail_cursor for
    select b.title, b.start_date, b.end_date, b.price, b.status, b.content, m.nickname, m.phone_number, b.image_url
    from board b, member m
    where b.id = board_id
    and m.id = b.member_id;
end;

/
--------------------------------------------------------
--  DDL for Procedure SELECT_BOARD_MEMBERID
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "SELECT_BOARD_MEMBERID" 
(
  p_board_id board.id%type,
  p_mem_id out board.member_id%type
)
is
begin
  select member_id into p_mem_id from board where id = p_board_id;
end;

/
--------------------------------------------------------
--  DDL for Procedure SELECT_BOARD_MINI
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "SELECT_BOARD_MINI" 
(select_board_mini_cursor out sys_refcursor)
IS
BEGIN
  open select_board_mini_cursor for
    SELECT id, title, price
    FROM board
    WHERE rownum<=5
    ORDER BY ID desc;
  EXCEPTION
  WHEN OTHERS THEN
  DBMS_OUTPUT.PUT_LINE('SQL ERROR MESSAGE: ' || SQLERRM);
END;

/
--------------------------------------------------------
--  DDL for Procedure SELECT_BOARD_MY_OLD
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "SELECT_BOARD_MY_OLD" 
(p_member_id in board.member_id%type,
 select_board_my_old_cursor out sys_refcursor)
IS
BEGIN
  open select_board_my_old_cursor for
    SELECT id, title, price, image_url, time, status
FROM board
WHERE member_id = p_member_id
ORDER BY time ASC;
  EXCEPTION
  WHEN OTHERS THEN
  DBMS_OUTPUT.PUT_LINE('SQL ERROR MESSAGE: ' || SQLERRM);
END;

/
--------------------------------------------------------
--  DDL for Procedure SELECT_BOARD_MY_RECENT
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "SELECT_BOARD_MY_RECENT" 
(p_member_id in board.member_id%type,
 select_board_my_recent_cursor out sys_refcursor)
IS
BEGIN
  open select_board_my_recent_cursor for
    select id, title, price, image_url, time, status
FROM board
WHERE member_id = p_member_id
ORDER BY time desc;
  EXCEPTION
  WHEN OTHERS THEN
  DBMS_OUTPUT.PUT_LINE('SQL ERROR MESSAGE: ' || SQLERRM);
END;

/
--------------------------------------------------------
--  DDL for Procedure SELECT_BOARD_MY_ZZIM
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "SELECT_BOARD_MY_ZZIM" 
(p_member_id in zzim.member_id%type,
 select_board_my_zzim_cursor out sys_refcursor)
IS
BEGIN
  open select_board_my_zzim_cursor for
    SELECT id, title, price, image_url, time, status
FROM board
WHERE id IN
    (SELECT board_id FROM zzim WHERE member_id = p_member_id);
  EXCEPTION
  WHEN OTHERS THEN
  DBMS_OUTPUT.PUT_LINE('SQL ERROR MESSAGE: ' || SQLERRM);
END;

/
--------------------------------------------------------
--  DDL for Procedure SELECT_BOARD_ONE_CATEGORY
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "SELECT_BOARD_ONE_CATEGORY" 
(p_category_id in board.category_id%type,
 select_board_one_category_board_cursor out sys_refcursor)
is
begin
  open select_board_one_category_board_cursor for
    select id, title, price, image_url, time
from board
where category_id = p_category_id
ORDER BY time desc;
  EXCEPTION
  WHEN OTHERS THEN
  DBMS_OUTPUT.PUT_LINE('SQL ERROR MESSAGE: ' || SQLERRM);
end;

/
--------------------------------------------------------
--  DDL for Procedure SELECT_CATEGORY_RANK
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "SELECT_CATEGORY_RANK" 
(select_category_rank_cursor out sys_refcursor)
IS
BEGIN
  open select_category_rank_cursor for
    SELECT category_id
    FROM(
      SELECT category_id, count(*)
      FROM traderecord
      GROUP BY category_id
      ORDER BY count(*) desc
    );
  EXCEPTION
  WHEN OTHERS THEN
  DBMS_OUTPUT.PUT_LINE('SQL ERROR MESSAGE: ' || SQLERRM);
END;

/
--------------------------------------------------------
--  DDL for Procedure SELECT_MEMBERID_NAME
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "SELECT_MEMBERID_NAME" 
(
  p_member_id   in  member.id%type,
  p_member_name out member.name%type
)
is
begin
  select name
  into p_member_name
  from member
  where id = p_member_id;
end;

/
--------------------------------------------------------
--  DDL for Procedure SELECT_MEMBER_GRADE
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "SELECT_MEMBER_GRADE" 
(
  p_member_id    in  member.id%type,
  p_member_grade out number
)
is
begin
  select avg(grade)
  into p_member_grade
  from review
  where member_id = p_member_id;
end;

/
--------------------------------------------------------
--  DDL for Procedure SELECT_MEMBER_ID_CHECK
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "SELECT_MEMBER_ID_CHECK" 
(p_id member.login_id%type,
p_cnt out number
)
is
begin
  select count(*) into p_cnt
  from member
  where login_id = p_id;
end;

/
--------------------------------------------------------
--  DDL for Procedure SELECT_MEMBER_INFO
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "SELECT_MEMBER_INFO" 
  (p_id member.login_id%type,
   p_pw member.login_password%type,
   p_memid out member.id%type,
   p_memName out member.name%type,
   p_memPhone_number out member.phone_number%type,
   p_memBirth out member.birthdate%type,
   p_memNickname out member.nickname%type
)
is
begin
    select id, name, phone_number, birthdate, nickname
    into p_memid, p_memName, p_memPhone_number, p_memBirth, p_memNickname from member_view
    where id = ( select select_member_check(p_id, p_pw) from dual);
end;

/
--------------------------------------------------------
--  DDL for Procedure SELECT_MEMBER_NICKNAME_CHECK
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "SELECT_MEMBER_NICKNAME_CHECK" 
(p_nickname member.nickname%type,
p_cnt out number
)
is
begin
  select count(*) into p_cnt
  from member
  where nickname = p_nickname;
end;

/
--------------------------------------------------------
--  DDL for Procedure SELECT_ONE_CATEGORY_BOARD
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "SELECT_ONE_CATEGORY_BOARD" 
(p_category_id in board.category_id%type,
 select_one_category_board_cursor out sys_refcursor)
is
begin
  open select_one_category_board_cursor for
    select id, title, price, image_url, time
from board
where category_id = p_category_id;
  EXCEPTION
  WHEN OTHERS THEN
  DBMS_OUTPUT.PUT_LINE('SQL ERROR MESSAGE: ' || SQLERRM);
end;

/
--------------------------------------------------------
--  DDL for Procedure SELECT_REPLY_BOARD
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "SELECT_REPLY_BOARD" 
(
  p_board_id reply.board_id%type,
  p_cursor out sys_refcursor
)
is
begin
  open p_cursor for
    select * from reply
    where board_id = p_board_id
    order by id;
end;

/
--------------------------------------------------------
--  DDL for Procedure SELECT_REVIEW_MEMBER
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "SELECT_REVIEW_MEMBER" 
(
  p_id     in  review.member_id%type,
  p_cursor out sys_refcursor
)
is
begin
  open p_cursor for
    select *
    from review
where member_id = p_id;
end;

/
--------------------------------------------------------
--  DDL for Procedure SELECT_TRADERECORD_MONTHLY
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "SELECT_TRADERECORD_MONTHLY" (
user_id in number,
select_traderecord_monthly_cursor out sys_refcursor
)
IS
BEGIN
  open select_traderecord_monthly_cursor for
    select TO_CHAR(t.time, 'YYYYMM') as month, sum(b.price) as total
    from TRADERECORD t, board b
    where t.member_id=user_id
      and t.board_id=b.id
      and t.time >= '20210101'
      and t.time <= '20211231'
      GROUP BY to_char(t.time, 'YYYYMM')
      ORDER BY month;
  EXCEPTION
  WHEN OTHERS THEN
  DBMS_OUTPUT.PUT_LINE('SQL ERROR MESSAGE: ' || SQLERRM);
END;

/
--------------------------------------------------------
--  DDL for Procedure SELECT_TRADERECORD_MONTHLY2
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "SELECT_TRADERECORD_MONTHLY2" (
    user_id in NUMBER,
    startDate in VARCHAR2,
    endDate in VARCHAR2,
    select_traderecord_monthly_cursor out sys_refcursor)
IS
BEGIN
  open select_traderecord_monthly_cursor for
    select TO_CHAR(t.time, 'YYYYMM') as month, sum(b.price) as total
    from TRADERECORD t, board b
    where t.member_id=user_id
      and t.board_id=b.id
      and t.time >= startDate
      and t.time <= endDate
      GROUP BY to_char(t.time, 'YYYYMM')
      ORDER BY month;
  EXCEPTION
  WHEN OTHERS THEN
  DBMS_OUTPUT.PUT_LINE('SQL ERROR MESSAGE: ' || SQLERRM);
END;

/
--------------------------------------------------------
--  DDL for Procedure SELECT_TRADERECORD_MONTHLY_POST
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "SELECT_TRADERECORD_MONTHLY_POST" (
    user_id in NUMBER,
    select_year in VARCHAR2,
    select_traderecord_monthly_post_cursor out sys_refcursor)
IS
BEGIN
    open select_traderecord_monthly_post_cursor for
    select b.title, b.price, TO_CHAR(t.time, 'YY/MM')
    from traderecord t, board b
    where t.member_id=user_id
        and t.board_id=b.id
        and t.time like SUBSTR(select_year, 3)||'/'||'%';
    EXCEPTION
  WHEN OTHERS THEN
  DBMS_OUTPUT.PUT_LINE('SQL ERROR MESSAGE: ' || SQLERRM);
END;

/
--------------------------------------------------------
--  DDL for Procedure SELECT_ZZIM
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "SELECT_ZZIM" 
(
  p_board_id zzim.board_id%type,
  p_member_id zzim.member_id%type,
  p_cnt out number
)
is
begin
  select count(*) into p_cnt from zzim
  where board_id = p_board_id and
           member_id = p_member_id;
end;

/
--------------------------------------------------------
--  DDL for Procedure UPDATE_BOARD_STATUS
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "UPDATE_BOARD_STATUS" 
(p_board_id in board.id%type)
IS
BEGIN
    UPDATE board
SET status = 1
WHERE id = p_board_id;
  EXCEPTION
  WHEN OTHERS THEN
  DBMS_OUTPUT.PUT_LINE('SQL ERROR MESSAGE: ' || SQLERRM);
END;

/
--------------------------------------------------------
--  DDL for Function SELECT_MEMBER_CHECK
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE FUNCTION "SELECT_MEMBER_CHECK" 
(p_id member.login_id%type,
p_pw member.login_password%type)
return number
is
  match_count member.id%type;
begin
  select id into match_count
  from member
  where login_id = p_id and
           login_password = p_pw;

  return match_count;
exception
  when no_data_found then
    return 0;
end;

/
--------------------------------------------------------
--  DDL for Synonymn LOVE
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE SYNONYM "LOVE" FOR "ZZIM";
--------------------------------------------------------
--  Constraints for Table BOARD
--------------------------------------------------------

  ALTER TABLE "BOARD" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "BOARD" MODIFY ("TITLE" NOT NULL ENABLE);
  ALTER TABLE "BOARD" MODIFY ("CONTENT" NOT NULL ENABLE);
  ALTER TABLE "BOARD" MODIFY ("PRICE" NOT NULL ENABLE);
  ALTER TABLE "BOARD" MODIFY ("STATUS" NOT NULL ENABLE);
  ALTER TABLE "BOARD" MODIFY ("TIME" NOT NULL ENABLE);
  ALTER TABLE "BOARD" MODIFY ("START_DATE" NOT NULL ENABLE);
  ALTER TABLE "BOARD" MODIFY ("END_DATE" NOT NULL ENABLE);
  ALTER TABLE "BOARD" MODIFY ("CATEGORY_ID" NOT NULL ENABLE);
  ALTER TABLE "BOARD" MODIFY ("MEMBER_ID" NOT NULL ENABLE);
  ALTER TABLE "BOARD" ADD CONSTRAINT "BOARD_PK" PRIMARY KEY ("ID")
  USING INDEX (CREATE INDEX "BOARD_ID_IDX" ON "BOARD" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" )  ENABLE;
--------------------------------------------------------
--  Constraints for Table CATEGORY
--------------------------------------------------------

  ALTER TABLE "CATEGORY" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "CATEGORY" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "CATEGORY" ADD CONSTRAINT "CATEGORY_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table MEMBER
--------------------------------------------------------

  ALTER TABLE "MEMBER" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "MEMBER" MODIFY ("LOGIN_ID" NOT NULL ENABLE);
  ALTER TABLE "MEMBER" MODIFY ("LOGIN_PASSWORD" NOT NULL ENABLE);
  ALTER TABLE "MEMBER" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "MEMBER" MODIFY ("PHONE_NUMBER" NOT NULL ENABLE);
  ALTER TABLE "MEMBER" MODIFY ("BIRTHDATE" NOT NULL ENABLE);
  ALTER TABLE "MEMBER" MODIFY ("NICKNAME" NOT NULL ENABLE);
  ALTER TABLE "MEMBER" ADD CONSTRAINT "MEMBER_PK" PRIMARY KEY ("ID")
  USING INDEX (CREATE INDEX "MEMBER_ID_IDX" ON "MEMBER" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" )  ENABLE;
--------------------------------------------------------
--  Constraints for Table REPLY
--------------------------------------------------------

  ALTER TABLE "REPLY" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "REPLY" MODIFY ("CONTENT" NOT NULL ENABLE);
  ALTER TABLE "REPLY" MODIFY ("TIME" NOT NULL ENABLE);
  ALTER TABLE "REPLY" MODIFY ("BOARD_ID" NOT NULL ENABLE);
  ALTER TABLE "REPLY" ADD CONSTRAINT "REPLY_PK" PRIMARY KEY ("ID")
  USING INDEX (CREATE INDEX "REPLY_ID_IDX" ON "REPLY" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" )  ENABLE;
--------------------------------------------------------
--  Constraints for Table REVIEW
--------------------------------------------------------

  ALTER TABLE "REVIEW" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "REVIEW" MODIFY ("GRADE" NOT NULL ENABLE);
  ALTER TABLE "REVIEW" MODIFY ("CONTENT" NOT NULL ENABLE);
  ALTER TABLE "REVIEW" MODIFY ("TIME" NOT NULL ENABLE);
  ALTER TABLE "REVIEW" MODIFY ("MEMBER_ID" NOT NULL ENABLE);
  ALTER TABLE "REVIEW" ADD CONSTRAINT "REVIEW_PK" PRIMARY KEY ("ID")
  USING INDEX (CREATE INDEX "REVIEW_ID_IDX" ON "REVIEW" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" )  ENABLE;
--------------------------------------------------------
--  Constraints for Table TRADERECORD
--------------------------------------------------------

  ALTER TABLE "TRADERECORD" MODIFY ("BOARD_ID" NOT NULL ENABLE);
  ALTER TABLE "TRADERECORD" MODIFY ("TIME" NOT NULL ENABLE);
  ALTER TABLE "TRADERECORD" MODIFY ("MEMBER_ID" NOT NULL ENABLE);
  ALTER TABLE "TRADERECORD" MODIFY ("CATEGORY_ID" NOT NULL ENABLE);
  ALTER TABLE "TRADERECORD" ADD PRIMARY KEY ("MEMBER_ID", "BOARD_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table ZZIM
--------------------------------------------------------

  ALTER TABLE "ZZIM" MODIFY ("BOARD_ID" NOT NULL ENABLE);
  ALTER TABLE "ZZIM" MODIFY ("MEMBER_ID" NOT NULL ENABLE);
  ALTER TABLE "ZZIM" ADD PRIMARY KEY ("MEMBER_ID", "BOARD_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table BOARD
--------------------------------------------------------

  ALTER TABLE "BOARD" ADD CONSTRAINT "BOARD_CATEGORY_FK" FOREIGN KEY ("CATEGORY_ID")
	  REFERENCES "CATEGORY" ("ID") ENABLE;
  ALTER TABLE "BOARD" ADD CONSTRAINT "BOARD_MEMBER_FK" FOREIGN KEY ("MEMBER_ID")
	  REFERENCES "MEMBER" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table REPLY
--------------------------------------------------------

  ALTER TABLE "REPLY" ADD CONSTRAINT "REPLY_BOARD_FK" FOREIGN KEY ("BOARD_ID")
	  REFERENCES "BOARD" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table REVIEW
--------------------------------------------------------

  ALTER TABLE "REVIEW" ADD CONSTRAINT "REVIEW_MEMBER_FK" FOREIGN KEY ("MEMBER_ID")
	  REFERENCES "MEMBER" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table TRADERECORD
--------------------------------------------------------

  ALTER TABLE "TRADERECORD" ADD CONSTRAINT "TRADERECORD_BOARD_FK" FOREIGN KEY ("BOARD_ID")
	  REFERENCES "BOARD" ("ID") ENABLE;
  ALTER TABLE "TRADERECORD" ADD CONSTRAINT "TRADERECORD_MEMBER_FK" FOREIGN KEY ("MEMBER_ID")
	  REFERENCES "MEMBER" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table ZZIM
--------------------------------------------------------

  ALTER TABLE "ZZIM" ADD CONSTRAINT "ZZIM_BOARD_FK" FOREIGN KEY ("BOARD_ID")
	  REFERENCES "BOARD" ("ID") ENABLE;
  ALTER TABLE "ZZIM" ADD CONSTRAINT "ZZIM_MEMBER_FK" FOREIGN KEY ("MEMBER_ID")
	  REFERENCES "MEMBER" ("ID") ENABLE;
