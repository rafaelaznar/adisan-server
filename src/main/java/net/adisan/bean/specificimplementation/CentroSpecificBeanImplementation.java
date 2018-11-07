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
        TableName = "centro",
        SingularDescription = "Centro educativo",
        PluralDescription = "Centros educativos",
        Icon = "fa fa-graduation-cap",
        Type = EnumHelper.SourceType.Table
)
public class CentroSpecificBeanImplementation extends GenericBeanImplementation {

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Nombre",
            LongName = "Nombre",
            Description = "Nombre del centro",
            Type = EnumHelper.FieldType.String,
            IsRequired = true,
            RegexPattern = RegexConstants.capitalizedName,
            RegexHelp = RegexConstants.capitalizedName_Help,
            IsForeignKeyDescriptor = true,
            Width = 3,
            MaxLength = 100
    )
    private String nombre;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Cod.",
            LongName = "Código",
            Description = "Código del centro",
            Type = EnumHelper.FieldType.String,
            IsRequired = true,
            RegexPattern = RegexConstants.capscode,
            RegexHelp = RegexConstants.capscode_Help,
            MaxLength = 50
    )
    private String codigo;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Población",
            LongName = "Población",
            Description = "Población del centro",
            Type = EnumHelper.FieldType.String,
            IsRequired = true,
            RegexPattern = RegexConstants.capitalizedName,
            RegexHelp = RegexConstants.capitalizedName_Help,
            IsForeignKeyDescriptor = true,
            Width = 3,
            MaxLength = 100
    )
    private String poblacion;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Provincia",
            LongName = "Provincia",
            Description = "Provincia del centro",
            Type = EnumHelper.FieldType.String,
            IsRequired = true,
            RegexPattern = RegexConstants.capitalizedName,
            RegexHelp = RegexConstants.capitalizedName_Help,
            Width = 3,
            MaxLength = 100
    )
    private String provincia;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Provincia",
            LongName = "Provincia",
            Description = "Provincia del centro",
            Type = EnumHelper.FieldType.String,
            IsRequired = true,
            RegexPattern = "(\\+34|0034|34)?[6|7|9][0-9]{8}",
            RegexHelp = "introduzca un teléfono válido",
            Width = 3,
            MaxLength = 100
    )
    private String telefono;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "email",
            LongName = "Correo electrónico",
            Description = "Correo electrónico del centro",
            Type = EnumHelper.FieldType.String,
            IsRequired = true,
            RegexPattern = RegexConstants.email,
            RegexHelp = RegexConstants.email_Help,
            MaxLength = 50
    )
    private String email;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Dir.",
            LongName = "Dirección",
            Description = "Dirección del centro",
            Type = EnumHelper.FieldType.String,
            IsRequired = true,
            MaxLength = 50
    )
    private String direccion;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "CP",
            LongName = "Código postal",
            Description = "Código postal del centro",
            Type = EnumHelper.FieldType.String,
            RegexPattern = "0[1-9][0-9]{3}|[1-4][0-9]{4}|5[0-2][0-9]{3}",
            RegexHelp = "código postal válido",
            IsRequired = true,
            MaxLength = 50
    )
    private String cod_postal;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "País",
            LongName = "País",
            Description = "País del centro",
            Type = EnumHelper.FieldType.String,
            IsRequired = true,
            RegexPattern = RegexConstants.capitalizedName,
            RegexHelp = RegexConstants.capitalizedName_Help,
            Width = 3,
            MaxLength = 100
    )
    private String pais;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "¿Público?",
            LongName = "¿Público?",
            Description = "¿Se trata de un centro público?",
            Type = EnumHelper.FieldType.Integer,
            IsRequired = true
    )
    private Boolean publico;

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Usuarios",
            LongName = "Usuarios en el centro",
            Description = "Usuarios en el centro educativo",
            Type = EnumHelper.FieldType.Link,
            References = "usuario"
    )
    private Integer link_usuario = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CentroSpecificBeanImplementation() {
    }

    public CentroSpecificBeanImplementation(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCod_postal() {
        return cod_postal;
    }

    public void setCod_postal(String cod_postal) {
        this.cod_postal = cod_postal;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Boolean getPublico() {
        return publico;
    }

    public void setPublico(Boolean publico) {
        this.publico = publico;
    }

    public Integer getLink_usuario() {
        return link_usuario;
    }

    public void setLink_usuario(Integer link_usuario) {
        this.link_usuario = link_usuario;
    }

}
