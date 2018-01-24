/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.rafaelaznar.bean.specificimplementation;

import com.google.gson.annotations.Expose;
import eu.rafaelaznar.bean.meta.publicinterface.MetaObjectBeanInterface;
import eu.rafaelaznar.bean.meta.publicinterface.MetaPropertyBeanInterface;
import eu.rafaelaznar.helper.EnumHelper;
import eu.rafaelaznar.helper.constant.RegexConstants;

@MetaObjectBeanInterface(
        TableName = "comunidad",
        SingularDescription = "Comunidad",
        PluralDescription = "Comunidades",
        Type = EnumHelper.SourceType.Table
)

public class ComunidadSpecificBeanImplementation {

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Comun.",
            LongName = "Comunidad",
            Description = "Comunidad Autónoma",
            Type = EnumHelper.FieldType.String,
            IsRequired = true,
            RegexPattern = RegexConstants.capitalizedName,
            RegexHelp = RegexConstants.capitalizedName_Help,
            IsForeignKeyDescriptor = false,
            Width = 3,
            MaxLength = 100,
            IsVisible = false
    )
    private String Comunidad;

    public ComunidadSpecificBeanImplementation() {
    }

    public ComunidadSpecificBeanImplementation(String Comunidad) {
        this.Comunidad = Comunidad;
    }

    public String getComunidad() {
        return Comunidad;
    }

    public void setComunidad(String Comunidad) {
        this.Comunidad = Comunidad;
    }

}
