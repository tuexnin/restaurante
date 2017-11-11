package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion {

    private static Connection Conexion;

    public void SQLSERVERConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "12345678");
            //JOptionPane.showMessageDialog(null, "Conexion Exitosa");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se encontró el driver de conexion");

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Hubo un problema al conectar con la base de datos");
        }
    }

    public void closeConnection() {
        try {
            Conexion.close();
            System.out.println("Se ha finalizado la conexión con el servidor");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createBD(String name) {
        try {
            String Query = "CREATE DATABASE " + name;
            Statement st = Conexion.createStatement();
            System.out.println(st.executeUpdate(Query));
            SQLSERVERConnection();
            JOptionPane.showMessageDialog(null, "Sea creado la base de datos " + name + " de forma exitosa");

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void UseBD() {
        try {

            String Query = "USE restaurante101 ";
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Se Conecto a la Base de Datos restaurante10 ");

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   public void createTable() {
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

            Statement st = Conexion.createStatement();
            st.executeUpdate(Query1);
            st.executeUpdate(Query2);
            st.executeUpdate(Query3);
            st.executeUpdate(Query4);
            st.executeUpdate(Query5);
            st.executeUpdate(Query6);
            st.executeUpdate(Query7);
            st.executeUpdate(Query8);
            st.executeUpdate(Query9);
            st.executeUpdate(Query10);
            st.executeUpdate(Query11);
            st.executeUpdate(Query12);
            st.executeUpdate(Query13);
            st.executeUpdate(Query14);
            st.executeUpdate(Query15);
            st.executeUpdate(Query16);
            st.executeUpdate(Query17);
            st.executeUpdate(Query18);
            st.executeUpdate(Query19);
            st.executeUpdate(Query20);
            JOptionPane.showMessageDialog(null, "Sea crearon las Tablas de forma exitosa");

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarBD() {
        try {
            String Query = "DROP DATABASE restaurante101 ";
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
            SQLSERVERConnection();
            JOptionPane.showMessageDialog(null, "Se ha borrado la base de datos restaurante101 ");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {

    }

}
