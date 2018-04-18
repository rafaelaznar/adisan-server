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

//para crear un nuevo subepisodio a partir del clip del listado de episodios de un paciente

moduloEpisodio.controller('SubepisodioxpacientexepisodioNew3Controller',
        ['$scope', '$routeParams', '$location', 'serverCallService', '$filter', '$uibModal', 'sessionService', '$route', 'toolService', 'constantService',
            function ($scope, $routeParams, $location, serverCallService, $filter, $uibModal, sessionService, $route, toolService, constantService) {
                $scope.ob = "episodio";
                $scope.op = "newx";
                $scope.profile = 3;
                //---
                $scope.xob = "paciente";
                $scope.xid = $routeParams.idpaciente;
                //---
                $scope.yob = "episodio";
                $scope.yid = $routeParams.idepisodiopadre;
                //---
                $scope.status = null;
                $scope.debugging = constantService.debugging();
                //---
                if ($scope.xob && $scope.xid) {
                    $scope.linkedbean = null;
                    serverCallService.getOne($scope.xob, $scope.xid).then(function (response) {
                        if (response.status == 200) {
                            if (response.data.status == 200) {
                                $scope.linkedbean = response.data.json;
                            }
                        }
                    }).catch(function (data) {
                    });
                }
                if ($scope.yob && $scope.yid) {
                    $scope.linkedbean2 = null;
                    serverCallService.getOne($scope.yob, $scope.yid).then(function (response) {
                        if (response.status == 200) {
                            if (response.data.status == 200) {
                                $scope.linkedbean2 = response.data.json;
                            }
                        }
                    }).catch(function (data) {
                    });
                }
                serverCallService.getMeta($scope.ob).then(function (response) {
                    if (response.status == 200) {
                        if (response.data.status == 200) {
                            $scope.status = null;
                            //--For every foreign key create obj inside bean tobe filled...
                            $scope.bean = {};
                            response.data.json.metaProperties.forEach(function (property) {
                                if (property.Type == 'ForeignObject') {
                                    $scope.bean[property.Name] = {};
                                    $scope.bean[property.Name].data = {};
                                    var propertyset = false;
                                    if (property.Name == 'obj_' + $scope.xob) {
                                        $scope.bean[property.Name].data.id = $scope.xid;
                                        propertyset = true;
                                    }
                                    if (property.Name == 'obj_' + $scope.yob) {
                                        $scope.bean[property.Name].data.id = $scope.yid;
                                        propertyset = true;
                                    }
                                    if (!propertyset) {
                                        $scope.bean[property.Name].data.id = null;
                                    }
                                }
                            });
                            //--
                            $scope.metao = response.data.json.metaObject;
                            $scope.metap = response.data.json.metaProperties;
                            //$scope.metap = toolService.deleteForeignKey($scope.metap, "obj_episodio");
                            //$scope.metap = toolService.deleteForeignKey($scope.metap, "obj_factura");
                            //$scope.metap = toolService.deleteForeignKey($scope.metap, "obj_circunstanciasalta");
                            //$scope.metap = toolService.deleteForeignKey($scope.metap, "obj_destinoalta");
                            //$scope.metap = toolService.deleteForeignKey($scope.metap, "obj_usuario");
                            /////////
                            //$scope.bean = toolService.deleteForeignKeyObject($scope.bean, "obj_episodio");
                            //$scope.bean = toolService.deleteForeignKeyObject($scope.bean, "obj_factura");
                            //$scope.bean = toolService.deleteForeignKeyObject($scope.bean, "obj_circunstanciasalta");
                            //$scope.bean = toolService.deleteForeignKeyObject($scope.bean, "obj_destinoalta");
                            //$scope.bean = toolService.deleteForeignKeyObject($scope.bean, "obj_usuario");
                        } else {
                            $scope.status = "Error en la recepción de datos del servidor";
                        }
                    } else {
                        $scope.status = "Error en la recepción de datos del servidor";
                    }
                }).catch(function (data) {
                    $scope.status = "Error en la recepción de datos del servidor";
                });
                //--
                $scope.save = function () {
                    var jsonToSend = {json: JSON.stringify(toolService.array_identificarArray($scope.bean))};
                    serverCallService.set($scope.ob, jsonToSend).then(function (response) {
                        if (response.status == 200) {
                            if (response.data.status == 200) {
                                $scope.response = response;
                                $scope.status = "El registro se ha creado con id=" + response.data.json;
                                $scope.bean.id = response.data.json;
                            } else {
                                $scope.status = "Error en la recepción de datos del servidor";
                            }
                        } else {
                            $scope.status = "Error en la recepción de datos del servidor";
                        }
                    }).catch(function (data) {
                        $scope.status = "Error en la recepción de datos del servidor";
                    });
                    ;
                };
                $scope.back = function () {
                    window.history.back();
                };
                $scope.close = function () {
                    $location.path('/home');
                };
            }
        ]);

