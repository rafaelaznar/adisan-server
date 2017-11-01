moduloDirectivas.component('genericactions', {
    templateUrl: "js/system/components/genericactions/genericactions.html",
    controllerAs: 'act',
    controller: actions,
    bindings:
            {
                id: '<',
                name: '<'
            }
});

function actions(constantService)
{
    var self = this;
    self.appurl = constantService.getCAppUrl();
}