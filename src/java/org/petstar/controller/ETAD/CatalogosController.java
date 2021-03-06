package org.petstar.controller.ETAD;

import com.google.gson.Gson;
import javax.servlet.http.HttpServletRequest;
import org.json.JSONObject;
import org.petstar.controller.ControllerAutenticacion;
import org.petstar.dao.CatalogosDAO;
import org.petstar.dao.ETAD.FrecuenciasDAO;
import org.petstar.dao.ETAD.KPIOperativosDAO;
import org.petstar.dao.ETAD.MetasEstrategicasDAO;
import org.petstar.dao.ETAD.ObjetivosOperativosDAO;
import org.petstar.dto.ETAD.PetCatKpiOperativo;
import org.petstar.dto.ETAD.PetCatMetaEstrategica;
import org.petstar.dto.ETAD.PetCatObjetivoOperativo;
import org.petstar.dto.ResultInteger;
import org.petstar.dto.UserDTO;
import org.petstar.model.ETAD.CatalogosResponse;
import org.petstar.model.OutputJson;
import org.petstar.model.ResponseJson;

/**
 *
 * @author Tech-Pro
 */
public class CatalogosController {
    private static final String MSG_SUCESS = "OK";
    private static final String MSG_LOGOUT = "Inicie sesión nuevamente";
    private static final String MSG_ERROR  = "Descripción de error: ";
    private static final String MSG_EXIST  = "Ya existe un registro con estos valores.";
    private static final String MSG_NOFOUND= "Registro no encontrado.";
    private static final String TABLE_ETAD = "pet_cat_etad";
    
    /**
     * Carga de Combos
     * Servicio que se encarga del llenado de las listas que se utilizaran
     * para los combos que se utilicen en el registro de catalogos
     * @param request
     * @return 
     */
    public OutputJson loadCombobox(HttpServletRequest request){
        ControllerAutenticacion autenticacion = new ControllerAutenticacion();
        ResponseJson response = new ResponseJson();
        OutputJson output = new OutputJson();
            
        try{
            UserDTO session = autenticacion.isValidToken(request);
            if(session != null){
                CatalogosResponse data = new CatalogosResponse();
                FrecuenciasDAO frecuenciasDAO = new FrecuenciasDAO();
                CatalogosDAO catalogosDAO = new CatalogosDAO();
                ObjetivosOperativosDAO oodao = new ObjetivosOperativosDAO();
                
                data.setListEtads(catalogosDAO.getCatalogosActive(TABLE_ETAD));
                data.setListFrecuencias(frecuenciasDAO.getAllFrecuenciasActive());
                data.setListObjetivoOperativos(oodao.getAllObjetivosOperativosActive());
                output.setData(data);
                response.setMessage(MSG_SUCESS);
                response.setSucessfull(true);
            }else{
                response.setMessage(MSG_LOGOUT);
                response.setSucessfull(false);
            }
        }catch(Exception ex){
            response.setMessage(MSG_ERROR + ex.getMessage());
            response.setSucessfull(false);
        }
        
        output.setResponse(response);
        return output;
    }
    
    /**
     * Consulta General
     * Servicio para la consulta general de los catalogos
     * @param request
     * @return 
     */
    public OutputJson getAllCatalogos(HttpServletRequest request){
        ControllerAutenticacion autenticacion = new ControllerAutenticacion();
        ResponseJson response = new ResponseJson();
        OutputJson output = new OutputJson();
            
        try{
            int tipoCatalogo = Integer.valueOf(request.getParameter("tipo_catalogo"));
            UserDTO session = autenticacion.isValidToken(request);
            if(session != null){
                /**
                * Tipos de Catalogos
                * 1.- Metas Estrategicas
                * 2.- Metas Operativas
                * 3.- KPI Operativo
                */
                ObjetivosOperativosDAO operativosDAO = new ObjetivosOperativosDAO();
                //MetasEstrategicasDAO estrategicasDAO = new MetasEstrategicasDAO();
                FrecuenciasDAO frecuenciasDAO = new FrecuenciasDAO();
                KPIOperativosDAO kpioDAO = new KPIOperativosDAO();
                CatalogosResponse data = new CatalogosResponse();
                switch(tipoCatalogo){
                    /*case 1:
                        data.setListMetasEstrategicas(estrategicasDAO.getAllMetasEstrategicas());
                    break;
                    */
                    case 2:
                        data.setListObjetivoOperativos(operativosDAO.getAllObjetivosOperativos());
                    break;
                    case 3:
                        data.setListKpiOperativos(kpioDAO.getAllKPIOperativos());
                        for(PetCatKpiOperativo row:data.getListKpiOperativos()){
                            row.setFrecuencia(frecuenciasDAO.getFrecuenciaById(row.getId_frecuencia()));
                            row.setObjetivoOperativo(operativosDAO.
                                    getObjetivoOperativoById(row.getId_cat_objetivo_operativo()));
                        }
                    break;
                }
                output.setData(data);
                response.setMessage(MSG_SUCESS);
                response.setSucessfull(true);
            }else{
                response.setMessage(MSG_LOGOUT);
                response.setSucessfull(false);
            }
        }catch(Exception ex){
            response.setMessage(MSG_ERROR + ex.getMessage());
            response.setSucessfull(false);
        }
        
        output.setResponse(response);
        return output;
    }
    
    /**
     * Consulta Especifica
     * Servicio para la consulta especifica de un registro por su ID
     * @param request
     * @return 
     */
    public OutputJson getCatalogoById(HttpServletRequest request){
        ControllerAutenticacion autenticacion = new ControllerAutenticacion();
        ResponseJson response = new ResponseJson();
        OutputJson output = new OutputJson();
            
        try{
            int tipoCatalogo = Integer.valueOf(request.getParameter("tipo_catalogo"));
            int idCatalogo = Integer.valueOf(request.getParameter("id_catalogo"));
            UserDTO session = autenticacion.isValidToken(request);
            if(session != null){
                /**
                * Tipos de Catalogos
                * 1.- Metas Estrategicas
                * 2.- Metas Operativas
                * 3.- KPI Operativo
                */
                ObjetivosOperativosDAO operativosDAO = new ObjetivosOperativosDAO();
                //MetasEstrategicasDAO estrategicasDAO = new MetasEstrategicasDAO();
                CatalogosDAO catalogosDAO = new CatalogosDAO();
                KPIOperativosDAO kpioDAO = new KPIOperativosDAO();
                FrecuenciasDAO frecuenciasDAO = new FrecuenciasDAO();
                CatalogosResponse data = new CatalogosResponse();
                
                data.setListEtads(catalogosDAO.getCatalogosActive(TABLE_ETAD));
                data.setListFrecuencias(frecuenciasDAO.getAllFrecuenciasActive());
                data.setListObjetivoOperativos(operativosDAO.getAllObjetivosOperativosActive());
                
                switch(tipoCatalogo){
                    /*case 1:
                        data.setMetaEstrategica(estrategicasDAO.getMetaEstrategicaAnualById(idCatalogo));
                        if(data.getMetaEstrategica() != null){
                            output.setData(data);
                            response = message(true, MSG_SUCESS);
                        }else{
                            response = message(false, MSG_NOFOUND);
                        }
                    break;
                    */
                    case 2:
                        data.setObjetivoOperativo(operativosDAO.getObjetivoOperativoById(idCatalogo));
                        if(data.getObjetivoOperativo() != null){
                            output.setData(data);
                            response = message(true, MSG_SUCESS);
                        }else{
                            response = message(false, MSG_NOFOUND);
                        }
                    break;
                    case 3:
                        data.setKpiOperativo(kpioDAO.getKPIOperativoById(idCatalogo));
                        if(data.getKpiOperativo() != null){
                            data.getKpiOperativo().setFrecuencia(frecuenciasDAO.getFrecuenciaById(
                                    data.getKpiOperativo().getId_frecuencia()));
                            data.getKpiOperativo().setObjetivoOperativo(operativosDAO.getObjetivoOperativoById(
                                    data.getKpiOperativo().getId_cat_objetivo_operativo()));
                            output.setData(data);
                            response = message(true, MSG_SUCESS);
                        }else{
                            response = message(false, MSG_NOFOUND);
                        }
                    break;
                }
            }else{
                response.setMessage(MSG_LOGOUT);
                response.setSucessfull(false);
            }
        }catch(Exception ex){
            response.setMessage(MSG_ERROR + ex.getMessage());
            response.setSucessfull(false);
        }
        
        output.setResponse(response);
        return output;
    }
    
    /**
     * Cambio de Estatus
     * Servicio para cambiar el estatus de un registro a Activo o Inactivo
     * @param request
     * @param estatus
     * @return 
     */
    public OutputJson changeEstatus(HttpServletRequest request, int estatus){
        ControllerAutenticacion autenticacion = new ControllerAutenticacion();
        ResponseJson response = new ResponseJson();
        OutputJson output = new OutputJson();
            
        try{
            int tipoCatalogo = Integer.valueOf(request.getParameter("tipo_catalogo"));
            int idCatalogo = Integer.valueOf(request.getParameter("id_catalogo"));
            UserDTO session = autenticacion.isValidToken(request);
            if(session != null){
                /**
                * Tipos de Catalogos
                * 1.- Metas Estrategicas
                * 2.- Metas Operativas
                * 3.- KPI Operativo
                */
                ObjetivosOperativosDAO operativosDAO = new ObjetivosOperativosDAO();
                //MetasEstrategicasDAO estrategicasDAO = new MetasEstrategicasDAO();
                KPIOperativosDAO kpioDAO = new KPIOperativosDAO();
                switch(tipoCatalogo){
                    /*case 1:
                        estrategicasDAO.changeEstatus(idCatalogo, estatus);
                    break;
                    */
                    case 2:
                        operativosDAO.changeEstatus(idCatalogo, estatus);
                    break;
                    case 3:
                        kpioDAO.changeEstatus(idCatalogo, estatus);
                    break;
                }
                response = message(true, MSG_SUCESS);
            }else{
                response.setMessage(MSG_LOGOUT);
                response.setSucessfull(false);
            }
        }catch(Exception ex){
            response.setMessage(MSG_ERROR + ex.getMessage());
            response.setSucessfull(false);
        }
        
        output.setResponse(response);
        return output;
    }
    
    /**
     * Actualización de datos
     * Servicio para la modificación de valores de un registro en especifico
     * @param request
     * @return 
     */
    public OutputJson updateCatalogo(HttpServletRequest request){
        ControllerAutenticacion autenticacion = new ControllerAutenticacion();
        ResponseJson response = new ResponseJson();
        OutputJson output = new OutputJson();
        Gson gson = new Gson();
            
        try{
            int tipoCatalogo = Integer.valueOf(request.getParameter("tipo_catalogo"));
            String jsonString = request.getParameter("record");
            JSONObject jsonResponse = new JSONObject(jsonString);
            
            UserDTO session = autenticacion.isValidToken(request);
            if(session != null){
                /**
                * Tipos de Catalogos
                * 1.- Metas Estrategicas
                * 2.- Metas Operativas
                * 3.- KPI Operativo
                */
                ObjetivosOperativosDAO operativosDAO = new ObjetivosOperativosDAO();
                //MetasEstrategicasDAO estrategicasDAO = new MetasEstrategicasDAO();
                KPIOperativosDAO kpioDAO = new KPIOperativosDAO();
                switch(tipoCatalogo){
                    /*case 1:
                        PetCatMetaEstrategica pcme = gson.fromJson(jsonResponse.
                                getJSONObject("record").toString(), PetCatMetaEstrategica.class);
                        
                        ResultInteger resultME = estrategicasDAO.validateUpdate(pcme);
                        if(resultME.getResult().equals(0)){
                            estrategicasDAO.updateMetaEstrategica(pcme);
                            response = message(true, MSG_SUCESS);
                        }else{
                            response = message(false, MSG_EXIST);
                        }
                    break;
                    */
                    case 2:
                        PetCatObjetivoOperativo pcoo = gson.fromJson(jsonResponse.
                                getJSONObject("record").toString(), PetCatObjetivoOperativo.class);
                        
                        ResultInteger resultOO = operativosDAO.validateUpdate(pcoo);
                        if(resultOO.getResult().equals(0)){
                            operativosDAO.updateMetaEstrategica(pcoo);
                            //operativosDAO.asignaLineasToObjetivoOperativo(pcoo);
                            response = message(true, MSG_SUCESS);
                        }else{
                            response = message(false, MSG_EXIST);
                        }
                    break;
                    case 3:
                        PetCatKpiOperativo pcko = gson.fromJson(jsonResponse.
                                getJSONObject("record").toString(), PetCatKpiOperativo.class);
                        
                        ResultInteger resultKO = kpioDAO.validateUpdate(pcko);
                        if (resultKO.getResult().equals(0)) {
                            kpioDAO.updateKPIOperativo(pcko);
                            kpioDAO.asignaLineasToKPIOperativos(pcko);
                            response = message(true, MSG_SUCESS);
                        }else{
                            response = message(false, MSG_EXIST);
                        }
                    break;
                }
            }else{
                response.setMessage(MSG_LOGOUT);
                response.setSucessfull(false);
            }
        }catch(Exception ex){
            response.setMessage(MSG_ERROR + ex.getMessage());
            response.setSucessfull(false);
        }
        
        output.setResponse(response);
        return output;
    }
    
    /**
     * Insercion de nuevos Registros
     * Servicio que permite registrar un nuevos elementos a los catalogos
     * @param request
     * @return 
     */
    public OutputJson insertCatalogo(HttpServletRequest request){
        ControllerAutenticacion autenticacion = new ControllerAutenticacion();
        ResponseJson response = new ResponseJson();
        OutputJson output = new OutputJson();
        Gson gson = new Gson();
            
        try{
            int tipoCatalogo = Integer.valueOf(request.getParameter("tipo_catalogo"));
            String jsonString = request.getParameter("record");
            JSONObject jsonResponse = new JSONObject(jsonString);
            
            UserDTO session = autenticacion.isValidToken(request);
            if(session != null){
                /**
                * Tipos de Catalogos
                * 1.- Metas Estrategicas
                * 2.- Metas Operativas
                * 3.- KPI Operativo
                */
                ObjetivosOperativosDAO operativosDAO = new ObjetivosOperativosDAO();
                MetasEstrategicasDAO estrategicasDAO = new MetasEstrategicasDAO();
                KPIOperativosDAO kpioDAO = new KPIOperativosDAO();
                switch(tipoCatalogo){
                    case 1:
                        PetCatMetaEstrategica pcme = gson.fromJson(jsonResponse.
                                getJSONObject("record").toString(), PetCatMetaEstrategica.class);
                        
                        ResultInteger resultME = estrategicasDAO.validateInsert(pcme);
                        if(resultME.getResult().equals(0)){
                            estrategicasDAO.insertMetaEstrategica(pcme);
                            response = message(true, MSG_SUCESS);
                        }else{
                            response = message(false, MSG_EXIST);
                        }
                    break;
                    case 2:
                        PetCatObjetivoOperativo pcoo = gson.fromJson(jsonResponse.
                                getJSONObject("record").toString(), PetCatObjetivoOperativo.class);
                        
                        ResultInteger resultOO = operativosDAO.validateInsert(pcoo);
                        if(resultOO.getResult().equals(0)){
                            ResultInteger idOO = operativosDAO.insertObjetivoOperativo(pcoo);
                            pcoo.setId(idOO.getResult());
                            //operativosDAO.asignaLineasToObjetivoOperativo(pcoo);
                            response = message(true, MSG_SUCESS);
                        }else{
                            response = message(false, MSG_EXIST);
                        }
                    break;
                    case 3:
                        PetCatKpiOperativo pcko = gson.fromJson(jsonResponse.
                                getJSONObject("record").toString(), PetCatKpiOperativo.class);
                        
                        ResultInteger resultKO = kpioDAO.validateInsert(pcko);
                        if (resultKO.getResult().equals(0)) {
                            ResultInteger idKO = kpioDAO.insertKPIOperativo(pcko);
                            pcko.setId(idKO.getResult());
                            kpioDAO.asignaLineasToKPIOperativos(pcko);
                            response = message(true, MSG_SUCESS);
                        }else{
                            response = message(false, MSG_EXIST);
                        }
                    break;
                }
            }else{
                response.setMessage(MSG_LOGOUT);
                response.setSucessfull(false);
            }
        }catch(Exception ex){
            response.setMessage(MSG_ERROR + ex.getMessage());
            response.setSucessfull(false);
        }
        
        output.setResponse(response);
        return output;
    }
    
    public ResponseJson message(boolean result, String reply){
        ResponseJson response = new ResponseJson();
        if(result){
            response.setMessage(reply);
            response.setSucessfull(true);
        }else{
            response.setMessage(reply);
            response.setSucessfull(false);
        }
        return response;
    }
}
