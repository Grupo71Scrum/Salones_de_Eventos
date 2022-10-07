
package beans;

public class Salones {
    private int id;
    private String nombre;
    private String categoria;
    private int capacidad;
    private float valor_hora;
    private boolean novedad;
    private String descripcion;
    private boolean bandera;

    public Salones(int id, String nombre, String categoria, int capacidad, float valor_hora, boolean novedad, String descripcion, boolean bandera) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.capacidad = capacidad;
        this.valor_hora = valor_hora;
        this.novedad = novedad;
        this.descripcion = descripcion;
        this.bandera = bandera;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public float getValor_hora() {
        return valor_hora;
    }

    public void setValor_hora(float valor_hora) {
        this.valor_hora = valor_hora;
    }

    public boolean isNovedad() {
        return novedad;
    }

    public void setNovedad(boolean novedad) {
        this.novedad = novedad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isBandera() {
        return bandera;
    }

    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }

   
    @Override
    public String toString() {
        return "Salon{" + "id=" + id + ", nombre=" + nombre + ", categoria=" + categoria + ", capacidad=" + capacidad + ", valor_hora=" + valor_hora + ", novedad=" + novedad + ", descripcion=" + descripcion +  ", bandera=" + bandera + '}';
    }

   
    
    
}
