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
package net.adisan.bean.specificimplementation;

import com.google.gson.annotations.Expose;
import net.adisan.bean.genericimplementation.GenericBeanImplementation;
import net.adisan.bean.meta.publicinterface.MetaObjectBeanInterface;
import net.adisan.bean.meta.publicinterface.MetaPropertyBeanInterface;
import net.adisan.helper.EnumHelper;
import net.adisan.helper.constant.RegexConstants;

@MetaObjectBeanInterface(
        TableName = "centrosanitario",
        SingularDescription = "Centro sanitario",
        PluralDescription = "Centros sanitarios",
        Icon = "fa fa-medkit",
        Type = EnumHelper.SourceType.Table,
        CreateDescription = "Añadir un Centro Sanitario a ADISAN"
)
public class CentrosanitarioSpecificBeanImplementation extends GenericBeanImplementation {

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Cto.Sanit.",
            LongName = "Centro Sanitario",
            Description = "Centro Sanitario",
            Type = EnumHelper.FieldType.String,
            IsRequired = true,
            RegexPattern = RegexConstants.capitalizedSentence,
            RegexHelp = RegexConstants.capitalizedSentence_Help,
            IsForeignKeyDescriptor = true
    )
    private String descripcion = "";

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Médicos",
            LongName = "Médicos en el centro sanitario",
            Description = "Médicos en el centro sanitario",
            Type = EnumHelper.FieldType.Link,
            References = "medico"
    )
    private Integer link_medico = null;

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Dependencias",
            LongName = "Dependencias en el centro sanitario",
            Description = "Dependencias en el centro sanitario",
            Type = EnumHelper.FieldType.Link,
            References = "dependencia"
    )
    private Integer link_dependencia = null;

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Usuarios",
            LongName = "Usuarios en el centro sanitario",
            Description = "Usuarios en el centro sanitario",
            Type = EnumHelper.FieldType.Link,
            References = "usuario"
    )
    private Integer link_usuario = null;

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Pacientes",
            LongName = "Pacientes en el centro sanitario",
            Description = "Pacientes en el centro sanitario",
            Type = EnumHelper.FieldType.Link,
            References = "paciente"
    )
    private Integer link_paciente = null;    

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Sanitarios",
            LongName = "Personal sanitario en el centro sanitario",
            Description = "Personal saniatrio en el centro sanitario",
            Type = EnumHelper.FieldType.Link,
            References = "personalsanitario"
    )
    private Integer link_personalsanitario = null;  
    
    public CentrosanitarioSpecificBeanImplementation() {
    }

    CentrosanitarioSpecificBeanImplementation(Integer id_centrosanitario) {
        id = id_centrosanitario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getLink_medico() {
        return link_medico;
    }

    public void setLink_medico(Integer link_medico) {
        this.link_medico = link_medico;
    }

    public Integer getLink_dependencia() {
        return link_dependencia;
    }

    public void setLink_dependencia(Integer link_dependencia) {
        this.link_dependencia = link_dependencia;
    }

    public Integer getLink_usuario() {
        return link_usuario;
    }

    public void setLink_usuario(Integer link_usuario) {
        this.link_usuario = link_usuario;
    }

    public Integer getLink_paciente() {
        return link_paciente;
    }

    public void setLink_paciente(Integer link_paciente) {
        this.link_paciente = link_paciente;
    }

    public Integer getLink_personalsanitario() {
        return link_personalsanitario;
    }

    public void setLink_personalsanitario(Integer link_personalsanitario) {
        this.link_personalsanitario = link_personalsanitario;
    }

}
