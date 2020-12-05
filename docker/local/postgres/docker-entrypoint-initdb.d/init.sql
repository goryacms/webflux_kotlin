create table if not exists person
(
    id SERIAL primary key,
    first_name varchar(15),
    second_name varchar(15),
    years_old integer
);

create table if not exists courses
(
    id SERIAL primary key,
    course_name varchar(75),
    date_range varchar(25),
    person_id integer
);

ALTER table courses add constraint person_courses__fk foreign key (person_id) references person (id);

INSERT INTO person(first_name, second_name, years_old)
VALUES ('Гена', 'Букин', 37);

INSERT INTO courses(course_name, date_range, person_id)
VALUES ('Java-разработка', '21.11.2020-22.03.2021', 1);