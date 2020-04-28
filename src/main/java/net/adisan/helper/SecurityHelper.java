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
import net.adisan.bean.helper.MetaBeanHelper;
import net.adisan.bean.specificimplementation.EpisodioSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.EpisodiodiagnosticoSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.GrupoSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.PacienteSpecificBeanImplementation;
import net.adisan.bean.specificimplementation.UsuarioSpecificBeanImplementation;
import net.adisan.dao.specificimplementation.episodio.Episodio1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.episodiodiagnostico.Episodiodiagnostico1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.grupo.Grupo1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.paciente.Paciente1SpecificDaoImplementation;
import net.adisan.dao.specificimplementation.usuario.Usuario1SpecificDaoImplementation;

public class SecurityHelper {

    public Integer getCentroSanitarioFromUsuario34(Connection oConnection, MetaBeanHelper oPuserSecurity, Integer idUsuario) throws Exception {
        Usuario1SpecificDaoImplementation oUsuarioDao = new Usuario1SpecificDaoImplementation(oConnection, oPuserSecurity, null);
        UsuarioSpecificBeanImplementation oUsuarioBean = (UsuarioSpecificBeanImplementation) oUsuarioDao.get(idUsuario, 0).getBean();
        if (oUsuarioBean.getId_tipousuario() == 1 || oUsuarioBean.getId_tipousuario() == 2 || oUsuarioBean.getId_tipousuario() == 5) {
            return 0;
        } else {
            if (oUsuarioBean.getId_tipousuario() == 3) {
                return oUsuarioBean.getId_centrosanitario();
            } else {
                if (oUsuarioBean.getId_tipousuario() == 4) {
                    Grupo1SpecificDaoImplementation oGrupoDao = new Grupo1SpecificDaoImplementation(oConnection, oPuserSecurity, null);
                    GrupoSpecificBeanImplementation oGrupoBean = (GrupoSpecificBeanImplementation) oGrupoDao.get(oUsuarioBean.getId_grupo(), 0).getBean();
                    UsuarioSpecificBeanImplementation oProfesorBean = (UsuarioSpecificBeanImplementation) oUsuarioDao.get(oGrupoBean.getId_usuario(), 0).getBean();
                    return oProfesorBean.getId_centrosanitario();
                }
            }
        }
        return null;
    }

    public Integer getCentroSanitarioFromPaciente(Connection oConnection, MetaBeanHelper oPuserSecurity, Integer idPaciente) throws Exception {
        Paciente1SpecificDaoImplementation oPacienteDao = new Paciente1SpecificDaoImplementation(oConnection, oPuserSecurity, null);
        PacienteSpecificBeanImplementation oPacienteBean = (PacienteSpecificBeanImplementation) oPacienteDao.get(idPaciente, 0).getBean();
        return this.getCentroSanitarioFromUsuario34(oConnection, oPuserSecurity, oPacienteBean.getId_usuario());
    }

    public Integer getCentroSanitarioFromEpisodio(Connection oConnection, MetaBeanHelper oPuserSecurity, Integer idEpisodio) throws Exception {
        Episodio1SpecificDaoImplementation oEpisodioDao = new Episodio1SpecificDaoImplementation(oConnection, oPuserSecurity, null);
        EpisodioSpecificBeanImplementation oEpisodioBean = (EpisodioSpecificBeanImplementation) oEpisodioDao.get(idEpisodio, 0).getBean();
        return getCentroSanitarioFromUsuario34(oConnection, oPuserSecurity, oEpisodioBean.getId_usuario());
    }

    public Integer getCentroSanitarioFromMedico(Connection oConnection, MetaBeanHelper oPuserSecurity, Integer idEpisodio) throws Exception {
        return 0;
    }    

    public Integer getCentroSanitarioFromEpisodiodiagnostico(Connection oConnection, MetaBeanHelper oPuserSecurity, Integer idEpisodio) throws Exception {
        Episodiodiagnostico1SpecificDaoImplementation oEpisodiodiagnosticoDao = new Episodiodiagnostico1SpecificDaoImplementation(oConnection, oPuserSecurity, null);
        EpisodiodiagnosticoSpecificBeanImplementation oEpisodiodiagnosticoBean = (EpisodiodiagnosticoSpecificBeanImplementation) oEpisodiodiagnosticoDao.get(idEpisodio, 0).getBean();
        return getCentroSanitarioFromUsuario34(oConnection, oPuserSecurity, oEpisodiodiagnosticoBean.getId_usuario());

    }    


    
}
