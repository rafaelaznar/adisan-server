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
package net.adisan.dao.genericimplementation;

import net.adisan.bean.genericimplementation.GenericBeanImplementation;
import net.adisan.bean.helper.FilterBeanHelper;
import net.adisan.bean.meta.publicinterface.MetaPropertyBeanInterface;
import net.adisan.bean.meta.helper.MetaObjectGenericBeanHelper;
import net.adisan.bean.meta.helper.MetaPropertyGenericBeanHelper;
import net.adisan.bean.helper.MetaBeanHelper;
import net.adisan.bean.meta.publicinterface.MetaObjectBeanInterface;
import net.adisan.dao.publicinterface.DaoInterface;
import net.adisan.helper.Log4jHelper;
import net.adisan.factory.BeanFactory;
import net.adisan.helper.EnumHelper;
import net.adisan.helper.SqlHelper;
import net.adisan.helper.TraceHelper;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import net.adisan.bean.publicinterface.BeanInterface;

public abstract class GenericDaoImplementation implements DaoInterface {

    protected String ob = null;
    protected String strSQL = null;
    protected String strCountSQL = null;
    protected Connection oConnection = null;
    protected MetaBeanHelper oPuserSecurity = null;

    public GenericDaoImplementation(String obj, Connection oPooledConnection, MetaBeanHelper oPuserBean_security, String strWhere) throws Exception {
        oConnection = oPooledConnection;
        oPuserSecurity = oPuserBean_security;
        ob = obj;
        try {
            strSQL = "SELECT * FROM " + ob + " WHERE 1=1 ";
            strCountSQL = "SELECT COUNT(*) FROM " + ob + " WHERE 1=1 ";
            if (strWhere != null) {
                strSQL += " " + strWhere + " ";
                strCountSQL += " " + strWhere + " ";
            }
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
            Log4jHelper.errorLog(msg, ex);
            throw new Exception(msg, ex);
        }
    }

    protected Long count(String strCountSQL) throws Exception {
        PreparedStatement oPreparedStatement = null;
        ResultSet oResultSet = null;
        Long iResult = 0L;
        try {
            oPreparedStatement = oConnection.prepareStatement(strCountSQL);
            oResultSet = oPreparedStatement.executeQuery();
            if (oResultSet.next()) {
                iResult = oResultSet.getLong("COUNT(*)");
            } else {
                String msg = this.getClass().getName() + ": getcount";
                Log4jHelper.errorLog(msg);
                throw new Exception(msg);
            }
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
            Log4jHelper.errorLog(msg, ex);
            throw new Exception(msg, ex);
        } finally {
            if (oResultSet != null) {
                oResultSet.close();
            }
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
            TraceHelper.trace("count-Estadistica0SpecificDaoImplementation(end):object=" + ob);
        }
        return iResult;
    }

    @Override
    public MetaBeanHelper getStatistics(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private ArrayList<MetaPropertyGenericBeanHelper> fillPropertiesMetaData(Class oClassBEAN, ArrayList<MetaPropertyGenericBeanHelper> alVector) {
        TraceHelper.trace("fillPropertiesMetaData(start): object = " + ob);
        for (Field field : oClassBEAN.getDeclaredFields()) {
            Annotation[] fieldAnnotations = field.getDeclaredAnnotations();
            for (Integer i = 0; i < fieldAnnotations.length; i++) {
                if (fieldAnnotations[i].annotationType().equals(MetaPropertyBeanInterface.class)) {
                    MetaPropertyBeanInterface fieldAnnotation = (MetaPropertyBeanInterface) fieldAnnotations[i];
                    if (fieldAnnotation.Type() != EnumHelper.FieldType.Password
                            && fieldAnnotation.Type() != EnumHelper.FieldType.Token
                            && fieldAnnotation.Type() != EnumHelper.FieldType.ForeignId
                            && fieldAnnotation.Type() != EnumHelper.FieldType.Can) {
                        MetaPropertyGenericBeanHelper oMeta = new MetaPropertyGenericBeanHelper();
                        oMeta.setName(field.getName());
                        oMeta.setShortName(fieldAnnotation.ShortName());
                        oMeta.setLongName(fieldAnnotation.LongName());
                        oMeta.setDescription(fieldAnnotation.Description());
                        oMeta.setIsId(field.getName() == "id");
                        oMeta.setIsIdForeignKey(field.getName().startsWith("id_"));
                        oMeta.setIsObjForeignKey(field.getName().startsWith("obj_"));
                        oMeta.setReferences(fieldAnnotation.References());
                        oMeta.setIsForeignKeyDescriptor(fieldAnnotation.IsForeignKeyDescriptor());
                        oMeta.setType(fieldAnnotation.Type());
                        oMeta.setIsRequired(fieldAnnotation.IsRequired());
                        oMeta.setRegexPattern(fieldAnnotation.RegexPattern());
                        oMeta.setRegexHelp(fieldAnnotation.RegexHelp());
                        oMeta.setDefaultValue(fieldAnnotation.DefaultValue());
                        oMeta.setIsVisible(fieldAnnotation.IsVisible());
                        oMeta.setWidth(fieldAnnotation.Width());
                        oMeta.setMaxLength(fieldAnnotation.MaxLength());
                        oMeta.setIsFormVisible(fieldAnnotation.IsFormVisible());
                        alVector.add(oMeta);
                    }
                }
            }
        }
        TraceHelper.trace("fillPropertiesMetaData(end): object = " + ob);
        return alVector;
    }

    private MetaObjectGenericBeanHelper fillObjectMetaData(Class oClassBEAN, MetaObjectGenericBeanHelper oMetaObject) {
        Annotation[] classAnnotations = oClassBEAN.getAnnotations();
        for (Integer i = 0; i < classAnnotations.length; i++) {
            if (classAnnotations[i].annotationType().equals(MetaObjectBeanInterface.class)) {
                MetaObjectBeanInterface fieldAnnotation = (MetaObjectBeanInterface) classAnnotations[i];
                oMetaObject.setClassName(oClassBEAN.getName());
                oMetaObject.setSingularDescription(fieldAnnotation.SingularDescription());
                oMetaObject.setPluralDescription(fieldAnnotation.PluralDescription());
                oMetaObject.setIcon(fieldAnnotation.Icon());
                oMetaObject.setTableName(fieldAnnotation.TableName());
                oMetaObject.setType(fieldAnnotation.Type());
            }
        }
        return oMetaObject;
    }

    @Override
    public MetaObjectGenericBeanHelper getObjectMetaData() throws Exception {
        MetaObjectGenericBeanHelper oMetaObject;
        try {
            GenericBeanImplementation oBean = (GenericBeanImplementation) BeanFactory.getBean(ob, oPuserSecurity);
            Class oClassBEAN = oBean.getClass();
            oMetaObject = new MetaObjectGenericBeanHelper();
            oMetaObject = fillObjectMetaData(oClassBEAN, oMetaObject);
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
            Log4jHelper.errorLog(msg, ex);
            throw new Exception(msg, ex);
        }
        return oMetaObject;
    }

    @Override
    public MetaObjectGenericBeanHelper getObjectMetaData(String ob) throws Exception {
        MetaObjectGenericBeanHelper oMetaObject;
        try {
            BeanInterface oBean = (BeanInterface) BeanFactory.getBean(ob, oPuserSecurity);
            Class oClassBEAN = oBean.getClass();
            oMetaObject = new MetaObjectGenericBeanHelper();
            oMetaObject = fillObjectMetaData(oClassBEAN, oMetaObject);
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
            Log4jHelper.errorLog(msg, ex);
            throw new Exception(msg, ex);
        }
        return oMetaObject;
    }

    @Override
    public ArrayList<MetaPropertyGenericBeanHelper> getPropertiesMetaData() throws Exception {
        ArrayList<MetaPropertyGenericBeanHelper> alVector = new ArrayList<>();
        try {
            BeanInterface oBean = (BeanInterface) BeanFactory.getBean(ob, oPuserSecurity);
            Class classBean = oBean.getClass();
            Class superClassBean = oBean.getClass().getSuperclass();
            alVector = fillPropertiesMetaData(superClassBean, alVector);
            alVector = fillPropertiesMetaData(classBean, alVector);
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
            Log4jHelper.errorLog(msg, ex);
            throw new Exception(msg, ex);
        }
        return alVector;
    }

    @Override
    public ArrayList<MetaPropertyGenericBeanHelper> getPropertiesMetaData(String ob) throws Exception {
        ArrayList<MetaPropertyGenericBeanHelper> alVector = new ArrayList<>();
        try {
            BeanInterface oBean = (BeanInterface) BeanFactory.getBean(ob, oPuserSecurity);
            Class classBean = oBean.getClass();
            Class superClassBean = oBean.getClass().getSuperclass();
            alVector = fillPropertiesMetaData(superClassBean, alVector);
            alVector = fillPropertiesMetaData(classBean, alVector);
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
            Log4jHelper.errorLog(msg, ex);
            throw new Exception(msg, ex);
        }
        return alVector;
    }

    @Override
    public Long getCount(ArrayList<FilterBeanHelper> alFilter) throws Exception {
        TraceHelper.trace("getCount-ViewGenericDaoImplementation(begin):object=" + ob);
        PreparedStatement oPreparedStatement = null;
        ResultSet oResultSet = null;
        strCountSQL += SqlHelper.buildSqlFilter(alFilter);
        Long iResult = 0L;
        try {
            oPreparedStatement = oConnection.prepareStatement(strCountSQL);
            oResultSet = oPreparedStatement.executeQuery();
            if (oResultSet.next()) {
                iResult = oResultSet.getLong("COUNT(*)");
            } else {
                String msg = this.getClass().getName() + ": getcount";
                Log4jHelper.errorLog(msg);
                throw new Exception(msg);
            }
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
            Log4jHelper.errorLog(msg, ex);
            throw new Exception(msg, ex);
        } finally {
            if (oResultSet != null) {
                oResultSet.close();
            }
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
            TraceHelper.trace("getCount-ViewGenericDaoImplementation(end):object=" + ob);
        }
        return iResult;
    }

    @Override
    public MetaBeanHelper getPage(int intRegsPerPag, int intPage, LinkedHashMap<String, String> hmOrder, ArrayList<FilterBeanHelper> alFilter, int expand) throws Exception {
        TraceHelper.trace("getPage-ViewGenericDaoImplementation(begin):object=" + ob);
        String strSQL1 = strSQL;
        strSQL1 += SqlHelper.buildSqlFilter(alFilter);
        strSQL1 += SqlHelper.buildSqlOrder(hmOrder);
        strSQL1 += SqlHelper.buildSqlLimit(this.getCount(alFilter), intRegsPerPag, intPage);
        ArrayList<GenericBeanImplementation> aloBean = new ArrayList<>();
        PreparedStatement oPreparedStatement = null;
        ResultSet oResultSet = null;
        MetaBeanHelper oMetaBeanHelper = null;
        try {
            oPreparedStatement = oConnection.prepareStatement(strSQL1);
            oResultSet = oPreparedStatement.executeQuery(strSQL1);
            while (oResultSet.next()) {
                BeanInterface oBean = BeanFactory.getBean(ob, oPuserSecurity);
                oBean = (GenericBeanImplementation) oBean.fill(oResultSet, oConnection, oPuserSecurity, expand);
                aloBean.add((GenericBeanImplementation) oBean);
            }

            ArrayList<MetaPropertyGenericBeanHelper> alMetaProperties = this.getPropertiesMetaData();
            MetaObjectGenericBeanHelper oMetaObject = this.getObjectMetaData();
            oMetaBeanHelper = new MetaBeanHelper(oMetaObject, alMetaProperties, aloBean);

        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
            Log4jHelper.errorLog(msg, ex);
            throw new Exception(msg, ex);
        } finally {
            if (oResultSet != null) {
                oResultSet.close();
            }
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
            TraceHelper.trace("getPage-ViewGenericDaoImplementation(end):object=" + ob);
        }
        return oMetaBeanHelper;
    }

    @Override
    public MetaBeanHelper getPageX(int id_foreign, String ob_foreign, int intRegsPerPag, int intPage, LinkedHashMap<String, String> hmOrder, ArrayList<FilterBeanHelper> alFilter, int expand) throws Exception {
        TraceHelper.trace("getPageX-ViewGenericDaoImplementation(begin):object=" + ob);
        String strSQL1 = strSQL;
        strSQL1 += " and id_" + ob_foreign + "=" + id_foreign + " ";
        strSQL1 += SqlHelper.buildSqlFilter(alFilter);
        strSQL1 += SqlHelper.buildSqlOrder(hmOrder);
        strSQL1 += SqlHelper.buildSqlLimit(getCount(alFilter), intRegsPerPag, intPage);
        ArrayList<GenericBeanImplementation> aloBean = new ArrayList<>();
        PreparedStatement oPreparedStatement = null;
        ResultSet oResultSet = null;
        MetaBeanHelper oMetaBeanHelper = null;
        try {
            oPreparedStatement = oConnection.prepareStatement(strSQL1);
            oResultSet = oPreparedStatement.executeQuery(strSQL1);
            while (oResultSet.next()) {
                BeanInterface oBean = BeanFactory.getBean(ob, oPuserSecurity);
                oBean = (GenericBeanImplementation) oBean.fill(oResultSet, oConnection, oPuserSecurity, expand);
                aloBean.add((GenericBeanImplementation) oBean);
            }

            ArrayList<MetaPropertyGenericBeanHelper> alMetaProperties = this.getPropertiesMetaData();
            MetaObjectGenericBeanHelper oMetaObject = this.getObjectMetaData();
            oMetaBeanHelper = new MetaBeanHelper(oMetaObject, alMetaProperties, aloBean);

        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
            Log4jHelper.errorLog(msg, ex);
            throw new Exception(msg, ex);
        } finally {
            if (oResultSet != null) {
                oResultSet.close();
            }
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
            TraceHelper.trace("getPageX-ViewGenericDaoImplementation(end):object=" + ob);
        }
        return oMetaBeanHelper;
    }

    @Override
    public Long getCountX(int id_foreign, String ob_foreign, ArrayList<FilterBeanHelper> alFilter) throws Exception {
        TraceHelper.trace("getCountX-ViewGenericDaoImplementation(begin):object=" + ob);
        PreparedStatement oPreparedStatement = null;
        ResultSet oResultSet = null;
        strSQL = "SELECT COUNT(*) FROM " + ob;
        strSQL += " WHERE 1=1 ";
        strSQL += " and id_" + ob_foreign + "=" + id_foreign + " ";
        strSQL += SqlHelper.buildSqlFilter(alFilter);
        Long iResult = 0L;
        try {
            oPreparedStatement = oConnection.prepareStatement(strSQL);
            oResultSet = oPreparedStatement.executeQuery(strSQL);
            if (oResultSet.next()) {
                iResult = oResultSet.getLong("COUNT(*)");
            } else {
                String msg = this.getClass().getName() + ": getCountxtipousuario";
                Log4jHelper.errorLog(msg);
                throw new Exception(msg);
            }
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
            Log4jHelper.errorLog(msg, ex);
            throw new Exception(msg, ex);
        } finally {
            if (oResultSet != null) {
                oResultSet.close();
            }
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
            TraceHelper.trace("getCountX-ViewGenericDaoImplementation(end):object=" + ob);
        }
        return iResult;
    }

    protected boolean countSQL(String strSQLini) throws Exception {
        PreparedStatement oPreparedStatement = null;
        ResultSet oResultSet = null;
        Long iResult = 0L;
        try {
            oPreparedStatement = oConnection.prepareStatement(strSQLini);
            oResultSet = oPreparedStatement.executeQuery();
            if (oResultSet.next()) {
                iResult = oResultSet.getLong("COUNT(*)");
            } else {
                String msg = this.getClass().getName() + ": getcount";
                Log4jHelper.errorLog(msg);
                throw new Exception(msg);
            }
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
            Log4jHelper.errorLog(msg, ex);
            throw new Exception(msg, ex);
        } finally {
            if (oResultSet != null) {
                oResultSet.close();
            }
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
        }
        return iResult > 0;
    }

    @Override
    public boolean canCreate(GenericBeanImplementation oBean) throws Exception {
        return false;
    }

    @Override
    public boolean canUpdate(GenericBeanImplementation oBean) throws Exception {
        return false;
    }

    @Override
    public boolean canDelete(GenericBeanImplementation oBean) throws Exception {
        return false;
    }

    @Override
    public boolean canStatistics(GenericBeanImplementation oBean) throws Exception {
        return false;
    }

    @Override
    public MetaBeanHelper get(int id, int intExpand) throws Exception {
        //if (this.canGet(id)) {
        TraceHelper.trace("get-GenericDaoImplementation(begin):object=" + ob);
        PreparedStatement oPreparedStatement = null;
        ResultSet oResultSet = null;
        strSQL += " AND id=? ";
        GenericBeanImplementation oBean = null;
        MetaBeanHelper oMetaBeanHelper = null;
        try {
            oPreparedStatement = oConnection.prepareStatement(strSQL);
            oPreparedStatement.setInt(1, id);
            oResultSet = oPreparedStatement.executeQuery();
            oBean = (GenericBeanImplementation) BeanFactory.getBean(ob, oPuserSecurity);

            if (oResultSet.next()) {
                oBean = (GenericBeanImplementation) oBean.fill(oResultSet, oConnection, oPuserSecurity, intExpand);
            } else {
                oBean.setId(0);
            }
            ArrayList<MetaPropertyGenericBeanHelper> alMetaProperties = this.getPropertiesMetaData();
            MetaObjectGenericBeanHelper oMetaObject = this.getObjectMetaData();
            oMetaBeanHelper = new MetaBeanHelper(oMetaObject, alMetaProperties, oBean);
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
            Log4jHelper.errorLog(msg, ex);
            throw new Exception(msg, ex);
        } finally {
            if (oResultSet != null) {
                oResultSet.close();
            }
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
            TraceHelper.trace("get-GenericDaoImplementation(end):object=" + ob);
        }
        return oMetaBeanHelper;
//        } else {
////            String msg = this.getClass().getName() + ": You don't have enought oermissions to perform this operation" + " ob:" + ob + " op: get";
////            Log4jHelper.errorLog(msg);
////            throw new Exception(msg);
//            return null;
//        }
    }

    @Override
    public Integer create(GenericBeanImplementation oBean) throws Exception {
        if (this.canCreate(oBean)) {
            TraceHelper.trace("create-GenericDaoImplementation(begin):object=" + ob);
            PreparedStatement oPreparedStatement = null;
            ResultSet oResultSet = null;
            Integer iResult = 0;
            try {
                strSQL = "INSERT INTO " + ob;
                strSQL += "(" + oBean.getColumns() + ")";
                strSQL += " VALUES ";
                strSQL += "(" + oBean.getValues() + ")";
                oPreparedStatement = oConnection.prepareStatement(strSQL, Statement.RETURN_GENERATED_KEYS);
                iResult = oPreparedStatement.executeUpdate();
                if (iResult < 1) {
                    String msg = this.getClass().getName() + ": set";
                    Log4jHelper.errorLog(msg);
                    throw new Exception(msg);
                }
                oResultSet = oPreparedStatement.getGeneratedKeys();
                oResultSet.next();
                iResult = oResultSet.getInt(1);

            } catch (Exception ex) {
                String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
                Log4jHelper.errorLog(msg, ex);
                throw new Exception(msg, ex);
            } finally {
                if (oResultSet != null) {
                    oResultSet.close();
                }
                if (oPreparedStatement != null) {
                    oPreparedStatement.close();
                }
                TraceHelper.trace("create-GenericDaoImplementation(end):object=" + ob);
            }
            return iResult;
        } else {
            String msg = this.getClass().getName() + ": You don't have enought oermissions to perform this operation" + " ob:" + ob + " op: create";
            Log4jHelper.errorLog(msg);
            throw new Exception(msg);
        }
    }

    @Override
    public Integer update(GenericBeanImplementation oBean) throws Exception {
        if (this.canUpdate(oBean)) {
            TraceHelper.trace("update-GenericDaoImplementation(begin):object=" + ob);
            PreparedStatement oPreparedStatement = null;
            Integer iResult = 0;
            try {
                strSQL = "UPDATE " + ob;
                strSQL += " SET ";
                strSQL += oBean.toPairs();
                strSQL += " WHERE id=? ";
                oPreparedStatement = oConnection.prepareStatement(strSQL, Statement.RETURN_GENERATED_KEYS);
                oPreparedStatement.setInt(1, oBean.getId());
                iResult = oPreparedStatement.executeUpdate();

                if (iResult < 1) {
                    String msg = this.getClass().getName() + ": set";
                    Log4jHelper.errorLog(msg);
                    throw new Exception(msg);
                }
            } catch (Exception ex) {
                String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
                Log4jHelper.errorLog(msg, ex);
                throw new Exception(msg, ex);
            } finally {

                if (oPreparedStatement != null) {
                    oPreparedStatement.close();
                }
                TraceHelper.trace("update-GenericDaoImplementation(end):object=" + ob);
            }
            return iResult;
        } else {
            String msg = this.getClass().getName() + ": You don't have enought oermissions to perform this operation" + " ob:" + ob + " op: update";
            Log4jHelper.errorLog(msg);
            throw new Exception(msg);
        }

    }

    @Override
    public Integer delete(GenericBeanImplementation oBean) throws Exception {
        if (this.canDelete(oBean)) {
            TraceHelper.trace("remove-GenericDaoImplementation(begin):object=" + ob);
            int iResult = 0;
            strSQL = "DELETE FROM " + ob + " WHERE id=?";
            PreparedStatement oPreparedStatement = null;
            try {
                oPreparedStatement = oConnection.prepareStatement(strSQL);
                oPreparedStatement.setInt(1, oBean.getId());
                iResult = oPreparedStatement.executeUpdate();
            } catch (Exception ex) {
                String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
                Log4jHelper.errorLog(msg, ex);
                throw new Exception(msg, ex);
            } finally {
                if (oPreparedStatement != null) {
                    oPreparedStatement.close();
                }
                TraceHelper.trace("remove-GenericDaoImplementation(end):object=" + ob);
            }
            return iResult;
        } else {
            String msg = this.getClass().getName() + ": You don't have enought oermissions to perform this operation" + " ob:" + ob + " op: update";
            Log4jHelper.errorLog(msg);
            throw new Exception(msg);
        }
    }
}
