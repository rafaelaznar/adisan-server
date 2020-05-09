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
        TableName = "nombrefemenino",
        SingularDescription = "Nombre Femenino",
        PluralDescription = "Nombres Femeninos",
        Type = EnumHelper.SourceType.Table,
        CreateDescription = "Añadir un nombre femenino a ADISAN"
)
public class NombrefemeninoSpecificBeanImplementation extends GenericBeanImplementation {

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Nombre",
            LongName = "Nombre",
            Description = "Nombre Femenino",
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

    public NombrefemeninoSpecificBeanImplementation() {
    }

    public NombrefemeninoSpecificBeanImplementation(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
