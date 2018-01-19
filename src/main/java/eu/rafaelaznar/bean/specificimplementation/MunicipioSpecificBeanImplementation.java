/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.rafaelaznar.bean.specificimplementation;

import com.google.gson.annotations.Expose;
import eu.rafaelaznar.bean.genericimplementation.TableGenericBeanImplementation;
import eu.rafaelaznar.bean.helper.MetaBeanHelper;
import eu.rafaelaznar.bean.meta.publicinterface.MetaObjectBeanInterface;
import eu.rafaelaznar.bean.meta.publicinterface.MetaPropertyBeanInterface;
import eu.rafaelaznar.helper.EnumHelper;
import eu.rafaelaznar.helper.constant.RegexConstants;

@MetaObjectBeanInterface(
        TableName = "municipio",
        SingularDescription = "Municipio",
        PluralDescription = "Municipios",
        Type = EnumHelper.SourceType.Table
)

public class MunicipioSpecificBeanImplementation extends TableGenericBeanImplementation {

    @Expose(serialize = false)
    @MetaPropertyBeanInterface(
            Type = EnumHelper.FieldType.ForeignId
    )
    private Integer id_comunidad = 0;
    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Comun.",
            LongName = "Comunidad",
            Description = "Comunidad Autonoma",
            Type = EnumHelper.FieldType.ForeignObject,
            IsRequired = true,
            References = "comunidad",
            Width = 4
    )
    private MetaBeanHelper obj_comunidad = null;

    @Expose(serialize = false)
    @MetaPropertyBeanInterface(
            Type = EnumHelper.FieldType.ForeignId
    )
    private Integer id_provincia = 0;
    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Provincia ",
            LongName = "Provincia",
            Description = "Provincia del paciente",
            Type = EnumHelper.FieldType.ForeignObject,
            IsRequired = true,
            References = "provincia",
            Width = 4
    )
    private MetaBeanHelper obj_provincia = null;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Muni.",
            LongName = "Municipio",
            Description = "Municipio",
            Type = EnumHelper.FieldType.String,
            IsRequired = true,
            RegexPattern = RegexConstants.capitalizedName,
            RegexHelp = RegexConstants.capitalizedName_Help,
            IsForeignKeyDescriptor = false,
            Width = 3,
            MaxLength = 100,
            IsVisible = false
    )
    private String municipio;

    public MunicipioSpecificBeanImplementation() {
    }

    public MunicipioSpecificBeanImplementation(String municipio) {
        this.municipio = municipio;
    }

    public Integer getId_comunidad() {
        return id_comunidad;
    }

    public void setId_comunidad(Integer id_comunidad) {
        this.id_comunidad = id_comunidad;
    }

    public MetaBeanHelper getObj_comunidad() {
        return obj_comunidad;
    }

    public void setObj_comunidad(MetaBeanHelper obj_comunidad) {
        this.obj_comunidad = obj_comunidad;
    }

    public Integer getId_provincia() {
        return id_provincia;
    }

    public void setId_provincia(Integer id_provincia) {
        this.id_provincia = id_provincia;
    }

    public MetaBeanHelper getObj_provincia() {
        return obj_provincia;
    }

    public void setObj_provincia(MetaBeanHelper obj_provincia) {
        this.obj_provincia = obj_provincia;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    
}
