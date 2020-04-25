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
package net.adisan.dao.specificimplementation.medico;

import net.adisan.bean.genericimplementation.GenericBeanImplementation;
import net.adisan.bean.helper.MetaBeanHelper;
import net.adisan.bean.specificimplementation.CentrosanitarioSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.MedicoSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.UsuarioSpecificBeanImplementation;
import net.adisan.dao.genericimplementation.GenericDaoImplementation;
import java.sql.Connection;


public class Medico3SpecificDaoImplementation extends GenericDaoImplementation {

    //private final Logger oLogger = (Logger) LogManager.getLogger(this.getClass().getName());
    private Integer idCentrosanitario = null;
    private Integer idUsuario;

    public Medico3SpecificDaoImplementation(Connection oPooledConnection, MetaBeanHelper oPuserBean_security, String strWhere) throws Exception {
        super("medico", oPooledConnection, oPuserBean_security, strWhere);

        if (oPuserBean_security != null) {
            UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
            idUsuario = oUsuario.getId();
            if (oUsuario.getId() > 1) {
                String strSQLini = "";

                CentrosanitarioSpecificBeanImplementation oCentroSanitario = (CentrosanitarioSpecificBeanImplementation) oUsuario.getObj_centrosanitario().getBean();
                idCentrosanitario = oCentroSanitario.getId();
                strSQLini = "FROM medico WHERE id_centrosanitario = " + idCentrosanitario + " ";

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
//        String strSQLini1 = "SELECT COUNT(*) FROM medico WHERE id_centrosanitario = " + idCentrosanitario + " "
//                + " and id=" + id;
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
    public boolean canUpdate(GenericBeanImplementation oBean) throws Exception {
        UsuarioSpecificBeanImplementation oSessionUser = (UsuarioSpecificBeanImplementation) oPuserSecurity.getBean();
        MedicoSpecificBeanImplementation oMedico = (MedicoSpecificBeanImplementation) oBean;
        if (oMedico.getId_centrosanitario().equals(oSessionUser.getId_centrosanitario())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean canDelete(GenericBeanImplementation oBean) throws Exception {
        return false;
    }

    @Override
    public Integer create(GenericBeanImplementation oBean) throws Exception {
        //se puede crear un medico en el centro sanitario del profesor
        UsuarioSpecificBeanImplementation oSessionUser = (UsuarioSpecificBeanImplementation) oPuserSecurity.getBean();
        MedicoSpecificBeanImplementation oNewMedico = (MedicoSpecificBeanImplementation) oBean;
        oNewMedico.setId_centrosanitario(oSessionUser.getId_centrosanitario());
        return super.create(oBean);
    }

    @Override
    public Integer update(GenericBeanImplementation oBean) throws Exception {
        UsuarioSpecificBeanImplementation oSessionUser = (UsuarioSpecificBeanImplementation) oPuserSecurity.getBean();
        MedicoSpecificBeanImplementation oNewMedico = (MedicoSpecificBeanImplementation) oBean;
        MedicoSpecificBeanImplementation oOldMedico = (MedicoSpecificBeanImplementation) this.get(oNewMedico.getId(), 0).getBean();
        if (oOldMedico.getId_centrosanitario().equals(oSessionUser.getId_centrosanitario())) {
            oNewMedico.setId_centrosanitario(oSessionUser.getId_centrosanitario());
            return super.update(oBean);
        } else {
            throw new Exception("No tienes permiso para efectuar la operación");
        }
    }

    @Override
    public Integer delete(GenericBeanImplementation oBean) throws Exception {
        //para borrar un medico que contacten con el administrador
        throw new Exception("No tienes permiso para efectuar la operación");
    }

}
