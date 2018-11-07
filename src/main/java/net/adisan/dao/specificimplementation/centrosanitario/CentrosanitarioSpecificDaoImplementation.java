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
package net.adisan.dao.specificimplementation.centrosanitario;

import net.adisan.bean.genericimplementation.GenericBeanImplementation;
import net.adisan.bean.helper.MetaBeanHelper;
import net.adisan.bean.statisticsspecificimplementation.CentrosanitarioStatisticsSpecificBeanImplementation;
import net.adisan.dao.genericimplementation.GenericDaoImplementation;
import net.adisan.factory.BeanFactory;
import java.sql.Connection;

public class CentrosanitarioSpecificDaoImplementation extends GenericDaoImplementation {

    public CentrosanitarioSpecificDaoImplementation(Connection oPooledConnection, MetaBeanHelper oPuserBean_security, String strWhere) throws Exception {
        super("centrosanitario", oPooledConnection, oPuserBean_security, strWhere);
    }

    @Override
    public boolean canStatistics(GenericBeanImplementation oBean) throws Exception {
        return true;
    }

    @Override
    public MetaBeanHelper getStatistics(int id) throws Exception {
        //El id es del centro sanitario
        CentrosanitarioStatisticsSpecificBeanImplementation oEstadistica = (CentrosanitarioStatisticsSpecificBeanImplementation) BeanFactory.getBean(ob + "statistics", oPuserSecurity);
        //obtener el numero de profesores del centro sanitario
        String countSQL1 = "select count(*) from usuario where id_tipousuario=3 and id_centrosanitario=" + id;
        oEstadistica.setProfesores(this.count(countSQL1));
        //alumnos de un centro sanitario
        countSQL1 = "select count(*) from usuario u, grupo g, usuario u2 WHERE u.id_tipousuario=4 AND u.id_grupo=g.id AND g.id_usuario=u2.id AND u2.id_centrosanitario=" + id;
        oEstadistica.setAlumnos(this.count(countSQL1));
        //grupos de un centro sanitario
        countSQL1 = "select count(*) from usuario u, grupo g WHERE u.id_tipousuario=3 AND u.id=g.id_usuario AND u.id_centrosanitario=" + id;
        oEstadistica.setGrupos(this.count(countSQL1));
        //-- pacientes de profesores del centro sanitario
        countSQL1 = "select count(*) from paciente p, usuario u where p.id_usuario = u.id and u.id_tipousuario=3 and u.id_centrosanitario=" + id;
        Long pacientesProfesores = this.count(countSQL1);
        oEstadistica.setPacientesDeProfesores(pacientesProfesores);
        //-- pacientes de alumnos del centro sanitario
        countSQL1 = "select count(*) from paciente p, usuario u, grupo g, usuario u2 where p.id_usuario = u.id and u.id_tipousuario=4 and u.id_grupo=g.id and g.id_usuario=u2.id and u2.id_tipousuario=3 and u2.id_centrosanitario=" + id;
        Long pacientesAlumnos = this.count(countSQL1);
        oEstadistica.setPacientesDeAlumnos(pacientesAlumnos);
        //-- pacientes totales del centro
        oEstadistica.setPacientes(pacientesProfesores + pacientesAlumnos);
        //--
        //-- episodios de profesores del centro sanitario
        countSQL1 = "select count(*) from episodio e, paciente p, usuario u where e.id_paciente=p.id and p.id_usuario = u.id and u.id_tipousuario=3 and u.id_centrosanitario=" + id;
        Long episodiosProfesores = this.count(countSQL1);
        oEstadistica.setEpisodiosDeProfesores(episodiosProfesores);
        //-- episodios de alumnos del centro sanitario
        countSQL1 = "select count(*) from episodio e, paciente p, usuario u, grupo g, usuario u2 where e.id_paciente=p.id and p.id_usuario = u.id and u.id_tipousuario=4 and u.id_grupo=g.id and g.id_usuario=u2.id and u2.id_tipousuario=3 and u2.id_centrosanitario=" + id;
        Long episodiosAlumnos = this.count(countSQL1);
        oEstadistica.setEpisodiosDeAlumnos(episodiosAlumnos);
        //-- episodios totales del centro
        oEstadistica.setEpisodios(episodiosProfesores + episodiosAlumnos);
        //---
        MetaBeanHelper oMetaBeanHelper = new MetaBeanHelper();
        oMetaBeanHelper.setBean(oEstadistica);
        oMetaBeanHelper.setMetaObject(this.getObjectMetaData(ob + "statistics"));
        oMetaBeanHelper.setMetaProperties(this.getPropertiesMetaData(ob + "statistics"));
        return oMetaBeanHelper;
    }

}
