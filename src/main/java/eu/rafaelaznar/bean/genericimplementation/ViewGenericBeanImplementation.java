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
package eu.rafaelaznar.bean.genericimplementation;

import eu.rafaelaznar.bean.helper.MetaBeanHelper;
import eu.rafaelaznar.bean.meta.publicinterface.MetaObjectBeanInterface;
import eu.rafaelaznar.bean.meta.publicinterface.MetaPropertyBeanInterface;
import java.sql.Connection;
import java.sql.ResultSet;
import eu.rafaelaznar.bean.publicinterface.GenericBeanInterface;
import eu.rafaelaznar.dao.publicinterface.TableDaoInterface;
import eu.rafaelaznar.factory.DaoFactory;
import eu.rafaelaznar.helper.EnumHelper.FieldType;
import eu.rafaelaznar.helper.Log4jHelper;
import eu.rafaelaznar.helper.TraceHelper;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Date;

public abstract class ViewGenericBeanImplementation implements GenericBeanInterface {

    public ViewGenericBeanImplementation() {

    }

    private String getOwnNameFromObjectMetaData() {
        String strOwnTable = "";
        Annotation[] classAnnotations = this.getClass().getAnnotationsByType(MetaObjectBeanInterface.class);
        for (Integer i = 0; i < classAnnotations.length; i++) {
            if (classAnnotations[i].annotationType().equals(MetaObjectBeanInterface.class)) {
                MetaObjectBeanInterface fieldAnnotation = (MetaObjectBeanInterface) classAnnotations[i];
                strOwnTable = fieldAnnotation.TableName();
            }
        }
        return strOwnTable;
    }

    protected FieldType getTypeFromPropertyMetaData(Field field) {
        FieldType f = null;
        Annotation[] fieldAnnotations = field.getDeclaredAnnotations();
        for (Integer i = 0; i < fieldAnnotations.length; i++) {
            if (fieldAnnotations[i].annotationType().equals(MetaPropertyBeanInterface.class)) {
                MetaPropertyBeanInterface fieldAnnotation = (MetaPropertyBeanInterface) fieldAnnotations[i];
                f = fieldAnnotation.Type();
            }
        }
        return f;
    }

    private String getReferencesFromPropertyMetaData(Field field) {
        String f = null;
        Annotation[] fieldAnnotations = field.getDeclaredAnnotations();
        for (Integer i = 0; i < fieldAnnotations.length; i++) {
            if (fieldAnnotations[i].annotationType().equals(MetaPropertyBeanInterface.class)) {
                MetaPropertyBeanInterface fieldAnnotation = (MetaPropertyBeanInterface) fieldAnnotations[i];
                f = fieldAnnotation.References();
            }
        }
        return f;
    }

    @Override
    public GenericBeanInterface fill(ResultSet oResultSet, Connection oConnection, MetaBeanHelper oPuserBean_security, Integer expand) throws Exception {

        try {
            ViewGenericBeanImplementation oBean = (ViewGenericBeanImplementation) Class.forName(this.getClass().getName()).newInstance();
            TraceHelper.trace("fill-ViewGenericBeanImplementation(begin):object=" + oBean.getClass().getName());
            if (this.getClass().getSuperclass() == TableGenericBeanImplementation.class) {
                TraceHelper.trace("Filling ID field;value=" + oResultSet.getInt("id"));
                Field oField = this.getClass().getSuperclass().getDeclaredField("id");
                oField.setAccessible(true);
                oField.set(this, oResultSet.getInt("id"));
                oField.setAccessible(false);
            }
            Field[] oFields = oBean.getClass().getDeclaredFields();
            for (Field oField : oFields) {
                oField.setAccessible(true);
                if (getTypeFromPropertyMetaData(oField) != null) {
                    if (getTypeFromPropertyMetaData(oField) != FieldType.Calculated) {
                        if (getTypeFromPropertyMetaData(oField) == FieldType.ForeignObject) {
                            TraceHelper.trace("Filling ForeignObject field=" + oField.getName());
                            if (expand > 0) {
                                String ob = getReferencesFromPropertyMetaData(oField);
                                TableDaoInterface oObDao = (TableDaoInterface) DaoFactory.getDao(ob, oConnection, oPuserBean_security, null);
                                TraceHelper.trace("Filling ForeignObject object=" + ob + ";id=" + oResultSet.getInt("id_" + ob));
                                Integer id = oResultSet.getInt("id_" + ob);
                                if (id != null && id > 0) {
                                    MetaBeanHelper oMetaBeanHelper = (MetaBeanHelper) oObDao.get(id, expand - 1);
                                    oField.set(this, oMetaBeanHelper);
                                }
                            } else {
                                String ob = getReferencesFromPropertyMetaData(oField);
                                TraceHelper.trace("Filling ForeignObject field=" + ob + "EoFieldpansion Limit Found!");
                            }
                        } else {
                            if (getTypeFromPropertyMetaData(oField) == FieldType.Link) {
                                String ob = getReferencesFromPropertyMetaData(oField);
                                TableDaoInterface oObDao = (TableDaoInterface) DaoFactory.getDao(ob, oConnection, oPuserBean_security, " and id_" + getOwnNameFromObjectMetaData() + "=" + oResultSet.getInt("id"));
                                TraceHelper.trace("Filling Link field=" + oField.getName() + ";references=" + ob);
                                if (oObDao != null) { //en el proceso de login puede ser nulo!!
                                    oField.set(this, oObDao.getCount(null).intValue());
                                } else {
                                    oField.set(this, 0);
                                }
                            } else {
                                if (getTypeFromPropertyMetaData(oField) == FieldType.ForeignId) {
                                    TraceHelper.trace("Filling ForeignID field=" + oField.getName() + ";value=" + oResultSet.getInt(oField.getName()));
                                    oField.set(this, oResultSet.getInt(oField.getName()));
                                } else {
                                    if (oField.getType() == String.class) {
                                        TraceHelper.trace("Filling String field=" + oField.getName() + ";value=" + oResultSet.getString(oField.getName()));
                                        oField.set(this, oResultSet.getString(oField.getName()));
                                    } else {
                                        if (oField.getType() == Date.class) {
                                            TraceHelper.trace("Filling Date field=" + oField.getName() + ";value=" + oResultSet.getDate(oField.getName()));
                                            oField.set(this, oResultSet.getDate(oField.getName()));
                                        } else {
                                            if (oField.getType() == Double.class || oField.getType() == double.class) {
                                                TraceHelper.trace("Filling Double field=" + oField.getName() + ";value=" + oResultSet.getDouble(oField.getName()));
                                                oField.set(this, oResultSet.getDouble(oField.getName()));
                                            } else {
                                                if (oField.getType() == Integer.class || oField.getType() == int.class) {
                                                    TraceHelper.trace("Filling Integer field=" + oField.getName() + ";value=" + oResultSet.getInt(oField.getName()));
                                                    oField.set(this, oResultSet.getInt(oField.getName()));
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                oField.setAccessible(false);
            }
            this.ComputeCalculatedFields();
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
            Log4jHelper.errorLog(msg, ex);
            throw new Exception(msg, ex);
        } finally {
            TraceHelper.trace("fill-ViewGenericBeanImplementation(end)");
        }
        return this;
    }

    @Override
    public void ComputeCalculatedFields() {
        TraceHelper.trace("ComputeCalculatedFields-ViewGenericBeanImplementation(brgin-end)");
    }
}
