package org.petstar.dto;

import java.math.BigDecimal;
import java.sql.Date;

/**
 *
 * @author Tech-Pro
 */
public class FallasDTO {
    private int id_falla;
    private String descripcion;
    private String hora_inicio;
    private String hora_final;
    private BigDecimal tiempo_paro;
    private int id_meta;
    private int id_razon;
    private int id_equipo;
    private int estatus;
    private int id_usuario_registro;
    private Date fecha_modificacion_registro;
    private int id_usuario_modifica_registro;
    private int id_fuente;
    private int id_linea;
    private int id_grupo;
    private int id_turno;
    private Date dia;
    private String diaString;
    private String valor_fuente;
    private String valor_razon;
    private String valor_equipo;
    private String valor_grupo;
    private String valor_turno;
    private String valor_linea;
    private String descripcion_equipo;
    private int estatus_validado;
    private boolean validado;

    public int getId_falla() {
        return id_falla;
    }

    public void setId_falla(int id_falla) {
        this.id_falla = id_falla;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public String getHora_final() {
        return hora_final;
    }

    public void setHora_final(String hora_final) {
        this.hora_final = hora_final;
    }

    public BigDecimal getTiempo_paro() {
        return tiempo_paro;
    }

    public void setTiempo_paro(BigDecimal tiempo_paro) {
        this.tiempo_paro = tiempo_paro;
    }

    public int getId_meta() {
        return id_meta;
    }

    public void setId_meta(int id_meta) {
        this.id_meta = id_meta;
    }

    public int getId_razon() {
        return id_razon;
    }

    public void setId_razon(int id_razon) {
        this.id_razon = id_razon;
    }

    public int getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(int id_equipo) {
        this.id_equipo = id_equipo;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public int getId_usuario_registro() {
        return id_usuario_registro;
    }

    public void setId_usuario_registro(int id_usuario_registro) {
        this.id_usuario_registro = id_usuario_registro;
    }

    public Date getFecha_modificacion_registro() {
        return fecha_modificacion_registro;
    }

    public void setFecha_modificacion_registro(Date fecha_modificacion_registro) {
        this.fecha_modificacion_registro = fecha_modificacion_registro;
    }

    public int getId_usuario_modifica_registro() {
        return id_usuario_modifica_registro;
    }

    public void setId_usuario_modifica_registro(int id_usuario_modifica_registro) {
        this.id_usuario_modifica_registro = id_usuario_modifica_registro;
    }

    public int getId_fuente() {
        return id_fuente;
    }

    public void setId_fuente(int id_fuente) {
        this.id_fuente = id_fuente;
    }

    public int getId_linea() {
        return id_linea;
    }

    public void setId_linea(int id_linea) {
        this.id_linea = id_linea;
    }

    public int getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(int id_grupo) {
        this.id_grupo = id_grupo;
    }

    public int getId_turno() {
        return id_turno;
    }

    public void setId_turno(int id_turno) {
        this.id_turno = id_turno;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public String getDiaString() {
        return diaString;
    }

    public void setDiaString(String diaString) {
        this.diaString = diaString;
    }

    public String getValor_fuente() {
        return valor_fuente;
    }

    public void setValor_fuente(String valor_fuente) {
        this.valor_fuente = valor_fuente;
    }

    public String getValor_razon() {
        return valor_razon;
    }

    public void setValor_razon(String valor_razon) {
        this.valor_razon = valor_razon;
    }

    public String getValor_equipo() {
        return valor_equipo;
    }

    public void setValor_equipo(String valor_equipo) {
        this.valor_equipo = valor_equipo;
    }

    public String getValor_grupo() {
        return valor_grupo;
    }

    public void setValor_grupo(String valor_grupo) {
        this.valor_grupo = valor_grupo;
    }

    public String getValor_turno() {
        return valor_turno;
    }

    public void setValor_turno(String valor_turno) {
        this.valor_turno = valor_turno;
    }

    public String getValor_linea() {
        return valor_linea;
    }

    public void setValor_linea(String valor_linea) {
        this.valor_linea = valor_linea;
    }

    public String getDescripcion_equipo() {
        return descripcion_equipo;
    }

    public void setDescripcion_equipo(String descripcion_equipo) {
        this.descripcion_equipo = descripcion_equipo;
    }

    public int getEstatus_validado() {
        return estatus_validado;
    }

    public void setEstatus_validado(int estatus_validado) {
        this.estatus_validado = estatus_validado;
    }

    public boolean isValidado() {
        return validado;
    }

    public void setValidado(boolean validado) {
        this.validado = validado;
    }
}
