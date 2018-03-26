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
package eu.rafaelaznar.dao.genericimplementation;

import eu.rafaelaznar.bean.genericimplementation.TableGenericBeanImplementation;
import eu.rafaelaznar.bean.helper.MetaBeanHelper;
import eu.rafaelaznar.bean.meta.helper.MetaObjectGenericBeanHelper;
import eu.rafaelaznar.bean.meta.helper.MetaPropertyGenericBeanHelper;
import eu.rafaelaznar.helper.Log4jHelper;
import eu.rafaelaznar.factory.BeanFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import eu.rafaelaznar.dao.publicinterface.TableDaoInterface;
import eu.rafaelaznar.helper.TraceHelper;
import java.util.ArrayList;

public abstract class TableGenericDaoImplementation extends ViewGenericDaoImplementation implements TableDaoInterface {

    public TableGenericDaoImplementation(String ob, Connection oPooledConnection, MetaBeanHelper oPuserBean_security, String strWhere) throws Exception {
        super(ob, oPooledConnection, oPuserBean_security, strWhere);
    }

    @Override
    public MetaBeanHelper get(int id, int intExpand) throws Exception {
        TraceHelper.trace("get-TableGenericDaoImplementation(begin):object=" + ob);
        PreparedStatement oPreparedStatement = null;
        ResultSet oResultSet = null;
        strSQL += " AND id=? ";
        TableGenericBeanImplementation oBean = null;
        MetaBeanHelper oMetaBeanHelper = null;
        try {
            oPreparedStatement = oConnection.prepareStatement(strSQL);
            oPreparedStatement.setInt(1, id);
            oResultSet = oPreparedStatement.executeQuery();
            oBean = (TableGenericBeanImplementation) BeanFactory.getBean(ob, oPuserSecurity);
            if (oResultSet.next()) {
                oBean = (TableGenericBeanImplementation) oBean.fill(oResultSet, oConnection, oPuserSecurity, intExpand);
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
            TraceHelper.trace("get-TableGenericDaoImplementation(end):object=" + ob);
        }
        return oMetaBeanHelper;
    }

    @Override
    public Integer create(TableGenericBeanImplementation oBean) throws Exception {
        TraceHelper.trace("create-TableGenericDaoImplementation(begin):object=" + ob);
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
            TraceHelper.trace("create-TableGenericDaoImplementation(end):object=" + ob);
        }
        return iResult;
    }

    @Override
    public Integer update(TableGenericBeanImplementation oBean) throws Exception {
        TraceHelper.trace("update-TableGenericDaoImplementation(begin):object=" + ob);
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
            TraceHelper.trace("update-TableGenericDaoImplementation(end):object=" + ob);
        }
        return iResult;
    }

    @Override
    public int remove(Integer id) throws Exception {
        TraceHelper.trace("remove-TableGenericDaoImplementation(begin):object=" + ob);
        int iResult = 0;
        strSQL = "DELETE FROM " + ob + " WHERE id=?";
        PreparedStatement oPreparedStatement = null;
        try {
            oPreparedStatement = oConnection.prepareStatement(strSQL);
            oPreparedStatement.setInt(1, id);
            iResult = oPreparedStatement.executeUpdate();
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
            Log4jHelper.errorLog(msg, ex);
            throw new Exception(msg, ex);
        } finally {
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
            TraceHelper.trace("remove-TableGenericDaoImplementation(end):object=" + ob);
        }
        return iResult;
    }

}
