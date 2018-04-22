/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.rafaelaznar.dao.specificimplementation.centrosanitario.medico.categoriaprofesional;

import eu.rafaelaznar.bean.genericimplementation.GenericBeanImplementation;
import eu.rafaelaznar.bean.helper.MetaBeanHelper;
import eu.rafaelaznar.bean.specificimplementation.CategoriaprofesionalSpecificBeanImplementation;
import eu.rafaelaznar.dao.genericimplementation.GenericDaoImplementation;
import java.sql.Connection;

public class Categoriaprofesional1SpecificDaoImplementation extends GenericDaoImplementation {

    public Categoriaprofesional1SpecificDaoImplementation(Connection oPooledConnection, MetaBeanHelper oPuserBean_security, String strWhere) throws Exception {
        super("categoriaprofesional", oPooledConnection, oPuserBean_security, strWhere);
    }

//    @Override
//    public boolean canGet(Integer id) throws Exception {
//        return true;
//    }
    @Override
    public boolean canCreate(GenericBeanImplementation oBean) throws Exception {
        return true;
    }

    @Override
    public boolean canUpdate(GenericBeanImplementation oBean) throws Exception {
        return true;
    }

    @Override
    public boolean canDelete(GenericBeanImplementation oBean) throws Exception {
        CategoriaprofesionalSpecificBeanImplementation oCategoriaprofesionalBean = (CategoriaprofesionalSpecificBeanImplementation) oBean;
        if (oCategoriaprofesionalBean.getLink_medico() > 0) {
            return false;
        } else {
            return true;
        }
    }
}
