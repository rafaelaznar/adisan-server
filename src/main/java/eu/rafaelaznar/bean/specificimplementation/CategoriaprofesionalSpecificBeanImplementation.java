/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.rafaelaznar.bean.specificimplementation;

import com.google.gson.annotations.Expose;
import eu.rafaelaznar.bean.genericimplementation.TableGenericBeanImplementation;
import eu.rafaelaznar.bean.meta.publicinterface.MetaObjectBeanInterface;
import eu.rafaelaznar.bean.meta.publicinterface.MetaPropertyBeanInterface;
import eu.rafaelaznar.helper.EnumHelper;
import eu.rafaelaznar.helper.constant.RegexConstants;

@MetaObjectBeanInterface(
        TableName = "categoriaprofesional",
        SingularDescription = "Categoría profesional",
        PluralDescription = "Categorías profesionales",
        Icon = "fa fa-list-alt",
        Type = EnumHelper.SourceType.Table
)
public class CategoriaprofesionalSpecificBeanImplementation extends TableGenericBeanImplementation {

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
}
