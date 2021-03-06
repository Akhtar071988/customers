DROP TABLE IF EXISTS Customers;
CREATE TABLE Customers (
    requestNumber           INTEGER NOT NULL AUTO_INCREMENT,
    requestDateTime TIMESTAMP NOT NULL,
    customerName   VARCHAR(50) NOT NULL,
    customerAddress    VARCHAR(50) NOT NULL,
    phoneNumber    VARCHAR(15) NOT NULL,
    description    VARCHAR(50) NOT NULL,
    technician    VARCHAR(50) NOT NULL,
    appointmentDateTime    TIMESTAMP,
    status    VARCHAR(50) NOT NULL,
    PRIMARY KEY (requestNumber)
);
DROP TABLE IF EXISTS Note;
CREATE TABLE notes (
    noteKey           INTEGER NOT NULL AUTO_INCREMENT,
    customerRequestNumber INTEGER  NOT NULL,
    dateTime TIMESTAMP NOT NULL,
    note   VARCHAR(200) NOT NULL,
    PRIMARY KEY (noteKey)
);