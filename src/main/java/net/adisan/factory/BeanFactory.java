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
import net.adisan.bean.specificimplementation.ApellidoSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.CategoriaprofesionalSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.CentroSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.CentrosanitarioSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.TipoepisodioSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.CircunstanciasaltaSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.ComunidadSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.CursoSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.DependenciaSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.EspecialidadSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.DestinoaltaSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.EpisodioSpecificBeanImplementation;
import net.adisan.bean.statisticsspecificimplementation.CentrosanitarioStatisticsSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.FacturaSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.GrupoSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.MedicoSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.ModalidadepisodioSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.MunicipioSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.NombrefemeninoSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.NombremasculinoSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.PacienteSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.ProvinciaSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.ServicioSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.TipopagoSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.SexoSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.TipodependenciaSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.TiposervicioSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.ViaSpecificBeanImplementation;
import net.adisan.bean.publicinterface.BeanInterface;
import net.adisan.bean.specificimplementation.CatalogodiagnosticosSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.CatalogoprocedimientosSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.CategoriaprofesionalpsSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.EpisodiodiagnosticoSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.EpisodioprocedimientoSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.EstadoSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.PersonalsanitarioSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.PresenciadiagnosticoSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.PresenciadiagnosticoingresoSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.PrioridadSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.ProcedimientoSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.ProcedimientodiagnosticofinalSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.ProcedimientodiagnosticoinicialSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.ProcedimientomedicoSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.ProcedimientopersonalsanitarioSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.TipodiagnosticoSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.TipoprocedimientoSpecificBeanImplementation;
import net.adisan.bean.statisticsspecificimplementation.LogSpecificBeanImplementation;

public class BeanFactory {

    public static BeanInterface getBean(String ob, MetaBeanHelper oPuserBean_security) throws Exception {
        BeanInterface oBean = null;
        MetaBeanHelper oPuserSecurity = oPuserBean_security;
        switch (ob) {
            case "usuario":
                oBean = new UsuarioSpecificBeanImplementation();
                break;
            case "tipousuario":
                oBean = new TipousuarioSpecificBeanImplementation();
                break;
            case "grupo":
                oBean = new GrupoSpecificBeanImplementation();
                break;
            case "curso":
                oBean = new CursoSpecificBeanImplementation();
                break;
            case "centrosanitario":
                oBean = new CentrosanitarioSpecificBeanImplementation();
                break;
            case "centro":
                oBean = new CentroSpecificBeanImplementation();
                break;
            case "circunstanciasalta":
                oBean = new CircunstanciasaltaSpecificBeanImplementation();
                break;
            case "especialidad":
                oBean = new EspecialidadSpecificBeanImplementation();
                break;
            case "destinoalta":
                oBean = new DestinoaltaSpecificBeanImplementation();
                break;
            case "tipopago":
                oBean = new TipopagoSpecificBeanImplementation();
                break;
            case "sexo":
                oBean = new SexoSpecificBeanImplementation();
                break;
            case "tipoepisodio":
                oBean = new TipoepisodioSpecificBeanImplementation();
                break;
            case "tiposervicio":
                oBean = new TiposervicioSpecificBeanImplementation();
                break;
            case "modalidadepisodio":
                oBean = new ModalidadepisodioSpecificBeanImplementation();
                break;
            case "tipodependencia":
                oBean = new TipodependenciaSpecificBeanImplementation();
                break;
            case "factura":
                oBean = new FacturaSpecificBeanImplementation();
                break;
            case "servicio":
                oBean = new ServicioSpecificBeanImplementation();
                break;
            case "paciente":
                oBean = new PacienteSpecificBeanImplementation();
                break;
            case "categoriaprofesional":
                oBean = new CategoriaprofesionalSpecificBeanImplementation();
                break;
            case "episodio":
                oBean = new EpisodioSpecificBeanImplementation();
                break;
            case "subepisodio":
                oBean = new EpisodioSpecificBeanImplementation();
                break;
            case "medico":
                oBean = new MedicoSpecificBeanImplementation();
                break;
            case "dependencia":
                oBean = new DependenciaSpecificBeanImplementation();
                break;
            case "nombremasculino":
                oBean = new NombremasculinoSpecificBeanImplementation();
                break;
            case "nombrefemenino":
                oBean = new NombrefemeninoSpecificBeanImplementation();
                break;
            case "apellido":
                oBean = new ApellidoSpecificBeanImplementation();
                break;
            case "municipio":
                oBean = new MunicipioSpecificBeanImplementation();
                break;
            case "provincia":
                oBean = new ProvinciaSpecificBeanImplementation();
                break;
            case "via":
                oBean = new ViaSpecificBeanImplementation();
                break;
            case "comunidad":
                oBean = new ComunidadSpecificBeanImplementation();
                break;
            case "centrosanitariostatistics":
                oBean = new CentrosanitarioStatisticsSpecificBeanImplementation();
                break;
            case "episodiodiagnostico":
                oBean = new EpisodiodiagnosticoSpecificBeanImplementation();
                break;
            case "tipodiagnostico":
                oBean = new TipodiagnosticoSpecificBeanImplementation();
                break;
            case "catalogodiagnosticos":
                oBean = new CatalogodiagnosticosSpecificBeanImplementation();
                break;
            case "presenciadiagnostico":
                oBean = new PresenciadiagnosticoSpecificBeanImplementation();
                break;
            case "presenciadiagnosticoingreso":
                oBean = new PresenciadiagnosticoingresoSpecificBeanImplementation();
                break;
            //---
            case "catalogoprocedimientos":
                oBean = new CatalogoprocedimientosSpecificBeanImplementation();
                break;
            case "categoriaprofesionalps":
                oBean = new CategoriaprofesionalpsSpecificBeanImplementation();
                break;
            case "episodioprocedimiento":
                oBean = new EpisodioprocedimientoSpecificBeanImplementation();
                break;
            case "estado":
                oBean = new EstadoSpecificBeanImplementation();
                break;
            case "personalsanitario":
                oBean = new PersonalsanitarioSpecificBeanImplementation();
                break;
            case "prioridad":
                oBean = new PrioridadSpecificBeanImplementation();
                break;
            case "procedimiento":
                oBean = new ProcedimientoSpecificBeanImplementation();
                break;
            case "procedimientodiagnosticofinal":
                oBean = new ProcedimientodiagnosticofinalSpecificBeanImplementation();
                break;
            case "procedimientodiagnosticoinicial":
                oBean = new ProcedimientodiagnosticoinicialSpecificBeanImplementation();
                break;
            case "procedimientomedico":
                oBean = new ProcedimientomedicoSpecificBeanImplementation();
                break;
            case "procedimientopersonalsanitario":
                oBean = new ProcedimientopersonalsanitarioSpecificBeanImplementation();
                break;
            case "tipoprocedimiento":
                oBean = new TipoprocedimientoSpecificBeanImplementation();
                break;
          case "log":
                oBean = new LogSpecificBeanImplementation();
                break;
            default:
                throw new Exception ("BeanFactory: Bean not found");
                //  oReplyBean = new ReplyBean(500, "Object not found : Please contact your administrator");
                
        }
        return oBean;
    }
}
