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
package net.adisan.dao.specificimplementation.usuario;

import net.adisan.bean.genericimplementation.GenericBeanImplementation;
import net.adisan.bean.helper.MetaBeanHelper;
import net.adisan.bean.specificimplementation.UsuarioSpecificBeanImplementation;
import net.adisan.dao.genericimplementation.GenericDaoImplementation;
import net.adisan.helper.EncodingHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Usuario1SpecificDaoImplementation extends GenericDaoImplementation {

    //private final Logger oLogger = (Logger) LogManager.getLogger(this.getClass().getName());
    public Usuario1SpecificDaoImplementation(Connection oPooledConnection, MetaBeanHelper oPuserBean_security, String strWhere) throws Exception {
        super("usuario", oPooledConnection, oPuserBean_security, strWhere);
    }

    @Override
    public boolean canCreate(GenericBeanImplementation oBean) throws Exception {
        return true;
    }

    @Override
    public boolean canUpdate(GenericBeanImplementation oBean) throws Exception {
        return true;
    }

    @Override
    public boolean canDelete(GenericBeanImplementation oBean) throws Exception {
        UsuarioSpecificBeanImplementation oUsuarioBean = (UsuarioSpecificBeanImplementation) oBean;
        return !(oUsuarioBean.getLink_grupo() > 0 || oUsuarioBean.getLink_paciente() > 0);
    }

    public MetaBeanHelper getFromLoginAndPass(UsuarioSpecificBeanImplementation oUsuarioBean) throws Exception {
        //TraceHelper.trace("GenericDaoImplementation", "getFromLoginAndPass", "object=" + ob);
        PreparedStatement oPreparedStatement = null;
        ResultSet oResultSet = null;
        MetaBeanHelper oMetaBeanHelper = null;
        String sSQL = strSQL;
        sSQL += " AND login='" + oUsuarioBean.getLogin() + "'";
        sSQL += " AND UPPER(password)='" + oUsuarioBean.getPassword().toUpperCase() + "'";
        try {
            oPreparedStatement = oConnection.prepareStatement(sSQL);
            oResultSet = oPreparedStatement.executeQuery();
            if (oResultSet.next()) {
                oUsuarioBean.setId(oResultSet.getInt("id"));
                oMetaBeanHelper = this.get(oUsuarioBean.getId(), 3);
            } else {
                throw new Exception("UsuarioDao getFromLoginAndPass error");
            }
        } catch (Exception ex) {
            //String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
            //Log4jHelper.errorLog(msg, ex);
            //throw new Exception(msg, ex);
            throw ex;
        } finally {
            if (oResultSet != null) {
                oResultSet.close();
            }
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
        }
        return oMetaBeanHelper;
    }

    public Integer updatePassword(int id, String oldPass, String newPass) throws Exception {
        //TraceHelper.trace("GenericDaoImplementation", "updatePassword", "object=" + ob);
        PreparedStatement oPreparedStatement = null;
        Integer iResult = 0;
        try {
            String strSQL = "UPDATE usuario ";
            strSQL += " SET ";
            strSQL += " password = " + EncodingHelper.quotate(newPass);
            strSQL += " WHERE id=? and password=? ";
            oPreparedStatement = oConnection.prepareStatement(strSQL, Statement.RETURN_GENERATED_KEYS);
            oPreparedStatement.setInt(1, id);
            oPreparedStatement.setString(2, oldPass);
            iResult = oPreparedStatement.executeUpdate();
            if (iResult < 1) {
                String msg = this.getClass().getName() + ": set";
                //Log4jHelper.errorLog(msg);
                throw new Exception(msg);
            }
        } catch (Exception ex) {
            //String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
            //Log4jHelper.errorLog(msg, ex);
            //throw new Exception(msg, ex);
            throw ex;
        } finally {
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
        }
        return iResult;
    }

    public Integer getIDfromUser(String strLogin) throws Exception {
        //TraceHelper.trace("GenericDaoImplementation", "getIDfromUser", "object=" + ob);
        Integer intResult = null;
        Statement oStatement = null;
        ResultSet oResultSet = null;
        try {
            oStatement = (Statement) oConnection.createStatement();
            String strSQL = "SELECT id FROM usuario WHERE login ='" + strLogin + "'";
            oResultSet = oStatement.executeQuery(strSQL);
            if (oResultSet.next()) {
                intResult = oResultSet.getInt("id");
            } else {
                intResult = 0;
                //throw new Exception("No tienes permiso para efectuar la operación");
            }
        } catch (SQLException ex) {
//            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
//            Log4jHelper.errorLog(msg, ex);
//            throw new Exception(msg, ex);
            throw ex;
        } finally {
            if (oResultSet != null) {
                oResultSet.close();
            }
            if (oStatement != null) {
                oStatement.close();
            }
        }
        return intResult;
    }

    public Integer getIDfromCodigoGrupo(String strCode) throws Exception {
        //TraceHelper.trace("GenericDaoImplementation", "getIDfromCodigoGrupo", "object=" + ob);
        Integer intResult = null;
        Statement oStatement = null;
        ResultSet oResultSet = null;
        try {
            oStatement = (Statement) oConnection.createStatement();
            String strSQL = "SELECT id FROM grupo WHERE codigo ='" + strCode + "'";
            oResultSet = oStatement.executeQuery(strSQL);
            if (oResultSet.next()) {
                intResult = oResultSet.getInt("id");
            } else {
                throw new Exception("No tienes permiso para efectuar la operación");
            }
        } catch (SQLException ex) {
            //String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
            //Log4jHelper.errorLog(msg, ex);
            //throw new Exception(msg, ex);
            throw ex;
        } finally {
            if (oResultSet != null) {
                oResultSet.close();
            }
            if (oStatement != null) {
                oStatement.close();
            }
        }
        return intResult;
    }

    public Integer activate(Integer id) throws Exception {
        //TraceHelper.trace("GenericDaoImplementation", "activate", "object=" + ob);
        MetaBeanHelper oUsuarioMBH = this.get(id, 0);
        UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oUsuarioMBH.getBean();
        oUsuario.setActivo(1);
        return this.update(oUsuario);
    }

    public Integer deactivate(Integer id) throws Exception {
        //TraceHelper.trace("GenericDaoImplementation", "deactivate", "object=" + ob);
        MetaBeanHelper oUsuarioMBH = this.get(id, 0);
        UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oUsuarioMBH.getBean();
        oUsuario.setActivo(0);
        return this.update(oUsuario);
    }
}
