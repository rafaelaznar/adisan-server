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
package eu.rafaelaznar.bean.specificimplementation;

import com.google.gson.annotations.Expose;
import eu.rafaelaznar.bean.genericimplementation.GenericBeanImplementation;
import eu.rafaelaznar.bean.helper.MetaBeanHelper;
import eu.rafaelaznar.bean.meta.publicinterface.MetaObjectBeanInterface;
import eu.rafaelaznar.bean.meta.publicinterface.MetaPropertyBeanInterface;
import eu.rafaelaznar.bean.publicinterface.BeanInterface;
import eu.rafaelaznar.helper.EnumHelper;
import java.sql.Connection;
import java.sql.ResultSet;

@MetaObjectBeanInterface(
        TableName = "estadísticas",
        SingularDescription = "Estadísticas por centro sanitario",
        PluralDescription = "Estadísticas por centro sanitario",
        Icon = "fa fa-bar-chart",
        Type = EnumHelper.SourceType.Table
)
public class EstadisticaXCentrosanitarioSpecificBeanImplementation implements BeanInterface {

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Profesores",
            LongName = "Profesores",
            Description = "Profesores del centro sanitario",
            Type = EnumHelper.FieldType.Integer,
            IsVisible = true
    )
    private Long profesores = null;
    
    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Alumnos",
            LongName = "Alumnos",
            Description = "Alumnos del centro sanitario",
            Type = EnumHelper.FieldType.Integer,
            IsVisible = true
    )
    private Long alumnos = null;
    
    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Grupos",
            LongName = "Grupos",
            Description = "Grupos del centro sanitario",
            Type = EnumHelper.FieldType.Integer,
            IsVisible = true
    )
    private Long grupos = null;

    
    
    @Override
    public String getColumns() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getValues() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toPairs() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BeanInterface fill(ResultSet oResultSet, Connection oConnection, MetaBeanHelper oPuserBean_security, Integer expand) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ComputeCalculatedFields() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Long getProfesores() {
        return profesores;
    }

    public void setProfesores(Long profesores) {
        this.profesores = profesores;
    }

    public Long getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Long alumnos) {
        this.alumnos = alumnos;
    }

    public Long getGrupos() {
        return grupos;
    }

    public void setGrupos(Long grupos) {
        this.grupos = grupos;
    }



    
    
    
    
}
