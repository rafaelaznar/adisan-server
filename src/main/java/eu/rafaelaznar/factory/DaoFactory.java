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
import eu.rafaelaznar.dao.specificimplementation.medico.categoriaprofesional.CategoriaprofesionalSpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.usuario.centro.Centro3SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.usuario.centro.Centro1SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.centrosanitario.Centrosanitario3SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.centrosanitario.Centrosanitario1SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.episodio.tipoepisodio.TipoepisodioSpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.episodio.circunstanciasalta.CircunstanciasaltaSpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.usuario.curso.Curso4SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.usuario.curso.Curso0SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.usuario.curso.Curso3SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.usuario.curso.Curso1SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.usuario.curso.Curso5SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.dependencia.Dependencia4SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.dependencia.Dependencia3SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.dependencia.Dependencia1SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.medico.especialidad.EspecialidadSpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.episodio.destinoalta.DestinoaltaSpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.episodio.Episodio4SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.episodio.Episodio3SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.episodio.Episodio1SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.episodio.factura.FacturaSpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.usuario.grupo.Grupo4SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.usuario.grupo.Grupo3SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.usuario.grupo.Grupo1SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.medico.Medico3SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.medico.Medico1SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.episodio.modalidadepisodio.ModalidadepisodioSpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.paciente.Paciente4SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.paciente.Paciente0SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.paciente.Paciente3SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.paciente.Paciente1SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.paciente.Paciente5SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.servicio.ServicioSpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.paciente.tipopago.TipopagoSpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.paciente.sexo.SexoSpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.dependencia.tipodependencia.TipodependenciaSpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.servicio.tiposervicio.TiposervicioSpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.usuario.tipousuario.Tipousuario4SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.usuario.tipousuario.Tipousuario0SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.usuario.tipousuario.Tipousuario3SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.usuario.tipousuario.Tipousuario1SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.usuario.tipousuario.Tipousuario5SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.usuario.Usuario4SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.usuario.Usuario0SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.usuario.Usuario3SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.usuario.Usuario1SpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.usuario.Usuario5SpecificDaoImplementation;
import eu.rafaelaznar.helper.SessionHelper;
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
                        case 3:
                            oDao = (MetaDaoInterface) new Tipousuario3SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 4:
                            oDao = (MetaDaoInterface) new Tipousuario4SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 5:
                            oDao = (MetaDaoInterface) new Tipousuario5SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
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
                            oDao = (MetaDaoInterface) new Grupo1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
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
            case "centrosanitario":
                if (oPuserBean_security == null) {
                    oDao = (MetaDaoInterface) new Centrosanitario1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
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
                            oDao = (MetaDaoInterface) new Centrosanitario3SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
//                        case 4:
//                            oDao = (MetaDaoInterface) new CentrosanitarioSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
//                            break;
//                        case 5:
//                            oDao = (MetaDaoInterface) new CentrosanitarioSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
//                            break;
                        default:
                            oDao = (MetaDaoInterface) new Centrosanitario1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                    }
                }
                break;
            case "centro":
                if (oPuserBean_security == null) {
                    oDao = (MetaDaoInterface) new Centro1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    break;
                } else {
                    oDao = (MetaDaoInterface) new Centro1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    switch (idTipousuario) {
                        case 1:
                            oDao = (MetaDaoInterface) new Centro1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 3:
                            oDao = (MetaDaoInterface) new Centro3SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
//                        case 4:
//                            oDao = (MetaDaoInterface) new CentrosanitarioSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
//                            break;
//                        case 5:
//                            oDao = (MetaDaoInterface) new CentrosanitarioSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
//                            break;
                        default:
                            oDao = (MetaDaoInterface) new Centro1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                    }
                }
                break;
            case "especialidad":
                oDao = (MetaDaoInterface) new EspecialidadSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                break;
            case "destinoalta":
                oDao = (MetaDaoInterface) new DestinoaltaSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                break;
            case "tipopago":
                oDao = (MetaDaoInterface) new TipopagoSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                break;
            case "circunstanciasalta":
                oDao = (MetaDaoInterface) new CircunstanciasaltaSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                break;
            case "sexo":
                oDao = (MetaDaoInterface) new SexoSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                break;
            case "tipoepisodio":
                oDao = (MetaDaoInterface) new TipoepisodioSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                break;
            case "tiposervicio":
                oDao = (MetaDaoInterface) new TiposervicioSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                break;
            case "modalidadepisodio":
                oDao = (MetaDaoInterface) new ModalidadepisodioSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                break;
            case "tipodependencia":
                oDao = (MetaDaoInterface) new TipodependenciaSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                break;
            case "factura":
                oDao = (MetaDaoInterface) new FacturaSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                break;
            case "servicio":
                oDao = (MetaDaoInterface) new ServicioSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                break;
            case "paciente":

                if (oPuserBean_security == null) {
                    oDao = (MetaDaoInterface) new Paciente0SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    break;
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

            case "categoriaprofesional":
                oDao = (MetaDaoInterface) new CategoriaprofesionalSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                break;
            case "episodio":
                if (oPuserBean_security == null) {
                    oDao = (MetaDaoInterface) new Episodio1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
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
//                        case 4:
//                            oDao = (MetaDaoInterface) new PacienteAlumnoSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
//                            break;
//                        case 5:
//                            oDao = (MetaDaoInterface) new PacienteSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
//                            break;
                        default:
                            oDao = (MetaDaoInterface) new Episodio1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                    }

                }
                break;
            case "medico":
                oDao = (MetaDaoInterface) new Medico1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
//                if (oPuserBean_security != null) { //en el proceso de login puede ser nulo!!
//                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
//                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
//                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
//                    Integer idTipousuario = oTipoUsuario.getId();
//                    switch (idTipousuario) {
//                        case 1:
//                            oDao = (MetaDaoInterface) new MedicoSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
//                            break;
//                        case 3:
//                            oDao = (MetaDaoInterface) new MedicoProfesorSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
//                            break;
//                        case 4:
//                            oDao = (MetaDaoInterface) new PacienteAlumnoSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
//                            break;
//                        case 5:
//                            oDao = (MetaDaoInterface) new PacienteSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
//                            break;
//                    }
//                } else {
//                    oDao = null;
//                }
                break;
            case "dependencia":
                if (oPuserBean_security == null) {
                    oDao = (MetaDaoInterface) new Dependencia1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
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
                            oDao = (MetaDaoInterface) new Dependencia1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        default:
                            oDao = (MetaDaoInterface) new Dependencia1SpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                    }
                }
                break;
            default:
                //oReplyBean = new ReplyBean(500, "Object not found : Please contact your administrator");
                break;
        }
        return oDao;
    }

}
