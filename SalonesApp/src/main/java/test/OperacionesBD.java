
package test;
    import beans.Salones;
    import connection.DBConnection;
    import java.sql.ResultSet;
    import java.sql.Statement;

public class OperacionesBD {
    public static void main(String[] args) {
        actaulizarSalon(1,"Conferencias");
        listarSalon();
    }
    public static void actaulizarSalon(int id, String categoria){
       DBConnection con = new DBConnection();
       String sql = "UPDATE salon SET categoria = '" + categoria+ " ' WHERE id =" + id;
        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally {
            con.desconectar();
        }
    }
    public static void listarSalon(){
       DBConnection con = new DBConnection();
       String sql = "SELECT * FROM salon";
        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String categoria = rs.getString("categoria");
                int capacidad = rs.getInt("capacidad");
                int valor_hora = rs.getInt("valor_hora");
                boolean novedad = rs.getBoolean("novedad");
                String descripcion = rs.getString("descripcion");
                   boolean bandera = rs.getBoolean("bandera");    
                
                Salones salones = new Salones(id,nombre,categoria,capacidad,valor_hora,novedad,descripcion,bandera);
                System.out.println(salones.toString());
            }
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally {
            con.desconectar();
        }
    }
}
