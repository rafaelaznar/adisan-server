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
import net.adisan.bean.specificimplementation.GrupoSpecificBeanImplementation;
import net.adisan.connection.publicinterface.ConnectionInterface;
import net.adisan.dao.specificimplementation.grupo.Grupo1SpecificDaoImplementation;
import net.adisan.factory.ConnectionFactory;
import net.adisan.helper.EncodingHelper;
import net.adisan.helper.constant.ConnectionConstants;
import net.adisan.service.genericimplementation.GenericServiceImplementation;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;

public class GrupoSpecificServiceImplementation extends GenericServiceImplementation {

    //private final Logger oLogger = (Logger) LogManager.getLogger(this.getClass().getName());
    
    public GrupoSpecificServiceImplementation(HttpServletRequest request) {
        super(request);
    }

    public ReplyBeanHelper check() throws Exception {
        Connection oConnection = null;
        ConnectionInterface oPooledConnection = null;
        ReplyBeanHelper oReplyBean = null;
        String codigo = oRequest.getParameter("codigo");
        if (!codigo.isEmpty()) {
            try {
                oPooledConnection = ConnectionFactory.getSourceConnection(ConnectionConstants.connectionName);
                oConnection = oPooledConnection.newConnection();
                Grupo1SpecificDaoImplementation oGrupoDao = new Grupo1SpecificDaoImplementation(oConnection, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
                GrupoSpecificBeanImplementation oGrupo = new GrupoSpecificBeanImplementation();
                oGrupo.setCodigo(codigo);
                oGrupo = (GrupoSpecificBeanImplementation) oGrupoDao.getFromCodigo(oGrupo).getBean();
                if (oGrupo.getId() > 0) {
                    oReplyBean = new ReplyBeanHelper(200, EncodingHelper.quotate("OK"));
                } else {
                    oReplyBean = new ReplyBeanHelper(403, EncodingHelper.quotate("Bad authentication"));
                }
            } catch (Exception ex) {
                if (oConnection != null) {
                    oConnection.rollback();
                }
                throw ex;
            } finally {
                if (oConnection != null) {
                    oConnection.close();
                }
                if (oPooledConnection != null) {
                    oPooledConnection.disposeConnection();
                }
            }

        }
        return oReplyBean;
    }

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
//                    }
//                    break;
//                default:
//                    return false;
//            }
//
//        }
//        return false;
//    }
}
