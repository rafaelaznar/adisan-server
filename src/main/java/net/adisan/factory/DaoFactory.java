/*
 * Copyright (c) 2017-2018
 *
 * by Rafael Angel Aznar Aparici (rafaaznar at gmail dot com) & DAW students
 *
 * ADISAN: Free Open Source Health Management System
 *
 *
 * Sources at:                https://github.com/rafaelaznar/adisan
 *
 * Database at:               https://github.com/rafaelaznar/adisan-database
 *
 * ADISAN is distributed under the MIT License (MIT)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package net.adisan.factory;

import net.adisan.bean.helper.MetaBeanHelper;
import net.adisan.bean.specificimplementation.TipousuarioSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.UsuarioSpecificBeanImplementation;
import net.adisan.dao.publicinterface.DaoInterface;
import net.adisan.dao.specificimplementation.centrosanitario.Centrosanitario0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.categoriaprofesional.Categoriaprofesional1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.centro.Centro1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.centrosanitario.Centrosanitario1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.dependencia.Dependencia0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.tipoepisodio.Tipoepisodio1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.circunstanciasalta.Circunstanciasalta1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.curso.Curso0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.curso.Curso1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.dependencia.Dependencia4SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.dependencia.Dependencia3SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.dependencia.Dependencia1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.dependencia.Dependencia5SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.tipodependencia.Tipodependencia0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.especialidad.Especialidad1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.destinoalta.Destinoalta1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.subepisodio.Subepisodio3SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.subepisodio.Subepisodio1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.factura.Factura1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.grupo.Grupo4SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.grupo.Grupo3SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.grupo.Grupo1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.medico.Medico1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.modalidadepisodio.Modalidadepisodio1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.paciente.Paciente4SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.paciente.Paciente0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.paciente.Paciente3SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.paciente.Paciente1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.paciente.Paciente5SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.servicio.Servicio0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.tipopago.Tipopago1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.tipodependencia.Tipodependencia1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.episodiodiagnostico.Episodiodiagnostico0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.episodiodiagnostico.Episodiodiagnostico1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.episodiodiagnostico.Episodiodiagnostico3SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.episodiodiagnostico.Episodiodiagnostico4SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.episodiodiagnostico.Episodiodiagnostico5SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.subepisodio.Subepisodio0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.subepisodio.Subepisodio4SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.subepisodio.Subepisodio5SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.circunstanciasalta.Circunstanciasalta0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.destinoalta.Destinoalta0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.factura.Factura0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.modalidadepisodio.Modalidadepisodio0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.tipoepisodio.Tipoepisodio0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.medico.Medico0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.medico.Medico3SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.medico.Medico4SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.medico.Medico5SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.categoriaprofesional.Categoriaprofesional0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.especialidad.Especialidad0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.catalogodiagnosticos.Catalogodiagnosticos0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.tipopago.Tipopago0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.servicio.Servicio1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.tiposervicio.Tiposervicio0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.tiposervicio.Tiposervicio1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.tipousuario.Tipousuario0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.tipousuario.Tipousuario1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.usuario.Usuario4SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.usuario.Usuario0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.usuario.Usuario3SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.usuario.Usuario1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.usuario.Usuario5SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.centro.Centro0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.grupo.Grupo5SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.factory.ApellidoSpecificDaoImplementation;
import net.adisan.dao.specificimplementation.factory.ComunidadSpecificDaoImplementation;
import net.adisan.dao.specificimplementation.factory.MunicipioSpecificDaoImplementation;
import net.adisan.dao.specificimplementation.factory.NombrefemeninoSpecificDaoImplementation;
import net.adisan.dao.specificimplementation.factory.NombremasculinoSpecificDaoImplementation;
import net.adisan.dao.specificimplementation.factory.ProvinciaSpecificDaoImplementation;
import net.adisan.dao.specificimplementation.factory.ViaSpecificDaoImplementation;
import java.sql.Connection;
import net.adisan.dao.specificimplementation.episodio.Episodio0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.episodio.Episodio1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.episodio.Episodio3SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.episodio.Episodio4SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.episodio.Episodio5SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.presenciadiagnostico.Presenciadiagnostico0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.presenciadiagnostico.Presenciadiagnostico1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.presenciadiagnosticoingreso.Presenciadiagnosticoingreso0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.presenciadiagnosticoingreso.Presenciadiagnosticoingreso1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.sexo.Sexo0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.sexo.Sexo1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.tipodiagnostico.Tipodiagnostico0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.tipodiagnostico.Tipodiagnostico1SpecificDaoImplementation;

public class DaoFactory {

    public static DaoInterface getDao(String ob, Connection oConnection, MetaBeanHelper oPuserBean_security, String strWhere) throws Exception {
        //TraceHelper.trace("GenericDaoImplementation", "getDao", "object=" + ob);
        DaoInterface oDao = null;
        switch (ob) {
            case "usuario":
                if (oPuserBean_security == null) {
                    oDao = (DaoInterface) new Usuario0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    break;
                } else {
                    oDao = (DaoInterface) new Usuario1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    switch (idTipousuario) {
                        case 1:
                            oDao = (DaoInterface) new Usuario1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 3:
                            oDao = (DaoInterface) new Usuario3SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 4:
                            oDao = (DaoInterface) new Usuario4SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 5:
                            oDao = (DaoInterface) new Usuario5SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        default:
                            oDao = (DaoInterface) new Usuario0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                    }
                }
                break;
            case "tipousuario":
                if (oPuserBean_security == null) {
                    oDao = (DaoInterface) new Tipousuario0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    break;
                } else {
                    oDao = (DaoInterface) new Usuario1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    switch (idTipousuario) {
                        case 1:
                            oDao = (DaoInterface) new Tipousuario1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        default:
                            oDao = (DaoInterface) new Tipousuario0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                    }
                }
                break;
            case "grupo":
                //oDao = (DaoInterface) new GrupoSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                if (oPuserBean_security == null) {
                    oDao = (DaoInterface) new Grupo1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    break;
                } else {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    switch (idTipousuario) {
                        case 1:
                            oDao = (DaoInterface) new Grupo1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 3:
                            oDao = (DaoInterface) new Grupo3SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 4:
                            oDao = (DaoInterface) new Grupo4SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 5:
                            oDao = (DaoInterface) new Grupo5SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        default:
                            oDao = (DaoInterface) new Grupo1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                    }
                }
                break;
            case "curso":
                if (oPuserBean_security == null) {
                    oDao = (DaoInterface) new Curso0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    break;
                } else {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    switch (idTipousuario) {
                        case 1:
                            oDao = (DaoInterface) new Curso1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        default:
                            oDao = (DaoInterface) new Curso0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                    }
                }
                break;
            case "centro":
                if (oPuserBean_security == null) {
                    oDao = (DaoInterface) new Centro0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    break;
                } else {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    switch (idTipousuario) {
                        case 1:
                            oDao = (DaoInterface) new Centro1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 3:
                            oDao = (DaoInterface) new Centro0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 4:
                            oDao = (DaoInterface) new Centro0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 5:
                            oDao = (DaoInterface) new Centro0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        default:
                            oDao = (DaoInterface) new Centro0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                    }
                }
                break;
            case "centrosanitario":
                if (oPuserBean_security == null) {
                    oDao = (DaoInterface) new Centrosanitario0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    break;
                } else {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    switch (idTipousuario) {
                        case 1:
                            oDao = (DaoInterface) new Centrosanitario1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 3:
                            oDao = (DaoInterface) new Centrosanitario0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 4:
                            oDao = (DaoInterface) new Centrosanitario0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 5:
                            oDao = (DaoInterface) new Centrosanitario0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        default:
                            oDao = (DaoInterface) new Centrosanitario1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                    }
                }
                break;
            //------------------------------------------------------------------
            case "paciente":
                if (oPuserBean_security == null) {
                    oDao = (DaoInterface) new Paciente0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                } else {
                    oDao = (DaoInterface) new Usuario1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    switch (idTipousuario) {
                        case 1:
                            oDao = (DaoInterface) new Paciente1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 3:
                            oDao = (DaoInterface) new Paciente3SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 4:
                            oDao = (DaoInterface) new Paciente4SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 5:
                            oDao = (DaoInterface) new Paciente5SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        default:
                            oDao = (DaoInterface) new Paciente0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                    }
                }
                break;
            case "sexo":
                if (oPuserBean_security == null) {
                    oDao = (DaoInterface) new Sexo0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                } else {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    if (idTipousuario == 1) {
                        oDao = (DaoInterface) new Sexo1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    } else {
                        oDao = (DaoInterface) new Sexo0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    }
                }
                break;
            case "tipopago":
                if (oPuserBean_security == null) {
                    oDao = (DaoInterface) new Tipopago0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                } else {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    if (idTipousuario == 1) {
                        oDao = (DaoInterface) new Tipopago1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    } else {
                        oDao = (DaoInterface) new Tipopago0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    }
                }
                break;
            //------------------------------------------------------------------
            case "medico":
                if (oPuserBean_security == null) {
                    oDao = (DaoInterface) new Medico0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    break;
                } else {
                    oDao = (DaoInterface) new Usuario1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    switch (idTipousuario) {
                        case 1:
                            oDao = (DaoInterface) new Medico1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 3:
                            oDao = (DaoInterface) new Medico3SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 4:
                            oDao = (DaoInterface) new Medico4SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 5:
                            oDao = (DaoInterface) new Medico5SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        default:
                            oDao = (DaoInterface) new Medico0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                    }
                }
                break;
            case "especialidad":
                if (oPuserBean_security == null) {
                    oDao = (DaoInterface) new Especialidad0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                } else {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    if (idTipousuario == 1) {
                        oDao = (DaoInterface) new Especialidad1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    } else {
                        oDao = (DaoInterface) new Especialidad0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    }
                }
                break;
            case "categoriaprofesional":
                if (oPuserBean_security == null) {
                    oDao = (DaoInterface) new Categoriaprofesional0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                } else {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    if (idTipousuario == 1) {
                        oDao = (DaoInterface) new Categoriaprofesional1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    } else {
                        oDao = (DaoInterface) new Categoriaprofesional0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    }
                }
                break;
            //------------------------------------------------------------------
            case "servicio":

                if (oPuserBean_security == null) {
                    oDao = (DaoInterface) new Servicio0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                } else {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    if (idTipousuario == 1) {
                        oDao = (DaoInterface) new Servicio1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    } else {
                        oDao = (DaoInterface) new Servicio0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    }
                }
                break;
            case "tiposervicio":
                if (oPuserBean_security == null) {
                    oDao = (DaoInterface) new Tiposervicio0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                } else {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    if (idTipousuario == 1) {
                        oDao = (DaoInterface) new Tiposervicio1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    } else {
                        oDao = (DaoInterface) new Tiposervicio0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    }
                }
                break;
            //------------------------------------------------------------------
            case "episodio":
                if (oPuserBean_security == null) {
                    oDao = (DaoInterface) new Episodio0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    break;
                } else {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    switch (idTipousuario) {
                        case 1:
                            oDao = (DaoInterface) new Episodio1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 3:
                            oDao = (DaoInterface) new Episodio3SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 4:
                            oDao = (DaoInterface) new Episodio4SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 5:
                            oDao = (DaoInterface) new Episodio5SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        default:
                            oDao = (DaoInterface) new Episodio0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                    }

                }
                break;
            case "subepisodio":
                if (oPuserBean_security == null) {
                    oDao = (DaoInterface) new Subepisodio0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    break;
                } else {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    switch (idTipousuario) {
                        case 1:
                            oDao = (DaoInterface) new Subepisodio1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 3:
                            oDao = (DaoInterface) new Subepisodio3SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 4:
                            oDao = (DaoInterface) new Subepisodio4SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 5:
                            oDao = (DaoInterface) new Subepisodio5SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        default:
                            oDao = (DaoInterface) new Subepisodio0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                    }

                }
                break;
            case "tipoepisodio":
                if (oPuserBean_security == null) {
                    oDao = (DaoInterface) new Tipoepisodio0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                } else {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    if (idTipousuario == 1) {
                        oDao = (DaoInterface) new Tipoepisodio1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    } else {
                        oDao = (DaoInterface) new Tipoepisodio0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    }
                }
                break;
            case "modalidadepisodio":
                if (oPuserBean_security == null) {
                    oDao = (DaoInterface) new Modalidadepisodio0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                } else {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    if (idTipousuario == 1) {
                        oDao = (DaoInterface) new Modalidadepisodio1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    } else {
                        oDao = (DaoInterface) new Modalidadepisodio0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    }
                }
                break;
            case "factura":
                if (oPuserBean_security == null) {
                    oDao = (DaoInterface) new Factura0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                } else {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    if (idTipousuario == 1) {
                        oDao = (DaoInterface) new Factura1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    } else {
                        oDao = (DaoInterface) new Factura0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    }
                }
                break;
            case "destinoalta":
                if (oPuserBean_security == null) {
                    oDao = (DaoInterface) new Destinoalta0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                } else {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    if (idTipousuario == 1) {
                        oDao = (DaoInterface) new Destinoalta1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    } else {
                        oDao = (DaoInterface) new Destinoalta0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    }
                }
                break;
            case "circunstanciasalta":
                if (oPuserBean_security == null) {
                    oDao = (DaoInterface) new Circunstanciasalta0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                } else {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    if (idTipousuario == 1) {
                        oDao = (DaoInterface) new Circunstanciasalta1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    } else {
                        oDao = (DaoInterface) new Circunstanciasalta0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    }
                }
                break;                
            case "presenciadiagnostico":
                if (oPuserBean_security == null) {
                    oDao = (DaoInterface) new Presenciadiagnostico0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                } else {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    if (idTipousuario == 1) {
                        oDao = (DaoInterface) new Presenciadiagnostico1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    } else {
                        oDao = (DaoInterface) new Presenciadiagnostico0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    }
                }
                break;                                
            case "presenciadiagnosticoingreso":
                if (oPuserBean_security == null) {
                    oDao = (DaoInterface) new Presenciadiagnosticoingreso0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                } else {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    if (idTipousuario == 1) {
                        oDao = (DaoInterface) new Presenciadiagnosticoingreso1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    } else {
                        oDao = (DaoInterface) new Presenciadiagnosticoingreso0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    }
                }
                break;                 
            case "tipodiagnostico":
                if (oPuserBean_security == null) {
                    oDao = (DaoInterface) new Tipodiagnostico0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                } else {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    if (idTipousuario == 1) {
                        oDao = (DaoInterface) new Tipodiagnostico1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    } else {
                        oDao = (DaoInterface) new Tipodiagnostico0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    }
                }
                break;                 
            case "catalogodiagnosticos":                
                oDao = (DaoInterface) new Catalogodiagnosticos0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);                
                break; 
                            //------------------------------------------------------------------
            case "episodiodiagnostico":
                if (oPuserBean_security == null) {
                    oDao = (DaoInterface) new Episodiodiagnostico0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    break;
                } else {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    switch (idTipousuario) {
                        case 1:
                            oDao = (DaoInterface) new Episodiodiagnostico1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 3:
                            oDao = (DaoInterface) new Episodiodiagnostico3SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 4:
                            oDao = (DaoInterface) new Episodiodiagnostico4SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 5:
                            oDao = (DaoInterface) new Episodiodiagnostico5SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        default:
                            oDao = (DaoInterface) new Episodiodiagnostico0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                    }

                }
                break;
            //------------------------------------------------------------------
            case "dependencia":
                if (oPuserBean_security == null) {
                    oDao = (DaoInterface) new Dependencia0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    break;
                } else {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    switch (idTipousuario) {
                        case 1:
                            oDao = (DaoInterface) new Dependencia1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 3:
                            oDao = (DaoInterface) new Dependencia3SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 4:
                            oDao = (DaoInterface) new Dependencia4SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 5:
                            oDao = (DaoInterface) new Dependencia5SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        default:
                            oDao = (DaoInterface) new Dependencia0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                    }
                }
                break;
            case "tipodependencia":
                if (oPuserBean_security == null) {
                    oDao = (DaoInterface) new Tipodependencia0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                } else {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    if (idTipousuario == 1) {
                        oDao = (DaoInterface) new Tipodependencia1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    } else {
                        oDao = (DaoInterface) new Tipodependencia0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    }
                }
                break;
            //------------------------------------------------------------------
            case "nombremasculino":
                if (oPuserBean_security != null) {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    if (idTipousuario == 1 || idTipousuario == 3) {
                        oDao = (DaoInterface) new NombremasculinoSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    }
                }
                break;
            //------------------------------------------------------------------
            case "nombrefemenino":
                if (oPuserBean_security != null) {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    if (idTipousuario == 1 || idTipousuario == 3) {
                        oDao = (DaoInterface) new NombrefemeninoSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    }
                }
                break;
            //------------------------------------------------------------------
            case "apellido":
                if (oPuserBean_security != null) {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    if (idTipousuario == 1 || idTipousuario == 3) {
                        oDao = (DaoInterface) new ApellidoSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    }
                }
                break;
            //------------------------------------------------------------------
            case "municipio":
                if (oPuserBean_security != null) {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    if (idTipousuario == 1 || idTipousuario == 3) {
                        oDao = (DaoInterface) new MunicipioSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    }
                }
                break;
            //------------------------------------------------------------------
            case "via":
                if (oPuserBean_security != null) {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    if (idTipousuario == 1 || idTipousuario == 3) {
                        oDao = (DaoInterface) new ViaSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    }
                }
                break;
            //------------------------------------------------------------------
            case "provincia":
                if (oPuserBean_security != null) {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    if (idTipousuario == 1 || idTipousuario == 3) {
                        oDao = (DaoInterface) new ProvinciaSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    }
                }
                break;
            //------------------------------------------------------------------
            case "comunidad":
                if (oPuserBean_security != null) {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    if (idTipousuario == 1 || idTipousuario == 3) {
                        oDao = (DaoInterface) new ComunidadSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    }
                }
                break;
            //------------------------------------------------------------------
            default:
                //TraceHelper.traceError("DAO not found: can't create DAO in DaoFactory for " + ob);
                //throw new Exception("Object not found: " + ob);
                break;
        } 
        return oDao;
    }

}
