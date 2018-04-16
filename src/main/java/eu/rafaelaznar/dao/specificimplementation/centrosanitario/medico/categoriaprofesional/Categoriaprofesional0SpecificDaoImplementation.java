/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.rafaelaznar.dao.specificimplementation.centrosanitario.medico.categoriaprofesional;

import eu.rafaelaznar.bean.genericimplementation.TableGenericBeanImplementation;
import eu.rafaelaznar.bean.helper.MetaBeanHelper;
import eu.rafaelaznar.dao.genericimplementation.TableGenericDaoImplementation;
import java.sql.Connection;

public class Categoriaprofesional0SpecificDaoImplementation extends TableGenericDaoImplementation {

    public Categoriaprofesional0SpecificDaoImplementation(Connection oPooledConnection, MetaBeanHelper oPuserBean_security, String strWhere) throws Exception {
        super("categoriaprofesional", oPooledConnection, oPuserBean_security, strWhere);
    }

//    @Override
//    public boolean canGet(Integer id) throws Exception {
//        return true;
//    }
}
