/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.adisan.dao.specificimplementation.factory;

import net.adisan.bean.helper.MetaBeanHelper;
import net.adisan.dao.genericimplementation.GenericDaoImplementation;
import java.sql.Connection;

public class ApellidoSpecificDaoImplementation extends GenericDaoImplementation {

    public ApellidoSpecificDaoImplementation(Connection oPooledConnection, MetaBeanHelper oPuserBean_security, String strWhere) throws Exception {
        super("apellido", oPooledConnection, oPuserBean_security, strWhere);
    }

}
