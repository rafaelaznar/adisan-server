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
package net.adisan.dao.specificimplementation.usuario;

import net.adisan.bean.helper.MetaBeanHelper;
import net.adisan.bean.specificimplementation.UsuarioSpecificBeanImplementation;
import net.adisan.dao.genericimplementation.GenericDaoImplementation;
import java.sql.Connection;
import java.util.Date;

public class Usuario5SpecificDaoImplementation extends GenericDaoImplementation {

    public Usuario5SpecificDaoImplementation(Connection oPooledConnection, MetaBeanHelper oMBHUsuarioSession, String strWhere) throws Exception {
        super("usuario", oPooledConnection, oMBHUsuarioSession, strWhere);
    }

    @Override
    public MetaBeanHelper get(int id, int intExpand) throws Exception {
        MetaBeanHelper oMetaBeanHelper = super.get(id, intExpand);
        UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
        oUsuario.setLogin("Información oculta");
        oUsuario.setActivo(0);
        oUsuario.setFecha_alta(new Date(0));
        return oMetaBeanHelper;
    }

}
