/*
 * Copyright (c) 2017-2018
 *
 * by Rafael Angel Aznar Aparici (rafaaznar at gmail dot com) & DAW students
 *
 * GESANE: Free Open Source Health Management System
 *
 * Sources at:
 *                            https://github.com/rafaelaznar/gesane-server
 *                            https://github.com/rafaelaznar/gesane-client
 *                            https://github.com/rafaelaznar/gesane-database
 *
 * GESANE is distributed under the MIT License (MIT)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package eu.rafaelaznar.service.specificimplementation;

import eu.rafaelaznar.bean.helper.MetaBeanHelper;
import eu.rafaelaznar.bean.helper.ReplyBeanHelper;
import eu.rafaelaznar.bean.specificimplementation.ApellidoSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.CentrosanitarioSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.MedicoSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.NombrefemeninoSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.NombremasculinoSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.TipousuarioSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.UsuarioSpecificBeanImplementation;
import eu.rafaelaznar.connection.publicinterface.ConnectionInterface;
import eu.rafaelaznar.dao.specificimplementation.factory.ApellidoSpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.medico.Medico1SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.factory.NombrefemeninoSpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.factory.NombremasculinoSpecificDaoImplementation;
import eu.rafaelaznar.factory.ConnectionFactory;
import eu.rafaelaznar.helper.EncodingHelper;
import eu.rafaelaznar.helper.Log4jHelper;
import eu.rafaelaznar.helper.RandomHelper;
import eu.rafaelaznar.helper.constant.ConnectionConstants;
import eu.rafaelaznar.service.genericimplementation.TableGenericServiceImplementation;
import java.sql.Connection;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

public class MedicoSpecificServiceImplementation extends TableGenericServiceImplementation {
    
    public MedicoSpecificServiceImplementation(HttpServletRequest request) {
        super(request);
    }
    
    Connection oConnection = null;
    ConnectionInterface oPooledConnection = null;
    
    @Override
    protected Boolean checkPermission(String strMethodName) {
        MetaBeanHelper oUsuarioBean = (MetaBeanHelper) oRequest.getSession().getAttribute("user");
        if (oUsuarioBean != null) {
            UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oUsuarioBean.getBean();
            MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
            TipousuarioSpecificBeanImplementation oTipousuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
            Integer idTipousuario = oTipousuario.getId();
            
            String strMethod = strMethodName.toLowerCase();
            switch (idTipousuario) {
                case 1:
                    return true;
                case 2:
                    return false;
                case 3:
                    switch (strMethod) {
                        case "getmetadata":
                            return true;
                        case "getobjectmetadata":
                            return true;
                        case "getpropertiesmetadata":
                            return true;
                        case "get":
                            return true;
                        case "set":
                            return true;
                        case "remove":
                            return true;
                        case "getpage":
                            return true;
                        case "getcount":
                            return true;
                    }
                    break;
                case 4:
                    switch (strMethod) {
                        case "getmetadata":
                            return true;
                        case "getobjectmetadata":
                            return true;
                        case "getpropertiesmetadata":
                            return true;
                        case "get":
                            return true;
                        case "set":
                            return true;
                        case "remove":
                            return false;
                        case "getpage":
                            return true;
                        case "getcount":
                            return true;
                    }
                    break;
                case 5:
                    switch (strMethod) {
                        case "getmetadata":
                            return true;
                        case "getobjectmetadata":
                            return true;
                        case "getpropertiesmetadata":
                            return true;
                        case "get":
                            return true;
                        case "set":
                            return false;
                        case "remove":
                            return false;
                        case "getpage":
                            return true;
                        case "getcount":
                            return true;
                    }
                    break;
                default:
                    return false;
            }
            
        }
        return false;
    }
    
    public ReplyBeanHelper rellenaMedico() throws Exception {
        ob = "medico";
        ReplyBeanHelper oReplyBean = null;
        MetaBeanHelper oMetaBean = new MetaBeanHelper();
        Integer num = Integer.parseInt(oRequest.getParameter("num"));
        int result = 0;
        try {
            oPooledConnection = ConnectionFactory.getSourceConnection(ConnectionConstants.connectionName);
            oConnection = oPooledConnection.newConnection();
            Medico1SpecificDaoImplementation oMedicoDao = new Medico1SpecificDaoImplementation(oConnection, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            MedicoSpecificBeanImplementation oMedicoBean = new MedicoSpecificBeanImplementation();
            
            MetaBeanHelper oUsuarioBean = (MetaBeanHelper) oRequest.getSession().getAttribute("user");
            UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oUsuarioBean.getBean();
            MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_centrosanitario();
            CentrosanitarioSpecificBeanImplementation oCentrosanitario = (CentrosanitarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
            Integer idCentrosanitario = oCentrosanitario.getId();

            //id_servicio
            oMedicoBean.setId_servicio(RandomHelper.getRandomInt(1, 16));
            //id_especialidad
            oMedicoBean.setId_especialidad(RandomHelper.getRandomInt(1, 21));

            //dni
            for (int j = 1; j <= num; j++) {
                
                String dni = "0";
                for (int i = 1; i <= 10; i++) {
                    dni += RandomHelper.getRandomInt(0, 8);
                }
                dni += RandomHelper.getRadomChar();
                oMedicoBean.setDni(dni);
                
                int sexo = (int) RandomHelper.getRandomInt(0, 1);
                //-- Nombre
                if (sexo == 1) {
                    NombremasculinoSpecificDaoImplementation oDaoMasculino = new NombremasculinoSpecificDaoImplementation(oConnection, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
                    oMetaBean = oDaoMasculino.get((int) RandomHelper.getRandomInt(1, oDaoMasculino.getCount(null).intValue()), 0);
                    NombremasculinoSpecificBeanImplementation oNombremasculinoBean = (NombremasculinoSpecificBeanImplementation) oMetaBean.getBean();
                    oMedicoBean.setNombre(oNombremasculinoBean.getNombre());
                    
                } else {
                    NombrefemeninoSpecificDaoImplementation oDaoFemenino = new NombrefemeninoSpecificDaoImplementation(oConnection, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
                    oMetaBean = oDaoFemenino.get((int) RandomHelper.getRandomInt(1, oDaoFemenino.getCount(null).intValue()), 0);
                    NombrefemeninoSpecificBeanImplementation oNombrefemeninoBean = (NombrefemeninoSpecificBeanImplementation) oMetaBean.getBean();
                    oMedicoBean.setNombre(oNombrefemeninoBean.getNombre());
                }

                //--- Apellido 1
                ApellidoSpecificDaoImplementation oDaoApellido = new ApellidoSpecificDaoImplementation(oConnection, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
                oMetaBean = oDaoApellido.get((int) RandomHelper.getRandomInt(1, oDaoApellido.getCount(null).intValue()), 0);
                ApellidoSpecificBeanImplementation oApellidoBean = (ApellidoSpecificBeanImplementation) oMetaBean.getBean();
                oMedicoBean.setPrimer_apellido(oApellidoBean.getApellido());

                // Apellido 2
                ApellidoSpecificDaoImplementation oDaoApellido2 = new ApellidoSpecificDaoImplementation(oConnection, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
                oMetaBean = oDaoApellido2.get((int) RandomHelper.getRandomInt(1, oDaoApellido.getCount(null).intValue()), 0);
                oApellidoBean = (ApellidoSpecificBeanImplementation) oMetaBean.getBean();
                oMedicoBean.setSegundo_apellido(oApellidoBean.getApellido());

                //--- email
                String nombrep = oMedicoBean.getNombre();
                String primerp = oMedicoBean.getPrimer_apellido();
                String segundop = oMedicoBean.getSegundo_apellido();
                String nombrep2c = nombrep.substring(0, Math.min(nombrep.length(), 2));
                String primerp2c = primerp.substring(0, Math.min(primerp.length(), 2));
                String segundop2c = segundop.substring(0, Math.min(segundop.length(), 2));
                String mail = nombrep2c + primerp2c + segundop2c + "@" + oMedicoBean.getPrimer_apellido() + ".es";
                oMedicoBean.setEmail(mail);
                //---- fecha_nacimiento
                Date fnac = RandomHelper.getRadomDate();
                oMedicoBean.setFecha_nacimiento(fnac);
                //id categoria profesional
                oMedicoBean.setId_categoriaprofesional(RandomHelper.getRandomInt(1, 3));     
                //id centro sanitario 
                oMedicoBean.setId_centrosanitario(idCentrosanitario);
                
                result += oMedicoDao.set(oMedicoBean);
            }
            
            oReplyBean = new ReplyBeanHelper(200, Integer.toString(result));
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
            Log4jHelper.errorLog(msg, ex);
            throw new Exception(msg, ex);
        } finally {
            if (oConnection != null) {
                oConnection.close();
            }
            if (oPooledConnection != null) {
                oPooledConnection.disposeConnection();
            }
        }
        
        return oReplyBean;
    }
}
