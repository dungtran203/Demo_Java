var app = angular.module("web207", []);
app.controller("web207-ctrl", function($scope, $http){
    var pageSize = 6;

    // Lấy danh sách sản phẩm
    // API: http://localhost:8080/products?skip=0&limit=10
    var getProduct= function(){
        $http.get("https://63ec6abb31ef61473b21f2a7.mockapi.io/dungttmph25136/dat-ve-xem-phim?page=1&limit="+pageSize)
            .then(function(response){
            $scope.products = response.data;
        });
    }
    getProduct();

    // Hiển thị tổng số sản phẩm
    // API: http://localhost:8080/products/count
    $http.get("https://63ec6abb31ef61473b21f2a7.mockapi.io/dungttmph25136/dat-ve-xem-phim/count").then(function(response){
        $scope.totalProduct = response.data;
    });

    // Hiển thị tổng số trang
    // totalPage = totalProduct / pageSize
    $scope.totalPage  = function(){
        return $scope.totalProduct / pageSize;
    }

    //Hiển thị số trang
    $scope.pageRange = function(){
        var range = [];
        var totalPage = $scope.totalPage();
        for(var i = 1;i <= 6 ;i++){
            range.push(i);
        }
        return range;
    }

    
    // Lấy dữ liệu lên chi tiết sản phẩm 
    $scope.getProduct = function(id) {
        $http.get("https://63ec6abb31ef61473b21f2a7.mockapi.io/dungttmph25136/dat-ve-xem-phim/" + id)
        .then(function (response) {
            $scope.selectedProduct = response.data;
            $scope.id = response.data.id;
            $scope.thongTinCoBan = response.data.thongTinCoBan;
            $scope.tenPhim = response.data.tenPhim;
            $scope.theLoai = response.data.theLoai;
            $scope.xepHang = response.data.xepHang;
            $scope.ngayPhatHanh = response.data.ngayPhatHanh;
            $scope.thoiLuong = response.data.thoiLuong;
            $scope.tomTatPhim = response.data.tomTatPhim;
            $scope.img = response.data.img;
        });
    }

    // Phân trang sản phẩm 
    $scope.getSP = function(so){
        var index = pageSize * (so - 1);
        $http.get("https://63ec6abb31ef61473b21f2a7.mockapi.io/dungttmph25136/dat-ve-xem-phim?page="+so+"&limit=" + pageSize).then(function(response){
            $scope.products = response.data;
        });
    }

    const url = "https://63ec6abb31ef61473b21f2a7.mockapi.io/dungttmph25136/dat-ve-xem-phim";
    //read
    //http.get().then(function(){}, function {})
    $scope.getPoductById = function(id) {
        $http.get( url + "/" + id )
            .then(function(response){
                var product = response.data;
                $scope.name = product.name;
                $scope.price = product.price;
                $scope.quantity = product.quantity;
                $scope.img = product.img;
            }, function(error){
                alert("NOT FOUND");
            });
    }

    //delete
    $scope.deleteProductById = function(id) {
        $http.delete( url + "/" + id )
        .then(function(response) {
            alert("Delete Success");
            getProduct();
        });
    }

    //Tao doi tuong tu cac thong tin duoc nhap
    var buildProduct = function() {
        return {
            // "id":  $scope.id,
            "tenPhim" : $scope.tenPhim,
            "thongTinCoBan" : $scope.thongTinCoBan,
            "theLoai": $scope.theLoai,
            "img":  $scope.img,
            "xepHang":  $scope.xepHang,
            "ngayPhatHanh":  $scope.ngayPhatHanh,
            "thoiLuong":  $scope.thoiLuong,
            "tomTatPhim":  $scope.tomTatPhim
        }
    }

    //create
    $scope.createProduct = function() {
        var product = buildProduct();
        $http.post(url, product)
        .then(function(response) {
            alert("Create Success");
        }, function(error) {
            alert("Create Fail");
            alert(error.data)
        });
    }

    //update
    $scope.updateProductById = function() {
        var product = buildProduct();
        $http.put( url + "/" + $scope.id, product)
        .then(function(response) {
            alert("Update Success");
            getProduct();
        }, function(error) {
            alert("Update Fail \n" + error.data);
        });
    }

//timkiem
    $scope.tim = function(tenPhim) {
        $http.get( "https://63ec6abb31ef61473b21f2a7.mockapi.io/dungttmph25136/dat-ve-xem-phim?tenPhim=" + tenPhim)
            .then(function(response) {
                $scope.products = response.data;
            });
            
    }
});