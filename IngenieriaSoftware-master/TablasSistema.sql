CREATE TABLE usuario
(
	nombre       text not null primary key,
 	contraseña   text not null ,
	tipo         int  not null
);

Create table empleado
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

CREATE TABLE Plantel
(
    vcod int not null primary key,
    raza text, 
    peso float not null,
    anio_nac int,
    c_lactancia int not null
);

Create table produccion
(
    vcod int not null,
    p_anio int not null,
    c_mes int not null,
    p_cant int not null,
    p_densidad float not null,
    primary key (vcod,c_mes),
    foreign key (vcod) references plantel(vcod)    
);

CREATE TABLE establecimiento
(
    est_cod int not null primary key,
    nombre text not null,
    ubicacion text not null
);

Create table productor
(
    pcod int not null primary key,
    nombre text not null,
    tel int,
    ubicacion text,
    est_cod int not null,
    foreign key (est_cod) references establecimiento(est_cod)
);


Create table controla
(
    elegajo text not null,
    pcod int not null,
    fecha_inicio int not null,
    cant_hrs int,
    primary key(elegajo,pcod),
    foreign key (elegajo) references empleado(elegajo),
    foreign key (pcod) references productor(pcod)
      
);

Create table lactometro
(
    lcod int not null primary key,
    lcant int not null,
    l_densidad float  
);