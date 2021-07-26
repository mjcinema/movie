create table MOVIES
(
    TITLE NVARCHAR2(50),
    DIRECTOR NVARCHAR2(50),
    "DATE" NVARCHAR2(50),
    GENRE NVARCHAR2(50),
    GRADE NVARCHAR2(50),
    FEE NVARCHAR2(50),
    CODE NUMBER not null
        constraint MOVIES_PK
            primary key
)
/

