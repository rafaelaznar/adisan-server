'use strict';
moduloFactura.controller('FacturaPList1Controller',
        ['$scope', '$routeParams', '$location', 'serverCallService', 'toolService', 'constantService',
            function ($scope, $routeParams, $location, serverCallService, toolService, constantService) {
                $scope.ob = "factura";
                $scope.op = "plist";
                $scope.profile = 1;
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
                function getDataFromServer() {
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
                $scope.setShowRemove = function (show) {
                    $scope.showRemove = show;
                };
                getDataFromServer();
            }
        ]);


