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
        TableName = "nombrefemenino",
        SingularDescription = "Nombre Femenino",
        PluralDescription = "Nombres Femeninos",
        Type = EnumHelper.SourceType.Table
)
public class NombrefemeninoSpecificBeanImplementation {

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
    private String nombreFemenino;

    public NombrefemeninoSpecificBeanImplementation() {
    }

    public NombrefemeninoSpecificBeanImplementation(String nombreFemenino) {
        this.nombreFemenino = nombreFemenino;
    }

    public String getNombreFemenino() {
        return nombreFemenino;
    }

    public void setNombreFemenino(String nombreFemenino) {
        this.nombreFemenino = nombreFemenino;
    }

}
