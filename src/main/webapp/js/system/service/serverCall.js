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


'use strict';
moduloServicios.factory('serverCallService',
        ['$http', 'constantService',
            function ($http, constantService) {
                return {
                    getCount: function (strObject, filter) {
                        if (filter) {
                            return $http.get(constantService.getAppUrl() + '?ob=' + strObject + '&op=getcount&filter=' + filter, 'GET', '');
                        } else {
                            return $http.get(constantService.getAppUrl() + '?ob=' + strObject + '&op=getcount', 'GET', '');
                        }
                    },
                    getPage: function (strObject, rpp, page, filter, order) {
                        if (filter) {
                            if (order) {
                                return $http.get(constantService.getAppUrl() + '?ob=' + strObject + '&op=getpage&np=' + page + "&rpp=" + rpp + "&filter=" + filter + "&order=" + order, 'GET', '');
                            } else {
                                return $http.get(constantService.getAppUrl() + '?ob=' + strObject + '&op=getpage&np=' + page + "&rpp=" + rpp + "&filter=" + filter, 'GET', '');
                            }
                        } else {
                            if (order) {
                                return $http.get(constantService.getAppUrl() + '?ob=' + strObject + '&op=getpage&np=' + page + "&rpp=" + rpp + "&order=" + order, 'GET', '');
                            } else {
                                return $http.get(constantService.getAppUrl() + '?ob=' + strObject + '&op=getpage&np=' + page + "&rpp=" + rpp, 'GET', '');
                            }
                        }
                    },
                    getOne: function (strClass, id) {
                        return $http.get(constantService.getAppUrl() + '?ob=' + strClass + '&op=get&id=' + id, 'GET', '');
                    },
                    getStatistics: function (strClass, id) {
                        return $http.get(constantService.getAppUrl() + '?ob=' + strClass + '&op=getStatistics&id=' + id, 'GET', '');
                    },
                    remove: function (strClass, id) {
                        return $http.get(constantService.getAppUrl() + '?ob=' + strClass + '&op=remove&id=' + id, 'GET', '');
                    },
                    set: function (strClass, jsonfile) {
                        $http.defaults.headers.put['Content-Type'] = 'application/json;charset=utf-8';
                        return $http.get(constantService.getAppUrl() + '?ob=' + strClass + '&op=set', {params: jsonfile});
                    },
                    getAll: function (strObject, filter, order) {
                        if (filter) {
                            if (order) {
                                return $http.get(constantService.getAppUrl() + '?ob=' + strObject + '&op=getpage&page=1&rpp=1000&filter=' + filter + "&order=" + order, 'GET', '');
                            } else {
                                return $http.get(constantService.getAppUrl() + '?ob=' + strObject + '&op=getpage&page=1&rpp=1000&filter=' + filter, 'GET', '');
                            }
                        } else {
                            if (order) {
                                return $http.get(constantService.getAppUrl() + '?ob=' + strObject + '&op=getpage&page=1&rpp=1000&order=' + order, 'GET', '');
                            } else {
                                return $http.get(constantService.getAppUrl() + '?ob=' + strObject + '&op=getpage&page=1&rpp=1000', 'GET', '');
                            }
                        }
                    },
                    getPageX: function (strObject, strObjectForeign, idForeign, rpp, page, filter, order) {
                        var base = constantService.getAppUrl() + '?ob=' + strObject + '&ob_foreign=' + strObjectForeign + '&id_foreign=' + idForeign + '&op=getpagex';
                        if (filter) {
                            if (order) {
                                return $http.get(base + '&np=' + page + "&rpp=" + rpp + "&filter=" + filter + "&order=" + order, 'GET', '');
                            } else {
                                return $http.get(base + '&np=' + page + "&rpp=" + rpp + "&filter=" + filter, 'GET', '');
                            }
                        } else {
                            if (order) {
                                return $http.get(base + '&np=' + page + "&rpp=" + rpp + "&order=" + order, 'GET', '');
                            } else {
                                return $http.get(base + '&np=' + page + "&rpp=" + rpp, 'GET', '');
                            }
                        }
                    },
                    getCountX: function (strObject, strObjectForeign, idForeign, filter) {
                        var base = constantService.getAppUrl() + '?ob=' + strObject + '&ob_foreign=' + strObjectForeign + '&id_foreign=' + idForeign + '&op=getcountx';
                        if (filter) {
                            return $http.get(base + '&filter=' + filter, 'GET', '');
                        } else {
                            return $http.get(base, 'GET', '');
                        }
                    },
                    getAllObjectsMetaData: function () {
                        return $http.get(constantService.getAppUrl() + '?ob=usuario&op=getallobjectsmetadata', 'GET', '');
                    },
                    getMeta: function (strClass) {
                        return $http.get(constantService.getAppUrl() + '?ob=' + strClass + '&op=getmetadata', 'GET', '');
                    },
                    getSession: function (strClass) {
                        return $http.get(constantService.getAppUrl() + '?ob=' + strClass + '&op=getsessionstatus', 'GET', '');
                    },
                    activate: function (id) {
                        return $http.get(constantService.getAppUrl() + '?ob=usuario&op=activate&id=' + id, 'GET', '');
                    },
                    deactivate: function (id) {
                        return $http.get(constantService.getAppUrl() + '?ob=usuario&op=deactivate&id=' + id, 'GET', '');
                    },
                    create: function (strClass, id) {
                        return $http.get(constantService.getAppUrl() + '?ob=' + strClass + '&op=create', 'GET', '');
                    },
                    resetPass: function (id) {
                        return $http.get(constantService.getAppUrl() + '?ob=usuario&op=resetpass&id=' + id, 'GET', '');
                    }
                }
            }
        ]);