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
package eu.rafaelaznar.dao.specificimplementation.paciente;

import eu.rafaelaznar.bean.genericimplementation.TableGenericBeanImplementation;
import eu.rafaelaznar.bean.helper.MetaBeanHelper;
import eu.rafaelaznar.bean.specificimplementation.CentrosanitarioSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.GrupoSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.PacienteSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.TipousuarioSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.UsuarioSpecificBeanImplementation;
import eu.rafaelaznar.dao.genericimplementation.TableGenericDaoImplementation;
import java.sql.Connection;

public class Paciente4SpecificDaoImplementation extends TableGenericDaoImplementation {

    private Integer idCentrosanitario = 0;
    private Integer idUsuario = 0;

    public Paciente4SpecificDaoImplementation(Connection oPooledConnection, MetaBeanHelper oPuserBean_security, String strWhere) throws Exception {
        super("paciente", oPooledConnection, oPuserBean_security, strWhere);               
        if (oPuserBean_security != null) {
            UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
            idUsuario = oUsuario.getId();
            MetaBeanHelper ombhTipousuario = (MetaBeanHelper) oUsuario.getObj_tipousuario();
            TipousuarioSpecificBeanImplementation oTipousuario= (TipousuarioSpecificBeanImplementation) ombhTipousuario.getBean();
            if (oTipousuario.getId() == 4) {
                String strSQLini = "";
                GrupoSpecificBeanImplementation oGrupo = (GrupoSpecificBeanImplementation) oUsuario.getObj_grupo().getBean();
                UsuarioSpecificBeanImplementation oProfesor = (UsuarioSpecificBeanImplementation) oGrupo.getObj_usuario().getBean();
                CentrosanitarioSpecificBeanImplementation oCentroSanitario = (CentrosanitarioSpecificBeanImplementation) oProfesor.getObj_centrosanitario().getBean();
                idCentrosanitario = oCentroSanitario.getId();
                strSQLini = "FROM paciente where 1=1 "
                        + "AND (id_usuario IN (SELECT distinct id FROM usuario where id_centrosanitario = " + idCentrosanitario + " and id_tipousuario=3 ) "
                        + " OR  id_usuario IN (SELECT distinct id FROM usuario where id_centrosanitario = " + idCentrosanitario + " and id_tipousuario=5 ) "
                        + " OR  id_usuario IN (SELECT distinct u.id FROM usuario u, grupo g, usuario u2 "
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
            }
        }
        //MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
        //CentrosanitarioSpecificBeanImplementation oCentrosanitario = (CentrosanitarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
        //strSQL = "SELECT * FROM paciente p, usuario u WHERE p.id_usuario = u.id AND u.id_centrosanitario = " + idCentrosanitario;
    }

    @Override
    public Integer set(TableGenericBeanImplementation oBean) throws Exception {
        PacienteSpecificBeanImplementation oPacienteBean = (PacienteSpecificBeanImplementation) oBean;
        oPacienteBean.setId_usuario(idUsuario);
        return super.set(oPacienteBean);
    }

//    @Override
//    public Integer set(TableGenericBeanImplementation oBean) throws Exception {
//        PreparedStatement oPreparedStatement = null;
//        ResultSet oResultSet = null;
//        Integer iResult = 0;
//        Integer idResult = 0;
//        Boolean insert = true;
//        try {
//            if (oBean.getId() == null || oBean.getId() == 0) {
//                strSQL = "INSERT INTO " + ob;
//                strSQL += "(" + oBean.getColumns() + ")";
//                strSQL += " VALUES ";
//                strSQL += "(" + oBean.getValues() + ")";
//                oPreparedStatement = oConnection.prepareStatement(strSQL, Statement.RETURN_GENERATED_KEYS);
//                iResult = oPreparedStatement.executeUpdate();
//                oResultSet = oPreparedStatement.getGeneratedKeys();
//                oResultSet.next();
//                idResult = oResultSet.getInt(1);
//                strSQL = "UPDATE " + ob + " SET id_usuario=" + idUsuario + " WHERE id=" + idResult;
//                oPreparedStatement = oConnection.prepareStatement(strSQL, Statement.RETURN_GENERATED_KEYS);
//                oPreparedStatement.executeUpdate();
//
//            } else {
//                insert = false;
//                strSQL = "UPDATE " + ob + " p";
//                strSQL += " SET ";
//                strSQL += oBean.toPairs();
//                strSQL += " WHERE p.id = ? AND p.id_usuario = " + idUsuario;
//                oPreparedStatement = oConnection.prepareStatement(strSQL, Statement.RETURN_GENERATED_KEYS);
//                oPreparedStatement.setInt(1, oBean.getId());
//                iResult = oPreparedStatement.executeUpdate();
//            }
//            if (iResult < 1) {
//                String msg = this.getClass().getName() + ": set";
//                Log4jHelper.errorLog(msg);
//                throw new Exception(msg);
//            }
//        } catch (Exception ex) {
//            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
//            Log4jHelper.errorLog(msg, ex);
//            throw new Exception(msg, ex);
//        } finally {
//            if (insert) {
//                if (oResultSet != null) {
//                    oResultSet.close();
//                }
//            }
//            if (oPreparedStatement != null) {
//                oPreparedStatement.close();
//            }
//        }
//        return idResult;
//    }
//    @Override
//    public MetaBeanHelper get(int id, int intExpand) throws Exception {
//        PreparedStatement oPreparedStatement = null;
//        ResultSet oResultSet = null;
//        strSQL += " AND p.id=? ";
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
//    @Override
//    public Long getCount(ArrayList<FilterBeanHelper> alFilter) throws Exception {
//        strSQL = "SELECT count(*) FROM paciente p, usuario u WHERE p.id_usuario = u.id AND u.id_centrosanitario = " + idCentrosanitario;
//        PreparedStatement oPreparedStatement = null;
//        ResultSet oResultSet = null;
//        strSQL += SqlHelper.buildSqlFilter(alFilter);
//        Long iResult = 0L;
//        try {
//            oPreparedStatement = oConnection.prepareStatement(strSQL);
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
}