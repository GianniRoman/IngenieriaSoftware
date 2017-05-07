CREATE TABLE usuario
(
	nombre       text not null primary key,
 	contraseña   text not null ,
	tipo         int  not null
);

Create table empleados
(
     elegajo     text  not null primary key,
	 dni         int   not null unique,
	 nombre      text  not null ,
	 telefono    int 
);

Create table gerente
(
	id           int  not null primary key,
	dni          int  not null unique,
	nombre       text not null
);