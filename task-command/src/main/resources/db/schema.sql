DROP TABLE user IF EXISTS;
DROP TABLE task IF EXISTS;
DROP TABLE team IF EXISTS;

CREATE TABLE team
(
    id INTEGER IDENTITY PRIMARY KEY,
);

CREATE TABLE user
(
    id           INTEGER IDENTITY PRIMARY KEY,
    name         VARCHAR(30),
    is_supervisor BOOLEAN,
    team_id       INTEGER
);

ALTER TABLE user
    ADD CONSTRAINT fk_team_id FOREIGN KEY (team_id) REFERENCES team (id);

CREATE TABLE task
(
    id           INTEGER IDENTITY PRIMARY KEY,
    name         VARCHAR(30),
    due_date     DATE,
    instructions VARCHAR(255),
    status       VARCHAR(10)
);


CREATE TABLE task_user
(
    id INTEGER IDENTITY PRIMARY KEY,
    task_id INTEGER,
    user_id INTEGER
);

ALTER TABLE task_user
    ADD CONSTRAINT fk_task_user_task FOREIGN KEY (task_id) REFERENCES task (id);
ALTER TABLE task_user
    ADD CONSTRAINT fk_task_user_user FOREIGN KEY (user_id) REFERENCES user (id);


-- CREATE INDEX vets_last_name ON vets (last_name);
