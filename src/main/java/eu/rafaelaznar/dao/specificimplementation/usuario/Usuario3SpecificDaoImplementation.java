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
package eu.rafaelaznar.dao.specificimplementation.usuario;

import eu.rafaelaznar.bean.genericimplementation.TableGenericBeanImplementation;
import eu.rafaelaznar.bean.helper.MetaBeanHelper;
import eu.rafaelaznar.bean.specificimplementation.CentrosanitarioSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.TipousuarioSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.UsuarioSpecificBeanImplementation;
import eu.rafaelaznar.helper.Log4jHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Usuario3SpecificDaoImplementation extends Usuario1SpecificDaoImplementation {

    private Integer idCentrosanitario = null;
    private Integer idUsuario = 0;

    public Usuario3SpecificDaoImplementation(Connection oPooledConnection, MetaBeanHelper oPuserBean_security, String strWhere) throws Exception {
        super(oPooledConnection, oPuserBean_security, strWhere);
        if (oPuserBean_security != null) {
            UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
            idUsuario = oUsuario.getId();
            MetaBeanHelper ombhTipousuario = (MetaBeanHelper) oUsuario.getObj_tipousuario();
            TipousuarioSpecificBeanImplementation oTipousuario = (TipousuarioSpecificBeanImplementation) ombhTipousuario.getBean();
            if (oTipousuario.getId() == 3) {
                String strSQLini = "";

                CentrosanitarioSpecificBeanImplementation oCentroSanitario = (CentrosanitarioSpecificBeanImplementation) oUsuario.getObj_centrosanitario().getBean();
                idCentrosanitario = oCentroSanitario.getId();
                strSQLini = "FROM usuario where 1=1 "
                        + "AND (id IN (SELECT distinct id FROM usuario where id_centrosanitario = " + idCentrosanitario + " and id_tipousuario=3 ) "
                        + " OR  id IN (SELECT distinct id FROM usuario where id_centrosanitario = " + idCentrosanitario + " and id_tipousuario=5 ) "
                        + " OR  id IN (SELECT distinct u.id FROM usuario u, grupo g, usuario u2 "
                        + "                    WHERE u.id_tipousuario=4 "
                        + "                      AND u.id_grupo=g.id "
                        + "                      AND g.id_usuario=u2.id "
                        + "                      AND u2.id_centrosanitario= " + idCentrosanitario + ")"
                        + ") ";

                strSQL = "SELECT * " + strSQLini;
                strCountSQL = "SELECT COUNT(*) " + strSQLini;
                if (strWhere != null) {
                    strSQL += " " + strWhere + " ";
                    strCountSQL += " " + strWhere + " ";
                }
            } else {
                String msg = this.getClass().getName() + ": constuctor: Unauthorized access";
                Log4jHelper.errorLog(msg);
                throw new Exception(msg);
            }
        } else {
            String msg = this.getClass().getName() + ": constuctor: Unauthorized access";
            Log4jHelper.errorLog(msg);
            throw new Exception(msg);
        }
//           UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
//        idUsuario = oUsuario.getId();
//        idCentrosanitario = oUsuario.getId_centrosanitario();
//        
//        //MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
//        //CentrosanitarioSpecificBeanImplementation oCentrosanitario = (CentrosanitarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
//        strSQL = "SELECT u.id, u.nombre, u.primer_apellido, u.segundo_apellido, u.login, u.password, u.email, u.token, u.activo, u.fecha_alta, u.validado, u.id_tipousuario, u.id_grupo, u.id_centro, u.id_centrosanitario \n" +
//        "FROM usuario u WHERE u.id_centrosanitario = "+ idCentrosanitario+" UNION SELECT u.id, u.nombre, u.primer_apellido, u.segundo_apellido, u.login, u.password, u.email, u.token, u.activo, u.fecha_alta, u.validado, u.id_tipousuario, u.id_grupo, u.id_centro, u.id_centrosanitario FROM paciente p, usuario u, grupo g, usuario u2 WHERE p.id_usuario = u.id AND u.id_tipousuario=4 and u.id_grupo=g.id and g.id_usuario=u2.id and u2.id_centrosanitario= " + idCentrosanitario;

    }

//    @Override
//    public MetaBeanHelper get(int id, int intExpand) throws Exception {
//        PreparedStatement oPreparedStatement = null;
//        ResultSet oResultSet = null;
//        strSQL += " AND u.id=? ";
//        TableGenericBeanImplementation oBean = null;
//        MetaBeanHelper oMetaBeanHelper = null;
//        try {
//            oPreparedStatement = oConnection.prepareStatement(strSQL);
//            oPreparedStatement.setInt(1, id);
//            oResultSet = oPreparedStatement.executeQuery();
//            oBean = (TableGenericBeanImplementation) BeanFactory.getBean(ob, oPuserSecurity);
//            if (oResultSet.next()) {
//                oBean = (TableGenericBeanImplementation) oBean.fill(oResultSet, oConnection, oPuserSecurity, intExpand);
//            } else {
//                oBean.setId(0);
//            }
//            ArrayList<MetaPropertyGenericBeanHelper> alMetaProperties = this.getPropertiesMetaData();
//            MetaObjectGenericBeanHelper oMetaObject = this.getObjectMetaData();
//            oMetaBeanHelper = new MetaBeanHelper(oMetaObject, alMetaProperties, oBean);
//        } catch (Exception ex) {
//            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
//            Log4jHelper.errorLog(msg, ex);
//            throw new Exception(msg, ex);
//        } finally {
//            if (oResultSet != null) {
//                oResultSet.close();
//            }
//            if (oPreparedStatement != null) {
//                oPreparedStatement.close();
//            }
//
//        }
//        return oMetaBeanHelper;
//    }
//    public Boolean checkUpdate(int id) {
//        if (id != 0) {
//            return true;
//        } else {
//            return false;
//        }
//    }
    @Override
    public Integer set(TableGenericBeanImplementation oBean) throws Exception {
        PreparedStatement oPreparedStatement = null;
        ResultSet oResultSet = null;
        Integer idResult = 0;
        Integer iResult = 0;
        Boolean insert = true;
        try {
            if (oBean.getId() == null || oBean.getId() == 0) {
                strSQL = "INSERT INTO " + ob;
                strSQL += "(" + oBean.getColumns() + ")";
                strSQL += " VALUES ";
                strSQL += "(" + oBean.getValues() + ")";

                oPreparedStatement = oConnection.prepareStatement(strSQL, Statement.RETURN_GENERATED_KEYS);
                iResult = oPreparedStatement.executeUpdate();
                if (insert) {
                    oResultSet = oPreparedStatement.getGeneratedKeys();
                    oResultSet.next();
                    idResult = oResultSet.getInt(1);
                }
                strSQL = "UPDATE " + ob + " SET id_usuario=" + idUsuario + " WHERE id=" + idResult;
                oPreparedStatement = oConnection.prepareStatement(strSQL, Statement.RETURN_GENERATED_KEYS);
                oPreparedStatement.executeUpdate();
            } else {
                // check permission if ok edit else unauthorized
                insert = false;
                strSQL = "UPDATE " + ob;
                strSQL += " SET ";
                strSQL += oBean.toPairs();
                strSQL += "SELECT COUNT(*) FROM " + ob + " p, usuario u, grupo g "
                        + "WHERE g.id_usuario = ? AND u.id_grupo = g.id AND "
                        + "u.id = p.id_usuario AND p.id = ?";
//                () from usuario u,paciente p, grupo g where g.id_usuario =  ? (IDPROFESORENSESION) and  u.id_grupo = g.id and u.id = p.id_usuario and p.id =  ? (IDPACIENTEAMODIFICAR);
                oPreparedStatement = oConnection.prepareStatement(strSQL, Statement.RETURN_GENERATED_KEYS);
                oPreparedStatement.setInt(1, idUsuario);
                oPreparedStatement.setInt(2, oBean.getId());
                iResult = oPreparedStatement.executeUpdate();
            }
            if (iResult < 1) {
                String msg = this.getClass().getName() + ": set";
                Log4jHelper.errorLog(msg);
                throw new Exception(msg);
            }
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
            Log4jHelper.errorLog(msg, ex);
            throw new Exception(msg, ex);
        } finally {
            if (insert) {
                if (oResultSet != null) {
                    oResultSet.close();
                }
            }
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
        }
        return idResult;
    }

//    @Override
//    public Long getCount(ArrayList<FilterBeanHelper> alFilter) throws Exception {
//        strCountSQL = "SELECT COUNT(*) FROM usuario u WHERE u.id_centrosanitario = " + idCentrosanitario;
//        PreparedStatement oPreparedStatement = null;
//        ResultSet oResultSet = null;
//        strCountSQL += SqlHelper.buildSqlFilter(alFilter);
//        Long iResult = 0L;
//        try {
//            oPreparedStatement = oConnection.prepareStatement(strCountSQL);
//            oResultSet = oPreparedStatement.executeQuery();
//            if (oResultSet.next()) {
//                iResult = oResultSet.getLong("COUNT(*)");
//            } else {
//                String msg = this.getClass().getName() + ": getcount";
//                Log4jHelper.errorLog(msg);
//                throw new Exception(msg);
//            }
//        } catch (Exception ex) {
//            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
//            Log4jHelper.errorLog(msg, ex);
//            throw new Exception(msg, ex);
//        } finally {
//            if (oResultSet != null) {
//                oResultSet.close();
//            }
//            if (oPreparedStatement != null) {
//                oPreparedStatement.close();
//            }
//        }
//        return iResult;
//    }
//
//    @Override
//    public MetaBeanHelper getPage(int intRegsPerPag, int intPage, LinkedHashMap<String, String> hmOrder, ArrayList<FilterBeanHelper> alFilter, int expand) throws Exception {
//        String strSQL1 = strSQL;
//        strSQL1 += SqlHelper.buildSqlFilter(alFilter);
//        strSQL1 += SqlHelper.buildSqlOrder(hmOrder);
//        strSQL1 += SqlHelper.buildSqlLimit(this.getCount(alFilter), intRegsPerPag, intPage);
//        ArrayList<ViewGenericBeanImplementation> aloBean = new ArrayList<>();
//        PreparedStatement oPreparedStatement = null;
//        ResultSet oResultSet = null;
//        MetaBeanHelper oMetaBeanHelper = null;
//        try {
//            oPreparedStatement = oConnection.prepareStatement(strSQL1);
//            oResultSet = oPreparedStatement.executeQuery(strSQL1);
//            while (oResultSet.next()) {
//                GenericBeanInterface oBean = BeanFactory.getBean(ob, oPuserSecurity);
//                oBean = (ViewGenericBeanImplementation) oBean.fill(oResultSet, oConnection, oPuserSecurity, expand);
//                aloBean.add((ViewGenericBeanImplementation) oBean);
//            }
//
//            ArrayList<MetaPropertyGenericBeanHelper> alMetaProperties = this.getPropertiesMetaData();
//            MetaObjectGenericBeanHelper oMetaObject = this.getObjectMetaData();
//            oMetaBeanHelper = new MetaBeanHelper(oMetaObject, alMetaProperties, aloBean);
//
//        } catch (Exception ex) {
//            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
//            Log4jHelper.errorLog(msg, ex);
//            throw new Exception(msg, ex);
//        } finally {
//            if (oResultSet != null) {
//                oResultSet.close();
//            }
//            if (oPreparedStatement != null) {
//                oPreparedStatement.close();
//            }
//        }
//        return oMetaBeanHelper;
//    }
//    public MetaBeanHelper getFromLoginAndPass(UsuarioSpecificBeanImplementation oUsuarioBean) throws Exception {
//        PreparedStatement oPreparedStatement = null;
//        ResultSet oResultSet = null;
//        MetaBeanHelper oMetaBeanHelper = null;
//        strSQL += " AND login='" + oUsuarioBean.getLogin() + "'";
//        strSQL += " AND password='" + oUsuarioBean.getPassword() + "'";
//        try {
//            oPreparedStatement = oConnection.prepareStatement(strSQL);
//            oResultSet = oPreparedStatement.executeQuery();
//            if (oResultSet.next()) {
//                oUsuarioBean.setId(oResultSet.getInt("id"));
//                oMetaBeanHelper = this.get(oUsuarioBean.getId(), 3);
//            } else {
//                throw new Exception("UsuarioDao getFromLoginAndPass error");
//            }
//        } catch (Exception ex) {
//            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
//            Log4jHelper.errorLog(msg, ex);
//            throw new Exception(msg, ex);
//        } finally {
//            if (oResultSet != null) {
//                oResultSet.close();
//            }
//            if (oPreparedStatement != null) {
//                oPreparedStatement.close();
//            }
//        }
//        return oMetaBeanHelper;
//    }
//
//    public Integer getIDfromUser(String strLogin) throws Exception {
//        Integer intResult = null;
//        Statement oStatement = null;
//        ResultSet oResultSet = null;
//        try {
//            oStatement = (Statement) oConnection.createStatement();
//            String strSQL = "SELECT id FROM usuario WHERE login ='" + strLogin + "'";
//            oResultSet = oStatement.executeQuery(strSQL);
//            if (oResultSet.next()) {
//                intResult = oResultSet.getInt("id");
//            } else {
//                return 0;
//            }
//        } catch (SQLException ex) {
//            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
//            Log4jHelper.errorLog(msg, ex);
//            throw new Exception(msg, ex);
//        } finally {
//            if (oResultSet != null) {
//                oResultSet.close();
//            }
//            if (oStatement != null) {
//                oStatement.close();
//            }
//        }
//        return intResult;
//    }
//
//    public Integer getIDfromCodigoGrupo(String strCode) throws Exception {
//        Integer intResult = null;
//        Statement oStatement = null;
//        ResultSet oResultSet = null;
//        try {
//            oStatement = (Statement) oConnection.createStatement();
//            String strSQL = "SELECT id FROM grupo WHERE codigo ='" + strCode + "'";
//            oResultSet = oStatement.executeQuery(strSQL);
//            if (oResultSet.next()) {
//                intResult = oResultSet.getInt("id");
//            } else {
//                return 0;
//            }
//        } catch (SQLException ex) {
//            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
//            Log4jHelper.errorLog(msg, ex);
//            throw new Exception(msg, ex);
//        } finally {
//            if (oResultSet != null) {
//                oResultSet.close();
//            }
//            if (oStatement != null) {
//                oStatement.close();
//            }
//        }
//        return intResult;
//    }
}
