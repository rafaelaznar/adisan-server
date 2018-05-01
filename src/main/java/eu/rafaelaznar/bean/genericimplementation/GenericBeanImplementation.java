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

import com.google.gson.annotations.Expose;
import eu.rafaelaznar.bean.helper.MetaBeanHelper;
import eu.rafaelaznar.bean.meta.publicinterface.MetaObjectBeanInterface;
import eu.rafaelaznar.bean.meta.publicinterface.MetaPropertyBeanInterface;
import java.sql.Connection;
import java.sql.ResultSet;
import eu.rafaelaznar.dao.publicinterface.DaoInterface;
import eu.rafaelaznar.factory.DaoFactory;
import eu.rafaelaznar.helper.EncodingHelper;
import eu.rafaelaznar.helper.EnumHelper;
import eu.rafaelaznar.helper.EnumHelper.FieldType;
import eu.rafaelaznar.helper.Log4jHelper;
import eu.rafaelaznar.helper.RandomHelper;
import eu.rafaelaznar.helper.TraceHelper;
import eu.rafaelaznar.helper.constant.ConfigurationConstants;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Date;
import eu.rafaelaznar.bean.publicinterface.BeanInterface;

public abstract class GenericBeanImplementation implements BeanInterface {

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "ID",
            LongName = "Identificador",
            Description = "Número Identificador de registro",
            IsVisible = true,
            Type = EnumHelper.FieldType.Id
    )

    protected Integer id;
    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "canCreate",
            LongName = "canCreate",
            Description = "canCreate",
            Type = EnumHelper.FieldType.Can
    )
    private Boolean canCreate;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "canUpdate",
            LongName = "canUpdate",
            Description = "canUpdate",
            Type = EnumHelper.FieldType.Can
    )
    private Boolean canUpdate;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "canDelete",
            LongName = "canDelete",
            Description = "canDelete",
            Type = EnumHelper.FieldType.Can
    )
    private Boolean canDelete;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "canStatistics",
            LongName = "canStatistics",
            Description = "canStatistics",
            Type = EnumHelper.FieldType.Can
    )
    private Boolean canStatistics;

    public GenericBeanImplementation() {

    }

    public GenericBeanImplementation(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getCanCreate() {
        return canCreate;
    }

    public void setCanCreate(Boolean canCreate) {
        this.canCreate = canCreate;
    }

    public Boolean getCanUpdate() {
        return canUpdate;
    }

    public void setCanUpdate(Boolean canUpdate) {
        this.canUpdate = canUpdate;
    }

    public Boolean getCanDelete() {
        return canDelete;
    }

    public void setCanDelete(Boolean canDelete) {
        this.canDelete = canDelete;
    }

    public Boolean getCanStatistics() {
        return canStatistics;
    }

    public void setCanStatistics(Boolean canStatistics) {
        this.canStatistics = canStatistics;
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
    public BeanInterface fill(ResultSet oResultSet, Connection oConnection, MetaBeanHelper oPuserBean_security, Integer expand) throws Exception {

        try {
            GenericBeanImplementation oBean = (GenericBeanImplementation) Class.forName(this.getClass().getName()).newInstance();
            TraceHelper.trace("fill-GenericBeanImplementation(begin):object=" + oBean.getClass().getName());
            if (this.getClass().getSuperclass() == GenericBeanImplementation.class) {
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
                                DaoInterface oObDao = (DaoInterface) DaoFactory.getDao(ob, oConnection, oPuserBean_security, null);
                                TraceHelper.trace("Filling ForeignObject object=" + ob + ";id=" + oResultSet.getInt("id_" + ob));
                                Integer id = oResultSet.getInt("id_" + ob);
                                if (id != null && id > 0) {
                                    MetaBeanHelper oMetaBeanHelper = (MetaBeanHelper) oObDao.get(id, expand - 1);
                                    oField.set(this, oMetaBeanHelper);
                                } else {
                                    oField.set(this, null);
                                }
                            } else {
                                String ob = getReferencesFromPropertyMetaData(oField);
                                TraceHelper.trace("Filling ForeignObject field=" + ob + " Field Expansion Limit Found!");
                            }
                        } else {
                            if (getTypeFromPropertyMetaData(oField) == FieldType.Link) {
                                String ob = getReferencesFromPropertyMetaData(oField);
                                DaoInterface oObDao = (DaoInterface) DaoFactory.getDao(ob, oConnection, oPuserBean_security, " and id_" + getOwnNameFromObjectMetaData() + "=" + oResultSet.getInt("id"));
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

            if (this.getClass().getSuperclass() == GenericBeanImplementation.class) {

                DaoInterface oObDao = (DaoInterface) DaoFactory.getDao(getOwnNameFromObjectMetaData(), oConnection, oPuserBean_security, "");

                TraceHelper.trace("Filling canCreate field");
                Field oFieldcanCreate = this.getClass().getSuperclass().getDeclaredField("canCreate");
                oFieldcanCreate.setAccessible(true);
                oFieldcanCreate.set(this, oObDao.canCreate((GenericBeanImplementation) this));
                oFieldcanCreate.setAccessible(false);

                TraceHelper.trace("Filling canUpdate field");
                Field oFieldcanUpdate = this.getClass().getSuperclass().getDeclaredField("canUpdate");
                oFieldcanUpdate.setAccessible(true);
                oFieldcanUpdate.set(this, oObDao.canUpdate((GenericBeanImplementation) this));
                oFieldcanUpdate.setAccessible(false);

                TraceHelper.trace("Filling canDelete field");
                Field oFieldcanDelete = this.getClass().getSuperclass().getDeclaredField("canDelete");
                oFieldcanDelete.setAccessible(true);
                oFieldcanDelete.set(this, oObDao.canDelete((GenericBeanImplementation) this));
                oFieldcanDelete.setAccessible(false);

                TraceHelper.trace("Filling canStatistics field");
                Field oFieldcanStatistics = this.getClass().getSuperclass().getDeclaredField("canStatistics");
                oFieldcanStatistics.setAccessible(true);
                oFieldcanStatistics.set(this, oObDao.canStatistics((GenericBeanImplementation) this));
                oFieldcanStatistics.setAccessible(false);

            }

        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
            Log4jHelper.errorLog(msg, ex);
            throw new Exception(msg, ex);
        } finally {
            TraceHelper.trace("fill-GenericBeanImplementation(end)");
        }
        return this;
    }

    @Override
    public void ComputeCalculatedFields() {
        TraceHelper.trace("ComputeCalculatedFields-GenericBeanImplementation(brgin-end)");
    }

    @Override
    public String getColumns() throws Exception {
        String strColumns = "";
        try {
            GenericBeanImplementation oBean = (GenericBeanImplementation) Class.forName(this.getClass().getName()).newInstance();
            Field[] oFields = oBean.getClass().getDeclaredFields();
            for (Field x : oFields) {
                if (getTypeFromPropertyMetaData(x) != null) {
                    if (getTypeFromPropertyMetaData(x) != EnumHelper.FieldType.Calculated) {
                        if (getTypeFromPropertyMetaData(x) != EnumHelper.FieldType.ForeignObject) {
                            if (getTypeFromPropertyMetaData(x) != EnumHelper.FieldType.Link) {
                                strColumns += x.getName() + ",";
                            }
                        }
                    }
                }
            }
            strColumns = strColumns.substring(0, strColumns.length() - 1);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
            Log4jHelper.errorLog(msg, ex);
            throw new Exception(msg, ex);
        }
        return strColumns;
    }

    @Override
    public String getValues() throws Exception {
        String strColumns = "";
        try {
            GenericBeanImplementation oBean = (GenericBeanImplementation) Class.forName(this.getClass().getName()).newInstance();
            Field[] oFields = oBean.getClass().getDeclaredFields();
            for (Field x : oFields) {
                if (getTypeFromPropertyMetaData(x) != null) {
                    x.setAccessible(true);
                    if (getTypeFromPropertyMetaData(x) != EnumHelper.FieldType.Calculated) {
                        if (getTypeFromPropertyMetaData(x) != EnumHelper.FieldType.ForeignObject) {
                            if (getTypeFromPropertyMetaData(x) != EnumHelper.FieldType.Link) {
                                if (getTypeFromPropertyMetaData(x) == EnumHelper.FieldType.ForeignId) {
                                    strColumns += (Integer) x.get(this) + ",";
                                } else if (getTypeFromPropertyMetaData(x) == EnumHelper.FieldType.Password) {
                                    if (x.get(this) == null) {
                                        strColumns += EncodingHelper.quotate("29A666F773333B5BA55BB7B1E6177A236665616BB87CF6DFCFEDAA08F8E7D01B".toUpperCase()) + ", "; //por defecto pass=gesane
                                    } else {
                                        strColumns += EncodingHelper.quotate((String) x.get(this).toString().toUpperCase()) + ",";
                                    }
                                } else if (getTypeFromPropertyMetaData(x) == EnumHelper.FieldType.Token) {
                                    strColumns += EncodingHelper.quotate(RandomHelper.getToken(ConfigurationConstants.tokenSize)) + ", ";
                                } else if (x.getType() == String.class) {
                                    strColumns += EncodingHelper.quotate((String) x.get(this)) + ",";
                                } else if (x.getType() == Date.class) {
                                    strColumns += EncodingHelper.stringifyAndQuotate((Date) x.get(this)) + ",";
                                } else if (x.getType() == Integer.class) {
                                    strColumns += (Integer) x.get(this) + ",";
                                } else if (x.getType() == Double.class) {
                                    strColumns += (Double) x.get(this) + ",";
                                } else if (x.getType() == Boolean.class) {
                                    strColumns += (int) x.get(this) + ",";
                                }
                            }
                        }
                    }
                    x.setAccessible(false);
                }
            }
            strColumns = strColumns.substring(0, strColumns.length() - 1);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
            Log4jHelper.errorLog(msg, ex);
            throw new Exception(msg, ex);
        }
        return strColumns;
    }

    @Override
    public String toPairs() throws Exception {
        String strColumns = "";
        try {
            GenericBeanImplementation oBean = (GenericBeanImplementation) Class.forName(this.getClass().getName()).newInstance();
            Field[] oFields = oBean.getClass().getDeclaredFields();
            for (Field x : oFields) {
                if (getTypeFromPropertyMetaData(x) != null) {
                    if (getTypeFromPropertyMetaData(x) != EnumHelper.FieldType.Calculated) {
                        if (getTypeFromPropertyMetaData(x) != EnumHelper.FieldType.ForeignObject) {
                            if (getTypeFromPropertyMetaData(x) != EnumHelper.FieldType.Link) {
                                if (getTypeFromPropertyMetaData(x) != EnumHelper.FieldType.Password) {
                                    x.setAccessible(true);
                                    strColumns += x.getName() + "=";
                                    if (x.getType() == String.class) {
                                        strColumns += EncodingHelper.quotate((String) x.get(this)) + ",";
                                    } else if (x.getType() == Date.class) {
                                        strColumns += EncodingHelper.stringifyAndQuotate((Date) x.get(this)) + ",";
                                    } else if (x.getType() == Integer.class) {
                                        strColumns += (Integer) x.get(this) + ",";
                                    } else if (x.getType() == Double.class) {
                                        strColumns += (Double) x.get(this) + ",";
                                    } else if (x.getType() == Boolean.class) {
                                        strColumns += (int) x.get(this) + ",";
                                    }
                                    x.setAccessible(false);
                                }
                            }
                        }
                    }
                }
            }
            strColumns = strColumns.substring(0, strColumns.length() - 1);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
            Log4jHelper.errorLog(msg, ex);
            throw new Exception(msg, ex);
        }
        return strColumns;
    }

}
