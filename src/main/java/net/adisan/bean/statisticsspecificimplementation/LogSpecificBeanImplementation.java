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
package net.adisan.bean.statisticsspecificimplementation;

import com.google.gson.annotations.Expose;
import net.adisan.bean.helper.MetaBeanHelper;
import net.adisan.bean.meta.publicinterface.MetaObjectBeanInterface;
import net.adisan.bean.meta.publicinterface.MetaPropertyBeanInterface;
import net.adisan.helper.EnumHelper;
import java.util.Calendar;
import java.util.Date;
import net.adisan.bean.genericimplementation.GenericBeanImplementation;
import net.adisan.helper.TimeHelper;

@MetaObjectBeanInterface(
        TableName = "log",
        SingularDescription = "Registro de usuarios",
        PluralDescription = "Registro de usuarios",
        Icon = "fa fa-eye",
        Type = EnumHelper.SourceType.Table
)
public class LogSpecificBeanImplementation extends GenericBeanImplementation {

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
            Width = 4,
            IsFormVisible4 = false
    )
    private MetaBeanHelper obj_usuario = null;

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Entidad",
            LongName = "Entidad",
            Description = "Entidad",
            Type = EnumHelper.FieldType.String,
            IsVisible = true
    )
    private String ob = null;

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Verbo",
            LongName = "Verbo",
            Description = "Verbo",
            Type = EnumHelper.FieldType.String,
            IsVisible = true
    )
    private String op = null;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Stamp",
            LongName = "Stamp",
            Description = "Stamp",
            Type = EnumHelper.FieldType.Datetime,
            RegexHelp = "una fecha correcta",
            IsRequired = true,
            DefaultValue = "today"
    )
    private Date stamp;

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Tiempo",
            LongName = "Tiempo",
            Description = "Tiempo",
            Type = EnumHelper.FieldType.Calculated,
            IsForeignKeyDescriptor = false,
            Width = 3,
            MaxLength = 100
    )
    private String tiempo;

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

    public String getOb() {
        return ob;
    }

    public void setOb(String ob) {
        this.ob = ob;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public Date getStamp() {
        return stamp;
    }

    public void setStamp(Date stamp) {
        this.stamp = stamp;
    }

    @Override
    public void ComputeCalculatedFields() {                
        this.tiempo = TimeHelper.getTimeDifference(this.stamp, new Date());
    }

}
