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
package net.adisan.helper;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import net.adisan.bean.helper.MetaBeanHelper;
import net.adisan.bean.specificimplementation.CentrosanitarioSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.GrupoSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.TipousuarioSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.UsuarioSpecificBeanImplementation;
import net.adisan.connection.publicinterface.ConnectionInterface;
import net.adisan.factory.ConnectionFactory;
import net.adisan.constant.ConnectionConstants;

public class SessionHelper {

    private static MetaBeanHelper oMBHUsuarioBean = null;

    public static void logDB(Integer id_usuario, String ob, String op) throws Exception {
        Connection oConnection = null;
        ConnectionInterface oPooledConnection = null;
        Statement oStatement = null;
        Statement oStatement2 = null;
        try {
            oPooledConnection = ConnectionFactory.getSourceConnection(ConnectionConstants.connectionName);
            oConnection = oPooledConnection.newConnection();
            Date otiempo = new Date(System.currentTimeMillis() - 12 * 30 * 24 * 60 * 60 * 1000); //1 año
            Date now = new Date();

            if (RandomHelper.getRandomInt(1, 10000) == 5329) {
                String strSQL = "DELETE FROM log WHERE stamp < " + EncodingHelper.stringifyAndQuotate(otiempo);
                oStatement = oConnection.createStatement();
                oStatement.executeUpdate(strSQL);
            }
            String strSQL2 = "INSERT INTO log (id, id_usuario, ob, op, stamp ) VALUES (NULL, " + id_usuario + ", '" + ob + "', '" + op + "', " + EncodingHelper.stringifyAndQuotate(now) + ")";
            oStatement2 = oConnection.createStatement();
            oStatement2.executeUpdate(strSQL2);
        } catch (SQLException ex) {
            throw ex;
        } finally {
            if (oStatement != null) {
                oStatement.close();
            }
            if (oStatement2 != null) {
                oStatement2.close();
            }
            if (oConnection != null) {
                oConnection.close();
            }
            if (oPooledConnection != null) {
                oPooledConnection.disposeConnection();
            }
        }
    }

    public static Boolean thereISSession() {
        return oMBHUsuarioBean != null;
    }

    public static Boolean thereIsNOSession() {
        return oMBHUsuarioBean == null;
    }

    public static Boolean isThereSession(Integer level) {
        if (oMBHUsuarioBean != null) {
            UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oMBHUsuarioBean.getBean();
            if (oUsuario != null) {
                if (oUsuario.getId_tipousuario() == level) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static UsuarioSpecificBeanImplementation getoUsuarioBean() {
        if (oMBHUsuarioBean != null) {
            return (UsuarioSpecificBeanImplementation) oMBHUsuarioBean.getBean();
        } else {
            return null;
        }
    }

    public static CentrosanitarioSpecificBeanImplementation getoCentroSanitarioBean() {
        if (oMBHUsuarioBean != null) {
            UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oMBHUsuarioBean.getBean();
            if (oUsuario != null) {
                if (oUsuario.getId_tipousuario() == 3) {
                    // el centro sanitario de un alumno es del profesor
                    GrupoSpecificBeanImplementation oGrupo = (GrupoSpecificBeanImplementation) SessionHelper.getoUsuarioBean().getObj_grupo().getBean();
                    UsuarioSpecificBeanImplementation oProfesor = (UsuarioSpecificBeanImplementation) oGrupo.getObj_usuario().getBean();
                    CentrosanitarioSpecificBeanImplementation oCentroSanitario = (CentrosanitarioSpecificBeanImplementation) oProfesor.getObj_centrosanitario().getBean();
                    return oCentroSanitario;
                } else {
                    return (CentrosanitarioSpecificBeanImplementation) oUsuario.getObj_centrosanitario().getBean();
                }
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public static MetaBeanHelper getoMBHUsuarioBean() {
        return oMBHUsuarioBean;
    }

    public static void setoMBHUsuarioBean(MetaBeanHelper oMBHUsuarioBean) {
        SessionHelper.oMBHUsuarioBean = oMBHUsuarioBean;

    }

    public static int getIdTipoUsuario() throws Exception {
        if (oMBHUsuarioBean != null) {
            UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oMBHUsuarioBean.getBean();
            if (oUsuario != null) {
                return oUsuario.getId_tipousuario();
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

}
