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
var anyAuthenticationPromise = function (sessionService) {
    return sessionService.anyAuthenticationPromise();
};
var authentication1Promise = function (sessionService) { //administrador
    return sessionService.authenticationPromise(1);
};
var authentication2Promise = function (sessionService) {
    return sessionService.authenticationPromise(2);
};
var authentication3Promise = function (sessionService) { //profesor
    return sessionService.authenticationPromise(3);
};
var authentication4Promise = function (sessionService) { //alumno
    return sessionService.authenticationPromise(4);
};
var authentication5Promise = function (sessionService) { //visitante
    return sessionService.authenticationPromise(5);
};
gesane.config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/', {templateUrl: 'js/system/shared/home.html', controller: 'HomeController', resolve: {auth: anyAuthenticationPromise}});
        //--
        $routeProvider.when('/login', {templateUrl: 'js/system/shared/login.html', controller: 'LoginController', resolve: {auth: anyAuthenticationPromise}});
        $routeProvider.when('/profile', {templateUrl: 'js/system/shared/profile.html', controller: 'ProfileController', resolve: {auth: anyAuthenticationPromise}});
        $routeProvider.when('/logout', {templateUrl: 'js/system/shared/logout.html', controller: 'LogoutController', resolve: {auth: anyAuthenticationPromise}});
        $routeProvider.when('/home', {templateUrl: 'js/system/shared/home.html', controller: 'HomeController', resolve: {auth: anyAuthenticationPromise}});
        $routeProvider.when('/license', {templateUrl: 'js/system/shared/license.html', controller: 'LicenseController', resolve: {auth: anyAuthenticationPromise}});
        $routeProvider.when('/passchange', {templateUrl: 'js/system/shared/passchange.html', controller: 'PasschangeController', resolve: {auth: anyAuthenticationPromise}});
        //--
        //-- usuario
        //--
        $routeProvider.when('/usuario/1/plist/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'UsuarioPList1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/usuario/1/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'UsuarioView1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/usuario/1/new/:id?', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'UsuarioNew1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/usuario/1/edit/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'UsuarioEdit1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/usuario/1/remove/:id', {templateUrl: 'js/system/shared/app/remove.html', controller: 'UsuarioRemove1Controller', resolve: {auth: authentication1Promise}});
        //--
        $routeProvider.when('/usuario/1/xtipousuario/plistx/:id/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'UsuarioXtipousuarioPList1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/usuario/1/xtipousuario/newx/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'UsuarioXtipousuarioNew1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/usuario/1/xtipousuario/editx/:id/:xid', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'UsuarioXtipousuarioEdit1Controller', resolve: {auth: authentication1Promise}});
        //--
        $routeProvider.when('/usuario/1/xgrupo/plistx/:id/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'UsuarioXgrupoPList1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/usuario/1/xgrupo/newx/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'UsuarioXgrupoNew1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/usuario/1/xgrupo/editx/:id/:xid', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'UsuarioXgrupoEdit1Controller', resolve: {auth: authentication1Promise}});
        //--
        $routeProvider.when('/usuario/1/xcentro/plistx/:id/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'UsuarioXcentroPList1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/usuario/1/xcentro/newx/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'UsuarioXcentroNew1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/usuario/1/xcentro/editx/:id/:xid', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'UsuarioXcentroEdit1Controller', resolve: {auth: authentication1Promise}});
        //--
        $routeProvider.when('/usuario/1/xcentrosanitario/plistx/:id/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'UsuarioXcentrosanitarioPList1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/usuario/1/xcentrosanitario/newx/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'UsuarioXcentrosanitarioNew1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/usuario/1/xcentrosanitario/editx/:id/:xid', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'UsuarioXcentrosanitarioEdit1Controller', resolve: {auth: authentication1Promise}});        
        //--
        $routeProvider.when('/usuario/3/plist/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'UsuarioPList3Controller', resolve: {auth: authentication3Promise}});
        $routeProvider.when('/usuario/3/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'UsuarioView3Controller', resolve: {auth: authentication3Promise}});
        $routeProvider.when('/usuario/3/new/:id?', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'UsuarioNew3Controller', resolve: {auth: authentication3Promise}});
        $routeProvider.when('/usuario/3/edit/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'UsuarioEdit3Controller', resolve: {auth: authentication3Promise}});
        $routeProvider.when('/usuario/3/remove/:id', {templateUrl: 'js/system/shared/app/remove.html', controller: 'UsuarioRemove3Controller', resolve: {auth: authentication3Promise}});
        //--
        $routeProvider.when('/usuario/3/xtipousuario/plistx/:id/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'UsuarioXtipousuarioPList3Controller', resolve: {auth: authentication3Promise}});
        $routeProvider.when('/usuario/3/xtipousuario/newx/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'UsuarioXtipousuarioNew3Controller', resolve: {auth: authentication3Promise}});
        $routeProvider.when('/usuario/3/xtipousuario/editx/:id/:xid', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'UsuarioXtipousuarioEdit3Controller', resolve: {auth: authentication3Promise}});
        //--
        $routeProvider.when('/usuario/3/xgrupo/plistx/:id/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'UsuarioXgrupoPList3Controller', resolve: {auth: authentication3Promise}});
        $routeProvider.when('/usuario/3/xgrupo/newx/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'UsuarioXgrupoNew3Controller', resolve: {auth: authentication3Promise}});
        $routeProvider.when('/usuario/3/xgrupo/editx/:id/:xid', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'UsuarioXgrupoEdit3Controller', resolve: {auth: authentication3Promise}});
        //--
        $routeProvider.when('/usuario/3/xcentro/plistx/:id/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'UsuarioXcentroPList3Controller', resolve: {auth: authentication3Promise}});
        $routeProvider.when('/usuario/3/xcentro/newx/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'UsuarioXcentroNew3Controller', resolve: {auth: authentication3Promise}});
        $routeProvider.when('/usuario/3/xcentro/editx/:id/:xid', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'UsuarioXcentroEdit3Controller', resolve: {auth: authentication3Promise}});
        //--
        $routeProvider.when('/usuario/3/xcentrosanitario/plistx/:id/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'UsuarioXcentrosanitarioPList3Controller', resolve: {auth: authentication3Promise}});
        $routeProvider.when('/usuario/3/xcentrosanitario/newx/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'UsuarioXcentrosanitarioNew3Controller', resolve: {auth: authentication3Promise}});
        $routeProvider.when('/usuario/3/xcentrosanitario/editx/:id/:xid', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'UsuarioXcentrosanitarioEdit3Controller', resolve: {auth: authentication3Promise}});        
        //--
        $routeProvider.when('/usuario/4/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'UsuarioView4Controller', resolve: {auth: authentication4Promise}});
        //--
        $routeProvider.when('/usuario/5/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'UsuarioView5Controller', resolve: {auth: authentication5Promise}});
        //--
        $routeProvider.when('/newalumno/9/:codigo', {templateUrl: 'js/app/usuario/9/newalumno.html', controller: 'UsuarioNewalumno9Controller', resolve: {auth: anyAuthenticationPromise}});
        //--
        //-- tipousuario
        //--
        $routeProvider.when('/tipousuario/1/plist/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'TipousuarioPList1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/tipousuario/1/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'TipousuarioView1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/tipousuario/1/new/:id?', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'TipousuarioNew1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/tipousuario/1/edit/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'TipousuarioEdit1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/tipousuario/1/remove/:id', {templateUrl: 'js/system/shared/app/remove.html', controller: 'TipousuarioRemove1Controller', resolve: {auth: authentication1Promise}});
        //--
        $routeProvider.when('/tipousuario/3/plist/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'TipousuarioPList3Controller', resolve: {auth: authentication3Promise}});
        $routeProvider.when('/tipousuario/3/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'TipousuarioView3Controller', resolve: {auth: authentication3Promise}});
        $routeProvider.when('/tipousuario/3/new/:id?', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'TipousuarioNew3Controller', resolve: {auth: authentication3Promise}});
        $routeProvider.when('/tipousuario/3/edit/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'TipousuarioEdit3Controller', resolve: {auth: authentication3Promise}});
        $routeProvider.when('/tipousuario/3/remove/:id', {templateUrl: 'js/system/shared/app/remove.html', controller: 'TipousuarioRemove3Controller', resolve: {auth: authentication3Promise}});
        //--
        $routeProvider.when('/tipousuario/4/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'TipousuarioView4Controller', resolve: {auth: authentication4Promise}});
        //--
        $routeProvider.when('/tipousuario/5/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'TipousuarioView5Controller', resolve: {auth: authentication5Promise}});
        //--
        //-- grupo
        //--
        $routeProvider.when('/grupo/1/plist/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'GrupoPList1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/grupo/1/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'GrupoView1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/grupo/1/new/:id?', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'GrupoNew1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/grupo/1/edit/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'GrupoEdit1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/grupo/1/remove/:id', {templateUrl: 'js/system/shared/app/remove.html', controller: 'GrupoRemove1Controller', resolve: {auth: authentication1Promise}});
        //--
        $routeProvider.when('/grupo/1/xcurso/plistx/:id/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'GrupoXcursoPList1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/grupo/1/xcurso/newx/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'GrupoXcursoNew1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/grupo/1/xcurso/editx/:id/:xid', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'GrupoXcursoEdit1Controller', resolve: {auth: authentication1Promise}});        
        //--
        $routeProvider.when('/grupo/1/xusuario/plistx/:id/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'GrupoXusuarioPList1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/grupo/1/xusuario/newx/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'GrupoXusuarioNew1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/grupo/1/xusuario/editx/:id/:xid', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'GrupoXusuarioEdit1Controller', resolve: {auth: authentication1Promise}});
        //--
        $routeProvider.when('/grupo/3/plist/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'GrupoPList3Controller', resolve: {auth: authentication3Promise}});
        $routeProvider.when('/grupo/3/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'GrupoView3Controller', resolve: {auth: authentication3Promise}});
        $routeProvider.when('/grupo/3/new/:id?', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'GrupoNew3Controller', resolve: {auth: authentication3Promise}});
        $routeProvider.when('/grupo/3/edit/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'GrupoEdit3Controller', resolve: {auth: authentication3Promise}});
        $routeProvider.when('/grupo/3/remove/:id', {templateUrl: 'js/system/shared/app/remove.html', controller: 'GrupoRemove3Controller', resolve: {auth: authentication3Promise}});
        //--
        $routeProvider.when('/grupo/3/xusuario/newx/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'GrupoxusuarioNew3Controller', resolve: {auth: authentication3Promise}});
        $routeProvider.when('/grupo/3/xusuario/editx/:id/:xid', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'GrupoxusuarioEdit3Controller', resolve: {auth: authentication3Promise}});
        $routeProvider.when('/grupo/3/xusuario/plistx/:id/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'GrupoxusuarioPList3Controller', resolve: {auth: authentication3Promise}});
        //--
        $routeProvider.when('/grupo/4/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'GrupoView4Controller', resolve: {auth: authentication4Promise}});
        //--
        $routeProvider.when('/grupo/5/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'GrupoView5Controller', resolve: {auth: authentication5Promise}});
        //--
        //--
        //-- curso
        //--
        $routeProvider.when('/curso/1/plist/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'CursoPList1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/curso/1/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'CursoView1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/curso/1/new/:id?', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'CursoNew1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/curso/1/edit/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'CursoEdit1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/curso/1/remove/:id', {templateUrl: 'js/system/shared/app/remove.html', controller: 'CursoRemove1Controller', resolve: {auth: authentication1Promise}});
        //--
        $routeProvider.when('/curso/3/plist/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'CursoPList3Controller', resolve: {auth: authentication3Promise}});
        $routeProvider.when('/curso/3/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'CursoView3Controller', resolve: {auth: authentication3Promise}});
        //--
        $routeProvider.when('/curso/4/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'CursoView4Controller', resolve: {auth: authentication4Promise}});
        //--
        $routeProvider.when('/curso/5/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'CursoView5Controller', resolve: {auth: authentication5Promise}});
        //--
        //-- centro
        //--
        $routeProvider.when('/centro/1/plist/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'CentroPList1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/centro/1/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'CentroView1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/centro/1/new/:id?', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'CentroNew1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/centro/1/edit/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'CentroEdit1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/centro/1/remove/:id', {templateUrl: 'js/system/shared/app/remove.html', controller: 'CentroRemove1Controller', resolve: {auth: authentication1Promise}});
        //-----------3
        $routeProvider.when('/centro/3/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'CentroView3Controller', resolve: {auth: authentication3Promise}});
        $routeProvider.when('/centro/3/plist/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'CentroPList3Controller', resolve: {auth: authentication3Promise}});
        //-----------4
        $routeProvider.when('/centro/4/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'CentroView4Controller', resolve: {auth: authentication4Promise}});
        //-----------5
        $routeProvider.when('/centro/5/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'CentroView5Controller', resolve: {auth: authentication5Promise}});
        //-- centrosanitario
        $routeProvider.when('/centrosanitario/1/plist/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'CentrosanitarioPList1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/centrosanitario/1/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'CentrosanitarioView1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/centrosanitario/1/new/:id?', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'CentrosanitarioNew1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/centrosanitario/1/edit/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'CentrosanitarioEdit1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/centrosanitario/1/remove/:id', {templateUrl: 'js/system/shared/app/remove.html', controller: 'CentrosanitarioRemove1Controller', resolve: {auth: authentication1Promise}});
        //-----------3
        $routeProvider.when('/centrosanitario/3/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'CentrosanitarioView3Controller', resolve: {auth: authentication3Promise}});
        //-----------4
        $routeProvider.when('/centrosanitario/4/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'CentrosanitarioView4Controller', resolve: {auth: authentication4Promise}});
        //-----------5
        $routeProvider.when('/centrosanitario/5/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'CentrosanitarioView5Controller', resolve: {auth: authentication5Promise}});
        //--
        //-- dependencia
        //--
        $routeProvider.when('/dependencia/1/plist/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'DependenciaPList1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/dependencia/1/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'DependenciaView1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/dependencia/1/new/:id?', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'DependenciaNew1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/dependencia/1/edit/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'DependenciaEdit1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/dependencia/1/remove/:id', {templateUrl: 'js/system/shared/app/remove.html', controller: 'DependenciaRemove1Controller', resolve: {auth: authentication1Promise}});
        //-- foreign key xtipodependencia
        $routeProvider.when('/dependencia/1/xtipodependencia/plistx/:id/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'DependenciaXtipodependenciaPList1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/dependencia/1/xtipodependencia/newx/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'DependenciaXtipodependenciaNew1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/dependencia/1/xtipodependencia/editx/:id/:xid', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'DependenciaXtipodependenciaEdit1Controller', resolve: {auth: authentication1Promise}});
        //-- foreign key xcentrosanitario
        $routeProvider.when('/dependencia/1/xcentrosanitario/plistx/:id/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'DependenciaxcentrosanitarioPList1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/dependencia/1/xcentrosanitario/newx/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'DependenciaxcentrosanitarioNew1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/dependencia/1/xcentrosanitario/editx/:id/:xid', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'DependenciaxcentrosanitarioEdit1Controller', resolve: {auth: authentication1Promise}});
        //-----------3
        $routeProvider.when('/dependencia/3/plist/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'DependenciaPList3Controller', resolve: {auth: authentication3Promise}});
        $routeProvider.when('/dependencia/3/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'DependenciaView3Controller', resolve: {auth: authentication3Promise}});
        $routeProvider.when('/dependencia/3/new/:id?', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'DependenciaNew3Controller', resolve: {auth: authentication3Promise}});
        $routeProvider.when('/dependencia/3/edit/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'DependenciaEdit3Controller', resolve: {auth: authentication3Promise}});
        $routeProvider.when('/dependencia/3/remove/:id', {templateUrl: 'js/system/shared/app/remove.html', controller: 'DependenciaRemove3Controller', resolve: {auth: authentication3Promise}});
        //-- foreign key xtipodependencia
        $routeProvider.when('/dependencia/3/xtipodependencia/plistx/:id/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'DependenciaxtipodependenciaPList3Controller', resolve: {auth: authentication3Promise}});
        $routeProvider.when('/dependencia/3/xtipodependencia/newx/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'DependenciaxtipodependenciaNew3Controller', resolve: {auth: authentication3Promise}});
        $routeProvider.when('/dependencia/3/xtipodependencia/editx/:id/:xid', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'DependenciaxtipodependenciaEdit3Controller', resolve: {auth: authentication3Promise}});
        //-- foreign key xcentrosanitario
        $routeProvider.when('/dependencia/3/xcentrosanitario/plistx/:id/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'DependenciaxcentrosanitarioPList3Controller', resolve: {auth: authentication3Promise}});
        $routeProvider.when('/dependencia/3/xcentrosanitario/newx/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'DependenciaxcentrosanitarioNew3Controller', resolve: {auth: authentication3Promise}});
        $routeProvider.when('/dependencia/3/xcentrosanitario/editx/:id/:xid', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'DependenciaxcentrosanitarioEdit3Controller', resolve: {auth: authentication3Promise}});
        //-----------4
        $routeProvider.when('/dependencia/4/plist/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'DependenciaPList4Controller', resolve: {auth: authentication4Promise}});
        $routeProvider.when('/dependencia/4/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'DependenciaView4Controller', resolve: {auth: authentication4Promise}});
        //-----------5
        $routeProvider.when('/dependencia/5/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'DependenciaView5Controller', resolve: {auth: authentication5Promise}});
        //--
        //-- tipodependencia
        //--
        $routeProvider.when('/tipodependencia/1/plist/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'TipodependenciaPList1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/tipodependencia/1/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'TipodependenciaView1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/tipodependencia/1/new/:id?', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'TipodependenciaNew1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/tipodependencia/1/edit/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'TipodependenciaEdit1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/tipodependencia/1/remove/:id', {templateUrl: 'js/system/shared/app/remove.html', controller: 'TipodependenciaRemove1Controller', resolve: {auth: authentication1Promise}});
        //-----------3
        $routeProvider.when('/tipodependencia/3/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'TipodependenciaView3Controller', resolve: {auth: authentication3Promise}});
        //-----------4
        $routeProvider.when('/tipodependencia/4/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'TipodependenciaView4Controller', resolve: {auth: authentication4Promise}});
        //-----------5
        $routeProvider.when('/tipodependencia/5/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'TipodependenciaView5Controller', resolve: {auth: authentication5Promise}});
        //--
        //-- medico
        //--
        $routeProvider.when('/medico/1/plist/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'MedicoPList1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/medico/1/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'MedicoView1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/medico/1/new/:id?', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'MedicoNew1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/medico/1/edit/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'MedicoEdit1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/medico/1/remove/:id', {templateUrl: 'js/system/shared/app/remove.html', controller: 'MedicoRemove1Controller', resolve: {auth: authentication1Promise}});
        //--
        $routeProvider.when('/medico/1/xespecialidad/newx/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'MedicoXespecialidadNew1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/medico/1/xespecialidad/editx/:id/:xid', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'MedicoXespecialidadEdit1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/medico/1/xespecialidad/plistx/:id/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'MedicoXespecialidadPList1Controller', resolve: {auth: authentication1Promise}});
        //--
        $routeProvider.when('/medico/1/xservicio/newx/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'MedicoXservicioNew1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/medico/1/xservicio/editx/:id/:xid', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'MedicoXservicioEdit1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/medico/1/xservicio/plistx/:id/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'MedicoXservicioPList1Controller', resolve: {auth: authentication1Promise}});
        //--
        $routeProvider.when('/medico/1/xcentrosanitario/newx/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'MedicoXcentrosanitarioNew1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/medico/1/xcentrosanitario/editx/:id/:xid', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'MedicoXcentrosanitarioEdit1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/medico/1/xcentrosanitario/plistx/:id/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'MedicoXcentrosanitarioPList1Controller', resolve: {auth: authentication1Promise}});
        //--
        $routeProvider.when('/medico/1/xcategoriaprofesional/plistx/:id/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'MedicoXcategoriaprofesionalPList1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/medico/1/xcategoriaprofesional/newx/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'MedicoXcategoriaprofesionalNew1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/medico/1/xcategoriaprofesional/editx/:id/:xid', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'MedicoXcategoriaprofesionalEdit1Controller', resolve: {auth: authentication1Promise}});
        //-----------3
        $routeProvider.when('/medico/3/plist/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'MedicoPList3Controller', resolve: {auth: authentication3Promise}});
        $routeProvider.when('/medico/3/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'MedicoView3Controller', resolve: {auth: authentication3Promise}});
        $routeProvider.when('/medico/3/edit/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'MedicoEdit3Controller', resolve: {auth: authentication3Promise}});
        $routeProvider.when('/medico/3/remove/:id', {templateUrl: 'js/system/shared/app/remove.html', controller: 'MedicoRemove3Controller', resolve: {auth: authentication3Promise}});
        $routeProvider.when('/medico/3/new/:id?', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'MedicoNew3Controller', resolve: {auth: authentication3Promise}});
        //-----------5
        $routeProvider.when('/medico/5/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'MedicoView5Controller', resolve: {auth: authentication5Promise}});
        //--
        //-- servicio
        //--
        $routeProvider.when('/servicio/1/plist/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'ServicioPList1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/servicio/1/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'ServicioView1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/servicio/1/new/:id?', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'ServicioNew1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/servicio/1/edit/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'ServicioEdit1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/servicio/1/remove/:id', {templateUrl: 'js/system/shared/app/remove.html', controller: 'ServicioRemove1Controller', resolve: {auth: authentication1Promise}});
        //--
        $routeProvider.when('/servicio/1/xtiposervicio/plistx/:id/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'ServicioXtiposervicioPList1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/servicio/1/xtiposervicio/newx/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'ServicioXtiposervicioNew1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/servicio/1/xtiposervicio/editx/:id/:xid', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'ServicioXtiposervicioEdit1Controller', resolve: {auth: authentication1Promise}});
        //----Servicio 3 profesor --
        $routeProvider.when('/servicio/3/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'ServicioView3Controller', resolve: {auth: authentication3Promise}});
        //----Servicio 4 profesor --
        $routeProvider.when('/servicio/4/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'ServicioView4Controller', resolve: {auth: authentication4Promise}});
        //----Servicio 5 visitante --
        $routeProvider.when('/servicio/5/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'ServicioView5Controller', resolve: {auth: authentication5Promise}});
        //--
        //-- tiposervicio
        //--
        $routeProvider.when('/tiposervicio/1/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'TiposervicioView1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/tiposervicio/1/plist/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'TiposervicioPlist1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/tiposervicio/1/new/:id?', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'TiposervicioNew1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/tiposervicio/1/edit/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'TiposervicioEdit1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/tiposervicio/1/remove/:id', {templateUrl: 'js/system/shared/app/remove.html', controller: 'TiposervicioRemove1Controller', resolve: {auth: authentication1Promise}});
        //----------
        $routeProvider.when('/tiposervicio/3/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'TiposervicioView3Controller', resolve: {auth: authentication3Promise}});
        //-----------
        $routeProvider.when('/tiposervicio/4/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'TiposervicioView4Controller', resolve: {auth: authentication4Promise}});
        //-----------
        $routeProvider.when('/tiposervicio/5/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'TiposervicioView5Controller', resolve: {auth: authentication5Promise}});
        //--
        //-- especialidad
        //--
        $routeProvider.when('/especialidad/1/plist/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'EspecialidadPList1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/especialidad/1/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'EspecialidadView1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/especialidad/1/new/:id?', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'EspecialidadNew1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/especialidad/1/edit/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'EspecialidadEdit1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/especialidad/1/remove/:id', {templateUrl: 'js/system/shared/app/remove.html', controller: 'EspecialidadRemove1Controller', resolve: {auth: authentication1Promise}});
        //-----------3
        $routeProvider.when('/especialidad/3/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'EspecialidadView3Controller', resolve: {auth: authentication3Promise}});
        //-----------4
        $routeProvider.when('/especialidad/4/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'EspecialidadView4Controller', resolve: {auth: authentication4Promise}});
        //-----------5
        $routeProvider.when('/especialidad/5/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'EspecialidadView5Controller', resolve: {auth: authentication5Promise}});
        //--
        //-- categoriaprofesional
        //--
        $routeProvider.when('/categoriaprofesional/1/plist/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'CategoriaprofesionalPList1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/categoriaprofesional/1/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'CategoriaprofesionalView1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/categoriaprofesional/1/new/:id?', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'CategoriaprofesionalNew1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/categoriaprofesional/1/edit/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'CategoriaprofesionalEdit1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/categoriaprofesional/1/remove/:id', {templateUrl: 'js/system/shared/app/remove.html', controller: 'CategoriaprofesionalRemove1Controller', resolve: {auth: authentication1Promise}});
        //-----------3
        $routeProvider.when('/categoriaprofesional/3/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'CategoriaprofesionalView3Controller', resolve: {auth: authentication3Promise}});
        //-----------4
        $routeProvider.when('/categoriaprofesional/4/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'CategoriaprofesionalView4Controller', resolve: {auth: authentication4Promise}});
        //-----------5
        $routeProvider.when('/categoriaprofesional/5/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'CategoriaprofesionalView5Controller', resolve: {auth: authentication5Promise}});
        //--
        //-- paciente
        //--
        $routeProvider.when('/paciente/1/plist/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'PacientePList1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/paciente/1/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'PacienteView1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/paciente/1/new/:id?', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'PacienteNew1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/paciente/1/edit/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'PacienteEdit1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/paciente/1/remove/:id', {templateUrl: 'js/system/shared/app/remove.html', controller: 'PacienteRemove1Controller', resolve: {auth: authentication1Promise}});
        //--
        $routeProvider.when('/paciente/1/xtipopago/plistx/:id/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'PacienteXtipopagoPList1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/paciente/1/xtipopago/newx/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'PacienteXtipopagoNew1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/paciente/1/xtipopago/editx/:id/:xid', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'PacienteXtipopagoEdit1Controller', resolve: {auth: authentication1Promise}});
        //--
        $routeProvider.when('/paciente/1/xsexo/plistx/:id/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'PacienteXsexoPList1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/paciente/1/xsexo/newx/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'PacienteXsexoNew1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/paciente/1/xsexo/editx/:id/:xid', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'PacienteXsexoEdit1Controller', resolve: {auth: authentication1Promise}});
        //--
        $routeProvider.when('/paciente/1/xusuario/plistx/:id/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'PacienteXusuarioPList1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/paciente/1/xusuario/newx/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'PacienteXusuarioNew1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/paciente/1/xusuario/editx/:id/:xid', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'PacienteXusuarioEdit1Controller', resolve: {auth: authentication1Promise}});
        //-----------paciente 3
        $routeProvider.when('/paciente/3/plist/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'PacientePList3Controller', resolve: {auth: authentication3Promise}});
        $routeProvider.when('/paciente/3/new/:id?', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'PacienteNew3Controller', resolve: {auth: authentication3Promise}});
        $routeProvider.when('/paciente/3/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'PacienteView3Controller', resolve: {auth: authentication3Promise}});
        $routeProvider.when('/paciente/3/edit/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'PacienteEdit3Controller', resolve: {auth: authentication3Promise}});
        $routeProvider.when('/paciente/3/remove/:id', {templateUrl: 'js/system/shared/app/remove.html', controller: 'PacienteRemove3Controller', resolve: {auth: authentication3Promise}});
        //--
        $routeProvider.when('/paciente/3/xusuario/plistx/:id/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'PacienteXusuarioPList3Controller', resolve: {auth: authentication3Promise}});
        $routeProvider.when('/paciente/3/xusuario/newx/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'PacienteXusuarioNew3Controller', resolve: {auth: authentication3Promise}});
        $routeProvider.when('/paciente/3/xusuario/editx/:id/:xid', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'PacienteXusuarioEdit3Controller', resolve: {auth: authentication3Promise}});
        //-----------paciente 4
        $routeProvider.when('/paciente/4/plist/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'PacientePList4Controller', resolve: {auth: authentication4Promise}});
        $routeProvider.when('/paciente/4/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'PacienteView4Controller', resolve: {auth: authentication4Promise}});
        $routeProvider.when('/paciente/4/new/:id?', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'PacienteNew4Controller', resolve: {auth: authentication4Promise}});
        $routeProvider.when('/paciente/4/edit/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'PacienteEdit4Controller', resolve: {auth: authentication4Promise}});
        //--
        $routeProvider.when('/paciente/4/xusuario/plistx/:id/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'PacientexusuarioList4Controller', resolve: {auth: authentication4Promise}});
        $routeProvider.when('/paciente/4/xusuario/newx/:id?', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'PacienteNew4Controller', resolve: {auth: authentication4Promise}});
        //--
        $routeProvider.when('/paciente/4/xsexo/plistx/:id/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'PacientexsexoPList4Controller', resolve: {auth: authentication4Promise}});
        $routeProvider.when('/paciente/4/xsexo/newx/:id?', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'PacientexsexoNew4Controller', resolve: {auth: authentication4Promise}});
        //--
        $routeProvider.when('/paciente/4/xtipopago/plistx/:id/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'PacientextipopagoPList4Controller', resolve: {auth: authentication4Promise}});
        $routeProvider.when('/paciente/4/xtipopago/newx/:id?', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'PacientextipopagoNew4Controller', resolve: {auth: authentication4Promise}});
        //-----------paciente 5
        $routeProvider.when('/paciente/5/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'PacienteView5Controller', resolve: {auth: authentication5Promise}});
        $routeProvider.when('/paciente/5/plist/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'PacientePList5Controller', resolve: {auth: authentication5Promise}});
        //--
        $routeProvider.when('/paciente/5/xusuario/plistx/:id/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'PacientexusuarioList5Controller', resolve: {auth: authentication5Promise}});
        //--
        //-- episodio
        //--
        $routeProvider.when('/episodio/1/plist/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'EpisodioPList1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/episodio/1/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'EpisodioView1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/episodio/1/new/:id?', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'EpisodioNew1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/episodio/1/edit/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'EpisodioEdit1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/episodio/1/remove/:id', {templateUrl: 'js/system/shared/app/remove.html', controller: 'EpisodioRemove1Controller', resolve: {auth: authentication1Promise}});
        //-- foreign key xcircunstanciasalta
        $routeProvider.when('/episodio/1/xcircunstanciasalta/plistx/:id/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'EpisodioXcircunstanciasaltaPList1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/episodio/1/xcircunstanciasalta/newx/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'EpisodioXcircunstanciasaltaNew1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/episodio/1/xcircunstanciasalta/editx/:id/:xid', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'EpisodioXcircunstanciasaltaEdit1Controller', resolve: {auth: authentication1Promise}});
        //-- foreign key xservicio
        $routeProvider.when('/episodio/1/xservicio/plistx/:id/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'EpisodioXservicioPList1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/episodio/1/xservicio/newx/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'EpisodioXservicioNew1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/episodio/1/xservicio/editx/:id/:xid', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'EpisodioXservicioEdit1Controller', resolve: {auth: authentication1Promise}});
        //-- foreign key xpaciente
        $routeProvider.when('/episodio/1/xpaciente/plistx/:id/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'EpisodioxpacientePList1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/episodio/1/xpaciente/newx/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'EpisodioxpacienteNew1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/episodio/1/xpaciente/editx/:id/:xid', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'EpisodioxpacienteEdit1Controller', resolve: {auth: authentication1Promise}});
        //-- foreign key xfactura
        $routeProvider.when('/episodio/1/xfactura/plistx/:id/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'EpisodioXfacturaPList1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/episodio/1/xfactura/newx/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'EpisodioXfacturaNew1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/episodio/1/xfactura/editx/:id/:xid', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'EpisodioXfacturaEdit1Controller', resolve: {auth: authentication1Promise}});
        //-- foreign key xdependencia
        $routeProvider.when('/episodio/1/xdependencia/plistx/:id/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'EpisodioXdependenciaPList1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/episodio/1/xdependencia/newx/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'EpisodioXdependenciaNew1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/episodio/1/xdependencia/editx/:id/:xid', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'EpisodioXdependenciaEdit1Controller', resolve: {auth: authentication1Promise}});
        //-- foreign key xmedico
        $routeProvider.when('/episodio/1/xmedico/plistx/:id/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'EpisodioXmedicoPList1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/episodio/1/xmedico/newx/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'EpisodioXmedicoNew1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/episodio/1/xmedico/editx/:id/:xid', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'EpisodioXmedicoEdit1Controller', resolve: {auth: authentication1Promise}});
        //-- foreign key xtipoepisodio
        $routeProvider.when('/episodio/1/xtipoepisodio/plistx/:id/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'EpisodioXtipoepisodioPList1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/episodio/1/xtipoepisodio/newx/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'EpisodioXtipoepisodioNew1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/episodio/1/xtipoepisodio/editx/:id/:xid', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'EpisodioXtipoepisodioEdit1Controller', resolve: {auth: authentication1Promise}});
        //-- foreign key xdestinoalta
        $routeProvider.when('/episodio/1/xdestinoalta/plistx/:id/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'EpisodioXdestinoaltaPList1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/episodio/1/xdestinoalta/newx/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'EpisodioXdestinoaltaNew1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/episodio/1/xdestinoalta/editx/:id/:xid', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'EpisodioXdestinoaltaEdit1Controller', resolve: {auth: authentication1Promise}});
        //-- foreign key xmodalidadepisodio
        $routeProvider.when('/episodio/1/xmodalidadepisodio/newx/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'EpisodioXmodalidadepisodioNew1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/episodio/1/xmodalidadepisodio/editx/:id/:xid', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'EpisodioXmodalidadepisodioEdit1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/episodio/1/xmodalidadepisodio/plistx/:id/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'EpisodioXmodalidadepisodioPList1Controller', resolve: {auth: authentication1Promise}});
        //-- foreign key xusuario
        $routeProvider.when('/episodio/1/xusuario/plistx/:id/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'EpisodioxusuarioPList1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/episodio/1/xusuario/newx/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'EpisodioxusuarioNew1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/episodio/1/xusuario/editx/:id/:xid', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'EpisodioxusuarioEdit1Controller', resolve: {auth: authentication1Promise}});
        //----Episodio 3 profesor --
        $routeProvider.when('/episodio/3/plist/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'EpisodioPList3Controller', resolve: {auth: authentication3Promise}});
        $routeProvider.when('/episodio/3/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'EpisodioView3Controller', resolve: {auth: authentication3Promise}});
        $routeProvider.when('/episodio/3/new/:id?', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'EpisodioNew3Controller', resolve: {auth: authentication3Promise}});
        $routeProvider.when('/episodio/3/edit/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'EpisodioEdit3Controller', resolve: {auth: authentication3Promise}});
        $routeProvider.when('/episodio/3/remove/:id', {templateUrl: 'js/system/shared/app/remove.html', controller: 'EpisodioRemove3Controller', resolve: {auth: authentication3Promise}});
        //-- foreign key xcircunstanciasalta
        $routeProvider.when('/episodio/3/xcircunstanciasalta/plistx/:id/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'EpisodioxcircunstanciasaltaPList3Controller', resolve: {auth: authentication3Promise}});
        //-- foreign key xpaciente
        $routeProvider.when('/episodio/3/xpaciente/plistx/:id/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'EpisodioxpacientePList3Controller', resolve: {auth: authentication3Promise}});
        $routeProvider.when('/episodio/3/xpaciente/newx/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'EpisodioxpacienteNew3Controller', resolve: {auth: authentication3Promise}});
        $routeProvider.when('/episodio/3/xpaciente/editx/:id/:xid', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'EpisodioxpacienteEdit3Controller', resolve: {auth: authentication3Promise}});
        //-- foreign key xepisodio
        $routeProvider.when('/episodio/3/xepisodio/plistx/:id/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'EpisodioxepisodioPList3Controller', resolve: {auth: authentication3Promise}});
        $routeProvider.when('/episodio/3/xepisodio/newx/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'EpisodioxepisodioNew3Controller', resolve: {auth: authentication3Promise}});
        $routeProvider.when('/episodio/3/xepisodio/editx/:id/:xid', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'EpisodioxepisodioEdit3Controller', resolve: {auth: authentication3Promise}});
        //-- foreign key xepisodio
        $routeProvider.when('/episodio/3/xpaciente/xepisodio/newx/:idpaciente/:idepisodiopadre', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'SubepisodioxpacientexepisodioNew3Controller', resolve: {auth: authentication3Promise}});
        //----Episodio 4 alumno --
        $routeProvider.when('/episodio/4/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'EpisodioView4Controller', resolve: {auth: authentication4Promise}});
        $routeProvider.when('/episodio/4/new/:id?', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'EpisodioNew4Controller', resolve: {auth: authentication4Promise}});
        $routeProvider.when('/episodio/4/edit/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'EpisodioEdit4Controller', resolve: {auth: authentication4Promise}});
        $routeProvider.when('/episodio/4/remove/:id', {templateUrl: 'js/system/shared/app/remove.html', controller: 'EpisodioRemove4Controller', resolve: {auth: authentication4Promise}});
        //-- foreign key xcircunstanciasalta
        $routeProvider.when('/episodio/4/xcircunstanciasalta/plistx/:id/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'EpisodioxcircunstanciasaltaPList4Controller', resolve: {auth: authentication4Promise}});
        //-- foreign key xpaciente
        $routeProvider.when('/episodio/4/xpaciente/plistx/:id/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'EpisodioxpacientePList4Controller', resolve: {auth: authentication4Promise}});
        $routeProvider.when('/episodio/4/xpaciente/newx/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'EpisodioxpacienteNew4Controller', resolve: {auth: authentication4Promise}});
        $routeProvider.when('/episodio/4/xpaciente/editx/:id/:xid', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'EpisodioxpacienteEdit4Controller', resolve: {auth: authentication4Promise}});
        //-- foreign key xepisodio
        $routeProvider.when('/episodio/4/xpaciente/xepisodio/newx/:idpaciente/:idepisodiopadre', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'SubepisodioxpacientexepisodioNew4Controller', resolve: {auth: authentication4Promise}});
        //-- foreign key xepisodio
        $routeProvider.when('/episodio/4/xepisodio/plistx/:id/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'EpisodioxepisodioPList4Controller', resolve: {auth: authentication4Promise}});
        $routeProvider.when('/episodio/4/xepisodio/newx/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'EpisodioxepisodioNew4Controller', resolve: {auth: authentication4Promise}});
        $routeProvider.when('/episodio/4/xepisodio/editx/:id/:xid', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'EpisodioxepisodioEdit4Controller', resolve: {auth: authentication4Promise}});
        //----Episodio 5 visitante --
        $routeProvider.when('/episodio/5/xcircunstanciasalta/plistx/:id/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'EpisodioxcircunstanciasaltaPList5Controller', resolve: {auth: authentication5Promise}});
        $routeProvider.when('/episodio/5/xepisodio/plistx/:id/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'EpisodioxepisodioPList5Controller', resolve: {auth: authentication5Promise}});
        //--
        //-- subepisodio
        //--
        //-- Subepisodio 1
        $routeProvider.when('/subepisodio/1/xepisodio/plistx/:id/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'SubepisodioXepisodioPList1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/subepisodio/1/xepisodio/newx/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'SubepisodioXepisodioNew1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/subepisodio/1/xepisodio/editx/:id/:xid', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'SubepisodioXepisodioEdit1Controller', resolve: {auth: authentication1Promise}});
        //-- Subepisodio 3
        $routeProvider.when('/subepisodio/3/xepisodio/plistx/:id/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'SubepisodioXepisodioPList3Controller', resolve: {auth: authentication3Promise}});
        $routeProvider.when('/subepisodio/3/xepisodio/newx/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'SubepisodioXepisodioNew3Controller', resolve: {auth: authentication3Promise}});
        //-- Subepisodio 4
        $routeProvider.when('/subepisodio/4/xepisodio/plistx/:id/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'SubepisodioXepisodioPList4Controller', resolve: {auth: authentication4Promise}});
        $routeProvider.when('/subepisodio/4/xepisodio/newx/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'SubepisodioXepisodioNew4Controller', resolve: {auth: authentication4Promise}});
        //-- Subepisodio 5
        $routeProvider.when('/subepisodio/5/xepisodio/plistx/:id/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'SubepisodioXepisodioPList5Controller', resolve: {auth: authentication5Promise}});
        //--
        //-- sexo
        //--
        $routeProvider.when('/sexo/1/plist/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'SexoPList1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/sexo/1/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'SexoView1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/sexo/1/new/:id?', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'SexoNew1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/sexo/1/edit/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'SexoEdit1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/sexo/1/remove/:id', {templateUrl: 'js/system/shared/app/remove.html', controller: 'SexoRemove1Controller', resolve: {auth: authentication1Promise}});
        //--
        $routeProvider.when('/sexo/2/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'SexoView2Controller', resolve: {auth: authentication2Promise}});
        //--
        $routeProvider.when('/sexo/3/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'SexoView3Controller', resolve: {auth: authentication3Promise}});
        //--
        $routeProvider.when('/sexo/4/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'SexoView4Controller', resolve: {auth: authentication4Promise}});
        //--
        $routeProvider.when('/sexo/5/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'SexoView5Controller', resolve: {auth: authentication5Promise}});
        //--
        //-- destinoalta
        //--
        $routeProvider.when('/destinoalta/1/plist/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'DestinoaltaPlist1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/destinoalta/1/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'DestinoaltaView1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/destinoalta/1/new/:id?', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'DestinoaltaNew1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/destinoalta/1/edit/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'DestinoaltaEdit1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/destinoalta/1/remove/:id', {templateUrl: 'js/system/shared/app/remove.html', controller: 'DestinoaltaRemove1Controller', resolve: {auth: authentication1Promise}});
        //-----------
        $routeProvider.when('/destinoalta/3/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'DestinoaltaView3Controller', resolve: {auth: authentication3Promise}});
        //-----------
        $routeProvider.when('/destinoalta/4/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'DestinoaltaView4Controller', resolve: {auth: authentication4Promise}});
        //-----------
        $routeProvider.when('/destinoalta/5/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'DestinoaltaView5Controller', resolve: {auth: authentication5Promise}});
        //--
        //-- modalidadepisodio
        //--
        $routeProvider.when('/modalidadepisodio/1/plist/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'ModalidadepisodioPList1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/modalidadepisodio/1/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'ModalidadepisodioView1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/modalidadepisodio/1/new/:id?', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'ModalidadepisodioNew1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/modalidadepisodio/1/edit/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'ModalidadepisodioEdit1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/modalidadepisodio/1/remove/:id', {templateUrl: 'js/system/shared/app/remove.html', controller: 'ModalidadepisodioRemove1Controller', resolve: {auth: authentication1Promise}});
        //-----------
        $routeProvider.when('/modalidadepisodio/3/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'ModalidadepisodioView3Controller', resolve: {auth: authentication3Promise}});
        //-----------
        $routeProvider.when('/modalidadepisodio/4/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'ModalidadepisodioView4Controller', resolve: {auth: authentication4Promise}});
        //-----------
        $routeProvider.when('/modalidadepisodio/5/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'ModalidadepisodioView5Controller', resolve: {auth: authentication5Promise}});
        //--
        //-- circunstanciasalta
        //--
        $routeProvider.when('/circunstanciasalta/1/plist/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'CircunstanciasaltaPList1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/circunstanciasalta/1/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'CircunstanciasaltaView1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/circunstanciasalta/1/new/:id?', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'CircunstanciasaltaNew1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/circunstanciasalta/1/edit/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'CircunstanciasaltaEdit1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/circunstanciasalta/1/remove/:id', {templateUrl: 'js/system/shared/app/remove.html', controller: 'CircunstanciasaltaRemove1Controller', resolve: {auth: authentication1Promise}});
        //----Circunstanciasalta 3 profesor --
        $routeProvider.when('/circunstanciasalta/3/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'CircunstanciasaltaView3Controller', resolve: {auth: authentication3Promise}});
        //----Circunstanciasalta 4 alumno --
        $routeProvider.when('/circunstanciasalta/4/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'CircunstanciasaltaView4Controller', resolve: {auth: authentication4Promise}});
        //----Circunstanciasalta 5 visitante --
        $routeProvider.when('/circunstanciasalta/5/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'CircunstanciasaltaView5Controller', resolve: {auth: authentication5Promise}});
        //--
        //-- tipoepisodio
        //--
        $routeProvider.when('/tipoepisodio/1/plist/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'TipoepisodioPList1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/tipoepisodio/1/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'TipoepisodioView1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/tipoepisodio/1/edit/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'TipoepisodioEdit1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/tipoepisodio/1/new/:id?', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'TipoepisodioNew1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/tipoepisodio/1/remove/:id', {templateUrl: 'js/system/shared/app/remove.html', controller: 'TipoepisodioRemove1Controller', resolve: {auth: authentication1Promise}});
        //--
        $routeProvider.when('/tipoepisodio/3/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'TipoepisodioView3Controller', resolve: {auth: authentication3Promise}});
        //--
        $routeProvider.when('/tipoepisodio/4/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'TipoepisodioView4Controller', resolve: {auth: authentication4Promise}});
        //--
        $routeProvider.when('/tipoepisodio/5/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'TipoepisodioView5Controller', resolve: {auth: authentication5Promise}});
        //--
        //-- tipopago
        //--
        $routeProvider.when('/tipopago/1/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'TipopagoView1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/tipopago/1/plist/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'TipopagoPList1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/tipopago/1/new/:id?', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'TipopagoNew1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/tipopago/1/edit/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'TipopagoEdit1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/tipopago/1/remove/:id', {templateUrl: 'js/system/shared/app/remove.html', controller: 'TipopagoRemove1Controller', resolve: {auth: authentication1Promise}});
        //-----------
        $routeProvider.when('/tipopago/3/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'TipopagoView3Controller', resolve: {auth: authentication3Promise}});
        //-----------
        $routeProvider.when('/tipopago/4/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'TipopagoView4Controller', resolve: {auth: authentication4Promise}});
        //-----------
        $routeProvider.when('/tipopago/5/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'TipopagoView5Controller', resolve: {auth: authentication5Promise}});
        //--
        //-- factura
        //--
        $routeProvider.when('/factura/1/plist/:page?/:rpp?', {templateUrl: 'js/system/shared/app/plist.html', controller: 'FacturaPList1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/factura/1/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'FacturaView1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/factura/3/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'FacturaView3Controller', resolve: {auth: authentication3Promise}});
        $routeProvider.when('/factura/4/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'FacturaView4Controller', resolve: {auth: authentication4Promise}});
        $routeProvider.when('/factura/5/view/:id', {templateUrl: 'js/system/shared/app/view.html', controller: 'FacturaView5Controller', resolve: {auth: authentication5Promise}});
        $routeProvider.when('/factura/1/new/:id?', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'FacturaNew1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/factura/1/edit/:id', {templateUrl: 'js/system/shared/app/newedit.html', controller: 'FacturaEdit1Controller', resolve: {auth: authentication1Promise}});
        $routeProvider.when('/factura/1/remove/:id', {templateUrl: 'js/system/shared/app/remove.html', controller: 'FacturaRemove1Controller', resolve: {auth: authentication1Promise}});
        //--
        //--
        //--
        //--
        $routeProvider.otherwise({redirectTo: '/'});
    }]);
