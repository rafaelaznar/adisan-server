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
import java.util.Date;

@MetaObjectBeanInterface(
        TableName = "personalsanitario",
        SingularDescription = "Personal sanitario",
        PluralDescription = "Personal sanitario",
        CreateDescription = "Añadir personal sanitario al centro sanitario",
        Icon = "fa fa-head-side-mask",
        Type = EnumHelper.SourceType.Table        
)
public class PersonalsanitarioSpecificBeanImplementation extends GenericBeanImplementation {

    @Expose(serialize = false)
    @MetaPropertyBeanInterface(
            Type = EnumHelper.FieldType.ForeignId
    )
    private Integer id_servicio = 0;

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Servicio",
            LongName = "Servicio",
            Description = "Servicio del sanitario",
            Type = EnumHelper.FieldType.ForeignObject,
            IsRequired = true,
            References = "servicio",
            Width = 4
    )
    private MetaBeanHelper obj_servicio = null;

    @Expose(serialize = false)
    @MetaPropertyBeanInterface(
            Type = EnumHelper.FieldType.ForeignId
    )
    private Integer id_especialidad = 0;

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Esp.",
            LongName = "Especialidad",
            Description = "Especialidad del sanitario",
            Type = EnumHelper.FieldType.ForeignObject,
            IsRequired = false,
            References = "especialidad",
            Width = 4
    )
    private MetaBeanHelper obj_especialidad = null;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Dni.",
            LongName = "Dni",
            Description = "Dni del sanitario",
            Type = EnumHelper.FieldType.String,
            IsRequired = true,
            RegexPattern = RegexConstants.dni,
            RegexHelp = RegexConstants.dni_Help,
            IsForeignKeyDescriptor = false,
            MaxLength = 50
    )
    private String dni;

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Nombre completo",
            LongName = "Nombre completo",
            Description = "Nombre completo del sanitario",
            Type = EnumHelper.FieldType.Calculated,
            IsForeignKeyDescriptor = true,
            Width = 3,
            MaxLength = 100
    )
    private String nombrecompleto;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Nombre",
            LongName = "Nombre",
            Description = "Nombre del sanitario",
            Type = EnumHelper.FieldType.String,
            IsRequired = true,
            RegexPattern = RegexConstants.capitalizedName,
            RegexHelp = RegexConstants.capitalizedName_Help,
            IsForeignKeyDescriptor = false,
            Width = 3,
            MaxLength = 100,
            IsVisible = false
    )
    private String nombre;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "1er. Ap.",
            LongName = "Primer Apellido",
            Description = "Primer Apellido del sanitario",
            Type = EnumHelper.FieldType.String,
            IsRequired = true,
            RegexPattern = RegexConstants.capitalizedName,
            RegexHelp = RegexConstants.capitalizedName_Help,
            IsForeignKeyDescriptor = false,
            Width = 3,
            MaxLength = 100,
            IsVisible = false
    )
    private String primer_apellido;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "2º Ap.",
            LongName = "Segundo Apellido",
            Description = "Segundo Apellido del sanitario",
            Type = EnumHelper.FieldType.String,
            IsRequired = true,
            RegexPattern = RegexConstants.capitalizedName,
            RegexHelp = RegexConstants.capitalizedName_Help,
            IsForeignKeyDescriptor = false,
            Width = 3,
            MaxLength = 100,
            IsVisible = false
    )
    private String segundo_apellido;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "F.Na",
            LongName = "Fecha de nacimiento",
            Description = "Fecha de nacimiento del sanitario",
            Type = EnumHelper.FieldType.Date,
            RegexHelp = "una fecha correcta",
            IsRequired = true,
            IsVisible = false
    )
    private Date fecha_nacimiento;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Nº Col.",
            LongName = "Número colegiado",
            Description = "Número colegiado del sanitario",
            Type = EnumHelper.FieldType.String,
            IsRequired = true,
            IsForeignKeyDescriptor = false,
            Width = 3,
            MaxLength = 100,
            IsVisible = false
    )
    private String num_colegiado;

    @Expose(serialize = false)
    @MetaPropertyBeanInterface(
            Type = EnumHelper.FieldType.ForeignId
    )
    private Integer id_categoriaprofesionalps = 0;

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Cat.",
            LongName = "Categoria profesional",
            Description = "Categoria profesional del sanitario",
            Type = EnumHelper.FieldType.ForeignObject,
            IsRequired = true,
            References = "categoriaprofesionalps",
            Width = 4
    )
    private MetaBeanHelper obj_categoriaprofesionalps = null;

    @Expose(serialize = false)
    @MetaPropertyBeanInterface(
            Type = EnumHelper.FieldType.ForeignId
    )
    private Integer id_centrosanitario = 0;

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Centr.",
            LongName = "Centro Sanitario",
            Description = "Centro sanitario del sanitario",
            Type = EnumHelper.FieldType.ForeignObject,
            IsRequired = true,
            References = "centrosanitario",
            Width = 4
    )
    private MetaBeanHelper obj_centrosanitario = null;

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Procedimientos",
            LongName = "Procedimientos",
            Description = "Procedimientos",
            Type = EnumHelper.FieldType.Link,
            References = "procedimientopersonalsanitario"
    )
    private Integer link_procedimientopersonalsanitario = null;

    public PersonalsanitarioSpecificBeanImplementation() {
    }

    public PersonalsanitarioSpecificBeanImplementation(Integer id) {
        this.id = id;
    }

    @Override
    public void ComputeCalculatedFields() {
        this.nombrecompleto = this.nombre + " " + this.primer_apellido + " " + this.segundo_apellido;
    }

    public Integer getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(Integer id_servicio) {
        this.id_servicio = id_servicio;
    }

    public MetaBeanHelper getObj_servicio() {
        return obj_servicio;
    }

    public void setObj_servicio(MetaBeanHelper obj_servicio) {
        this.obj_servicio = obj_servicio;
    }

    public Integer getId_especialidad() {
        return id_especialidad;
    }

    public void setId_especialidad(Integer id_especialidad) {
        this.id_especialidad = id_especialidad;
    }

    public MetaBeanHelper getObj_especialidad() {
        return obj_especialidad;
    }

    public void setObj_especialidad(MetaBeanHelper obj_especialidad) {
        this.obj_especialidad = obj_especialidad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombrecompleto() {
        return nombrecompleto;
    }

    public void setNombrecompleto(String nombrecompleto) {
        this.nombrecompleto = nombrecompleto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    public String getSegundo_apellido() {
        return segundo_apellido;
    }

    public void setSegundo_apellido(String segundo_apellido) {
        this.segundo_apellido = segundo_apellido;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getNum_colegiado() {
        return num_colegiado;
    }

    public void setNum_colegiado(String num_colegiado) {
        this.num_colegiado = num_colegiado;
    }

    public Integer getId_categoriaprofesionalps() {
        return id_categoriaprofesionalps;
    }

    public void setId_categoriaprofesionalps(Integer id_categoriaprofesionalps) {
        this.id_categoriaprofesionalps = id_categoriaprofesionalps;
    }

    public MetaBeanHelper getObj_categoriaprofesionalps() {
        return obj_categoriaprofesionalps;
    }

    public void setObj_categoriaprofesionalps(MetaBeanHelper obj_categoriaprofesionalps) {
        this.obj_categoriaprofesionalps = obj_categoriaprofesionalps;
    }

    public Integer getId_centrosanitario() {
        return id_centrosanitario;
    }

    public void setId_centrosanitario(Integer id_centrosanitario) {
        this.id_centrosanitario = id_centrosanitario;
    }

    public MetaBeanHelper getObj_centrosanitario() {
        return obj_centrosanitario;
    }

    public void setObj_centrosanitario(MetaBeanHelper obj_centrosanitario) {
        this.obj_centrosanitario = obj_centrosanitario;
    }

    public Integer getLink_procedimientopersonalsanitario() {
        return link_procedimientopersonalsanitario;
    }

    public void setLink_procedimientopersonalsanitario(Integer link_procedimientopersonalsanitario) {
        this.link_procedimientopersonalsanitario = link_procedimientopersonalsanitario;
    }

}
