INSERT INTO DEPARTMENTS (name)
VALUES ('1-st department');
INSERT INTO DEPARTMENTS (name)
VALUES ('2-st department');

INSERT INTO WORKERS (first_name, last_name, department_id)
VALUES ('John', 'Gold', 1);
INSERT INTO WORKERS (first_name, last_name, department_id)
VALUES ('Anton', 'Dolin', 1);
INSERT INTO WORKERS (first_name, last_name, department_id)
VALUES ('Vladimir', 'Petrov', 1);
INSERT INTO WORKERS (first_name, last_name, department_id)
VALUES ('Monika', 'Belucci', 2);

INSERT INTO WORKED_HOURS (start_date, end_date, worker_id)
VALUES ('2022-4-12 10:21:55', '2022-5-12 10:21:55', 1);
INSERT INTO WORKED_HOURS (start_date, end_date, worker_id)
VALUES ('2021-9-12 10:21:55', '2021-9-12 19:21:00', 2);
INSERT INTO WORKED_HOURS (start_date, end_date, worker_id)
VALUES ('2022-1-01 01:21:58', '2022-1-12 10:45:01', 3);
INSERT INTO WORKED_HOURS (start_date, end_date, worker_id)
VALUES ('2021-10-12 05:17:57', '2021-10-12 06:21:47', 4);
INSERT INTO WORKED_HOURS (start_date, end_date, worker_id)
VALUES ('2022-3-01 12:21:12', '2022-3-01 22:00:30', 1);
INSERT INTO WORKED_HOURS (start_date, worker_id)
VALUES ('2022-4-12 10:21:55', 2);