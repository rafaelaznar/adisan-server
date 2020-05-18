/*
 * Copyright (c) 2017-2018
 *
 * by Rafael Angel Aznar Aparici (rafaaznar at gmail dot com) & DAW students
 *
 * ADISAN: Free Open Source Health Management System
 *
 *
 * Sources at:                https://github.com/rafaelaznar/adisan
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
package net.adisan.dao.genericimplementation;

import net.adisan.bean.genericimplementation.GenericBeanImplementation;
import net.adisan.bean.helper.FilterBeanHelper;
import net.adisan.bean.meta.publicinterface.MetaPropertyBeanInterface;
import net.adisan.bean.meta.helper.MetaObjectGenericBeanHelper;
import net.adisan.bean.meta.helper.MetaPropertyGenericBeanHelper;
import net.adisan.bean.helper.MetaBeanHelper;
import net.adisan.bean.meta.publicinterface.MetaObjectBeanInterface;
import net.adisan.dao.publicinterface.DaoInterface;
import net.adisan.factory.BeanFactory;
import net.adisan.helper.EnumHelper;
import net.adisan.helper.SqlHelper;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import net.adisan.bean.helper.PListBeanHelper;
import net.adisan.bean.publicinterface.BeanInterface;
import net.adisan.bean.specificimplementation.UsuarioSpecificBeanImplementation;

public abstract class GenericDaoImplementation implements DaoInterface {
    
    protected String ob = null;
    protected String strSQL = null;
    protected String strCountSQL = null;
    protected Connection oConnection = null;
    protected MetaBeanHelper oMBHUsuarioSession = null;
    
    public GenericDaoImplementation(String obj, Connection oPooledConnection, MetaBeanHelper oMBHUsuarioSession, String strWhere) {
        oConnection = oPooledConnection;
        this.oMBHUsuarioSession = oMBHUsuarioSession;
        ob = obj;
        strSQL = "SELECT * FROM " + ob + " WHERE 1=1 ";
        strCountSQL = "SELECT COUNT(*) FROM " + ob + " WHERE 1=1 ";
        if (strWhere != null) {
            strSQL += " " + strWhere + " ";
            strCountSQL += " " + strWhere + " ";
        }
    }
    
    protected Long count(String strCountSQL) throws SQLException {
        //oLogger.trace("GenericDaoImplementation", "count", "ob" + ob);
        PreparedStatement oPreparedStatement = null;
        ResultSet oResultSet = null;
        Long iResult = 0L;
        try {
            oPreparedStatement = oConnection.prepareStatement(strCountSQL);
            oResultSet = oPreparedStatement.executeQuery();
            if (oResultSet.next()) {
                iResult = oResultSet.getLong("COUNT(*)");
            } else {
                //oLogger.error(this.getClass().getName() + ".count-No count(*) result:ob=" + ob);
                throw new SQLException(this.getClass().getName() + ".count-No count(*) result:ob=" + ob);
            }
            return iResult;
        } catch (SQLException ex) {
            //oLogger.error(this.getClass().getName() + ".count ob:" + ob, ex);
            throw ex;
        } finally {
            if (oResultSet != null) {
                oResultSet.close();
            }
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
        }
    }
    
    @Override
    public MetaBeanHelper getStatistics(int id) throws Exception {
        throw new UnsupportedOperationException("GenericDaoImplementation.getStatistics:Not supported yet.");
    }
    
    private ArrayList<MetaPropertyGenericBeanHelper> fillPropertiesMetaData(Class oClassBEAN, ArrayList<MetaPropertyGenericBeanHelper> alVector) {
        //oLogger.trace("GenericDaoImplementation", "fillPropertiesMetaData", "object = " + ob);
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
                        
                        oMeta.setClip(fieldAnnotation.Clip());
                        
                        oMeta.setIsFormVisible1(fieldAnnotation.IsFormVisible1());
                        oMeta.setIsFormVisible2(fieldAnnotation.IsFormVisible2());
                        oMeta.setIsFormVisible3(fieldAnnotation.IsFormVisible3());
                        oMeta.setIsFormVisible4(fieldAnnotation.IsFormVisible4());
                        oMeta.setIsFormVisible5(fieldAnnotation.IsFormVisible5());
                        alVector.add(oMeta);
                    }
                }
            }
        }
        return alVector;
    }
    
    private MetaObjectGenericBeanHelper fillObjectMetaData(Class oClassBEAN, MetaObjectGenericBeanHelper oMetaObject) throws Exception {
        //oLogger.trace("GenericDaoImplementation", "fillObjectMetaData", "object = " + ob);
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
                oMetaObject.setCanCreateObject(this.canCreateObject());
                oMetaObject.setCreateDescription(fieldAnnotation.CreateDescription());                
            }
        }
        return oMetaObject;
    }
    
    @Override
    public MetaObjectGenericBeanHelper getObjectMetaData() throws Exception {
        //oLogger.trace("GenericDaoImplementation", "getObjectMetaData", "object = " + ob);
        MetaObjectGenericBeanHelper oMetaObject;
        try {
            GenericBeanImplementation oBean = (GenericBeanImplementation) BeanFactory.getBean(ob, oMBHUsuarioSession);
            Class oClassBEAN = oBean.getClass();
            oMetaObject = new MetaObjectGenericBeanHelper();
            oMetaObject = fillObjectMetaData(oClassBEAN, oMetaObject);
        } catch (Exception ex) {
            //oLogger.error(this.getClass().getName() + ".getObjectMetaData ob:" + ob, ex);
            throw ex;
        }
        return oMetaObject;
    }
    
    @Override
    public MetaObjectGenericBeanHelper getObjectMetaData(String ob) throws Exception {
        //oLogger.trace("GenericDaoImplementation", "getObjectMetaData(ob)", "object = " + ob);
        MetaObjectGenericBeanHelper oMetaObject;
        try {
            BeanInterface oBean = (BeanInterface) BeanFactory.getBean(ob, oMBHUsuarioSession);
            Class oClassBEAN = oBean.getClass();
            oMetaObject = new MetaObjectGenericBeanHelper();
            oMetaObject = fillObjectMetaData(oClassBEAN, oMetaObject);
        } catch (Exception ex) {
            //oLogger.error(this.getClass().getName() + ".getObjectMetaData(ob) ob:" + ob, ex);
            throw ex;
        }
        return oMetaObject;
    }
    
    @Override
    public ArrayList<MetaPropertyGenericBeanHelper> getPropertiesMetaData() throws Exception {
        //oLogger.trace("GenericDaoImplementation", "getPropertiesMetaData()", "object = " + ob);
        ArrayList<MetaPropertyGenericBeanHelper> alVector = new ArrayList<>();
        try {
            BeanInterface oBean = (BeanInterface) BeanFactory.getBean(ob, oMBHUsuarioSession);
            Class classBean = oBean.getClass();
            Class superClassBean = oBean.getClass().getSuperclass();
            alVector = fillPropertiesMetaData(superClassBean, alVector);
            alVector = fillPropertiesMetaData(classBean, alVector);
        } catch (Exception ex) {
            //oLogger.error(this.getClass().getName() + ".getPropertiesMetaData() ob:" + ob, ex);
            throw ex;
        }
        return alVector;
    }
    
    @Override
    public ArrayList<MetaPropertyGenericBeanHelper> getPropertiesMetaData(String ob) throws Exception {
        //oLogger.trace("GenericDaoImplementation", "getPropertiesMetaData(ob)", "object = " + ob);
        ArrayList<MetaPropertyGenericBeanHelper> alVector = new ArrayList<>();
        try {
            BeanInterface oBean = (BeanInterface) BeanFactory.getBean(ob, oMBHUsuarioSession);
            Class classBean = oBean.getClass();
            Class superClassBean = oBean.getClass().getSuperclass();
            alVector = fillPropertiesMetaData(superClassBean, alVector);
            alVector = fillPropertiesMetaData(classBean, alVector);
        } catch (Exception ex) {
            //TraceHelper.traceError(this.getClass().getName() + ".getPropertiesMetaData(ob) ob:" + ob, ex);
            throw ex;
        }
        return alVector;
    }
    
    @Override
    public Long getCount(ArrayList<FilterBeanHelper> alFilter) throws SQLException, ParseException, Exception {
        //oLogger.trace("GenericDaoImplementation", "getCount", "object=" + ob);
        PreparedStatement oPreparedStatement = null;
        ResultSet oResultSet = null;
        Long iResult = 0L;
        try {
            strCountSQL += SqlHelper.buildSqlFilter(alFilter);
            oPreparedStatement = oConnection.prepareStatement(strCountSQL);
            oResultSet = oPreparedStatement.executeQuery();
            if (oResultSet.next()) {
                iResult = oResultSet.getLong("COUNT(*)");
            } else {
                String msg = this.getClass().getName() + ": getCount";
                //oLogger.error(msg);
                throw new SQLException(msg);
            }
        } catch (Exception ex) {
            //TraceHelper.traceError(this.getClass().getName() + ".getCount ob:" + ob, ex);
            throw ex;
        } finally {
            if (oResultSet != null) {
                oResultSet.close();
            }
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
        }
        return iResult;
    }
    
    @Override
    public MetaBeanHelper getPage(int intRegsPerPag, int intPage, LinkedHashMap<String, String> hmOrder, ArrayList<FilterBeanHelper> alFilter, int expand) throws Exception {
        //oLogger.trace("GenericDaoImplementation", "getPage", "object=" + ob);
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
                BeanInterface oBean = BeanFactory.getBean(ob, oMBHUsuarioSession);
                oBean = (GenericBeanImplementation) oBean.fill(oResultSet, oConnection, oMBHUsuarioSession, expand);
                aloBean.add((GenericBeanImplementation) oBean);
            }
            
            ArrayList<MetaPropertyGenericBeanHelper> alMetaProperties = this.getPropertiesMetaData();
            MetaObjectGenericBeanHelper oMetaObject = this.getObjectMetaData();
            oMetaBeanHelper = new MetaBeanHelper(oMetaObject, alMetaProperties, aloBean);
            
        } catch (Exception ex) {
            //oLogger.error(this.getClass().getName() + ".getPage ob:" + ob, ex);
            throw ex;
        } finally {
            if (oResultSet != null) {
                oResultSet.close();
            }
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
        }
        return oMetaBeanHelper;
    }
    
    public PListBeanHelper getPList(int intRegsPerPag, int intPage, LinkedHashMap<String, String> hmOrder, ArrayList<FilterBeanHelper> alFilter, int expand) throws Exception {
        PListBeanHelper oPlist = new PListBeanHelper();
        oPlist.setPage(this.getPage(intRegsPerPag, intPage, hmOrder, alFilter, expand));
        oPlist.setCount(this.getCount(alFilter));
        return oPlist;
    }    
    
    @Override
    public MetaBeanHelper getPageX(int id_foreign, String ob_foreign, int intRegsPerPag, int intPage, LinkedHashMap<String, String> hmOrder, ArrayList<FilterBeanHelper> alFilter, int expand) throws Exception {
        //oLogger.trace("GenericDaoImplementation", "getPageX", "object=" + ob);
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
                BeanInterface oBean = BeanFactory.getBean(ob, oMBHUsuarioSession);
                oBean = (GenericBeanImplementation) oBean.fill(oResultSet, oConnection, oMBHUsuarioSession, expand);
                aloBean.add((GenericBeanImplementation) oBean);
            }
            
            ArrayList<MetaPropertyGenericBeanHelper> alMetaProperties = this.getPropertiesMetaData();
            MetaObjectGenericBeanHelper oMetaObject = this.getObjectMetaData();
            oMetaBeanHelper = new MetaBeanHelper(oMetaObject, alMetaProperties, aloBean);
            
        } catch (Exception ex) {
            //Logger.error(this.getClass().getName() + ".getPageX ob:" + ob, ex);
            throw ex;
        } finally {
            if (oResultSet != null) {
                oResultSet.close();
            }
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
        }
        return oMetaBeanHelper;
    }
    
    @Override
    public Long getCountX(int id_foreign, String ob_foreign, ArrayList<FilterBeanHelper> alFilter) throws Exception {
        //oLogger.trace("GenericDaoImplementation", "getCountX", "object=" + ob);
        PreparedStatement oPreparedStatement = null;
        ResultSet oResultSet = null;        
        String strSQL = strCountSQL;
        //strSQL += " WHERE 1=1 ";
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
                //oLogger.error(msg);
                throw new Exception(msg);
            }
        } catch (Exception ex) {
            //TraceHelper.traceError(this.getClass().getName() + ".getCountX ob:" + ob, ex);
            throw ex;
        } finally {
            if (oResultSet != null) {
                oResultSet.close();
            }
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
        }
        return iResult;
    }
    
    public PListBeanHelper getPListX(int id_foreign, String ob_foreign, int intRegsPerPag, int intPage, LinkedHashMap<String, String> hmOrder, ArrayList<FilterBeanHelper> alFilter, int expand) throws Exception {
        PListBeanHelper oPlist = new PListBeanHelper();
        oPlist.setPage(this.getPageX(id_foreign, ob_foreign, intRegsPerPag, intPage, hmOrder, alFilter, expand));
        oPlist.setCount(this.getCountX(id_foreign, ob_foreign, alFilter));
        return oPlist;
    }    
    
    protected Long countSQL(String strSQLini) throws Exception {
        //oLogger.trace("GenericDaoImplementation", "countSQL", "object=" + ob);
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
                //oLogger.error(msg);
                throw new Exception(msg);
            }
        } catch (Exception ex) {
            //TraceHelper.traceError(this.getClass().getName() + ".countSQL ob:" + ob, ex);
            throw ex;
        } finally {
            if (oResultSet != null) {
                oResultSet.close();
            }
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
        }
        return iResult;
    }
    
    @Override
    public boolean canCreateObject() throws Exception {
        return false;
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
        //oLogger.trace("GenericDaoImplementation", "get", "object=" + ob);
        PreparedStatement oPreparedStatement = null;
        ResultSet oResultSet = null;
        String strSQLget = this.strSQL + " AND id=? ";  //OJOOOO
        GenericBeanImplementation oBean = null;
        MetaBeanHelper oMetaBeanHelper = null;
        try {
            oPreparedStatement = oConnection.prepareStatement(strSQLget);
            oPreparedStatement.setInt(1, id);
            oResultSet = oPreparedStatement.executeQuery();
            oBean = (GenericBeanImplementation) BeanFactory.getBean(ob, oMBHUsuarioSession);
            if (oResultSet.next()) {
                oBean = (GenericBeanImplementation) oBean.fill(oResultSet, oConnection, oMBHUsuarioSession, intExpand);
            } else {
                oBean.setId(0);
            }
            ArrayList<MetaPropertyGenericBeanHelper> alMetaProperties = this.getPropertiesMetaData();
            MetaObjectGenericBeanHelper oMetaObject = this.getObjectMetaData();
            oMetaBeanHelper = new MetaBeanHelper(oMetaObject, alMetaProperties, oBean);
        } catch (Exception ex) {
            //oLogger.error(this.getClass().getName() + ".get ob:" + ob, ex);
            throw ex;
        } finally {
            if (oResultSet != null) {
                oResultSet.close();
            }
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
        }
        return oMetaBeanHelper;
    }
    
    @Override
    public Integer create(GenericBeanImplementation oBean) throws Exception {
        //oLogger.trace("GenericDaoImplementation", "create", "object=" + ob);
        Integer iResult = 0;
        if (this.canCreate(oBean)) {
            PreparedStatement oPreparedStatement = null;
            ResultSet oResultSet = null;
            try {
                String strSQL = "INSERT INTO " + ob;
                strSQL += "(" + oBean.getColumns() + ")";
                strSQL += " VALUES ";
                strSQL += "(" + oBean.getValues() + ")";
                oPreparedStatement = oConnection.prepareStatement(strSQL, Statement.RETURN_GENERATED_KEYS);
                iResult = oPreparedStatement.executeUpdate();
                if (iResult < 1) {
                    String msg = this.getClass().getName() + ": set";
                    //oLogger.error(msg);
                    throw new Exception(msg);
                }
                oResultSet = oPreparedStatement.getGeneratedKeys();
                oResultSet.next();
                iResult = oResultSet.getInt(1);
                
            } catch (Exception ex) {
                //TraceHelper.traceError(this.getClass().getName() + ".create ob:" + ob, ex);
                throw ex;
            } finally {
                if (oResultSet != null) {
                    oResultSet.close();
                }
                if (oPreparedStatement != null) {
                    oPreparedStatement.close();
                }
            }
        } else {
            //oLogger.error(this.getClass().getName() + ".create ob:" + ob);
            throw new Exception(this.getClass().getName() + ": You don't have enought permissions to perform this operation" + " ob:" + ob + " op: create");
        }
        return iResult;
    }
    
    @Override
    public Integer update(GenericBeanImplementation oBean) throws Exception {
        //oLogger.trace("GenericDaoImplementation", "update", "object=" + ob);
        Integer iResult = 0;
        if (this.canUpdate(oBean)) {
            PreparedStatement oPreparedStatement = null;
            try {
                String strSQL = "UPDATE " + ob;
                strSQL += " SET ";
                strSQL += oBean.toPairs();
                strSQL += " WHERE id=? ";
                oPreparedStatement = oConnection.prepareStatement(strSQL, Statement.RETURN_GENERATED_KEYS);
                oPreparedStatement.setInt(1, oBean.getId());
                iResult = oPreparedStatement.executeUpdate();
                if (iResult < 1) {
                    String msg = this.getClass().getName() + ": set";
                    //oLogger.error(msg);
                    throw new Exception(msg);
                }
            } catch (Exception ex) {
                //TraceHelper.traceError(this.getClass().getName() + ".update ob:" + ob, ex);
                throw ex;
            } finally {
                if (oPreparedStatement != null) {
                    oPreparedStatement.close();
                }
            }
        } else {
            //oLogger.error(this.getClass().getName() + ".update ob:" + ob);
            throw new Exception(this.getClass().getName() + ": You don't have enought permissions to perform this operation" + " ob:" + ob + " op: update");
        }
        return iResult;
    }
    
    @Override
    public Integer delete(GenericBeanImplementation oBean) throws Exception {
        //oLogger.trace("GenericDaoImplementation", "delete", "object=" + ob);
        int iResult = 0;
        if (this.canDelete(oBean)) {
            String strSQL = "DELETE FROM " + ob + " WHERE id=?";
            PreparedStatement oPreparedStatement = null;
            try {
                oPreparedStatement = oConnection.prepareStatement(strSQL);
                oPreparedStatement.setInt(1, oBean.getId());
                iResult = oPreparedStatement.executeUpdate();
            } catch (Exception ex) {
                //TraceHelper.traceError(this.getClass().getName() + ".delete ob:" + ob, ex);
                throw ex;
            } finally {
                if (oPreparedStatement != null) {
                    oPreparedStatement.close();
                }
            }
        } else {
            //oLogger.error(this.getClass().getName() + ".delete ob:" + ob);
            throw new Exception(this.getClass().getName() + ": You don't have enought permissions to perform this operation" + " ob:" + ob + " op: delete");
        }
        return iResult;
    }
    
    protected boolean esMiGrupo(Integer idGrupo) throws Exception {
        UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oMBHUsuarioSession.getBean();
        if (oUsuario.getId_tipousuario() == 3) {
            Integer idUsuarioProfesor = oUsuario.getId();
            String strSQLini = "SELECT COUNT(*) "
                    + "FROM grupo g WHERE "
                    + "g.id_usuario=" + idUsuarioProfesor + " "
                    + "and g.id=" + idGrupo;
            return this.countSQL(strSQLini) > 0;
        } else {
            return false;
        }
    }    
    
    protected boolean esMiAlumno(Integer idAlumno) throws Exception {
        UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oMBHUsuarioSession.getBean();
        if (oUsuario.getId_tipousuario() == 3) {
            Integer idUsuarioProfesor = oUsuario.getId();
            String strSQLini = "SELECT COUNT(*) "
                    + "FROM usuario u, grupo g "
                    + "where u.id_grupo=g.id "
                    + "and g.id_usuario=" + idUsuarioProfesor + " "
                    + "and u.id=" + idAlumno;
            return this.countSQL(strSQLini) > 0;
        } else {
            return false;
        }
    }
    
    protected boolean esMiProfesor(Integer idProfesor) throws Exception {
        UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oMBHUsuarioSession.getBean();
        if (oUsuario.getId_tipousuario() == 4) {
            Integer idUsuarioAlumno = oUsuario.getId();
            String strSQLini = "SELECT COUNT(*) "
                    + "FROM usuario u, grupo g "
                    + "where u.id_grupo=g.id "
                    + "and g.id_usuario=" + idProfesor + " "
                    + "and u.id=" + idUsuarioAlumno;
            return this.countSQL(strSQLini) > 0;
        } else {
            return false;
        }
    }
    
}
