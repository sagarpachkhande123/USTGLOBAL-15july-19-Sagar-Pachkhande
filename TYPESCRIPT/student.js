"use strict";
exports.__esModule = true;
var Student = /** @class */ (function () {
    function Student() {
        this.name = 'fns';
    }
    Student.prototype.printDetails = function () {
        console.log(this.name);
    };
    return Student;
}());
exports.Student = Student;
var XYZ = /** @class */ (function () {
    function XYZ() {
        this.name = "Sagar";
        console.log("my name is " + this.name);
    }
    return XYZ;
}());
exports.XYZ = XYZ;
