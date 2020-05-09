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
import net.adisan.bean.helper.MetaBeanHelper;
import net.adisan.bean.meta.publicinterface.MetaObjectBeanInterface;
import net.adisan.bean.meta.publicinterface.MetaPropertyBeanInterface;
import net.adisan.helper.EnumHelper;
import net.adisan.helper.constant.RegexConstants;

@MetaObjectBeanInterface(
        TableName = "procedimientomedico",
        SingularDescription = "Personal sanitario en procedimiento",
        PluralDescription = "Personal sanitario en procedimientos",
        CreateDescription = "Añadir personal sanitario al procedimiento",
        Icon = "fa fa-user-nurse",
        Type = EnumHelper.SourceType.Table
)
public class ProcedimientopersonalsanitarioSpecificBeanImplementation extends GenericBeanImplementation {


    @Expose(serialize = false)
    @MetaPropertyBeanInterface(
            Type = EnumHelper.FieldType.ForeignId
    )
    private Integer id_personalsanitario = null;

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Personal",
            LongName = "Personal sanitario",
            Description = "Personal sanitario",
            Type = EnumHelper.FieldType.ForeignObject,
            IsRequired = true,
            References = "personalsanitario",
            Width = 4
    )
    private MetaBeanHelper obj_personalsanitario = null;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Observaciones",
            LongName = "Observaciones",
            Description = "Observaciones",
            Type = EnumHelper.FieldType.LongText,
            //IsRequired = true,
            RegexPattern = RegexConstants.capitalizedSentence,
            RegexHelp = RegexConstants.capitalizedSentence_Help,
            IsForeignKeyDescriptor = false,
            Width = 3,
            MaxLength = 10000,
            IsVisible = true
    )
    private String observaciones;

    @Expose(serialize = false)
    @MetaPropertyBeanInterface(
            Type = EnumHelper.FieldType.ForeignId
    )
    private Integer id_usuario = null;

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Usuario",
            LongName = "Usuario",
            Description = "Usuario",
            Type = EnumHelper.FieldType.ForeignObject,
            IsRequired = true,
            References = "usuario",
            Width = 4
    )
    private MetaBeanHelper obj_usuario = null;

    @Expose(serialize = false)
    @MetaPropertyBeanInterface(
            Type = EnumHelper.FieldType.ForeignId
    )
    private Integer id_episodioprocedimiento = null;

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Procedimiento",
            LongName = "Procedimiento",
            Description = "Procedimiento",
            Type = EnumHelper.FieldType.ForeignObject,
            IsRequired = true,
            IsVisible = true,
            References = "episodioprocedimiento",
            Width = 4
    )
    private MetaBeanHelper obj_episodioprocedimiento = null;

    public ProcedimientopersonalsanitarioSpecificBeanImplementation() {
    }

    public ProcedimientopersonalsanitarioSpecificBeanImplementation(Integer id) {
        super(id);
    }

    public Integer getId_personalsanitario() {
        return id_personalsanitario;
    }

    public void setId_personalsanitario(Integer id_personalsanitario) {
        this.id_personalsanitario = id_personalsanitario;
    }

    public MetaBeanHelper getObj_personalsanitario() {
        return obj_personalsanitario;
    }

    public void setObj_personalsanitario(MetaBeanHelper obj_personalsanitario) {
        this.obj_personalsanitario = obj_personalsanitario;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public MetaBeanHelper getObj_usuario() {
        return obj_usuario;
    }

    public void setObj_usuario(MetaBeanHelper obj_usuario) {
        this.obj_usuario = obj_usuario;
    }

    public Integer getId_episodioprocedimiento() {
        return id_episodioprocedimiento;
    }

    public void setId_episodioprocedimiento(Integer id_episodioprocedimiento) {
        this.id_episodioprocedimiento = id_episodioprocedimiento;
    }

    public MetaBeanHelper getObj_episodioprocedimiento() {
        return obj_episodioprocedimiento;
    }

    public void setObj_episodioprocedimiento(MetaBeanHelper obj_episodioprocedimiento) {
        this.obj_episodioprocedimiento = obj_episodioprocedimiento;
    }

}
