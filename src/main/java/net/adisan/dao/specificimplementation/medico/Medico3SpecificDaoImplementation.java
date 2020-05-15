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
import net.adisan.bean.specificimplementation.MedicoSpecificBeanImplementation;
import net.adisan.dao.genericimplementation.GenericDaoImplementation;
import java.sql.Connection;
import net.adisan.bean.helper.MetaBeanHelper;
import net.adisan.helper.SessionHelper;

public class Medico3SpecificDaoImplementation extends GenericDaoImplementation {

    public Medico3SpecificDaoImplementation(Connection oPooledConnection, MetaBeanHelper oMBHUsuarioSession, String strWhere) throws Exception {
        super("medico", oPooledConnection, oMBHUsuarioSession, strWhere);
        String strSQLini = "FROM medico WHERE id_centrosanitario = " + SessionHelper.getoCentroSanitarioBean(oMBHUsuarioSession).getId() + " ";
        strSQL = "SELECT * " + strSQLini;
        strCountSQL = "SELECT COUNT(*) " + strSQLini;
        if (strWhere != null) {
            strSQL += " " + strWhere + " ";
            strCountSQL += " " + strWhere + " ";
        }
    }

    @Override
    public boolean canCreateObject() throws Exception {
        return true;
    }

    @Override
    public boolean canCreate(GenericBeanImplementation oBean) throws Exception {
        return true;
    }

    @Override
    public boolean canUpdate(GenericBeanImplementation oBean) throws Exception {
        MedicoSpecificBeanImplementation oMedico = (MedicoSpecificBeanImplementation) oBean;
        if (oMedico.getId_centrosanitario().equals(SessionHelper.getoCentroSanitarioBean(oMBHUsuarioSession).getId())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean canDelete(GenericBeanImplementation oBean) throws Exception {
        MedicoSpecificBeanImplementation oMedico = (MedicoSpecificBeanImplementation) oBean;
        if (oMedico.getLink_episodio() > 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Integer create(GenericBeanImplementation oBean) throws Exception {
        //se puede crear un medico en el centro sanitario del profesor        
        MedicoSpecificBeanImplementation oMedico = (MedicoSpecificBeanImplementation) oBean;
        oMedico.setId_centrosanitario(SessionHelper.getoCentroSanitarioBean(oMBHUsuarioSession).getId());
        return super.create(oMedico);
    }

    @Override
    public Integer update(GenericBeanImplementation oBean) throws Exception {
        MedicoSpecificBeanImplementation oMedico = (MedicoSpecificBeanImplementation) oBean;
        oMedico.setId_centrosanitario(SessionHelper.getoCentroSanitarioBean(oMBHUsuarioSession).getId());
        return super.update(oMedico);

    }

    @Override
    public Integer delete(GenericBeanImplementation oBean) throws Exception {
        MedicoSpecificBeanImplementation oMedico = (MedicoSpecificBeanImplementation) oBean;
        if (oMedico.getLink_episodio() > 0) {
            return super.delete(oBean);
        } else {
            throw new Exception("No tienes permiso para efectuar la operación");
        }
    }

}
