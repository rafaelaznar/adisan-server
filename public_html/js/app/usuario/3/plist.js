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
moduloUsuario.controller('UsuarioPList3Controller',
        ['$scope', '$routeParams', '$http', '$location', 'serverCallService', 'toolService', 'constantService', 'sessionService',
            function ($scope, $routeParams, $http, $location, serverCallService, toolService, constantService, sessionService) {
                $scope.ob = "usuario";
                $scope.op = "plist";
                $scope.profile = 3;
                //---
                $scope.url = $scope.ob + '/' + $scope.profile + '/' + $scope.op;
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
                $scope.idseve = false;
                $scope.iduser = 0;
                $scope.veredit = true;

                function getDataFromServer() {
                    //error gordo: esta llamada jamas se debe hacer ya que está prgramada en sessionService
//                    serverCallService.getSession("usuario").then(function (response) {
//                        if (response.status == 200) {
//                            $scope.iduser = response.data.json.data.id;
//                        }
//                    });
                    serverCallService.getCount($scope.ob, $scope.filterParams).then(function (response) {
                        if (response.status == 200) {
                            $scope.registers = response.data.json;
                            $scope.pages = toolService.calculatePages($scope.rpp, $scope.registers);
                            if ($scope.numpage > $scope.pages) {
                                $scope.numpage = $scope.pages;
                            }
                            return serverCallService.getPage($scope.ob, $scope.rpp, $scope.numpage, $scope.filterParams, $routeParams.order);
                        } else {
                            $scope.status = "Error en la recepción de datos del servidor";
                        }
                    }).then(function (response) {
                        if (response.status == 200) {
                            $scope.page = response.data.json.data;
                            $scope.metao = response.data.json.metaObject;
                            $scope.metap = response.data.json.metaProperties;
                        } else {
                            $scope.status = "Error en la recepción de datos del servidor";
                        }
                    }).catch(function (data) {
                        $scope.status = "Error en la recepción de datos del servidor";
                    });
                }
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
                $scope.showViewButton = function (oBean) {
                    return true;
                }
                $scope.showEditButton = function (oBean) {
                    return true;
                }
                $scope.showRemoveButton = function (oBean) {
                    if (oBean.link_grupo > 0 || oBean.link_paciente > 0) {
                        return false;
                    } else {
                        return true;
                    }
                }
                $scope.showOtherButton = function (oBean) {
                    return false;
                }
                $scope.goViewURL = function (oBean) {
                    $location.path($scope.ob + "/" + $scope.profile + "/view/" + oBean.id);
                }
                $scope.goEditURL = function (oBean) {
                    $location.path($scope.ob + "/" + $scope.profile + "/edit/" + oBean.id);
                }
                $scope.goRemoveURL = function (oBean) {
                    $location.path($scope.ob + "/" + $scope.profile + "/remove/" + oBean.id);
                }
//                $scope.includeExtraButtons = function () {
//                    return "js/app/paciente/3/plistExtraButtons.html"
//                }
                //--------------------------------------------------------------


                $scope.renderLinksHtml = function (html_code) {
                    return "";
                }




                getDataFromServer();
            }
        ]);


