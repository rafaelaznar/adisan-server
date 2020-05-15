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
import net.adisan.constant.RegexConstants;

@MetaObjectBeanInterface(
        TableName = "procedimientomedico",
        SingularDescription = "Médico en procedimiento",
        PluralDescription = "Médicos en procedimientos",
        Icon = "fa fa-stethoscope",
        Type = EnumHelper.SourceType.Table,
        CreateDescription = "Añadir un médico al procedimiento"
)
public class ProcedimientomedicoSpecificBeanImplementation extends GenericBeanImplementation {

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
            References = "episodioprocedimiento",
            Width = 4,
            IsVisible = true
    )
    private MetaBeanHelper obj_episodioprocedimiento = null;

    @Expose(serialize = false)
    @MetaPropertyBeanInterface(
            Type = EnumHelper.FieldType.ForeignId
    )
    private Integer id_medico = null;

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Médico",
            LongName = "Médico",
            Description = "Médico",
            Type = EnumHelper.FieldType.ForeignObject,
            IsRequired = true,
            References = "medico",
            Width = 4,
            IsVisible = true
    )
    private MetaBeanHelper obj_medico = null;

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

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "¿Responsable?",
            LongName = "¿Es el/la Responsable?",
            Description = "¿Es Responsable del procedimiento?",
            Type = EnumHelper.FieldType.Boolean,
            IsRequired = true,
            IsVisible = true
    )
    private Integer responsable;

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
            IsFormVisible4 = false,
            Width = 4
    )
    private MetaBeanHelper obj_usuario = null;

    public ProcedimientomedicoSpecificBeanImplementation() {
    }

    public ProcedimientomedicoSpecificBeanImplementation(Integer id) {
        super(id);
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

    public Integer getId_medico() {
        return id_medico;
    }

    public void setId_medico(Integer id_medico) {
        this.id_medico = id_medico;
    }

    public MetaBeanHelper getObj_medico() {
        return obj_medico;
    }

    public void setObj_medico(MetaBeanHelper obj_medico) {
        this.obj_medico = obj_medico;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Integer getResponsable() {
        return responsable;
    }

    public void setResponsable(Integer responsable) {
        this.responsable = responsable;
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

}
