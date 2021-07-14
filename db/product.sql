create table PRODUCT
(
    MPID NVARCHAR2(50)
        constraint FK_PRODUCT
        references MEMBER,
    PNUMBER NUMBER not null
        constraint PK_PRODUCT2
            primary key,
    PTITLE NVARCHAR2(50),
    PCONTENTS2 NVARCHAR2(50),
    PFILENAME NVARCHAR2(50),
    PREVIEW NVARCHAR2(50),
    PQNA NVARCHAR2(50),
    PHIT NUMBER,
    PSALE NUMBER,
    PAMOUNT NUMBER
)
    /

