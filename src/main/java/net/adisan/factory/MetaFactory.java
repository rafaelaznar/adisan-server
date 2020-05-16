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

import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import net.adisan.bean.helper.MetaBeanHelper;
import net.adisan.bean.helper.ReplyBeanHelper;
import net.adisan.bean.meta.helper.MetaObjectGenericBeanHelper;
import net.adisan.dao.publicinterface.DaoInterface;
import net.adisan.helper.EncodingHelper;
import net.adisan.helper.GsonHelper;
import net.adisan.helper.SessionHelper;

public class MetaFactory {

    public ReplyBeanHelper getMenu(HttpServletRequest oRequest) throws Exception {
        MetaBeanHelper oMHBUsuarioSessionBean = (MetaBeanHelper) oRequest.getSession().getAttribute("user");
        ReplyBeanHelper oReplyBean = null;
        DaoInterface oDao = null;
        ArrayList<ArrayList<MetaObjectGenericBeanHelper>> oMenu = new ArrayList<ArrayList<MetaObjectGenericBeanHelper>>();
        //pte - derivar a tabla..
        if (SessionHelper.getIdTipoUsuario(oMHBUsuarioSessionBean) == 1) {

            ArrayList<MetaObjectGenericBeanHelper> oMenu11 = new ArrayList<MetaObjectGenericBeanHelper>();
            oDao = DaoFactory.getDao("usuario", null, oMHBUsuarioSessionBean, null);
            oMenu11.add(oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("tipousuario", null, oMHBUsuarioSessionBean, null);
            oMenu11.add(oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("grupo", null, oMHBUsuarioSessionBean, null);
            oMenu11.add(oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("curso", null, oMHBUsuarioSessionBean, null);
            oMenu11.add(oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("centroeducativo", null, oMHBUsuarioSessionBean, null);
            oMenu11.add(oDao.getObjectMetaData());

            oMenu.add(oMenu11);

            ArrayList<MetaObjectGenericBeanHelper> oMenu12 = new ArrayList<MetaObjectGenericBeanHelper>();
            oDao = DaoFactory.getDao("centrosanitario", null, oMHBUsuarioSessionBean, null);
            oMenu12.add(oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("dependencia", null, oMHBUsuarioSessionBean, null);
            oMenu12.add(oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("tipodependencia", null, oMHBUsuarioSessionBean, null);
            oMenu12.add(oDao.getObjectMetaData());

            oMenu.add(oMenu12);

            ArrayList<MetaObjectGenericBeanHelper> oMenu13 = new ArrayList<MetaObjectGenericBeanHelper>();
            oDao = DaoFactory.getDao("medico", null, oMHBUsuarioSessionBean, null);
            oMenu13.add(oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("personalsanitario", null, oMHBUsuarioSessionBean, null);
            oMenu13.add(oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("servicio", null, oMHBUsuarioSessionBean, null);
            oMenu13.add(oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("tiposervicio", null, oMHBUsuarioSessionBean, null);
            oMenu13.add(oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("especialidad", null, oMHBUsuarioSessionBean, null);
            oMenu13.add(oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("mategoriaprofesional", null, oMHBUsuarioSessionBean, null);
            oMenu13.add(oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("categoriaprofesionalps", null, oMHBUsuarioSessionBean, null);
            oMenu13.add(oDao.getObjectMetaData());

            oMenu.add(oMenu13);

        }
        String strJson = GsonHelper.getGson().toJson(oMenu);
        oReplyBean = new ReplyBeanHelper(200, strJson);
        return oReplyBean;
    }

    public ReplyBeanHelper getallobjectsmetadata(HttpServletRequest oRequest) throws Exception {
        MetaBeanHelper oMHBUsuarioSessionBean = (MetaBeanHelper) oRequest.getSession().getAttribute("user");
        if (oMHBUsuarioSessionBean != null) {
            ReplyBeanHelper oReplyBean = null;
            HashMap hmObjectsMetaData = new HashMap();
            DaoInterface oDao = null;
            oDao = DaoFactory.getDao("usuario", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("usuario", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("tipousuario", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("tipousuario", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("centro", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("centro", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("centrosanitario", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("centrosanitario", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("curso", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("curso", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("grupo", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("grupo", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("tipoepisodio", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("tipoepisodio", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("especialidad", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("especialidad", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("destinoalta", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("destinoalta", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("tipopago", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("tipopago", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("sexo", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("sexo", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("circunstanciasalta", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("circunstanciasalta", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("modalidadepisodio", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("modalidadepisodio", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("tipodependencia", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("tipodependencia", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("tiposervicio", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("tiposervicio", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("factura", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("factura", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("servicio", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("servicio", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("paciente", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("paciente", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("categoriaprofesional", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("categoriaprofesional", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("episodio", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("episodio", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("subepisodio", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("subepisodio", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("dependencia", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("dependencia", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("medico", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("medico", oDao.getObjectMetaData());

            oDao = DaoFactory.getDao("episodiodiagnostico", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("episodiodiagnostico", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("tipodiagnostico", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("tipodiagnostico", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("catalogodiagnosticos", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("catalogodiagnosticos", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("presenciadiagnostico", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("presenciadiagnostico", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("presenciadiagnosticoingreso", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("presenciadiagnosticoingreso", oDao.getObjectMetaData());

            oDao = DaoFactory.getDao("catalogoprocedimientos", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("catalogoprocedimientos", oDao.getObjectMetaData());

            oDao = DaoFactory.getDao("categoriaprofesionalps", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("categoriaprofesionalps", oDao.getObjectMetaData());

            oDao = DaoFactory.getDao("episodioprocedimiento", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("episodioprocedimiento", oDao.getObjectMetaData());

            oDao = DaoFactory.getDao("estado", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("estado", oDao.getObjectMetaData());

            oDao = DaoFactory.getDao("personalsanitario", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("personalsanitario", oDao.getObjectMetaData());

            oDao = DaoFactory.getDao("prioridad", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("prioridad", oDao.getObjectMetaData());

            oDao = DaoFactory.getDao("procedimiento", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("procedimiento", oDao.getObjectMetaData());

            oDao = DaoFactory.getDao("procedimientodiagnosticofinal", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("procedimientodiagnosticofinal", oDao.getObjectMetaData());

            oDao = DaoFactory.getDao("procedimientodiagnosticoinicial", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("procedimientodiagnosticoinicial", oDao.getObjectMetaData());

            oDao = DaoFactory.getDao("procedimientomedico", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("procedimientomedico", oDao.getObjectMetaData());

            oDao = DaoFactory.getDao("procedimientopersonalsanitario", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("procedimientopersonalsanitario", oDao.getObjectMetaData());

            oDao = DaoFactory.getDao("tipoprocedimiento", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("tipoprocedimiento", oDao.getObjectMetaData());

            oDao = DaoFactory.getDao("log", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("log", oDao.getObjectMetaData());

            String strJson = GsonHelper.getGson().toJson(hmObjectsMetaData);
            oReplyBean = new ReplyBeanHelper(200, strJson);
            return oReplyBean;
        } else {
            return new ReplyBeanHelper(401, EncodingHelper.quotate("Unauthorized"));
        }

    }

    public HashMap<String, MetaObjectGenericBeanHelper> getallobjectsmetadata2(HttpServletRequest oRequest) throws Exception {
        MetaBeanHelper oMHBUsuarioSessionBean = (MetaBeanHelper) oRequest.getSession().getAttribute("user");
        if (oMHBUsuarioSessionBean != null) {
            ReplyBeanHelper oReplyBean = null;
            HashMap<String, MetaObjectGenericBeanHelper> hmObjectsMetaData = new HashMap();
            DaoInterface oDao = null;
            oDao = DaoFactory.getDao("usuario", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("usuario", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("tipousuario", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("tipousuario", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("centro", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("centro", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("centrosanitario", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("centrosanitario", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("curso", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("curso", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("grupo", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("grupo", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("tipoepisodio", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("tipoepisodio", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("especialidad", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("especialidad", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("destinoalta", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("destinoalta", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("tipopago", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("tipopago", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("sexo", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("sexo", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("circunstanciasalta", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("circunstanciasalta", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("modalidadepisodio", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("modalidadepisodio", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("tipodependencia", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("tipodependencia", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("tiposervicio", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("tiposervicio", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("factura", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("factura", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("servicio", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("servicio", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("paciente", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("paciente", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("categoriaprofesional", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("categoriaprofesional", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("episodio", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("episodio", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("subepisodio", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("subepisodio", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("dependencia", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("dependencia", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("medico", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("medico", oDao.getObjectMetaData());

            oDao = DaoFactory.getDao("episodiodiagnostico", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("episodiodiagnostico", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("tipodiagnostico", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("tipodiagnostico", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("catalogodiagnosticos", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("catalogodiagnosticos", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("presenciadiagnostico", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("presenciadiagnostico", oDao.getObjectMetaData());
            oDao = DaoFactory.getDao("presenciadiagnosticoingreso", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("presenciadiagnosticoingreso", oDao.getObjectMetaData());

            oDao = DaoFactory.getDao("catalogoprocedimientos", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("catalogoprocedimientos", oDao.getObjectMetaData());

            oDao = DaoFactory.getDao("categoriaprofesionalps", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("categoriaprofesionalps", oDao.getObjectMetaData());

            oDao = DaoFactory.getDao("episodioprocedimiento", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("episodioprocedimiento", oDao.getObjectMetaData());

            oDao = DaoFactory.getDao("estado", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("estado", oDao.getObjectMetaData());

            oDao = DaoFactory.getDao("personalsanitario", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("personalsanitario", oDao.getObjectMetaData());

            oDao = DaoFactory.getDao("prioridad", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("prioridad", oDao.getObjectMetaData());

            oDao = DaoFactory.getDao("procedimiento", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("procedimiento", oDao.getObjectMetaData());

            oDao = DaoFactory.getDao("procedimientodiagnosticofinal", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("procedimientodiagnosticofinal", oDao.getObjectMetaData());

            oDao = DaoFactory.getDao("procedimientodiagnosticoinicial", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("procedimientodiagnosticoinicial", oDao.getObjectMetaData());

            oDao = DaoFactory.getDao("procedimientomedico", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("procedimientomedico", oDao.getObjectMetaData());

            oDao = DaoFactory.getDao("procedimientopersonalsanitario", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("procedimientopersonalsanitario", oDao.getObjectMetaData());

            oDao = DaoFactory.getDao("tipoprocedimiento", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("tipoprocedimiento", oDao.getObjectMetaData());

            oDao = DaoFactory.getDao("log", null, oMHBUsuarioSessionBean, null);
            hmObjectsMetaData.put("log", oDao.getObjectMetaData());

            return hmObjectsMetaData;
        } else {
            return null;
        }

    }

}
