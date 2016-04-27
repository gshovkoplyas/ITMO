var obj = {
    "x": 10,
    "y": 20
}
obj["x"] = 100;
obj["y"] = 20;
obj["hello, world"] = 30;
obj["undefined"] = 40;

         
println(obj["x"]);
println(obj.x)
println(obj["y"]);
println(obj["hello, world"]);
println(obj[undefined]);


println("======color point=======");

var point = {
  x: 10,
  y: 20
}
var colorPoint = Object.create(point);
colorPoint.color = "red";

println(colorPoint.color);
println(colorPoint.x);
println(colorPoint.y);

point.x = 100;
println(colorPoint.x);
println(point.x);

Object.prototype.hello = "world";
println(colorPoint.hello);
println("jfjfjfj".hello);

println("=======shifted point=======");
var shiftedPoint = Object.create(point);
shiftedPoint.dx = 2;
shiftedPoint.dy = 3;
shiftedPoint.getX = function() { return this.x + this.dx; }
shiftedPoint.getY = function() { return this.y + this.dy; }

var sp = shiftedPoint;
shiftedPoint = {};

for (var name in sp) {
    if (typeof(sp[name]) == "function") {
        println("   " + name + "() = " + sp[name]());
    } else {
        println("   " + name + " = " + sp[name]);
    }
}

println("=======spspspspssp=========");
var spp = {x: -1, y: -2, dx: -3, dy: -4};
println(sp.getX.apply(spp));





























































