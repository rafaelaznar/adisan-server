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
package net.adisan.dao.specificimplementation.usuario;

import net.adisan.bean.genericimplementation.GenericBeanImplementation;
import net.adisan.bean.helper.MetaBeanHelper;
import net.adisan.bean.specificimplementation.CentrosanitarioSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.TipousuarioSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.UsuarioSpecificBeanImplementation;
import net.adisan.dao.genericimplementation.GenericDaoImplementation;
import net.adisan.helper.EncodingHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Usuario3SpecificDaoImplementation extends GenericDaoImplementation {

    //private final Logger oLogger = (Logger) LogManager.getLogger(this.getClass().getName());
    private Integer idCentrosanitario = null;
    private Integer idUsuario = 0;

    public Usuario3SpecificDaoImplementation(Connection oPooledConnection, MetaBeanHelper oPuserBean_security, String strWhere) throws Exception {
        super("usuario", oPooledConnection, oPuserBean_security, strWhere);
        if (oPuserBean_security != null) {
            UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
            idUsuario = oUsuario.getId();

            MetaBeanHelper ombhTipousuario = (MetaBeanHelper) oUsuario.getObj_tipousuario();
            TipousuarioSpecificBeanImplementation oTipousuario = (TipousuarioSpecificBeanImplementation) ombhTipousuario.getBean();
            if (oTipousuario.getId() == 3) {
                String strSQLini = "";
                CentrosanitarioSpecificBeanImplementation oCentroSanitario = (CentrosanitarioSpecificBeanImplementation) oUsuario.getObj_centrosanitario().getBean();
                idCentrosanitario = oCentroSanitario.getId();
                strSQLini = "FROM usuario where 1=1 "
                        + "AND (id IN (SELECT distinct id FROM usuario where id_centrosanitario = " + idCentrosanitario + " and id_tipousuario=3 ) "
                        + " OR  id IN (SELECT distinct id FROM usuario where id_centrosanitario = " + idCentrosanitario + " and id_tipousuario=5 ) "
                        + " OR  id IN (SELECT distinct u.id FROM usuario u, grupo g, usuario u2 "
                        + "                    WHERE u.id_tipousuario=4 "
                        + "                      AND u.id_grupo=g.id "
                        + "                      AND g.id_usuario=u2.id "
                        + "                      AND u2.id_centrosanitario= " + idCentrosanitario + ")"
                        + ") ";

                strSQL = "SELECT * " + strSQLini;
                strCountSQL = "SELECT COUNT(*) " + strSQLini;
                if (strWhere != null) {
                    strSQL += " " + strWhere + " ";
                    strCountSQL += " " + strWhere + " ";
                }
            } else {
                String msg = this.getClass().getName() + ": constuctor: Unauthorized access";
                throw new Exception(msg);
            }
        } else {
            String msg = this.getClass().getName() + ": constuctor: Unauthorized access";
            throw new Exception(msg);
        }
    }

    @Override
    public boolean canCreate(GenericBeanImplementation oBean) throws Exception {
        UsuarioSpecificBeanImplementation oNewUser = (UsuarioSpecificBeanImplementation) oBean;
        //comprobar que al alumno lo metemos en uno de los grupos del profe en sesion 
        if (esMiGrupo(oNewUser.getId_grupo())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean canUpdate(GenericBeanImplementation oBean) throws Exception {
        UsuarioSpecificBeanImplementation oSessionUser = (UsuarioSpecificBeanImplementation) oPuserSecurity.getBean();
        UsuarioSpecificBeanImplementation oUpdateUser = (UsuarioSpecificBeanImplementation) oBean;
        if (oSessionUser.getId().equals(oUpdateUser.getId())) {
            //soy yo
            return true;
        } else if (esMiAlumno(oUpdateUser.getId())) {
            //el usuario que editamos es realmente un alumno del profesor en sesion
            if (esMiGrupo(oUpdateUser.getId_grupo())) {
                //al alumno lo metemos en uno de los grupos del profe en sesion
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean canDelete(GenericBeanImplementation oBean) throws Exception {
        if (esMiAlumno(oBean.getId())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Integer create(GenericBeanImplementation oBean) throws Exception {
        UsuarioSpecificBeanImplementation oSessionUser = (UsuarioSpecificBeanImplementation) oPuserSecurity.getBean();
        UsuarioSpecificBeanImplementation oNewUser = (UsuarioSpecificBeanImplementation) oBean;
        oNewUser.setId_centro(oSessionUser.getId_centro());
        oNewUser.setId_tipousuario(4);
        oNewUser.setId_centrosanitario(oSessionUser.getId_centrosanitario());
        return super.create(oBean);
    }

    @Override
    public Integer update(GenericBeanImplementation oBean) throws Exception {
        UsuarioSpecificBeanImplementation oSessionUser = (UsuarioSpecificBeanImplementation) oPuserSecurity.getBean();
         UsuarioSpecificBeanImplementation oUpdateUser = (UsuarioSpecificBeanImplementation) oBean;
        oUpdateUser.setId_centro(oSessionUser.getId_centro());
        oUpdateUser.setId_tipousuario(4);
        oUpdateUser.setId_centrosanitario(oSessionUser.getId_centrosanitario());
        return super.update(oBean);
    }

    public Integer activate(Integer id) throws Exception {
        //TraceHelper.trace("Usuario3SpecificDaoImplementation", "activate", "object=" + ob);
        if (esMiAlumno(id)) {
            MetaBeanHelper oUsuarioMBH = this.get(id, 0);
            UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oUsuarioMBH.getBean();
            oUsuario.setActivo(1);
            return this.update(oUsuario);
        } else {
            //TraceHelper.traceError(this.getClass().getName() + ".activate ob:" + ob + " Can't activate: only allowed to deactivate your own students");
            throw new Exception("No tienes permiso: sólo se pueden activar tus alumnos");
        }
    }

    public Integer deactivate(Integer id) throws Exception {
        //TraceHelper.trace("Usuario3SpecificDaoImplementation", "deactivate", "object=" + ob);
        if (esMiAlumno(id)) {
            MetaBeanHelper oUsuarioMBH = this.get(id, 0);
            UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oUsuarioMBH.getBean();
            oUsuario.setActivo(0);
            return this.update(oUsuario);
        } else {
            //TraceHelper.traceError(this.getClass().getName() + ".deactivate ob:" + ob + " Can't deactivate: only allowed to deactivate your own students");
            throw new Exception("Can't deactivate: only allowed to deactivate your own students");
        }
    }

    public Integer updatePassword(int id, String oldPass, String newPass) throws Exception {
        //TraceHelper.trace("Usuario3SpecificDaoImplementation", "updatePassword", "object=" + ob);
        if (esMiAlumno(id) || idUsuario == id) {
            PreparedStatement oPreparedStatement = null;
            Integer iResult = 0;
            try {
                String strSQL = "UPDATE usuario ";
                strSQL += " SET ";
                strSQL += " password = " + EncodingHelper.quotate(newPass);
                strSQL += " WHERE id=? and password=? ";
                oPreparedStatement = oConnection.prepareStatement(strSQL, Statement.RETURN_GENERATED_KEYS);
                oPreparedStatement.setInt(1, id);
                oPreparedStatement.setString(2, oldPass);
                iResult = oPreparedStatement.executeUpdate();
                if (iResult < 1) {
                    String msg = this.getClass().getName() + ": set";
                    throw new Exception(msg);
                }
            } catch (Exception ex) {
                throw ex;
            } finally {
                if (oPreparedStatement != null) {
                    oPreparedStatement.close();
                }
            }
            return iResult;
        } else {
            //TraceHelper.traceError(this.getClass().getName() + ".update ob:" + ob + " Can't reset password: not mine nor my student's pass");
            throw new Exception("Can't reset password: not mine nor my student's pass");
        }
    }

}
