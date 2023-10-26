/*Se crea la base de datos */
drop schema if exists theGoodTree;
drop user if exists usuario_prueba;
CREATE SCHEMA theGoodTree ;

/*Se crea un usuario para la base de datos llamado "usuario_prueba" y tiene la contraseña "Usuario_Clave."*/
create user 'usuario_prueba'@'%' identified by 'Usuar1o_Clave.';

/*Se asignan los prvilegios sobr ela base de datos theGoodTree al usuario creado */
grant all privileges on theGoodTree.* to 'usuario_prueba'@'%';
flush privileges;

/* la tabla de arboles contiene arboless de productos*/
create table theGoodTree.arboles (
  id_arboles INT NOT NULL AUTO_INCREMENT,
  descripcion VARCHAR(30) NOT NULL,
  ruta_imagen varchar(1024),
  activo bool,
  PRIMARY KEY (id_arboles))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

/*Se crea la tabla de clientes llamada cliente... igual que la clase Cliente */
CREATE TABLE theGoodTree.usuario (
  id_usuario INT NOT NULL AUTO_INCREMENT,
  username varchar(20) NOT NULL,
  password varchar(512) NOT NULL,
  nombre VARCHAR(20) NOT NULL,
  apellidos VARCHAR(30) NOT NULL,
  correo VARCHAR(25) NULL,
  telefono VARCHAR(15) NULL,
  ruta_imagen varchar(1024),
  activo boolean,
  PRIMARY KEY (`id_usuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

/*Se insertan 3 registros en la tabla cliente como ejemplo */
INSERT INTO theGoodTree.usuario (id_usuario, username,password,nombre, apellidos, correo, telefono,ruta_imagen,activo) VALUES 
(1,'juan','$2a$10$P1.w58XvnaYQUQgZUCk4aO/RTRl8EValluCqB3S2VMLTbRt.tlre.','Juan', 'Castro Mora',    'jcastro@gmail.com',    '4556-8978', 'https://upload.wikimedia.org/wikipedia/commons/thumb/2/2a/Juan_Diego_Madrigal.jpg/250px-Juan_Diego_Madrigal.jpg',true),
(2,'rebeca','$2a$10$GkEj.ZzmQa/aEfDmtLIh3udIH5fMphx/35d0EYeqZL5uzgCJ0lQRi','Rebeca',  'Contreras Mora', 'acontreras@gmail.com', '5456-8789','https://upload.wikimedia.org/wikipedia/commons/0/06/Photo_of_Rebeca_Arthur.jpg',true),
(3,'pedro','$2a$10$koGR7eS22Pv5KdaVJKDcge04ZB53iMiw76.UjHPY.XyVYlYqXnPbO','Pedro', 'Mena Loria',     'lmena@gmail.com',      '7898-8936','https://upload.wikimedia.org/wikipedia/commons/thumb/f/fd/Eduardo_de_Pedro_2019.jpg/480px-Eduardo_de_Pedro_2019.jpg?20200109230854',true);

/*Se insertan 5 arboless de productos como ejemplo */
INSERT INTO theGoodTree.arboles (id_arboles,descripcion,ruta_imagen,activo) VALUES 
('1','Arbol de Guanacaste', 'https://costarica-decouverte.com/wp-content/uploads/2018/09/arbre-guanacaste-costa-rica-decouverte.jpg',   true), 
('2','Pino',  'https://st3.depositphotos.com/1006065/12826/i/950/depositphotos_128261710-stock-photo-aerial-view-of-green-pine.jpg',   true),
('3','Sakura','https://image.freepik.com/foto-gratis/hermoso-arbol-japon-sakura_40120-576.jpg',true),
('4','secuoya','https://ca-times.brightspotcdn.com/dims4/default/db679d9/2147483647/strip/true/crop/5568x3712+0+0/resize/1200x800!/quality/75/?url=https%3A%2F%2Fcalifornia-times-brightspot.s3.amazonaws.com%2F56%2Fa9%2F09c162c14e7db472eff71a303dd4%2Fla-tr-general-sherman-the-wild-getty-images-04.JPG',    false),
('5','Frutales','https://www.gtush.com/wp-content/uploads/2018/05/arboles-frutales.jpg',    false);

create table theGoodTree.rol (
  id_rol INT NOT NULL AUTO_INCREMENT,
  nombre varchar(20),
  id_usuario int,
  PRIMARY KEY (id_rol),
  foreign key fk_rol_usuario (id_usuario) references usuario(id_usuario)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

insert into theGoodTree.rol (id_rol, nombre, id_usuario) values
 (1,'ROLE_ADMIN',1), (2,'ROLE_VENDEDOR',1), (3,'ROLE_USER',1),
 (4,'ROLE_VENDEDOR',2), (5,'ROLE_USER',2),
 (6,'ROLE_USER',3);

