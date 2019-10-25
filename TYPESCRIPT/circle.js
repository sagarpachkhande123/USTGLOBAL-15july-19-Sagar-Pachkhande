// The namespace is used to logical grouping of functionalities
// A namespace can include interface, classes, function and varible to support a single or a group of related functionlities
// A namespace can be created using the namespace keyword followed by the namespace name
// all interfaces, classes etc can be defined in the curly bracess
// syntax{
//  namespace sagar{
//  }
// }
var MathOperation;
(function (MathOperation) {
    var pi = 3.14;
    function CircumferenceOfCircle(radius) {
        console.log("The circumference of circle is " + 2 * pi * radius);
    }
    MathOperation.CircumferenceOfCircle = CircumferenceOfCircle;
    function AreaOfCircle(radius) {
        console.log('The Area of Circle is ' + pi * radius * radius);
    }
    MathOperation.AreaOfCircle = AreaOfCircle;
    var rectangle;
    (function (rectangle) {
        function area(length, breadth) {
            console.log("Area of rectangle is " + length * breadth);
        }
        rectangle.area = area;
    })(rectangle = MathOperation.rectangle || (MathOperation.rectangle = {}));
})(MathOperation || (MathOperation = {}));
MathOperation.CircumferenceOfCircle(7);
