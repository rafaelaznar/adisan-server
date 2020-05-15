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
import java.sql.Connection;
import net.adisan.bean.genericimplementation.GenericBeanImplementation;
import net.adisan.bean.helper.MetaBeanHelper;
import net.adisan.bean.meta.publicinterface.MetaObjectBeanInterface;
import net.adisan.bean.meta.publicinterface.MetaPropertyBeanInterface;
import net.adisan.helper.EnumHelper;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.adisan.dao.genericimplementation.GenericDaoImplementation;
import net.adisan.factory.DaoFactory;
import net.adisan.constant.RegexConstants;

@MetaObjectBeanInterface(
        TableName = "episodioprocedimiento",
        SingularDescription = "Procedimiento de episodio",
        PluralDescription = "Procedimientos de episodio",
        Icon = "fa fa-user-injured",
        Type = EnumHelper.SourceType.Table,
        CreateDescription = "Añadir un procedimiento al episodio"
)
public class EpisodioprocedimientoSpecificBeanImplementation extends GenericBeanImplementation {

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Registro",
            LongName = "Fecha registro",
            Description = "Fecha de registro del procedimiento",
            Type = EnumHelper.FieldType.Date,
            RegexHelp = "una fecha correcta",
            IsRequired = true,
            DefaultValue = "today"
    )
    private Date fecha_registro;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Inicio",
            LongName = "Fecha inicio",
            Description = "Fecha de inicio del procedimiento",
            Type = EnumHelper.FieldType.Date,
            RegexHelp = "una fecha correcta",
            IsRequired = true,
            DefaultValue = "today",
            IsForeignKeyDescriptor = true
    )
    private Date fecha_inicio;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Fecha fin",
            LongName = "Fecha de fin",
            Description = "Fecha de fin del procedimiento",
            Type = EnumHelper.FieldType.Date,
            RegexHelp = "una fecha correcta",
            IsRequired = false
    )
    private Date fecha_fin;

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

    //----------------------------------------------------------
    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Paciente",
            LongName = "Paciente",
            Description = "Paciente",
            Type = EnumHelper.FieldType.Calculated,
            IsForeignKeyDescriptor = true,
            Width = 3,
            IsVisible = true,
            MaxLength = 100
    )
    private String paciente;

    @Expose(serialize = false)
    @MetaPropertyBeanInterface(
            Type = EnumHelper.FieldType.ForeignId
    )
    private Integer id_episodio = null;

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Episodio",
            LongName = "Episodio",
            Description = "Episodio",
            Type = EnumHelper.FieldType.ForeignObject,
            IsRequired = true,
            References = "episodio",
            IsVisible = true,
            Width = 4
    )
    private MetaBeanHelper obj_episodio = null;

    //----------------------------------------------------------
    @Expose(serialize = false)
    @MetaPropertyBeanInterface(
            Type = EnumHelper.FieldType.ForeignId
    )
    private Integer id_dependencia = null;

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Dependencia",
            LongName = "Dependencia",
            Description = "Dependencia del centro sanitario",
            Type = EnumHelper.FieldType.ForeignObject,
            IsRequired = true,
            References = "dependencia",
            IsVisible = true,
            Width = 4
    )
    private MetaBeanHelper obj_dependencia = null;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Informe",
            LongName = "Informe",
            Description = "Informe",
            Type = EnumHelper.FieldType.LongText,
            //IsRequired = true,
            RegexPattern = RegexConstants.capitalizedSentence,
            RegexHelp = RegexConstants.capitalizedSentence_Help,
            IsForeignKeyDescriptor = false,
            Width = 3,
            MaxLength = 10000,
            IsVisible = false
    )
    private String informe;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Previsto",
            LongName = "Procedimiento previsto",
            Description = "Procedimiento previsto",
            Type = EnumHelper.FieldType.LongText,
            IsRequired = true,
            RegexPattern = RegexConstants.capitalizedSentence,
            RegexHelp = RegexConstants.capitalizedSentence_Help,
            IsForeignKeyDescriptor = true,
            Width = 3,
            MaxLength = 10000,
            IsVisible = false
    )
    private String procedimiento_previsto;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Realizado",
            LongName = "Procedimiento realizado",
            Description = "Procedimiento realizado",
            Type = EnumHelper.FieldType.LongText,
            //IsRequired = true,
            RegexPattern = RegexConstants.capitalizedSentence,
            RegexHelp = RegexConstants.capitalizedSentence_Help,
            IsForeignKeyDescriptor = false,
            Width = 3,
            MaxLength = 10000,
            IsVisible = false
    )
    private String procedimiento_realizado;

    @Expose(serialize = false)
    @MetaPropertyBeanInterface(
            Type = EnumHelper.FieldType.ForeignId
    )
    private Integer id_prioridad = null;

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Prioridad",
            LongName = "Prioridad",
            Description = "Prioridad del diagnóstico",
            Type = EnumHelper.FieldType.ForeignObject,
            IsRequired = true,
            IsVisible = true,
            References = "prioridad",
            Width = 4
    )
    private MetaBeanHelper obj_prioridad = null;

    @Expose(serialize = false)
    @MetaPropertyBeanInterface(
            Type = EnumHelper.FieldType.ForeignId
    )
    private Integer id_tipoprocedimiento = null;

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Tipo",
            LongName = "Tipo de procedimiento",
            Description = "Tipo de procedimiento",
            Type = EnumHelper.FieldType.ForeignObject,
            IsRequired = true,
            References = "tipoprocedimiento",
            Width = 6
    )
    private MetaBeanHelper obj_tipoprocedimiento = null;

    //----------------------------------------------------------
    @Expose(serialize = false)
    @MetaPropertyBeanInterface(
            Type = EnumHelper.FieldType.ForeignId
    )
    private Integer id_estado = null;

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Estado",
            LongName = "Estado",
            Description = "Estado del procedimiento",
            Type = EnumHelper.FieldType.ForeignObject,
            IsRequired = true,
            References = "estado",
            Width = 4
    )
    private MetaBeanHelper obj_estado = null;

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
    //----------------------------------------------------------
    //----------------------------------------------------------

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Codificación",
            LongName = "Procedimiento codificado",
            Description = "Codificaciones de este procedimiento",
            Type = EnumHelper.FieldType.Link,
            References = "procedimiento"
    )
    private Integer link_procedimiento = null;

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Medicos",
            LongName = "Médicos del procedimiento",
            Description = "Procedimientos de este procedimiento",
            Type = EnumHelper.FieldType.Link,
            References = "procedimientomedico"
    )
    private Integer link_procedimientomedico = null;

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "D.Inicial",
            LongName = "Diagnóstico inicial",
            Description = "Diagnóstico inicial",
            Type = EnumHelper.FieldType.Link,
            References = "procedimientodiagnosticoinicial"
    )
    private Integer link_procedimientodiagnosticoinicial = null;

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "D.Final",
            LongName = "Diagnóstico final",
            Description = "Diagnóstico final",
            Type = EnumHelper.FieldType.Link,
            References = "procedimientodiagnosticofinal"
    )
    private Integer link_procedimientodiagnosticofinal = null;

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Sanitarios",
            LongName = "Personal sanitario",
            Description = "Personal sanitario",
            Type = EnumHelper.FieldType.Link,
            References = "procedimientopersonalsanitario"
    )
    private Integer link_procedimientopersonalsanitario = null;

    //-------------------------------
    //-------------------------------
    //-------------------------------
    public EpisodioprocedimientoSpecificBeanImplementation() {
    }

    public EpisodioprocedimientoSpecificBeanImplementation(Integer id) {
        this.id = id;
    }

    @Override
    public void ComputeCalculatedFields(Connection oConnection, MetaBeanHelper oUsuarioSession) {
        try {
            if (this.obj_episodio != null) {
                EpisodioSpecificBeanImplementation oEpisodioBean = (EpisodioSpecificBeanImplementation) this.obj_episodio.getBean();
                if (oEpisodioBean.getId_paciente() != null) {
                    GenericDaoImplementation oPacienteDao;
                    oPacienteDao = (GenericDaoImplementation) DaoFactory.getDao("paciente", oConnection, oUsuarioSession, "");
                    PacienteSpecificBeanImplementation oPacienteBean = (PacienteSpecificBeanImplementation) oPacienteDao.get(oEpisodioBean.getId_paciente(), 0).getBean();
                    //PacienteSpecificBeanImplementation oPacienteBean = (PacienteSpecificBeanImplementation) oEpisodioBean.getObj_paciente().getBean();
                    this.paciente = oPacienteBean.getNombrecompleto() + " (" + oPacienteBean.getId() + ") ";
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(EpisodiodiagnosticoSpecificBeanImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
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

    public Integer getId_dependencia() {
        return id_dependencia;
    }

    public void setId_dependencia(Integer id_dependencia) {
        this.id_dependencia = id_dependencia;
    }

    public MetaBeanHelper getObj_dependencia() {
        return obj_dependencia;
    }

    public void setObj_dependencia(MetaBeanHelper obj_dependencia) {
        this.obj_dependencia = obj_dependencia;
    }

    public String getInforme() {
        return informe;
    }

    public void setInforme(String informe) {
        this.informe = informe;
    }

    public String getProcedimiento_previsto() {
        return procedimiento_previsto;
    }

    public void setProcedimiento_previsto(String procedimiento_previsto) {
        this.procedimiento_previsto = procedimiento_previsto;
    }

    public String getProcedimiento_realizado() {
        return procedimiento_realizado;
    }

    public void setProcedimiento_realizado(String procedimiento_realizado) {
        this.procedimiento_realizado = procedimiento_realizado;
    }

    public Integer getId_prioridad() {
        return id_prioridad;
    }

    public void setId_prioridad(Integer id_prioridad) {
        this.id_prioridad = id_prioridad;
    }

    public MetaBeanHelper getObj_prioridad() {
        return obj_prioridad;
    }

    public void setObj_prioridad(MetaBeanHelper obj_prioridad) {
        this.obj_prioridad = obj_prioridad;
    }

    public Integer getId_tipoprocedimiento() {
        return id_tipoprocedimiento;
    }

    public void setId_tipoprocedimiento(Integer id_tipoprocedimiento) {
        this.id_tipoprocedimiento = id_tipoprocedimiento;
    }

    public MetaBeanHelper getObj_tipoprocedimiento() {
        return obj_tipoprocedimiento;
    }

    public void setObj_tipoprocedimiento(MetaBeanHelper obj_tipoprocedimiento) {
        this.obj_tipoprocedimiento = obj_tipoprocedimiento;
    }

    public Integer getId_estado() {
        return id_estado;
    }

    public void setId_estado(Integer id_estado) {
        this.id_estado = id_estado;
    }

    public MetaBeanHelper getObj_estado() {
        return obj_estado;
    }

    public void setObj_estado(MetaBeanHelper obj_estado) {
        this.obj_estado = obj_estado;
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

    public Integer getLink_procedimientomedico() {
        return link_procedimientomedico;
    }

    public void setLink_procedimientomedico(Integer link_procedimientomedico) {
        this.link_procedimientomedico = link_procedimientomedico;
    }

    public Integer getLink_procedimientodiagnosticoinicial() {
        return link_procedimientodiagnosticoinicial;
    }

    public void setLink_procedimientodiagnosticoinicial(Integer link_procedimientodiagnosticoinicial) {
        this.link_procedimientodiagnosticoinicial = link_procedimientodiagnosticoinicial;
    }

    public Integer getLink_procedimientodiagnosticofinal() {
        return link_procedimientodiagnosticofinal;
    }

    public void setLink_procedimientodiagnosticofinal(Integer link_procedimientodiagnosticofinal) {
        this.link_procedimientodiagnosticofinal = link_procedimientodiagnosticofinal;
    }

    public Integer getLink_procedimientopersonalsanitario() {
        return link_procedimientopersonalsanitario;
    }

    public void setLink_procedimientopersonalsanitario(Integer link_procedimientopersonalsanitario) {
        this.link_procedimientopersonalsanitario = link_procedimientopersonalsanitario;
    }

    public Integer getLink_procedimiento() {
        return link_procedimiento;
    }

    public void setLink_procedimiento(Integer link_procedimiento) {
        this.link_procedimiento = link_procedimiento;
    }

}
