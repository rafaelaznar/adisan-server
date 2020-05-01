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

/**
 *
 * pendiente: falta el campo ingreso con subtabla periférica para la procedencia
 * del ingreso
 *
 */
@MetaObjectBeanInterface(
        TableName = "episodiodiagnostico",
        SingularDescription = "Diagnóstico codificado",
        PluralDescription = "Diagnósticos codificados",
        Icon = "fa fa-project-diagram",
        Type = EnumHelper.SourceType.Table
)
public class EpisodiodiagnosticoSpecificBeanImplementation extends GenericBeanImplementation {

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Orden",
            LongName = "Orden",
            Description = "Orden del diagnóstico",
            Type = EnumHelper.FieldType.Integer,
            Width = 1,
            IsVisible = true,
            IsRequired = true
    )
    private Integer orden;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Fecha",
            LongName = "Fecha diagnóstico",
            Description = "Fecha del diagnóstico",
            Type = EnumHelper.FieldType.Date,
            RegexHelp = "una fecha correcta",
            IsRequired = true,
            DefaultValue = "today",
            IsForeignKeyDescriptor = true
    )
    private Date fecha;

    @Expose(serialize = false)
    @MetaPropertyBeanInterface(
            Type = EnumHelper.FieldType.ForeignId
    )
    private Integer id_tipodiagnostico = null;

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Tipo",
            LongName = "Tipo diagnóstico",
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
    private Integer id_episodio = null;

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Episodio",
            LongName = "Episodio",
            Description = "Episodio del diagnóstico",
            Type = EnumHelper.FieldType.ForeignObject,
            IsRequired = true,
            IsVisible = false,
            References = "episodio",
            Width = 4
    )
    private MetaBeanHelper obj_episodio = null;

    @Expose(serialize = false)
    @MetaPropertyBeanInterface(
            Type = EnumHelper.FieldType.ForeignId
    )
    private Integer id_catalogodiagnosticos = null;

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Diagnostico",
            LongName = "Diagnóstico",
            Description = "Diagnóstico codificado",
            Type = EnumHelper.FieldType.ForeignObject,
            IsRequired = true,
            References = "catalogodiagnosticos",
            Width = 6
    )
    private MetaBeanHelper obj_catalogodiagnosticos = null;

    //-----------
    @Expose(serialize = false)
    @MetaPropertyBeanInterface(
            Type = EnumHelper.FieldType.ForeignId
    )
    private Integer id_presenciadiagnostico = null;

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "POD",
            LongName = "Presencia de Diagnóstico",
            Description = "Presencia de Diagnóstico",
            Type = EnumHelper.FieldType.ForeignObject,
            IsRequired = true,
            References = "presenciadiagnostico",
            Width = 4
    )
    private MetaBeanHelper obj_presenciadiagnostico = null;

    @Expose(serialize = false)
    @MetaPropertyBeanInterface(
            Type = EnumHelper.FieldType.ForeignId
    )
    private Integer id_presenciadiagnosticoingreso = null;

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "POA",
            LongName = "Presencia de Diagnóstico en ingreso",
            Description = "Presencia de Diagnóstico en ingreso",
            Type = EnumHelper.FieldType.ForeignObject,
            IsRequired = true,
            References = "presenciadiagnosticoingreso",
            Width = 4
    )
    private MetaBeanHelper obj_presenciadiagnosticoingreso = null;

     @Expose(serialize = false)
    @MetaPropertyBeanInterface(
            Type = EnumHelper.FieldType.ForeignId
    )
    private Integer id_usuario = 0;

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Usu.",
            LongName = "Usuario",
            Description = "Usuario del episodio",
            Type = EnumHelper.FieldType.ForeignObject,
            IsRequired = false,
            References = "usuario",
            Width = 4,
            IsVisible = false,
            IsFormVisible4 = false
    )
    private MetaBeanHelper obj_usuario = null;
    
    //-------------------------------
    //-------------------------------
    //-------------------------------
    public EpisodiodiagnosticoSpecificBeanImplementation() {
    }

    public EpisodiodiagnosticoSpecificBeanImplementation(Integer id) {
        this.id = id;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

    public Integer getId_episodio() {
        return id_episodio;
    }

    public void setId_episodio(Integer id_episodio) {
        this.id_episodio = id_episodio;
    }

    public MetaBeanHelper getObj_episodio() {
        return obj_episodio;
    }

    public void setObj_episodio(MetaBeanHelper obj_episodio) {
        this.obj_episodio = obj_episodio;
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

    public Integer getId_presenciadiagnostico() {
        return id_presenciadiagnostico;
    }

    public void setId_presenciadiagnostico(Integer id_presenciadiagnostico) {
        this.id_presenciadiagnostico = id_presenciadiagnostico;
    }

    public MetaBeanHelper getObj_presenciadiagnostico() {
        return obj_presenciadiagnostico;
    }

    public void setObj_presenciadiagnostico(MetaBeanHelper obj_presenciadiagnostico) {
        this.obj_presenciadiagnostico = obj_presenciadiagnostico;
    }

    public Integer getId_presenciadiagnosticoingreso() {
        return id_presenciadiagnosticoingreso;
    }

    public void setId_presenciadiagnosticoingreso(Integer id_presenciadiagnosticoingreso) {
        this.id_presenciadiagnosticoingreso = id_presenciadiagnosticoingreso;
    }

    public MetaBeanHelper getObj_presenciadiagnosticoingreso() {
        return obj_presenciadiagnosticoingreso;
    }

    public void setObj_presenciadiagnosticoingreso(MetaBeanHelper obj_presenciadiagnosticoingreso) {
        this.obj_presenciadiagnosticoingreso = obj_presenciadiagnosticoingreso;
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
