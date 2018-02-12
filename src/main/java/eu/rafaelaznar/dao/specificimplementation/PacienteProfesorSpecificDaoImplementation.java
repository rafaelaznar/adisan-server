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
package eu.rafaelaznar.dao.specificimplementation;

import eu.rafaelaznar.bean.genericimplementation.TableGenericBeanImplementation;
import eu.rafaelaznar.bean.helper.MetaBeanHelper;
import eu.rafaelaznar.bean.specificimplementation.CentrosanitarioSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.PacienteSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.TipousuarioSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.UsuarioSpecificBeanImplementation;
import eu.rafaelaznar.dao.genericimplementation.TableGenericDaoImplementation;
import eu.rafaelaznar.helper.Log4jHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PacienteProfesorSpecificDaoImplementation extends TableGenericDaoImplementation {

    private Integer idUsuario;
    private Integer idCentrosanitario = null;

    public PacienteProfesorSpecificDaoImplementation(Connection oPooledConnection, MetaBeanHelper oPuserBean_security, String strWhere) throws Exception {
        super("paciente", oPooledConnection, oPuserBean_security, strWhere);
        if (oPuserBean_security != null) {
            UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
            idUsuario = oUsuario.getId();
            MetaBeanHelper ombhTipousuario = (MetaBeanHelper) oUsuario.getObj_tipousuario();
            TipousuarioSpecificBeanImplementation oTipousuario = (TipousuarioSpecificBeanImplementation) ombhTipousuario.getBean();
            if (oTipousuario.getId() == 3) {
                String strSQLini = "";

                CentrosanitarioSpecificBeanImplementation oCentroSanitario = (CentrosanitarioSpecificBeanImplementation) oUsuario.getObj_centrosanitario().getBean();
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

//        strSQL = "SELECT p.id, p.dni, p.nombre, p.primer_apellido, p.segundo_apellido, p.direccion, p.ciudad, p.codigo_postal, p.provincia, p.pais, p.email, p.telefono1, p.telefono2, p.nombre_padre, p.nombre_madre, p.fecha_nacimiento, p.ciudad_nacimiento, p.pais_nacimiento, p.sip_aseguradora, p.id_tipopago, p.id_sexo, p.id_usuario FROM paciente p, usuario u WHERE p.id_usuario = u.id AND u.id_centrosanitario = 1 UNION SELECT p.id, p.dni, p.nombre, p.primer_apellido, p.segundo_apellido, p.direccion, p.ciudad, p.codigo_postal, p.provincia, p.pais, p.email, p.telefono1, p.telefono2, p.nombre_padre, p.nombre_madre, p.fecha_nacimiento, p.ciudad_nacimiento, p.pais_nacimiento, p.sip_aseguradora, p.id_tipopago, p.id_sexo, p.id_usuario  FROM paciente p, usuario u, grupo g, usuario u2 WHERE p.id_usuario = u.id AND u.id_tipousuario=4 and u.id_grupo=g.id and g.id_usuario=u2.id and u2.id_centrosanitario= " + idCentrosanitario;        
//        strCountSQL = "SELECT COUNT(*) FROM paciente p, usuario u WHERE p.id_usuario = u.id AND u.id_centrosanitario = " + idCentrosanitario;
    }

    @Override
    public Integer set(TableGenericBeanImplementation oBean) throws Exception {
        PacienteSpecificBeanImplementation oPacienteBean = (PacienteSpecificBeanImplementation) oBean;
        oPacienteBean.setId_usuario(idUsuario);
        return super.set(oPacienteBean);
    }

    @Override
    public int remove(Integer id) throws Exception {
        String strSQLini1 = "SELECT COUNT(*) FROM paciente where 1=1 "
                + "AND (id_usuario IN (SELECT distinct id FROM usuario where id_centrosanitario = " + idCentrosanitario + " and id_tipousuario=3 ) "
                + " OR  id_usuario IN (SELECT distinct id FROM usuario where id_centrosanitario = " + idCentrosanitario + " and id_tipousuario=5 ) "
                + " OR  id_usuario IN (SELECT distinct u.id FROM usuario u, grupo g, usuario u2 "
                + "                    WHERE u.id_tipousuario=4 "
                + "                      AND u.id_grupo=g.id "
                + "                      AND g.id_usuario=u2.id "
                + "                      AND u2.id_centrosanitario= " + idCentrosanitario + ")"
                + ") and id=" + id;
        PreparedStatement oPreparedStatement = null;
        ResultSet oResultSet = null;
        Long iResult = 0L;
        try {
            oPreparedStatement = oConnection.prepareStatement(strSQLini1);
            oResultSet = oPreparedStatement.executeQuery();
            if (oResultSet.next()) {
                iResult = oResultSet.getLong("COUNT(*)");
            } else {
                String msg = this.getClass().getName() + ": getcount";
                Log4jHelper.errorLog(msg);
                throw new Exception(msg);
            }
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
            Log4jHelper.errorLog(msg, ex);
            throw new Exception(msg, ex);
        } finally {
            if (oResultSet != null) {
                oResultSet.close();
            }
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
        }
        if (iResult > 0) {
            return super.remove(id);
        } else {
            return 0;
        }
    }

//    @Override
//    public MetaBeanHelper get(int id, int intExpand) throws Exception {
//        PreparedStatement oPreparedStatement = null;
//        ResultSet oResultSet = null;
//
//        strSQL = "SELECT p.id, p.dni, p.nombre, p.primer_apellido, "
//                + "p.segundo_apellido, p.direccion, p.ciudad, p.codigo_postal, "
//                + "p.provincia, p.pais, p.email, p.telefono1, p.telefono2, "
//                + "p.nombre_padre, p.nombre_madre, p.fecha_nacimiento, "
//                + "p.ciudad_nacimiento, p.pais_nacimiento, p.sip_aseguradora, "
//                + "p.id_tipopago, p.id_sexo, p.id_usuario "
//                + "FROM paciente p, usuario u "
//                + "WHERE p.id_usuario = u.id AND u.id_centrosanitario = 1 "
//                + "AND p.id=" + id + " "
//                + "UNION "
//                + "SELECT p.id, p.dni, p.nombre, p.primer_apellido, "
//                + "p.segundo_apellido, p.direccion, p.ciudad, "
//                + "p.codigo_postal, p.provincia, p.pais, p.email, "
//                + "p.telefono1, p.telefono2, p.nombre_padre, p.nombre_madre, "
//                + "p.fecha_nacimiento, p.ciudad_nacimiento, p.pais_nacimiento, "
//                + "p.sip_aseguradora, p.id_tipopago, p.id_sexo, p.id_usuario  "
//                + "FROM paciente p, usuario u, grupo g, usuario u2 "
//                + "WHERE p.id_usuario = u.id AND u.id_tipousuario=4 and "
//                + "u.id_grupo=g.id and g.id_usuario=u2.id and "
//                + "u2.id_centrosanitario= " + idCentrosanitario
//                + " AND p.id=" + id;
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
//    public Integer set(TableGenericBeanImplementation oBean) throws Exception {
//        PreparedStatement oPreparedStatement = null;
//        ResultSet oResultSet = null;
//        Integer iResult = 0;
//        Integer idResult = 0;
//        Boolean insert = true;
//        PacienteSpecificBeanImplementation oPaciente = (PacienteSpecificBeanImplementation) oBean;
//        try {
//            if (oBean.getId() == null || oBean.getId() == 0) {
//                strSQL = "INSERT INTO " + ob;
//                strSQL += "(" + oBean.getColumns() + ")";
//                strSQL += " VALUES ";
//                strSQL += "(" + EncodingHelper.quotate(oPaciente.getDni()) + ",";
//                strSQL += EncodingHelper.quotate(oPaciente.getNombre()) + ",";
//                strSQL += EncodingHelper.quotate(oPaciente.getPrimer_apellido()) + ",";
//                strSQL += EncodingHelper.quotate(oPaciente.getSegundo_apellido()) + ",";
//                strSQL += EncodingHelper.quotate(oPaciente.getDireccion()) + ",";
//                strSQL += EncodingHelper.quotate(oPaciente.getCiudad()) + ",";
//                strSQL += EncodingHelper.quotate(oPaciente.getCodigo_postal()) + ",";
//                strSQL += EncodingHelper.quotate(oPaciente.getProvincia()) + ",";
//                strSQL += EncodingHelper.quotate(oPaciente.getPais()) + ",";
//                strSQL += EncodingHelper.quotate(oPaciente.getEmail()) + ",";
//                strSQL += EncodingHelper.quotate(oPaciente.getTelefono1()) + ",";
//                strSQL += EncodingHelper.quotate(oPaciente.getTelefono2()) + ",";
//                strSQL += EncodingHelper.quotate(oPaciente.getNombre_padre()) + ",";
//                strSQL += EncodingHelper.quotate(oPaciente.getNombre_madre()) + ",";
//                strSQL += EncodingHelper.stringifyAndQuotate(oPaciente.getFecha_nacimiento()) + ",";
//                strSQL += EncodingHelper.quotate(oPaciente.getCiudad_nacimiento()) + ",";
//                strSQL += EncodingHelper.quotate(oPaciente.getPais_nacimiento()) + ",";
//                strSQL += oPaciente.getSip_aseguradora() + ",";
//                strSQL += oPaciente.getId_tipopago() + ",";
//                strSQL += oPaciente.getId_sexo() + ",";
//                strSQL += idUsuario + ")";
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
//                strSQL += " WHERE g.id_usuario = " + idUsuario + " AND u.id_grupo = g.id AND u.id = p.id_usuario AND p.id = ?";
//                oPreparedStatement = oConnection.prepareStatement(strSQL, Statement.RETURN_GENERATED_KEYS);
//                oPreparedStatement.setInt(1, idUsuario);
//                oPreparedStatement.setInt(2, oBean.getId());
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
//    public Long getCount(ArrayList<FilterBeanHelper> alFilter) throws Exception {
//        strCountSQL = "SELECT COUNT(*) FROM paciente p, usuario u WHERE p.id_usuario = u.id AND u.id_centrosanitario = " + idCentrosanitario;
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
//    public MetaBeanHelper getPageX(int id_foreign, String ob_foreign, int intRegsPerPag, int intPage, LinkedHashMap<String, String> hmOrder, ArrayList<FilterBeanHelper> alFilter, int expand) throws Exception {
//        String strSQL1 = strSQL;
//        strSQL1 += " and p.id_" + ob_foreign + "=" + id_foreign + " ";
//        strSQL1 += SqlHelper.buildSqlFilter(alFilter);
//        strSQL1 += SqlHelper.buildSqlOrder(hmOrder);
//        strSQL1 += SqlHelper.buildSqlLimit(getCount(alFilter), intRegsPerPag, intPage);
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
//    @Override
//    public Long getCount(ArrayList<FilterBeanHelper> alFilter) throws Exception {
//        strCountSQL = "SELECT COUNT(*) FROM paciente p, usuario u WHERE p.id_usuario = u.id AND u.id_centrosanitario = " + idCentrosanitario;
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
}
