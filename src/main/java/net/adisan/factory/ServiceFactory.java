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


import net.adisan.bean.helper.ReplyBeanHelper;
import net.adisan.helper.EncodingHelper;
import net.adisan.service.specificimplementation.CategoriaprofesionalSpecificServiceImplementation;
import net.adisan.service.specificimplementation.CentroSpecificServiceImplementation;
import net.adisan.service.specificimplementation.CentrosanitarioSpecificServiceImplementation;
import net.adisan.service.specificimplementation.TipoepisodioSpecificServiceImplementation;
import net.adisan.service.specificimplementation.CircunstanciasaltaSpecificServiceImplementation;
import net.adisan.service.specificimplementation.CursoSpecificServiceImplementation;
import net.adisan.service.specificimplementation.DependenciaSpecificServiceImplementation;
import net.adisan.service.specificimplementation.EspecialidadSpecificServiceImplementation;
import net.adisan.service.specificimplementation.DestinoaltaSpecificServiceImplementation;
import net.adisan.service.specificimplementation.EpisodioSpecificServiceImplementation;
import net.adisan.service.specificimplementation.FacturaSpecificServiceImplementation;
import net.adisan.service.specificimplementation.GrupoSpecificServiceImplementation;
import net.adisan.service.specificimplementation.MedicoSpecificServiceImplementation;
import net.adisan.service.specificimplementation.ModalidadepisodioSpecificServiceImplementation;
import net.adisan.service.specificimplementation.PacienteSpecificServiceImplementation;
import net.adisan.service.specificimplementation.ServicioSpecificServiceImplementation;
import net.adisan.service.specificimplementation.TipopagoSpecificServiceImplementation;
import net.adisan.service.specificimplementation.SexoSpecificServiceImplementation;
import net.adisan.service.specificimplementation.SubepisodioSpecificServiceImplementation;
import net.adisan.service.specificimplementation.TipodependenciaSpecificServiceImplementation;
import net.adisan.service.specificimplementation.TiposervicioSpecificServiceImplementation;
import net.adisan.service.specificimplementation.TipousuarioSpecificServiceImplementation;
import net.adisan.service.specificimplementation.UsuarioSpecificServiceImplementation;
import javax.servlet.http.HttpServletRequest;
import net.adisan.service.specificimplementation.CatalogodiagnosticosSpecificServiceImplementation;
import net.adisan.service.specificimplementation.CatalogoprocedimientosSpecificServiceImplementation;
import net.adisan.service.specificimplementation.CategoriaprofesionalpsSpecificServiceImplementation;
import net.adisan.service.specificimplementation.EpisodiodiagnosticoSpecificServiceImplementation;
import net.adisan.service.specificimplementation.EpisodioprocedimientoSpecificServiceImplementation;
import net.adisan.service.specificimplementation.EstadoSpecificServiceImplementation;
import net.adisan.service.specificimplementation.LogSpecificServiceImplementation;
import net.adisan.service.specificimplementation.PersonalsanitarioSpecificServiceImplementation;
import net.adisan.service.specificimplementation.PresenciadiagnosticoSpecificServiceImplementation;
import net.adisan.service.specificimplementation.PresenciadiagnosticoingresoSpecificServiceImplementation;
import net.adisan.service.specificimplementation.PrioridadSpecificServiceImplementation;
import net.adisan.service.specificimplementation.ProcedimientoSpecificServiceImplementation;
import net.adisan.service.specificimplementation.ProcedimientodiagnosticofinalSpecificServiceImplementation;
import net.adisan.service.specificimplementation.ProcedimientodiagnosticoinicialSpecificServiceImplementation;
import net.adisan.service.specificimplementation.ProcedimientomedicoSpecificServiceImplementation;
import net.adisan.service.specificimplementation.ProcedimientopersonalsanitarioSpecificServiceImplementation;
import net.adisan.service.specificimplementation.TipodiagnosticoSpecificServiceImplementation;
import net.adisan.service.specificimplementation.TipoprocedimientoSpecificServiceImplementation;

public class ServiceFactory {

//    public static Method getServiceMethod(HttpServletRequest oRequest) throws Exception {
//        String ob = oRequest.getParameter("ob");
//        String op = oRequest.getParameter("op");
//        Method oMethod  = null;
//        switch (ob) {
//            case "usuario":
//                UsuarioSpecificServiceImplementation oUsuarioService = new UsuarioSpecificServiceImplementation(oRequest);
//                switch (op) {
//                    case "getallobjectsmetadata":
//                        oMethod = UsuarioSpecificServiceImplementation.class.getMethod("getallobjectsmetadata");
//                        break;
//                    case "getmetadata":
//                        oMethod = UsuarioSpecificServiceImplementation.class.getMethod("getmetadata");
//                        break;
//                    case "getobjectmetadata":
//                        oMethod = UsuarioSpecificServiceImplementation.class.getMethod("getmetadata");
//                        break;
//                    case "getpropertiesmetadata":
//                        oMethod = UsuarioSpecificServiceImplementation.class.getMethod("getmetadata");
//                        break;
//                    case "get":
//                        oMethod = UsuarioSpecificServiceImplementation.class.getMethod("getmetadata");
//                        break;
//                    case "set":
//                        oMethod = UsuarioSpecificServiceImplementation.class.getMethod("getmetadata");
//                        break;
//                    case "remove":
//                        oMethod = UsuarioSpecificServiceImplementation.class.getMethod("getmetadata");
//                        break;
//                    case "getpage":
//                        oMethod = UsuarioSpecificServiceImplementation.class.getMethod("getmetadata");
//                        break;
//                    case "getcount":
//                        oMethod = UsuarioSpecificServiceImplementation.class.getMethod("getmetadata");
//                        break;
//                    case "login":
//                        oMethod = UsuarioSpecificServiceImplementation.class.getMethod("getmetadata");
//                        break;
//                    case "logout":
//                        oMethod = UsuarioSpecificServiceImplementation.class.getMethod("getmetadata");
//                        break;
//                    case "getsessionstatus":
//                        oMethod = UsuarioSpecificServiceImplementation.class.getMethod("getmetadata");
//                        break;
//                    case "getcountx":
//                        oMethod = UsuarioSpecificServiceImplementation.class.getMethod("getmetadata");
//                        break;
//                    case "getpagex":
//                        oMethod = UsuarioSpecificServiceImplementation.class.getMethod("getmetadata");
//                        break;
//                    case "setpass":
//                        oMethod = UsuarioSpecificServiceImplementation.class.getMethod("getmetadata");
//                        break;
//                    case "getsessionuserlevel":
//                        oMethod = UsuarioSpecificServiceImplementation.class.getMethod("getmetadata");
//                        break;
//                    case "checklogin":
//                        oMethod = UsuarioSpecificServiceImplementation.class.getMethod("getmetadata");
//                        break;
//                    case "setalumno":
//                        oMethod = UsuarioSpecificServiceImplementation.class.getMethod("getmetadata");
//                        break;
//                    case "getidcurso":
//                        oMethod = UsuarioSpecificServiceImplementation.class.getMethod("getmetadata");
//                        break;
//                    case "activate":
//                        oMethod = UsuarioSpecificServiceImplementation.class.getMethod("getmetadata");
//                        break;
//                    case "deactivate":
//                        oMethod = UsuarioSpecificServiceImplementation.class.getMethod("getmetadata");
//                        break;
//                    case "resetpass":
//                        oMethod = UsuarioSpecificServiceImplementation.class.getMethod("getmetadata");
//                        break;
//                    default:
//                        throw new Exception("Operation not found for object usuario");
//                }
//                break;
//                
//            default:
//                throw new Exception("Object not found");
//        }
//            return oMethod;
//    }
    public static ReplyBeanHelper executeMethodService(HttpServletRequest oRequest) throws Exception {
        String ob = oRequest.getParameter("ob");
        String op = oRequest.getParameter("op");
        ReplyBeanHelper oReplyBean = null;

        switch (ob) {
            case "usuario":
                UsuarioSpecificServiceImplementation oUsuarioService = new UsuarioSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata": //pte de pasar a ob=metadata
                        oReplyBean = oUsuarioService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oUsuarioService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oUsuarioService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oUsuarioService.get();
                        break;
                    case "set":
                        oReplyBean = oUsuarioService.set();
                        break;
                    case "remove":
                        oReplyBean = oUsuarioService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oUsuarioService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oUsuarioService.getCount();
                        break;
                    case "login":
                        oReplyBean = oUsuarioService.login();
                        break;
                    case "logout":
                        oReplyBean = oUsuarioService.logout();
                        break;
                    case "getsessionstatus":
                        oReplyBean = oUsuarioService.getSessionStatus();
                        break;
                    case "getcountx":
                        oReplyBean = oUsuarioService.getCountX();
                        break;
                    case "getpagex":
                        oReplyBean = oUsuarioService.getPageX();
                        break;
                    case "setpass":
                        oReplyBean = oUsuarioService.setPass();
                        break;
                    case "getsessionuserlevel":
                        oReplyBean = oUsuarioService.getSessionUserLevel();
                        break;
                    case "checklogin":
                        oReplyBean = oUsuarioService.checklogin();
                        break;
                    case "setalumno":
                        oReplyBean = oUsuarioService.setalumno();
                        break;
                    case "getidcurso":
                        oReplyBean = oUsuarioService.getidcurso();
                        break;
                    case "activate":
                        oReplyBean = oUsuarioService.activate();
                        break;
                    case "deactivate":
                        oReplyBean = oUsuarioService.deactivate();
                        break;
                    case "resetpass":
                        oReplyBean = oUsuarioService.resetPass();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;
            case "tipousuario":
                TipousuarioSpecificServiceImplementation oTipousuarioService = new TipousuarioSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oTipousuarioService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oTipousuarioService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oTipousuarioService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oTipousuarioService.get();
                        break;
                    //                    case "set":
                    //                        oReplyBean = oTipousuarioService.set();
                    //                        break;
                    //                    case "remove":
                    //                        oReplyBean = oTipousuarioService.remove();
                    //                        break;
                    case "getpage":
                        oReplyBean = oTipousuarioService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oTipousuarioService.getCount();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;
            case "log":
                LogSpecificServiceImplementation oLogService = new LogSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oLogService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oLogService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oLogService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oLogService.get();
                        break;
                    case "getpage":
                        oReplyBean = oLogService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oLogService.getCount();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;
            case "grupo":
                GrupoSpecificServiceImplementation oGrupoService = new GrupoSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "check":
                        oReplyBean = oGrupoService.check();
                        break;
                    case "getmetadata":
                        oReplyBean = oGrupoService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oGrupoService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oGrupoService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oGrupoService.get();
                        break;
                    case "set":
                        oReplyBean = oGrupoService.set();
                        break;
                    case "remove":
                        oReplyBean = oGrupoService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oGrupoService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oGrupoService.getCount();
                        break;
                    case "getcountx":
                        oReplyBean = oGrupoService.getCountX();
                        break;
                    case "getpagex":
                        oReplyBean = oGrupoService.getPageX();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;
            case "curso":
                CursoSpecificServiceImplementation oCursoService = new CursoSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oCursoService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oCursoService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oCursoService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oCursoService.get();
                        break;
                    case "set":
                        oReplyBean = oCursoService.set();
                        break;
                    case "remove":
                        oReplyBean = oCursoService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oCursoService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oCursoService.getCount();
                        break;
                    case "getcountx":
                        oReplyBean = oCursoService.getCountX();
                        break;
                    case "getpagex":
                        oReplyBean = oCursoService.getPageX();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;
            case "centrosanitario":
                CentrosanitarioSpecificServiceImplementation oCentrosanitarioService = new CentrosanitarioSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oCentrosanitarioService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oCentrosanitarioService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oCentrosanitarioService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oCentrosanitarioService.get();
                        break;
                    case "set":
                        oReplyBean = oCentrosanitarioService.set();
                        break;
                    case "remove":
                        oReplyBean = oCentrosanitarioService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oCentrosanitarioService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oCentrosanitarioService.getCount();
                        break;
                    case "getcountx":
                        oReplyBean = oCentrosanitarioService.getCountX();
                        break;
                    case "getpagex":
                        oReplyBean = oCentrosanitarioService.getPageX();
                        break;
                    case "getStatistics":
                        oReplyBean = oCentrosanitarioService.getStatistics();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;
            case "centro":
                CentroSpecificServiceImplementation oCentroService = new CentroSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oCentroService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oCentroService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oCentroService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oCentroService.get();
                        break;
                    case "set":
                        oReplyBean = oCentroService.set();
                        break;
                    case "remove":
                        oReplyBean = oCentroService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oCentroService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oCentroService.getCount();
                        break;
                    case "getcountx":
                        oReplyBean = oCentroService.getCountX();
                        break;
                    case "getpagex":
                        oReplyBean = oCentroService.getPageX();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;
            case "especialidad":
                EspecialidadSpecificServiceImplementation oEspecialidadService = new EspecialidadSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oEspecialidadService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oEspecialidadService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oEspecialidadService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oEspecialidadService.get();
                        break;
                    case "set":
                        oReplyBean = oEspecialidadService.set();
                        break;
                    case "remove":
                        oReplyBean = oEspecialidadService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oEspecialidadService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oEspecialidadService.getCount();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;
            case "destinoalta":
                DestinoaltaSpecificServiceImplementation oDestinoaltaService = new DestinoaltaSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oDestinoaltaService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oDestinoaltaService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oDestinoaltaService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oDestinoaltaService.get();
                        break;
                    case "set":
                        oReplyBean = oDestinoaltaService.set();
                        break;
                    case "remove":
                        oReplyBean = oDestinoaltaService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oDestinoaltaService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oDestinoaltaService.getCount();
                        break;
                    case "getcountx":
                        oReplyBean = oDestinoaltaService.getCountX();
                        break;
                    case "getpagex":
                        oReplyBean = oDestinoaltaService.getPageX();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;
            case "tipopago":
                TipopagoSpecificServiceImplementation oTipopagoService = new TipopagoSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oTipopagoService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oTipopagoService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oTipopagoService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oTipopagoService.get();
                        break;
                    case "set":
                        oReplyBean = oTipopagoService.set();
                        break;
                    case "remove":
                        oReplyBean = oTipopagoService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oTipopagoService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oTipopagoService.getCount();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;
            case "circunstanciasalta":
                CircunstanciasaltaSpecificServiceImplementation oCircunstanciasaltaService = new CircunstanciasaltaSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oCircunstanciasaltaService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oCircunstanciasaltaService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oCircunstanciasaltaService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oCircunstanciasaltaService.get();
                        break;
                    case "set":
                        oReplyBean = oCircunstanciasaltaService.set();
                        break;
                    case "remove":
                        oReplyBean = oCircunstanciasaltaService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oCircunstanciasaltaService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oCircunstanciasaltaService.getCount();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;
            case "sexo":
                SexoSpecificServiceImplementation oSexoService = new SexoSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oSexoService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oSexoService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oSexoService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oSexoService.get();
                        break;
                    case "set":
                        oReplyBean = oSexoService.set();
                        break;
                    case "remove":
                        oReplyBean = oSexoService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oSexoService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oSexoService.getCount();
                        break;
                    case "getcountx":
                        oReplyBean = oSexoService.getCountX();
                        break;
                    case "getpagex":
                        oReplyBean = oSexoService.getPageX();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;
            case "tipoepisodio":
                TipoepisodioSpecificServiceImplementation oTipoepisodioService = new TipoepisodioSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oTipoepisodioService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oTipoepisodioService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oTipoepisodioService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oTipoepisodioService.get();
                        break;
                    case "set":
                        oReplyBean = oTipoepisodioService.set();
                        break;
                    case "remove":
                        oReplyBean = oTipoepisodioService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oTipoepisodioService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oTipoepisodioService.getCount();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;
            case "tiposervicio":
                TiposervicioSpecificServiceImplementation oTiposervicioService = new TiposervicioSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oTiposervicioService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oTiposervicioService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oTiposervicioService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oTiposervicioService.get();
                        break;
                    case "set":
                        oReplyBean = oTiposervicioService.set();
                        break;
                    case "remove":
                        oReplyBean = oTiposervicioService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oTiposervicioService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oTiposervicioService.getCount();
                        break;
                    case "getcountx":
                        oReplyBean = oTiposervicioService.getCountX();
                        break;
                    case "getpagex":
                        oReplyBean = oTiposervicioService.getPageX();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;
            case "modalidadepisodio":
                ModalidadepisodioSpecificServiceImplementation oModalidadepisodioService = new ModalidadepisodioSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oModalidadepisodioService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oModalidadepisodioService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oModalidadepisodioService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oModalidadepisodioService.get();
                        break;
                    case "set":
                        oReplyBean = oModalidadepisodioService.set();
                        break;
                    case "remove":
                        oReplyBean = oModalidadepisodioService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oModalidadepisodioService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oModalidadepisodioService.getCount();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }

                break;
            case "tipodependencia":
                TipodependenciaSpecificServiceImplementation oTipodependenciaService = new TipodependenciaSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oTipodependenciaService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oTipodependenciaService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oTipodependenciaService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oTipodependenciaService.get();
                        break;
                    case "set":
                        oReplyBean = oTipodependenciaService.set();
                        break;
                    case "remove":
                        oReplyBean = oTipodependenciaService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oTipodependenciaService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oTipodependenciaService.getCount();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;
            case "servicio":
                ServicioSpecificServiceImplementation oServicioService = new ServicioSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oServicioService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oServicioService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oServicioService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oServicioService.get();
                        break;
                    case "set":
                        oReplyBean = oServicioService.set();
                        break;
                    case "remove":
                        oReplyBean = oServicioService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oServicioService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oServicioService.getCount();
                        break;
                    case "getcountx":
                        oReplyBean = oServicioService.getCountX();
                        break;
                    case "getpagex":
                        oReplyBean = oServicioService.getPageX();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;
            case "factura":
                FacturaSpecificServiceImplementation oFacturaService = new FacturaSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oFacturaService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oFacturaService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oFacturaService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oFacturaService.get();
                        break;
                    case "set":
                        oReplyBean = oFacturaService.set();
                        break;
                    case "remove":
                        oReplyBean = oFacturaService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oFacturaService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oFacturaService.getCount();
                        break;
                    case "getcountx":
                        oReplyBean = oFacturaService.getCountX();
                        break;
                    case "getpagex":
                        oReplyBean = oFacturaService.getPageX();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;

            case "paciente":
                PacienteSpecificServiceImplementation oPacienteService = new PacienteSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oPacienteService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oPacienteService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oPacienteService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oPacienteService.get();
                        break;
                    case "set":
                        oReplyBean = oPacienteService.set();
                        break;
                    case "remove":
                        oReplyBean = oPacienteService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oPacienteService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oPacienteService.getCount();
                        break;
                    case "getcountx":
                        oReplyBean = oPacienteService.getCountX();
                        break;
                    case "getpagex":
                        oReplyBean = oPacienteService.getPageX();
                        break;
                    case "create":
                        oReplyBean = oPacienteService.create();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;

            case "categoriaprofesional":
                CategoriaprofesionalSpecificServiceImplementation oCategoriaService = new CategoriaprofesionalSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oCategoriaService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oCategoriaService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oCategoriaService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oCategoriaService.get();
                        break;
                    case "set":
                        oReplyBean = oCategoriaService.set();
                        break;
                    case "remove":
                        oReplyBean = oCategoriaService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oCategoriaService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oCategoriaService.getCount();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;

            case "episodio":
                EpisodioSpecificServiceImplementation oEpisodioService = new EpisodioSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oEpisodioService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oEpisodioService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oEpisodioService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oEpisodioService.get();
                        break;
                    case "set":
                        oReplyBean = oEpisodioService.set();
                        break;
                    case "remove":
                        oReplyBean = oEpisodioService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oEpisodioService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oEpisodioService.getCount();
                        break;
                    case "getcountx":
                        oReplyBean = oEpisodioService.getCountX();
                        break;
                    case "getpagex":
                        oReplyBean = oEpisodioService.getPageX();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;
            case "subepisodio":
                SubepisodioSpecificServiceImplementation oSubepisodioService = new SubepisodioSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oSubepisodioService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oSubepisodioService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oSubepisodioService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oSubepisodioService.get();
                        break;
                    case "set":
                        oReplyBean = oSubepisodioService.set();
                        break;
                    case "remove":
                        oReplyBean = oSubepisodioService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oSubepisodioService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oSubepisodioService.getCount();
                        break;
                    case "getcountx":
                        oReplyBean = oSubepisodioService.getCountX();
                        break;
                    case "getpagex":
                        oReplyBean = oSubepisodioService.getPageX();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;
            case "medico":
                MedicoSpecificServiceImplementation oMedicoService = new MedicoSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oMedicoService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oMedicoService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oMedicoService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oMedicoService.get();
                        break;
                    case "set":
                        oReplyBean = oMedicoService.set();
                        break;
                    case "remove":
                        oReplyBean = oMedicoService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oMedicoService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oMedicoService.getCount();
                        break;
                    case "getcountx":
                        oReplyBean = oMedicoService.getCountX();
                        break;
                    case "getpagex":
                        oReplyBean = oMedicoService.getPageX();
                        break;
                    case "rellenamedico":
                        oReplyBean = oMedicoService.rellenaMedico();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;
            case "dependencia":
                DependenciaSpecificServiceImplementation oDependenciaService = new DependenciaSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oDependenciaService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oDependenciaService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oDependenciaService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oDependenciaService.get();
                        break;
                    case "set":
                        oReplyBean = oDependenciaService.set();
                        break;
                    case "remove":
                        oReplyBean = oDependenciaService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oDependenciaService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oDependenciaService.getCount();
                        break;
                    case "getcountx":
                        oReplyBean = oDependenciaService.getCountX();
                        break;
                    case "getpagex":
                        oReplyBean = oDependenciaService.getPageX();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;

            case "catalogodiagnosticos":
                CatalogodiagnosticosSpecificServiceImplementation oDiagnosticoService = new CatalogodiagnosticosSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oDiagnosticoService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oDiagnosticoService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oDiagnosticoService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oDiagnosticoService.get();
                        break;
                    case "set":
                        oReplyBean = oDiagnosticoService.set();
                        break;
                    case "remove":
                        oReplyBean = oDiagnosticoService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oDiagnosticoService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oDiagnosticoService.getCount();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;
            case "presenciadiagnostico":
                PresenciadiagnosticoSpecificServiceImplementation oPresenciadiagnosticoService = new PresenciadiagnosticoSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oPresenciadiagnosticoService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oPresenciadiagnosticoService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oPresenciadiagnosticoService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oPresenciadiagnosticoService.get();
                        break;
                    case "set":
                        oReplyBean = oPresenciadiagnosticoService.set();
                        break;
                    case "remove":
                        oReplyBean = oPresenciadiagnosticoService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oPresenciadiagnosticoService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oPresenciadiagnosticoService.getCount();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;
            case "presenciadiagnosticoingreso":
                PresenciadiagnosticoingresoSpecificServiceImplementation oPresenciadiagnosticoingresoService = new PresenciadiagnosticoingresoSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oPresenciadiagnosticoingresoService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oPresenciadiagnosticoingresoService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oPresenciadiagnosticoingresoService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oPresenciadiagnosticoingresoService.get();
                        break;
                    case "set":
                        oReplyBean = oPresenciadiagnosticoingresoService.set();
                        break;
                    case "remove":
                        oReplyBean = oPresenciadiagnosticoingresoService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oPresenciadiagnosticoingresoService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oPresenciadiagnosticoingresoService.getCount();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;
            case "tipodiagnostico":
                TipodiagnosticoSpecificServiceImplementation oTipodiagnosticoService = new TipodiagnosticoSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oTipodiagnosticoService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oTipodiagnosticoService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oTipodiagnosticoService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oTipodiagnosticoService.get();
                        break;
                    case "set":
                        oReplyBean = oTipodiagnosticoService.set();
                        break;
                    case "remove":
                        oReplyBean = oTipodiagnosticoService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oTipodiagnosticoService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oTipodiagnosticoService.getCount();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;
            case "episodiodiagnostico":
                EpisodiodiagnosticoSpecificServiceImplementation oEpisodiodiagnosticoService = new EpisodiodiagnosticoSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oEpisodiodiagnosticoService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oEpisodiodiagnosticoService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oEpisodiodiagnosticoService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oEpisodiodiagnosticoService.get();
                        break;
                    case "set":
                        oReplyBean = oEpisodiodiagnosticoService.set();
                        break;
                    case "remove":
                        oReplyBean = oEpisodiodiagnosticoService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oEpisodiodiagnosticoService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oEpisodiodiagnosticoService.getCount();
                        break;
                    case "getcountx":
                        oReplyBean = oEpisodiodiagnosticoService.getCountX();
                        break;
                    case "getpagex":
                        oReplyBean = oEpisodiodiagnosticoService.getPageX();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;

            case "catalogoprocedimientos":
                CatalogoprocedimientosSpecificServiceImplementation oCatalogoprocedimientosService = new CatalogoprocedimientosSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oCatalogoprocedimientosService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oCatalogoprocedimientosService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oCatalogoprocedimientosService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oCatalogoprocedimientosService.get();
                        break;
                    case "set":
                        oReplyBean = oCatalogoprocedimientosService.set();
                        break;
                    case "remove":
                        oReplyBean = oCatalogoprocedimientosService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oCatalogoprocedimientosService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oCatalogoprocedimientosService.getCount();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;
            case "categoriaprofesionalps":
                CategoriaprofesionalpsSpecificServiceImplementation oCategoriaprofesionalpsService = new CategoriaprofesionalpsSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oCategoriaprofesionalpsService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oCategoriaprofesionalpsService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oCategoriaprofesionalpsService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oCategoriaprofesionalpsService.get();
                        break;
                    case "set":
                        oReplyBean = oCategoriaprofesionalpsService.set();
                        break;
                    case "remove":
                        oReplyBean = oCategoriaprofesionalpsService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oCategoriaprofesionalpsService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oCategoriaprofesionalpsService.getCount();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;
            case "estado":
                EstadoSpecificServiceImplementation oEstadoService = new EstadoSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oEstadoService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oEstadoService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oEstadoService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oEstadoService.get();
                        break;
                    case "set":
                        oReplyBean = oEstadoService.set();
                        break;
                    case "remove":
                        oReplyBean = oEstadoService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oEstadoService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oEstadoService.getCount();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;
            case "prioridad":
                PrioridadSpecificServiceImplementation oPrioridadService = new PrioridadSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oPrioridadService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oPrioridadService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oPrioridadService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oPrioridadService.get();
                        break;
                    case "set":
                        oReplyBean = oPrioridadService.set();
                        break;
                    case "remove":
                        oReplyBean = oPrioridadService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oPrioridadService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oPrioridadService.getCount();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;
            case "tipoprocedimiento":
                TipoprocedimientoSpecificServiceImplementation oTipoprocedimientoService = new TipoprocedimientoSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oTipoprocedimientoService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oTipoprocedimientoService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oTipoprocedimientoService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oTipoprocedimientoService.get();
                        break;
                    case "set":
                        oReplyBean = oTipoprocedimientoService.set();
                        break;
                    case "remove":
                        oReplyBean = oTipoprocedimientoService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oTipoprocedimientoService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oTipoprocedimientoService.getCount();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;
            case "episodioprocedimiento":
                EpisodioprocedimientoSpecificServiceImplementation oEpisodioprocedimientoService = new EpisodioprocedimientoSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oEpisodioprocedimientoService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oEpisodioprocedimientoService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oEpisodioprocedimientoService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oEpisodioprocedimientoService.get();
                        break;
                    case "set":
                        oReplyBean = oEpisodioprocedimientoService.set();
                        break;
                    case "remove":
                        oReplyBean = oEpisodioprocedimientoService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oEpisodioprocedimientoService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oEpisodioprocedimientoService.getCount();
                        break;
                    case "getcountx":
                        oReplyBean = oEpisodioprocedimientoService.getCountX();
                        break;
                    case "getpagex":
                        oReplyBean = oEpisodioprocedimientoService.getPageX();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;
            case "personalsanitario":
                PersonalsanitarioSpecificServiceImplementation oPersonalsanitarioService = new PersonalsanitarioSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oPersonalsanitarioService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oPersonalsanitarioService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oPersonalsanitarioService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oPersonalsanitarioService.get();
                        break;
                    case "set":
                        oReplyBean = oPersonalsanitarioService.set();
                        break;
                    case "remove":
                        oReplyBean = oPersonalsanitarioService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oPersonalsanitarioService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oPersonalsanitarioService.getCount();
                        break;
                    case "getcountx":
                        oReplyBean = oPersonalsanitarioService.getCountX();
                        break;
                    case "getpagex":
                        oReplyBean = oPersonalsanitarioService.getPageX();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;
            case "procedimiento":
                ProcedimientoSpecificServiceImplementation oProcedimientoService = new ProcedimientoSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oProcedimientoService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oProcedimientoService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oProcedimientoService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oProcedimientoService.get();
                        break;
                    case "set":
                        oReplyBean = oProcedimientoService.set();
                        break;
                    case "remove":
                        oReplyBean = oProcedimientoService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oProcedimientoService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oProcedimientoService.getCount();
                        break;
                    case "getcountx":
                        oReplyBean = oProcedimientoService.getCountX();
                        break;
                    case "getpagex":
                        oReplyBean = oProcedimientoService.getPageX();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;
            case "procedimientodiagnosticofinal":
                ProcedimientodiagnosticofinalSpecificServiceImplementation oProcedimientodiagnosticofinalService = new ProcedimientodiagnosticofinalSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oProcedimientodiagnosticofinalService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oProcedimientodiagnosticofinalService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oProcedimientodiagnosticofinalService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oProcedimientodiagnosticofinalService.get();
                        break;
                    case "set":
                        oReplyBean = oProcedimientodiagnosticofinalService.set();
                        break;
                    case "remove":
                        oReplyBean = oProcedimientodiagnosticofinalService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oProcedimientodiagnosticofinalService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oProcedimientodiagnosticofinalService.getCount();
                        break;
                    case "getcountx":
                        oReplyBean = oProcedimientodiagnosticofinalService.getCountX();
                        break;
                    case "getpagex":
                        oReplyBean = oProcedimientodiagnosticofinalService.getPageX();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;
            case "procedimientodiagnosticoinicial":
                ProcedimientodiagnosticoinicialSpecificServiceImplementation oProcedimientodiagnosticoinicialService = new ProcedimientodiagnosticoinicialSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oProcedimientodiagnosticoinicialService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oProcedimientodiagnosticoinicialService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oProcedimientodiagnosticoinicialService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oProcedimientodiagnosticoinicialService.get();
                        break;
                    case "set":
                        oReplyBean = oProcedimientodiagnosticoinicialService.set();
                        break;
                    case "remove":
                        oReplyBean = oProcedimientodiagnosticoinicialService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oProcedimientodiagnosticoinicialService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oProcedimientodiagnosticoinicialService.getCount();
                        break;
                    case "getcountx":
                        oReplyBean = oProcedimientodiagnosticoinicialService.getCountX();
                        break;
                    case "getpagex":
                        oReplyBean = oProcedimientodiagnosticoinicialService.getPageX();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;
            case "procedimientomedico":
                ProcedimientomedicoSpecificServiceImplementation oProcedimientomedicoService = new ProcedimientomedicoSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oProcedimientomedicoService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oProcedimientomedicoService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oProcedimientomedicoService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oProcedimientomedicoService.get();
                        break;
                    case "set":
                        oReplyBean = oProcedimientomedicoService.set();
                        break;
                    case "remove":
                        oReplyBean = oProcedimientomedicoService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oProcedimientomedicoService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oProcedimientomedicoService.getCount();
                        break;
                    case "getcountx":
                        oReplyBean = oProcedimientomedicoService.getCountX();
                        break;
                    case "getpagex":
                        oReplyBean = oProcedimientomedicoService.getPageX();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;
            case "procedimientopersonalsanitario":
                ProcedimientopersonalsanitarioSpecificServiceImplementation oProcedimientopersonalsanitarioService = new ProcedimientopersonalsanitarioSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oProcedimientopersonalsanitarioService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oProcedimientopersonalsanitarioService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oProcedimientopersonalsanitarioService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oProcedimientopersonalsanitarioService.get();
                        break;
                    case "set":
                        oReplyBean = oProcedimientopersonalsanitarioService.set();
                        break;
                    case "remove":
                        oReplyBean = oProcedimientopersonalsanitarioService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oProcedimientopersonalsanitarioService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oProcedimientopersonalsanitarioService.getCount();
                        break;
                    case "getcountx":
                        oReplyBean = oProcedimientopersonalsanitarioService.getCountX();
                        break;
                    case "getpagex":
                        oReplyBean = oProcedimientopersonalsanitarioService.getPageX();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;

            default:
                oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Object not found : Please contact your administrator"));
                break;
        }
        return oReplyBean;
    }
}
