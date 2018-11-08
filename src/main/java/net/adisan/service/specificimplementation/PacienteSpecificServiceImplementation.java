/*
 * Copyright (c) 2017-2018
 *
 * by Rafael Angel Aznar Aparici (rafaaznar at gmail dot com) & DAW students
 *
 * ADISAN: Free Open Source Health Management System
 *
 *
 * Sources at:                https://github.com/rafaelaznar/adisan
 *                            
 * Database at:               https://github.com/rafaelaznar/adisan-database
 *
 * ADISAN is distributed under the MIT License (MIT)
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
package net.adisan.service.specificimplementation;

import net.adisan.bean.helper.MetaBeanHelper;
import net.adisan.bean.helper.ReplyBeanHelper;
import net.adisan.bean.specificimplementation.ApellidoSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.MunicipioSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.NombrefemeninoSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.NombremasculinoSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.PacienteSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.ProvinciaSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.TipousuarioSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.UsuarioSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.ViaSpecificBeanImplementation;
import net.adisan.connection.publicinterface.ConnectionInterface;
import net.adisan.dao.specificimplementation.factory.ApellidoSpecificDaoImplementation;
import net.adisan.dao.specificimplementation.factory.MunicipioSpecificDaoImplementation;
import net.adisan.dao.specificimplementation.factory.NombrefemeninoSpecificDaoImplementation;
import net.adisan.dao.specificimplementation.factory.NombremasculinoSpecificDaoImplementation;
import net.adisan.dao.specificimplementation.paciente.Paciente1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.factory.ProvinciaSpecificDaoImplementation;
import net.adisan.dao.specificimplementation.factory.ViaSpecificDaoImplementation;
import net.adisan.factory.ConnectionFactory;
import net.adisan.helper.EncodingHelper;
import net.adisan.helper.GsonHelper;
import net.adisan.helper.Log4jHelper;
import net.adisan.helper.RandomHelper;
import net.adisan.helper.constant.ConnectionConstants;
import net.adisan.service.genericimplementation.GenericServiceImplementation;
import java.sql.Connection;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

public class PacienteSpecificServiceImplementation extends GenericServiceImplementation {

    public PacienteSpecificServiceImplementation(HttpServletRequest request) {
        super(request);
    }

    Connection oConnection = null;
    ConnectionInterface oPooledConnection = null;
    Integer idUsuario = null;

//    @Override
//    protected Boolean checkPermission(String strMethodName) {
//        MetaBeanHelper oUsuarioBean = (MetaBeanHelper) oRequest.getSession().getAttribute("user");
//        if (oUsuarioBean != null) {
//            UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oUsuarioBean.getBean();
//            MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
//            TipousuarioSpecificBeanImplementation oTipousuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
//            Integer idTipousuario = oTipousuario.getId();
//
//            String strMethod = strMethodName.toLowerCase();
//            switch (idTipousuario) {
//                case 1:
//                    return true;
//                case 2:
//                    return false;
//                case 3:
//                    switch (strMethod) {
//                        case "getmetadata":
//                            return true;
//                        case "getobjectmetadata":
//                            return true;
//                        case "getpropertiesmetadata":
//                            return true;
//                        case "get":
//                            return true;
//                        case "setnew":
//                            return true;
//                        case "getpage":
//                            return true;
//                        case "getcount":
//                            return true;
//                        case "getpagex":
//                            return true;
//                        case "getcountx":
//                            return true;
//                    }
//                    break;
//                case 4:
//                    switch (strMethod) {
//                        case "getmetadata":
//                            return true;
//                        case "getobjectmetadata":
//                            return true;
//                        case "getpropertiesmetadata":
//                            return true;
//                        case "get":
//                            return true;
//                        case "set":
//                            return true;
//                        case "remove":
//                            return false;
//                        case "getpage":
//                            return true;
//                        case "getcount":
//                            return true;
//                        case "getcountx":
//                            return true;
//                        case "getpagex":
//                            return true;
//                    }
//                    break;
//                case 5:
//                    switch (strMethod) {
//                        case "getmetadata":
//                            return true;
//                        case "getobjectmetadata":
//                            return true;
//                        case "getpropertiesmetadata":
//                            return true;
//                        case "get":
//                            return true;
//                        case "set":
//                            return false;
//                        case "remove":
//                            return false;
//                        case "getpage":
//                            return true;
//                        case "getcount":
//                            return true;
//                        case "getpagex":
//                            return true;
//                        case "getcountx":
//                            return true;
//                    }
//                    break;
//                default:
//                    return false;
//            }
//
//        }
//        return false;
//    }
    public ReplyBeanHelper create() throws Exception {
        ob = "paciente";
        ReplyBeanHelper oReplyBean = null;
        MetaBeanHelper oMetaBean = new MetaBeanHelper();
        //Integer num = Integer.parseInt(oRequest.getParameter("num"));
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

            //for (int j = 1; j <= num; j++) {
            //String dni = "0";
            String dni = "";
            for (int i = 1; i <= 8; i++) {
                dni += RandomHelper.getRandomInt(0, 9);
            }
            dni += RandomHelper.getRadomChar();
            oPacienteBean.setDni(dni);

            int sexo = (int) RandomHelper.getRandomInt(1, 2);
            //-- Nombre
            if (sexo == 1) {
                NombremasculinoSpecificDaoImplementation oDaoMasculino = new NombremasculinoSpecificDaoImplementation(oConnection, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
                oMetaBean = oDaoMasculino.get((int) RandomHelper.getRandomInt(1, oDaoMasculino.getCount(null).intValue()), 0);
                NombremasculinoSpecificBeanImplementation oNombremasculinoBean = (NombremasculinoSpecificBeanImplementation) oMetaBean.getBean();
                oPacienteBean.setNombre(EncodingHelper.capitalizeString(oNombremasculinoBean.getNombre()));

            } else {
                NombrefemeninoSpecificDaoImplementation oDaoFemenino = new NombrefemeninoSpecificDaoImplementation(oConnection, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
                oMetaBean = oDaoFemenino.get((int) RandomHelper.getRandomInt(1, oDaoFemenino.getCount(null).intValue()), 0);
                NombrefemeninoSpecificBeanImplementation oNombrefemeninoBean = (NombrefemeninoSpecificBeanImplementation) oMetaBean.getBean();
                oPacienteBean.setNombre(EncodingHelper.capitalizeString(oNombrefemeninoBean.getNombre()));
            }

            //--- Apellido 1
            ApellidoSpecificDaoImplementation oDaoApellido = new ApellidoSpecificDaoImplementation(oConnection, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            oMetaBean = oDaoApellido.get((int) RandomHelper.getRandomInt(1, oDaoApellido.getCount(null).intValue()), 0);
            ApellidoSpecificBeanImplementation oApellidoBean = (ApellidoSpecificBeanImplementation) oMetaBean.getBean();
            oPacienteBean.setPrimer_apellido(EncodingHelper.capitalizeString(oApellidoBean.getApellido()));

            // Apellido 2
            ApellidoSpecificDaoImplementation oDaoApellido2 = new ApellidoSpecificDaoImplementation(oConnection, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            oMetaBean = oDaoApellido2.get((int) RandomHelper.getRandomInt(1, oDaoApellido.getCount(null).intValue()), 0);
            oApellidoBean = (ApellidoSpecificBeanImplementation) oMetaBean.getBean();
            oPacienteBean.setSegundo_apellido(EncodingHelper.capitalizeString(oApellidoBean.getApellido()));

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
            Direccion = oViaBean.getVia() + " de " + EncodingHelper.capitalizeString(nombre + " " + ap);
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
            oPacienteBean.setEmail(mail.toLowerCase());

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
            oPacienteBean.setNombre_padre(EncodingHelper.capitalizeString(nombre));

            //---- Nombre de la madre
            NombrefemeninoSpecificDaoImplementation oDaoFemenino = new NombrefemeninoSpecificDaoImplementation(oConnection, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            oMetaBean = oDaoFemenino.get((int) RandomHelper.getRandomInt(1, oDaoFemenino.getCount(null).intValue()), 0);
            NombrefemeninoSpecificBeanImplementation oNombrefemeninoBean = (NombrefemeninoSpecificBeanImplementation) oMetaBean.getBean();
            nombre = oNombrefemeninoBean.getNombre();
            oPacienteBean.setNombre_madre(EncodingHelper.capitalizeString(nombre));

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
            for (int i = 1; i <= 9; i++) {
                sip += RandomHelper.getRandomInt(0, 9);
            }
            oPacienteBean.setSip_aseguradora(sip);
            //--
            //oPacienteBean.setId_tipopago(RandomHelper.getRandomInt(1, 3));
            oPacienteBean.setId_sexo(sexo);
            oPacienteBean.setId_usuario(oUsuario.getId());

            result += oPacienteDao.create(oPacienteBean);

            String strJson = GsonHelper.getGson().toJson(oPacienteBean);
            oReplyBean = new ReplyBeanHelper(200, strJson);

            //}
            //oReplyBean = new ReplyBeanHelper(200, Integer.toString(result));
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
