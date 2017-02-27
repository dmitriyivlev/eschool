CREATE TABLE pupil (
    id SERIAL PRIMARY KEY,
	first_name varchar(20) NOT NULL,
	last_name varchar(20) NOT NULL,
	middle_name varchar(20),
	birthday date,
	sex	char(1) NOT NULL,
	class_number integer NOT NULL,
	class_letter char(1) NOT NULL,
	address varchar(200),
	home_phone varchar(15),
	mobile_phone varchar(15),
	email varchar(50)
);

INSERT INTO pupil(first_name, last_name, middle_name, birthday, sex, class_number, class_letter, address, home_phone, mobile_phone, email) values
('Сергей', 'Иванов', 'Юрьевич', '2007-12-13', 'm', '4', 'А', 'ул. Ленина д. 57, кв. 15', '8(727)358-21-87', '8(777)257-25-34', 'serivanov@gmail.com'),
('Семен', 'Петров', 'Дмитриевич', '2005-02-25', 'm', '6', 'В', 'ул. Танкистов д. 25, кв. 27', '8(727)236-33-85', '8(777)257-96-23', 'sempetrom@yandex.ru'),
('Мария', 'Дубенко', 'Семенова', '2009-07-07', 'f', '2', 'Б', 'ул. Яблочная д. 8, кв. 21', '8(727)242-35-98', '8(705)587-74-05', 'mdubenko@gmail.com'),
('Ольга', 'Рыжова', 'Степанова', '2008-01-11', 'f', '3', 'Г', 'ул. Вишневая д. 28, кв. 58', '8(727)365-20-05', '8(701)147-28-48', 'olgarijova@yandex.ru'),
('Иван', 'Круглов', 'Денисович', '2004-10-23', 'm', '7', 'В', 'ул. Космонавтов д. 87, кв. 3', '8(727)347-65-31', '8(701)294-26-47', 'ivankruglov@mail.ru'),
('Денис', 'Назаров', 'Сергеевич', '2006-04-18', 'm', '5', 'Б', 'ул. Виноградова д. 76, кв. 36', '8(727)354-25-36', '8(705)985-57-36', 'denisnazarov@gmail.com'),
('Татьяна', 'Удилина', 'Олеговна', '2007-09-14', 'f', '4', 'А', 'ул. Дружбы д. 44, кв. 20', '8(727)389-27-17', '8(777)257-29-27', 'tudilina@yandex.ru');