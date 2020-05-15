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
import net.adisan.constant.RegexConstants;

@MetaObjectBeanInterface(
        TableName = "presenciadiagnosticoingreso",
        SingularDescription = "Presencia de diagnóstico en el ingreso",
        PluralDescription = "Presencia de diagnósticos en el ingreso",
        Icon = "fa fa-door-open",
        Type = EnumHelper.SourceType.Table,
        CreateDescription = "Añadir un código de presencia de diagnóstico a ADISAN"
)

public class PresenciadiagnosticoingresoSpecificBeanImplementation extends GenericBeanImplementation {

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "POA",
            LongName = "Código POA",
            Description = "Código de la presencia del diagnóstico en ingreso",
            Type = EnumHelper.FieldType.String,
            IsRequired = true,
            RegexPattern = RegexConstants.capitalizedSentence,
            IsForeignKeyDescriptor = true
    )
    private String codigo = "";    
    
    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Desc POA",
            LongName = "Descripcion PA",
            Description = "Descripcion de la presencia del diagnóstico en el ingreso",
            Type = EnumHelper.FieldType.String,
            IsRequired = true,
            RegexPattern = RegexConstants.capitalizedSentence,
            IsForeignKeyDescriptor = false
    )
    private String descripcion = "";

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Diagnósticos",
            LongName = "Diagnósticos",
            Description = "Diagnósticos de este POA",
            Type = EnumHelper.FieldType.Link,
            References = "episodiodiagnostico"
    )
    private Integer link_episodiodiagnostico = null;

    public PresenciadiagnosticoingresoSpecificBeanImplementation() {
    }

    PresenciadiagnosticoingresoSpecificBeanImplementation(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getLink_episodiodiagnostico() {
        return link_episodiodiagnostico;
    }

    public void setLink_episodiodiagnostico(Integer link_episodiodiagnostico) {
        this.link_episodiodiagnostico = link_episodiodiagnostico;
    }







}
