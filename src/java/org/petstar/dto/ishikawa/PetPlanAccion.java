package org.petstar.dto.ishikawa;

import java.sql.Date;

/**
 *
 * @author Tech-Pro
 */
public class PetPlanAccion {
    private int id_plan;
    private String accion;
    private String responsable;
    private Date fecha;
    private int id_porque;
    private PetVerificacion verificacion;

    public int getId_plan() {
        return id_plan;
    }

    public void setId_plan(int id_plan) {
        this.id_plan = id_plan;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getId_porque() {
        return id_porque;
    }

    public void setId_porque(int id_porque) {
        this.id_porque = id_porque;
    }

    public PetVerificacion getVerificacion() {
        return verificacion;
    }

    public void setVerificacion(PetVerificacion verificacion) {
        this.verificacion = verificacion;
    }
}
