-- Створення таблиці для працівників
CREATE TABLE worker (ID INT PRIMARY KEY AUTO_INCREMENT,
                     NAME VARCHAR(1000) NOT NULL CHECK (LENGTH(NAME) >= 2),
                     BIRTHDAY DATE CHECK (YEAR(BIRTHDAY) > 1900),
    LEVEL ENUM('Trainee', 'Junior', 'Middle', 'Senior') NOT NULL,
    SALARY INT NOT NULL CHECK (SALARY BETWEEN 100 AND 100000)
);

-- Створення таблиці для клієнтів
CREATE TABLE client (ID INT PRIMARY KEY AUTO_INCREMENT,
                    NAME VARCHAR(1000) NOT NULL CHECK (LENGTH(NAME) >= 2)
);

-- Створення таблиці для проєктів
CREATE TABLE project (ID INT PRIMARY KEY AUTO_INCREMENT,
                    CLIENT_ID INT,
                    START_DATE DATE,
                    FINISH_DATE DATE,
                    FOREIGN KEY (CLIENT_ID) REFERENCES client(ID)
);

-- Створення таблиці для зв'язку між проєктами та працівниками
CREATE TABLE project_worker (PROJECT_ID INT,
                             WORKER_ID INT,
                             PRIMARY KEY (PROJECT_ID, WORKER_ID),
                             FOREIGN KEY (PROJECT_ID) REFERENCES project(ID),
                             FOREIGN KEY (WORKER_ID) REFERENCES worker(ID)
);
