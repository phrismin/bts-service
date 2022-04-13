CREATE TABLE departments
(
    id   BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(128) UNIQUE NOT NULL
);

CREATE TABLE workers
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name    VARCHAR(128) UNIQUE NOT NULL,
    last_name     VARCHAR(128) UNIQUE NOT NULL,
    department_id BIGINT,
    FOREIGN KEY (department_id) references departments (id)
);

CREATE TABLE worked_hours
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    start_date TIMESTAMP NOT NULL,
    end_date   TIMESTAMP,
    worker_id  BIGINT,
    FOREIGN KEY (worker_id) references workers (id)
)