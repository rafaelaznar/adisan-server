/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.adisan.bean.specificimplementation;

import com.google.gson.annotations.Expose;
import net.adisan.bean.genericimplementation.GenericBeanImplementation;
import net.adisan.bean.meta.publicinterface.MetaObjectBeanInterface;
import net.adisan.bean.meta.publicinterface.MetaPropertyBeanInterface;
import net.adisan.helper.EnumHelper;
import net.adisan.helper.constant.RegexConstants;

@MetaObjectBeanInterface(
        TableName = "comunidad",
        SingularDescription = "Comunidad",
        PluralDescription = "Comunidades",
        Type = EnumHelper.SourceType.Table,
        CreateDescription = "Añadir una Comunidad a ADISAN"
)

public class ComunidadSpecificBeanImplementation extends GenericBeanImplementation {

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
