/*
 * Copyright (c) 2017-2018 
 *
 * by Rafael Angel Aznar Aparici (rafaaznar at gmail dot com) & DAW students
 * 
 * ADISAN: Free Open Source Health Management System
 *
 * Sources at:
 *                            https://github.com/rafaelaznar/adisan
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
package net.adisan.service.specificimplementation;

import net.adisan.bean.helper.MetaBeanHelper;
import net.adisan.bean.specificimplementation.TipousuarioSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.UsuarioSpecificBeanImplementation;
import net.adisan.service.genericimplementation.GenericServiceImplementation;
import javax.servlet.http.HttpServletRequest;

public class EspecialidadSpecificServiceImplementation extends GenericServiceImplementation {

    public EspecialidadSpecificServiceImplementation(HttpServletRequest request) {
        super(request);
    }

//    @Override
//    protected Boolean checkPermission(String strMethodName) {
//        MetaBeanHelper oUsuarioBean = (MetaBeanHelper) oRequest.getSession().getAttribute("user");
//        if (oUsuarioBean != null) {
//            UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oUsuarioBean.getBean();
//            MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
//            TipousuarioSpecificBeanImplementation oTipousuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
//            Integer idTipousuario = oTipousuario.getId();
//
//            String strMethod = strMethodName.toLowerCase();
//            if (idTipousuario == 1) {
//                return true;
//            } else {
//                if (idTipousuario == 3
//                        || idTipousuario == 4
//                        || idTipousuario == 5) {
//
//                    switch (strMethod) {
//                        case "getmetadata":
//                            return true;
//                        case "getobjectmetadata":
//                            return true;
//                        case "getpropertiesmetadata":
//                            return true;
//                        case "get":
//                            return true;
//                        case "set":
//                            return false;
//                        case "remove":
//                            return false;
//                        case "getpage":
//                            return true;
//                        case "getcount":
//                            return true;
//                    }
//                } else {
//                    return false;
//                }
//            }
//        } else {
//            return false;
//        }
//        return false;
//    }
}
