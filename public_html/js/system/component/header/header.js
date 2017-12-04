moduloDirectivas.component('header', {
    templateUrl: "js/system/component/header/header.html",
    controllerAs: 'hd',
    controller: menuCtrl,
    bindings:
            {
                ob: '<',
                op: '<',
                xob: '<',
                xid: '<'
            }
});
function menuCtrl(serverCallService) {
    var self = this;
    this.$onInit = function () {

        serverCallService.getAllObjectsMetaData().then(function (response) {
            if (response.status == 200) {
                if (response.data.status == 200) {
                    self.status = null;
                    self.meta = response.data.json;
                } else {
                    self.status = "Error en la recepción de datos del servidor";
                }
            } else {
                self.status = "Error en la recepción de datos del servidor";
            }
        }).catch(function (data) {
            self.status = "Error en la recepción de datos del servidor";
        });

        if (self.xob) {
            serverCallService.getOne(self.xob, self.xid).then(function (response) {
                if (response.status == 200) {
                    if (response.data.status == 200) {

                        self.linkedbean = response.data.json;
                    } else {
                        self.linkedbean = null;
                    }
                } else {
                    self.linkedbean = null;
                }
            }).catch(function (data) {
                self.linkedbean = null;
            });
        }
    }

}
