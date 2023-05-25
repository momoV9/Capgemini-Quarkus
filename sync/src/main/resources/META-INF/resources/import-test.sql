CREATE TABLE metrics_entry
(
    id         BIGINT PRIMARY KEY,
    user       VARCHAR(255),
    start_date DATE,
    end_date   DATE,
    leave_type VARCHAR(255),
    hours      INT
);
