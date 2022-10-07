package controller;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import beans.Salones;
import connection.DBConnection;

public class SalonController implements ISalonController {

    @Override
    public String listar(boolean ordenar, String orden) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "Select * from salon";

        if (ordenar == true) {
            sql += " order by categoria " + orden;
        }

        List<String> salones = new ArrayList<String>();
        System.out.println("estoy donde se crea el vector que guarda los salones");
        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String categoria = rs.getString("categoria");
                int capacidad = rs.getInt("capacidad");
                float valor_hora = rs.getFloat("valor_hora");
                boolean novedad = rs.getBoolean("novedad");
                String descripcion = rs.getString("descripcion");
                boolean bandera = rs.getBoolean("bandera");

                Salones salon1 = new Salones(id, nombre, categoria, capacidad, valor_hora, novedad, descripcion, bandera);

                salones.add(gson.toJson(salon1));

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return gson.toJson(salones);

    }
    
}