create table UNIT (
ID          number PRIMARY KEY NOT NULL,
UNIT_NAME   varchar2 (100)
);

create table PROJECT (
ID              number PRIMARY KEY NOT NULL,
PROJECT_NAME    varchar2 (100)
);

create table EMPLOYEE (
ID          number PRIMARY KEY NOT NULL,
FIRST_NAME  varchar2 (100),
LAST_NAME   varchar2 (100),
EMAIL       varchar2 (100),
STATUS      varchar2 (100),
CITY        varchar2 (100),
COUNTRY     varchar2 (100),
STREET      varchar2 (100),
ZIP         number,
UNIT_ID     number,
FOREIGN KEY (UNIT_ID) REFERENCES UNIT (ID)
);

create table PERSONAL_INFO (
EMPLOYEE_ID number PRIMARY KEY NOT NULL,
BIRTHDAY    date,
PERSONAL    clob,
FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYEE (ID) ON DELETE CASCADE
);

create table EMPLOYEES_PROJECTS (
EMPLOYEE_ID number,
PROJECT_ID  number,
FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYEE (ID),
FOREIGN KEY (PROJECT_ID) REFERENCES PROJECT (ID),
CONSTRAINT UNIQUE_PAIR UNIQUE (EMPLOYEE_ID, PROJECT_ID)
);

create sequence JPA_PK_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1;