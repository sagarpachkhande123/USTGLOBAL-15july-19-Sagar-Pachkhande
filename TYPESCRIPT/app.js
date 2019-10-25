var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
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
///<reference path="./circle.ts"/>
var myName = 'Sagar';
//  myName=45  this is not posiible so it TS is called strong typing or static typing
var mySurname = 'Pachkhande'; //can declare like this also
var age; //it is implicitly any type i.e age:any
age = 'gh';
age = 22;
console.log(myName);
console.log(mySurname);
console.log(age);
// --------------------------------------------------
var sample;
sample = 'rakshanda';
sample = true;
console.log("sample: ", sample);
//----------------------------------------Array-----------------
var a = [132, true, 'sagar', 'g'];
// let a:any[]=[132,true,'sagar','g'] a array internally works as like this
console.log("array a is::", a);
var b = ['sagar', 'pachkhande'];
console.log("array b is::", b);
//----------------------------------------Tuples-----------------
var c = ['sagar', 78, true]; //whatever datatype mentioned in the tuple need to be assigned and value in same order and all type of value must be mentioned
console.log(c);
//----------------------------------------Enum-----------------
var Color;
(function (Color) {
    Color[Color["red"] = 0] = "red";
    Color[Color["green"] = 1] = "green";
    Color[Color["blue"] = 2] = "blue";
    Color[Color["black"] = 3] = "black";
})(Color || (Color = {}));
console.log("green color is at the position::\n", Color.green);
var Color1;
(function (Color1) {
    Color1[Color1["a"] = 200] = "a";
    Color1[Color1["b"] = 201] = "b";
    Color1[Color1["c"] = 202] = "c";
    Color1[Color1["d"] = 203] = "d";
})(Color1 || (Color1 = {}));
// console.log("after assingning value for a=200 the value of c is\n",Color1.c);
// enum day{
//     1='sunday',2='monday',3='tuesday',4='wednesday'
// }
// console.log(day["2"]);
// ------------------------------------------class---------------------
var Person = /** @class */ (function () {
    function Person(nm, ag) {
        this.name = nm;
        this.age = ag;
    }
    return Person;
}());
var person = new Person('sagar', 22);
console.log("Person name is::", person.name);
// Another Method of declaring constructor
var Person2 = /** @class */ (function () {
    function Person2(personName, personAge) {
        this.personName = personName;
        this.personAge = personAge;
    }
    return Person2;
}());
var person2 = new Person2('sagar', 22);
console.log("mine age is ", person2.personAge);
var Static_NonStatic = /** @class */ (function () {
    function Static_NonStatic() {
        this.name = 'BMW'; // Non static member acccess by creating object
    }
    Static_NonStatic.model = 'x5'; //static member acccess by class name
    return Static_NonStatic;
}());
var bmwCar = new Static_NonStatic();
console.log("----Nonsatic and Static class---");
console.log("non static members access::" + bmwCar.name);
console.log("Static member " + Static_NonStatic.model);
console.log("");
var Parameter_Constructor = /** @class */ (function () {
    function Parameter_Constructor(brand, model) {
        this.brand = brand;
        this.model = model;
        this.name = 'BMW'; // Non static member acccess by creating object
    }
    Parameter_Constructor.model = 'x5'; //static member acccess by class name
    return Parameter_Constructor;
}());
var Car = new Parameter_Constructor('Lamborgini', 'KS5');
console.log(Car.brand);
console.log(Car.model);
console.log("");
//---------------------Inheritance-------------------
var ParentClass = /** @class */ (function () {
    function ParentClass(name, age) {
        this.name = name;
        this.age = age;
        this.salary = 12345;
    }
    return ParentClass;
}());
//childClass will invokes all the properties from parent class
var ChildClass = /** @class */ (function (_super) {
    __extends(ChildClass, _super);
    function ChildClass(nm, age, USN) {
        var _this = _super.call(this, nm, age) || this;
        _this.nm = nm;
        _this.age = age;
        _this.USN = USN;
        return _this;
    }
    return ChildClass;
}(ParentClass));
// let parentobject=new ParentClass('sagar',22);
var childobject = new ChildClass('dinga', 34, 1234354543);
console.log(childobject.salary);
var Pappa = /** @class */ (function () {
    function Pappa(name, age) {
        this.name = name;
        this.age = age;
    }
    return Pappa;
}());
var p1 = {
    name: 'sagar'
};
var p2 = {
    name: 'abc',
    age: 289
};
var Per = /** @class */ (function () {
    function Per() {
        this.name = 'ABC';
        this.age = 90;
    }
    Per.prototype.printDetailes = function () {
        console.log("Name is " + this.name);
    };
    return Per;
}());
var per1 = new Per();
per1.printDetailes();
//object of interface
// but we have to initialise the memebrs and provide the defination of the interface in the object creation of an interface 
var ss1 = {
    name: 'xyz',
    age: 34,
    printDetailes: function () {
        console.log("Interface object creation:: Name is " + ss1.name);
    }
};
ss1.printDetailes();
;
// Generics:: It offers a way to creat reusable com[onentes]. generic provides a way to make
function getArray(items) {
    return new Array().concat(items);
}
console.log(getArray(['10,5,45', 'hdhs']));
///this generic will take a 'p' as a datatype of array that will treated as the single datatype 
// i.e if we provide the array with string then it will treated as a string array and in case of number array 'p' will treated as numeric array
function getArray1(items1) {
    return new Array().concat(items1);
}
var strArray = getArray1(['sagar', 'pachkhande']);
var numArray = getArray1([56, 7, 8]);
numArray.push(78);
console.log(strArray);
console.log(numArray);
// namespace MathOperation{
//     const pi=3.14;
//     export function CircumferenceOfCircle(radius: number){
//         console.log("The circumference of circle is "+2*pi*radius)
//     }
//     export function AreaOfCircle(radius:number){
//         console.log('The Area of Circle is '+pi*radius*radius)
//     }
//     export namespace rectangle{                                //nested namespace
//         export function area(length:number,breadth:number){
//             console.log("Area of rectangle is "+length*breadth);
//         }
//     }
// }
// MathOperation.CircumferenceOfCircle(7);
MathOperation.rectangle.area(7, 8); //calling the method of area nested namespace rectangle
