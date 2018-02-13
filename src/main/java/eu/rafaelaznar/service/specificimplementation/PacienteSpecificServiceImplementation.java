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

import com.google.gson.Gson;
import eu.rafaelaznar.bean.genericimplementation.TableGenericBeanImplementation;
import eu.rafaelaznar.bean.helper.MetaBeanHelper;
import eu.rafaelaznar.bean.helper.ReplyBeanHelper;
import eu.rafaelaznar.bean.specificimplementation.ApellidoSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.MunicipioSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.NombrefemeninoSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.NombremasculinoSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.PacienteSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.ProvinciaSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.TipousuarioSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.UsuarioSpecificBeanImplementation;
import eu.rafaelaznar.connection.publicinterface.ConnectionInterface;
import eu.rafaelaznar.dao.specificimplementation.usuario.grupo.Grupo3SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.paciente.Paciente3SpecificDaoImplementation;
import eu.rafaelaznar.factory.BeanFactory;
import eu.rafaelaznar.factory.ConnectionFactory;
import eu.rafaelaznar.helper.GsonHelper;
import eu.rafaelaznar.helper.Log4jHelper;
import eu.rafaelaznar.bean.specificimplementation.ViaSpecificBeanImplementation;
import eu.rafaelaznar.connection.publicinterface.ConnectionInterface;
import eu.rafaelaznar.dao.specificimplementation.factory.ApellidoSpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.factory.MunicipioSpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.factory.NombrefemeninoSpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.factory.NombremasculinoSpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.paciente.Paciente1SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.factory.ProvinciaSpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.factory.ViaSpecificDaoImplementation;
import eu.rafaelaznar.factory.ConnectionFactory;
import eu.rafaelaznar.helper.EncodingHelper;
import eu.rafaelaznar.helper.Log4jHelper;
import eu.rafaelaznar.helper.RandomHelper;
import eu.rafaelaznar.helper.constant.ConnectionConstants;
import eu.rafaelaznar.service.genericimplementation.TableGenericServiceImplementation;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

public class PacienteSpecificServiceImplementation extends TableGenericServiceImplementation {

    public PacienteSpecificServiceImplementation(HttpServletRequest request) {
        super(request);
    }

    Connection oConnection = null;
    ConnectionInterface oPooledConnection = null;
    Integer idUsuario = null;

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
                        case "setnew":
                            return true;
                        case "getpage":
                            return true;
                        case "getcount":
                            return true;
                        case "getpagex":
                            return true;
                        case "getcountx":
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
                        case "getcountx":
                            return true;
                        case "getpagex":
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
                        case "getpagex":
                            return true;
                        case "getcountx":
                            return true;
                    }
                    break;
                default:
                    return false;
            }

        }
        return false;
    }

    public ReplyBeanHelper rellenaPaciente() throws Exception {
        ob = "paciente";
        ReplyBeanHelper oReplyBean = null;
        MetaBeanHelper oMetaBean = new MetaBeanHelper();
        Integer num = Integer.parseInt(oRequest.getParameter("num"));
        int result = 0;
        try {
            oPooledConnection = ConnectionFactory.getSourceConnection(ConnectionConstants.connectionName);
            oConnection = oPooledConnection.newConnection();
            Paciente1SpecificDaoImplementation oPacienteDao = new Paciente1SpecificDaoImplementation(oConnection, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            PacienteSpecificBeanImplementation oPacienteBean = new PacienteSpecificBeanImplementation();

            MetaBeanHelper oUsuarioBean = (MetaBeanHelper) oRequest.getSession().getAttribute("user");
            UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oUsuarioBean.getBean();
            MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
            TipousuarioSpecificBeanImplementation oTipousuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
            Integer idTipousuario = oTipousuario.getId();

            for (int j = 1; j <= num; j++) {

                String dni = "0";
                for (int i = 1; i <= 10; i++) {
                    dni += RandomHelper.getRandomInt(0, 8);
                }
                dni += RandomHelper.getRadomChar();
                oPacienteBean.setDni(dni);

                int sexo = (int) RandomHelper.getRandomInt(1, 2);
                //-- Nombre
                if (sexo == 1) {
                    NombremasculinoSpecificDaoImplementation oDaoMasculino = new NombremasculinoSpecificDaoImplementation(oConnection, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
                    oMetaBean = oDaoMasculino.get((int) RandomHelper.getRandomInt(1, oDaoMasculino.getCount(null).intValue()), 0);
                    NombremasculinoSpecificBeanImplementation oNombremasculinoBean = (NombremasculinoSpecificBeanImplementation) oMetaBean.getBean();
                    oPacienteBean.setNombre(oNombremasculinoBean.getNombre());

                } else {
                    NombrefemeninoSpecificDaoImplementation oDaoFemenino = new NombrefemeninoSpecificDaoImplementation(oConnection, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
                    oMetaBean = oDaoFemenino.get((int) RandomHelper.getRandomInt(1, oDaoFemenino.getCount(null).intValue()), 0);
                    NombrefemeninoSpecificBeanImplementation oNombrefemeninoBean = (NombrefemeninoSpecificBeanImplementation) oMetaBean.getBean();
                    oPacienteBean.setNombre(oNombrefemeninoBean.getNombre());
                }

                //--- Apellido 1
                ApellidoSpecificDaoImplementation oDaoApellido = new ApellidoSpecificDaoImplementation(oConnection, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
                oMetaBean = oDaoApellido.get((int) RandomHelper.getRandomInt(1, oDaoApellido.getCount(null).intValue()), 0);
                ApellidoSpecificBeanImplementation oApellidoBean = (ApellidoSpecificBeanImplementation) oMetaBean.getBean();
                oPacienteBean.setPrimer_apellido(oApellidoBean.getApellido());

                // Apellido 2
                ApellidoSpecificDaoImplementation oDaoApellido2 = new ApellidoSpecificDaoImplementation(oConnection, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
                oMetaBean = oDaoApellido2.get((int) RandomHelper.getRandomInt(1, oDaoApellido.getCount(null).intValue()), 0);
                oApellidoBean = (ApellidoSpecificBeanImplementation) oMetaBean.getBean();
                oPacienteBean.setSegundo_apellido(oApellidoBean.getApellido());

                //--- Dirección
                String Direccion = "";
                String nombre = "";
                String via = "";
                ViaSpecificBeanImplementation oViaBean = new ViaSpecificBeanImplementation();
                ViaSpecificDaoImplementation oDaoVia = new ViaSpecificDaoImplementation(oConnection, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
                oMetaBean = oDaoVia.get((int) RandomHelper.getRandomInt(1, oDaoVia.getCount(null).intValue()), 0);
                oViaBean = (ViaSpecificBeanImplementation) oMetaBean.getBean();
                via = oViaBean.getVia();
                Integer sexop = (int) RandomHelper.getRandomInt(1, 2);
                //--
                if (sexop == 1) {
                    NombremasculinoSpecificDaoImplementation oDaoMasculino = new NombremasculinoSpecificDaoImplementation(oConnection, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
                    oMetaBean = oDaoMasculino.get((int) RandomHelper.getRandomInt(1, oDaoMasculino.getCount(null).intValue()), 0);
                    NombremasculinoSpecificBeanImplementation oNombremasculinoBean = (NombremasculinoSpecificBeanImplementation) oMetaBean.getBean();
                    nombre = oNombremasculinoBean.getNombre();
                } else {
                    NombrefemeninoSpecificDaoImplementation oDaoFemenino = new NombrefemeninoSpecificDaoImplementation(oConnection, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
                    oMetaBean = oDaoFemenino.get((int) RandomHelper.getRandomInt(1, oDaoFemenino.getCount(null).intValue()), 0);
                    NombrefemeninoSpecificBeanImplementation oNombrefemeninoBean = (NombrefemeninoSpecificBeanImplementation) oMetaBean.getBean();
                    nombre = oNombrefemeninoBean.getNombre();
                }
                ApellidoSpecificDaoImplementation oDaoApellidoDireccion = new ApellidoSpecificDaoImplementation(oConnection, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
                oMetaBean = oDaoApellidoDireccion.get((int) RandomHelper.getRandomInt(1, oDaoApellido.getCount(null).intValue()), 0);
                oApellidoBean = (ApellidoSpecificBeanImplementation) oMetaBean.getBean();
                String ap = oApellidoBean.getApellido();
                //--
                Direccion = oViaBean.getVia() + " de " + nombre + " " + ap;
                oPacienteBean.setDireccion(Direccion);

                //-- Ciudad
                MunicipioSpecificDaoImplementation oDaoMunicipio = new MunicipioSpecificDaoImplementation(oConnection, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
                oMetaBean = oDaoMunicipio.get((int) RandomHelper.getRandomInt(1, oDaoMunicipio.getCount(null).intValue()), 0);
                MunicipioSpecificBeanImplementation oMunicipioBean = (MunicipioSpecificBeanImplementation) oMetaBean.getBean();
                oPacienteBean.setCiudad(oMunicipioBean.getMunicipio());

                //-- codigo postal
                String cod_postal = "46" + RandomHelper.getRandomInt(0, 9) + RandomHelper.getRandomInt(0, 1) + RandomHelper.getRandomInt(0, 9);
                oPacienteBean.setCodigo_postal(cod_postal);

                //--- provincia
                ProvinciaSpecificDaoImplementation oDaoProvincia = new ProvinciaSpecificDaoImplementation(oConnection, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
                oMetaBean = oDaoProvincia.get(oMunicipioBean.getId_provincia(), 0);
                ProvinciaSpecificBeanImplementation oProvinciaBean = (ProvinciaSpecificBeanImplementation) oMetaBean.getBean();
                oPacienteBean.setProvincia(oProvinciaBean.getProvincia());

                //--- país
                oPacienteBean.setPais("España");

                //--- email
                String nombrep = oPacienteBean.getNombre();
                String primerp = oPacienteBean.getPrimer_apellido();
                String segundop = oPacienteBean.getSegundo_apellido();
                String nombrep2c = nombrep.substring(0, Math.min(nombrep.length(), 2));
                String primerp2c = primerp.substring(0, Math.min(primerp.length(), 2));
                String segundop2c = segundop.substring(0, Math.min(segundop.length(), 2));
                String mail = nombrep2c + primerp2c + segundop2c + "@" + oPacienteBean.getPrimer_apellido() + ".es";
                oPacienteBean.setEmail(mail);

                ///--- telefono1
                if (RandomHelper.getRandomInt(0, 1) == 0) {
                    oPacienteBean.setTelefono1(Integer.toString(RandomHelper.getRandomInt(620000000, 629999999)));
                } else {
                    oPacienteBean.setTelefono1(Integer.toString(RandomHelper.getRandomInt(640000000, 649999999)));
                }

                //---- telefono 2
                if (RandomHelper.getRandomInt(0, 1) == 0) {
                    oPacienteBean.setTelefono2(Integer.toString(RandomHelper.getRandomInt(620000000, 629999999)));
                } else {
                    oPacienteBean.setTelefono2(Integer.toString(RandomHelper.getRandomInt(640000000, 649999999)));
                }

                //----- Nombre del padre
                NombremasculinoSpecificDaoImplementation oDaoMasculino = new NombremasculinoSpecificDaoImplementation(oConnection, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
                oMetaBean = oDaoMasculino.get((int) RandomHelper.getRandomInt(1, oDaoMasculino.getCount(null).intValue()), 0);
                NombremasculinoSpecificBeanImplementation oNombremasculinoBean = (NombremasculinoSpecificBeanImplementation) oMetaBean.getBean();
                nombre = oNombremasculinoBean.getNombre();
                oPacienteBean.setNombre_padre(nombre);

                //---- Nombre de la madre
                NombrefemeninoSpecificDaoImplementation oDaoFemenino = new NombrefemeninoSpecificDaoImplementation(oConnection, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
                oMetaBean = oDaoFemenino.get((int) RandomHelper.getRandomInt(1, oDaoFemenino.getCount(null).intValue()), 0);
                NombrefemeninoSpecificBeanImplementation oNombrefemeninoBean = (NombrefemeninoSpecificBeanImplementation) oMetaBean.getBean();
                nombre = oNombrefemeninoBean.getNombre();
                oPacienteBean.setNombre_madre(nombre);

                //---- fecha_nacimiento
                Date fnac = RandomHelper.getRadomDate();
                oPacienteBean.setFecha_nacimiento(fnac);

                MunicipioSpecificDaoImplementation oDaoMunicipioNacimiento = new MunicipioSpecificDaoImplementation(oConnection, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
                oMetaBean = oDaoMunicipioNacimiento.get((int) RandomHelper.getRandomInt(1, oDaoMunicipio.getCount(null).intValue()), 0);
                oMunicipioBean = (MunicipioSpecificBeanImplementation) oMetaBean.getBean();
                oPacienteBean.setCiudad_nacimiento(oMunicipioBean.getMunicipio());

                //--- país
                oPacienteBean.setPais_nacimiento("España");

                //--sip
                String sip = "0";
                for (int i = 1; i <= 10; i++) {
                    sip += RandomHelper.getRandomInt(0, 9);
                }
                oPacienteBean.setSip_aseguradora(sip);
                //--
                oPacienteBean.setId_tipopago(RandomHelper.getRandomInt(1, 3));
                oPacienteBean.setId_sexo(sexo);
                oPacienteBean.setId_usuario(idTipousuario);

                result += oPacienteDao.set(oPacienteBean);
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
