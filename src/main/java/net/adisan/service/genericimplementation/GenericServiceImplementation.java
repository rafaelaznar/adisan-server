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
package net.adisan.service.genericimplementation;

import com.google.gson.Gson;
import net.adisan.bean.genericimplementation.GenericBeanImplementation;
import net.adisan.bean.helper.FilterBeanHelper;
import net.adisan.bean.helper.MetaBeanHelper;
import net.adisan.bean.helper.ReplyBeanHelper;
import net.adisan.connection.publicinterface.ConnectionInterface;
import net.adisan.dao.publicinterface.DaoInterface;
import net.adisan.factory.BeanFactory;
import net.adisan.factory.ConnectionFactory;
import net.adisan.helper.EncodingHelper;
import net.adisan.helper.GsonHelper;
import net.adisan.helper.Log4jHelper;
import net.adisan.factory.DaoFactory;
import net.adisan.helper.ParameterHelper;
import net.adisan.helper.constant.ConfigurationConstants;
import net.adisan.helper.constant.ConnectionConstants;
import net.adisan.service.publicinterface.ServiceInterface;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import javax.servlet.http.HttpServletRequest;

public abstract class GenericServiceImplementation implements ServiceInterface {

    protected HttpServletRequest oRequest = null;
    protected String ob = null;

    public GenericServiceImplementation(HttpServletRequest request) {
        oRequest = request;
        ob = oRequest.getParameter("ob");
    }

    protected Boolean checkPermission(String strMethodName) {
        MetaBeanHelper oUsuarioBean = (MetaBeanHelper) oRequest.getSession().getAttribute("user");
        if (oUsuarioBean != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public ReplyBeanHelper getMetaData() throws Exception {
        ReplyBeanHelper oReplyBean = null;
        if (this.checkPermission("getMetaData")) {
            String data = null;
            try {
                DaoInterface oDao = DaoFactory.getDao(ob, null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
                HashMap alMeta = new HashMap();
                alMeta.put("metaObject", oDao.getObjectMetaData());
                alMeta.put("metaProperties", oDao.getPropertiesMetaData());
                oReplyBean = new ReplyBeanHelper(200, GsonHelper.getGson().toJson(alMeta));
            } catch (Exception ex) {
                String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
                Log4jHelper.errorLog(msg, ex);
                throw new Exception(msg, ex);
            }
            return oReplyBean;
        } else {
            return new ReplyBeanHelper(401, EncodingHelper.quotate("Unauthorized"));
        }
    }

    @Override
    public ReplyBeanHelper getObjectMetaData() throws Exception {
        ReplyBeanHelper oReplyBean = null;
        if (this.checkPermission("getObjectMetaData")) {
            String data = null;
            try {
                DaoInterface oDao = DaoFactory.getDao(ob, null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
                String strJson = GsonHelper.getGson().toJson(oDao.getObjectMetaData());
                oReplyBean = new ReplyBeanHelper(200, strJson);
            } catch (Exception ex) {
                String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
                Log4jHelper.errorLog(msg, ex);
                throw new Exception(msg, ex);
            }
            return oReplyBean;
        } else {
            return new ReplyBeanHelper(401, EncodingHelper.quotate("Unauthorized"));
        }
    }

    @Override
    public ReplyBeanHelper getPropertiesMetaData() throws Exception {
        ReplyBeanHelper oReplyBean = null;
        if (this.checkPermission("getPropertiesMetaData")) {
            String data = null;
            try {
                DaoInterface oDao = DaoFactory.getDao(ob, null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
                String strJson = GsonHelper.getGson().toJson(oDao.getPropertiesMetaData());
                oReplyBean = new ReplyBeanHelper(200, strJson);
            } catch (Exception ex) {
                String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
                Log4jHelper.errorLog(msg, ex);
                throw new Exception(msg, ex);
            }
            return oReplyBean;
        } else {
            return new ReplyBeanHelper(401, EncodingHelper.quotate("Unauthorized"));
        }
    }

    /*
    * http://127.0.0.1:8081/trolleyes-server/json?ob=xxxxxx&op=getpage&np=1&rpp=10
     */
    @Override
    public ReplyBeanHelper getPage() throws Exception {
        if (this.checkPermission("getpage")) {
            int np = Integer.parseInt(oRequest.getParameter("np"));
            int rpp = Integer.parseInt(oRequest.getParameter("rpp"));
            String strOrder = oRequest.getParameter("order");
            String strFilter = oRequest.getParameter("filter");
            LinkedHashMap<String, String> hmOrder = ParameterHelper.getOrderParams(strOrder);
            ArrayList<FilterBeanHelper> alFilter = ParameterHelper.getFilterParams(strFilter);
            Connection oConnection = null;
            ConnectionInterface oPooledConnection = null;
            ReplyBeanHelper oReplyBean = null;
            MetaBeanHelper oMetaBeanHelper = null;
            try {
                oPooledConnection = ConnectionFactory.getSourceConnection(ConnectionConstants.connectionName);
                oConnection = oPooledConnection.newConnection();
                DaoInterface oDao = (DaoInterface) DaoFactory.getDao(ob, oConnection, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
                oMetaBeanHelper = (MetaBeanHelper) oDao.getPage(rpp, np, hmOrder, alFilter, ConfigurationConstants.jsonMsgDepth);
                String strJson = GsonHelper.getGson().toJson(oMetaBeanHelper);
                oReplyBean = new ReplyBeanHelper(200, strJson);
            } catch (Exception ex) {
                String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
                Log4jHelper.errorLog(msg, ex);
                throw new Exception(msg, ex);
            } finally {
                if (oConnection != null) {
                    oConnection.close();
                }
                if (oPooledConnection != null) {
                    oPooledConnection.disposeConnection();
                }
            }
            return oReplyBean;
        } else {
            return new ReplyBeanHelper(401, EncodingHelper.quotate("Unauthorized"));
        }
    }

    /*
    * http://127.0.0.1:8081/trolleyes-server/json?ob=xxxxxxxx&op=getcount
     */
    @Override
    public ReplyBeanHelper getCount() throws Exception {
        if (this.checkPermission("getcount")) {
            Long lResult;
            Connection oConnection = null;
            ConnectionInterface oPooledConnection = null;
            ReplyBeanHelper oReplyBean = null;
            String strFilter = oRequest.getParameter("filter");
            ArrayList<FilterBeanHelper> alFilter = ParameterHelper.getFilterParams(strFilter);
            try {
                oPooledConnection = ConnectionFactory.getSourceConnection(ConnectionConstants.connectionName);
                oConnection = oPooledConnection.newConnection();
                DaoInterface oDao = (DaoInterface) DaoFactory.getDao(ob, oConnection, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
                lResult = oDao.getCount(alFilter);
                String strJson = GsonHelper.getGson().toJson(lResult);
                oReplyBean = new ReplyBeanHelper(200, strJson);
            } catch (Exception ex) {
                String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
                Log4jHelper.errorLog(msg, ex);
                throw new Exception(msg, ex);
            } finally {
                if (oConnection != null) {
                    oConnection.close();
                }
                if (oPooledConnection != null) {
                    oPooledConnection.disposeConnection();
                }
            }
            return oReplyBean;
        } else {
            return new ReplyBeanHelper(401, EncodingHelper.quotate("Unauthorized"));
        }
    }

    public ReplyBeanHelper getPageX() throws Exception {
        if (this.checkPermission("getpagex")) {
            int np = Integer.parseInt(oRequest.getParameter("np"));
            int rpp = Integer.parseInt(oRequest.getParameter("rpp"));
            int id_foreign = Integer.parseInt(oRequest.getParameter("id_foreign"));
            String ob_foreign = oRequest.getParameter("ob_foreign");
            String strOrder = oRequest.getParameter("order");
            String strFilter = oRequest.getParameter("filter");
            LinkedHashMap<String, String> hmOrder = ParameterHelper.getOrderParams(strOrder);
            ArrayList<FilterBeanHelper> alFilter = ParameterHelper.getFilterParams(strFilter);
            Connection oConnection = null;
            ConnectionInterface oPooledConnection = null;
            ReplyBeanHelper oReplyBean = null;
            MetaBeanHelper oMetaBeanHelper = null;
            try {
                oPooledConnection = ConnectionFactory.getSourceConnection(ConnectionConstants.connectionName);
                oConnection = oPooledConnection.newConnection();
                DaoInterface oDao = (DaoInterface) DaoFactory.getDao(ob, oConnection, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
                oMetaBeanHelper = (MetaBeanHelper) oDao.getPageX(id_foreign, ob_foreign, rpp, np, hmOrder, alFilter, ConfigurationConstants.jsonMsgDepth);
                String strJson = GsonHelper.getGson().toJson(oMetaBeanHelper);
                oReplyBean = new ReplyBeanHelper(200, strJson);
            } catch (Exception ex) {
                String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
                Log4jHelper.errorLog(msg, ex);
                throw new Exception(msg, ex);
            } finally {
                if (oConnection != null) {
                    oConnection.close();
                }
                if (oPooledConnection != null) {
                    oPooledConnection.disposeConnection();
                }
            }
            return oReplyBean;
        } else {
            return new ReplyBeanHelper(401, EncodingHelper.quotate("Unauthorized"));
        }
    }

    @Override
    public ReplyBeanHelper getCountX() throws Exception {
        if (this.checkPermission("getcountx")) {
            Long lResult;
            Connection oConnection = null;
            ConnectionInterface oPooledConnection = null;
            ReplyBeanHelper oReplyBean = null;
            int id_foreign = Integer.parseInt(oRequest.getParameter("id_foreign"));
            String ob_foreign = oRequest.getParameter("ob_foreign");
            String strFilter = oRequest.getParameter("filter");
            ArrayList<FilterBeanHelper> alFilter = ParameterHelper.getFilterParams(strFilter);
            try {
                oPooledConnection = ConnectionFactory.getSourceConnection(ConnectionConstants.connectionName);
                oConnection = oPooledConnection.newConnection();
                DaoInterface oDao = (DaoInterface) DaoFactory.getDao(ob, oConnection, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
                lResult = oDao.getCountX(id_foreign, ob_foreign, alFilter);
                Gson oGson = GsonHelper.getGson();
                String strJson = oGson.toJson(lResult);
                oReplyBean = new ReplyBeanHelper(200, strJson);
            } catch (Exception ex) {
                String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
                Log4jHelper.errorLog(msg, ex);
                throw new Exception(msg, ex);
            } finally {
                if (oConnection != null) {
                    oConnection.close();
                }
                if (oPooledConnection != null) {
                    oPooledConnection.disposeConnection();
                }
            }
            return oReplyBean;
        } else {
            return new ReplyBeanHelper(401, EncodingHelper.quotate("Unauthorized"));
        }
    }

    /*
    * http://127.0.0.1:8081/gesane/json?ob=xxxxxx&op=get&id=n
     */
    @Override
    public ReplyBeanHelper get() throws Exception {
        if (this.checkPermission("get")) {
            int id = Integer.parseInt(oRequest.getParameter("id"));
            Connection oConnection = null;
            ConnectionInterface oPooledConnection = null;
            ReplyBeanHelper oReplyBean = null;
            try {
                oPooledConnection = ConnectionFactory.getSourceConnection(ConnectionConstants.connectionName);
                oConnection = oPooledConnection.newConnection();
                DaoInterface oDao = (DaoInterface) DaoFactory.getDao(ob, oConnection, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
                MetaBeanHelper oMetaBeanHelper = (MetaBeanHelper) oDao.get(id, ConfigurationConstants.jsonMsgDepth);
                String strJson = GsonHelper.getGson().toJson(oMetaBeanHelper);
                oReplyBean = new ReplyBeanHelper(200, strJson);
            } catch (Exception ex) {
                String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
                Log4jHelper.errorLog(msg, ex);
                throw new Exception(msg, ex);
            } finally {
                if (oConnection != null) {
                    oConnection.close();
                }
                if (oPooledConnection != null) {
                    oPooledConnection.disposeConnection();
                }
            }
            return oReplyBean;
        } else {
            return new ReplyBeanHelper(401, EncodingHelper.quotate("Unauthorized"));
        }
    }

    /*
    * http://127.0.0.1:8081/trolleyes-server/json?ob=xxxxxx&op=set (datos aparte)
     */
    private ReplyBeanHelper setoBean(GenericBeanImplementation oBean) throws Exception {
        Connection oConnection = null;
        ConnectionInterface oPooledConnection = null;
        ReplyBeanHelper oReplyBean = null;
        int iResult = 0;
        try {
            oPooledConnection = ConnectionFactory.getSourceConnection(ConnectionConstants.connectionName);
            oConnection = oPooledConnection.newConnection();
            DaoInterface oDao = (DaoInterface) DaoFactory.getDao(ob, oConnection, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            if (oBean.getId() == null || oBean.getId() == 0) {
                iResult = oDao.create(oBean);
            } else {
                iResult = oDao.update(oBean);
            }
            Gson oGson = GsonHelper.getGson();
            String strJson = oGson.toJson(iResult);
            oReplyBean = new ReplyBeanHelper(200, strJson);
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
            Log4jHelper.errorLog(msg, ex);
            throw new Exception(msg, ex);
        } finally {
            if (oConnection != null) {
                oConnection.close();
            }
            if (oPooledConnection != null) {
                oPooledConnection.disposeConnection();
            }
        }
        return oReplyBean;
    }

    @Override
    public ReplyBeanHelper set() throws Exception {
        if (this.checkPermission("set")) {
            String jason = oRequest.getParameter("json");
            GenericBeanImplementation oBean = (GenericBeanImplementation) BeanFactory.getBean(ob, (MetaBeanHelper) oRequest.getSession().getAttribute("user"));
            Gson oGson = GsonHelper.getGson();
            oBean = oGson.fromJson(jason, oBean.getClass());
            ReplyBeanHelper oReplyBean = null;
            if (oBean == null) {
                throw new Exception("Bean null en service set");
            } else {
                oReplyBean = setoBean(oBean);
            }
            return oReplyBean;
        } else {
            return new ReplyBeanHelper(401, EncodingHelper.quotate("Unauthorized"));
        }
    }

    /*
    * http://127.0.0.1:8081/trolleyes-server/json?ob=xxxxxxx&op=remove&id=1
     */
    @Override
    public ReplyBeanHelper remove() throws Exception {
        if (this.checkPermission("remove")) {
            int id = Integer.parseInt(oRequest.getParameter("id"));
            int iResult = 0;
            Connection oConnection = null;
            ConnectionInterface oPooledConnection = null;
            ReplyBeanHelper oReplyBean = null;
            try {
                oPooledConnection = ConnectionFactory.getSourceConnection(ConnectionConstants.connectionName);
                oConnection = oPooledConnection.newConnection();
                DaoInterface oDao = (DaoInterface) DaoFactory.getDao(ob, oConnection, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
                GenericBeanImplementation oBean = (GenericBeanImplementation) BeanFactory.getBean(ob, (MetaBeanHelper) oRequest.getSession().getAttribute("user"));
                oBean.setId(id);

                oBean = (GenericBeanImplementation) oDao.get(oBean.getId(), 0).getBean();
                iResult = oDao.delete(oBean);
                Gson oGson = GsonHelper.getGson();
                String strJson = oGson.toJson(iResult);
                oReplyBean = new ReplyBeanHelper(200, strJson);
            } catch (Exception ex) {
                String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
                Log4jHelper.errorLog(msg, ex);
                throw new Exception(msg, ex);
            } finally {
                if (oConnection != null) {
                    oConnection.close();
                }
                if (oPooledConnection != null) {
                    oPooledConnection.disposeConnection();
                }
            }
            return oReplyBean;
        } else {
            return new ReplyBeanHelper(401, EncodingHelper.quotate("Unauthorized"));
        }
    }

    @Override
    public ReplyBeanHelper getStatistics() throws Exception {
        if (this.checkPermission("getStatistics")) {
            int id = Integer.parseInt(oRequest.getParameter("id"));
            Connection oConnection = null;
            ConnectionInterface oPooledConnection = null;
            ReplyBeanHelper oReplyBean = null;
            try {
                oPooledConnection = ConnectionFactory.getSourceConnection(ConnectionConstants.connectionName);
                oConnection = oPooledConnection.newConnection();
                DaoInterface oDao = (DaoInterface) DaoFactory.getDao(ob, oConnection, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
                MetaBeanHelper oMetaBeanHelper = (MetaBeanHelper) oDao.getStatistics(id);
                String strJson = GsonHelper.getGson().toJson(oMetaBeanHelper);
                oReplyBean = new ReplyBeanHelper(200, strJson);
            } catch (Exception ex) {
                String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
                Log4jHelper.errorLog(msg, ex);
                throw new Exception(msg, ex);
            } finally {
                if (oConnection != null) {
                    oConnection.close();
                }
                if (oPooledConnection != null) {
                    oPooledConnection.disposeConnection();
                }
            }
            return oReplyBean;
        } else {
            return new ReplyBeanHelper(401, EncodingHelper.quotate("Unauthorized"));
        }

    }

}
