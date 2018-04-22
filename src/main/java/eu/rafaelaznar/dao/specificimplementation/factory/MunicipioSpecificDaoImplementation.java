/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.rafaelaznar.dao.specificimplementation.factory;

import eu.rafaelaznar.bean.helper.MetaBeanHelper;
import eu.rafaelaznar.dao.genericimplementation.GenericDaoImplementation;
import java.sql.Connection;

public class MunicipioSpecificDaoImplementation extends GenericDaoImplementation {

    public MunicipioSpecificDaoImplementation(Connection oPooledConnection, MetaBeanHelper oPuserBean_security, String strWhere) throws Exception {
        super("municipio", oPooledConnection, oPuserBean_security, strWhere);
    }

}
