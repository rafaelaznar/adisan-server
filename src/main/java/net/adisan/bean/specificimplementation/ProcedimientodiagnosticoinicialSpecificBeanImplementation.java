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
import java.util.Date;
import net.adisan.bean.genericimplementation.GenericBeanImplementation;
import net.adisan.bean.helper.MetaBeanHelper;
import net.adisan.bean.meta.publicinterface.MetaObjectBeanInterface;
import net.adisan.bean.meta.publicinterface.MetaPropertyBeanInterface;
import net.adisan.helper.EnumHelper;

@MetaObjectBeanInterface(
        TableName = "procedimientodiagnosticoinicial",
        SingularDescription = "Diagnostico inicial",
        PluralDescription = "Diagnostico inicial",
        Icon = "fa fa-lungs",
        Type = EnumHelper.SourceType.Table,
        CreateDescription = "Añadir un item codificado de diagnóstico inicial al procedimiento"
)
public class ProcedimientodiagnosticoinicialSpecificBeanImplementation extends GenericBeanImplementation {

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Fecha",
            LongName = "Fecha de diagnóstico inicial",
            Description = "Fecha de diagnóstico inicial",
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
            IsFormVisible4 = false,
            Width = 4
    )
    private MetaBeanHelper obj_usuario = null;

    @Expose(serialize = false)
    @MetaPropertyBeanInterface(
            Type = EnumHelper.FieldType.ForeignId
    )
    private Integer id_tipodiagnostico = null;

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Tipo",
            LongName = "Tipo de diagnóstico",
            Description = "Tipo de diagnóstico",
            Type = EnumHelper.FieldType.ForeignObject,
            IsRequired = true,
            References = "tipodiagnostico",
            Width = 4
    )
    private MetaBeanHelper obj_tipodiagnostico = null;

    @Expose(serialize = false)
    @MetaPropertyBeanInterface(
            Type = EnumHelper.FieldType.ForeignId
    )
    private Integer id_catalogodiagnosticos = null;

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Diagnostico inicial",
            LongName = "Diagnóstico inicial codificado",
            Description = "Diagnóstico inicial codificado",
            Type = EnumHelper.FieldType.ForeignObject,
            IsRequired = true,
            References = "catalogodiagnosticos",
            Width = 4
    )
    private MetaBeanHelper obj_catalogodiagnosticos = null;

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

    public ProcedimientodiagnosticoinicialSpecificBeanImplementation() {
    }

    public ProcedimientodiagnosticoinicialSpecificBeanImplementation(Integer id) {
        super(id);
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

    public Integer getId_tipodiagnostico() {
        return id_tipodiagnostico;
    }

    public void setId_tipodiagnostico(Integer id_tipodiagnostico) {
        this.id_tipodiagnostico = id_tipodiagnostico;
    }

    public MetaBeanHelper getObj_tipodiagnostico() {
        return obj_tipodiagnostico;
    }

    public void setObj_tipodiagnostico(MetaBeanHelper obj_tipodiagnostico) {
        this.obj_tipodiagnostico = obj_tipodiagnostico;
    }

    public Integer getId_catalogodiagnosticos() {
        return id_catalogodiagnosticos;
    }

    public void setId_catalogodiagnosticos(Integer id_catalogodiagnosticos) {
        this.id_catalogodiagnosticos = id_catalogodiagnosticos;
    }

    public MetaBeanHelper getObj_catalogodiagnosticos() {
        return obj_catalogodiagnosticos;
    }

    public void setObj_catalogodiagnosticos(MetaBeanHelper obj_catalogodiagnosticos) {
        this.obj_catalogodiagnosticos = obj_catalogodiagnosticos;
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
