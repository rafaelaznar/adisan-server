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
        TableName = "categoriaprofesionalps",
        SingularDescription = "Categoría profesional personal sanitario",
        PluralDescription = "Categorías profesionales personal sanitario",
        Icon = "fa fa-chess-queen",
        Type = EnumHelper.SourceType.Table,
        CreateDescription = "Añadir un código de categoría profesional para personal sanitario a ADISAN"
)
public class CategoriaprofesionalpsSpecificBeanImplementation extends GenericBeanImplementation {

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Cat.prof.",
            LongName = "Categoría profesional del empleado",
            Description = "Descripcion de la tabla categoría profesional",
            Type = EnumHelper.FieldType.String,
            IsRequired = true,
            RegexPattern = RegexConstants.capitalizedSentence,
            RegexHelp = RegexConstants.capitalizedSentence_Help,
            IsForeignKeyDescriptor = true
    )
    private String descripcion = "";

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Personal de la categoría",
            LongName = "Personal de la categoría",
            Description = "Personal de la categoría",
            Type = EnumHelper.FieldType.Link,
            References = "personalsanitario"
    )
    private Integer link_personalsanitario = null;

    public CategoriaprofesionalpsSpecificBeanImplementation() {
    }

    CategoriaprofesionalpsSpecificBeanImplementation(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getLink_personalsanitario() {
        return link_personalsanitario;
    }

    public void setLink_personalsanitario(Integer link_personalsanitario) {
        this.link_personalsanitario = link_personalsanitario;
    }



}
