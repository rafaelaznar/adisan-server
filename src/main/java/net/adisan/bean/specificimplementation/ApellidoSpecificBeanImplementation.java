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
import net.adisan.constant.RegexConstants;

@MetaObjectBeanInterface(
        TableName = "apellido",
        SingularDescription = "Apellido",
        PluralDescription = "Apellido",
        Type = EnumHelper.SourceType.Table,
        CreateDescription = "Añadir apellido a ADISAN"
)

public class ApellidoSpecificBeanImplementation extends GenericBeanImplementation {

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Ap.",
            LongName = "Apellido",
            Description = "Apellido del usuario",
            Type = EnumHelper.FieldType.String,
            IsRequired = true,
            RegexPattern = RegexConstants.capitalizedName,
            RegexHelp = RegexConstants.capitalizedName_Help,
            IsForeignKeyDescriptor = false,
            Width = 3,
            MaxLength = 100,
            IsVisible = false
    )
    private String Apellido;

    public ApellidoSpecificBeanImplementation() {
    }

    public ApellidoSpecificBeanImplementation(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

}
