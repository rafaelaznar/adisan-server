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
package eu.rafaelaznar.dao.specificimplementation.medico;

import eu.rafaelaznar.bean.genericimplementation.TableGenericBeanImplementation;
import eu.rafaelaznar.bean.helper.MetaBeanHelper;
import eu.rafaelaznar.bean.specificimplementation.CentrosanitarioSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.MedicoSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.UsuarioSpecificBeanImplementation;
import eu.rafaelaznar.dao.genericimplementation.TableGenericDaoImplementation;
import java.sql.Connection;

public class Medico3SpecificDaoImplementation extends TableGenericDaoImplementation {

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

    @Override
    public boolean canUpdate(TableGenericBeanImplementation oBean) throws Exception {
        UsuarioSpecificBeanImplementation oSessionUser = (UsuarioSpecificBeanImplementation) oPuserSecurity.getBean();
        MedicoSpecificBeanImplementation oNewMedico = (MedicoSpecificBeanImplementation) oBean;
        MedicoSpecificBeanImplementation oOldMedico = (MedicoSpecificBeanImplementation) this.get(oNewMedico.getId(), 0).getBean();
        if (oOldMedico.getId_centrosanitario().equals(oSessionUser.getId_centrosanitario())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean canDelete(Integer id) throws Exception {
        return false;
    }

    @Override
    public Integer create(TableGenericBeanImplementation oBean) throws Exception {
        //se puede crear un medico en el centro sanitario del profesor
        UsuarioSpecificBeanImplementation oSessionUser = (UsuarioSpecificBeanImplementation) oPuserSecurity.getBean();
        MedicoSpecificBeanImplementation oNewMedico = (MedicoSpecificBeanImplementation) oBean;
        oNewMedico.setId_centrosanitario(oSessionUser.getId_centrosanitario());
        return super.create(oBean);
    }

    @Override
    public Integer update(TableGenericBeanImplementation oBean) throws Exception {
        UsuarioSpecificBeanImplementation oSessionUser = (UsuarioSpecificBeanImplementation) oPuserSecurity.getBean();
        MedicoSpecificBeanImplementation oNewMedico = (MedicoSpecificBeanImplementation) oBean;
        MedicoSpecificBeanImplementation oOldMedico = (MedicoSpecificBeanImplementation) this.get(oNewMedico.getId(), 0).getBean();
        if (oOldMedico.getId_centrosanitario().equals(oSessionUser.getId_centrosanitario())) {
            oNewMedico.setId_centrosanitario(oSessionUser.getId_centrosanitario());
            return super.update(oBean);
        } else {
            return 0;
        }
    }

    @Override
    public Integer delete(Integer id) throws Exception {
        //para borrar un medico que contacten con el administrador
        return 0;
    }

}
