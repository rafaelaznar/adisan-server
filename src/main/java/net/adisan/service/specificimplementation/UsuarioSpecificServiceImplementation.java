/*
 * Copyright (c) 2017-2018
 *
 * by Rafael Angel Aznar Aparici (rafaaznar at gmail dot com) & DAW students
 *
 * ADISAN: Free Open Source Health Management System
 *
 * Sources at:
 *                            https://github.com/rafaelaznar/adisan
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

import com.google.gson.Gson;
import net.adisan.service.genericimplementation.GenericServiceImplementation;
import net.adisan.bean.helper.MetaBeanHelper;
import net.adisan.bean.helper.ReplyBeanHelper;
import net.adisan.bean.specificimplementation.UsuarioSpecificBeanImplementation;
import net.adisan.connection.publicinterface.ConnectionInterface;
import net.adisan.dao.specificimplementation.centrosanitario.usuario.Usuario1SpecificDaoImplementation;
import net.adisan.factory.ConnectionFactory;
import net.adisan.helper.constant.ConnectionConstants;
import net.adisan.dao.publicinterface.DaoInterface;
import net.adisan.dao.specificimplementation.centrosanitario.usuario.Usuario3SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.centrosanitario.usuario.grupo.Grupo1SpecificDaoImplementation;
import net.adisan.factory.DaoFactory;
import net.adisan.helper.EncodingHelper;
import net.adisan.helper.GsonHelper;
import net.adisan.helper.Log4jHelper;
import net.adisan.helper.RandomHelper;
import net.adisan.helper.Recaptcha;
import net.adisan.helper.constant.ConfigurationConstants;
import net.adisan.helper.constant.RecaptchaConstants;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UsuarioSpecificServiceImplementation extends GenericServiceImplementation {

    public UsuarioSpecificServiceImplementation(HttpServletRequest request) {
        super(request);
    }

    public ReplyBeanHelper getallobjectsmetadata() throws Exception {
        if (this.checkPermission("getallobjectsmetadata")) {
            ReplyBeanHelper oReplyBean = null;
            HashMap hmObjectsMetaData = new HashMap();
            DaoInterface oDao = null;
            oDao = DaoFactory.getDao("usuario", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("usuario", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("tipousuario", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("tipousuario", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("centro", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("centro", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("centrosanitario", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("centrosanitario", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("curso", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("curso", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("grupo", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("grupo", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("tipoepisodio", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("tipoepisodio", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("especialidad", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("especialidad", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("destinoalta", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("destinoalta", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("tipopago", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("tipopago", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("sexo", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("sexo", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("circunstanciasalta", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("circunstanciasalta", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("modalidadepisodio", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("modalidadepisodio", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("tipodependencia", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("tipodependencia", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("tiposervicio", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("tiposervicio", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("factura", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("factura", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("servicio", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("servicio", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("paciente", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("paciente", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("categoriaprofesional", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("categoriaprofesional", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("episodio", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("episodio", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("subepisodio", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("subepisodio", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("dependencia", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("dependencia", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("medico", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("medico", oDao.getObjectMetaData());
            String strJson = GsonHelper.getGson().toJson(hmObjectsMetaData);
            oReplyBean = new ReplyBeanHelper(200, strJson);
            return oReplyBean;
        } else {
            return new ReplyBeanHelper(401, EncodingHelper.quotate("Unauthorized"));
        }
    }

    public ReplyBeanHelper login() throws Exception {
        Connection oConnection = null;
        ConnectionInterface oPooledConnection = null;
        ReplyBeanHelper oReplyBean = null;
        UsuarioSpecificBeanImplementation oUsuarioBean = new UsuarioSpecificBeanImplementation();
        oUsuarioBean.setLogin(oRequest.getParameter("user"));
        oUsuarioBean.setPassword(oRequest.getParameter("pass"));
//        String recaptcha = oRequest.getParameter("g-recaptcha-response");
//        if (Recaptcha.isCaptchaValid(RecaptchaConstants.getSecretKey(), oRequest.getParameter("g-recaptcha-response"))) {
            if (!oUsuarioBean.getLogin().equalsIgnoreCase("") || !oUsuarioBean.getPassword().equalsIgnoreCase("")) {
                try {
                    oPooledConnection = ConnectionFactory.getSourceConnection(ConnectionConstants.connectionName);
                    oConnection = oPooledConnection.newConnection();
                    Usuario1SpecificDaoImplementation oDao = new Usuario1SpecificDaoImplementation(oConnection, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
                    MetaBeanHelper oMetaBeanHelper = oDao.getFromLoginAndPass(oUsuarioBean);

                    UsuarioSpecificBeanImplementation oUsuarioSession = (UsuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    if (oUsuarioSession.getId_tipousuario() > 2) {
                        if (oUsuarioSession.getActivo() == 1) {
                            HttpSession oSession = oRequest.getSession();
                            oSession.setAttribute("user", oMetaBeanHelper);
                            String strJson = GsonHelper.getGson().toJson(oMetaBeanHelper);
                            oReplyBean = new ReplyBeanHelper(200, strJson);
                        } else {
                            String msg1 = this.getClass().getName() + ": Inactive user try to login: rejected: ob:" + ob;
                            Log4jHelper.errorLog(msg1);
                            throw new Exception(msg1);
                        }
                    } else { //el administrador siempre activo
                        HttpSession oSession = oRequest.getSession();
                        oSession.setAttribute("user", oMetaBeanHelper);
                        String strJson = GsonHelper.getGson().toJson(oMetaBeanHelper);
                        oReplyBean = new ReplyBeanHelper(200, strJson);
                    }
                } catch (Exception ex) {
                    String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
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
            }
//        } else {
//            String msg1 = this.getClass().getName() + ": Invalid captcha ob:" + ob;
//            Log4jHelper.errorLog(msg1);
//            throw new Exception(msg1);
//        }
        return oReplyBean;
    }

    public ReplyBeanHelper logout() throws Exception {
        if (this.checkPermission("logout")) {
            HttpSession oSession = oRequest.getSession();
            oSession.invalidate();
            ReplyBeanHelper oReplyBean = new ReplyBeanHelper(200, EncodingHelper.quotate("Session is closed"));
            return oReplyBean;
        } else {
            return new ReplyBeanHelper(401, EncodingHelper.quotate("Unauthorized"));
        }
    }

    public ReplyBeanHelper getSessionStatus() throws Exception {
        ReplyBeanHelper oReplyBean = null;
        UsuarioSpecificBeanImplementation oUsuarioBean = null;
        try {
            HttpSession oSession = oRequest.getSession();
            MetaBeanHelper oMetaBeanHelper = (MetaBeanHelper) oSession.getAttribute("user");
            if (oMetaBeanHelper != null) {
                String strJson = GsonHelper.getGson().toJson(oMetaBeanHelper);
                oReplyBean = new ReplyBeanHelper(200, strJson);
            } else {
                oReplyBean = new ReplyBeanHelper(401, null);
            }
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
            Log4jHelper.errorLog(msg, ex);
            throw new Exception(msg, ex);
        }
        return oReplyBean;
    }

    public ReplyBeanHelper getSessionUserLevel() {
        if (this.checkPermission("getSessionUserLevel")) {
            ReplyBeanHelper oReplyBean = null;
            String strAnswer = null;
            MetaBeanHelper oUserBean = (MetaBeanHelper) oRequest.getSession().getAttribute("user");
            Map<Integer, String> map = new HashMap<>();
            if (oUserBean == null) {
                oReplyBean = new ReplyBeanHelper(401, EncodingHelper.quotate("Unauthorized"));
            } else {
                oReplyBean = new ReplyBeanHelper(200, EncodingHelper.quotate(((UsuarioSpecificBeanImplementation) oUserBean.getBean()).getId_tipousuario().toString()));
            }
            return oReplyBean;
        } else {
            return new ReplyBeanHelper(401, EncodingHelper.quotate("Unauthorized"));
        }
    }

    public ReplyBeanHelper resetPass() throws Exception {
        if (this.checkPermission("passchange")) {
            Connection oConnection = null;
            ConnectionInterface oPooledConnection = null;
            int id = Integer.parseInt(oRequest.getParameter("id"));
            String newPass = "60AFD331E8DBEFB78E530FE296CF330F4F8E9B9D585B012B22CD65E0B7CCED09"; //adisan
            ReplyBeanHelper oReplyBean = null;
            Integer iResult = 0;
            try {
                oPooledConnection = ConnectionFactory.getSourceConnection(ConnectionConstants.connectionName);
                oConnection = oPooledConnection.newConnection();
                oConnection.setAutoCommit(false);

                MetaBeanHelper oPuserBean_security = (MetaBeanHelper) oRequest.getSession().getAttribute("user");
                UsuarioSpecificBeanImplementation oUserSessionBean = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();

                switch (oUserSessionBean.getId_tipousuario()) {
                    case 1:
                        Usuario1SpecificDaoImplementation oUser1Dao = new Usuario1SpecificDaoImplementation(oConnection, oPuserBean_security, "");
                        MetaBeanHelper oUser1 = oUser1Dao.get(id, 0);
                        UsuarioSpecificBeanImplementation oUsuario1Bean = (UsuarioSpecificBeanImplementation) oUser1.getBean();
                        iResult = oUser1Dao.updatePassword(oUsuario1Bean.getId(), oUsuario1Bean.getPassword(), newPass);
                        break;
                    case 3:
                        Usuario3SpecificDaoImplementation oUser3Dao = new Usuario3SpecificDaoImplementation(oConnection, oPuserBean_security, "");
                        MetaBeanHelper oUser = oUser3Dao.get(id, 0);
                        UsuarioSpecificBeanImplementation oUsuario3Bean = (UsuarioSpecificBeanImplementation) oUser.getBean();
                        iResult = oUser3Dao.updatePassword(oUsuario3Bean.getId(), oUsuario3Bean.getPassword(), newPass);
                        break;
                }

                if (iResult >= 1) {
                    oReplyBean = new ReplyBeanHelper(200, EncodingHelper.quotate(iResult.toString()));
                } else {
                    oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Server error during password change operation"));
                }
                oConnection.commit();
            } catch (Exception ex) {
                if (oConnection != null) {
                    oConnection.rollback();
                }
                String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
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

    public ReplyBeanHelper setPass() throws Exception {
        if (this.checkPermission("passchange")) {
            Connection oConnection = null;
            ConnectionInterface oPooledConnection = null;
            String oldPass = oRequest.getParameter("old");
            String newPass = oRequest.getParameter("new");
            ReplyBeanHelper oReplyBean = null;
            Integer iResult = 0;
            try {
                oPooledConnection = ConnectionFactory.getSourceConnection(ConnectionConstants.connectionName);
                oConnection = oPooledConnection.newConnection();
                oConnection.setAutoCommit(false);
                Usuario1SpecificDaoImplementation oUserDao = new Usuario1SpecificDaoImplementation(oConnection, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
                MetaBeanHelper oSessionUsuarioBeanMeta = (MetaBeanHelper) oRequest.getSession().getAttribute("user");
                UsuarioSpecificBeanImplementation oSessionUsuarioBean = (UsuarioSpecificBeanImplementation) oSessionUsuarioBeanMeta.getBean();
                if (oSessionUsuarioBean.getPassword().equalsIgnoreCase(oldPass)) {
                    oSessionUsuarioBean.setPassword(newPass);
                    iResult = oUserDao.updatePassword(oSessionUsuarioBean.getId(), oldPass, newPass);
                    if (iResult >= 1) {
                        oReplyBean = new ReplyBeanHelper(200, EncodingHelper.quotate(iResult.toString()));
                    } else {
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Server error during password change operation"));
                    }
                } else {
                    oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate(iResult.toString()));
                }
                oConnection.commit();
            } catch (Exception ex) {
                if (oConnection != null) {
                    oConnection.rollback();
                }
                String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
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

    /**
     * used in the auto-registration process of students,2nd phase
     *
     * @return OK if user name (login parameter) not exists in the database
     * @throws java.sql.SQLException
     */
    public ReplyBeanHelper checklogin() throws SQLException, Exception {
        Connection oConnection = null;
        ConnectionInterface oPooledConnection = null;
        ReplyBeanHelper oReplyBean = null;
        UsuarioSpecificBeanImplementation oPuser = null;
        String strAnswer = null;
        String strCode = "200";
        try {
            oPooledConnection = ConnectionFactory.getSourceConnection(ConnectionConstants.connectionName);
            oConnection = oPooledConnection.newConnection();
            String login = oRequest.getParameter("login");
            if (!login.isEmpty()) {
                try {
                    Usuario1SpecificDaoImplementation oUserDao = new Usuario1SpecificDaoImplementation(oConnection, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
                    if (oUserDao.getIDfromUser(login) == 0) {
                        oReplyBean = new ReplyBeanHelper(200, EncodingHelper.quotate("OK"));
                    } else {
                        oReplyBean = new ReplyBeanHelper(403, EncodingHelper.quotate("Server error during checklogin operation"));
                    }
                } catch (Exception ex) {
                    String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
                    Log4jHelper.errorLog(msg, ex);
                    throw new Exception(msg, ex);
                }
            }
        } catch (Exception ex) {
            if (oConnection != null) {
                oConnection.rollback();
            }
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
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

    /**
     * used in the auto-registration process of students, 3th phase saves alumno
     * data from 'json' parameter
     *
     * @return return id of new alumno
     * @throws java.lang.Exception
     */
    public ReplyBeanHelper setalumno() throws Exception {
        Connection oConnection = null;
        ConnectionInterface oPooledConnection = null;
        ReplyBeanHelper oReplyBean = null;
        UsuarioSpecificBeanImplementation oPuser = null;
        try {
            oPooledConnection = ConnectionFactory.getSourceConnection(ConnectionConstants.connectionName);
            oConnection = oPooledConnection.newConnection();
            UsuarioSpecificBeanImplementation oUser = new UsuarioSpecificBeanImplementation();
            Usuario1SpecificDaoImplementation oUserDao = new Usuario1SpecificDaoImplementation(oConnection, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            Gson oGson = GsonHelper.getGson();
            oUser = oGson.fromJson(oRequest.getParameter("json"), oUser.getClass());
            oUser.setId_tipousuario(4);
            oUser.setActivo(0);
            oUser.setValidado(0);
            java.util.Date dt = new java.util.Date();
            oUser.setFecha_alta(dt);
            oUser.setToken(RandomHelper.getToken(ConfigurationConstants.tokenSize));
            Integer iResult = oUserDao.create(oUser);
            if (iResult >= 1) {
                oReplyBean = new ReplyBeanHelper(200, EncodingHelper.quotate(iResult.toString()));
            } else {
                oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Server error during new setalumno operation"));
            }
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
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

    /**
     * Used in the auto-registration process of students,1st phase
     *
     * @return returns grupo json from a registration code
     * @throws java.sql.SQLException
     * @throws java.lang.Exception
     */
    public ReplyBeanHelper getidcurso() throws SQLException, Exception {
        Connection oConnection = null;
        ConnectionInterface oPooledConnection = null;
        ReplyBeanHelper oReplyBean = null;
        UsuarioSpecificBeanImplementation oPuser = null;
        try {
            oPooledConnection = ConnectionFactory.getSourceConnection(ConnectionConstants.connectionName);
            oConnection = oPooledConnection.newConnection();
            String codigo = oRequest.getParameter("codigo");
            if (!codigo.isEmpty()) {
                Usuario1SpecificDaoImplementation oUserDao = new Usuario1SpecificDaoImplementation(oConnection, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
                Grupo1SpecificDaoImplementation oGrupoDao = new Grupo1SpecificDaoImplementation(oConnection, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
                MetaBeanHelper oGrupoMBH = oGrupoDao.get(oUserDao.getIDfromCodigoGrupo(codigo), 2);
                oReplyBean = new ReplyBeanHelper(200, GsonHelper.getGson().toJson(oGrupoMBH));
            }
        } catch (Exception ex) {
            if (oConnection != null) {
                oConnection.rollback();
            }
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
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

    /**
     * used in teachers activations of students
     *
     *
     * @return return id of new alumno
     * @throws java.lang.Exception
     */
    public ReplyBeanHelper activate() throws Exception {
        Connection oConnection = null;
        ConnectionInterface oPooledConnection = null;
        ReplyBeanHelper oReplyBean = null;
        UsuarioSpecificBeanImplementation oPuser = null;
        try {
            oPooledConnection = ConnectionFactory.getSourceConnection(ConnectionConstants.connectionName);
            oConnection = oPooledConnection.newConnection();
            int id = Integer.parseInt(oRequest.getParameter("id"));
            if (id > 0) {
                MetaBeanHelper oUsuarioSessionBean = (MetaBeanHelper) oRequest.getSession().getAttribute("user");
                UsuarioSpecificBeanImplementation oUsuarioSession = (UsuarioSpecificBeanImplementation) oUsuarioSessionBean.getBean();
                Integer iResult = 0;
                //sólo pueden activar admin y profesores
                if (oUsuarioSession.getId_tipousuario() == 1) {
                    Usuario1SpecificDaoImplementation oUsuario1Dao = (Usuario1SpecificDaoImplementation) DaoFactory.getDao(ob, oConnection, oUsuarioSessionBean, null);
                    iResult = oUsuario1Dao.activate(id);
                }
                if (oUsuarioSession.getId_tipousuario() == 3) {
                    Usuario3SpecificDaoImplementation oUsuario3Dao = (Usuario3SpecificDaoImplementation) DaoFactory.getDao(ob, oConnection, oUsuarioSessionBean, null);
                    iResult = oUsuario3Dao.activate(id);
                }
                if (iResult >= 1) {
                    oReplyBean = new ReplyBeanHelper(200, EncodingHelper.quotate(iResult.toString()));
                } else {
                    oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Server error during activate operation"));
                }
            }
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
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

    /**
     * used in teachers deactivations of students
     *
     *
     * @return return id of new alumno
     * @throws java.lang.Exception
     */
    public ReplyBeanHelper deactivate() throws Exception {
        Connection oConnection = null;
        ConnectionInterface oPooledConnection = null;
        ReplyBeanHelper oReplyBean = null;
        UsuarioSpecificBeanImplementation oPuser = null;
        try {
            oPooledConnection = ConnectionFactory.getSourceConnection(ConnectionConstants.connectionName);
            oConnection = oPooledConnection.newConnection();
            int id = Integer.parseInt(oRequest.getParameter("id"));
            if (id > 0) {
                MetaBeanHelper oUsuarioSessionBean = (MetaBeanHelper) oRequest.getSession().getAttribute("user");
                UsuarioSpecificBeanImplementation oUsuarioSession = (UsuarioSpecificBeanImplementation) oUsuarioSessionBean.getBean();
                Integer iResult = 0;
                //sólo pueden desactivar admin y profesores
                if (oUsuarioSession.getId_tipousuario() == 1) {
                    Usuario1SpecificDaoImplementation oUsuario1Dao = (Usuario1SpecificDaoImplementation) DaoFactory.getDao(ob, oConnection, oUsuarioSessionBean, null);
                    iResult = oUsuario1Dao.deactivate(id);
                }
                if (oUsuarioSession.getId_tipousuario() == 3) {
                    Usuario3SpecificDaoImplementation oUsuario3Dao = (Usuario3SpecificDaoImplementation) DaoFactory.getDao(ob, oConnection, oUsuarioSessionBean, null);
                    iResult = oUsuario3Dao.deactivate(id);
                }
                if (iResult >= 1) {
                    oReplyBean = new ReplyBeanHelper(200, EncodingHelper.quotate(iResult.toString()));
                } else {
                    oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Server error during deactivate operation"));
                }
            }
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
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
