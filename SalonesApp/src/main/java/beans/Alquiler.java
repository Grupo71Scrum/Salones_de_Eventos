
package beans;

import java.sql.Date;

public class Alquiler {
    private int id;
    private String username;
    private Date fecha;
    private boolean novedad;
    private String categoria;
    private Date hora_inicio;
    private Date hora_salida;
    private float valo;

    public Alquiler(int id, String username, Date fecha, boolean novedad, String categoria, Date hora_inicio, Date hora_salida, float valo) {
        this.id = id;
        this.username = username;
        this.fecha = fecha;
        this.novedad = novedad;
        this.categoria = categoria;
        this.hora_inicio = hora_inicio;
        this.hora_salida = hora_salida;
        this.valo = valo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean isNovedad() {
        return novedad;
    }

    public void setNovedad(boolean novedad) {
        this.novedad = novedad;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Date getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(Date hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public Date getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(Date hora_salida) {
        this.hora_salida = hora_salida;
    }

    public float getValo() {
        return valo;
    }

    public void setValo(float valo) {
        this.valo = valo;
    }

    @Override
    public String toString() {
        return "Alquiler{" + "id=" + id + ", username=" + username + ", fecha=" + fecha + ", novedad=" + novedad + ", categoria=" + categoria + ", hora_inicio=" + hora_inicio + ", hora_salida=" + hora_salida + ", valo=" + valo + '}';
    }
    
    
    
    
    
}
