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
package net.adisan.dao.specificimplementation.episodioprocedimiento;

import net.adisan.bean.genericimplementation.GenericBeanImplementation;
import net.adisan.bean.helper.MetaBeanHelper;
import net.adisan.bean.specificimplementation.CentrosanitarioSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.GrupoSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.UsuarioSpecificBeanImplementation;
import net.adisan.dao.genericimplementation.GenericDaoImplementation;
import java.sql.Connection;
import net.adisan.bean.specificimplementation.EpisodiodiagnosticoSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.EpisodioprocedimientoSpecificBeanImplementation;

public class Episodioprocedimiento4SpecificDaoImplementation extends GenericDaoImplementation {

    private Integer idCentrosanitario = null;
    private Integer idUsuario;

    public Episodioprocedimiento4SpecificDaoImplementation(Connection oPooledConnection, MetaBeanHelper oPuserBean_security, String strWhere) throws Exception {
        super("episodioprocedimiento", oPooledConnection, oPuserBean_security, strWhere);

        if (oPuserBean_security != null) {
            UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
            idUsuario = oUsuario.getId();
            if (oUsuario.getId() > 1) {
                String strSQLini = "";
                //como es un alumno, su centro sanitario es el de su profesor
                //idCentrosanitario = SecurityHelper.getCentroSanitarioFromUsuario(oPooledConnection, oPuserSecurity, idUsuario); // con esta línea obligas siempre a crear conexión aunque en el getallobjectsmetadata o haria falta
                GrupoSpecificBeanImplementation oGrupo = (GrupoSpecificBeanImplementation) oUsuario.getObj_grupo().getBean();
                UsuarioSpecificBeanImplementation oProfesor = (UsuarioSpecificBeanImplementation) oGrupo.getObj_usuario().getBean();
                CentrosanitarioSpecificBeanImplementation oCentroSanitario = (CentrosanitarioSpecificBeanImplementation) oProfesor.getObj_centrosanitario().getBean();
                idCentrosanitario = oCentroSanitario.getId();
                strSQLini = "FROM episodioprocedimiento where 1=1 "
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
        EpisodioprocedimientoSpecificBeanImplementation oEpisodioprocedimientoBean = (EpisodioprocedimientoSpecificBeanImplementation) oBean;
        if (oEpisodioprocedimientoBean.getId_usuario().equals(idUsuario)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean canDelete(GenericBeanImplementation oBean) throws Exception {
        EpisodioprocedimientoSpecificBeanImplementation oEpisodioprocedimientoBean = (EpisodioprocedimientoSpecificBeanImplementation) oBean;
        if (oEpisodioprocedimientoBean.getId_usuario().equals(idUsuario)) {
            if (oEpisodioprocedimientoBean.getLink_procedimiento() == 0
                    && oEpisodioprocedimientoBean.getLink_procedimientodiagnosticofinal() == 0
                    && oEpisodioprocedimientoBean.getLink_procedimientodiagnosticoinicial() == 0
                    && oEpisodioprocedimientoBean.getLink_procedimientomedico() == 0
                    && oEpisodioprocedimientoBean.getLink_procedimientopersonalsanitario() == 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public Integer create(GenericBeanImplementation oBean) throws Exception {
        EpisodioprocedimientoSpecificBeanImplementation oEpisodioprocedimientoBean = (EpisodioprocedimientoSpecificBeanImplementation) oBean;
        oEpisodioprocedimientoBean.setId_usuario(idUsuario);
        return super.create(oEpisodioprocedimientoBean);
    }

    @Override
    public Integer update(GenericBeanImplementation oBean) throws Exception {
        EpisodiodiagnosticoSpecificBeanImplementation oEpisodioDiagnosticoBean = (EpisodiodiagnosticoSpecificBeanImplementation) oBean;
        oEpisodioDiagnosticoBean.setId_usuario(idUsuario);
        return super.update(oEpisodioDiagnosticoBean);
    }

}