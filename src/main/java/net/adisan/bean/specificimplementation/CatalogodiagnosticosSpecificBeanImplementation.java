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
        TableName = "catalogodiagnosticos",
        SingularDescription = "Diagnóstico codificado del catálogo",
        PluralDescription = "Catálogo de diagnósticos codificados",
        Icon = "fa fa-qrcode",
        Type = EnumHelper.SourceType.Table,
        CreateDescription = "Añadir un diagnóstico al catálogo"
)

public class CatalogodiagnosticosSpecificBeanImplementation extends GenericBeanImplementation {

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Código",
            LongName = "Código del diagnóstico",
            Description = "Código del diagnóstico",
            Type = EnumHelper.FieldType.String,
            IsRequired = true,
            RegexPattern = RegexConstants.capitalizedSentence,
            IsForeignKeyDescriptor = true
    )
    private String codigo = "";

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Descripción",
            LongName = "Descripción del diagnóstico",
            Description = "Descripcion del diagnóstico",
            Type = EnumHelper.FieldType.String,
            IsRequired = true,
            RegexPattern = RegexConstants.capitalizedSentence,
            Clip = false,
            IsForeignKeyDescriptor = true
    )
    private String descripcion = "";

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Final",
            LongName = "Nodo final",
            Description = "Nodo final",
            Type = EnumHelper.FieldType.Boolean,
            IsRequired = true,
            IsVisible = true
    )
    private Integer nodo_final;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "NDXP",
            LongName = "No DX Principal",
            Description = "No valido DX principal",
            Type = EnumHelper.FieldType.Boolean,
            IsRequired = true,
            IsVisible = true
    )
    private Integer no_valido_dx_principal;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "VCDP",
            LongName = "VCDP",
            Description = "VCDP",
            Type = EnumHelper.FieldType.Boolean,
            IsRequired = true,
            IsVisible = true
    )
    private Integer vcdp;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "NoPOA",
            LongName = "POA exento",
            Description = "POA Exento",
            Type = EnumHelper.FieldType.Boolean,
            IsRequired = true,
            IsVisible = true
    )
    private Integer poa_exento;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Manif.",
            LongName = "Manifestación",
            Description = "Manifestación",
            Type = EnumHelper.FieldType.Boolean,
            IsRequired = true,
            IsVisible = true
    )
    private Integer manifestacion;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Perinatal",
            LongName = "Perinatal",
            Description = "Perinatal",
            Type = EnumHelper.FieldType.Boolean,
            IsRequired = true,
            IsVisible = true
    )
    private Integer perinatal;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Pediátrico",
            LongName = "Pediátrico",
            Description = "Pediátrico",
            Type = EnumHelper.FieldType.Boolean,
            IsRequired = true,
            IsVisible = true
    )
    private Integer pediatrico;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Obstétrico",
            LongName = "Obstétrico",
            Description = "Obstétrico",
            Type = EnumHelper.FieldType.Boolean,
            IsRequired = true,
            IsVisible = true
    )
    private Integer obstetrico;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Adulto",
            LongName = "Adulto",
            Description = "Adulto",
            Type = EnumHelper.FieldType.Boolean,
            IsRequired = true,
            IsVisible = true
    )
    private Integer adulto;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Mujer",
            LongName = "Mujer",
            Description = "Mujer",
            Type = EnumHelper.FieldType.Boolean,
            IsRequired = true,
            IsVisible = true
    )
    private Integer mujer;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Hombre",
            LongName = "Hombre",
            Description = "Hombre",
            Type = EnumHelper.FieldType.Boolean,
            IsRequired = true,
            IsVisible = true
    )
    private Integer hombre;

    //-----------------------------------------------------
    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Diagnósticos en episodios",
            LongName = "Diagnósticos del código",
            Description = "Diagnósticos de este código",
            Type = EnumHelper.FieldType.Link,
            References = "episodiodiagnostico"
    )
    private Integer link_episodiodiagnostico = null;

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Diagnósticos iniciales en procedimientos",
            LongName = "Diagnósticos iniciales en procedimientos del código",
            Description = "Diagnósticos iniciales en procedimientos del código",
            Type = EnumHelper.FieldType.Link,
            References = "procedimientodiagnosticoinicial"
    )
    private Integer link_procedimientodiagnosticoinicial = null;

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Diagnósticos finales en procedimientos",
            LongName = "Diagnósticos finales en procedimientos del código",
            Description = "Diagnósticos finales en procedimientos del código",
            Type = EnumHelper.FieldType.Link,
            References = "procedimientodiagnosticofinal"
    )
    private Integer link_procedimientodiagnosticofinal = null;

    public CatalogodiagnosticosSpecificBeanImplementation() {
    }

    CatalogodiagnosticosSpecificBeanImplementation(Integer id) {
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

    public Integer getNodo_final() {
        return nodo_final;
    }

    public void setNodo_final(Integer nodo_final) {
        this.nodo_final = nodo_final;
    }

    public Integer getNo_valido_dx_principal() {
        return no_valido_dx_principal;
    }

    public void setNo_valido_dx_principal(Integer no_valido_dx_principal) {
        this.no_valido_dx_principal = no_valido_dx_principal;
    }

    public Integer getVcdp() {
        return vcdp;
    }

    public void setVcdp(Integer vcdp) {
        this.vcdp = vcdp;
    }

    public Integer getPoa_exento() {
        return poa_exento;
    }

    public void setPoa_exento(Integer poa_exento) {
        this.poa_exento = poa_exento;
    }

    public Integer getManifestacion() {
        return manifestacion;
    }

    public void setManifestacion(Integer manifestacion) {
        this.manifestacion = manifestacion;
    }

    public Integer getPerinatal() {
        return perinatal;
    }

    public void setPerinatal(Integer perinatal) {
        this.perinatal = perinatal;
    }

    public Integer getPediatrico() {
        return pediatrico;
    }

    public void setPediatrico(Integer pediatrico) {
        this.pediatrico = pediatrico;
    }

    public Integer getObstetrico() {
        return obstetrico;
    }

    public void setObstetrico(Integer obstetrico) {
        this.obstetrico = obstetrico;
    }

    public Integer getAdulto() {
        return adulto;
    }

    public void setAdulto(Integer adulto) {
        this.adulto = adulto;
    }

    public Integer getMujer() {
        return mujer;
    }

    public void setMujer(Integer mujer) {
        this.mujer = mujer;
    }

    public Integer getHombre() {
        return hombre;
    }

    public void setHombre(Integer hombre) {
        this.hombre = hombre;
    }

    public Integer getLink_episodiodiagnostico() {
        return link_episodiodiagnostico;
    }

    public void setLink_episodiodiagnostico(Integer link_episodiodiagnostico) {
        this.link_episodiodiagnostico = link_episodiodiagnostico;
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

}
