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
import java.util.Date;

@MetaObjectBeanInterface(
        TableName = "procedimiento",
        SingularDescription = "Codificación de procedimiento",
        PluralDescription = "Codificaciones de procedimiento",
        Icon = "fa fa-syringe",
        Type = EnumHelper.SourceType.Table,
        CreateDescription = "Añadir un item codificado al procedimiento del episodio"
)
public class ProcedimientoSpecificBeanImplementation extends GenericBeanImplementation {

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Fecha",
            LongName = "Fecha",
            Description = "Fecha del procedimiento",
            Type = EnumHelper.FieldType.Date,
            RegexHelp = "una fecha correcta",
            IsRequired = true,
            DefaultValue = "today",
            IsForeignKeyDescriptor = true
    )
    private Date fecha;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Orden",
            LongName = "Orden",
            Description = "Orden del procedimiento",
            Type = EnumHelper.FieldType.Integer,
            Width = 1,
            IsVisible = true,
            IsRequired = true
    )
    private Integer orden;

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
            References = "episodioprocedimiento",
            Width = 4
    )
    private MetaBeanHelper obj_episodioprocedimiento = null;

    @Expose(serialize = false)
    @MetaPropertyBeanInterface(
            Type = EnumHelper.FieldType.ForeignId
    )
    private Integer id_catalogoprocedimientos = null;

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Código",
            LongName = "Código Procedimiento",
            Description = "Procedimiento codificado",
            Type = EnumHelper.FieldType.ForeignObject,
            IsRequired = true,
            IsVisible = true,
            References = "catalogoprocedimientos",
            Width = 4
    )
    private MetaBeanHelper obj_catalogoprocedimientos = null;

    
    
    //----------------------------------------------------------
    //----------------------------------------------------------
    //-------------------------------
    //-------------------------------
    //-------------------------------
    public ProcedimientoSpecificBeanImplementation() {
    }

    public ProcedimientoSpecificBeanImplementation(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
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

    public Integer getId_catalogoprocedimientos() {
        return id_catalogoprocedimientos;
    }

    public void setId_catalogoprocedimientos(Integer id_catalogoprocedimientos) {
        this.id_catalogoprocedimientos = id_catalogoprocedimientos;
    }

    public MetaBeanHelper getObj_catalogoprocedimientos() {
        return obj_catalogoprocedimientos;
    }

    public void setObj_catalogoprocedimientos(MetaBeanHelper obj_catalogoprocedimientos) {
        this.obj_catalogoprocedimientos = obj_catalogoprocedimientos;
    }

}
