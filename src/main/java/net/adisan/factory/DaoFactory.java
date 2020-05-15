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
import net.adisan.dao.publicinterface.DaoInterface;
import net.adisan.dao.specificimplementation.centrosanitario.Centrosanitario0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.categoriaprofesionalps.Categoriaprofesionalps1SpecificDaoImplementation;
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
import net.adisan.dao.specificimplementation.prioridad.Prioridad0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.especialidad.Especialidad1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.destinoalta.Destinoalta1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.subepisodio.Subepisodio3SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.subepisodio.Subepisodio1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.factura.Factura1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.grupo.Grupo4SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.grupo.Grupo3SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.grupo.Grupo1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.personalsanitario.Personalsanitario1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.modalidadepisodio.Modalidadepisodio1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.paciente.Paciente4SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.paciente.Paciente0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.paciente.Paciente3SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.paciente.Paciente1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.paciente.Paciente5SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.servicio.Servicio0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.tipoprocedimiento.Tipoprocedimiento1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.prioridad.Prioridad1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.procedimientodiagnosticofinal.Procedimientodiagnosticofinal0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.procedimientodiagnosticofinal.Procedimientodiagnosticofinal1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.procedimientodiagnosticofinal.Procedimientodiagnosticofinal3SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.procedimientodiagnosticofinal.Procedimientodiagnosticofinal4SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.procedimientodiagnosticofinal.Procedimientodiagnosticofinal5SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.subepisodio.Subepisodio0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.subepisodio.Subepisodio4SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.subepisodio.Subepisodio5SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.circunstanciasalta.Circunstanciasalta0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.destinoalta.Destinoalta0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.factura.Factura0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.modalidadepisodio.Modalidadepisodio0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.tipoepisodio.Tipoepisodio0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.personalsanitario.Personalsanitario0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.personalsanitario.Personalsanitario3SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.personalsanitario.Personalsanitario4SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.personalsanitario.Personalsanitario5SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.categoriaprofesionalps.Categoriaprofesionalps0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.especialidad.Especialidad0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.catalogoprocedimientos.Catalogoprocedimientos0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.tipoprocedimiento.Tipoprocedimiento0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.servicio.Servicio1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.tiposervicio.Tiposervicio0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.tiposervicio.Tiposervicio1SpecificDaoImplementation;
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
import net.adisan.dao.specificimplementation.catalogodiagnosticos.Catalogodiagnosticos0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.categoriaprofesional.Categoriaprofesional0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.categoriaprofesional.Categoriaprofesional1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.episodio.Episodio0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.episodio.Episodio1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.episodio.Episodio3SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.episodio.Episodio4SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.episodio.Episodio5SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.episodiodiagnostico.Episodiodiagnostico0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.episodiodiagnostico.Episodiodiagnostico1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.episodiodiagnostico.Episodiodiagnostico3SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.episodiodiagnostico.Episodiodiagnostico4SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.episodiodiagnostico.Episodiodiagnostico5SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.episodioprocedimiento.Episodioprocedimiento0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.episodioprocedimiento.Episodioprocedimiento1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.episodioprocedimiento.Episodioprocedimiento3SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.episodioprocedimiento.Episodioprocedimiento4SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.episodioprocedimiento.Episodioprocedimiento5SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.estado.Estado0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.estado.Estado1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.log.Log0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.log.Log1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.medico.Medico0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.medico.Medico1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.medico.Medico3SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.medico.Medico4SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.medico.Medico5SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.presenciadiagnostico.Presenciadiagnostico0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.presenciadiagnostico.Presenciadiagnostico1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.presenciadiagnosticoingreso.Presenciadiagnosticoingreso0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.presenciadiagnosticoingreso.Presenciadiagnosticoingreso1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.procedimiento.Procedimiento0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.procedimiento.Procedimiento1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.procedimiento.Procedimiento3SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.procedimiento.Procedimiento4SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.procedimiento.Procedimiento5SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.procedimientodiagnosticoinicial.Procedimientodiagnosticoinicial0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.procedimientodiagnosticoinicial.Procedimientodiagnosticoinicial1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.procedimientodiagnosticoinicial.Procedimientodiagnosticoinicial3SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.procedimientodiagnosticoinicial.Procedimientodiagnosticoinicial4SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.procedimientodiagnosticoinicial.Procedimientodiagnosticoinicial5SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.procedimientomedico.Procedimientomedico0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.procedimientomedico.Procedimientomedico1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.procedimientomedico.Procedimientomedico3SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.procedimientomedico.Procedimientomedico4SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.procedimientomedico.Procedimientomedico5SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.procedimientopersonalsanitario.Procedimientopersonalsanitario0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.procedimientopersonalsanitario.Procedimientopersonalsanitario1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.procedimientopersonalsanitario.Procedimientopersonalsanitario3SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.procedimientopersonalsanitario.Procedimientopersonalsanitario4SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.procedimientopersonalsanitario.Procedimientopersonalsanitario5SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.sexo.Sexo0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.sexo.Sexo1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.tipodependencia.Tipodependencia0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.tipodependencia.Tipodependencia1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.tipodiagnostico.Tipodiagnostico0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.tipodiagnostico.Tipodiagnostico1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.tipopago.Tipopago0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.tipopago.Tipopago1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.tipousuario.Tipousuario0SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.tipousuario.Tipousuario1SpecificDaoImplementation;
import net.adisan.helper.SessionHelper;

public class DaoFactory {

    public static DaoInterface getDao(String ob, Connection oConnection, MetaBeanHelper oMBHUsuarioSession, String strWhere) throws Exception {
        //TraceHelper.trace("GenericDaoImplementation", "getDao", "object=" + ob);
        DaoInterface oDao = null;
        switch (ob) {
            case "usuario":
                if (SessionHelper.thereIsNOSession(oMBHUsuarioSession)) {
                    oDao = (DaoInterface) new Usuario0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    break;
                } else {
                    switch (SessionHelper.getIdTipoUsuario(oMBHUsuarioSession)) {
                        case 1:
                            oDao = (DaoInterface) new Usuario1SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        case 3:
                            oDao = (DaoInterface) new Usuario3SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        case 4:
                            oDao = (DaoInterface) new Usuario4SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        case 5:
                            oDao = (DaoInterface) new Usuario5SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        default:
                            oDao = (DaoInterface) new Usuario0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                    }
                }
                break;
            case "tipousuario":
                if (SessionHelper.thereIsNOSession(oMBHUsuarioSession)) {
                    oDao = (DaoInterface) new Tipousuario0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    break;
                } else {
                    switch (SessionHelper.getIdTipoUsuario(oMBHUsuarioSession)) {
                        case 1:
                            oDao = (DaoInterface) new Tipousuario1SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        default:
                            oDao = (DaoInterface) new Tipousuario0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                    }
                }
                break;
            case "log":
                if (SessionHelper.thereIsNOSession(oMBHUsuarioSession)) {
                    oDao = (DaoInterface) new Log0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    break;
                } else {

                    switch (SessionHelper.getIdTipoUsuario(oMBHUsuarioSession)) {
                        case 1:
                            oDao = (DaoInterface) new Log1SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        default:
                            oDao = (DaoInterface) new Log0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                    }
                }
                break;
            case "grupo":
                if (SessionHelper.thereIsNOSession(oMBHUsuarioSession)) {
                    oDao = (DaoInterface) new Grupo1SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    break;
                } else {
                    switch (SessionHelper.getIdTipoUsuario(oMBHUsuarioSession)) {
                        case 1:
                            oDao = (DaoInterface) new Grupo1SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        case 3:
                            oDao = (DaoInterface) new Grupo3SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        case 4:
                            oDao = (DaoInterface) new Grupo4SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        case 5:
                            oDao = (DaoInterface) new Grupo5SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        default:
                            oDao = (DaoInterface) new Grupo1SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                    }
                }
                break;
            case "curso":
                if (SessionHelper.thereIsNOSession(oMBHUsuarioSession)) {
                    oDao = (DaoInterface) new Curso0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    break;
                } else {
                    switch (SessionHelper.getIdTipoUsuario(oMBHUsuarioSession)) {
                        case 1:
                            oDao = (DaoInterface) new Curso1SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        default:
                            oDao = (DaoInterface) new Curso0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                    }
                }
                break;
            case "centro":
                if (SessionHelper.thereIsNOSession(oMBHUsuarioSession)) {
                    oDao = (DaoInterface) new Centro0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    break;
                } else {
                    switch (SessionHelper.getIdTipoUsuario(oMBHUsuarioSession)) {
                        case 1:
                            oDao = (DaoInterface) new Centro1SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        case 3:
                            oDao = (DaoInterface) new Centro0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        case 4:
                            oDao = (DaoInterface) new Centro0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        case 5:
                            oDao = (DaoInterface) new Centro0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        default:
                            oDao = (DaoInterface) new Centro0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                    }
                }
                break;
            case "centrosanitario":
                if (SessionHelper.thereIsNOSession(oMBHUsuarioSession)) {
                    oDao = (DaoInterface) new Centrosanitario0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    break;
                } else {
                    switch (SessionHelper.getIdTipoUsuario(oMBHUsuarioSession)) {
                        case 1:
                            oDao = (DaoInterface) new Centrosanitario1SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        case 3:
                            oDao = (DaoInterface) new Centrosanitario0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        case 4:
                            oDao = (DaoInterface) new Centrosanitario0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        case 5:
                            oDao = (DaoInterface) new Centrosanitario0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        default:
                            oDao = (DaoInterface) new Centrosanitario1SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                    }
                }
                break;
            //------------------------------------------------------------------
            case "paciente":
                if (SessionHelper.thereIsNOSession(oMBHUsuarioSession)) {
                    oDao = (DaoInterface) new Paciente0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                } else {
                    switch (SessionHelper.getIdTipoUsuario(oMBHUsuarioSession)) {
                        case 1:
                            oDao = (DaoInterface) new Paciente1SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        case 3:
                            oDao = (DaoInterface) new Paciente3SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        case 4:
                            oDao = (DaoInterface) new Paciente4SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        case 5:
                            oDao = (DaoInterface) new Paciente5SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        default:
                            oDao = (DaoInterface) new Paciente0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                    }
                }
                break;
            case "sexo":
                if (SessionHelper.thereIsNOSession(oMBHUsuarioSession)) {
                    oDao = (DaoInterface) new Sexo0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                } else {
                    if (SessionHelper.getIdTipoUsuario(oMBHUsuarioSession) == 1) {
                        oDao = (DaoInterface) new Sexo1SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    } else {
                        oDao = (DaoInterface) new Sexo0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    }
                }
                break;
            case "tipopago":
                if (SessionHelper.thereIsNOSession(oMBHUsuarioSession)) {
                    oDao = (DaoInterface) new Tipopago0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                } else {
                    if (SessionHelper.getIdTipoUsuario(oMBHUsuarioSession) == 1) {
                        oDao = (DaoInterface) new Tipopago1SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    } else {
                        oDao = (DaoInterface) new Tipopago0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    }
                }
                break;
            //------------------------------------------------------------------
            case "medico":
                if (SessionHelper.thereIsNOSession(oMBHUsuarioSession)) {
                    oDao = (DaoInterface) new Medico0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    break;
                } else {
                    switch (SessionHelper.getIdTipoUsuario(oMBHUsuarioSession)) {
                        case 1:
                            oDao = (DaoInterface) new Medico1SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        case 3:
                            oDao = (DaoInterface) new Medico3SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        case 4:
                            oDao = (DaoInterface) new Medico4SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        case 5:
                            oDao = (DaoInterface) new Medico5SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        default:
                            oDao = (DaoInterface) new Medico0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                    }
                }
                break;
            case "especialidad":
                if (SessionHelper.thereIsNOSession(oMBHUsuarioSession)) {
                    oDao = (DaoInterface) new Especialidad0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                } else {
                    if (SessionHelper.getIdTipoUsuario(oMBHUsuarioSession) == 1) {
                        oDao = (DaoInterface) new Especialidad1SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    } else {
                        oDao = (DaoInterface) new Especialidad0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    }
                }
                break;
            case "categoriaprofesional":
                if (SessionHelper.thereIsNOSession(oMBHUsuarioSession)) {
                    oDao = (DaoInterface) new Categoriaprofesional0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                } else {
                    if (SessionHelper.getIdTipoUsuario(oMBHUsuarioSession) == 1) {
                        oDao = (DaoInterface) new Categoriaprofesional1SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    } else {
                        oDao = (DaoInterface) new Categoriaprofesional0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    }
                }
                break;
            //------------------------------------------------------------------
            case "servicio":

                if (SessionHelper.thereIsNOSession(oMBHUsuarioSession)) {
                    oDao = (DaoInterface) new Servicio0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                } else {
                    if (SessionHelper.getIdTipoUsuario(oMBHUsuarioSession) == 1) {
                        oDao = (DaoInterface) new Servicio1SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    } else {
                        oDao = (DaoInterface) new Servicio0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    }
                }
                break;
            case "tiposervicio":
                if (SessionHelper.thereIsNOSession(oMBHUsuarioSession)) {
                    oDao = (DaoInterface) new Tiposervicio0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                } else {
                    if (SessionHelper.getIdTipoUsuario(oMBHUsuarioSession) == 1) {
                        oDao = (DaoInterface) new Tiposervicio1SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    } else {
                        oDao = (DaoInterface) new Tiposervicio0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    }
                }
                break;
            //------------------------------------------------------------------
            case "episodio":
                if (SessionHelper.thereIsNOSession(oMBHUsuarioSession)) {
                    oDao = (DaoInterface) new Episodio0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    break;
                } else {
                    switch (SessionHelper.getIdTipoUsuario(oMBHUsuarioSession)) {
                        case 1:
                            oDao = (DaoInterface) new Episodio1SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        case 3:
                            oDao = (DaoInterface) new Episodio3SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        case 4:
                            oDao = (DaoInterface) new Episodio4SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        case 5:
                            oDao = (DaoInterface) new Episodio5SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        default:
                            oDao = (DaoInterface) new Episodio0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                    }

                }
                break;
            case "subepisodio":
                if (SessionHelper.thereIsNOSession(oMBHUsuarioSession)) {
                    oDao = (DaoInterface) new Subepisodio0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    break;
                } else {
                    switch (SessionHelper.getIdTipoUsuario(oMBHUsuarioSession)) {
                        case 1:
                            oDao = (DaoInterface) new Subepisodio1SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        case 3:
                            oDao = (DaoInterface) new Subepisodio3SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        case 4:
                            oDao = (DaoInterface) new Subepisodio4SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        case 5:
                            oDao = (DaoInterface) new Subepisodio5SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        default:
                            oDao = (DaoInterface) new Subepisodio0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                    }

                }
                break;
            case "tipoepisodio":
                if (SessionHelper.thereIsNOSession(oMBHUsuarioSession)) {
                    oDao = (DaoInterface) new Tipoepisodio0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                } else {
                    if (SessionHelper.getIdTipoUsuario(oMBHUsuarioSession) == 1) {
                        oDao = (DaoInterface) new Tipoepisodio1SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    } else {
                        oDao = (DaoInterface) new Tipoepisodio0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    }
                }
                break;
            case "modalidadepisodio":
                if (SessionHelper.thereIsNOSession(oMBHUsuarioSession)) {
                    oDao = (DaoInterface) new Modalidadepisodio0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                } else {
                    if (SessionHelper.getIdTipoUsuario(oMBHUsuarioSession) == 1) {
                        oDao = (DaoInterface) new Modalidadepisodio1SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    } else {
                        oDao = (DaoInterface) new Modalidadepisodio0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    }
                }
                break;
            case "factura":
                if (SessionHelper.thereIsNOSession(oMBHUsuarioSession)) {
                    oDao = (DaoInterface) new Factura0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                } else {
                    if (SessionHelper.getIdTipoUsuario(oMBHUsuarioSession) == 1) {
                        oDao = (DaoInterface) new Factura1SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    } else {
                        oDao = (DaoInterface) new Factura0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    }
                }
                break;
            case "destinoalta":
                if (SessionHelper.thereIsNOSession(oMBHUsuarioSession)) {
                    oDao = (DaoInterface) new Destinoalta0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                } else {
                    if (SessionHelper.getIdTipoUsuario(oMBHUsuarioSession) == 1) {
                        oDao = (DaoInterface) new Destinoalta1SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    } else {
                        oDao = (DaoInterface) new Destinoalta0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    }
                }
                break;
            case "circunstanciasalta":
                if (SessionHelper.thereIsNOSession(oMBHUsuarioSession)) {
                    oDao = (DaoInterface) new Circunstanciasalta0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                } else {
                    if (SessionHelper.getIdTipoUsuario(oMBHUsuarioSession) == 1) {
                        oDao = (DaoInterface) new Circunstanciasalta1SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    } else {
                        oDao = (DaoInterface) new Circunstanciasalta0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    }
                }
                break;
            case "presenciadiagnostico":
                if (SessionHelper.thereIsNOSession(oMBHUsuarioSession)) {
                    oDao = (DaoInterface) new Presenciadiagnostico0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                } else {
                    if (SessionHelper.getIdTipoUsuario(oMBHUsuarioSession) == 1) {
                        oDao = (DaoInterface) new Presenciadiagnostico1SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    } else {
                        oDao = (DaoInterface) new Presenciadiagnostico0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    }
                }
                break;
            case "presenciadiagnosticoingreso":
                if (SessionHelper.thereIsNOSession(oMBHUsuarioSession)) {
                    oDao = (DaoInterface) new Presenciadiagnosticoingreso0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                } else {
                    if (SessionHelper.getIdTipoUsuario(oMBHUsuarioSession) == 1) {
                        oDao = (DaoInterface) new Presenciadiagnosticoingreso1SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    } else {
                        oDao = (DaoInterface) new Presenciadiagnosticoingreso0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    }
                }
                break;
            case "tipodiagnostico":
                if (SessionHelper.thereIsNOSession(oMBHUsuarioSession)) {
                    oDao = (DaoInterface) new Tipodiagnostico0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                } else {
                    if (SessionHelper.getIdTipoUsuario(oMBHUsuarioSession) == 1) {
                        oDao = (DaoInterface) new Tipodiagnostico1SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    } else {
                        oDao = (DaoInterface) new Tipodiagnostico0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    }
                }
                break;
            case "catalogodiagnosticos":
                oDao = (DaoInterface) new Catalogodiagnosticos0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                break;
            //------------------------------------------------------------------
            case "episodiodiagnostico":
                if (SessionHelper.thereIsNOSession(oMBHUsuarioSession)) {
                    oDao = (DaoInterface) new Episodiodiagnostico0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    break;
                } else {;
                    switch (SessionHelper.getIdTipoUsuario(oMBHUsuarioSession)) {
                        case 1:
                            oDao = (DaoInterface) new Episodiodiagnostico1SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        case 3:
                            oDao = (DaoInterface) new Episodiodiagnostico3SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        case 4:
                            oDao = (DaoInterface) new Episodiodiagnostico4SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        case 5:
                            oDao = (DaoInterface) new Episodiodiagnostico5SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        default:
                            oDao = (DaoInterface) new Episodiodiagnostico0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                    }

                }
                break;
            //------------------------------------------------------------------
            case "dependencia":
                if (SessionHelper.thereIsNOSession(oMBHUsuarioSession)) {
                    oDao = (DaoInterface) new Dependencia0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    break;
                } else {
                    switch (SessionHelper.getIdTipoUsuario(oMBHUsuarioSession)) {
                        case 1:
                            oDao = (DaoInterface) new Dependencia1SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        case 3:
                            oDao = (DaoInterface) new Dependencia3SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        case 4:
                            oDao = (DaoInterface) new Dependencia4SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        case 5:
                            oDao = (DaoInterface) new Dependencia5SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        default:
                            oDao = (DaoInterface) new Dependencia0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                    }
                }
                break;
            case "tipodependencia":
                if (SessionHelper.thereIsNOSession(oMBHUsuarioSession)) {
                    oDao = (DaoInterface) new Tipodependencia0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                } else {
                    if (SessionHelper.getIdTipoUsuario(oMBHUsuarioSession) == 1) {
                        oDao = (DaoInterface) new Tipodependencia1SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    } else {
                        oDao = (DaoInterface) new Tipodependencia0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    }
                }
                break;
            //------------------------------------------------------------------
            case "nombremasculino":
                if (SessionHelper.thereISSession(oMBHUsuarioSession)) {
                    if (SessionHelper.getIdTipoUsuario(oMBHUsuarioSession) == 1 || SessionHelper.getIdTipoUsuario(oMBHUsuarioSession) == 3) {
                        oDao = (DaoInterface) new NombremasculinoSpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    }
                }
                break;
            //------------------------------------------------------------------
            case "nombrefemenino":
                if (SessionHelper.thereISSession(oMBHUsuarioSession)) {
                    if (SessionHelper.getIdTipoUsuario(oMBHUsuarioSession) == 1 || SessionHelper.getIdTipoUsuario(oMBHUsuarioSession) == 3) {
                        oDao = (DaoInterface) new NombrefemeninoSpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    }
                }
                break;
            //------------------------------------------------------------------
            case "apellido":
                if (SessionHelper.thereISSession(oMBHUsuarioSession)) {;
                    if (SessionHelper.getIdTipoUsuario(oMBHUsuarioSession) == 1 || SessionHelper.getIdTipoUsuario(oMBHUsuarioSession) == 3) {
                        oDao = (DaoInterface) new ApellidoSpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    }
                }
                break;
            //------------------------------------------------------------------
            case "municipio":
                if (SessionHelper.thereISSession(oMBHUsuarioSession)) {
                    if (SessionHelper.getIdTipoUsuario(oMBHUsuarioSession) == 1 || SessionHelper.getIdTipoUsuario(oMBHUsuarioSession) == 3) {
                        oDao = (DaoInterface) new MunicipioSpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    }
                }
                break;
            //------------------------------------------------------------------
            case "via":
                if (SessionHelper.thereISSession(oMBHUsuarioSession)) {
                    if (SessionHelper.getIdTipoUsuario(oMBHUsuarioSession) == 1 || SessionHelper.getIdTipoUsuario(oMBHUsuarioSession) == 3) {
                        oDao = (DaoInterface) new ViaSpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    }
                }
                break;
            //------------------------------------------------------------------
            case "provincia":
                if (SessionHelper.thereISSession(oMBHUsuarioSession)) {
                    if (SessionHelper.getIdTipoUsuario(oMBHUsuarioSession) == 1 || SessionHelper.getIdTipoUsuario(oMBHUsuarioSession) == 3) {
                        oDao = (DaoInterface) new ProvinciaSpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    }
                }
                break;
            //------------------------------------------------------------------
            case "comunidad":
                if (SessionHelper.thereISSession(oMBHUsuarioSession)) {
                    if (SessionHelper.getIdTipoUsuario(oMBHUsuarioSession) == 1 || SessionHelper.getIdTipoUsuario(oMBHUsuarioSession) == 3) {
                        oDao = (DaoInterface) new ComunidadSpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    }
                }
                break;
            //------------------------------------------------------------------

            case "catalogoprocedimientos":
                oDao = (DaoInterface) new Catalogoprocedimientos0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                break;

            case "categoriaprofesionalps":
                if (SessionHelper.thereIsNOSession(oMBHUsuarioSession)) {
                    oDao = (DaoInterface) new Categoriaprofesionalps0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                } else {
                    if (SessionHelper.getIdTipoUsuario(oMBHUsuarioSession) == 1) {
                        oDao = (DaoInterface) new Categoriaprofesionalps1SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    } else {
                        oDao = (DaoInterface) new Categoriaprofesionalps0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    }
                }
                break;
            case "episodioprocedimiento":

                if (SessionHelper.thereIsNOSession(oMBHUsuarioSession)) {
                    oDao = (DaoInterface) new Episodioprocedimiento0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    break;
                } else {
                    switch (SessionHelper.getIdTipoUsuario(oMBHUsuarioSession)) {
                        case 1:
                            oDao = (DaoInterface) new Episodioprocedimiento1SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        case 3:
                            oDao = (DaoInterface) new Episodioprocedimiento3SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        case 4:
                            oDao = (DaoInterface) new Episodioprocedimiento4SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        case 5:
                            oDao = (DaoInterface) new Episodioprocedimiento5SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        default:
                            oDao = (DaoInterface) new Episodioprocedimiento0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                    }

                }
                break;
            case "estado":
                if (SessionHelper.thereIsNOSession(oMBHUsuarioSession)) {
                    oDao = (DaoInterface) new Estado0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                } else {
                    if (SessionHelper.getIdTipoUsuario(oMBHUsuarioSession) == 1) {
                        oDao = (DaoInterface) new Estado1SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    } else {
                        oDao = (DaoInterface) new Estado0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    }
                }
                break;
            case "personalsanitario":
                if (SessionHelper.thereIsNOSession(oMBHUsuarioSession)) {
                    oDao = (DaoInterface) new Personalsanitario0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    break;
                } else {
                    switch (SessionHelper.getIdTipoUsuario(oMBHUsuarioSession)) {
                        case 1:
                            oDao = (DaoInterface) new Personalsanitario1SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        case 3:
                            oDao = (DaoInterface) new Personalsanitario3SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        case 4:
                            oDao = (DaoInterface) new Personalsanitario4SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        case 5:
                            oDao = (DaoInterface) new Personalsanitario5SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        default:
                            oDao = (DaoInterface) new Personalsanitario0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                    }

                }
                break;

            case "prioridad":
                if (SessionHelper.thereIsNOSession(oMBHUsuarioSession)) {
                    oDao = (DaoInterface) new Prioridad0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                } else {
                    if (SessionHelper.getIdTipoUsuario(oMBHUsuarioSession) == 1) {
                        oDao = (DaoInterface) new Prioridad1SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    } else {
                        oDao = (DaoInterface) new Prioridad0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    }
                }
                break;
            case "procedimiento":
                if (SessionHelper.thereIsNOSession(oMBHUsuarioSession)) {
                    oDao = (DaoInterface) new Procedimiento0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    break;
                } else {
                    switch (SessionHelper.getIdTipoUsuario(oMBHUsuarioSession)) {
                        case 1:
                            oDao = (DaoInterface) new Procedimiento1SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        case 3:
                            oDao = (DaoInterface) new Procedimiento3SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        case 4:
                            oDao = (DaoInterface) new Procedimiento4SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        case 5:
                            oDao = (DaoInterface) new Procedimiento5SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        default:
                            oDao = (DaoInterface) new Procedimiento0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                    }

                }
                break;
            case "procedimientodiagnosticofinal":
                if (SessionHelper.thereIsNOSession(oMBHUsuarioSession)) {
                    oDao = (DaoInterface) new Procedimientodiagnosticofinal0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    break;
                } else {
                    switch (SessionHelper.getIdTipoUsuario(oMBHUsuarioSession)) {
                        case 1:
                            oDao = (DaoInterface) new Procedimientodiagnosticofinal1SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        case 3:
                            oDao = (DaoInterface) new Procedimientodiagnosticofinal3SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        case 4:
                            oDao = (DaoInterface) new Procedimientodiagnosticofinal4SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        case 5:
                            oDao = (DaoInterface) new Procedimientodiagnosticofinal5SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        default:
                            oDao = (DaoInterface) new Procedimientodiagnosticofinal0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                    }

                }
                break;
            case "procedimientodiagnosticoinicial":
                if (SessionHelper.thereIsNOSession(oMBHUsuarioSession)) {
                    oDao = (DaoInterface) new Procedimientodiagnosticoinicial0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    break;
                } else {
                    switch (SessionHelper.getIdTipoUsuario(oMBHUsuarioSession)) {
                        case 1:
                            oDao = (DaoInterface) new Procedimientodiagnosticoinicial1SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        case 3:
                            oDao = (DaoInterface) new Procedimientodiagnosticoinicial3SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        case 4:
                            oDao = (DaoInterface) new Procedimientodiagnosticoinicial4SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        case 5:
                            oDao = (DaoInterface) new Procedimientodiagnosticoinicial5SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        default:
                            oDao = (DaoInterface) new Procedimientodiagnosticoinicial0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                    }

                }
                break;

            case "procedimientomedico":
                if (SessionHelper.thereIsNOSession(oMBHUsuarioSession)) {
                    oDao = (DaoInterface) new Procedimientomedico0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    break;
                } else {
                    switch (SessionHelper.getIdTipoUsuario(oMBHUsuarioSession)) {
                        case 1:
                            oDao = (DaoInterface) new Procedimientomedico1SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        case 3:
                            oDao = (DaoInterface) new Procedimientomedico3SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        case 4:
                            oDao = (DaoInterface) new Procedimientomedico4SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        case 5:
                            oDao = (DaoInterface) new Procedimientomedico5SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        default:
                            oDao = (DaoInterface) new Procedimientomedico0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                    }

                }
                break;
            case "procedimientopersonalsanitario":
                if (SessionHelper.thereIsNOSession(oMBHUsuarioSession)) {
                    oDao = (DaoInterface) new Procedimientopersonalsanitario0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    break;
                } else {
                    switch (SessionHelper.getIdTipoUsuario(oMBHUsuarioSession)) {
                        case 1:
                            oDao = (DaoInterface) new Procedimientopersonalsanitario1SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        case 3:
                            oDao = (DaoInterface) new Procedimientopersonalsanitario3SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        case 4:
                            oDao = (DaoInterface) new Procedimientopersonalsanitario4SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        case 5:
                            oDao = (DaoInterface) new Procedimientopersonalsanitario5SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                        default:
                            oDao = (DaoInterface) new Procedimientopersonalsanitario0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                            break;
                    }

                }
                break;
            case "tipoprocedimiento":
                if (SessionHelper.thereIsNOSession(oMBHUsuarioSession)) {
                    oDao = (DaoInterface) new Tipoprocedimiento0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                } else {
                    if (SessionHelper.getIdTipoUsuario(oMBHUsuarioSession) == 1) {
                        oDao = (DaoInterface) new Tipoprocedimiento1SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    } else {
                        oDao = (DaoInterface) new Tipoprocedimiento0SpecificDaoImplementation(oConnection, oMBHUsuarioSession, strWhere);
                    }
                }
                break;

            default:
                //TraceHelper.traceError("DAO not found: can't create DAO in DaoFactory for " + ob);
                //throw new Exception("Object not found: " + ob);
                break;
        }
        return oDao;
    }

}
