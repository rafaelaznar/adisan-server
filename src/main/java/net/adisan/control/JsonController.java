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
package net.adisan.control;

import net.adisan.bean.helper.ReplyBeanHelper;
import net.adisan.connection.publicinterface.ConnectionInterface;
import net.adisan.factory.ConnectionFactory;
import net.adisan.constant.ConnectionConstants;
import net.adisan.constant.ConfigurationConstants;

import net.adisan.factory.ServiceFactory;
import net.adisan.helper.EnumHelper.Environment;
import static net.adisan.helper.ParameterHelper.prepareCamelCaseObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.adisan.bean.helper.MetaBeanHelper;
import net.adisan.bean.specificimplementation.UsuarioSpecificBeanImplementation;

import net.adisan.helper.EncodingHelper;
import net.adisan.helper.SessionHelper;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
public class JsonController extends HttpServlet {

    //private final Logger oLogger = (Logger) LogManager.getLogger(this.getClass().getName());
    private void Controllerdelay(Integer iLast) {
        try {
            if (iLast > 0) {
                Thread.sleep(iLast);
            }
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public static String getStackTrace(final Throwable throwable) {
        final StringWriter sw = new StringWriter();
        final PrintWriter pw = new PrintWriter(sw, true);
        throwable.printStackTrace(pw);
        return sw.getBuffer().toString();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, Exception {
        ReplyBeanHelper oReplyBean = null;
        try (PrintWriter out = response.getWriter()) {
            String ob = prepareCamelCaseObject(request);
            String op = request.getParameter("op");
            //--                         
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (Exception ex) {
                oReplyBean = new ReplyBeanHelper(500, "Database Connection Error: Please contact your administrator");
            }
            if (ConfigurationConstants.environment == Environment.Debug) {
                Controllerdelay(ConfigurationConstants.programDalay);
            }
            if (("".equalsIgnoreCase(ob) && "".equalsIgnoreCase(op)) || (ob == null && op == null)) {
                Connection oConnection = null;
                ConnectionInterface oPooledConnection = null;
                response.setContentType("text/html;charset=UTF-8");
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head><title>ADISAN server</title><link rel=\"shortcut icon\" href=\"favicon.ico\" type=\"image/x-icon\"></head>");
                out.println("<body style=\"background: url(/images/adisan80g.png) no-repeat center center fixed; background-repeat: no-repeat;background-size: 900px;\">");
                out.println("<h1>Welcome to ADISAN server</h1><h2>Servlet controller json listening at " + InetAddress.getLocalHost().getHostAddress() + ":" + request.getLocalPort() + request.getContextPath() + "</h2>");
                out.println("version: " + ConfigurationConstants.version + " (" + ConfigurationConstants.versionDate + ")" + "<br>");
                out.println("author: " + ConfigurationConstants.author + " (" + ConfigurationConstants.authorMail + ") " + "<br>");
                out.println("license: " + ConfigurationConstants.licenseLink + "<br>");
                out.println("sources: " + ConfigurationConstants.sources + "<br>");
                //----
                //--
                try {
                    oPooledConnection = ConnectionFactory.getSourceConnection(ConnectionConstants.connectionName);
                    oConnection = oPooledConnection.newConnection();
                    out.print("<h3>Database Connection OK</h3>");
                } catch (Exception ex) {
                    out.println("<h3>Database Conexión KO:</h3><h4>" + ex.getMessage() + "</h4>");
                } finally {
                    out.println("</body>");
                    out.println("</html>");
                    if (oConnection != null) {
                        oConnection.close();
                    }
                    if (oPooledConnection != null) {
                        oPooledConnection.disposeConnection();
                    }
                }
            } else {
                response.setContentType("application/json;charset=UTF-8");
                response.setHeader("Access-Control-Allow-Origin", request.getHeader("origin"));
                response.setHeader("Access-Control-Allow-Methods", "GET,POST");
                response.setHeader("Access-Control-Max-Age", "86400");
                response.setHeader("Access-Control-Allow-Credentials", "true");
                response.setHeader("Access-Control-Allow-Headers", "Origin, Accept, x-requested-with, Content-Type");
                //response.setHeader("Set-Cookie: cross-site-cookie=name; SameSite=None; Secure");
                response.setHeader("Set-Cookie", "HttpOnly;SameSite=Strict;Secure");
                //response.setHeader("Set-Cookie", "HttpOnly;SameSite=None;Secure");
                if (ob.equalsIgnoreCase("usuario") && op.equalsIgnoreCase("getpage")) {
                    //TraceHelper.traceCode = true;
                }
                //--
//                if (request.getSession().getAttribute("user") != null) {
//                    MetaBeanHelper oMBHUsuario = (MetaBeanHelper) request.getSession().getAttribute("user");
//                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oMBHUsuario.getBean();
//                    SessionHelper.logDB(oUsuario.getId(), ob, op);
//                } else {
//                    SessionHelper.logDB(null, ob, op);
//                }

                //--
                //oLogger.info("JsonController.processRequest(ob=" + ob + ";op=" + op + ")");
                try {
                    oReplyBean = (ReplyBeanHelper) ServiceFactory.executeMethodService(request);
                } catch (Exception ex) {
                    //oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("ADISAN-server error. Please, contact your administrator."));
                    StringWriter errors = new StringWriter();
                    ex.printStackTrace(new PrintWriter(errors));

                    oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("MSG: " + EncodingHelper.escape4JSON(ex.getMessage() + " TRACE: " + getStackTrace(ex))));
                    //oLogger.error("JsonController.processRequest", ex);
                }
                //response.setStatus(oReplyBean.getCode());
                response.setStatus(200);
                out.print("{\"status\":" + oReplyBean.getCode() + ", \"json\":" + oReplyBean.getJson() + "}");

            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            //oLogger.error("JsonController.doGet",ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            //oLogger.error("JsonController.doPost",ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Controller";
    }// </editor-fold>

}
