/*
 * Copyright (c) 2017-2018
 *
 * by Rafael Angel Aznar Aparici (rafaaznar at gmail dot com) & DAW students
 *
 * GESANE: Free Open Source Health Management System
 *
 * Sources at:
 *                            https://github.com/rafaelaznar/gesane-server
 *                            https://github.com/rafaelaznar/gesane-client
 *                            https://github.com/rafaelaznar/gesane-database
 *
 * GESANE is distributed under the MIT License (MIT)
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
package eu.rafaelaznar.factory;

import eu.rafaelaznar.bean.helper.MetaBeanHelper;
import eu.rafaelaznar.bean.specificimplementation.TipousuarioSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.UsuarioSpecificBeanImplementation;
import eu.rafaelaznar.dao.publicinterface.MetaDaoInterface;
import eu.rafaelaznar.dao.specificimplementation.centrosanitario.Centrosanitario0SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.medico.categoriaprofesional.Categoriaprofesional1SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.usuario.centro.Centro1SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.centrosanitario.Centrosanitario1SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.dependencia.Dependencia0SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.episodio.tipoepisodio.Tipoepisodio1SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.episodio.circunstanciasalta.Circunstanciasalta1SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.usuario.curso.Curso4SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.usuario.curso.Curso0SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.usuario.curso.Curso3SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.usuario.curso.Curso1SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.usuario.curso.Curso5SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.dependencia.Dependencia4SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.dependencia.Dependencia3SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.dependencia.Dependencia1SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.dependencia.Dependencia5SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.dependencia.tipodependencia.Tipodependencia0SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.medico.especialidad.Especialidad1SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.episodio.destinoalta.Destinoalta1SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.episodio.Episodio3SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.episodio.Episodio1SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.episodio.factura.Factura1SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.usuario.grupo.Grupo4SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.usuario.grupo.Grupo3SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.usuario.grupo.Grupo1SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.medico.Medico1SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.episodio.modalidadepisodio.Modalidadepisodio1SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.paciente.Paciente4SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.paciente.Paciente0SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.paciente.Paciente3SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.paciente.Paciente1SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.paciente.Paciente5SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.servicio.Servicio0SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.paciente.tipopago.Tipopago1SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.paciente.sexo.Sexo1SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.dependencia.tipodependencia.Tipodependencia1SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.episodio.Episodio0SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.episodio.Episodio4SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.episodio.Episodio5SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.episodio.circunstanciasalta.Circunstanciasalta0SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.episodio.destinoalta.Destinoalta0SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.episodio.factura.Factura0SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.episodio.modalidadepisodio.Modalidadepisodio0SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.episodio.tipoepisodio.Tipoepisodio0SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.medico.Medico0SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.medico.Medico3SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.medico.Medico4SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.medico.Medico5SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.medico.categoriaprofesional.Categoriaprofesional0SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.medico.especialidad.Especialidad0SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.paciente.sexo.Sexo0SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.paciente.tipopago.Tipopago0SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.servicio.Servicio1SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.servicio.tiposervicio.Tiposervicio0SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.servicio.tiposervicio.Tiposervicio1SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.usuario.tipousuario.Tipousuario0SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.usuario.tipousuario.Tipousuario1SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.usuario.Usuario4SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.usuario.Usuario0SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.usuario.Usuario3SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.usuario.Usuario1SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.usuario.Usuario5SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.usuario.centro.Centro0SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.usuario.grupo.Grupo5SpecificDaoImplementation;
import java.sql.Connection;

public class DaoFactory {

    public static MetaDaoInterface getDao(String ob, Connection oConnection, MetaBeanHelper oPuserBean_security, String strWhere) throws Exception {
        MetaDaoInterface oDao = null;
        switch (ob) {
            case "usuario":
                if (oPuserBean_security == null) {
                    oDao = (MetaDaoInterface) new Usuario0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    break;
                } else {
                    oDao = (MetaDaoInterface) new Usuario1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    switch (idTipousuario) {
                        case 1:
                            oDao = (MetaDaoInterface) new Usuario1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 3:
                            oDao = (MetaDaoInterface) new Usuario3SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 4:
                            oDao = (MetaDaoInterface) new Usuario4SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 5:
                            oDao = (MetaDaoInterface) new Usuario5SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        default:
                            oDao = (MetaDaoInterface) new Usuario0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                    }
                }
                break;
            case "tipousuario":
                if (oPuserBean_security == null) {
                    oDao = (MetaDaoInterface) new Tipousuario0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    break;
                } else {
                    oDao = (MetaDaoInterface) new Usuario1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    switch (idTipousuario) {
                        case 1:
                            oDao = (MetaDaoInterface) new Tipousuario1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        default:
                            oDao = (MetaDaoInterface) new Tipousuario0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                    }
                }
                break;
            case "grupo":
                //oDao = (MetaDaoInterface) new GrupoSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                if (oPuserBean_security == null) {
                    oDao = (MetaDaoInterface) new Grupo1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    break;
                } else {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    switch (idTipousuario) {
                        case 1:
                            oDao = (MetaDaoInterface) new Grupo1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 3:
                            oDao = (MetaDaoInterface) new Grupo3SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 4:
                            oDao = (MetaDaoInterface) new Grupo4SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 5:
                            oDao = (MetaDaoInterface) new Grupo5SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        default:
                            oDao = (MetaDaoInterface) new Grupo1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                    }
                }
                break;
            case "curso":
                if (oPuserBean_security == null) {
                    oDao = (MetaDaoInterface) new Curso0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    break;
                } else {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    switch (idTipousuario) {
                        case 1:
                            oDao = (MetaDaoInterface) new Curso1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 3:
                            oDao = (MetaDaoInterface) new Curso3SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 4:
                            oDao = (MetaDaoInterface) new Curso4SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 5:
                            oDao = (MetaDaoInterface) new Curso5SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        default:
                            oDao = (MetaDaoInterface) new Curso0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                    }
                }
                break;
            case "centro":
                if (oPuserBean_security == null) {
                    oDao = (MetaDaoInterface) new Centro0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    break;
                } else {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    switch (idTipousuario) {
                        case 1:
                            oDao = (MetaDaoInterface) new Centro1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 3:
                            oDao = (MetaDaoInterface) new Centro0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 4:
                            oDao = (MetaDaoInterface) new Centro0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 5:
                            oDao = (MetaDaoInterface) new Centro0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        default:
                            oDao = (MetaDaoInterface) new Centro0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                    }
                }
                break;
            case "centrosanitario":
                if (oPuserBean_security == null) {
                    oDao = (MetaDaoInterface) new Centrosanitario0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    break;
                } else {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    switch (idTipousuario) {
                        case 1:
                            oDao = (MetaDaoInterface) new Centrosanitario1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 3:
                            oDao = (MetaDaoInterface) new Centrosanitario0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 4:
                            oDao = (MetaDaoInterface) new Centrosanitario0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 5:
                            oDao = (MetaDaoInterface) new Centrosanitario0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        default:
                            oDao = (MetaDaoInterface) new Centrosanitario1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                    }
                }
                break;
            //------------------------------------------------------------------
            case "paciente":
                if (oPuserBean_security == null) {
                    oDao = (MetaDaoInterface) new Paciente0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                } else {
                    oDao = (MetaDaoInterface) new Usuario1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    switch (idTipousuario) {
                        case 1:
                            oDao = (MetaDaoInterface) new Paciente1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 3:
                            oDao = (MetaDaoInterface) new Paciente3SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 4:
                            oDao = (MetaDaoInterface) new Paciente4SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 5:
                            oDao = (MetaDaoInterface) new Paciente5SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        default:
                            oDao = (MetaDaoInterface) new Paciente0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                    }
                }
                break;
            case "sexo":
                if (oPuserBean_security == null) {
                    oDao = (MetaDaoInterface) new Sexo0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                } else {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    if (idTipousuario == 1) {
                        oDao = (MetaDaoInterface) new Sexo1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    } else {
                        oDao = (MetaDaoInterface) new Sexo0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    }
                }
                break;
            case "tipopago":
                if (oPuserBean_security == null) {
                    oDao = (MetaDaoInterface) new Tipopago0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                } else {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    if (idTipousuario == 1) {
                        oDao = (MetaDaoInterface) new Tipopago1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    } else {
                        oDao = (MetaDaoInterface) new Tipopago0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    }
                }
                break;
            //------------------------------------------------------------------
            case "medico":
                if (oPuserBean_security == null) {
                    oDao = (MetaDaoInterface) new Medico0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    break;
                } else {
                    oDao = (MetaDaoInterface) new Usuario1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    switch (idTipousuario) {
                        case 1:
                            oDao = (MetaDaoInterface) new Medico1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 3:
                            oDao = (MetaDaoInterface) new Medico3SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 4:
                            oDao = (MetaDaoInterface) new Medico4SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 5:
                            oDao = (MetaDaoInterface) new Medico5SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        default:
                            oDao = (MetaDaoInterface) new Medico0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                    }
                }
                break;
            case "especialidad":
                if (oPuserBean_security == null) {
                    oDao = (MetaDaoInterface) new Especialidad0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                } else {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    if (idTipousuario == 1) {
                        oDao = (MetaDaoInterface) new Especialidad1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    } else {
                        oDao = (MetaDaoInterface) new Especialidad0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    }
                }
                break;
            case "categoriaprofesional":
                if (oPuserBean_security == null) {
                    oDao = (MetaDaoInterface) new Categoriaprofesional0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                } else {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    if (idTipousuario == 1) {
                        oDao = (MetaDaoInterface) new Categoriaprofesional1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    } else {
                        oDao = (MetaDaoInterface) new Categoriaprofesional0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    }
                }
                break;
            //------------------------------------------------------------------
            case "servicio":

                if (oPuserBean_security == null) {
                    oDao = (MetaDaoInterface) new Servicio0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                } else {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    if (idTipousuario == 1) {
                        oDao = (MetaDaoInterface) new Servicio1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    } else {
                        oDao = (MetaDaoInterface) new Servicio0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    }
                }
                break;
            case "tiposervicio":
                if (oPuserBean_security == null) {
                    oDao = (MetaDaoInterface) new Tiposervicio0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                } else {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    if (idTipousuario == 1) {
                        oDao = (MetaDaoInterface) new Tiposervicio1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    } else {
                        oDao = (MetaDaoInterface) new Tiposervicio0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    }
                }
                break;
            //------------------------------------------------------------------
            case "episodio":
                if (oPuserBean_security == null) {
                    oDao = (MetaDaoInterface) new Episodio0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    break;
                } else {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    switch (idTipousuario) {
                        case 1:
                            oDao = (MetaDaoInterface) new Episodio1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 3:
                            oDao = (MetaDaoInterface) new Episodio3SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 4:
                            oDao = (MetaDaoInterface) new Episodio4SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 5:
                            oDao = (MetaDaoInterface) new Episodio5SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        default:
                            oDao = (MetaDaoInterface) new Episodio0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                    }

                }
                break;
            case "tipoepisodio":
                if (oPuserBean_security == null) {
                    oDao = (MetaDaoInterface) new Tipoepisodio0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                } else {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    if (idTipousuario == 1) {
                        oDao = (MetaDaoInterface) new Tipoepisodio1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    } else {
                        oDao = (MetaDaoInterface) new Tipoepisodio0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    }
                }
                break;
            case "modalidadepisodio":
                if (oPuserBean_security == null) {
                    oDao = (MetaDaoInterface) new Modalidadepisodio0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                } else {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    if (idTipousuario == 1) {
                        oDao = (MetaDaoInterface) new Modalidadepisodio1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    } else {
                        oDao = (MetaDaoInterface) new Modalidadepisodio0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    }
                }
                break;
            case "factura":
                if (oPuserBean_security == null) {
                    oDao = (MetaDaoInterface) new Factura0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                } else {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    if (idTipousuario == 1) {
                        oDao = (MetaDaoInterface) new Factura1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    } else {
                        oDao = (MetaDaoInterface) new Factura0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    }
                }
                break;
            case "destinoalta":
                if (oPuserBean_security == null) {
                    oDao = (MetaDaoInterface) new Destinoalta0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                } else {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    if (idTipousuario == 1) {
                        oDao = (MetaDaoInterface) new Destinoalta1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    } else {
                        oDao = (MetaDaoInterface) new Destinoalta0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    }
                }
                break;
            case "circunstanciasalta":
                if (oPuserBean_security == null) {
                    oDao = (MetaDaoInterface) new Circunstanciasalta0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                } else {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    if (idTipousuario == 1) {
                        oDao = (MetaDaoInterface) new Circunstanciasalta1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    } else {
                        oDao = (MetaDaoInterface) new Circunstanciasalta0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    }
                }
                break;
            //------------------------------------------------------------------
            case "dependencia":
                if (oPuserBean_security == null) {
                    oDao = (MetaDaoInterface) new Dependencia0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    break;
                } else {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    switch (idTipousuario) {
                        case 1:
                            oDao = (MetaDaoInterface) new Dependencia1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 3:
                            oDao = (MetaDaoInterface) new Dependencia3SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 4:
                            oDao = (MetaDaoInterface) new Dependencia4SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 5:
                            oDao = (MetaDaoInterface) new Dependencia5SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        default:
                            oDao = (MetaDaoInterface) new Dependencia0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                    }
                }
                break;
            case "tipodependencia":
                if (oPuserBean_security == null) {
                    oDao = (MetaDaoInterface) new Tipodependencia0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                } else {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    if (idTipousuario == 1) {
                        oDao = (MetaDaoInterface) new Tipodependencia1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    } else {
                        oDao = (MetaDaoInterface) new Tipodependencia0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    }
                }
                break;
            //------------------------------------------------------------------
            default:
                //oReplyBean = new ReplyBean(500, "Object not found : Please contact your administrator");
                break;
        }
        return oDao;
    }

}
