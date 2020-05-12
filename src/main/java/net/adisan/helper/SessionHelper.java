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
package net.adisan.helper;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import net.adisan.bean.helper.MetaBeanHelper;
import net.adisan.bean.specificimplementation.TipousuarioSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.UsuarioSpecificBeanImplementation;
import net.adisan.connection.publicinterface.ConnectionInterface;
import net.adisan.factory.ConnectionFactory;
import net.adisan.helper.constant.ConnectionConstants;

public class SessionHelper {

    public static int getIdTipoUsuario(MetaBeanHelper oPuserBean_security) throws Exception {
        UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
        MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
        TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
        Integer idTipousuario = oTipoUsuario.getId();
        return idTipousuario;
    }

    public static void logDB(Integer id_usuario, String ob, String op) throws Exception {
        Connection oConnection = null;
        ConnectionInterface oPooledConnection = null;
        Statement oStatement = null;
        Statement oStatement2 = null;
        try {
            oPooledConnection = ConnectionFactory.getSourceConnection(ConnectionConstants.connectionName);
            oConnection = oPooledConnection.newConnection();
            Date o30minAgo = new Date(System.currentTimeMillis() - 30 * 60 * 1000);
            Date now = new Date();

            String strSQL = "DELETE FROM log WHERE stamp < " + EncodingHelper.stringifyAndQuotate(o30minAgo);
            oStatement = oConnection.createStatement();
            oStatement.executeUpdate(strSQL);

            String strSQL2 = "INSERT INTO log (id, id_usuario, ob, op, stamp ) VALUES (NULL, " + id_usuario + ", '" + ob + "', '" + op + "', " + EncodingHelper.stringifyAndQuotate(now) + ")";
            oStatement2 = oConnection.createStatement();
            oStatement2.executeUpdate(strSQL2);
        } catch (SQLException ex) {
            throw ex;
        } finally {
            if (oStatement != null) {
                oStatement.close();
            }
            if (oStatement2 != null) {
                oStatement2.close();
            }
            if (oConnection != null) {
                oConnection.close();
            }
            if (oPooledConnection != null) {
                oPooledConnection.disposeConnection();
            }
        }
    }

}
