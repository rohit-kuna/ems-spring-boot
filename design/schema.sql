CREATE TABLE employee (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL CHECK (email LIKE '%@%'),
    salary BIGINT NOT NULL DEFAULT(30000),

    /*C*/ fk_dept_id BIGINT REFERENCES department(id) ON DELETE SET NULL

);

CREATE TABLE passport (
    id BIGINT PRIMARY KEY,
    passport_number BIGINT UNIQUE NOT NULL,
    issuing_country VARCHAR(255) NOT NULL,
    date_of_issue DATE NOT NULL,
    date_of_expiry DATE NOT NULL,

    /*A*/ fk_employee_id BIGINT UNIQUE NOT NULL REFERENCES employee(id) ON DELETE CASCADE

);

CREATE TABLE address (
    id BIGINT PRIMARY KEY,
    house_no INT NOT NULL,
    street VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL,
    state VARCHAR(255) NOT NULL,
    country VARCHAR(255) NOT NULL,
    zip_code VARCHAR(8) NOT NULL,
    address_type VARCHAR(255) NOT NULL CHECK(address_type IN ("HOME","OFFICE")),

    /*B*/ fk_employee_id BIGINT NOT NULL REFERENCES employee(id) ON DELETE CASCADE
);

CREATE TABLE department (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE project (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE training (
	id BIGINT PRIMARY KEY,
	name VARCHAR(255) UNIQUE NOT NULL,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    domain VARCHAR(255)
);

/*Association table with data*/
CREATE TABLE employee_training_lookup (
	fk_employee_id BIGINT REFERENCES employee(id) ON DELETE CASCADE,
	fk_training_id BIGINT REFERENCES training(id) ON DELETE CASCADE,
	start_date DATE,
	end_date DATE,
	CONSTRAINT employee_training_pk PRIMARY KEY (fk_employee_id, fk_training_id),
    CONSTRAINT employee_training_date_check CHECK (end_date IS NULL OR end_date >= start_date)
)

/*D*/
CREATE TABLE employee_project (
	fk_employee_id BIGINT NOT NULL REFERENCES employee(id) ON DELETE CASCADE,
	fk_project_id BIGINT NOT NULL REFERENCES project(id) ON DELETE CASCADE,
	CONSTRAINT employee_project_fk PRIMARY KEY (fk_employee_id, fk_project_id)
);

-- adding foreign keys
/*

Finding relations
A.employee x passport
employee -> strong
passport -> dependent

An employee can have only one passport
A passport belongs to only one employee
Strictly one to one
employee -- passport
fk in dependent entity

SQL : on delete rule:
ON DELETE CASCADE

JPA CascadeTypes :
- As child fully depends on parent CascadeType.ALL can be mentioned on parent
Hence no cruds needed separately for passport

B. employee : address
employee -> strong
address -> dependent

an employee can have multiple address
an address just belongs to one employee
employee : address
1 : M
1 : 1
-----
1 : M

fk on dependent / many side
on delete cascade

JPA CascadeTypes :
- As child fully depends on parent CascadeType.ALL can be mentioned on parent
Hence no CRUD apis needed for Address separately

C. employee : dept
both are strong entities
no delete restrict

1E : 1D - an employee can belong to 1 dept
*E : 1D -  1 dept can have many employees
*E : 1D
fk on Many side

JPA CascadeType :
- employee

D. employees : projects
1-E : M-P - an employee can work in multiple projects
M-E : 1-P - a project can be assigned to multiple employees
M-E : M-P
So need a separate table pure association
employees : projects
both table foreign keys in it
ON DELETE :
If a project is deleted or employee is deleted -> the relation should not be there otherwise it would lead to orphans
Hence ON DELETE CASCADE for both fks

E. employee : training
M : M
SQL ON DELETE rules : ON DELETE Cascade for both fks
JPA CascadeType : None

*/
