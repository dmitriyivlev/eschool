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
('������', '������', '�������', '2007-12-13', 'm', '4', '�', '��. ������ �. 57, ��. 15', '8(727)358-21-87', '8(777)257-25-34', 'serivanov@gmail.com'),
('�����', '������', '����������', '2005-02-25', 'm', '6', '�', '��. ��������� �. 25, ��. 27', '8(727)236-33-85', '8(777)257-96-23', 'sempetrom@yandex.ru'),
('�����', '�������', '��������', '2009-07-07', 'f', '2', '�', '��. �������� �. 8, ��. 21', '8(727)242-35-98', '8(705)587-74-05', 'mdubenko@gmail.com'),
('�����', '������', '���������', '2008-01-11', 'f', '3', '�', '��. �������� �. 28, ��. 58', '8(727)365-20-05', '8(701)147-28-48', 'olgarijova@yandex.ru'),
('����', '�������', '���������', '2004-10-23', 'm', '7', '�', '��. ����������� �. 87, ��. 3', '8(727)347-65-31', '8(701)294-26-47', 'ivankruglov@mail.ru'),
('�����', '�������', '���������', '2006-04-18', 'm', '5', '�', '��. ����������� �. 76, ��. 36', '8(727)354-25-36', '8(705)985-57-36', 'denisnazarov@gmail.com'),
('�������', '�������', '��������', '2007-09-14', 'f', '4', '�', '��. ������ �. 44, ��. 20', '8(727)389-27-17', '8(777)257-29-27', 'tudilina@yandex.ru');