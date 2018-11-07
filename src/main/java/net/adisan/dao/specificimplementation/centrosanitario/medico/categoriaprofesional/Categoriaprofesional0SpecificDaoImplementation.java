/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.adisan.dao.specificimplementation.centrosanitario.medico.categoriaprofesional;

import net.adisan.bean.genericimplementation.GenericBeanImplementation;
import net.adisan.bean.helper.MetaBeanHelper;
import net.adisan.dao.genericimplementation.GenericDaoImplementation;
import java.sql.Connection;

public class Categoriaprofesional0SpecificDaoImplementation extends GenericDaoImplementation {

    public Categoriaprofesional0SpecificDaoImplementation(Connection oPooledConnection, MetaBeanHelper oPuserBean_security, String strWhere) throws Exception {
        super("categoriaprofesional", oPooledConnection, oPuserBean_security, strWhere);
    }

//    @Override
//    public boolean canGet(Integer id) throws Exception {
//        return true;
//    }
}
