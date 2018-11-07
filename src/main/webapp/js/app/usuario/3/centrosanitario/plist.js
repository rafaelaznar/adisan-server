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

'use strict';
moduloUsuario.controller('UsuarioXcentrosanitarioPList3Controller',
        ['$scope', '$routeParams', '$location', 'serverCallService', 'toolService', 'constantService',
            function ($scope, $routeParams, $location, serverCallService, toolService, constantService) {
                $scope.ob = "usuario";
                $scope.op = "plist";
                $scope.profile = 3;
                //----
                $scope.xob = "centrosanitario";
                $scope.xid = $routeParams.id;
                //----
                $scope.url = $scope.ob + '/' + $scope.profile + '/' + $scope.op + $scope.xob + '/' + $scope.xid;
                //----
                $scope.numpage = toolService.checkDefault(1, $routeParams.page);
                $scope.rpp = toolService.checkDefault(10, $routeParams.rpp);
                $scope.neighbourhood = constantService.getGlobalNeighbourhood();
                //---
                $scope.orderParams = toolService.checkEmptyString($routeParams.order);
                $scope.filterParams = toolService.checkEmptyString($routeParams.filter);
                //---
                $scope.status = null;
                $scope.debugging = constantService.debugging();
                //---
                function getDataFromServer() {
                    if ($scope.xob && $scope.xid) {
                        $scope.linkedbean = null;
                        serverCallService.getOne($scope.xob, $scope.xid).then(function (response) {
                            if (response.status == 200) {
                                if (response.data.status == 200) {
                                    $scope.linkedbean = response.data.json;
                                    $scope.breadcrumbs = toolService.renderLinkHtml($scope.linkedbean, $scope.profile);
                                }
                            }
                        }).catch(function (data) {
                        });
                    }
                    ;
                    serverCallService.getCountX($scope.ob, $scope.xob, $scope.xid, $scope.filterParams).then(function (response) {
                        if (response.status == 200) {
                            $scope.registers = response.data.json;
                            $scope.pages = toolService.calculatePages($scope.rpp, $scope.registers);
                            if ($scope.numpage > $scope.pages) {
                                $scope.numpage = $scope.pages;
                            }
                            return serverCallService.getPageX($scope.ob, $scope.xob, $scope.xid, $scope.rpp, $scope.numpage, $scope.filterParams, $routeParams.order);
                        } else {
                            $scope.status = "Error en la recepción de datos del servidor";
                        }
                    }).then(function (response) {
                        if (response.status == 200) {
                            $scope.page = response.data.json.data;
                            $scope.metao = response.data.json.metaObject;
                            $scope.metap = response.data.json.metaProperties;
                            toolService.hideField($scope.metap, "obj_" + $scope.xob);
                        } else {
                            $scope.status = "Error en la recepción de datos del servidor";
                        }
                    }).catch(function (data) {
                        $scope.status = "Error en la recepción de datos del servidor";
                    });
                }
                //---
                $scope.doorder = function (orderField, ascDesc) {
                    $location.url($scope.url + '/' + $scope.numpage + '/' + $scope.rpp).search('filter', $scope.filterParams).search('order', orderField + ',' + ascDesc);
                    return false;
                };
                $scope.back = function () {
                    window.history.back();
                };
                $scope.close = function () {
                    $location.path('/home');
                };
                //--------------------------------------------------------------
                $scope.showViewButton = function () {
                    return true;
                }
                $scope.showNewButton = function () {
                    return true;
                }
                $scope.showEditButton = function (oBean) {
                    return oBean.canUpdate;
                }
                $scope.showRemoveButton = function (oBean) {
                    return oBean.canDelete;
                }
                $scope.goViewURL = function (oBean) {
                    $location.path($scope.ob + "/" + $scope.profile + "/view/" + oBean.id);
                }
                $scope.goNewURL = function () {
                    $location.path($scope.ob + "/" + $scope.profile + "/" + $scope.xob + "/new/" + $scope.xid);
                }
                $scope.goEditURL = function (oBean) {
                    $location.path($scope.ob + "/" + $scope.profile + "/" + $scope.xob + "/edit/" + oBean.id + "/" + $scope.xid);
                }
                $scope.goRemoveURL = function (oBean) {
                    $location.path($scope.ob + "/" + $scope.profile + "/remove/" + oBean.id);
                }
                //--------------------------------------------------------------
                $scope.showOtherButton = function (oBean) {
                    return true;
                }
                $scope.includeExtraButtons = function () {
                    return "js/app/usuario/plistExtraButtons.html"
                }
                $scope.showActivateButton = function (oBean) {
                    if (oBean.activo == 1) {
                        return false
                    } else {

                        return true;
                    }
                }
                $scope.showDeactivateButton = function (oBean) {
                    if (oBean.activo == 1) {
                        return true
                    } else {

                        return false;
                    }
                }
                //----                
                //----------
                $scope.activate = function (oBean) {
                    serverCallService.activate(oBean.id).then(function (response) {
                        if (response.status == 200) {
                            if (response.data.status == 200) {
                                getDataFromServer();
                            }
                        }
                    }).catch(function (data) {
                    });
                }
                $scope.deactivate = function (oBean) {
                    serverCallService.deactivate(oBean.id).then(function (response) {
                        if (response.status == 200) {
                            if (response.data.status == 200) {
                                getDataFromServer();
                            }
                        }
                    }).catch(function (data) {
                    });

                }               
                //--------------------------------------------------------------
                $scope.showResetPass = function (oBean) {
                    return true;
                }
                $scope.resetPass = function (oBean) {
                    $scope.modalMessage = "¿Estás seguro que quieres resetear el password?";
                    $scope.modalYesno = true;
                    $scope.methodYes = 'resetarPass';
                    $scope.params = oBean;
                    $('#myModal').modal({
                        keyboard: true
                    })
                }
                $scope.resetarPass = function (oBean) {
                    $('#myModal').modal('hide');
                    serverCallService.resetPass(oBean.id).then(function (response) {
                        if (response.status == 200) {
                            if (response.data.status == 200) {
                                $scope.modalMessage = "Password reseteado";
                                $scope.modalYesno = false;
                                $('#myModal').modal({
                                    keyboard: true
                                })
                                //getDataFromServer();
                            }
                        }
                    }).catch(function (data) {
                    });
                }
                //--------------------------------------------------------------
                getDataFromServer();
            }
        ]);

