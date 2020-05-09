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

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import net.adisan.bean.helper.MetaBeanHelper;
import net.adisan.bean.helper.ReplyBeanHelper;
import net.adisan.dao.publicinterface.DaoInterface;
import net.adisan.helper.EncodingHelper;
import net.adisan.helper.GsonHelper;

public class MetaFactory {

    public ReplyBeanHelper getallobjectsmetadata(HttpServletRequest oRequest) throws Exception {
        MetaBeanHelper oUsuarioBean = (MetaBeanHelper) oRequest.getSession().getAttribute("user");
        if (oUsuarioBean != null) {
            ReplyBeanHelper oReplyBean = null;
            HashMap hmObjectsMetaData = new HashMap();
            DaoInterface oDao = null;
            oDao = DaoFactory.getDao("usuario", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("usuario", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("tipousuario", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("tipousuario", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("centro", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("centro", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("centrosanitario", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("centrosanitario", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("curso", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("curso", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("grupo", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("grupo", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("tipoepisodio", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("tipoepisodio", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("especialidad", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("especialidad", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("destinoalta", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("destinoalta", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("tipopago", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("tipopago", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("sexo", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("sexo", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("circunstanciasalta", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("circunstanciasalta", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("modalidadepisodio", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("modalidadepisodio", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("tipodependencia", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("tipodependencia", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("tiposervicio", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("tiposervicio", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("factura", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("factura", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("servicio", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("servicio", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("paciente", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("paciente", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("categoriaprofesional", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("categoriaprofesional", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("episodio", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("episodio", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("subepisodio", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("subepisodio", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("dependencia", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("dependencia", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("medico", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("medico", oDao.getObjectMetaData());

            oDao = DaoFactory.getDao("episodiodiagnostico", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("episodiodiagnostico", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("tipodiagnostico", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("tipodiagnostico", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("catalogodiagnosticos", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("catalogodiagnosticos", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("presenciadiagnostico", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("presenciadiagnostico", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("presenciadiagnosticoingreso", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("presenciadiagnosticoingreso", oDao.getObjectMetaData());

            oDao = DaoFactory.getDao("catalogoprocedimientos", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("catalogoprocedimientos", oDao.getObjectMetaData());

            oDao = DaoFactory.getDao("categoriaprofesionalps", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("categoriaprofesionalps", oDao.getObjectMetaData());

            oDao = DaoFactory.getDao("episodioprocedimiento", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("episodioprocedimiento", oDao.getObjectMetaData());

            oDao = DaoFactory.getDao("estado", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("estado", oDao.getObjectMetaData());

            oDao = DaoFactory.getDao("personalsanitario", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("personalsanitario", oDao.getObjectMetaData());

            oDao = DaoFactory.getDao("prioridad", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("prioridad", oDao.getObjectMetaData());

            oDao = DaoFactory.getDao("procedimiento", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("procedimiento", oDao.getObjectMetaData());

            oDao = DaoFactory.getDao("procedimientodiagnosticofinal", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("procedimientodiagnosticofinal", oDao.getObjectMetaData());

            oDao = DaoFactory.getDao("procedimientodiagnosticoinicial", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("procedimientodiagnosticoinicial", oDao.getObjectMetaData());

            oDao = DaoFactory.getDao("procedimientomedico", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("procedimientomedico", oDao.getObjectMetaData());

            oDao = DaoFactory.getDao("procedimientopersonalsanitario", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("procedimientopersonalsanitario", oDao.getObjectMetaData());

            oDao = DaoFactory.getDao("tipoprocedimiento", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            hmObjectsMetaData.put("tipoprocedimiento", oDao.getObjectMetaData());

            String strJson = GsonHelper.getGson().toJson(hmObjectsMetaData);
            oReplyBean = new ReplyBeanHelper(200, strJson);
            return oReplyBean;
        } else {
            return new ReplyBeanHelper(401, EncodingHelper.quotate("Unauthorized"));
        }

    }
}
