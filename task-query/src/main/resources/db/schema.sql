DROP TABLE dashboard_entry IF EXISTS;

CREATE TABLE dashboard_entry
(
    id           INTEGER IDENTITY PRIMARY KEY,
    task_name    VARCHAR(30),
    due_date     DATE,
    instructions VARCHAR(255),
    status       VARCHAR(10),
    created      DATE

);
