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
package eu.rafaelaznar.dao.specificimplementation.usuario;

import eu.rafaelaznar.bean.genericimplementation.TableGenericBeanImplementation;
import eu.rafaelaznar.bean.helper.MetaBeanHelper;
import eu.rafaelaznar.bean.specificimplementation.UsuarioSpecificBeanImplementation;
import eu.rafaelaznar.dao.genericimplementation.TableGenericDaoImplementation;
import static eu.rafaelaznar.helper.EnumHelper.FieldType.Date;
import java.sql.Connection;
import java.util.Date;

public class Usuario5SpecificDaoImplementation extends TableGenericDaoImplementation {
    
    public Usuario5SpecificDaoImplementation(Connection oPooledConnection, MetaBeanHelper oPuserBean_security, String strWhere) throws Exception {
        super("usuario", oPooledConnection, oPuserBean_security, strWhere);
    }
    
    @Override
    public boolean canCreate(TableGenericBeanImplementation oBean) throws Exception {
        return false;
    }
    
    @Override
    public boolean canUpdate(TableGenericBeanImplementation oBean) throws Exception {
        return false;
    }
    
    @Override
    public boolean canDelete(Integer id) throws Exception {
        return false;
    }
    
    @Override
    public MetaBeanHelper get(int id, int intExpand) throws Exception {
        MetaBeanHelper oMetaBeanHelper = super.get(id, intExpand);
        UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
        oUsuario.setNombrecompleto("Oculto para proteger la identidad");
        oUsuario.setNombre("Oculto para proteger la identidad");
        oUsuario.setPrimer_apellido("Oculto para proteger la identidad");
        oUsuario.setSegundo_apellido("Oculto para proteger la identidad");
        oUsuario.setEmail("Oculto para proteger la identidad");
        oUsuario.setLogin("No tienes permiso para acceder a esta información");
        oUsuario.setActivo(0);
        oUsuario.setFecha_alta(new Date(0));
        return oMetaBeanHelper;
    }
    
    @Override
    public Integer create(TableGenericBeanImplementation oBean) throws Exception {
        return 0;
    }
    
    @Override
    public Integer update(TableGenericBeanImplementation oBean) throws Exception {
        return 0;
    }
    
    @Override
    public Integer delete(Integer id) throws Exception {
        return 0;
    }

//    @Override
//    public Long getCount(ArrayList<FilterBeanHelper> alFilter) throws Exception {
//        return null;
//    }
//
//    @Override
//    public MetaBeanHelper getPage(int intRegsPerPag, int intPage, LinkedHashMap<String, String> hmOrder, ArrayList<FilterBeanHelper> alFilter, int expand) throws Exception {
//        return null;
//    }
//
//    @Override
//    public MetaBeanHelper getPageX(int id_foreign, String ob_foreign, int intRegsPerPag, int intPage, LinkedHashMap<String, String> hmOrder, ArrayList<FilterBeanHelper> alFilter, int expand) throws Exception {
//        return null;
//    }
//
//    @Override
//    public Long getCountX(int id_foreign, String ob_foreign, ArrayList<FilterBeanHelper> alFilter) throws Exception {
//        return null;
//    }
//
//    @Override
//    public MetaObjectGenericBeanHelper getObjectMetaData() throws Exception {
//        return null;
//    }
//
//    @Override
//    public ArrayList<MetaPropertyGenericBeanHelper> getPropertiesMetaData() throws Exception {
//        return null;
//    }
}
