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
        TableName = "categoriaprofesional",
        SingularDescription = "Categoría profesional médico",
        PluralDescription = "Categorías profesionales médicos",
        Icon = "fa fa-chess-king",
        Type = EnumHelper.SourceType.Table,
        CreateDescription = "Añadir un item de categoría profesional para médico a ADISAN"
)
public class CategoriaprofesionalSpecificBeanImplementation extends GenericBeanImplementation {

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Cat.prof.",
            LongName = "Categoría profesional del médico",
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
            ShortName = "Médicos de la categoría",
            LongName = "Médicos de la categoría",
            Description = "Médicos de la categoría",
            Type = EnumHelper.FieldType.Link,
            References = "medico"
    )
    private Integer link_medico = null;

    public CategoriaprofesionalSpecificBeanImplementation() {
    }

    CategoriaprofesionalSpecificBeanImplementation(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getLink_medico() {
        return link_medico;
    }

    public void setLink_medico(Integer link_medico) {
        this.link_medico = link_medico;
    }

}
