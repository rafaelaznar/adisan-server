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
package eu.rafaelaznar.dao.specificimplementation.estadistica;

import eu.rafaelaznar.bean.genericimplementation.GenericBeanImplementation;
import eu.rafaelaznar.bean.helper.FilterBeanHelper;
import eu.rafaelaznar.bean.helper.MetaBeanHelper;
import eu.rafaelaznar.bean.specificimplementation.EstadisticaXCentrosanitarioSpecificBeanImplementation;
import eu.rafaelaznar.dao.genericimplementation.GenericDaoImplementation;
import eu.rafaelaznar.factory.BeanFactory;
import eu.rafaelaznar.helper.Log4jHelper;
import eu.rafaelaznar.helper.TraceHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Estadistica0XCentrosanitarioSpecificDaoImplementation extends GenericDaoImplementation {

    public Estadistica0XCentrosanitarioSpecificDaoImplementation(Connection oPooledConnection, MetaBeanHelper oPuserBean_security, String strWhere) throws Exception {
        super("estadistica", oPooledConnection, oPuserBean_security, strWhere);
    }

    private Long count(String strCountSQL) throws Exception {
        PreparedStatement oPreparedStatement = null;
        ResultSet oResultSet = null;
        Long iResult = 0L;
        try {
            oPreparedStatement = oConnection.prepareStatement(strCountSQL);
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
            TraceHelper.trace("count-Estadistica0SpecificDaoImplementation(end):object=" + ob);
        }
        return iResult;
    }

    @Override
    public MetaBeanHelper get(int id, int intExpand) throws Exception {
        //El id es del centro sanitario
        EstadisticaXCentrosanitarioSpecificBeanImplementation oEstadistica = (EstadisticaXCentrosanitarioSpecificBeanImplementation) BeanFactory.getBean(ob, oPuserSecurity);
        //obtener el numero de prfesores del centro sanitario
        String countSQL1 = "select count(*) from usuario where id_tipousuario=3 and u.id_centrosanitario=" + id;
        oEstadistica.setProfesores(this.count(countSQL1));
        //alumnos de un centro sanitario
        countSQL1 = "select count(*) from usuario u, grupo g, usuario u2 WHERE u.id_tipousuario=4 AND u.id_grupo=g.id AND g.id_usuario=u2.id AND u2.id_centrosanitario=" + id;
        oEstadistica.setAlumnos(this.count(countSQL1));
        //alumnos de un centro sanitario
        countSQL1 = "select count(*) from usuario u, grupo g WHERE u.id_tipousuario=3 AND u.id=g.id_usuario AND u.id_centrosanitario=" + id;
        oEstadistica.setGrupos(this.count(countSQL1));

        MetaBeanHelper oMetaBeanHelper = new MetaBeanHelper();
        oMetaBeanHelper.setBean(oEstadistica);
        oMetaBeanHelper.setMetaObject(this.getObjectMetaData());
        oMetaBeanHelper.setMetaProperties(this.getPropertiesMetaData());
        return oMetaBeanHelper;
    }

    @Override
    public Long getCount(ArrayList<FilterBeanHelper> alFilter) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MetaBeanHelper getPage(int intRegsPerPag, int intPage, LinkedHashMap<String, String> hmOrder, ArrayList<FilterBeanHelper> alFilter, int expand) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MetaBeanHelper getPageX(int id_foreign, String ob_foreign, int intRegsPerPag, int intPage, LinkedHashMap<String, String> hmOrder, ArrayList<FilterBeanHelper> alFilter, int expand) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Long getCountX(int id_foreign, String ob_foreign, ArrayList<FilterBeanHelper> alFilter) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean canCreate(GenericBeanImplementation oBean) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean canUpdate(GenericBeanImplementation oBean) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean canDelete(GenericBeanImplementation oBean) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer create(GenericBeanImplementation oBean) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer update(GenericBeanImplementation oBean) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer delete(GenericBeanImplementation oBean) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
