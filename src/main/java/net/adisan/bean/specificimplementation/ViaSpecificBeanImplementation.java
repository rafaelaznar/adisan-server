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
        TableName = "via",
        SingularDescription = "Via",
        PluralDescription = "Via",
        Type = EnumHelper.SourceType.Table,
        CreateDescription = "Añadir un código de via al procedimiento"
)
public class ViaSpecificBeanImplementation extends GenericBeanImplementation {

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Via",
            LongName = "Via",
            Description = "Via",
            Type = EnumHelper.FieldType.String,
            IsRequired = true,
            RegexPattern = RegexConstants.capitalizedName,
            RegexHelp = RegexConstants.capitalizedName_Help,
            IsForeignKeyDescriptor = false,
            Width = 3,
            MaxLength = 100,
            IsVisible = false
    )
    private String via;

    public ViaSpecificBeanImplementation() {
    }

    public ViaSpecificBeanImplementation(String via) {
        this.via = via;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

}
