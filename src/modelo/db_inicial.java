/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Edwin CR
 */
public class db_inicial extends ConeDB{
    
    public int createBD() {
        int dato=0;
        try {
            String Query = "CREATE DATABASE restaurante10";
            this.st = this.con.createStatement();
            dato=this.st.executeUpdate(Query);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error no se pudo crear la base de datos");
            ex.printStackTrace();
        }
        return dato;
    }
    
    public void closeConnection() {
        try {
            this.con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public int UseBD() {
        int dato=0;
        try {

            String Query = "USE restaurante10";
            this.st = this.con.createStatement();
            dato=this.st.executeUpdate(Query);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL INTENTAR LA BD");
            ex.printStackTrace();
        }
        return dato;
    }
    
    public int eliminarBD() {
        int dato=0;
        try {
            String Query = "DROP DATABASE restaurante10";
            this.st = this.con.createStatement();
            dato=this.st.executeUpdate(Query);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR LA BASE DE DATOS");
            ex.printStackTrace();
        }
        return dato;
    }
    
    public void createTableMYSQL() {
        try {

            String Query1 = "CREATE TABLE " + "tipo_almacen" + ""
                        + "(idtipo_almacen int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,"
                        + "tipo varchar(45) NOT NULL)";

            String Query2 = "CREATE TABLE " + "almacen" + ""
                        + "(idAlmacen varchar(50) PRIMARY KEY NOT NULL,"
                        + "encargado varchar(45) NOT NULL,"
                        + "idtipo int(11) NOT NULL,"
                        + "foreign key(idtipo) references tipo_almacen(idtipo_almacen))";

            String Query3 = "CREATE TABLE " + "tipo_bebidas" + ""
                        + "(idtipo int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,"
                        + "tipo varchar(45) NOT NULL)";

            String Query4 = "CREATE TABLE " + "bebidas" + ""
                        + "(codbebidas varchar(15) PRIMARY KEY NOT NULL,"
                        + "nombre varchar(45) NOT NULL,"
                        + "descripcion varchar(100) NOT NULL,"
                        + "medida varchar(10) NOT NULL,"
                        + "stok int(11) NOT NULL,"
                        + "idtipo int(11) NOT NULL,"
                        + "idAlmacen varchar(50) NOT NULL,"
                        + "FOREIGN KEY (idtipo) REFERENCES tipo_bebidas (idtipo),"
                        + "FOREIGN KEY (idAlmacen) REFERENCES almacen (idAlmacen))";

            String Query5 = "CREATE TABLE " + "ingrediente" + ""
                        + "(idIngrediente varchar(50) PRIMARY KEY NOT NULL,"
                        + "nombre varchar(100) NOT NULL,"
                        + "cantidad double NOT NULL,"
                        + "medida varchar (45) NOT NULL,"
                        + "idAlmacen varchar(50) NOT NULL,"
                        + "FOREIGN KEY (idAlmacen) REFERENCES almacen (idAlmacen))";

            String Query6 = "CREATE TABLE " + "tipo_plato" + ""
                        + "(idtipo int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,"
                        + "tipo varchar(155) NOT NULL)";

            String Query7 = "CREATE TABLE " + "platos" + ""
                        + "(codigoPlato varchar(15) PRIMARY KEY NOT NULL,"
                        + "nombre varchar(45) NOT NULL,"
                        + "idtipo int(11) NOT NULL,"
                        + "FOREIGN KEY (idtipo) REFERENCES tipo_plato(idtipo))";

            String Query8 = "CREATE TABLE " + "platos_de_ingrediente" + ""
                        + "(id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,"
                        + "codigoPlato varchar(15) NOT NULL,"
                        + "idIngrediente varchar(50) NOT NULL,"
                        + "FOREIGN KEY (codigoPlato) REFERENCES platos(codigoPlato),"
                        + "FOREIGN KEY (idIngrediente) REFERENCES ingrediente(idIngrediente))";

            String Query9 = "CREATE TABLE " + "consumiciones" + ""
                        + "(idconsumiciones int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,"
                        + "descripcion varchar(220) NOT NULL)";

            String Query10 = "CREATE TABLE " + "bebidas_de_consumiciones" + ""
                        + "(id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,"
                        + "codbebidas varchar(15) NOT NULL,"
                        + "idconsumiciones int(11) NOT NULL,"
                        + "FOREIGN KEY (codbebidas) REFERENCES bebidas(codbebidas),"
                        + "FOREIGN KEY (idconsumiciones) REFERENCES consumiciones(idconsumiciones))";

            String Query11 = "CREATE TABLE " + "platos_de_consumiciones" + ""
                        + "(id int(10) PRIMARY KEY NOT NULL AUTO_INCREMENT,"
                        + "codigoPlato varchar(15) NOT NULL,"
                        + "idconsumiciones int(11) NOT NULL,"
                        + "FOREIGN KEY (codigoPlato) REFERENCES platos(codigoPlato),"
                        + "FOREIGN KEY (idconsumiciones) REFERENCES consumiciones(idconsumiciones))";

            String Query12 = "CREATE TABLE " + "cliente" + ""
                        + "(idcliente varchar(50) PRIMARY KEY NOT NULL,"
                        + "nombre varchar(150) NOT NULL,"
                        + "dni varchar(8) NOT NULL)";

            String Query13 = "CREATE TABLE " + "cocina" + ""
                        + "(idCocina varchar(50) PRIMARY KEY NOT NULL,"
                        + "Encargado varchar(50) NOT NULL,"
                        + "minimoEncargable varchar(250) NOT NULL)";

            String Query14 = "CREATE TABLE " + "restaurante" + ""
                        + "(idRestaurante varchar(50) PRIMARY KEY NOT NULL,"
                        + "direccion varchar(150) NOT NULL,"
                        + "aforo int(11) NOT NULL,"
                        + "cantidadMesas int(11) NOT NULL)";

            String Query15 = "CREATE TABLE " + "tipomesa" + ""
                        + "(idTipomesa varchar(50) PRIMARY KEY NOT NULL,"
                        + "Descripcion varchar(150) NOT NULL)";

            String Query16 = "CREATE TABLE " + "mesa" + ""
                        + "(idMesa int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,"
                        + "num_mesa varchar(45) NOT NULL,"
                        + "capacidad int(11) NOT NULL,"
                        + "estadomesa varchar(50) NOT NULL,"
                        + "idTipomesa varchar(50) NOT NULL,"
                        + "idRestaurante varchar(50) NOT NULL,"
                        + "FOREIGN KEY (idTipomesa) REFERENCES tipomesa(idTipomesa),"
                        + "FOREIGN KEY (idRestaurante) REFERENCES restaurante(idRestaurante))";

            String Query17 = "CREATE TABLE " + "reserva" + ""
                        + "(idReserva varchar(50) PRIMARY KEY NOT NULL,"
                        + "dia date NOT NULL,"
                        + "hora time NOT NULL,"
                        + "idcliente varchar(50) NOT NULL,"
                        + "idMesa int(11) NOT NULL,"
                        + "FOREIGN KEY (idcliente) REFERENCES cliente(idcliente),"
                        + "FOREIGN KEY (idMesa) REFERENCES mesa(idMesa))";

            String Query18 = "CREATE TABLE " + "pedido" + ""
                        + "(idPedido varchar(50) PRIMARY KEY NOT NULL,"
                        + "horaPedido time(6) NOT NULL,"
                        + "estado varchar(45) NOT NULL,"
                        + "idMesa int(11) NOT NULL,"
                        + "idconsumiciones int(11) NOT NULL,"
                        + "idCocina varchar(50) NOT NULL,"
                        + "FOREIGN KEY (idMesa) REFERENCES mesa(idMesa),"
                        + "FOREIGN KEY (idconsumiciones) REFERENCES consumiciones(idconsumiciones),"
                        + "FOREIGN KEY (idCocina) REFERENCES cocina(idCocina))";

            String Query19 = "CREATE TABLE " + "tipopago" + ""
                        + "(idTipopago varchar(50) PRIMARY KEY NOT NULL,"
                        + "descripcion varchar(100) NOT NULL)";

            String Query20 = "CREATE TABLE " + "pago" + ""
                        + "(idPago varchar(50) PRIMARY KEY NOT NULL,"
                        + "idTipopago varchar(50) NOT NULL,"
                        + "idMesa int(11) NOT NULL,"
                        + "FOREIGN KEY (idTipopago) REFERENCES tipopago(idTipopago),"
                        + "FOREIGN KEY (idMesa) REFERENCES mesa(idMesa))";

            this.st = this.con.createStatement();
            this.st.executeUpdate(Query1);
            this.st.executeUpdate(Query2);
            this.st.executeUpdate(Query3);
            this.st.executeUpdate(Query4);
            this.st.executeUpdate(Query5);
            this.st.executeUpdate(Query6);
            this.st.executeUpdate(Query7);
            this.st.executeUpdate(Query8);
            this.st.executeUpdate(Query9);
            this.st.executeUpdate(Query10);
            this.st.executeUpdate(Query11);
            this.st.executeUpdate(Query12);
            this.st.executeUpdate(Query13);
            this.st.executeUpdate(Query14);
            this.st.executeUpdate(Query15);
            this.st.executeUpdate(Query16);
            this.st.executeUpdate(Query17);
            this.st.executeUpdate(Query18);
            this.st.executeUpdate(Query19);
            this.st.executeUpdate(Query20);
            

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL CREAR LAS TABLAS");
            ex.printStackTrace();
        }
    }
    
    
    public void createTableSqlServer() {
        try {

            String Query1 = "CREATE TABLE " + "tipo_almacen" + ""
                        + "(idtipo_almacen int PRIMARY KEY NOT NULL IDENTITY(1,1),"
                        + "tipo varchar(45) NOT NULL)";

            String Query2 = "CREATE TABLE " + "almacen" + ""
                        + "(idAlmacen varchar(50) PRIMARY KEY NOT NULL,"
                        + "encargado varchar(45) NOT NULL,"
                        + "idtipo int NOT NULL,"
                        + "foreign key(idtipo) references tipo_almacen(idtipo_almacen))";

            String Query3 = "CREATE TABLE " + "tipo_bebidas" + ""
                        + "(idtipo int PRIMARY KEY NOT NULL IDENTITY(1,1),"
                        + "tipo varchar(45) NOT NULL)";

            String Query4 = "CREATE TABLE " + "bebidas" + ""
                        + "(codbebidas varchar(15) PRIMARY KEY NOT NULL,"
                        + "nombre varchar(45) NOT NULL,"
                        + "descripcion varchar(100) NOT NULL,"
                        + "medida varchar(10) NOT NULL,"
                        + "stok int NOT NULL,"
                        + "idtipo int NOT NULL,"
                        + "idAlmacen varchar(50) NOT NULL,"
                        + "FOREIGN KEY (idtipo) REFERENCES tipo_bebidas (idtipo),"
                        + "FOREIGN KEY (idAlmacen) REFERENCES almacen (idAlmacen))";

            String Query5 = "CREATE TABLE " + "ingrediente" + ""
                        + "(idIngrediente varchar(50) PRIMARY KEY NOT NULL,"
                        + "nombre varchar(100) NOT NULL,"
                        + "cantidad decimal(8,2) NOT NULL,"
                        + "medida varchar (45) NOT NULL,"
                        + "idAlmacen varchar(50) NOT NULL,"
                        + "FOREIGN KEY (idAlmacen) REFERENCES almacen (idAlmacen))";

            String Query6 = "CREATE TABLE " + "tipo_plato" + ""
                        + "(idtipo int PRIMARY KEY NOT NULL IDENTITY(1,1),"
                        + "tipo varchar(155) NOT NULL)";

            String Query7 = "CREATE TABLE " + "platos" + ""
                        + "(codigoPlato varchar(15) PRIMARY KEY NOT NULL,"
                        + "nombre varchar(45) NOT NULL,"
                        + "idtipo int NOT NULL,"
                        + "FOREIGN KEY (idtipo) REFERENCES tipo_plato(idtipo))";

            String Query8 = "CREATE TABLE " + "platos_de_ingrediente" + ""
                        + "(id int PRIMARY KEY NOT NULL IDENTITY(1,1),"
                        + "codigoPlato varchar(15) NOT NULL,"
                        + "idIngrediente varchar(50) NOT NULL,"
                        + "FOREIGN KEY (codigoPlato) REFERENCES platos(codigoPlato),"
                        + "FOREIGN KEY (idIngrediente) REFERENCES ingrediente(idIngrediente))";

            String Query9 = "CREATE TABLE " + "consumiciones" + ""
                        + "(idconsumiciones int PRIMARY KEY NOT NULL IDENTITY(1,1),"
                        + "descripcion varchar(220) NOT NULL)";

            String Query10 = "CREATE TABLE " + "bebidas_de_consumiciones" + ""
                        + "(id int PRIMARY KEY NOT NULL IDENTITY(1,1),"
                        + "codbebidas varchar(15) NOT NULL,"
                        + "idconsumiciones int NOT NULL,"
                        + "FOREIGN KEY (codbebidas) REFERENCES bebidas(codbebidas),"
                        + "FOREIGN KEY (idconsumiciones) REFERENCES consumiciones(idconsumiciones))";

            String Query11 = "CREATE TABLE " + "platos_de_consumiciones" + ""
                        + "(id int PRIMARY KEY NOT NULL IDENTITY(1,1),"
                        + "codigoPlato varchar(15) NOT NULL,"
                        + "idconsumiciones int NOT NULL,"
                        + "FOREIGN KEY (codigoPlato) REFERENCES platos(codigoPlato),"
                        + "FOREIGN KEY (idconsumiciones) REFERENCES consumiciones(idconsumiciones))";

            String Query12 = "CREATE TABLE " + "cliente" + ""
                        + "(idcliente varchar(50) PRIMARY KEY NOT NULL,"
                        + "nombre varchar(150) NOT NULL,"
                        + "dni varchar(8) NOT NULL)";

            String Query13 = "CREATE TABLE " + "cocina" + ""
                        + "(idCocina varchar(50) PRIMARY KEY NOT NULL,"
                        + "Encargado varchar(50) NOT NULL,"
                        + "minimoEncargable varchar(250) NOT NULL)";

            String Query14 = "CREATE TABLE " + "restaurante" + ""
                        + "(idRestaurante varchar(50) PRIMARY KEY NOT NULL,"
                        + "direccion varchar(150) NOT NULL,"
                        + "aforo int NOT NULL,"
                        + "cantidadMesas int NOT NULL)";

            String Query15 = "CREATE TABLE " + "tipomesa" + ""
                        + "(idTipomesa varchar(50) PRIMARY KEY NOT NULL,"
                        + "Descripcion varchar(150) NOT NULL)";

            String Query16 = "CREATE TABLE " + "mesa" + ""
                        + "(idMesa int PRIMARY KEY NOT NULL IDENTITY(1,1),"
                        + "num_mesa varchar(45) NOT NULL,"
                        + "capacidad int NOT NULL,"
                        + "estadomesa varchar(50) NOT NULL,"
                        + "idTipomesa varchar(50) NOT NULL,"
                        + "idRestaurante varchar(50) NOT NULL,"
                        + "FOREIGN KEY (idTipomesa) REFERENCES tipomesa(idTipomesa),"
                        + "FOREIGN KEY (idRestaurante) REFERENCES restaurante(idRestaurante))";

            String Query17 = "CREATE TABLE " + "reserva" + ""
                        + "(idReserva varchar(50) PRIMARY KEY NOT NULL,"
                        + "dia date NOT NULL,"
                        + "hora time NOT NULL,"
                        + "idcliente varchar(50) NOT NULL,"
                        + "idMesa int NOT NULL,"
                        + "FOREIGN KEY (idcliente) REFERENCES cliente(idcliente),"
                        + "FOREIGN KEY (idMesa) REFERENCES mesa(idMesa))";

            String Query18 = "CREATE TABLE " + "pedido" + ""
                        + "(idPedido varchar(50) PRIMARY KEY NOT NULL,"
                        + "horaPedido time(6) NOT NULL,"
                        + "estado varchar(45) NOT NULL,"
                        + "idMesa int NOT NULL,"
                        + "idconsumiciones int NOT NULL,"
                        + "idCocina varchar(50) NOT NULL,"
                        + "FOREIGN KEY (idMesa) REFERENCES mesa(idMesa),"
                        + "FOREIGN KEY (idconsumiciones) REFERENCES consumiciones(idconsumiciones),"
                        + "FOREIGN KEY (idCocina) REFERENCES cocina(idCocina))";

            String Query19 = "CREATE TABLE " + "tipopago" + ""
                        + "(idTipopago varchar(50) PRIMARY KEY NOT NULL,"
                        + "descripcion varchar(100) NOT NULL)";

            String Query20 = "CREATE TABLE " + "pago" + ""
                        + "(idPago varchar(50) PRIMARY KEY NOT NULL,"
                        + "idTipopago varchar(50) NOT NULL,"
                        + "idMesa int NOT NULL,"
                        + "FOREIGN KEY (idTipopago) REFERENCES tipopago(idTipopago),"
                        + "FOREIGN KEY (idMesa) REFERENCES mesa(idMesa))";

            this.st = this.con.createStatement();
            this.st.executeUpdate(Query1);
            this.st.executeUpdate(Query2);
            this.st.executeUpdate(Query3);
            this.st.executeUpdate(Query4);
            this.st.executeUpdate(Query5);
            this.st.executeUpdate(Query6);
            this.st.executeUpdate(Query7);
            this.st.executeUpdate(Query8);
            this.st.executeUpdate(Query9);
            this.st.executeUpdate(Query10);
            this.st.executeUpdate(Query11);
            this.st.executeUpdate(Query12);
            this.st.executeUpdate(Query13);
            this.st.executeUpdate(Query14);
            this.st.executeUpdate(Query15);
            this.st.executeUpdate(Query16);
            this.st.executeUpdate(Query17);
            this.st.executeUpdate(Query18);
            this.st.executeUpdate(Query19);
            this.st.executeUpdate(Query20);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL CREAR LAS TABLAS");
            ex.printStackTrace();
        }
    }
    
    
    public void createTablePostGreSql() {
        try {
            String Query1 = "CREATE SEQUENCE " + "tipo_almacen_seq";

            String Query2 = "CREATE TABLE " + "tipo_almacen" + ""
                        + "(idtipo_almacen int default nextval('tipo_almacen_seq') PRIMARY KEY,"
                        + "tipo varchar(45) NOT NULL)";

            String Query3 = "CREATE TABLE " + "almacen" + ""
                        + "(idAlmacen varchar(50) PRIMARY KEY NOT NULL,"
                        + "encargado varchar(45) NOT NULL,"
                        + "idtipo int NOT NULL,"
                        + "foreign key(idtipo) references tipo_almacen(idtipo_almacen))";

            String Query4 = "CREATE SEQUENCE " + "tipo_bebidas_seq";

            String Query5 = "CREATE TABLE " + "tipo_bebidas" + ""
                        + "(idtipo int  default nextval('tipo_bebidas_seq') PRIMARY KEY ,"
                        + "tipo varchar(45) NOT NULL)";

            String Query6 = "CREATE TABLE " + "bebidas" + ""
                        + "(codbebidas varchar(15) PRIMARY KEY NOT NULL,"
                        + "nombre varchar(45) NOT NULL,"
                        + "descripcion varchar(100) NOT NULL,"
                        + "medida varchar(10) NOT NULL,"
                        + "stok int NOT NULL,"
                        + "idtipo int NOT NULL,"
                        + "idAlmacen varchar(50) NOT NULL,"
                        + "FOREIGN KEY (idtipo) REFERENCES tipo_bebidas (idtipo),"
                        + "FOREIGN KEY (idAlmacen) REFERENCES almacen (idAlmacen))";

            String Query7 = "CREATE TABLE " + "ingrediente" + ""
                        + "(idIngrediente varchar(50) PRIMARY KEY NOT NULL,"
                        + "nombre varchar(100) NOT NULL,"
                        + "cantidad decimal(8,2) NOT NULL,"
                        + "medida varchar (45) NOT NULL,"
                        + "idAlmacen varchar(50) NOT NULL,"
                        + "FOREIGN KEY (idAlmacen) REFERENCES almacen (idAlmacen))";

            String Query8 = "CREATE SEQUENCE " + "tipo_plato_seq";

            String Query9 = "CREATE TABLE " + "tipo_plato" + ""
                        + "(idtipo int default nextval('tipo_plato_seq') PRIMARY KEY,"
                        + "tipo varchar(155) NOT NULL)";

            String Query10 = "CREATE TABLE " + "platos" + ""
                        + "(codigoPlato varchar(15) PRIMARY KEY NOT NULL,"
                        + "nombre varchar(45) NOT NULL,"
                        + "idtipo int NOT NULL,"
                        + "FOREIGN KEY (idtipo) REFERENCES tipo_plato(idtipo))";

            String Query11 = "CREATE SEQUENCE " + "platos_de_ingrediente_seq";

            String Query12 = "CREATE TABLE " + "platos_de_ingrediente" + ""
                        + "(id int default nextval('platos_de_ingrediente_seq') PRIMARY KEY,"
                        + "codigoPlato varchar(15) NOT NULL,"
                        + "idIngrediente varchar(50) NOT NULL,"
                        + "FOREIGN KEY (codigoPlato) REFERENCES platos(codigoPlato),"
                        + "FOREIGN KEY (idIngrediente) REFERENCES ingrediente(idIngrediente))";

            String Query13 = "CREATE SEQUENCE " + "consumiciones_seq";

            String Query14 = "CREATE TABLE " + "consumiciones" + ""
                        + "(idconsumiciones int default nextval('consumiciones_seq') PRIMARY KEY,"
                        + "descripcion varchar(220) NOT NULL)";

            String Query15 = "CREATE SEQUENCE " + "bebidas_de_consumiciones_seq";

            String Query16 = "CREATE TABLE " + "bebidas_de_consumiciones" + ""
                        + "(id int default nextval('bebidas_de_consumiciones_seq') PRIMARY KEY,"
                        + "codbebidas varchar(15) NOT NULL,"
                        + "idconsumiciones int NOT NULL,"
                        + "FOREIGN KEY (codbebidas) REFERENCES bebidas(codbebidas),"
                        + "FOREIGN KEY (idconsumiciones) REFERENCES consumiciones(idconsumiciones))";

            String Query17 = "CREATE SEQUENCE " + "platos_de_consumiciones_seq";

            String Query18 = "CREATE TABLE " + "platos_de_consumiciones" + ""
                        + "(id int default nextval('platos_de_consumiciones_seq') PRIMARY KEY,"
                        + "codigoPlato varchar(15) NOT NULL,"
                        + "idconsumiciones int NOT NULL,"
                        + "FOREIGN KEY (codigoPlato) REFERENCES platos(codigoPlato),"
                        + "FOREIGN KEY (idconsumiciones) REFERENCES consumiciones(idconsumiciones))";

            String Query19 = "CREATE TABLE " + "cliente" + ""
                        + "(idcliente varchar(50) PRIMARY KEY NOT NULL,"
                        + "nombre varchar(150) NOT NULL,"
                        + "dni varchar(8) NOT NULL)";

            String Query20 = "CREATE TABLE " + "cocina" + ""
                        + "(idCocina varchar(50) PRIMARY KEY NOT NULL,"
                        + "Encargado varchar(50) NOT NULL,"
                        + "minimoEncargable varchar(250) NOT NULL)";

            String Query21 = "CREATE TABLE " + "restaurante" + ""
                        + "(idRestaurante varchar(50) PRIMARY KEY NOT NULL,"
                        + "direccion varchar(150) NOT NULL,"
                        + "aforo int NOT NULL,"
                        + "cantidadMesas int NOT NULL)";

            String Query22 = "CREATE TABLE " + "tipomesa" + ""
                        + "(idTipomesa varchar(50) PRIMARY KEY NOT NULL,"
                        + "Descripcion varchar(150) NOT NULL)";

            String Query23 = "CREATE SEQUENCE " + "mesa_seq";

            String Query24 = "CREATE TABLE " + "mesa" + ""
                        + "(idMesa int default nextval('mesa_seq') PRIMARY KEY,"
                        + "num_mesa varchar(45) NOT NULL,"
                        + "capacidad int NOT NULL,"
                        + "estadomesa varchar(50) NOT NULL,"
                        + "idTipomesa varchar(50) NOT NULL,"
                        + "idRestaurante varchar(50) NOT NULL,"
                        + "FOREIGN KEY (idTipomesa) REFERENCES tipomesa(idTipomesa),"
                        + "FOREIGN KEY (idRestaurante) REFERENCES restaurante(idRestaurante))";

            String Query25 = "CREATE TABLE " + "reserva" + ""
                        + "(idReserva varchar(50) PRIMARY KEY NOT NULL,"
                        + "dia date NOT NULL,"
                        + "hora time NOT NULL,"
                        + "idcliente varchar(50) NOT NULL,"
                        + "idMesa int NOT NULL,"
                        + "FOREIGN KEY (idcliente) REFERENCES cliente(idcliente),"
                        + "FOREIGN KEY (idMesa) REFERENCES mesa(idMesa))";

            String Query26 = "CREATE TABLE " + "pedido" + ""
                        + "(idPedido varchar(50) PRIMARY KEY NOT NULL,"
                        + "horaPedido time(6) NOT NULL,"
                        + "estado varchar(45) NOT NULL,"
                        + "idMesa int NOT NULL,"
                        + "idconsumiciones int NOT NULL,"
                        + "idCocina varchar(50) NOT NULL,"
                        + "FOREIGN KEY (idMesa) REFERENCES mesa(idMesa),"
                        + "FOREIGN KEY (idconsumiciones) REFERENCES consumiciones(idconsumiciones),"
                        + "FOREIGN KEY (idCocina) REFERENCES cocina(idCocina))";

            String Query27 = "CREATE TABLE " + "tipopago" + ""
                        + "(idTipopago varchar(50) PRIMARY KEY NOT NULL,"
                        + "descripcion varchar(100) NOT NULL)";

            String Query28 = "CREATE TABLE " + "pago" + ""
                        + "(idPago varchar(50) PRIMARY KEY NOT NULL,"
                        + "idTipopago varchar(50) NOT NULL,"
                        + "idMesa int NOT NULL,"
                        + "FOREIGN KEY (idTipopago) REFERENCES tipopago(idTipopago),"
                        + "FOREIGN KEY (idMesa) REFERENCES mesa(idMesa))";

            this.st = this.con.createStatement();
            this.st.executeUpdate(Query1);
            this.st.executeUpdate(Query2);
            this.st.executeUpdate(Query3);
            this.st.executeUpdate(Query4);
            this.st.executeUpdate(Query5);
            this.st.executeUpdate(Query6);
            this.st.executeUpdate(Query7);
            this.st.executeUpdate(Query8);
            this.st.executeUpdate(Query9);
            this.st.executeUpdate(Query10);
            this.st.executeUpdate(Query11);
            this.st.executeUpdate(Query12);
            this.st.executeUpdate(Query13);
            this.st.executeUpdate(Query14);
            this.st.executeUpdate(Query15);
            this.st.executeUpdate(Query16);
            this.st.executeUpdate(Query17);
            this.st.executeUpdate(Query18);
            this.st.executeUpdate(Query19);
            this.st.executeUpdate(Query20);
            this.st.executeUpdate(Query21);
            this.st.executeUpdate(Query22);
            this.st.executeUpdate(Query23);
            this.st.executeUpdate(Query24);
            this.st.executeUpdate(Query25);
            this.st.executeUpdate(Query26);
            this.st.executeUpdate(Query27);
            this.st.executeUpdate(Query28);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL CREAR LAS TABLAS");
            ex.printStackTrace();
        }
    }
}
