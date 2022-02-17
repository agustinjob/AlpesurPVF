package punto.venta.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import punto.venta.misclases.InventaMovi;

public class InventaMovimiDAO{

    Date d = new Date();
    DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
    DateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
    int idUsuario = UsuarioDAO.getIdUsuario();
    Connection conn= Conexion.conectarMySQL();

    public void insertarMovimiento(InventaMovi inventaMovi){

        try {
            Statement s = conn.createStatement();
            String sql="INSERT INTO `movimientos_inventario`(`hora`, `descripcion`, `movimiento`, `habia`, `cantidad`, `hay`, `cajero`, `Departamento`, `idUsuario`) VALUES "+
            "('"+formatoHora.format(d)+"','"+inventaMovi.getDescripcion()+"','"+inventaMovi.getMovimiento()+"',"+inventaMovi.getHabia()+","+inventaMovi.getCantidad()+","+inventaMovi.getHay()+",'"+inventaMovi.getCajero()+"','"+inventaMovi.getDepartamento()+"',"+inventaMovi.getIdMovInv()+")"; 
            s.execute(sql);
        } catch (SQLException e) {
           
            e.printStackTrace();
        }

    }

    public void modificarMovimiento(InventaMovi inventaMovi){
        try {
            Statement s = conn.createStatement();
            String sql="UPDATE `movimientos_inventario` SET  `hora`='"+inventaMovi.getHora()+"',`descripcion`='"+inventaMovi.getDescripcion()+"',`movimiento`='"+inventaMovi.getMovimiento()+"',"+
            "`habia`="+inventaMovi.getHabia()+",`cantidad`="+inventaMovi.getCantidad()+",`hay`="+inventaMovi.getHay()+",`cajero`='"+inventaMovi.getCajero()+"',`Departamento`='"+inventaMovi.getDepartamento()+"',`idUsuario`="+inventaMovi.getIdUsuario()+" WHERE idMovInv= " + inventaMovi.getIdMovInv();
            s.executeUpdate(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public ResultSet movimientosPorDia(Date fecha, String tipo, String departamento){

        ResultSet datos=null;
        try {
            Statement s = conn.createStatement();
            String sql="Select * from movimientos_inventario where fecha = '"+formatoFecha.format(fecha)+"'";
            if(!tipo.equalsIgnoreCase("")){
                sql= sql +" and movimiento='"+tipo+"'";
            }
            if(!departamento.equalsIgnoreCase("")){
                sql = sql = " and departamento='"+departamento+"'";
            }

           datos= s.executeQuery(sql);


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return datos;
        

    }
}