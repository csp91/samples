CREATE TABLE PATRON
(
    Patron_ID                INT            NOT NULL,
    FName                    VARCHAR(20)    NOT NULL,
    LName                    VARCHAR(20)    NOT NULL,
    Address                  VARCHAR(70)    NOT NULL,
    Email                    VARCHAR(70)    NULL,
    BookOnPossession         INT            NOT NULL,
     
    CONSTRAINT PK_Patron_ID PRIMARY KEY(Patron_ID),
    CONSTRAINT CHK_Patron CHECK (Patron_ID BETWEEN 50001 and 99999),
    CONSTRAINT CHK_BookOnPoss CHECK (BookOnPossession BETWEEN 0 and 3)

);

INSERT INTO PATRON (Patron_ID, FName, LName, Address, Email, BookOnPossession)
VALUES  ('50001', 'Jackie', 'Chan', '123 Drunk Dr', 'martialartisbest@email.com', '3');

INSERT INTO PATRON (Patron_ID, FName, LName, Address, Email, BookOnPossession)
VALUES  ('50002', 'John', 'Smith', '456 Main Ave', '', '0');

INSERT INTO PATRON (Patron_ID, FName, LName, Address, Email, BookOnPossession)
VALUES  ('50003', 'Bruce', 'Lee', '999 Dragon Dr', 'oneinchpunch@email.com', '1');

INSERT INTO PATRON (Patron_ID, FName, LName, Address, Email, BookOnPossession)
VALUES  ('50004', 'Ip', 'Man', '432 Wing St', 'wingchun@email.com', '2');

INSERT INTO PATRON (Patron_ID, FName, LName, Address, Email, BookOnPossession)
VALUES  ('50005', 'Jet', 'Li', '765 Fearless St', 'Italkwithfist@email.com', '0');


CREATE TABLE SUPPLIER
(
    SupplierID                  INT                NOT NULL,
    Name                        VARCHAR(70)        NOT NULL,
    Location                    VARCHAR(70)        NOT NULL,
    
    CONSTRAINT PK_SupplierID   PRIMARY KEY (SupplierID),
    CONSTRAINT CHK_SupplierID  CHECK (SupplierID BETWEEN 1000 and 3000)
);

INSERT INTO SUPPLIER (SupplierID, Name, Location)
VALUES  ('1011', 'Book Supply Store', 'Omaha City');

INSERT INTO SUPPLIER (SupplierID, Name, Location)
VALUES  ('1012', 'Chicago Bookstore', 'Chicago City');

INSERT INTO SUPPLIER (SupplierID, Name, Location)
VALUES  ('1013', 'Bellevue Retail', 'Omaha City');

INSERT INTO SUPPLIER (SupplierID, Name, Location)
VALUES  ('1014', 'Sinful Bookstore', 'Las Vegas City');

INSERT INTO SUPPLIER (SupplierID, Name, Location)
VALUES  ('1015', 'Caesar Book Emporium', 'Palace City');




CREATE TABLE INVENTORY
(
    Inventory_ID                INT            NOT NULL,
    Title                       CHAR(50)       NOT NULL,
    OriginalPrice               NUMBER(7,2)    NOT NULL,
    Quality                     CHAR(20)       NOT NULL,
    ShelfLocation               CHAR(20)       NOT NULL,
    isStored                    CHAR(1)        NOT NULL,
    SupplierID                  INT            REFERENCES SUPPLIER,
    
    CONSTRAINT PK_InventoryID PRIMARY KEY(Inventory_ID),
    CONSTRAINT CHK_InventoryID CHECK (Inventory_ID BETWEEN 30001 and 50000),
    CONSTRAINT bool_isStored  CHECK (isStored BETWEEN 0 and 1)
);


INSERT INTO INVENTORY (Inventory_ID, Title, OriginalPrice, Quality, ShelfLocation, isStored, SupplierID)
    VALUES  ('30001','Larry Potter I','233.33','Good','B12','1','1011');
    
INSERT INTO INVENTORY (Inventory_ID, Title, OriginalPrice, Quality, ShelfLocation, isStored, SupplierID)
    VALUES  ('30002','How to be a SQL developer?','461.33','Good','A42','1','1011');
    
INSERT INTO INVENTORY (Inventory_ID, Title, OriginalPrice, Quality, ShelfLocation, isStored, SupplierID)
    VALUES  ('30003','I found a bigfoot','11.30','Bad','B2','1','1014');
    
INSERT INTO INVENTORY (Inventory_ID, Title, OriginalPrice, Quality, ShelfLocation, isStored, SupplierID)
    VALUES  ('30004','Sleeping for dummies','999.99','Good','R2','1','1015');
    
INSERT INTO INVENTORY (Inventory_ID, Title, OriginalPrice, Quality, ShelfLocation, isStored, SupplierID)
    VALUES  ('30005','Flat Earth Evidence','1.00','Excellent','D2','1','1013');


CREATE TABLE BORROW
(
    Borrow_ID                    INT            NOT NULL,
    Patron_ID                    INT            NOT NULL,
    Inventory_ID                 INT            NOT NULL,
    BorrowedOn                   DATE           NOT NULL,
    DueDate                      DATE           NOT NULL,
    
    
    CONSTRAINT PK_BorrowID PRIMARY KEY(Borrow_ID),
    CONSTRAINT CHK_BorrowID CHECK (Borrow_ID BETWEEN 10000 and 30000),
    
    CONSTRAINT FK_PatronID
      FOREIGN KEY (Patron_ID)
      REFERENCES Patron (Patron_ID),
      
    CONSTRAINT FK_InventoryID
      FOREIGN KEY (Inventory_ID)
      REFERENCES INVENTORY (Inventory_ID)
    
);
    
INSERT INTO BORROW (Borrow_ID, Patron_ID, Inventory_ID, BorrowedOn, DueDate)
    VALUES('10001','50001','30001','11202019','11242019');

INSERT INTO BORROW (Borrow_ID, Patron_ID, Inventory_ID, BorrowedOn, DueDate)
    VALUES('10002','50002','30002','11232019','11272019');

INSERT INTO BORROW (Borrow_ID, Patron_ID, Inventory_ID, BorrowedOn, DueDate)
    VALUES('10003','50002','30003','11232019','11272019');

INSERT INTO BORROW (Borrow_ID, Patron_ID, Inventory_ID, BorrowedOn, DueDate)
    VALUES('10004','50003','30004','10102019','10142019');

INSERT INTO BORROW (Borrow_ID, Patron_ID, Inventory_ID, BorrowedOn, DueDate)
    VALUES('10005','50004','30005','10202019','10242019');
        
CREATE TABLE EMPLOYEE 
(
    Employee_ID                  INT                NOT NULL,
    FName                        VARCHAR(20)        NOT NULL,
    LName                        VARCHAR(20)        NOT NULL,
    Salary                       NUMBER(8,2)        NULL,
    
    
    CONSTRAINT PK_EmployeeID PRIMARY KEY(Employee_ID),
    CONSTRAINT CHK_EmployeeID CHECK (Employee_ID BETWEEN 80001 and 99999)
    
);

INSERT INTO EMPLOYEE (Employee_ID, FName, LName, Salary)
    VALUES ('80001','Kevin','Hart','30000');

INSERT INTO EMPLOYEE (Employee_ID, FName, LName, Salary)
    VALUES ('80002','Donald','Trump','45000');

INSERT INTO EMPLOYEE (Employee_ID, FName, LName, Salary)
    VALUES ('80003','George','Washington','100000');

INSERT INTO EMPLOYEE (Employee_ID, FName, LName, Salary)
    VALUES ('80004','Kobe','Bryant','50000');

INSERT INTO EMPLOYEE (Employee_ID, FName, LName, Salary)
    VALUES ('80005','Galileo','Galilee','90000');

INSERT INTO EMPLOYEE (Employee_ID, FName, LName, Salary)
    VALUES ('80006','Thomas','Edison','70000');


CREATE TABLE INVENTORY_EMPLOYEE
(
    Inventory_ID                  INT            REFERENCES INVENTORY,
    Employee_ID                   INT            REFERENCES EMPLOYEE,
    LastUpdate                    DATE            NOT NULL,
    PRIMARY KEY(Inventory_ID, Employee_ID)
    
);

INSERT INTO INVENTORY_EMPLOYEE (Inventory_ID, Employee_ID, LastUpdate)
    VALUES ('30001','80003','11202019');

INSERT INTO INVENTORY_EMPLOYEE (Inventory_ID, Employee_ID, LastUpdate)
    VALUES ('30002','80002','11242019');

INSERT INTO INVENTORY_EMPLOYEE (Inventory_ID, Employee_ID, LastUpdate)
    VALUES ('30003','80004','11242019');

INSERT INTO INVENTORY_EMPLOYEE (Inventory_ID, Employee_ID, LastUpdate)
    VALUES ('30004','80002','10102019');

INSERT INTO INVENTORY_EMPLOYEE (Inventory_ID, Employee_ID, LastUpdate)
    VALUES ('30005','80005','10202019');

CREATE TABLE LIBRARIAN
(
    Employee_ID                    INT         REFERENCES EMPLOYEE,
    
    PRIMARY KEY(EMPLOYEE_ID)
);

INSERT INTO LIBRARIAN (Employee_ID)
    VALUES ('80001');
INSERT INTO LIBRARIAN (Employee_ID)
    VALUES ('80002');
INSERT INTO LIBRARIAN (Employee_ID)
    VALUES ('80004');
INSERT INTO LIBRARIAN (Employee_ID)
    VALUES ('80005');
INSERT INTO LIBRARIAN (Employee_ID)
    VALUES ('80006');


CREATE TABLE HEAD_LIBRARIAN
(    
    Employee_ID                    INT         REFERENCES EMPLOYEE,
    AccountAccess                  CHAR(50)    NOT NULL,
    PRIMARY KEY(EMPLOYEE_ID)
);

INSERT INTO HEAD_LIBRARIAN (Employee_ID, AccountAccess)
    VALUES ('80003', 'A123');


CREATE TABLE PUBLISHER
(
    PublisherName                  VARCHAR(70)    NOT NULL,
    Address                        VARCHAR(70) NOT NULL,
    Phone                          CHAR(12)    NOT NULL,
    
    CONSTRAINT PK_Publisher PRIMARY KEY(PublisherName)
);

INSERT INTO PUBLISHER (PublisherName, Address, Phone)
    VALUES ('Kakashi Books', 'Brooklyn, NY', '123-345-6789');
INSERT INTO PUBLISHER (PublisherName, Address, Phone)
    VALUES ('Whitewolf Press', 'Minneapolis, MN', '444-345-4444');
INSERT INTO PUBLISHER (PublisherName, Address, Phone)
    VALUES ('Narwhal Books', 'Juneau, AK', '323-555-1221');
INSERT INTO PUBLISHER (PublisherName, Address, Phone)
    VALUES ('Pierce Education', 'Boston, MA', '888-388-6888');
INSERT INTO PUBLISHER (PublisherName, Address, Phone)
    VALUES ('Flying Books', 'Sky, NV', '213-355-5353');



CREATE TABLE CATEGORY
(
    Category_ID                    INT         NOT NULL,
    Name                           VARCHAR(20) NOT NULL,
    Description                    VARCHAR(254) NULL,
    
    CONSTRAINT PK_Category PRIMARY KEY (Category_ID),
    CONSTRAINT CHK_Category CHECK (Category_ID BETWEEN 111 and 999)
);

INSERT INTO CATEGORY (Category_ID, Name, Description)
    VALUES ('222', 'Satire', 'the use of humor, irony, exaggeration, or ridicule to expose and criticize people''s stupidity or vices, particularly in the context of contemporary politics and other topical issues.');
INSERT INTO CATEGORY (Category_ID, Name, Description)
    VALUES ('333', 'Fantasy', '');
INSERT INTO CATEGORY (Category_ID, Name, Description)
    VALUES ('444', 'Horror', '');
INSERT INTO CATEGORY (Category_ID, Name, Description)
    VALUES ('555', 'Mystery', '');
INSERT INTO CATEGORY (Category_ID, Name, Description)
    VALUES ('666', 'Self Help', '');



CREATE TABLE AUTHOR
(
    Author_ID                    INT            NOT NULL,
    FName                        VARCHAR(20) NOT NULL,
    LName                        VARCHAR(20) NOT NULL,
    
    CONSTRAINT PK_AuthorID        PRIMARY KEY(Author_ID),
    CONSTRAINT CHK_Author        CHECK (Author_ID BETWEEN 500001 and 999999)
    
);
        
INSERT INTO AUTHOR (Author_ID, FName, LName)
        VALUES('600001','Chris','Padilla');
        
INSERT INTO AUTHOR (Author_ID, FName, LName)
        VALUES('600002','Clark','Kent');

INSERT INTO AUTHOR (Author_ID, FName, LName)
        VALUES('600003','Bruce','Wayne');
        
INSERT INTO AUTHOR (Author_ID, FName, LName)
        VALUES('600004','Tony','Stark');
        
INSERT INTO AUTHOR (Author_ID, FName, LName)
        VALUES('600005','Jean','Grey');

CREATE TABLE BOOK
(
    Inventory_ID                INT            REFERENCES INVENTORY,
    ISBN                        CHAR(18)       NOT NULL,
    PublishedOn                 DATE           NOT NULL,
    Description                 VARCHAR(254)   NULL,
    PublisherName               VARCHAR(70)    REFERENCES PUBLISHER,
    Author_ID                   INT            REFERENCES AUTHOR,
    Category_ID                 INT            REFERENCES CATEGORY,
    
    PRIMARY KEY(Inventory_ID, ISBN)
);
            
INSERT INTO BOOK (Inventory_ID, ISBN, PublishedOn, Description, PublisherName, Author_ID, Category_ID)
            VALUES ('30001', '978-3-16-555555-0','01012010','','Whitewolf Press', '600001','333');
            
INSERT INTO BOOK (Inventory_ID, ISBN, PublishedOn, Description, PublisherName, Author_ID, Category_ID)
            VALUES ('30002', '944-3-16-566555-0','01012010','','Narwhal Books', '600002','444');
            
INSERT INTO BOOK (Inventory_ID, ISBN, PublishedOn, Description, PublisherName, Author_ID, Category_ID)
            VALUES ('30003', '933-3-16-556655-0','01012010','','Whitewolf Press', '600001','555');
            
INSERT INTO BOOK (Inventory_ID, ISBN, PublishedOn, Description, PublisherName, Author_ID, Category_ID)
            VALUES ('30004', '922-3-16-555575-0','01012010','','Kakashi Books', '600004','333');
            
INSERT INTO BOOK (Inventory_ID, ISBN, PublishedOn, Description, PublisherName, Author_ID, Category_ID)
            VALUES ('30005', '911-3-16-525555-0','01012010','','Pierce Education', '600003','222');

CREATE TABLE ORDER_TAB
(
    Order_ID                    INT            NOT NULL,
    PurchaseDate                DATE           NOT NULL,
    Employee_ID                 INT            REFERENCES EMPLOYEE,
    ISBN                        CHAR(18)       NOT NULL,
    SupplierID                  INT            REFERENCES SUPPLIER,


    
    CONSTRAINT PK_Order_ID    PRIMARY KEY(Order_ID),
    CONSTRAINT CHK_Order    CHECK (Order_ID BETWEEN 4000 and 5000)
);

                
INSERT INTO ORDER_TAB (Order_ID, PurchaseDate, Employee_ID, ISBN, SupplierID)
    VALUES ('4311','11162019','80003','911-3-16-525555-0','1011');

INSERT INTO ORDER_TAB (Order_ID, PurchaseDate, Employee_ID, ISBN, SupplierID)
    VALUES ('4241','10162019','80003','911-3-16-525155-0','1012');

INSERT INTO ORDER_TAB (Order_ID, PurchaseDate, Employee_ID, ISBN, SupplierID)
    VALUES ('4654','07132019','80003','911-3-16-5251155-0','1011');

INSERT INTO ORDER_TAB (Order_ID, PurchaseDate, Employee_ID, ISBN, SupplierID)
    VALUES ('4432','03112019','80003','911-3-16-521155-0','1012');

INSERT INTO ORDER_TAB (Order_ID, PurchaseDate, Employee_ID, ISBN, SupplierID)
    VALUES ('4123','05262019','80003','911-3-16-115555-0','1012');

CREATE TABLE PATRON_PAYMENT
(
    Payment_ID                   INT           NOT NULL,
    CreditCardNum                CHAR(16)      NOT NULL,
    ExpDate                      DATE          NOT NULL,
    CVV                          INT           NOT NULL,
    Patron_ID                    INT           REFERENCES PATRON,
    
    CONSTRAINT PK_PaymentID    PRIMARY KEY(Payment_ID),
    CONSTRAINT CHK_PaymentID   CHECK (Payment_ID BETWEEN 100000 and 500000)

);


INSERT INTO PATRON_PAYMENT (Payment_ID, CreditCardNum, ExpDate, CVV, Patron_ID)
    VALUES  ('499999','1234123412341234','11112021','433','50001');
   
INSERT INTO PATRON_PAYMENT (Payment_ID, CreditCardNum, ExpDate, CVV, Patron_ID)
    VALUES  ('499998','1234123412341234','10122021','544','50002');

INSERT INTO PATRON_PAYMENT (Payment_ID, CreditCardNum, ExpDate, CVV, Patron_ID)
    VALUES  ('499997','1234123414444234','09142022','454','50003');

INSERT INTO PATRON_PAYMENT (Payment_ID, CreditCardNum, ExpDate, CVV, Patron_ID)
    VALUES  ('499996','1234144412341234','05162023','111','50004');

INSERT INTO PATRON_PAYMENT (Payment_ID, CreditCardNum, ExpDate, CVV, Patron_ID)
    VALUES  ('499995','4444123412341234','05162023','444','50005');


    
    ​