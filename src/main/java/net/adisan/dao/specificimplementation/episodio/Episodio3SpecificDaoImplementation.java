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
package net.adisan.dao.specificimplementation.episodio;

import net.adisan.bean.genericimplementation.GenericBeanImplementation;
import net.adisan.bean.specificimplementation.EpisodioSpecificBeanImplementation;
import net.adisan.dao.genericimplementation.GenericDaoImplementation;
import java.sql.Connection;
import net.adisan.helper.SessionHelper;

public class Episodio3SpecificDaoImplementation extends GenericDaoImplementation {

    public Episodio3SpecificDaoImplementation(Connection oPooledConnection, String strWhere) throws Exception {
        super("episodio", oPooledConnection, strWhere);
        String strSQLini = "FROM episodio where  (id_episodio IS NULL OR id_episodio=0 OR id_episodio='') "
                + "AND (id_usuario IN (SELECT distinct id FROM usuario where id_centrosanitario = " + SessionHelper.getoCentroSanitarioBean().getId() + " and id_tipousuario=3 ) "
                + " OR  id_usuario IN (SELECT distinct id FROM usuario where id_centrosanitario = " + SessionHelper.getoCentroSanitarioBean().getId() + " and id_tipousuario=5 ) "
                + " OR  id_usuario IN (SELECT distinct u.id FROM usuario u, grupo g, usuario u2 "
                + "                    WHERE u.id_tipousuario=4 "
                + "                      AND u.id_grupo=g.id "
                + "                      AND g.id_usuario=u2.id "
                + "                      AND u2.id_centrosanitario= " + SessionHelper.getoCentroSanitarioBean().getId() + ")"
                + ") ";
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
        EpisodioSpecificBeanImplementation oEpisodioBean = (EpisodioSpecificBeanImplementation) oBean;
        if (esMiAlumno(oEpisodioBean.getId_usuario()) || oEpisodioBean.getId_usuario() == SessionHelper.getoUsuarioBean().getId()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean canUpdate(GenericBeanImplementation oBean) throws Exception {
        EpisodioSpecificBeanImplementation oNewEpisodio = (EpisodioSpecificBeanImplementation) oBean;
        //EpisodioSpecificBeanImplementation oOldEpisodio = (EpisodioSpecificBeanImplementation) this.get(oNewEpisodio.getId(), 0).getBean();
        if ((esMiAlumno(oNewEpisodio.getId_usuario()) || oNewEpisodio.getId_usuario() == SessionHelper.getoUsuarioBean().getId())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean canDelete(GenericBeanImplementation oBean) throws Exception {
        EpisodioSpecificBeanImplementation oEpisodioBean = (EpisodioSpecificBeanImplementation) oBean;
        if ((esMiAlumno(oEpisodioBean.getId_usuario())
                || oEpisodioBean.getId_usuario() == SessionHelper.getoUsuarioBean().getId())
                && oEpisodioBean.getLink_subepisodio() == 0
                && oEpisodioBean.getLink_episodiodiagnostico() == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Integer create(GenericBeanImplementation oBean) throws Exception {
        EpisodioSpecificBeanImplementation oEpisodioBean = (EpisodioSpecificBeanImplementation) oBean;
        oEpisodioBean.setId_episodio(null);
        return super.create(oEpisodioBean);
    }

}
