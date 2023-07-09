function changeImage(element) {
    var main_prodcut_image = document.getElementById('main_product_image');
    main_prodcut_image.src = element.src;
}

var app = angular.module("web207", []);
    app.controller("web207-ctrl", function($scope, $http){
        var getProduct= function(){
            $http.get("https://63ec6abb31ef61473b21f2a7.mockapi.io/dungttmph25136/dat-ve-xem-phim/" + $scope.id)
                .then(function(response){
                $scope.products = response.data;
            });
        }
        getProduct();


});