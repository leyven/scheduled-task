

DROP TABLE IF EXISTS tasks;

CREATE TABLE tasks (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  scheduled_time VARCHAR(250) NOT NULL,
  payload VARCHAR(250) NOT NULL,
    endpoint VARCHAR(250) NOT NULL,

  active boolean DEFAULT false
);


