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
import eu.rafaelaznar.bean.specificimplementation.TipousuarioSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.UsuarioSpecificBeanImplementation;
import eu.rafaelaznar.connection.publicinterface.ConnectionInterface;
import eu.rafaelaznar.service.genericimplementation.TableGenericServiceImplementation;
import java.sql.Connection;
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
    // Aquí va el rellena médico + crear beans nuevos
/*
    public ReplyBeanHelper rellena() throws Exception {
        if (this.checkPermission("rellena")) {
            ob = "paciente";
            oPooledConnection = ConnectionFactory.getSourceConnection(ConnectionConstants.connectionName);
            oConnection = oPooledConnection.newConnection();

            ReplyBeanHelper oReplyBean = null;
            Integer num = Integer.parseInt(oRequest.getParameter("num"));
            int result = 0;
            try {
                oPooledConnection = ConnectionFactory.getSourceConnection(ConnectionConstants.connectionName);
                oConnection = oPooledConnection.newConnection();
                MedicoSpecificDaoImplementation oMedicoDao = new MedicoSpecificDaoImplementation(oConnection, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
                MedicoSpecificBeanImplementation oMedicoBean = new MedicoSpecificBeanImplementation();

                for (int j = 1; j <= num; j++) {

                    String dni = "0";
                    for (int i = 1; i <= 10; i++) {
                        dni += RandomHelper.getRandomInt(0, 8);
                    }
                    dni += RandomHelper.getRadomChar();
                    oMedicoBean.setDni(dni);

                    int sexo = (int) RandomHelper.getRandomInt(0, 1);
                    //-- Nombre
                    if (sexo == 0) {
                        NombremasculinoSpecificBeanImplementation oNombremasculinoBean = new NombremasculinoSpecificBeanImplementation();
                        NombremasculinoSpecificDaoImplementation oDaoMasculino = new NombremasculinoSpecificDaoImplementation(oConnection, (UsuarioSpecificBeanImplementation) oRequest.getSession().getAttribute("user"), null);
                        oNombremasculinoBean = (NombremasculinoSpecificBeanImplementation) oDaoMasculino.get((int) RandomHelper.getRandomInt(1, oDaoMasculino.getCount(null).intValue()), 0);
                        oMedicoBean.setNombre(oNombremasculinoBean.getNombre());
                    } else {
                        NombrefemeninoSpecificBeanImplementation oNombrefemeninoBean = new NombrefemeninoSpecificBeanImplementation();
                        NombrefemeninoSpecificDaoImplementation oDaoFemenino = new NombrefemeninoSpecificDaoImplementation(oConnection, (UsuarioSpecificBeanImplementation) oRequest.getSession().getAttribute("user"), null);
                        oNombrefemeninoBean = (NombrefemeninoSpecificBeanImplementation) oDaoFemenino.get((int) RandomHelper.getRandomInt(1, oDaoFemenino.getCount(null).intValue()), 0);
                        oMedicoBean.setNombre(oNombrefemeninoBean.getNombre());
                    }
                    //--- Apellido 1
                    ApellidoSpecificBeanImplementation oApellidoBean = new ApellidoSpecificBeanImplementation();
                    ApellidoSpecificDaoImplementation oDaoApellido = new ApellidoSpecificDaoImplementation(oConnection, (UsuarioSpecificBeanImplementation) oRequest.getSession().getAttribute("user"), null);
                    oApellidoBean = (ApellidoSpecificBeanImplementation) oDaoApellido.get((int) RandomHelper.getRandomInt(1, oDaoApellido.getCount(null).intValue()), 0);
                    oMedicoBean.setPrimerApellido(oApellidoBean.getApellido());
                    //--- Apellido 2
                    oApellidoBean = new ApellidoSpecificBeanImplementation();
                    oDaoApellido = new ApellidoSpecificDaoImplementation(oConnection, (UsuarioSpecificBeanImplementation) oRequest.getSession().getAttribute("user"), null);
                    oApellidoBean = (ApellidoSpecificBeanImplementation) oDaoApellido.get((int) RandomHelper.getRandomInt(1, oDaoApellido.getCount(null).intValue()), 0);
                    oMedicoBean.setSegundoApellido(oApellidoBean.getApellido());
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
                    //---

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
        } else {
            return new ReplyBeanHelper(401, EncodingHelper.quotate("Unauthorized"));
        }
    }
*/
}
