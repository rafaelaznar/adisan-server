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
        TableName = "catalogoprocedimientos",
        SingularDescription = "Procedimiento codificado del catálogo",
        PluralDescription = "Catálogo de procedimientos codificados",
        Icon = "fa fa-procedures",
        Type = EnumHelper.SourceType.Table,
        CreateDescription = "Añadir una codificación de procedimientos al catálogo"
)

public class CatalogoprocedimientosSpecificBeanImplementation extends GenericBeanImplementation {

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Código",
            LongName = "Código del procedimiento",
            Description = "Código del procedimiento",
            Type = EnumHelper.FieldType.String,
            IsRequired = true,
            RegexPattern = RegexConstants.capitalizedSentence,
            IsForeignKeyDescriptor = true           
    )
    private String codigo = "";

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Descripción",
            LongName = "Descripción del procedimiento",
            Description = "Descripcion del procedimiento",
            Type = EnumHelper.FieldType.String,
            IsRequired = true,
            RegexPattern = RegexConstants.capitalizedSentence,
            Clip = false,
            IsForeignKeyDescriptor = true
    )
    private String descripcion = "";

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Mujeres",
            LongName = "Sólo Mujeres",
            Description = "Sólo Mujeres",
            Type = EnumHelper.FieldType.Boolean,
            IsRequired = false,
            IsVisible = true
    )
    private Integer females_only;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Hombre",
            LongName = "Sólo Hombres",
            Description = "Sólo Hombres",
            Type = EnumHelper.FieldType.Boolean,
            IsRequired = false,
            IsVisible = true
    )
    private Integer males_only;

    //-----------------------------------------------------
    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Procedimientos",
            LongName = "Procedimientos del código",
            Description = "Procedimientos de este código",
            Type = EnumHelper.FieldType.Link,
            References = "procedimiento"
    )
    private Integer link_procedimiento = null;

    public CatalogoprocedimientosSpecificBeanImplementation() {
    }

    CatalogoprocedimientosSpecificBeanImplementation(Integer id) {
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

    public Integer getFemales_only() {
        return females_only;
    }

    public void setFemales_only(Integer females_only) {
        this.females_only = females_only;
    }

    public Integer getMales_only() {
        return males_only;
    }

    public void setMales_only(Integer males_only) {
        this.males_only = males_only;
    }

    public Integer getLink_procedimiento() {
        return link_procedimiento;
    }

    public void setLink_procedimiento(Integer link_procedimiento) {
        this.link_procedimiento = link_procedimiento;
    }

}
