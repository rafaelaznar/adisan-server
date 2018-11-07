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
package net.adisan.dao.specificimplementation.centrosanitario.paciente;

import net.adisan.bean.genericimplementation.GenericBeanImplementation;
import net.adisan.bean.helper.MetaBeanHelper;
import net.adisan.bean.specificimplementation.CentrosanitarioSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.PacienteSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.TipousuarioSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.UsuarioSpecificBeanImplementation;
import net.adisan.dao.genericimplementation.GenericDaoImplementation;
import net.adisan.helper.Log4jHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Paciente3SpecificDaoImplementation extends GenericDaoImplementation {

    private Integer idUsuario;
    private Integer idCentrosanitario = null;

    public Paciente3SpecificDaoImplementation(Connection oPooledConnection, MetaBeanHelper oPuserBean_security, String strWhere) throws Exception {
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
    }

//    @Override
//    public boolean canGet(Integer id) throws Exception {
//        String strSQLini1 = "SELECT COUNT(*) FROM paciente where 1=1 "
//                + "AND (id_usuario IN (SELECT distinct id FROM usuario where id_centrosanitario = " + idCentrosanitario + " and id_tipousuario=3 ) "
//                + " OR  id_usuario IN (SELECT distinct id FROM usuario where id_centrosanitario = " + idCentrosanitario + " and id_tipousuario=5 ) "
//                + " OR  id_usuario IN (SELECT distinct u.id FROM usuario u, grupo g, usuario u2 "
//                + "                    WHERE u.id_tipousuario=4 "
//                + "                      AND u.id_grupo=g.id "
//                + "                      AND g.id_usuario=u2.id "
//                + "                      AND u2.id_centrosanitario= " + idCentrosanitario + ")"
//                + ") and id=" + id;
//        PreparedStatement oPreparedStatement = null;
//        ResultSet oResultSet = null;
//        Long iResult = 0L;
//        try {
//            oPreparedStatement = oConnection.prepareStatement(strSQLini1);
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
//        return iResult > 0;
//    }
    @Override
    public boolean canCreate(GenericBeanImplementation oBean) throws Exception {
        return true;
    }

    @Override
    public Integer create(GenericBeanImplementation oBean) throws Exception {
        PacienteSpecificBeanImplementation oPacienteBean = (PacienteSpecificBeanImplementation) oBean;
        oPacienteBean.setId_usuario(idUsuario);
        return super.create(oPacienteBean);
    }

    @Override
    public boolean canUpdate(GenericBeanImplementation oBean) throws Exception {
        return true;

    }

    @Override
    public Integer update(GenericBeanImplementation oBean) throws Exception {
        PacienteSpecificBeanImplementation oPacienteBean = (PacienteSpecificBeanImplementation) oBean;
        oPacienteBean.setId_usuario(idUsuario);
        return super.update(oPacienteBean);
    }

    @Override
    public boolean canDelete(GenericBeanImplementation oBean) throws Exception {
        PacienteSpecificBeanImplementation oPacienteBean = (PacienteSpecificBeanImplementation) oBean;
        if (oPacienteBean.getLink_episodio() > 0) {
            return false;
        } else {
            return true;
        }
    }

}
