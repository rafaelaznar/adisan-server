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
package net.adisan.bean.statisticsspecificimplementation;

import com.google.gson.annotations.Expose;
import net.adisan.bean.helper.MetaBeanHelper;
import net.adisan.bean.meta.publicinterface.MetaObjectBeanInterface;
import net.adisan.bean.meta.publicinterface.MetaPropertyBeanInterface;
import net.adisan.bean.publicinterface.BeanInterface;
import net.adisan.helper.EnumHelper;
import java.sql.Connection;
import java.sql.ResultSet;

@MetaObjectBeanInterface(
        TableName = "estadísticas",
        SingularDescription = "Estadísticas por centro sanitario",
        PluralDescription = "Estadísticas por centro sanitario",
        Icon = "fa fa-bar-chart",
        Type = EnumHelper.SourceType.Table
)
public class CentrosanitarioStatisticsSpecificBeanImplementation implements BeanInterface {

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Profesores",
            LongName = "Profesores del centro sanitario",
            Description = "Profesores del centro sanitario",
            Type = EnumHelper.FieldType.Integer,
            IsVisible = true
    )
    private Long profesores = null;

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Alumnos",
            LongName = "Alumnos del centro sanitario",
            Description = "Alumnos del centro sanitario",
            Type = EnumHelper.FieldType.Integer,
            IsVisible = true
    )
    private Long alumnos = null;

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Grupos",
            LongName = "Grupos del centro sanitario",
            Description = "Grupos del centro sanitario",
            Type = EnumHelper.FieldType.Integer,
            IsVisible = true
    )
    private Long grupos = null;

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Pacientes",
            LongName = "Pacientes del centro sanitario",
            Description = "Pacientes del centro sanitario",
            Type = EnumHelper.FieldType.Integer,
            IsVisible = true
    )
    private Long pacientes = null;

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Pacientes de profesores",
            LongName = "Pacientes de profesores del centro sanitario",
            Description = "Pacientes de profesores del centro sanitario",
            Type = EnumHelper.FieldType.Integer,
            IsVisible = true
    )
    private Long pacientesDeProfesores = null;

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Pacientes de alumnos",
            LongName = "Pacientes de alumnos del centro sanitario",
            Description = "Pacientes de alumnos del centro sanitario",
            Type = EnumHelper.FieldType.Integer,
            IsVisible = true
    )
    private Long pacientesDeAlumnos = null;
    
    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Episodios",
            LongName = "Episodios del centro sanitario",
            Description = "Episodios del centro sanitario",
            Type = EnumHelper.FieldType.Integer,
            IsVisible = true
    )
    private Long episodios = null;

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Episodios de pacientes de profesores",
            LongName = "Episodios de pacientes de profesores del centro sanitario",
            Description = "Episodios de pacientes de profesores del centro sanitario",
            Type = EnumHelper.FieldType.Integer,
            IsVisible = true
    )
    private Long episodiosDeProfesores = null;

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Episodios de pacientes de alumnos",
            LongName = "Episodios de pacientes de alumnos del centro sanitario",
            Description = "Episodios de pacientes de alumnos del centro sanitario",
            Type = EnumHelper.FieldType.Integer,
            IsVisible = true
    )
    private Long episodiosDeAlumnos = null;

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

    public Long getPacientes() {
        return pacientes;
    }

    public void setPacientes(Long pacientes) {
        this.pacientes = pacientes;
    }

    public Long getPacientesDeProfesores() {
        return pacientesDeProfesores;
    }

    public void setPacientesDeProfesores(Long pacientesDeProfesores) {
        this.pacientesDeProfesores = pacientesDeProfesores;
    }

    public Long getPacientesDeAlumnos() {
        return pacientesDeAlumnos;
    }

    public void setPacientesDeAlumnos(Long pacientesDeAlumnos) {
        this.pacientesDeAlumnos = pacientesDeAlumnos;
    }

    public Long getEpisodios() {
        return episodios;
    }

    public void setEpisodios(Long episodios) {
        this.episodios = episodios;
    }

    public Long getEpisodiosDeProfesores() {
        return episodiosDeProfesores;
    }

    public void setEpisodiosDeProfesores(Long episodiosDeProfesores) {
        this.episodiosDeProfesores = episodiosDeProfesores;
    }

    public Long getEpisodiosDeAlumnos() {
        return episodiosDeAlumnos;
    }

    public void setEpisodiosDeAlumnos(Long episodiosDeAlumnos) {
        this.episodiosDeAlumnos = episodiosDeAlumnos;
    }

}
